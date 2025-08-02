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

__all__ = ['CashCollateralValuationMethod']


class CashCollateralValuationMethod(BaseDataClass):
    """
    This type is a generic structure that can represent the parameters of several mid-market valuation and replacement value methods described in the 2021 ISDA Definitions.
    """
    applicableCsa: Optional[cdm.observable.asset.CsaTypeEnum.CsaTypeEnum] = Field(None, description="This may be used to specify what type of CSA (credit support annex/agreement) is to be used for cash settlement purposes.")
    """
    This may be used to specify what type of CSA (credit support annex/agreement) is to be used for cash settlement purposes.
    """
    cashCollateralCurrency: Optional[str] = Field(None, description="This may be used to indicate the currency of cash collateral for cash settlement purposes.")
    """
    This may be used to indicate the currency of cash collateral for cash settlement purposes.
    """
    cashCollateralInterestRate: Optional[AttributeWithMeta[str] | str] = Field(None, description="This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.")
    """
    This may be used to indicate the interest rate to be used for cash collateral for cash settlement purposes.
    """
    agreedDiscountRate: Optional[AttributeWithMeta[str] | str] = Field(None, description="This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.")
    """
    This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
    """
    protectedParty: List[cdm.observable.asset.PartyDeterminationEnum.PartyDeterminationEnum] = Field([], description="This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).")
    """
    This may be used to specify which party is protected (e.g. under Replacement Value cash settlement methods).
    """
    @rosetta_condition
    def cardinality_protectedParty(self):
        return check_cardinality(self.protectedParty, 0, 2)
    
    prescribedDocumentationAdjustment: Optional[bool] = Field(None, description="This may be used to indicate that 'prescribed documentation adjustment' is applicable.")
    """
    This may be used to indicate that 'prescribed documentation adjustment' is applicable.
    """

import cdm 
import cdm.observable.asset.CsaTypeEnum
import cdm.observable.asset.PartyDeterminationEnum
