# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['QuotationSideEnum']

class QuotationSideEnum(Enum):
    """
    The enumerated values to specify the side from which perspective a value is quoted.
    """
    AFTERNOON = "Afternoon"
    """
    Denotes a value as the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    ASK = "Ask"
    """
    Denotes a value 'asked' by a seller for an asset, i.e. the value at which a seller is willing to sell.
    """
    BID = "Bid"
    """
    Denotes a value 'bid' by a buyer for an asset, i.e. the value a buyer is willing to pay.
    """
    CLOSING = "Closing"
    """
    Denotes a value as the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    HIGH = "High"
    """
    Denotes a value as the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    INDEX = "Index"
    """
    Denotes a value as the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    LOCATIONAL_MARGINAL = "LocationalMarginal"
    """
    Denotes a value as the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    LOW = "Low"
    """
    Denotes a value as the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MARGINAL_HOURLY = "MarginalHourly"
    """
    Denotes a value as the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MARKET_CLEARING = "MarketClearing"
    """
    Denotes a value as the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MEAN_OF_BID_AND_ASK = "MeanOfBidAndAsk"
    """
    Denotes a value as the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MEAN_OF_HIGH_AND_LOW = "MeanOfHighAndLow"
    """
    Denotes a value as the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MID = "Mid"
    """
    Denotes a value as the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    MORNING = "Morning"
    """
    Denotes a value as the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    NATIONAL_SINGLE = "NationalSingle"
    """
    Denotes a value as the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    OSP = "OSP"
    """
    Denotes a value as the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    OFFICIAL = "Official"
    """
    Denotes a value as the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    OPENING = "Opening"
    """
    Denotes a value as the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    SETTLEMENT = "Settlement"
    """
    Denotes a value as the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    SPOT = "Spot"
    """
    Denotes a value as the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    """
    UN_WEIGHTED_AVERAGE = "UnWeightedAverage"
    """
    Denotes a value as the Non-volume Weighted Average of prices effective on the Pricing Date.
    """
    WEIGHTED_AVERAGE = "WeightedAverage"
    """
    Denotes a value as the Volume Weighted Average of prices effective on the Pricing Date.
    """
