package cdm.product.collateral;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.CollateralCriteriaBase;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilder;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseImpl;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralTreatment.CollateralTreatmentBuilder;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaImpl;
import cdm.product.collateral.RatingPriorityResolutionEnum;
import cdm.product.collateral.meta.EligibleCollateralCriteriaMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Represents a set of criteria used to specify eligible collateral.
 * @version 6.0.0
 */
@RosettaDataType(value="EligibleCollateralCriteria", builder=EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="EligibleCollateralCriteria", model="Just another Rosetta model", builder=EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl.class, version="6.0.0")
public interface EligibleCollateralCriteria extends CollateralCriteriaBase {

	EligibleCollateralCriteriaMeta metaData = new EligibleCollateralCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the treatment of specified collateral, e.g., haircuts,holding limits or exclusions.
	 */
	CollateralTreatment getTreatment();

	/*********************** Build Methods  ***********************/
	EligibleCollateralCriteria build();
	
	EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder();
	
	static EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder() {
		return new EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EligibleCollateralCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EligibleCollateralCriteria> getType() {
		return EligibleCollateralCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.class, getCollateralCriteria());
		processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
		processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
		processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
		processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.class, getTreatment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EligibleCollateralCriteriaBuilder extends EligibleCollateralCriteria, CollateralCriteriaBase.CollateralCriteriaBaseBuilder {
		CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment();
		@Override
		CollateralTreatment.CollateralTreatmentBuilder getTreatment();
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteria(CollateralCriteria collateralCriteria);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo, int _idx);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment treatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getCollateralCriteria());
			processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
			processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
			processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
			processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.CollateralTreatmentBuilder.class, getTreatment());
		}
		

		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of EligibleCollateralCriteria  ***********************/
	class EligibleCollateralCriteriaImpl extends CollateralCriteriaBase.CollateralCriteriaBaseImpl implements EligibleCollateralCriteria {
		private final CollateralTreatment treatment;
		
		protected EligibleCollateralCriteriaImpl(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			super(builder);
			this.treatment = ofNullable(builder.getTreatment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public CollateralTreatment getTreatment() {
			return treatment;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTreatment()).ifPresent(builder::setTreatment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteria {" +
				"treatment=" + this.treatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EligibleCollateralCriteria  ***********************/
	class EligibleCollateralCriteriaBuilderImpl extends CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl implements EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder {
	
		protected CollateralTreatment.CollateralTreatmentBuilder treatment;
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public CollateralTreatment.CollateralTreatmentBuilder getTreatment() {
			return treatment;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment() {
			CollateralTreatment.CollateralTreatmentBuilder result;
			if (treatment!=null) {
				result = treatment;
			}
			else {
				result = treatment = CollateralTreatment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@RuneAttribute("collateralCriteria")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteria(CollateralCriteria _collateralCriteria) {
			this.collateralCriteria = _collateralCriteria == null ? null : _collateralCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		@RuneAttribute("appliesTo")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo) {
			if (_appliesTo != null) {
				this.appliesTo.add(_appliesTo);
			}
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo, int _idx) {
			getIndex(this.appliesTo, _idx, () -> _appliesTo);
			return this;
		}
		
		@Override 
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos != null) {
				for (final CounterpartyRoleEnum toAdd : appliesTos) {
					this.appliesTo.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("appliesTo")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos == null) {
				this.appliesTo = new ArrayList<>();
			} else {
				this.appliesTo = appliesTos.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		@RuneAttribute("restrictTo")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum _restrictTo) {
			this.restrictTo = _restrictTo == null ? null : _restrictTo;
			return this;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		@RuneAttribute("ratingPriorityResolution")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum _ratingPriorityResolution) {
			this.ratingPriorityResolution = _ratingPriorityResolution == null ? null : _ratingPriorityResolution;
			return this;
		}
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment _treatment) {
			this.treatment = _treatment == null ? null : _treatment.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return new EligibleCollateralCriteria.EligibleCollateralCriteriaImpl(this);
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder prune() {
			super.prune();
			if (treatment!=null && !treatment.prune().hasData()) treatment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTreatment()!=null && getTreatment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder o = (EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder) other;
			
			merger.mergeRosetta(getTreatment(), o.getTreatment(), this::setTreatment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteriaBuilder {" +
				"treatment=" + this.treatment +
			'}' + " " + super.toString();
		}
	}
}
