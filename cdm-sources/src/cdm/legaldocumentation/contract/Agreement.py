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

__all__ = ['Agreement']


class Agreement(BaseDataClass):
    """
    Specification of the standard set of terms that define a legal agreement.
    """
    creditSupportAgreementElections: Optional[cdm.legaldocumentation.csa.CreditSupportAgreementElections.CreditSupportAgreementElections] = Field(None, description="Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.")
    """
    Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.
    """
    collateralTransferAgreementElections: Optional[cdm.legaldocumentation.csa.CollateralTransferAgreementElections.CollateralTransferAgreementElections] = Field(None, description="Elections to specify a Collateral Transfer Agreement.")
    """
    Elections to specify a Collateral Transfer Agreement.
    """
    securityAgreementElections: Optional[cdm.legaldocumentation.csa.SecurityAgreementElections.SecurityAgreementElections] = Field(None, description="Elections to specify a Security agreement.")
    """
    Elections to specify a Security agreement.
    """
    masterAgreementSchedule: Optional[cdm.legaldocumentation.master.MasterAgreementSchedule.MasterAgreementSchedule] = Field(None, description="Elections to specify a Master Agreement Schedule.")
    """
    Elections to specify a Master Agreement Schedule.
    """
    transactionAdditionalTerms: Optional[cdm.legaldocumentation.master.TransactionAdditionalTerms.TransactionAdditionalTerms] = Field(None, description="Any additional terms which mainly intend to specify the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens")
    """
    Any additional terms which mainly intend to specify the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('creditSupportAgreementElections', 'collateralTransferAgreementElections', 'securityAgreementElections', 'masterAgreementSchedule', 'transactionAdditionalTerms', necessity=True)

import cdm 
import cdm.legaldocumentation.csa.CreditSupportAgreementElections
import cdm.legaldocumentation.csa.CollateralTransferAgreementElections
import cdm.legaldocumentation.csa.SecurityAgreementElections
import cdm.legaldocumentation.master.MasterAgreementSchedule
import cdm.legaldocumentation.master.TransactionAdditionalTerms
