package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO). The set of codes in this enumerated list is sourced from ISO Standard 3166 (ISO-3166-1alpha-2)(https://www.iso.org/iso-3166-country-codes.html) as at 14-Aug-23.
 * @version 6.0.0
 */
@RosettaEnum("ISOCountryCodeEnum")
public enum ISOCountryCodeEnum {

	/**
	 * Afghanistan
	 */
	@RosettaEnumValue(value = "AF") 
	AF("AF", null),
	
	/**
	 * Albania
	 */
	@RosettaEnumValue(value = "AL") 
	AL("AL", null),
	
	/**
	 * Algeria
	 */
	@RosettaEnumValue(value = "DZ") 
	DZ("DZ", null),
	
	/**
	 * American Samoa
	 */
	@RosettaEnumValue(value = "AS") 
	AS("AS", null),
	
	/**
	 * Andorra
	 */
	@RosettaEnumValue(value = "AD") 
	AD("AD", null),
	
	/**
	 * Angola
	 */
	@RosettaEnumValue(value = "AO") 
	AO("AO", null),
	
	/**
	 * Anguilla
	 */
	@RosettaEnumValue(value = "AI") 
	AI("AI", null),
	
	/**
	 * Antarctica
	 */
	@RosettaEnumValue(value = "AQ") 
	AQ("AQ", null),
	
	/**
	 * Antigua and Barbuda
	 */
	@RosettaEnumValue(value = "AG") 
	AG("AG", null),
	
	/**
	 * Argentina
	 */
	@RosettaEnumValue(value = "AR") 
	AR("AR", null),
	
	/**
	 * Armenia
	 */
	@RosettaEnumValue(value = "AM") 
	AM("AM", null),
	
	/**
	 * Aruba
	 */
	@RosettaEnumValue(value = "AW") 
	AW("AW", null),
	
	/**
	 * Australia
	 */
	@RosettaEnumValue(value = "AU") 
	AU("AU", null),
	
	/**
	 * Austria
	 */
	@RosettaEnumValue(value = "AT") 
	AT("AT", null),
	
	/**
	 * Azerbaijan
	 */
	@RosettaEnumValue(value = "AZ") 
	AZ("AZ", null),
	
	/**
	 * Bahamas (the)
	 */
	@RosettaEnumValue(value = "BS") 
	BS("BS", null),
	
	/**
	 * Bahrain
	 */
	@RosettaEnumValue(value = "BH") 
	BH("BH", null),
	
	/**
	 * Bangladesh
	 */
	@RosettaEnumValue(value = "BD") 
	BD("BD", null),
	
	/**
	 * Barbados
	 */
	@RosettaEnumValue(value = "BB") 
	BB("BB", null),
	
	/**
	 * Belarus
	 */
	@RosettaEnumValue(value = "BY") 
	BY("BY", null),
	
	/**
	 * Belgium
	 */
	@RosettaEnumValue(value = "BE") 
	BE("BE", null),
	
	/**
	 * Belize
	 */
	@RosettaEnumValue(value = "BZ") 
	BZ("BZ", null),
	
	/**
	 * Benin
	 */
	@RosettaEnumValue(value = "BJ") 
	BJ("BJ", null),
	
	/**
	 * Bermuda
	 */
	@RosettaEnumValue(value = "BM") 
	BM("BM", null),
	
	/**
	 * Aland Islands
	 */
	@RosettaEnumValue(value = "AX") 
	AX("AX", null),
	
	/**
	 * Bhutan
	 */
	@RosettaEnumValue(value = "BT") 
	BT("BT", null),
	
	/**
	 * Bolivia (Plurinational State of)
	 */
	@RosettaEnumValue(value = "BO") 
	BO("BO", null),
	
	/**
	 * Bonaire, Sint Eustatius and Saba
	 */
	@RosettaEnumValue(value = "BQ") 
	BQ("BQ", null),
	
	/**
	 * Bosnia and Herzegovina
	 */
	@RosettaEnumValue(value = "BA") 
	BA("BA", null),
	
	/**
	 * Botswana
	 */
	@RosettaEnumValue(value = "BW") 
	BW("BW", null),
	
	/**
	 * Bouvet Island
	 */
	@RosettaEnumValue(value = "BV") 
	BV("BV", null),
	
	/**
	 * Brazil
	 */
	@RosettaEnumValue(value = "BR") 
	BR("BR", null),
	
	/**
	 * British Indian Ocean Territory (the)
	 */
	@RosettaEnumValue(value = "IO") 
	IO("IO", null),
	
	/**
	 * Brunei Darussalam
	 */
	@RosettaEnumValue(value = "BN") 
	BN("BN", null),
	
	/**
	 * Bulgaria
	 */
	@RosettaEnumValue(value = "BG") 
	BG("BG", null),
	
	/**
	 * Burkina Faso
	 */
	@RosettaEnumValue(value = "BF") 
	BF("BF", null),
	
	/**
	 * Burundi
	 */
	@RosettaEnumValue(value = "BI") 
	BI("BI", null),
	
	/**
	 * Cabo Verde
	 */
	@RosettaEnumValue(value = "CV") 
	CV("CV", null),
	
	/**
	 * Cambodia
	 */
	@RosettaEnumValue(value = "KH") 
	KH("KH", null),
	
	/**
	 * Cameroon
	 */
	@RosettaEnumValue(value = "CM") 
	CM("CM", null),
	
	/**
	 * Canada
	 */
	@RosettaEnumValue(value = "CA") 
	CA("CA", null),
	
	/**
	 * Cayman Islands (the)
	 */
	@RosettaEnumValue(value = "KY") 
	KY("KY", null),
	
	/**
	 * Central African Republic (the)
	 */
	@RosettaEnumValue(value = "CF") 
	CF("CF", null),
	
	/**
	 * Chad
	 */
	@RosettaEnumValue(value = "TD") 
	TD("TD", null),
	
	/**
	 * Chile
	 */
	@RosettaEnumValue(value = "CL") 
	CL("CL", null),
	
	/**
	 * China
	 */
	@RosettaEnumValue(value = "CN") 
	CN("CN", null),
	
	/**
	 * Christmas Island
	 */
	@RosettaEnumValue(value = "CX") 
	CX("CX", null),
	
	/**
	 * Cocos (Keeling) Islands (the)
	 */
	@RosettaEnumValue(value = "CC") 
	CC("CC", null),
	
	/**
	 * Colombia
	 */
	@RosettaEnumValue(value = "CO") 
	CO("CO", null),
	
	/**
	 * Comoros (the)
	 */
	@RosettaEnumValue(value = "KM") 
	KM("KM", null),
	
	/**
	 * Congo (the Democratic Republic of the)
	 */
	@RosettaEnumValue(value = "CD") 
	CD("CD", null),
	
	/**
	 * Congo (the)
	 */
	@RosettaEnumValue(value = "CG") 
	CG("CG", null),
	
	/**
	 * Cook Islands (the)
	 */
	@RosettaEnumValue(value = "CK") 
	CK("CK", null),
	
	/**
	 * Costa Rica
	 */
	@RosettaEnumValue(value = "CR") 
	CR("CR", null),
	
	/**
	 * Croatia
	 */
	@RosettaEnumValue(value = "HR") 
	HR("HR", null),
	
	/**
	 * Cuba
	 */
	@RosettaEnumValue(value = "CU") 
	CU("CU", null),
	
	/**
	 * Curaao
	 */
	@RosettaEnumValue(value = "CW") 
	CW("CW", null),
	
	/**
	 * Cyprus
	 */
	@RosettaEnumValue(value = "CY") 
	CY("CY", null),
	
	/**
	 * Czechia
	 */
	@RosettaEnumValue(value = "CZ") 
	CZ("CZ", null),
	
	/**
	 * Cte d&#39;Ivoire
	 */
	@RosettaEnumValue(value = "CI") 
	CI("CI", null),
	
	/**
	 * Denmark
	 */
	@RosettaEnumValue(value = "DK") 
	DK("DK", null),
	
	/**
	 * Djibouti
	 */
	@RosettaEnumValue(value = "DJ") 
	DJ("DJ", null),
	
	/**
	 * Dominica
	 */
	@RosettaEnumValue(value = "DM") 
	DM("DM", null),
	
	/**
	 * Dominican Republic (the)
	 */
	@RosettaEnumValue(value = "DO") 
	DO("DO", null),
	
	/**
	 * Ecuador
	 */
	@RosettaEnumValue(value = "EC") 
	EC("EC", null),
	
	/**
	 * Egypt
	 */
	@RosettaEnumValue(value = "EG") 
	EG("EG", null),
	
	/**
	 * El Salvador
	 */
	@RosettaEnumValue(value = "SV") 
	SV("SV", null),
	
	/**
	 * Equatorial Guinea
	 */
	@RosettaEnumValue(value = "GQ") 
	GQ("GQ", null),
	
	/**
	 * Eritrea
	 */
	@RosettaEnumValue(value = "ER") 
	ER("ER", null),
	
	/**
	 * Estonia
	 */
	@RosettaEnumValue(value = "EE") 
	EE("EE", null),
	
	/**
	 * Eswatini
	 */
	@RosettaEnumValue(value = "SZ") 
	SZ("SZ", null),
	
	/**
	 * Ethiopia
	 */
	@RosettaEnumValue(value = "ET") 
	ET("ET", null),
	
	/**
	 * Falkland Islands (the) [Malvinas]
	 */
	@RosettaEnumValue(value = "FK") 
	FK("FK", null),
	
	/**
	 * Faroe Islands (the)
	 */
	@RosettaEnumValue(value = "FO") 
	FO("FO", null),
	
	/**
	 * Fiji
	 */
	@RosettaEnumValue(value = "FJ") 
	FJ("FJ", null),
	
	/**
	 * Finland
	 */
	@RosettaEnumValue(value = "FI") 
	FI("FI", null),
	
	/**
	 * France
	 */
	@RosettaEnumValue(value = "FR") 
	FR("FR", null),
	
	/**
	 * French Guiana
	 */
	@RosettaEnumValue(value = "GF") 
	GF("GF", null),
	
	/**
	 * French Polynesia
	 */
	@RosettaEnumValue(value = "PF") 
	PF("PF", null),
	
	/**
	 * French Southern Territories (the)
	 */
	@RosettaEnumValue(value = "TF") 
	TF("TF", null),
	
	/**
	 * Gabon
	 */
	@RosettaEnumValue(value = "GA") 
	GA("GA", null),
	
	/**
	 * Gambia (the)
	 */
	@RosettaEnumValue(value = "GM") 
	GM("GM", null),
	
	/**
	 * Georgia
	 */
	@RosettaEnumValue(value = "GE") 
	GE("GE", null),
	
	/**
	 * Germany
	 */
	@RosettaEnumValue(value = "DE") 
	DE("DE", null),
	
	/**
	 * Ghana
	 */
	@RosettaEnumValue(value = "GH") 
	GH("GH", null),
	
	/**
	 * Gibraltar
	 */
	@RosettaEnumValue(value = "GI") 
	GI("GI", null),
	
	/**
	 * Greece
	 */
	@RosettaEnumValue(value = "GR") 
	GR("GR", null),
	
	/**
	 * Greenland
	 */
	@RosettaEnumValue(value = "GL") 
	GL("GL", null),
	
	/**
	 * Grenada
	 */
	@RosettaEnumValue(value = "GD") 
	GD("GD", null),
	
	/**
	 * Guadeloupe
	 */
	@RosettaEnumValue(value = "GP") 
	GP("GP", null),
	
	/**
	 * Guam
	 */
	@RosettaEnumValue(value = "GU") 
	GU("GU", null),
	
	/**
	 * Guatemala
	 */
	@RosettaEnumValue(value = "GT") 
	GT("GT", null),
	
	/**
	 * Guernsey
	 */
	@RosettaEnumValue(value = "GG") 
	GG("GG", null),
	
	/**
	 * Guinea
	 */
	@RosettaEnumValue(value = "GN") 
	GN("GN", null),
	
	/**
	 * Guinea-Bissau
	 */
	@RosettaEnumValue(value = "GW") 
	GW("GW", null),
	
	/**
	 * Guyana
	 */
	@RosettaEnumValue(value = "GY") 
	GY("GY", null),
	
	/**
	 * Haiti
	 */
	@RosettaEnumValue(value = "HT") 
	HT("HT", null),
	
	/**
	 * Heard Island and McDonald Islands
	 */
	@RosettaEnumValue(value = "HM") 
	HM("HM", null),
	
	/**
	 * Holy See (the)
	 */
	@RosettaEnumValue(value = "VA") 
	VA("VA", null),
	
	/**
	 * Honduras
	 */
	@RosettaEnumValue(value = "HN") 
	HN("HN", null),
	
	/**
	 * Hong Kong
	 */
	@RosettaEnumValue(value = "HK") 
	HK("HK", null),
	
	/**
	 * Hungary
	 */
	@RosettaEnumValue(value = "HU") 
	HU("HU", null),
	
	/**
	 * Iceland
	 */
	@RosettaEnumValue(value = "IS") 
	IS("IS", null),
	
	/**
	 * India
	 */
	@RosettaEnumValue(value = "IN") 
	IN("IN", null),
	
	/**
	 * Indonesia
	 */
	@RosettaEnumValue(value = "ID") 
	ID("ID", null),
	
	/**
	 * Iran (Islamic Republic of)
	 */
	@RosettaEnumValue(value = "IR") 
	IR("IR", null),
	
	/**
	 * Iraq
	 */
	@RosettaEnumValue(value = "IQ") 
	IQ("IQ", null),
	
	/**
	 * Ireland
	 */
	@RosettaEnumValue(value = "IE") 
	IE("IE", null),
	
	/**
	 * Isle of Man
	 */
	@RosettaEnumValue(value = "IM") 
	IM("IM", null),
	
	/**
	 * Israel
	 */
	@RosettaEnumValue(value = "IL") 
	IL("IL", null),
	
	/**
	 * Italy
	 */
	@RosettaEnumValue(value = "IT") 
	IT("IT", null),
	
	/**
	 * Jamaica
	 */
	@RosettaEnumValue(value = "JM") 
	JM("JM", null),
	
	/**
	 * Japan
	 */
	@RosettaEnumValue(value = "JP") 
	JP("JP", null),
	
	/**
	 * Jersey
	 */
	@RosettaEnumValue(value = "JE") 
	JE("JE", null),
	
	/**
	 * Jordan
	 */
	@RosettaEnumValue(value = "JO") 
	JO("JO", null),
	
	/**
	 * Kazakhstan
	 */
	@RosettaEnumValue(value = "KZ") 
	KZ("KZ", null),
	
	/**
	 * Kenya
	 */
	@RosettaEnumValue(value = "KE") 
	KE("KE", null),
	
	/**
	 * Kiribati
	 */
	@RosettaEnumValue(value = "KI") 
	KI("KI", null),
	
	/**
	 * Korea (the Democratic People&#39;s Republic of)
	 */
	@RosettaEnumValue(value = "KP") 
	KP("KP", null),
	
	/**
	 * Korea (the Republic of)
	 */
	@RosettaEnumValue(value = "KR") 
	KR("KR", null),
	
	/**
	 * Kuwait
	 */
	@RosettaEnumValue(value = "KW") 
	KW("KW", null),
	
	/**
	 * Kyrgyzstan
	 */
	@RosettaEnumValue(value = "KG") 
	KG("KG", null),
	
	/**
	 * Lao People&#39;s Democratic Republic (the)
	 */
	@RosettaEnumValue(value = "LA") 
	LA("LA", null),
	
	/**
	 * Latvia
	 */
	@RosettaEnumValue(value = "LV") 
	LV("LV", null),
	
	/**
	 * Lebanon
	 */
	@RosettaEnumValue(value = "LB") 
	LB("LB", null),
	
	/**
	 * Lesotho
	 */
	@RosettaEnumValue(value = "LS") 
	LS("LS", null),
	
	/**
	 * Liberia
	 */
	@RosettaEnumValue(value = "LR") 
	LR("LR", null),
	
	/**
	 * Libya
	 */
	@RosettaEnumValue(value = "LY") 
	LY("LY", null),
	
	/**
	 * Liechtenstein
	 */
	@RosettaEnumValue(value = "LI") 
	LI("LI", null),
	
	/**
	 * Lithuania
	 */
	@RosettaEnumValue(value = "LT") 
	LT("LT", null),
	
	/**
	 * Luxembourg
	 */
	@RosettaEnumValue(value = "LU") 
	LU("LU", null),
	
	/**
	 * Macao
	 */
	@RosettaEnumValue(value = "MO") 
	MO("MO", null),
	
	/**
	 * Madagascar
	 */
	@RosettaEnumValue(value = "MG") 
	MG("MG", null),
	
	/**
	 * Malawi
	 */
	@RosettaEnumValue(value = "MW") 
	MW("MW", null),
	
	/**
	 * Malaysia
	 */
	@RosettaEnumValue(value = "MY") 
	MY("MY", null),
	
	/**
	 * Maldives
	 */
	@RosettaEnumValue(value = "MV") 
	MV("MV", null),
	
	/**
	 * Mali
	 */
	@RosettaEnumValue(value = "ML") 
	ML("ML", null),
	
	/**
	 * Malta
	 */
	@RosettaEnumValue(value = "MT") 
	MT("MT", null),
	
	/**
	 * Marshall Islands (the)
	 */
	@RosettaEnumValue(value = "MH") 
	MH("MH", null),
	
	/**
	 * Martinique
	 */
	@RosettaEnumValue(value = "MQ") 
	MQ("MQ", null),
	
	/**
	 * Mauritania
	 */
	@RosettaEnumValue(value = "MR") 
	MR("MR", null),
	
	/**
	 * Mauritius
	 */
	@RosettaEnumValue(value = "MU") 
	MU("MU", null),
	
	/**
	 * Mayotte
	 */
	@RosettaEnumValue(value = "YT") 
	YT("YT", null),
	
	/**
	 * Mexico
	 */
	@RosettaEnumValue(value = "MX") 
	MX("MX", null),
	
	/**
	 * Micronesia (Federated States of)
	 */
	@RosettaEnumValue(value = "FM") 
	FM("FM", null),
	
	/**
	 * Moldova (the Republic of)
	 */
	@RosettaEnumValue(value = "MD") 
	MD("MD", null),
	
	/**
	 * Monaco
	 */
	@RosettaEnumValue(value = "MC") 
	MC("MC", null),
	
	/**
	 * Mongolia
	 */
	@RosettaEnumValue(value = "MN") 
	MN("MN", null),
	
	/**
	 * Montenegro
	 */
	@RosettaEnumValue(value = "ME") 
	ME("ME", null),
	
	/**
	 * Montserrat
	 */
	@RosettaEnumValue(value = "MS") 
	MS("MS", null),
	
	/**
	 * Morocco
	 */
	@RosettaEnumValue(value = "MA") 
	MA("MA", null),
	
	/**
	 * Mozambique
	 */
	@RosettaEnumValue(value = "MZ") 
	MZ("MZ", null),
	
	/**
	 * Myanmar
	 */
	@RosettaEnumValue(value = "MM") 
	MM("MM", null),
	
	/**
	 * Namibia
	 */
	@RosettaEnumValue(value = "NA") 
	NA("NA", null),
	
	/**
	 * Nauru
	 */
	@RosettaEnumValue(value = "NR") 
	NR("NR", null),
	
	/**
	 * Nepal
	 */
	@RosettaEnumValue(value = "NP") 
	NP("NP", null),
	
	/**
	 * Netherlands (Kingdom of the)
	 */
	@RosettaEnumValue(value = "NL") 
	NL("NL", null),
	
	/**
	 * New Caledonia
	 */
	@RosettaEnumValue(value = "NC") 
	NC("NC", null),
	
	/**
	 * New Zealand
	 */
	@RosettaEnumValue(value = "NZ") 
	NZ("NZ", null),
	
	/**
	 * Nicaragua
	 */
	@RosettaEnumValue(value = "NI") 
	NI("NI", null),
	
	/**
	 * Niger (the)
	 */
	@RosettaEnumValue(value = "NE") 
	NE("NE", null),
	
	/**
	 * Nigeria
	 */
	@RosettaEnumValue(value = "NG") 
	NG("NG", null),
	
	/**
	 * Niue
	 */
	@RosettaEnumValue(value = "NU") 
	NU("NU", null),
	
	/**
	 * Norfolk Island
	 */
	@RosettaEnumValue(value = "NF") 
	NF("NF", null),
	
	/**
	 * North Macedonia
	 */
	@RosettaEnumValue(value = "MK") 
	MK("MK", null),
	
	/**
	 * Northern Mariana Islands (the)
	 */
	@RosettaEnumValue(value = "MP") 
	MP("MP", null),
	
	/**
	 * Norway
	 */
	@RosettaEnumValue(value = "NO") 
	NO("NO", null),
	
	/**
	 * Oman
	 */
	@RosettaEnumValue(value = "OM") 
	OM("OM", null),
	
	/**
	 * Pakistan
	 */
	@RosettaEnumValue(value = "PK") 
	PK("PK", null),
	
	/**
	 * Palau
	 */
	@RosettaEnumValue(value = "PW") 
	PW("PW", null),
	
	/**
	 * Palestine, State of
	 */
	@RosettaEnumValue(value = "PS") 
	PS("PS", null),
	
	/**
	 * Panama
	 */
	@RosettaEnumValue(value = "PA") 
	PA("PA", null),
	
	/**
	 * Papua New Guinea
	 */
	@RosettaEnumValue(value = "PG") 
	PG("PG", null),
	
	/**
	 * Paraguay
	 */
	@RosettaEnumValue(value = "PY") 
	PY("PY", null),
	
	/**
	 * Peru
	 */
	@RosettaEnumValue(value = "PE") 
	PE("PE", null),
	
	/**
	 * Philippines (the)
	 */
	@RosettaEnumValue(value = "PH") 
	PH("PH", null),
	
	/**
	 * Pitcairn
	 */
	@RosettaEnumValue(value = "PN") 
	PN("PN", null),
	
	/**
	 * Poland
	 */
	@RosettaEnumValue(value = "PL") 
	PL("PL", null),
	
	/**
	 * Portugal
	 */
	@RosettaEnumValue(value = "PT") 
	PT("PT", null),
	
	/**
	 * Puerto Rico
	 */
	@RosettaEnumValue(value = "PR") 
	PR("PR", null),
	
	/**
	 * Qatar
	 */
	@RosettaEnumValue(value = "QA") 
	QA("QA", null),
	
	/**
	 * Romania
	 */
	@RosettaEnumValue(value = "RO") 
	RO("RO", null),
	
	/**
	 * Russian Federation (the)
	 */
	@RosettaEnumValue(value = "RU") 
	RU("RU", null),
	
	/**
	 * Rwanda
	 */
	@RosettaEnumValue(value = "RW") 
	RW("RW", null),
	
	/**
	 * Runion
	 */
	@RosettaEnumValue(value = "RE") 
	RE("RE", null),
	
	/**
	 * Saint Barthlemy
	 */
	@RosettaEnumValue(value = "BL") 
	BL("BL", null),
	
	/**
	 * Saint Helena, Ascension and Tristan da Cunha
	 */
	@RosettaEnumValue(value = "SH") 
	SH("SH", null),
	
	/**
	 * Saint Kitts and Nevis
	 */
	@RosettaEnumValue(value = "KN") 
	KN("KN", null),
	
	/**
	 * Saint Lucia
	 */
	@RosettaEnumValue(value = "LC") 
	LC("LC", null),
	
	/**
	 * Saint Martin (French part)
	 */
	@RosettaEnumValue(value = "MF") 
	MF("MF", null),
	
	/**
	 * Saint Pierre and Miquelon
	 */
	@RosettaEnumValue(value = "PM") 
	PM("PM", null),
	
	/**
	 * Saint Vincent and the Grenadines
	 */
	@RosettaEnumValue(value = "VC") 
	VC("VC", null),
	
	/**
	 * Samoa
	 */
	@RosettaEnumValue(value = "WS") 
	WS("WS", null),
	
	/**
	 * San Marino
	 */
	@RosettaEnumValue(value = "SM") 
	SM("SM", null),
	
	/**
	 * Sao Tome and Principe
	 */
	@RosettaEnumValue(value = "ST") 
	ST("ST", null),
	
	/**
	 * Saudi Arabia
	 */
	@RosettaEnumValue(value = "SA") 
	SA("SA", null),
	
	/**
	 * Senegal
	 */
	@RosettaEnumValue(value = "SN") 
	SN("SN", null),
	
	/**
	 * Serbia
	 */
	@RosettaEnumValue(value = "RS") 
	RS("RS", null),
	
	/**
	 * Seychelles
	 */
	@RosettaEnumValue(value = "SC") 
	SC("SC", null),
	
	/**
	 * Sierra Leone
	 */
	@RosettaEnumValue(value = "SL") 
	SL("SL", null),
	
	/**
	 * Singapore
	 */
	@RosettaEnumValue(value = "SG") 
	SG("SG", null),
	
	/**
	 * Sint Maarten (Dutch part)
	 */
	@RosettaEnumValue(value = "SX") 
	SX("SX", null),
	
	/**
	 * Slovakia
	 */
	@RosettaEnumValue(value = "SK") 
	SK("SK", null),
	
	/**
	 * Slovenia
	 */
	@RosettaEnumValue(value = "SI") 
	SI("SI", null),
	
	/**
	 * Solomon Islands
	 */
	@RosettaEnumValue(value = "SB") 
	SB("SB", null),
	
	/**
	 * Somalia
	 */
	@RosettaEnumValue(value = "SO") 
	SO("SO", null),
	
	/**
	 * South Africa
	 */
	@RosettaEnumValue(value = "ZA") 
	ZA("ZA", null),
	
	/**
	 * South Georgia and the South Sandwich Islands
	 */
	@RosettaEnumValue(value = "GS") 
	GS("GS", null),
	
	/**
	 * South Sudan
	 */
	@RosettaEnumValue(value = "SS") 
	SS("SS", null),
	
	/**
	 * Spain
	 */
	@RosettaEnumValue(value = "ES") 
	ES("ES", null),
	
	/**
	 * Sri Lanka
	 */
	@RosettaEnumValue(value = "LK") 
	LK("LK", null),
	
	/**
	 * Sudan (the)
	 */
	@RosettaEnumValue(value = "SD") 
	SD("SD", null),
	
	/**
	 * Suriname
	 */
	@RosettaEnumValue(value = "SR") 
	SR("SR", null),
	
	/**
	 * Svalbard and Jan Mayen
	 */
	@RosettaEnumValue(value = "SJ") 
	SJ("SJ", null),
	
	/**
	 * Sweden
	 */
	@RosettaEnumValue(value = "SE") 
	SE("SE", null),
	
	/**
	 * Switzerland
	 */
	@RosettaEnumValue(value = "CH") 
	CH("CH", null),
	
	/**
	 * Syrian Arab Republic (the)
	 */
	@RosettaEnumValue(value = "SY") 
	SY("SY", null),
	
	/**
	 * Taiwan (Province of China)
	 */
	@RosettaEnumValue(value = "TW") 
	TW("TW", null),
	
	/**
	 * Tajikistan
	 */
	@RosettaEnumValue(value = "TJ") 
	TJ("TJ", null),
	
	/**
	 * Tanzania, the United Republic of
	 */
	@RosettaEnumValue(value = "TZ") 
	TZ("TZ", null),
	
	/**
	 * Thailand
	 */
	@RosettaEnumValue(value = "TH") 
	TH("TH", null),
	
	/**
	 * Timor-Leste
	 */
	@RosettaEnumValue(value = "TL") 
	TL("TL", null),
	
	/**
	 * Togo
	 */
	@RosettaEnumValue(value = "TG") 
	TG("TG", null),
	
	/**
	 * Tokelau
	 */
	@RosettaEnumValue(value = "TK") 
	TK("TK", null),
	
	/**
	 * Tonga
	 */
	@RosettaEnumValue(value = "TO") 
	TO("TO", null),
	
	/**
	 * Trinidad and Tobago
	 */
	@RosettaEnumValue(value = "TT") 
	TT("TT", null),
	
	/**
	 * Tunisia
	 */
	@RosettaEnumValue(value = "TN") 
	TN("TN", null),
	
	/**
	 * Turkmenistan
	 */
	@RosettaEnumValue(value = "TM") 
	TM("TM", null),
	
	/**
	 * Turks and Caicos Islands (the)
	 */
	@RosettaEnumValue(value = "TC") 
	TC("TC", null),
	
	/**
	 * Tuvalu
	 */
	@RosettaEnumValue(value = "TV") 
	TV("TV", null),
	
	/**
	 * Trkiye
	 */
	@RosettaEnumValue(value = "TR") 
	TR("TR", null),
	
	/**
	 * Uganda
	 */
	@RosettaEnumValue(value = "UG") 
	UG("UG", null),
	
	/**
	 * Ukraine
	 */
	@RosettaEnumValue(value = "UA") 
	UA("UA", null),
	
	/**
	 * United Arab Emirates (the)
	 */
	@RosettaEnumValue(value = "AE") 
	AE("AE", null),
	
	/**
	 * United Kingdom of Great Britain and Northern Ireland (the)
	 */
	@RosettaEnumValue(value = "GB") 
	GB("GB", null),
	
	/**
	 * United States Minor Outlying Islands (the)
	 */
	@RosettaEnumValue(value = "UM") 
	UM("UM", null),
	
	/**
	 * United States of America (the)
	 */
	@RosettaEnumValue(value = "US") 
	US("US", null),
	
	/**
	 * Uruguay
	 */
	@RosettaEnumValue(value = "UY") 
	UY("UY", null),
	
	/**
	 * Uzbekistan
	 */
	@RosettaEnumValue(value = "UZ") 
	UZ("UZ", null),
	
	/**
	 * Vanuatu
	 */
	@RosettaEnumValue(value = "VU") 
	VU("VU", null),
	
	/**
	 * Venezuela (Bolivarian Republic of)
	 */
	@RosettaEnumValue(value = "VE") 
	VE("VE", null),
	
	/**
	 * Viet Nam
	 */
	@RosettaEnumValue(value = "VN") 
	VN("VN", null),
	
	/**
	 * Virgin Islands (British)
	 */
	@RosettaEnumValue(value = "VG") 
	VG("VG", null),
	
	/**
	 * Virgin Islands (U.S.)
	 */
	@RosettaEnumValue(value = "VI") 
	VI("VI", null),
	
	/**
	 * Wallis and Futuna
	 */
	@RosettaEnumValue(value = "WF") 
	WF("WF", null),
	
	/**
	 * Western Sahara*
	 */
	@RosettaEnumValue(value = "EH") 
	EH("EH", null),
	
	/**
	 * Yemen
	 */
	@RosettaEnumValue(value = "YE") 
	YE("YE", null),
	
	/**
	 * Zambia
	 */
	@RosettaEnumValue(value = "ZM") 
	ZM("ZM", null),
	
	/**
	 * Zimbabwe
	 */
	@RosettaEnumValue(value = "ZW") 
	ZW("ZW", null)
;
	private static Map<String, ISOCountryCodeEnum> values;
	static {
        Map<String, ISOCountryCodeEnum> map = new ConcurrentHashMap<>();
		for (ISOCountryCodeEnum instance : ISOCountryCodeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ISOCountryCodeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ISOCountryCodeEnum fromDisplayName(String name) {
		ISOCountryCodeEnum value = values.get(name);
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
