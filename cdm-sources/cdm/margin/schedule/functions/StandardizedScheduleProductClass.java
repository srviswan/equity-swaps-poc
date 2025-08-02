package cdm.margin.schedule.functions;

import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquityForward;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnCorrelation_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnCorrelation;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(StandardizedScheduleProductClass.StandardizedScheduleProductClassDefault.class)
public abstract class StandardizedScheduleProductClass implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCreditNthToDefault isCreditNthToDefault;
	@Inject protected IsFXDeliverableOption isFXDeliverableOption;
	@Inject protected IsFXNonDeliverableOption isFXNonDeliverableOption;
	@Inject protected IsIRSwapWithCallableBermudanRightToEnterExitSwaps isIRSwapWithCallableBermudanRightToEnterExitSwaps;
	@Inject protected IsIRSwaptionStraddle isIRSwaptionStraddle;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_EquityForward qualify_BaseProduct_EquityForward;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_EquityOption_ParameterReturnCorrelation_Basket qualify_EquityOption_ParameterReturnCorrelation_Basket;
	@Inject protected Qualify_EquityOption_ParameterReturnDividend_Basket qualify_EquityOption_ParameterReturnDividend_Basket;
	@Inject protected Qualify_EquityOption_ParameterReturnDividend_Index qualify_EquityOption_ParameterReturnDividend_Index;
	@Inject protected Qualify_EquityOption_ParameterReturnDividend_SingleName qualify_EquityOption_ParameterReturnDividend_SingleName;
	@Inject protected Qualify_EquityOption_ParameterReturnVariance_Basket qualify_EquityOption_ParameterReturnVariance_Basket;
	@Inject protected Qualify_EquityOption_ParameterReturnVariance_Index qualify_EquityOption_ParameterReturnVariance_Index;
	@Inject protected Qualify_EquityOption_ParameterReturnVariance_SingleName qualify_EquityOption_ParameterReturnVariance_SingleName;
	@Inject protected Qualify_EquityOption_ParameterReturnVolatility_Basket qualify_EquityOption_ParameterReturnVolatility_Basket;
	@Inject protected Qualify_EquityOption_ParameterReturnVolatility_Index qualify_EquityOption_ParameterReturnVolatility_Index;
	@Inject protected Qualify_EquityOption_ParameterReturnVolatility_SingleName qualify_EquityOption_ParameterReturnVolatility_SingleName;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Basket qualify_EquityOption_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Index qualify_EquityOption_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_SingleName qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Basket qualify_EquitySwap_ParameterReturnDividend_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Index qualify_EquitySwap_ParameterReturnDividend_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_SingleName qualify_EquitySwap_ParameterReturnDividend_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Basket qualify_EquitySwap_ParameterReturnVariance_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Index qualify_EquitySwap_ParameterReturnVariance_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_SingleName qualify_EquitySwap_ParameterReturnVariance_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Basket qualify_EquitySwap_ParameterReturnVolatility_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Index qualify_EquitySwap_ParameterReturnVolatility_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_SingleName qualify_EquitySwap_ParameterReturnVolatility_SingleName;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_ParameterReturnCorrelation qualify_ForeignExchange_ParameterReturnCorrelation;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVariance qualify_ForeignExchange_ParameterReturnVariance;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVolatility qualify_ForeignExchange_ParameterReturnVolatility;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;

	/**
	* @param trade 
	* @return productClass 
	*/
	public StandardizedScheduleProductClassEnum evaluate(Trade trade) {
		StandardizedScheduleProductClassEnum productClass = doEvaluate(trade);
		
		return productClass;
	}

	protected abstract StandardizedScheduleProductClassEnum doEvaluate(Trade trade);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade);

	public static class StandardizedScheduleProductClassDefault extends StandardizedScheduleProductClass {
		@Override
		protected StandardizedScheduleProductClassEnum doEvaluate(Trade trade) {
			StandardizedScheduleProductClassEnum productClass = null;
			return assignOutput(productClass, trade);
		}
		
		protected StandardizedScheduleProductClassEnum assignOutput(StandardizedScheduleProductClassEnum productClass, Trade trade) {
			final Boolean boolean0 = isIRSwapWithCallableBermudanRightToEnterExitSwaps.evaluate(economicTerms(trade).get());
			if ((boolean0 == null ? false : boolean0)) {
				productClass = StandardizedScheduleProductClassEnum.SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS;
			} else {
				final Boolean boolean1 = qualify_BaseProduct_IRSwap.evaluate(economicTerms(trade).get());
				if ((boolean1 == null ? false : boolean1)) {
					productClass = StandardizedScheduleProductClassEnum.SWAP;
				} else {
					final Boolean boolean2 = qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(trade).get());
					if ((boolean2 == null ? false : boolean2)) {
						productClass = StandardizedScheduleProductClassEnum.CROSS_CURRENCY_SWAP;
					} else {
						final Boolean boolean3 = isIRSwaptionStraddle.evaluate(economicTerms(trade).get());
						if ((boolean3 == null ? false : boolean3)) {
							productClass = StandardizedScheduleProductClassEnum.SWAPTION_STRADDLE;
						} else {
							final Boolean boolean4 = qualify_InterestRate_Option_Swaption.evaluate(economicTerms(trade).get());
							if ((boolean4 == null ? false : boolean4)) {
								productClass = StandardizedScheduleProductClassEnum.SWAPTION;
							} else {
								final Boolean boolean5 = qualify_InterestRate_CapFloor.evaluate(economicTerms(trade).get());
								if ((boolean5 == null ? false : boolean5)) {
									productClass = StandardizedScheduleProductClassEnum.OPTION;
								} else {
									final Boolean boolean6 = qualify_InterestRate_Fra.evaluate(economicTerms(trade).get());
									if ((boolean6 == null ? false : boolean6)) {
										productClass = StandardizedScheduleProductClassEnum.FORWARD_RATE_AGREEMENT;
									} else {
										final Boolean boolean7 = qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(trade).get());
										if ((boolean7 == null ? false : boolean7)) {
											productClass = StandardizedScheduleProductClassEnum.SINGLE_NAME_CREDIT_DEFAULT_SWAP;
										} else {
											final Boolean boolean8 = qualify_CreditDefaultSwap_Index.evaluate(economicTerms(trade).get());
											if ((boolean8 == null ? false : boolean8)) {
												productClass = StandardizedScheduleProductClassEnum.INDEX_CDS;
											} else {
												final Boolean boolean9 = qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(trade).get());
												if ((boolean9 == null ? false : boolean9)) {
													productClass = StandardizedScheduleProductClassEnum.INDEX_TRANCHE;
												} else {
													final Boolean boolean10 = qualify_CreditDefaultSwaption.evaluate(economicTerms(trade).get());
													if ((boolean10 == null ? false : boolean10)) {
														productClass = StandardizedScheduleProductClassEnum.SWAPTION;
													} else {
														final Boolean boolean11 = isCreditNthToDefault.evaluate(economicTerms(trade).get());
														if ((boolean11 == null ? false : boolean11)) {
															productClass = StandardizedScheduleProductClassEnum.CREDIT_NTH_TO_DEFAULT;
														} else {
															final Boolean boolean12 = qualify_ForeignExchange_Swap.evaluate(economicTerms(trade).get());
															if ((boolean12 == null ? false : boolean12)) {
																productClass = StandardizedScheduleProductClassEnum.DELIVERABLE_SWAP;
															} else {
																final Boolean boolean13 = qualify_ForeignExchange_NDS.evaluate(economicTerms(trade).get());
																if ((boolean13 == null ? false : boolean13)) {
																	productClass = StandardizedScheduleProductClassEnum.NON_DELIVERABLE_CROSS_CURRENCY_SWAP;
																} else {
																	final Boolean boolean14 = qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(trade).get());
																	if ((boolean14 == null ? false : boolean14)) {
																		productClass = StandardizedScheduleProductClassEnum.DELIVERABLE_FORWARD;
																	} else {
																		final Boolean boolean15 = qualify_ForeignExchange_NDF.evaluate(economicTerms(trade).get());
																		if ((boolean15 == null ? false : boolean15)) {
																			productClass = StandardizedScheduleProductClassEnum.NON_DELIVERABLE_FORWARD;
																		} else {
																			final Boolean boolean16 = isFXDeliverableOption.evaluate(economicTerms(trade).get());
																			if ((boolean16 == null ? false : boolean16)) {
																				productClass = StandardizedScheduleProductClassEnum.DELIVERABLE_OPTION;
																			} else {
																				final Boolean boolean17 = isFXNonDeliverableOption.evaluate(economicTerms(trade).get());
																				if ((boolean17 == null ? false : boolean17)) {
																					productClass = StandardizedScheduleProductClassEnum.NON_DELIVERABLE_OPTION;
																				} else {
																					final Boolean boolean18 = qualify_ForeignExchange_ParameterReturnVariance.evaluate(economicTerms(trade).get());
																					if ((boolean18 == null ? false : boolean18)) {
																						productClass = StandardizedScheduleProductClassEnum.VARIANCE_SWAP;
																					} else {
																						final Boolean boolean19 = qualify_ForeignExchange_ParameterReturnVolatility.evaluate(economicTerms(trade).get());
																						if ((boolean19 == null ? false : boolean19)) {
																							productClass = StandardizedScheduleProductClassEnum.VOLATILITY_SWAP;
																						} else {
																							final Boolean boolean20 = qualify_ForeignExchange_ParameterReturnCorrelation.evaluate(economicTerms(trade).get());
																							if ((boolean20 == null ? false : boolean20)) {
																								productClass = StandardizedScheduleProductClassEnum.CORRELATION_SWAP;
																							} else if (ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_SingleName.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVolatility_Basket.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVolatility_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVolatility_SingleName.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVariance_Basket.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVariance_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnVariance_SingleName.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnCorrelation_Basket.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnDividend_Basket.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnDividend_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_ParameterReturnDividend_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																								productClass = StandardizedScheduleProductClassEnum.OPTION;
																							} else {
																								final Boolean boolean21 = qualify_BaseProduct_EquityForward.evaluate(economicTerms(trade).get());
																								if ((boolean21 == null ? false : boolean21)) {
																									productClass = StandardizedScheduleProductClassEnum.FORWARD;
																								} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																									productClass = StandardizedScheduleProductClassEnum.DIVIDEND_SWAP;
																								} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																									productClass = StandardizedScheduleProductClassEnum.VARIANCE_SWAP;
																								} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																									productClass = StandardizedScheduleProductClassEnum.VOLATILITY_SWAP;
																								} else {
																									final Boolean boolean22 = qualify_BaseProduct_EquitySwap.evaluate(economicTerms(trade).get());
																									if ((boolean22 == null ? false : boolean22)) {
																										productClass = StandardizedScheduleProductClassEnum.SWAPS_AND_PORTFOLIO_SWAPS;
																									} else {
																										final Boolean boolean23 = qualify_Commodity_Forward.evaluate(economicTerms(trade).get());
																										if ((boolean23 == null ? false : boolean23)) {
																											productClass = StandardizedScheduleProductClassEnum.FORWARD;
																										} else {
																											final Boolean boolean24 = qualify_Commodity_Option.evaluate(economicTerms(trade).get());
																											if ((boolean24 == null ? false : boolean24)) {
																												productClass = StandardizedScheduleProductClassEnum.OPTION;
																											} else {
																												final Boolean boolean25 = qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(trade).get());
																												if ((boolean25 == null ? false : boolean25)) {
																													productClass = StandardizedScheduleProductClassEnum.FIXED_FLOAT_SWAP;
																												} else {
																													final Boolean boolean26 = qualify_Commodity_Swap_Basis.evaluate(economicTerms(trade).get());
																													if ((boolean26 == null ? false : boolean26)) {
																														productClass = StandardizedScheduleProductClassEnum.BASIS_SWAP;
																													} else {
																														final Boolean boolean27 = qualify_Commodity_Swaption.evaluate(economicTerms(trade).get());
																														if ((boolean27 == null ? false : boolean27)) {
																															productClass = StandardizedScheduleProductClassEnum.SWAPTION;
																														} else {
																															productClass = null;
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			return productClass;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade) {
			return product(trade).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
	}
}
