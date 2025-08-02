package cdm.product.collateral.validation.exists;

import cdm.base.datetime.PeriodRange;
import cdm.base.staticdata.asset.common.MaturityTypeEnum;
import cdm.product.collateral.AssetMaturity;
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

public class AssetMaturityOnlyExistsValidator implements ValidatorWithArg<AssetMaturity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetMaturity> ValidationResult<AssetMaturity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("maturityType", ExistenceChecker.isSet((MaturityTypeEnum) o.getMaturityType()))
				.put("maturityRange", ExistenceChecker.isSet((PeriodRange) o.getMaturityRange()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetMaturity", ValidationType.ONLY_EXISTS, "AssetMaturity", path, "");
		}
		return failure("AssetMaturity", ValidationType.ONLY_EXISTS, "AssetMaturity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
