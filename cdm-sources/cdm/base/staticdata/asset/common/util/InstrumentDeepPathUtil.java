package cdm.base.staticdata.asset.common.util;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.party.LegalEntity;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class InstrumentDeepPathUtil {
	public Boolean chooseIsExchangeListed(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<Boolean>map("getIsExchangeListed", _listedDerivative -> _listedDerivative.getIsExchangeListed()).get();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<Boolean>map("getIsExchangeListed", _loan -> _loan.getIsExchangeListed()).get();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<Boolean>map("getIsExchangeListed", _security -> _security.getIsExchangeListed()).get();
		}
		return null;
	}
	
	public List<AssetIdentifier> chooseIdentifier(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<AssetIdentifier>mapC("getIdentifier", _listedDerivative -> _listedDerivative.getIdentifier()).getMulti();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<AssetIdentifier>mapC("getIdentifier", _loan -> _loan.getIdentifier()).getMulti();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<AssetIdentifier>mapC("getIdentifier", _security -> _security.getIdentifier()).getMulti();
		}
		return Collections.<AssetIdentifier>emptyList();
	}
	
	public InstrumentTypeEnum chooseInstrumentType(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<InstrumentTypeEnum>map("getInstrumentType", _listedDerivative -> _listedDerivative.getInstrumentType()).get();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<InstrumentTypeEnum>map("getInstrumentType", _loan -> _loan.getInstrumentType()).get();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<InstrumentTypeEnum>map("getInstrumentType", _security -> _security.getInstrumentType()).get();
		}
		return null;
	}
	
	public List<LegalEntity> chooseRelatedExchange(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<LegalEntity>mapC("getRelatedExchange", _listedDerivative -> _listedDerivative.getRelatedExchange()).getMulti();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<LegalEntity>mapC("getRelatedExchange", _loan -> _loan.getRelatedExchange()).getMulti();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<LegalEntity>mapC("getRelatedExchange", _security -> _security.getRelatedExchange()).getMulti();
		}
		return Collections.<LegalEntity>emptyList();
	}
	
	public LegalEntity chooseExchange(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<LegalEntity>map("getExchange", _listedDerivative -> _listedDerivative.getExchange()).get();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<LegalEntity>map("getExchange", _loan -> _loan.getExchange()).get();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<LegalEntity>map("getExchange", _security -> _security.getExchange()).get();
		}
		return null;
	}
	
	public List<Taxonomy> chooseTaxonomy(Instrument instrument) {
		final MapperS<ListedDerivative> listedDerivative = MapperS.of(instrument).<ListedDerivative>map("getListedDerivative", _instrument -> _instrument.getListedDerivative());
		if (exists(listedDerivative).getOrDefault(false)) {
			return listedDerivative.<Taxonomy>mapC("getTaxonomy", _listedDerivative -> _listedDerivative.getTaxonomy()).getMulti();
		}
		final MapperS<Loan> loan = MapperS.of(instrument).<Loan>map("getLoan", _instrument -> _instrument.getLoan());
		if (exists(loan).getOrDefault(false)) {
			return loan.<Taxonomy>mapC("getTaxonomy", _loan -> _loan.getTaxonomy()).getMulti();
		}
		final MapperS<Security> security = MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity());
		if (exists(security).getOrDefault(false)) {
			return security.<Taxonomy>mapC("getTaxonomy", _security -> _security.getTaxonomy()).getMulti();
		}
		return Collections.<Taxonomy>emptyList();
	}
	
}
