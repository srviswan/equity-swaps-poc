package cdm.product.asset;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Offset.OffsetBuilder;
import cdm.base.math.AveragingWeightingMethodEnum;
import cdm.base.math.Rounding;
import cdm.base.math.Rounding.RoundingBuilder;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.calculatedrate.FallbackRateParameters;
import cdm.observable.asset.calculatedrate.FallbackRateParameters.FallbackRateParametersBuilder;
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters;
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder;
import cdm.observable.asset.calculatedrate.InflationCalculationMethodEnum;
import cdm.observable.asset.calculatedrate.InflationCalculationStyleEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder;
import cdm.product.asset.FinalPrincipalExchangeCalculationEnum;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilder;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilderImpl;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationImpl;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InflationRateSpecification.InflationRateSpecificationBuilder;
import cdm.product.asset.InflationRateSpecification.InflationRateSpecificationBuilderImpl;
import cdm.product.asset.InflationRateSpecification.InflationRateSpecificationImpl;
import cdm.product.asset.NegativeInterestRateTreatmentEnum;
import cdm.product.asset.RateTreatmentEnum;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.asset.meta.InflationRateSpecificationMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data to:  specify the inflation rate.
 * @version 6.0.0
 */
@RosettaDataType(value="InflationRateSpecification", builder=InflationRateSpecification.InflationRateSpecificationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="InflationRateSpecification", model="Just another Rosetta model", builder=InflationRateSpecification.InflationRateSpecificationBuilderImpl.class, version="6.0.0")
public interface InflationRateSpecification extends FloatingRateSpecification {

	InflationRateSpecificationMeta metaData = new InflationRateSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
	 */
	Offset getInflationLag();
	/**
	 * The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
	 */
	FieldWithMetaString getIndexSource();
	/**
	 * The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
	 */
	FieldWithMetaString getMainPublication();
	/**
	 * The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
	 */
	FieldWithMetaInterpolationMethodEnum getInterpolationMethod();
	/**
	 * Initial known index level for the first calculation period.
	 */
	BigDecimal getInitialIndexLevel();
	/**
	 * The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
	 */
	Boolean getFallbackBondApplicable();
	/**
	 * Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
	 */
	InflationCalculationMethodEnum getCalculationMethod();
	/**
	 * Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
	 */
	InflationCalculationStyleEnum getCalculationStyle();
	/**
	 * To be specified only for products that embed a redemption payment.
	 */
	FinalPrincipalExchangeCalculationEnum getFinalPrincipalExchangeCalculation();

	/*********************** Build Methods  ***********************/
	InflationRateSpecification build();
	
	InflationRateSpecification.InflationRateSpecificationBuilder toBuilder();
	
	static InflationRateSpecification.InflationRateSpecificationBuilder builder() {
		return new InflationRateSpecification.InflationRateSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationRateSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InflationRateSpecification> getType() {
		return InflationRateSpecification.class;
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
		processRosetta(path.newSubPath("inflationLag"), processor, Offset.class, getInflationLag());
		processRosetta(path.newSubPath("indexSource"), processor, FieldWithMetaString.class, getIndexSource());
		processRosetta(path.newSubPath("mainPublication"), processor, FieldWithMetaString.class, getMainPublication());
		processRosetta(path.newSubPath("interpolationMethod"), processor, FieldWithMetaInterpolationMethodEnum.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
		processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
		processor.processBasic(path.newSubPath("calculationMethod"), InflationCalculationMethodEnum.class, getCalculationMethod(), this);
		processor.processBasic(path.newSubPath("calculationStyle"), InflationCalculationStyleEnum.class, getCalculationStyle(), this);
		processor.processBasic(path.newSubPath("finalPrincipalExchangeCalculation"), FinalPrincipalExchangeCalculationEnum.class, getFinalPrincipalExchangeCalculation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InflationRateSpecificationBuilder extends InflationRateSpecification, FloatingRateSpecification.FloatingRateSpecificationBuilder {
		Offset.OffsetBuilder getOrCreateInflationLag();
		@Override
		Offset.OffsetBuilder getInflationLag();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIndexSource();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getIndexSource();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMainPublication();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getMainPublication();
		FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder getOrCreateInterpolationMethod();
		@Override
		FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder getInterpolationMethod();
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setRateOption(ReferenceWithMetaInterestRateIndex rateOption);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setRateOptionValue(InterestRateIndex rateOption);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setMeta(MetaFields meta);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setInitialRate(Price initialRate);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setAveragingMethod(AveragingWeightingMethodEnum averagingMethod);
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);
		InflationRateSpecification.InflationRateSpecificationBuilder setInflationLag(Offset inflationLag);
		InflationRateSpecification.InflationRateSpecificationBuilder setIndexSource(FieldWithMetaString indexSource);
		InflationRateSpecification.InflationRateSpecificationBuilder setIndexSourceValue(String indexSource);
		InflationRateSpecification.InflationRateSpecificationBuilder setMainPublication(FieldWithMetaString mainPublication);
		InflationRateSpecification.InflationRateSpecificationBuilder setMainPublicationValue(String mainPublication);
		InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethod(FieldWithMetaInterpolationMethodEnum interpolationMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethodValue(InterpolationMethodEnum interpolationMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel);
		InflationRateSpecification.InflationRateSpecificationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable);
		InflationRateSpecification.InflationRateSpecificationBuilder setCalculationMethod(InflationCalculationMethodEnum calculationMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setCalculationStyle(InflationCalculationStyleEnum calculationStyle);
		InflationRateSpecification.InflationRateSpecificationBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculationEnum finalPrincipalExchangeCalculation);

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
			processRosetta(path.newSubPath("inflationLag"), processor, Offset.OffsetBuilder.class, getInflationLag());
			processRosetta(path.newSubPath("indexSource"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getIndexSource());
			processRosetta(path.newSubPath("mainPublication"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getMainPublication());
			processRosetta(path.newSubPath("interpolationMethod"), processor, FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
			processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
			processor.processBasic(path.newSubPath("calculationMethod"), InflationCalculationMethodEnum.class, getCalculationMethod(), this);
			processor.processBasic(path.newSubPath("calculationStyle"), InflationCalculationStyleEnum.class, getCalculationStyle(), this);
			processor.processBasic(path.newSubPath("finalPrincipalExchangeCalculation"), FinalPrincipalExchangeCalculationEnum.class, getFinalPrincipalExchangeCalculation(), this);
		}
		

		InflationRateSpecification.InflationRateSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of InflationRateSpecification  ***********************/
	class InflationRateSpecificationImpl extends FloatingRateSpecification.FloatingRateSpecificationImpl implements InflationRateSpecification {
		private final Offset inflationLag;
		private final FieldWithMetaString indexSource;
		private final FieldWithMetaString mainPublication;
		private final FieldWithMetaInterpolationMethodEnum interpolationMethod;
		private final BigDecimal initialIndexLevel;
		private final Boolean fallbackBondApplicable;
		private final InflationCalculationMethodEnum calculationMethod;
		private final InflationCalculationStyleEnum calculationStyle;
		private final FinalPrincipalExchangeCalculationEnum finalPrincipalExchangeCalculation;
		
		protected InflationRateSpecificationImpl(InflationRateSpecification.InflationRateSpecificationBuilder builder) {
			super(builder);
			this.inflationLag = ofNullable(builder.getInflationLag()).map(f->f.build()).orElse(null);
			this.indexSource = ofNullable(builder.getIndexSource()).map(f->f.build()).orElse(null);
			this.mainPublication = ofNullable(builder.getMainPublication()).map(f->f.build()).orElse(null);
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.initialIndexLevel = builder.getInitialIndexLevel();
			this.fallbackBondApplicable = builder.getFallbackBondApplicable();
			this.calculationMethod = builder.getCalculationMethod();
			this.calculationStyle = builder.getCalculationStyle();
			this.finalPrincipalExchangeCalculation = builder.getFinalPrincipalExchangeCalculation();
		}
		
		@Override
		@RosettaAttribute("inflationLag")
		@RuneAttribute("inflationLag")
		public Offset getInflationLag() {
			return inflationLag;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		@RuneAttribute("indexSource")
		public FieldWithMetaString getIndexSource() {
			return indexSource;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		@RuneAttribute("mainPublication")
		public FieldWithMetaString getMainPublication() {
			return mainPublication;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public FieldWithMetaInterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		@RuneAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		@RuneAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@RuneAttribute("calculationMethod")
		public InflationCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("calculationStyle")
		@RuneAttribute("calculationStyle")
		public InflationCalculationStyleEnum getCalculationStyle() {
			return calculationStyle;
		}
		
		@Override
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@RuneAttribute("finalPrincipalExchangeCalculation")
		public FinalPrincipalExchangeCalculationEnum getFinalPrincipalExchangeCalculation() {
			return finalPrincipalExchangeCalculation;
		}
		
		@Override
		public InflationRateSpecification build() {
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder toBuilder() {
			InflationRateSpecification.InflationRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRateSpecification.InflationRateSpecificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInflationLag()).ifPresent(builder::setInflationLag);
			ofNullable(getIndexSource()).ifPresent(builder::setIndexSource);
			ofNullable(getMainPublication()).ifPresent(builder::setMainPublication);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getInitialIndexLevel()).ifPresent(builder::setInitialIndexLevel);
			ofNullable(getFallbackBondApplicable()).ifPresent(builder::setFallbackBondApplicable);
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getCalculationStyle()).ifPresent(builder::setCalculationStyle);
			ofNullable(getFinalPrincipalExchangeCalculation()).ifPresent(builder::setFinalPrincipalExchangeCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(calculationStyle, _that.getCalculationStyle())) return false;
			if (!Objects.equals(finalPrincipalExchangeCalculation, _that.getFinalPrincipalExchangeCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationStyle != null ? calculationStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalPrincipalExchangeCalculation != null ? finalPrincipalExchangeCalculation.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateSpecification {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InflationRateSpecification  ***********************/
	class InflationRateSpecificationBuilderImpl extends FloatingRateSpecification.FloatingRateSpecificationBuilderImpl implements InflationRateSpecification.InflationRateSpecificationBuilder {
	
		protected Offset.OffsetBuilder inflationLag;
		protected FieldWithMetaString.FieldWithMetaStringBuilder indexSource;
		protected FieldWithMetaString.FieldWithMetaStringBuilder mainPublication;
		protected FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder interpolationMethod;
		protected BigDecimal initialIndexLevel;
		protected Boolean fallbackBondApplicable;
		protected InflationCalculationMethodEnum calculationMethod;
		protected InflationCalculationStyleEnum calculationStyle;
		protected FinalPrincipalExchangeCalculationEnum finalPrincipalExchangeCalculation;
		
		@Override
		@RosettaAttribute("inflationLag")
		@RuneAttribute("inflationLag")
		public Offset.OffsetBuilder getInflationLag() {
			return inflationLag;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateInflationLag() {
			Offset.OffsetBuilder result;
			if (inflationLag!=null) {
				result = inflationLag;
			}
			else {
				result = inflationLag = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		@RuneAttribute("indexSource")
		public FieldWithMetaString.FieldWithMetaStringBuilder getIndexSource() {
			return indexSource;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIndexSource() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (indexSource!=null) {
				result = indexSource;
			}
			else {
				result = indexSource = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		@RuneAttribute("mainPublication")
		public FieldWithMetaString.FieldWithMetaStringBuilder getMainPublication() {
			return mainPublication;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMainPublication() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (mainPublication!=null) {
				result = mainPublication;
			}
			else {
				result = mainPublication = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder getOrCreateInterpolationMethod() {
			FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = FieldWithMetaInterpolationMethodEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		@RuneAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		@RuneAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@RuneAttribute("calculationMethod")
		public InflationCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("calculationStyle")
		@RuneAttribute("calculationStyle")
		public InflationCalculationStyleEnum getCalculationStyle() {
			return calculationStyle;
		}
		
		@Override
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@RuneAttribute("finalPrincipalExchangeCalculation")
		public FinalPrincipalExchangeCalculationEnum getFinalPrincipalExchangeCalculation() {
			return finalPrincipalExchangeCalculation;
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateOption(ReferenceWithMetaInterestRateIndex _rateOption) {
			this.rateOption = _rateOption == null ? null : _rateOption.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateOptionValue(InterestRateIndex _rateOption) {
			this.getOrCreateRateOption().setValue(_rateOption);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public InflationRateSpecification.InflationRateSpecificationBuilder setSpreadSchedule(SpreadSchedule _spreadSchedule) {
			this.spreadSchedule = _spreadSchedule == null ? null : _spreadSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public InflationRateSpecification.InflationRateSpecificationBuilder setCapRateSchedule(StrikeSchedule _capRateSchedule) {
			this.capRateSchedule = _capRateSchedule == null ? null : _capRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			this.floorRateSchedule = _floorRateSchedule == null ? null : _floorRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public InflationRateSpecification.InflationRateSpecificationBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@RuneAttribute("floatingRateMultiplierSchedule")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@RuneAttribute("rateTreatment")
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@RuneAttribute("calculationParameters")
		public InflationRateSpecification.InflationRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackRate")
		@RuneAttribute("fallbackRate")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFallbackRate(FallbackRateParameters _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("initialRate")
		@RuneAttribute("initialRate")
		public InflationRateSpecification.InflationRateSpecificationBuilder setInitialRate(Price _initialRate) {
			this.initialRate = _initialRate == null ? null : _initialRate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@RuneAttribute("finalRateRounding")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFinalRateRounding(Rounding _finalRateRounding) {
			this.finalRateRounding = _finalRateRounding == null ? null : _finalRateRounding.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public InflationRateSpecification.InflationRateSpecificationBuilder setAveragingMethod(AveragingWeightingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@RuneAttribute("negativeInterestRateTreatment")
		public InflationRateSpecification.InflationRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum _negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = _negativeInterestRateTreatment == null ? null : _negativeInterestRateTreatment;
			return this;
		}
		
		@Override
		@RosettaAttribute("inflationLag")
		@RuneAttribute("inflationLag")
		public InflationRateSpecification.InflationRateSpecificationBuilder setInflationLag(Offset _inflationLag) {
			this.inflationLag = _inflationLag == null ? null : _inflationLag.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		@RuneAttribute("indexSource")
		public InflationRateSpecification.InflationRateSpecificationBuilder setIndexSource(FieldWithMetaString _indexSource) {
			this.indexSource = _indexSource == null ? null : _indexSource.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setIndexSourceValue(String _indexSource) {
			this.getOrCreateIndexSource().setValue(_indexSource);
			return this;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		@RuneAttribute("mainPublication")
		public InflationRateSpecification.InflationRateSpecificationBuilder setMainPublication(FieldWithMetaString _mainPublication) {
			this.mainPublication = _mainPublication == null ? null : _mainPublication.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setMainPublicationValue(String _mainPublication) {
			this.getOrCreateMainPublication().setValue(_mainPublication);
			return this;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethod(FieldWithMetaInterpolationMethodEnum _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethodValue(InterpolationMethodEnum _interpolationMethod) {
			this.getOrCreateInterpolationMethod().setValue(_interpolationMethod);
			return this;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		@RuneAttribute("initialIndexLevel")
		public InflationRateSpecification.InflationRateSpecificationBuilder setInitialIndexLevel(BigDecimal _initialIndexLevel) {
			this.initialIndexLevel = _initialIndexLevel == null ? null : _initialIndexLevel;
			return this;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		@RuneAttribute("fallbackBondApplicable")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFallbackBondApplicable(Boolean _fallbackBondApplicable) {
			this.fallbackBondApplicable = _fallbackBondApplicable == null ? null : _fallbackBondApplicable;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@RuneAttribute("calculationMethod")
		public InflationRateSpecification.InflationRateSpecificationBuilder setCalculationMethod(InflationCalculationMethodEnum _calculationMethod) {
			this.calculationMethod = _calculationMethod == null ? null : _calculationMethod;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationStyle")
		@RuneAttribute("calculationStyle")
		public InflationRateSpecification.InflationRateSpecificationBuilder setCalculationStyle(InflationCalculationStyleEnum _calculationStyle) {
			this.calculationStyle = _calculationStyle == null ? null : _calculationStyle;
			return this;
		}
		
		@Override
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@RuneAttribute("finalPrincipalExchangeCalculation")
		public InflationRateSpecification.InflationRateSpecificationBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculationEnum _finalPrincipalExchangeCalculation) {
			this.finalPrincipalExchangeCalculation = _finalPrincipalExchangeCalculation == null ? null : _finalPrincipalExchangeCalculation;
			return this;
		}
		
		@Override
		public InflationRateSpecification build() {
			return new InflationRateSpecification.InflationRateSpecificationImpl(this);
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder prune() {
			super.prune();
			if (inflationLag!=null && !inflationLag.prune().hasData()) inflationLag = null;
			if (indexSource!=null && !indexSource.prune().hasData()) indexSource = null;
			if (mainPublication!=null && !mainPublication.prune().hasData()) mainPublication = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInflationLag()!=null && getInflationLag().hasData()) return true;
			if (getIndexSource()!=null) return true;
			if (getMainPublication()!=null) return true;
			if (getInterpolationMethod()!=null) return true;
			if (getInitialIndexLevel()!=null) return true;
			if (getFallbackBondApplicable()!=null) return true;
			if (getCalculationMethod()!=null) return true;
			if (getCalculationStyle()!=null) return true;
			if (getFinalPrincipalExchangeCalculation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InflationRateSpecification.InflationRateSpecificationBuilder o = (InflationRateSpecification.InflationRateSpecificationBuilder) other;
			
			merger.mergeRosetta(getInflationLag(), o.getInflationLag(), this::setInflationLag);
			merger.mergeRosetta(getIndexSource(), o.getIndexSource(), this::setIndexSource);
			merger.mergeRosetta(getMainPublication(), o.getMainPublication(), this::setMainPublication);
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			
			merger.mergeBasic(getInitialIndexLevel(), o.getInitialIndexLevel(), this::setInitialIndexLevel);
			merger.mergeBasic(getFallbackBondApplicable(), o.getFallbackBondApplicable(), this::setFallbackBondApplicable);
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			merger.mergeBasic(getCalculationStyle(), o.getCalculationStyle(), this::setCalculationStyle);
			merger.mergeBasic(getFinalPrincipalExchangeCalculation(), o.getFinalPrincipalExchangeCalculation(), this::setFinalPrincipalExchangeCalculation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(calculationStyle, _that.getCalculationStyle())) return false;
			if (!Objects.equals(finalPrincipalExchangeCalculation, _that.getFinalPrincipalExchangeCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationStyle != null ? calculationStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalPrincipalExchangeCalculation != null ? finalPrincipalExchangeCalculation.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateSpecificationBuilder {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}' + " " + super.toString();
		}
	}
}
