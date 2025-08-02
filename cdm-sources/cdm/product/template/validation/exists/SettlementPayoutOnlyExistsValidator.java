package cdm.product.template.validation.exists;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SettlementPayout;
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

public class SettlementPayoutOnlyExistsValidator implements ValidatorWithArg<SettlementPayout, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPayout> ValidationResult<SettlementPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerReceiver", ExistenceChecker.isSet((PayerReceiver) o.getPayerReceiver()))
				.put("priceQuantity", ExistenceChecker.isSet((ResolvablePriceQuantity) o.getPriceQuantity()))
				.put("principalPayment", ExistenceChecker.isSet((PrincipalPayments) o.getPrincipalPayment()))
				.put("settlementTerms", ExistenceChecker.isSet((SettlementTerms) o.getSettlementTerms()))
				.put("underlier", ExistenceChecker.isSet((Underlier) o.getUnderlier()))
				.put("deliveryTerm", ExistenceChecker.isSet((String) o.getDeliveryTerm()))
				.put("delivery", ExistenceChecker.isSet((AssetDeliveryInformation) o.getDelivery()))
				.put("schedule", ExistenceChecker.isSet((CalculationSchedule) o.getSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPayout", ValidationType.ONLY_EXISTS, "SettlementPayout", path, "");
		}
		return failure("SettlementPayout", ValidationType.ONLY_EXISTS, "SettlementPayout", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
