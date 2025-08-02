package cdm.observable.asset.fro;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.observable.asset.fro.FloatingRateIndexIdentification;
import cdm.observable.asset.fro.FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder;
import cdm.observable.asset.fro.FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilderImpl;
import cdm.observable.asset.fro.FloatingRateIndexIdentification.FloatingRateIndexIdentificationImpl;
import cdm.observable.asset.fro.meta.FloatingRateIndexIdentificationMeta;
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
@RosettaDataType(value="FloatingRateIndexIdentification", builder=FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRateIndexIdentification", model="Just another Rosetta model", builder=FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilderImpl.class, version="6.0.0")
public interface FloatingRateIndexIdentification extends RosettaModelObject {

	FloatingRateIndexIdentificationMeta metaData = new FloatingRateIndexIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference index that is used to specify the floating interest rate. The FpML standard maintains the list of such indices, which are positioned as enumeration values as part of the CDM.
	 */
	FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * FRO currency - 3 character ISO currrency code
	 */
	ISOCurrencyCodeEnum getCurrency();
	/**
	 * FRO type (e.g. OIS)
	 */
	String getFroType();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexIdentification build();
	
	FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder toBuilder();
	
	static FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder builder() {
		return new FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexIdentification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexIdentification> getType() {
		return FloatingRateIndexIdentification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.class, getFloatingRateIndex());
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("froType"), String.class, getFroType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexIdentificationBuilder extends FloatingRateIndexIdentification, RosettaModelObjectBuilder {
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex();
		@Override
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex();
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex);
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex);
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setCurrency(ISOCurrencyCodeEnum currency);
		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFroType(String froType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder.class, getFloatingRateIndex());
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("froType"), String.class, getFroType(), this);
		}
		

		FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexIdentification  ***********************/
	class FloatingRateIndexIdentificationImpl implements FloatingRateIndexIdentification {
		private final FieldWithMetaFloatingRateIndexEnum floatingRateIndex;
		private final ISOCurrencyCodeEnum currency;
		private final String froType;
		
		protected FloatingRateIndexIdentificationImpl(FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.currency = builder.getCurrency();
			this.froType = builder.getFroType();
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("froType")
		@RuneAttribute("froType")
		public String getFroType() {
			return froType;
		}
		
		@Override
		public FloatingRateIndexIdentification build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder toBuilder() {
			FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getFroType()).ifPresent(builder::setFroType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexIdentification _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(froType, _that.getFroType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (froType != null ? froType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexIdentification {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"currency=" + this.currency + ", " +
				"froType=" + this.froType +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexIdentification  ***********************/
	class FloatingRateIndexIdentificationBuilderImpl implements FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder {
	
		protected FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder floatingRateIndex;
		protected ISOCurrencyCodeEnum currency;
		protected String froType;
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("froType")
		@RuneAttribute("froType")
		public String getFroType() {
			return froType;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFloatingRateIndexValue(FloatingRateIndexEnum _floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(_floatingRateIndex);
			return this;
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@Override
		@RosettaAttribute("froType")
		@RuneAttribute("froType")
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder setFroType(String _froType) {
			this.froType = _froType == null ? null : _froType;
			return this;
		}
		
		@Override
		public FloatingRateIndexIdentification build() {
			return new FloatingRateIndexIdentification.FloatingRateIndexIdentificationImpl(this);
		}
		
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getFroType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder o = (FloatingRateIndexIdentification.FloatingRateIndexIdentificationBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getFroType(), o.getFroType(), this::setFroType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexIdentification _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(froType, _that.getFroType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (froType != null ? froType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexIdentificationBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"currency=" + this.currency + ", " +
				"froType=" + this.froType +
			'}';
		}
	}
}
