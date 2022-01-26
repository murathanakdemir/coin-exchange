package com.sgv.exchange.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgv.exchange.dto.ConversionRequest;
import com.sgv.exchange.dto.TradeHistoryDTO;
import com.sgv.exchange.service.ExchangeService;
import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeRestControllerTest_IT {
    private final String CALCULATE_ENDPOINT = "/exchange/calculate";
    private final String TRADE_ENDPOINT = "/exchange/trade";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExchangeService exchangeService;

    @Test
    void givenConversionRequestWithUsdAndBtc_whenCalculate_returnCoinsToReceive_statusIsOK() throws Exception {
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 1000.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(content().string(expected.toString()));

    }

    @Test
    void givenConversionRequestWithEurAndBtc_whenCalculate_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.BTC, 1000.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(content().string(expected.toString()));
    }

    @Test
    void givenConversionRequestWithUsdAndEth_whenCalculate_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.ETH, 1000.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(content().string(expected.toString()));
    }

    @Test
    void givenConversionRequestWithEurAndEth_whenCalculate_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.ETH, 1000.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(content().string(expected.toString()));
    }

    @Test
    void givenConversionRequestWithInvalidMinAmount_whenCalculate_returnCoinsToReceive_statusIsBadRequest() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 10.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenConversionRequestWithInvalidMaxAmount_whenCalculate_returnCoinsToReceive_statusIsBadRequest() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 10000.0);

        Double expected = 1.5;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        performPostRequest(request, CALCULATE_ENDPOINT)
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenConversionRequestWithUsdAndBtc_whenTrade_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coinAmount").value(0.1))
                .andExpect(jsonPath("$.coinType").value(CoinType.BTC.toString()))
                .andExpect(jsonPath("$.fiatCurrency").value(CurrencyType.USD.toString()))
                .andExpect(jsonPath("$.fiatAmount").value(1000.0));;

    }

    @Test
    void givenConversionRequestWithEurAndBtc_whenTrade_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.BTC, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.EUR);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coinAmount").value(0.1))
                .andExpect(jsonPath("$.coinType").value(CoinType.BTC.toString()))
                .andExpect(jsonPath("$.fiatCurrency").value(CurrencyType.EUR.toString()))
                .andExpect(jsonPath("$.fiatAmount").value(1000.0));

    }

    @Test
    void givenConversionRequestWithUsdAndEth_whenTrade_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.ETH, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.ETH, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coinAmount").value(0.1))
                .andExpect(jsonPath("$.coinType").value(CoinType.ETH.toString()))
                .andExpect(jsonPath("$.fiatCurrency").value(CurrencyType.USD.toString()))
                .andExpect(jsonPath("$.fiatAmount").value(1000.0));

    }

    @Test
    void givenConversionRequestWithEurAndEth_whenTrade_returnCoinsToReceive_statusIsOK() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.ETH, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.ETH, CurrencyType.EUR);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coinAmount").value(0.1))
                .andExpect(jsonPath("$.coinType").value(CoinType.ETH.toString()))
                .andExpect(jsonPath("$.fiatCurrency").value(CurrencyType.EUR.toString()))
                .andExpect(jsonPath("$.fiatAmount").value(1000.0));

    }

    @Test
    void givenConversionRequestWithInvalidMinAmount_whenTrade_returnCoinsToReceive_statusIsBadRequest() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 10.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenConversionRequestWithInvalidMaxAmount_whenTrade_returnCoinsToReceive_statusIsBadRequest() throws Exception{
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 10000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        performPostRequest(request, TRADE_ENDPOINT)
                .andExpect(status().isBadRequest());
    }

    private ResultActions performPostRequest(Object body, String endpoint) throws Exception{
        return mockMvc.perform(post(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(body)));
    }

    private String asJsonString(final Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }

    TradeHistoryDTO getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType coinType, CurrencyType currencyType) {
        TradeHistoryDTO tradeHistoryDTO = new TradeHistoryDTO();
        tradeHistoryDTO.setCoinAmount(0.1);
        tradeHistoryDTO.setDate(new Date());
        tradeHistoryDTO.setCoinType(coinType);
        tradeHistoryDTO.setFiatCurrency(currencyType);
        tradeHistoryDTO.setFiatAmount(1000.0);

        return tradeHistoryDTO;
    }
}
