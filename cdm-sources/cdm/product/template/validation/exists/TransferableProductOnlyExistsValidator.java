package cdm.product.template.validation.exists;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.product.template.EconomicTerms;
import cdm.product.template.TransferableProduct;
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

public class TransferableProductOnlyExistsValidator implements ValidatorWithArg<TransferableProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TransferableProduct> ValidationResult<TransferableProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Cash", ExistenceChecker.isSet((Cash) o.getCash()))
				.put("Commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("DigitalAsset", ExistenceChecker.isSet((DigitalAsset) o.getDigitalAsset()))
				.put("Instrument", ExistenceChecker.isSet((Instrument) o.getInstrument()))
				.put("economicTerms", ExistenceChecker.isSet((EconomicTerms) o.getEconomicTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TransferableProduct", ValidationType.ONLY_EXISTS, "TransferableProduct", path, "");
		}
		return failure("TransferableProduct", ValidationType.ONLY_EXISTS, "TransferableProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
