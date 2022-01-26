package com.sgv.exchange.client;

import com.sgv.exchange.dto.TickerDTO;
import com.sgv.exchange.util.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange", url = Constants.BASE_BLOCKCHAIN_API_URL)
public interface ExchangeFeignClient {

    @GetMapping("/tickers/{symbol}")
    TickerDTO getTickerBySymbol(@PathVariable String symbol);
}