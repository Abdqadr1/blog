package com.qadr.lannisterpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SplitBreakdown {
    @JsonProperty("SplitEntityId")
    private String SplitEntityId;

    @JsonProperty("Amount")
    private Double Amount;
}
