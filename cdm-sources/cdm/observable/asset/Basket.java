package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Basket.BasketBuilder;
import cdm.observable.asset.Basket.BasketBuilderImpl;
import cdm.observable.asset.Basket.BasketImpl;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.meta.BasketMeta;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a custom basket by referencing an identifier and its constituents.
 * @version 6.0.0
 */
@RosettaDataType(value="Basket", builder=Basket.BasketBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Basket", model="Just another Rosetta model", builder=Basket.BasketBuilderImpl.class, version="6.0.0")
public interface Basket extends AssetBase {

	BasketMeta metaData = new BasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the constituents of the basket
	 */
	List<? extends FieldWithMetaBasketConstituent> getBasketConstituent();

	/*********************** Build Methods  ***********************/
	Basket build();
	
	Basket.BasketBuilder toBuilder();
	
	static Basket.BasketBuilder builder() {
		return new Basket.BasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Basket> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Basket> getType() {
		return Basket.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.class, getBasketConstituent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketBuilder extends Basket, AssetBase.AssetBaseBuilder {
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int _index);
		@Override
		List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent();
		@Override
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		Basket.BasketBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		Basket.BasketBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Basket.BasketBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		Basket.BasketBuilder setExchange(LegalEntity exchange);
		@Override
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		Basket.BasketBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent);
		Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent basketConstituent, int _idx);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent);
		Basket.BasketBuilder addBasketConstituentValue(BasketConstituent basketConstituent, int _idx);
		Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituent);
		Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituent);
		Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("basketConstituent"), processor, FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder.class, getBasketConstituent());
		}
		

		Basket.BasketBuilder prune();
	}

	/*********************** Immutable Implementation of Basket  ***********************/
	class BasketImpl extends AssetBase.AssetBaseImpl implements Basket {
		private final List<? extends FieldWithMetaBasketConstituent> basketConstituent;
		
		protected BasketImpl(Basket.BasketBuilder builder) {
			super(builder);
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public List<? extends FieldWithMetaBasketConstituent> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public Basket build() {
			return this;
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			Basket.BasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Basket.BasketBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Basket {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Basket  ***********************/
	class BasketBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements Basket.BasketBuilder {
	
		protected List<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> basketConstituent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public List<? extends FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder> getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder getOrCreateBasketConstituent(int _index) {
		
			if (basketConstituent==null) {
				this.basketConstituent = new ArrayList<>();
			}
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder result;
			return getIndex(basketConstituent, _index, () -> {
						FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder newBasketConstituent = FieldWithMetaBasketConstituent.builder();
						newBasketConstituent.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newBasketConstituent;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public Basket.BasketBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public Basket.BasketBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Basket.BasketBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public Basket.BasketBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Basket.BasketBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public Basket.BasketBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public Basket.BasketBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public Basket.BasketBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent _basketConstituent) {
			if (_basketConstituent != null) {
				this.basketConstituent.add(_basketConstituent.toBuilder());
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituent(FieldWithMetaBasketConstituent _basketConstituent, int _idx) {
			getIndex(this.basketConstituent, _idx, () -> _basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent _basketConstituent) {
			this.getOrCreateBasketConstituent(-1).setValue(_basketConstituent.toBuilder());
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(BasketConstituent _basketConstituent, int _idx) {
			this.getOrCreateBasketConstituent(_idx).setValue(_basketConstituent.toBuilder());
			return this;
		}
		
		@Override 
		public Basket.BasketBuilder addBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (final FieldWithMetaBasketConstituent toAdd : basketConstituents) {
					this.basketConstituent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("basketConstituent")
		public Basket.BasketBuilder setBasketConstituent(List<? extends FieldWithMetaBasketConstituent> basketConstituents) {
			if (basketConstituents == null) {
				this.basketConstituent = new ArrayList<>();
			} else {
				this.basketConstituent = basketConstituents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder addBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			if (basketConstituents != null) {
				for (final BasketConstituent toAdd : basketConstituents) {
					this.addBasketConstituentValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Basket.BasketBuilder setBasketConstituentValue(List<? extends BasketConstituent> basketConstituents) {
			this.basketConstituent.clear();
			if (basketConstituents != null) {
				basketConstituents.forEach(this::addBasketConstituentValue);
			}
			return this;
		}
		
		@Override
		public Basket build() {
			return new Basket.BasketImpl(this);
		}
		
		@Override
		public Basket.BasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder prune() {
			super.prune();
			basketConstituent = basketConstituent.stream().filter(b->b!=null).<FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Basket.BasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Basket.BasketBuilder o = (Basket.BasketBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::getOrCreateBasketConstituent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Basket _that = getType().cast(o);
		
			if (!ListEquals.listEquals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketBuilder {" +
				"basketConstituent=" + this.basketConstituent +
			'}' + " " + super.toString();
		}
	}
}
