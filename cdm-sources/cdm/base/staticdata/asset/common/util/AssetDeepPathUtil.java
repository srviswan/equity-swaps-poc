package cdm.base.staticdata.asset.common.util;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class AssetDeepPathUtil {
	private final InstrumentDeepPathUtil instrumentDeepPathUtil;
	
	@Inject
	public AssetDeepPathUtil(InstrumentDeepPathUtil instrumentDeepPathUtil) {
		this.instrumentDeepPathUtil = instrumentDeepPathUtil;
	}
	
	public Boolean chooseIsExchangeListed(Asset asset) {
		final MapperS<Cash> cash = MapperS.of(asset).<Cash>map("getCash", _asset -> _asset.getCash());
		if (exists(cash).getOrDefault(false)) {
			return cash.<Boolean>map("getIsExchangeListed", _cash -> _cash.getIsExchangeListed()).get();
		}
		final MapperS<Commodity> commodity = MapperS.of(asset).<Commodity>map("getCommodity", _asset -> _asset.getCommodity());
		if (exists(commodity).getOrDefault(false)) {
			return commodity.<Boolean>map("getIsExchangeListed", _commodity -> _commodity.getIsExchangeListed()).get();
		}
		final MapperS<DigitalAsset> digitalAsset = MapperS.of(asset).<DigitalAsset>map("getDigitalAsset", _asset -> _asset.getDigitalAsset());
		if (exists(digitalAsset).getOrDefault(false)) {
			return digitalAsset.<Boolean>map("getIsExchangeListed", _digitalAsset -> _digitalAsset.getIsExchangeListed()).get();
		}
		final MapperS<Instrument> instrument = MapperS.of(asset).<Instrument>map("getInstrument", _asset -> _asset.getInstrument());
		if (exists(instrument).getOrDefault(false)) {
			return instrument.<Boolean>map("chooseIsExchangeListed", _instrument -> instrumentDeepPathUtil.chooseIsExchangeListed(_instrument)).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(Asset asset) {
		final MapperS<Cash> cash = MapperS.of(asset).<Cash>map("getCash", _asset -> _asset.getCash());
		if (exists(cash).getOrDefault(false)) {
			return cash.<AssetIdentifier>mapC("getIdentifier", _cash -> _cash.getIdentifier()).getMulti();
		}
		final MapperS<Commodity> commodity = MapperS.of(asset).<Commodity>map("getCommodity", _asset -> _asset.getCommodity());
		if (exists(commodity).getOrDefault(false)) {
			return commodity.<AssetIdentifier>mapC("getIdentifier", _commodity -> _commodity.getIdentifier()).getMulti();
		}
		final MapperS<DigitalAsset> digitalAsset = MapperS.of(asset).<DigitalAsset>map("getDigitalAsset", _asset -> _asset.getDigitalAsset());
		if (exists(digitalAsset).getOrDefault(false)) {
			return digitalAsset.<AssetIdentifier>mapC("getIdentifier", _digitalAsset -> _digitalAsset.getIdentifier()).getMulti();
		}
		final MapperS<Instrument> instrument = MapperS.of(asset).<Instrument>map("getInstrument", _asset -> _asset.getInstrument());
		if (exists(instrument).getOrDefault(false)) {
			return instrument.<AssetIdentifier>mapC("chooseIdentifier", _instrument -> instrumentDeepPathUtil.chooseIdentifier(_instrument)).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public List<LegalEntity> chooseRelatedExchange(Asset asset) {
		final MapperS<Cash> cash = MapperS.of(asset).<Cash>map("getCash", _asset -> _asset.getCash());
		if (exists(cash).getOrDefault(false)) {
			return cash.<LegalEntity>mapC("getRelatedExchange", _cash -> _cash.getRelatedExchange()).getMulti();
		}
		final MapperS<Commodity> commodity = MapperS.of(asset).<Commodity>map("getCommodity", _asset -> _asset.getCommodity());
		if (exists(commodity).getOrDefault(false)) {
			return commodity.<LegalEntity>mapC("getRelatedExchange", _commodity -> _commodity.getRelatedExchange()).getMulti();
		}
		final MapperS<DigitalAsset> digitalAsset = MapperS.of(asset).<DigitalAsset>map("getDigitalAsset", _asset -> _asset.getDigitalAsset());
		if (exists(digitalAsset).getOrDefault(false)) {
			return digitalAsset.<LegalEntity>mapC("getRelatedExchange", _digitalAsset -> _digitalAsset.getRelatedExchange()).getMulti();
		}
		final MapperS<Instrument> instrument = MapperS.of(asset).<Instrument>map("getInstrument", _asset -> _asset.getInstrument());
		if (exists(instrument).getOrDefault(false)) {
			return instrument.<LegalEntity>mapC("chooseRelatedExchange", _instrument -> instrumentDeepPathUtil.chooseRelatedExchange(_instrument)).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public LegalEntity chooseExchange(Asset asset) {
		final MapperS<Cash> cash = MapperS.of(asset).<Cash>map("getCash", _asset -> _asset.getCash());
		if (exists(cash).getOrDefault(false)) {
			return cash.<LegalEntity>map("getExchange", _cash -> _cash.getExchange()).get();
		}
		final MapperS<Commodity> commodity = MapperS.of(asset).<Commodity>map("getCommodity", _asset -> _asset.getCommodity());
		if (exists(commodity).getOrDefault(false)) {
			return commodity.<LegalEntity>map("getExchange", _commodity -> _commodity.getExchange()).get();
		}
		final MapperS<DigitalAsset> digitalAsset = MapperS.of(asset).<DigitalAsset>map("getDigitalAsset", _asset -> _asset.getDigitalAsset());
		if (exists(digitalAsset).getOrDefault(false)) {
			return digitalAsset.<LegalEntity>map("getExchange", _digitalAsset -> _digitalAsset.getExchange()).get();
		}
		final MapperS<Instrument> instrument = MapperS.of(asset).<Instrument>map("getInstrument", _asset -> _asset.getInstrument());
		if (exists(instrument).getOrDefault(false)) {
			return instrument.<LegalEntity>map("chooseExchange", _instrument -> instrumentDeepPathUtil.chooseExchange(_instrument)).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(Asset asset) {
		final MapperS<Cash> cash = MapperS.of(asset).<Cash>map("getCash", _asset -> _asset.getCash());
		if (exists(cash).getOrDefault(false)) {
			return cash.<Taxonomy>mapC("getTaxonomy", _cash -> _cash.getTaxonomy()).getMulti();
		}
		final MapperS<Commodity> commodity = MapperS.of(asset).<Commodity>map("getCommodity", _asset -> _asset.getCommodity());
		if (exists(commodity).getOrDefault(false)) {
			return commodity.<Taxonomy>mapC("getTaxonomy", _commodity -> _commodity.getTaxonomy()).getMulti();
		}
		final MapperS<DigitalAsset> digitalAsset = MapperS.of(asset).<DigitalAsset>map("getDigitalAsset", _asset -> _asset.getDigitalAsset());
		if (exists(digitalAsset).getOrDefault(false)) {
			return digitalAsset.<Taxonomy>mapC("getTaxonomy", _digitalAsset -> _digitalAsset.getTaxonomy()).getMulti();
		}
		final MapperS<Instrument> instrument = MapperS.of(asset).<Instrument>map("getInstrument", _asset -> _asset.getInstrument());
		if (exists(instrument).getOrDefault(false)) {
			return instrument.<Taxonomy>mapC("chooseTaxonomy", _instrument -> instrumentDeepPathUtil.chooseTaxonomy(_instrument)).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
}
