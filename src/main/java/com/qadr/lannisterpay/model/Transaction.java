package com.qadr.lannisterpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Transaction {
    @JsonProperty("ID")
    private Long ID;

    @JsonProperty("Amount")
    private BigDecimal Amount;

    @JsonProperty("Currency")
    private String Currency;

    @JsonProperty("CustomerEmail")
    private String CustomerEmail;

    @JsonProperty("SplitInfo")
    private List<SplitInfo> SplitInfo = new ArrayList<>();
}
