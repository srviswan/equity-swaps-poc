package cdm.margin.schedule.validation.exists;

import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StandardizedScheduleInitialMarginOnlyExistsValidator implements ValidatorWithArg<StandardizedScheduleInitialMargin, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StandardizedScheduleInitialMargin> ValidationResult<StandardizedScheduleInitialMargin> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeInfo", ExistenceChecker.isSet((List<? extends StandardizedScheduleTradeInfo>) o.getTradeInfo()))
				.put("netInitialMargin", ExistenceChecker.isSet((Money) o.getNetInitialMargin()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StandardizedScheduleInitialMargin", ValidationType.ONLY_EXISTS, "StandardizedScheduleInitialMargin", path, "");
		}
		return failure("StandardizedScheduleInitialMargin", ValidationType.ONLY_EXISTS, "StandardizedScheduleInitialMargin", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
