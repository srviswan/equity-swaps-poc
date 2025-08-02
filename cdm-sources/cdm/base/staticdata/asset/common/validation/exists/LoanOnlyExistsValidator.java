package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanOnlyExistsValidator implements ValidatorWithArg<Loan, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Loan> ValidationResult<Loan> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends AssetIdentifier>) o.getIdentifier()))
				.put("taxonomy", ExistenceChecker.isSet((List<? extends Taxonomy>) o.getTaxonomy()))
				.put("isExchangeListed", ExistenceChecker.isSet((Boolean) o.getIsExchangeListed()))
				.put("exchange", ExistenceChecker.isSet((LegalEntity) o.getExchange()))
				.put("relatedExchange", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getRelatedExchange()))
				.put("instrumentType", ExistenceChecker.isSet((InstrumentTypeEnum) o.getInstrumentType()))
				.put("borrower", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getBorrower()))
				.put("lien", ExistenceChecker.isSet((FieldWithMetaString) o.getLien()))
				.put("facilityType", ExistenceChecker.isSet((FieldWithMetaString) o.getFacilityType()))
				.put("creditAgreementDate", ExistenceChecker.isSet((Date) o.getCreditAgreementDate()))
				.put("tranche", ExistenceChecker.isSet((FieldWithMetaString) o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Loan", ValidationType.ONLY_EXISTS, "Loan", path, "");
		}
		return failure("Loan", ValidationType.ONLY_EXISTS, "Loan", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
