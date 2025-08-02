package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InflationIndex.InflationIndexBuilder;
import cdm.observable.asset.InflationIndex.InflationIndexBuilderImpl;
import cdm.observable.asset.InflationIndex.InflationIndexImpl;
import cdm.observable.asset.meta.InflationIndexMeta;
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
 * Specification of an index that measures inflation in a specific market, e.g. the US Consumer Price Index.
 * @version 6.0.0
 */
@RosettaDataType(value="InflationIndex", builder=InflationIndex.InflationIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="InflationIndex", model="Just another Rosetta model", builder=InflationIndex.InflationIndexBuilderImpl.class, version="6.0.0")
public interface InflationIndex extends IndexBase {

	InflationIndexMeta metaData = new InflationIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference index that is used to specify the inflation interest rate.
	 */
	FieldWithMetaInflationRateIndexEnum getInflationRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the floating rate tenor.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	InflationIndex build();
	
	InflationIndex.InflationIndexBuilder toBuilder();
	
	static InflationIndex.InflationIndexBuilder builder() {
		return new InflationIndex.InflationIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InflationIndex> getType() {
		return InflationIndex.class;
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
		processRosetta(path.newSubPath("inflationRateIndex"), processor, FieldWithMetaInflationRateIndexEnum.class, getInflationRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InflationIndexBuilder extends InflationIndex, IndexBase.IndexBaseBuilder {
		FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder getOrCreateInflationRateIndex();
		@Override
		FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder getInflationRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		@Override
		InflationIndex.InflationIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		InflationIndex.InflationIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		InflationIndex.InflationIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		InflationIndex.InflationIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		InflationIndex.InflationIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		InflationIndex.InflationIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		InflationIndex.InflationIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		InflationIndex.InflationIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		InflationIndex.InflationIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		InflationIndex.InflationIndexBuilder setExchange(LegalEntity exchange);
		@Override
		InflationIndex.InflationIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		InflationIndex.InflationIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		InflationIndex.InflationIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		InflationIndex.InflationIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		InflationIndex.InflationIndexBuilder setName(FieldWithMetaString name);
		@Override
		InflationIndex.InflationIndexBuilder setNameValue(String name);
		@Override
		InflationIndex.InflationIndexBuilder setProvider(LegalEntity provider);
		@Override
		InflationIndex.InflationIndexBuilder setAssetClass(AssetClassEnum assetClass);
		InflationIndex.InflationIndexBuilder setInflationRateIndex(FieldWithMetaInflationRateIndexEnum inflationRateIndex);
		InflationIndex.InflationIndexBuilder setInflationRateIndexValue(InflationRateIndexEnum inflationRateIndex);
		InflationIndex.InflationIndexBuilder setIndexTenor(Period indexTenor);

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
			processRosetta(path.newSubPath("inflationRateIndex"), processor, FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder.class, getInflationRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		InflationIndex.InflationIndexBuilder prune();
	}

	/*********************** Immutable Implementation of InflationIndex  ***********************/
	class InflationIndexImpl extends IndexBase.IndexBaseImpl implements InflationIndex {
		private final FieldWithMetaInflationRateIndexEnum inflationRateIndex;
		private final Period indexTenor;
		
		protected InflationIndexImpl(InflationIndex.InflationIndexBuilder builder) {
			super(builder);
			this.inflationRateIndex = ofNullable(builder.getInflationRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inflationRateIndex")
		@RuneAttribute("inflationRateIndex")
		public FieldWithMetaInflationRateIndexEnum getInflationRateIndex() {
			return inflationRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public InflationIndex build() {
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder toBuilder() {
			InflationIndex.InflationIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationIndex.InflationIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInflationRateIndex()).ifPresent(builder::setInflationRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationIndex _that = getType().cast(o);
		
			if (!Objects.equals(inflationRateIndex, _that.getInflationRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationRateIndex != null ? inflationRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationIndex {" +
				"inflationRateIndex=" + this.inflationRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InflationIndex  ***********************/
	class InflationIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements InflationIndex.InflationIndexBuilder {
	
		protected FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder inflationRateIndex;
		protected Period.PeriodBuilder indexTenor;
		
		@Override
		@RosettaAttribute("inflationRateIndex")
		@RuneAttribute("inflationRateIndex")
		public FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder getInflationRateIndex() {
			return inflationRateIndex;
		}
		
		@Override
		public FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder getOrCreateInflationRateIndex() {
			FieldWithMetaInflationRateIndexEnum.FieldWithMetaInflationRateIndexEnumBuilder result;
			if (inflationRateIndex!=null) {
				result = inflationRateIndex;
			}
			else {
				result = inflationRateIndex = FieldWithMetaInflationRateIndexEnum.builder();
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
		public InflationIndex.InflationIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public InflationIndex.InflationIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public InflationIndex.InflationIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public InflationIndex.InflationIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public InflationIndex.InflationIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public InflationIndex.InflationIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public InflationIndex.InflationIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public InflationIndex.InflationIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public InflationIndex.InflationIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public InflationIndex.InflationIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public InflationIndex.InflationIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public InflationIndex.InflationIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public InflationIndex.InflationIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public InflationIndex.InflationIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("inflationRateIndex")
		@RuneAttribute("inflationRateIndex")
		public InflationIndex.InflationIndexBuilder setInflationRateIndex(FieldWithMetaInflationRateIndexEnum _inflationRateIndex) {
			this.inflationRateIndex = _inflationRateIndex == null ? null : _inflationRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder setInflationRateIndexValue(InflationRateIndexEnum _inflationRateIndex) {
			this.getOrCreateInflationRateIndex().setValue(_inflationRateIndex);
			return this;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public InflationIndex.InflationIndexBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public InflationIndex build() {
			return new InflationIndex.InflationIndexImpl(this);
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationIndex.InflationIndexBuilder prune() {
			super.prune();
			if (inflationRateIndex!=null && !inflationRateIndex.prune().hasData()) inflationRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInflationRateIndex()!=null) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationIndex.InflationIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InflationIndex.InflationIndexBuilder o = (InflationIndex.InflationIndexBuilder) other;
			
			merger.mergeRosetta(getInflationRateIndex(), o.getInflationRateIndex(), this::setInflationRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationIndex _that = getType().cast(o);
		
			if (!Objects.equals(inflationRateIndex, _that.getInflationRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationRateIndex != null ? inflationRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationIndexBuilder {" +
				"inflationRateIndex=" + this.inflationRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}' + " " + super.toString();
		}
	}
}
