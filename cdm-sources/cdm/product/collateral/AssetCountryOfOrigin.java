package cdm.product.collateral;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.AssetCountryOfOrigin;
import cdm.product.collateral.AssetCountryOfOrigin.AssetCountryOfOriginBuilder;
import cdm.product.collateral.AssetCountryOfOrigin.AssetCountryOfOriginBuilderImpl;
import cdm.product.collateral.AssetCountryOfOrigin.AssetCountryOfOriginImpl;
import cdm.product.collateral.meta.AssetCountryOfOriginMeta;
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
@RosettaDataType(value="AssetCountryOfOrigin", builder=AssetCountryOfOrigin.AssetCountryOfOriginBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetCountryOfOrigin", model="Just another Rosetta model", builder=AssetCountryOfOrigin.AssetCountryOfOriginBuilderImpl.class, version="6.0.0")
public interface AssetCountryOfOrigin extends RosettaModelObject {

	AssetCountryOfOriginMeta metaData = new AssetCountryOfOriginMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter on the asset country of origin based on the ISO Standard 3166.
	 */
	ISOCountryCodeEnum getAssetCountryOfOrigin();

	/*********************** Build Methods  ***********************/
	AssetCountryOfOrigin build();
	
	AssetCountryOfOrigin.AssetCountryOfOriginBuilder toBuilder();
	
	static AssetCountryOfOrigin.AssetCountryOfOriginBuilder builder() {
		return new AssetCountryOfOrigin.AssetCountryOfOriginBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetCountryOfOrigin> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetCountryOfOrigin> getType() {
		return AssetCountryOfOrigin.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("assetCountryOfOrigin"), ISOCountryCodeEnum.class, getAssetCountryOfOrigin(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetCountryOfOriginBuilder extends AssetCountryOfOrigin, RosettaModelObjectBuilder {
		AssetCountryOfOrigin.AssetCountryOfOriginBuilder setAssetCountryOfOrigin(ISOCountryCodeEnum assetCountryOfOrigin);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("assetCountryOfOrigin"), ISOCountryCodeEnum.class, getAssetCountryOfOrigin(), this);
		}
		

		AssetCountryOfOrigin.AssetCountryOfOriginBuilder prune();
	}

	/*********************** Immutable Implementation of AssetCountryOfOrigin  ***********************/
	class AssetCountryOfOriginImpl implements AssetCountryOfOrigin {
		private final ISOCountryCodeEnum assetCountryOfOrigin;
		
		protected AssetCountryOfOriginImpl(AssetCountryOfOrigin.AssetCountryOfOriginBuilder builder) {
			this.assetCountryOfOrigin = builder.getAssetCountryOfOrigin();
		}
		
		@Override
		@RosettaAttribute("assetCountryOfOrigin")
		@RuneAttribute("assetCountryOfOrigin")
		public ISOCountryCodeEnum getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		@Override
		public AssetCountryOfOrigin build() {
			return this;
		}
		
		@Override
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder toBuilder() {
			AssetCountryOfOrigin.AssetCountryOfOriginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetCountryOfOrigin.AssetCountryOfOriginBuilder builder) {
			ofNullable(getAssetCountryOfOrigin()).ifPresent(builder::setAssetCountryOfOrigin);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetCountryOfOrigin _that = getType().cast(o);
		
			if (!Objects.equals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetCountryOfOrigin {" +
				"assetCountryOfOrigin=" + this.assetCountryOfOrigin +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetCountryOfOrigin  ***********************/
	class AssetCountryOfOriginBuilderImpl implements AssetCountryOfOrigin.AssetCountryOfOriginBuilder {
	
		protected ISOCountryCodeEnum assetCountryOfOrigin;
		
		@Override
		@RosettaAttribute("assetCountryOfOrigin")
		@RuneAttribute("assetCountryOfOrigin")
		public ISOCountryCodeEnum getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		@Override
		@RosettaAttribute("assetCountryOfOrigin")
		@RuneAttribute("assetCountryOfOrigin")
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder setAssetCountryOfOrigin(ISOCountryCodeEnum _assetCountryOfOrigin) {
			this.assetCountryOfOrigin = _assetCountryOfOrigin == null ? null : _assetCountryOfOrigin;
			return this;
		}
		
		@Override
		public AssetCountryOfOrigin build() {
			return new AssetCountryOfOrigin.AssetCountryOfOriginImpl(this);
		}
		
		@Override
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetCountryOfOrigin()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetCountryOfOrigin.AssetCountryOfOriginBuilder o = (AssetCountryOfOrigin.AssetCountryOfOriginBuilder) other;
			
			
			merger.mergeBasic(getAssetCountryOfOrigin(), o.getAssetCountryOfOrigin(), this::setAssetCountryOfOrigin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetCountryOfOrigin _that = getType().cast(o);
		
			if (!Objects.equals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetCountryOfOriginBuilder {" +
				"assetCountryOfOrigin=" + this.assetCountryOfOrigin +
			'}';
		}
	}
}
