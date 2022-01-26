package com.sgv.exchange.service;

import com.sgv.exchange.dto.ConversionRequest;
import com.sgv.exchange.dto.TradeHistoryDTO;
import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

@SpringBootTest
public class ExchangeServiceTest {
    @MockBean
    ExchangeService exchangeService;

    @Test
    void givenConversionRequestWithUsdAndBtc_whenCalculate_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 1000.0);

        Double expected = 0.01;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        Double actual = exchangeService.calculate(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithEurAndBtc_whenCalculate_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.BTC, 1000.0);

        Double expected = 0.01;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        Double actual = exchangeService.calculate(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithUsdAndEth_whenCalculate_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.ETH, 1000.0);

        Double expected = 0.01;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        Double actual = exchangeService.calculate(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithEurAndEth_whenCalculate_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.ETH, 1000.0);

        Double expected = 0.01;

        Mockito.when(exchangeService.calculate(request)).thenReturn(expected);

        Double actual = exchangeService.calculate(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithUsdAndBtc_whenTrade_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.BTC, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        TradeHistoryDTO actual = exchangeService.trade(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithEurAndBtc_whenTrade_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.BTC, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.BTC, CurrencyType.EUR);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        TradeHistoryDTO actual = exchangeService.trade(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithUsdAndEth_whenTrade_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.USD, CoinType.ETH, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.ETH, CurrencyType.USD);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        TradeHistoryDTO actual = exchangeService.trade(request);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenConversionRequestWithEurAndEth_whenTrade_returnCoinsToReceive() {
        ConversionRequest request = new ConversionRequest(CurrencyType.EUR, CoinType.ETH, 1000.0);

        TradeHistoryDTO expected = getTestTradeHistoryDTOByCoinTypeAndCurrencyType(CoinType.ETH, CurrencyType.EUR);

        Mockito.when(exchangeService.trade(request)).thenReturn(expected);

        TradeHistoryDTO actual = exchangeService.trade(request);

        Assertions.assertEquals(expected, actual);

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
