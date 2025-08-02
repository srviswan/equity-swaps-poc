package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
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

public class InstrumentOnlyExistsValidator implements ValidatorWithArg<Instrument, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Instrument> ValidationResult<Instrument> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ListedDerivative", ExistenceChecker.isSet((ListedDerivative) o.getListedDerivative()))
				.put("Loan", ExistenceChecker.isSet((Loan) o.getLoan()))
				.put("Security", ExistenceChecker.isSet((Security) o.getSecurity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Instrument", ValidationType.ONLY_EXISTS, "Instrument", path, "");
		}
		return failure("Instrument", ValidationType.ONLY_EXISTS, "Instrument", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
