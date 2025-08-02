package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.PutCallEnum;
import cdm.base.staticdata.party.LegalEntity;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ListedDerivativeValidator implements Validator<ListedDerivative> {

	private List<ComparisonResult> getComparisonResults(ListedDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends AssetIdentifier>) o.getIdentifier() == null ? 0 : o.getIdentifier().size(), 1, 0), 
				checkCardinality("isExchangeListed", (Boolean) o.getIsExchangeListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchange", (LegalEntity) o.getExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentType", (InstrumentTypeEnum) o.getInstrumentType() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryTerm", (String) o.getDeliveryTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ListedDerivative> validate(RosettaPath path, ListedDerivative o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ListedDerivative", ValidationType.CARDINALITY, "ListedDerivative", path, "", error);
		}
		return success("ListedDerivative", ValidationType.CARDINALITY, "ListedDerivative", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListedDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListedDerivative", ValidationType.CARDINALITY, "ListedDerivative", path, "", res.getError());
				}
				return success("ListedDerivative", ValidationType.CARDINALITY, "ListedDerivative", path, "");
			})
			.collect(toList());
	}

}
