package cdm.base.math;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.Frequency.FrequencyBuilder;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.Measure;
import cdm.base.math.Measure.MeasureBuilder;
import cdm.base.math.MeasureSchedule;
import cdm.base.math.MeasureSchedule.MeasureScheduleBuilder;
import cdm.base.math.MeasureSchedule.MeasureScheduleBuilderImpl;
import cdm.base.math.MeasureSchedule.MeasureScheduleImpl;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.QuantitySchedule.QuantityScheduleBuilder;
import cdm.base.math.QuantitySchedule.QuantityScheduleBuilderImpl;
import cdm.base.math.QuantitySchedule.QuantityScheduleImpl;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.base.math.meta.QuantityScheduleMeta;
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
 * Specifies a quantity schedule to be associated to a financial product to represent a trade amount. This data type extends MeasureSchedule with several unit or multiplier attributes that are used to define financial quantities. This data type is generically based on a schedule and can also be used to represent a quantity as a single value.
 * @version 6.0.0
 */
@RosettaDataType(value="QuantitySchedule", builder=QuantitySchedule.QuantityScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="QuantitySchedule", model="Just another Rosetta model", builder=QuantitySchedule.QuantityScheduleBuilderImpl.class, version="6.0.0")
public interface QuantitySchedule extends MeasureSchedule {

	QuantityScheduleMeta metaData = new QuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines an optional number that the quantity should be multiplied by to derive a total quantity. This number is associated to a unit. For example in the case of the Coal (API2) CIF ARA (ARGUS-McCloskey) Futures Contract on the CME, where the unit would be contracts, the multiplier value would 1,000 and the mulitiplier unit would be 1,000 MT (Metric Tons).
	 */
	Measure getMultiplier();
	/**
	 * Defines the frequency to be used when defining a quantity. For example a quantity may be specified as a number of barrels of oil per day, which needs multiplying by the number of days in the relevant period to get the total quantity as a number of barrels.
	 */
	Frequency getFrequency();

	/*********************** Build Methods  ***********************/
	QuantitySchedule build();
	
	QuantitySchedule.QuantityScheduleBuilder toBuilder();
	
	static QuantitySchedule.QuantityScheduleBuilder builder() {
		return new QuantitySchedule.QuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuantitySchedule> getType() {
		return QuantitySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processRosetta(path.newSubPath("unit"), processor, UnitType.class, getUnit());
		processRosetta(path.newSubPath("datedValue"), processor, DatedValue.class, getDatedValue());
		processRosetta(path.newSubPath("multiplier"), processor, Measure.class, getMultiplier());
		processRosetta(path.newSubPath("frequency"), processor, Frequency.class, getFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityScheduleBuilder extends QuantitySchedule, MeasureSchedule.MeasureScheduleBuilder {
		Measure.MeasureBuilder getOrCreateMultiplier();
		@Override
		Measure.MeasureBuilder getMultiplier();
		Frequency.FrequencyBuilder getOrCreateFrequency();
		@Override
		Frequency.FrequencyBuilder getFrequency();
		@Override
		QuantitySchedule.QuantityScheduleBuilder setValue(BigDecimal value);
		@Override
		QuantitySchedule.QuantityScheduleBuilder setUnit(UnitType unit);
		@Override
		QuantitySchedule.QuantityScheduleBuilder addDatedValue(DatedValue datedValue);
		@Override
		QuantitySchedule.QuantityScheduleBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		QuantitySchedule.QuantityScheduleBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		QuantitySchedule.QuantityScheduleBuilder setDatedValue(List<? extends DatedValue> datedValue);
		QuantitySchedule.QuantityScheduleBuilder setMultiplier(Measure multiplier);
		QuantitySchedule.QuantityScheduleBuilder setFrequency(Frequency frequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("multiplier"), processor, Measure.MeasureBuilder.class, getMultiplier());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
		}
		

		QuantitySchedule.QuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of QuantitySchedule  ***********************/
	class QuantityScheduleImpl extends MeasureSchedule.MeasureScheduleImpl implements QuantitySchedule {
		private final Measure multiplier;
		private final Frequency frequency;
		
		protected QuantityScheduleImpl(QuantitySchedule.QuantityScheduleBuilder builder) {
			super(builder);
			this.multiplier = ofNullable(builder.getMultiplier()).map(f->f.build()).orElse(null);
			this.frequency = ofNullable(builder.getFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@RuneAttribute("multiplier")
		public Measure getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public Frequency getFrequency() {
			return frequency;
		}
		
		@Override
		public QuantitySchedule build() {
			return this;
		}
		
		@Override
		public QuantitySchedule.QuantityScheduleBuilder toBuilder() {
			QuantitySchedule.QuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantitySchedule.QuantityScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getFrequency()).ifPresent(builder::setFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantitySchedule {" +
				"multiplier=" + this.multiplier + ", " +
				"frequency=" + this.frequency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of QuantitySchedule  ***********************/
	class QuantityScheduleBuilderImpl extends MeasureSchedule.MeasureScheduleBuilderImpl implements QuantitySchedule.QuantityScheduleBuilder {
	
		protected Measure.MeasureBuilder multiplier;
		protected Frequency.FrequencyBuilder frequency;
		
		@Override
		@RosettaAttribute("multiplier")
		@RuneAttribute("multiplier")
		public Measure.MeasureBuilder getMultiplier() {
			return multiplier;
		}
		
		@Override
		public Measure.MeasureBuilder getOrCreateMultiplier() {
			Measure.MeasureBuilder result;
			if (multiplier!=null) {
				result = multiplier;
			}
			else {
				result = multiplier = Measure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public Frequency.FrequencyBuilder getFrequency() {
			return frequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateFrequency() {
			Frequency.FrequencyBuilder result;
			if (frequency!=null) {
				result = frequency;
			}
			else {
				result = frequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public QuantitySchedule.QuantityScheduleBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public QuantitySchedule.QuantityScheduleBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public QuantitySchedule.QuantityScheduleBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public QuantitySchedule.QuantityScheduleBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public QuantitySchedule.QuantityScheduleBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public QuantitySchedule.QuantityScheduleBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		public QuantitySchedule.QuantityScheduleBuilder setMultiplier(Measure _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public QuantitySchedule.QuantityScheduleBuilder setFrequency(Frequency _frequency) {
			this.frequency = _frequency == null ? null : _frequency.toBuilder();
			return this;
		}
		
		@Override
		public QuantitySchedule build() {
			return new QuantitySchedule.QuantityScheduleImpl(this);
		}
		
		@Override
		public QuantitySchedule.QuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantitySchedule.QuantityScheduleBuilder prune() {
			super.prune();
			if (multiplier!=null && !multiplier.prune().hasData()) multiplier = null;
			if (frequency!=null && !frequency.prune().hasData()) frequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null && getMultiplier().hasData()) return true;
			if (getFrequency()!=null && getFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantitySchedule.QuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			QuantitySchedule.QuantityScheduleBuilder o = (QuantitySchedule.QuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeRosetta(getFrequency(), o.getFrequency(), this::setFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityScheduleBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"frequency=" + this.frequency +
			'}' + " " + super.toString();
		}
	}
}
