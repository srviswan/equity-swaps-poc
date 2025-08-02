package cdm.base.staticdata.asset.common.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(AssetIdentifierByType.AssetIdentifierByTypeDefault.class)
public abstract class AssetIdentifierByType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param identifiers 
	* @param idType 
	* @return filteredIdentifier 
	*/
	public List<? extends AssetIdentifier> evaluate(List<? extends AssetIdentifier> identifiers, AssetIdTypeEnum idType) {
		List<AssetIdentifier.AssetIdentifierBuilder> filteredIdentifierBuilder = doEvaluate(identifiers, idType);
		
		final List<? extends AssetIdentifier> filteredIdentifier;
		if (filteredIdentifierBuilder == null) {
			filteredIdentifier = null;
		} else {
			filteredIdentifier = filteredIdentifierBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, filteredIdentifier);
		}
		
		return filteredIdentifier;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(List<? extends AssetIdentifier> identifiers, AssetIdTypeEnum idType);

	public static class AssetIdentifierByTypeDefault extends AssetIdentifierByType {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(List<? extends AssetIdentifier> identifiers, AssetIdTypeEnum idType) {
			if (identifiers == null) {
				identifiers = Collections.emptyList();
			}
			List<AssetIdentifier.AssetIdentifierBuilder> filteredIdentifier = new ArrayList<>();
			return assignOutput(filteredIdentifier, identifiers, idType);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> filteredIdentifier, List<? extends AssetIdentifier> identifiers, AssetIdTypeEnum idType) {
			filteredIdentifier.addAll(toBuilder(MapperC.<AssetIdentifier>of(identifiers)
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(idType), CardinalityOperator.All).get()).getMulti()));
			
			return Optional.ofNullable(filteredIdentifier)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
