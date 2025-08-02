package cdm.observable.asset;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.MeasureSchedule;
import cdm.base.math.MeasureSchedule.MeasureScheduleBuilder;
import cdm.base.math.MeasureSchedule.MeasureScheduleBuilderImpl;
import cdm.base.math.MeasureSchedule.MeasureScheduleImpl;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.CashPrice.CashPriceBuilder;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceComposite.PriceCompositeBuilder;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilder;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilderImpl;
import cdm.observable.asset.PriceSchedule.PriceScheduleImpl;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.meta.PriceScheduleMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
 * @version 6.0.0
 */
@RosettaDataType(value="PriceSchedule", builder=PriceSchedule.PriceScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PriceSchedule", model="Just another Rosetta model", builder=PriceSchedule.PriceScheduleBuilderImpl.class, version="6.0.0")
public interface PriceSchedule extends MeasureSchedule {

	PriceScheduleMeta metaData = new PriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
	 */
	UnitType getPerUnitOf();
	/**
	 * Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price&#39;s units.
	 */
	PriceTypeEnum getPriceType();
	/**
	 * (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
	 */
	PriceExpressionEnum getPriceExpression();
	/**
	 * (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
	 */
	PriceComposite getComposite();
	/**
	 * (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
	 */
	ArithmeticOperationEnum getArithmeticOperator();
	/**
	 * (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
	 */
	CashPrice getCashPrice();

	/*********************** Build Methods  ***********************/
	PriceSchedule build();
	
	PriceSchedule.PriceScheduleBuilder toBuilder();
	
	static PriceSchedule.PriceScheduleBuilder builder() {
		return new PriceSchedule.PriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceSchedule> getType() {
		return PriceSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("unit"), processor, UnitType.class, getUnit());
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
		processRosetta(path.newSubPath("perUnitOf"), processor, UnitType.class, getPerUnitOf());
		processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
		processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
		processRosetta(path.newSubPath("composite"), processor, PriceComposite.class, getComposite());
		processor.processBasic(path.newSubPath("arithmeticOperator"), ArithmeticOperationEnum.class, getArithmeticOperator(), this);
		processRosetta(path.newSubPath("cashPrice"), processor, CashPrice.class, getCashPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceScheduleBuilder extends PriceSchedule, MeasureSchedule.MeasureScheduleBuilder {
		UnitType.UnitTypeBuilder getOrCreatePerUnitOf();
		@Override
		UnitType.UnitTypeBuilder getPerUnitOf();
		PriceComposite.PriceCompositeBuilder getOrCreateComposite();
		@Override
		PriceComposite.PriceCompositeBuilder getComposite();
		CashPrice.CashPriceBuilder getOrCreateCashPrice();
		@Override
		CashPrice.CashPriceBuilder getCashPrice();
		@Override
		PriceSchedule.PriceScheduleBuilder setValue(BigDecimal value);
		@Override
		PriceSchedule.PriceScheduleBuilder setUnit(UnitType unit);
		@Override
		PriceSchedule.PriceScheduleBuilder addDatedValue(DatedValue datedValue);
		@Override
		PriceSchedule.PriceScheduleBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		PriceSchedule.PriceScheduleBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		PriceSchedule.PriceScheduleBuilder setDatedValue(List<? extends DatedValue> datedValue);
		PriceSchedule.PriceScheduleBuilder setPerUnitOf(UnitType perUnitOf);
		PriceSchedule.PriceScheduleBuilder setPriceType(PriceTypeEnum priceType);
		PriceSchedule.PriceScheduleBuilder setPriceExpression(PriceExpressionEnum priceExpression);
		PriceSchedule.PriceScheduleBuilder setComposite(PriceComposite composite);
		PriceSchedule.PriceScheduleBuilder setArithmeticOperator(ArithmeticOperationEnum arithmeticOperator);
		PriceSchedule.PriceScheduleBuilder setCashPrice(CashPrice cashPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("perUnitOf"), processor, UnitType.UnitTypeBuilder.class, getPerUnitOf());
			processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
			processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
			processRosetta(path.newSubPath("composite"), processor, PriceComposite.PriceCompositeBuilder.class, getComposite());
			processor.processBasic(path.newSubPath("arithmeticOperator"), ArithmeticOperationEnum.class, getArithmeticOperator(), this);
			processRosetta(path.newSubPath("cashPrice"), processor, CashPrice.CashPriceBuilder.class, getCashPrice());
		}
		

		PriceSchedule.PriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of PriceSchedule  ***********************/
	class PriceScheduleImpl extends MeasureSchedule.MeasureScheduleImpl implements PriceSchedule {
		private final UnitType perUnitOf;
		private final PriceTypeEnum priceType;
		private final PriceExpressionEnum priceExpression;
		private final PriceComposite composite;
		private final ArithmeticOperationEnum arithmeticOperator;
		private final CashPrice cashPrice;
		
		protected PriceScheduleImpl(PriceSchedule.PriceScheduleBuilder builder) {
			super(builder);
			this.perUnitOf = ofNullable(builder.getPerUnitOf()).map(f->f.build()).orElse(null);
			this.priceType = builder.getPriceType();
			this.priceExpression = builder.getPriceExpression();
			this.composite = ofNullable(builder.getComposite()).map(f->f.build()).orElse(null);
			this.arithmeticOperator = builder.getArithmeticOperator();
			this.cashPrice = ofNullable(builder.getCashPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("perUnitOf")
		@RuneAttribute("perUnitOf")
		public UnitType getPerUnitOf() {
			return perUnitOf;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@RuneAttribute("priceType")
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@RuneAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@Override
		@RosettaAttribute("composite")
		@RuneAttribute("composite")
		public PriceComposite getComposite() {
			return composite;
		}
		
		@Override
		@RosettaAttribute("arithmeticOperator")
		@RuneAttribute("arithmeticOperator")
		public ArithmeticOperationEnum getArithmeticOperator() {
			return arithmeticOperator;
		}
		
		@Override
		@RosettaAttribute("cashPrice")
		@RuneAttribute("cashPrice")
		public CashPrice getCashPrice() {
			return cashPrice;
		}
		
		@Override
		public PriceSchedule build() {
			return this;
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder toBuilder() {
			PriceSchedule.PriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceSchedule.PriceScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPerUnitOf()).ifPresent(builder::setPerUnitOf);
			ofNullable(getPriceType()).ifPresent(builder::setPriceType);
			ofNullable(getPriceExpression()).ifPresent(builder::setPriceExpression);
			ofNullable(getComposite()).ifPresent(builder::setComposite);
			ofNullable(getArithmeticOperator()).ifPresent(builder::setArithmeticOperator);
			ofNullable(getCashPrice()).ifPresent(builder::setCashPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(perUnitOf, _that.getPerUnitOf())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			if (!Objects.equals(composite, _that.getComposite())) return false;
			if (!Objects.equals(arithmeticOperator, _that.getArithmeticOperator())) return false;
			if (!Objects.equals(cashPrice, _that.getCashPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (perUnitOf != null ? perUnitOf.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (composite != null ? composite.hashCode() : 0);
			_result = 31 * _result + (arithmeticOperator != null ? arithmeticOperator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashPrice != null ? cashPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceSchedule {" +
				"perUnitOf=" + this.perUnitOf + ", " +
				"priceType=" + this.priceType + ", " +
				"priceExpression=" + this.priceExpression + ", " +
				"composite=" + this.composite + ", " +
				"arithmeticOperator=" + this.arithmeticOperator + ", " +
				"cashPrice=" + this.cashPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PriceSchedule  ***********************/
	class PriceScheduleBuilderImpl extends MeasureSchedule.MeasureScheduleBuilderImpl implements PriceSchedule.PriceScheduleBuilder {
	
		protected UnitType.UnitTypeBuilder perUnitOf;
		protected PriceTypeEnum priceType;
		protected PriceExpressionEnum priceExpression;
		protected PriceComposite.PriceCompositeBuilder composite;
		protected ArithmeticOperationEnum arithmeticOperator;
		protected CashPrice.CashPriceBuilder cashPrice;
		
		@Override
		@RosettaAttribute("perUnitOf")
		@RuneAttribute("perUnitOf")
		public UnitType.UnitTypeBuilder getPerUnitOf() {
			return perUnitOf;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getOrCreatePerUnitOf() {
			UnitType.UnitTypeBuilder result;
			if (perUnitOf!=null) {
				result = perUnitOf;
			}
			else {
				result = perUnitOf = UnitType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@RuneAttribute("priceType")
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@RuneAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@Override
		@RosettaAttribute("composite")
		@RuneAttribute("composite")
		public PriceComposite.PriceCompositeBuilder getComposite() {
			return composite;
		}
		
		@Override
		public PriceComposite.PriceCompositeBuilder getOrCreateComposite() {
			PriceComposite.PriceCompositeBuilder result;
			if (composite!=null) {
				result = composite;
			}
			else {
				result = composite = PriceComposite.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("arithmeticOperator")
		@RuneAttribute("arithmeticOperator")
		public ArithmeticOperationEnum getArithmeticOperator() {
			return arithmeticOperator;
		}
		
		@Override
		@RosettaAttribute("cashPrice")
		@RuneAttribute("cashPrice")
		public CashPrice.CashPriceBuilder getCashPrice() {
			return cashPrice;
		}
		
		@Override
		public CashPrice.CashPriceBuilder getOrCreateCashPrice() {
			CashPrice.CashPriceBuilder result;
			if (cashPrice!=null) {
				result = cashPrice;
			}
			else {
				result = cashPrice = CashPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public PriceSchedule.PriceScheduleBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public PriceSchedule.PriceScheduleBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public PriceSchedule.PriceScheduleBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public PriceSchedule.PriceScheduleBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public PriceSchedule.PriceScheduleBuilder setDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues == null) {
				this.datedValue = new ArrayList<>();
			} else {
				this.datedValue = datedValues.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("perUnitOf")
		@RuneAttribute("perUnitOf")
		public PriceSchedule.PriceScheduleBuilder setPerUnitOf(UnitType _perUnitOf) {
			this.perUnitOf = _perUnitOf == null ? null : _perUnitOf.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@RuneAttribute("priceType")
		public PriceSchedule.PriceScheduleBuilder setPriceType(PriceTypeEnum _priceType) {
			this.priceType = _priceType == null ? null : _priceType;
			return this;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@RuneAttribute("priceExpression")
		public PriceSchedule.PriceScheduleBuilder setPriceExpression(PriceExpressionEnum _priceExpression) {
			this.priceExpression = _priceExpression == null ? null : _priceExpression;
			return this;
		}
		
		@Override
		@RosettaAttribute("composite")
		@RuneAttribute("composite")
		public PriceSchedule.PriceScheduleBuilder setComposite(PriceComposite _composite) {
			this.composite = _composite == null ? null : _composite.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("arithmeticOperator")
		@RuneAttribute("arithmeticOperator")
		public PriceSchedule.PriceScheduleBuilder setArithmeticOperator(ArithmeticOperationEnum _arithmeticOperator) {
			this.arithmeticOperator = _arithmeticOperator == null ? null : _arithmeticOperator;
			return this;
		}
		
		@Override
		@RosettaAttribute("cashPrice")
		@RuneAttribute("cashPrice")
		public PriceSchedule.PriceScheduleBuilder setCashPrice(CashPrice _cashPrice) {
			this.cashPrice = _cashPrice == null ? null : _cashPrice.toBuilder();
			return this;
		}
		
		@Override
		public PriceSchedule build() {
			return new PriceSchedule.PriceScheduleImpl(this);
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSchedule.PriceScheduleBuilder prune() {
			super.prune();
			if (perUnitOf!=null && !perUnitOf.prune().hasData()) perUnitOf = null;
			if (composite!=null && !composite.prune().hasData()) composite = null;
			if (cashPrice!=null && !cashPrice.prune().hasData()) cashPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPerUnitOf()!=null && getPerUnitOf().hasData()) return true;
			if (getPriceType()!=null) return true;
			if (getPriceExpression()!=null) return true;
			if (getComposite()!=null && getComposite().hasData()) return true;
			if (getArithmeticOperator()!=null) return true;
			if (getCashPrice()!=null && getCashPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSchedule.PriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PriceSchedule.PriceScheduleBuilder o = (PriceSchedule.PriceScheduleBuilder) other;
			
			merger.mergeRosetta(getPerUnitOf(), o.getPerUnitOf(), this::setPerUnitOf);
			merger.mergeRosetta(getComposite(), o.getComposite(), this::setComposite);
			merger.mergeRosetta(getCashPrice(), o.getCashPrice(), this::setCashPrice);
			
			merger.mergeBasic(getPriceType(), o.getPriceType(), this::setPriceType);
			merger.mergeBasic(getPriceExpression(), o.getPriceExpression(), this::setPriceExpression);
			merger.mergeBasic(getArithmeticOperator(), o.getArithmeticOperator(), this::setArithmeticOperator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(perUnitOf, _that.getPerUnitOf())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			if (!Objects.equals(composite, _that.getComposite())) return false;
			if (!Objects.equals(arithmeticOperator, _that.getArithmeticOperator())) return false;
			if (!Objects.equals(cashPrice, _that.getCashPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (perUnitOf != null ? perUnitOf.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (composite != null ? composite.hashCode() : 0);
			_result = 31 * _result + (arithmeticOperator != null ? arithmeticOperator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashPrice != null ? cashPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceScheduleBuilder {" +
				"perUnitOf=" + this.perUnitOf + ", " +
				"priceType=" + this.priceType + ", " +
				"priceExpression=" + this.priceExpression + ", " +
				"composite=" + this.composite + ", " +
				"arithmeticOperator=" + this.arithmeticOperator + ", " +
				"cashPrice=" + this.cashPrice +
			'}' + " " + super.toString();
		}
	}
}
