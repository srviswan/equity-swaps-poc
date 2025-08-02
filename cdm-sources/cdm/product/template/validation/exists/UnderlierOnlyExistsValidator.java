package cdm.product.template.validation.exists;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
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

public class UnderlierOnlyExistsValidator implements ValidatorWithArg<Underlier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Underlier> ValidationResult<Underlier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Observable", ExistenceChecker.isSet((ReferenceWithMetaObservable) o.getObservable()))
				.put("Product", ExistenceChecker.isSet((Product) o.getProduct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Underlier", ValidationType.ONLY_EXISTS, "Underlier", path, "");
		}
		return failure("Underlier", ValidationType.ONLY_EXISTS, "Underlier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
