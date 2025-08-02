package cdm.product.asset;

import cdm.observable.asset.InterestRateIndex;
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
import cdm.product.asset.FloatingRateBase;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilder;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilderImpl;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseImpl;
import cdm.product.asset.RateTreatmentEnum;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.asset.meta.FloatingRateMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="FloatingRate", builder=FloatingRate.FloatingRateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRate", model="Just another Rosetta model", builder=FloatingRate.FloatingRateBuilderImpl.class, version="6.0.0")
public interface FloatingRate extends FloatingRateBase {

	FloatingRateMeta metaData = new FloatingRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 */
	RateSchedule getFloatingRateMultiplierSchedule();
	/**
	 * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 */
	RateTreatmentEnum getRateTreatment();
	/**
	 * Support for modular calculated rates, such such as lockout compound calculations.
	 */
	FloatingRateCalculationParameters getCalculationParameters();
	/**
	 * Definition of any fallback rate that may be applicable.
	 */
	FallbackRateParameters getFallbackRate();

	/*********************** Build Methods  ***********************/
	FloatingRate build();
	
	FloatingRate.FloatingRateBuilder toBuilder();
	
	static FloatingRate.FloatingRateBuilder builder() {
		return new FloatingRate.FloatingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRate> getType() {
		return FloatingRate.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateBuilder extends FloatingRate, FloatingRateBase.FloatingRateBaseBuilder {
		RateSchedule.RateScheduleBuilder getOrCreateFloatingRateMultiplierSchedule();
		@Override
		RateSchedule.RateScheduleBuilder getFloatingRateMultiplierSchedule();
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters();
		@Override
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters();
		FallbackRateParameters.FallbackRateParametersBuilder getOrCreateFallbackRate();
		@Override
		FallbackRateParameters.FallbackRateParametersBuilder getFallbackRate();
		@Override
		FloatingRate.FloatingRateBuilder setRateOption(ReferenceWithMetaInterestRateIndex rateOption);
		@Override
		FloatingRate.FloatingRateBuilder setRateOptionValue(InterestRateIndex rateOption);
		@Override
		FloatingRate.FloatingRateBuilder setSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		FloatingRate.FloatingRateBuilder setCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		FloatingRate.FloatingRateBuilder setFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		FloatingRate.FloatingRateBuilder setMeta(MetaFields meta);
		FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		FloatingRate.FloatingRateBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		FloatingRate.FloatingRateBuilder setFallbackRate(FallbackRateParameters fallbackRate);

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
		}
		

		FloatingRate.FloatingRateBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRate  ***********************/
	class FloatingRateImpl extends FloatingRateBase.FloatingRateBaseImpl implements FloatingRate {
		private final RateSchedule floatingRateMultiplierSchedule;
		private final RateTreatmentEnum rateTreatment;
		private final FloatingRateCalculationParameters calculationParameters;
		private final FallbackRateParameters fallbackRate;
		
		protected FloatingRateImpl(FloatingRate.FloatingRateBuilder builder) {
			super(builder);
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.calculationParameters = ofNullable(builder.getCalculationParameters()).map(f->f.build()).orElse(null);
			this.fallbackRate = ofNullable(builder.getFallbackRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@RuneAttribute("floatingRateMultiplierSchedule")
		public RateSchedule getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@RuneAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@RuneAttribute("calculationParameters")
		public FloatingRateCalculationParameters getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		@RosettaAttribute("fallbackRate")
		@RuneAttribute("fallbackRate")
		public FallbackRateParameters getFallbackRate() {
			return fallbackRate;
		}
		
		@Override
		public FloatingRate build() {
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			FloatingRate.FloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate.FloatingRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getCalculationParameters()).ifPresent(builder::setCalculationParameters);
			ofNullable(getFallbackRate()).ifPresent(builder::setFallbackRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate {" +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"calculationParameters=" + this.calculationParameters + ", " +
				"fallbackRate=" + this.fallbackRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRate  ***********************/
	class FloatingRateBuilderImpl extends FloatingRateBase.FloatingRateBaseBuilderImpl implements FloatingRate.FloatingRateBuilder {
	
		protected RateSchedule.RateScheduleBuilder floatingRateMultiplierSchedule;
		protected RateTreatmentEnum rateTreatment;
		protected FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder calculationParameters;
		protected FallbackRateParameters.FallbackRateParametersBuilder fallbackRate;
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@RuneAttribute("floatingRateMultiplierSchedule")
		public RateSchedule.RateScheduleBuilder getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder getOrCreateFloatingRateMultiplierSchedule() {
			RateSchedule.RateScheduleBuilder result;
			if (floatingRateMultiplierSchedule!=null) {
				result = floatingRateMultiplierSchedule;
			}
			else {
				result = floatingRateMultiplierSchedule = RateSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@RuneAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@RuneAttribute("calculationParameters")
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters() {
			FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder result;
			if (calculationParameters!=null) {
				result = calculationParameters;
			}
			else {
				result = calculationParameters = FloatingRateCalculationParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackRate")
		@RuneAttribute("fallbackRate")
		public FallbackRateParameters.FallbackRateParametersBuilder getFallbackRate() {
			return fallbackRate;
		}
		
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder getOrCreateFallbackRate() {
			FallbackRateParameters.FallbackRateParametersBuilder result;
			if (fallbackRate!=null) {
				result = fallbackRate;
			}
			else {
				result = fallbackRate = FallbackRateParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public FloatingRate.FloatingRateBuilder setRateOption(ReferenceWithMetaInterestRateIndex _rateOption) {
			this.rateOption = _rateOption == null ? null : _rateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder setRateOptionValue(InterestRateIndex _rateOption) {
			this.getOrCreateRateOption().setValue(_rateOption);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public FloatingRate.FloatingRateBuilder setSpreadSchedule(SpreadSchedule _spreadSchedule) {
			this.spreadSchedule = _spreadSchedule == null ? null : _spreadSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public FloatingRate.FloatingRateBuilder setCapRateSchedule(StrikeSchedule _capRateSchedule) {
			this.capRateSchedule = _capRateSchedule == null ? null : _capRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public FloatingRate.FloatingRateBuilder setFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			this.floorRateSchedule = _floorRateSchedule == null ? null : _floorRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public FloatingRate.FloatingRateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@RuneAttribute("floatingRateMultiplierSchedule")
		public FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(RateSchedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@RuneAttribute("rateTreatment")
		public FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@RuneAttribute("calculationParameters")
		public FloatingRate.FloatingRateBuilder setCalculationParameters(FloatingRateCalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackRate")
		@RuneAttribute("fallbackRate")
		public FloatingRate.FloatingRateBuilder setFallbackRate(FallbackRateParameters _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate build() {
			return new FloatingRate.FloatingRateImpl(this);
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder prune() {
			super.prune();
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			if (calculationParameters!=null && !calculationParameters.prune().hasData()) calculationParameters = null;
			if (fallbackRate!=null && !fallbackRate.prune().hasData()) fallbackRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getRateTreatment()!=null) return true;
			if (getCalculationParameters()!=null && getCalculationParameters().hasData()) return true;
			if (getFallbackRate()!=null && getFallbackRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRate.FloatingRateBuilder o = (FloatingRate.FloatingRateBuilder) other;
			
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getCalculationParameters(), o.getCalculationParameters(), this::setCalculationParameters);
			merger.mergeRosetta(getFallbackRate(), o.getFallbackRate(), this::setFallbackRate);
			
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateBuilder {" +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"calculationParameters=" + this.calculationParameters + ", " +
				"fallbackRate=" + this.fallbackRate +
			'}' + " " + super.toString();
		}
	}
}
