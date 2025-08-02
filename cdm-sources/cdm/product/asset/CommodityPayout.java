package cdm.product.asset;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryInformation.AssetDeliveryInformationBuilder;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CommodityPayout.CommodityPayoutBuilder;
import cdm.product.asset.CommodityPayout.CommodityPayoutBuilderImpl;
import cdm.product.asset.CommodityPayout.CommodityPayoutImpl;
import cdm.product.asset.meta.CommodityPayoutMeta;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDatesBuilder;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.PaymentDates.PaymentDatesBuilder;
import cdm.product.common.settlement.CommodityPriceReturnTerms;
import cdm.product.common.settlement.CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.PricingDates;
import cdm.product.common.settlement.PricingDates.PricingDatesBuilder;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.PrincipalPayments.PrincipalPaymentsBuilder;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity.ResolvablePriceQuantityBuilder;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTerms.SettlementTermsBuilder;
import cdm.product.template.AveragingCalculation;
import cdm.product.template.AveragingCalculation.AveragingCalculationBuilder;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.CalculationSchedule.CalculationScheduleBuilder;
import cdm.product.template.FxFeature;
import cdm.product.template.FxFeature.FxFeatureBuilder;
import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
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
 * Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) &amp; bullet (average of 1) pricing
 * @version 6.0.0
 */
@RosettaDataType(value="CommodityPayout", builder=CommodityPayout.CommodityPayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CommodityPayout", model="Just another Rosetta model", builder=CommodityPayout.CommodityPayoutBuilderImpl.class, version="6.0.0")
public interface CommodityPayout extends PayoutBase {

	CommodityPayoutMeta metaData = new CommodityPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates if the averaging calculation, when applicable, is weighted or unweighted.
	 */
	AveragingCalculation getAveragingFeature();
	/**
	 * Defines parameters in which the commodity price is assessed.
	 */
	CommodityPriceReturnTerms getCommodityPriceReturnTerms();
	/**
	 * Specifies specific dates or parametric rules for the dates on which the price will be determined.
	 */
	PricingDates getPricingDates();
	/**
	 * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
	 */
	CalculationSchedule getSchedule();
	/**
	 * Defines the calculation period dates schedule.
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 * Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
	 */
	PaymentDates getPaymentDates();
	/**
	 * Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the &#39;2018 ISDA CDM Equity Confirmation for Security Equity Swap&#39; as Security.
	 */
	Underlier getUnderlier();
	/**
	 * Defines quanto or composite FX features that are included in the swap leg.
	 */
	FxFeature getFxFeature();
	/**
	 * Contains the information relative to the delivery of the asset.
	 */
	AssetDeliveryInformation getDelivery();

	/*********************** Build Methods  ***********************/
	CommodityPayout build();
	
	CommodityPayout.CommodityPayoutBuilder toBuilder();
	
	static CommodityPayout.CommodityPayoutBuilder builder() {
		return new CommodityPayout.CommodityPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPayout> getType() {
		return CommodityPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("averagingFeature"), processor, AveragingCalculation.class, getAveragingFeature());
		processRosetta(path.newSubPath("commodityPriceReturnTerms"), processor, CommodityPriceReturnTerms.class, getCommodityPriceReturnTerms());
		processRosetta(path.newSubPath("pricingDates"), processor, PricingDates.class, getPricingDates());
		processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.class, getSchedule());
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("underlier"), processor, Underlier.class, getUnderlier());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.class, getDelivery());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPayoutBuilder extends CommodityPayout, PayoutBase.PayoutBaseBuilder {
		AveragingCalculation.AveragingCalculationBuilder getOrCreateAveragingFeature();
		@Override
		AveragingCalculation.AveragingCalculationBuilder getAveragingFeature();
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getOrCreateCommodityPriceReturnTerms();
		@Override
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getCommodityPriceReturnTerms();
		PricingDates.PricingDatesBuilder getOrCreatePricingDates();
		@Override
		PricingDates.PricingDatesBuilder getPricingDates();
		CalculationSchedule.CalculationScheduleBuilder getOrCreateSchedule();
		@Override
		CalculationSchedule.CalculationScheduleBuilder getSchedule();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		@Override
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		@Override
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		Underlier.UnderlierBuilder getOrCreateUnderlier();
		@Override
		Underlier.UnderlierBuilder getUnderlier();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		@Override
		FxFeature.FxFeatureBuilder getFxFeature();
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getOrCreateDelivery();
		@Override
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getDelivery();
		@Override
		CommodityPayout.CommodityPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		@Override
		CommodityPayout.CommodityPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		@Override
		CommodityPayout.CommodityPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		@Override
		CommodityPayout.CommodityPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		CommodityPayout.CommodityPayoutBuilder setAveragingFeature(AveragingCalculation averagingFeature);
		CommodityPayout.CommodityPayoutBuilder setCommodityPriceReturnTerms(CommodityPriceReturnTerms commodityPriceReturnTerms);
		CommodityPayout.CommodityPayoutBuilder setPricingDates(PricingDates pricingDates);
		CommodityPayout.CommodityPayoutBuilder setSchedule(CalculationSchedule schedule);
		CommodityPayout.CommodityPayoutBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		CommodityPayout.CommodityPayoutBuilder setPaymentDates(PaymentDates paymentDates);
		CommodityPayout.CommodityPayoutBuilder setUnderlier(Underlier underlier);
		CommodityPayout.CommodityPayoutBuilder setFxFeature(FxFeature fxFeature);
		CommodityPayout.CommodityPayoutBuilder setDelivery(AssetDeliveryInformation delivery);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("averagingFeature"), processor, AveragingCalculation.AveragingCalculationBuilder.class, getAveragingFeature());
			processRosetta(path.newSubPath("commodityPriceReturnTerms"), processor, CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder.class, getCommodityPriceReturnTerms());
			processRosetta(path.newSubPath("pricingDates"), processor, PricingDates.PricingDatesBuilder.class, getPricingDates());
			processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.CalculationScheduleBuilder.class, getSchedule());
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("underlier"), processor, Underlier.UnderlierBuilder.class, getUnderlier());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.AssetDeliveryInformationBuilder.class, getDelivery());
		}
		

		CommodityPayout.CommodityPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPayout  ***********************/
	class CommodityPayoutImpl extends PayoutBase.PayoutBaseImpl implements CommodityPayout {
		private final AveragingCalculation averagingFeature;
		private final CommodityPriceReturnTerms commodityPriceReturnTerms;
		private final PricingDates pricingDates;
		private final CalculationSchedule schedule;
		private final CalculationPeriodDates calculationPeriodDates;
		private final PaymentDates paymentDates;
		private final Underlier underlier;
		private final FxFeature fxFeature;
		private final AssetDeliveryInformation delivery;
		
		protected CommodityPayoutImpl(CommodityPayout.CommodityPayoutBuilder builder) {
			super(builder);
			this.averagingFeature = ofNullable(builder.getAveragingFeature()).map(f->f.build()).orElse(null);
			this.commodityPriceReturnTerms = ofNullable(builder.getCommodityPriceReturnTerms()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.schedule = ofNullable(builder.getSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.delivery = ofNullable(builder.getDelivery()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("averagingFeature")
		@RuneAttribute("averagingFeature")
		public AveragingCalculation getAveragingFeature() {
			return averagingFeature;
		}
		
		@Override
		@RosettaAttribute("commodityPriceReturnTerms")
		@RuneAttribute("commodityPriceReturnTerms")
		public CommodityPriceReturnTerms getCommodityPriceReturnTerms() {
			return commodityPriceReturnTerms;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@RuneAttribute("pricingDates")
		public PricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("schedule")
		@RuneAttribute("schedule")
		public CalculationSchedule getSchedule() {
			return schedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@RuneAttribute("paymentDates")
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public Underlier getUnderlier() {
			return underlier;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@RuneAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("delivery")
		@RuneAttribute("delivery")
		public AssetDeliveryInformation getDelivery() {
			return delivery;
		}
		
		@Override
		public CommodityPayout build() {
			return this;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder toBuilder() {
			CommodityPayout.CommodityPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPayout.CommodityPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAveragingFeature()).ifPresent(builder::setAveragingFeature);
			ofNullable(getCommodityPriceReturnTerms()).ifPresent(builder::setCommodityPriceReturnTerms);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getSchedule()).ifPresent(builder::setSchedule);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getDelivery()).ifPresent(builder::setDelivery);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPayout _that = getType().cast(o);
		
			if (!Objects.equals(averagingFeature, _that.getAveragingFeature())) return false;
			if (!Objects.equals(commodityPriceReturnTerms, _that.getCommodityPriceReturnTerms())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingFeature != null ? averagingFeature.hashCode() : 0);
			_result = 31 * _result + (commodityPriceReturnTerms != null ? commodityPriceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayout {" +
				"averagingFeature=" + this.averagingFeature + ", " +
				"commodityPriceReturnTerms=" + this.commodityPriceReturnTerms + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"schedule=" + this.schedule + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"delivery=" + this.delivery +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPayout  ***********************/
	class CommodityPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl implements CommodityPayout.CommodityPayoutBuilder {
	
		protected AveragingCalculation.AveragingCalculationBuilder averagingFeature;
		protected CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder commodityPriceReturnTerms;
		protected PricingDates.PricingDatesBuilder pricingDates;
		protected CalculationSchedule.CalculationScheduleBuilder schedule;
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected Underlier.UnderlierBuilder underlier;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected AssetDeliveryInformation.AssetDeliveryInformationBuilder delivery;
		
		@Override
		@RosettaAttribute("averagingFeature")
		@RuneAttribute("averagingFeature")
		public AveragingCalculation.AveragingCalculationBuilder getAveragingFeature() {
			return averagingFeature;
		}
		
		@Override
		public AveragingCalculation.AveragingCalculationBuilder getOrCreateAveragingFeature() {
			AveragingCalculation.AveragingCalculationBuilder result;
			if (averagingFeature!=null) {
				result = averagingFeature;
			}
			else {
				result = averagingFeature = AveragingCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPriceReturnTerms")
		@RuneAttribute("commodityPriceReturnTerms")
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getCommodityPriceReturnTerms() {
			return commodityPriceReturnTerms;
		}
		
		@Override
		public CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder getOrCreateCommodityPriceReturnTerms() {
			CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder result;
			if (commodityPriceReturnTerms!=null) {
				result = commodityPriceReturnTerms;
			}
			else {
				result = commodityPriceReturnTerms = CommodityPriceReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@RuneAttribute("pricingDates")
		public PricingDates.PricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public PricingDates.PricingDatesBuilder getOrCreatePricingDates() {
			PricingDates.PricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = PricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("schedule")
		@RuneAttribute("schedule")
		public CalculationSchedule.CalculationScheduleBuilder getSchedule() {
			return schedule;
		}
		
		@Override
		public CalculationSchedule.CalculationScheduleBuilder getOrCreateSchedule() {
			CalculationSchedule.CalculationScheduleBuilder result;
			if (schedule!=null) {
				result = schedule;
			}
			else {
				result = schedule = CalculationSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@RuneAttribute("paymentDates")
		public PaymentDates.PaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public Underlier.UnderlierBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Underlier.UnderlierBuilder getOrCreateUnderlier() {
			Underlier.UnderlierBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Underlier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@RuneAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("delivery")
		@RuneAttribute("delivery")
		public AssetDeliveryInformation.AssetDeliveryInformationBuilder getDelivery() {
			return delivery;
		}
		
		@Override
		public AssetDeliveryInformation.AssetDeliveryInformationBuilder getOrCreateDelivery() {
			AssetDeliveryInformation.AssetDeliveryInformationBuilder result;
			if (delivery!=null) {
				result = delivery;
			}
			else {
				result = delivery = AssetDeliveryInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public CommodityPayout.CommodityPayoutBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public CommodityPayout.CommodityPayoutBuilder setPriceQuantity(ResolvablePriceQuantity _priceQuantity) {
			this.priceQuantity = _priceQuantity == null ? null : _priceQuantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("principalPayment")
		@RuneAttribute("principalPayment")
		public CommodityPayout.CommodityPayoutBuilder setPrincipalPayment(PrincipalPayments _principalPayment) {
			this.principalPayment = _principalPayment == null ? null : _principalPayment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@RuneAttribute("settlementTerms")
		public CommodityPayout.CommodityPayoutBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("averagingFeature")
		@RuneAttribute("averagingFeature")
		public CommodityPayout.CommodityPayoutBuilder setAveragingFeature(AveragingCalculation _averagingFeature) {
			this.averagingFeature = _averagingFeature == null ? null : _averagingFeature.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityPriceReturnTerms")
		@RuneAttribute("commodityPriceReturnTerms")
		public CommodityPayout.CommodityPayoutBuilder setCommodityPriceReturnTerms(CommodityPriceReturnTerms _commodityPriceReturnTerms) {
			this.commodityPriceReturnTerms = _commodityPriceReturnTerms == null ? null : _commodityPriceReturnTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@RuneAttribute("pricingDates")
		public CommodityPayout.CommodityPayoutBuilder setPricingDates(PricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("schedule")
		@RuneAttribute("schedule")
		public CommodityPayout.CommodityPayoutBuilder setSchedule(CalculationSchedule _schedule) {
			this.schedule = _schedule == null ? null : _schedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@RuneAttribute("calculationPeriodDates")
		public CommodityPayout.CommodityPayoutBuilder setCalculationPeriodDates(CalculationPeriodDates _calculationPeriodDates) {
			this.calculationPeriodDates = _calculationPeriodDates == null ? null : _calculationPeriodDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@RuneAttribute("paymentDates")
		public CommodityPayout.CommodityPayoutBuilder setPaymentDates(PaymentDates _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public CommodityPayout.CommodityPayoutBuilder setUnderlier(Underlier _underlier) {
			this.underlier = _underlier == null ? null : _underlier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@RuneAttribute("fxFeature")
		public CommodityPayout.CommodityPayoutBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("delivery")
		@RuneAttribute("delivery")
		public CommodityPayout.CommodityPayoutBuilder setDelivery(AssetDeliveryInformation _delivery) {
			this.delivery = _delivery == null ? null : _delivery.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPayout build() {
			return new CommodityPayout.CommodityPayoutImpl(this);
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayout.CommodityPayoutBuilder prune() {
			super.prune();
			if (averagingFeature!=null && !averagingFeature.prune().hasData()) averagingFeature = null;
			if (commodityPriceReturnTerms!=null && !commodityPriceReturnTerms.prune().hasData()) commodityPriceReturnTerms = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (schedule!=null && !schedule.prune().hasData()) schedule = null;
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (delivery!=null && !delivery.prune().hasData()) delivery = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAveragingFeature()!=null && getAveragingFeature().hasData()) return true;
			if (getCommodityPriceReturnTerms()!=null && getCommodityPriceReturnTerms().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getSchedule()!=null && getSchedule().hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getDelivery()!=null && getDelivery().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPayout.CommodityPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPayout.CommodityPayoutBuilder o = (CommodityPayout.CommodityPayoutBuilder) other;
			
			merger.mergeRosetta(getAveragingFeature(), o.getAveragingFeature(), this::setAveragingFeature);
			merger.mergeRosetta(getCommodityPriceReturnTerms(), o.getCommodityPriceReturnTerms(), this::setCommodityPriceReturnTerms);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getSchedule(), o.getSchedule(), this::setSchedule);
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getDelivery(), o.getDelivery(), this::setDelivery);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPayout _that = getType().cast(o);
		
			if (!Objects.equals(averagingFeature, _that.getAveragingFeature())) return false;
			if (!Objects.equals(commodityPriceReturnTerms, _that.getCommodityPriceReturnTerms())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingFeature != null ? averagingFeature.hashCode() : 0);
			_result = 31 * _result + (commodityPriceReturnTerms != null ? commodityPriceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPayoutBuilder {" +
				"averagingFeature=" + this.averagingFeature + ", " +
				"commodityPriceReturnTerms=" + this.commodityPriceReturnTerms + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"schedule=" + this.schedule + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"delivery=" + this.delivery +
			'}' + " " + super.toString();
		}
	}
}
