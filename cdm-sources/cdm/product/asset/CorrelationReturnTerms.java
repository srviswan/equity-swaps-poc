package cdm.product.asset;

import cdm.base.math.NumberRange;
import cdm.base.math.NumberRange.NumberRangeBuilder;
import cdm.observable.asset.DividendApplicability;
import cdm.observable.asset.DividendApplicability.DividendApplicabilityBuilder;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.CorrelationReturnTerms;
import cdm.product.asset.CorrelationReturnTerms.CorrelationReturnTermsBuilder;
import cdm.product.asset.CorrelationReturnTerms.CorrelationReturnTermsBuilderImpl;
import cdm.product.asset.CorrelationReturnTerms.CorrelationReturnTermsImpl;
import cdm.product.asset.EquityUnderlierProvisions;
import cdm.product.asset.EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder;
import cdm.product.asset.ReturnTermsBase;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseBuilder;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseBuilderImpl;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseImpl;
import cdm.product.asset.ValuationTerms;
import cdm.product.asset.ValuationTerms.ValuationTermsBuilder;
import cdm.product.asset.meta.CorrelationReturnTermsMeta;
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
@RosettaDataType(value="CorrelationReturnTerms", builder=CorrelationReturnTerms.CorrelationReturnTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CorrelationReturnTerms", model="Just another Rosetta model", builder=CorrelationReturnTerms.CorrelationReturnTermsBuilderImpl.class, version="6.0.0")
public interface CorrelationReturnTerms extends ReturnTermsBase {

	CorrelationReturnTermsMeta metaData = new CorrelationReturnTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Correlation Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	Price getCorrelationStrikePrice();
	/**
	 * Describes correlation bounds, which form a cap and a floor on the realized correlation.
	 */
	NumberRange getBoundedCorrelation();
	/**
	 * Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
	 */
	Integer getNumberOfDataSeries();

	/*********************** Build Methods  ***********************/
	CorrelationReturnTerms build();
	
	CorrelationReturnTerms.CorrelationReturnTermsBuilder toBuilder();
	
	static CorrelationReturnTerms.CorrelationReturnTermsBuilder builder() {
		return new CorrelationReturnTerms.CorrelationReturnTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationReturnTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrelationReturnTerms> getType() {
		return CorrelationReturnTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationTerms"), processor, ValuationTerms.class, getValuationTerms());
		processor.processBasic(path.newSubPath("annualizationFactor"), Integer.class, getAnnualizationFactor(), this);
		processRosetta(path.newSubPath("dividendApplicability"), processor, DividendApplicability.class, getDividendApplicability());
		processRosetta(path.newSubPath("equityUnderlierProvisions"), processor, EquityUnderlierProvisions.class, getEquityUnderlierProvisions());
		processor.processBasic(path.newSubPath("sharePriceDividendAdjustment"), Boolean.class, getSharePriceDividendAdjustment(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processor.processBasic(path.newSubPath("initialLevelSource"), DeterminationMethodEnum.class, getInitialLevelSource(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
		processRosetta(path.newSubPath("correlationStrikePrice"), processor, Price.class, getCorrelationStrikePrice());
		processRosetta(path.newSubPath("boundedCorrelation"), processor, NumberRange.class, getBoundedCorrelation());
		processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationReturnTermsBuilder extends CorrelationReturnTerms, ReturnTermsBase.ReturnTermsBaseBuilder {
		Price.PriceBuilder getOrCreateCorrelationStrikePrice();
		@Override
		Price.PriceBuilder getCorrelationStrikePrice();
		NumberRange.NumberRangeBuilder getOrCreateBoundedCorrelation();
		@Override
		NumberRange.NumberRangeBuilder getBoundedCorrelation();
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setValuationTerms(ValuationTerms valuationTerms);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setAnnualizationFactor(Integer annualizationFactor);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setDividendApplicability(DividendApplicability dividendApplicability);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions equityUnderlierProvisions);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setSharePriceDividendAdjustment(Boolean sharePriceDividendAdjustment);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setExpectedN(Integer expectedN);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setInitialLevel(BigDecimal initialLevel);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setInitialLevelSource(DeterminationMethodEnum initialLevelSource);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setMeanAdjustment(Boolean meanAdjustment);
		@Override
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setPerformance(String performance);
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setCorrelationStrikePrice(Price correlationStrikePrice);
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setBoundedCorrelation(NumberRange boundedCorrelation);
		CorrelationReturnTerms.CorrelationReturnTermsBuilder setNumberOfDataSeries(Integer numberOfDataSeries);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationTerms"), processor, ValuationTerms.ValuationTermsBuilder.class, getValuationTerms());
			processor.processBasic(path.newSubPath("annualizationFactor"), Integer.class, getAnnualizationFactor(), this);
			processRosetta(path.newSubPath("dividendApplicability"), processor, DividendApplicability.DividendApplicabilityBuilder.class, getDividendApplicability());
			processRosetta(path.newSubPath("equityUnderlierProvisions"), processor, EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder.class, getEquityUnderlierProvisions());
			processor.processBasic(path.newSubPath("sharePriceDividendAdjustment"), Boolean.class, getSharePriceDividendAdjustment(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processor.processBasic(path.newSubPath("initialLevelSource"), DeterminationMethodEnum.class, getInitialLevelSource(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
			processRosetta(path.newSubPath("correlationStrikePrice"), processor, Price.PriceBuilder.class, getCorrelationStrikePrice());
			processRosetta(path.newSubPath("boundedCorrelation"), processor, NumberRange.NumberRangeBuilder.class, getBoundedCorrelation());
			processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
		}
		

		CorrelationReturnTerms.CorrelationReturnTermsBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationReturnTerms  ***********************/
	class CorrelationReturnTermsImpl extends ReturnTermsBase.ReturnTermsBaseImpl implements CorrelationReturnTerms {
		private final Price correlationStrikePrice;
		private final NumberRange boundedCorrelation;
		private final Integer numberOfDataSeries;
		
		protected CorrelationReturnTermsImpl(CorrelationReturnTerms.CorrelationReturnTermsBuilder builder) {
			super(builder);
			this.correlationStrikePrice = ofNullable(builder.getCorrelationStrikePrice()).map(f->f.build()).orElse(null);
			this.boundedCorrelation = ofNullable(builder.getBoundedCorrelation()).map(f->f.build()).orElse(null);
			this.numberOfDataSeries = builder.getNumberOfDataSeries();
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		@RuneAttribute("correlationStrikePrice")
		public Price getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		@RuneAttribute("boundedCorrelation")
		public NumberRange getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		@RuneAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@Override
		public CorrelationReturnTerms build() {
			return this;
		}
		
		@Override
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder toBuilder() {
			CorrelationReturnTerms.CorrelationReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationReturnTerms.CorrelationReturnTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelationStrikePrice()).ifPresent(builder::setCorrelationStrikePrice);
			ofNullable(getBoundedCorrelation()).ifPresent(builder::setBoundedCorrelation);
			ofNullable(getNumberOfDataSeries()).ifPresent(builder::setNumberOfDataSeries);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationReturnTerms {" +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationReturnTerms  ***********************/
	class CorrelationReturnTermsBuilderImpl extends ReturnTermsBase.ReturnTermsBaseBuilderImpl implements CorrelationReturnTerms.CorrelationReturnTermsBuilder {
	
		protected Price.PriceBuilder correlationStrikePrice;
		protected NumberRange.NumberRangeBuilder boundedCorrelation;
		protected Integer numberOfDataSeries;
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		@RuneAttribute("correlationStrikePrice")
		public Price.PriceBuilder getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateCorrelationStrikePrice() {
			Price.PriceBuilder result;
			if (correlationStrikePrice!=null) {
				result = correlationStrikePrice;
			}
			else {
				result = correlationStrikePrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		@RuneAttribute("boundedCorrelation")
		public NumberRange.NumberRangeBuilder getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		public NumberRange.NumberRangeBuilder getOrCreateBoundedCorrelation() {
			NumberRange.NumberRangeBuilder result;
			if (boundedCorrelation!=null) {
				result = boundedCorrelation;
			}
			else {
				result = boundedCorrelation = NumberRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		@RuneAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@Override
		@RosettaAttribute("valuationTerms")
		@RuneAttribute("valuationTerms")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setValuationTerms(ValuationTerms _valuationTerms) {
			this.valuationTerms = _valuationTerms == null ? null : _valuationTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@RuneAttribute("annualizationFactor")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setAnnualizationFactor(Integer _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@Override
		@RosettaAttribute("dividendApplicability")
		@RuneAttribute("dividendApplicability")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setDividendApplicability(DividendApplicability _dividendApplicability) {
			this.dividendApplicability = _dividendApplicability == null ? null : _dividendApplicability.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("equityUnderlierProvisions")
		@RuneAttribute("equityUnderlierProvisions")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions _equityUnderlierProvisions) {
			this.equityUnderlierProvisions = _equityUnderlierProvisions == null ? null : _equityUnderlierProvisions.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("sharePriceDividendAdjustment")
		@RuneAttribute("sharePriceDividendAdjustment")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setSharePriceDividendAdjustment(Boolean _sharePriceDividendAdjustment) {
			this.sharePriceDividendAdjustment = _sharePriceDividendAdjustment == null ? null : _sharePriceDividendAdjustment;
			return this;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@RuneAttribute("expectedN")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		@RuneAttribute("initialLevel")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@RuneAttribute("initialLevelSource")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setInitialLevelSource(DeterminationMethodEnum _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource;
			return this;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@RuneAttribute("meanAdjustment")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setMeanAdjustment(Boolean _meanAdjustment) {
			this.meanAdjustment = _meanAdjustment == null ? null : _meanAdjustment;
			return this;
		}
		
		@Override
		@RosettaAttribute("performance")
		@RuneAttribute("performance")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setPerformance(String _performance) {
			this.performance = _performance == null ? null : _performance;
			return this;
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		@RuneAttribute("correlationStrikePrice")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setCorrelationStrikePrice(Price _correlationStrikePrice) {
			this.correlationStrikePrice = _correlationStrikePrice == null ? null : _correlationStrikePrice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		@RuneAttribute("boundedCorrelation")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setBoundedCorrelation(NumberRange _boundedCorrelation) {
			this.boundedCorrelation = _boundedCorrelation == null ? null : _boundedCorrelation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		@RuneAttribute("numberOfDataSeries")
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder setNumberOfDataSeries(Integer _numberOfDataSeries) {
			this.numberOfDataSeries = _numberOfDataSeries == null ? null : _numberOfDataSeries;
			return this;
		}
		
		@Override
		public CorrelationReturnTerms build() {
			return new CorrelationReturnTerms.CorrelationReturnTermsImpl(this);
		}
		
		@Override
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder prune() {
			super.prune();
			if (correlationStrikePrice!=null && !correlationStrikePrice.prune().hasData()) correlationStrikePrice = null;
			if (boundedCorrelation!=null && !boundedCorrelation.prune().hasData()) boundedCorrelation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelationStrikePrice()!=null && getCorrelationStrikePrice().hasData()) return true;
			if (getBoundedCorrelation()!=null && getBoundedCorrelation().hasData()) return true;
			if (getNumberOfDataSeries()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationReturnTerms.CorrelationReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorrelationReturnTerms.CorrelationReturnTermsBuilder o = (CorrelationReturnTerms.CorrelationReturnTermsBuilder) other;
			
			merger.mergeRosetta(getCorrelationStrikePrice(), o.getCorrelationStrikePrice(), this::setCorrelationStrikePrice);
			merger.mergeRosetta(getBoundedCorrelation(), o.getBoundedCorrelation(), this::setBoundedCorrelation);
			
			merger.mergeBasic(getNumberOfDataSeries(), o.getNumberOfDataSeries(), this::setNumberOfDataSeries);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationReturnTermsBuilder {" +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}
}
