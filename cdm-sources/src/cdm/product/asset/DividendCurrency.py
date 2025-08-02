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

__all__ = ['DividendCurrency']


class DividendCurrency(BaseDataClass):
    """
    A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
    """
    currency: Optional[AttributeWithMeta[str] | str] = Field(None, description="The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.")
    """
    The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
    """
    determinationMethod: Optional[cdm.observable.common.DeterminationMethodEnum.DeterminationMethodEnum] = Field(None, description="Specifies the method according to which the dividend is determined, e.g. the dividend currency.")
    """
    Specifies the method according to which the dividend is determined, e.g. the dividend currency.
    """
    currencyReference: Optional[AttributeWithReference | str] = Field(None, description="Reference to a currency specified elsewhere in the document")
    """
    Reference to a currency specified elsewhere in the document
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('currency', 'determinationMethod', 'currencyReference', necessity=True)

import cdm 
import cdm.observable.common.DeterminationMethodEnum
