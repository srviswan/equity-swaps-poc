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

__all__ = ['Instrument']


class Instrument(BaseDataClass):
    """
    A type of Asset that is issued by one party to one or more others.
    """
    ListedDerivative: Optional[cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivative] = Field(None, description="A securitized derivative on another asset that is created by an exchange.")
    """
    A securitized derivative on another asset that is created by an exchange.
    """
    Loan: Optional[cdm.base.staticdata.asset.common.Loan.Loan] = Field(None, description="An Asset that represents a loan or borrow obligation.")
    """
    An Asset that represents a loan or borrow obligation.
    """
    Security: Optional[cdm.base.staticdata.asset.common.Security.Security] = Field(None, description="An Asset that is issued by a party to be held by or transferred to others.")
    """
    An Asset that is issued by a party to be held by or transferred to others.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('ListedDerivative', 'Loan', 'Security', necessity=True)

import cdm 
import cdm.base.staticdata.asset.common.ListedDerivative
import cdm.base.staticdata.asset.common.Loan
import cdm.base.staticdata.asset.common.Security
