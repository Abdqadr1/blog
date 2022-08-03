package com.qadr.lannisterpay.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qadr.lannisterpay.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ComputeControllerTest {
    @Autowired TestRestTemplate restTemplate;
    @Autowired ObjectMapper objectMapper;
    @Autowired MockMvc mockMvc;
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
        SplitResponse response = restTemplate.postForObject(
                "/split-payments/compute",
                transaction,
                SplitResponse.class
        );
        assertThat(response.getId()).isEqualTo(transaction.getId());
        System.out.println(response);

        assertThat(response.getId()).isEqualTo(transaction.getId());
        assertThat(response.getBalance().doubleValue()).isEqualTo(0f);
        List<SplitBreakdown> splitBreakdown = response.getSplitBreakdown();
        double sum = splitBreakdown.stream().mapToDouble(SplitBreakdown::getAmount).sum();

        assertThat(BigDecimal.valueOf(sum)).isEqualTo(amount);
        System.out.println(transaction.getAmount());
        System.out.println(response.getBalance());
    }

    @Test
    void testTransactionLessThan0() throws Exception {
        transaction.setSplitInfo(new ArrayList<>());
        mockMvc.perform(post("/split-payments/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transaction)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}