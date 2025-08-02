package cdm.product.template;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilderImpl;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerImpl;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.product.template.CallingPartyEnum;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseNotice.ExerciseNoticeBuilder;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilder;
import cdm.product.template.ExtendibleProvision;
import cdm.product.template.ExtendibleProvision.ExtendibleProvisionBuilder;
import cdm.product.template.ExtendibleProvision.ExtendibleProvisionBuilderImpl;
import cdm.product.template.ExtendibleProvision.ExtendibleProvisionImpl;
import cdm.product.template.ExtendibleProvisionAdjustedDates;
import cdm.product.template.ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder;
import cdm.product.template.meta.ExtendibleProvisionMeta;
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
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date. As a difference from FpML, it extends the BuyerSeller class, which represents the BuyerSeller.model.
 * @version 6.0.0
 */
@RosettaDataType(value="ExtendibleProvision", builder=ExtendibleProvision.ExtendibleProvisionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ExtendibleProvision", model="Just another Rosetta model", builder=ExtendibleProvision.ExtendibleProvisionBuilderImpl.class, version="6.0.0")
public interface ExtendibleProvision extends BuyerSeller {

	ExtendibleProvisionMeta metaData = new ExtendibleProvisionMeta();

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
	 * The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
	 */
	ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates();
	CallingPartyEnum getCallingParty();
	/**
	 * If the ability to extend the contract is not available to both parties then this component specifies the buyer and seller of the option.
	 */
	PartyRole getSinglePartyOption();
	/**
	 * Defines the minimum period before a contract is scheduled to terminate that notice can be given that it will terminate beyond the scheduled termination date.
	 */
	RelativeDateOffset getNoticeDeadlinePeriod();
	/**
	 * A specific date and time for the notice deadline
	 */
	ZonedDateTime getNoticeDeadlineDateTime();
	/**
	 * The length of each extension period relative to the effective date of the preceding contract.
	 */
	RelativeDateOffset getExtensionTerm();
	/**
	 * The period within which notice can be given that the contract will be extended.
	 */
	AdjustableRelativeOrPeriodicDates getExtensionPeriod();
	/**
	 * The exercise terms associated with the extendible provision, including details such as exercise style, exercise fees, and any other relevant conditions or terms governing the extension of the swap transaction.
	 */
	ExerciseTerms getExerciseTerms();

	/*********************** Build Methods  ***********************/
	ExtendibleProvision build();
	
	ExtendibleProvision.ExtendibleProvisionBuilder toBuilder();
	
	static ExtendibleProvision.ExtendibleProvisionBuilder builder() {
		return new ExtendibleProvision.ExtendibleProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtendibleProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExtendibleProvision> getType() {
		return ExtendibleProvision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
		processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.class, getExtendibleProvisionAdjustedDates());
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processRosetta(path.newSubPath("singlePartyOption"), processor, PartyRole.class, getSinglePartyOption());
		processRosetta(path.newSubPath("noticeDeadlinePeriod"), processor, RelativeDateOffset.class, getNoticeDeadlinePeriod());
		processor.processBasic(path.newSubPath("noticeDeadlineDateTime"), ZonedDateTime.class, getNoticeDeadlineDateTime(), this);
		processRosetta(path.newSubPath("extensionTerm"), processor, RelativeDateOffset.class, getExtensionTerm());
		processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableRelativeOrPeriodicDates.class, getExtensionPeriod());
		processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.class, getExerciseTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtendibleProvisionBuilder extends ExtendibleProvision, BuyerSeller.BuyerSellerBuilder {
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		@Override
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates();
		@Override
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates();
		PartyRole.PartyRoleBuilder getOrCreateSinglePartyOption();
		@Override
		PartyRole.PartyRoleBuilder getSinglePartyOption();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateNoticeDeadlinePeriod();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getNoticeDeadlinePeriod();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateExtensionTerm();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getExtensionTerm();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateExtensionPeriod();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getExtensionPeriod();
		ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms();
		@Override
		ExerciseTerms.ExerciseTermsBuilder getExerciseTerms();
		@Override
		ExtendibleProvision.ExtendibleProvisionBuilder setBuyer(CounterpartyRoleEnum buyer);
		@Override
		ExtendibleProvision.ExtendibleProvisionBuilder setSeller(CounterpartyRoleEnum seller);
		ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates);
		ExtendibleProvision.ExtendibleProvisionBuilder setCallingParty(CallingPartyEnum callingParty);
		ExtendibleProvision.ExtendibleProvisionBuilder setSinglePartyOption(PartyRole singlePartyOption);
		ExtendibleProvision.ExtendibleProvisionBuilder setNoticeDeadlinePeriod(RelativeDateOffset noticeDeadlinePeriod);
		ExtendibleProvision.ExtendibleProvisionBuilder setNoticeDeadlineDateTime(ZonedDateTime noticeDeadlineDateTime);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtensionTerm(RelativeDateOffset extensionTerm);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtensionPeriod(AdjustableRelativeOrPeriodicDates extensionPeriod);
		ExtendibleProvision.ExtendibleProvisionBuilder setExerciseTerms(ExerciseTerms exerciseTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
			processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder.class, getExtendibleProvisionAdjustedDates());
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processRosetta(path.newSubPath("singlePartyOption"), processor, PartyRole.PartyRoleBuilder.class, getSinglePartyOption());
			processRosetta(path.newSubPath("noticeDeadlinePeriod"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getNoticeDeadlinePeriod());
			processor.processBasic(path.newSubPath("noticeDeadlineDateTime"), ZonedDateTime.class, getNoticeDeadlineDateTime(), this);
			processRosetta(path.newSubPath("extensionTerm"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getExtensionTerm());
			processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getExtensionPeriod());
			processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.ExerciseTermsBuilder.class, getExerciseTerms());
		}
		

		ExtendibleProvision.ExtendibleProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionImpl extends BuyerSeller.BuyerSellerImpl implements ExtendibleProvision {
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates;
		private final CallingPartyEnum callingParty;
		private final PartyRole singlePartyOption;
		private final RelativeDateOffset noticeDeadlinePeriod;
		private final ZonedDateTime noticeDeadlineDateTime;
		private final RelativeDateOffset extensionTerm;
		private final AdjustableRelativeOrPeriodicDates extensionPeriod;
		private final ExerciseTerms exerciseTerms;
		
		protected ExtendibleProvisionImpl(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			super(builder);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.extendibleProvisionAdjustedDates = ofNullable(builder.getExtendibleProvisionAdjustedDates()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.singlePartyOption = ofNullable(builder.getSinglePartyOption()).map(f->f.build()).orElse(null);
			this.noticeDeadlinePeriod = ofNullable(builder.getNoticeDeadlinePeriod()).map(f->f.build()).orElse(null);
			this.noticeDeadlineDateTime = builder.getNoticeDeadlineDateTime();
			this.extensionTerm = ofNullable(builder.getExtensionTerm()).map(f->f.build()).orElse(null);
			this.extensionPeriod = ofNullable(builder.getExtensionPeriod()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@RuneAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@RuneAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		@RuneAttribute("singlePartyOption")
		public PartyRole getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public RelativeDateOffset getNoticeDeadlinePeriod() {
			return noticeDeadlinePeriod;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public ZonedDateTime getNoticeDeadlineDateTime() {
			return noticeDeadlineDateTime;
		}
		
		@Override
		@RosettaAttribute("extensionTerm")
		@RuneAttribute("extensionTerm")
		public RelativeDateOffset getExtensionTerm() {
			return extensionTerm;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@RuneAttribute("extensionPeriod")
		public AdjustableRelativeOrPeriodicDates getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExerciseTerms getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public ExtendibleProvision build() {
			return this;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			ExtendibleProvision.ExtendibleProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getExtendibleProvisionAdjustedDates()).ifPresent(builder::setExtendibleProvisionAdjustedDates);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getSinglePartyOption()).ifPresent(builder::setSinglePartyOption);
			ofNullable(getNoticeDeadlinePeriod()).ifPresent(builder::setNoticeDeadlinePeriod);
			ofNullable(getNoticeDeadlineDateTime()).ifPresent(builder::setNoticeDeadlineDateTime);
			ofNullable(getExtensionTerm()).ifPresent(builder::setExtensionTerm);
			ofNullable(getExtensionPeriod()).ifPresent(builder::setExtensionPeriod);
			ofNullable(getExerciseTerms()).ifPresent(builder::setExerciseTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(noticeDeadlinePeriod, _that.getNoticeDeadlinePeriod())) return false;
			if (!Objects.equals(noticeDeadlineDateTime, _that.getNoticeDeadlineDateTime())) return false;
			if (!Objects.equals(extensionTerm, _that.getExtensionTerm())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlinePeriod != null ? noticeDeadlinePeriod.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlineDateTime != null ? noticeDeadlineDateTime.hashCode() : 0);
			_result = 31 * _result + (extensionTerm != null ? extensionTerm.hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvision {" +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates + ", " +
				"callingParty=" + this.callingParty + ", " +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"noticeDeadlinePeriod=" + this.noticeDeadlinePeriod + ", " +
				"noticeDeadlineDateTime=" + this.noticeDeadlineDateTime + ", " +
				"extensionTerm=" + this.extensionTerm + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionBuilderImpl extends BuyerSeller.BuyerSellerBuilderImpl implements ExtendibleProvision.ExtendibleProvisionBuilder {
	
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates;
		protected CallingPartyEnum callingParty;
		protected PartyRole.PartyRoleBuilder singlePartyOption;
		protected RelativeDateOffset.RelativeDateOffsetBuilder noticeDeadlinePeriod;
		protected ZonedDateTime noticeDeadlineDateTime;
		protected RelativeDateOffset.RelativeDateOffsetBuilder extensionTerm;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder extensionPeriod;
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
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@RuneAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates() {
			ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder result;
			if (extendibleProvisionAdjustedDates!=null) {
				result = extendibleProvisionAdjustedDates;
			}
			else {
				result = extendibleProvisionAdjustedDates = ExtendibleProvisionAdjustedDates.builder();
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
		@RosettaAttribute("singlePartyOption")
		@RuneAttribute("singlePartyOption")
		public PartyRole.PartyRoleBuilder getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreateSinglePartyOption() {
			PartyRole.PartyRoleBuilder result;
			if (singlePartyOption!=null) {
				result = singlePartyOption;
			}
			else {
				result = singlePartyOption = PartyRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public RelativeDateOffset.RelativeDateOffsetBuilder getNoticeDeadlinePeriod() {
			return noticeDeadlinePeriod;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateNoticeDeadlinePeriod() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (noticeDeadlinePeriod!=null) {
				result = noticeDeadlinePeriod;
			}
			else {
				result = noticeDeadlinePeriod = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public ZonedDateTime getNoticeDeadlineDateTime() {
			return noticeDeadlineDateTime;
		}
		
		@Override
		@RosettaAttribute("extensionTerm")
		@RuneAttribute("extensionTerm")
		public RelativeDateOffset.RelativeDateOffsetBuilder getExtensionTerm() {
			return extensionTerm;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateExtensionTerm() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (extensionTerm!=null) {
				result = extensionTerm;
			}
			else {
				result = extensionTerm = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@RuneAttribute("extensionPeriod")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateExtensionPeriod() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (extensionPeriod!=null) {
				result = extensionPeriod;
			}
			else {
				result = extensionPeriod = AdjustableRelativeOrPeriodicDates.builder();
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
		public ExtendibleProvision.ExtendibleProvisionBuilder setBuyer(CounterpartyRoleEnum _buyer) {
			this.buyer = _buyer == null ? null : _buyer;
			return this;
		}
		
		@Override
		@RosettaAttribute("seller")
		@RuneAttribute("seller")
		public ExtendibleProvision.ExtendibleProvisionBuilder setSeller(CounterpartyRoleEnum _seller) {
			this.seller = _seller == null ? null : _seller;
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@RuneAttribute("exerciseNotice")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice _exerciseNotice) {
			this.exerciseNotice = _exerciseNotice == null ? null : _exerciseNotice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@RuneAttribute("followUpConfirmation")
		public ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean _followUpConfirmation) {
			this.followUpConfirmation = _followUpConfirmation == null ? null : _followUpConfirmation;
			return this;
		}
		
		@Override
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@RuneAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates _extendibleProvisionAdjustedDates) {
			this.extendibleProvisionAdjustedDates = _extendibleProvisionAdjustedDates == null ? null : _extendibleProvisionAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@RuneAttribute("callingParty")
		public ExtendibleProvision.ExtendibleProvisionBuilder setCallingParty(CallingPartyEnum _callingParty) {
			this.callingParty = _callingParty == null ? null : _callingParty;
			return this;
		}
		
		@Override
		@RosettaAttribute("singlePartyOption")
		@RuneAttribute("singlePartyOption")
		public ExtendibleProvision.ExtendibleProvisionBuilder setSinglePartyOption(PartyRole _singlePartyOption) {
			this.singlePartyOption = _singlePartyOption == null ? null : _singlePartyOption.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public ExtendibleProvision.ExtendibleProvisionBuilder setNoticeDeadlinePeriod(RelativeDateOffset _noticeDeadlinePeriod) {
			this.noticeDeadlinePeriod = _noticeDeadlinePeriod == null ? null : _noticeDeadlinePeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public ExtendibleProvision.ExtendibleProvisionBuilder setNoticeDeadlineDateTime(ZonedDateTime _noticeDeadlineDateTime) {
			this.noticeDeadlineDateTime = _noticeDeadlineDateTime == null ? null : _noticeDeadlineDateTime;
			return this;
		}
		
		@Override
		@RosettaAttribute("extensionTerm")
		@RuneAttribute("extensionTerm")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtensionTerm(RelativeDateOffset _extensionTerm) {
			this.extensionTerm = _extensionTerm == null ? null : _extensionTerm.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@RuneAttribute("extensionPeriod")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtensionPeriod(AdjustableRelativeOrPeriodicDates _extensionPeriod) {
			this.extensionPeriod = _extensionPeriod == null ? null : _extensionPeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExtendibleProvision.ExtendibleProvisionBuilder setExerciseTerms(ExerciseTerms _exerciseTerms) {
			this.exerciseTerms = _exerciseTerms == null ? null : _exerciseTerms.toBuilder();
			return this;
		}
		
		@Override
		public ExtendibleProvision build() {
			return new ExtendibleProvision.ExtendibleProvisionImpl(this);
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder prune() {
			super.prune();
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (extendibleProvisionAdjustedDates!=null && !extendibleProvisionAdjustedDates.prune().hasData()) extendibleProvisionAdjustedDates = null;
			if (singlePartyOption!=null && !singlePartyOption.prune().hasData()) singlePartyOption = null;
			if (noticeDeadlinePeriod!=null && !noticeDeadlinePeriod.prune().hasData()) noticeDeadlinePeriod = null;
			if (extensionTerm!=null && !extensionTerm.prune().hasData()) extensionTerm = null;
			if (extensionPeriod!=null && !extensionPeriod.prune().hasData()) extensionPeriod = null;
			if (exerciseTerms!=null && !exerciseTerms.prune().hasData()) exerciseTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getExtendibleProvisionAdjustedDates()!=null && getExtendibleProvisionAdjustedDates().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getSinglePartyOption()!=null && getSinglePartyOption().hasData()) return true;
			if (getNoticeDeadlinePeriod()!=null && getNoticeDeadlinePeriod().hasData()) return true;
			if (getNoticeDeadlineDateTime()!=null) return true;
			if (getExtensionTerm()!=null && getExtensionTerm().hasData()) return true;
			if (getExtensionPeriod()!=null && getExtensionPeriod().hasData()) return true;
			if (getExerciseTerms()!=null && getExerciseTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExtendibleProvision.ExtendibleProvisionBuilder o = (ExtendibleProvision.ExtendibleProvisionBuilder) other;
			
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getExtendibleProvisionAdjustedDates(), o.getExtendibleProvisionAdjustedDates(), this::setExtendibleProvisionAdjustedDates);
			merger.mergeRosetta(getSinglePartyOption(), o.getSinglePartyOption(), this::setSinglePartyOption);
			merger.mergeRosetta(getNoticeDeadlinePeriod(), o.getNoticeDeadlinePeriod(), this::setNoticeDeadlinePeriod);
			merger.mergeRosetta(getExtensionTerm(), o.getExtensionTerm(), this::setExtensionTerm);
			merger.mergeRosetta(getExtensionPeriod(), o.getExtensionPeriod(), this::setExtensionPeriod);
			merger.mergeRosetta(getExerciseTerms(), o.getExerciseTerms(), this::setExerciseTerms);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getNoticeDeadlineDateTime(), o.getNoticeDeadlineDateTime(), this::setNoticeDeadlineDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			if (!Objects.equals(noticeDeadlinePeriod, _that.getNoticeDeadlinePeriod())) return false;
			if (!Objects.equals(noticeDeadlineDateTime, _that.getNoticeDeadlineDateTime())) return false;
			if (!Objects.equals(extensionTerm, _that.getExtensionTerm())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlinePeriod != null ? noticeDeadlinePeriod.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlineDateTime != null ? noticeDeadlineDateTime.hashCode() : 0);
			_result = 31 * _result + (extensionTerm != null ? extensionTerm.hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvisionBuilder {" +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates + ", " +
				"callingParty=" + this.callingParty + ", " +
				"singlePartyOption=" + this.singlePartyOption + ", " +
				"noticeDeadlinePeriod=" + this.noticeDeadlinePeriod + ", " +
				"noticeDeadlineDateTime=" + this.noticeDeadlineDateTime + ", " +
				"extensionTerm=" + this.extensionTerm + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"exerciseTerms=" + this.exerciseTerms +
			'}' + " " + super.toString();
		}
	}
}
