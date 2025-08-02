package cdm.product.collateral;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilder;
import cdm.product.collateral.SovereignAgencyRating;
import cdm.product.collateral.SovereignAgencyRating.SovereignAgencyRatingBuilder;
import cdm.product.collateral.SovereignAgencyRating.SovereignAgencyRatingBuilderImpl;
import cdm.product.collateral.SovereignAgencyRating.SovereignAgencyRatingImpl;
import cdm.product.collateral.meta.SovereignAgencyRatingMeta;
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
@RosettaDataType(value="SovereignAgencyRating", builder=SovereignAgencyRating.SovereignAgencyRatingBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SovereignAgencyRating", model="Just another Rosetta model", builder=SovereignAgencyRating.SovereignAgencyRatingBuilderImpl.class, version="6.0.0")
public interface SovereignAgencyRating extends RosettaModelObject {

	SovereignAgencyRatingMeta metaData = new SovereignAgencyRatingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents an agency rating based on default risk of the country of the issuer.
	 */
	AgencyRatingCriteria getSovereignAgencyRating();

	/*********************** Build Methods  ***********************/
	SovereignAgencyRating build();
	
	SovereignAgencyRating.SovereignAgencyRatingBuilder toBuilder();
	
	static SovereignAgencyRating.SovereignAgencyRatingBuilder builder() {
		return new SovereignAgencyRating.SovereignAgencyRatingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SovereignAgencyRating> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SovereignAgencyRating> getType() {
		return SovereignAgencyRating.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sovereignAgencyRating"), processor, AgencyRatingCriteria.class, getSovereignAgencyRating());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SovereignAgencyRatingBuilder extends SovereignAgencyRating, RosettaModelObjectBuilder {
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateSovereignAgencyRating();
		@Override
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getSovereignAgencyRating();
		SovereignAgencyRating.SovereignAgencyRatingBuilder setSovereignAgencyRating(AgencyRatingCriteria sovereignAgencyRating);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sovereignAgencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getSovereignAgencyRating());
		}
		

		SovereignAgencyRating.SovereignAgencyRatingBuilder prune();
	}

	/*********************** Immutable Implementation of SovereignAgencyRating  ***********************/
	class SovereignAgencyRatingImpl implements SovereignAgencyRating {
		private final AgencyRatingCriteria sovereignAgencyRating;
		
		protected SovereignAgencyRatingImpl(SovereignAgencyRating.SovereignAgencyRatingBuilder builder) {
			this.sovereignAgencyRating = ofNullable(builder.getSovereignAgencyRating()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sovereignAgencyRating")
		@RuneAttribute("sovereignAgencyRating")
		public AgencyRatingCriteria getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		@Override
		public SovereignAgencyRating build() {
			return this;
		}
		
		@Override
		public SovereignAgencyRating.SovereignAgencyRatingBuilder toBuilder() {
			SovereignAgencyRating.SovereignAgencyRatingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SovereignAgencyRating.SovereignAgencyRatingBuilder builder) {
			ofNullable(getSovereignAgencyRating()).ifPresent(builder::setSovereignAgencyRating);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SovereignAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SovereignAgencyRating {" +
				"sovereignAgencyRating=" + this.sovereignAgencyRating +
			'}';
		}
	}

	/*********************** Builder Implementation of SovereignAgencyRating  ***********************/
	class SovereignAgencyRatingBuilderImpl implements SovereignAgencyRating.SovereignAgencyRatingBuilder {
	
		protected AgencyRatingCriteria.AgencyRatingCriteriaBuilder sovereignAgencyRating;
		
		@Override
		@RosettaAttribute("sovereignAgencyRating")
		@RuneAttribute("sovereignAgencyRating")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateSovereignAgencyRating() {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			if (sovereignAgencyRating!=null) {
				result = sovereignAgencyRating;
			}
			else {
				result = sovereignAgencyRating = AgencyRatingCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sovereignAgencyRating")
		@RuneAttribute("sovereignAgencyRating")
		public SovereignAgencyRating.SovereignAgencyRatingBuilder setSovereignAgencyRating(AgencyRatingCriteria _sovereignAgencyRating) {
			this.sovereignAgencyRating = _sovereignAgencyRating == null ? null : _sovereignAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		public SovereignAgencyRating build() {
			return new SovereignAgencyRating.SovereignAgencyRatingImpl(this);
		}
		
		@Override
		public SovereignAgencyRating.SovereignAgencyRatingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SovereignAgencyRating.SovereignAgencyRatingBuilder prune() {
			if (sovereignAgencyRating!=null && !sovereignAgencyRating.prune().hasData()) sovereignAgencyRating = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSovereignAgencyRating()!=null && getSovereignAgencyRating().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SovereignAgencyRating.SovereignAgencyRatingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SovereignAgencyRating.SovereignAgencyRatingBuilder o = (SovereignAgencyRating.SovereignAgencyRatingBuilder) other;
			
			merger.mergeRosetta(getSovereignAgencyRating(), o.getSovereignAgencyRating(), this::setSovereignAgencyRating);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SovereignAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SovereignAgencyRatingBuilder {" +
				"sovereignAgencyRating=" + this.sovereignAgencyRating +
			'}';
		}
	}
}
