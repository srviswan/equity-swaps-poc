package com.pb.swap.rules.runtime.builder;

import com.pb.swap.rules.core.action.SwapWriter;
import com.pb.swap.rules.core.model.DivPassthrough;
import com.pb.swap.rules.core.model.EnrichedEquitySwap;
import com.pb.swap.rules.core.model.EquityLeg;
import com.pb.swap.rules.core.model.InterestLeg;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.Schedule;
import com.pb.swap.rules.core.model.SwapContract;
import java.math.BigDecimal;

public final class EquitySwapBuilder implements SwapWriter {
    private String tradeId;
    private SwapContract swapContract;
    private InterestLeg interestLeg;
    private EquityLeg equityLeg;
    private Schedule schedule;
    private DivPassthrough divPassthrough;
    private String legalEntity;
    private String workflowStatus;
    private String routingDestination;

    public static EquitySwapBuilder startFrom(RawHedgeTrade raw) {
        EquitySwapBuilder b = new EquitySwapBuilder();
        b.tradeId = raw.tradeId();
        b.swapContract =
                new SwapContract(raw.tradeId(), raw.productType(), raw.tradeDate(), null);
        b.interestLeg = new InterestLeg(null, null, null, null, null);
        b.equityLeg = new EquityLeg(null, null);
        b.schedule = new Schedule(null, null);
        b.divPassthrough = new DivPassthrough(null, null);
        return b;
    }

    public EnrichedEquitySwap build() {
        return new EnrichedEquitySwap(
                tradeId,
                swapContract,
                interestLeg,
                equityLeg,
                schedule,
                divPassthrough,
                legalEntity,
                workflowStatus,
                routingDestination);
    }

    public EnrichedEquitySwap partial() {
        return build();
    }

    @Override
    public String readAsString(String path) {
        Object v = readObject(path);
        return v == null ? null : v.toString();
    }

    private Object readObject(String path) {
        return switch (path) {
            case "interestLeg.dayCount" -> interestLeg.dayCount();
            case "interestLeg.spreadBps" -> interestLeg.spreadBps();
            case "interestLeg.rateType" -> interestLeg.rateType();
            case "interestLeg.fixedRate" -> interestLeg.fixedRate();
            case "equityLeg.returnType" -> equityLeg.returnType();
            case "schedule.paymentFrequency" -> schedule.paymentFrequency();
            case "divPassthrough.percent" -> divPassthrough.percent();
            case "divPassthrough.timing" -> divPassthrough.timing();
            case "workflowStatus" -> workflowStatus;
            case "routingDestination" -> routingDestination;
            case "legalEntity" -> legalEntity;
            case "swapContract.productType" -> swapContract.productType();
            default -> null;
        };
    }

    @Override
    public void set(String path, Object value) {
        switch (path) {
            case "interestLeg.dayCount" ->
                    interestLeg =
                            new InterestLeg(
                                    str(value),
                                    interestLeg.rateType(),
                                    interestLeg.index(),
                                    interestLeg.spreadBps(),
                                    interestLeg.fixedRate());
            case "interestLeg.spreadBps" ->
                    interestLeg =
                            new InterestLeg(
                                    interestLeg.dayCount(),
                                    interestLeg.rateType(),
                                    interestLeg.index(),
                                    toBigDecimal(value),
                                    interestLeg.fixedRate());
            case "interestLeg.rateType" ->
                    interestLeg =
                            new InterestLeg(
                                    interestLeg.dayCount(),
                                    str(value),
                                    interestLeg.index(),
                                    interestLeg.spreadBps(),
                                    interestLeg.fixedRate());
            case "equityLeg.returnType" -> equityLeg = new EquityLeg(str(value), equityLeg.feeType());
            case "schedule.paymentFrequency" ->
                    schedule = new Schedule(str(value), schedule.rollConvention());
            case "divPassthrough.percent" ->
                    divPassthrough = new DivPassthrough(toBigDecimal(value), divPassthrough.timing());
            case "divPassthrough.timing" ->
                    divPassthrough = new DivPassthrough(divPassthrough.percent(), str(value));
            case "workflowStatus" -> workflowStatus = str(value);
            case "routingDestination" -> routingDestination = str(value);
            case "legalEntity" -> legalEntity = str(value);
            case "swapContract.productType" ->
                    swapContract =
                            new SwapContract(
                                    swapContract.contractId(),
                                    str(value),
                                    swapContract.startDate(),
                                    swapContract.endDate());
            default -> {}
        }
    }

    private static String str(Object v) {
        return v == null ? null : v.toString();
    }

    private static BigDecimal toBigDecimal(Object v) {
        if (v == null) {
            return null;
        }
        if (v instanceof BigDecimal bd) {
            return bd;
        }
        return new BigDecimal(v.toString());
    }
}
