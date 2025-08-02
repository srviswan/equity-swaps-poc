package cdm.product.collateral;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilder;
import cdm.product.collateral.IssuerAgencyRating;
import cdm.product.collateral.IssuerAgencyRating.IssuerAgencyRatingBuilder;
import cdm.product.collateral.IssuerAgencyRating.IssuerAgencyRatingBuilderImpl;
import cdm.product.collateral.IssuerAgencyRating.IssuerAgencyRatingImpl;
import cdm.product.collateral.meta.IssuerAgencyRatingMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="IssuerAgencyRating", builder=IssuerAgencyRating.IssuerAgencyRatingBuilderImpl.class, version="6.0.0")
@RuneDataType(value="IssuerAgencyRating", model="Just another Rosetta model", builder=IssuerAgencyRating.IssuerAgencyRatingBuilderImpl.class, version="6.0.0")
public interface IssuerAgencyRating extends RosettaModelObject {

	IssuerAgencyRatingMeta metaData = new IssuerAgencyRatingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents an agency rating based on default risk and creditors claim in event of default associated with asset issuer.
	 */
	AgencyRatingCriteria getIssuerAgencyRating();

	/*********************** Build Methods  ***********************/
	IssuerAgencyRating build();
	
	IssuerAgencyRating.IssuerAgencyRatingBuilder toBuilder();
	
	static IssuerAgencyRating.IssuerAgencyRatingBuilder builder() {
		return new IssuerAgencyRating.IssuerAgencyRatingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerAgencyRating> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IssuerAgencyRating> getType() {
		return IssuerAgencyRating.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerAgencyRating"), processor, AgencyRatingCriteria.class, getIssuerAgencyRating());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerAgencyRatingBuilder extends IssuerAgencyRating, RosettaModelObjectBuilder {
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateIssuerAgencyRating();
		@Override
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getIssuerAgencyRating();
		IssuerAgencyRating.IssuerAgencyRatingBuilder setIssuerAgencyRating(AgencyRatingCriteria issuerAgencyRating);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerAgencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getIssuerAgencyRating());
		}
		

		IssuerAgencyRating.IssuerAgencyRatingBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerAgencyRating  ***********************/
	class IssuerAgencyRatingImpl implements IssuerAgencyRating {
		private final AgencyRatingCriteria issuerAgencyRating;
		
		protected IssuerAgencyRatingImpl(IssuerAgencyRating.IssuerAgencyRatingBuilder builder) {
			this.issuerAgencyRating = ofNullable(builder.getIssuerAgencyRating()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuerAgencyRating")
		@RuneAttribute("issuerAgencyRating")
		public AgencyRatingCriteria getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		@Override
		public IssuerAgencyRating build() {
			return this;
		}
		
		@Override
		public IssuerAgencyRating.IssuerAgencyRatingBuilder toBuilder() {
			IssuerAgencyRating.IssuerAgencyRatingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerAgencyRating.IssuerAgencyRatingBuilder builder) {
			ofNullable(getIssuerAgencyRating()).ifPresent(builder::setIssuerAgencyRating);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerAgencyRating {" +
				"issuerAgencyRating=" + this.issuerAgencyRating +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerAgencyRating  ***********************/
	class IssuerAgencyRatingBuilderImpl implements IssuerAgencyRating.IssuerAgencyRatingBuilder {
	
		protected AgencyRatingCriteria.AgencyRatingCriteriaBuilder issuerAgencyRating;
		
		@Override
		@RosettaAttribute("issuerAgencyRating")
		@RuneAttribute("issuerAgencyRating")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateIssuerAgencyRating() {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			if (issuerAgencyRating!=null) {
				result = issuerAgencyRating;
			}
			else {
				result = issuerAgencyRating = AgencyRatingCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerAgencyRating")
		@RuneAttribute("issuerAgencyRating")
		public IssuerAgencyRating.IssuerAgencyRatingBuilder setIssuerAgencyRating(AgencyRatingCriteria _issuerAgencyRating) {
			this.issuerAgencyRating = _issuerAgencyRating == null ? null : _issuerAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		public IssuerAgencyRating build() {
			return new IssuerAgencyRating.IssuerAgencyRatingImpl(this);
		}
		
		@Override
		public IssuerAgencyRating.IssuerAgencyRatingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerAgencyRating.IssuerAgencyRatingBuilder prune() {
			if (issuerAgencyRating!=null && !issuerAgencyRating.prune().hasData()) issuerAgencyRating = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerAgencyRating()!=null && getIssuerAgencyRating().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerAgencyRating.IssuerAgencyRatingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerAgencyRating.IssuerAgencyRatingBuilder o = (IssuerAgencyRating.IssuerAgencyRatingBuilder) other;
			
			merger.mergeRosetta(getIssuerAgencyRating(), o.getIssuerAgencyRating(), this::setIssuerAgencyRating);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerAgencyRatingBuilder {" +
				"issuerAgencyRating=" + this.issuerAgencyRating +
			'}';
		}
	}
}
