package cdm.margin.schedule;

import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.margin.schedule.StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder;
import cdm.margin.schedule.StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilderImpl;
import cdm.margin.schedule.StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoImpl;
import cdm.margin.schedule.meta.StandardizedScheduleTradeInfoMeta;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
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
 * @version 6.0.0
 */
@RosettaDataType(value="StandardizedScheduleTradeInfo", builder=StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilderImpl.class, version="6.0.0")
@RuneDataType(value="StandardizedScheduleTradeInfo", model="Just another Rosetta model", builder=StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilderImpl.class, version="6.0.0")
public interface StandardizedScheduleTradeInfo extends RosettaModelObject {

	StandardizedScheduleTradeInfoMeta metaData = new StandardizedScheduleTradeInfoMeta();

	/*********************** Getter Methods  ***********************/
	StandardizedScheduleAssetClassEnum getAssetClass();
	StandardizedScheduleProductClassEnum getProductClass();
	Money getGrossInitialMargin();
	Money getMarkToMarketValue();

	/*********************** Build Methods  ***********************/
	StandardizedScheduleTradeInfo build();
	
	StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder toBuilder();
	
	static StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder builder() {
		return new StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StandardizedScheduleTradeInfo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StandardizedScheduleTradeInfo> getType() {
		return StandardizedScheduleTradeInfo.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("assetClass"), StandardizedScheduleAssetClassEnum.class, getAssetClass(), this);
		processor.processBasic(path.newSubPath("productClass"), StandardizedScheduleProductClassEnum.class, getProductClass(), this);
		processRosetta(path.newSubPath("grossInitialMargin"), processor, Money.class, getGrossInitialMargin());
		processRosetta(path.newSubPath("markToMarketValue"), processor, Money.class, getMarkToMarketValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StandardizedScheduleTradeInfoBuilder extends StandardizedScheduleTradeInfo, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateGrossInitialMargin();
		@Override
		Money.MoneyBuilder getGrossInitialMargin();
		Money.MoneyBuilder getOrCreateMarkToMarketValue();
		@Override
		Money.MoneyBuilder getMarkToMarketValue();
		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setAssetClass(StandardizedScheduleAssetClassEnum assetClass);
		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setProductClass(StandardizedScheduleProductClassEnum productClass);
		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setGrossInitialMargin(Money grossInitialMargin);
		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setMarkToMarketValue(Money markToMarketValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("assetClass"), StandardizedScheduleAssetClassEnum.class, getAssetClass(), this);
			processor.processBasic(path.newSubPath("productClass"), StandardizedScheduleProductClassEnum.class, getProductClass(), this);
			processRosetta(path.newSubPath("grossInitialMargin"), processor, Money.MoneyBuilder.class, getGrossInitialMargin());
			processRosetta(path.newSubPath("markToMarketValue"), processor, Money.MoneyBuilder.class, getMarkToMarketValue());
		}
		

		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder prune();
	}

	/*********************** Immutable Implementation of StandardizedScheduleTradeInfo  ***********************/
	class StandardizedScheduleTradeInfoImpl implements StandardizedScheduleTradeInfo {
		private final StandardizedScheduleAssetClassEnum assetClass;
		private final StandardizedScheduleProductClassEnum productClass;
		private final Money grossInitialMargin;
		private final Money markToMarketValue;
		
		protected StandardizedScheduleTradeInfoImpl(StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder builder) {
			this.assetClass = builder.getAssetClass();
			this.productClass = builder.getProductClass();
			this.grossInitialMargin = ofNullable(builder.getGrossInitialMargin()).map(f->f.build()).orElse(null);
			this.markToMarketValue = ofNullable(builder.getMarkToMarketValue()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("grossInitialMargin")
		@RuneAttribute("grossInitialMargin")
		public Money getGrossInitialMargin() {
			return grossInitialMargin;
		}
		
		@Override
		@RosettaAttribute("markToMarketValue")
		@RuneAttribute("markToMarketValue")
		public Money getMarkToMarketValue() {
			return markToMarketValue;
		}
		
		@Override
		public StandardizedScheduleTradeInfo build() {
			return this;
		}
		
		@Override
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder toBuilder() {
			StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder builder) {
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
			ofNullable(getProductClass()).ifPresent(builder::setProductClass);
			ofNullable(getGrossInitialMargin()).ifPresent(builder::setGrossInitialMargin);
			ofNullable(getMarkToMarketValue()).ifPresent(builder::setMarkToMarketValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedScheduleTradeInfo _that = getType().cast(o);
		
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(productClass, _that.getProductClass())) return false;
			if (!Objects.equals(grossInitialMargin, _that.getGrossInitialMargin())) return false;
			if (!Objects.equals(markToMarketValue, _that.getMarkToMarketValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productClass != null ? productClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (grossInitialMargin != null ? grossInitialMargin.hashCode() : 0);
			_result = 31 * _result + (markToMarketValue != null ? markToMarketValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedScheduleTradeInfo {" +
				"assetClass=" + this.assetClass + ", " +
				"productClass=" + this.productClass + ", " +
				"grossInitialMargin=" + this.grossInitialMargin + ", " +
				"markToMarketValue=" + this.markToMarketValue +
			'}';
		}
	}

	/*********************** Builder Implementation of StandardizedScheduleTradeInfo  ***********************/
	class StandardizedScheduleTradeInfoBuilderImpl implements StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder {
	
		protected StandardizedScheduleAssetClassEnum assetClass;
		protected StandardizedScheduleProductClassEnum productClass;
		protected Money.MoneyBuilder grossInitialMargin;
		protected Money.MoneyBuilder markToMarketValue;
		
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
		@RosettaAttribute("grossInitialMargin")
		@RuneAttribute("grossInitialMargin")
		public Money.MoneyBuilder getGrossInitialMargin() {
			return grossInitialMargin;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateGrossInitialMargin() {
			Money.MoneyBuilder result;
			if (grossInitialMargin!=null) {
				result = grossInitialMargin;
			}
			else {
				result = grossInitialMargin = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("markToMarketValue")
		@RuneAttribute("markToMarketValue")
		public Money.MoneyBuilder getMarkToMarketValue() {
			return markToMarketValue;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMarkToMarketValue() {
			Money.MoneyBuilder result;
			if (markToMarketValue!=null) {
				result = markToMarketValue;
			}
			else {
				result = markToMarketValue = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setAssetClass(StandardizedScheduleAssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("productClass")
		@RuneAttribute("productClass")
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setProductClass(StandardizedScheduleProductClassEnum _productClass) {
			this.productClass = _productClass == null ? null : _productClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("grossInitialMargin")
		@RuneAttribute("grossInitialMargin")
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setGrossInitialMargin(Money _grossInitialMargin) {
			this.grossInitialMargin = _grossInitialMargin == null ? null : _grossInitialMargin.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("markToMarketValue")
		@RuneAttribute("markToMarketValue")
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder setMarkToMarketValue(Money _markToMarketValue) {
			this.markToMarketValue = _markToMarketValue == null ? null : _markToMarketValue.toBuilder();
			return this;
		}
		
		@Override
		public StandardizedScheduleTradeInfo build() {
			return new StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoImpl(this);
		}
		
		@Override
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder prune() {
			if (grossInitialMargin!=null && !grossInitialMargin.prune().hasData()) grossInitialMargin = null;
			if (markToMarketValue!=null && !markToMarketValue.prune().hasData()) markToMarketValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetClass()!=null) return true;
			if (getProductClass()!=null) return true;
			if (getGrossInitialMargin()!=null && getGrossInitialMargin().hasData()) return true;
			if (getMarkToMarketValue()!=null && getMarkToMarketValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder o = (StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder) other;
			
			merger.mergeRosetta(getGrossInitialMargin(), o.getGrossInitialMargin(), this::setGrossInitialMargin);
			merger.mergeRosetta(getMarkToMarketValue(), o.getMarkToMarketValue(), this::setMarkToMarketValue);
			
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			merger.mergeBasic(getProductClass(), o.getProductClass(), this::setProductClass);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedScheduleTradeInfo _that = getType().cast(o);
		
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(productClass, _that.getProductClass())) return false;
			if (!Objects.equals(grossInitialMargin, _that.getGrossInitialMargin())) return false;
			if (!Objects.equals(markToMarketValue, _that.getMarkToMarketValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productClass != null ? productClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (grossInitialMargin != null ? grossInitialMargin.hashCode() : 0);
			_result = 31 * _result + (markToMarketValue != null ? markToMarketValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedScheduleTradeInfoBuilder {" +
				"assetClass=" + this.assetClass + ", " +
				"productClass=" + this.productClass + ", " +
				"grossInitialMargin=" + this.grossInitialMargin + ", " +
				"markToMarketValue=" + this.markToMarketValue +
			'}';
		}
	}
}
