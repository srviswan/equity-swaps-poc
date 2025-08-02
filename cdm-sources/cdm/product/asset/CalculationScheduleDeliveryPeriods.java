package cdm.product.asset;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder;
import cdm.product.asset.AssetDeliveryPeriods.AssetDeliveryPeriodsBuilderImpl;
import cdm.product.asset.AssetDeliveryPeriods.AssetDeliveryPeriodsImpl;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.AssetDeliveryProfile.AssetDeliveryProfileBuilder;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder;
import cdm.product.asset.CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilderImpl;
import cdm.product.asset.CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsImpl;
import cdm.product.asset.meta.CalculationScheduleDeliveryPeriodsMeta;
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
import com.rosetta.model.lib.records.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Period and time profile over which the delivery takes place.
 * @version 6.0.0
 */
@RosettaDataType(value="CalculationScheduleDeliveryPeriods", builder=CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CalculationScheduleDeliveryPeriods", model="Just another Rosetta model", builder=CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilderImpl.class, version="6.0.0")
public interface CalculationScheduleDeliveryPeriods extends AssetDeliveryPeriods {

	CalculationScheduleDeliveryPeriodsMeta metaData = new CalculationScheduleDeliveryPeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of units included in the transaction for each delivery interval
	 */
	Quantity getDeliveryCapacity();
	/**
	 * Price per quantity per delivery time interval.
	 */
	Price getPriceTimeIntervalQuantity();

	/*********************** Build Methods  ***********************/
	CalculationScheduleDeliveryPeriods build();
	
	CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder toBuilder();
	
	static CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder builder() {
		return new CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationScheduleDeliveryPeriods> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationScheduleDeliveryPeriods> getType() {
		return CalculationScheduleDeliveryPeriods.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("profile"), processor, AssetDeliveryProfile.class, getProfile());
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processRosetta(path.newSubPath("deliveryCapacity"), processor, Quantity.class, getDeliveryCapacity());
		processRosetta(path.newSubPath("priceTimeIntervalQuantity"), processor, Price.class, getPriceTimeIntervalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationScheduleDeliveryPeriodsBuilder extends CalculationScheduleDeliveryPeriods, AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder {
		Quantity.QuantityBuilder getOrCreateDeliveryCapacity();
		@Override
		Quantity.QuantityBuilder getDeliveryCapacity();
		Price.PriceBuilder getOrCreatePriceTimeIntervalQuantity();
		@Override
		Price.PriceBuilder getPriceTimeIntervalQuantity();
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(AssetDeliveryProfile profile);
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(AssetDeliveryProfile profile, int _idx);
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(List<? extends AssetDeliveryProfile> profile);
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setProfile(List<? extends AssetDeliveryProfile> profile);
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setStartDate(Date startDate);
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setEndDate(Date endDate);
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setDeliveryCapacity(Quantity deliveryCapacity);
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setPriceTimeIntervalQuantity(Price priceTimeIntervalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("profile"), processor, AssetDeliveryProfile.AssetDeliveryProfileBuilder.class, getProfile());
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processRosetta(path.newSubPath("deliveryCapacity"), processor, Quantity.QuantityBuilder.class, getDeliveryCapacity());
			processRosetta(path.newSubPath("priceTimeIntervalQuantity"), processor, Price.PriceBuilder.class, getPriceTimeIntervalQuantity());
		}
		

		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationScheduleDeliveryPeriods  ***********************/
	class CalculationScheduleDeliveryPeriodsImpl extends AssetDeliveryPeriods.AssetDeliveryPeriodsImpl implements CalculationScheduleDeliveryPeriods {
		private final Quantity deliveryCapacity;
		private final Price priceTimeIntervalQuantity;
		
		protected CalculationScheduleDeliveryPeriodsImpl(CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder builder) {
			super(builder);
			this.deliveryCapacity = ofNullable(builder.getDeliveryCapacity()).map(f->f.build()).orElse(null);
			this.priceTimeIntervalQuantity = ofNullable(builder.getPriceTimeIntervalQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@RuneAttribute("deliveryCapacity")
		public Quantity getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantity")
		@RuneAttribute("priceTimeIntervalQuantity")
		public Price getPriceTimeIntervalQuantity() {
			return priceTimeIntervalQuantity;
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods build() {
			return this;
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder toBuilder() {
			CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryCapacity()).ifPresent(builder::setDeliveryCapacity);
			ofNullable(getPriceTimeIntervalQuantity()).ifPresent(builder::setPriceTimeIntervalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationScheduleDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!Objects.equals(priceTimeIntervalQuantity, _that.getPriceTimeIntervalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantity != null ? priceTimeIntervalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationScheduleDeliveryPeriods {" +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"priceTimeIntervalQuantity=" + this.priceTimeIntervalQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationScheduleDeliveryPeriods  ***********************/
	class CalculationScheduleDeliveryPeriodsBuilderImpl extends AssetDeliveryPeriods.AssetDeliveryPeriodsBuilderImpl implements CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder {
	
		protected Quantity.QuantityBuilder deliveryCapacity;
		protected Price.PriceBuilder priceTimeIntervalQuantity;
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@RuneAttribute("deliveryCapacity")
		public Quantity.QuantityBuilder getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateDeliveryCapacity() {
			Quantity.QuantityBuilder result;
			if (deliveryCapacity!=null) {
				result = deliveryCapacity;
			}
			else {
				result = deliveryCapacity = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantity")
		@RuneAttribute("priceTimeIntervalQuantity")
		public Price.PriceBuilder getPriceTimeIntervalQuantity() {
			return priceTimeIntervalQuantity;
		}
		
		@Override
		public Price.PriceBuilder getOrCreatePriceTimeIntervalQuantity() {
			Price.PriceBuilder result;
			if (priceTimeIntervalQuantity!=null) {
				result = priceTimeIntervalQuantity;
			}
			else {
				result = priceTimeIntervalQuantity = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("profile")
		@RuneAttribute("profile")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(AssetDeliveryProfile _profile) {
			if (_profile != null) {
				this.profile.add(_profile.toBuilder());
			}
			return this;
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(AssetDeliveryProfile _profile, int _idx) {
			getIndex(this.profile, _idx, () -> _profile.toBuilder());
			return this;
		}
		
		@Override 
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder addProfile(List<? extends AssetDeliveryProfile> profiles) {
			if (profiles != null) {
				for (final AssetDeliveryProfile toAdd : profiles) {
					this.profile.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("profile")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setProfile(List<? extends AssetDeliveryProfile> profiles) {
			if (profiles == null) {
				this.profile = new ArrayList<>();
			} else {
				this.profile = profiles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@RuneAttribute("startDate")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setStartDate(Date _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@RuneAttribute("endDate")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@RuneAttribute("deliveryCapacity")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setDeliveryCapacity(Quantity _deliveryCapacity) {
			this.deliveryCapacity = _deliveryCapacity == null ? null : _deliveryCapacity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantity")
		@RuneAttribute("priceTimeIntervalQuantity")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder setPriceTimeIntervalQuantity(Price _priceTimeIntervalQuantity) {
			this.priceTimeIntervalQuantity = _priceTimeIntervalQuantity == null ? null : _priceTimeIntervalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods build() {
			return new CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsImpl(this);
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder prune() {
			super.prune();
			if (deliveryCapacity!=null && !deliveryCapacity.prune().hasData()) deliveryCapacity = null;
			if (priceTimeIntervalQuantity!=null && !priceTimeIntervalQuantity.prune().hasData()) priceTimeIntervalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryCapacity()!=null && getDeliveryCapacity().hasData()) return true;
			if (getPriceTimeIntervalQuantity()!=null && getPriceTimeIntervalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder o = (CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder) other;
			
			merger.mergeRosetta(getDeliveryCapacity(), o.getDeliveryCapacity(), this::setDeliveryCapacity);
			merger.mergeRosetta(getPriceTimeIntervalQuantity(), o.getPriceTimeIntervalQuantity(), this::setPriceTimeIntervalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationScheduleDeliveryPeriods _that = getType().cast(o);
		
			if (!Objects.equals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!Objects.equals(priceTimeIntervalQuantity, _that.getPriceTimeIntervalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantity != null ? priceTimeIntervalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationScheduleDeliveryPeriodsBuilder {" +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"priceTimeIntervalQuantity=" + this.priceTimeIntervalQuantity +
			'}' + " " + super.toString();
		}
	}
}
