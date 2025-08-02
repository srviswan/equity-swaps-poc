package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ManualExercise;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("TradableProductExerciseNoticeReceiverPartyManual")
@ImplementedBy(TradableProductExerciseNoticeReceiverPartyManual.Default.class)
public interface TradableProductExerciseNoticeReceiverPartyManual extends Validator<TradableProduct> {
	
	String NAME = "TradableProductExerciseNoticeReceiverPartyManual";
	String DEFINITION = "if product -> economicTerms -> payout -> OptionPayout -> exerciseTerms -> exerciseProcedure -> manualExercise -> exerciseNotice -> exerciseNoticeReceiver exists then ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual and if ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual then product -> economicTerms -> payout -> OptionPayout -> exerciseTerms -> exerciseProcedure -> manualExercise -> exerciseNotice -> exerciseNoticeReceiver exists";
	
	ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct);
	
	class Default implements TradableProductExerciseNoticeReceiverPartyManual {
	
		@Override
		public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct) {
			ComparisonResult result = executeDataRule(tradableProduct);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
			try {
				if (exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<ExerciseProcedure>map("getExerciseProcedure", exerciseTerms -> exerciseTerms.getExerciseProcedure()).<ManualExercise>map("getManualExercise", exerciseProcedure -> exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL)).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<ExerciseProcedure>map("getExerciseProcedure", exerciseTerms -> exerciseTerms.getExerciseProcedure()).<ManualExercise>map("getManualExercise", exerciseProcedure -> exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", manualExercise -> manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver()));
					} else {
						ifThenElseResult = ComparisonResult.successEmptyOperand("");
					}
					return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL)).and(ifThenElseResult);
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductExerciseNoticeReceiverPartyManual {
	
		@Override
		public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION);
		}
	}
}
