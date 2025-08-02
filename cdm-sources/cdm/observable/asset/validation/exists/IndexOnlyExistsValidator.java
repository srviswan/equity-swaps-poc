package cdm.observable.asset.validation.exists;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
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

public class IndexOnlyExistsValidator implements ValidatorWithArg<Index, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Index> ValidationResult<Index> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("CreditIndex", ExistenceChecker.isSet((CreditIndex) o.getCreditIndex()))
				.put("EquityIndex", ExistenceChecker.isSet((EquityIndex) o.getEquityIndex()))
				.put("InterestRateIndex", ExistenceChecker.isSet((FieldWithMetaInterestRateIndex) o.getInterestRateIndex()))
				.put("ForeignExchangeRateIndex", ExistenceChecker.isSet((ForeignExchangeRateIndex) o.getForeignExchangeRateIndex()))
				.put("OtherIndex", ExistenceChecker.isSet((OtherIndex) o.getOtherIndex()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Index", ValidationType.ONLY_EXISTS, "Index", path, "");
		}
		return failure("Index", ValidationType.ONLY_EXISTS, "Index", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
