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

__all__ = ['Create_RollTermChangeInstruction']


@replaceable
def Create_RollTermChangeInstruction(product: NonTransferableProduct, effectiveRollDate: AdjustableOrRelativeDate, terminationDate: AdjustableOrRelativeDate) -> TermsChangeInstruction:
    """
    Creates the relevant terms change primitive instruction object for rolling a contractual product, which consists in the same terms as the original contractual product but with different effective and termination dates.
    
    Parameters 
    ----------
    product : NonTransferableProduct
    The original contractual product to be rolled.
    
    effectiveRollDate : AdjustableOrRelativeDate
    The date to close and open a new position.
    
    terminationDate : AdjustableOrRelativeDate
    The new termination date.
    
    Returns
    -------
    termsChangeInstruction : TermsChangeInstruction
    
    """
    self = inspect.currentframe()
    
    
    termsChangeInstruction = _get_rosetta_object('TermsChangeInstruction', 'product', rosetta_resolve_attr(self, "product"))
    termsChangeInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'termsChangeInstruction'), 'product->economicTerms->effectiveDate', rosetta_resolve_attr(self, "effectiveRollDate"))
    termsChangeInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'termsChangeInstruction'), 'product->economicTerms->terminationDate', rosetta_resolve_attr(self, "terminationDate"))
    
    
    return termsChangeInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
