package cdm.product.collateral;

import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.CreditNotation.CreditNotationBuilder;
import cdm.observable.asset.CreditNotationBoundaryEnum;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilder;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaImpl;
import cdm.product.collateral.meta.AgencyRatingCriteriaMeta;
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
 * Represents a class to specify a credit notation.
 * @version 6.0.0
 */
@RosettaDataType(value="AgencyRatingCriteria", builder=AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AgencyRatingCriteria", model="Just another Rosetta model", builder=AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl.class, version="6.0.0")
public interface AgencyRatingCriteria extends RosettaModelObject {

	AgencyRatingCriteriaMeta metaData = new AgencyRatingCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the agency rating criteria specified for the asset or issuer.
	 */
	CreditNotation getCreditNotation();
	/**
	 * Indicator for options to be used if several agency ratings (&gt;1) are specified and its necessary to identify specific charateristics. i.e (lowest or highest).
	 */
	CreditNotationMismatchResolutionEnum getMismatchResolution();
	/**
	 * identifies the dominant reference agency if there is a missmatch and several reference agencies exsist.
	 */
	CreditRatingAgencyEnum getReferenceAgency();
	/**
	 * Indicates the boundary of a credit agency rating i.e minimum or maximum.
	 */
	CreditNotationBoundaryEnum getBoundary();

	/*********************** Build Methods  ***********************/
	AgencyRatingCriteria build();
	
	AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder();
	
	static AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder() {
		return new AgencyRatingCriteria.AgencyRatingCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgencyRatingCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgencyRatingCriteria> getType() {
		return AgencyRatingCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditNotation"), processor, CreditNotation.class, getCreditNotation());
		processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
		processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
		processor.processBasic(path.newSubPath("boundary"), CreditNotationBoundaryEnum.class, getBoundary(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgencyRatingCriteriaBuilder extends AgencyRatingCriteria, RosettaModelObjectBuilder {
		CreditNotation.CreditNotationBuilder getOrCreateCreditNotation();
		@Override
		CreditNotation.CreditNotationBuilder getCreditNotation();
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setCreditNotation(CreditNotation creditNotation);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum mismatchResolution);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setReferenceAgency(CreditRatingAgencyEnum referenceAgency);
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder setBoundary(CreditNotationBoundaryEnum boundary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditNotation"), processor, CreditNotation.CreditNotationBuilder.class, getCreditNotation());
			processor.processBasic(path.newSubPath("mismatchResolution"), CreditNotationMismatchResolutionEnum.class, getMismatchResolution(), this);
			processor.processBasic(path.newSubPath("referenceAgency"), CreditRatingAgencyEnum.class, getReferenceAgency(), this);
			processor.processBasic(path.newSubPath("boundary"), CreditNotationBoundaryEnum.class, getBoundary(), this);
		}
		

		AgencyRatingCriteria.AgencyRatingCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of AgencyRatingCriteria  ***********************/
	class AgencyRatingCriteriaImpl implements AgencyRatingCriteria {
		private final CreditNotation creditNotation;
		private final CreditNotationMismatchResolutionEnum mismatchResolution;
		private final CreditRatingAgencyEnum referenceAgency;
		private final CreditNotationBoundaryEnum boundary;
		
		protected AgencyRatingCriteriaImpl(AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder) {
			this.creditNotation = ofNullable(builder.getCreditNotation()).map(f->f.build()).orElse(null);
			this.mismatchResolution = builder.getMismatchResolution();
			this.referenceAgency = builder.getReferenceAgency();
			this.boundary = builder.getBoundary();
		}
		
		@Override
		@RosettaAttribute("creditNotation")
		@RuneAttribute("creditNotation")
		public CreditNotation getCreditNotation() {
			return creditNotation;
		}
		
		@Override
		@RosettaAttribute("mismatchResolution")
		@RuneAttribute("mismatchResolution")
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		@RosettaAttribute("referenceAgency")
		@RuneAttribute("referenceAgency")
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
		@Override
		@RosettaAttribute("boundary")
		@RuneAttribute("boundary")
		public CreditNotationBoundaryEnum getBoundary() {
			return boundary;
		}
		
		@Override
		public AgencyRatingCriteria build() {
			return this;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder() {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgencyRatingCriteria.AgencyRatingCriteriaBuilder builder) {
			ofNullable(getCreditNotation()).ifPresent(builder::setCreditNotation);
			ofNullable(getMismatchResolution()).ifPresent(builder::setMismatchResolution);
			ofNullable(getReferenceAgency()).ifPresent(builder::setReferenceAgency);
			ofNullable(getBoundary()).ifPresent(builder::setBoundary);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgencyRatingCriteria _that = getType().cast(o);
		
			if (!Objects.equals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			if (!Objects.equals(boundary, _that.getBoundary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (boundary != null ? boundary.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgencyRatingCriteria {" +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"referenceAgency=" + this.referenceAgency + ", " +
				"boundary=" + this.boundary +
			'}';
		}
	}

	/*********************** Builder Implementation of AgencyRatingCriteria  ***********************/
	class AgencyRatingCriteriaBuilderImpl implements AgencyRatingCriteria.AgencyRatingCriteriaBuilder {
	
		protected CreditNotation.CreditNotationBuilder creditNotation;
		protected CreditNotationMismatchResolutionEnum mismatchResolution;
		protected CreditRatingAgencyEnum referenceAgency;
		protected CreditNotationBoundaryEnum boundary;
		
		@Override
		@RosettaAttribute("creditNotation")
		@RuneAttribute("creditNotation")
		public CreditNotation.CreditNotationBuilder getCreditNotation() {
			return creditNotation;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder getOrCreateCreditNotation() {
			CreditNotation.CreditNotationBuilder result;
			if (creditNotation!=null) {
				result = creditNotation;
			}
			else {
				result = creditNotation = CreditNotation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mismatchResolution")
		@RuneAttribute("mismatchResolution")
		public CreditNotationMismatchResolutionEnum getMismatchResolution() {
			return mismatchResolution;
		}
		
		@Override
		@RosettaAttribute("referenceAgency")
		@RuneAttribute("referenceAgency")
		public CreditRatingAgencyEnum getReferenceAgency() {
			return referenceAgency;
		}
		
		@Override
		@RosettaAttribute("boundary")
		@RuneAttribute("boundary")
		public CreditNotationBoundaryEnum getBoundary() {
			return boundary;
		}
		
		@Override
		@RosettaAttribute("creditNotation")
		@RuneAttribute("creditNotation")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setCreditNotation(CreditNotation _creditNotation) {
			this.creditNotation = _creditNotation == null ? null : _creditNotation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("mismatchResolution")
		@RuneAttribute("mismatchResolution")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setMismatchResolution(CreditNotationMismatchResolutionEnum _mismatchResolution) {
			this.mismatchResolution = _mismatchResolution == null ? null : _mismatchResolution;
			return this;
		}
		
		@Override
		@RosettaAttribute("referenceAgency")
		@RuneAttribute("referenceAgency")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setReferenceAgency(CreditRatingAgencyEnum _referenceAgency) {
			this.referenceAgency = _referenceAgency == null ? null : _referenceAgency;
			return this;
		}
		
		@Override
		@RosettaAttribute("boundary")
		@RuneAttribute("boundary")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder setBoundary(CreditNotationBoundaryEnum _boundary) {
			this.boundary = _boundary == null ? null : _boundary;
			return this;
		}
		
		@Override
		public AgencyRatingCriteria build() {
			return new AgencyRatingCriteria.AgencyRatingCriteriaImpl(this);
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder prune() {
			if (creditNotation!=null && !creditNotation.prune().hasData()) creditNotation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditNotation()!=null && getCreditNotation().hasData()) return true;
			if (getMismatchResolution()!=null) return true;
			if (getReferenceAgency()!=null) return true;
			if (getBoundary()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder o = (AgencyRatingCriteria.AgencyRatingCriteriaBuilder) other;
			
			merger.mergeRosetta(getCreditNotation(), o.getCreditNotation(), this::setCreditNotation);
			
			merger.mergeBasic(getMismatchResolution(), o.getMismatchResolution(), this::setMismatchResolution);
			merger.mergeBasic(getReferenceAgency(), o.getReferenceAgency(), this::setReferenceAgency);
			merger.mergeBasic(getBoundary(), o.getBoundary(), this::setBoundary);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgencyRatingCriteria _that = getType().cast(o);
		
			if (!Objects.equals(creditNotation, _that.getCreditNotation())) return false;
			if (!Objects.equals(mismatchResolution, _that.getMismatchResolution())) return false;
			if (!Objects.equals(referenceAgency, _that.getReferenceAgency())) return false;
			if (!Objects.equals(boundary, _that.getBoundary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditNotation != null ? creditNotation.hashCode() : 0);
			_result = 31 * _result + (mismatchResolution != null ? mismatchResolution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceAgency != null ? referenceAgency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (boundary != null ? boundary.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgencyRatingCriteriaBuilder {" +
				"creditNotation=" + this.creditNotation + ", " +
				"mismatchResolution=" + this.mismatchResolution + ", " +
				"referenceAgency=" + this.referenceAgency + ", " +
				"boundary=" + this.boundary +
			'}';
		}
	}
}
