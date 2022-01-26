package com.sgv.exchange.entity;

import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
public class TradeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double coinAmount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private CoinType coinType;
    @Enumerated(EnumType.STRING)
    private CurrencyType fiatCurrency;
    private Double fiatAmount;
}
