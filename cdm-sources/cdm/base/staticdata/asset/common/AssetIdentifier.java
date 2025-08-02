package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilderImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierImpl;
import cdm.base.staticdata.asset.common.meta.AssetIdentifierMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The unique identifier for an Asset, specified using an Asset Identifier Type enumerator.
 * @version 6.0.0
 */
@RosettaDataType(value="AssetIdentifier", builder=AssetIdentifier.AssetIdentifierBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetIdentifier", model="Just another Rosetta model", builder=AssetIdentifier.AssetIdentifierBuilderImpl.class, version="6.0.0")
public interface AssetIdentifier extends RosettaModelObject {

	AssetIdentifierMeta metaData = new AssetIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The identifier value.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.
	 */
	AssetIdTypeEnum getIdentifierType();

	/*********************** Build Methods  ***********************/
	AssetIdentifier build();
	
	AssetIdentifier.AssetIdentifierBuilder toBuilder();
	
	static AssetIdentifier.AssetIdentifierBuilder builder() {
		return new AssetIdentifier.AssetIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetIdentifier> getType() {
		return AssetIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processor.processBasic(path.newSubPath("identifierType"), AssetIdTypeEnum.class, getIdentifierType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetIdentifierBuilder extends AssetIdentifier, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier();
		AssetIdentifier.AssetIdentifierBuilder setIdentifier(FieldWithMetaString identifier);
		AssetIdentifier.AssetIdentifierBuilder setIdentifierValue(String identifier);
		AssetIdentifier.AssetIdentifierBuilder setIdentifierType(AssetIdTypeEnum identifierType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getIdentifier());
			processor.processBasic(path.newSubPath("identifierType"), AssetIdTypeEnum.class, getIdentifierType(), this);
		}
		

		AssetIdentifier.AssetIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of AssetIdentifier  ***********************/
	class AssetIdentifierImpl implements AssetIdentifier {
		private final FieldWithMetaString identifier;
		private final AssetIdTypeEnum identifierType;
		
		protected AssetIdentifierImpl(AssetIdentifier.AssetIdentifierBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.identifierType = builder.getIdentifierType();
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public AssetIdTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		public AssetIdentifier build() {
			return this;
		}
		
		@Override
		public AssetIdentifier.AssetIdentifierBuilder toBuilder() {
			AssetIdentifier.AssetIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetIdentifier.AssetIdentifierBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getIdentifierType()).ifPresent(builder::setIdentifierType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetIdentifier {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetIdentifier  ***********************/
	class AssetIdentifierBuilderImpl implements AssetIdentifier.AssetIdentifierBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder identifier;
		protected AssetIdTypeEnum identifierType;
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public AssetIdTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public AssetIdentifier.AssetIdentifierBuilder setIdentifier(FieldWithMetaString _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public AssetIdentifier.AssetIdentifierBuilder setIdentifierValue(String _identifier) {
			this.getOrCreateIdentifier().setValue(_identifier);
			return this;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public AssetIdentifier.AssetIdentifierBuilder setIdentifierType(AssetIdTypeEnum _identifierType) {
			this.identifierType = _identifierType == null ? null : _identifierType;
			return this;
		}
		
		@Override
		public AssetIdentifier build() {
			return new AssetIdentifier.AssetIdentifierImpl(this);
		}
		
		@Override
		public AssetIdentifier.AssetIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetIdentifier.AssetIdentifierBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getIdentifierType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetIdentifier.AssetIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetIdentifier.AssetIdentifierBuilder o = (AssetIdentifier.AssetIdentifierBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			merger.mergeBasic(getIdentifierType(), o.getIdentifierType(), this::setIdentifierType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetIdentifierBuilder {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType +
			'}';
		}
	}
}
