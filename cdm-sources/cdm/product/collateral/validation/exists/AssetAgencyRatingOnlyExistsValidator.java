package cdm.product.collateral.validation.exists;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AssetAgencyRating;
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

public class AssetAgencyRatingOnlyExistsValidator implements ValidatorWithArg<AssetAgencyRating, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetAgencyRating> ValidationResult<AssetAgencyRating> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assetAgencyRating", ExistenceChecker.isSet((AgencyRatingCriteria) o.getAssetAgencyRating()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetAgencyRating", ValidationType.ONLY_EXISTS, "AssetAgencyRating", path, "");
		}
		return failure("AssetAgencyRating", ValidationType.ONLY_EXISTS, "AssetAgencyRating", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
