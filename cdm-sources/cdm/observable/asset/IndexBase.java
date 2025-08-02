package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.meta.IndexBaseMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies an index by referencing an identifier.
 * @version 6.0.0
 */
@RosettaDataType(value="IndexBase", builder=IndexBase.IndexBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="IndexBase", model="Just another Rosetta model", builder=IndexBase.IndexBaseBuilderImpl.class, version="6.0.0")
public interface IndexBase extends AssetBase {

	IndexBaseMeta metaData = new IndexBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A description of the Index.
	 */
	FieldWithMetaString getName();
	/**
	 * The organisation that creates or maintains the Index.
	 */
	LegalEntity getProvider();
	/**
	 * The Asset Class of the Index.
	 */
	AssetClassEnum getAssetClass();

	/*********************** Build Methods  ***********************/
	IndexBase build();
	
	IndexBase.IndexBaseBuilder toBuilder();
	
	static IndexBase.IndexBaseBuilder builder() {
		return new IndexBase.IndexBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexBase> getType() {
		return IndexBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("provider"), processor, LegalEntity.class, getProvider());
		processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexBaseBuilder extends IndexBase, AssetBase.AssetBaseBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getName();
		LegalEntity.LegalEntityBuilder getOrCreateProvider();
		@Override
		LegalEntity.LegalEntityBuilder getProvider();
		@Override
		IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		IndexBase.IndexBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		IndexBase.IndexBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		IndexBase.IndexBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		IndexBase.IndexBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		IndexBase.IndexBaseBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		IndexBase.IndexBaseBuilder setExchange(LegalEntity exchange);
		@Override
		IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		IndexBase.IndexBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		IndexBase.IndexBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		IndexBase.IndexBaseBuilder setName(FieldWithMetaString name);
		IndexBase.IndexBaseBuilder setNameValue(String name);
		IndexBase.IndexBaseBuilder setProvider(LegalEntity provider);
		IndexBase.IndexBaseBuilder setAssetClass(AssetClassEnum assetClass);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("provider"), processor, LegalEntity.LegalEntityBuilder.class, getProvider());
			processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
		}
		

		IndexBase.IndexBaseBuilder prune();
	}

	/*********************** Immutable Implementation of IndexBase  ***********************/
	class IndexBaseImpl extends AssetBase.AssetBaseImpl implements IndexBase {
		private final FieldWithMetaString name;
		private final LegalEntity provider;
		private final AssetClassEnum assetClass;
		
		protected IndexBaseImpl(IndexBase.IndexBaseBuilder builder) {
			super(builder);
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.provider = ofNullable(builder.getProvider()).map(f->f.build()).orElse(null);
			this.assetClass = builder.getAssetClass();
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public LegalEntity getProvider() {
			return provider;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public AssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		public IndexBase build() {
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder toBuilder() {
			IndexBase.IndexBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexBase.IndexBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getProvider()).ifPresent(builder::setProvider);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexBase _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(provider, _that.getProvider())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (provider != null ? provider.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBase {" +
				"name=" + this.name + ", " +
				"provider=" + this.provider + ", " +
				"assetClass=" + this.assetClass +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IndexBase  ***********************/
	class IndexBaseBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements IndexBase.IndexBaseBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder name;
		protected LegalEntity.LegalEntityBuilder provider;
		protected AssetClassEnum assetClass;
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public FieldWithMetaString.FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public LegalEntity.LegalEntityBuilder getProvider() {
			return provider;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateProvider() {
			LegalEntity.LegalEntityBuilder result;
			if (provider!=null) {
				result = provider;
			}
			else {
				result = provider = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public AssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public IndexBase.IndexBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public IndexBase.IndexBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null) {
				this.taxonomy = new ArrayList<>();
			} else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		@RuneAttribute("isExchangeListed")
		public IndexBase.IndexBaseBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public IndexBase.IndexBaseBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public IndexBase.IndexBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public IndexBase.IndexBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null) {
				this.relatedExchange = new ArrayList<>();
			} else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public IndexBase.IndexBaseBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public IndexBase.IndexBaseBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public IndexBase.IndexBaseBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public IndexBase.IndexBaseBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		public IndexBase build() {
			return new IndexBase.IndexBaseImpl(this);
		}
		
		@Override
		public IndexBase.IndexBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexBase.IndexBaseBuilder prune() {
			super.prune();
			if (name!=null && !name.prune().hasData()) name = null;
			if (provider!=null && !provider.prune().hasData()) provider = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getName()!=null) return true;
			if (getProvider()!=null && getProvider().hasData()) return true;
			if (getAssetClass()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexBase.IndexBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IndexBase.IndexBaseBuilder o = (IndexBase.IndexBaseBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getProvider(), o.getProvider(), this::setProvider);
			
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexBase _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(provider, _that.getProvider())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (provider != null ? provider.hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBaseBuilder {" +
				"name=" + this.name + ", " +
				"provider=" + this.provider + ", " +
				"assetClass=" + this.assetClass +
			'}' + " " + super.toString();
		}
	}
}
