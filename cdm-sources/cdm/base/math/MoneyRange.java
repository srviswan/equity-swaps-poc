package cdm.base.math;

import cdm.base.math.MoneyBound;
import cdm.base.math.MoneyBound.MoneyBoundBuilder;
import cdm.base.math.MoneyRange;
import cdm.base.math.MoneyRange.MoneyRangeBuilder;
import cdm.base.math.MoneyRange.MoneyRangeBuilderImpl;
import cdm.base.math.MoneyRange.MoneyRangeImpl;
import cdm.base.math.meta.MoneyRangeMeta;
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
 * The money range defined as either a lower and upper money bound, or both.
 * @version 6.0.0
 */
@RosettaDataType(value="MoneyRange", builder=MoneyRange.MoneyRangeBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MoneyRange", model="Just another Rosetta model", builder=MoneyRange.MoneyRangeBuilderImpl.class, version="6.0.0")
public interface MoneyRange extends RosettaModelObject {

	MoneyRangeMeta metaData = new MoneyRangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The lower bound of a money range, e.g. greater than or equal to 1,000 USD.
	 */
	MoneyBound getLowerBound();
	/**
	 * The upper bound of a money range, e.g. less than 10,000 USD.
	 */
	MoneyBound getUpperBound();

	/*********************** Build Methods  ***********************/
	MoneyRange build();
	
	MoneyRange.MoneyRangeBuilder toBuilder();
	
	static MoneyRange.MoneyRangeBuilder builder() {
		return new MoneyRange.MoneyRangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MoneyRange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MoneyRange> getType() {
		return MoneyRange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lowerBound"), processor, MoneyBound.class, getLowerBound());
		processRosetta(path.newSubPath("upperBound"), processor, MoneyBound.class, getUpperBound());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyRangeBuilder extends MoneyRange, RosettaModelObjectBuilder {
		MoneyBound.MoneyBoundBuilder getOrCreateLowerBound();
		@Override
		MoneyBound.MoneyBoundBuilder getLowerBound();
		MoneyBound.MoneyBoundBuilder getOrCreateUpperBound();
		@Override
		MoneyBound.MoneyBoundBuilder getUpperBound();
		MoneyRange.MoneyRangeBuilder setLowerBound(MoneyBound lowerBound);
		MoneyRange.MoneyRangeBuilder setUpperBound(MoneyBound upperBound);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lowerBound"), processor, MoneyBound.MoneyBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("upperBound"), processor, MoneyBound.MoneyBoundBuilder.class, getUpperBound());
		}
		

		MoneyRange.MoneyRangeBuilder prune();
	}

	/*********************** Immutable Implementation of MoneyRange  ***********************/
	class MoneyRangeImpl implements MoneyRange {
		private final MoneyBound lowerBound;
		private final MoneyBound upperBound;
		
		protected MoneyRangeImpl(MoneyRange.MoneyRangeBuilder builder) {
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@RuneAttribute("lowerBound")
		public MoneyBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@RuneAttribute("upperBound")
		public MoneyBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		public MoneyRange build() {
			return this;
		}
		
		@Override
		public MoneyRange.MoneyRangeBuilder toBuilder() {
			MoneyRange.MoneyRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MoneyRange.MoneyRangeBuilder builder) {
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MoneyRange _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyRange {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}

	/*********************** Builder Implementation of MoneyRange  ***********************/
	class MoneyRangeBuilderImpl implements MoneyRange.MoneyRangeBuilder {
	
		protected MoneyBound.MoneyBoundBuilder lowerBound;
		protected MoneyBound.MoneyBoundBuilder upperBound;
		
		@Override
		@RosettaAttribute("lowerBound")
		@RuneAttribute("lowerBound")
		public MoneyBound.MoneyBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public MoneyBound.MoneyBoundBuilder getOrCreateLowerBound() {
			MoneyBound.MoneyBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = MoneyBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@RuneAttribute("upperBound")
		public MoneyBound.MoneyBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public MoneyBound.MoneyBoundBuilder getOrCreateUpperBound() {
			MoneyBound.MoneyBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = MoneyBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@RuneAttribute("lowerBound")
		public MoneyRange.MoneyRangeBuilder setLowerBound(MoneyBound _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@RuneAttribute("upperBound")
		public MoneyRange.MoneyRangeBuilder setUpperBound(MoneyBound _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound.toBuilder();
			return this;
		}
		
		@Override
		public MoneyRange build() {
			return new MoneyRange.MoneyRangeImpl(this);
		}
		
		@Override
		public MoneyRange.MoneyRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyRange.MoneyRangeBuilder prune() {
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyRange.MoneyRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MoneyRange.MoneyRangeBuilder o = (MoneyRange.MoneyRangeBuilder) other;
			
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MoneyRange _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyRangeBuilder {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}
}
