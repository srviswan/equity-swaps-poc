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
from cdm.base.staticdata.asset.common.AssetIdTypeEnum import AssetIdTypeEnum
from cdm.base.staticdata.asset.common.Cash import Cash
from cdm.base.staticdata.asset.common.functions.AssetIdentifierByType import AssetIdentifierByType

__all__ = ['GetCashCurrency']


@replaceable
def GetCashCurrency(cash: Cash) -> CurrencyCodeEnum:
    """
    Returns the enumerated Currency Code of a Cash asset.
    
    Parameters 
    ----------
    cash : Cash
    
    Returns
    -------
    currencyEnum : CurrencyCodeEnum
    
    """
    self = inspect.currentframe()
    
    
    cashId = AssetIdentifierByType(rosetta_resolve_attr(rosetta_resolve_attr(self, "cash"), "identifier"), rosetta_resolve_attr(AssetIdTypeEnum, "CURRENCY_CODE"))
    currencyEnum =  CurrencyCodeEnum(rosetta_resolve_attr(rosetta_resolve_attr(self, "cashId"), "identifier")[0])
    
    
    return currencyEnum

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
