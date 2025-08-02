package cdm.observable.asset.util;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class InterestRateIndexDeepPathUtil {
	public Boolean chooseIsExchangeListed(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<Boolean>map("getIsExchangeListed", _floatingRateIndex -> _floatingRateIndex.getIsExchangeListed()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Boolean>map("getIsExchangeListed", _inflationIndex -> _inflationIndex.getIsExchangeListed()).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<AssetIdentifier>mapC("getIdentifier", _floatingRateIndex -> _floatingRateIndex.getIdentifier()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<AssetIdentifier>mapC("getIdentifier", _inflationIndex -> _inflationIndex.getIdentifier()).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public LegalEntity chooseProvider(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<LegalEntity>map("getProvider", _floatingRateIndex -> _floatingRateIndex.getProvider()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>map("getProvider", _inflationIndex -> _inflationIndex.getProvider()).get();
		}
		return null;
	}
	
	public List<LegalEntity> chooseRelatedExchange(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<LegalEntity>mapC("getRelatedExchange", _floatingRateIndex -> _floatingRateIndex.getRelatedExchange()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>mapC("getRelatedExchange", _inflationIndex -> _inflationIndex.getRelatedExchange()).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public FieldWithMetaString chooseName(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<FieldWithMetaString>map("getName", _floatingRateIndex -> _floatingRateIndex.getName()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<FieldWithMetaString>map("getName", _inflationIndex -> _inflationIndex.getName()).get();
		}
		return null;
	}
	
	public Period chooseIndexTenor(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Period>map("getIndexTenor", _inflationIndex -> _inflationIndex.getIndexTenor()).get();
		}
		return null;
	}
	
	public LegalEntity chooseExchange(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<LegalEntity>map("getExchange", _floatingRateIndex -> _floatingRateIndex.getExchange()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<LegalEntity>map("getExchange", _inflationIndex -> _inflationIndex.getExchange()).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<Taxonomy>mapC("getTaxonomy", _floatingRateIndex -> _floatingRateIndex.getTaxonomy()).getMulti();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<Taxonomy>mapC("getTaxonomy", _inflationIndex -> _inflationIndex.getTaxonomy()).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
	public AssetClassEnum chooseAssetClass(InterestRateIndex interestRateIndex) {
		final MapperS<FloatingRateIndex> floatingRateIndex = MapperS.of(interestRateIndex).<FloatingRateIndex>map("getFloatingRateIndex", _interestRateIndex -> _interestRateIndex.getFloatingRateIndex());
		if (exists(floatingRateIndex).getOrDefault(false)) {
			return floatingRateIndex.<AssetClassEnum>map("getAssetClass", _floatingRateIndex -> _floatingRateIndex.getAssetClass()).get();
		}
		final MapperS<InflationIndex> inflationIndex = MapperS.of(interestRateIndex).<InflationIndex>map("getInflationIndex", _interestRateIndex -> _interestRateIndex.getInflationIndex());
		if (exists(inflationIndex).getOrDefault(false)) {
			return inflationIndex.<AssetClassEnum>map("getAssetClass", _inflationIndex -> _inflationIndex.getAssetClass()).get();
		}
		return null;
	}
	
}
