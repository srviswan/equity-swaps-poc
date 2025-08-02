package cdm.product.collateral.validation.exists;

import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.NegativeCriteria;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NegativeCriteriaOnlyExistsValidator implements ValidatorWithArg<NegativeCriteria, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NegativeCriteria> ValidationResult<NegativeCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("negativeCriteria", ExistenceChecker.isSet((CollateralCriteria) o.getNegativeCriteria()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NegativeCriteria", ValidationType.ONLY_EXISTS, "NegativeCriteria", path, "");
		}
		return failure("NegativeCriteria", ValidationType.ONLY_EXISTS, "NegativeCriteria", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
