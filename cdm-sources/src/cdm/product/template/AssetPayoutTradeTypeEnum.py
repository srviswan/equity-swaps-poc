# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AssetPayoutTradeTypeEnum']

class AssetPayoutTradeTypeEnum(Enum):
    """
    An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout.
    """
    BUY_SELL_BACK = "Buy/Sell-Back"
    """
    In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo.
    """
    REPO = "Repo"
    """
    In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller.
    """
