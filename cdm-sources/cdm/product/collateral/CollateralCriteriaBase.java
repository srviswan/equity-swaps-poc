package cdm.product.collateral;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.CollateralCriteriaBase;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilder;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl;
import cdm.product.collateral.CollateralCriteriaBase.CollateralCriteriaBaseImpl;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.RatingPriorityResolutionEnum;
import cdm.product.collateral.meta.CollateralCriteriaBaseMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Represents a set of criteria used to specify and describe collateral.
 * @version 6.0.0
 */
@RosettaDataType(value="CollateralCriteriaBase", builder=CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CollateralCriteriaBase", model="Just another Rosetta model", builder=CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl.class, version="6.0.0")
public interface CollateralCriteriaBase extends RosettaModelObject {

	CollateralCriteriaBaseMeta metaData = new CollateralCriteriaBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specific criteria that applies. It can be created using AND, OR and NOT logic, and both asset and issuer characteristics.
	 */
	CollateralCriteria getCollateralCriteria();
	/**
	 * Specifies which of the two counterparties the criteria applies to (either one or both counterparties). This attribute is optional, in case the applicable party is already specified elsewhere within a party election.
	 */
	List<CounterpartyRoleEnum> getAppliesTo();
	/**
	 * Restrict the criteria to only apply to a specific type of margin, ie IM or VM.
	 */
	CollateralMarginTypeEnum getRestrictTo();
	/**
	 * Denotes which Criteria has priority if more than one agency rating applies.
	 */
	RatingPriorityResolutionEnum getRatingPriorityResolution();

	/*********************** Build Methods  ***********************/
	CollateralCriteriaBase build();
	
	CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder();
	
	static CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder() {
		return new CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralCriteriaBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralCriteriaBase> getType() {
		return CollateralCriteriaBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.class, getCollateralCriteria());
		processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
		processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
		processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralCriteriaBaseBuilder extends CollateralCriteriaBase, RosettaModelObjectBuilder {
		CollateralCriteria.CollateralCriteriaBuilder getOrCreateCollateralCriteria();
		@Override
		CollateralCriteria.CollateralCriteriaBuilder getCollateralCriteria();
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setCollateralCriteria(CollateralCriteria collateralCriteria);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum appliesTo, int _idx);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo);
		CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getCollateralCriteria());
			processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
			processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
			processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
		}
		

		CollateralCriteriaBase.CollateralCriteriaBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralCriteriaBase  ***********************/
	class CollateralCriteriaBaseImpl implements CollateralCriteriaBase {
		private final CollateralCriteria collateralCriteria;
		private final List<CounterpartyRoleEnum> appliesTo;
		private final CollateralMarginTypeEnum restrictTo;
		private final RatingPriorityResolutionEnum ratingPriorityResolution;
		
		protected CollateralCriteriaBaseImpl(CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder) {
			this.collateralCriteria = ofNullable(builder.getCollateralCriteria()).map(f->f.build()).orElse(null);
			this.appliesTo = ofNullable(builder.getAppliesTo()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.restrictTo = builder.getRestrictTo();
			this.ratingPriorityResolution = builder.getRatingPriorityResolution();
		}
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@RuneAttribute("collateralCriteria")
		public CollateralCriteria getCollateralCriteria() {
			return collateralCriteria;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		@RuneAttribute("appliesTo")
		public List<CounterpartyRoleEnum> getAppliesTo() {
			return appliesTo;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		@RuneAttribute("restrictTo")
		public CollateralMarginTypeEnum getRestrictTo() {
			return restrictTo;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		@RuneAttribute("ratingPriorityResolution")
		public RatingPriorityResolutionEnum getRatingPriorityResolution() {
			return ratingPriorityResolution;
		}
		
		@Override
		public CollateralCriteriaBase build() {
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder() {
			CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralCriteriaBase.CollateralCriteriaBaseBuilder builder) {
			ofNullable(getCollateralCriteria()).ifPresent(builder::setCollateralCriteria);
			ofNullable(getAppliesTo()).ifPresent(builder::setAppliesTo);
			ofNullable(getRestrictTo()).ifPresent(builder::setRestrictTo);
			ofNullable(getRatingPriorityResolution()).ifPresent(builder::setRatingPriorityResolution);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteriaBase _that = getType().cast(o);
		
			if (!Objects.equals(collateralCriteria, _that.getCollateralCriteria())) return false;
			if (!ListEquals.listEquals(appliesTo, _that.getAppliesTo())) return false;
			if (!Objects.equals(restrictTo, _that.getRestrictTo())) return false;
			if (!Objects.equals(ratingPriorityResolution, _that.getRatingPriorityResolution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralCriteria != null ? collateralCriteria.hashCode() : 0);
			_result = 31 * _result + (appliesTo != null ? appliesTo.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (restrictTo != null ? restrictTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingPriorityResolution != null ? ratingPriorityResolution.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteriaBase {" +
				"collateralCriteria=" + this.collateralCriteria + ", " +
				"appliesTo=" + this.appliesTo + ", " +
				"restrictTo=" + this.restrictTo + ", " +
				"ratingPriorityResolution=" + this.ratingPriorityResolution +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralCriteriaBase  ***********************/
	class CollateralCriteriaBaseBuilderImpl implements CollateralCriteriaBase.CollateralCriteriaBaseBuilder {
	
		protected CollateralCriteria.CollateralCriteriaBuilder collateralCriteria;
		protected List<CounterpartyRoleEnum> appliesTo = new ArrayList<>();
		protected CollateralMarginTypeEnum restrictTo;
		protected RatingPriorityResolutionEnum ratingPriorityResolution;
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@RuneAttribute("collateralCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder getCollateralCriteria() {
			return collateralCriteria;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder getOrCreateCollateralCriteria() {
			CollateralCriteria.CollateralCriteriaBuilder result;
			if (collateralCriteria!=null) {
				result = collateralCriteria;
			}
			else {
				result = collateralCriteria = CollateralCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		@RuneAttribute("appliesTo")
		public List<CounterpartyRoleEnum> getAppliesTo() {
			return appliesTo;
		}
		
		@Override
		@RosettaAttribute("restrictTo")
		@RuneAttribute("restrictTo")
		public CollateralMarginTypeEnum getRestrictTo() {
			return restrictTo;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		@RuneAttribute("ratingPriorityResolution")
		public RatingPriorityResolutionEnum getRatingPriorityResolution() {
			return ratingPriorityResolution;
		}
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@RuneAttribute("collateralCriteria")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setCollateralCriteria(CollateralCriteria _collateralCriteria) {
			this.collateralCriteria = _collateralCriteria == null ? null : _collateralCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("appliesTo")
		@RuneAttribute("appliesTo")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo) {
			if (_appliesTo != null) {
				this.appliesTo.add(_appliesTo);
			}
			return this;
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo, int _idx) {
			getIndex(this.appliesTo, _idx, () -> _appliesTo);
			return this;
		}
		
		@Override 
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos != null) {
				for (final CounterpartyRoleEnum toAdd : appliesTos) {
					this.appliesTo.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("appliesTo")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
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
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRestrictTo(CollateralMarginTypeEnum _restrictTo) {
			this.restrictTo = _restrictTo == null ? null : _restrictTo;
			return this;
		}
		
		@Override
		@RosettaAttribute("ratingPriorityResolution")
		@RuneAttribute("ratingPriorityResolution")
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum _ratingPriorityResolution) {
			this.ratingPriorityResolution = _ratingPriorityResolution == null ? null : _ratingPriorityResolution;
			return this;
		}
		
		@Override
		public CollateralCriteriaBase build() {
			return new CollateralCriteriaBase.CollateralCriteriaBaseImpl(this);
		}
		
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder prune() {
			if (collateralCriteria!=null && !collateralCriteria.prune().hasData()) collateralCriteria = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralCriteria()!=null && getCollateralCriteria().hasData()) return true;
			if (getAppliesTo()!=null && !getAppliesTo().isEmpty()) return true;
			if (getRestrictTo()!=null) return true;
			if (getRatingPriorityResolution()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteriaBase.CollateralCriteriaBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralCriteriaBase.CollateralCriteriaBaseBuilder o = (CollateralCriteriaBase.CollateralCriteriaBaseBuilder) other;
			
			merger.mergeRosetta(getCollateralCriteria(), o.getCollateralCriteria(), this::setCollateralCriteria);
			
			merger.mergeBasic(getAppliesTo(), o.getAppliesTo(), (Consumer<CounterpartyRoleEnum>) this::addAppliesTo);
			merger.mergeBasic(getRestrictTo(), o.getRestrictTo(), this::setRestrictTo);
			merger.mergeBasic(getRatingPriorityResolution(), o.getRatingPriorityResolution(), this::setRatingPriorityResolution);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteriaBase _that = getType().cast(o);
		
			if (!Objects.equals(collateralCriteria, _that.getCollateralCriteria())) return false;
			if (!ListEquals.listEquals(appliesTo, _that.getAppliesTo())) return false;
			if (!Objects.equals(restrictTo, _that.getRestrictTo())) return false;
			if (!Objects.equals(ratingPriorityResolution, _that.getRatingPriorityResolution())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralCriteria != null ? collateralCriteria.hashCode() : 0);
			_result = 31 * _result + (appliesTo != null ? appliesTo.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (restrictTo != null ? restrictTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingPriorityResolution != null ? ratingPriorityResolution.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteriaBaseBuilder {" +
				"collateralCriteria=" + this.collateralCriteria + ", " +
				"appliesTo=" + this.appliesTo + ", " +
				"restrictTo=" + this.restrictTo + ", " +
				"ratingPriorityResolution=" + this.ratingPriorityResolution +
			'}';
		}
	}
}
