package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.ValuationDates;
import cdm.observable.asset.ValuationDates.ValuationDatesBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsBuilder;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.PaymentDates.PaymentDatesBuilder;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.PrincipalPayments.PrincipalPaymentsBuilder;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity.ResolvablePriceQuantityBuilder;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTerms.SettlementTermsBuilder;
import cdm.product.template.FxFeature;
import cdm.product.template.FxFeature.FxFeatureBuilder;
import cdm.product.template.PerformancePayout;
import cdm.product.template.PerformancePayout.PerformancePayoutBuilder;
import cdm.product.template.PerformancePayout.PerformancePayoutBuilderImpl;
import cdm.product.template.PerformancePayout.PerformancePayoutImpl;
import cdm.product.template.PortfolioReturnTerms;
import cdm.product.template.PortfolioReturnTerms.PortfolioReturnTermsBuilder;
import cdm.product.template.ReturnTerms;
import cdm.product.template.ReturnTerms.ReturnTermsBuilder;
import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
import cdm.product.template.meta.PerformancePayoutMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Contains the necessary specifications for all performance payouts, encompassing equity return, dividend, variance, volatility and correlation products.
 * @version 6.0.0
 */
@RosettaDataType(value="PerformancePayout", builder=PerformancePayout.PerformancePayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PerformancePayout", model="Just another Rosetta model", builder=PerformancePayout.PerformancePayoutBuilderImpl.class, version="6.0.0")
public interface PerformancePayout extends PayoutBase {

	PerformancePayoutMeta metaData = new PerformancePayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines how and when a performance type option or performance type swap is to be observed.
	 */
	ObservationTerms getObservationTerms();
	/**
	 * Defines how and when a performance type option or performance type swap is to be valued, including both interim and final valuation.
	 */
	ValuationDates getValuationDates();
	/**
	 * Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
	 */
	PaymentDates getPaymentDates();
	/**
	 * Identifies the underlying product that is referenced for pricing of the applicable leg in a swap.  Referenced in the &#39;2018 ISDA CDM Equity Confirmation for Security Equity Swap&#39; as Security.
	 */
	Underlier getUnderlier();
	/**
	 * Defines quanto or composite FX features that are included in the swap leg.
	 */
	List<? extends FxFeature> getFxFeature();
	/**
	 * Specifies the type of return of a performance payout.
	 */
	ReturnTerms getReturnTerms();
	/**
	 * Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level
	 */
	List<? extends PortfolioReturnTerms> getPortfolioReturnTerms();
	/**
	 * Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice();
	/**
	 * Specifies the net initial valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice();
	/**
	 * Specifies the net final valuation price(s) of the underlier at Performance Payout level. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 */
	List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice();

	/*********************** Build Methods  ***********************/
	PerformancePayout build();
	
	PerformancePayout.PerformancePayoutBuilder toBuilder();
	
	static PerformancePayout.PerformancePayoutBuilder builder() {
		return new PerformancePayout.PerformancePayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PerformancePayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PerformancePayout> getType() {
		return PerformancePayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("observationTerms"), processor, ObservationTerms.class, getObservationTerms());
		processRosetta(path.newSubPath("valuationDates"), processor, ValuationDates.class, getValuationDates());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("underlier"), processor, Underlier.class, getUnderlier());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("returnTerms"), processor, ReturnTerms.class, getReturnTerms());
		processRosetta(path.newSubPath("portfolioReturnTerms"), processor, PortfolioReturnTerms.class, getPortfolioReturnTerms());
		processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInitialValuationPrice());
		processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getInterimValuationPrice());
		processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.class, getFinalValuationPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PerformancePayoutBuilder extends PerformancePayout, PayoutBase.PayoutBaseBuilder {
		ObservationTerms.ObservationTermsBuilder getOrCreateObservationTerms();
		@Override
		ObservationTerms.ObservationTermsBuilder getObservationTerms();
		ValuationDates.ValuationDatesBuilder getOrCreateValuationDates();
		@Override
		ValuationDates.ValuationDatesBuilder getValuationDates();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		@Override
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		Underlier.UnderlierBuilder getOrCreateUnderlier();
		@Override
		Underlier.UnderlierBuilder getUnderlier();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature(int _index);
		@Override
		List<? extends FxFeature.FxFeatureBuilder> getFxFeature();
		ReturnTerms.ReturnTermsBuilder getOrCreateReturnTerms();
		@Override
		ReturnTerms.ReturnTermsBuilder getReturnTerms();
		PortfolioReturnTerms.PortfolioReturnTermsBuilder getOrCreatePortfolioReturnTerms(int _index);
		@Override
		List<? extends PortfolioReturnTerms.PortfolioReturnTermsBuilder> getPortfolioReturnTerms();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice();
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index);
		@Override
		List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice();
		@Override
		PerformancePayout.PerformancePayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		@Override
		PerformancePayout.PerformancePayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		@Override
		PerformancePayout.PerformancePayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		@Override
		PerformancePayout.PerformancePayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		PerformancePayout.PerformancePayoutBuilder setObservationTerms(ObservationTerms observationTerms);
		PerformancePayout.PerformancePayoutBuilder setValuationDates(ValuationDates valuationDates);
		PerformancePayout.PerformancePayoutBuilder setPaymentDates(PaymentDates paymentDates);
		PerformancePayout.PerformancePayoutBuilder setUnderlier(Underlier underlier);
		PerformancePayout.PerformancePayoutBuilder addFxFeature(FxFeature fxFeature);
		PerformancePayout.PerformancePayoutBuilder addFxFeature(FxFeature fxFeature, int _idx);
		PerformancePayout.PerformancePayoutBuilder addFxFeature(List<? extends FxFeature> fxFeature);
		PerformancePayout.PerformancePayoutBuilder setFxFeature(List<? extends FxFeature> fxFeature);
		PerformancePayout.PerformancePayoutBuilder setReturnTerms(ReturnTerms returnTerms);
		PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(PortfolioReturnTerms portfolioReturnTerms);
		PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(PortfolioReturnTerms portfolioReturnTerms, int _idx);
		PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(List<? extends PortfolioReturnTerms> portfolioReturnTerms);
		PerformancePayout.PerformancePayoutBuilder setPortfolioReturnTerms(List<? extends PortfolioReturnTerms> portfolioReturnTerms);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule initialValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(PriceSchedule initialValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule interimValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(PriceSchedule interimValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule finalValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(PriceSchedule finalValuationPrice, int _idx);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice);
		PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice);
		PerformancePayout.PerformancePayoutBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("observationTerms"), processor, ObservationTerms.ObservationTermsBuilder.class, getObservationTerms());
			processRosetta(path.newSubPath("valuationDates"), processor, ValuationDates.ValuationDatesBuilder.class, getValuationDates());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("underlier"), processor, Underlier.UnderlierBuilder.class, getUnderlier());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("returnTerms"), processor, ReturnTerms.ReturnTermsBuilder.class, getReturnTerms());
			processRosetta(path.newSubPath("portfolioReturnTerms"), processor, PortfolioReturnTerms.PortfolioReturnTermsBuilder.class, getPortfolioReturnTerms());
			processRosetta(path.newSubPath("initialValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInitialValuationPrice());
			processRosetta(path.newSubPath("interimValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getInterimValuationPrice());
			processRosetta(path.newSubPath("finalValuationPrice"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getFinalValuationPrice());
		}
		

		PerformancePayout.PerformancePayoutBuilder prune();
	}

	/*********************** Immutable Implementation of PerformancePayout  ***********************/
	class PerformancePayoutImpl extends PayoutBase.PayoutBaseImpl implements PerformancePayout {
		private final ObservationTerms observationTerms;
		private final ValuationDates valuationDates;
		private final PaymentDates paymentDates;
		private final Underlier underlier;
		private final List<? extends FxFeature> fxFeature;
		private final ReturnTerms returnTerms;
		private final List<? extends PortfolioReturnTerms> portfolioReturnTerms;
		private final List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrice;
		private final List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrice;
		
		protected PerformancePayoutImpl(PerformancePayout.PerformancePayoutBuilder builder) {
			super(builder);
			this.observationTerms = ofNullable(builder.getObservationTerms()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.returnTerms = ofNullable(builder.getReturnTerms()).map(f->f.build()).orElse(null);
			this.portfolioReturnTerms = ofNullable(builder.getPortfolioReturnTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialValuationPrice = ofNullable(builder.getInitialValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interimValuationPrice = ofNullable(builder.getInterimValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.finalValuationPrice = ofNullable(builder.getFinalValuationPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationTerms")
		@RuneAttribute("observationTerms")
		public ObservationTerms getObservationTerms() {
			return observationTerms;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@RuneAttribute("valuationDates")
		public ValuationDates getValuationDates() {
			return valuationDates;
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
		public List<? extends FxFeature> getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("returnTerms")
		@RuneAttribute("returnTerms")
		public ReturnTerms getReturnTerms() {
			return returnTerms;
		}
		
		@Override
		@RosettaAttribute("portfolioReturnTerms")
		@RuneAttribute("portfolioReturnTerms")
		public List<? extends PortfolioReturnTerms> getPortfolioReturnTerms() {
			return portfolioReturnTerms;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		public PerformancePayout build() {
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder toBuilder() {
			PerformancePayout.PerformancePayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PerformancePayout.PerformancePayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getObservationTerms()).ifPresent(builder::setObservationTerms);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getReturnTerms()).ifPresent(builder::setReturnTerms);
			ofNullable(getPortfolioReturnTerms()).ifPresent(builder::setPortfolioReturnTerms);
			ofNullable(getInitialValuationPrice()).ifPresent(builder::setInitialValuationPrice);
			ofNullable(getInterimValuationPrice()).ifPresent(builder::setInterimValuationPrice);
			ofNullable(getFinalValuationPrice()).ifPresent(builder::setFinalValuationPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PerformancePayout _that = getType().cast(o);
		
			if (!Objects.equals(observationTerms, _that.getObservationTerms())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!ListEquals.listEquals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(returnTerms, _that.getReturnTerms())) return false;
			if (!ListEquals.listEquals(portfolioReturnTerms, _that.getPortfolioReturnTerms())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (observationTerms != null ? observationTerms.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (returnTerms != null ? returnTerms.hashCode() : 0);
			_result = 31 * _result + (portfolioReturnTerms != null ? portfolioReturnTerms.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PerformancePayout {" +
				"observationTerms=" + this.observationTerms + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"returnTerms=" + this.returnTerms + ", " +
				"portfolioReturnTerms=" + this.portfolioReturnTerms + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PerformancePayout  ***********************/
	class PerformancePayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl implements PerformancePayout.PerformancePayoutBuilder {
	
		protected ObservationTerms.ObservationTermsBuilder observationTerms;
		protected ValuationDates.ValuationDatesBuilder valuationDates;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected Underlier.UnderlierBuilder underlier;
		protected List<FxFeature.FxFeatureBuilder> fxFeature = new ArrayList<>();
		protected ReturnTerms.ReturnTermsBuilder returnTerms;
		protected List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> portfolioReturnTerms = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> initialValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> interimValuationPrice = new ArrayList<>();
		protected List<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> finalValuationPrice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("observationTerms")
		@RuneAttribute("observationTerms")
		public ObservationTerms.ObservationTermsBuilder getObservationTerms() {
			return observationTerms;
		}
		
		@Override
		public ObservationTerms.ObservationTermsBuilder getOrCreateObservationTerms() {
			ObservationTerms.ObservationTermsBuilder result;
			if (observationTerms!=null) {
				result = observationTerms;
			}
			else {
				result = observationTerms = ObservationTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@RuneAttribute("valuationDates")
		public ValuationDates.ValuationDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public ValuationDates.ValuationDatesBuilder getOrCreateValuationDates() {
			ValuationDates.ValuationDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = ValuationDates.builder();
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
		public List<? extends FxFeature.FxFeatureBuilder> getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature(int _index) {
		
			if (fxFeature==null) {
				this.fxFeature = new ArrayList<>();
			}
			FxFeature.FxFeatureBuilder result;
			return getIndex(fxFeature, _index, () -> {
						FxFeature.FxFeatureBuilder newFxFeature = FxFeature.builder();
						return newFxFeature;
					});
		}
		
		@Override
		@RosettaAttribute("returnTerms")
		@RuneAttribute("returnTerms")
		public ReturnTerms.ReturnTermsBuilder getReturnTerms() {
			return returnTerms;
		}
		
		@Override
		public ReturnTerms.ReturnTermsBuilder getOrCreateReturnTerms() {
			ReturnTerms.ReturnTermsBuilder result;
			if (returnTerms!=null) {
				result = returnTerms;
			}
			else {
				result = returnTerms = ReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReturnTerms")
		@RuneAttribute("portfolioReturnTerms")
		public List<? extends PortfolioReturnTerms.PortfolioReturnTermsBuilder> getPortfolioReturnTerms() {
			return portfolioReturnTerms;
		}
		
		@Override
		public PortfolioReturnTerms.PortfolioReturnTermsBuilder getOrCreatePortfolioReturnTerms(int _index) {
		
			if (portfolioReturnTerms==null) {
				this.portfolioReturnTerms = new ArrayList<>();
			}
			PortfolioReturnTerms.PortfolioReturnTermsBuilder result;
			return getIndex(portfolioReturnTerms, _index, () -> {
						PortfolioReturnTerms.PortfolioReturnTermsBuilder newPortfolioReturnTerms = PortfolioReturnTerms.builder();
						return newPortfolioReturnTerms;
					});
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInitialValuationPrice() {
			return initialValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInitialValuationPrice(int _index) {
		
			if (initialValuationPrice==null) {
				this.initialValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(initialValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInitialValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInitialValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getInterimValuationPrice() {
			return interimValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateInterimValuationPrice(int _index) {
		
			if (interimValuationPrice==null) {
				this.interimValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(interimValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newInterimValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newInterimValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public List<? extends ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder> getFinalValuationPrice() {
			return finalValuationPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder getOrCreateFinalValuationPrice(int _index) {
		
			if (finalValuationPrice==null) {
				this.finalValuationPrice = new ArrayList<>();
			}
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder result;
			return getIndex(finalValuationPrice, _index, () -> {
						ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder newFinalValuationPrice = ReferenceWithMetaPriceSchedule.builder();
						return newFinalValuationPrice;
					});
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public PerformancePayout.PerformancePayoutBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public PerformancePayout.PerformancePayoutBuilder setPriceQuantity(ResolvablePriceQuantity _priceQuantity) {
			this.priceQuantity = _priceQuantity == null ? null : _priceQuantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("principalPayment")
		@RuneAttribute("principalPayment")
		public PerformancePayout.PerformancePayoutBuilder setPrincipalPayment(PrincipalPayments _principalPayment) {
			this.principalPayment = _principalPayment == null ? null : _principalPayment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@RuneAttribute("settlementTerms")
		public PerformancePayout.PerformancePayoutBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationTerms")
		@RuneAttribute("observationTerms")
		public PerformancePayout.PerformancePayoutBuilder setObservationTerms(ObservationTerms _observationTerms) {
			this.observationTerms = _observationTerms == null ? null : _observationTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@RuneAttribute("valuationDates")
		public PerformancePayout.PerformancePayoutBuilder setValuationDates(ValuationDates _valuationDates) {
			this.valuationDates = _valuationDates == null ? null : _valuationDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@RuneAttribute("paymentDates")
		public PerformancePayout.PerformancePayoutBuilder setPaymentDates(PaymentDates _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public PerformancePayout.PerformancePayoutBuilder setUnderlier(Underlier _underlier) {
			this.underlier = _underlier == null ? null : _underlier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@RuneAttribute("fxFeature")
		public PerformancePayout.PerformancePayoutBuilder addFxFeature(FxFeature _fxFeature) {
			if (_fxFeature != null) {
				this.fxFeature.add(_fxFeature.toBuilder());
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addFxFeature(FxFeature _fxFeature, int _idx) {
			getIndex(this.fxFeature, _idx, () -> _fxFeature.toBuilder());
			return this;
		}
		
		@Override 
		public PerformancePayout.PerformancePayoutBuilder addFxFeature(List<? extends FxFeature> fxFeatures) {
			if (fxFeatures != null) {
				for (final FxFeature toAdd : fxFeatures) {
					this.fxFeature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("fxFeature")
		public PerformancePayout.PerformancePayoutBuilder setFxFeature(List<? extends FxFeature> fxFeatures) {
			if (fxFeatures == null) {
				this.fxFeature = new ArrayList<>();
			} else {
				this.fxFeature = fxFeatures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("returnTerms")
		@RuneAttribute("returnTerms")
		public PerformancePayout.PerformancePayoutBuilder setReturnTerms(ReturnTerms _returnTerms) {
			this.returnTerms = _returnTerms == null ? null : _returnTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("portfolioReturnTerms")
		@RuneAttribute("portfolioReturnTerms")
		public PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(PortfolioReturnTerms _portfolioReturnTerms) {
			if (_portfolioReturnTerms != null) {
				this.portfolioReturnTerms.add(_portfolioReturnTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(PortfolioReturnTerms _portfolioReturnTerms, int _idx) {
			getIndex(this.portfolioReturnTerms, _idx, () -> _portfolioReturnTerms.toBuilder());
			return this;
		}
		
		@Override 
		public PerformancePayout.PerformancePayoutBuilder addPortfolioReturnTerms(List<? extends PortfolioReturnTerms> portfolioReturnTermss) {
			if (portfolioReturnTermss != null) {
				for (final PortfolioReturnTerms toAdd : portfolioReturnTermss) {
					this.portfolioReturnTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("portfolioReturnTerms")
		public PerformancePayout.PerformancePayoutBuilder setPortfolioReturnTerms(List<? extends PortfolioReturnTerms> portfolioReturnTermss) {
			if (portfolioReturnTermss == null) {
				this.portfolioReturnTerms = new ArrayList<>();
			} else {
				this.portfolioReturnTerms = portfolioReturnTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialValuationPrice")
		@RuneAttribute("initialValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule _initialValuationPrice) {
			if (_initialValuationPrice != null) {
				this.initialValuationPrice.add(_initialValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(ReferenceWithMetaPriceSchedule _initialValuationPrice, int _idx) {
			getIndex(this.initialValuationPrice, _idx, () -> _initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(PriceSchedule _initialValuationPrice) {
			this.getOrCreateInitialValuationPrice(-1).setValue(_initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(PriceSchedule _initialValuationPrice, int _idx) {
			this.getOrCreateInitialValuationPrice(_idx).setValue(_initialValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : initialValuationPrices) {
					this.initialValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("initialValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder setInitialValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> initialValuationPrices) {
			if (initialValuationPrices == null) {
				this.initialValuationPrice = new ArrayList<>();
			} else {
				this.initialValuationPrice = initialValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			if (initialValuationPrices != null) {
				for (final PriceSchedule toAdd : initialValuationPrices) {
					this.addInitialValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder setInitialValuationPriceValue(List<? extends PriceSchedule> initialValuationPrices) {
			this.initialValuationPrice.clear();
			if (initialValuationPrices != null) {
				initialValuationPrices.forEach(this::addInitialValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("interimValuationPrice")
		@RuneAttribute("interimValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule _interimValuationPrice) {
			if (_interimValuationPrice != null) {
				this.interimValuationPrice.add(_interimValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(ReferenceWithMetaPriceSchedule _interimValuationPrice, int _idx) {
			getIndex(this.interimValuationPrice, _idx, () -> _interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(PriceSchedule _interimValuationPrice) {
			this.getOrCreateInterimValuationPrice(-1).setValue(_interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(PriceSchedule _interimValuationPrice, int _idx) {
			this.getOrCreateInterimValuationPrice(_idx).setValue(_interimValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : interimValuationPrices) {
					this.interimValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("interimValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder setInterimValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> interimValuationPrices) {
			if (interimValuationPrices == null) {
				this.interimValuationPrice = new ArrayList<>();
			} else {
				this.interimValuationPrice = interimValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			if (interimValuationPrices != null) {
				for (final PriceSchedule toAdd : interimValuationPrices) {
					this.addInterimValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder setInterimValuationPriceValue(List<? extends PriceSchedule> interimValuationPrices) {
			this.interimValuationPrice.clear();
			if (interimValuationPrices != null) {
				interimValuationPrices.forEach(this::addInterimValuationPriceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("finalValuationPrice")
		@RuneAttribute("finalValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule _finalValuationPrice) {
			if (_finalValuationPrice != null) {
				this.finalValuationPrice.add(_finalValuationPrice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(ReferenceWithMetaPriceSchedule _finalValuationPrice, int _idx) {
			getIndex(this.finalValuationPrice, _idx, () -> _finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(PriceSchedule _finalValuationPrice) {
			this.getOrCreateFinalValuationPrice(-1).setValue(_finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(PriceSchedule _finalValuationPrice, int _idx) {
			this.getOrCreateFinalValuationPrice(_idx).setValue(_finalValuationPrice.toBuilder());
			return this;
		}
		
		@Override 
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (final ReferenceWithMetaPriceSchedule toAdd : finalValuationPrices) {
					this.finalValuationPrice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("finalValuationPrice")
		public PerformancePayout.PerformancePayoutBuilder setFinalValuationPrice(List<? extends ReferenceWithMetaPriceSchedule> finalValuationPrices) {
			if (finalValuationPrices == null) {
				this.finalValuationPrice = new ArrayList<>();
			} else {
				this.finalValuationPrice = finalValuationPrices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder addFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			if (finalValuationPrices != null) {
				for (final PriceSchedule toAdd : finalValuationPrices) {
					this.addFinalValuationPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder setFinalValuationPriceValue(List<? extends PriceSchedule> finalValuationPrices) {
			this.finalValuationPrice.clear();
			if (finalValuationPrices != null) {
				finalValuationPrices.forEach(this::addFinalValuationPriceValue);
			}
			return this;
		}
		
		@Override
		public PerformancePayout build() {
			return new PerformancePayout.PerformancePayoutImpl(this);
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PerformancePayout.PerformancePayoutBuilder prune() {
			super.prune();
			if (observationTerms!=null && !observationTerms.prune().hasData()) observationTerms = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			fxFeature = fxFeature.stream().filter(b->b!=null).<FxFeature.FxFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (returnTerms!=null && !returnTerms.prune().hasData()) returnTerms = null;
			portfolioReturnTerms = portfolioReturnTerms.stream().filter(b->b!=null).<PortfolioReturnTerms.PortfolioReturnTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			initialValuationPrice = initialValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interimValuationPrice = interimValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			finalValuationPrice = finalValuationPrice.stream().filter(b->b!=null).<ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getObservationTerms()!=null && getObservationTerms().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReturnTerms()!=null && getReturnTerms().hasData()) return true;
			if (getPortfolioReturnTerms()!=null && getPortfolioReturnTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialValuationPrice()!=null && getInitialValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterimValuationPrice()!=null && getInterimValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFinalValuationPrice()!=null && getFinalValuationPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PerformancePayout.PerformancePayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PerformancePayout.PerformancePayoutBuilder o = (PerformancePayout.PerformancePayoutBuilder) other;
			
			merger.mergeRosetta(getObservationTerms(), o.getObservationTerms(), this::setObservationTerms);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::getOrCreateFxFeature);
			merger.mergeRosetta(getReturnTerms(), o.getReturnTerms(), this::setReturnTerms);
			merger.mergeRosetta(getPortfolioReturnTerms(), o.getPortfolioReturnTerms(), this::getOrCreatePortfolioReturnTerms);
			merger.mergeRosetta(getInitialValuationPrice(), o.getInitialValuationPrice(), this::getOrCreateInitialValuationPrice);
			merger.mergeRosetta(getInterimValuationPrice(), o.getInterimValuationPrice(), this::getOrCreateInterimValuationPrice);
			merger.mergeRosetta(getFinalValuationPrice(), o.getFinalValuationPrice(), this::getOrCreateFinalValuationPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PerformancePayout _that = getType().cast(o);
		
			if (!Objects.equals(observationTerms, _that.getObservationTerms())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!ListEquals.listEquals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(returnTerms, _that.getReturnTerms())) return false;
			if (!ListEquals.listEquals(portfolioReturnTerms, _that.getPortfolioReturnTerms())) return false;
			if (!ListEquals.listEquals(initialValuationPrice, _that.getInitialValuationPrice())) return false;
			if (!ListEquals.listEquals(interimValuationPrice, _that.getInterimValuationPrice())) return false;
			if (!ListEquals.listEquals(finalValuationPrice, _that.getFinalValuationPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (observationTerms != null ? observationTerms.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (returnTerms != null ? returnTerms.hashCode() : 0);
			_result = 31 * _result + (portfolioReturnTerms != null ? portfolioReturnTerms.hashCode() : 0);
			_result = 31 * _result + (initialValuationPrice != null ? initialValuationPrice.hashCode() : 0);
			_result = 31 * _result + (interimValuationPrice != null ? interimValuationPrice.hashCode() : 0);
			_result = 31 * _result + (finalValuationPrice != null ? finalValuationPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PerformancePayoutBuilder {" +
				"observationTerms=" + this.observationTerms + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"returnTerms=" + this.returnTerms + ", " +
				"portfolioReturnTerms=" + this.portfolioReturnTerms + ", " +
				"initialValuationPrice=" + this.initialValuationPrice + ", " +
				"interimValuationPrice=" + this.interimValuationPrice + ", " +
				"finalValuationPrice=" + this.finalValuationPrice +
			'}' + " " + super.toString();
		}
	}
}
