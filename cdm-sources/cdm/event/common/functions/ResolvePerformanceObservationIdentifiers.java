package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.functions.ResolveAdjustableDate;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.util.AssetDeepPathUtil;
import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.ValuationDates;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.common.TimeTypeEnum;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.ObservationIdentifier.ObservationIdentifierBuilder;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolvePerformanceObservationIdentifiers.ResolvePerformanceObservationIdentifiersDefault.class)
public abstract class ResolvePerformanceObservationIdentifiers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustedValuationDates adjustedValuationDates;
	@Inject protected AssetDeepPathUtil assetDeepPathUtil;
	@Inject protected ResolveAdjustableDate resolveAdjustableDate;
	@Inject protected ResolvePerformanceValuationTime resolvePerformanceValuationTime;

	/**
	* @param payout 
	* @param adjustedDate 
	* @return identifiers 
	*/
	public ObservationIdentifier evaluate(PerformancePayout payout, Date adjustedDate) {
		ObservationIdentifier.ObservationIdentifierBuilder identifiersBuilder = doEvaluate(payout, adjustedDate);
		
		final ObservationIdentifier identifiers;
		if (identifiersBuilder == null) {
			identifiers = null;
		} else {
			identifiers = identifiersBuilder.build();
			objectValidator.validate(ObservationIdentifier.class, identifiers);
		}
		
		return identifiers;
	}

	protected abstract ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(PerformancePayout payout, Date adjustedDate);

	protected abstract MapperS<Date> adjustedFinalValuationDate(PerformancePayout payout, Date adjustedDate);

	protected abstract MapperS<? extends PerformanceValuationDates> valuationDates(PerformancePayout payout, Date adjustedDate);

	public static class ResolvePerformanceObservationIdentifiersDefault extends ResolvePerformanceObservationIdentifiers {
		@Override
		protected ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(PerformancePayout payout, Date adjustedDate) {
			ObservationIdentifier.ObservationIdentifierBuilder identifiers = ObservationIdentifier.builder();
			return assignOutput(identifiers, payout, adjustedDate);
		}
		
		protected ObservationIdentifier.ObservationIdentifierBuilder assignOutput(ObservationIdentifier.ObservationIdentifierBuilder identifiers, PerformancePayout payout, Date adjustedDate) {
			final ReferenceWithMetaObservable referenceWithMetaObservable = MapperS.of(payout).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			identifiers
				.setObservable((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()));
			
			final MapperC<Date> thenArg = MapperC.<Date>of(adjustedValuationDates.evaluate(MapperS.of(payout).<ValuationDates>map("getValuationDates", performancePayout -> performancePayout.getValuationDates()).get()))
				.filterItemNullSafe(item -> lessThanEquals(item, MapperS.of(adjustedDate), CardinalityOperator.All).get());
			identifiers
				.setObservationDate(thenArg
					.last().get());
			
			identifiers
				.setObservationTime(resolvePerformanceValuationTime.evaluate(valuationDates(payout, adjustedDate).<BusinessCenterTime>map("getValuationTime", performanceValuationDates -> performanceValuationDates.getValuationTime()).get(), valuationDates(payout, adjustedDate).<TimeTypeEnum>map("getValuationTimeType", performanceValuationDates -> performanceValuationDates.getValuationTimeType()).get(), MapperS.of(identifiers).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Asset>map("getAsset", observable -> observable.getAsset()).<AssetIdentifier>mapC("chooseIdentifier", asset -> assetDeepPathUtil.chooseIdentifier(asset)).get(), valuationDates(payout, adjustedDate).<DeterminationMethodEnum>map("getDeterminationMethod", performanceValuationDates -> performanceValuationDates.getDeterminationMethod()).get()));
			
			identifiers
				.setInformationSource(MapperS.of(payout).<ObservationTerms>map("getObservationTerms", performancePayout -> performancePayout.getObservationTerms()).<FxSpotRateSource>map("getInformationSource", observationTerms -> observationTerms.getInformationSource()).<InformationSource>map("getPrimarySource", fxSpotRateSource -> fxSpotRateSource.getPrimarySource()).get());
			
			identifiers
				.getOrCreateDeterminationMethodology()
				.setDeterminationMethod(valuationDates(payout, adjustedDate).<DeterminationMethodEnum>map("getDeterminationMethod", performanceValuationDates -> performanceValuationDates.getDeterminationMethod()).get());
			
			return Optional.ofNullable(identifiers)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Date> adjustedFinalValuationDate(PerformancePayout payout, Date adjustedDate) {
			return MapperS.of(resolveAdjustableDate.evaluate(MapperS.of(payout).<ValuationDates>map("getValuationDates", performancePayout -> performancePayout.getValuationDates()).<PerformanceValuationDates>map("getFinalValuationDate", _valuationDates -> _valuationDates.getFinalValuationDate()).<AdjustableOrRelativeDate>map("getValuationDate", performanceValuationDates -> performanceValuationDates.getValuationDate()).get()));
		}
		
		@Override
		protected MapperS<? extends PerformanceValuationDates> valuationDates(PerformancePayout payout, Date adjustedDate) {
			if (lessThan(MapperS.of(adjustedDate), adjustedFinalValuationDate(payout, adjustedDate), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(payout).<ValuationDates>map("getValuationDates", performancePayout -> performancePayout.getValuationDates()).<PerformanceValuationDates>map("getInterimValuationDate", _valuationDates -> _valuationDates.getInterimValuationDate());
			}
			return MapperS.of(payout).<ValuationDates>map("getValuationDates", performancePayout -> performancePayout.getValuationDates()).<PerformanceValuationDates>map("getFinalValuationDate", _valuationDates -> _valuationDates.getFinalValuationDate());
		}
	}
}
