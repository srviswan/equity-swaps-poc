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
from cdm.base.staticdata.party.CounterpartyRoleEnum import CounterpartyRoleEnum

__all__ = ['Update_ProductDirection']


@replaceable
def Update_ProductDirection(before: NonTransferableProduct, originalPayer: CounterpartyRoleEnum, originalReceiver: CounterpartyRoleEnum) -> NonTransferableProduct:
    """
    Flips the payer and receiver on a product (used when a Put Option is exercised).
    
    Parameters 
    ----------
    before : NonTransferableProduct
    
    originalPayer : CounterpartyRoleEnum
    
    originalReceiver : CounterpartyRoleEnum
    
    Returns
    -------
    after : NonTransferableProduct
    
    """
    self = inspect.currentframe()
    
    
    after =  rosetta_resolve_attr(self, "before")
    after = _get_rosetta_object('NonTransferableProduct', 'economicTerms', _get_rosetta_object('EconomicTerms', 'payout', _get_rosetta_object('Payout', 'OptionPayout', _get_rosetta_object('OptionPayout', 'payerReceiver', _get_rosetta_object('PayerReceiver', 'payer', rosetta_resolve_attr(self, "originalReceiver"))))))
    after = set_rosetta_attr(rosetta_resolve_attr(self, 'after'), 'economicTerms->payout->OptionPayout->payerReceiver->receiver', rosetta_resolve_attr(self, "originalPayer"))
    
    
    return after

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
