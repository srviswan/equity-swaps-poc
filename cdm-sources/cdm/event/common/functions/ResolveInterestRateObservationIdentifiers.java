package cdm.event.common.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.ObservationIdentifier.ObservationIdentifierBuilder;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ResolveInterestRateObservationIdentifiers.ResolveInterestRateObservationIdentifiersDefault.class)
public abstract class ResolveInterestRateObservationIdentifiers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payout 
	* @param date 
	* @return identifiers 
	*/
	public ObservationIdentifier evaluate(InterestRatePayout payout, Date date) {
		ObservationIdentifier.ObservationIdentifierBuilder identifiersBuilder = doEvaluate(payout, date);
		
		final ObservationIdentifier identifiers;
		if (identifiersBuilder == null) {
			identifiers = null;
		} else {
			identifiers = identifiersBuilder.build();
			objectValidator.validate(ObservationIdentifier.class, identifiers);
		}
		
		return identifiers;
	}

	protected abstract ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(InterestRatePayout payout, Date date);

	public static class ResolveInterestRateObservationIdentifiersDefault extends ResolveInterestRateObservationIdentifiers {
		@Override
		protected ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(InterestRatePayout payout, Date date) {
			ObservationIdentifier.ObservationIdentifierBuilder identifiers = ObservationIdentifier.builder();
			return assignOutput(identifiers, payout, date);
		}
		
		protected ObservationIdentifier.ObservationIdentifierBuilder assignOutput(ObservationIdentifier.ObservationIdentifierBuilder identifiers, InterestRatePayout payout, Date date) {
			final ReferenceWithMetaInterestRateIndex referenceWithMetaInterestRateIndex = MapperS.of(payout).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).get();
			identifiers
				.getOrCreateObservable()
				.getOrCreateIndex()
				.setInterestRateIndexValue((referenceWithMetaInterestRateIndex == null ? null : referenceWithMetaInterestRateIndex.getValue()));
			
			identifiers
				.setObservationDate(date);
			
			return Optional.ofNullable(identifiers)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
