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

__all__ = ['Loan']

from cdm.base.staticdata.asset.common.InstrumentBase import InstrumentBase

class Loan(InstrumentBase):
    """
    Identifies a loan by referencing an asset identifier and through an optional set of attributes.
    """
    borrower: List[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field([], description="Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn't applicable.")
    """
    Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn't applicable.
    """
    lien: Optional[AttributeWithMeta[str] | str] = Field(None, description="Specifies the seniority level of the lien.")
    """
    Specifies the seniority level of the lien.
    """
    facilityType: Optional[AttributeWithMeta[str] | str] = Field(None, description="Specifies the type of loan facility (letter of credit, revolving, ...).")
    """
    Specifies the type of loan facility (letter of credit, revolving, ...).
    """
    creditAgreementDate: Optional[datetime.date] = Field(None, description="Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.")
    """
    Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
    """
    tranche: Optional[AttributeWithMeta[str] | str] = Field(None, description="Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.")
    """
    Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
    """

import cdm 
import cdm.base.staticdata.party.LegalEntity
