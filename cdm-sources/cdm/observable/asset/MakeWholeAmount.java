package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.observable.asset.MakeWholeAmount;
import cdm.observable.asset.MakeWholeAmount.MakeWholeAmountBuilder;
import cdm.observable.asset.MakeWholeAmount.MakeWholeAmountBuilderImpl;
import cdm.observable.asset.MakeWholeAmount.MakeWholeAmountImpl;
import cdm.observable.asset.QuotationSideEnum;
import cdm.observable.asset.SwapCurveValuation;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationBuilder;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationBuilderImpl;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationImpl;
import cdm.observable.asset.meta.MakeWholeAmountMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (typically applicable to the convertible bond options).
 * @version 6.0.0
 */
@RosettaDataType(value="MakeWholeAmount", builder=MakeWholeAmount.MakeWholeAmountBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MakeWholeAmount", model="Just another Rosetta model", builder=MakeWholeAmount.MakeWholeAmountBuilderImpl.class, version="6.0.0")
public interface MakeWholeAmount extends SwapCurveValuation {

	MakeWholeAmountMeta metaData = new MakeWholeAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of interpolation method that the calculation agent reserves the right to use.
	 */
	InterpolationMethodEnum getInterpolationMethod();
	/**
	 * Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
	 */
	FieldWithMetaDate getEarlyCallDate();

	/*********************** Build Methods  ***********************/
	MakeWholeAmount build();
	
	MakeWholeAmount.MakeWholeAmountBuilder toBuilder();
	
	static MakeWholeAmount.MakeWholeAmountBuilder builder() {
		return new MakeWholeAmount.MakeWholeAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MakeWholeAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MakeWholeAmount> getType() {
		return MakeWholeAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
		processor.processBasic(path.newSubPath("interpolationMethod"), InterpolationMethodEnum.class, getInterpolationMethod(), this);
		processRosetta(path.newSubPath("earlyCallDate"), processor, FieldWithMetaDate.class, getEarlyCallDate(), AttributeMeta.GLOBAL_KEY_FIELD);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MakeWholeAmountBuilder extends MakeWholeAmount, SwapCurveValuation.SwapCurveValuationBuilder {
		FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateEarlyCallDate();
		@Override
		FieldWithMetaDate.FieldWithMetaDateBuilder getEarlyCallDate();
		@Override
		MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex);
		@Override
		MakeWholeAmount.MakeWholeAmountBuilder setIndexTenor(Period indexTenor);
		@Override
		MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal spread);
		@Override
		MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum side);
		MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethodEnum interpolationMethod);
		MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(FieldWithMetaDate earlyCallDate);
		MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDateValue(Date earlyCallDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("side"), QuotationSideEnum.class, getSide(), this);
			processor.processBasic(path.newSubPath("interpolationMethod"), InterpolationMethodEnum.class, getInterpolationMethod(), this);
			processRosetta(path.newSubPath("earlyCallDate"), processor, FieldWithMetaDate.FieldWithMetaDateBuilder.class, getEarlyCallDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		}
		

		MakeWholeAmount.MakeWholeAmountBuilder prune();
	}

	/*********************** Immutable Implementation of MakeWholeAmount  ***********************/
	class MakeWholeAmountImpl extends SwapCurveValuation.SwapCurveValuationImpl implements MakeWholeAmount {
		private final InterpolationMethodEnum interpolationMethod;
		private final FieldWithMetaDate earlyCallDate;
		
		protected MakeWholeAmountImpl(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super(builder);
			this.interpolationMethod = builder.getInterpolationMethod();
			this.earlyCallDate = ofNullable(builder.getEarlyCallDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public InterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("earlyCallDate")
		@RuneAttribute("earlyCallDate")
		public FieldWithMetaDate getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public MakeWholeAmount build() {
			return this;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			MakeWholeAmount.MakeWholeAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getEarlyCallDate()).ifPresent(builder::setEarlyCallDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmount {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"earlyCallDate=" + this.earlyCallDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MakeWholeAmount  ***********************/
	class MakeWholeAmountBuilderImpl extends SwapCurveValuation.SwapCurveValuationBuilderImpl implements MakeWholeAmount.MakeWholeAmountBuilder {
	
		protected InterpolationMethodEnum interpolationMethod;
		protected FieldWithMetaDate.FieldWithMetaDateBuilder earlyCallDate;
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public InterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("earlyCallDate")
		@RuneAttribute("earlyCallDate")
		public FieldWithMetaDate.FieldWithMetaDateBuilder getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateEarlyCallDate() {
			FieldWithMetaDate.FieldWithMetaDateBuilder result;
			if (earlyCallDate!=null) {
				result = earlyCallDate;
			}
			else {
				result = earlyCallDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndex(FloatingRateIndexEnum _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex;
			return this;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@RuneAttribute("indexTenor")
		public MakeWholeAmount.MakeWholeAmountBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("spread")
		@RuneAttribute("spread")
		public MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@Override
		@RosettaAttribute("side")
		@RuneAttribute("side")
		public MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum _side) {
			this.side = _side == null ? null : _side;
			return this;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@RuneAttribute("interpolationMethod")
		public MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethodEnum _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod;
			return this;
		}
		
		@Override
		@RosettaAttribute("earlyCallDate")
		@RuneAttribute("earlyCallDate")
		public MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(FieldWithMetaDate _earlyCallDate) {
			this.earlyCallDate = _earlyCallDate == null ? null : _earlyCallDate.toBuilder();
			return this;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDateValue(Date _earlyCallDate) {
			this.getOrCreateEarlyCallDate().setValue(_earlyCallDate);
			return this;
		}
		
		@Override
		public MakeWholeAmount build() {
			return new MakeWholeAmount.MakeWholeAmountImpl(this);
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder prune() {
			super.prune();
			if (earlyCallDate!=null && !earlyCallDate.prune().hasData()) earlyCallDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInterpolationMethod()!=null) return true;
			if (getEarlyCallDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MakeWholeAmount.MakeWholeAmountBuilder o = (MakeWholeAmount.MakeWholeAmountBuilder) other;
			
			merger.mergeRosetta(getEarlyCallDate(), o.getEarlyCallDate(), this::setEarlyCallDate);
			
			merger.mergeBasic(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmountBuilder {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"earlyCallDate=" + this.earlyCallDate +
			'}' + " " + super.toString();
		}
	}
}
