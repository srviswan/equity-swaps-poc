package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
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

public class InstrumentValidator implements Validator<Instrument> {

	private List<ComparisonResult> getComparisonResults(Instrument o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ListedDerivative", (ListedDerivative) o.getListedDerivative() != null ? 1 : 0, 0, 1), 
				checkCardinality("Loan", (Loan) o.getLoan() != null ? 1 : 0, 0, 1), 
				checkCardinality("Security", (Security) o.getSecurity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Instrument> validate(RosettaPath path, Instrument o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Instrument", ValidationType.CARDINALITY, "Instrument", path, "", error);
		}
		return success("Instrument", ValidationType.CARDINALITY, "Instrument", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Instrument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Instrument", ValidationType.CARDINALITY, "Instrument", path, "", res.getError());
				}
				return success("Instrument", ValidationType.CARDINALITY, "Instrument", path, "");
			})
			.collect(toList());
	}

}
