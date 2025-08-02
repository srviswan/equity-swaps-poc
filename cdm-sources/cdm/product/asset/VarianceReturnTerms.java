package cdm.product.asset;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import cdm.observable.asset.DividendApplicability;
import cdm.observable.asset.DividendApplicability.DividendApplicabilityBuilder;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.EquityUnderlierProvisions;
import cdm.product.asset.EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder;
import cdm.product.asset.ReturnTermsBase;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseBuilder;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseBuilderImpl;
import cdm.product.asset.ReturnTermsBase.ReturnTermsBaseImpl;
import cdm.product.asset.ValuationTerms;
import cdm.product.asset.ValuationTerms.ValuationTermsBuilder;
import cdm.product.asset.VarianceCapFloor;
import cdm.product.asset.VarianceCapFloor.VarianceCapFloorBuilder;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.VarianceReturnTerms.VarianceReturnTermsBuilder;
import cdm.product.asset.VarianceReturnTerms.VarianceReturnTermsBuilderImpl;
import cdm.product.asset.VarianceReturnTerms.VarianceReturnTermsImpl;
import cdm.product.asset.VolatilityCapFloor;
import cdm.product.asset.VolatilityCapFloor.VolatilityCapFloorBuilder;
import cdm.product.asset.meta.VarianceReturnTermsMeta;
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
@RosettaDataType(value="VarianceReturnTerms", builder=VarianceReturnTerms.VarianceReturnTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="VarianceReturnTerms", model="Just another Rosetta model", builder=VarianceReturnTerms.VarianceReturnTermsBuilderImpl.class, version="6.0.0")
public interface VarianceReturnTerms extends ReturnTermsBase {

	VarianceReturnTermsMeta metaData = new VarianceReturnTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Variance Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	Price getVarianceStrikePrice();
	/**
	 * Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 */
	Price getVolatilityStrikePrice();
	/**
	 * Contains possible barriers for variance products, both variance-based and underlier price based
	 */
	VarianceCapFloor getVarianceCapFloor();
	/**
	 * Contains containing volatility-based barriers
	 */
	VolatilityCapFloor getVolatilityCapFloor();
	/**
	 * Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
	 */
	NonNegativeQuantitySchedule getVegaNotionalAmount();
	/**
	 * Specification of the exchange traded contract nearest.
	 */
	ReferenceWithMetaObservable getExchangeTradedContractNearest();

	/*********************** Build Methods  ***********************/
	VarianceReturnTerms build();
	
	VarianceReturnTerms.VarianceReturnTermsBuilder toBuilder();
	
	static VarianceReturnTerms.VarianceReturnTermsBuilder builder() {
		return new VarianceReturnTerms.VarianceReturnTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceReturnTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VarianceReturnTerms> getType() {
		return VarianceReturnTerms.class;
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
		processRosetta(path.newSubPath("varianceStrikePrice"), processor, Price.class, getVarianceStrikePrice());
		processRosetta(path.newSubPath("volatilityStrikePrice"), processor, Price.class, getVolatilityStrikePrice());
		processRosetta(path.newSubPath("varianceCapFloor"), processor, VarianceCapFloor.class, getVarianceCapFloor());
		processRosetta(path.newSubPath("volatilityCapFloor"), processor, VolatilityCapFloor.class, getVolatilityCapFloor());
		processRosetta(path.newSubPath("vegaNotionalAmount"), processor, NonNegativeQuantitySchedule.class, getVegaNotionalAmount());
		processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ReferenceWithMetaObservable.class, getExchangeTradedContractNearest());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceReturnTermsBuilder extends VarianceReturnTerms, ReturnTermsBase.ReturnTermsBaseBuilder {
		Price.PriceBuilder getOrCreateVarianceStrikePrice();
		@Override
		Price.PriceBuilder getVarianceStrikePrice();
		Price.PriceBuilder getOrCreateVolatilityStrikePrice();
		@Override
		Price.PriceBuilder getVolatilityStrikePrice();
		VarianceCapFloor.VarianceCapFloorBuilder getOrCreateVarianceCapFloor();
		@Override
		VarianceCapFloor.VarianceCapFloorBuilder getVarianceCapFloor();
		VolatilityCapFloor.VolatilityCapFloorBuilder getOrCreateVolatilityCapFloor();
		@Override
		VolatilityCapFloor.VolatilityCapFloorBuilder getVolatilityCapFloor();
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getOrCreateVegaNotionalAmount();
		@Override
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getVegaNotionalAmount();
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateExchangeTradedContractNearest();
		@Override
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getExchangeTradedContractNearest();
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setValuationTerms(ValuationTerms valuationTerms);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setAnnualizationFactor(Integer annualizationFactor);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setDividendApplicability(DividendApplicability dividendApplicability);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions equityUnderlierProvisions);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setSharePriceDividendAdjustment(Boolean sharePriceDividendAdjustment);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setExpectedN(Integer expectedN);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setInitialLevel(BigDecimal initialLevel);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setInitialLevelSource(DeterminationMethodEnum initialLevelSource);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setMeanAdjustment(Boolean meanAdjustment);
		@Override
		VarianceReturnTerms.VarianceReturnTermsBuilder setPerformance(String performance);
		VarianceReturnTerms.VarianceReturnTermsBuilder setVarianceStrikePrice(Price varianceStrikePrice);
		VarianceReturnTerms.VarianceReturnTermsBuilder setVolatilityStrikePrice(Price volatilityStrikePrice);
		VarianceReturnTerms.VarianceReturnTermsBuilder setVarianceCapFloor(VarianceCapFloor varianceCapFloor);
		VarianceReturnTerms.VarianceReturnTermsBuilder setVolatilityCapFloor(VolatilityCapFloor volatilityCapFloor);
		VarianceReturnTerms.VarianceReturnTermsBuilder setVegaNotionalAmount(NonNegativeQuantitySchedule vegaNotionalAmount);
		VarianceReturnTerms.VarianceReturnTermsBuilder setExchangeTradedContractNearest(ReferenceWithMetaObservable exchangeTradedContractNearest);
		VarianceReturnTerms.VarianceReturnTermsBuilder setExchangeTradedContractNearestValue(Observable exchangeTradedContractNearest);

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
			processRosetta(path.newSubPath("varianceStrikePrice"), processor, Price.PriceBuilder.class, getVarianceStrikePrice());
			processRosetta(path.newSubPath("volatilityStrikePrice"), processor, Price.PriceBuilder.class, getVolatilityStrikePrice());
			processRosetta(path.newSubPath("varianceCapFloor"), processor, VarianceCapFloor.VarianceCapFloorBuilder.class, getVarianceCapFloor());
			processRosetta(path.newSubPath("volatilityCapFloor"), processor, VolatilityCapFloor.VolatilityCapFloorBuilder.class, getVolatilityCapFloor());
			processRosetta(path.newSubPath("vegaNotionalAmount"), processor, NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder.class, getVegaNotionalAmount());
			processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder.class, getExchangeTradedContractNearest());
		}
		

		VarianceReturnTerms.VarianceReturnTermsBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceReturnTerms  ***********************/
	class VarianceReturnTermsImpl extends ReturnTermsBase.ReturnTermsBaseImpl implements VarianceReturnTerms {
		private final Price varianceStrikePrice;
		private final Price volatilityStrikePrice;
		private final VarianceCapFloor varianceCapFloor;
		private final VolatilityCapFloor volatilityCapFloor;
		private final NonNegativeQuantitySchedule vegaNotionalAmount;
		private final ReferenceWithMetaObservable exchangeTradedContractNearest;
		
		protected VarianceReturnTermsImpl(VarianceReturnTerms.VarianceReturnTermsBuilder builder) {
			super(builder);
			this.varianceStrikePrice = ofNullable(builder.getVarianceStrikePrice()).map(f->f.build()).orElse(null);
			this.volatilityStrikePrice = ofNullable(builder.getVolatilityStrikePrice()).map(f->f.build()).orElse(null);
			this.varianceCapFloor = ofNullable(builder.getVarianceCapFloor()).map(f->f.build()).orElse(null);
			this.volatilityCapFloor = ofNullable(builder.getVolatilityCapFloor()).map(f->f.build()).orElse(null);
			this.vegaNotionalAmount = ofNullable(builder.getVegaNotionalAmount()).map(f->f.build()).orElse(null);
			this.exchangeTradedContractNearest = ofNullable(builder.getExchangeTradedContractNearest()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		@RuneAttribute("varianceStrikePrice")
		public Price getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		@RuneAttribute("volatilityStrikePrice")
		public Price getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCapFloor")
		@RuneAttribute("varianceCapFloor")
		public VarianceCapFloor getVarianceCapFloor() {
			return varianceCapFloor;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFloor")
		@RuneAttribute("volatilityCapFloor")
		public VolatilityCapFloor getVolatilityCapFloor() {
			return volatilityCapFloor;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		@RuneAttribute("vegaNotionalAmount")
		public NonNegativeQuantitySchedule getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@RuneAttribute("exchangeTradedContractNearest")
		public ReferenceWithMetaObservable getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public VarianceReturnTerms build() {
			return this;
		}
		
		@Override
		public VarianceReturnTerms.VarianceReturnTermsBuilder toBuilder() {
			VarianceReturnTerms.VarianceReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceReturnTerms.VarianceReturnTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceStrikePrice()).ifPresent(builder::setVarianceStrikePrice);
			ofNullable(getVolatilityStrikePrice()).ifPresent(builder::setVolatilityStrikePrice);
			ofNullable(getVarianceCapFloor()).ifPresent(builder::setVarianceCapFloor);
			ofNullable(getVolatilityCapFloor()).ifPresent(builder::setVolatilityCapFloor);
			ofNullable(getVegaNotionalAmount()).ifPresent(builder::setVegaNotionalAmount);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceCapFloor, _that.getVarianceCapFloor())) return false;
			if (!Objects.equals(volatilityCapFloor, _that.getVolatilityCapFloor())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCapFloor != null ? varianceCapFloor.hashCode() : 0);
			_result = 31 * _result + (volatilityCapFloor != null ? volatilityCapFloor.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceReturnTerms {" +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceCapFloor=" + this.varianceCapFloor + ", " +
				"volatilityCapFloor=" + this.volatilityCapFloor + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceReturnTerms  ***********************/
	class VarianceReturnTermsBuilderImpl extends ReturnTermsBase.ReturnTermsBaseBuilderImpl implements VarianceReturnTerms.VarianceReturnTermsBuilder {
	
		protected Price.PriceBuilder varianceStrikePrice;
		protected Price.PriceBuilder volatilityStrikePrice;
		protected VarianceCapFloor.VarianceCapFloorBuilder varianceCapFloor;
		protected VolatilityCapFloor.VolatilityCapFloorBuilder volatilityCapFloor;
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder vegaNotionalAmount;
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder exchangeTradedContractNearest;
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		@RuneAttribute("varianceStrikePrice")
		public Price.PriceBuilder getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateVarianceStrikePrice() {
			Price.PriceBuilder result;
			if (varianceStrikePrice!=null) {
				result = varianceStrikePrice;
			}
			else {
				result = varianceStrikePrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		@RuneAttribute("volatilityStrikePrice")
		public Price.PriceBuilder getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateVolatilityStrikePrice() {
			Price.PriceBuilder result;
			if (volatilityStrikePrice!=null) {
				result = volatilityStrikePrice;
			}
			else {
				result = volatilityStrikePrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("varianceCapFloor")
		@RuneAttribute("varianceCapFloor")
		public VarianceCapFloor.VarianceCapFloorBuilder getVarianceCapFloor() {
			return varianceCapFloor;
		}
		
		@Override
		public VarianceCapFloor.VarianceCapFloorBuilder getOrCreateVarianceCapFloor() {
			VarianceCapFloor.VarianceCapFloorBuilder result;
			if (varianceCapFloor!=null) {
				result = varianceCapFloor;
			}
			else {
				result = varianceCapFloor = VarianceCapFloor.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFloor")
		@RuneAttribute("volatilityCapFloor")
		public VolatilityCapFloor.VolatilityCapFloorBuilder getVolatilityCapFloor() {
			return volatilityCapFloor;
		}
		
		@Override
		public VolatilityCapFloor.VolatilityCapFloorBuilder getOrCreateVolatilityCapFloor() {
			VolatilityCapFloor.VolatilityCapFloorBuilder result;
			if (volatilityCapFloor!=null) {
				result = volatilityCapFloor;
			}
			else {
				result = volatilityCapFloor = VolatilityCapFloor.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		@RuneAttribute("vegaNotionalAmount")
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder getOrCreateVegaNotionalAmount() {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result;
			if (vegaNotionalAmount!=null) {
				result = vegaNotionalAmount;
			}
			else {
				result = vegaNotionalAmount = NonNegativeQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@RuneAttribute("exchangeTradedContractNearest")
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder getOrCreateExchangeTradedContractNearest() {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder result;
			if (exchangeTradedContractNearest!=null) {
				result = exchangeTradedContractNearest;
			}
			else {
				result = exchangeTradedContractNearest = ReferenceWithMetaObservable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationTerms")
		@RuneAttribute("valuationTerms")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setValuationTerms(ValuationTerms _valuationTerms) {
			this.valuationTerms = _valuationTerms == null ? null : _valuationTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@RuneAttribute("annualizationFactor")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setAnnualizationFactor(Integer _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@Override
		@RosettaAttribute("dividendApplicability")
		@RuneAttribute("dividendApplicability")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setDividendApplicability(DividendApplicability _dividendApplicability) {
			this.dividendApplicability = _dividendApplicability == null ? null : _dividendApplicability.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("equityUnderlierProvisions")
		@RuneAttribute("equityUnderlierProvisions")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setEquityUnderlierProvisions(EquityUnderlierProvisions _equityUnderlierProvisions) {
			this.equityUnderlierProvisions = _equityUnderlierProvisions == null ? null : _equityUnderlierProvisions.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("sharePriceDividendAdjustment")
		@RuneAttribute("sharePriceDividendAdjustment")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setSharePriceDividendAdjustment(Boolean _sharePriceDividendAdjustment) {
			this.sharePriceDividendAdjustment = _sharePriceDividendAdjustment == null ? null : _sharePriceDividendAdjustment;
			return this;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		@RuneAttribute("expectedN")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		@RuneAttribute("initialLevel")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		@RuneAttribute("initialLevelSource")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setInitialLevelSource(DeterminationMethodEnum _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource;
			return this;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@RuneAttribute("meanAdjustment")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setMeanAdjustment(Boolean _meanAdjustment) {
			this.meanAdjustment = _meanAdjustment == null ? null : _meanAdjustment;
			return this;
		}
		
		@Override
		@RosettaAttribute("performance")
		@RuneAttribute("performance")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setPerformance(String _performance) {
			this.performance = _performance == null ? null : _performance;
			return this;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		@RuneAttribute("varianceStrikePrice")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setVarianceStrikePrice(Price _varianceStrikePrice) {
			this.varianceStrikePrice = _varianceStrikePrice == null ? null : _varianceStrikePrice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		@RuneAttribute("volatilityStrikePrice")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setVolatilityStrikePrice(Price _volatilityStrikePrice) {
			this.volatilityStrikePrice = _volatilityStrikePrice == null ? null : _volatilityStrikePrice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("varianceCapFloor")
		@RuneAttribute("varianceCapFloor")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setVarianceCapFloor(VarianceCapFloor _varianceCapFloor) {
			this.varianceCapFloor = _varianceCapFloor == null ? null : _varianceCapFloor.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFloor")
		@RuneAttribute("volatilityCapFloor")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setVolatilityCapFloor(VolatilityCapFloor _volatilityCapFloor) {
			this.volatilityCapFloor = _volatilityCapFloor == null ? null : _volatilityCapFloor.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		@RuneAttribute("vegaNotionalAmount")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setVegaNotionalAmount(NonNegativeQuantitySchedule _vegaNotionalAmount) {
			this.vegaNotionalAmount = _vegaNotionalAmount == null ? null : _vegaNotionalAmount.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@RuneAttribute("exchangeTradedContractNearest")
		public VarianceReturnTerms.VarianceReturnTermsBuilder setExchangeTradedContractNearest(ReferenceWithMetaObservable _exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = _exchangeTradedContractNearest == null ? null : _exchangeTradedContractNearest.toBuilder();
			return this;
		}
		
		@Override
		public VarianceReturnTerms.VarianceReturnTermsBuilder setExchangeTradedContractNearestValue(Observable _exchangeTradedContractNearest) {
			this.getOrCreateExchangeTradedContractNearest().setValue(_exchangeTradedContractNearest);
			return this;
		}
		
		@Override
		public VarianceReturnTerms build() {
			return new VarianceReturnTerms.VarianceReturnTermsImpl(this);
		}
		
		@Override
		public VarianceReturnTerms.VarianceReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceReturnTerms.VarianceReturnTermsBuilder prune() {
			super.prune();
			if (varianceStrikePrice!=null && !varianceStrikePrice.prune().hasData()) varianceStrikePrice = null;
			if (volatilityStrikePrice!=null && !volatilityStrikePrice.prune().hasData()) volatilityStrikePrice = null;
			if (varianceCapFloor!=null && !varianceCapFloor.prune().hasData()) varianceCapFloor = null;
			if (volatilityCapFloor!=null && !volatilityCapFloor.prune().hasData()) volatilityCapFloor = null;
			if (vegaNotionalAmount!=null && !vegaNotionalAmount.prune().hasData()) vegaNotionalAmount = null;
			if (exchangeTradedContractNearest!=null && !exchangeTradedContractNearest.prune().hasData()) exchangeTradedContractNearest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceStrikePrice()!=null && getVarianceStrikePrice().hasData()) return true;
			if (getVolatilityStrikePrice()!=null && getVolatilityStrikePrice().hasData()) return true;
			if (getVarianceCapFloor()!=null && getVarianceCapFloor().hasData()) return true;
			if (getVolatilityCapFloor()!=null && getVolatilityCapFloor().hasData()) return true;
			if (getVegaNotionalAmount()!=null && getVegaNotionalAmount().hasData()) return true;
			if (getExchangeTradedContractNearest()!=null && getExchangeTradedContractNearest().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceReturnTerms.VarianceReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceReturnTerms.VarianceReturnTermsBuilder o = (VarianceReturnTerms.VarianceReturnTermsBuilder) other;
			
			merger.mergeRosetta(getVarianceStrikePrice(), o.getVarianceStrikePrice(), this::setVarianceStrikePrice);
			merger.mergeRosetta(getVolatilityStrikePrice(), o.getVolatilityStrikePrice(), this::setVolatilityStrikePrice);
			merger.mergeRosetta(getVarianceCapFloor(), o.getVarianceCapFloor(), this::setVarianceCapFloor);
			merger.mergeRosetta(getVolatilityCapFloor(), o.getVolatilityCapFloor(), this::setVolatilityCapFloor);
			merger.mergeRosetta(getVegaNotionalAmount(), o.getVegaNotionalAmount(), this::setVegaNotionalAmount);
			merger.mergeRosetta(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceCapFloor, _that.getVarianceCapFloor())) return false;
			if (!Objects.equals(volatilityCapFloor, _that.getVolatilityCapFloor())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCapFloor != null ? varianceCapFloor.hashCode() : 0);
			_result = 31 * _result + (volatilityCapFloor != null ? volatilityCapFloor.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceReturnTermsBuilder {" +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceCapFloor=" + this.varianceCapFloor + ", " +
				"volatilityCapFloor=" + this.volatilityCapFloor + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}' + " " + super.toString();
		}
	}
}
