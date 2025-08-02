package cdm.product.collateral.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.RatingPriorityResolutionEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EligibleCollateralCriteriaOnlyExistsValidator implements ValidatorWithArg<EligibleCollateralCriteria, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EligibleCollateralCriteria> ValidationResult<EligibleCollateralCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralCriteria", ExistenceChecker.isSet((CollateralCriteria) o.getCollateralCriteria()))
				.put("appliesTo", ExistenceChecker.isSet((List<CounterpartyRoleEnum>) o.getAppliesTo()))
				.put("restrictTo", ExistenceChecker.isSet((CollateralMarginTypeEnum) o.getRestrictTo()))
				.put("ratingPriorityResolution", ExistenceChecker.isSet((RatingPriorityResolutionEnum) o.getRatingPriorityResolution()))
				.put("treatment", ExistenceChecker.isSet((CollateralTreatment) o.getTreatment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EligibleCollateralCriteria", ValidationType.ONLY_EXISTS, "EligibleCollateralCriteria", path, "");
		}
		return failure("EligibleCollateralCriteria", ValidationType.ONLY_EXISTS, "EligibleCollateralCriteria", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
