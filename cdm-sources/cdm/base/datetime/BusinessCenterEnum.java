package cdm.base.datetime;

import cdm.base.datetime.BusinessCenterEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the business centers.
 * @version 6.0.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/business-center"
 *
 * Provision 
 *
 */
@RosettaEnum("BusinessCenterEnum")
public enum BusinessCenterEnum {

	/**
	 * Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii))
	 */
	@RosettaEnumValue(value = "AEAB") 
	AEAB("AEAB", null),
	
	/**
	 * Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i))
	 */
	@RosettaEnumValue(value = "AEAD") 
	AEAD("AEAD", null),
	
	/**
	 * Dubai, United Arab Emirates
	 */
	@RosettaEnumValue(value = "AEDU") 
	AEDU("AEDU", null),
	
	/**
	 * Yerevan, Armenia
	 */
	@RosettaEnumValue(value = "AMYE") 
	AMYE("AMYE", null),
	
	/**
	 * Luanda, Angola
	 */
	@RosettaEnumValue(value = "AOLU") 
	AOLU("AOLU", null),
	
	/**
	 * Buenos Aires, Argentina
	 */
	@RosettaEnumValue(value = "ARBA") 
	ARBA("ARBA", null),
	
	/**
	 * Vienna, Austria
	 */
	@RosettaEnumValue(value = "ATVI") 
	ATVI("ATVI", null),
	
	/**
	 * Adelaide, Australia
	 */
	@RosettaEnumValue(value = "AUAD") 
	AUAD("AUAD", null),
	
	/**
	 * Brisbane, Australia
	 */
	@RosettaEnumValue(value = "AUBR") 
	AUBR("AUBR", null),
	
	/**
	 * Canberra, Australia
	 */
	@RosettaEnumValue(value = "AUCA") 
	AUCA("AUCA", null),
	
	/**
	 * Darwin, Australia
	 */
	@RosettaEnumValue(value = "AUDA") 
	AUDA("AUDA", null),
	
	/**
	 * Melbourne, Australia
	 */
	@RosettaEnumValue(value = "AUME") 
	AUME("AUME", null),
	
	/**
	 * Perth, Australia
	 */
	@RosettaEnumValue(value = "AUPE") 
	AUPE("AUPE", null),
	
	/**
	 * Sydney, Australia
	 */
	@RosettaEnumValue(value = "AUSY") 
	AUSY("AUSY", null),
	
	/**
	 * Baku, Azerbaijan
	 */
	@RosettaEnumValue(value = "AZBA") 
	AZBA("AZBA", null),
	
	/**
	 * Bridgetown, Barbados
	 */
	@RosettaEnumValue(value = "BBBR") 
	BBBR("BBBR", null),
	
	/**
	 * Dhaka, Bangladesh
	 */
	@RosettaEnumValue(value = "BDDH") 
	BDDH("BDDH", null),
	
	/**
	 * Brussels, Belgium
	 */
	@RosettaEnumValue(value = "BEBR") 
	BEBR("BEBR", null),
	
	/**
	 * Sofia, Bulgaria
	 */
	@RosettaEnumValue(value = "BGSO") 
	BGSO("BGSO", null),
	
	/**
	 * Manama, Bahrain
	 */
	@RosettaEnumValue(value = "BHMA") 
	BHMA("BHMA", null),
	
	/**
	 * Hamilton, Bermuda
	 */
	@RosettaEnumValue(value = "BMHA") 
	BMHA("BMHA", null),
	
	/**
	 * Bandar Seri Begawan, Brunei
	 */
	@RosettaEnumValue(value = "BNBS") 
	BNBS("BNBS", null),
	
	/**
	 * La Paz, Bolivia
	 */
	@RosettaEnumValue(value = "BOLP") 
	BOLP("BOLP", null),
	
	/**
	 * Brazil Business Day.
	 */
	@RosettaEnumValue(value = "BRBD") 
	BRBD("BRBD", null),
	
	/**
	 * Brasilia, Brazil.
	 */
	@RosettaEnumValue(value = "BRBR") 
	BRBR("BRBR", null),
	
	/**
	 * Rio de Janeiro, Brazil.
	 */
	@RosettaEnumValue(value = "BRRJ") 
	BRRJ("BRRJ", null),
	
	/**
	 * Sao Paulo, Brazil.
	 */
	@RosettaEnumValue(value = "BRSP") 
	BRSP("BRSP", null),
	
	/**
	 * Nassau, Bahamas
	 */
	@RosettaEnumValue(value = "BSNA") 
	BSNA("BSNA", null),
	
	/**
	 * Gaborone, Botswana
	 */
	@RosettaEnumValue(value = "BWGA") 
	BWGA("BWGA", null),
	
	/**
	 * Minsk, Belarus
	 */
	@RosettaEnumValue(value = "BYMI") 
	BYMI("BYMI", null),
	
	/**
	 * Calgary, Canada
	 */
	@RosettaEnumValue(value = "CACL") 
	CACL("CACL", null),
	
	/**
	 * Fredericton, Canada.
	 */
	@RosettaEnumValue(value = "CAFR") 
	CAFR("CAFR", null),
	
	/**
	 * Montreal, Canada
	 */
	@RosettaEnumValue(value = "CAMO") 
	CAMO("CAMO", null),
	
	/**
	 * Ottawa, Canada
	 */
	@RosettaEnumValue(value = "CAOT") 
	CAOT("CAOT", null),
	
	/**
	 * Toronto, Canada
	 */
	@RosettaEnumValue(value = "CATO") 
	CATO("CATO", null),
	
	/**
	 * Vancouver, Canada
	 */
	@RosettaEnumValue(value = "CAVA") 
	CAVA("CAVA", null),
	
	/**
	 * Winnipeg, Canada
	 */
	@RosettaEnumValue(value = "CAWI") 
	CAWI("CAWI", null),
	
	/**
	 * Basel, Switzerland
	 */
	@RosettaEnumValue(value = "CHBA") 
	CHBA("CHBA", null),
	
	/**
	 * Geneva, Switzerland
	 */
	@RosettaEnumValue(value = "CHGE") 
	CHGE("CHGE", null),
	
	/**
	 * Zurich, Switzerland
	 */
	@RosettaEnumValue(value = "CHZU") 
	CHZU("CHZU", null),
	
	/**
	 * Abidjan, Cote d&#39;Ivoire
	 */
	@RosettaEnumValue(value = "CIAB") 
	CIAB("CIAB", null),
	
	/**
	 * Santiago, Chile
	 */
	@RosettaEnumValue(value = "CLSA") 
	CLSA("CLSA", null),
	
	/**
	 * Yaounde, Cameroon
	 */
	@RosettaEnumValue(value = "CMYA") 
	CMYA("CMYA", null),
	
	/**
	 * Beijing, China
	 */
	@RosettaEnumValue(value = "CNBE") 
	CNBE("CNBE", null),
	
	/**
	 * Shanghai, China
	 */
	@RosettaEnumValue(value = "CNSH") 
	CNSH("CNSH", null),
	
	/**
	 * Bogota, Colombia
	 */
	@RosettaEnumValue(value = "COBO") 
	COBO("COBO", null),
	
	/**
	 * San Jose, Costa Rica
	 */
	@RosettaEnumValue(value = "CRSJ") 
	CRSJ("CRSJ", null),
	
	/**
	 * Willemstad, Curacao
	 */
	@RosettaEnumValue(value = "CWWI") 
	CWWI("CWWI", null),
	
	/**
	 * Nicosia, Cyprus
	 */
	@RosettaEnumValue(value = "CYNI") 
	CYNI("CYNI", null),
	
	/**
	 * Prague, Czech Republic
	 */
	@RosettaEnumValue(value = "CZPR") 
	CZPR("CZPR", null),
	
	/**
	 * Cologne, Germany
	 */
	@RosettaEnumValue(value = "DECO") 
	DECO("DECO", null),
	
	/**
	 * Dusseldorf, Germany
	 */
	@RosettaEnumValue(value = "DEDU") 
	DEDU("DEDU", null),
	
	/**
	 * Frankfurt, Germany
	 */
	@RosettaEnumValue(value = "DEFR") 
	DEFR("DEFR", null),
	
	/**
	 * Hannover, Germany
	 */
	@RosettaEnumValue(value = "DEHA") 
	DEHA("DEHA", null),
	
	/**
	 * Hamburg, Germany
	 */
	@RosettaEnumValue(value = "DEHH") 
	DEHH("DEHH", null),
	
	/**
	 * Leipzig, Germany
	 */
	@RosettaEnumValue(value = "DELE") 
	DELE("DELE", null),
	
	/**
	 * Mainz, Germany
	 */
	@RosettaEnumValue(value = "DEMA") 
	DEMA("DEMA", null),
	
	/**
	 * Munich, Germany
	 */
	@RosettaEnumValue(value = "DEMU") 
	DEMU("DEMU", null),
	
	/**
	 * Stuttgart, Germany
	 */
	@RosettaEnumValue(value = "DEST") 
	DEST("DEST", null),
	
	/**
	 * Copenhagen, Denmark
	 */
	@RosettaEnumValue(value = "DKCO") 
	DKCO("DKCO", null),
	
	/**
	 * Santo Domingo, Dominican Republic
	 */
	@RosettaEnumValue(value = "DOSD") 
	DOSD("DOSD", null),
	
	/**
	 * Algiers, Algeria
	 */
	@RosettaEnumValue(value = "DZAL") 
	DZAL("DZAL", null),
	
	/**
	 * Guayaquil, Ecuador
	 */
	@RosettaEnumValue(value = "ECGU") 
	ECGU("ECGU", null),
	
	/**
	 * Tallinn, Estonia
	 */
	@RosettaEnumValue(value = "EETA") 
	EETA("EETA", null),
	
	/**
	 * Cairo, Egypt
	 */
	@RosettaEnumValue(value = "EGCA") 
	EGCA("EGCA", null),
	
	/**
	 * ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
	 */
	@RosettaEnumValue(value = "ESAS") 
	ESAS("ESAS", null),
	
	/**
	 * Barcelona, Spain
	 */
	@RosettaEnumValue(value = "ESBA") 
	ESBA("ESBA", null),
	
	/**
	 * Madrid, Spain
	 */
	@RosettaEnumValue(value = "ESMA") 
	ESMA("ESMA", null),
	
	/**
	 * San Sebastian, Spain
	 */
	@RosettaEnumValue(value = "ESSS") 
	ESSS("ESSS", null),
	
	/**
	 * Addis Ababa, Ethiopia
	 */
	@RosettaEnumValue(value = "ETAA") 
	ETAA("ETAA", null),
	
	/**
	 * Publication dates for ICE Swap rates based on EUR-EURIBOR rates
	 */
	@RosettaEnumValue(value = "EUR_ICESWAP", displayName = "EUR-ICESWAP") 
	EUR_ICESWAP("EUR_ICESWAP", "EUR-ICESWAP"),
	
	/**
	 * TARGET Settlement Day
	 */
	@RosettaEnumValue(value = "EUTA") 
	EUTA("EUTA", null),
	
	/**
	 * Helsinki, Finland
	 */
	@RosettaEnumValue(value = "FIHE") 
	FIHE("FIHE", null),
	
	/**
	 * Paris, France
	 */
	@RosettaEnumValue(value = "FRPA") 
	FRPA("FRPA", null),
	
	/**
	 * Edinburgh, Scotland
	 */
	@RosettaEnumValue(value = "GBED") 
	GBED("GBED", null),
	
	/**
	 * London, United Kingdom
	 */
	@RosettaEnumValue(value = "GBLO") 
	GBLO("GBLO", null),
	
	/**
	 * Publication dates for GBP ICE Swap rates
	 */
	@RosettaEnumValue(value = "GBP_ICESWAP", displayName = "GBP-ICESWAP") 
	GBP_ICESWAP("GBP_ICESWAP", "GBP-ICESWAP"),
	
	/**
	 * Tbilisi, Georgia
	 */
	@RosettaEnumValue(value = "GETB") 
	GETB("GETB", null),
	
	/**
	 * Saint Peter Port, Guernsey
	 */
	@RosettaEnumValue(value = "GGSP") 
	GGSP("GGSP", null),
	
	/**
	 * Accra, Ghana
	 */
	@RosettaEnumValue(value = "GHAC") 
	GHAC("GHAC", null),
	
	/**
	 * Gibraltar, Gibraltar
	 */
	@RosettaEnumValue(value = "GIGI") 
	GIGI("GIGI", null),
	
	/**
	 * Banjul, Gambia
	 */
	@RosettaEnumValue(value = "GMBA") 
	GMBA("GMBA", null),
	
	/**
	 * Conakry, Guinea
	 */
	@RosettaEnumValue(value = "GNCO") 
	GNCO("GNCO", null),
	
	/**
	 * Athens, Greece
	 */
	@RosettaEnumValue(value = "GRAT") 
	GRAT("GRAT", null),
	
	/**
	 * Guatemala City, Guatemala
	 */
	@RosettaEnumValue(value = "GTGC") 
	GTGC("GTGC", null),
	
	/**
	 * Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.]
	 */
	@RosettaEnumValue(value = "GUGC") 
	GUGC("GUGC", null),
	
	/**
	 * Hong Kong, Hong Kong
	 */
	@RosettaEnumValue(value = "HKHK") 
	HKHK("HKHK", null),
	
	/**
	 * Tegucigalpa, Honduras
	 */
	@RosettaEnumValue(value = "HNTE") 
	HNTE("HNTE", null),
	
	/**
	 * Zagreb, Republic of Croatia
	 */
	@RosettaEnumValue(value = "HRZA") 
	HRZA("HRZA", null),
	
	/**
	 * Budapest, Hungary
	 */
	@RosettaEnumValue(value = "HUBU") 
	HUBU("HUBU", null),
	
	/**
	 * Jakarta, Indonesia
	 */
	@RosettaEnumValue(value = "IDJA") 
	IDJA("IDJA", null),
	
	/**
	 * Dublin, Ireland
	 */
	@RosettaEnumValue(value = "IEDU") 
	IEDU("IEDU", null),
	
	/**
	 * Jerusalem, Israel
	 */
	@RosettaEnumValue(value = "ILJE") 
	ILJE("ILJE", null),
	
	/**
	 * Publication dates of the ILS-TELBOR index.
	 */
	@RosettaEnumValue(value = "ILS_TELBOR", displayName = "ILS-TELBOR") 
	ILS_TELBOR("ILS_TELBOR", "ILS-TELBOR"),
	
	/**
	 * Tel Aviv, Israel
	 */
	@RosettaEnumValue(value = "ILTA") 
	ILTA("ILTA", null),
	
	/**
	 * Ahmedabad, India
	 */
	@RosettaEnumValue(value = "INAH") 
	INAH("INAH", null),
	
	/**
	 * Bangalore, India
	 */
	@RosettaEnumValue(value = "INBA") 
	INBA("INBA", null),
	
	/**
	 * Chennai, India
	 */
	@RosettaEnumValue(value = "INCH") 
	INCH("INCH", null),
	
	/**
	 * Hyderabad, India
	 */
	@RosettaEnumValue(value = "INHY") 
	INHY("INHY", null),
	
	/**
	 * Kolkata, India
	 */
	@RosettaEnumValue(value = "INKO") 
	INKO("INKO", null),
	
	/**
	 * Mumbai, India
	 */
	@RosettaEnumValue(value = "INMU") 
	INMU("INMU", null),
	
	/**
	 * New Delhi, India
	 */
	@RosettaEnumValue(value = "INND") 
	INND("INND", null),
	
	/**
	 * Baghdad, Iraq
	 */
	@RosettaEnumValue(value = "IQBA") 
	IQBA("IQBA", null),
	
	/**
	 * Teheran, Iran
	 */
	@RosettaEnumValue(value = "IRTE") 
	IRTE("IRTE", null),
	
	/**
	 * Reykjavik, Iceland
	 */
	@RosettaEnumValue(value = "ISRE") 
	ISRE("ISRE", null),
	
	/**
	 * Milan, Italy
	 */
	@RosettaEnumValue(value = "ITMI") 
	ITMI("ITMI", null),
	
	/**
	 * Rome, Italy
	 */
	@RosettaEnumValue(value = "ITRO") 
	ITRO("ITRO", null),
	
	/**
	 * Turin, Italy
	 */
	@RosettaEnumValue(value = "ITTU") 
	ITTU("ITTU", null),
	
	/**
	 * St. Helier, Channel Islands, Jersey
	 */
	@RosettaEnumValue(value = "JESH") 
	JESH("JESH", null),
	
	/**
	 * Kingston, Jamaica
	 */
	@RosettaEnumValue(value = "JMKI") 
	JMKI("JMKI", null),
	
	/**
	 * Amman, Jordan
	 */
	@RosettaEnumValue(value = "JOAM") 
	JOAM("JOAM", null),
	
	/**
	 * Tokyo, Japan
	 */
	@RosettaEnumValue(value = "JPTO") 
	JPTO("JPTO", null),
	
	/**
	 * Nairobi, Kenya
	 */
	@RosettaEnumValue(value = "KENA") 
	KENA("KENA", null),
	
	/**
	 * Phnom Penh, Cambodia
	 */
	@RosettaEnumValue(value = "KHPP") 
	KHPP("KHPP", null),
	
	/**
	 * Seoul, Republic of Korea
	 */
	@RosettaEnumValue(value = "KRSE") 
	KRSE("KRSE", null),
	
	/**
	 * Kuwait City, Kuwait
	 */
	@RosettaEnumValue(value = "KWKC") 
	KWKC("KWKC", null),
	
	/**
	 * George Town, Cayman Islands
	 */
	@RosettaEnumValue(value = "KYGE") 
	KYGE("KYGE", null),
	
	/**
	 * Almaty, Kazakhstan
	 */
	@RosettaEnumValue(value = "KZAL") 
	KZAL("KZAL", null),
	
	/**
	 * Vientiane, Laos
	 */
	@RosettaEnumValue(value = "LAVI") 
	LAVI("LAVI", null),
	
	/**
	 * Beirut, Lebanon
	 */
	@RosettaEnumValue(value = "LBBE") 
	LBBE("LBBE", null),
	
	/**
	 * Colombo, Sri Lanka
	 */
	@RosettaEnumValue(value = "LKCO") 
	LKCO("LKCO", null),
	
	/**
	 * Luxembourg, Luxembourg
	 */
	@RosettaEnumValue(value = "LULU") 
	LULU("LULU", null),
	
	/**
	 * Riga, Latvia
	 */
	@RosettaEnumValue(value = "LVRI") 
	LVRI("LVRI", null),
	
	/**
	 * Casablanca, Morocco
	 */
	@RosettaEnumValue(value = "MACA") 
	MACA("MACA", null),
	
	/**
	 * Rabat, Morocco
	 */
	@RosettaEnumValue(value = "MARA") 
	MARA("MARA", null),
	
	/**
	 * Monaco, Monaco
	 */
	@RosettaEnumValue(value = "MCMO") 
	MCMO("MCMO", null),
	
	/**
	 * Ulan Bator, Mongolia
	 */
	@RosettaEnumValue(value = "MNUB") 
	MNUB("MNUB", null),
	
	/**
	 * Macau, Macao
	 */
	@RosettaEnumValue(value = "MOMA") 
	MOMA("MOMA", null),
	
	/**
	 * Valletta, Malta
	 */
	@RosettaEnumValue(value = "MTVA") 
	MTVA("MTVA", null),
	
	/**
	 * Port Louis, Mauritius
	 */
	@RosettaEnumValue(value = "MUPL") 
	MUPL("MUPL", null),
	
	/**
	 * Male, Maldives
	 */
	@RosettaEnumValue(value = "MVMA") 
	MVMA("MVMA", null),
	
	/**
	 * Lilongwe, Malawi
	 */
	@RosettaEnumValue(value = "MWLI") 
	MWLI("MWLI", null),
	
	/**
	 * Mexico City, Mexico
	 */
	@RosettaEnumValue(value = "MXMC") 
	MXMC("MXMC", null),
	
	/**
	 * Kuala Lumpur, Malaysia
	 */
	@RosettaEnumValue(value = "MYKL") 
	MYKL("MYKL", null),
	
	/**
	 * Labuan, Malaysia
	 */
	@RosettaEnumValue(value = "MYLA") 
	MYLA("MYLA", null),
	
	/**
	 * Maputo, Mozambique
	 */
	@RosettaEnumValue(value = "MZMA") 
	MZMA("MZMA", null),
	
	/**
	 * Windhoek, Namibia
	 */
	@RosettaEnumValue(value = "NAWI") 
	NAWI("NAWI", null),
	
	/**
	 * Abuja, Nigeria
	 */
	@RosettaEnumValue(value = "NGAB") 
	NGAB("NGAB", null),
	
	/**
	 * Lagos, Nigeria
	 */
	@RosettaEnumValue(value = "NGLA") 
	NGLA("NGLA", null),
	
	/**
	 * Amsterdam, Netherlands
	 */
	@RosettaEnumValue(value = "NLAM") 
	NLAM("NLAM", null),
	
	/**
	 * Rotterdam, Netherlands
	 */
	@RosettaEnumValue(value = "NLRO") 
	NLRO("NLRO", null),
	
	/**
	 * Oslo, Norway
	 */
	@RosettaEnumValue(value = "NOOS") 
	NOOS("NOOS", null),
	
	/**
	 * Kathmandu, Nepal
	 */
	@RosettaEnumValue(value = "NPKA") 
	NPKA("NPKA", null),
	
	/**
	 * New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7)
	 */
	@RosettaEnumValue(value = "NYFD") 
	NYFD("NYFD", null),
	
	/**
	 * New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8)
	 */
	@RosettaEnumValue(value = "NYSE") 
	NYSE("NYSE", null),
	
	/**
	 * Auckland, New Zealand
	 */
	@RosettaEnumValue(value = "NZAU") 
	NZAU("NZAU", null),
	
	/**
	 * Wellington, New Zealand
	 */
	@RosettaEnumValue(value = "NZWE") 
	NZWE("NZWE", null),
	
	/**
	 * Muscat, Oman
	 */
	@RosettaEnumValue(value = "OMMU") 
	OMMU("OMMU", null),
	
	/**
	 * Panama City, Panama
	 */
	@RosettaEnumValue(value = "PAPC") 
	PAPC("PAPC", null),
	
	/**
	 * Lima, Peru
	 */
	@RosettaEnumValue(value = "PELI") 
	PELI("PELI", null),
	
	/**
	 * Manila, Philippines
	 */
	@RosettaEnumValue(value = "PHMA") 
	PHMA("PHMA", null),
	
	/**
	 * Makati, Philippines
	 */
	@RosettaEnumValue(value = "PHMK") 
	PHMK("PHMK", null),
	
	/**
	 * Karachi, Pakistan
	 */
	@RosettaEnumValue(value = "PKKA") 
	PKKA("PKKA", null),
	
	/**
	 * Warsaw, Poland
	 */
	@RosettaEnumValue(value = "PLWA") 
	PLWA("PLWA", null),
	
	/**
	 * San Juan, Puerto Rico
	 */
	@RosettaEnumValue(value = "PRSJ") 
	PRSJ("PRSJ", null),
	
	/**
	 * Lisbon, Portugal
	 */
	@RosettaEnumValue(value = "PTLI") 
	PTLI("PTLI", null),
	
	/**
	 * Doha, Qatar
	 */
	@RosettaEnumValue(value = "QADO") 
	QADO("QADO", null),
	
	/**
	 * Bucharest, Romania
	 */
	@RosettaEnumValue(value = "ROBU") 
	ROBU("ROBU", null),
	
	/**
	 * Belgrade, Serbia
	 */
	@RosettaEnumValue(value = "RSBE") 
	RSBE("RSBE", null),
	
	/**
	 * Moscow, Russian Federation
	 */
	@RosettaEnumValue(value = "RUMO") 
	RUMO("RUMO", null),
	
	/**
	 * Abha, Saudi Arabia
	 */
	@RosettaEnumValue(value = "SAAB") 
	SAAB("SAAB", null),
	
	/**
	 * Jeddah, Saudi Arabia
	 */
	@RosettaEnumValue(value = "SAJE") 
	SAJE("SAJE", null),
	
	/**
	 * Riyadh, Saudi Arabia
	 */
	@RosettaEnumValue(value = "SARI") 
	SARI("SARI", null),
	
	/**
	 * Stockholm, Sweden
	 */
	@RosettaEnumValue(value = "SEST") 
	SEST("SEST", null),
	
	/**
	 * Singapore, Singapore
	 */
	@RosettaEnumValue(value = "SGSI") 
	SGSI("SGSI", null),
	
	/**
	 * Ljubljana, Slovenia
	 */
	@RosettaEnumValue(value = "SILJ") 
	SILJ("SILJ", null),
	
	/**
	 * Bratislava, Slovakia
	 */
	@RosettaEnumValue(value = "SKBR") 
	SKBR("SKBR", null),
	
	/**
	 * Freetown, Sierra Leone
	 */
	@RosettaEnumValue(value = "SLFR") 
	SLFR("SLFR", null),
	
	/**
	 * Dakar, Senegal
	 */
	@RosettaEnumValue(value = "SNDA") 
	SNDA("SNDA", null),
	
	/**
	 * San Salvador, El Salvador
	 */
	@RosettaEnumValue(value = "SVSS") 
	SVSS("SVSS", null),
	
	/**
	 * Bangkok, Thailand
	 */
	@RosettaEnumValue(value = "THBA") 
	THBA("THBA", null),
	
	/**
	 * Tunis, Tunisia
	 */
	@RosettaEnumValue(value = "TNTU") 
	TNTU("TNTU", null),
	
	/**
	 * Ankara, Turkey
	 */
	@RosettaEnumValue(value = "TRAN") 
	TRAN("TRAN", null),
	
	/**
	 * Istanbul, Turkey
	 */
	@RosettaEnumValue(value = "TRIS") 
	TRIS("TRIS", null),
	
	/**
	 * Port of Spain, Trinidad and Tobago
	 */
	@RosettaEnumValue(value = "TTPS") 
	TTPS("TTPS", null),
	
	/**
	 * Taipei, Taiwan
	 */
	@RosettaEnumValue(value = "TWTA") 
	TWTA("TWTA", null),
	
	/**
	 * Dar es Salaam, Tanzania
	 */
	@RosettaEnumValue(value = "TZDA") 
	TZDA("TZDA", null),
	
	/**
	 * Dodoma, Tanzania
	 */
	@RosettaEnumValue(value = "TZDO") 
	TZDO("TZDO", null),
	
	/**
	 * Kiev, Ukraine
	 */
	@RosettaEnumValue(value = "UAKI") 
	UAKI("UAKI", null),
	
	/**
	 * Kampala, Uganda
	 */
	@RosettaEnumValue(value = "UGKA") 
	UGKA("UGKA", null),
	
	/**
	 * Boston, Massachusetts, United States
	 */
	@RosettaEnumValue(value = "USBO") 
	USBO("USBO", null),
	
	/**
	 * Chicago, United States
	 */
	@RosettaEnumValue(value = "USCH") 
	USCH("USCH", null),
	
	/**
	 * Charlotte, North Carolina, United States
	 */
	@RosettaEnumValue(value = "USCR") 
	USCR("USCR", null),
	
	/**
	 * Washington, District of Columbia, United States
	 */
	@RosettaEnumValue(value = "USDC") 
	USDC("USDC", null),
	
	/**
	 * Publication dates for ICE Swap rates based on USD-LIBOR rates
	 */
	@RosettaEnumValue(value = "USD_ICESWAP", displayName = "USD-ICESWAP") 
	USD_ICESWAP("USD_ICESWAP", "USD-ICESWAP"),
	
	/**
	 * Publication dates for the USD-Municipal Swap Index
	 */
	@RosettaEnumValue(value = "USD_MUNI", displayName = "USD-MUNI") 
	USD_MUNI("USD_MUNI", "USD-MUNI"),
	
	/**
	 * Denver, United States
	 */
	@RosettaEnumValue(value = "USDN") 
	USDN("USDN", null),
	
	/**
	 * Detroit, Michigan, United States
	 */
	@RosettaEnumValue(value = "USDT") 
	USDT("USDT", null),
	
	/**
	 * U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
	 */
	@RosettaEnumValue(value = "USGS") 
	USGS("USGS", null),
	
	/**
	 * Honolulu, Hawaii, United States
	 */
	@RosettaEnumValue(value = "USHL") 
	USHL("USHL", null),
	
	/**
	 * Houston, United States
	 */
	@RosettaEnumValue(value = "USHO") 
	USHO("USHO", null),
	
	/**
	 * Los Angeles, United States
	 */
	@RosettaEnumValue(value = "USLA") 
	USLA("USLA", null),
	
	/**
	 * Mobile, Alabama, United States
	 */
	@RosettaEnumValue(value = "USMB") 
	USMB("USMB", null),
	
	/**
	 * Minneapolis, United States
	 */
	@RosettaEnumValue(value = "USMN") 
	USMN("USMN", null),
	
	/**
	 * New York, United States
	 */
	@RosettaEnumValue(value = "USNY") 
	USNY("USNY", null),
	
	/**
	 * Portland, Oregon, United States
	 */
	@RosettaEnumValue(value = "USPO") 
	USPO("USPO", null),
	
	/**
	 * Sacramento, California, United States
	 */
	@RosettaEnumValue(value = "USSA") 
	USSA("USSA", null),
	
	/**
	 * Seattle, United States
	 */
	@RosettaEnumValue(value = "USSE") 
	USSE("USSE", null),
	
	/**
	 * San Francisco, United States
	 */
	@RosettaEnumValue(value = "USSF") 
	USSF("USSF", null),
	
	/**
	 * Wichita, United States
	 */
	@RosettaEnumValue(value = "USWT") 
	USWT("USWT", null),
	
	/**
	 * Montevideo, Uruguay
	 */
	@RosettaEnumValue(value = "UYMO") 
	UYMO("UYMO", null),
	
	/**
	 * Tashkent, Uzbekistan
	 */
	@RosettaEnumValue(value = "UZTA") 
	UZTA("UZTA", null),
	
	/**
	 * Caracas, Venezuela
	 */
	@RosettaEnumValue(value = "VECA") 
	VECA("VECA", null),
	
	/**
	 * Road Town, Virgin Islands (British)
	 */
	@RosettaEnumValue(value = "VGRT") 
	VGRT("VGRT", null),
	
	/**
	 * Hanoi, Vietnam
	 */
	@RosettaEnumValue(value = "VNHA") 
	VNHA("VNHA", null),
	
	/**
	 * Ho Chi Minh (formerly Saigon), Vietnam
	 */
	@RosettaEnumValue(value = "VNHC") 
	VNHC("VNHC", null),
	
	/**
	 * Aden, Yemen
	 */
	@RosettaEnumValue(value = "YEAD") 
	YEAD("YEAD", null),
	
	/**
	 * Johannesburg, South Africa
	 */
	@RosettaEnumValue(value = "ZAJO") 
	ZAJO("ZAJO", null),
	
	/**
	 * Lusaka, Zambia
	 */
	@RosettaEnumValue(value = "ZMLU") 
	ZMLU("ZMLU", null),
	
	/**
	 * Harare, Zimbabwe
	 */
	@RosettaEnumValue(value = "ZWHA") 
	ZWHA("ZWHA", null)
;
	private static Map<String, BusinessCenterEnum> values;
	static {
        Map<String, BusinessCenterEnum> map = new ConcurrentHashMap<>();
		for (BusinessCenterEnum instance : BusinessCenterEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BusinessCenterEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BusinessCenterEnum fromDisplayName(String name) {
		BusinessCenterEnum value = values.get(name);
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
