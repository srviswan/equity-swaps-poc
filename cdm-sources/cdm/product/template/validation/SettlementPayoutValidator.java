package cdm.product.template.validation;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPayoutValidator implements Validator<SettlementPayout> {

	private List<ComparisonResult> getComparisonResults(SettlementPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiver", (PayerReceiver) o.getPayerReceiver() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceQuantity", (ResolvablePriceQuantity) o.getPriceQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalPayment", (PrincipalPayments) o.getPrincipalPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTerms", (SettlementTerms) o.getSettlementTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlier", (Underlier) o.getUnderlier() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryTerm", (String) o.getDeliveryTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("delivery", (AssetDeliveryInformation) o.getDelivery() != null ? 1 : 0, 0, 1), 
				checkCardinality("schedule", (CalculationSchedule) o.getSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPayout", ValidationType.CARDINALITY, "SettlementPayout", path, "", error);
		}
		return success("SettlementPayout", ValidationType.CARDINALITY, "SettlementPayout", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPayout", ValidationType.CARDINALITY, "SettlementPayout", path, "", res.getError());
				}
				return success("SettlementPayout", ValidationType.CARDINALITY, "SettlementPayout", path, "");
			})
			.collect(toList());
	}

}
