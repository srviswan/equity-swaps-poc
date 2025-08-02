package cdm.product.common.settlement.validation;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.CashflowType;
import cdm.product.common.settlement.PaymentDiscounting;
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

public class CashflowValidator implements Validator<Cashflow> {

	private List<ComparisonResult> getComparisonResults(Cashflow o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quantity", (NonNegativeQuantity) o.getQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("asset", (Asset) o.getAsset() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (AdjustableOrAdjustedOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerReceiver", (PayerReceiver) o.getPayerReceiver() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashflowType", (CashflowType) o.getCashflowType() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDiscounting", (PaymentDiscounting) o.getPaymentDiscounting() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Cashflow> validate(RosettaPath path, Cashflow o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Cashflow", ValidationType.CARDINALITY, "Cashflow", path, "", error);
		}
		return success("Cashflow", ValidationType.CARDINALITY, "Cashflow", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cashflow o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cashflow", ValidationType.CARDINALITY, "Cashflow", path, "", res.getError());
				}
				return success("Cashflow", ValidationType.CARDINALITY, "Cashflow", path, "");
			})
			.collect(toList());
	}

}
