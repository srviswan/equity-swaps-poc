package cdm.product.template;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import cdm.product.template.Product;
import cdm.product.template.Product.ProductBuilder;
import cdm.product.template.Product.ProductBuilderImpl;
import cdm.product.template.Product.ProductImpl;
import cdm.product.template.TransferableProduct;
import cdm.product.template.TransferableProduct.TransferableProductBuilder;
import cdm.product.template.meta.ProductMeta;
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
 * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
 * @version 6.0.0
 */
@RosettaDataType(value="Product", builder=Product.ProductBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Product", model="Just another Rosetta model", builder=Product.ProductBuilderImpl.class, version="6.0.0")
public interface Product extends RosettaModelObject {

	ProductMeta metaData = new ProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
	 */
	TransferableProduct getTransferableProduct();
	/**
	 * The non-transferable product data type represents a product that can be traded (as part of a TradableProduct) but cannot be transferred to others.
	 */
	NonTransferableProduct getNonTransferableProduct();

	/*********************** Build Methods  ***********************/
	Product build();
	
	Product.ProductBuilder toBuilder();
	
	static Product.ProductBuilder builder() {
		return new Product.ProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Product> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Product> getType() {
		return Product.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("TransferableProduct"), processor, TransferableProduct.class, getTransferableProduct());
		processRosetta(path.newSubPath("NonTransferableProduct"), processor, NonTransferableProduct.class, getNonTransferableProduct());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductBuilder extends Product, RosettaModelObjectBuilder {
		TransferableProduct.TransferableProductBuilder getOrCreateTransferableProduct();
		@Override
		TransferableProduct.TransferableProductBuilder getTransferableProduct();
		NonTransferableProduct.NonTransferableProductBuilder getOrCreateNonTransferableProduct();
		@Override
		NonTransferableProduct.NonTransferableProductBuilder getNonTransferableProduct();
		Product.ProductBuilder setTransferableProduct(TransferableProduct _TransferableProduct);
		Product.ProductBuilder setNonTransferableProduct(NonTransferableProduct _NonTransferableProduct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("TransferableProduct"), processor, TransferableProduct.TransferableProductBuilder.class, getTransferableProduct());
			processRosetta(path.newSubPath("NonTransferableProduct"), processor, NonTransferableProduct.NonTransferableProductBuilder.class, getNonTransferableProduct());
		}
		

		Product.ProductBuilder prune();
	}

	/*********************** Immutable Implementation of Product  ***********************/
	class ProductImpl implements Product {
		private final TransferableProduct transferableProduct;
		private final NonTransferableProduct nonTransferableProduct;
		
		protected ProductImpl(Product.ProductBuilder builder) {
			this.transferableProduct = ofNullable(builder.getTransferableProduct()).map(f->f.build()).orElse(null);
			this.nonTransferableProduct = ofNullable(builder.getNonTransferableProduct()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("TransferableProduct")
		@RuneAttribute("TransferableProduct")
		public TransferableProduct getTransferableProduct() {
			return transferableProduct;
		}
		
		@Override
		@RosettaAttribute("NonTransferableProduct")
		@RuneAttribute("NonTransferableProduct")
		public NonTransferableProduct getNonTransferableProduct() {
			return nonTransferableProduct;
		}
		
		@Override
		public Product build() {
			return this;
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			Product.ProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Product.ProductBuilder builder) {
			ofNullable(getTransferableProduct()).ifPresent(builder::setTransferableProduct);
			ofNullable(getNonTransferableProduct()).ifPresent(builder::setNonTransferableProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(transferableProduct, _that.getTransferableProduct())) return false;
			if (!Objects.equals(nonTransferableProduct, _that.getNonTransferableProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferableProduct != null ? transferableProduct.hashCode() : 0);
			_result = 31 * _result + (nonTransferableProduct != null ? nonTransferableProduct.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Product {" +
				"TransferableProduct=" + this.transferableProduct + ", " +
				"NonTransferableProduct=" + this.nonTransferableProduct +
			'}';
		}
	}

	/*********************** Builder Implementation of Product  ***********************/
	class ProductBuilderImpl implements Product.ProductBuilder {
	
		protected TransferableProduct.TransferableProductBuilder transferableProduct;
		protected NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct;
		
		@Override
		@RosettaAttribute("TransferableProduct")
		@RuneAttribute("TransferableProduct")
		public TransferableProduct.TransferableProductBuilder getTransferableProduct() {
			return transferableProduct;
		}
		
		@Override
		public TransferableProduct.TransferableProductBuilder getOrCreateTransferableProduct() {
			TransferableProduct.TransferableProductBuilder result;
			if (transferableProduct!=null) {
				result = transferableProduct;
			}
			else {
				result = transferableProduct = TransferableProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NonTransferableProduct")
		@RuneAttribute("NonTransferableProduct")
		public NonTransferableProduct.NonTransferableProductBuilder getNonTransferableProduct() {
			return nonTransferableProduct;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder getOrCreateNonTransferableProduct() {
			NonTransferableProduct.NonTransferableProductBuilder result;
			if (nonTransferableProduct!=null) {
				result = nonTransferableProduct;
			}
			else {
				result = nonTransferableProduct = NonTransferableProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("TransferableProduct")
		@RuneAttribute("TransferableProduct")
		public Product.ProductBuilder setTransferableProduct(TransferableProduct _transferableProduct) {
			this.transferableProduct = _transferableProduct == null ? null : _transferableProduct.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("NonTransferableProduct")
		@RuneAttribute("NonTransferableProduct")
		public Product.ProductBuilder setNonTransferableProduct(NonTransferableProduct _nonTransferableProduct) {
			this.nonTransferableProduct = _nonTransferableProduct == null ? null : _nonTransferableProduct.toBuilder();
			return this;
		}
		
		@Override
		public Product build() {
			return new Product.ProductImpl(this);
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder prune() {
			if (transferableProduct!=null && !transferableProduct.prune().hasData()) transferableProduct = null;
			if (nonTransferableProduct!=null && !nonTransferableProduct.prune().hasData()) nonTransferableProduct = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransferableProduct()!=null && getTransferableProduct().hasData()) return true;
			if (getNonTransferableProduct()!=null && getNonTransferableProduct().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Product.ProductBuilder o = (Product.ProductBuilder) other;
			
			merger.mergeRosetta(getTransferableProduct(), o.getTransferableProduct(), this::setTransferableProduct);
			merger.mergeRosetta(getNonTransferableProduct(), o.getNonTransferableProduct(), this::setNonTransferableProduct);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(transferableProduct, _that.getTransferableProduct())) return false;
			if (!Objects.equals(nonTransferableProduct, _that.getNonTransferableProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferableProduct != null ? transferableProduct.hashCode() : 0);
			_result = 31 * _result + (nonTransferableProduct != null ? nonTransferableProduct.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBuilder {" +
				"TransferableProduct=" + this.transferableProduct + ", " +
				"NonTransferableProduct=" + this.nonTransferableProduct +
			'}';
		}
	}
}
