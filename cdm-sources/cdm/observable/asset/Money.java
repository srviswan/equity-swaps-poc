package cdm.observable.asset;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.Frequency.FrequencyBuilder;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.Measure;
import cdm.base.math.Measure.MeasureBuilder;
import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.math.Quantity.QuantityBuilderImpl;
import cdm.base.math.Quantity.QuantityImpl;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import cdm.observable.asset.Money.MoneyBuilderImpl;
import cdm.observable.asset.Money.MoneyImpl;
import cdm.observable.asset.meta.MoneyMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a monetary amount in a specified currency.
 * @version 6.0.0
 */
@RosettaDataType(value="Money", builder=Money.MoneyBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Money", model="Just another Rosetta model", builder=Money.MoneyBuilderImpl.class, version="6.0.0")
public interface Money extends Quantity, GlobalKey {

	MoneyMeta metaData = new MoneyMeta();

	/*********************** Getter Methods  ***********************/
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	Money build();
	
	Money.MoneyBuilder toBuilder();
	
	static Money.MoneyBuilder builder() {
		return new Money.MoneyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Money> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Money> getType() {
		return Money.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("unit"), processor, UnitType.class, getUnit());
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
		processRosetta(path.newSubPath("multiplier"), processor, Measure.class, getMultiplier());
		processRosetta(path.newSubPath("frequency"), processor, Frequency.class, getFrequency());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyBuilder extends Money, Quantity.QuantityBuilder, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		@Override
		Money.MoneyBuilder setValue(BigDecimal value);
		@Override
		Money.MoneyBuilder setUnit(UnitType unit);
		@Override
		Money.MoneyBuilder addDatedValue(DatedValue datedValue);
		@Override
		Money.MoneyBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		Money.MoneyBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Money.MoneyBuilder setDatedValue(List<? extends DatedValue> datedValue);
		@Override
		Money.MoneyBuilder setMultiplier(Measure multiplier);
		@Override
		Money.MoneyBuilder setFrequency(Frequency frequency);
		Money.MoneyBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("multiplier"), processor, Measure.MeasureBuilder.class, getMultiplier());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		Money.MoneyBuilder prune();
	}

	/*********************** Immutable Implementation of Money  ***********************/
	class MoneyImpl extends Quantity.QuantityImpl implements Money {
		private final MetaFields meta;
		
		protected MoneyImpl(Money.MoneyBuilder builder) {
			super(builder);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money build() {
			return this;
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			Money.MoneyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Money.MoneyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Money {" +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Money  ***********************/
	class MoneyBuilderImpl extends Quantity.QuantityBuilderImpl implements Money.MoneyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		
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
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public Money.MoneyBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public Money.MoneyBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public Money.MoneyBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public Money.MoneyBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public Money.MoneyBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public Money.MoneyBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		@RosettaAttribute("multiplier")
		@RuneAttribute("multiplier")
		public Money.MoneyBuilder setMultiplier(Measure _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public Money.MoneyBuilder setFrequency(Frequency _frequency) {
			this.frequency = _frequency == null ? null : _frequency.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public Money.MoneyBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public Money build() {
			return new Money.MoneyImpl(this);
		}
		
		@Override
		public Money.MoneyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder prune() {
			super.prune();
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Money.MoneyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Money.MoneyBuilder o = (Money.MoneyBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Money _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyBuilder {" +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}
