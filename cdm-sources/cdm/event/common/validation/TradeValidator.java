package cdm.event.common.validation;

import cdm.base.datetime.metafields.FieldWithMetaTimeZone;
import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.ContractDetails;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.product.collateral.Collateral;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeValidator implements Validator<Trade> {

	private List<ComparisonResult> getComparisonResults(Trade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("product", (NonTransferableProduct) o.getProduct() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeLot", (List<? extends TradeLot>) o.getTradeLot() == null ? 0 : o.getTradeLot().size(), 1, 0), 
				checkCardinality("counterparty", (List<? extends Counterparty>) o.getCounterparty() == null ? 0 : o.getCounterparty().size(), 2, 2), 
				checkCardinality("adjustment", (NotionalAdjustmentEnum) o.getAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeIdentifier", (List<? extends TradeIdentifier>) o.getTradeIdentifier() == null ? 0 : o.getTradeIdentifier().size(), 1, 0), 
				checkCardinality("tradeDate", (FieldWithMetaDate) o.getTradeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeTime", (FieldWithMetaTimeZone) o.getTradeTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDetails", (ExecutionDetails) o.getExecutionDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractDetails", (ContractDetails) o.getContractDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearedDate", (Date) o.getClearedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Trade", ValidationType.CARDINALITY, "Trade", path, "", error);
		}
		return success("Trade", ValidationType.CARDINALITY, "Trade", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Trade", ValidationType.CARDINALITY, "Trade", path, "", res.getError());
				}
				return success("Trade", ValidationType.CARDINALITY, "Trade", path, "");
			})
			.collect(toList());
	}

}
