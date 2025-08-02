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
from cdm.event.common.TermsChangeInstruction import TermsChangeInstruction
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_CancellationTermChangeInstruction']


@replaceable
def Create_CancellationTermChangeInstruction(product: NonTransferableProduct, cancellationDate: AdjustableOrRelativeDate) -> TermsChangeInstruction:
    """
    Create a terms change instruction for a cancellation that consists in bringing the termination date forward.
    
    Parameters 
    ----------
    product : NonTransferableProduct
    Contractual product of original trade
    
    cancellationDate : AdjustableOrRelativeDate
    The new termination date.
    
    Returns
    -------
    termsChangeInstruction : TermsChangeInstruction
    
    """
    self = inspect.currentframe()
    
    
    termsChangeInstruction = _get_rosetta_object('TermsChangeInstruction', 'product', rosetta_resolve_attr(self, "product"))
    termsChangeInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'termsChangeInstruction'), 'product->economicTerms->terminationDate', rosetta_resolve_attr(self, "cancellationDate"))
    
    
    return termsChangeInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
