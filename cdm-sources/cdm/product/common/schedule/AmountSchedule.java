package cdm.product.common.schedule;

import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.Schedule;
import cdm.base.math.Schedule.ScheduleBuilder;
import cdm.base.math.Schedule.ScheduleBuilderImpl;
import cdm.base.math.Schedule.ScheduleImpl;
import cdm.product.common.schedule.AmountSchedule;
import cdm.product.common.schedule.AmountSchedule.AmountScheduleBuilder;
import cdm.product.common.schedule.AmountSchedule.AmountScheduleBuilderImpl;
import cdm.product.common.schedule.AmountSchedule.AmountScheduleImpl;
import cdm.product.common.schedule.meta.AmountScheduleMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a currency amount or a currency amount schedule.
 * @version 6.0.0
 */
@RosettaDataType(value="AmountSchedule", builder=AmountSchedule.AmountScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AmountSchedule", model="Just another Rosetta model", builder=AmountSchedule.AmountScheduleBuilderImpl.class, version="6.0.0")
public interface AmountSchedule extends Schedule {

	AmountScheduleMeta metaData = new AmountScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which the amount schedule is denominated. The currency is specified outside of the actual schedule in order to be applied uniformly to it. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	List<? extends FieldWithMetaString> getCurrency();

	/*********************** Build Methods  ***********************/
	AmountSchedule build();
	
	AmountSchedule.AmountScheduleBuilder toBuilder();
	
	static AmountSchedule.AmountScheduleBuilder builder() {
		return new AmountSchedule.AmountScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountSchedule> getType() {
		return AmountSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountScheduleBuilder extends AmountSchedule, Schedule.ScheduleBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency(int _index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getCurrency();
		@Override
		AmountSchedule.AmountScheduleBuilder setValue(BigDecimal value);
		@Override
		AmountSchedule.AmountScheduleBuilder addDatedValue(DatedValue datedValue);
		@Override
		AmountSchedule.AmountScheduleBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		AmountSchedule.AmountScheduleBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		AmountSchedule.AmountScheduleBuilder setDatedValue(List<? extends DatedValue> datedValue);
		AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency);
		AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString currency, int _idx);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(String currency, int _idx);
		AmountSchedule.AmountScheduleBuilder addCurrency(List<? extends FieldWithMetaString> currency);
		AmountSchedule.AmountScheduleBuilder setCurrency(List<? extends FieldWithMetaString> currency);
		AmountSchedule.AmountScheduleBuilder addCurrencyValue(List<? extends String> currency);
		AmountSchedule.AmountScheduleBuilder setCurrencyValue(List<? extends String> currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
		}
		

		AmountSchedule.AmountScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of AmountSchedule  ***********************/
	class AmountScheduleImpl extends Schedule.ScheduleImpl implements AmountSchedule {
		private final List<? extends FieldWithMetaString> currency;
		
		protected AmountScheduleImpl(AmountSchedule.AmountScheduleBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public List<? extends FieldWithMetaString> getCurrency() {
			return currency;
		}
		
		@Override
		public AmountSchedule build() {
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			AmountSchedule.AmountScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountSchedule.AmountScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountSchedule {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmountSchedule  ***********************/
	class AmountScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl implements AmountSchedule.AmountScheduleBuilder {
	
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> currency = new ArrayList<>();
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency(int _index) {
		
			if (currency==null) {
				this.currency = new ArrayList<>();
			}
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			return getIndex(currency, _index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newCurrency = FieldWithMetaString.builder();
						return newCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public AmountSchedule.AmountScheduleBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public AmountSchedule.AmountScheduleBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public AmountSchedule.AmountScheduleBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public AmountSchedule.AmountScheduleBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString _currency) {
			if (_currency != null) {
				this.currency.add(_currency.toBuilder());
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrency(FieldWithMetaString _currency, int _idx) {
			getIndex(this.currency, _idx, () -> _currency.toBuilder());
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrencyValue(String _currency) {
			this.getOrCreateCurrency(-1).setValue(_currency);
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrencyValue(String _currency, int _idx) {
			this.getOrCreateCurrency(_idx).setValue(_currency);
			return this;
		}
		
		@Override 
		public AmountSchedule.AmountScheduleBuilder addCurrency(List<? extends FieldWithMetaString> currencys) {
			if (currencys != null) {
				for (final FieldWithMetaString toAdd : currencys) {
					this.currency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("currency")
		public AmountSchedule.AmountScheduleBuilder setCurrency(List<? extends FieldWithMetaString> currencys) {
			if (currencys == null) {
				this.currency = new ArrayList<>();
			} else {
				this.currency = currencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addCurrencyValue(List<? extends String> currencys) {
			if (currencys != null) {
				for (final String toAdd : currencys) {
					this.addCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder setCurrencyValue(List<? extends String> currencys) {
			this.currency.clear();
			if (currencys != null) {
				currencys.forEach(this::addCurrencyValue);
			}
			return this;
		}
		
		@Override
		public AmountSchedule build() {
			return new AmountSchedule.AmountScheduleImpl(this);
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountSchedule.AmountScheduleBuilder prune() {
			super.prune();
			currency = currency.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && !getCurrency().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountSchedule.AmountScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmountSchedule.AmountScheduleBuilder o = (AmountSchedule.AmountScheduleBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::getOrCreateCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountScheduleBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
