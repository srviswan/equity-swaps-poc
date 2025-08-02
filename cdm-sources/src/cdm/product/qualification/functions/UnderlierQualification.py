# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.AssetClassEnum import AssetClassEnum
from cdm.product.template.Underlier import Underlier
from cdm.product.qualification.functions.ObservableQualification import ObservableQualification
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum

__all__ = ['UnderlierQualification']


@replaceable
def UnderlierQualification(underlier: Underlier, securityType: InstrumentTypeEnum | None, assetClass: AssetClassEnum | None) -> bool:
    """
    Identifies whether the underlier(s) have either the specified securityType or assetClass.
    
    Parameters 
    ----------
    underlier : Underlier
    An Underlier is an Observable (eg Asset, Basket or Index) or a Product.
    
    securityType : InstrumentTypeEnum
    
    assetClass : AssetClassEnum
    
    Returns
    -------
    qualifies : boolean
    
    """
    self = inspect.currentframe()
    
    
    qualifies =  (ObservableQualification(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Observable"), rosetta_resolve_attr(self, "securityType"), rosetta_resolve_attr(self, "assetClass")) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "TransferableProduct"), "Instrument"), "Security"), "instrumentType"), "=", rosetta_resolve_attr(self, "securityType")))
    
    
    return qualifies

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
