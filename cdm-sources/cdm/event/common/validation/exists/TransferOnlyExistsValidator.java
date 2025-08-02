package cdm.event.common.validation.exists;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.Reset;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
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

public class TransferOnlyExistsValidator implements ValidatorWithArg<Transfer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Transfer> ValidationResult<Transfer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quantity", ExistenceChecker.isSet((NonNegativeQuantity) o.getQuantity()))
				.put("asset", ExistenceChecker.isSet((Asset) o.getAsset()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrAdjustedOrRelativeDate) o.getSettlementDate()))
				.put("identifier", ExistenceChecker.isSet((List<? extends FieldWithMetaIdentifier>) o.getIdentifier()))
				.put("payerReceiver", ExistenceChecker.isSet((PartyReferencePayerReceiver) o.getPayerReceiver()))
				.put("settlementOrigin", ExistenceChecker.isSet((ReferenceWithMetaPayout) o.getSettlementOrigin()))
				.put("resetOrigin", ExistenceChecker.isSet((Reset) o.getResetOrigin()))
				.put("transferExpression", ExistenceChecker.isSet((TransferExpression) o.getTransferExpression()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Transfer", ValidationType.ONLY_EXISTS, "Transfer", path, "");
		}
		return failure("Transfer", ValidationType.ONLY_EXISTS, "Transfer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
