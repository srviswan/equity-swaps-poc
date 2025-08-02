package cdm.product.asset;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
import cdm.product.asset.FPVFinalPriceElectionFallbackEnum;
import cdm.product.asset.ValuationTerms;
import cdm.product.asset.ValuationTerms.ValuationTermsBuilder;
import cdm.product.asset.ValuationTerms.ValuationTermsBuilderImpl;
import cdm.product.asset.ValuationTerms.ValuationTermsImpl;
import cdm.product.asset.meta.ValuationTermsMeta;
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
@RosettaDataType(value="ValuationTerms", builder=ValuationTerms.ValuationTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ValuationTerms", model="Just another Rosetta model", builder=ValuationTerms.ValuationTermsBuilderImpl.class, version="6.0.0")
public interface ValuationTerms extends RosettaModelObject {

	ValuationTermsMeta metaData = new ValuationTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 */
	Boolean getFuturesPriceValuation();
	/**
	 * The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions
	 */
	Boolean getOptionsPriceValuation();
	/**
	 * The number of valuation dates between valuation start date and valuation end date.
	 */
	Integer getNumberOfValuationDates();
	/**
	 * Specifies the dividend valuation dates of the swap.
	 */
	AdjustableRelativeOrPeriodicDates getDividendValuationDates();
	/**
	 * Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
	 */
	FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback();
	/**
	 * For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 */
	Boolean getMultipleExchangeIndexAnnexFallback();
	/**
	 * For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 */
	Boolean getComponentSecurityIndexAnnexFallback();

	/*********************** Build Methods  ***********************/
	ValuationTerms build();
	
	ValuationTerms.ValuationTermsBuilder toBuilder();
	
	static ValuationTerms.ValuationTermsBuilder builder() {
		return new ValuationTerms.ValuationTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationTerms> getType() {
		return ValuationTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
		processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
		processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
		processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getDividendValuationDates());
		processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationTermsBuilder extends ValuationTerms, RosettaModelObjectBuilder {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates();
		ValuationTerms.ValuationTermsBuilder setFuturesPriceValuation(Boolean futuresPriceValuation);
		ValuationTerms.ValuationTermsBuilder setOptionsPriceValuation(Boolean optionsPriceValuation);
		ValuationTerms.ValuationTermsBuilder setNumberOfValuationDates(Integer numberOfValuationDates);
		ValuationTerms.ValuationTermsBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates dividendValuationDates);
		ValuationTerms.ValuationTermsBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback);
		ValuationTerms.ValuationTermsBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		ValuationTerms.ValuationTermsBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
			processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
			processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
			processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getDividendValuationDates());
			processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		}
		

		ValuationTerms.ValuationTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationTerms  ***********************/
	class ValuationTermsImpl implements ValuationTerms {
		private final Boolean futuresPriceValuation;
		private final Boolean optionsPriceValuation;
		private final Integer numberOfValuationDates;
		private final AdjustableRelativeOrPeriodicDates dividendValuationDates;
		private final FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		
		protected ValuationTermsImpl(ValuationTerms.ValuationTermsBuilder builder) {
			this.futuresPriceValuation = builder.getFuturesPriceValuation();
			this.optionsPriceValuation = builder.getOptionsPriceValuation();
			this.numberOfValuationDates = builder.getNumberOfValuationDates();
			this.dividendValuationDates = ofNullable(builder.getDividendValuationDates()).map(f->f.build()).orElse(null);
			this.fPVFinalPriceElectionFallback = builder.getFPVFinalPriceElectionFallback();
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		@RuneAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		@RuneAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		@RuneAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		@RuneAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@RuneAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		public ValuationTerms build() {
			return this;
		}
		
		@Override
		public ValuationTerms.ValuationTermsBuilder toBuilder() {
			ValuationTerms.ValuationTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationTerms.ValuationTermsBuilder builder) {
			ofNullable(getFuturesPriceValuation()).ifPresent(builder::setFuturesPriceValuation);
			ofNullable(getOptionsPriceValuation()).ifPresent(builder::setOptionsPriceValuation);
			ofNullable(getNumberOfValuationDates()).ifPresent(builder::setNumberOfValuationDates);
			ofNullable(getDividendValuationDates()).ifPresent(builder::setDividendValuationDates);
			ofNullable(getFPVFinalPriceElectionFallback()).ifPresent(builder::setFPVFinalPriceElectionFallback);
			ofNullable(getMultipleExchangeIndexAnnexFallback()).ifPresent(builder::setMultipleExchangeIndexAnnexFallback);
			ofNullable(getComponentSecurityIndexAnnexFallback()).ifPresent(builder::setComponentSecurityIndexAnnexFallback);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationTerms _that = getType().cast(o);
		
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationTerms {" +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationTerms  ***********************/
	class ValuationTermsBuilderImpl implements ValuationTerms.ValuationTermsBuilder {
	
		protected Boolean futuresPriceValuation;
		protected Boolean optionsPriceValuation;
		protected Integer numberOfValuationDates;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder dividendValuationDates;
		protected FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		@RuneAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		@RuneAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		@RuneAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		@RuneAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (dividendValuationDates!=null) {
				result = dividendValuationDates;
			}
			else {
				result = dividendValuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@RuneAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		@RuneAttribute("futuresPriceValuation")
		public ValuationTerms.ValuationTermsBuilder setFuturesPriceValuation(Boolean _futuresPriceValuation) {
			this.futuresPriceValuation = _futuresPriceValuation == null ? null : _futuresPriceValuation;
			return this;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		@RuneAttribute("optionsPriceValuation")
		public ValuationTerms.ValuationTermsBuilder setOptionsPriceValuation(Boolean _optionsPriceValuation) {
			this.optionsPriceValuation = _optionsPriceValuation == null ? null : _optionsPriceValuation;
			return this;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		@RuneAttribute("numberOfValuationDates")
		public ValuationTerms.ValuationTermsBuilder setNumberOfValuationDates(Integer _numberOfValuationDates) {
			this.numberOfValuationDates = _numberOfValuationDates == null ? null : _numberOfValuationDates;
			return this;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		@RuneAttribute("dividendValuationDates")
		public ValuationTerms.ValuationTermsBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates _dividendValuationDates) {
			this.dividendValuationDates = _dividendValuationDates == null ? null : _dividendValuationDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@RuneAttribute("fPVFinalPriceElectionFallback")
		public ValuationTerms.ValuationTermsBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum _fPVFinalPriceElectionFallback) {
			this.fPVFinalPriceElectionFallback = _fPVFinalPriceElectionFallback == null ? null : _fPVFinalPriceElectionFallback;
			return this;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public ValuationTerms.ValuationTermsBuilder setMultipleExchangeIndexAnnexFallback(Boolean _multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = _multipleExchangeIndexAnnexFallback == null ? null : _multipleExchangeIndexAnnexFallback;
			return this;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public ValuationTerms.ValuationTermsBuilder setComponentSecurityIndexAnnexFallback(Boolean _componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = _componentSecurityIndexAnnexFallback == null ? null : _componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@Override
		public ValuationTerms build() {
			return new ValuationTerms.ValuationTermsImpl(this);
		}
		
		@Override
		public ValuationTerms.ValuationTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationTerms.ValuationTermsBuilder prune() {
			if (dividendValuationDates!=null && !dividendValuationDates.prune().hasData()) dividendValuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFuturesPriceValuation()!=null) return true;
			if (getOptionsPriceValuation()!=null) return true;
			if (getNumberOfValuationDates()!=null) return true;
			if (getDividendValuationDates()!=null && getDividendValuationDates().hasData()) return true;
			if (getFPVFinalPriceElectionFallback()!=null) return true;
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationTerms.ValuationTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationTerms.ValuationTermsBuilder o = (ValuationTerms.ValuationTermsBuilder) other;
			
			merger.mergeRosetta(getDividendValuationDates(), o.getDividendValuationDates(), this::setDividendValuationDates);
			
			merger.mergeBasic(getFuturesPriceValuation(), o.getFuturesPriceValuation(), this::setFuturesPriceValuation);
			merger.mergeBasic(getOptionsPriceValuation(), o.getOptionsPriceValuation(), this::setOptionsPriceValuation);
			merger.mergeBasic(getNumberOfValuationDates(), o.getNumberOfValuationDates(), this::setNumberOfValuationDates);
			merger.mergeBasic(getFPVFinalPriceElectionFallback(), o.getFPVFinalPriceElectionFallback(), this::setFPVFinalPriceElectionFallback);
			merger.mergeBasic(getMultipleExchangeIndexAnnexFallback(), o.getMultipleExchangeIndexAnnexFallback(), this::setMultipleExchangeIndexAnnexFallback);
			merger.mergeBasic(getComponentSecurityIndexAnnexFallback(), o.getComponentSecurityIndexAnnexFallback(), this::setComponentSecurityIndexAnnexFallback);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationTerms _that = getType().cast(o);
		
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationTermsBuilder {" +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback +
			'}';
		}
	}
}
