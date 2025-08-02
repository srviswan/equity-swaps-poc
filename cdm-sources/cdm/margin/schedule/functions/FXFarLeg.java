package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(FXFarLeg.FXFarLegDefault.class)
public abstract class FXFarLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;

	/**
	* @param product 
	* @return nearLegPayout 
	*/
	public SettlementPayout evaluate(NonTransferableProduct product) {
		SettlementPayout.SettlementPayoutBuilder nearLegPayoutBuilder = doEvaluate(product);
		
		final SettlementPayout nearLegPayout;
		if (nearLegPayoutBuilder == null) {
			nearLegPayout = null;
		} else {
			nearLegPayout = nearLegPayoutBuilder.build();
			objectValidator.validate(SettlementPayout.class, nearLegPayout);
		}
		
		return nearLegPayout;
	}

	protected abstract SettlementPayout.SettlementPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends SettlementPayout> settlementPayout(NonTransferableProduct product);

	public static class FXFarLegDefault extends FXFarLeg {
		@Override
		protected SettlementPayout.SettlementPayoutBuilder doEvaluate(NonTransferableProduct product) {
			SettlementPayout.SettlementPayoutBuilder nearLegPayout = SettlementPayout.builder();
			return assignOutput(nearLegPayout, product);
		}
		
		protected SettlementPayout.SettlementPayoutBuilder assignOutput(SettlementPayout.SettlementPayoutBuilder nearLegPayout, NonTransferableProduct product) {
			if (ComparisonResult.of(MapperS.of(qualify_ForeignExchange_Swap.evaluate(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).or(ComparisonResult.of(MapperS.of(qualify_ForeignExchange_NDS.evaluate(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).and(exists(settlementPayout(product).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate()))).getOrDefault(false)) {
				nearLegPayout = toBuilder(settlementPayout(product)
					.max(item -> item.<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())).get());
			} else if (ComparisonResult.of(MapperS.of(qualify_ForeignExchange_Swap.evaluate(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).or(ComparisonResult.of(MapperS.of(qualify_ForeignExchange_NDS.evaluate(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).and(exists(settlementPayout(product).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()))).getOrDefault(false)) {
				nearLegPayout = toBuilder(settlementPayout(product)
					.max(item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(item.<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()).get()))).get());
			} else {
				nearLegPayout = null;
			}
			
			return Optional.ofNullable(nearLegPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends SettlementPayout> settlementPayout(NonTransferableProduct product) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout());
		}
	}
}
