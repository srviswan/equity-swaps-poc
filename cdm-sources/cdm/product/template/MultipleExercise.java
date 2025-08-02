package cdm.product.template;

import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.template.MultipleExercise;
import cdm.product.template.MultipleExercise.MultipleExerciseBuilder;
import cdm.product.template.MultipleExercise.MultipleExerciseBuilderImpl;
import cdm.product.template.MultipleExercise.MultipleExerciseImpl;
import cdm.product.template.PartialExercise;
import cdm.product.template.PartialExercise.PartialExerciseBuilder;
import cdm.product.template.PartialExercise.PartialExerciseBuilderImpl;
import cdm.product.template.PartialExercise.PartialExerciseImpl;
import cdm.product.template.meta.MultipleExerciseMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining multiple exercises. As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount. In FpML, MultipleExercise is built upon the PartialExercise.model.
 * @version 6.0.0
 */
@RosettaDataType(value="MultipleExercise", builder=MultipleExercise.MultipleExerciseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MultipleExercise", model="Just another Rosetta model", builder=MultipleExercise.MultipleExerciseBuilderImpl.class, version="6.0.0")
public interface MultipleExercise extends PartialExercise {

	MultipleExerciseMeta metaData = new MultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The maximum notional amount that can be exercised on a given exercise date.
	 */
	BigDecimal getMaximumNotionalAmount();
	/**
	 * The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
	 */
	Integer getMaximumNumberOfOptions();

	/*********************** Build Methods  ***********************/
	MultipleExercise build();
	
	MultipleExercise.MultipleExerciseBuilder toBuilder();
	
	static MultipleExercise.MultipleExerciseBuilder builder() {
		return new MultipleExercise.MultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MultipleExercise> getType() {
		return MultipleExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionaReference"), processor, ReferenceWithMetaMoney.class, getNotionaReference());
		processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
		processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("maximumNumberOfOptions"), Integer.class, getMaximumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MultipleExerciseBuilder extends MultipleExercise, PartialExercise.PartialExerciseBuilder {
		@Override
		MultipleExercise.MultipleExerciseBuilder setNotionaReference(ReferenceWithMetaMoney notionaReference);
		@Override
		MultipleExercise.MultipleExerciseBuilder setNotionaReferenceValue(Money notionaReference);
		@Override
		MultipleExercise.MultipleExerciseBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount);
		@Override
		MultipleExercise.MultipleExerciseBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount);
		@Override
		MultipleExercise.MultipleExerciseBuilder setMinimumNumberOfOptions(Integer minimumNumberOfOptions);
		MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal maximumNotionalAmount);
		MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(Integer maximumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionaReference"), processor, ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder.class, getNotionaReference());
			processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
			processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("maximumNumberOfOptions"), Integer.class, getMaximumNumberOfOptions(), this);
		}
		

		MultipleExercise.MultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of MultipleExercise  ***********************/
	class MultipleExerciseImpl extends PartialExercise.PartialExerciseImpl implements MultipleExercise {
		private final BigDecimal maximumNotionalAmount;
		private final Integer maximumNumberOfOptions;
		
		protected MultipleExerciseImpl(MultipleExercise.MultipleExerciseBuilder builder) {
			super(builder);
			this.maximumNotionalAmount = builder.getMaximumNotionalAmount();
			this.maximumNumberOfOptions = builder.getMaximumNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@RuneAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@RuneAttribute("maximumNumberOfOptions")
		public Integer getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		public MultipleExercise build() {
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			MultipleExercise.MultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultipleExercise.MultipleExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMaximumNotionalAmount()).ifPresent(builder::setMaximumNotionalAmount);
			ofNullable(getMaximumNumberOfOptions()).ifPresent(builder::setMaximumNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExercise {" +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MultipleExercise  ***********************/
	class MultipleExerciseBuilderImpl extends PartialExercise.PartialExerciseBuilderImpl implements MultipleExercise.MultipleExerciseBuilder {
	
		protected BigDecimal maximumNotionalAmount;
		protected Integer maximumNumberOfOptions;
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@RuneAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@RuneAttribute("maximumNumberOfOptions")
		public Integer getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("notionaReference")
		@RuneAttribute("notionaReference")
		public MultipleExercise.MultipleExerciseBuilder setNotionaReference(ReferenceWithMetaMoney _notionaReference) {
			this.notionaReference = _notionaReference == null ? null : _notionaReference.toBuilder();
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder setNotionaReferenceValue(Money _notionaReference) {
			this.getOrCreateNotionaReference().setValue(_notionaReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		@RuneAttribute("integralMultipleAmount")
		public MultipleExercise.MultipleExerciseBuilder setIntegralMultipleAmount(BigDecimal _integralMultipleAmount) {
			this.integralMultipleAmount = _integralMultipleAmount == null ? null : _integralMultipleAmount;
			return this;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		@RuneAttribute("minimumNotionalAmount")
		public MultipleExercise.MultipleExerciseBuilder setMinimumNotionalAmount(BigDecimal _minimumNotionalAmount) {
			this.minimumNotionalAmount = _minimumNotionalAmount == null ? null : _minimumNotionalAmount;
			return this;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		@RuneAttribute("minimumNumberOfOptions")
		public MultipleExercise.MultipleExerciseBuilder setMinimumNumberOfOptions(Integer _minimumNumberOfOptions) {
			this.minimumNumberOfOptions = _minimumNumberOfOptions == null ? null : _minimumNumberOfOptions;
			return this;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@RuneAttribute("maximumNotionalAmount")
		public MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal _maximumNotionalAmount) {
			this.maximumNotionalAmount = _maximumNotionalAmount == null ? null : _maximumNotionalAmount;
			return this;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@RuneAttribute("maximumNumberOfOptions")
		public MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(Integer _maximumNumberOfOptions) {
			this.maximumNumberOfOptions = _maximumNumberOfOptions == null ? null : _maximumNumberOfOptions;
			return this;
		}
		
		@Override
		public MultipleExercise build() {
			return new MultipleExercise.MultipleExerciseImpl(this);
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMaximumNotionalAmount()!=null) return true;
			if (getMaximumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MultipleExercise.MultipleExerciseBuilder o = (MultipleExercise.MultipleExerciseBuilder) other;
			
			
			merger.mergeBasic(getMaximumNotionalAmount(), o.getMaximumNotionalAmount(), this::setMaximumNotionalAmount);
			merger.mergeBasic(getMaximumNumberOfOptions(), o.getMaximumNumberOfOptions(), this::setMaximumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExerciseBuilder {" +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}' + " " + super.toString();
		}
	}
}
