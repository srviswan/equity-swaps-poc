# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.NonTransferableProduct import NonTransferableProduct
from cdm.product.template.Underlier import Underlier
from cdm.base.staticdata.party.PayerReceiver import PayerReceiver

__all__ = ['Create_NonTransferableProduct']


@replaceable
def Create_NonTransferableProduct(underlier: Underlier, payerReceiver: PayerReceiver) -> NonTransferableProduct:
    """
    Creates a NonTransferableProduct (ie EconomicTerms) from an underlier.
    
    Parameters 
    ----------
    underlier : Underlier
    
    payerReceiver : PayerReceiver
    
    Returns
    -------
    newProduct : NonTransferableProduct
    
    """
    self = inspect.currentframe()
    
    
    newProduct = _get_rosetta_object('NonTransferableProduct', 'economicTerms', _get_rosetta_object('EconomicTerms', 'payout', _get_rosetta_object('Payout', 'SettlementPayout', _get_rosetta_object('SettlementPayout', 'underlier', rosetta_resolve_attr(self, "underlier")))))
    newProduct = set_rosetta_attr(rosetta_resolve_attr(self, 'newProduct'), 'economicTerms->payout->SettlementPayout->payerReceiver', rosetta_resolve_attr(self, "payerReceiver"))
    
    
    return newProduct

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
