package com.sgv.exchange.dto;

import com.sgv.exchange.entity.TradeHistory;
import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class TradeHistoryDTO {
    private Double coinAmount;
    private Date date;
    private CoinType coinType;
    private CurrencyType fiatCurrency;
    private Double fiatAmount;

    public static TradeHistoryDTO fromEntity(TradeHistory tradeHistory) {
        TradeHistoryDTO tradeHistoryDTO = new TradeHistoryDTO();
        tradeHistoryDTO.setCoinAmount(tradeHistory.getCoinAmount());
        tradeHistoryDTO.setDate(tradeHistory.getDate());
        tradeHistoryDTO.setCoinType(tradeHistory.getCoinType());
        tradeHistoryDTO.setFiatCurrency(tradeHistory.getFiatCurrency());
        tradeHistoryDTO.setFiatAmount(tradeHistory.getFiatAmount());

        return tradeHistoryDTO;
    }
}
