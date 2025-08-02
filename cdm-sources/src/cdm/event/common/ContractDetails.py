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

__all__ = ['ContractDetails']


class ContractDetails(BaseDataClass):
    """
    Defines specific attributes that relate to contractual details of trades.
    """
    documentation: List[cdm.legaldocumentation.common.LegalAgreement.LegalAgreement] = Field([], description="Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.")
    """
    Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
    """
    governingLaw: Optional[AttributeWithMeta[cdm.legaldocumentation.common.GoverningLawEnum.GoverningLawEnum] | cdm.legaldocumentation.common.GoverningLawEnum.GoverningLawEnum] = Field(None, description="Represents the law governing the trade and associated contractual product terms.")
    """
    Represents the law governing the trade and associated contractual product terms.
    """
    
    @rosetta_condition
    def condition_0_ExecutedAgreement(self):
        """
        Contract details can only only point to  executed legal agreements.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "documentation"), "agreementDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "documentation")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.LegalAgreement
import cdm.legaldocumentation.common.GoverningLawEnum
