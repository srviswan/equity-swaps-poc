package cdm.product.template;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductIdentifier.ProductIdentifierBuilder;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.ProductTaxonomy.ProductTaxonomyBuilder;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EconomicTerms.EconomicTermsBuilder;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilderImpl;
import cdm.product.template.NonTransferableProduct.NonTransferableProductImpl;
import cdm.product.template.meta.NonTransferableProductMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data type to specify the financial product&#39;s economic terms, alongside the product identification and product taxonomy. The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.  It is meant to be used across the pre-execution, execution and (as part of the Contract) post-execution lifecycle contexts.
 * @version 6.0.0
 */
@RosettaDataType(value="NonTransferableProduct", builder=NonTransferableProduct.NonTransferableProductBuilderImpl.class, version="6.0.0")
@RuneDataType(value="NonTransferableProduct", model="Just another Rosetta model", builder=NonTransferableProduct.NonTransferableProductBuilderImpl.class, version="6.0.0")
public interface NonTransferableProduct extends RosettaModelObject, GlobalKey {

	NonTransferableProductMeta metaData = new NonTransferableProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Comprises a identifier and a source to uniquely identify the nonTransferableProduct. 
	 */
	List<? extends ProductIdentifier> getIdentifier();
	/**
	 * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
	 */
	List<? extends ProductTaxonomy> getTaxonomy();
	/**
	 * The price forming features, including payouts and provisions.
	 */
	EconomicTerms getEconomicTerms();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	NonTransferableProduct build();
	
	NonTransferableProduct.NonTransferableProductBuilder toBuilder();
	
	static NonTransferableProduct.NonTransferableProductBuilder builder() {
		return new NonTransferableProduct.NonTransferableProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonTransferableProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonTransferableProduct> getType() {
		return NonTransferableProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, ProductIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, ProductTaxonomy.class, getTaxonomy());
		processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.class, getEconomicTerms());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonTransferableProductBuilder extends NonTransferableProduct, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		ProductIdentifier.ProductIdentifierBuilder getOrCreateIdentifier(int _index);
		@Override
		List<? extends ProductIdentifier.ProductIdentifierBuilder> getIdentifier();
		ProductTaxonomy.ProductTaxonomyBuilder getOrCreateTaxonomy(int _index);
		@Override
		List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getTaxonomy();
		EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms();
		@Override
		EconomicTerms.EconomicTermsBuilder getEconomicTerms();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		NonTransferableProduct.NonTransferableProductBuilder addIdentifier(ProductIdentifier identifier);
		NonTransferableProduct.NonTransferableProductBuilder addIdentifier(ProductIdentifier identifier, int _idx);
		NonTransferableProduct.NonTransferableProductBuilder addIdentifier(List<? extends ProductIdentifier> identifier);
		NonTransferableProduct.NonTransferableProductBuilder setIdentifier(List<? extends ProductIdentifier> identifier);
		NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(ProductTaxonomy taxonomy);
		NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(ProductTaxonomy taxonomy, int _idx);
		NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(List<? extends ProductTaxonomy> taxonomy);
		NonTransferableProduct.NonTransferableProductBuilder setTaxonomy(List<? extends ProductTaxonomy> taxonomy);
		NonTransferableProduct.NonTransferableProductBuilder setEconomicTerms(EconomicTerms economicTerms);
		NonTransferableProduct.NonTransferableProductBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, ProductTaxonomy.ProductTaxonomyBuilder.class, getTaxonomy());
			processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.EconomicTermsBuilder.class, getEconomicTerms());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		NonTransferableProduct.NonTransferableProductBuilder prune();
	}

	/*********************** Immutable Implementation of NonTransferableProduct  ***********************/
	class NonTransferableProductImpl implements NonTransferableProduct {
		private final List<? extends ProductIdentifier> identifier;
		private final List<? extends ProductTaxonomy> taxonomy;
		private final EconomicTerms economicTerms;
		private final MetaFields meta;
		
		protected NonTransferableProductImpl(NonTransferableProduct.NonTransferableProductBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.taxonomy = ofNullable(builder.getTaxonomy()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.economicTerms = ofNullable(builder.getEconomicTerms()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends ProductIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public List<? extends ProductTaxonomy> getTaxonomy() {
			return taxonomy;
		}
		
		@Override
		@RosettaAttribute("economicTerms")
		@RuneAttribute("economicTerms")
		public EconomicTerms getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public NonTransferableProduct build() {
			return this;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder toBuilder() {
			NonTransferableProduct.NonTransferableProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonTransferableProduct.NonTransferableProductBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getTaxonomy()).ifPresent(builder::setTaxonomy);
			ofNullable(getEconomicTerms()).ifPresent(builder::setEconomicTerms);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonTransferableProduct _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(taxonomy, _that.getTaxonomy())) return false;
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (taxonomy != null ? taxonomy.hashCode() : 0);
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonTransferableProduct {" +
				"identifier=" + this.identifier + ", " +
				"taxonomy=" + this.taxonomy + ", " +
				"economicTerms=" + this.economicTerms + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of NonTransferableProduct  ***********************/
	class NonTransferableProductBuilderImpl implements NonTransferableProduct.NonTransferableProductBuilder {
	
		protected List<ProductIdentifier.ProductIdentifierBuilder> identifier = new ArrayList<>();
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> taxonomy = new ArrayList<>();
		protected EconomicTerms.EconomicTermsBuilder economicTerms;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends ProductIdentifier.ProductIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			ProductIdentifier.ProductIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						ProductIdentifier.ProductIdentifierBuilder newIdentifier = ProductIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getTaxonomy() {
			return taxonomy;
		}
		
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder getOrCreateTaxonomy(int _index) {
		
			if (taxonomy==null) {
				this.taxonomy = new ArrayList<>();
			}
			ProductTaxonomy.ProductTaxonomyBuilder result;
			return getIndex(taxonomy, _index, () -> {
						ProductTaxonomy.ProductTaxonomyBuilder newTaxonomy = ProductTaxonomy.builder();
						return newTaxonomy;
					});
		}
		
		@Override
		@RosettaAttribute("economicTerms")
		@RuneAttribute("economicTerms")
		public EconomicTerms.EconomicTermsBuilder getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms() {
			EconomicTerms.EconomicTermsBuilder result;
			if (economicTerms!=null) {
				result = economicTerms;
			}
			else {
				result = economicTerms = EconomicTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public NonTransferableProduct.NonTransferableProductBuilder addIdentifier(ProductIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder addIdentifier(ProductIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public NonTransferableProduct.NonTransferableProductBuilder addIdentifier(List<? extends ProductIdentifier> identifiers) {
			if (identifiers != null) {
				for (final ProductIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public NonTransferableProduct.NonTransferableProductBuilder setIdentifier(List<? extends ProductIdentifier> identifiers) {
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
		public NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(ProductTaxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(ProductTaxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public NonTransferableProduct.NonTransferableProductBuilder addTaxonomy(List<? extends ProductTaxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final ProductTaxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public NonTransferableProduct.NonTransferableProductBuilder setTaxonomy(List<? extends ProductTaxonomy> taxonomys) {
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
		@RosettaAttribute("economicTerms")
		@RuneAttribute("economicTerms")
		public NonTransferableProduct.NonTransferableProductBuilder setEconomicTerms(EconomicTerms _economicTerms) {
			this.economicTerms = _economicTerms == null ? null : _economicTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public NonTransferableProduct.NonTransferableProductBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public NonTransferableProduct build() {
			return new NonTransferableProduct.NonTransferableProductImpl(this);
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<ProductIdentifier.ProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			taxonomy = taxonomy.stream().filter(b->b!=null).<ProductTaxonomy.ProductTaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (economicTerms!=null && !economicTerms.prune().hasData()) economicTerms = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTaxonomy()!=null && getTaxonomy().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEconomicTerms()!=null && getEconomicTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonTransferableProduct.NonTransferableProductBuilder o = (NonTransferableProduct.NonTransferableProductBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getTaxonomy(), o.getTaxonomy(), this::getOrCreateTaxonomy);
			merger.mergeRosetta(getEconomicTerms(), o.getEconomicTerms(), this::setEconomicTerms);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonTransferableProduct _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(taxonomy, _that.getTaxonomy())) return false;
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (taxonomy != null ? taxonomy.hashCode() : 0);
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonTransferableProductBuilder {" +
				"identifier=" + this.identifier + ", " +
				"taxonomy=" + this.taxonomy + ", " +
				"economicTerms=" + this.economicTerms + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
