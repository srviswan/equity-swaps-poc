package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.AssetBaseMeta;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The base data type to specify common attributes for all Assets.
 * @version 6.0.0
 */
@RosettaDataType(value="AssetBase", builder=AssetBase.AssetBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetBase", model="Just another Rosetta model", builder=AssetBase.AssetBaseBuilderImpl.class, version="6.0.0")
public interface AssetBase extends RosettaModelObject {

	AssetBaseMeta metaData = new AssetBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
	 */
	List<? extends AssetIdentifier> getIdentifier();
	/**
	 * Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
	 */
	List<? extends Taxonomy> getTaxonomy();
	/**
	 * Defines whether the Asset is listed on a public exchange.
	 */
	Boolean getIsExchangeListed();
	/**
	 * If the Asset is listed, defines the public exchange of the listing.
	 */
	LegalEntity getExchange();
	/**
	 * Provides the related Exchanges, if applicable.
	 */
	List<? extends LegalEntity> getRelatedExchange();

	/*********************** Build Methods  ***********************/
	AssetBase build();
	
	AssetBase.AssetBaseBuilder toBuilder();
	
	static AssetBase.AssetBaseBuilder builder() {
		return new AssetBase.AssetBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetBase> getType() {
		return AssetBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetBaseBuilder extends AssetBase, RosettaModelObjectBuilder {
		AssetIdentifier.AssetIdentifierBuilder getOrCreateIdentifier(int _index);
		@Override
		List<? extends AssetIdentifier.AssetIdentifierBuilder> getIdentifier();
		Taxonomy.TaxonomyBuilder getOrCreateTaxonomy(int _index);
		@Override
		List<? extends Taxonomy.TaxonomyBuilder> getTaxonomy();
		LegalEntity.LegalEntityBuilder getOrCreateExchange();
		@Override
		LegalEntity.LegalEntityBuilder getExchange();
		LegalEntity.LegalEntityBuilder getOrCreateRelatedExchange(int _index);
		@Override
		List<? extends LegalEntity.LegalEntityBuilder> getRelatedExchange();
		AssetBase.AssetBaseBuilder addIdentifier(AssetIdentifier identifier);
		AssetBase.AssetBaseBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		AssetBase.AssetBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		AssetBase.AssetBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		AssetBase.AssetBaseBuilder addTaxonomy(Taxonomy taxonomy);
		AssetBase.AssetBaseBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		AssetBase.AssetBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		AssetBase.AssetBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		AssetBase.AssetBaseBuilder setIsExchangeListed(Boolean isExchangeListed);
		AssetBase.AssetBaseBuilder setExchange(LegalEntity exchange);
		AssetBase.AssetBaseBuilder addRelatedExchange(LegalEntity relatedExchange);
		AssetBase.AssetBaseBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		AssetBase.AssetBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		AssetBase.AssetBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
		}
		

		AssetBase.AssetBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AssetBase  ***********************/
	class AssetBaseImpl implements AssetBase {
		private final List<? extends AssetIdentifier> identifier;
		private final List<? extends Taxonomy> taxonomy;
		private final Boolean isExchangeListed;
		private final LegalEntity exchange;
		private final List<? extends LegalEntity> relatedExchange;
		
		protected AssetBaseImpl(AssetBase.AssetBaseBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.taxonomy = ofNullable(builder.getTaxonomy()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.isExchangeListed = builder.getIsExchangeListed();
			this.exchange = ofNullable(builder.getExchange()).map(f->f.build()).orElse(null);
			this.relatedExchange = ofNullable(builder.getRelatedExchange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends AssetIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public List<? extends Taxonomy> getTaxonomy() {
			return taxonomy;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		@RuneAttribute("isExchangeListed")
		public Boolean getIsExchangeListed() {
			return isExchangeListed;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public LegalEntity getExchange() {
			return exchange;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public List<? extends LegalEntity> getRelatedExchange() {
			return relatedExchange;
		}
		
		@Override
		public AssetBase build() {
			return this;
		}
		
		@Override
		public AssetBase.AssetBaseBuilder toBuilder() {
			AssetBase.AssetBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetBase.AssetBaseBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getTaxonomy()).ifPresent(builder::setTaxonomy);
			ofNullable(getIsExchangeListed()).ifPresent(builder::setIsExchangeListed);
			ofNullable(getExchange()).ifPresent(builder::setExchange);
			ofNullable(getRelatedExchange()).ifPresent(builder::setRelatedExchange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(taxonomy, _that.getTaxonomy())) return false;
			if (!Objects.equals(isExchangeListed, _that.getIsExchangeListed())) return false;
			if (!Objects.equals(exchange, _that.getExchange())) return false;
			if (!ListEquals.listEquals(relatedExchange, _that.getRelatedExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (taxonomy != null ? taxonomy.hashCode() : 0);
			_result = 31 * _result + (isExchangeListed != null ? isExchangeListed.hashCode() : 0);
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			_result = 31 * _result + (relatedExchange != null ? relatedExchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetBase {" +
				"identifier=" + this.identifier + ", " +
				"taxonomy=" + this.taxonomy + ", " +
				"isExchangeListed=" + this.isExchangeListed + ", " +
				"exchange=" + this.exchange + ", " +
				"relatedExchange=" + this.relatedExchange +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetBase  ***********************/
	class AssetBaseBuilderImpl implements AssetBase.AssetBaseBuilder {
	
		protected List<AssetIdentifier.AssetIdentifierBuilder> identifier = new ArrayList<>();
		protected List<Taxonomy.TaxonomyBuilder> taxonomy = new ArrayList<>();
		protected Boolean isExchangeListed;
		protected LegalEntity.LegalEntityBuilder exchange;
		protected List<LegalEntity.LegalEntityBuilder> relatedExchange = new ArrayList<>();
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends AssetIdentifier.AssetIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public AssetIdentifier.AssetIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			AssetIdentifier.AssetIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						AssetIdentifier.AssetIdentifierBuilder newIdentifier = AssetIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public List<? extends Taxonomy.TaxonomyBuilder> getTaxonomy() {
			return taxonomy;
		}
		
		@Override
		public Taxonomy.TaxonomyBuilder getOrCreateTaxonomy(int _index) {
		
			if (taxonomy==null) {
				this.taxonomy = new ArrayList<>();
			}
			Taxonomy.TaxonomyBuilder result;
			return getIndex(taxonomy, _index, () -> {
						Taxonomy.TaxonomyBuilder newTaxonomy = Taxonomy.builder();
						return newTaxonomy;
					});
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		@RuneAttribute("isExchangeListed")
		public Boolean getIsExchangeListed() {
			return isExchangeListed;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public LegalEntity.LegalEntityBuilder getExchange() {
			return exchange;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateExchange() {
			LegalEntity.LegalEntityBuilder result;
			if (exchange!=null) {
				result = exchange;
			}
			else {
				result = exchange = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public List<? extends LegalEntity.LegalEntityBuilder> getRelatedExchange() {
			return relatedExchange;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateRelatedExchange(int _index) {
		
			if (relatedExchange==null) {
				this.relatedExchange = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(relatedExchange, _index, () -> {
						LegalEntity.LegalEntityBuilder newRelatedExchange = LegalEntity.builder();
						return newRelatedExchange;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public AssetBase.AssetBaseBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetBase.AssetBaseBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public AssetBase.AssetBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public AssetBase.AssetBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public AssetBase.AssetBaseBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetBase.AssetBaseBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public AssetBase.AssetBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public AssetBase.AssetBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public AssetBase.AssetBaseBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public AssetBase.AssetBaseBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public AssetBase.AssetBaseBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetBase.AssetBaseBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public AssetBase.AssetBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public AssetBase.AssetBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public AssetBase build() {
			return new AssetBase.AssetBaseImpl(this);
		}
		
		@Override
		public AssetBase.AssetBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetBase.AssetBaseBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<AssetIdentifier.AssetIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			taxonomy = taxonomy.stream().filter(b->b!=null).<Taxonomy.TaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exchange!=null && !exchange.prune().hasData()) exchange = null;
			relatedExchange = relatedExchange.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTaxonomy()!=null && getTaxonomy().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIsExchangeListed()!=null) return true;
			if (getExchange()!=null && getExchange().hasData()) return true;
			if (getRelatedExchange()!=null && getRelatedExchange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetBase.AssetBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetBase.AssetBaseBuilder o = (AssetBase.AssetBaseBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getTaxonomy(), o.getTaxonomy(), this::getOrCreateTaxonomy);
			merger.mergeRosetta(getExchange(), o.getExchange(), this::setExchange);
			merger.mergeRosetta(getRelatedExchange(), o.getRelatedExchange(), this::getOrCreateRelatedExchange);
			
			merger.mergeBasic(getIsExchangeListed(), o.getIsExchangeListed(), this::setIsExchangeListed);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(taxonomy, _that.getTaxonomy())) return false;
			if (!Objects.equals(isExchangeListed, _that.getIsExchangeListed())) return false;
			if (!Objects.equals(exchange, _that.getExchange())) return false;
			if (!ListEquals.listEquals(relatedExchange, _that.getRelatedExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (taxonomy != null ? taxonomy.hashCode() : 0);
			_result = 31 * _result + (isExchangeListed != null ? isExchangeListed.hashCode() : 0);
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			_result = 31 * _result + (relatedExchange != null ? relatedExchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetBaseBuilder {" +
				"identifier=" + this.identifier + ", " +
				"taxonomy=" + this.taxonomy + ", " +
				"isExchangeListed=" + this.isExchangeListed + ", " +
				"exchange=" + this.exchange + ", " +
				"relatedExchange=" + this.relatedExchange +
			'}';
		}
	}
}
