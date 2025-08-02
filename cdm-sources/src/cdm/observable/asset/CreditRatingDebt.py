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

__all__ = ['CreditRatingDebt']


class CreditRatingDebt(BaseDataClass):
    """
    Specifies the credit rating debt type(s) associated with the credit rating notation and scale. When several debt types are specified, they must be qualified through an 'any' or 'all'.
    """
    debtType: Optional[AttributeWithMeta[str] | str] = Field(None, description="Specifies when there is only one debt type. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.")
    """
    Specifies when there is only one debt type. FpML doesn't specify values in relation to the associated scheme, which is hence not specified as an enumeration as part of the CDM.
    """
    debtTypes: Optional[cdm.observable.asset.MultipleDebtTypes.MultipleDebtTypes] = Field(None, description="Specifies if there are several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.")
    """
    Specifies if there are several debt types, alongside an 'any' or 'all' or all condition. As an example, Baa1 rating is required for any long term debt and deposit.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('debtType', 'debtTypes', necessity=True)

import cdm 
import cdm.observable.asset.MultipleDebtTypes
