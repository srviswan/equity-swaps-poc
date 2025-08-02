package cdm.product.asset;

import cdm.base.math.AveragingWeightingMethodEnum;
import cdm.base.math.Rounding;
import cdm.base.math.Rounding.RoundingBuilder;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.calculatedrate.FallbackRateParameters;
import cdm.observable.asset.calculatedrate.FallbackRateParameters.FallbackRateParametersBuilder;
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters;
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder;
import cdm.product.asset.FloatingRate;
import cdm.product.asset.FloatingRate.FloatingRateBuilder;
import cdm.product.asset.FloatingRate.FloatingRateBuilderImpl;
import cdm.product.asset.FloatingRate.FloatingRateImpl;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilder;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilderImpl;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationImpl;
import cdm.product.asset.NegativeInterestRateTreatmentEnum;
import cdm.product.asset.RateTreatmentEnum;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.asset.meta.FloatingRateSpecificationMeta;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.schedule.RateSchedule.RateScheduleBuilder;
import cdm.product.template.StrikeSchedule;
import cdm.product.template.StrikeSchedule.StrikeScheduleBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
 * @version 6.0.0
 */
@RosettaDataType(value="FloatingRateSpecification", builder=FloatingRateSpecification.FloatingRateSpecificationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRateSpecification", model="Just another Rosetta model", builder=FloatingRateSpecification.FloatingRateSpecificationBuilderImpl.class, version="6.0.0")
public interface FloatingRateSpecification extends FloatingRate {

	FloatingRateSpecificationMeta metaData = new FloatingRateSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
	 */
	Price getInitialRate();
	/**
	 * The rounding convention to apply to the final rate used in determination of a calculation period amount.
	 */
	Rounding getFinalRateRounding();
	/**
	 * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
	 */
	AveragingWeightingMethodEnum getAveragingMethod();
	/**
	 * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
	 */
	NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment();

	/*********************** Build Methods  ***********************/
	FloatingRateSpecification build();
	
	FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder();
	
	static FloatingRateSpecification.FloatingRateSpecificationBuilder builder() {
		return new FloatingRateSpecification.FloatingRateSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateSpecification> getType() {
		return FloatingRateSpecification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.class, getRateOption());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, RateSchedule.class, getFloatingRateMultiplierSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.class, getCalculationParameters());
		processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRateParameters.class, getFallbackRate());
		processRosetta(path.newSubPath("initialRate"), processor, Price.class, getInitialRate());
		processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.class, getFinalRateRounding());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingWeightingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateSpecificationBuilder extends FloatingRateSpecification, FloatingRate.FloatingRateBuilder {
		Price.PriceBuilder getOrCreateInitialRate();
		@Override
		Price.PriceBuilder getInitialRate();
		Rounding.RoundingBuilder getOrCreateFinalRateRounding();
		@Override
		Rounding.RoundingBuilder getFinalRateRounding();
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOption(ReferenceWithMetaInterestRateIndex rateOption);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOptionValue(InterestRateIndex rateOption);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setMeta(MetaFields meta);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setInitialRate(Price initialRate);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setAveragingMethod(AveragingWeightingMethodEnum averagingMethod);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder.class, getRateOption());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, RateSchedule.RateScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder.class, getCalculationParameters());
			processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRateParameters.FallbackRateParametersBuilder.class, getFallbackRate());
			processRosetta(path.newSubPath("initialRate"), processor, Price.PriceBuilder.class, getInitialRate());
			processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.RoundingBuilder.class, getFinalRateRounding());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingWeightingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
		}
		

		FloatingRateSpecification.FloatingRateSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateSpecification  ***********************/
	class FloatingRateSpecificationImpl extends FloatingRate.FloatingRateImpl implements FloatingRateSpecification {
		private final Price initialRate;
		private final Rounding finalRateRounding;
		private final AveragingWeightingMethodEnum averagingMethod;
		private final NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		protected FloatingRateSpecificationImpl(FloatingRateSpecification.FloatingRateSpecificationBuilder builder) {
			super(builder);
			this.initialRate = ofNullable(builder.getInitialRate()).map(f->f.build()).orElse(null);
			this.finalRateRounding = ofNullable(builder.getFinalRateRounding()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.negativeInterestRateTreatment = builder.getNegativeInterestRateTreatment();
		}
		
		@Override
		@RosettaAttribute("initialRate")
		@RuneAttribute("initialRate")
		public Price getInitialRate() {
			return initialRate;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@RuneAttribute("finalRateRounding")
		public Rounding getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public AveragingWeightingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@RuneAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		public FloatingRateSpecification build() {
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder() {
			FloatingRateSpecification.FloatingRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateSpecification.FloatingRateSpecificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInitialRate()).ifPresent(builder::setInitialRate);
			ofNullable(getFinalRateRounding()).ifPresent(builder::setFinalRateRounding);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getNegativeInterestRateTreatment()).ifPresent(builder::setNegativeInterestRateTreatment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSpecification {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateSpecification  ***********************/
	class FloatingRateSpecificationBuilderImpl extends FloatingRate.FloatingRateBuilderImpl implements FloatingRateSpecification.FloatingRateSpecificationBuilder {
	
		protected Price.PriceBuilder initialRate;
		protected Rounding.RoundingBuilder finalRateRounding;
		protected AveragingWeightingMethodEnum averagingMethod;
		protected NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		@Override
		@RosettaAttribute("initialRate")
		@RuneAttribute("initialRate")
		public Price.PriceBuilder getInitialRate() {
			return initialRate;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateInitialRate() {
			Price.PriceBuilder result;
			if (initialRate!=null) {
				result = initialRate;
			}
			else {
				result = initialRate = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@RuneAttribute("finalRateRounding")
		public Rounding.RoundingBuilder getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateFinalRateRounding() {
			Rounding.RoundingBuilder result;
			if (finalRateRounding!=null) {
				result = finalRateRounding;
			}
			else {
				result = finalRateRounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public AveragingWeightingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@RuneAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOption(ReferenceWithMetaInterestRateIndex _rateOption) {
			this.rateOption = _rateOption == null ? null : _rateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOptionValue(InterestRateIndex _rateOption) {
			this.getOrCreateRateOption().setValue(_rateOption);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setSpreadSchedule(SpreadSchedule _spreadSchedule) {
			this.spreadSchedule = _spreadSchedule == null ? null : _spreadSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setCapRateSchedule(StrikeSchedule _capRateSchedule) {
			this.capRateSchedule = _capRateSchedule == null ? null : _capRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			this.floorRateSchedule = _floorRateSchedule == null ? null : _floorRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@RuneAttribute("floatingRateMultiplierSchedule")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@RuneAttribute("rateTreatment")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@RuneAttribute("calculationParameters")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackRate")
		@RuneAttribute("fallbackRate")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFallbackRate(FallbackRateParameters _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("initialRate")
		@RuneAttribute("initialRate")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setInitialRate(Price _initialRate) {
			this.initialRate = _initialRate == null ? null : _initialRate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@RuneAttribute("finalRateRounding")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFinalRateRounding(Rounding _finalRateRounding) {
			this.finalRateRounding = _finalRateRounding == null ? null : _finalRateRounding.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setAveragingMethod(AveragingWeightingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@RuneAttribute("negativeInterestRateTreatment")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum _negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = _negativeInterestRateTreatment == null ? null : _negativeInterestRateTreatment;
			return this;
		}
		
		@Override
		public FloatingRateSpecification build() {
			return new FloatingRateSpecification.FloatingRateSpecificationImpl(this);
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder prune() {
			super.prune();
			if (initialRate!=null && !initialRate.prune().hasData()) initialRate = null;
			if (finalRateRounding!=null && !finalRateRounding.prune().hasData()) finalRateRounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInitialRate()!=null && getInitialRate().hasData()) return true;
			if (getFinalRateRounding()!=null && getFinalRateRounding().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getNegativeInterestRateTreatment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateSpecification.FloatingRateSpecificationBuilder o = (FloatingRateSpecification.FloatingRateSpecificationBuilder) other;
			
			merger.mergeRosetta(getInitialRate(), o.getInitialRate(), this::setInitialRate);
			merger.mergeRosetta(getFinalRateRounding(), o.getFinalRateRounding(), this::setFinalRateRounding);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getNegativeInterestRateTreatment(), o.getNegativeInterestRateTreatment(), this::setNegativeInterestRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSpecificationBuilder {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
}
