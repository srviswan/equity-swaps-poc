package cdm.margin.schedule.validation.exists;

import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
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

public class StandardizedScheduleTradeInfoOnlyExistsValidator implements ValidatorWithArg<StandardizedScheduleTradeInfo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StandardizedScheduleTradeInfo> ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assetClass", ExistenceChecker.isSet((StandardizedScheduleAssetClassEnum) o.getAssetClass()))
				.put("productClass", ExistenceChecker.isSet((StandardizedScheduleProductClassEnum) o.getProductClass()))
				.put("grossInitialMargin", ExistenceChecker.isSet((Money) o.getGrossInitialMargin()))
				.put("markToMarketValue", ExistenceChecker.isSet((Money) o.getMarkToMarketValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StandardizedScheduleTradeInfo", ValidationType.ONLY_EXISTS, "StandardizedScheduleTradeInfo", path, "");
		}
		return failure("StandardizedScheduleTradeInfo", ValidationType.ONLY_EXISTS, "StandardizedScheduleTradeInfo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
