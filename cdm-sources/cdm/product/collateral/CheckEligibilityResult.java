package cdm.product.collateral;

import cdm.product.collateral.CheckEligibilityResult;
import cdm.product.collateral.CheckEligibilityResult.CheckEligibilityResultBuilder;
import cdm.product.collateral.CheckEligibilityResult.CheckEligibilityResultBuilderImpl;
import cdm.product.collateral.CheckEligibilityResult.CheckEligibilityResultImpl;
import cdm.product.collateral.EligibilityQuery;
import cdm.product.collateral.EligibilityQuery.EligibilityQueryBuilder;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder;
import cdm.product.collateral.EligibleCollateralSpecification;
import cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder;
import cdm.product.collateral.meta.CheckEligibilityResultMeta;
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
 * Result for the CheckEligibilityByDetails and CheckEligibilityForProduct functions
 * @version 6.0.0
 */
@RosettaDataType(value="CheckEligibilityResult", builder=CheckEligibilityResult.CheckEligibilityResultBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CheckEligibilityResult", model="Just another Rosetta model", builder=CheckEligibilityResult.CheckEligibilityResultBuilderImpl.class, version="6.0.0")
public interface CheckEligibilityResult extends RosettaModelObject {

	CheckEligibilityResultMeta metaData = new CheckEligibilityResultMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible
	 */
	Boolean getIsEligible();
	/**
	 * if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input
	 */
	List<? extends EligibleCollateralCriteria> getMatchingEligibleCriteria();
	/**
	 * a copy of the input query that was checked against the eligible collateral specification
	 */
	EligibilityQuery getEligibilityQuery();
	/**
	 * a copy of the input EligbilityCollateralSpecification that was checked against the query
	 */
	EligibleCollateralSpecification getSpecification();

	/*********************** Build Methods  ***********************/
	CheckEligibilityResult build();
	
	CheckEligibilityResult.CheckEligibilityResultBuilder toBuilder();
	
	static CheckEligibilityResult.CheckEligibilityResultBuilder builder() {
		return new CheckEligibilityResult.CheckEligibilityResultBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CheckEligibilityResult> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CheckEligibilityResult> getType() {
		return CheckEligibilityResult.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isEligible"), Boolean.class, getIsEligible(), this);
		processRosetta(path.newSubPath("matchingEligibleCriteria"), processor, EligibleCollateralCriteria.class, getMatchingEligibleCriteria());
		processRosetta(path.newSubPath("eligibilityQuery"), processor, EligibilityQuery.class, getEligibilityQuery());
		processRosetta(path.newSubPath("specification"), processor, EligibleCollateralSpecification.class, getSpecification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CheckEligibilityResultBuilder extends CheckEligibilityResult, RosettaModelObjectBuilder {
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateMatchingEligibleCriteria(int _index);
		@Override
		List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getMatchingEligibleCriteria();
		EligibilityQuery.EligibilityQueryBuilder getOrCreateEligibilityQuery();
		@Override
		EligibilityQuery.EligibilityQueryBuilder getEligibilityQuery();
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder getOrCreateSpecification();
		@Override
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder getSpecification();
		CheckEligibilityResult.CheckEligibilityResultBuilder setIsEligible(Boolean isEligible);
		CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(EligibleCollateralCriteria matchingEligibleCriteria);
		CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(EligibleCollateralCriteria matchingEligibleCriteria, int _idx);
		CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(List<? extends EligibleCollateralCriteria> matchingEligibleCriteria);
		CheckEligibilityResult.CheckEligibilityResultBuilder setMatchingEligibleCriteria(List<? extends EligibleCollateralCriteria> matchingEligibleCriteria);
		CheckEligibilityResult.CheckEligibilityResultBuilder setEligibilityQuery(EligibilityQuery eligibilityQuery);
		CheckEligibilityResult.CheckEligibilityResultBuilder setSpecification(EligibleCollateralSpecification specification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isEligible"), Boolean.class, getIsEligible(), this);
			processRosetta(path.newSubPath("matchingEligibleCriteria"), processor, EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder.class, getMatchingEligibleCriteria());
			processRosetta(path.newSubPath("eligibilityQuery"), processor, EligibilityQuery.EligibilityQueryBuilder.class, getEligibilityQuery());
			processRosetta(path.newSubPath("specification"), processor, EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder.class, getSpecification());
		}
		

		CheckEligibilityResult.CheckEligibilityResultBuilder prune();
	}

	/*********************** Immutable Implementation of CheckEligibilityResult  ***********************/
	class CheckEligibilityResultImpl implements CheckEligibilityResult {
		private final Boolean isEligible;
		private final List<? extends EligibleCollateralCriteria> matchingEligibleCriteria;
		private final EligibilityQuery eligibilityQuery;
		private final EligibleCollateralSpecification specification;
		
		protected CheckEligibilityResultImpl(CheckEligibilityResult.CheckEligibilityResultBuilder builder) {
			this.isEligible = builder.getIsEligible();
			this.matchingEligibleCriteria = ofNullable(builder.getMatchingEligibleCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.eligibilityQuery = ofNullable(builder.getEligibilityQuery()).map(f->f.build()).orElse(null);
			this.specification = ofNullable(builder.getSpecification()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isEligible")
		@RuneAttribute("isEligible")
		public Boolean getIsEligible() {
			return isEligible;
		}
		
		@Override
		@RosettaAttribute("matchingEligibleCriteria")
		@RuneAttribute("matchingEligibleCriteria")
		public List<? extends EligibleCollateralCriteria> getMatchingEligibleCriteria() {
			return matchingEligibleCriteria;
		}
		
		@Override
		@RosettaAttribute("eligibilityQuery")
		@RuneAttribute("eligibilityQuery")
		public EligibilityQuery getEligibilityQuery() {
			return eligibilityQuery;
		}
		
		@Override
		@RosettaAttribute("specification")
		@RuneAttribute("specification")
		public EligibleCollateralSpecification getSpecification() {
			return specification;
		}
		
		@Override
		public CheckEligibilityResult build() {
			return this;
		}
		
		@Override
		public CheckEligibilityResult.CheckEligibilityResultBuilder toBuilder() {
			CheckEligibilityResult.CheckEligibilityResultBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CheckEligibilityResult.CheckEligibilityResultBuilder builder) {
			ofNullable(getIsEligible()).ifPresent(builder::setIsEligible);
			ofNullable(getMatchingEligibleCriteria()).ifPresent(builder::setMatchingEligibleCriteria);
			ofNullable(getEligibilityQuery()).ifPresent(builder::setEligibilityQuery);
			ofNullable(getSpecification()).ifPresent(builder::setSpecification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CheckEligibilityResult _that = getType().cast(o);
		
			if (!Objects.equals(isEligible, _that.getIsEligible())) return false;
			if (!ListEquals.listEquals(matchingEligibleCriteria, _that.getMatchingEligibleCriteria())) return false;
			if (!Objects.equals(eligibilityQuery, _that.getEligibilityQuery())) return false;
			if (!Objects.equals(specification, _that.getSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isEligible != null ? isEligible.hashCode() : 0);
			_result = 31 * _result + (matchingEligibleCriteria != null ? matchingEligibleCriteria.hashCode() : 0);
			_result = 31 * _result + (eligibilityQuery != null ? eligibilityQuery.hashCode() : 0);
			_result = 31 * _result + (specification != null ? specification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CheckEligibilityResult {" +
				"isEligible=" + this.isEligible + ", " +
				"matchingEligibleCriteria=" + this.matchingEligibleCriteria + ", " +
				"eligibilityQuery=" + this.eligibilityQuery + ", " +
				"specification=" + this.specification +
			'}';
		}
	}

	/*********************** Builder Implementation of CheckEligibilityResult  ***********************/
	class CheckEligibilityResultBuilderImpl implements CheckEligibilityResult.CheckEligibilityResultBuilder {
	
		protected Boolean isEligible;
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> matchingEligibleCriteria = new ArrayList<>();
		protected EligibilityQuery.EligibilityQueryBuilder eligibilityQuery;
		protected EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder specification;
		
		@Override
		@RosettaAttribute("isEligible")
		@RuneAttribute("isEligible")
		public Boolean getIsEligible() {
			return isEligible;
		}
		
		@Override
		@RosettaAttribute("matchingEligibleCriteria")
		@RuneAttribute("matchingEligibleCriteria")
		public List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getMatchingEligibleCriteria() {
			return matchingEligibleCriteria;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateMatchingEligibleCriteria(int _index) {
		
			if (matchingEligibleCriteria==null) {
				this.matchingEligibleCriteria = new ArrayList<>();
			}
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder result;
			return getIndex(matchingEligibleCriteria, _index, () -> {
						EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder newMatchingEligibleCriteria = EligibleCollateralCriteria.builder();
						return newMatchingEligibleCriteria;
					});
		}
		
		@Override
		@RosettaAttribute("eligibilityQuery")
		@RuneAttribute("eligibilityQuery")
		public EligibilityQuery.EligibilityQueryBuilder getEligibilityQuery() {
			return eligibilityQuery;
		}
		
		@Override
		public EligibilityQuery.EligibilityQueryBuilder getOrCreateEligibilityQuery() {
			EligibilityQuery.EligibilityQueryBuilder result;
			if (eligibilityQuery!=null) {
				result = eligibilityQuery;
			}
			else {
				result = eligibilityQuery = EligibilityQuery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specification")
		@RuneAttribute("specification")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder getSpecification() {
			return specification;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder getOrCreateSpecification() {
			EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder result;
			if (specification!=null) {
				result = specification;
			}
			else {
				result = specification = EligibleCollateralSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isEligible")
		@RuneAttribute("isEligible")
		public CheckEligibilityResult.CheckEligibilityResultBuilder setIsEligible(Boolean _isEligible) {
			this.isEligible = _isEligible == null ? null : _isEligible;
			return this;
		}
		
		@Override
		@RosettaAttribute("matchingEligibleCriteria")
		@RuneAttribute("matchingEligibleCriteria")
		public CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(EligibleCollateralCriteria _matchingEligibleCriteria) {
			if (_matchingEligibleCriteria != null) {
				this.matchingEligibleCriteria.add(_matchingEligibleCriteria.toBuilder());
			}
			return this;
		}
		
		@Override
		public CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(EligibleCollateralCriteria _matchingEligibleCriteria, int _idx) {
			getIndex(this.matchingEligibleCriteria, _idx, () -> _matchingEligibleCriteria.toBuilder());
			return this;
		}
		
		@Override 
		public CheckEligibilityResult.CheckEligibilityResultBuilder addMatchingEligibleCriteria(List<? extends EligibleCollateralCriteria> matchingEligibleCriterias) {
			if (matchingEligibleCriterias != null) {
				for (final EligibleCollateralCriteria toAdd : matchingEligibleCriterias) {
					this.matchingEligibleCriteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("matchingEligibleCriteria")
		public CheckEligibilityResult.CheckEligibilityResultBuilder setMatchingEligibleCriteria(List<? extends EligibleCollateralCriteria> matchingEligibleCriterias) {
			if (matchingEligibleCriterias == null) {
				this.matchingEligibleCriteria = new ArrayList<>();
			} else {
				this.matchingEligibleCriteria = matchingEligibleCriterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("eligibilityQuery")
		@RuneAttribute("eligibilityQuery")
		public CheckEligibilityResult.CheckEligibilityResultBuilder setEligibilityQuery(EligibilityQuery _eligibilityQuery) {
			this.eligibilityQuery = _eligibilityQuery == null ? null : _eligibilityQuery.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("specification")
		@RuneAttribute("specification")
		public CheckEligibilityResult.CheckEligibilityResultBuilder setSpecification(EligibleCollateralSpecification _specification) {
			this.specification = _specification == null ? null : _specification.toBuilder();
			return this;
		}
		
		@Override
		public CheckEligibilityResult build() {
			return new CheckEligibilityResult.CheckEligibilityResultImpl(this);
		}
		
		@Override
		public CheckEligibilityResult.CheckEligibilityResultBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CheckEligibilityResult.CheckEligibilityResultBuilder prune() {
			matchingEligibleCriteria = matchingEligibleCriteria.stream().filter(b->b!=null).<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (eligibilityQuery!=null && !eligibilityQuery.prune().hasData()) eligibilityQuery = null;
			if (specification!=null && !specification.prune().hasData()) specification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsEligible()!=null) return true;
			if (getMatchingEligibleCriteria()!=null && getMatchingEligibleCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEligibilityQuery()!=null && getEligibilityQuery().hasData()) return true;
			if (getSpecification()!=null && getSpecification().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CheckEligibilityResult.CheckEligibilityResultBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CheckEligibilityResult.CheckEligibilityResultBuilder o = (CheckEligibilityResult.CheckEligibilityResultBuilder) other;
			
			merger.mergeRosetta(getMatchingEligibleCriteria(), o.getMatchingEligibleCriteria(), this::getOrCreateMatchingEligibleCriteria);
			merger.mergeRosetta(getEligibilityQuery(), o.getEligibilityQuery(), this::setEligibilityQuery);
			merger.mergeRosetta(getSpecification(), o.getSpecification(), this::setSpecification);
			
			merger.mergeBasic(getIsEligible(), o.getIsEligible(), this::setIsEligible);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CheckEligibilityResult _that = getType().cast(o);
		
			if (!Objects.equals(isEligible, _that.getIsEligible())) return false;
			if (!ListEquals.listEquals(matchingEligibleCriteria, _that.getMatchingEligibleCriteria())) return false;
			if (!Objects.equals(eligibilityQuery, _that.getEligibilityQuery())) return false;
			if (!Objects.equals(specification, _that.getSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isEligible != null ? isEligible.hashCode() : 0);
			_result = 31 * _result + (matchingEligibleCriteria != null ? matchingEligibleCriteria.hashCode() : 0);
			_result = 31 * _result + (eligibilityQuery != null ? eligibilityQuery.hashCode() : 0);
			_result = 31 * _result + (specification != null ? specification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CheckEligibilityResultBuilder {" +
				"isEligible=" + this.isEligible + ", " +
				"matchingEligibleCriteria=" + this.matchingEligibleCriteria + ", " +
				"eligibilityQuery=" + this.eligibilityQuery + ", " +
				"specification=" + this.specification +
			'}';
		}
	}
}
