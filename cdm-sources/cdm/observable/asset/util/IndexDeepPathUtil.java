package cdm.observable.asset.util;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class IndexDeepPathUtil {
	private final InterestRateIndexDeepPathUtil interestRateIndexDeepPathUtil;
	
	@Inject
	public IndexDeepPathUtil(InterestRateIndexDeepPathUtil interestRateIndexDeepPathUtil) {
		this.interestRateIndexDeepPathUtil = interestRateIndexDeepPathUtil;
	}
	
	public Boolean chooseIsExchangeListed(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<Boolean>map("getIsExchangeListed", _creditIndex -> _creditIndex.getIsExchangeListed()).get();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<Boolean>map("getIsExchangeListed", _equityIndex -> _equityIndex.getIsExchangeListed()).get();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<Boolean>map("chooseIsExchangeListed", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseIsExchangeListed(_interestRateIndex)).get();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<Boolean>map("getIsExchangeListed", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getIsExchangeListed()).get();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<Boolean>map("getIsExchangeListed", _otherIndex -> _otherIndex.getIsExchangeListed()).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<AssetIdentifier>mapC("getIdentifier", _creditIndex -> _creditIndex.getIdentifier()).getMulti();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<AssetIdentifier>mapC("getIdentifier", _equityIndex -> _equityIndex.getIdentifier()).getMulti();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<AssetIdentifier>mapC("chooseIdentifier", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseIdentifier(_interestRateIndex)).getMulti();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<AssetIdentifier>mapC("getIdentifier", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getIdentifier()).getMulti();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<AssetIdentifier>mapC("getIdentifier", _otherIndex -> _otherIndex.getIdentifier()).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public LegalEntity chooseProvider(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<LegalEntity>map("getProvider", _creditIndex -> _creditIndex.getProvider()).get();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<LegalEntity>map("getProvider", _equityIndex -> _equityIndex.getProvider()).get();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<LegalEntity>map("chooseProvider", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseProvider(_interestRateIndex)).get();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<LegalEntity>map("getProvider", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getProvider()).get();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<LegalEntity>map("getProvider", _otherIndex -> _otherIndex.getProvider()).get();
		}
		return null;
	}
	
	public List<LegalEntity> chooseRelatedExchange(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<LegalEntity>mapC("getRelatedExchange", _creditIndex -> _creditIndex.getRelatedExchange()).getMulti();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<LegalEntity>mapC("getRelatedExchange", _equityIndex -> _equityIndex.getRelatedExchange()).getMulti();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<LegalEntity>mapC("chooseRelatedExchange", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseRelatedExchange(_interestRateIndex)).getMulti();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<LegalEntity>mapC("getRelatedExchange", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getRelatedExchange()).getMulti();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<LegalEntity>mapC("getRelatedExchange", _otherIndex -> _otherIndex.getRelatedExchange()).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public FieldWithMetaString chooseName(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<FieldWithMetaString>map("getName", _creditIndex -> _creditIndex.getName()).get();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<FieldWithMetaString>map("getName", _equityIndex -> _equityIndex.getName()).get();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<FieldWithMetaString>map("chooseName", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseName(_interestRateIndex)).get();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<FieldWithMetaString>map("getName", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getName()).get();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<FieldWithMetaString>map("getName", _otherIndex -> _otherIndex.getName()).get();
		}
		return null;
	}
	
	public LegalEntity chooseExchange(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<LegalEntity>map("getExchange", _creditIndex -> _creditIndex.getExchange()).get();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<LegalEntity>map("getExchange", _equityIndex -> _equityIndex.getExchange()).get();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<LegalEntity>map("chooseExchange", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseExchange(_interestRateIndex)).get();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<LegalEntity>map("getExchange", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getExchange()).get();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<LegalEntity>map("getExchange", _otherIndex -> _otherIndex.getExchange()).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<Taxonomy>mapC("getTaxonomy", _creditIndex -> _creditIndex.getTaxonomy()).getMulti();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<Taxonomy>mapC("getTaxonomy", _equityIndex -> _equityIndex.getTaxonomy()).getMulti();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<Taxonomy>mapC("chooseTaxonomy", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseTaxonomy(_interestRateIndex)).getMulti();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<Taxonomy>mapC("getTaxonomy", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getTaxonomy()).getMulti();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<Taxonomy>mapC("getTaxonomy", _otherIndex -> _otherIndex.getTaxonomy()).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
	public AssetClassEnum chooseAssetClass(Index index) {
		final MapperS<CreditIndex> creditIndex = MapperS.of(index).<CreditIndex>map("getCreditIndex", _index -> _index.getCreditIndex());
		if (exists(creditIndex).getOrDefault(false)) {
			return creditIndex.<AssetClassEnum>map("getAssetClass", _creditIndex -> _creditIndex.getAssetClass()).get();
		}
		final MapperS<EquityIndex> equityIndex = MapperS.of(index).<EquityIndex>map("getEquityIndex", _index -> _index.getEquityIndex());
		if (exists(equityIndex).getOrDefault(false)) {
			return equityIndex.<AssetClassEnum>map("getAssetClass", _equityIndex -> _equityIndex.getAssetClass()).get();
		}
		final MapperS<FieldWithMetaInterestRateIndex> interestRateIndex = MapperS.of(index).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", _index -> _index.getInterestRateIndex());
		if (exists(interestRateIndex).getOrDefault(false)) {
			return interestRateIndex.<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex == null ? null : fieldWithMetaInterestRateIndex.getValue()).<AssetClassEnum>map("chooseAssetClass", _interestRateIndex -> interestRateIndexDeepPathUtil.chooseAssetClass(_interestRateIndex)).get();
		}
		final MapperS<ForeignExchangeRateIndex> foreignExchangeRateIndex = MapperS.of(index).<ForeignExchangeRateIndex>map("getForeignExchangeRateIndex", _index -> _index.getForeignExchangeRateIndex());
		if (exists(foreignExchangeRateIndex).getOrDefault(false)) {
			return foreignExchangeRateIndex.<AssetClassEnum>map("getAssetClass", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getAssetClass()).get();
		}
		final MapperS<OtherIndex> otherIndex = MapperS.of(index).<OtherIndex>map("getOtherIndex", _index -> _index.getOtherIndex());
		if (exists(otherIndex).getOrDefault(false)) {
			return otherIndex.<AssetClassEnum>map("getAssetClass", _otherIndex -> _otherIndex.getAssetClass()).get();
		}
		return null;
	}
	
}
