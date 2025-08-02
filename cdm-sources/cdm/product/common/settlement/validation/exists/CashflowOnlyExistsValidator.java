package cdm.product.common.settlement.validation.exists;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.CashflowType;
import cdm.product.common.settlement.PaymentDiscounting;
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

public class CashflowOnlyExistsValidator implements ValidatorWithArg<Cashflow, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Cashflow> ValidationResult<Cashflow> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quantity", ExistenceChecker.isSet((NonNegativeQuantity) o.getQuantity()))
				.put("asset", ExistenceChecker.isSet((Asset) o.getAsset()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrAdjustedOrRelativeDate) o.getSettlementDate()))
				.put("payerReceiver", ExistenceChecker.isSet((PayerReceiver) o.getPayerReceiver()))
				.put("cashflowType", ExistenceChecker.isSet((CashflowType) o.getCashflowType()))
				.put("paymentDiscounting", ExistenceChecker.isSet((PaymentDiscounting) o.getPaymentDiscounting()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Cashflow", ValidationType.ONLY_EXISTS, "Cashflow", path, "");
		}
		return failure("Cashflow", ValidationType.ONLY_EXISTS, "Cashflow", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
