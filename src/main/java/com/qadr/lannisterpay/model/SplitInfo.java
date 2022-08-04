package com.qadr.lannisterpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SplitInfo {
    @JsonProperty("SplitEntityId")
    private String SplitEntityId;

    @JsonProperty("SplitValue")
    private BigDecimal SplitValue;

    @JsonProperty("SplitType")
    private SplitType SplitType;
}
