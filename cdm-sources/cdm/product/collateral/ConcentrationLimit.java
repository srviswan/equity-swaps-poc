package cdm.product.collateral;

import cdm.base.math.MoneyRange;
import cdm.base.math.MoneyRange.MoneyRangeBuilder;
import cdm.base.math.NumberRange;
import cdm.base.math.NumberRange.NumberRangeBuilder;
import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.ConcentrationLimit.ConcentrationLimitBuilder;
import cdm.product.collateral.ConcentrationLimit.ConcentrationLimitBuilderImpl;
import cdm.product.collateral.ConcentrationLimit.ConcentrationLimitImpl;
import cdm.product.collateral.ConcentrationLimitCriteria;
import cdm.product.collateral.ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder;
import cdm.product.collateral.meta.ConcentrationLimitMeta;
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
 * Represents a class to describe concentration limits that may be applicable to eligible collateral criteria.
 * @version 6.0.0
 */
@RosettaDataType(value="ConcentrationLimit", builder=ConcentrationLimit.ConcentrationLimitBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ConcentrationLimit", model="Just another Rosetta model", builder=ConcentrationLimit.ConcentrationLimitBuilderImpl.class, version="6.0.0")
public interface ConcentrationLimit extends RosettaModelObject {

	ConcentrationLimitMeta metaData = new ConcentrationLimitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a set of criteria to describe the assets that the concentration limits apply to.
	 */
	ConcentrationLimitCriteria getConcentrationLimitCriteria();
	/**
	 * Specifies the value of collateral limit represented as a range.
	 */
	MoneyRange getValueLimit();
	/**
	 * Specifies the perecentage of collateral limit represented as a decimal number - example 25% is 0.25.
	 */
	NumberRange getPercentageLimit();

	/*********************** Build Methods  ***********************/
	ConcentrationLimit build();
	
	ConcentrationLimit.ConcentrationLimitBuilder toBuilder();
	
	static ConcentrationLimit.ConcentrationLimitBuilder builder() {
		return new ConcentrationLimit.ConcentrationLimitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConcentrationLimit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConcentrationLimit> getType() {
		return ConcentrationLimit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("concentrationLimitCriteria"), processor, ConcentrationLimitCriteria.class, getConcentrationLimitCriteria());
		processRosetta(path.newSubPath("valueLimit"), processor, MoneyRange.class, getValueLimit());
		processRosetta(path.newSubPath("percentageLimit"), processor, NumberRange.class, getPercentageLimit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConcentrationLimitBuilder extends ConcentrationLimit, RosettaModelObjectBuilder {
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getOrCreateConcentrationLimitCriteria();
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getConcentrationLimitCriteria();
		MoneyRange.MoneyRangeBuilder getOrCreateValueLimit();
		@Override
		MoneyRange.MoneyRangeBuilder getValueLimit();
		NumberRange.NumberRangeBuilder getOrCreatePercentageLimit();
		@Override
		NumberRange.NumberRangeBuilder getPercentageLimit();
		ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitCriteria(ConcentrationLimitCriteria concentrationLimitCriteria);
		ConcentrationLimit.ConcentrationLimitBuilder setValueLimit(MoneyRange valueLimit);
		ConcentrationLimit.ConcentrationLimitBuilder setPercentageLimit(NumberRange percentageLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("concentrationLimitCriteria"), processor, ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder.class, getConcentrationLimitCriteria());
			processRosetta(path.newSubPath("valueLimit"), processor, MoneyRange.MoneyRangeBuilder.class, getValueLimit());
			processRosetta(path.newSubPath("percentageLimit"), processor, NumberRange.NumberRangeBuilder.class, getPercentageLimit());
		}
		

		ConcentrationLimit.ConcentrationLimitBuilder prune();
	}

	/*********************** Immutable Implementation of ConcentrationLimit  ***********************/
	class ConcentrationLimitImpl implements ConcentrationLimit {
		private final ConcentrationLimitCriteria concentrationLimitCriteria;
		private final MoneyRange valueLimit;
		private final NumberRange percentageLimit;
		
		protected ConcentrationLimitImpl(ConcentrationLimit.ConcentrationLimitBuilder builder) {
			this.concentrationLimitCriteria = ofNullable(builder.getConcentrationLimitCriteria()).map(f->f.build()).orElse(null);
			this.valueLimit = ofNullable(builder.getValueLimit()).map(f->f.build()).orElse(null);
			this.percentageLimit = ofNullable(builder.getPercentageLimit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("concentrationLimitCriteria")
		@RuneAttribute("concentrationLimitCriteria")
		public ConcentrationLimitCriteria getConcentrationLimitCriteria() {
			return concentrationLimitCriteria;
		}
		
		@Override
		@RosettaAttribute("valueLimit")
		@RuneAttribute("valueLimit")
		public MoneyRange getValueLimit() {
			return valueLimit;
		}
		
		@Override
		@RosettaAttribute("percentageLimit")
		@RuneAttribute("percentageLimit")
		public NumberRange getPercentageLimit() {
			return percentageLimit;
		}
		
		@Override
		public ConcentrationLimit build() {
			return this;
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder toBuilder() {
			ConcentrationLimit.ConcentrationLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConcentrationLimit.ConcentrationLimitBuilder builder) {
			ofNullable(getConcentrationLimitCriteria()).ifPresent(builder::setConcentrationLimitCriteria);
			ofNullable(getValueLimit()).ifPresent(builder::setValueLimit);
			ofNullable(getPercentageLimit()).ifPresent(builder::setPercentageLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimit _that = getType().cast(o);
		
			if (!Objects.equals(concentrationLimitCriteria, _that.getConcentrationLimitCriteria())) return false;
			if (!Objects.equals(valueLimit, _that.getValueLimit())) return false;
			if (!Objects.equals(percentageLimit, _that.getPercentageLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimitCriteria != null ? concentrationLimitCriteria.hashCode() : 0);
			_result = 31 * _result + (valueLimit != null ? valueLimit.hashCode() : 0);
			_result = 31 * _result + (percentageLimit != null ? percentageLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimit {" +
				"concentrationLimitCriteria=" + this.concentrationLimitCriteria + ", " +
				"valueLimit=" + this.valueLimit + ", " +
				"percentageLimit=" + this.percentageLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of ConcentrationLimit  ***********************/
	class ConcentrationLimitBuilderImpl implements ConcentrationLimit.ConcentrationLimitBuilder {
	
		protected ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder concentrationLimitCriteria;
		protected MoneyRange.MoneyRangeBuilder valueLimit;
		protected NumberRange.NumberRangeBuilder percentageLimit;
		
		@Override
		@RosettaAttribute("concentrationLimitCriteria")
		@RuneAttribute("concentrationLimitCriteria")
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getConcentrationLimitCriteria() {
			return concentrationLimitCriteria;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder getOrCreateConcentrationLimitCriteria() {
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder result;
			if (concentrationLimitCriteria!=null) {
				result = concentrationLimitCriteria;
			}
			else {
				result = concentrationLimitCriteria = ConcentrationLimitCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valueLimit")
		@RuneAttribute("valueLimit")
		public MoneyRange.MoneyRangeBuilder getValueLimit() {
			return valueLimit;
		}
		
		@Override
		public MoneyRange.MoneyRangeBuilder getOrCreateValueLimit() {
			MoneyRange.MoneyRangeBuilder result;
			if (valueLimit!=null) {
				result = valueLimit;
			}
			else {
				result = valueLimit = MoneyRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageLimit")
		@RuneAttribute("percentageLimit")
		public NumberRange.NumberRangeBuilder getPercentageLimit() {
			return percentageLimit;
		}
		
		@Override
		public NumberRange.NumberRangeBuilder getOrCreatePercentageLimit() {
			NumberRange.NumberRangeBuilder result;
			if (percentageLimit!=null) {
				result = percentageLimit;
			}
			else {
				result = percentageLimit = NumberRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("concentrationLimitCriteria")
		@RuneAttribute("concentrationLimitCriteria")
		public ConcentrationLimit.ConcentrationLimitBuilder setConcentrationLimitCriteria(ConcentrationLimitCriteria _concentrationLimitCriteria) {
			this.concentrationLimitCriteria = _concentrationLimitCriteria == null ? null : _concentrationLimitCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("valueLimit")
		@RuneAttribute("valueLimit")
		public ConcentrationLimit.ConcentrationLimitBuilder setValueLimit(MoneyRange _valueLimit) {
			this.valueLimit = _valueLimit == null ? null : _valueLimit.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("percentageLimit")
		@RuneAttribute("percentageLimit")
		public ConcentrationLimit.ConcentrationLimitBuilder setPercentageLimit(NumberRange _percentageLimit) {
			this.percentageLimit = _percentageLimit == null ? null : _percentageLimit.toBuilder();
			return this;
		}
		
		@Override
		public ConcentrationLimit build() {
			return new ConcentrationLimit.ConcentrationLimitImpl(this);
		}
		
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder prune() {
			if (concentrationLimitCriteria!=null && !concentrationLimitCriteria.prune().hasData()) concentrationLimitCriteria = null;
			if (valueLimit!=null && !valueLimit.prune().hasData()) valueLimit = null;
			if (percentageLimit!=null && !percentageLimit.prune().hasData()) percentageLimit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConcentrationLimitCriteria()!=null && getConcentrationLimitCriteria().hasData()) return true;
			if (getValueLimit()!=null && getValueLimit().hasData()) return true;
			if (getPercentageLimit()!=null && getPercentageLimit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimit.ConcentrationLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConcentrationLimit.ConcentrationLimitBuilder o = (ConcentrationLimit.ConcentrationLimitBuilder) other;
			
			merger.mergeRosetta(getConcentrationLimitCriteria(), o.getConcentrationLimitCriteria(), this::setConcentrationLimitCriteria);
			merger.mergeRosetta(getValueLimit(), o.getValueLimit(), this::setValueLimit);
			merger.mergeRosetta(getPercentageLimit(), o.getPercentageLimit(), this::setPercentageLimit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConcentrationLimit _that = getType().cast(o);
		
			if (!Objects.equals(concentrationLimitCriteria, _that.getConcentrationLimitCriteria())) return false;
			if (!Objects.equals(valueLimit, _that.getValueLimit())) return false;
			if (!Objects.equals(percentageLimit, _that.getPercentageLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (concentrationLimitCriteria != null ? concentrationLimitCriteria.hashCode() : 0);
			_result = 31 * _result + (valueLimit != null ? valueLimit.hashCode() : 0);
			_result = 31 * _result + (percentageLimit != null ? percentageLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitBuilder {" +
				"concentrationLimitCriteria=" + this.concentrationLimitCriteria + ", " +
				"valueLimit=" + this.valueLimit + ", " +
				"percentageLimit=" + this.percentageLimit +
			'}';
		}
	}
}
