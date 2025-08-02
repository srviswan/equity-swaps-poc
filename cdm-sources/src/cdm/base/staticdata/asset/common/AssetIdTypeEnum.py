# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AssetIdTypeEnum']

class AssetIdTypeEnum(Enum):
    """
    Extends product identifiers with additional identifier sources for Assets.
    """
    BBGID = "BBGID"
    """
    Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
    """
    BBGTICKER = "BBGTICKER"
    """
    Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
    """
    CUSIP = "CUSIP"
    """
    Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
    """
    CLEARING_CODE = "ClearingCode"
    """
    The identifier follows the symbology set by the clearing house which clears the asset.
    """
    CURRENCY_CODE = "CurrencyCode"
    """
    Used to identify the currency of a Cash Asset.
    """
    EXCHANGE_CODE = "ExchangeCode"
    """
    The identifier follows the symbology set by the exchange which lists the asset.
    """
    FIGI = "FIGI"
    """
    Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
    """
    ISDACRP = "ISDACRP"
    """
    Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
    """
    ISIN = "ISIN"
    """
    Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
    """
    NAME = "Name"
    """
    The name of the product.
    """
    OTHER = "Other"
    """
    Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
    """
    RIC = "RIC"
    """
    Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
    """
    SEDOL = "SEDOL"
    """
    Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well.
    """
    SICOVAM = "Sicovam"
    """
    Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
    """
    UPI = "UPI"
    """
    Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
    """
    WERTPAPIER = "Wertpapier"
    """
    Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
    """
