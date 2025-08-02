package cdm.margin.schedule;

import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.StandardizedSchedule.StandardizedScheduleBuilder;
import cdm.margin.schedule.StandardizedSchedule.StandardizedScheduleBuilderImpl;
import cdm.margin.schedule.StandardizedSchedule.StandardizedScheduleImpl;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.meta.StandardizedScheduleMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="StandardizedSchedule", builder=StandardizedSchedule.StandardizedScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="StandardizedSchedule", model="Just another Rosetta model", builder=StandardizedSchedule.StandardizedScheduleBuilderImpl.class, version="6.0.0")
public interface StandardizedSchedule extends RosettaModelObject {

	StandardizedScheduleMeta metaData = new StandardizedScheduleMeta();

	/*********************** Getter Methods  ***********************/
	StandardizedScheduleAssetClassEnum getAssetClass();
	StandardizedScheduleProductClassEnum getProductClass();
	BigDecimal getNotional();
	String getNotionalCurrency();
	BigDecimal getDurationInYears();

	/*********************** Build Methods  ***********************/
	StandardizedSchedule build();
	
	StandardizedSchedule.StandardizedScheduleBuilder toBuilder();
	
	static StandardizedSchedule.StandardizedScheduleBuilder builder() {
		return new StandardizedSchedule.StandardizedScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StandardizedSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StandardizedSchedule> getType() {
		return StandardizedSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("assetClass"), StandardizedScheduleAssetClassEnum.class, getAssetClass(), this);
		processor.processBasic(path.newSubPath("productClass"), StandardizedScheduleProductClassEnum.class, getProductClass(), this);
		processor.processBasic(path.newSubPath("notional"), BigDecimal.class, getNotional(), this);
		processor.processBasic(path.newSubPath("notionalCurrency"), String.class, getNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("durationInYears"), BigDecimal.class, getDurationInYears(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StandardizedScheduleBuilder extends StandardizedSchedule, RosettaModelObjectBuilder {
		StandardizedSchedule.StandardizedScheduleBuilder setAssetClass(StandardizedScheduleAssetClassEnum assetClass);
		StandardizedSchedule.StandardizedScheduleBuilder setProductClass(StandardizedScheduleProductClassEnum productClass);
		StandardizedSchedule.StandardizedScheduleBuilder setNotional(BigDecimal notional);
		StandardizedSchedule.StandardizedScheduleBuilder setNotionalCurrency(String notionalCurrency);
		StandardizedSchedule.StandardizedScheduleBuilder setDurationInYears(BigDecimal durationInYears);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("assetClass"), StandardizedScheduleAssetClassEnum.class, getAssetClass(), this);
			processor.processBasic(path.newSubPath("productClass"), StandardizedScheduleProductClassEnum.class, getProductClass(), this);
			processor.processBasic(path.newSubPath("notional"), BigDecimal.class, getNotional(), this);
			processor.processBasic(path.newSubPath("notionalCurrency"), String.class, getNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("durationInYears"), BigDecimal.class, getDurationInYears(), this);
		}
		

		StandardizedSchedule.StandardizedScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of StandardizedSchedule  ***********************/
	class StandardizedScheduleImpl implements StandardizedSchedule {
		private final StandardizedScheduleAssetClassEnum assetClass;
		private final StandardizedScheduleProductClassEnum productClass;
		private final BigDecimal notional;
		private final String notionalCurrency;
		private final BigDecimal durationInYears;
		
		protected StandardizedScheduleImpl(StandardizedSchedule.StandardizedScheduleBuilder builder) {
			this.assetClass = builder.getAssetClass();
			this.productClass = builder.getProductClass();
			this.notional = builder.getNotional();
			this.notionalCurrency = builder.getNotionalCurrency();
			this.durationInYears = builder.getDurationInYears();
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public StandardizedScheduleAssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("productClass")
		@RuneAttribute("productClass")
		public StandardizedScheduleProductClassEnum getProductClass() {
			return productClass;
		}
		
		@Override
		@RosettaAttribute("notional")
		@RuneAttribute("notional")
		public BigDecimal getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@RuneAttribute("notionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("durationInYears")
		@RuneAttribute("durationInYears")
		public BigDecimal getDurationInYears() {
			return durationInYears;
		}
		
		@Override
		public StandardizedSchedule build() {
			return this;
		}
		
		@Override
		public StandardizedSchedule.StandardizedScheduleBuilder toBuilder() {
			StandardizedSchedule.StandardizedScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StandardizedSchedule.StandardizedScheduleBuilder builder) {
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
			ofNullable(getProductClass()).ifPresent(builder::setProductClass);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getDurationInYears()).ifPresent(builder::setDurationInYears);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedSchedule _that = getType().cast(o);
		
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(productClass, _that.getProductClass())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(durationInYears, _that.getDurationInYears())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productClass != null ? productClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (durationInYears != null ? durationInYears.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedSchedule {" +
				"assetClass=" + this.assetClass + ", " +
				"productClass=" + this.productClass + ", " +
				"notional=" + this.notional + ", " +
				"notionalCurrency=" + this.notionalCurrency + ", " +
				"durationInYears=" + this.durationInYears +
			'}';
		}
	}

	/*********************** Builder Implementation of StandardizedSchedule  ***********************/
	class StandardizedScheduleBuilderImpl implements StandardizedSchedule.StandardizedScheduleBuilder {
	
		protected StandardizedScheduleAssetClassEnum assetClass;
		protected StandardizedScheduleProductClassEnum productClass;
		protected BigDecimal notional;
		protected String notionalCurrency;
		protected BigDecimal durationInYears;
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public StandardizedScheduleAssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("productClass")
		@RuneAttribute("productClass")
		public StandardizedScheduleProductClassEnum getProductClass() {
			return productClass;
		}
		
		@Override
		@RosettaAttribute("notional")
		@RuneAttribute("notional")
		public BigDecimal getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@RuneAttribute("notionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("durationInYears")
		@RuneAttribute("durationInYears")
		public BigDecimal getDurationInYears() {
			return durationInYears;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public StandardizedSchedule.StandardizedScheduleBuilder setAssetClass(StandardizedScheduleAssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("productClass")
		@RuneAttribute("productClass")
		public StandardizedSchedule.StandardizedScheduleBuilder setProductClass(StandardizedScheduleProductClassEnum _productClass) {
			this.productClass = _productClass == null ? null : _productClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("notional")
		@RuneAttribute("notional")
		public StandardizedSchedule.StandardizedScheduleBuilder setNotional(BigDecimal _notional) {
			this.notional = _notional == null ? null : _notional;
			return this;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency")
		@RuneAttribute("notionalCurrency")
		public StandardizedSchedule.StandardizedScheduleBuilder setNotionalCurrency(String _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@Override
		@RosettaAttribute("durationInYears")
		@RuneAttribute("durationInYears")
		public StandardizedSchedule.StandardizedScheduleBuilder setDurationInYears(BigDecimal _durationInYears) {
			this.durationInYears = _durationInYears == null ? null : _durationInYears;
			return this;
		}
		
		@Override
		public StandardizedSchedule build() {
			return new StandardizedSchedule.StandardizedScheduleImpl(this);
		}
		
		@Override
		public StandardizedSchedule.StandardizedScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedSchedule.StandardizedScheduleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetClass()!=null) return true;
			if (getProductClass()!=null) return true;
			if (getNotional()!=null) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getDurationInYears()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedSchedule.StandardizedScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StandardizedSchedule.StandardizedScheduleBuilder o = (StandardizedSchedule.StandardizedScheduleBuilder) other;
			
			
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			merger.mergeBasic(getProductClass(), o.getProductClass(), this::setProductClass);
			merger.mergeBasic(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getDurationInYears(), o.getDurationInYears(), this::setDurationInYears);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedSchedule _that = getType().cast(o);
		
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(productClass, _that.getProductClass())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(durationInYears, _that.getDurationInYears())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productClass != null ? productClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (durationInYears != null ? durationInYears.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedScheduleBuilder {" +
				"assetClass=" + this.assetClass + ", " +
				"productClass=" + this.productClass + ", " +
				"notional=" + this.notional + ", " +
				"notionalCurrency=" + this.notionalCurrency + ", " +
				"durationInYears=" + this.durationInYears +
			'}';
		}
	}
}
