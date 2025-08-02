package cdm.product.template;

import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder;
import cdm.product.template.Product;
import cdm.product.template.Product.ProductBuilder;
import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
import cdm.product.template.Underlier.UnderlierBuilderImpl;
import cdm.product.template.Underlier.UnderlierImpl;
import cdm.product.template.meta.UnderlierMeta;
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
 * The underlying financial product that will be physically or cash settled, which can be of any type, eg an asset such as cash or a security, a product, or the cash settlement of an index rate.  Conditions are usually applied when used in a data type, such as a payout, to ensure this aligns with the use case.
 * @version 6.0.0
 */
@RosettaDataType(value="Underlier", builder=Underlier.UnderlierBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Underlier", model="Just another Rosetta model", builder=Underlier.UnderlierBuilderImpl.class, version="6.0.0")
public interface Underlier extends RosettaModelObject {

	UnderlierMeta metaData = new UnderlierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the object to be observed for a price, it could be an asset or a reference.
	 */
	ReferenceWithMetaObservable getObservable();
	/**
	 * Enables either a TransferableProduct or a NonTransferableProduct to be used in an underlier.
	 */
	Product getProduct();

	/*********************** Build Methods  ***********************/
	Underlier build();
	
	Underlier.UnderlierBuilder toBuilder();
	
	static Underlier.UnderlierBuilder builder() {
		return new Underlier.UnderlierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Underlier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Underlier> getType() {
		return Underlier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Observable"), processor, ReferenceWithMetaObservable.class, getObservable());
		processRosetta(path.newSubPath("Product"), processor, Product.class, getProduct());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlierBuilder extends Underlier, RosettaModelObjectBuilder {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateObservable();
		@Override
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getObservable();
		Product.ProductBuilder getOrCreateProduct();
		@Override
		Product.ProductBuilder getProduct();
		Underlier.UnderlierBuilder setObservable(ReferenceWithMetaObservable _Observable);
		Underlier.UnderlierBuilder setObservableValue(Observable _Observable);
		Underlier.UnderlierBuilder setProduct(Product _Product);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Observable"), processor, ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("Product"), processor, Product.ProductBuilder.class, getProduct());
		}
		

		Underlier.UnderlierBuilder prune();
	}

	/*********************** Immutable Implementation of Underlier  ***********************/
	class UnderlierImpl implements Underlier {
		private final ReferenceWithMetaObservable observable;
		private final Product product;
		
		protected UnderlierImpl(Underlier.UnderlierBuilder builder) {
			this.observable = ofNullable(builder.getObservable()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Observable")
		@RuneAttribute("Observable")
		public ReferenceWithMetaObservable getObservable() {
			return observable;
		}
		
		@Override
		@RosettaAttribute("Product")
		@RuneAttribute("Product")
		public Product getProduct() {
			return product;
		}
		
		@Override
		public Underlier build() {
			return this;
		}
		
		@Override
		public Underlier.UnderlierBuilder toBuilder() {
			Underlier.UnderlierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Underlier.UnderlierBuilder builder) {
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Underlier _that = getType().cast(o);
		
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Underlier {" +
				"Observable=" + this.observable + ", " +
				"Product=" + this.product +
			'}';
		}
	}

	/*********************** Builder Implementation of Underlier  ***********************/
	class UnderlierBuilderImpl implements Underlier.UnderlierBuilder {
	
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable;
		protected Product.ProductBuilder product;
		
		@Override
		@RosettaAttribute("Observable")
		@RuneAttribute("Observable")
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getObservable() {
			return observable;
		}
		
		@Override
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateObservable() {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder result;
			if (observable!=null) {
				result = observable;
			}
			else {
				result = observable = ReferenceWithMetaObservable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Product")
		@RuneAttribute("Product")
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Observable")
		@RuneAttribute("Observable")
		public Underlier.UnderlierBuilder setObservable(ReferenceWithMetaObservable _observable) {
			this.observable = _observable == null ? null : _observable.toBuilder();
			return this;
		}
		
		@Override
		public Underlier.UnderlierBuilder setObservableValue(Observable _observable) {
			this.getOrCreateObservable().setValue(_observable);
			return this;
		}
		
		@Override
		@RosettaAttribute("Product")
		@RuneAttribute("Product")
		public Underlier.UnderlierBuilder setProduct(Product _product) {
			this.product = _product == null ? null : _product.toBuilder();
			return this;
		}
		
		@Override
		public Underlier build() {
			return new Underlier.UnderlierImpl(this);
		}
		
		@Override
		public Underlier.UnderlierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Underlier.UnderlierBuilder prune() {
			if (observable!=null && !observable.prune().hasData()) observable = null;
			if (product!=null && !product.prune().hasData()) product = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservable()!=null && getObservable().hasData()) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Underlier.UnderlierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Underlier.UnderlierBuilder o = (Underlier.UnderlierBuilder) other;
			
			merger.mergeRosetta(getObservable(), o.getObservable(), this::setObservable);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Underlier _that = getType().cast(o);
		
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlierBuilder {" +
				"Observable=" + this.observable + ", " +
				"Product=" + this.product +
			'}';
		}
	}
}
