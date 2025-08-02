package cdm.margin.schedule.validation;

import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
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

public class StandardizedScheduleTradeInfoValidator implements Validator<StandardizedScheduleTradeInfo> {

	private List<ComparisonResult> getComparisonResults(StandardizedScheduleTradeInfo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("assetClass", (StandardizedScheduleAssetClassEnum) o.getAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("productClass", (StandardizedScheduleProductClassEnum) o.getProductClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("grossInitialMargin", (Money) o.getGrossInitialMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("markToMarketValue", (Money) o.getMarkToMarketValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StandardizedScheduleTradeInfo", ValidationType.CARDINALITY, "StandardizedScheduleTradeInfo", path, "", error);
		}
		return success("StandardizedScheduleTradeInfo", ValidationType.CARDINALITY, "StandardizedScheduleTradeInfo", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardizedScheduleTradeInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StandardizedScheduleTradeInfo", ValidationType.CARDINALITY, "StandardizedScheduleTradeInfo", path, "", res.getError());
				}
				return success("StandardizedScheduleTradeInfo", ValidationType.CARDINALITY, "StandardizedScheduleTradeInfo", path, "");
			})
			.collect(toList());
	}

}
