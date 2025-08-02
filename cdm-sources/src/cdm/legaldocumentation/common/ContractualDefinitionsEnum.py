# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ContractualDefinitionsEnum']

class ContractualDefinitionsEnum(Enum):
    """
    The enumerated values to specify a set of standard contract definitions relevant to the transaction.
    """
    ISDA_1991_INTEREST_RATE = "ISDA1991InterestRate"
    """
    ISDA 1991 Interest Rate Definitions
    """
    ISDA_1993_COMMODITY_DERIVATIVES = "ISDA1993CommodityDerivatives"
    """
    ISDA 1993 Commodity Derivatives Definitions
    """
    ISDA_1996_EQUITY_DERIVATIVES = "ISDA1996EquityDerivatives"
    """
    ISDA 1996 Equity Derivatives Definitions
    """
    ISDA_1997_BULLION = "ISDA1997Bullion"
    """
    ISDA 1997 Bullion Definitions
    """
    ISDA_1997_GOVERNMENT_BOND_OPTION = "ISDA1997GovernmentBondOption"
    """
    ISDA 1997 Government Bond Option Definitions
    """
    ISDA_1998_FX_AND_CURRENCY_OPTION = "ISDA1998FxAndCurrencyOption"
    """
    ISDA 1998 FX and Currency Option Definitions
    """
    ISDA_1999_CREDIT_DERIVATIVES = "ISDA1999CreditDerivatives"
    """
    ISDA 1999 Credit Derivatives Definitions
    """
    ISDA2000 = "ISDA2000"
    """
    ISDA 2000 Definitions
    """
    ISDA_2002_EQUITY_DERIVATIVES = "ISDA2002EquityDerivatives"
    """
    ISDA 2002 Equity Derivatives Definitions
    """
    ISDA_2003_CREDIT_DERIVATIVES = "ISDA2003CreditDerivatives"
    """
    ISDA 2003 Credit Derivatives Definitions
    """
    ISDA_2004_NOVATION = "ISDA2004Novation"
    """
    ISDA 2004 Novation Definitions
    """
    ISDA_2005_COMMODITY = "ISDA2005Commodity"
    """
    ISDA 2005 Commodity Definitions
    """
    ISDA2006 = "ISDA2006"
    """
    ISDA 2006 Definitions
    """
    ISDA_2006_INFLATION_DERIVATIVES = "ISDA2006InflationDerivatives"
    """
    ISDA 2006 Inflation Derivatives Definitions
    """
    ISDA_2008_INFLATION_DERIVATIVES = "ISDA2008InflationDerivatives"
    """
    ISDA 2008 Inflation Derivatives Definitions
    """
    ISDA_2011_EQUITY_DERIVATIVES = "ISDA2011EquityDerivatives"
    """
    ISDA 2011 Equity Derivatives Definitions
    """
    ISDA_2014_CREDIT_DERIVATIVES = "ISDA2014CreditDerivatives"
    """
    ISDA 2014 Credit Derivatives Definitions
    """
    ISDA_2021_INTEREST_RATE_DERIVATIVES = "ISDA2021InterestRateDerivatives"
    """
    ISDA 2021 Interest Rate Derivatives Definitions
    """
    ISDA_2022_VERIFIED_CARBON_CREDIT = "ISDA2022VerifiedCarbonCredit"
    """
    ISDA 2022 Verified Carbon Credit Transactions Definitions
    """
    ISDA_2023_DIGITAL_ASSET_DERIVATIVES = "ISDA2023DigitalAssetDerivatives"
    """
    ISDA 2023 Digital Asset Derivatives Definitions
    """
