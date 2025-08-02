package cdm.product.collateral;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilder;
import cdm.product.collateral.AssetAgencyRating;
import cdm.product.collateral.AssetAgencyRating.AssetAgencyRatingBuilder;
import cdm.product.collateral.AssetAgencyRating.AssetAgencyRatingBuilderImpl;
import cdm.product.collateral.AssetAgencyRating.AssetAgencyRatingImpl;
import cdm.product.collateral.meta.AssetAgencyRatingMeta;
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
@RosettaDataType(value="AssetAgencyRating", builder=AssetAgencyRating.AssetAgencyRatingBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetAgencyRating", model="Just another Rosetta model", builder=AssetAgencyRating.AssetAgencyRatingBuilderImpl.class, version="6.0.0")
public interface AssetAgencyRating extends RosettaModelObject {

	AssetAgencyRatingMeta metaData = new AssetAgencyRatingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents an agency rating based on default risk and creditors claim in event of default associated with specific instrument.
	 */
	AgencyRatingCriteria getAssetAgencyRating();

	/*********************** Build Methods  ***********************/
	AssetAgencyRating build();
	
	AssetAgencyRating.AssetAgencyRatingBuilder toBuilder();
	
	static AssetAgencyRating.AssetAgencyRatingBuilder builder() {
		return new AssetAgencyRating.AssetAgencyRatingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetAgencyRating> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetAgencyRating> getType() {
		return AssetAgencyRating.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assetAgencyRating"), processor, AgencyRatingCriteria.class, getAssetAgencyRating());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetAgencyRatingBuilder extends AssetAgencyRating, RosettaModelObjectBuilder {
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateAssetAgencyRating();
		@Override
		AgencyRatingCriteria.AgencyRatingCriteriaBuilder getAssetAgencyRating();
		AssetAgencyRating.AssetAgencyRatingBuilder setAssetAgencyRating(AgencyRatingCriteria assetAgencyRating);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assetAgencyRating"), processor, AgencyRatingCriteria.AgencyRatingCriteriaBuilder.class, getAssetAgencyRating());
		}
		

		AssetAgencyRating.AssetAgencyRatingBuilder prune();
	}

	/*********************** Immutable Implementation of AssetAgencyRating  ***********************/
	class AssetAgencyRatingImpl implements AssetAgencyRating {
		private final AgencyRatingCriteria assetAgencyRating;
		
		protected AssetAgencyRatingImpl(AssetAgencyRating.AssetAgencyRatingBuilder builder) {
			this.assetAgencyRating = ofNullable(builder.getAssetAgencyRating()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("assetAgencyRating")
		@RuneAttribute("assetAgencyRating")
		public AgencyRatingCriteria getAssetAgencyRating() {
			return assetAgencyRating;
		}
		
		@Override
		public AssetAgencyRating build() {
			return this;
		}
		
		@Override
		public AssetAgencyRating.AssetAgencyRatingBuilder toBuilder() {
			AssetAgencyRating.AssetAgencyRatingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetAgencyRating.AssetAgencyRatingBuilder builder) {
			ofNullable(getAssetAgencyRating()).ifPresent(builder::setAssetAgencyRating);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(assetAgencyRating, _that.getAssetAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetAgencyRating != null ? assetAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetAgencyRating {" +
				"assetAgencyRating=" + this.assetAgencyRating +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetAgencyRating  ***********************/
	class AssetAgencyRatingBuilderImpl implements AssetAgencyRating.AssetAgencyRatingBuilder {
	
		protected AgencyRatingCriteria.AgencyRatingCriteriaBuilder assetAgencyRating;
		
		@Override
		@RosettaAttribute("assetAgencyRating")
		@RuneAttribute("assetAgencyRating")
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getAssetAgencyRating() {
			return assetAgencyRating;
		}
		
		@Override
		public AgencyRatingCriteria.AgencyRatingCriteriaBuilder getOrCreateAssetAgencyRating() {
			AgencyRatingCriteria.AgencyRatingCriteriaBuilder result;
			if (assetAgencyRating!=null) {
				result = assetAgencyRating;
			}
			else {
				result = assetAgencyRating = AgencyRatingCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetAgencyRating")
		@RuneAttribute("assetAgencyRating")
		public AssetAgencyRating.AssetAgencyRatingBuilder setAssetAgencyRating(AgencyRatingCriteria _assetAgencyRating) {
			this.assetAgencyRating = _assetAgencyRating == null ? null : _assetAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		public AssetAgencyRating build() {
			return new AssetAgencyRating.AssetAgencyRatingImpl(this);
		}
		
		@Override
		public AssetAgencyRating.AssetAgencyRatingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetAgencyRating.AssetAgencyRatingBuilder prune() {
			if (assetAgencyRating!=null && !assetAgencyRating.prune().hasData()) assetAgencyRating = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetAgencyRating()!=null && getAssetAgencyRating().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetAgencyRating.AssetAgencyRatingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetAgencyRating.AssetAgencyRatingBuilder o = (AssetAgencyRating.AssetAgencyRatingBuilder) other;
			
			merger.mergeRosetta(getAssetAgencyRating(), o.getAssetAgencyRating(), this::setAssetAgencyRating);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetAgencyRating _that = getType().cast(o);
		
			if (!Objects.equals(assetAgencyRating, _that.getAssetAgencyRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetAgencyRating != null ? assetAgencyRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetAgencyRatingBuilder {" +
				"assetAgencyRating=" + this.assetAgencyRating +
			'}';
		}
	}
}
