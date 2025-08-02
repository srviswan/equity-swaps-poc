# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['BusinessCenterEnum']

class BusinessCenterEnum(Enum):
    """
    The enumerated values to specify the business centers.
    """
    AEAB = "AEAB"
    """
    Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii))
    """
    AEAD = "AEAD"
    """
    Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i))
    """
    AEDU = "AEDU"
    """
    Dubai, United Arab Emirates
    """
    AMYE = "AMYE"
    """
    Yerevan, Armenia
    """
    AOLU = "AOLU"
    """
    Luanda, Angola
    """
    ARBA = "ARBA"
    """
    Buenos Aires, Argentina
    """
    ATVI = "ATVI"
    """
    Vienna, Austria
    """
    AUAD = "AUAD"
    """
    Adelaide, Australia
    """
    AUBR = "AUBR"
    """
    Brisbane, Australia
    """
    AUCA = "AUCA"
    """
    Canberra, Australia
    """
    AUDA = "AUDA"
    """
    Darwin, Australia
    """
    AUME = "AUME"
    """
    Melbourne, Australia
    """
    AUPE = "AUPE"
    """
    Perth, Australia
    """
    AUSY = "AUSY"
    """
    Sydney, Australia
    """
    AZBA = "AZBA"
    """
    Baku, Azerbaijan
    """
    BBBR = "BBBR"
    """
    Bridgetown, Barbados
    """
    BDDH = "BDDH"
    """
    Dhaka, Bangladesh
    """
    BEBR = "BEBR"
    """
    Brussels, Belgium
    """
    BGSO = "BGSO"
    """
    Sofia, Bulgaria
    """
    BHMA = "BHMA"
    """
    Manama, Bahrain
    """
    BMHA = "BMHA"
    """
    Hamilton, Bermuda
    """
    BNBS = "BNBS"
    """
    Bandar Seri Begawan, Brunei
    """
    BOLP = "BOLP"
    """
    La Paz, Bolivia
    """
    BRBD = "BRBD"
    """
    Brazil Business Day.
    """
    BRBR = "BRBR"
    """
    Brasilia, Brazil.
    """
    BRRJ = "BRRJ"
    """
    Rio de Janeiro, Brazil.
    """
    BRSP = "BRSP"
    """
    Sao Paulo, Brazil.
    """
    BSNA = "BSNA"
    """
    Nassau, Bahamas
    """
    BWGA = "BWGA"
    """
    Gaborone, Botswana
    """
    BYMI = "BYMI"
    """
    Minsk, Belarus
    """
    CACL = "CACL"
    """
    Calgary, Canada
    """
    CAFR = "CAFR"
    """
    Fredericton, Canada.
    """
    CAMO = "CAMO"
    """
    Montreal, Canada
    """
    CAOT = "CAOT"
    """
    Ottawa, Canada
    """
    CATO = "CATO"
    """
    Toronto, Canada
    """
    CAVA = "CAVA"
    """
    Vancouver, Canada
    """
    CAWI = "CAWI"
    """
    Winnipeg, Canada
    """
    CHBA = "CHBA"
    """
    Basel, Switzerland
    """
    CHGE = "CHGE"
    """
    Geneva, Switzerland
    """
    CHZU = "CHZU"
    """
    Zurich, Switzerland
    """
    CIAB = "CIAB"
    """
    Abidjan, Cote d'Ivoire
    """
    CLSA = "CLSA"
    """
    Santiago, Chile
    """
    CMYA = "CMYA"
    """
    Yaounde, Cameroon
    """
    CNBE = "CNBE"
    """
    Beijing, China
    """
    CNSH = "CNSH"
    """
    Shanghai, China
    """
    COBO = "COBO"
    """
    Bogota, Colombia
    """
    CRSJ = "CRSJ"
    """
    San Jose, Costa Rica
    """
    CWWI = "CWWI"
    """
    Willemstad, Curacao
    """
    CYNI = "CYNI"
    """
    Nicosia, Cyprus
    """
    CZPR = "CZPR"
    """
    Prague, Czech Republic
    """
    DECO = "DECO"
    """
    Cologne, Germany
    """
    DEDU = "DEDU"
    """
    Dusseldorf, Germany
    """
    DEFR = "DEFR"
    """
    Frankfurt, Germany
    """
    DEHA = "DEHA"
    """
    Hannover, Germany
    """
    DEHH = "DEHH"
    """
    Hamburg, Germany
    """
    DELE = "DELE"
    """
    Leipzig, Germany
    """
    DEMA = "DEMA"
    """
    Mainz, Germany
    """
    DEMU = "DEMU"
    """
    Munich, Germany
    """
    DEST = "DEST"
    """
    Stuttgart, Germany
    """
    DKCO = "DKCO"
    """
    Copenhagen, Denmark
    """
    DOSD = "DOSD"
    """
    Santo Domingo, Dominican Republic
    """
    DZAL = "DZAL"
    """
    Algiers, Algeria
    """
    ECGU = "ECGU"
    """
    Guayaquil, Ecuador
    """
    EETA = "EETA"
    """
    Tallinn, Estonia
    """
    EGCA = "EGCA"
    """
    Cairo, Egypt
    """
    ESAS = "ESAS"
    """
    ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
    """
    ESBA = "ESBA"
    """
    Barcelona, Spain
    """
    ESMA = "ESMA"
    """
    Madrid, Spain
    """
    ESSS = "ESSS"
    """
    San Sebastian, Spain
    """
    ETAA = "ETAA"
    """
    Addis Ababa, Ethiopia
    """
    EUR_ICESWAP = "EUR-ICESWAP"
    """
    Publication dates for ICE Swap rates based on EUR-EURIBOR rates
    """
    EUTA = "EUTA"
    """
    TARGET Settlement Day
    """
    FIHE = "FIHE"
    """
    Helsinki, Finland
    """
    FRPA = "FRPA"
    """
    Paris, France
    """
    GBED = "GBED"
    """
    Edinburgh, Scotland
    """
    GBLO = "GBLO"
    """
    London, United Kingdom
    """
    GBP_ICESWAP = "GBP-ICESWAP"
    """
    Publication dates for GBP ICE Swap rates
    """
    GETB = "GETB"
    """
    Tbilisi, Georgia
    """
    GGSP = "GGSP"
    """
    Saint Peter Port, Guernsey
    """
    GHAC = "GHAC"
    """
    Accra, Ghana
    """
    GIGI = "GIGI"
    """
    Gibraltar, Gibraltar
    """
    GMBA = "GMBA"
    """
    Banjul, Gambia
    """
    GNCO = "GNCO"
    """
    Conakry, Guinea
    """
    GRAT = "GRAT"
    """
    Athens, Greece
    """
    GTGC = "GTGC"
    """
    Guatemala City, Guatemala
    """
    GUGC = "GUGC"
    """
    Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.]
    """
    HKHK = "HKHK"
    """
    Hong Kong, Hong Kong
    """
    HNTE = "HNTE"
    """
    Tegucigalpa, Honduras
    """
    HRZA = "HRZA"
    """
    Zagreb, Republic of Croatia
    """
    HUBU = "HUBU"
    """
    Budapest, Hungary
    """
    IDJA = "IDJA"
    """
    Jakarta, Indonesia
    """
    IEDU = "IEDU"
    """
    Dublin, Ireland
    """
    ILJE = "ILJE"
    """
    Jerusalem, Israel
    """
    ILS_TELBOR = "ILS-TELBOR"
    """
    Publication dates of the ILS-TELBOR index.
    """
    ILTA = "ILTA"
    """
    Tel Aviv, Israel
    """
    INAH = "INAH"
    """
    Ahmedabad, India
    """
    INBA = "INBA"
    """
    Bangalore, India
    """
    INCH = "INCH"
    """
    Chennai, India
    """
    INHY = "INHY"
    """
    Hyderabad, India
    """
    INKO = "INKO"
    """
    Kolkata, India
    """
    INMU = "INMU"
    """
    Mumbai, India
    """
    INND = "INND"
    """
    New Delhi, India
    """
    IQBA = "IQBA"
    """
    Baghdad, Iraq
    """
    IRTE = "IRTE"
    """
    Teheran, Iran
    """
    ISRE = "ISRE"
    """
    Reykjavik, Iceland
    """
    ITMI = "ITMI"
    """
    Milan, Italy
    """
    ITRO = "ITRO"
    """
    Rome, Italy
    """
    ITTU = "ITTU"
    """
    Turin, Italy
    """
    JESH = "JESH"
    """
    St. Helier, Channel Islands, Jersey
    """
    JMKI = "JMKI"
    """
    Kingston, Jamaica
    """
    JOAM = "JOAM"
    """
    Amman, Jordan
    """
    JPTO = "JPTO"
    """
    Tokyo, Japan
    """
    KENA = "KENA"
    """
    Nairobi, Kenya
    """
    KHPP = "KHPP"
    """
    Phnom Penh, Cambodia
    """
    KRSE = "KRSE"
    """
    Seoul, Republic of Korea
    """
    KWKC = "KWKC"
    """
    Kuwait City, Kuwait
    """
    KYGE = "KYGE"
    """
    George Town, Cayman Islands
    """
    KZAL = "KZAL"
    """
    Almaty, Kazakhstan
    """
    LAVI = "LAVI"
    """
    Vientiane, Laos
    """
    LBBE = "LBBE"
    """
    Beirut, Lebanon
    """
    LKCO = "LKCO"
    """
    Colombo, Sri Lanka
    """
    LULU = "LULU"
    """
    Luxembourg, Luxembourg
    """
    LVRI = "LVRI"
    """
    Riga, Latvia
    """
    MACA = "MACA"
    """
    Casablanca, Morocco
    """
    MARA = "MARA"
    """
    Rabat, Morocco
    """
    MCMO = "MCMO"
    """
    Monaco, Monaco
    """
    MNUB = "MNUB"
    """
    Ulan Bator, Mongolia
    """
    MOMA = "MOMA"
    """
    Macau, Macao
    """
    MTVA = "MTVA"
    """
    Valletta, Malta
    """
    MUPL = "MUPL"
    """
    Port Louis, Mauritius
    """
    MVMA = "MVMA"
    """
    Male, Maldives
    """
    MWLI = "MWLI"
    """
    Lilongwe, Malawi
    """
    MXMC = "MXMC"
    """
    Mexico City, Mexico
    """
    MYKL = "MYKL"
    """
    Kuala Lumpur, Malaysia
    """
    MYLA = "MYLA"
    """
    Labuan, Malaysia
    """
    MZMA = "MZMA"
    """
    Maputo, Mozambique
    """
    NAWI = "NAWI"
    """
    Windhoek, Namibia
    """
    NGAB = "NGAB"
    """
    Abuja, Nigeria
    """
    NGLA = "NGLA"
    """
    Lagos, Nigeria
    """
    NLAM = "NLAM"
    """
    Amsterdam, Netherlands
    """
    NLRO = "NLRO"
    """
    Rotterdam, Netherlands
    """
    NOOS = "NOOS"
    """
    Oslo, Norway
    """
    NPKA = "NPKA"
    """
    Kathmandu, Nepal
    """
    NYFD = "NYFD"
    """
    New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7)
    """
    NYSE = "NYSE"
    """
    New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8)
    """
    NZAU = "NZAU"
    """
    Auckland, New Zealand
    """
    NZWE = "NZWE"
    """
    Wellington, New Zealand
    """
    OMMU = "OMMU"
    """
    Muscat, Oman
    """
    PAPC = "PAPC"
    """
    Panama City, Panama
    """
    PELI = "PELI"
    """
    Lima, Peru
    """
    PHMA = "PHMA"
    """
    Manila, Philippines
    """
    PHMK = "PHMK"
    """
    Makati, Philippines
    """
    PKKA = "PKKA"
    """
    Karachi, Pakistan
    """
    PLWA = "PLWA"
    """
    Warsaw, Poland
    """
    PRSJ = "PRSJ"
    """
    San Juan, Puerto Rico
    """
    PTLI = "PTLI"
    """
    Lisbon, Portugal
    """
    QADO = "QADO"
    """
    Doha, Qatar
    """
    ROBU = "ROBU"
    """
    Bucharest, Romania
    """
    RSBE = "RSBE"
    """
    Belgrade, Serbia
    """
    RUMO = "RUMO"
    """
    Moscow, Russian Federation
    """
    SAAB = "SAAB"
    """
    Abha, Saudi Arabia
    """
    SAJE = "SAJE"
    """
    Jeddah, Saudi Arabia
    """
    SARI = "SARI"
    """
    Riyadh, Saudi Arabia
    """
    SEST = "SEST"
    """
    Stockholm, Sweden
    """
    SGSI = "SGSI"
    """
    Singapore, Singapore
    """
    SILJ = "SILJ"
    """
    Ljubljana, Slovenia
    """
    SKBR = "SKBR"
    """
    Bratislava, Slovakia
    """
    SLFR = "SLFR"
    """
    Freetown, Sierra Leone
    """
    SNDA = "SNDA"
    """
    Dakar, Senegal
    """
    SVSS = "SVSS"
    """
    San Salvador, El Salvador
    """
    THBA = "THBA"
    """
    Bangkok, Thailand
    """
    TNTU = "TNTU"
    """
    Tunis, Tunisia
    """
    TRAN = "TRAN"
    """
    Ankara, Turkey
    """
    TRIS = "TRIS"
    """
    Istanbul, Turkey
    """
    TTPS = "TTPS"
    """
    Port of Spain, Trinidad and Tobago
    """
    TWTA = "TWTA"
    """
    Taipei, Taiwan
    """
    TZDA = "TZDA"
    """
    Dar es Salaam, Tanzania
    """
    TZDO = "TZDO"
    """
    Dodoma, Tanzania
    """
    UAKI = "UAKI"
    """
    Kiev, Ukraine
    """
    UGKA = "UGKA"
    """
    Kampala, Uganda
    """
    USBO = "USBO"
    """
    Boston, Massachusetts, United States
    """
    USCH = "USCH"
    """
    Chicago, United States
    """
    USCR = "USCR"
    """
    Charlotte, North Carolina, United States
    """
    USDC = "USDC"
    """
    Washington, District of Columbia, United States
    """
    USDN = "USDN"
    """
    Denver, United States
    """
    USDT = "USDT"
    """
    Detroit, Michigan, United States
    """
    USD_ICESWAP = "USD-ICESWAP"
    """
    Publication dates for ICE Swap rates based on USD-LIBOR rates
    """
    USD_MUNI = "USD-MUNI"
    """
    Publication dates for the USD-Municipal Swap Index
    """
    USGS = "USGS"
    """
    U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
    """
    USHL = "USHL"
    """
    Honolulu, Hawaii, United States
    """
    USHO = "USHO"
    """
    Houston, United States
    """
    USLA = "USLA"
    """
    Los Angeles, United States
    """
    USMB = "USMB"
    """
    Mobile, Alabama, United States
    """
    USMN = "USMN"
    """
    Minneapolis, United States
    """
    USNY = "USNY"
    """
    New York, United States
    """
    USPO = "USPO"
    """
    Portland, Oregon, United States
    """
    USSA = "USSA"
    """
    Sacramento, California, United States
    """
    USSE = "USSE"
    """
    Seattle, United States
    """
    USSF = "USSF"
    """
    San Francisco, United States
    """
    USWT = "USWT"
    """
    Wichita, United States
    """
    UYMO = "UYMO"
    """
    Montevideo, Uruguay
    """
    UZTA = "UZTA"
    """
    Tashkent, Uzbekistan
    """
    VECA = "VECA"
    """
    Caracas, Venezuela
    """
    VGRT = "VGRT"
    """
    Road Town, Virgin Islands (British)
    """
    VNHA = "VNHA"
    """
    Hanoi, Vietnam
    """
    VNHC = "VNHC"
    """
    Ho Chi Minh (formerly Saigon), Vietnam
    """
    YEAD = "YEAD"
    """
    Aden, Yemen
    """
    ZAJO = "ZAJO"
    """
    Johannesburg, South Africa
    """
    ZMLU = "ZMLU"
    """
    Lusaka, Zambia
    """
    ZWHA = "ZWHA"
    """
    Harare, Zimbabwe
    """
