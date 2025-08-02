package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016.
 * @version 6.0.0
 */
@RosettaEnum("CurrencyCodeEnum")
public enum CurrencyCodeEnum {

	/**
	 * UAE Dirham
	 */
	@RosettaEnumValue(value = "AED") 
	AED("AED", null),
	
	/**
	 * Afghani
	 */
	@RosettaEnumValue(value = "AFN") 
	AFN("AFN", null),
	
	/**
	 * Lek
	 */
	@RosettaEnumValue(value = "ALL") 
	ALL("ALL", null),
	
	/**
	 * Armenian Dram
	 */
	@RosettaEnumValue(value = "AMD") 
	AMD("AMD", null),
	
	/**
	 * Netherlands Antillean Guilder
	 */
	@RosettaEnumValue(value = "ANG") 
	ANG("ANG", null),
	
	/**
	 * Kwanza
	 */
	@RosettaEnumValue(value = "AOA") 
	AOA("AOA", null),
	
	/**
	 * Argentine Peso
	 */
	@RosettaEnumValue(value = "ARS") 
	ARS("ARS", null),
	
	/**
	 * Australian Dollar
	 */
	@RosettaEnumValue(value = "AUD") 
	AUD("AUD", null),
	
	/**
	 * Aruban Florin
	 */
	@RosettaEnumValue(value = "AWG") 
	AWG("AWG", null),
	
	/**
	 * Azerbaijan Manat
	 */
	@RosettaEnumValue(value = "AZN") 
	AZN("AZN", null),
	
	/**
	 * Convertible Mark
	 */
	@RosettaEnumValue(value = "BAM") 
	BAM("BAM", null),
	
	/**
	 * Barbados Dollar
	 */
	@RosettaEnumValue(value = "BBD") 
	BBD("BBD", null),
	
	/**
	 * Taka
	 */
	@RosettaEnumValue(value = "BDT") 
	BDT("BDT", null),
	
	/**
	 * Bulgarian Lev
	 */
	@RosettaEnumValue(value = "BGN") 
	BGN("BGN", null),
	
	/**
	 * Bahraini Dinar
	 */
	@RosettaEnumValue(value = "BHD") 
	BHD("BHD", null),
	
	/**
	 * Burundi Franc
	 */
	@RosettaEnumValue(value = "BIF") 
	BIF("BIF", null),
	
	/**
	 * Bermudian Dollar
	 */
	@RosettaEnumValue(value = "BMD") 
	BMD("BMD", null),
	
	/**
	 * Brunei Dollar
	 */
	@RosettaEnumValue(value = "BND") 
	BND("BND", null),
	
	/**
	 * Boliviano
	 */
	@RosettaEnumValue(value = "BOB") 
	BOB("BOB", null),
	
	/**
	 * Mvdol
	 */
	@RosettaEnumValue(value = "BOV") 
	BOV("BOV", null),
	
	/**
	 * Brazilian Real
	 */
	@RosettaEnumValue(value = "BRL") 
	BRL("BRL", null),
	
	/**
	 * Bahamian Dollar
	 */
	@RosettaEnumValue(value = "BSD") 
	BSD("BSD", null),
	
	/**
	 * Ngultrum
	 */
	@RosettaEnumValue(value = "BTN") 
	BTN("BTN", null),
	
	/**
	 * Pula
	 */
	@RosettaEnumValue(value = "BWP") 
	BWP("BWP", null),
	
	/**
	 * Belarusian Ruble
	 */
	@RosettaEnumValue(value = "BYN") 
	BYN("BYN", null),
	
	/**
	 * Belize Dollar
	 */
	@RosettaEnumValue(value = "BZD") 
	BZD("BZD", null),
	
	/**
	 * Canadian Dollar
	 */
	@RosettaEnumValue(value = "CAD") 
	CAD("CAD", null),
	
	/**
	 * Congolese Franc
	 */
	@RosettaEnumValue(value = "CDF") 
	CDF("CDF", null),
	
	/**
	 * WIR Euro
	 */
	@RosettaEnumValue(value = "CHE") 
	CHE("CHE", null),
	
	/**
	 * Swiss Franc
	 */
	@RosettaEnumValue(value = "CHF") 
	CHF("CHF", null),
	
	/**
	 * WIR Franc
	 */
	@RosettaEnumValue(value = "CHW") 
	CHW("CHW", null),
	
	/**
	 * Unidad de Fomento
	 */
	@RosettaEnumValue(value = "CLF") 
	CLF("CLF", null),
	
	/**
	 * Chilean Peso
	 */
	@RosettaEnumValue(value = "CLP") 
	CLP("CLP", null),
	
	/**
	 * Yuan Renminbi
	 */
	@RosettaEnumValue(value = "CNY") 
	CNY("CNY", null),
	
	/**
	 * Colombian Peso
	 */
	@RosettaEnumValue(value = "COP") 
	COP("COP", null),
	
	/**
	 * Unidad de Valor Real
	 */
	@RosettaEnumValue(value = "COU") 
	COU("COU", null),
	
	/**
	 * Costa Rican Colon
	 */
	@RosettaEnumValue(value = "CRC") 
	CRC("CRC", null),
	
	/**
	 * Peso Convertible
	 */
	@RosettaEnumValue(value = "CUC") 
	CUC("CUC", null),
	
	/**
	 * Cuban Peso
	 */
	@RosettaEnumValue(value = "CUP") 
	CUP("CUP", null),
	
	/**
	 * Cabo Verde Escudo
	 */
	@RosettaEnumValue(value = "CVE") 
	CVE("CVE", null),
	
	/**
	 * Czech Koruna
	 */
	@RosettaEnumValue(value = "CZK") 
	CZK("CZK", null),
	
	/**
	 * Djibouti Franc
	 */
	@RosettaEnumValue(value = "DJF") 
	DJF("DJF", null),
	
	/**
	 * Danish Krone
	 */
	@RosettaEnumValue(value = "DKK") 
	DKK("DKK", null),
	
	/**
	 * Dominican Peso
	 */
	@RosettaEnumValue(value = "DOP") 
	DOP("DOP", null),
	
	/**
	 * Algerian Dinar
	 */
	@RosettaEnumValue(value = "DZD") 
	DZD("DZD", null),
	
	/**
	 * Egyptian Pound
	 */
	@RosettaEnumValue(value = "EGP") 
	EGP("EGP", null),
	
	/**
	 * Nakfa
	 */
	@RosettaEnumValue(value = "ERN") 
	ERN("ERN", null),
	
	/**
	 * Ethiopian Birr
	 */
	@RosettaEnumValue(value = "ETB") 
	ETB("ETB", null),
	
	/**
	 * Euro
	 */
	@RosettaEnumValue(value = "EUR") 
	EUR("EUR", null),
	
	/**
	 * Fiji Dollar
	 */
	@RosettaEnumValue(value = "FJD") 
	FJD("FJD", null),
	
	/**
	 * Falkland Islands Pound
	 */
	@RosettaEnumValue(value = "FKP") 
	FKP("FKP", null),
	
	/**
	 * Pound Sterling
	 */
	@RosettaEnumValue(value = "GBP") 
	GBP("GBP", null),
	
	/**
	 * Lari
	 */
	@RosettaEnumValue(value = "GEL") 
	GEL("GEL", null),
	
	/**
	 * Ghana Cedi
	 */
	@RosettaEnumValue(value = "GHS") 
	GHS("GHS", null),
	
	/**
	 * Gibraltar Pound
	 */
	@RosettaEnumValue(value = "GIP") 
	GIP("GIP", null),
	
	/**
	 * Dalasi
	 */
	@RosettaEnumValue(value = "GMD") 
	GMD("GMD", null),
	
	/**
	 * Guinean Franc
	 */
	@RosettaEnumValue(value = "GNF") 
	GNF("GNF", null),
	
	/**
	 * Quetzal
	 */
	@RosettaEnumValue(value = "GTQ") 
	GTQ("GTQ", null),
	
	/**
	 * Guyana Dollar
	 */
	@RosettaEnumValue(value = "GYD") 
	GYD("GYD", null),
	
	/**
	 * Hong Kong Dollar
	 */
	@RosettaEnumValue(value = "HKD") 
	HKD("HKD", null),
	
	/**
	 * Lempira
	 */
	@RosettaEnumValue(value = "HNL") 
	HNL("HNL", null),
	
	/**
	 * Gourde
	 */
	@RosettaEnumValue(value = "HTG") 
	HTG("HTG", null),
	
	/**
	 * Forint
	 */
	@RosettaEnumValue(value = "HUF") 
	HUF("HUF", null),
	
	/**
	 * Rupiah
	 */
	@RosettaEnumValue(value = "IDR") 
	IDR("IDR", null),
	
	/**
	 * New Israeli Sheqel
	 */
	@RosettaEnumValue(value = "ILS") 
	ILS("ILS", null),
	
	/**
	 * Indian Rupee
	 */
	@RosettaEnumValue(value = "INR") 
	INR("INR", null),
	
	/**
	 * Iraqi Dinar
	 */
	@RosettaEnumValue(value = "IQD") 
	IQD("IQD", null),
	
	/**
	 * Iranian Rial
	 */
	@RosettaEnumValue(value = "IRR") 
	IRR("IRR", null),
	
	/**
	 * Iceland Krona
	 */
	@RosettaEnumValue(value = "ISK") 
	ISK("ISK", null),
	
	/**
	 * Jamaican Dollar
	 */
	@RosettaEnumValue(value = "JMD") 
	JMD("JMD", null),
	
	/**
	 * Jordanian Dinar
	 */
	@RosettaEnumValue(value = "JOD") 
	JOD("JOD", null),
	
	/**
	 * Yen
	 */
	@RosettaEnumValue(value = "JPY") 
	JPY("JPY", null),
	
	/**
	 * Kenyan Shilling
	 */
	@RosettaEnumValue(value = "KES") 
	KES("KES", null),
	
	/**
	 * Som
	 */
	@RosettaEnumValue(value = "KGS") 
	KGS("KGS", null),
	
	/**
	 * Riel
	 */
	@RosettaEnumValue(value = "KHR") 
	KHR("KHR", null),
	
	/**
	 * Comorian Franc 
	 */
	@RosettaEnumValue(value = "KMF") 
	KMF("KMF", null),
	
	/**
	 * North Korean Won
	 */
	@RosettaEnumValue(value = "KPW") 
	KPW("KPW", null),
	
	/**
	 * Won
	 */
	@RosettaEnumValue(value = "KRW") 
	KRW("KRW", null),
	
	/**
	 * Kuwaiti Dinar
	 */
	@RosettaEnumValue(value = "KWD") 
	KWD("KWD", null),
	
	/**
	 * Cayman Islands Dollar
	 */
	@RosettaEnumValue(value = "KYD") 
	KYD("KYD", null),
	
	/**
	 * Tenge
	 */
	@RosettaEnumValue(value = "KZT") 
	KZT("KZT", null),
	
	/**
	 * Lao Kip
	 */
	@RosettaEnumValue(value = "LAK") 
	LAK("LAK", null),
	
	/**
	 * Lebanese Pound
	 */
	@RosettaEnumValue(value = "LBP") 
	LBP("LBP", null),
	
	/**
	 * Sri Lanka Rupee
	 */
	@RosettaEnumValue(value = "LKR") 
	LKR("LKR", null),
	
	/**
	 * Liberian Dollar
	 */
	@RosettaEnumValue(value = "LRD") 
	LRD("LRD", null),
	
	/**
	 * Loti
	 */
	@RosettaEnumValue(value = "LSL") 
	LSL("LSL", null),
	
	/**
	 * Libyan Dinar
	 */
	@RosettaEnumValue(value = "LYD") 
	LYD("LYD", null),
	
	/**
	 * Moroccan Dirham
	 */
	@RosettaEnumValue(value = "MAD") 
	MAD("MAD", null),
	
	/**
	 * Moldovan Leu
	 */
	@RosettaEnumValue(value = "MDL") 
	MDL("MDL", null),
	
	/**
	 * Malagasy Ariary
	 */
	@RosettaEnumValue(value = "MGA") 
	MGA("MGA", null),
	
	/**
	 * Denar
	 */
	@RosettaEnumValue(value = "MKD") 
	MKD("MKD", null),
	
	/**
	 * Kyat
	 */
	@RosettaEnumValue(value = "MMK") 
	MMK("MMK", null),
	
	/**
	 * Tugrik
	 */
	@RosettaEnumValue(value = "MNT") 
	MNT("MNT", null),
	
	/**
	 * Pataca
	 */
	@RosettaEnumValue(value = "MOP") 
	MOP("MOP", null),
	
	/**
	 * Ouguiya
	 */
	@RosettaEnumValue(value = "MRU") 
	MRU("MRU", null),
	
	/**
	 * Mauritius Rupee
	 */
	@RosettaEnumValue(value = "MUR") 
	MUR("MUR", null),
	
	/**
	 * Rufiyaa
	 */
	@RosettaEnumValue(value = "MVR") 
	MVR("MVR", null),
	
	/**
	 * Malawi Kwacha
	 */
	@RosettaEnumValue(value = "MWK") 
	MWK("MWK", null),
	
	/**
	 * Mexican Peso
	 */
	@RosettaEnumValue(value = "MXN") 
	MXN("MXN", null),
	
	/**
	 * Mexican Unidad de Inversion (UDI)
	 */
	@RosettaEnumValue(value = "MXV") 
	MXV("MXV", null),
	
	/**
	 * Malaysian Ringgit
	 */
	@RosettaEnumValue(value = "MYR") 
	MYR("MYR", null),
	
	/**
	 * Mozambique Metical
	 */
	@RosettaEnumValue(value = "MZN") 
	MZN("MZN", null),
	
	/**
	 * Namibia Dollar
	 */
	@RosettaEnumValue(value = "NAD") 
	NAD("NAD", null),
	
	/**
	 * Naira
	 */
	@RosettaEnumValue(value = "NGN") 
	NGN("NGN", null),
	
	/**
	 * Cordoba Oro
	 */
	@RosettaEnumValue(value = "NIO") 
	NIO("NIO", null),
	
	/**
	 * Norwegian Krone
	 */
	@RosettaEnumValue(value = "NOK") 
	NOK("NOK", null),
	
	/**
	 * Nepalese Rupee
	 */
	@RosettaEnumValue(value = "NPR") 
	NPR("NPR", null),
	
	/**
	 * New Zealand Dollar
	 */
	@RosettaEnumValue(value = "NZD") 
	NZD("NZD", null),
	
	/**
	 * Rial Omani
	 */
	@RosettaEnumValue(value = "OMR") 
	OMR("OMR", null),
	
	/**
	 * Balboa
	 */
	@RosettaEnumValue(value = "PAB") 
	PAB("PAB", null),
	
	/**
	 * Sol
	 */
	@RosettaEnumValue(value = "PEN") 
	PEN("PEN", null),
	
	/**
	 * Kina
	 */
	@RosettaEnumValue(value = "PGK") 
	PGK("PGK", null),
	
	/**
	 * Philippine Peso
	 */
	@RosettaEnumValue(value = "PHP") 
	PHP("PHP", null),
	
	/**
	 * Pakistan Rupee
	 */
	@RosettaEnumValue(value = "PKR") 
	PKR("PKR", null),
	
	/**
	 * Zloty
	 */
	@RosettaEnumValue(value = "PLN") 
	PLN("PLN", null),
	
	/**
	 * Guarani
	 */
	@RosettaEnumValue(value = "PYG") 
	PYG("PYG", null),
	
	/**
	 * Qatari Rial
	 */
	@RosettaEnumValue(value = "QAR") 
	QAR("QAR", null),
	
	/**
	 * Romanian Leu
	 */
	@RosettaEnumValue(value = "RON") 
	RON("RON", null),
	
	/**
	 * Serbian Dinar
	 */
	@RosettaEnumValue(value = "RSD") 
	RSD("RSD", null),
	
	/**
	 * Russian Ruble
	 */
	@RosettaEnumValue(value = "RUB") 
	RUB("RUB", null),
	
	/**
	 * Rwanda Franc
	 */
	@RosettaEnumValue(value = "RWF") 
	RWF("RWF", null),
	
	/**
	 * Saudi Riyal
	 */
	@RosettaEnumValue(value = "SAR") 
	SAR("SAR", null),
	
	/**
	 * Solomon Islands Dollar
	 */
	@RosettaEnumValue(value = "SBD") 
	SBD("SBD", null),
	
	/**
	 * Seychelles Rupee
	 */
	@RosettaEnumValue(value = "SCR") 
	SCR("SCR", null),
	
	/**
	 * Sudanese Pound
	 */
	@RosettaEnumValue(value = "SDG") 
	SDG("SDG", null),
	
	/**
	 * Swedish Krona
	 */
	@RosettaEnumValue(value = "SEK") 
	SEK("SEK", null),
	
	/**
	 * Singapore Dollar
	 */
	@RosettaEnumValue(value = "SGD") 
	SGD("SGD", null),
	
	/**
	 * Saint Helena Pound
	 */
	@RosettaEnumValue(value = "SHP") 
	SHP("SHP", null),
	
	/**
	 * Leone
	 */
	@RosettaEnumValue(value = "SLE") 
	SLE("SLE", null),
	
	/**
	 * Somali Shilling
	 */
	@RosettaEnumValue(value = "SOS") 
	SOS("SOS", null),
	
	/**
	 * Surinam Dollar
	 */
	@RosettaEnumValue(value = "SRD") 
	SRD("SRD", null),
	
	/**
	 * South Sudanese Pound
	 */
	@RosettaEnumValue(value = "SSP") 
	SSP("SSP", null),
	
	/**
	 * Dobra
	 */
	@RosettaEnumValue(value = "STN") 
	STN("STN", null),
	
	/**
	 * El Salvador Colon
	 */
	@RosettaEnumValue(value = "SVC") 
	SVC("SVC", null),
	
	/**
	 * Syrian Pound
	 */
	@RosettaEnumValue(value = "SYP") 
	SYP("SYP", null),
	
	/**
	 * Lilangeni
	 */
	@RosettaEnumValue(value = "SZL") 
	SZL("SZL", null),
	
	/**
	 * Baht
	 */
	@RosettaEnumValue(value = "THB") 
	THB("THB", null),
	
	/**
	 * Somoni
	 */
	@RosettaEnumValue(value = "TJS") 
	TJS("TJS", null),
	
	/**
	 * Turkmenistan New Manat
	 */
	@RosettaEnumValue(value = "TMT") 
	TMT("TMT", null),
	
	/**
	 * Tunisian Dinar
	 */
	@RosettaEnumValue(value = "TND") 
	TND("TND", null),
	
	/**
	 * Pa’anga
	 */
	@RosettaEnumValue(value = "TOP") 
	TOP("TOP", null),
	
	/**
	 * Turkish Lira
	 */
	@RosettaEnumValue(value = "TRY") 
	TRY("TRY", null),
	
	/**
	 * Trinidad and Tobago Dollar
	 */
	@RosettaEnumValue(value = "TTD") 
	TTD("TTD", null),
	
	/**
	 * New Taiwan Dollar
	 */
	@RosettaEnumValue(value = "TWD") 
	TWD("TWD", null),
	
	/**
	 * Tanzanian Shilling
	 */
	@RosettaEnumValue(value = "TZS") 
	TZS("TZS", null),
	
	/**
	 * Hryvnia
	 */
	@RosettaEnumValue(value = "UAH") 
	UAH("UAH", null),
	
	/**
	 * Uganda Shilling
	 */
	@RosettaEnumValue(value = "UGX") 
	UGX("UGX", null),
	
	/**
	 * US Dollar
	 */
	@RosettaEnumValue(value = "USD") 
	USD("USD", null),
	
	/**
	 * US Dollar (Next day)
	 */
	@RosettaEnumValue(value = "USN") 
	USN("USN", null),
	
	/**
	 * Uruguay Peso en Unidades Indexadas (UI)
	 */
	@RosettaEnumValue(value = "UYI") 
	UYI("UYI", null),
	
	/**
	 * Peso Uruguayo
	 */
	@RosettaEnumValue(value = "UYU") 
	UYU("UYU", null),
	
	/**
	 * Unidad Previsional
	 */
	@RosettaEnumValue(value = "UYW") 
	UYW("UYW", null),
	
	/**
	 * Uzbekistan Sum
	 */
	@RosettaEnumValue(value = "UZS") 
	UZS("UZS", null),
	
	/**
	 * Bolívar Soberano
	 */
	@RosettaEnumValue(value = "VED") 
	VED("VED", null),
	
	/**
	 * Bolívar Soberano
	 */
	@RosettaEnumValue(value = "VES") 
	VES("VES", null),
	
	/**
	 * Dong
	 */
	@RosettaEnumValue(value = "VND") 
	VND("VND", null),
	
	/**
	 * Vatu
	 */
	@RosettaEnumValue(value = "VUV") 
	VUV("VUV", null),
	
	/**
	 * Tala
	 */
	@RosettaEnumValue(value = "WST") 
	WST("WST", null),
	
	/**
	 * CFA Franc BEAC
	 */
	@RosettaEnumValue(value = "XAF") 
	XAF("XAF", null),
	
	/**
	 * Silver
	 */
	@RosettaEnumValue(value = "XAG") 
	XAG("XAG", null),
	
	/**
	 * Gold
	 */
	@RosettaEnumValue(value = "XAU") 
	XAU("XAU", null),
	
	/**
	 * Bond Markets Unit European Composite Unit (EURCO)
	 */
	@RosettaEnumValue(value = "XBA") 
	XBA("XBA", null),
	
	/**
	 * Bond Markets Unit European Monetary Unit (E.M.U.-6)
	 */
	@RosettaEnumValue(value = "XBB") 
	XBB("XBB", null),
	
	/**
	 * Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
	 */
	@RosettaEnumValue(value = "XBC") 
	XBC("XBC", null),
	
	/**
	 * Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
	 */
	@RosettaEnumValue(value = "XBD") 
	XBD("XBD", null),
	
	/**
	 * East Caribbean Dollar
	 */
	@RosettaEnumValue(value = "XCD") 
	XCD("XCD", null),
	
	/**
	 * SDR (Special Drawing Right)
	 */
	@RosettaEnumValue(value = "XDR") 
	XDR("XDR", null),
	
	/**
	 * CFA Franc BCEAO
	 */
	@RosettaEnumValue(value = "XOF") 
	XOF("XOF", null),
	
	/**
	 * Palladium
	 */
	@RosettaEnumValue(value = "XPD") 
	XPD("XPD", null),
	
	/**
	 * CFP Franc
	 */
	@RosettaEnumValue(value = "XPF") 
	XPF("XPF", null),
	
	/**
	 * Platinum
	 */
	@RosettaEnumValue(value = "XPT") 
	XPT("XPT", null),
	
	/**
	 * Sucre
	 */
	@RosettaEnumValue(value = "XSU") 
	XSU("XSU", null),
	
	/**
	 * Codes specifically reserved for testing purposes
	 */
	@RosettaEnumValue(value = "XTS") 
	XTS("XTS", null),
	
	/**
	 * ADB Unit of Account
	 */
	@RosettaEnumValue(value = "XUA") 
	XUA("XUA", null),
	
	/**
	 * The codes assigned for transactions where no currency is involved
	 */
	@RosettaEnumValue(value = "XXX") 
	XXX("XXX", null),
	
	/**
	 * Yemeni Rial
	 */
	@RosettaEnumValue(value = "YER") 
	YER("YER", null),
	
	/**
	 * Rand
	 */
	@RosettaEnumValue(value = "ZAR") 
	ZAR("ZAR", null),
	
	/**
	 * Zambian Kwacha
	 */
	@RosettaEnumValue(value = "ZMW") 
	ZMW("ZMW", null),
	
	/**
	 * Zimbabwe Gold
	 */
	@RosettaEnumValue(value = "ZWG") 
	ZWG("ZWG", null),
	
	/**
	 * Offshore Chinese Yuan traded in Hong Kong.
	 */
	@RosettaEnumValue(value = "CNH") 
	CNH("CNH", null),
	
	/**
	 * Offshore Chinese Yuan traded in Taiwan.
	 */
	@RosettaEnumValue(value = "CNT") 
	CNT("CNT", null),
	
	/**
	 * Guernsey Pound.
	 */
	@RosettaEnumValue(value = "GGP") 
	GGP("GGP", null),
	
	/**
	 * Isle of Man Pound.
	 */
	@RosettaEnumValue(value = "IMP") 
	IMP("IMP", null),
	
	/**
	 * Jersey Pound.
	 */
	@RosettaEnumValue(value = "JEP") 
	JEP("JEP", null),
	
	/**
	 * Tuvaluan Dollar.
	 */
	@RosettaEnumValue(value = "KID") 
	KID("KID", null),
	
	/**
	 * Monegasque Franc.
	 */
	@RosettaEnumValue(value = "MCF") 
	MCF("MCF", null),
	
	/**
	 * Sammarinese Lira.
	 */
	@RosettaEnumValue(value = "SML") 
	SML("SML", null),
	
	/**
	 * Vatican Lira.
	 */
	@RosettaEnumValue(value = "VAL") 
	VAL("VAL", null)
;
	private static Map<String, CurrencyCodeEnum> values;
	static {
        Map<String, CurrencyCodeEnum> map = new ConcurrentHashMap<>();
		for (CurrencyCodeEnum instance : CurrencyCodeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CurrencyCodeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CurrencyCodeEnum fromDisplayName(String name) {
		CurrencyCodeEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
