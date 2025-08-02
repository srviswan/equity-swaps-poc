package cdm.observable.asset.validation.exists;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.InflationIndex;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InflationIndexOnlyExistsValidator implements ValidatorWithArg<InflationIndex, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InflationIndex> ValidationResult<InflationIndex> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends AssetIdentifier>) o.getIdentifier()))
				.put("taxonomy", ExistenceChecker.isSet((List<? extends Taxonomy>) o.getTaxonomy()))
				.put("isExchangeListed", ExistenceChecker.isSet((Boolean) o.getIsExchangeListed()))
				.put("exchange", ExistenceChecker.isSet((LegalEntity) o.getExchange()))
				.put("relatedExchange", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getRelatedExchange()))
				.put("name", ExistenceChecker.isSet((FieldWithMetaString) o.getName()))
				.put("provider", ExistenceChecker.isSet((LegalEntity) o.getProvider()))
				.put("assetClass", ExistenceChecker.isSet((AssetClassEnum) o.getAssetClass()))
				.put("inflationRateIndex", ExistenceChecker.isSet((FieldWithMetaInflationRateIndexEnum) o.getInflationRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((Period) o.getIndexTenor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InflationIndex", ValidationType.ONLY_EXISTS, "InflationIndex", path, "");
		}
		return failure("InflationIndex", ValidationType.ONLY_EXISTS, "InflationIndex", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
