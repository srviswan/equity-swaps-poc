package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryInformation.AssetDeliveryInformationBuilder;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsBuilder;
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
import cdm.product.template.CalculationSchedule;
import cdm.product.template.CalculationSchedule.CalculationScheduleBuilder;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilder;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionFeature.OptionFeatureBuilder;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionPayout.OptionPayoutBuilder;
import cdm.product.template.OptionPayout.OptionPayoutBuilderImpl;
import cdm.product.template.OptionPayout.OptionPayoutImpl;
import cdm.product.template.OptionStrike;
import cdm.product.template.OptionStrike.OptionStrikeBuilder;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Underlier;
import cdm.product.template.Underlier.UnderlierBuilder;
import cdm.product.template.meta.OptionPayoutMeta;
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
 *  The option payout specification terms. The associated globalKey denotes the ability to associate a hash value to the respective OptionPayout instantiation for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version 6.0.0
 */
@RosettaDataType(value="OptionPayout", builder=OptionPayout.OptionPayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="OptionPayout", model="Just another Rosetta model", builder=OptionPayout.OptionPayoutBuilderImpl.class, version="6.0.0")
public interface OptionPayout extends PayoutBase {

	OptionPayoutMeta metaData = new OptionPayoutMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSeller getBuyerSeller();
	/**
	 * The option feature, such as quanto, Asian, barrier, knock.
	 */
	OptionFeature getFeature();
	/**
	 * Class containing terms that are associated with observing a price/benchmark/index across either single or multple observations. To be used for option contracts that reference a benchmark price.
	 */
	ObservationTerms getObservationTerms();
	/**
	 * Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
	 */
	CalculationSchedule getSchedule();
	/**
	 * Contains the information relative to the delivery of the asset.
	 */
	AssetDeliveryInformation getDelivery();
	/**
	 * The financial product underlying the option, which can be of any type including an Asset, Basket, Index or a NonTransferableProduct.
	 */
	Underlier getUnderlier();
	/**
	 * The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options on index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike.
	 */
	OptionTypeEnum getOptionType();
	/**
	 * The terms for exercising the option, which include the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
	 */
	ExerciseTerms getExerciseTerms();
	/**
	 * Specifies the strike of the option
	 */
	OptionStrike getStrike();

	/*********************** Build Methods  ***********************/
	OptionPayout build();
	
	OptionPayout.OptionPayoutBuilder toBuilder();
	
	static OptionPayout.OptionPayoutBuilder builder() {
		return new OptionPayout.OptionPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionPayout> getType() {
		return OptionPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("buyerSeller"), processor, BuyerSeller.class, getBuyerSeller());
		processRosetta(path.newSubPath("feature"), processor, OptionFeature.class, getFeature());
		processRosetta(path.newSubPath("observationTerms"), processor, ObservationTerms.class, getObservationTerms());
		processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.class, getSchedule());
		processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.class, getDelivery());
		processRosetta(path.newSubPath("underlier"), processor, Underlier.class, getUnderlier());
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.class, getExerciseTerms());
		processRosetta(path.newSubPath("strike"), processor, OptionStrike.class, getStrike());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionPayoutBuilder extends OptionPayout, PayoutBase.PayoutBaseBuilder {
		BuyerSeller.BuyerSellerBuilder getOrCreateBuyerSeller();
		@Override
		BuyerSeller.BuyerSellerBuilder getBuyerSeller();
		OptionFeature.OptionFeatureBuilder getOrCreateFeature();
		@Override
		OptionFeature.OptionFeatureBuilder getFeature();
		ObservationTerms.ObservationTermsBuilder getOrCreateObservationTerms();
		@Override
		ObservationTerms.ObservationTermsBuilder getObservationTerms();
		CalculationSchedule.CalculationScheduleBuilder getOrCreateSchedule();
		@Override
		CalculationSchedule.CalculationScheduleBuilder getSchedule();
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getOrCreateDelivery();
		@Override
		AssetDeliveryInformation.AssetDeliveryInformationBuilder getDelivery();
		Underlier.UnderlierBuilder getOrCreateUnderlier();
		@Override
		Underlier.UnderlierBuilder getUnderlier();
		ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms();
		@Override
		ExerciseTerms.ExerciseTermsBuilder getExerciseTerms();
		OptionStrike.OptionStrikeBuilder getOrCreateStrike();
		@Override
		OptionStrike.OptionStrikeBuilder getStrike();
		@Override
		OptionPayout.OptionPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		@Override
		OptionPayout.OptionPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		@Override
		OptionPayout.OptionPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		@Override
		OptionPayout.OptionPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		OptionPayout.OptionPayoutBuilder setBuyerSeller(BuyerSeller buyerSeller);
		OptionPayout.OptionPayoutBuilder setFeature(OptionFeature feature);
		OptionPayout.OptionPayoutBuilder setObservationTerms(ObservationTerms observationTerms);
		OptionPayout.OptionPayoutBuilder setSchedule(CalculationSchedule schedule);
		OptionPayout.OptionPayoutBuilder setDelivery(AssetDeliveryInformation delivery);
		OptionPayout.OptionPayoutBuilder setUnderlier(Underlier underlier);
		OptionPayout.OptionPayoutBuilder setOptionType(OptionTypeEnum optionType);
		OptionPayout.OptionPayoutBuilder setExerciseTerms(ExerciseTerms exerciseTerms);
		OptionPayout.OptionPayoutBuilder setStrike(OptionStrike strike);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("buyerSeller"), processor, BuyerSeller.BuyerSellerBuilder.class, getBuyerSeller());
			processRosetta(path.newSubPath("feature"), processor, OptionFeature.OptionFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("observationTerms"), processor, ObservationTerms.ObservationTermsBuilder.class, getObservationTerms());
			processRosetta(path.newSubPath("schedule"), processor, CalculationSchedule.CalculationScheduleBuilder.class, getSchedule());
			processRosetta(path.newSubPath("delivery"), processor, AssetDeliveryInformation.AssetDeliveryInformationBuilder.class, getDelivery());
			processRosetta(path.newSubPath("underlier"), processor, Underlier.UnderlierBuilder.class, getUnderlier());
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("exerciseTerms"), processor, ExerciseTerms.ExerciseTermsBuilder.class, getExerciseTerms());
			processRosetta(path.newSubPath("strike"), processor, OptionStrike.OptionStrikeBuilder.class, getStrike());
		}
		

		OptionPayout.OptionPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of OptionPayout  ***********************/
	class OptionPayoutImpl extends PayoutBase.PayoutBaseImpl implements OptionPayout {
		private final BuyerSeller buyerSeller;
		private final OptionFeature feature;
		private final ObservationTerms observationTerms;
		private final CalculationSchedule schedule;
		private final AssetDeliveryInformation delivery;
		private final Underlier underlier;
		private final OptionTypeEnum optionType;
		private final ExerciseTerms exerciseTerms;
		private final OptionStrike strike;
		
		protected OptionPayoutImpl(OptionPayout.OptionPayoutBuilder builder) {
			super(builder);
			this.buyerSeller = ofNullable(builder.getBuyerSeller()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.observationTerms = ofNullable(builder.getObservationTerms()).map(f->f.build()).orElse(null);
			this.schedule = ofNullable(builder.getSchedule()).map(f->f.build()).orElse(null);
			this.delivery = ofNullable(builder.getDelivery()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.exerciseTerms = ofNullable(builder.getExerciseTerms()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSeller")
		@RuneAttribute("buyerSeller")
		public BuyerSeller getBuyerSeller() {
			return buyerSeller;
		}
		
		@Override
		@RosettaAttribute("feature")
		@RuneAttribute("feature")
		public OptionFeature getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("observationTerms")
		@RuneAttribute("observationTerms")
		public ObservationTerms getObservationTerms() {
			return observationTerms;
		}
		
		@Override
		@RosettaAttribute("schedule")
		@RuneAttribute("schedule")
		public CalculationSchedule getSchedule() {
			return schedule;
		}
		
		@Override
		@RosettaAttribute("delivery")
		@RuneAttribute("delivery")
		public AssetDeliveryInformation getDelivery() {
			return delivery;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public Underlier getUnderlier() {
			return underlier;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExerciseTerms getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public OptionStrike getStrike() {
			return strike;
		}
		
		@Override
		public OptionPayout build() {
			return this;
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder toBuilder() {
			OptionPayout.OptionPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionPayout.OptionPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSeller()).ifPresent(builder::setBuyerSeller);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getObservationTerms()).ifPresent(builder::setObservationTerms);
			ofNullable(getSchedule()).ifPresent(builder::setSchedule);
			ofNullable(getDelivery()).ifPresent(builder::setDelivery);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getExerciseTerms()).ifPresent(builder::setExerciseTerms);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(buyerSeller, _that.getBuyerSeller())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(observationTerms, _that.getObservationTerms())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSeller != null ? buyerSeller.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (observationTerms != null ? observationTerms.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionPayout {" +
				"buyerSeller=" + this.buyerSeller + ", " +
				"feature=" + this.feature + ", " +
				"observationTerms=" + this.observationTerms + ", " +
				"schedule=" + this.schedule + ", " +
				"delivery=" + this.delivery + ", " +
				"underlier=" + this.underlier + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseTerms=" + this.exerciseTerms + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionPayout  ***********************/
	class OptionPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl implements OptionPayout.OptionPayoutBuilder {
	
		protected BuyerSeller.BuyerSellerBuilder buyerSeller;
		protected OptionFeature.OptionFeatureBuilder feature;
		protected ObservationTerms.ObservationTermsBuilder observationTerms;
		protected CalculationSchedule.CalculationScheduleBuilder schedule;
		protected AssetDeliveryInformation.AssetDeliveryInformationBuilder delivery;
		protected Underlier.UnderlierBuilder underlier;
		protected OptionTypeEnum optionType;
		protected ExerciseTerms.ExerciseTermsBuilder exerciseTerms;
		protected OptionStrike.OptionStrikeBuilder strike;
		
		@Override
		@RosettaAttribute("buyerSeller")
		@RuneAttribute("buyerSeller")
		public BuyerSeller.BuyerSellerBuilder getBuyerSeller() {
			return buyerSeller;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getOrCreateBuyerSeller() {
			BuyerSeller.BuyerSellerBuilder result;
			if (buyerSeller!=null) {
				result = buyerSeller;
			}
			else {
				result = buyerSeller = BuyerSeller.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		@RuneAttribute("feature")
		public OptionFeature.OptionFeatureBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder getOrCreateFeature() {
			OptionFeature.OptionFeatureBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeature.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public ExerciseTerms.ExerciseTermsBuilder getExerciseTerms() {
			return exerciseTerms;
		}
		
		@Override
		public ExerciseTerms.ExerciseTermsBuilder getOrCreateExerciseTerms() {
			ExerciseTerms.ExerciseTermsBuilder result;
			if (exerciseTerms!=null) {
				result = exerciseTerms;
			}
			else {
				result = exerciseTerms = ExerciseTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public OptionStrike.OptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder getOrCreateStrike() {
			OptionStrike.OptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = OptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public OptionPayout.OptionPayoutBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public OptionPayout.OptionPayoutBuilder setPriceQuantity(ResolvablePriceQuantity _priceQuantity) {
			this.priceQuantity = _priceQuantity == null ? null : _priceQuantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("principalPayment")
		@RuneAttribute("principalPayment")
		public OptionPayout.OptionPayoutBuilder setPrincipalPayment(PrincipalPayments _principalPayment) {
			this.principalPayment = _principalPayment == null ? null : _principalPayment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@RuneAttribute("settlementTerms")
		public OptionPayout.OptionPayoutBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("buyerSeller")
		@RuneAttribute("buyerSeller")
		public OptionPayout.OptionPayoutBuilder setBuyerSeller(BuyerSeller _buyerSeller) {
			this.buyerSeller = _buyerSeller == null ? null : _buyerSeller.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("feature")
		@RuneAttribute("feature")
		public OptionPayout.OptionPayoutBuilder setFeature(OptionFeature _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationTerms")
		@RuneAttribute("observationTerms")
		public OptionPayout.OptionPayoutBuilder setObservationTerms(ObservationTerms _observationTerms) {
			this.observationTerms = _observationTerms == null ? null : _observationTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("schedule")
		@RuneAttribute("schedule")
		public OptionPayout.OptionPayoutBuilder setSchedule(CalculationSchedule _schedule) {
			this.schedule = _schedule == null ? null : _schedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("delivery")
		@RuneAttribute("delivery")
		public OptionPayout.OptionPayoutBuilder setDelivery(AssetDeliveryInformation _delivery) {
			this.delivery = _delivery == null ? null : _delivery.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public OptionPayout.OptionPayoutBuilder setUnderlier(Underlier _underlier) {
			this.underlier = _underlier == null ? null : _underlier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public OptionPayout.OptionPayoutBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseTerms")
		@RuneAttribute("exerciseTerms")
		public OptionPayout.OptionPayoutBuilder setExerciseTerms(ExerciseTerms _exerciseTerms) {
			this.exerciseTerms = _exerciseTerms == null ? null : _exerciseTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public OptionPayout.OptionPayoutBuilder setStrike(OptionStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@Override
		public OptionPayout build() {
			return new OptionPayout.OptionPayoutImpl(this);
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionPayout.OptionPayoutBuilder prune() {
			super.prune();
			if (buyerSeller!=null && !buyerSeller.prune().hasData()) buyerSeller = null;
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (observationTerms!=null && !observationTerms.prune().hasData()) observationTerms = null;
			if (schedule!=null && !schedule.prune().hasData()) schedule = null;
			if (delivery!=null && !delivery.prune().hasData()) delivery = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			if (exerciseTerms!=null && !exerciseTerms.prune().hasData()) exerciseTerms = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSeller()!=null && getBuyerSeller().hasData()) return true;
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getObservationTerms()!=null && getObservationTerms().hasData()) return true;
			if (getSchedule()!=null && getSchedule().hasData()) return true;
			if (getDelivery()!=null && getDelivery().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getExerciseTerms()!=null && getExerciseTerms().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionPayout.OptionPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			OptionPayout.OptionPayoutBuilder o = (OptionPayout.OptionPayoutBuilder) other;
			
			merger.mergeRosetta(getBuyerSeller(), o.getBuyerSeller(), this::setBuyerSeller);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getObservationTerms(), o.getObservationTerms(), this::setObservationTerms);
			merger.mergeRosetta(getSchedule(), o.getSchedule(), this::setSchedule);
			merger.mergeRosetta(getDelivery(), o.getDelivery(), this::setDelivery);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getExerciseTerms(), o.getExerciseTerms(), this::setExerciseTerms);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionPayout _that = getType().cast(o);
		
			if (!Objects.equals(buyerSeller, _that.getBuyerSeller())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(observationTerms, _that.getObservationTerms())) return false;
			if (!Objects.equals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(delivery, _that.getDelivery())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseTerms, _that.getExerciseTerms())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSeller != null ? buyerSeller.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (observationTerms != null ? observationTerms.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (delivery != null ? delivery.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseTerms != null ? exerciseTerms.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionPayoutBuilder {" +
				"buyerSeller=" + this.buyerSeller + ", " +
				"feature=" + this.feature + ", " +
				"observationTerms=" + this.observationTerms + ", " +
				"schedule=" + this.schedule + ", " +
				"delivery=" + this.delivery + ", " +
				"underlier=" + this.underlier + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseTerms=" + this.exerciseTerms + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}
}
