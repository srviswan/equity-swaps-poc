package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(NewEquitySwapProduct.NewEquitySwapProductDefault.class)
public abstract class NewEquitySwapProduct implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected NewFloatingPayout newFloatingPayout;
	@Inject protected NewSingleNameEquityPerformancePayout newSingleNameEquityPerformancePayout;

	/**
	* @param security The underlying Equity asset for the swap.
	* @param masterConfirmation An (optional) pointer to the Master Confirmation Agreement, if any, that holds further inputs to the Equity Swap
	* @return product 
	*/
	public NonTransferableProduct evaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		// pre-conditions
		conditionValidator.validate(() -> areEqual(MapperS.of(security).<InstrumentTypeEnum>map("getInstrumentType", _security -> _security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.EQUITY), CardinalityOperator.All),
			"Security must be equity (single name).");
		
		NonTransferableProduct.NonTransferableProductBuilder productBuilder = doEvaluate(security, masterConfirmation);
		
		final NonTransferableProduct product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, product);
		}
		
		// post-conditions
		conditionValidator.validate(() -> {
			if (notExists(MapperS.of(masterConfirmation)).getOrDefault(false)) {
				final MapperC<Boolean> thenArg = MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout())
					.mapItem(item -> exists(item.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout())).asMapper());
				return ComparisonResult.of(areEqual(thenArg, MapperS.of(true), CardinalityOperator.All).asMapper());
			}
			return ComparisonResult.successEmptyOperand("");
		},
			"Other payout types must be absent.");
		
		return product;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation);

	public static class NewEquitySwapProductDefault extends NewEquitySwapProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
			NonTransferableProduct.NonTransferableProductBuilder product = NonTransferableProduct.builder();
			return assignOutput(product, security, masterConfirmation);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder product, Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
			final Payout payout0 = Payout.builder()
				.setPerformancePayout(newSingleNameEquityPerformancePayout.evaluate(security, masterConfirmation))
				.build();
			product
				.getOrCreateEconomicTerms()
				.addPayout((payout0 == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout0)));
			
			final List<Payout> ifThenElseResult;
			if (exists(MapperS.of(masterConfirmation)).getOrDefault(false)) {
				final Payout payout1 = Payout.builder()
					.setInterestRatePayout(newFloatingPayout.evaluate(masterConfirmation))
					.build();
				ifThenElseResult = payout1 == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout1);
			} else {
				ifThenElseResult = Collections.<Payout>emptyList();
			}
			product
				.getOrCreateEconomicTerms()
				.addPayout(ifThenElseResult);
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
