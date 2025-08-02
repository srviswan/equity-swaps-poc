package cdm.product.template.util;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.AssetPayout;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class PayoutDeepPathUtil {
	public PayerReceiver choosePayerReceiver(Payout payout) {
		final MapperS<AssetPayout> assetPayout = MapperS.of(payout).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		if (exists(assetPayout).getOrDefault(false)) {
			return assetPayout.<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).get();
		}
		final MapperS<CommodityPayout> commodityPayout = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout());
		if (exists(commodityPayout).getOrDefault(false)) {
			return commodityPayout.<PayerReceiver>map("getPayerReceiver", _commodityPayout -> _commodityPayout.getPayerReceiver()).get();
		}
		final MapperS<CreditDefaultPayout> creditDefaultPayout = MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout());
		if (exists(creditDefaultPayout).getOrDefault(false)) {
			return creditDefaultPayout.<PayerReceiver>map("getPayerReceiver", _creditDefaultPayout -> _creditDefaultPayout.getPayerReceiver()).get();
		}
		final MapperS<FixedPricePayout> fixedPricePayout = MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout());
		if (exists(fixedPricePayout).getOrDefault(false)) {
			return fixedPricePayout.<PayerReceiver>map("getPayerReceiver", _fixedPricePayout -> _fixedPricePayout.getPayerReceiver()).get();
		}
		final MapperS<InterestRatePayout> interestRatePayout = MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout());
		if (exists(interestRatePayout).getOrDefault(false)) {
			return interestRatePayout.<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).get();
		}
		final MapperS<OptionPayout> optionPayout = MapperS.of(payout).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout());
		if (exists(optionPayout).getOrDefault(false)) {
			return optionPayout.<PayerReceiver>map("getPayerReceiver", _optionPayout -> _optionPayout.getPayerReceiver()).get();
		}
		final MapperS<PerformancePayout> performancePayout = MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout());
		if (exists(performancePayout).getOrDefault(false)) {
			return performancePayout.<PayerReceiver>map("getPayerReceiver", _performancePayout -> _performancePayout.getPayerReceiver()).get();
		}
		final MapperS<SettlementPayout> settlementPayout = MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout());
		if (exists(settlementPayout).getOrDefault(false)) {
			return settlementPayout.<PayerReceiver>map("getPayerReceiver", _settlementPayout -> _settlementPayout.getPayerReceiver()).get();
		}
		return null;
	}
	
	public ResolvablePriceQuantity choosePriceQuantity(Payout payout) {
		final MapperS<AssetPayout> assetPayout = MapperS.of(payout).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		if (exists(assetPayout).getOrDefault(false)) {
			return assetPayout.<ResolvablePriceQuantity>map("getPriceQuantity", _assetPayout -> _assetPayout.getPriceQuantity()).get();
		}
		final MapperS<CommodityPayout> commodityPayout = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout());
		if (exists(commodityPayout).getOrDefault(false)) {
			return commodityPayout.<ResolvablePriceQuantity>map("getPriceQuantity", _commodityPayout -> _commodityPayout.getPriceQuantity()).get();
		}
		final MapperS<CreditDefaultPayout> creditDefaultPayout = MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout());
		if (exists(creditDefaultPayout).getOrDefault(false)) {
			return creditDefaultPayout.<ResolvablePriceQuantity>map("getPriceQuantity", _creditDefaultPayout -> _creditDefaultPayout.getPriceQuantity()).get();
		}
		final MapperS<FixedPricePayout> fixedPricePayout = MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout());
		if (exists(fixedPricePayout).getOrDefault(false)) {
			return fixedPricePayout.<ResolvablePriceQuantity>map("getPriceQuantity", _fixedPricePayout -> _fixedPricePayout.getPriceQuantity()).get();
		}
		final MapperS<InterestRatePayout> interestRatePayout = MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout());
		if (exists(interestRatePayout).getOrDefault(false)) {
			return interestRatePayout.<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).get();
		}
		final MapperS<OptionPayout> optionPayout = MapperS.of(payout).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout());
		if (exists(optionPayout).getOrDefault(false)) {
			return optionPayout.<ResolvablePriceQuantity>map("getPriceQuantity", _optionPayout -> _optionPayout.getPriceQuantity()).get();
		}
		final MapperS<PerformancePayout> performancePayout = MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout());
		if (exists(performancePayout).getOrDefault(false)) {
			return performancePayout.<ResolvablePriceQuantity>map("getPriceQuantity", _performancePayout -> _performancePayout.getPriceQuantity()).get();
		}
		final MapperS<SettlementPayout> settlementPayout = MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout());
		if (exists(settlementPayout).getOrDefault(false)) {
			return settlementPayout.<ResolvablePriceQuantity>map("getPriceQuantity", _settlementPayout -> _settlementPayout.getPriceQuantity()).get();
		}
		return null;
	}
	
	public SettlementTerms chooseSettlementTerms(Payout payout) {
		final MapperS<AssetPayout> assetPayout = MapperS.of(payout).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		if (exists(assetPayout).getOrDefault(false)) {
			return assetPayout.<SettlementTerms>map("getSettlementTerms", _assetPayout -> _assetPayout.getSettlementTerms()).get();
		}
		final MapperS<CommodityPayout> commodityPayout = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout());
		if (exists(commodityPayout).getOrDefault(false)) {
			return commodityPayout.<SettlementTerms>map("getSettlementTerms", _commodityPayout -> _commodityPayout.getSettlementTerms()).get();
		}
		final MapperS<CreditDefaultPayout> creditDefaultPayout = MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout());
		if (exists(creditDefaultPayout).getOrDefault(false)) {
			return creditDefaultPayout.<SettlementTerms>map("getSettlementTerms", _creditDefaultPayout -> _creditDefaultPayout.getSettlementTerms()).get();
		}
		final MapperS<FixedPricePayout> fixedPricePayout = MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout());
		if (exists(fixedPricePayout).getOrDefault(false)) {
			return fixedPricePayout.<SettlementTerms>map("getSettlementTerms", _fixedPricePayout -> _fixedPricePayout.getSettlementTerms()).get();
		}
		final MapperS<InterestRatePayout> interestRatePayout = MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout());
		if (exists(interestRatePayout).getOrDefault(false)) {
			return interestRatePayout.<SettlementTerms>map("getSettlementTerms", _interestRatePayout -> _interestRatePayout.getSettlementTerms()).get();
		}
		final MapperS<OptionPayout> optionPayout = MapperS.of(payout).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout());
		if (exists(optionPayout).getOrDefault(false)) {
			return optionPayout.<SettlementTerms>map("getSettlementTerms", _optionPayout -> _optionPayout.getSettlementTerms()).get();
		}
		final MapperS<PerformancePayout> performancePayout = MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout());
		if (exists(performancePayout).getOrDefault(false)) {
			return performancePayout.<SettlementTerms>map("getSettlementTerms", _performancePayout -> _performancePayout.getSettlementTerms()).get();
		}
		final MapperS<SettlementPayout> settlementPayout = MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout());
		if (exists(settlementPayout).getOrDefault(false)) {
			return settlementPayout.<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).get();
		}
		return null;
	}
	
	public PrincipalPayments choosePrincipalPayment(Payout payout) {
		final MapperS<AssetPayout> assetPayout = MapperS.of(payout).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		if (exists(assetPayout).getOrDefault(false)) {
			return assetPayout.<PrincipalPayments>map("getPrincipalPayment", _assetPayout -> _assetPayout.getPrincipalPayment()).get();
		}
		final MapperS<CommodityPayout> commodityPayout = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", _payout -> _payout.getCommodityPayout());
		if (exists(commodityPayout).getOrDefault(false)) {
			return commodityPayout.<PrincipalPayments>map("getPrincipalPayment", _commodityPayout -> _commodityPayout.getPrincipalPayment()).get();
		}
		final MapperS<CreditDefaultPayout> creditDefaultPayout = MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout());
		if (exists(creditDefaultPayout).getOrDefault(false)) {
			return creditDefaultPayout.<PrincipalPayments>map("getPrincipalPayment", _creditDefaultPayout -> _creditDefaultPayout.getPrincipalPayment()).get();
		}
		final MapperS<FixedPricePayout> fixedPricePayout = MapperS.of(payout).<FixedPricePayout>map("getFixedPricePayout", _payout -> _payout.getFixedPricePayout());
		if (exists(fixedPricePayout).getOrDefault(false)) {
			return fixedPricePayout.<PrincipalPayments>map("getPrincipalPayment", _fixedPricePayout -> _fixedPricePayout.getPrincipalPayment()).get();
		}
		final MapperS<InterestRatePayout> interestRatePayout = MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout());
		if (exists(interestRatePayout).getOrDefault(false)) {
			return interestRatePayout.<PrincipalPayments>map("getPrincipalPayment", _interestRatePayout -> _interestRatePayout.getPrincipalPayment()).get();
		}
		final MapperS<OptionPayout> optionPayout = MapperS.of(payout).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout());
		if (exists(optionPayout).getOrDefault(false)) {
			return optionPayout.<PrincipalPayments>map("getPrincipalPayment", _optionPayout -> _optionPayout.getPrincipalPayment()).get();
		}
		final MapperS<PerformancePayout> performancePayout = MapperS.of(payout).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout());
		if (exists(performancePayout).getOrDefault(false)) {
			return performancePayout.<PrincipalPayments>map("getPrincipalPayment", _performancePayout -> _performancePayout.getPrincipalPayment()).get();
		}
		final MapperS<SettlementPayout> settlementPayout = MapperS.of(payout).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout());
		if (exists(settlementPayout).getOrDefault(false)) {
			return settlementPayout.<PrincipalPayments>map("getPrincipalPayment", _settlementPayout -> _settlementPayout.getPrincipalPayment()).get();
		}
		return null;
	}
	
}
