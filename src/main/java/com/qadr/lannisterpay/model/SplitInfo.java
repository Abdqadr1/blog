package com.qadr.lannisterpay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SplitInfo {
    private String splitEntityId;
    private BigDecimal splitValue;
    private SplitType splitType;
}
