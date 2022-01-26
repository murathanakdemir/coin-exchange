package com.sgv.exchange.repository;

import com.sgv.exchange.entity.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryJpaRepository extends JpaRepository<TradeHistory, Long> {
}
