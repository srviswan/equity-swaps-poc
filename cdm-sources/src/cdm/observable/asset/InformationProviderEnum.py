# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InformationProviderEnum']

class InformationProviderEnum(Enum):
    """
    The enumerated values to specify the list of information providers.
    """
    ASSOC_BANKS_SINGAPORE = "AssocBanksSingapore"
    """
    The Association of Banks in Singapore.
    """
    BANCO_CENTRAL_CHILE = "BancoCentralChile"
    """
    The central bank of Chile.
    """
    BANK_OF_CANADA = "BankOfCanada"
    """
    The central bank of Canada.
    """
    BANK_OF_ENGLAND = "BankOfEngland"
    """
    The Bank Of England.
    """
    BANK_OF_JAPAN = "BankOfJapan"
    """
    The central bank of Japan.
    """
    BLOOMBERG = "Bloomberg"
    """
    Bloomberg LP.
    """
    EURO_CENTRAL_BANK = "EuroCentralBank"
    """
    The European Central Bank.
    """
    FHLBSF = "FHLBSF"
    """
    The Federal Home Loan Bank of San Francisco, or its successor.
    """
    FEDERAL_RESERVE = "FederalReserve"
    """
    The Federal Reserve, the central bank of the United States.
    """
    ICESWAP = "ICESWAP"
    """
    ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate.
    """
    ISDA = "ISDA"
    """
    International Swaps and Derivatives Association, Inc.
    """
    REFINITIV = "Refinitiv"
    """
    Refinitiv, formerly Thomson Reuters Financial & Risk.
    """
    RESERVE_BANK_AUSTRALIA = "ReserveBankAustralia"
    """
    The Reserve Bank of Australia.
    """
    RESERVE_BANK_NEW_ZEALAND = "ReserveBankNewZealand"
    """
    The Reserve Bank of New Zealand.
    """
    REUTERS = "Reuters"
    """
    Reuters Group Plc.
    """
    SAFEX = "SAFEX"
    """
    South African Futures Exchange, or its successor.
    """
    TOKYOSWAP = "TOKYOSWAP"
    """
    The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR.
    """
    TELERATE = "Telerate"
    """
    Telerate, Inc.
    """
