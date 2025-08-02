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

__all__ = ['PaymentRule']


class PaymentRule(BaseDataClass):
    """
    A class defining the payment calculation rule. As of FpML 5.10, percentage rule is the only calculation rule that has been specified as part of the standard.
    """
    percentageRule: Optional[cdm.product.common.settlement.PercentageRule.PercentageRule] = Field(None, description="This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.")
    """
    This attribute is not present as part of the FpML construct, as the payment rule is specialised by means of runtime type extension through the xsi:type.
    """

import cdm 
import cdm.product.common.settlement.PercentageRule
