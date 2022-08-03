package com.qadr.lannisterpay.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class SplitResponse {
    private Long id;
    private BigDecimal balance;
    private List<SplitBreakdown> splitBreakdown = new ArrayList<>();
}
