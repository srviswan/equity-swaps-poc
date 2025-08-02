# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.functions.ToTime import ToTime

__all__ = ['ToDateTime']


@replaceable
def ToDateTime(date: datetime.date | None) -> datetime.datetime:
    """
    Creates a ZonedDateTime from the provided Date, and defaults the time to 00:00:00 and timezone to UTC.
    
    Parameters 
    ----------
    date : date
    
    Returns
    -------
    zonedDateTime : zonedDateTime
    
    """
    self = inspect.currentframe()
    
    
    zonedDateTime =  zonedDateTime(date=rosetta_resolve_attr(self, "date"), time=ToTime(0, 0, 0), timezone="Z")
    
    
    return zonedDateTime

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
