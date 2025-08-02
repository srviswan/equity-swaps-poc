package cdm.product.template;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
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
import cdm.product.template.AssetLeg;
import cdm.product.template.AssetLeg.AssetLegBuilder;
import cdm.product.template.AssetPayout;
import cdm.product.template.AssetPayout.AssetPayoutBuilder;
import cdm.product.template.AssetPayout.AssetPayoutBuilderImpl;
import cdm.product.template.AssetPayout.AssetPayoutImpl;
import cdm.product.template.AssetPayoutTradeTypeEnum;
import cdm.product.template.DividendTerms;
import cdm.product.template.DividendTerms.DividendTermsBuilder;
import cdm.product.template.meta.AssetPayoutMeta;
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
 * Security finance payout specification in case the product payout involves some form of security collateral, as in a securities financing transaction. Plus additional description for ICMA.
 * @version 6.0.0
 */
@RosettaDataType(value="AssetPayout", builder=AssetPayout.AssetPayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetPayout", model="Just another Rosetta model", builder=AssetPayout.AssetPayoutBuilderImpl.class, version="6.0.0")
public interface AssetPayout extends PayoutBase {

	AssetPayoutMeta metaData = new AssetPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines each asset movement as a buy/sell at different dates, typically 1 near leg and 1 far leg in a securities financing transaction.
	 */
	List<? extends AssetLeg> getAssetLeg();
	/**
	 * Specifies the Purchased Asset, usually a Security.
	 */
	Asset getUnderlier();
	/**
	 * A contractual minimum amount which the borrower will pay, regardless of the duration of the loan. A mechanism for making sure that a trade generates enough income.
	 */
	Money getMinimumFee();
	/**
	 * Specifies the terms under which dividends received by the borrower are passed through to the lender.
	 */
	DividendTerms getDividendTerms();
	/**
	 * The trade type, eg repurchase transaction or buy/sell-back.
	 */
	AssetPayoutTradeTypeEnum getTradeType();

	/*********************** Build Methods  ***********************/
	AssetPayout build();
	
	AssetPayout.AssetPayoutBuilder toBuilder();
	
	static AssetPayout.AssetPayoutBuilder builder() {
		return new AssetPayout.AssetPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetPayout> getType() {
		return AssetPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("assetLeg"), processor, AssetLeg.class, getAssetLeg());
		processRosetta(path.newSubPath("underlier"), processor, Asset.class, getUnderlier());
		processRosetta(path.newSubPath("minimumFee"), processor, Money.class, getMinimumFee());
		processRosetta(path.newSubPath("dividendTerms"), processor, DividendTerms.class, getDividendTerms());
		processor.processBasic(path.newSubPath("tradeType"), AssetPayoutTradeTypeEnum.class, getTradeType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetPayoutBuilder extends AssetPayout, PayoutBase.PayoutBaseBuilder {
		AssetLeg.AssetLegBuilder getOrCreateAssetLeg(int _index);
		@Override
		List<? extends AssetLeg.AssetLegBuilder> getAssetLeg();
		Asset.AssetBuilder getOrCreateUnderlier();
		@Override
		Asset.AssetBuilder getUnderlier();
		Money.MoneyBuilder getOrCreateMinimumFee();
		@Override
		Money.MoneyBuilder getMinimumFee();
		DividendTerms.DividendTermsBuilder getOrCreateDividendTerms();
		@Override
		DividendTerms.DividendTermsBuilder getDividendTerms();
		@Override
		AssetPayout.AssetPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		@Override
		AssetPayout.AssetPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		@Override
		AssetPayout.AssetPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		@Override
		AssetPayout.AssetPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		AssetPayout.AssetPayoutBuilder addAssetLeg(AssetLeg assetLeg);
		AssetPayout.AssetPayoutBuilder addAssetLeg(AssetLeg assetLeg, int _idx);
		AssetPayout.AssetPayoutBuilder addAssetLeg(List<? extends AssetLeg> assetLeg);
		AssetPayout.AssetPayoutBuilder setAssetLeg(List<? extends AssetLeg> assetLeg);
		AssetPayout.AssetPayoutBuilder setUnderlier(Asset underlier);
		AssetPayout.AssetPayoutBuilder setMinimumFee(Money minimumFee);
		AssetPayout.AssetPayoutBuilder setDividendTerms(DividendTerms dividendTerms);
		AssetPayout.AssetPayoutBuilder setTradeType(AssetPayoutTradeTypeEnum tradeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("assetLeg"), processor, AssetLeg.AssetLegBuilder.class, getAssetLeg());
			processRosetta(path.newSubPath("underlier"), processor, Asset.AssetBuilder.class, getUnderlier());
			processRosetta(path.newSubPath("minimumFee"), processor, Money.MoneyBuilder.class, getMinimumFee());
			processRosetta(path.newSubPath("dividendTerms"), processor, DividendTerms.DividendTermsBuilder.class, getDividendTerms());
			processor.processBasic(path.newSubPath("tradeType"), AssetPayoutTradeTypeEnum.class, getTradeType(), this);
		}
		

		AssetPayout.AssetPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of AssetPayout  ***********************/
	class AssetPayoutImpl extends PayoutBase.PayoutBaseImpl implements AssetPayout {
		private final List<? extends AssetLeg> assetLeg;
		private final Asset underlier;
		private final Money minimumFee;
		private final DividendTerms dividendTerms;
		private final AssetPayoutTradeTypeEnum tradeType;
		
		protected AssetPayoutImpl(AssetPayout.AssetPayoutBuilder builder) {
			super(builder);
			this.assetLeg = ofNullable(builder.getAssetLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
			this.minimumFee = ofNullable(builder.getMinimumFee()).map(f->f.build()).orElse(null);
			this.dividendTerms = ofNullable(builder.getDividendTerms()).map(f->f.build()).orElse(null);
			this.tradeType = builder.getTradeType();
		}
		
		@Override
		@RosettaAttribute("assetLeg")
		@RuneAttribute("assetLeg")
		public List<? extends AssetLeg> getAssetLeg() {
			return assetLeg;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public Asset getUnderlier() {
			return underlier;
		}
		
		@Override
		@RosettaAttribute("minimumFee")
		@RuneAttribute("minimumFee")
		public Money getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		@RosettaAttribute("dividendTerms")
		@RuneAttribute("dividendTerms")
		public DividendTerms getDividendTerms() {
			return dividendTerms;
		}
		
		@Override
		@RosettaAttribute("tradeType")
		@RuneAttribute("tradeType")
		public AssetPayoutTradeTypeEnum getTradeType() {
			return tradeType;
		}
		
		@Override
		public AssetPayout build() {
			return this;
		}
		
		@Override
		public AssetPayout.AssetPayoutBuilder toBuilder() {
			AssetPayout.AssetPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetPayout.AssetPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAssetLeg()).ifPresent(builder::setAssetLeg);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
			ofNullable(getMinimumFee()).ifPresent(builder::setMinimumFee);
			ofNullable(getDividendTerms()).ifPresent(builder::setDividendTerms);
			ofNullable(getTradeType()).ifPresent(builder::setTradeType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetPayout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assetLeg, _that.getAssetLeg())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!Objects.equals(dividendTerms, _that.getDividendTerms())) return false;
			if (!Objects.equals(tradeType, _that.getTradeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (assetLeg != null ? assetLeg.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (dividendTerms != null ? dividendTerms.hashCode() : 0);
			_result = 31 * _result + (tradeType != null ? tradeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPayout {" +
				"assetLeg=" + this.assetLeg + ", " +
				"underlier=" + this.underlier + ", " +
				"minimumFee=" + this.minimumFee + ", " +
				"dividendTerms=" + this.dividendTerms + ", " +
				"tradeType=" + this.tradeType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AssetPayout  ***********************/
	class AssetPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl implements AssetPayout.AssetPayoutBuilder {
	
		protected List<AssetLeg.AssetLegBuilder> assetLeg = new ArrayList<>();
		protected Asset.AssetBuilder underlier;
		protected Money.MoneyBuilder minimumFee;
		protected DividendTerms.DividendTermsBuilder dividendTerms;
		protected AssetPayoutTradeTypeEnum tradeType;
		
		@Override
		@RosettaAttribute("assetLeg")
		@RuneAttribute("assetLeg")
		public List<? extends AssetLeg.AssetLegBuilder> getAssetLeg() {
			return assetLeg;
		}
		
		@Override
		public AssetLeg.AssetLegBuilder getOrCreateAssetLeg(int _index) {
		
			if (assetLeg==null) {
				this.assetLeg = new ArrayList<>();
			}
			AssetLeg.AssetLegBuilder result;
			return getIndex(assetLeg, _index, () -> {
						AssetLeg.AssetLegBuilder newAssetLeg = AssetLeg.builder();
						return newAssetLeg;
					});
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public Asset.AssetBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlier() {
			Asset.AssetBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumFee")
		@RuneAttribute("minimumFee")
		public Money.MoneyBuilder getMinimumFee() {
			return minimumFee;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumFee() {
			Money.MoneyBuilder result;
			if (minimumFee!=null) {
				result = minimumFee;
			}
			else {
				result = minimumFee = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendTerms")
		@RuneAttribute("dividendTerms")
		public DividendTerms.DividendTermsBuilder getDividendTerms() {
			return dividendTerms;
		}
		
		@Override
		public DividendTerms.DividendTermsBuilder getOrCreateDividendTerms() {
			DividendTerms.DividendTermsBuilder result;
			if (dividendTerms!=null) {
				result = dividendTerms;
			}
			else {
				result = dividendTerms = DividendTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeType")
		@RuneAttribute("tradeType")
		public AssetPayoutTradeTypeEnum getTradeType() {
			return tradeType;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public AssetPayout.AssetPayoutBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public AssetPayout.AssetPayoutBuilder setPriceQuantity(ResolvablePriceQuantity _priceQuantity) {
			this.priceQuantity = _priceQuantity == null ? null : _priceQuantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("principalPayment")
		@RuneAttribute("principalPayment")
		public AssetPayout.AssetPayoutBuilder setPrincipalPayment(PrincipalPayments _principalPayment) {
			this.principalPayment = _principalPayment == null ? null : _principalPayment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@RuneAttribute("settlementTerms")
		public AssetPayout.AssetPayoutBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetLeg")
		@RuneAttribute("assetLeg")
		public AssetPayout.AssetPayoutBuilder addAssetLeg(AssetLeg _assetLeg) {
			if (_assetLeg != null) {
				this.assetLeg.add(_assetLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetPayout.AssetPayoutBuilder addAssetLeg(AssetLeg _assetLeg, int _idx) {
			getIndex(this.assetLeg, _idx, () -> _assetLeg.toBuilder());
			return this;
		}
		
		@Override 
		public AssetPayout.AssetPayoutBuilder addAssetLeg(List<? extends AssetLeg> assetLegs) {
			if (assetLegs != null) {
				for (final AssetLeg toAdd : assetLegs) {
					this.assetLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("assetLeg")
		public AssetPayout.AssetPayoutBuilder setAssetLeg(List<? extends AssetLeg> assetLegs) {
			if (assetLegs == null) {
				this.assetLeg = new ArrayList<>();
			} else {
				this.assetLeg = assetLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("underlier")
		@RuneAttribute("underlier")
		public AssetPayout.AssetPayoutBuilder setUnderlier(Asset _underlier) {
			this.underlier = _underlier == null ? null : _underlier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("minimumFee")
		@RuneAttribute("minimumFee")
		public AssetPayout.AssetPayoutBuilder setMinimumFee(Money _minimumFee) {
			this.minimumFee = _minimumFee == null ? null : _minimumFee.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("dividendTerms")
		@RuneAttribute("dividendTerms")
		public AssetPayout.AssetPayoutBuilder setDividendTerms(DividendTerms _dividendTerms) {
			this.dividendTerms = _dividendTerms == null ? null : _dividendTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeType")
		@RuneAttribute("tradeType")
		public AssetPayout.AssetPayoutBuilder setTradeType(AssetPayoutTradeTypeEnum _tradeType) {
			this.tradeType = _tradeType == null ? null : _tradeType;
			return this;
		}
		
		@Override
		public AssetPayout build() {
			return new AssetPayout.AssetPayoutImpl(this);
		}
		
		@Override
		public AssetPayout.AssetPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPayout.AssetPayoutBuilder prune() {
			super.prune();
			assetLeg = assetLeg.stream().filter(b->b!=null).<AssetLeg.AssetLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			if (minimumFee!=null && !minimumFee.prune().hasData()) minimumFee = null;
			if (dividendTerms!=null && !dividendTerms.prune().hasData()) dividendTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAssetLeg()!=null && getAssetLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			if (getMinimumFee()!=null && getMinimumFee().hasData()) return true;
			if (getDividendTerms()!=null && getDividendTerms().hasData()) return true;
			if (getTradeType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPayout.AssetPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AssetPayout.AssetPayoutBuilder o = (AssetPayout.AssetPayoutBuilder) other;
			
			merger.mergeRosetta(getAssetLeg(), o.getAssetLeg(), this::getOrCreateAssetLeg);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			merger.mergeRosetta(getMinimumFee(), o.getMinimumFee(), this::setMinimumFee);
			merger.mergeRosetta(getDividendTerms(), o.getDividendTerms(), this::setDividendTerms);
			
			merger.mergeBasic(getTradeType(), o.getTradeType(), this::setTradeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetPayout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assetLeg, _that.getAssetLeg())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			if (!Objects.equals(minimumFee, _that.getMinimumFee())) return false;
			if (!Objects.equals(dividendTerms, _that.getDividendTerms())) return false;
			if (!Objects.equals(tradeType, _that.getTradeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (assetLeg != null ? assetLeg.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			_result = 31 * _result + (minimumFee != null ? minimumFee.hashCode() : 0);
			_result = 31 * _result + (dividendTerms != null ? dividendTerms.hashCode() : 0);
			_result = 31 * _result + (tradeType != null ? tradeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPayoutBuilder {" +
				"assetLeg=" + this.assetLeg + ", " +
				"underlier=" + this.underlier + ", " +
				"minimumFee=" + this.minimumFee + ", " +
				"dividendTerms=" + this.dividendTerms + ", " +
				"tradeType=" + this.tradeType +
			'}' + " " + super.toString();
		}
	}
}
