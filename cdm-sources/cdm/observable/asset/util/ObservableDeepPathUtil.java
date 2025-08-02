package cdm.observable.asset.util;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.util.AssetDeepPathUtil;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class ObservableDeepPathUtil {
	private final IndexDeepPathUtil indexDeepPathUtil;
	private final AssetDeepPathUtil assetDeepPathUtil;
	
	@Inject
	public ObservableDeepPathUtil(IndexDeepPathUtil indexDeepPathUtil, AssetDeepPathUtil assetDeepPathUtil) {
		this.indexDeepPathUtil = indexDeepPathUtil;
		this.assetDeepPathUtil = assetDeepPathUtil;
	}
	
	public Boolean chooseIsExchangeListed(Observable observable) {
		final MapperS<Asset> asset = MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset());
		if (exists(asset).getOrDefault(false)) {
			return asset.<Boolean>map("chooseIsExchangeListed", _asset -> assetDeepPathUtil.chooseIsExchangeListed(_asset)).get();
		}
		final MapperS<Basket> basket = MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<Boolean>map("getIsExchangeListed", _basket -> _basket.getIsExchangeListed()).get();
		}
		final MapperS<Index> index = MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex());
		if (exists(index).getOrDefault(false)) {
			return index.<Boolean>map("chooseIsExchangeListed", _index -> indexDeepPathUtil.chooseIsExchangeListed(_index)).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(Observable observable) {
		final MapperS<Asset> asset = MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset());
		if (exists(asset).getOrDefault(false)) {
			return asset.<AssetIdentifier>mapC("chooseIdentifier", _asset -> assetDeepPathUtil.chooseIdentifier(_asset)).getMulti();
		}
		final MapperS<Basket> basket = MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<AssetIdentifier>mapC("getIdentifier", _basket -> _basket.getIdentifier()).getMulti();
		}
		final MapperS<Index> index = MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex());
		if (exists(index).getOrDefault(false)) {
			return index.<AssetIdentifier>mapC("chooseIdentifier", _index -> indexDeepPathUtil.chooseIdentifier(_index)).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public List<LegalEntity> chooseRelatedExchange(Observable observable) {
		final MapperS<Asset> asset = MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset());
		if (exists(asset).getOrDefault(false)) {
			return asset.<LegalEntity>mapC("chooseRelatedExchange", _asset -> assetDeepPathUtil.chooseRelatedExchange(_asset)).getMulti();
		}
		final MapperS<Basket> basket = MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<LegalEntity>mapC("getRelatedExchange", _basket -> _basket.getRelatedExchange()).getMulti();
		}
		final MapperS<Index> index = MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex());
		if (exists(index).getOrDefault(false)) {
			return index.<LegalEntity>mapC("chooseRelatedExchange", _index -> indexDeepPathUtil.chooseRelatedExchange(_index)).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public LegalEntity chooseExchange(Observable observable) {
		final MapperS<Asset> asset = MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset());
		if (exists(asset).getOrDefault(false)) {
			return asset.<LegalEntity>map("chooseExchange", _asset -> assetDeepPathUtil.chooseExchange(_asset)).get();
		}
		final MapperS<Basket> basket = MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<LegalEntity>map("getExchange", _basket -> _basket.getExchange()).get();
		}
		final MapperS<Index> index = MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex());
		if (exists(index).getOrDefault(false)) {
			return index.<LegalEntity>map("chooseExchange", _index -> indexDeepPathUtil.chooseExchange(_index)).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(Observable observable) {
		final MapperS<Asset> asset = MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset());
		if (exists(asset).getOrDefault(false)) {
			return asset.<Taxonomy>mapC("chooseTaxonomy", _asset -> assetDeepPathUtil.chooseTaxonomy(_asset)).getMulti();
		}
		final MapperS<Basket> basket = MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<Taxonomy>mapC("getTaxonomy", _basket -> _basket.getTaxonomy()).getMulti();
		}
		final MapperS<Index> index = MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex());
		if (exists(index).getOrDefault(false)) {
			return index.<Taxonomy>mapC("chooseTaxonomy", _index -> indexDeepPathUtil.chooseTaxonomy(_index)).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
}
