package cdm.product.template;

import cdm.base.math.AveragingCalculationMethod;
import cdm.base.math.AveragingCalculationMethod.AveragingCalculationMethodBuilder;
import cdm.base.math.Rounding;
import cdm.base.math.Rounding.RoundingBuilder;
import cdm.product.template.AveragingCalculation;
import cdm.product.template.AveragingCalculation.AveragingCalculationBuilder;
import cdm.product.template.AveragingCalculation.AveragingCalculationBuilderImpl;
import cdm.product.template.AveragingCalculation.AveragingCalculationImpl;
import cdm.product.template.meta.AveragingCalculationMeta;
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
 * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
 * @version 6.0.0
 */
@RosettaDataType(value="AveragingCalculation", builder=AveragingCalculation.AveragingCalculationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AveragingCalculation", model="Just another Rosetta model", builder=AveragingCalculation.AveragingCalculationBuilderImpl.class, version="6.0.0")
public interface AveragingCalculation extends RosettaModelObject {

	AveragingCalculationMeta metaData = new AveragingCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies enumerations for the type of averaging calculation.
	 */
	AveragingCalculationMethod getAveragingMethod();
	/**
	 * Rounding applied to the average calculation. 
	 */
	Rounding getPrecision();

	/*********************** Build Methods  ***********************/
	AveragingCalculation build();
	
	AveragingCalculation.AveragingCalculationBuilder toBuilder();
	
	static AveragingCalculation.AveragingCalculationBuilder builder() {
		return new AveragingCalculation.AveragingCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AveragingCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AveragingCalculation> getType() {
		return AveragingCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("averagingMethod"), processor, AveragingCalculationMethod.class, getAveragingMethod());
		processRosetta(path.newSubPath("precision"), processor, Rounding.class, getPrecision());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AveragingCalculationBuilder extends AveragingCalculation, RosettaModelObjectBuilder {
		AveragingCalculationMethod.AveragingCalculationMethodBuilder getOrCreateAveragingMethod();
		@Override
		AveragingCalculationMethod.AveragingCalculationMethodBuilder getAveragingMethod();
		Rounding.RoundingBuilder getOrCreatePrecision();
		@Override
		Rounding.RoundingBuilder getPrecision();
		AveragingCalculation.AveragingCalculationBuilder setAveragingMethod(AveragingCalculationMethod averagingMethod);
		AveragingCalculation.AveragingCalculationBuilder setPrecision(Rounding precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("averagingMethod"), processor, AveragingCalculationMethod.AveragingCalculationMethodBuilder.class, getAveragingMethod());
			processRosetta(path.newSubPath("precision"), processor, Rounding.RoundingBuilder.class, getPrecision());
		}
		

		AveragingCalculation.AveragingCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of AveragingCalculation  ***********************/
	class AveragingCalculationImpl implements AveragingCalculation {
		private final AveragingCalculationMethod averagingMethod;
		private final Rounding precision;
		
		protected AveragingCalculationImpl(AveragingCalculation.AveragingCalculationBuilder builder) {
			this.averagingMethod = ofNullable(builder.getAveragingMethod()).map(f->f.build()).orElse(null);
			this.precision = ofNullable(builder.getPrecision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public AveragingCalculationMethod getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public Rounding getPrecision() {
			return precision;
		}
		
		@Override
		public AveragingCalculation build() {
			return this;
		}
		
		@Override
		public AveragingCalculation.AveragingCalculationBuilder toBuilder() {
			AveragingCalculation.AveragingCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragingCalculation.AveragingCalculationBuilder builder) {
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingCalculation _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingCalculation {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}';
		}
	}

	/*********************** Builder Implementation of AveragingCalculation  ***********************/
	class AveragingCalculationBuilderImpl implements AveragingCalculation.AveragingCalculationBuilder {
	
		protected AveragingCalculationMethod.AveragingCalculationMethodBuilder averagingMethod;
		protected Rounding.RoundingBuilder precision;
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public AveragingCalculationMethod.AveragingCalculationMethodBuilder getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public AveragingCalculationMethod.AveragingCalculationMethodBuilder getOrCreateAveragingMethod() {
			AveragingCalculationMethod.AveragingCalculationMethodBuilder result;
			if (averagingMethod!=null) {
				result = averagingMethod;
			}
			else {
				result = averagingMethod = AveragingCalculationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public Rounding.RoundingBuilder getPrecision() {
			return precision;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreatePrecision() {
			Rounding.RoundingBuilder result;
			if (precision!=null) {
				result = precision;
			}
			else {
				result = precision = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@RuneAttribute("averagingMethod")
		public AveragingCalculation.AveragingCalculationBuilder setAveragingMethod(AveragingCalculationMethod _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("precision")
		@RuneAttribute("precision")
		public AveragingCalculation.AveragingCalculationBuilder setPrecision(Rounding _precision) {
			this.precision = _precision == null ? null : _precision.toBuilder();
			return this;
		}
		
		@Override
		public AveragingCalculation build() {
			return new AveragingCalculation.AveragingCalculationImpl(this);
		}
		
		@Override
		public AveragingCalculation.AveragingCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingCalculation.AveragingCalculationBuilder prune() {
			if (averagingMethod!=null && !averagingMethod.prune().hasData()) averagingMethod = null;
			if (precision!=null && !precision.prune().hasData()) precision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingMethod()!=null && getAveragingMethod().hasData()) return true;
			if (getPrecision()!=null && getPrecision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingCalculation.AveragingCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AveragingCalculation.AveragingCalculationBuilder o = (AveragingCalculation.AveragingCalculationBuilder) other;
			
			merger.mergeRosetta(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeRosetta(getPrecision(), o.getPrecision(), this::setPrecision);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingCalculation _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingCalculationBuilder {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
}
