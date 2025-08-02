# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InstrumentTypeEnum']

class InstrumentTypeEnum(Enum):
    """
    Represents an enumeration list to indentify the type of an instrument.
    """
    CERTIFICATE = "Certificate"
    """
    Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
    """
    DEBT = "Debt"
    """
    Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
    """
    EQUITY = "Equity"
    """
    Identifies an instrument as an Equity value of holding of shares in listed company.
    """
    FUND = "Fund"
    """
    Identifies an instrument as representing holding in an investment fund.
    """
    LETTER_OF_CREDIT = "LetterOfCredit"
    """
    Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
    """
    LISTED_DERIVATIVE = "ListedDerivative"
    """
    Identifies an instrument as a listed derivative on an exchange.
    """
    WARRANT = "Warrant"
    """
    Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
    """
