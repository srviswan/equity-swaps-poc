package cdm.product.common.schedule;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.BusinessCenterTime.BusinessCenterTimeBuilder;
import cdm.base.math.Rounding;
import cdm.base.math.Rounding.RoundingBuilder;
import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.asset.FxSpotRateSource.FxSpotRateSourceBuilder;
import cdm.observable.common.TimeTypeEnum;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDatesBuilder;
import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ObservationDates.ObservationDatesBuilder;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsBuilder;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsBuilderImpl;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsImpl;
import cdm.product.common.schedule.meta.ObservationTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Class containing terms that are associated with observing a price/benchmark/index across either single or multiple observations. 
 * @version 6.0.0
 */
@RosettaDataType(value="ObservationTerms", builder=ObservationTerms.ObservationTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ObservationTerms", model="Just another Rosetta model", builder=ObservationTerms.ObservationTermsBuilderImpl.class, version="6.0.0")
public interface ObservationTerms extends RosettaModelObject {

	ObservationTermsMeta metaData = new ObservationTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines time in respect to a business calendar location that the price/benchmark/index is observed
	 */
	BusinessCenterTime getObservationTime();
	/**
	 * The enumerated values to specify points in the day when option exercise and valuation can occur.
	 */
	TimeTypeEnum getObservationTimeType();
	/**
	 * The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 */
	FxSpotRateSource getInformationSource();
	/**
	 * Defines rounding rules and precision to be used in the rounding of observations.
	 */
	Rounding getPrecision();
	/**
	 * Defines parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 * Describes date details for a set of observation dates in parametric or non-parametric form.
	 */
	ObservationDates getObservationDates();
	/**
	 * The number of observation dates between observation start date and observation end date.
	 */
	Integer getNumberOfObservationDates();

	/*********************** Build Methods  ***********************/
	ObservationTerms build();
	
	ObservationTerms.ObservationTermsBuilder toBuilder();
	
	static ObservationTerms.ObservationTermsBuilder builder() {
		return new ObservationTerms.ObservationTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationTerms> getType() {
		return ObservationTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processor.processBasic(path.newSubPath("observationTimeType"), TimeTypeEnum.class, getObservationTimeType(), this);
		processRosetta(path.newSubPath("informationSource"), processor, FxSpotRateSource.class, getInformationSource());
		processRosetta(path.newSubPath("precision"), processor, Rounding.class, getPrecision());
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("observationDates"), processor, ObservationDates.class, getObservationDates());
		processor.processBasic(path.newSubPath("numberOfObservationDates"), Integer.class, getNumberOfObservationDates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationTermsBuilder extends ObservationTerms, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateInformationSource();
		@Override
		FxSpotRateSource.FxSpotRateSourceBuilder getInformationSource();
		Rounding.RoundingBuilder getOrCreatePrecision();
		@Override
		Rounding.RoundingBuilder getPrecision();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		@Override
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		ObservationDates.ObservationDatesBuilder getOrCreateObservationDates();
		@Override
		ObservationDates.ObservationDatesBuilder getObservationDates();
		ObservationTerms.ObservationTermsBuilder setObservationTime(BusinessCenterTime observationTime);
		ObservationTerms.ObservationTermsBuilder setObservationTimeType(TimeTypeEnum observationTimeType);
		ObservationTerms.ObservationTermsBuilder setInformationSource(FxSpotRateSource informationSource);
		ObservationTerms.ObservationTermsBuilder setPrecision(Rounding precision);
		ObservationTerms.ObservationTermsBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		ObservationTerms.ObservationTermsBuilder setObservationDates(ObservationDates observationDates);
		ObservationTerms.ObservationTermsBuilder setNumberOfObservationDates(Integer numberOfObservationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processor.processBasic(path.newSubPath("observationTimeType"), TimeTypeEnum.class, getObservationTimeType(), this);
			processRosetta(path.newSubPath("informationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("precision"), processor, Rounding.RoundingBuilder.class, getPrecision());
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("observationDates"), processor, ObservationDates.ObservationDatesBuilder.class, getObservationDates());
			processor.processBasic(path.newSubPath("numberOfObservationDates"), Integer.class, getNumberOfObservationDates(), this);
		}
		

		ObservationTerms.ObservationTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationTerms  ***********************/
	class ObservationTermsImpl implements ObservationTerms {
		private final BusinessCenterTime observationTime;
		private final TimeTypeEnum observationTimeType;
		private final FxSpotRateSource informationSource;
		private final Rounding precision;
		private final CalculationPeriodDates calculationPeriodDates;
		private final ObservationDates observationDates;
		private final Integer numberOfObservationDates;
		
		protected ObservationTermsImpl(ObservationTerms.ObservationTermsBuilder builder) {
			this.observationTime = ofNullable(builder.getObservationTime()).map(f->f.build()).orElse(null);
			this.observationTimeType = builder.getObservationTimeType();
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.precision = ofNullable(builder.getPrecision()).map(f->f.build()).orElse(null);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.observationDates = ofNullable(builder.getObservationDates()).map(f->f.build()).orElse(null);
			this.numberOfObservationDates = builder.getNumberOfObservationDates();
		}
		
		@Override
		@RosettaAttribute("observationTime")
		@RuneAttribute("observationTime")
		public BusinessCenterTime getObservationTime() {
			return observationTime;
		}
		
		@Override
		@RosettaAttribute("observationTimeType")
		@RuneAttribute("observationTimeType")
		public TimeTypeEnum getObservationTimeType() {
			return observationTimeType;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@RuneAttribute("informationSource")
		public FxSpotRateSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public Rounding getPrecision() {
			return precision;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public ObservationDates getObservationDates() {
			return observationDates;
		}
		
		@Override
		@RosettaAttribute("numberOfObservationDates")
		@RuneAttribute("numberOfObservationDates")
		public Integer getNumberOfObservationDates() {
			return numberOfObservationDates;
		}
		
		@Override
		public ObservationTerms build() {
			return this;
		}
		
		@Override
		public ObservationTerms.ObservationTermsBuilder toBuilder() {
			ObservationTerms.ObservationTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationTerms.ObservationTermsBuilder builder) {
			ofNullable(getObservationTime()).ifPresent(builder::setObservationTime);
			ofNullable(getObservationTimeType()).ifPresent(builder::setObservationTimeType);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getObservationDates()).ifPresent(builder::setObservationDates);
			ofNullable(getNumberOfObservationDates()).ifPresent(builder::setNumberOfObservationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationTerms _that = getType().cast(o);
		
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(observationTimeType, _that.getObservationTimeType())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(observationDates, _that.getObservationDates())) return false;
			if (!Objects.equals(numberOfObservationDates, _that.getNumberOfObservationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (observationTimeType != null ? observationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (numberOfObservationDates != null ? numberOfObservationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationTerms {" +
				"observationTime=" + this.observationTime + ", " +
				"observationTimeType=" + this.observationTimeType + ", " +
				"informationSource=" + this.informationSource + ", " +
				"precision=" + this.precision + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"observationDates=" + this.observationDates + ", " +
				"numberOfObservationDates=" + this.numberOfObservationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationTerms  ***********************/
	class ObservationTermsBuilderImpl implements ObservationTerms.ObservationTermsBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationTime;
		protected TimeTypeEnum observationTimeType;
		protected FxSpotRateSource.FxSpotRateSourceBuilder informationSource;
		protected Rounding.RoundingBuilder precision;
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected ObservationDates.ObservationDatesBuilder observationDates;
		protected Integer numberOfObservationDates;
		
		@Override
		@RosettaAttribute("observationTime")
		@RuneAttribute("observationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime() {
			return observationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationTime!=null) {
				result = observationTime;
			}
			else {
				result = observationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationTimeType")
		@RuneAttribute("observationTimeType")
		public TimeTypeEnum getObservationTimeType() {
			return observationTimeType;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@RuneAttribute("informationSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateInformationSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public Rounding.RoundingBuilder getPrecision() {
			return precision;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreatePrecision() {
			Rounding.RoundingBuilder result;
			if (precision!=null) {
				result = precision;
			}
			else {
				result = precision = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public ObservationDates.ObservationDatesBuilder getObservationDates() {
			return observationDates;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder getOrCreateObservationDates() {
			ObservationDates.ObservationDatesBuilder result;
			if (observationDates!=null) {
				result = observationDates;
			}
			else {
				result = observationDates = ObservationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfObservationDates")
		@RuneAttribute("numberOfObservationDates")
		public Integer getNumberOfObservationDates() {
			return numberOfObservationDates;
		}
		
		@Override
		@RosettaAttribute("observationTime")
		@RuneAttribute("observationTime")
		public ObservationTerms.ObservationTermsBuilder setObservationTime(BusinessCenterTime _observationTime) {
			this.observationTime = _observationTime == null ? null : _observationTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationTimeType")
		@RuneAttribute("observationTimeType")
		public ObservationTerms.ObservationTermsBuilder setObservationTimeType(TimeTypeEnum _observationTimeType) {
			this.observationTimeType = _observationTimeType == null ? null : _observationTimeType;
			return this;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@RuneAttribute("informationSource")
		public ObservationTerms.ObservationTermsBuilder setInformationSource(FxSpotRateSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public ObservationTerms.ObservationTermsBuilder setPrecision(Rounding _precision) {
			this.precision = _precision == null ? null : _precision.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public ObservationTerms.ObservationTermsBuilder setCalculationPeriodDates(CalculationPeriodDates _calculationPeriodDates) {
			this.calculationPeriodDates = _calculationPeriodDates == null ? null : _calculationPeriodDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public ObservationTerms.ObservationTermsBuilder setObservationDates(ObservationDates _observationDates) {
			this.observationDates = _observationDates == null ? null : _observationDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("numberOfObservationDates")
		@RuneAttribute("numberOfObservationDates")
		public ObservationTerms.ObservationTermsBuilder setNumberOfObservationDates(Integer _numberOfObservationDates) {
			this.numberOfObservationDates = _numberOfObservationDates == null ? null : _numberOfObservationDates;
			return this;
		}
		
		@Override
		public ObservationTerms build() {
			return new ObservationTerms.ObservationTermsImpl(this);
		}
		
		@Override
		public ObservationTerms.ObservationTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationTerms.ObservationTermsBuilder prune() {
			if (observationTime!=null && !observationTime.prune().hasData()) observationTime = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (precision!=null && !precision.prune().hasData()) precision = null;
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (observationDates!=null && !observationDates.prune().hasData()) observationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationTime()!=null && getObservationTime().hasData()) return true;
			if (getObservationTimeType()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getPrecision()!=null && getPrecision().hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getObservationDates()!=null && getObservationDates().hasData()) return true;
			if (getNumberOfObservationDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationTerms.ObservationTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationTerms.ObservationTermsBuilder o = (ObservationTerms.ObservationTermsBuilder) other;
			
			merger.mergeRosetta(getObservationTime(), o.getObservationTime(), this::setObservationTime);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getPrecision(), o.getPrecision(), this::setPrecision);
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getObservationDates(), o.getObservationDates(), this::setObservationDates);
			
			merger.mergeBasic(getObservationTimeType(), o.getObservationTimeType(), this::setObservationTimeType);
			merger.mergeBasic(getNumberOfObservationDates(), o.getNumberOfObservationDates(), this::setNumberOfObservationDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationTerms _that = getType().cast(o);
		
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(observationTimeType, _that.getObservationTimeType())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(observationDates, _that.getObservationDates())) return false;
			if (!Objects.equals(numberOfObservationDates, _that.getNumberOfObservationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (observationTimeType != null ? observationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (numberOfObservationDates != null ? numberOfObservationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationTermsBuilder {" +
				"observationTime=" + this.observationTime + ", " +
				"observationTimeType=" + this.observationTimeType + ", " +
				"informationSource=" + this.informationSource + ", " +
				"precision=" + this.precision + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"observationDates=" + this.observationDates + ", " +
				"numberOfObservationDates=" + this.numberOfObservationDates +
			'}';
		}
	}
}
