package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilder;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilderImpl;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexImpl;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.meta.FloatingRateIndexMeta;
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
 * Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
 * @version 6.0.0
 */
@RosettaDataType(value="FloatingRateIndex", builder=FloatingRateIndex.FloatingRateIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRateIndex", model="Just another Rosetta model", builder=FloatingRateIndex.FloatingRateIndexBuilderImpl.class, version="6.0.0")
public interface FloatingRateIndex extends IndexBase {

	FloatingRateIndexMeta metaData = new FloatingRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference index that is used to specify the floating interest rate.
	 */
	FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the floating rate tenor.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	FloatingRateIndex build();
	
	FloatingRateIndex.FloatingRateIndexBuilder toBuilder();
	
	static FloatingRateIndex.FloatingRateIndexBuilder builder() {
		return new FloatingRateIndex.FloatingRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndex> getType() {
		return FloatingRateIndex.class;
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
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexBuilder extends FloatingRateIndex, IndexBase.IndexBaseBuilder {
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex();
		@Override
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setExchange(LegalEntity exchange);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setName(FieldWithMetaString name);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setNameValue(String name);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setProvider(LegalEntity provider);
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder setAssetClass(AssetClassEnum assetClass);
		FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex);
		FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex);
		FloatingRateIndex.FloatingRateIndexBuilder setIndexTenor(Period indexTenor);

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
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		FloatingRateIndex.FloatingRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexImpl extends IndexBase.IndexBaseImpl implements FloatingRateIndex {
		private final FieldWithMetaFloatingRateIndexEnum floatingRateIndex;
		private final Period indexTenor;
		
		protected FloatingRateIndexImpl(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			super(builder);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public FloatingRateIndex build() {
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			FloatingRateIndex.FloatingRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndex {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements FloatingRateIndex.FloatingRateIndexBuilder {
	
		protected FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public FloatingRateIndex.FloatingRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public FloatingRateIndex.FloatingRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public FloatingRateIndex.FloatingRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public FloatingRateIndex.FloatingRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public FloatingRateIndex.FloatingRateIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public FloatingRateIndex.FloatingRateIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public FloatingRateIndex.FloatingRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public FloatingRateIndex.FloatingRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public FloatingRateIndex.FloatingRateIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public FloatingRateIndex.FloatingRateIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public FloatingRateIndex.FloatingRateIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder setFloatingRateIndexValue(FloatingRateIndexEnum _floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(_floatingRateIndex);
			return this;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public FloatingRateIndex.FloatingRateIndexBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndex build() {
			return new FloatingRateIndex.FloatingRateIndexImpl(this);
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder prune() {
			super.prune();
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateIndex.FloatingRateIndexBuilder o = (FloatingRateIndex.FloatingRateIndexBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}
}
