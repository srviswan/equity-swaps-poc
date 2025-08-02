# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.CurrencyCodeEnum import CurrencyCodeEnum
from cdm.base.staticdata.asset.common.AssetIdentifier import AssetIdentifier
from cdm.base.staticdata.asset.common.Cash import Cash

__all__ = ['SetCashCurrency']


@replaceable
def SetCashCurrency(cash: Cash | None, currency: CurrencyCodeEnum) -> Cash:
    """
    Sets (or updates) the string identifier of a Cash asset using an enumerated Currency Code.
    
    Parameters 
    ----------
    cash : Cash
    
    currency : CurrencyCodeEnum
    
    Returns
    -------
    cashOutput : Cash
    
    """
    self = inspect.currentframe()
    
    
    cashOutput = _get_rosetta_object('Cash', 'identifier', AssetIdentifier(identifier=rosetta_str(rosetta_resolve_attr(self, "currency")), identifierType=rosetta_resolve_attr(AssetIdTypeEnum, "CURRENCY_CODE")))
    
    
    return cashOutput

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
