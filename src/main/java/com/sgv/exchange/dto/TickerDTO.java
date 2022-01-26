package com.sgv.exchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TickerDTO {
    private String symbol;
    @JsonProperty("price_24h")
    private Double price24h;
    @JsonProperty("volume_24h")
    private Double volume24h;
    @JsonProperty("last_trade_price")
    private Double lastTradePrice;
}
