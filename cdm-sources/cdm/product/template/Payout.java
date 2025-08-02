package cdm.product.template;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CommodityPayout.CommodityPayoutBuilder;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.CreditDefaultPayout.CreditDefaultPayoutBuilder;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout.InterestRatePayoutBuilder;
import cdm.product.template.AssetPayout;
import cdm.product.template.AssetPayout.AssetPayoutBuilder;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.FixedPricePayout.FixedPricePayoutBuilder;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionPayout.OptionPayoutBuilder;
import cdm.product.template.Payout;
import cdm.product.template.Payout.PayoutBuilder;
import cdm.product.template.Payout.PayoutBuilderImpl;
import cdm.product.template.Payout.PayoutImpl;
import cdm.product.template.PerformancePayout;
import cdm.product.template.PerformancePayout.PerformancePayoutBuilder;
import cdm.product.template.SettlementPayout;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilder;
import cdm.product.template.meta.PayoutMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Represents the set of future cashflow methodologies in the form of specific payout data type(s) which result from the financial product.  Examples: a trade in a cash asset will use only a settlement payout; for derivatives, two interest rate payouts can be combined to specify an interest rate swap; one interest rate payout can be combined with a credit default payout to specify a credit default swap.
 * @version 6.0.0
 */
@RosettaDataType(value="Payout", builder=Payout.PayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Payout", model="Just another Rosetta model", builder=Payout.PayoutBuilderImpl.class, version="6.0.0")
public interface Payout extends RosettaModelObject, GlobalKey {

	PayoutMeta metaData = new PayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the assets and movements in a security financing transaction.
	 */
	AssetPayout getAssetPayout();
	/**
	 * Defines the payout for the floating leg of a Commodity Swap.
	 */
	CommodityPayout getCommodityPayout();
	/**
	 * The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.
	 */
	CreditDefaultPayout getCreditDefaultPayout();
	/**
	 * Defines a payout in which one or more payouts are defined as a fixed price.
	 */
	FixedPricePayout getFixedPricePayout();
	/**
	 * All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).
	 */
	InterestRatePayout getInterestRatePayout();
	/**
	 * The option payout.
	 */
	OptionPayout getOptionPayout();
	/**
	 * The performance payout, which encompasses the equity price returns, dividend returns, volatility return, variance return and correlation provisions.
	 */
	PerformancePayout getPerformancePayout();
	/**
	 * Represents a forward settling payout. The &#39;Underlier&#39; attribute captures the underlying payout, which is settled according to the &#39;SettlementTerms&#39; attribute. Both FX Spot and FX Forward should use this component.
	 */
	SettlementPayout getSettlementPayout();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	Payout build();
	
	Payout.PayoutBuilder toBuilder();
	
	static Payout.PayoutBuilder builder() {
		return new Payout.PayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Payout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Payout> getType() {
		return Payout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("AssetPayout"), processor, AssetPayout.class, getAssetPayout());
		processRosetta(path.newSubPath("CommodityPayout"), processor, CommodityPayout.class, getCommodityPayout());
		processRosetta(path.newSubPath("CreditDefaultPayout"), processor, CreditDefaultPayout.class, getCreditDefaultPayout());
		processRosetta(path.newSubPath("FixedPricePayout"), processor, FixedPricePayout.class, getFixedPricePayout());
		processRosetta(path.newSubPath("InterestRatePayout"), processor, InterestRatePayout.class, getInterestRatePayout());
		processRosetta(path.newSubPath("OptionPayout"), processor, OptionPayout.class, getOptionPayout());
		processRosetta(path.newSubPath("PerformancePayout"), processor, PerformancePayout.class, getPerformancePayout());
		processRosetta(path.newSubPath("SettlementPayout"), processor, SettlementPayout.class, getSettlementPayout());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayoutBuilder extends Payout, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		AssetPayout.AssetPayoutBuilder getOrCreateAssetPayout();
		@Override
		AssetPayout.AssetPayoutBuilder getAssetPayout();
		CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout();
		@Override
		CommodityPayout.CommodityPayoutBuilder getCommodityPayout();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout();
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout();
		FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout();
		@Override
		FixedPricePayout.FixedPricePayoutBuilder getFixedPricePayout();
		InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout();
		@Override
		InterestRatePayout.InterestRatePayoutBuilder getInterestRatePayout();
		OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout();
		@Override
		OptionPayout.OptionPayoutBuilder getOptionPayout();
		PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout();
		@Override
		PerformancePayout.PerformancePayoutBuilder getPerformancePayout();
		SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout();
		@Override
		SettlementPayout.SettlementPayoutBuilder getSettlementPayout();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		Payout.PayoutBuilder setAssetPayout(AssetPayout _AssetPayout);
		Payout.PayoutBuilder setCommodityPayout(CommodityPayout _CommodityPayout);
		Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout _CreditDefaultPayout);
		Payout.PayoutBuilder setFixedPricePayout(FixedPricePayout _FixedPricePayout);
		Payout.PayoutBuilder setInterestRatePayout(InterestRatePayout _InterestRatePayout);
		Payout.PayoutBuilder setOptionPayout(OptionPayout _OptionPayout);
		Payout.PayoutBuilder setPerformancePayout(PerformancePayout _PerformancePayout);
		Payout.PayoutBuilder setSettlementPayout(SettlementPayout _SettlementPayout);
		Payout.PayoutBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("AssetPayout"), processor, AssetPayout.AssetPayoutBuilder.class, getAssetPayout());
			processRosetta(path.newSubPath("CommodityPayout"), processor, CommodityPayout.CommodityPayoutBuilder.class, getCommodityPayout());
			processRosetta(path.newSubPath("CreditDefaultPayout"), processor, CreditDefaultPayout.CreditDefaultPayoutBuilder.class, getCreditDefaultPayout());
			processRosetta(path.newSubPath("FixedPricePayout"), processor, FixedPricePayout.FixedPricePayoutBuilder.class, getFixedPricePayout());
			processRosetta(path.newSubPath("InterestRatePayout"), processor, InterestRatePayout.InterestRatePayoutBuilder.class, getInterestRatePayout());
			processRosetta(path.newSubPath("OptionPayout"), processor, OptionPayout.OptionPayoutBuilder.class, getOptionPayout());
			processRosetta(path.newSubPath("PerformancePayout"), processor, PerformancePayout.PerformancePayoutBuilder.class, getPerformancePayout());
			processRosetta(path.newSubPath("SettlementPayout"), processor, SettlementPayout.SettlementPayoutBuilder.class, getSettlementPayout());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		Payout.PayoutBuilder prune();
	}

	/*********************** Immutable Implementation of Payout  ***********************/
	class PayoutImpl implements Payout {
		private final AssetPayout assetPayout;
		private final CommodityPayout commodityPayout;
		private final CreditDefaultPayout creditDefaultPayout;
		private final FixedPricePayout fixedPricePayout;
		private final InterestRatePayout interestRatePayout;
		private final OptionPayout optionPayout;
		private final PerformancePayout performancePayout;
		private final SettlementPayout settlementPayout;
		private final MetaFields meta;
		
		protected PayoutImpl(Payout.PayoutBuilder builder) {
			this.assetPayout = ofNullable(builder.getAssetPayout()).map(f->f.build()).orElse(null);
			this.commodityPayout = ofNullable(builder.getCommodityPayout()).map(f->f.build()).orElse(null);
			this.creditDefaultPayout = ofNullable(builder.getCreditDefaultPayout()).map(f->f.build()).orElse(null);
			this.fixedPricePayout = ofNullable(builder.getFixedPricePayout()).map(f->f.build()).orElse(null);
			this.interestRatePayout = ofNullable(builder.getInterestRatePayout()).map(f->f.build()).orElse(null);
			this.optionPayout = ofNullable(builder.getOptionPayout()).map(f->f.build()).orElse(null);
			this.performancePayout = ofNullable(builder.getPerformancePayout()).map(f->f.build()).orElse(null);
			this.settlementPayout = ofNullable(builder.getSettlementPayout()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("AssetPayout")
		@RuneAttribute("AssetPayout")
		public AssetPayout getAssetPayout() {
			return assetPayout;
		}
		
		@Override
		@RosettaAttribute("CommodityPayout")
		@RuneAttribute("CommodityPayout")
		public CommodityPayout getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		@RosettaAttribute("CreditDefaultPayout")
		@RuneAttribute("CreditDefaultPayout")
		public CreditDefaultPayout getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		@RosettaAttribute("FixedPricePayout")
		@RuneAttribute("FixedPricePayout")
		public FixedPricePayout getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		@RosettaAttribute("InterestRatePayout")
		@RuneAttribute("InterestRatePayout")
		public InterestRatePayout getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		@RosettaAttribute("OptionPayout")
		@RuneAttribute("OptionPayout")
		public OptionPayout getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		@RosettaAttribute("PerformancePayout")
		@RuneAttribute("PerformancePayout")
		public PerformancePayout getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		@RosettaAttribute("SettlementPayout")
		@RuneAttribute("SettlementPayout")
		public SettlementPayout getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Payout build() {
			return this;
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			Payout.PayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Payout.PayoutBuilder builder) {
			ofNullable(getAssetPayout()).ifPresent(builder::setAssetPayout);
			ofNullable(getCommodityPayout()).ifPresent(builder::setCommodityPayout);
			ofNullable(getCreditDefaultPayout()).ifPresent(builder::setCreditDefaultPayout);
			ofNullable(getFixedPricePayout()).ifPresent(builder::setFixedPricePayout);
			ofNullable(getInterestRatePayout()).ifPresent(builder::setInterestRatePayout);
			ofNullable(getOptionPayout()).ifPresent(builder::setOptionPayout);
			ofNullable(getPerformancePayout()).ifPresent(builder::setPerformancePayout);
			ofNullable(getSettlementPayout()).ifPresent(builder::setSettlementPayout);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!Objects.equals(assetPayout, _that.getAssetPayout())) return false;
			if (!Objects.equals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!Objects.equals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(optionPayout, _that.getOptionPayout())) return false;
			if (!Objects.equals(performancePayout, _that.getPerformancePayout())) return false;
			if (!Objects.equals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetPayout != null ? assetPayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Payout {" +
				"AssetPayout=" + this.assetPayout + ", " +
				"CommodityPayout=" + this.commodityPayout + ", " +
				"CreditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"FixedPricePayout=" + this.fixedPricePayout + ", " +
				"InterestRatePayout=" + this.interestRatePayout + ", " +
				"OptionPayout=" + this.optionPayout + ", " +
				"PerformancePayout=" + this.performancePayout + ", " +
				"SettlementPayout=" + this.settlementPayout + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of Payout  ***********************/
	class PayoutBuilderImpl implements Payout.PayoutBuilder {
	
		protected AssetPayout.AssetPayoutBuilder assetPayout;
		protected CommodityPayout.CommodityPayoutBuilder commodityPayout;
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout;
		protected FixedPricePayout.FixedPricePayoutBuilder fixedPricePayout;
		protected InterestRatePayout.InterestRatePayoutBuilder interestRatePayout;
		protected OptionPayout.OptionPayoutBuilder optionPayout;
		protected PerformancePayout.PerformancePayoutBuilder performancePayout;
		protected SettlementPayout.SettlementPayoutBuilder settlementPayout;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("AssetPayout")
		@RuneAttribute("AssetPayout")
		public AssetPayout.AssetPayoutBuilder getAssetPayout() {
			return assetPayout;
		}
		
		@Override
		public AssetPayout.AssetPayoutBuilder getOrCreateAssetPayout() {
			AssetPayout.AssetPayoutBuilder result;
			if (assetPayout!=null) {
				result = assetPayout;
			}
			else {
				result = assetPayout = AssetPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CommodityPayout")
		@RuneAttribute("CommodityPayout")
		public CommodityPayout.CommodityPayoutBuilder getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout() {
			CommodityPayout.CommodityPayoutBuilder result;
			if (commodityPayout!=null) {
				result = commodityPayout;
			}
			else {
				result = commodityPayout = CommodityPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CreditDefaultPayout")
		@RuneAttribute("CreditDefaultPayout")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder result;
			if (creditDefaultPayout!=null) {
				result = creditDefaultPayout;
			}
			else {
				result = creditDefaultPayout = CreditDefaultPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FixedPricePayout")
		@RuneAttribute("FixedPricePayout")
		public FixedPricePayout.FixedPricePayoutBuilder getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		public FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout() {
			FixedPricePayout.FixedPricePayoutBuilder result;
			if (fixedPricePayout!=null) {
				result = fixedPricePayout;
			}
			else {
				result = fixedPricePayout = FixedPricePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("InterestRatePayout")
		@RuneAttribute("InterestRatePayout")
		public InterestRatePayout.InterestRatePayoutBuilder getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout() {
			InterestRatePayout.InterestRatePayoutBuilder result;
			if (interestRatePayout!=null) {
				result = interestRatePayout;
			}
			else {
				result = interestRatePayout = InterestRatePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OptionPayout")
		@RuneAttribute("OptionPayout")
		public OptionPayout.OptionPayoutBuilder getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout() {
			OptionPayout.OptionPayoutBuilder result;
			if (optionPayout!=null) {
				result = optionPayout;
			}
			else {
				result = optionPayout = OptionPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("PerformancePayout")
		@RuneAttribute("PerformancePayout")
		public PerformancePayout.PerformancePayoutBuilder getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout() {
			PerformancePayout.PerformancePayoutBuilder result;
			if (performancePayout!=null) {
				result = performancePayout;
			}
			else {
				result = performancePayout = PerformancePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SettlementPayout")
		@RuneAttribute("SettlementPayout")
		public SettlementPayout.SettlementPayoutBuilder getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout() {
			SettlementPayout.SettlementPayoutBuilder result;
			if (settlementPayout!=null) {
				result = settlementPayout;
			}
			else {
				result = settlementPayout = SettlementPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AssetPayout")
		@RuneAttribute("AssetPayout")
		public Payout.PayoutBuilder setAssetPayout(AssetPayout _assetPayout) {
			this.assetPayout = _assetPayout == null ? null : _assetPayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CommodityPayout")
		@RuneAttribute("CommodityPayout")
		public Payout.PayoutBuilder setCommodityPayout(CommodityPayout _commodityPayout) {
			this.commodityPayout = _commodityPayout == null ? null : _commodityPayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CreditDefaultPayout")
		@RuneAttribute("CreditDefaultPayout")
		public Payout.PayoutBuilder setCreditDefaultPayout(CreditDefaultPayout _creditDefaultPayout) {
			this.creditDefaultPayout = _creditDefaultPayout == null ? null : _creditDefaultPayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("FixedPricePayout")
		@RuneAttribute("FixedPricePayout")
		public Payout.PayoutBuilder setFixedPricePayout(FixedPricePayout _fixedPricePayout) {
			this.fixedPricePayout = _fixedPricePayout == null ? null : _fixedPricePayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("InterestRatePayout")
		@RuneAttribute("InterestRatePayout")
		public Payout.PayoutBuilder setInterestRatePayout(InterestRatePayout _interestRatePayout) {
			this.interestRatePayout = _interestRatePayout == null ? null : _interestRatePayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("OptionPayout")
		@RuneAttribute("OptionPayout")
		public Payout.PayoutBuilder setOptionPayout(OptionPayout _optionPayout) {
			this.optionPayout = _optionPayout == null ? null : _optionPayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("PerformancePayout")
		@RuneAttribute("PerformancePayout")
		public Payout.PayoutBuilder setPerformancePayout(PerformancePayout _performancePayout) {
			this.performancePayout = _performancePayout == null ? null : _performancePayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("SettlementPayout")
		@RuneAttribute("SettlementPayout")
		public Payout.PayoutBuilder setSettlementPayout(SettlementPayout _settlementPayout) {
			this.settlementPayout = _settlementPayout == null ? null : _settlementPayout.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public Payout.PayoutBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public Payout build() {
			return new Payout.PayoutImpl(this);
		}
		
		@Override
		public Payout.PayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder prune() {
			if (assetPayout!=null && !assetPayout.prune().hasData()) assetPayout = null;
			if (commodityPayout!=null && !commodityPayout.prune().hasData()) commodityPayout = null;
			if (creditDefaultPayout!=null && !creditDefaultPayout.prune().hasData()) creditDefaultPayout = null;
			if (fixedPricePayout!=null && !fixedPricePayout.prune().hasData()) fixedPricePayout = null;
			if (interestRatePayout!=null && !interestRatePayout.prune().hasData()) interestRatePayout = null;
			if (optionPayout!=null && !optionPayout.prune().hasData()) optionPayout = null;
			if (performancePayout!=null && !performancePayout.prune().hasData()) performancePayout = null;
			if (settlementPayout!=null && !settlementPayout.prune().hasData()) settlementPayout = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetPayout()!=null && getAssetPayout().hasData()) return true;
			if (getCommodityPayout()!=null && getCommodityPayout().hasData()) return true;
			if (getCreditDefaultPayout()!=null && getCreditDefaultPayout().hasData()) return true;
			if (getFixedPricePayout()!=null && getFixedPricePayout().hasData()) return true;
			if (getInterestRatePayout()!=null && getInterestRatePayout().hasData()) return true;
			if (getOptionPayout()!=null && getOptionPayout().hasData()) return true;
			if (getPerformancePayout()!=null && getPerformancePayout().hasData()) return true;
			if (getSettlementPayout()!=null && getSettlementPayout().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Payout.PayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Payout.PayoutBuilder o = (Payout.PayoutBuilder) other;
			
			merger.mergeRosetta(getAssetPayout(), o.getAssetPayout(), this::setAssetPayout);
			merger.mergeRosetta(getCommodityPayout(), o.getCommodityPayout(), this::setCommodityPayout);
			merger.mergeRosetta(getCreditDefaultPayout(), o.getCreditDefaultPayout(), this::setCreditDefaultPayout);
			merger.mergeRosetta(getFixedPricePayout(), o.getFixedPricePayout(), this::setFixedPricePayout);
			merger.mergeRosetta(getInterestRatePayout(), o.getInterestRatePayout(), this::setInterestRatePayout);
			merger.mergeRosetta(getOptionPayout(), o.getOptionPayout(), this::setOptionPayout);
			merger.mergeRosetta(getPerformancePayout(), o.getPerformancePayout(), this::setPerformancePayout);
			merger.mergeRosetta(getSettlementPayout(), o.getSettlementPayout(), this::setSettlementPayout);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Payout _that = getType().cast(o);
		
			if (!Objects.equals(assetPayout, _that.getAssetPayout())) return false;
			if (!Objects.equals(commodityPayout, _that.getCommodityPayout())) return false;
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!Objects.equals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(optionPayout, _that.getOptionPayout())) return false;
			if (!Objects.equals(performancePayout, _that.getPerformancePayout())) return false;
			if (!Objects.equals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetPayout != null ? assetPayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutBuilder {" +
				"AssetPayout=" + this.assetPayout + ", " +
				"CommodityPayout=" + this.commodityPayout + ", " +
				"CreditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"FixedPricePayout=" + this.fixedPricePayout + ", " +
				"InterestRatePayout=" + this.interestRatePayout + ", " +
				"OptionPayout=" + this.optionPayout + ", " +
				"PerformancePayout=" + this.performancePayout + ", " +
				"SettlementPayout=" + this.settlementPayout + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
