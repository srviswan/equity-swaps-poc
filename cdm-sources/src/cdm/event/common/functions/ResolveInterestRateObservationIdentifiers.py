# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.observable.event.ObservationIdentifier import ObservationIdentifier

__all__ = ['ResolveInterestRateObservationIdentifiers']


@replaceable
def ResolveInterestRateObservationIdentifiers(payout: InterestRatePayout, date: datetime.date) -> ObservationIdentifier:
    """
    Defines which attributes on the InterestRatePayout should be used to locate and resolve the underlier's price, for example for the reset process.
    
    Parameters 
    ----------
    payout : InterestRatePayout
    
    date : date
    
    Returns
    -------
    identifiers : ObservationIdentifier
    
    """
    self = inspect.currentframe()
    
    
    identifiers = _get_rosetta_object('ObservationIdentifier', 'observable', _get_rosetta_object('Observable', 'Index', _get_rosetta_object('Index', 'InterestRateIndex', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "rateSpecification"), "FloatingRateSpecification"), "rateOption"))))
    identifiers = set_rosetta_attr(rosetta_resolve_attr(self, 'identifiers'), 'observationDate', rosetta_resolve_attr(self, "date"))
    
    
    return identifiers

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
