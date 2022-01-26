package com.sgv.exchange.dto;

import com.sgv.exchange.util.enums.CoinType;
import com.sgv.exchange.util.enums.CurrencyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@ApiModel
public class ConversionRequest {
    @ApiModelProperty(allowableValues = "USD,EUR", required = true)
    private CurrencyType currencyType;

    @ApiModelProperty(allowableValues = "BTC,ETH", required = true)
    private CoinType coinType;

    @ApiModelProperty(notes = "Min: 25, Max: 5000", required = true)
    @Min(value = 25, message = "Amount must be greater than 25")
    @Max(value = 5000, message = "Amount must be less than 5000")
    private Double amountsToSpend;
}
