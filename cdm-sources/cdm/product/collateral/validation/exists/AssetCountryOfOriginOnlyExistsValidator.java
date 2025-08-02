package cdm.product.collateral.validation.exists;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.AssetCountryOfOrigin;
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

public class AssetCountryOfOriginOnlyExistsValidator implements ValidatorWithArg<AssetCountryOfOrigin, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetCountryOfOrigin> ValidationResult<AssetCountryOfOrigin> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assetCountryOfOrigin", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getAssetCountryOfOrigin()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetCountryOfOrigin", ValidationType.ONLY_EXISTS, "AssetCountryOfOrigin", path, "");
		}
		return failure("AssetCountryOfOrigin", ValidationType.ONLY_EXISTS, "AssetCountryOfOrigin", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
