package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.PutCallEnum;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ListedDerivativeOnlyExistsValidator implements ValidatorWithArg<ListedDerivative, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ListedDerivative> ValidationResult<ListedDerivative> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends AssetIdentifier>) o.getIdentifier()))
				.put("taxonomy", ExistenceChecker.isSet((List<? extends Taxonomy>) o.getTaxonomy()))
				.put("isExchangeListed", ExistenceChecker.isSet((Boolean) o.getIsExchangeListed()))
				.put("exchange", ExistenceChecker.isSet((LegalEntity) o.getExchange()))
				.put("relatedExchange", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getRelatedExchange()))
				.put("instrumentType", ExistenceChecker.isSet((InstrumentTypeEnum) o.getInstrumentType()))
				.put("deliveryTerm", ExistenceChecker.isSet((String) o.getDeliveryTerm()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("strike", ExistenceChecker.isSet((BigDecimal) o.getStrike()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ListedDerivative", ValidationType.ONLY_EXISTS, "ListedDerivative", path, "");
		}
		return failure("ListedDerivative", ValidationType.ONLY_EXISTS, "ListedDerivative", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
