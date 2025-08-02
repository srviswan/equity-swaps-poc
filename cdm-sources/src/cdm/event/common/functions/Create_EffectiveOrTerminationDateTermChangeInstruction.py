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

__all__ = ['Create_EffectiveOrTerminationDateTermChangeInstruction']


@replaceable
def Create_EffectiveOrTerminationDateTermChangeInstruction(product: NonTransferableProduct, effectiveRollDate: AdjustableOrRelativeDate | None, terminationDate: AdjustableOrRelativeDate | None) -> TermsChangeInstruction:
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
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_DateExists(self):
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "effectiveRollDate")) or rosetta_attr_exists(rosetta_resolve_attr(self, "terminationDate")))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "effectiveRollDate")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "effectiveDate")
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "terminationDate")
    
    def _else_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "terminationDate")
    
    termsChangeInstruction = _get_rosetta_object('TermsChangeInstruction', 'product', rosetta_resolve_attr(self, "product"))
    termsChangeInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'termsChangeInstruction'), 'product->economicTerms->effectiveDate', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "effectiveRollDate")), _then_fn1, _else_fn1))
    termsChangeInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'termsChangeInstruction'), 'product->economicTerms->terminationDate', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "terminationDate")), _then_fn2, _else_fn2))
    
    
    return termsChangeInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
