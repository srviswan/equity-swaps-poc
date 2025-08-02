package cdm.product.collateral.validation.datarule;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.ConcentrationLimitCriteria;
import cdm.product.collateral.ConcentrationLimitTypeEnum;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.functions.CriteriaMatchesAssetType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly")
@ImplementedBy(EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly.Default.class)
public interface EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly extends Validator<EligibleCollateralCriteria> {
	
	String NAME = "EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly";
	String DEFINITION = "if treatment -> concentrationLimit -> concentrationLimitCriteria -> concentrationLimitType only-element = ConcentrationLimitTypeEnum -> IssueOutstandingAmount then CriteriaMatchesAssetType(collateralCriteria, Debt) or ( treatment -> concentrationLimit extract CriteriaMatchesAssetType( item -> concentrationLimitCriteria -> collateralCriteria, Debt ) ) all = True";
	
	ValidationResult<EligibleCollateralCriteria> validate(RosettaPath path, EligibleCollateralCriteria eligibleCollateralCriteria);
	
	class Default implements EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly {
	
		@Inject protected CriteriaMatchesAssetType criteriaMatchesAssetType;
		
		@Override
		public ValidationResult<EligibleCollateralCriteria> validate(RosettaPath path, EligibleCollateralCriteria eligibleCollateralCriteria) {
			ComparisonResult result = executeDataRule(eligibleCollateralCriteria);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EligibleCollateralCriteria", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EligibleCollateralCriteria", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EligibleCollateralCriteria eligibleCollateralCriteria) {
			try {
				if (areEqual(MapperS.of(MapperS.of(eligibleCollateralCriteria).<CollateralTreatment>map("getTreatment", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getTreatment()).<ConcentrationLimit>mapC("getConcentrationLimit", collateralTreatment -> collateralTreatment.getConcentrationLimit()).<ConcentrationLimitCriteria>map("getConcentrationLimitCriteria", concentrationLimit -> concentrationLimit.getConcentrationLimitCriteria()).<ConcentrationLimitTypeEnum>map("getConcentrationLimitType", concentrationLimitCriteria -> concentrationLimitCriteria.getConcentrationLimitType()).get()), MapperS.of(ConcentrationLimitTypeEnum.ISSUE_OUTSTANDING_AMOUNT), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.of(MapperS.of(criteriaMatchesAssetType.evaluate(MapperS.of(eligibleCollateralCriteria).<CollateralCriteria>map("getCollateralCriteria", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getCollateralCriteria()).get(), InstrumentTypeEnum.DEBT))).or(areEqual(MapperS.of(eligibleCollateralCriteria).<CollateralTreatment>map("getTreatment", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getTreatment()).<ConcentrationLimit>mapC("getConcentrationLimit", collateralTreatment -> collateralTreatment.getConcentrationLimit())
						.mapItem(item -> MapperS.of(criteriaMatchesAssetType.evaluate(item.<ConcentrationLimitCriteria>map("getConcentrationLimitCriteria", concentrationLimit -> concentrationLimit.getConcentrationLimitCriteria()).<CollateralCriteria>map("getCollateralCriteria", concentrationLimitCriteria -> concentrationLimitCriteria.getCollateralCriteria()).get(), InstrumentTypeEnum.DEBT))), MapperS.of(true), CardinalityOperator.All));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EligibleCollateralCriteriaConcentrationLimitTypeIssueOSAmountDebtOnly {
	
		@Override
		public ValidationResult<EligibleCollateralCriteria> validate(RosettaPath path, EligibleCollateralCriteria eligibleCollateralCriteria) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EligibleCollateralCriteria", path, DEFINITION);
		}
	}
}
