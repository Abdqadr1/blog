package com.qadr.lannisterpay.service;

import com.qadr.lannisterpay.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public record LannisterService() {

    public SplitResponse compute(Transaction transaction){
        if(
                transaction.getSplitInfo().size() < 1 ||
                transaction.getSplitInfo().size() > 20)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Split Infos length should not be less than 1 or more than 20"
            );
        }

        List<SplitInfo> splitInfos = transaction.getSplitInfo();
        SplitResponse response = new SplitResponse();
        response.setId(transaction.getId());

        List<SplitInfo> flats = splitInfos.stream()
                .filter(splitInfo -> splitInfo.getSplitType().equals(SplitType.FLAT)).collect(Collectors.toList());
        computeFlat(transaction, flats, response);

        List<SplitInfo> percents = splitInfos.stream()
                .filter(splitInfo -> splitInfo.getSplitType().equals(SplitType.PERCENTAGE)).collect(Collectors.toList());
        computePercentage(transaction, percents, response);

        List<SplitInfo> ratio = splitInfos.stream()
                .filter(splitInfo -> splitInfo.getSplitType().equals(SplitType.RATIO)).collect(Collectors.toList());
        computeRatio(transaction.getAmount(), ratio, response);

        response.setBalance(BigDecimal.ZERO);
        return response;
    }

    private void computePercentage(Transaction transaction,
                                   List<SplitInfo> infos, SplitResponse response) {
        infos.forEach(splitInfo -> {
            BigDecimal amount = transaction.getAmount();
            BigDecimal value = splitInfo.getSplitValue().multiply(amount).divide(BigDecimal.valueOf(100L));
            BigDecimal newAmount = amount.subtract(value);
            transaction.setAmount(newAmount);
            SplitBreakdown breakdown = new SplitBreakdown();
            breakdown.setSplitEntityId(splitInfo.getSplitEntityId());
            breakdown.setAmount(value.doubleValue());
            response.getSplitBreakdown().add(breakdown);
        });
    }

    private void computeRatio(BigDecimal amount,
                              List<SplitInfo> infos, SplitResponse response) {
        double ratio = infos.stream()
                .mapToDouble(info-> info.getSplitValue().doubleValue())
                .sum();
        infos.forEach(splitInfo -> {
            BigDecimal value = splitInfo.getSplitValue()
                    .divide(BigDecimal.valueOf(ratio), 2 , RoundingMode.HALF_UP).multiply(amount);
            SplitBreakdown breakdown = new SplitBreakdown();
            breakdown.setSplitEntityId(splitInfo.getSplitEntityId());
            breakdown.setAmount(value.doubleValue());
            response.getSplitBreakdown().add(breakdown);
        });
    }

    private void computeFlat(Transaction transaction,
                             List<SplitInfo> infos, SplitResponse response){
        infos.forEach(splitInfo -> {
            BigDecimal amount = transaction.getAmount();
            BigDecimal newAmount = amount.subtract(splitInfo.getSplitValue());
            transaction.setAmount(newAmount);
            SplitBreakdown breakdown = new SplitBreakdown();
            breakdown.setSplitEntityId(splitInfo.getSplitEntityId());
            breakdown.setAmount(splitInfo.getSplitValue().doubleValue());
            response.getSplitBreakdown().add(breakdown);
        });
    }

}
