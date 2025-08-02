package cdm.product.template.validation.exists;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.AssetPayout;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
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

public class PayoutOnlyExistsValidator implements ValidatorWithArg<Payout, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Payout> ValidationResult<Payout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("AssetPayout", ExistenceChecker.isSet((AssetPayout) o.getAssetPayout()))
				.put("CommodityPayout", ExistenceChecker.isSet((CommodityPayout) o.getCommodityPayout()))
				.put("CreditDefaultPayout", ExistenceChecker.isSet((CreditDefaultPayout) o.getCreditDefaultPayout()))
				.put("FixedPricePayout", ExistenceChecker.isSet((FixedPricePayout) o.getFixedPricePayout()))
				.put("InterestRatePayout", ExistenceChecker.isSet((InterestRatePayout) o.getInterestRatePayout()))
				.put("OptionPayout", ExistenceChecker.isSet((OptionPayout) o.getOptionPayout()))
				.put("PerformancePayout", ExistenceChecker.isSet((PerformancePayout) o.getPerformancePayout()))
				.put("SettlementPayout", ExistenceChecker.isSet((SettlementPayout) o.getSettlementPayout()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Payout", ValidationType.ONLY_EXISTS, "Payout", path, "");
		}
		return failure("Payout", ValidationType.ONLY_EXISTS, "Payout", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
