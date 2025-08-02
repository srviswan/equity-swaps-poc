package cdm.margin.schedule.functions;

import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.StandardizedSchedule.StandardizedScheduleBuilder;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(BuildStandardizedSchedule.BuildStandardizedScheduleDefault.class)
public abstract class BuildStandardizedSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected StandardizedScheduleAssetClass standardizedScheduleAssetClass;
	@Inject protected StandardizedScheduleDuration standardizedScheduleDuration;
	@Inject protected StandardizedScheduleNotional standardizedScheduleNotional;
	@Inject protected StandardizedScheduleNotionalCurrency standardizedScheduleNotionalCurrency;
	@Inject protected StandardizedScheduleProductClass standardizedScheduleProductClass;

	/**
	* @param trade 
	* @return standardizedSchedule 
	*/
	public StandardizedSchedule evaluate(Trade trade) {
		StandardizedSchedule.StandardizedScheduleBuilder standardizedScheduleBuilder = doEvaluate(trade);
		
		final StandardizedSchedule standardizedSchedule;
		if (standardizedScheduleBuilder == null) {
			standardizedSchedule = null;
		} else {
			standardizedSchedule = standardizedScheduleBuilder.build();
			objectValidator.validate(StandardizedSchedule.class, standardizedSchedule);
		}
		
		return standardizedSchedule;
	}

	protected abstract StandardizedSchedule.StandardizedScheduleBuilder doEvaluate(Trade trade);

	protected abstract MapperS<StandardizedScheduleAssetClassEnum> assetClass(Trade trade);

	protected abstract MapperS<StandardizedScheduleProductClassEnum> productClass(Trade trade);

	public static class BuildStandardizedScheduleDefault extends BuildStandardizedSchedule {
		@Override
		protected StandardizedSchedule.StandardizedScheduleBuilder doEvaluate(Trade trade) {
			StandardizedSchedule.StandardizedScheduleBuilder standardizedSchedule = StandardizedSchedule.builder();
			return assignOutput(standardizedSchedule, trade);
		}
		
		protected StandardizedSchedule.StandardizedScheduleBuilder assignOutput(StandardizedSchedule.StandardizedScheduleBuilder standardizedSchedule, Trade trade) {
			standardizedSchedule
				.setAssetClass(assetClass(trade).get());
			
			standardizedSchedule
				.setProductClass(productClass(trade).get());
			
			standardizedSchedule
				.setNotional(standardizedScheduleNotional.evaluate(trade, assetClass(trade).get(), productClass(trade).get()));
			
			standardizedSchedule
				.setNotionalCurrency(standardizedScheduleNotionalCurrency.evaluate(trade, assetClass(trade).get(), productClass(trade).get()));
			
			standardizedSchedule
				.setDurationInYears(standardizedScheduleDuration.evaluate(trade, assetClass(trade).get(), productClass(trade).get()));
			
			return Optional.ofNullable(standardizedSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<StandardizedScheduleAssetClassEnum> assetClass(Trade trade) {
			return MapperS.of(standardizedScheduleAssetClass.evaluate(trade));
		}
		
		@Override
		protected MapperS<StandardizedScheduleProductClassEnum> productClass(Trade trade) {
			return MapperS.of(standardizedScheduleProductClass.evaluate(trade));
		}
	}
}
