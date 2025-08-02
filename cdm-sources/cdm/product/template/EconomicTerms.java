package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import cdm.observable.asset.CalculationAgent;
import cdm.observable.asset.CalculationAgent.CalculationAgentBuilder;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.Collateral.CollateralBuilder;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EconomicTerms.EconomicTermsBuilder;
import cdm.product.template.EconomicTerms.EconomicTermsBuilderImpl;
import cdm.product.template.EconomicTerms.EconomicTermsImpl;
import cdm.product.template.Payout;
import cdm.product.template.Payout.PayoutBuilder;
import cdm.product.template.TerminationProvision;
import cdm.product.template.TerminationProvision.TerminationProvisionBuilder;
import cdm.product.template.meta.EconomicTermsMeta;
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
 *  This class represents the full set of price-forming features associated with a contractual product: the payout component, the notional/quantity, the effective and termination date and the date adjustment provisions when applying uniformily across the payout components. This class also includes the legal provisions which have valuation implications: cancelable provision, extendible provision, early termination provision and extraordinary events specification.
 * @version 6.0.0
 */
@RosettaDataType(value="EconomicTerms", builder=EconomicTerms.EconomicTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="EconomicTerms", model="Just another Rosetta model", builder=EconomicTerms.EconomicTermsBuilderImpl.class, version="6.0.0")
public interface EconomicTerms extends RosettaModelObject {

	EconomicTermsMeta metaData = new EconomicTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 * Body ICMA
	 * Corpus MasterAgreement GMRA Global Master Repurchase Agreement GMRA 2011 "The Global Master Repurchase Agreement (GMRA) is a model legal agreement designed for parties transacting repos and is published by the International Capital Market Association (ICMA)." 
	 * namingConvention "Purchase Date"
	 *
	 * Provision As defined in GMRA paragraph 2(mm) The date on which Purchased Securities are sold or are to be sold by Seller to Buyer.
	 *
	 *
	 * Body ICMA
	 * Corpus Guidance ERCCBestPractice ERCC Guide to Best Practice in the European Repo Market ERCC Guide to Best Practice in the European Repo Market "The ERCC Guide to Best Practice in the European Repo Market is published by ICMAs European Repo and Collateral Council (ERCC). Its purpose is to help foster a fair and efficient European repo market by recommending practices which market experience suggests can help avoid uncertainty or disagreement about transactions, and consequent delay or disruption to repo trading and settlement. With the same purpose in mind, the Guide also codifies market conventions, where this has been thought to be helpful, usually in response to queries from market participants." 
	 * namingConvention "Purchase Date"
	 *
	 * Provision ERCC Guide: Annex II  Glossary of repo terminology. The term for the value date of a repo.
	 *
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
	 *
	 * Body ICMA
	 * Corpus MasterAgreement GMRA Global Master Repurchase Agreement GMRA 2011 "The Global Master Repurchase Agreement (GMRA) is a model legal agreement designed for parties transacting repos and is published by the International Capital Market Association (ICMA)." 
	 * namingConvention "Repurchase Date"
	 *
	 * Provision As defined in GMRA paragraph 2(qq) The date on which Buyer is to sell Equivalent Securities to Seller.
	 *
	 *
	 * Body ICMA
	 * Corpus Guidance ERCCBestPractice ERCC Guide to Best Practice in the European Repo Market ERCC Guide to Best Practice in the European Repo Market "The ERCC Guide to Best Practice in the European Repo Market is published by ICMAs European Repo and Collateral Council (ERCC). Its purpose is to help foster a fair and efficient European repo market by recommending practices which market experience suggests can help avoid uncertainty or disagreement about transactions, and consequent delay or disruption to repo trading and settlement. With the same purpose in mind, the Guide also codifies market conventions, where this has been thought to be helpful, usually in response to queries from market participants." 
	 * namingConvention "Repurchase Date"
	 *
	 * Provision ERCC Guide: Annex II  Glossary of repo terminology. The term for the maturity date of a repo.
	 *
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 * The business day adjustment convention when it applies across all the payout components. This specification of the business day convention and financial business centers is used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * The payout specifies the future cashflow computation methodology which characterizes a financial product.
	 */
	List<? extends Payout> getPayout();
	/**
	 * Contains optional provisions pertaining to the termination characteristics of a contract.
	 */
	TerminationProvision getTerminationProvision();
	/**
	 * The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * Specifies, when boolean value is True, that additional economic terms exist that have not been included in the product representation.
	 */
	Boolean getNonStandardisedTerms();
	/**
	 * Represents the collateral obligations of a party.
	 */
	Collateral getCollateral();

	/*********************** Build Methods  ***********************/
	EconomicTerms build();
	
	EconomicTerms.EconomicTermsBuilder toBuilder();
	
	static EconomicTerms.EconomicTermsBuilder builder() {
		return new EconomicTerms.EconomicTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EconomicTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EconomicTerms> getType() {
		return EconomicTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("payout"), processor, Payout.class, getPayout());
		processRosetta(path.newSubPath("terminationProvision"), processor, TerminationProvision.class, getTerminationProvision());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processor.processBasic(path.newSubPath("nonStandardisedTerms"), Boolean.class, getNonStandardisedTerms(), this);
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EconomicTermsBuilder extends EconomicTerms, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		Payout.PayoutBuilder getOrCreatePayout(int _index);
		@Override
		List<? extends Payout.PayoutBuilder> getPayout();
		TerminationProvision.TerminationProvisionBuilder getOrCreateTerminationProvision();
		@Override
		TerminationProvision.TerminationProvisionBuilder getTerminationProvision();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		@Override
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		Collateral.CollateralBuilder getOrCreateCollateral();
		@Override
		Collateral.CollateralBuilder getCollateral();
		EconomicTerms.EconomicTermsBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		EconomicTerms.EconomicTermsBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		EconomicTerms.EconomicTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		EconomicTerms.EconomicTermsBuilder addPayout(Payout payout);
		EconomicTerms.EconomicTermsBuilder addPayout(Payout payout, int _idx);
		EconomicTerms.EconomicTermsBuilder addPayout(List<? extends Payout> payout);
		EconomicTerms.EconomicTermsBuilder setPayout(List<? extends Payout> payout);
		EconomicTerms.EconomicTermsBuilder setTerminationProvision(TerminationProvision terminationProvision);
		EconomicTerms.EconomicTermsBuilder setCalculationAgent(CalculationAgent calculationAgent);
		EconomicTerms.EconomicTermsBuilder setNonStandardisedTerms(Boolean nonStandardisedTerms);
		EconomicTerms.EconomicTermsBuilder setCollateral(Collateral collateral);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("payout"), processor, Payout.PayoutBuilder.class, getPayout());
			processRosetta(path.newSubPath("terminationProvision"), processor, TerminationProvision.TerminationProvisionBuilder.class, getTerminationProvision());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processor.processBasic(path.newSubPath("nonStandardisedTerms"), Boolean.class, getNonStandardisedTerms(), this);
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
		}
		

		EconomicTerms.EconomicTermsBuilder prune();
	}

	/*********************** Immutable Implementation of EconomicTerms  ***********************/
	class EconomicTermsImpl implements EconomicTerms {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final List<? extends Payout> payout;
		private final TerminationProvision terminationProvision;
		private final CalculationAgent calculationAgent;
		private final Boolean nonStandardisedTerms;
		private final Collateral collateral;
		
		protected EconomicTermsImpl(EconomicTerms.EconomicTermsBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.payout = ofNullable(builder.getPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.terminationProvision = ofNullable(builder.getTerminationProvision()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.nonStandardisedTerms = builder.getNonStandardisedTerms();
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public List<? extends Payout> getPayout() {
			return payout;
		}
		
		@Override
		@RosettaAttribute("terminationProvision")
		@RuneAttribute("terminationProvision")
		public TerminationProvision getTerminationProvision() {
			return terminationProvision;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@RuneAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("nonStandardisedTerms")
		@RuneAttribute("nonStandardisedTerms")
		public Boolean getNonStandardisedTerms() {
			return nonStandardisedTerms;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		public EconomicTerms build() {
			return this;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder toBuilder() {
			EconomicTerms.EconomicTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EconomicTerms.EconomicTermsBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getTerminationProvision()).ifPresent(builder::setTerminationProvision);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getNonStandardisedTerms()).ifPresent(builder::setNonStandardisedTerms);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EconomicTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(payout, _that.getPayout())) return false;
			if (!Objects.equals(terminationProvision, _that.getTerminationProvision())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(nonStandardisedTerms, _that.getNonStandardisedTerms())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (terminationProvision != null ? terminationProvision.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (nonStandardisedTerms != null ? nonStandardisedTerms.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EconomicTerms {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"payout=" + this.payout + ", " +
				"terminationProvision=" + this.terminationProvision + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"nonStandardisedTerms=" + this.nonStandardisedTerms + ", " +
				"collateral=" + this.collateral +
			'}';
		}
	}

	/*********************** Builder Implementation of EconomicTerms  ***********************/
	class EconomicTermsBuilderImpl implements EconomicTerms.EconomicTermsBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<Payout.PayoutBuilder> payout = new ArrayList<>();
		protected TerminationProvision.TerminationProvisionBuilder terminationProvision;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected Boolean nonStandardisedTerms;
		protected Collateral.CollateralBuilder collateral;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public List<? extends Payout.PayoutBuilder> getPayout() {
			return payout;
		}
		
		@Override
		public Payout.PayoutBuilder getOrCreatePayout(int _index) {
		
			if (payout==null) {
				this.payout = new ArrayList<>();
			}
			Payout.PayoutBuilder result;
			return getIndex(payout, _index, () -> {
						Payout.PayoutBuilder newPayout = Payout.builder();
						return newPayout;
					});
		}
		
		@Override
		@RosettaAttribute("terminationProvision")
		@RuneAttribute("terminationProvision")
		public TerminationProvision.TerminationProvisionBuilder getTerminationProvision() {
			return terminationProvision;
		}
		
		@Override
		public TerminationProvision.TerminationProvisionBuilder getOrCreateTerminationProvision() {
			TerminationProvision.TerminationProvisionBuilder result;
			if (terminationProvision!=null) {
				result = terminationProvision;
			}
			else {
				result = terminationProvision = TerminationProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@RuneAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonStandardisedTerms")
		@RuneAttribute("nonStandardisedTerms")
		public Boolean getNonStandardisedTerms() {
			return nonStandardisedTerms;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public EconomicTerms.EconomicTermsBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@RuneAttribute("terminationDate")
		public EconomicTerms.EconomicTermsBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public EconomicTerms.EconomicTermsBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public EconomicTerms.EconomicTermsBuilder addPayout(Payout _payout) {
			if (_payout != null) {
				this.payout.add(_payout.toBuilder());
			}
			return this;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder addPayout(Payout _payout, int _idx) {
			getIndex(this.payout, _idx, () -> _payout.toBuilder());
			return this;
		}
		
		@Override 
		public EconomicTerms.EconomicTermsBuilder addPayout(List<? extends Payout> payouts) {
			if (payouts != null) {
				for (final Payout toAdd : payouts) {
					this.payout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("payout")
		public EconomicTerms.EconomicTermsBuilder setPayout(List<? extends Payout> payouts) {
			if (payouts == null) {
				this.payout = new ArrayList<>();
			} else {
				this.payout = payouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("terminationProvision")
		@RuneAttribute("terminationProvision")
		public EconomicTerms.EconomicTermsBuilder setTerminationProvision(TerminationProvision _terminationProvision) {
			this.terminationProvision = _terminationProvision == null ? null : _terminationProvision.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@RuneAttribute("calculationAgent")
		public EconomicTerms.EconomicTermsBuilder setCalculationAgent(CalculationAgent _calculationAgent) {
			this.calculationAgent = _calculationAgent == null ? null : _calculationAgent.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("nonStandardisedTerms")
		@RuneAttribute("nonStandardisedTerms")
		public EconomicTerms.EconomicTermsBuilder setNonStandardisedTerms(Boolean _nonStandardisedTerms) {
			this.nonStandardisedTerms = _nonStandardisedTerms == null ? null : _nonStandardisedTerms;
			return this;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public EconomicTerms.EconomicTermsBuilder setCollateral(Collateral _collateral) {
			this.collateral = _collateral == null ? null : _collateral.toBuilder();
			return this;
		}
		
		@Override
		public EconomicTerms build() {
			return new EconomicTerms.EconomicTermsImpl(this);
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EconomicTerms.EconomicTermsBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			payout = payout.stream().filter(b->b!=null).<Payout.PayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (terminationProvision!=null && !terminationProvision.prune().hasData()) terminationProvision = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getPayout()!=null && getPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTerminationProvision()!=null && getTerminationProvision().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getNonStandardisedTerms()!=null) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EconomicTerms.EconomicTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EconomicTerms.EconomicTermsBuilder o = (EconomicTerms.EconomicTermsBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getPayout(), o.getPayout(), this::getOrCreatePayout);
			merger.mergeRosetta(getTerminationProvision(), o.getTerminationProvision(), this::setTerminationProvision);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			
			merger.mergeBasic(getNonStandardisedTerms(), o.getNonStandardisedTerms(), this::setNonStandardisedTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EconomicTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(payout, _that.getPayout())) return false;
			if (!Objects.equals(terminationProvision, _that.getTerminationProvision())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(nonStandardisedTerms, _that.getNonStandardisedTerms())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (terminationProvision != null ? terminationProvision.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (nonStandardisedTerms != null ? nonStandardisedTerms.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EconomicTermsBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"payout=" + this.payout + ", " +
				"terminationProvision=" + this.terminationProvision + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"nonStandardisedTerms=" + this.nonStandardisedTerms + ", " +
				"collateral=" + this.collateral +
			'}';
		}
	}
}
