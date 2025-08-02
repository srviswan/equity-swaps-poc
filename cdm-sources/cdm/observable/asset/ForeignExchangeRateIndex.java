package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder;
import cdm.observable.asset.ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilderImpl;
import cdm.observable.asset.ForeignExchangeRateIndex.ForeignExchangeRateIndexImpl;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.InformationSource.InformationSourceBuilder;
import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.meta.ForeignExchangeRateIndexMeta;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.Key;
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
 * Specification of a rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
 * @version 6.0.0
 */
@RosettaDataType(value="ForeignExchangeRateIndex", builder=ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ForeignExchangeRateIndex", model="Just another Rosetta model", builder=ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilderImpl.class, version="6.0.0")
public interface ForeignExchangeRateIndex extends IndexBase {

	ForeignExchangeRateIndexMeta metaData = new ForeignExchangeRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the composition of a rate that has been quoted or is to be quoted.
	 */
	FieldWithMetaQuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * Specifies the primary source from which a rate should be observed.
	 */
	InformationSource getPrimaryFxSpotRateSource();
	/**
	 * Specifies an alternative, or secondary, source from which a rate should be observed.
	 */
	InformationSource getSecondaryFxSpotRateSource();

	/*********************** Build Methods  ***********************/
	ForeignExchangeRateIndex build();
	
	ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder toBuilder();
	
	static ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder builder() {
		return new ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ForeignExchangeRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ForeignExchangeRateIndex> getType() {
		return ForeignExchangeRateIndex.class;
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
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, FieldWithMetaQuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("primaryFxSpotRateSource"), processor, InformationSource.class, getPrimaryFxSpotRateSource());
		processRosetta(path.newSubPath("secondaryFxSpotRateSource"), processor, InformationSource.class, getSecondaryFxSpotRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ForeignExchangeRateIndexBuilder extends ForeignExchangeRateIndex, IndexBase.IndexBaseBuilder {
		FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreatePrimaryFxSpotRateSource();
		@Override
		InformationSource.InformationSourceBuilder getPrimaryFxSpotRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryFxSpotRateSource();
		@Override
		InformationSource.InformationSourceBuilder getSecondaryFxSpotRateSource();
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setExchange(LegalEntity exchange);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setName(FieldWithMetaString name);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setNameValue(String name);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setProvider(LegalEntity provider);
		@Override
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setAssetClass(AssetClassEnum assetClass);
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setQuotedCurrencyPair(FieldWithMetaQuotedCurrencyPair quotedCurrencyPair);
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair quotedCurrencyPair);
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setPrimaryFxSpotRateSource(InformationSource primaryFxSpotRateSource);
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setSecondaryFxSpotRateSource(InformationSource secondaryFxSpotRateSource);

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
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("primaryFxSpotRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryFxSpotRateSource());
			processRosetta(path.newSubPath("secondaryFxSpotRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryFxSpotRateSource());
		}
		

		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of ForeignExchangeRateIndex  ***********************/
	class ForeignExchangeRateIndexImpl extends IndexBase.IndexBaseImpl implements ForeignExchangeRateIndex {
		private final FieldWithMetaQuotedCurrencyPair quotedCurrencyPair;
		private final InformationSource primaryFxSpotRateSource;
		private final InformationSource secondaryFxSpotRateSource;
		
		protected ForeignExchangeRateIndexImpl(ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.primaryFxSpotRateSource = ofNullable(builder.getPrimaryFxSpotRateSource()).map(f->f.build()).orElse(null);
			this.secondaryFxSpotRateSource = ofNullable(builder.getSecondaryFxSpotRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@RuneAttribute("quotedCurrencyPair")
		public FieldWithMetaQuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("primaryFxSpotRateSource")
		@RuneAttribute("primaryFxSpotRateSource")
		public InformationSource getPrimaryFxSpotRateSource() {
			return primaryFxSpotRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryFxSpotRateSource")
		@RuneAttribute("secondaryFxSpotRateSource")
		public InformationSource getSecondaryFxSpotRateSource() {
			return secondaryFxSpotRateSource;
		}
		
		@Override
		public ForeignExchangeRateIndex build() {
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder toBuilder() {
			ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getPrimaryFxSpotRateSource()).ifPresent(builder::setPrimaryFxSpotRateSource);
			ofNullable(getSecondaryFxSpotRateSource()).ifPresent(builder::setSecondaryFxSpotRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ForeignExchangeRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(primaryFxSpotRateSource, _that.getPrimaryFxSpotRateSource())) return false;
			if (!Objects.equals(secondaryFxSpotRateSource, _that.getSecondaryFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (primaryFxSpotRateSource != null ? primaryFxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryFxSpotRateSource != null ? secondaryFxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForeignExchangeRateIndex {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"primaryFxSpotRateSource=" + this.primaryFxSpotRateSource + ", " +
				"secondaryFxSpotRateSource=" + this.secondaryFxSpotRateSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ForeignExchangeRateIndex  ***********************/
	class ForeignExchangeRateIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder {
	
		protected FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder quotedCurrencyPair;
		protected InformationSource.InformationSourceBuilder primaryFxSpotRateSource;
		protected InformationSource.InformationSourceBuilder secondaryFxSpotRateSource;
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@RuneAttribute("quotedCurrencyPair")
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = FieldWithMetaQuotedCurrencyPair.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("primaryFxSpotRateSource")
		@RuneAttribute("primaryFxSpotRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryFxSpotRateSource() {
			return primaryFxSpotRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryFxSpotRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryFxSpotRateSource!=null) {
				result = primaryFxSpotRateSource;
			}
			else {
				result = primaryFxSpotRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryFxSpotRateSource")
		@RuneAttribute("secondaryFxSpotRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryFxSpotRateSource() {
			return secondaryFxSpotRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryFxSpotRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryFxSpotRateSource!=null) {
				result = secondaryFxSpotRateSource;
			}
			else {
				result = secondaryFxSpotRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@RuneAttribute("quotedCurrencyPair")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setQuotedCurrencyPair(FieldWithMetaQuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setQuotedCurrencyPairValue(QuotedCurrencyPair _quotedCurrencyPair) {
			this.getOrCreateQuotedCurrencyPair().setValue(_quotedCurrencyPair);
			return this;
		}
		
		@Override
		@RosettaAttribute("primaryFxSpotRateSource")
		@RuneAttribute("primaryFxSpotRateSource")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setPrimaryFxSpotRateSource(InformationSource _primaryFxSpotRateSource) {
			this.primaryFxSpotRateSource = _primaryFxSpotRateSource == null ? null : _primaryFxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("secondaryFxSpotRateSource")
		@RuneAttribute("secondaryFxSpotRateSource")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder setSecondaryFxSpotRateSource(InformationSource _secondaryFxSpotRateSource) {
			this.secondaryFxSpotRateSource = _secondaryFxSpotRateSource == null ? null : _secondaryFxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		public ForeignExchangeRateIndex build() {
			return new ForeignExchangeRateIndex.ForeignExchangeRateIndexImpl(this);
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (primaryFxSpotRateSource!=null && !primaryFxSpotRateSource.prune().hasData()) primaryFxSpotRateSource = null;
			if (secondaryFxSpotRateSource!=null && !secondaryFxSpotRateSource.prune().hasData()) secondaryFxSpotRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getPrimaryFxSpotRateSource()!=null && getPrimaryFxSpotRateSource().hasData()) return true;
			if (getSecondaryFxSpotRateSource()!=null && getSecondaryFxSpotRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder o = (ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getPrimaryFxSpotRateSource(), o.getPrimaryFxSpotRateSource(), this::setPrimaryFxSpotRateSource);
			merger.mergeRosetta(getSecondaryFxSpotRateSource(), o.getSecondaryFxSpotRateSource(), this::setSecondaryFxSpotRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ForeignExchangeRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(primaryFxSpotRateSource, _that.getPrimaryFxSpotRateSource())) return false;
			if (!Objects.equals(secondaryFxSpotRateSource, _that.getSecondaryFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (primaryFxSpotRateSource != null ? primaryFxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryFxSpotRateSource != null ? secondaryFxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForeignExchangeRateIndexBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"primaryFxSpotRateSource=" + this.primaryFxSpotRateSource + ", " +
				"secondaryFxSpotRateSource=" + this.secondaryFxSpotRateSource +
			'}' + " " + super.toString();
		}
	}
}
