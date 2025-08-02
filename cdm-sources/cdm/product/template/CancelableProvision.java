package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder;
import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.BusinessCenterTime.BusinessCenterTimeBuilder;
import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder;
import cdm.product.template.CallingPartyEnum;
import cdm.product.template.CancelableProvision;
import cdm.product.template.CancelableProvision.CancelableProvisionBuilder;
import cdm.product.template.CancelableProvision.CancelableProvisionBuilderImpl;
import cdm.product.template.CancelableProvision.CancelableProvisionImpl;
import cdm.product.template.CancelableProvisionAdjustedDates;
import cdm.product.template.CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseNotice.ExerciseNoticeBuilder;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilder;
import cdm.product.template.meta.CancelableProvisionMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for &#39;walk-away&#39; cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified. As a difference from the FpML construct, the canonical model extends the BuyerSeller class.
 * @version 6.0.0
 */
@RosettaDataType(value="CancelableProvision", builder=CancelableProvision.CancelableProvisionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CancelableProvision", model="Just another Rosetta model", builder=CancelableProvision.CancelableProvisionBuilderImpl.class, version="6.0.0")
public interface CancelableProvision extends BuyerSeller {

	CancelableProvisionMeta metaData = new CancelableProvisionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	ExerciseNotice getExerciseNotice();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
	 */
	CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates();
	/**
	 * Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC&#39;s or they can be specified separately.
	 */
	List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment();
	/**
	 * An initial fee for the cancelable option.
	 */
	Transfer getInitialFee();
	/**
	 * The party with right to exercise a cancellation. Allows for buyer, seller or either.
	 */
	CallingPartyEnum getCallingParty();
	/**
	 * The first day when cancelation is permitted to take effect. A party may give notice prior to this date and taken together with the effective period would be necessary to cancel on this date.
	 */
	AdjustableOrRelativeDate getEarliestDate();
	/**
	 * The last day within the term of the contract that cancelation is allowed.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	/**
	 * The effective date if cancelation is invoked otherwise the cancellation period defines the cancellation date.
	 */
	AdjustableOrRelativeDates getEffectiveDate();
	/**
	 * Effective period for cancelation when notice is given. This is the period after notice is given that cancellation becomes effecticve.
	 */
	Period getEffectivePeriod();
	/**
	 * The earliest time in a business day that notice of cancelation can be given.
	 */
	BusinessCenterTime getEarliestCancellationTime();
	/**
	 * The latest time at which notice of cancelation can be given.
	 */
	BusinessCenterTime getLatestCancelationTime();
	/**
	 * The exercise terms associated with the cancelable provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the cancellation of the swap transaction.
	 */
	ExerciseTerms getExerciseTerms();

	/*********************** Build Methods  ***********************/
	CancelableProvision build();
	
	CancelableProvision.CancelableProvisionBuilder toBuilder();
	
	static CancelableProvision.CancelableProvisionBuilder builder() {
		return new CancelableProvision.CancelableProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancelableProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CancelableProvision> getType() {
		return CancelableProvision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
		processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.class, getCancelableProvisionAdjustedDates());
		processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.class, getFinalCalculationPeriodDateAdjustment());
		processRosetta(path.newSubPath("initialFee"), processor, Transfer.class, getInitialFee());
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processRosetta(path.newSubPath("earliestDate"), processor, AdjustableOrRelativeDate.class, getEarliestDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDates.class, getEffectiveDate());
		processRosetta(path.newSubPath("effectivePeriod"), processor, Period.class, getEffectivePeriod());
		processRosetta(path.newSubPath("earliestCancellationTime"), processor, BusinessCenterTime.class, getEarliestCancellationTime());
		processRosetta(path.newSubPath("latestCancelationTime"), processor, BusinessCenterTime.class, getLatestCancelationTime());
		processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.class, getExerciseTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancelableProvisionBuilder extends CancelableProvision, BuyerSeller.BuyerSellerBuilder {
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		@Override
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates();
		@Override
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index);
		@Override
		List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment();
		Transfer.TransferBuilder getOrCreateInitialFee();
		@Override
		Transfer.TransferBuilder getInitialFee();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEarliestDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEarliestDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getEffectiveDate();
		Period.PeriodBuilder getOrCreateEffectivePeriod();
		@Override
		Period.PeriodBuilder getEffectivePeriod();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestCancellationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestCancellationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestCancelationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestCancelationTime();
		ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms();
		@Override
		ExerciseTerms.ExerciseTermsBuilder getExerciseTerms();
		@Override
		CancelableProvision.CancelableProvisionBuilder setBuyer(CounterpartyRoleEnum buyer);
		@Override
		CancelableProvision.CancelableProvisionBuilder setSeller(CounterpartyRoleEnum seller);
		CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment, int _idx);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setInitialFee(Transfer initialFee);
		CancelableProvision.CancelableProvisionBuilder setCallingParty(CallingPartyEnum callingParty);
		CancelableProvision.CancelableProvisionBuilder setEarliestDate(AdjustableOrRelativeDate earliestDate);
		CancelableProvision.CancelableProvisionBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		CancelableProvision.CancelableProvisionBuilder setEffectiveDate(AdjustableOrRelativeDates effectiveDate);
		CancelableProvision.CancelableProvisionBuilder setEffectivePeriod(Period effectivePeriod);
		CancelableProvision.CancelableProvisionBuilder setEarliestCancellationTime(BusinessCenterTime earliestCancellationTime);
		CancelableProvision.CancelableProvisionBuilder setLatestCancelationTime(BusinessCenterTime latestCancelationTime);
		CancelableProvision.CancelableProvisionBuilder setExerciseTerms(ExerciseTerms exerciseTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
			processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder.class, getCancelableProvisionAdjustedDates());
			processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder.class, getFinalCalculationPeriodDateAdjustment());
			processRosetta(path.newSubPath("initialFee"), processor, Transfer.TransferBuilder.class, getInitialFee());
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processRosetta(path.newSubPath("earliestDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEarliestDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("effectivePeriod"), processor, Period.PeriodBuilder.class, getEffectivePeriod());
			processRosetta(path.newSubPath("earliestCancellationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestCancellationTime());
			processRosetta(path.newSubPath("latestCancelationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestCancelationTime());
			processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.ExerciseTermsBuilder.class, getExerciseTerms());
		}
		

		CancelableProvision.CancelableProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of CancelableProvision  ***********************/
	class CancelableProvisionImpl extends BuyerSeller.BuyerSellerImpl implements CancelableProvision {
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates;
		private final List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment;
		private final Transfer initialFee;
		private final CallingPartyEnum callingParty;
		private final AdjustableOrRelativeDate earliestDate;
		private final AdjustableOrRelativeDate expirationDate;
		private final AdjustableOrRelativeDates effectiveDate;
		private final Period effectivePeriod;
		private final BusinessCenterTime earliestCancellationTime;
		private final BusinessCenterTime latestCancelationTime;
		private final ExerciseTerms exerciseTerms;
		
		protected CancelableProvisionImpl(CancelableProvision.CancelableProvisionBuilder builder) {
			super(builder);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.cancelableProvisionAdjustedDates = ofNullable(builder.getCancelableProvisionAdjustedDates()).map(f->f.build()).orElse(null);
			this.finalCalculationPeriodDateAdjustment = ofNullable(builder.getFinalCalculationPeriodDateAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialFee = ofNullable(builder.getInitialFee()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.earliestDate = ofNullable(builder.getEarliestDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.effectivePeriod = ofNullable(builder.getEffectivePeriod()).map(f->f.build()).orElse(null);
			this.earliestCancellationTime = ofNullable(builder.getEarliestCancellationTime()).map(f->f.build()).orElse(null);
			this.latestCancelationTime = ofNullable(builder.getLatestCancelationTime()).map(f->f.build()).orElse(null);
			this.exerciseTerms = ofNullable(builder.getExerciseTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@RuneAttribute("exerciseNotice")
		public ExerciseNotice getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@RuneAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@RuneAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		@RosettaAttribute("initialFee")
		@RuneAttribute("initialFee")
		public Transfer getInitialFee() {
			return initialFee;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@RuneAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("earliestDate")
		@RuneAttribute("earliestDate")
		public AdjustableOrRelativeDate getEarliestDate() {
			return earliestDate;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDates getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("effectivePeriod")
		@RuneAttribute("effectivePeriod")
		public Period getEffectivePeriod() {
			return effectivePeriod;
		}
		
		@Override
		@RosettaAttribute("earliestCancellationTime")
		@RuneAttribute("earliestCancellationTime")
		public BusinessCenterTime getEarliestCancellationTime() {
			return earliestCancellationTime;
		}
		
		@Override
		@RosettaAttribute("latestCancelationTime")
		@RuneAttribute("latestCancelationTime")
		public BusinessCenterTime getLatestCancelationTime() {
			return latestCancelationTime;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExerciseTerms getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public CancelableProvision build() {
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			CancelableProvision.CancelableProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancelableProvision.CancelableProvisionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getCancelableProvisionAdjustedDates()).ifPresent(builder::setCancelableProvisionAdjustedDates);
			ofNullable(getFinalCalculationPeriodDateAdjustment()).ifPresent(builder::setFinalCalculationPeriodDateAdjustment);
			ofNullable(getInitialFee()).ifPresent(builder::setInitialFee);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getEarliestDate()).ifPresent(builder::setEarliestDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEffectivePeriod()).ifPresent(builder::setEffectivePeriod);
			ofNullable(getEarliestCancellationTime()).ifPresent(builder::setEarliestCancellationTime);
			ofNullable(getLatestCancelationTime()).ifPresent(builder::setLatestCancelationTime);
			ofNullable(getExerciseTerms()).ifPresent(builder::setExerciseTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(earliestDate, _that.getEarliestDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(effectivePeriod, _that.getEffectivePeriod())) return false;
			if (!Objects.equals(earliestCancellationTime, _that.getEarliestCancellationTime())) return false;
			if (!Objects.equals(latestCancelationTime, _that.getLatestCancelationTime())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earliestDate != null ? earliestDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (effectivePeriod != null ? effectivePeriod.hashCode() : 0);
			_result = 31 * _result + (earliestCancellationTime != null ? earliestCancellationTime.hashCode() : 0);
			_result = 31 * _result + (latestCancelationTime != null ? latestCancelationTime.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvision {" +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee + ", " +
				"callingParty=" + this.callingParty + ", " +
				"earliestDate=" + this.earliestDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"effectivePeriod=" + this.effectivePeriod + ", " +
				"earliestCancellationTime=" + this.earliestCancellationTime + ", " +
				"latestCancelationTime=" + this.latestCancelationTime + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CancelableProvision  ***********************/
	class CancelableProvisionBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl implements CancelableProvision.CancelableProvisionBuilder {
	
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates;
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustment = new ArrayList<>();
		protected Transfer.TransferBuilder initialFee;
		protected CallingPartyEnum callingParty;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder earliestDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder effectiveDate;
		protected Period.PeriodBuilder effectivePeriod;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestCancellationTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestCancelationTime;
		protected ExerciseTerms.ExerciseTermsBuilder exerciseTerms;
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@RuneAttribute("exerciseNotice")
		public ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice() {
			ExerciseNotice.ExerciseNoticeBuilder result;
			if (exerciseNotice!=null) {
				result = exerciseNotice;
			}
			else {
				result = exerciseNotice = ExerciseNotice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@RuneAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@RuneAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates() {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder result;
			if (cancelableProvisionAdjustedDates!=null) {
				result = cancelableProvisionAdjustedDates;
			}
			else {
				result = cancelableProvisionAdjustedDates = CancelableProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int _index) {
		
			if (finalCalculationPeriodDateAdjustment==null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder result;
			return getIndex(finalCalculationPeriodDateAdjustment, _index, () -> {
						FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder newFinalCalculationPeriodDateAdjustment = FinalCalculationPeriodDateAdjustment.builder();
						return newFinalCalculationPeriodDateAdjustment;
					});
		}
		
		@Override
		@RosettaAttribute("initialFee")
		@RuneAttribute("initialFee")
		public Transfer.TransferBuilder getInitialFee() {
			return initialFee;
		}
		
		@Override
		public Transfer.TransferBuilder getOrCreateInitialFee() {
			Transfer.TransferBuilder result;
			if (initialFee!=null) {
				result = initialFee;
			}
			else {
				result = initialFee = Transfer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@RuneAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("earliestDate")
		@RuneAttribute("earliestDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEarliestDate() {
			return earliestDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEarliestDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (earliestDate!=null) {
				result = earliestDate;
			}
			else {
				result = earliestDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectivePeriod")
		@RuneAttribute("effectivePeriod")
		public Period.PeriodBuilder getEffectivePeriod() {
			return effectivePeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateEffectivePeriod() {
			Period.PeriodBuilder result;
			if (effectivePeriod!=null) {
				result = effectivePeriod;
			}
			else {
				result = effectivePeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestCancellationTime")
		@RuneAttribute("earliestCancellationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestCancellationTime() {
			return earliestCancellationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestCancellationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestCancellationTime!=null) {
				result = earliestCancellationTime;
			}
			else {
				result = earliestCancellationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestCancelationTime")
		@RuneAttribute("latestCancelationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestCancelationTime() {
			return latestCancelationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestCancelationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestCancelationTime!=null) {
				result = latestCancelationTime;
			}
			else {
				result = latestCancelationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExerciseTerms.ExerciseTermsBuilder getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms() {
			ExerciseTerms.ExerciseTermsBuilder result;
			if (exerciseTerms!=null) {
				result = exerciseTerms;
			}
			else {
				result = exerciseTerms = ExerciseTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyer")
		@RuneAttribute("buyer")
		public CancelableProvision.CancelableProvisionBuilder setBuyer(CounterpartyRoleEnum _buyer) {
			this.buyer = _buyer == null ? null : _buyer;
			return this;
		}
		
		@Override
		@RosettaAttribute("seller")
		@RuneAttribute("seller")
		public CancelableProvision.CancelableProvisionBuilder setSeller(CounterpartyRoleEnum _seller) {
			this.seller = _seller == null ? null : _seller;
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@RuneAttribute("exerciseNotice")
		public CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice _exerciseNotice) {
			this.exerciseNotice = _exerciseNotice == null ? null : _exerciseNotice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@RuneAttribute("followUpConfirmation")
		public CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean _followUpConfirmation) {
			this.followUpConfirmation = _followUpConfirmation == null ? null : _followUpConfirmation;
			return this;
		}
		
		@Override
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@RuneAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates _cancelableProvisionAdjustedDates) {
			this.cancelableProvisionAdjustedDates = _cancelableProvisionAdjustedDates == null ? null : _cancelableProvisionAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment _finalCalculationPeriodDateAdjustment) {
			if (_finalCalculationPeriodDateAdjustment != null) {
				this.finalCalculationPeriodDateAdjustment.add(_finalCalculationPeriodDateAdjustment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment _finalCalculationPeriodDateAdjustment, int _idx) {
			getIndex(this.finalCalculationPeriodDateAdjustment, _idx, () -> _finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		
		@Override 
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments != null) {
				for (final FinalCalculationPeriodDateAdjustment toAdd : finalCalculationPeriodDateAdjustments) {
					this.finalCalculationPeriodDateAdjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments == null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			} else {
				this.finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialFee")
		@RuneAttribute("initialFee")
		public CancelableProvision.CancelableProvisionBuilder setInitialFee(Transfer _initialFee) {
			this.initialFee = _initialFee == null ? null : _initialFee.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@RuneAttribute("callingParty")
		public CancelableProvision.CancelableProvisionBuilder setCallingParty(CallingPartyEnum _callingParty) {
			this.callingParty = _callingParty == null ? null : _callingParty;
			return this;
		}
		
		@Override
		@RosettaAttribute("earliestDate")
		@RuneAttribute("earliestDate")
		public CancelableProvision.CancelableProvisionBuilder setEarliestDate(AdjustableOrRelativeDate _earliestDate) {
			this.earliestDate = _earliestDate == null ? null : _earliestDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@RuneAttribute("expirationDate")
		public CancelableProvision.CancelableProvisionBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public CancelableProvision.CancelableProvisionBuilder setEffectiveDate(AdjustableOrRelativeDates _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("effectivePeriod")
		@RuneAttribute("effectivePeriod")
		public CancelableProvision.CancelableProvisionBuilder setEffectivePeriod(Period _effectivePeriod) {
			this.effectivePeriod = _effectivePeriod == null ? null : _effectivePeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("earliestCancellationTime")
		@RuneAttribute("earliestCancellationTime")
		public CancelableProvision.CancelableProvisionBuilder setEarliestCancellationTime(BusinessCenterTime _earliestCancellationTime) {
			this.earliestCancellationTime = _earliestCancellationTime == null ? null : _earliestCancellationTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("latestCancelationTime")
		@RuneAttribute("latestCancelationTime")
		public CancelableProvision.CancelableProvisionBuilder setLatestCancelationTime(BusinessCenterTime _latestCancelationTime) {
			this.latestCancelationTime = _latestCancelationTime == null ? null : _latestCancelationTime.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public CancelableProvision.CancelableProvisionBuilder setExerciseTerms(ExerciseTerms _exerciseTerms) {
			this.exerciseTerms = _exerciseTerms == null ? null : _exerciseTerms.toBuilder();
			return this;
		}
		
		@Override
		public CancelableProvision build() {
			return new CancelableProvision.CancelableProvisionImpl(this);
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder prune() {
			super.prune();
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (cancelableProvisionAdjustedDates!=null && !cancelableProvisionAdjustedDates.prune().hasData()) cancelableProvisionAdjustedDates = null;
			finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustment.stream().filter(b->b!=null).<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (initialFee!=null && !initialFee.prune().hasData()) initialFee = null;
			if (earliestDate!=null && !earliestDate.prune().hasData()) earliestDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (effectivePeriod!=null && !effectivePeriod.prune().hasData()) effectivePeriod = null;
			if (earliestCancellationTime!=null && !earliestCancellationTime.prune().hasData()) earliestCancellationTime = null;
			if (latestCancelationTime!=null && !latestCancelationTime.prune().hasData()) latestCancelationTime = null;
			if (exerciseTerms!=null && !exerciseTerms.prune().hasData()) exerciseTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getCancelableProvisionAdjustedDates()!=null && getCancelableProvisionAdjustedDates().hasData()) return true;
			if (getFinalCalculationPeriodDateAdjustment()!=null && getFinalCalculationPeriodDateAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialFee()!=null && getInitialFee().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getEarliestDate()!=null && getEarliestDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getEffectivePeriod()!=null && getEffectivePeriod().hasData()) return true;
			if (getEarliestCancellationTime()!=null && getEarliestCancellationTime().hasData()) return true;
			if (getLatestCancelationTime()!=null && getLatestCancelationTime().hasData()) return true;
			if (getExerciseTerms()!=null && getExerciseTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CancelableProvision.CancelableProvisionBuilder o = (CancelableProvision.CancelableProvisionBuilder) other;
			
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getCancelableProvisionAdjustedDates(), o.getCancelableProvisionAdjustedDates(), this::setCancelableProvisionAdjustedDates);
			merger.mergeRosetta(getFinalCalculationPeriodDateAdjustment(), o.getFinalCalculationPeriodDateAdjustment(), this::getOrCreateFinalCalculationPeriodDateAdjustment);
			merger.mergeRosetta(getInitialFee(), o.getInitialFee(), this::setInitialFee);
			merger.mergeRosetta(getEarliestDate(), o.getEarliestDate(), this::setEarliestDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getEffectivePeriod(), o.getEffectivePeriod(), this::setEffectivePeriod);
			merger.mergeRosetta(getEarliestCancellationTime(), o.getEarliestCancellationTime(), this::setEarliestCancellationTime);
			merger.mergeRosetta(getLatestCancelationTime(), o.getLatestCancelationTime(), this::setLatestCancelationTime);
			merger.mergeRosetta(getExerciseTerms(), o.getExerciseTerms(), this::setExerciseTerms);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(earliestDate, _that.getEarliestDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(effectivePeriod, _that.getEffectivePeriod())) return false;
			if (!Objects.equals(earliestCancellationTime, _that.getEarliestCancellationTime())) return false;
			if (!Objects.equals(latestCancelationTime, _that.getLatestCancelationTime())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earliestDate != null ? earliestDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (effectivePeriod != null ? effectivePeriod.hashCode() : 0);
			_result = 31 * _result + (earliestCancellationTime != null ? earliestCancellationTime.hashCode() : 0);
			_result = 31 * _result + (latestCancelationTime != null ? latestCancelationTime.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionBuilder {" +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee + ", " +
				"callingParty=" + this.callingParty + ", " +
				"earliestDate=" + this.earliestDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"effectivePeriod=" + this.effectivePeriod + ", " +
				"earliestCancellationTime=" + this.earliestCancellationTime + ", " +
				"latestCancelationTime=" + this.latestCancelationTime + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}' + " " + super.toString();
		}
	}
}
