# pylint: disable=line-too-long, invalid-name, missing-function-docstring
# pylint: disable=bad-indentation, trailing-whitespace, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import
# pylint: disable=wildcard-import, wrong-import-order, missing-class-docstring
# pylint: disable=missing-module-docstring
from __future__ import annotations
from typing import List, Optional
import datetime
import inspect
from decimal import Decimal
from pydantic import Field
from rosetta.runtime.utils import (
    BaseDataClass, rosetta_condition, rosetta_resolve_attr
)
from rosetta.runtime.utils import *

__all__ = ['ContractFormationInstruction']


class ContractFormationInstruction(BaseDataClass):
    """
    Specifies instructions to create a fully formed contract, with optional legal agreements.
    """
    legalAgreement: List[cdm.legaldocumentation.common.LegalAgreement.LegalAgreement] = Field([], description="Optional legal agreements associated to the contract being formed, for instance a master agreement.")
    """
    Optional legal agreements associated to the contract being formed, for instance a master agreement.
    """
    
    @rosetta_condition
    def condition_0_ExecutedAgreements(self):
        """
        The full formation of a contract can only be completed with executed legal agreements.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreement"), "agreementDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "legalAgreement")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.LegalAgreement
