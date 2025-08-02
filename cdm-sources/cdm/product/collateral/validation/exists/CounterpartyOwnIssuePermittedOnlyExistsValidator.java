package cdm.product.collateral.validation.exists;

import cdm.product.collateral.CounterpartyOwnIssuePermitted;
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

public class CounterpartyOwnIssuePermittedOnlyExistsValidator implements ValidatorWithArg<CounterpartyOwnIssuePermitted, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CounterpartyOwnIssuePermitted> ValidationResult<CounterpartyOwnIssuePermitted> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("counterpartyOwnIssuePermitted", ExistenceChecker.isSet((Boolean) o.getCounterpartyOwnIssuePermitted()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CounterpartyOwnIssuePermitted", ValidationType.ONLY_EXISTS, "CounterpartyOwnIssuePermitted", path, "");
		}
		return failure("CounterpartyOwnIssuePermitted", ValidationType.ONLY_EXISTS, "CounterpartyOwnIssuePermitted", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
