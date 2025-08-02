package cdm.base.math;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.Frequency.FrequencyBuilder;
import cdm.base.math.DatedValue;
import cdm.base.math.DatedValue.DatedValueBuilder;
import cdm.base.math.Measure;
import cdm.base.math.Measure.MeasureBuilder;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilder;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilderImpl;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityImpl;
import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.math.Quantity.QuantityBuilderImpl;
import cdm.base.math.Quantity.QuantityImpl;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import cdm.base.math.meta.NonNegativeQuantityMeta;
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
 * Specifies a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
 * @version 6.0.0
 */
@RosettaDataType(value="NonNegativeQuantity", builder=NonNegativeQuantity.NonNegativeQuantityBuilderImpl.class, version="6.0.0")
@RuneDataType(value="NonNegativeQuantity", model="Just another Rosetta model", builder=NonNegativeQuantity.NonNegativeQuantityBuilderImpl.class, version="6.0.0")
public interface NonNegativeQuantity extends Quantity {

	NonNegativeQuantityMeta metaData = new NonNegativeQuantityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NonNegativeQuantity build();
	
	NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder();
	
	static NonNegativeQuantity.NonNegativeQuantityBuilder builder() {
		return new NonNegativeQuantity.NonNegativeQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonNegativeQuantity> getType() {
		return NonNegativeQuantity.class;
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
	interface NonNegativeQuantityBuilder extends NonNegativeQuantity, Quantity.QuantityBuilder {
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder setValue(BigDecimal value);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder setUnit(UnitType unit);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(DatedValue datedValue);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(DatedValue datedValue, int _idx);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(List<? extends DatedValue> datedValue);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder setDatedValue(List<? extends DatedValue> datedValue);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplier(Measure multiplier);
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder setFrequency(Frequency frequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processRosetta(path.newSubPath("unit"), processor, UnitType.UnitTypeBuilder.class, getUnit());
			processRosetta(path.newSubPath("datedValue"), processor, DatedValue.DatedValueBuilder.class, getDatedValue());
			processRosetta(path.newSubPath("multiplier"), processor, Measure.MeasureBuilder.class, getMultiplier());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
		}
		

		NonNegativeQuantity.NonNegativeQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeQuantity  ***********************/
	class NonNegativeQuantityImpl extends Quantity.QuantityImpl implements NonNegativeQuantity {
		
		protected NonNegativeQuantityImpl(NonNegativeQuantity.NonNegativeQuantityBuilder builder) {
			super(builder);
		}
		
		@Override
		public NonNegativeQuantity build() {
			return this;
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder() {
			NonNegativeQuantity.NonNegativeQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeQuantity.NonNegativeQuantityBuilder builder) {
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
			return "NonNegativeQuantity {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeQuantity  ***********************/
	class NonNegativeQuantityBuilderImpl extends Quantity.QuantityBuilderImpl implements NonNegativeQuantity.NonNegativeQuantityBuilder {
	
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("value")
		public NonNegativeQuantity.NonNegativeQuantityBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		@RosettaAttribute("unit")
		@RuneAttribute("unit")
		public NonNegativeQuantity.NonNegativeQuantityBuilder setUnit(UnitType _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("datedValue")
		@RuneAttribute("datedValue")
		public NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(DatedValue _datedValue) {
			if (_datedValue != null) {
				this.datedValue.add(_datedValue.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(DatedValue _datedValue, int _idx) {
			getIndex(this.datedValue, _idx, () -> _datedValue.toBuilder());
			return this;
		}
		
		@Override 
		public NonNegativeQuantity.NonNegativeQuantityBuilder addDatedValue(List<? extends DatedValue> datedValues) {
			if (datedValues != null) {
				for (final DatedValue toAdd : datedValues) {
					this.datedValue.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("datedValue")
		public NonNegativeQuantity.NonNegativeQuantityBuilder setDatedValue(List<? extends DatedValue> datedValues) {
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
		public NonNegativeQuantity.NonNegativeQuantityBuilder setMultiplier(Measure _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("frequency")
		@RuneAttribute("frequency")
		public NonNegativeQuantity.NonNegativeQuantityBuilder setFrequency(Frequency _frequency) {
			this.frequency = _frequency == null ? null : _frequency.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeQuantity build() {
			return new NonNegativeQuantity.NonNegativeQuantityImpl(this);
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder prune() {
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
		public NonNegativeQuantity.NonNegativeQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeQuantity.NonNegativeQuantityBuilder o = (NonNegativeQuantity.NonNegativeQuantityBuilder) other;
			
			
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
			return "NonNegativeQuantityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
