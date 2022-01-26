package com.sgv.exchange.service;

import com.sgv.exchange.client.ExchangeFeignClient;
import com.sgv.exchange.dto.TradeHistoryDTO;
import com.sgv.exchange.dto.TickerDTO;
import com.sgv.exchange.dto.ConversionRequest;
import com.sgv.exchange.entity.TradeHistory;
import com.sgv.exchange.repository.TradeHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final ExchangeFeignClient exchangeFeignClient;
    private final TradeHistoryJpaRepository tradeHistoryJpaRepository;

    public Double calculate(ConversionRequest request) {
        String symbol = request.getCoinType() + "-" + request.getCurrencyType();
        TickerDTO tickerDTO = exchangeFeignClient.getTickerBySymbol(symbol);
        Double coinsToReceive = request.getAmountsToSpend() / tickerDTO.getLastTradePrice();

        return coinsToReceive;
    }

    public TradeHistoryDTO trade(ConversionRequest request) {
        Double coinAmount = calculate(request);

        TradeHistory tradeHistory = TradeHistory.builder()
                .coinAmount(coinAmount)
                .date(new Date())
                .coinType(request.getCoinType())
                .fiatCurrency(request.getCurrencyType())
                .fiatAmount(request.getAmountsToSpend())
                .build();

        tradeHistoryJpaRepository.save(tradeHistory);

        return TradeHistoryDTO.fromEntity(tradeHistory);
    }
}
