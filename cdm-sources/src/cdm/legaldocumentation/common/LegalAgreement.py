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

__all__ = ['LegalAgreement']

from cdm.legaldocumentation.common.LegalAgreementBase import LegalAgreementBase

class LegalAgreement(LegalAgreementBase):
    """
    The specification of a legal agreement between two parties, being negotiated or having been executed. This includes the baseline information and the optional specialised elections
    """
    agreementTerms: Optional[cdm.legaldocumentation.common.AgreementTerms.AgreementTerms] = Field(None, description="Specification of the content of the legal agreement.")
    """
    Specification of the content of the legal agreement.
    """
    relatedAgreements: List[cdm.legaldocumentation.common.LegalAgreement.LegalAgreement] = Field([], description="Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.")
    """
    Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.
    """
    umbrellaAgreement: Optional[cdm.legaldocumentation.common.UmbrellaAgreement.UmbrellaAgreement] = Field(None, description="The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).")
    """
    The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).
    """
    
    @rosetta_condition
    def condition_0_ConsistentlyExecutedAgreements(self):
        """
        An executed agreement can only point to executed related agreements if any.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "relatedAgreements"), "agreementDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "relatedAgreements")) and rosetta_attr_exists(rosetta_resolve_attr(self, "agreementDate"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_AgreementVerification(self):
        """
        A validation rule to ensure that the agreement elections are associated with the correct legal agreement type as specified.
        """
        item = self
        def _then_fn3():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreementIdentification"), "agreementName"), "agreementType"), "=", rosetta_resolve_attr(LegalAgreementTypeEnum, "MASTER_AGREEMENT"))
        
        def _else_fn3():
            return True
        
        def _then_fn2():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreementIdentification"), "agreementName"), "creditSupportAgreementType"), "=", rosetta_resolve_attr(CreditSupportAgreementTypeEnum, "COLLATERAL_TRANSFER_AGREEMENT"))
        
        def _else_fn2():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "agreementTerms"), "agreement"), "masterAgreementSchedule")), _then_fn3, _else_fn3)
        
        def _then_fn1():
            return (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreementIdentification"), "agreementName"), "creditSupportAgreementType"), "=", rosetta_resolve_attr(CreditSupportAgreementTypeEnum, "CREDIT_SUPPORT_ANNEX")) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreementIdentification"), "agreementName"), "creditSupportAgreementType"), "=", rosetta_resolve_attr(CreditSupportAgreementTypeEnum, "CREDIT_SUPPORT_DEED")))
        
        def _else_fn1():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "agreementTerms"), "agreement"), "collateralTransferAgreementElections")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "legalAgreementIdentification"), "agreementName"), "agreementType"), "=", rosetta_resolve_attr(LegalAgreementTypeEnum, "SECURITY_AGREEMENT"))
        
        def _else_fn0():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "agreementTerms"), "agreement"), "creditSupportAgreementElections")), _then_fn1, _else_fn1)
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "agreementTerms"), "agreement"), "securityAgreementElections")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.AgreementTerms
import cdm.legaldocumentation.common.LegalAgreement
import cdm.legaldocumentation.common.UmbrellaAgreement
from cdm.legaldocumentation.common.LegalAgreementTypeEnum import LegalAgreementTypeEnum
from cdm.product.collateral.CreditSupportAgreementTypeEnum import CreditSupportAgreementTypeEnum
