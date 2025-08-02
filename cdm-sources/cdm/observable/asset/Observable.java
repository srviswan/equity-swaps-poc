package cdm.observable.asset;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Basket.BasketBuilder;
import cdm.observable.asset.Index;
import cdm.observable.asset.Index.IndexBuilder;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Observable.ObservableBuilder;
import cdm.observable.asset.Observable.ObservableBuilderImpl;
import cdm.observable.asset.Observable.ObservableImpl;
import cdm.observable.asset.meta.ObservableMeta;
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
 * Specifies the object to be observed for a price, it could be an asset or a reference.
 * @version 6.0.0
 */
@RosettaDataType(value="Observable", builder=Observable.ObservableBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Observable", model="Just another Rosetta model", builder=Observable.ObservableBuilderImpl.class, version="6.0.0")
public interface Observable extends RosettaModelObject {

	ObservableMeta metaData = new ObservableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
	 */
	Asset getAsset();
	/**
	 * The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
	 */
	Basket getBasket();
	/**
	 * The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
	 */
	Index getIndex();

	/*********************** Build Methods  ***********************/
	Observable build();
	
	Observable.ObservableBuilder toBuilder();
	
	static Observable.ObservableBuilder builder() {
		return new Observable.ObservableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Observable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Observable> getType() {
		return Observable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Asset"), processor, Asset.class, getAsset());
		processRosetta(path.newSubPath("Basket"), processor, Basket.class, getBasket());
		processRosetta(path.newSubPath("Index"), processor, Index.class, getIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservableBuilder extends Observable, RosettaModelObjectBuilder {
		Asset.AssetBuilder getOrCreateAsset();
		@Override
		Asset.AssetBuilder getAsset();
		Basket.BasketBuilder getOrCreateBasket();
		@Override
		Basket.BasketBuilder getBasket();
		Index.IndexBuilder getOrCreateIndex();
		@Override
		Index.IndexBuilder getIndex();
		Observable.ObservableBuilder setAsset(Asset _Asset);
		Observable.ObservableBuilder setBasket(Basket _Basket);
		Observable.ObservableBuilder setIndex(Index _Index);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Asset"), processor, Asset.AssetBuilder.class, getAsset());
			processRosetta(path.newSubPath("Basket"), processor, Basket.BasketBuilder.class, getBasket());
			processRosetta(path.newSubPath("Index"), processor, Index.IndexBuilder.class, getIndex());
		}
		

		Observable.ObservableBuilder prune();
	}

	/*********************** Immutable Implementation of Observable  ***********************/
	class ObservableImpl implements Observable {
		private final Asset asset;
		private final Basket basket;
		private final Index index;
		
		protected ObservableImpl(Observable.ObservableBuilder builder) {
			this.asset = ofNullable(builder.getAsset()).map(f->f.build()).orElse(null);
			this.basket = ofNullable(builder.getBasket()).map(f->f.build()).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Asset")
		@RuneAttribute("Asset")
		public Asset getAsset() {
			return asset;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@RuneAttribute("Basket")
		public Basket getBasket() {
			return basket;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public Index getIndex() {
			return index;
		}
		
		@Override
		public Observable build() {
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder toBuilder() {
			Observable.ObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Observable.ObservableBuilder builder) {
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getBasket()).ifPresent(builder::setBasket);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observable _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Observable {" +
				"Asset=" + this.asset + ", " +
				"Basket=" + this.basket + ", " +
				"Index=" + this.index +
			'}';
		}
	}

	/*********************** Builder Implementation of Observable  ***********************/
	class ObservableBuilderImpl implements Observable.ObservableBuilder {
	
		protected Asset.AssetBuilder asset;
		protected Basket.BasketBuilder basket;
		protected Index.IndexBuilder index;
		
		@Override
		@RosettaAttribute("Asset")
		@RuneAttribute("Asset")
		public Asset.AssetBuilder getAsset() {
			return asset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateAsset() {
			Asset.AssetBuilder result;
			if (asset!=null) {
				result = asset;
			}
			else {
				result = asset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@RuneAttribute("Basket")
		public Basket.BasketBuilder getBasket() {
			return basket;
		}
		
		@Override
		public Basket.BasketBuilder getOrCreateBasket() {
			Basket.BasketBuilder result;
			if (basket!=null) {
				result = basket;
			}
			else {
				result = basket = Basket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public Index.IndexBuilder getIndex() {
			return index;
		}
		
		@Override
		public Index.IndexBuilder getOrCreateIndex() {
			Index.IndexBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = Index.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Asset")
		@RuneAttribute("Asset")
		public Observable.ObservableBuilder setAsset(Asset _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@RuneAttribute("Basket")
		public Observable.ObservableBuilder setBasket(Basket _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public Observable.ObservableBuilder setIndex(Index _index) {
			this.index = _index == null ? null : _index.toBuilder();
			return this;
		}
		
		@Override
		public Observable build() {
			return new Observable.ObservableImpl(this);
		}
		
		@Override
		public Observable.ObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observable.ObservableBuilder prune() {
			if (asset!=null && !asset.prune().hasData()) asset = null;
			if (basket!=null && !basket.prune().hasData()) basket = null;
			if (index!=null && !index.prune().hasData()) index = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsset()!=null && getAsset().hasData()) return true;
			if (getBasket()!=null && getBasket().hasData()) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observable.ObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Observable.ObservableBuilder o = (Observable.ObservableBuilder) other;
			
			merger.mergeRosetta(getAsset(), o.getAsset(), this::setAsset);
			merger.mergeRosetta(getBasket(), o.getBasket(), this::setBasket);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observable _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservableBuilder {" +
				"Asset=" + this.asset + ", " +
				"Basket=" + this.basket + ", " +
				"Index=" + this.index +
			'}';
		}
	}
}
