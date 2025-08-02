# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.legaldocumentation.common.LegalAgreement import LegalAgreement
from cdm.event.common.ContractFormationInstruction import ContractFormationInstruction

__all__ = ['Create_ContractFormationInstruction']


@replaceable
def Create_ContractFormationInstruction(legalAgreement: list[LegalAgreement] | None) -> ContractFormationInstruction:
    """
    
    Parameters 
    ----------
    legalAgreement : LegalAgreement
    
    Returns
    -------
    instruction : ContractFormationInstruction
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_ExecutedAgreement(self):
        """
        The full formation of a contract can only be completed with executed legal agreements if any.
        """
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreement"), "agreementDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "legalAgreement")), _then_fn0, _else_fn0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    instruction = rosetta_resolve_attr(self, "legalAgreement")
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
