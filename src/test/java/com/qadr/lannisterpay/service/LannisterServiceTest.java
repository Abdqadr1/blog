package com.qadr.lannisterpay.service;

import com.qadr.lannisterpay.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LannisterServiceTest {
    @Autowired
    private LannisterService service;

    private Transaction transaction = new Transaction();

    @BeforeEach
    void runBeforeEachTest(){
        transaction.setAmount(BigDecimal.valueOf(25252.93));
        transaction.setId(7933L);
        List<SplitInfo> infos = List.of(
                new SplitInfo(
                        "LNPYACT0011",
                        BigDecimal.valueOf(46),
                        SplitType.FLAT
                ),
                new SplitInfo(
                        "LNPYACC0014",
                        BigDecimal.valueOf(4),
                        SplitType.PERCENTAGE
                ),
                new SplitInfo(
                        "LNPYACC003",
                        BigDecimal.valueOf(2),
                        SplitType.RATIO
                )
        );
        transaction.setSplitInfo(infos);
    }

    @Test
    void testComputeTransaction() {
        BigDecimal amount = transaction.getAmount();
        SplitResponse response = service.compute(transaction);
        assertThat(response.getId()).isEqualTo(transaction.getId());
        assertThat(response.getBalance().doubleValue()).isEqualTo(0f);
        List<SplitBreakdown> splitBreakdown = response.getSplitBreakdown();
        double sum = splitBreakdown.stream().mapToDouble(SplitBreakdown::getAmount).sum();

        assertThat(BigDecimal.valueOf(sum)).isEqualTo(amount);
        System.out.println(transaction.getAmount());
        System.out.println(response.getBalance());
    }

    @Test
    void testTransactionLessThan0(){
        transaction.setSplitInfo(new ArrayList<>());
        assertThatThrownBy(()-> service.compute(transaction))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("Split Infos length should not be less than 1 or more than 20");
    }
}