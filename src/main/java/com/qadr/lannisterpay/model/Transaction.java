package com.qadr.lannisterpay.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Transaction {
    private Long id;
    private BigDecimal amount;
    private String currency;
    private String customerEmail;
    private List<SplitInfo> splitInfo = new ArrayList<>();
}
