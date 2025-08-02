package cdm.base.math;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.Frequency.FrequencyBuilder;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.Measure;
import cdm.base.math.Measure.MeasureBuilder;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleImpl;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.QuantitySchedule.QuantityScheduleBuilder;
import cdm.base.math.QuantitySchedule.QuantityScheduleBuilderImpl;
import cdm.base.math.QuantitySchedule.QuantityScheduleImpl;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.base.math.meta.NonNegativeQuantityScheduleMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="NonNegativeQuantitySchedule", builder=NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="NonNegativeQuantitySchedule", model="Just another Rosetta model", builder=NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl.class, version="6.0.0")
public interface NonNegativeQuantitySchedule extends QuantitySchedule {

	NonNegativeQuantityScheduleMeta metaData = new NonNegativeQuantityScheduleMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NonNegativeQuantitySchedule build();
	
	NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder();
	
	static NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder() {
		return new NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeQuantitySchedule> getType() {
		return NonNegativeQuantitySchedule.class;
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
	interface NonNegativeQuantityScheduleBuilder extends NonNegativeQuantitySchedule, QuantitySchedule.QuantityScheduleBuilder {
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setValue(BigDecimal value);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setUnit(UnitType unit);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(DatedValue datedValue);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setDatedValue(List<? extends DatedValue> datedValue);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setMultiplier(Measure multiplier);
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setFrequency(Frequency frequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("multiplier"), processor, Measure.MeasureBuilder.class, getMultiplier());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
		}
		

		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeQuantitySchedule  ***********************/
	class NonNegativeQuantityScheduleImpl extends QuantitySchedule.QuantityScheduleImpl implements NonNegativeQuantitySchedule {
		
		protected NonNegativeQuantityScheduleImpl(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder) {
			super(builder);
		}
		
		@Override
		public NonNegativeQuantitySchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder() {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder) {
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
			return "NonNegativeQuantitySchedule {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeQuantitySchedule  ***********************/
	class NonNegativeQuantityScheduleBuilderImpl extends QuantitySchedule.QuantityScheduleBuilderImpl implements NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder {
	
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setMultiplier(Measure _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setFrequency(Frequency _frequency) {
			this.frequency = _frequency == null ? null : _frequency.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule build() {
			return new NonNegativeQuantitySchedule.NonNegativeQuantityScheduleImpl(this);
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder prune() {
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
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder o = (NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder) other;
			
			
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
			return "NonNegativeQuantityScheduleBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
