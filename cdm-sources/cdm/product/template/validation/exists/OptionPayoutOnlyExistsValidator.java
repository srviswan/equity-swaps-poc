package cdm.product.template.validation.exists;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.OptionTypeEnum;
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

public class OptionPayoutOnlyExistsValidator implements ValidatorWithArg<OptionPayout, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionPayout> ValidationResult<OptionPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerReceiver", ExistenceChecker.isSet((PayerReceiver) o.getPayerReceiver()))
				.put("priceQuantity", ExistenceChecker.isSet((ResolvablePriceQuantity) o.getPriceQuantity()))
				.put("principalPayment", ExistenceChecker.isSet((PrincipalPayments) o.getPrincipalPayment()))
				.put("settlementTerms", ExistenceChecker.isSet((SettlementTerms) o.getSettlementTerms()))
				.put("buyerSeller", ExistenceChecker.isSet((BuyerSeller) o.getBuyerSeller()))
				.put("feature", ExistenceChecker.isSet((OptionFeature) o.getFeature()))
				.put("observationTerms", ExistenceChecker.isSet((ObservationTerms) o.getObservationTerms()))
				.put("schedule", ExistenceChecker.isSet((CalculationSchedule) o.getSchedule()))
				.put("delivery", ExistenceChecker.isSet((AssetDeliveryInformation) o.getDelivery()))
				.put("underlier", ExistenceChecker.isSet((Underlier) o.getUnderlier()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("exerciseTerms", ExistenceChecker.isSet((ExerciseTerms) o.getExerciseTerms()))
				.put("strike", ExistenceChecker.isSet((OptionStrike) o.getStrike()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionPayout", ValidationType.ONLY_EXISTS, "OptionPayout", path, "");
		}
		return failure("OptionPayout", ValidationType.ONLY_EXISTS, "OptionPayout", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
