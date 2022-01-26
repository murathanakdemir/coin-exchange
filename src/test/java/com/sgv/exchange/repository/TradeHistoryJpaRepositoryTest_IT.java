package com.sgv.exchange.repository;

import com.sgv.exchange.entity.TradeHistory;
import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

@DataJpaTest
public class TradeHistoryJpaRepositoryTest_IT {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TradeHistoryJpaRepository tradeHistoryJpaRepository;

    @Test
    public void givenTradeHistory_whenSaveTradeHistory_thenReturnSavedTradeHistory() {

        TradeHistory tradeHistory = TradeHistory.builder()
                .coinAmount(0.01)
                .coinType(CoinType.BTC)
                .fiatAmount(1000.0)
                .fiatCurrency(CurrencyType.USD)
                .date(new Date())
                .build();


        TradeHistory expected = entityManager.persist(tradeHistory);
        entityManager.flush();

        TradeHistory actual = tradeHistoryJpaRepository.getById(expected.getId());

        Assertions.assertEquals(expected.getCoinAmount(), actual.getCoinAmount());
    }
}


