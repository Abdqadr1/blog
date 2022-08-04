package com.qadr.lannisterpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class SplitResponse {
    @JsonProperty("ID")
    private Long ID;

    @JsonProperty("Balance")
    private BigDecimal Balance;

    @JsonProperty("SplitBreakdown")
    private List<SplitBreakdown> SplitBreakdown = new ArrayList<>();
}
