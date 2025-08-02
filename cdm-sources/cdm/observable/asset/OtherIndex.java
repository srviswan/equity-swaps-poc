package cdm.observable.asset;

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
import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.OtherIndex.OtherIndexBuilder;
import cdm.observable.asset.OtherIndex.OtherIndexBuilderImpl;
import cdm.observable.asset.OtherIndex.OtherIndexImpl;
import cdm.observable.asset.meta.OtherIndexMeta;
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
 * Specification of a user-defined index that does not meet the criteria of other Index data types.
 * @version 6.0.0
 */
@RosettaDataType(value="OtherIndex", builder=OtherIndex.OtherIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="OtherIndex", model="Just another Rosetta model", builder=OtherIndex.OtherIndexBuilderImpl.class, version="6.0.0")
public interface OtherIndex extends IndexBase {

	OtherIndexMeta metaData = new OtherIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A description that defines the OtherIndex.
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	OtherIndex build();
	
	OtherIndex.OtherIndexBuilder toBuilder();
	
	static OtherIndex.OtherIndexBuilder builder() {
		return new OtherIndex.OtherIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherIndex> getType() {
		return OtherIndex.class;
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
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherIndexBuilder extends OtherIndex, IndexBase.IndexBaseBuilder {
		@Override
		OtherIndex.OtherIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		OtherIndex.OtherIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		OtherIndex.OtherIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		OtherIndex.OtherIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		OtherIndex.OtherIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		OtherIndex.OtherIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		OtherIndex.OtherIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		OtherIndex.OtherIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		OtherIndex.OtherIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		OtherIndex.OtherIndexBuilder setExchange(LegalEntity exchange);
		@Override
		OtherIndex.OtherIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		OtherIndex.OtherIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		OtherIndex.OtherIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		OtherIndex.OtherIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		OtherIndex.OtherIndexBuilder setName(FieldWithMetaString name);
		@Override
		OtherIndex.OtherIndexBuilder setNameValue(String name);
		@Override
		OtherIndex.OtherIndexBuilder setProvider(LegalEntity provider);
		@Override
		OtherIndex.OtherIndexBuilder setAssetClass(AssetClassEnum assetClass);
		OtherIndex.OtherIndexBuilder setDescription(String description);

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
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		OtherIndex.OtherIndexBuilder prune();
	}

	/*********************** Immutable Implementation of OtherIndex  ***********************/
	class OtherIndexImpl extends IndexBase.IndexBaseImpl implements OtherIndex {
		private final String description;
		
		protected OtherIndexImpl(OtherIndex.OtherIndexBuilder builder) {
			super(builder);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public OtherIndex build() {
			return this;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder toBuilder() {
			OtherIndex.OtherIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherIndex.OtherIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OtherIndex _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherIndex {" +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OtherIndex  ***********************/
	class OtherIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements OtherIndex.OtherIndexBuilder {
	
		protected String description;
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public OtherIndex.OtherIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public OtherIndex.OtherIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public OtherIndex.OtherIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public OtherIndex.OtherIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public OtherIndex.OtherIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public OtherIndex.OtherIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public OtherIndex.OtherIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public OtherIndex.OtherIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public OtherIndex.OtherIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public OtherIndex.OtherIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public OtherIndex.OtherIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public OtherIndex.OtherIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public OtherIndex.OtherIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public OtherIndex.OtherIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public OtherIndex.OtherIndexBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public OtherIndex build() {
			return new OtherIndex.OtherIndexImpl(this);
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherIndex.OtherIndexBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherIndex.OtherIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OtherIndex.OtherIndexBuilder o = (OtherIndex.OtherIndexBuilder) other;
			
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OtherIndex _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherIndexBuilder {" +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
