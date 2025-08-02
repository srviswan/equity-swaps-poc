# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DebtClassEnum']

class DebtClassEnum(Enum):
    """
    Represents an enumeration list that identifies the type of debt.
    """
    ASSET_BACKED = "AssetBacked"
    """
    Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations.
    """
    CONVERTIBLE = "Convertible"
    """
    Identifies a debt instrument that can be converted into common shares.
    """
    HOLDER_CONVERTIBLE = "HolderConvertible"
    """
    Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer.
    """
    HOLDER_EXCHANGEABLE = "HolderExchangeable"
    """
    Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer.
    """
    ISSUER_CONVERTIBLE = "IssuerConvertible"
    """
    Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
    """
    ISSUER_EXCHANGEABLE = "IssuerExchangeable"
    """
    Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable.
    """
    REG_CAP = "RegCap"
    """
    Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
    """
    STRUCTURED = "Structured"
    """
    Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
    """
    VANILLA = "Vanilla"
    """
    Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
    """
