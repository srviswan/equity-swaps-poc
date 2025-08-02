# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.Security import Security
from cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018 import EquitySwapMasterConfirmation2018
from cdm.product.template.PerformancePayout import PerformancePayout

__all__ = ['NewSingleNameEquityPerformancePayout']


@replaceable
def NewSingleNameEquityPerformancePayout(security: Security, masterConfirmation: EquitySwapMasterConfirmation2018 | None) -> PerformancePayout:
    """
    Function specification to create the equity payout part of an Equity Swap according to the 2018 ISDA CDM Equity Confirmation template.
    
    Parameters 
    ----------
    security : Security
    
    masterConfirmation : EquitySwapMasterConfirmation2018
    
    Returns
    -------
    performancePayout : PerformancePayout
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_EquitySecurityType(self):
        """
        Security must be equity (single name).
        """
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "EQUITY"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    performancePayout = _get_rosetta_object('PerformancePayout', 'returnTerms', _get_rosetta_object('ReturnTerms', 'priceReturnTerms', _get_rosetta_object('PriceReturnTerms', 'returnType', rosetta_resolve_attr(rosetta_resolve_attr(self, "masterConfirmation"), "typeOfSwapElection"))))
    performancePayout = set_rosetta_attr(rosetta_resolve_attr(self, 'performancePayout'), 'valuationDates', rosetta_resolve_attr(rosetta_resolve_attr(self, "masterConfirmation"), "valuationDates"))
    performancePayout = set_rosetta_attr(rosetta_resolve_attr(self, 'performancePayout'), 'paymentDates', rosetta_resolve_attr(rosetta_resolve_attr(self, "masterConfirmation"), "equityCashSettlementDates"))
    performancePayout = set_rosetta_attr(rosetta_resolve_attr(self, 'performancePayout'), 'settlementTerms', rosetta_resolve_attr(rosetta_resolve_attr(self, "masterConfirmation"), "settlementTerms"))
    
    
    return performancePayout

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
