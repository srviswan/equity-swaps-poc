package cdm.observable.asset;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Basket.BasketBuilder;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.BasketConstituent.BasketConstituentBuilder;
import cdm.observable.asset.BasketConstituent.BasketConstituentBuilderImpl;
import cdm.observable.asset.BasketConstituent.BasketConstituentImpl;
import cdm.observable.asset.Index;
import cdm.observable.asset.Index.IndexBuilder;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Observable.ObservableBuilder;
import cdm.observable.asset.Observable.ObservableBuilderImpl;
import cdm.observable.asset.Observable.ObservableImpl;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.meta.BasketConstituentMeta;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder;
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
 * Identifies the constituents of the basket
 * @version 6.0.0
 */
@RosettaDataType(value="BasketConstituent", builder=BasketConstituent.BasketConstituentBuilderImpl.class, version="6.0.0")
@RuneDataType(value="BasketConstituent", model="Just another Rosetta model", builder=BasketConstituent.BasketConstituentBuilderImpl.class, version="6.0.0")
public interface BasketConstituent extends Observable {

	BasketConstituentMeta metaData = new BasketConstituentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity-&gt;quantity that this quantity is referencing.
	 */
	List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> getQuantity();
	/**
	 * Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity-&gt;price that this price is referencing.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice();
	/**
	 * Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity-&gt;price that this price is referencing.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice();
	/**
	 * Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity-&gt;price that this price is referencing.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice();

	/*********************** Build Methods  ***********************/
	BasketConstituent build();
	
	BasketConstituent.BasketConstituentBuilder toBuilder();
	
	static BasketConstituent.BasketConstituentBuilder builder() {
		return new BasketConstituent.BasketConstituentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketConstituent> getType() {
		return BasketConstituent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Asset"), processor, Asset.class, getAsset());
		processRosetta(path.newSubPath("Basket"), processor, Basket.class, getBasket());
		processRosetta(path.newSubPath("Index"), processor, Index.class, getIndex());
		processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaNonNegativeQuantitySchedule.class, getQuantity());
		processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInitialValuationPrice());
		processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInterimValuationPrice());
		processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getFinalValuationPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituentBuilder extends BasketConstituent, Observable.ObservableBuilder {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity(int _index);
		@Override
		List<? extends ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder> getQuantity();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice();
		@Override
		BasketConstituent.BasketConstituentBuilder setAsset(Asset _Asset);
		@Override
		BasketConstituent.BasketConstituentBuilder setBasket(Basket _Basket);
		@Override
		BasketConstituent.BasketConstituentBuilder setIndex(Index _Index);
		BasketConstituent.BasketConstituentBuilder addQuantity(ReferenceWithMetaNonNegativeQuantitySchedule quantity);
		BasketConstituent.BasketConstituentBuilder addQuantity(ReferenceWithMetaNonNegativeQuantitySchedule quantity, int _idx);
		BasketConstituent.BasketConstituentBuilder addQuantityValue(NonNegativeQuantitySchedule quantity);
		BasketConstituent.BasketConstituentBuilder addQuantityValue(NonNegativeQuantitySchedule quantity, int _idx);
		BasketConstituent.BasketConstituentBuilder addQuantity(List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> quantity);
		BasketConstituent.BasketConstituentBuilder setQuantity(List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> quantity);
		BasketConstituent.BasketConstituentBuilder addQuantityValue(List<? extends NonNegativeQuantitySchedule> quantity);
		BasketConstituent.BasketConstituentBuilder setQuantityValue(List<? extends NonNegativeQuantitySchedule> quantity);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice, int _idx);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice);
		BasketConstituent.BasketConstituentBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice);
		BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice);
		BasketConstituent.BasketConstituentBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Asset"), processor, Asset.AssetBuilder.class, getAsset());
			processRosetta(path.newSubPath("Basket"), processor, Basket.BasketBuilder.class, getBasket());
			processRosetta(path.newSubPath("Index"), processor, Index.IndexBuilder.class, getIndex());
			processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder.class, getQuantity());
			processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInitialValuationPrice());
			processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInterimValuationPrice());
			processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getFinalValuationPrice());
		}
		

		BasketConstituent.BasketConstituentBuilder prune();
	}

	/*********************** Immutable Implementation of BasketConstituent  ***********************/
	class BasketConstituentImpl extends Observable.ObservableImpl implements BasketConstituent {
		private final List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> quantity;
		private final List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice;
		
		protected BasketConstituentImpl(BasketConstituent.BasketConstituentBuilder builder) {
			super(builder);
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialValuationPrice = ofNullable(builder.getInitialValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interimValuationPrice = ofNullable(builder.getInterimValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.finalValuationPrice = ofNullable(builder.getFinalValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		public BasketConstituent build() {
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			BasketConstituent.BasketConstituentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituent.BasketConstituentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getInitialValuationPrice()).ifPresent(builder::setInitialValuationPrice);
			ofNullable(getInterimValuationPrice()).ifPresent(builder::setInterimValuationPrice);
			ofNullable(getFinalValuationPrice()).ifPresent(builder::setFinalValuationPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituent {" +
				"quantity=" + this.quantity + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BasketConstituent  ***********************/
	class BasketConstituentBuilderImpl extends Observable.ObservableBuilderImpl implements BasketConstituent.BasketConstituentBuilder {
	
		protected List<ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder> quantity = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> initialValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> interimValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> finalValuationPrice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public List<? extends ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder> getQuantity() {
			return quantity;
		}
		
		@Override
		public ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder getOrCreateQuantity(int _index) {
		
			if (quantity==null) {
				this.quantity = new ArrayList<>();
			}
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder result;
			return getIndex(quantity, _index, () -> {
						ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder newQuantity = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
						return newQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index) {
		
			if (initialValuationPrice==null) {
				this.initialValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(initialValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInitialValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInitialValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index) {
		
			if (interimValuationPrice==null) {
				this.interimValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(interimValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInterimValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInterimValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index) {
		
			if (finalValuationPrice==null) {
				this.finalValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(finalValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newFinalValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newFinalValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("Asset")
		@RuneAttribute("Asset")
		public BasketConstituent.BasketConstituentBuilder setAsset(Asset _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@RuneAttribute("Basket")
		public BasketConstituent.BasketConstituentBuilder setBasket(Basket _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public BasketConstituent.BasketConstituentBuilder setIndex(Index _index) {
			this.index = _index == null ? null : _index.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public BasketConstituent.BasketConstituentBuilder addQuantity(ReferenceWithMetaNonNegativeQuantitySchedule _quantity) {
			if (_quantity != null) {
				this.quantity.add(_quantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addQuantity(ReferenceWithMetaNonNegativeQuantitySchedule _quantity, int _idx) {
			getIndex(this.quantity, _idx, () -> _quantity.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addQuantityValue(NonNegativeQuantitySchedule _quantity) {
			this.getOrCreateQuantity(-1).setValue(_quantity.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addQuantityValue(NonNegativeQuantitySchedule _quantity, int _idx) {
			this.getOrCreateQuantity(_idx).setValue(_quantity.toBuilder());
			return this;
		}
		
		@Override 
		public BasketConstituent.BasketConstituentBuilder addQuantity(List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> quantitys) {
			if (quantitys != null) {
				for (final ReferenceWithMetaNonNegativeQuantitySchedule toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("quantity")
		public BasketConstituent.BasketConstituentBuilder setQuantity(List<? extends ReferenceWithMetaNonNegativeQuantitySchedule> quantitys) {
			if (quantitys == null) {
				this.quantity = new ArrayList<>();
			} else {
				this.quantity = quantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addQuantityValue(List<? extends NonNegativeQuantitySchedule> quantitys) {
			if (quantitys != null) {
				for (final NonNegativeQuantitySchedule toAdd : quantitys) {
					this.addQuantityValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder setQuantityValue(List<? extends NonNegativeQuantitySchedule> quantitys) {
			this.quantity.clear();
			if (quantitys != null) {
				quantitys.forEach(this::addQuantityValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule _initialValuationPrice) {
			if (_initialValuationPrice != null) {
				this.initialValuationPrice.add(_initialValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule _initialValuationPrice, int _idx) {
			getIndex(this.initialValuationPrice, _idx, () -> _initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(PriceSchedule _initialValuationPrice) {
			this.getOrCreateInitialValuationPrice(-1).setValue(_initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(PriceSchedule _initialValuationPrice, int _idx) {
			this.getOrCreateInitialValuationPrice(_idx).setValue(_initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : initialValuationPrices) {
					this.initialValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("initialValuationPrice")
		public BasketConstituent.BasketConstituentBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices == null) {
				this.initialValuationPrice = new ArrayList<>();
			} else {
				this.initialValuationPrice = initialValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (final PriceSchedule toAdd : initialValuationPrices) {
					this.addInitialValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			this.initialValuationPrice.clear();
			if (initialValuationPrices != null) {
				initialValuationPrices.forEach(this::addInitialValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule _interimValuationPrice) {
			if (_interimValuationPrice != null) {
				this.interimValuationPrice.add(_interimValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule _interimValuationPrice, int _idx) {
			getIndex(this.interimValuationPrice, _idx, () -> _interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(PriceSchedule _interimValuationPrice) {
			this.getOrCreateInterimValuationPrice(-1).setValue(_interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(PriceSchedule _interimValuationPrice, int _idx) {
			this.getOrCreateInterimValuationPrice(_idx).setValue(_interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : interimValuationPrices) {
					this.interimValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("interimValuationPrice")
		public BasketConstituent.BasketConstituentBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices == null) {
				this.interimValuationPrice = new ArrayList<>();
			} else {
				this.interimValuationPrice = interimValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (final PriceSchedule toAdd : interimValuationPrices) {
					this.addInterimValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			this.interimValuationPrice.clear();
			if (interimValuationPrices != null) {
				interimValuationPrices.forEach(this::addInterimValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule _finalValuationPrice) {
			if (_finalValuationPrice != null) {
				this.finalValuationPrice.add(_finalValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule _finalValuationPrice, int _idx) {
			getIndex(this.finalValuationPrice, _idx, () -> _finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(PriceSchedule _finalValuationPrice) {
			this.getOrCreateFinalValuationPrice(-1).setValue(_finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(PriceSchedule _finalValuationPrice, int _idx) {
			this.getOrCreateFinalValuationPrice(_idx).setValue(_finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : finalValuationPrices) {
					this.finalValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("finalValuationPrice")
		public BasketConstituent.BasketConstituentBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices == null) {
				this.finalValuationPrice = new ArrayList<>();
			} else {
				this.finalValuationPrice = finalValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (final PriceSchedule toAdd : finalValuationPrices) {
					this.addFinalValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			this.finalValuationPrice.clear();
			if (finalValuationPrices != null) {
				finalValuationPrices.forEach(this::addFinalValuationPriceValue);
			}
			return this;
		}
		
		@Override
		public BasketConstituent build() {
			return new BasketConstituent.BasketConstituentImpl(this);
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder prune() {
			super.prune();
			quantity = quantity.stream().filter(b->b!=null).<ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			initialValuationPrice = initialValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interimValuationPrice = interimValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			finalValuationPrice = finalValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialValuationPrice()!=null && getInitialValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterimValuationPrice()!=null && getInterimValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFinalValuationPrice()!=null && getFinalValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituent.BasketConstituentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BasketConstituent.BasketConstituentBuilder o = (BasketConstituent.BasketConstituentBuilder) other;
			
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			merger.mergeRosetta(getInitialValuationPrice(), o.getInitialValuationPrice(), this::getOrCreateInitialValuationPrice);
			merger.mergeRosetta(getInterimValuationPrice(), o.getInterimValuationPrice(), this::getOrCreateInterimValuationPrice);
			merger.mergeRosetta(getFinalValuationPrice(), o.getFinalValuationPrice(), this::getOrCreateFinalValuationPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasketConstituent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituentBuilder {" +
				"quantity=" + this.quantity + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice +
			'}' + " " + super.toString();
		}
	}
}
