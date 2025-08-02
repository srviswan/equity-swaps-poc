# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MasterConfirmationAnnexTypeEnum']

class MasterConfirmationAnnexTypeEnum(Enum):
    """
    The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction.
    """
    ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER = "ISDA2004IndexVarianceSwapAmericasInterdealer"
    """
    The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER = "ISDA2004ShareVarianceSwapAmericasInterdealer"
    """
    The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN = "ISDA2007DispersionVarianceSwapEuropean"
    """
    The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies.
    """
    ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN = "ISDA2007EquityFinanceSwapEuropean"
    """
    The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER = "ISDA2007IndexVarianceSwapAmericasInterdealer"
    """
    The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER = "ISDA2007ShareVarianceSwapAmericasInterdealer"
    """
    The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_OPTION_EUROPEAN = "ISDA2007VarianceOptionEuropean"
    """
    The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN = "ISDA2008EquityFinanceSwapAsiaExcludingJapan"
    """
    The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1 = "ISDA2008EquityFinanceSwapAsiaExcludingJapanRev1"
    """
    The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN = "ISDA2008EquityOptionAsiaExcludingJapan"
    """
    The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1 = "ISDA2008EquityOptionAsiaExcludingJapanRev1"
    """
    The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_OPTION_JAPAN = "ISDA2008EquityOptionJapan"
    """
    The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN = "ISDA2009ClosedMarketsOptionsAsiaExcludingJapan"
    """
    The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_EQUITY_EUROPEAN_IS = "ISDA2009EquityEuropeanIS"
    """
    The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS = "ISDA2009EquityEuropeanInterdealerSS"
    """
    The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_INDEX_SHARE_OPTION_AMERICAS = "ISDA2009IndexShareOptionAmericas"
    """
    The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER = "ISDA2009IndexSwapEuropeanInterdealer"
    """
    The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER = "ISDA2009IndexSwapPanAsiaInterdealer"
    """
    The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_SHARE_SWAP_PAN_ASIA = "ISDA2009ShareSwapPanAsia"
    """
    The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER = "ISDA2010FairValueShareSwapEuropeanInterdealer"
    """
    The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER = "ISDA2010IndexShareOptionEMEAInterdealer"
    """
    The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
