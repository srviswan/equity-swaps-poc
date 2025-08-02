package cdm.product.asset;

import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.DividendCurrency;
import cdm.product.asset.DividendCurrency.DividendCurrencyBuilder;
import cdm.product.asset.DividendCurrency.DividendCurrencyBuilderImpl;
import cdm.product.asset.DividendCurrency.DividendCurrencyImpl;
import cdm.product.asset.meta.DividendCurrencyMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.ReferenceWithMetaString;
import com.rosetta.model.metafields.ReferenceWithMetaString.ReferenceWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
 * @version 6.0.0
 */
@RosettaDataType(value="DividendCurrency", builder=DividendCurrency.DividendCurrencyBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DividendCurrency", model="Just another Rosetta model", builder=DividendCurrency.DividendCurrencyBuilderImpl.class, version="6.0.0")
public interface DividendCurrency extends RosettaModelObject {

	DividendCurrencyMeta metaData = new DividendCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * Specifies the method according to which the dividend is determined, e.g. the dividend currency.
	 */
	DeterminationMethodEnum getDeterminationMethod();
	/**
	 * Reference to a currency specified elsewhere in the document
	 */
	ReferenceWithMetaString getCurrencyReference();

	/*********************** Build Methods  ***********************/
	DividendCurrency build();
	
	DividendCurrency.DividendCurrencyBuilder toBuilder();
	
	static DividendCurrency.DividendCurrencyBuilder builder() {
		return new DividendCurrency.DividendCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendCurrency> getType() {
		return DividendCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
		processRosetta(path.newSubPath("currencyReference"), processor, ReferenceWithMetaString.class, getCurrencyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendCurrencyBuilder extends DividendCurrency, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCurrency();
		ReferenceWithMetaString.ReferenceWithMetaStringBuilder getOrCreateCurrencyReference();
		@Override
		ReferenceWithMetaString.ReferenceWithMetaStringBuilder getCurrencyReference();
		DividendCurrency.DividendCurrencyBuilder setCurrency(FieldWithMetaString currency);
		DividendCurrency.DividendCurrencyBuilder setCurrencyValue(String currency);
		DividendCurrency.DividendCurrencyBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod);
		DividendCurrency.DividendCurrencyBuilder setCurrencyReference(ReferenceWithMetaString currencyReference);
		DividendCurrency.DividendCurrencyBuilder setCurrencyReferenceValue(String currencyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
			processRosetta(path.newSubPath("currencyReference"), processor, ReferenceWithMetaString.ReferenceWithMetaStringBuilder.class, getCurrencyReference());
		}
		

		DividendCurrency.DividendCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of DividendCurrency  ***********************/
	class DividendCurrencyImpl implements DividendCurrency {
		private final FieldWithMetaString currency;
		private final DeterminationMethodEnum determinationMethod;
		private final ReferenceWithMetaString currencyReference;
		
		protected DividendCurrencyImpl(DividendCurrency.DividendCurrencyBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.determinationMethod = builder.getDeterminationMethod();
			this.currencyReference = ofNullable(builder.getCurrencyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@RuneAttribute("determinationMethod")
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@RuneAttribute("currencyReference")
		public ReferenceWithMetaString getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public DividendCurrency build() {
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder toBuilder() {
			DividendCurrency.DividendCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendCurrency.DividendCurrencyBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getCurrencyReference()).ifPresent(builder::setCurrencyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendCurrency _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendCurrency {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendCurrency  ***********************/
	class DividendCurrencyBuilderImpl implements DividendCurrency.DividendCurrencyBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder currency;
		protected DeterminationMethodEnum determinationMethod;
		protected ReferenceWithMetaString.ReferenceWithMetaStringBuilder currencyReference;
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public FieldWithMetaString.FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@RuneAttribute("determinationMethod")
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@RuneAttribute("currencyReference")
		public ReferenceWithMetaString.ReferenceWithMetaStringBuilder getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public ReferenceWithMetaString.ReferenceWithMetaStringBuilder getOrCreateCurrencyReference() {
			ReferenceWithMetaString.ReferenceWithMetaStringBuilder result;
			if (currencyReference!=null) {
				result = currencyReference;
			}
			else {
				result = currencyReference = ReferenceWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public DividendCurrency.DividendCurrencyBuilder setCurrency(FieldWithMetaString _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrencyValue(String _currency) {
			this.getOrCreateCurrency().setValue(_currency);
			return this;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@RuneAttribute("determinationMethod")
		public DividendCurrency.DividendCurrencyBuilder setDeterminationMethod(DeterminationMethodEnum _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod;
			return this;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@RuneAttribute("currencyReference")
		public DividendCurrency.DividendCurrencyBuilder setCurrencyReference(ReferenceWithMetaString _currencyReference) {
			this.currencyReference = _currencyReference == null ? null : _currencyReference.toBuilder();
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrencyReferenceValue(String _currencyReference) {
			this.getOrCreateCurrencyReference().setValue(_currencyReference);
			return this;
		}
		
		@Override
		public DividendCurrency build() {
			return new DividendCurrency.DividendCurrencyImpl(this);
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendCurrency.DividendCurrencyBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (currencyReference!=null && !currencyReference.prune().hasData()) currencyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null) return true;
			if (getDeterminationMethod()!=null) return true;
			if (getCurrencyReference()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendCurrency.DividendCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendCurrency.DividendCurrencyBuilder o = (DividendCurrency.DividendCurrencyBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getCurrencyReference(), o.getCurrencyReference(), this::setCurrencyReference);
			
			merger.mergeBasic(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendCurrency _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendCurrencyBuilder {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference +
			'}';
		}
	}
}
