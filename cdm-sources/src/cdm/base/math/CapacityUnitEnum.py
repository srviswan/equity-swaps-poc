# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CapacityUnitEnum']

class CapacityUnitEnum(Enum):
    """
    Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
    """
    ALW = "ALW"
    """
    Denotes Allowances as standard unit.
    """
    BBL = "BBL"
    """
    Denotes a Barrel as a standard unit.
    """
    BCF = "BCF"
    """
    Denotes Billion Cubic Feet as a standard unit.
    """
    BDFT = "BDFT"
    """
    Denotes Board Feet as a standard unit.
    """
    CBM = "CBM"
    """
    Denotes Cubic Meters as a standard unit.
    """
    CER = "CER"
    """
    Denotes Certified Emissions Reduction as a standard unit.
    """
    CRT = "CRT"
    """
    Denotes Climate Reserve Tonnes as a standard unit.
    """
    DAG = "DAG"
    """
    Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
    """
    DAY = "DAY"
    """
    Denotes a single day as a standard unit used in time charter trades.
    """
    DMTU = "DMTU"
    """
    Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
    """
    ENVCRD = "ENVCRD"
    """
    Denotes Environmental Credit as a standard unit.
    """
    ENVOFST = "ENVOFST"
    """
    Denotes Environmental Offset as a standard unit.
    """
    FEU = "FEU"
    """
    Denotes a 40 ft. Equivalent Unit container as a standard unit.
    """
    G = "G"
    """
    Denotes a Gram as a standard unit.
    """
    GBBSH = "GBBSH"
    """
    Denotes a GB Bushel as a standard unit.
    """
    GBBTU = "GBBTU"
    """
    Denotes a GB British Thermal Unit as a standard unit.
    """
    GBCWT = "GBCWT"
    """
    Denotes a GB Hundredweight unit as standard unit.
    """
    GBGAL = "GBGAL"
    """
    Denotes a GB Gallon unit as standard unit.
    """
    GBMBTU = "GBMBTU"
    """
    Denotes a Thousand GB British Thermal Units as a standard unit.
    """
    GBMMBTU = "GBMMBTU"
    """
    Denotes a Million GB British Thermal Units as a standard unit.
    """
    GBT = "GBT"
    """
    Denotes a GB Ton as a standard unit.
    """
    GBTHM = "GBTHM"
    """
    Denotes a GB Thermal Unit as a standard unit.
    """
    GJ = "GJ"
    """
    Denotes a Gigajoule as a standard unit.
    """
    GW = "GW"
    """
    Denotes a Gigawatt as a standard unit.
    """
    GWH = "GWH"
    """
    Denotes a Gigawatt-hour as a standard unit.
    """
    HL = "HL"
    """
    Denotes a Hectolitre as a standard unit.
    """
    HOGB = "HOGB"
    """
    Denotes a 100-troy ounces Gold Bar as a standard unit.
    """
    ISOBTU = "ISOBTU"
    """
    Denotes an ISO British Thermal Unit as a standard unit.
    """
    ISOMBTU = "ISOMBTU"
    """
    Denotes a Thousand ISO British Thermal Unit as a standard unit.
    """
    ISOMMBTU = "ISOMMBTU"
    """
    Denotes a Million ISO British Thermal Unit as a standard unit.
    """
    ISOTHM = "ISOTHM"
    """
    Denotes an ISO Thermal Unit as a standard unit.
    """
    J = "J"
    """
    Denotes a Joule as a standard unit.
    """
    KG = "KG"
    """
    Denotes a Kilogram as a standard unit.
    """
    KL = "KL"
    """
    Denotes a Kilolitre as a standard unit.
    """
    KW = "KW"
    """
    Denotes a Kilowatt as a standard unit.
    """
    KWD = "KWD"
    """
    Denotes a Kilowatt-day as a standard unit.
    """
    KWH = "KWH"
    """
    Denotes a Kilowatt-hour as a standard unit.
    """
    KWM = "KWM"
    """
    Denotes a Kilowatt-month as a standard unit.
    """
    KWMIN = "KWMIN"
    """
    Denotes a Kilowatt-minute as a standard unit.
    """
    KWY = "KWY"
    """
    Denotes a Kilowatt-year as a standard unit.
    """
    L = "L"
    """
    Denotes a Litre as a standard unit.
    """
    LB = "LB"
    """
    Denotes a Pound as a standard unit.
    """
    MB = "MB"
    """
    Denotes a Thousand Barrels as a standard unit.
    """
    MBF = "MBF"
    """
    Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
    """
    MJ = "MJ"
    """
    Denotes a Megajoule as a standard unit.
    """
    MMBBL = "MMBBL"
    """
    Denotes a Million Barrels as a standard unit.
    """
    MMBF = "MMBF"
    """
    Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
    """
    MSF = "MSF"
    """
    Denotes a Thousand square feet as a standard unit.
    """
    MT = "MT"
    """
    Denotes a Metric Ton as a standard unit.
    """
    MW = "MW"
    """
    Denotes a Megawatt as a standard unit.
    """
    MWD = "MWD"
    """
    Denotes a Megawatt-day as a standard unit.
    """
    MWH = "MWH"
    """
    Denotes a Megawatt-hour as a standard unit.
    """
    MWM = "MWM"
    """
    Denotes a Megawatt-month as a standard unit.
    """
    MWMIN = "MWMIN"
    """
    Denotes a Megawatt-minute as a standard unit.
    """
    MWY = "MWY"
    """
    Denotes a Megawatt-year as a standard unit.
    """
    OZT = "OZT"
    """
    Denotes a Troy Ounce as a standard unit.
    """
    SGB = "SGB"
    """
    Denotes a Standard Gold Bar as a standard unit.
    """
    TEU = "TEU"
    """
    Denotes a 20 ft. Equivalent Unit container as a standard unit.
    """
    USBSH = "USBSH"
    """
    Denotes a US Bushel as a standard unit.
    """
    USBTU = "USBTU"
    """
    Denotes a US British Thermal Unit as a standard unit.
    """
    USCWT = "USCWT"
    """
    Denotes US Hundredweight unit as a standard unit.
    """
    USGAL = "USGAL"
    """
    Denotes a US Gallon unit as a standard unit.
    """
    USMBTU = "USMBTU"
    """
    Denotes a Thousand US British Thermal Units as a standard unit.
    """
    USMMBTU = "USMMBTU"
    """
    Denotes a Million US British Thermal Units as a standard unit.
    """
    UST = "UST"
    """
    Denotes a US Ton as a standard unit.
    """
    USTHM = "USTHM"
    """
    Denotes a US Thermal Unit as a standard unit.
    """
