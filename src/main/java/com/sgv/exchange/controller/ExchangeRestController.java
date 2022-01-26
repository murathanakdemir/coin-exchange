package com.sgv.exchange.controller;

import com.sgv.exchange.dto.ConversionRequest;
import com.sgv.exchange.dto.TradeHistoryDTO;
import com.sgv.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeRestController {
    private final ExchangeService exchangeService;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody @Valid ConversionRequest request) {
        Double coinsToReceive = exchangeService.calculate(request);

        return ResponseEntity.ok(coinsToReceive);
    }

    @PostMapping("/trade")
    public ResponseEntity<TradeHistoryDTO> trade(@RequestBody @Valid ConversionRequest request) {
        TradeHistoryDTO tradeHistoryDTO = exchangeService.trade(request);

        return ResponseEntity.ok(tradeHistoryDTO);
    }
}
