package cdm.observable.asset;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.CashPrice.CashPriceBuilder;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.Price.PriceBuilderImpl;
import cdm.observable.asset.Price.PriceImpl;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceComposite.PriceCompositeBuilder;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilder;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilderImpl;
import cdm.observable.asset.PriceSchedule.PriceScheduleImpl;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.meta.PriceMeta;
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
import java.util.stream.Collectors;


/**
 * Specifies a price as a single value to be associated to a financial product. This data type extends PriceSchedule and requires that only the amount value exists.
 * @version 6.0.0
 */
@RosettaDataType(value="Price", builder=Price.PriceBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Price", model="Just another Rosetta model", builder=Price.PriceBuilderImpl.class, version="6.0.0")
public interface Price extends PriceSchedule {

	PriceMeta metaData = new PriceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Price build();
	
	Price.PriceBuilder toBuilder();
	
	static Price.PriceBuilder builder() {
		return new Price.PriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Price> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Price> getType() {
		return Price.class;
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
	interface PriceBuilder extends Price, PriceSchedule.PriceScheduleBuilder {
		@Override
		Price.PriceBuilder setValue(BigDecimal value);
		@Override
		Price.PriceBuilder setUnit(UnitType unit);
		@Override
		Price.PriceBuilder addDatedValue(DatedValue datedValue);
		@Override
		Price.PriceBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		Price.PriceBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Price.PriceBuilder setDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Price.PriceBuilder setPerUnitOf(UnitType perUnitOf);
		@Override
		Price.PriceBuilder setPriceType(PriceTypeEnum priceType);
		@Override
		Price.PriceBuilder setPriceExpression(PriceExpressionEnum priceExpression);
		@Override
		Price.PriceBuilder setComposite(PriceComposite composite);
		@Override
		Price.PriceBuilder setArithmeticOperator(ArithmeticOperationEnum arithmeticOperator);
		@Override
		Price.PriceBuilder setCashPrice(CashPrice cashPrice);

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
		

		Price.PriceBuilder prune();
	}

	/*********************** Immutable Implementation of Price  ***********************/
	class PriceImpl extends PriceSchedule.PriceScheduleImpl implements Price {
		
		protected PriceImpl(Price.PriceBuilder builder) {
			super(builder);
		}
		
		@Override
		public Price build() {
			return this;
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			Price.PriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Price.PriceBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Price {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Price  ***********************/
	class PriceBuilderImpl extends PriceSchedule.PriceScheduleBuilderImpl implements Price.PriceBuilder {
	
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public Price.PriceBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public Price.PriceBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public Price.PriceBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public Price.PriceBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public Price.PriceBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public Price.PriceBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		public Price.PriceBuilder setPerUnitOf(UnitType _perUnitOf) {
			this.perUnitOf = _perUnitOf == null ? null : _perUnitOf.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@RuneAttribute("priceType")
		public Price.PriceBuilder setPriceType(PriceTypeEnum _priceType) {
			this.priceType = _priceType == null ? null : _priceType;
			return this;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@RuneAttribute("priceExpression")
		public Price.PriceBuilder setPriceExpression(PriceExpressionEnum _priceExpression) {
			this.priceExpression = _priceExpression == null ? null : _priceExpression;
			return this;
		}
		
		@Override
		@RosettaAttribute("composite")
		@RuneAttribute("composite")
		public Price.PriceBuilder setComposite(PriceComposite _composite) {
			this.composite = _composite == null ? null : _composite.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("arithmeticOperator")
		@RuneAttribute("arithmeticOperator")
		public Price.PriceBuilder setArithmeticOperator(ArithmeticOperationEnum _arithmeticOperator) {
			this.arithmeticOperator = _arithmeticOperator == null ? null : _arithmeticOperator;
			return this;
		}
		
		@Override
		@RosettaAttribute("cashPrice")
		@RuneAttribute("cashPrice")
		public Price.PriceBuilder setCashPrice(CashPrice _cashPrice) {
			this.cashPrice = _cashPrice == null ? null : _cashPrice.toBuilder();
			return this;
		}
		
		@Override
		public Price build() {
			return new Price.PriceImpl(this);
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Price.PriceBuilder o = (Price.PriceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
