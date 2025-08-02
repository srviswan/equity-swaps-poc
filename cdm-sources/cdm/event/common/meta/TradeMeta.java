package cdm.event.common.meta;

import cdm.event.common.Trade;
import cdm.event.common.validation.TradeTypeFormatValidator;
import cdm.event.common.validation.TradeValidator;
import cdm.event.common.validation.exists.TradeOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.0.0
 */
@RosettaMeta(model=Trade.class)
public class TradeMeta implements RosettaMetaData<Trade> {

	@Override
	public List<Validator<? super Trade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductPriceQuantityTriangulation.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductNotionalAdjustment.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductPerformancePayoutExtraordinaryDividendsParty.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductOptionPayoutPredeterminedClearingOrganizationParty.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductForwardPayoutPredeterminedClearingOrganizationParty.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductPredeterminedClearingOrganizationParty.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyManual.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyCancelableProvision.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyExtendibleProvision.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductCalculationAgentIndependent.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductCalculationAgentOptionalEarlyTermination.class),
			factory.<cdm.product.template.TradableProduct>create(cdm.product.template.validation.datarule.TradableProductCalculationAgentMandatoryEarlyTermination.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeSettlementPayout.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradePackageTrade.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeDeliverableObligationsPhysicalSettlementMatrix.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeObligationsPhysicalSettlementMatrix.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeCreditEventsPhysicalSettlementMatrix.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeRestructuringPhysicalSettlementMatrix.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeAdditionalFixedPaymentsMortgages.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFloatingAmountEventsMortgages.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeCreditEventsMortgages.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeHedgingParty.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeDeterminingParty.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeBarrierDerterminationAgent.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeClearedDate.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd1.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd7.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd8.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd11.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd19.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd20.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd23.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd24.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd25.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLCd32.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeFpMLIrd8.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeExtraordinaryEvents.class),
			factory.<cdm.event.common.Trade>create(cdm.event.common.validation.datarule.TradeDisruptionEventsDeterminingParty.class)
		);
	}
	
	@Override
	public List<Function<? super Trade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Trade> validator() {
		return new TradeValidator();
	}

	@Override
	public Validator<? super Trade> typeFormatValidator() {
		return new TradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Trade, Set<String>> onlyExistsValidator() {
		return new TradeOnlyExistsValidator();
	}
}
