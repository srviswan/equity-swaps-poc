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

__all__ = ['DebtEconomics']


class DebtEconomics(BaseDataClass):
    """
    Specifies selected economics of a debt instrument.
    """
    debtSeniority: Optional[cdm.base.staticdata.asset.common.DebtSeniorityEnum.DebtSeniorityEnum] = Field(None, description="Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).")
    """
    Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
    """
    debtInterest: Optional[cdm.base.staticdata.asset.common.DebtInterestEnum.DebtInterestEnum] = Field(None, description="Specifies the general rule for periodic interest rate payment.")
    """
    Specifies the general rule for periodic interest rate payment.
    """
    debtPrincipal: Optional[cdm.base.staticdata.asset.common.DebtPrincipalEnum.DebtPrincipalEnum] = Field(None, description="Specifies the general rule for repayment of principal.")
    """
    Specifies the general rule for repayment of principal.
    """

import cdm 
import cdm.base.staticdata.asset.common.DebtSeniorityEnum
import cdm.base.staticdata.asset.common.DebtInterestEnum
import cdm.base.staticdata.asset.common.DebtPrincipalEnum
