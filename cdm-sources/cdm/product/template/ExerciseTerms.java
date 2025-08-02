package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder;
import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.BusinessCenterTime.BusinessCenterTimeBuilder;
import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseFee.ExerciseFeeBuilder;
import cdm.product.template.ExerciseFeeSchedule;
import cdm.product.template.ExerciseFeeSchedule.ExerciseFeeScheduleBuilder;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseProcedure.ExerciseProcedureBuilder;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilder;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilderImpl;
import cdm.product.template.ExerciseTerms.ExerciseTermsImpl;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.MultipleExercise;
import cdm.product.template.MultipleExercise.MultipleExerciseBuilder;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.PartialExercise;
import cdm.product.template.PartialExercise.PartialExerciseBuilder;
import cdm.product.template.meta.ExerciseTermsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining the exercise period for an option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 * @version 6.0.0
 */
@RosettaDataType(value="ExerciseTerms", builder=ExerciseTerms.ExerciseTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ExerciseTerms", model="Just another Rosetta model", builder=ExerciseTerms.ExerciseTermsBuilderImpl.class, version="6.0.0")
public interface ExerciseTerms extends RosettaModelObject, GlobalKey {

	ExerciseTermsMeta metaData = new ExerciseTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Whether the option has a single exercise (european), multiple exercise dates (bermuda), or a continuous range of exercise (american).
	 */
	OptionExerciseStyleEnum getStyle();
	/**
	 * The first day of the exercise period for an American style option.
	 */
	AdjustableOrRelativeDate getCommencementDate();
	/**
	 * The dates that define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
	 */
	AdjustableOrRelativeDates getExerciseDates();
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 */
	List<? extends AdjustableOrRelativeDate> getExpirationDate();
	/**
	 * The effective date on the underlying product if the option is exercised.  For example, for a swaption it is the swap effective date, for an option on an FX spot or forward it is the value date for settlement, and in an extendible/cancelable provision it is the swap termination date, which is the date on which the termination is effective.&#39;
	 */
	AdjustableOrRelativeDates getRelevantUnderlyingDate();
	/**
	 * The earliest time at which notice of exercise can be given by the buyer to the seller (or seller&#39;s agent) to, and including, the expiration date.
	 */
	BusinessCenterTime getEarliestExerciseTime();
	/**
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 * The latest time for exercise on expirationDate. It is made mandatory given that for all option styles, this field is required.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 * The time of day at which the equity option expires, for example the official closing time of the exchange.
	 */
	ExpirationTimeTypeEnum getExpirationTimeType();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 */
	MultipleExercise getMultipleExercise();
	/**
	 * The fees associated with an exercise date. The fees are conditional on the exercise occurring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
	 */
	ExerciseFeeSchedule getExerciseFeeSchedule();
	/**
	 * The set of parameters defining the procedure associated with the exercise, e.g. manual exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
	 */
	ExerciseFee getExerciseFee();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 */
	PartialExercise getPartialExercise();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	ExerciseTerms build();
	
	ExerciseTerms.ExerciseTermsBuilder toBuilder();
	
	static ExerciseTerms.ExerciseTermsBuilder builder() {
		return new ExerciseTerms.ExerciseTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseTerms> getType() {
		return ExerciseTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("style"), OptionExerciseStyleEnum.class, getStyle(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("exerciseDates"), processor, AdjustableOrRelativeDates.class, getExerciseDates());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processor.processBasic(path.newSubPath("expirationTimeType"), ExpirationTimeTypeEnum.class, getExpirationTimeType(), this);
		processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.class, getMultipleExercise());
		processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.class, getExerciseFeeSchedule());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.class, getExerciseFee());
		processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.class, getPartialExercise());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseTermsBuilder extends ExerciseTerms, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExerciseDates();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExerciseDates();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int _index);
		@Override
		List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise();
		@Override
		MultipleExercise.MultipleExerciseBuilder getMultipleExercise();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule();
		@Override
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee();
		@Override
		ExerciseFee.ExerciseFeeBuilder getExerciseFee();
		PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise();
		@Override
		PartialExercise.PartialExerciseBuilder getPartialExercise();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		ExerciseTerms.ExerciseTermsBuilder setStyle(OptionExerciseStyleEnum style);
		ExerciseTerms.ExerciseTermsBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		ExerciseTerms.ExerciseTermsBuilder setExerciseDates(AdjustableOrRelativeDates exerciseDates);
		ExerciseTerms.ExerciseTermsBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate);
		ExerciseTerms.ExerciseTermsBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate, int _idx);
		ExerciseTerms.ExerciseTermsBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate);
		ExerciseTerms.ExerciseTermsBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate);
		ExerciseTerms.ExerciseTermsBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		ExerciseTerms.ExerciseTermsBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		ExerciseTerms.ExerciseTermsBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		ExerciseTerms.ExerciseTermsBuilder setExpirationTime(BusinessCenterTime expirationTime);
		ExerciseTerms.ExerciseTermsBuilder setExpirationTimeType(ExpirationTimeTypeEnum expirationTimeType);
		ExerciseTerms.ExerciseTermsBuilder setMultipleExercise(MultipleExercise multipleExercise);
		ExerciseTerms.ExerciseTermsBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule);
		ExerciseTerms.ExerciseTermsBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		ExerciseTerms.ExerciseTermsBuilder setExerciseFee(ExerciseFee exerciseFee);
		ExerciseTerms.ExerciseTermsBuilder setPartialExercise(PartialExercise partialExercise);
		ExerciseTerms.ExerciseTermsBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("style"), OptionExerciseStyleEnum.class, getStyle(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("exerciseDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getExerciseDates());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processor.processBasic(path.newSubPath("expirationTimeType"), ExpirationTimeTypeEnum.class, getExpirationTimeType(), this);
			processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.MultipleExerciseBuilder.class, getMultipleExercise());
			processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.ExerciseFeeScheduleBuilder.class, getExerciseFeeSchedule());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.ExerciseFeeBuilder.class, getExerciseFee());
			processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.PartialExerciseBuilder.class, getPartialExercise());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		ExerciseTerms.ExerciseTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseTerms  ***********************/
	class ExerciseTermsImpl implements ExerciseTerms {
		private final OptionExerciseStyleEnum style;
		private final AdjustableOrRelativeDate commencementDate;
		private final AdjustableOrRelativeDates exerciseDates;
		private final List<? extends AdjustableOrRelativeDate> expirationDate;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		private final BusinessCenterTime earliestExerciseTime;
		private final BusinessCenterTime latestExerciseTime;
		private final BusinessCenterTime expirationTime;
		private final ExpirationTimeTypeEnum expirationTimeType;
		private final MultipleExercise multipleExercise;
		private final ExerciseFeeSchedule exerciseFeeSchedule;
		private final ExerciseProcedure exerciseProcedure;
		private final ExerciseFee exerciseFee;
		private final PartialExercise partialExercise;
		private final MetaFields meta;
		
		protected ExerciseTermsImpl(ExerciseTerms.ExerciseTermsBuilder builder) {
			this.style = builder.getStyle();
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.exerciseDates = ofNullable(builder.getExerciseDates()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.expirationTimeType = builder.getExpirationTimeType();
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
			this.exerciseFeeSchedule = ofNullable(builder.getExerciseFeeSchedule()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.exerciseFee = ofNullable(builder.getExerciseFee()).map(f->f.build()).orElse(null);
			this.partialExercise = ofNullable(builder.getPartialExercise()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("style")
		@RuneAttribute("style")
		public OptionExerciseStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@RuneAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		@RosettaAttribute("exerciseDates")
		@RuneAttribute("exerciseDates")
		public AdjustableOrRelativeDates getExerciseDates() {
			return exerciseDates;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		@RuneAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		@RuneAttribute("earliestExerciseTime")
		public BusinessCenterTime getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@RuneAttribute("latestExerciseTime")
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@RuneAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("expirationTimeType")
		@RuneAttribute("expirationTimeType")
		public ExpirationTimeTypeEnum getExpirationTimeType() {
			return expirationTimeType;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@RuneAttribute("multipleExercise")
		public MultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		@RuneAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		@RuneAttribute("exerciseFee")
		public ExerciseFee getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		@RosettaAttribute("partialExercise")
		@RuneAttribute("partialExercise")
		public PartialExercise getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ExerciseTerms build() {
			return this;
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder toBuilder() {
			ExerciseTerms.ExerciseTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseTerms.ExerciseTermsBuilder builder) {
			ofNullable(getStyle()).ifPresent(builder::setStyle);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExerciseDates()).ifPresent(builder::setExerciseDates);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getExpirationTimeType()).ifPresent(builder::setExpirationTimeType);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
			ofNullable(getExerciseFeeSchedule()).ifPresent(builder::setExerciseFeeSchedule);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getExerciseFee()).ifPresent(builder::setExerciseFee);
			ofNullable(getPartialExercise()).ifPresent(builder::setPartialExercise);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseTerms _that = getType().cast(o);
		
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseDates, _that.getExerciseDates())) return false;
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(expirationTimeType, _that.getExpirationTimeType())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseDates != null ? exerciseDates.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeType != null ? expirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseTerms {" +
				"style=" + this.style + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseDates=" + this.exerciseDates + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"expirationTimeType=" + this.expirationTimeType + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"exerciseFee=" + this.exerciseFee + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseTerms  ***********************/
	class ExerciseTermsBuilderImpl implements ExerciseTerms.ExerciseTermsBuilder {
	
		protected OptionExerciseStyleEnum style;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder exerciseDates;
		protected List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> expirationDate = new ArrayList<>();
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected ExpirationTimeTypeEnum expirationTimeType;
		protected MultipleExercise.MultipleExerciseBuilder multipleExercise;
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected ExerciseFee.ExerciseFeeBuilder exerciseFee;
		protected PartialExercise.PartialExerciseBuilder partialExercise;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("style")
		@RuneAttribute("style")
		public OptionExerciseStyleEnum getStyle() {
			return style;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@RuneAttribute("commencementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseDates")
		@RuneAttribute("exerciseDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExerciseDates() {
			return exerciseDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExerciseDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (exerciseDates!=null) {
				result = exerciseDates;
			}
			else {
				result = exerciseDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int _index) {
		
			if (expirationDate==null) {
				this.expirationDate = new ArrayList<>();
			}
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			return getIndex(expirationDate, _index, () -> {
						AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder newExpirationDate = AdjustableOrRelativeDate.builder();
						return newExpirationDate;
					});
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		@RuneAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDate!=null) {
				result = relevantUnderlyingDate;
			}
			else {
				result = relevantUnderlyingDate = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		@RuneAttribute("earliestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExerciseTime!=null) {
				result = earliestExerciseTime;
			}
			else {
				result = earliestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@RuneAttribute("latestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@RuneAttribute("expirationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTimeType")
		@RuneAttribute("expirationTimeType")
		public ExpirationTimeTypeEnum getExpirationTimeType() {
			return expirationTimeType;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@RuneAttribute("multipleExercise")
		public MultipleExercise.MultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise() {
			MultipleExercise.MultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = MultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		@RuneAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder result;
			if (exerciseFeeSchedule!=null) {
				result = exerciseFeeSchedule;
			}
			else {
				result = exerciseFeeSchedule = ExerciseFeeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		@RuneAttribute("exerciseFee")
		public ExerciseFee.ExerciseFeeBuilder getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee() {
			ExerciseFee.ExerciseFeeBuilder result;
			if (exerciseFee!=null) {
				result = exerciseFee;
			}
			else {
				result = exerciseFee = ExerciseFee.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partialExercise")
		@RuneAttribute("partialExercise")
		public PartialExercise.PartialExerciseBuilder getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise() {
			PartialExercise.PartialExerciseBuilder result;
			if (partialExercise!=null) {
				result = partialExercise;
			}
			else {
				result = partialExercise = PartialExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("style")
		@RuneAttribute("style")
		public ExerciseTerms.ExerciseTermsBuilder setStyle(OptionExerciseStyleEnum _style) {
			this.style = _style == null ? null : _style;
			return this;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@RuneAttribute("commencementDate")
		public ExerciseTerms.ExerciseTermsBuilder setCommencementDate(AdjustableOrRelativeDate _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseDates")
		@RuneAttribute("exerciseDates")
		public ExerciseTerms.ExerciseTermsBuilder setExerciseDates(AdjustableOrRelativeDates _exerciseDates) {
			this.exerciseDates = _exerciseDates == null ? null : _exerciseDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public ExerciseTerms.ExerciseTermsBuilder addExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			if (_expirationDate != null) {
				this.expirationDate.add(_expirationDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder addExpirationDate(AdjustableOrRelativeDate _expirationDate, int _idx) {
			getIndex(this.expirationDate, _idx, () -> _expirationDate.toBuilder());
			return this;
		}
		
		@Override 
		public ExerciseTerms.ExerciseTermsBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates != null) {
				for (final AdjustableOrRelativeDate toAdd : expirationDates) {
					this.expirationDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("expirationDate")
		public ExerciseTerms.ExerciseTermsBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates == null) {
				this.expirationDate = new ArrayList<>();
			} else {
				this.expirationDate = expirationDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		@RuneAttribute("relevantUnderlyingDate")
		public ExerciseTerms.ExerciseTermsBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates _relevantUnderlyingDate) {
			this.relevantUnderlyingDate = _relevantUnderlyingDate == null ? null : _relevantUnderlyingDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		@RuneAttribute("earliestExerciseTime")
		public ExerciseTerms.ExerciseTermsBuilder setEarliestExerciseTime(BusinessCenterTime _earliestExerciseTime) {
			this.earliestExerciseTime = _earliestExerciseTime == null ? null : _earliestExerciseTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@RuneAttribute("latestExerciseTime")
		public ExerciseTerms.ExerciseTermsBuilder setLatestExerciseTime(BusinessCenterTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@RuneAttribute("expirationTime")
		public ExerciseTerms.ExerciseTermsBuilder setExpirationTime(BusinessCenterTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationTimeType")
		@RuneAttribute("expirationTimeType")
		public ExerciseTerms.ExerciseTermsBuilder setExpirationTimeType(ExpirationTimeTypeEnum _expirationTimeType) {
			this.expirationTimeType = _expirationTimeType == null ? null : _expirationTimeType;
			return this;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@RuneAttribute("multipleExercise")
		public ExerciseTerms.ExerciseTermsBuilder setMultipleExercise(MultipleExercise _multipleExercise) {
			this.multipleExercise = _multipleExercise == null ? null : _multipleExercise.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		@RuneAttribute("exerciseFeeSchedule")
		public ExerciseTerms.ExerciseTermsBuilder setExerciseFeeSchedule(ExerciseFeeSchedule _exerciseFeeSchedule) {
			this.exerciseFeeSchedule = _exerciseFeeSchedule == null ? null : _exerciseFeeSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@RuneAttribute("exerciseProcedure")
		public ExerciseTerms.ExerciseTermsBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		@RuneAttribute("exerciseFee")
		public ExerciseTerms.ExerciseTermsBuilder setExerciseFee(ExerciseFee _exerciseFee) {
			this.exerciseFee = _exerciseFee == null ? null : _exerciseFee.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("partialExercise")
		@RuneAttribute("partialExercise")
		public ExerciseTerms.ExerciseTermsBuilder setPartialExercise(PartialExercise _partialExercise) {
			this.partialExercise = _partialExercise == null ? null : _partialExercise.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public ExerciseTerms.ExerciseTermsBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseTerms build() {
			return new ExerciseTerms.ExerciseTermsImpl(this);
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseTerms.ExerciseTermsBuilder prune() {
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (exerciseDates!=null && !exerciseDates.prune().hasData()) exerciseDates = null;
			expirationDate = expirationDate.stream().filter(b->b!=null).<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			if (exerciseFeeSchedule!=null && !exerciseFeeSchedule.prune().hasData()) exerciseFeeSchedule = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (exerciseFee!=null && !exerciseFee.prune().hasData()) exerciseFee = null;
			if (partialExercise!=null && !partialExercise.prune().hasData()) partialExercise = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStyle()!=null) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExerciseDates()!=null && getExerciseDates().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getExpirationTimeType()!=null) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			if (getExerciseFeeSchedule()!=null && getExerciseFeeSchedule().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getExerciseFee()!=null && getExerciseFee().hasData()) return true;
			if (getPartialExercise()!=null && getPartialExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseTerms.ExerciseTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseTerms.ExerciseTermsBuilder o = (ExerciseTerms.ExerciseTermsBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExerciseDates(), o.getExerciseDates(), this::setExerciseDates);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::getOrCreateExpirationDate);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			merger.mergeRosetta(getExerciseFeeSchedule(), o.getExerciseFeeSchedule(), this::setExerciseFeeSchedule);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getExerciseFee(), o.getExerciseFee(), this::setExerciseFee);
			merger.mergeRosetta(getPartialExercise(), o.getPartialExercise(), this::setPartialExercise);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getStyle(), o.getStyle(), this::setStyle);
			merger.mergeBasic(getExpirationTimeType(), o.getExpirationTimeType(), this::setExpirationTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseTerms _that = getType().cast(o);
		
			if (!Objects.equals(style, _that.getStyle())) return false;
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(exerciseDates, _that.getExerciseDates())) return false;
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(expirationTimeType, _that.getExpirationTimeType())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (style != null ? style.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (exerciseDates != null ? exerciseDates.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeType != null ? expirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseTermsBuilder {" +
				"style=" + this.style + ", " +
				"commencementDate=" + this.commencementDate + ", " +
				"exerciseDates=" + this.exerciseDates + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"expirationTimeType=" + this.expirationTimeType + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"exerciseFee=" + this.exerciseFee + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
