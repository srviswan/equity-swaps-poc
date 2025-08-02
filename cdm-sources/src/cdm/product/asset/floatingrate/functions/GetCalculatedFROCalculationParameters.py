# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.calculatedrate.CalculationMethodEnum import CalculationMethodEnum
from cdm.product.common.schedule.ResetDates import ResetDates
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['GetCalculatedFROCalculationParameters']


@replaceable
def GetCalculatedFROCalculationParameters(resetDates: ResetDates, calcMethod: CalculationMethodEnum) -> FloatingRateCalculationParameters:
    """
    Initialize a calculation parameters block for an OIS or a daily average rate. Used to support FROs that include an embedded calculation.
    
    Parameters 
    ----------
    resetDates : ResetDates
    The reset dates for the interest rate payout for which the calculated rate is being computed.
    
    calcMethod : CalculationMethodEnum
    Whether the rate is a compound (OIS) or daily average rate.
    
    Returns
    -------
    calcParams : FloatingRateCalculationParameters
    
    """
    self = inspect.currentframe()
    
    
    calcParams = _get_rosetta_object('FloatingRateCalculationParameters', 'calculationMethod', rosetta_resolve_attr(self, "calcMethod"))
    calcParams = set_rosetta_attr(rosetta_resolve_attr(self, 'calcParams'), 'applicableBusinessDays', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "fixingDates"), "businessCenters"))
    
    
    return calcParams

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
