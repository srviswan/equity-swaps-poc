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

__all__ = ['BusinessCenters']


class BusinessCenters(BaseDataClass):
    """
    A class for specifying the business day calendar location used in determining whether a day is a business day or not, either by specifying this business center by reference to an enumerated list that is maintained by the FpML standard, or by reference to such specification when it exists elsewhere as part of the instance document. This class corresponds to the FpML BusinessCentersOrReference.model.
    """
    businessCenter: List[AttributeWithMeta[cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] | cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] = Field([], description="A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.")
    """
    A code identifying one or several business day calendar location(s). The set of business day calendar locations are specified by the business day calendar location enumeration which is maintained by the FpML standard.
    """
    commodityBusinessCalendar: List[AttributeWithMeta[cdm.base.datetime.CommodityBusinessCalendarEnum.CommodityBusinessCalendarEnum] | cdm.base.datetime.CommodityBusinessCalendarEnum.CommodityBusinessCalendarEnum] = Field([], description="")
    businessCentersReference: Optional[AttributeWithReference | cdm.base.datetime.BusinessCenters.BusinessCenters] = Field(None, description="A reference to a financial business center location specified elsewhere in the instance document.")
    """
    A reference to a financial business center location specified elsewhere in the instance document.
    """
    
    @rosetta_condition
    def condition_0_BusinessCentersChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('businessCenter', 'businessCentersReference', 'commodityBusinessCalendar', necessity=True)

import cdm 
import cdm.base.datetime.BusinessCenterEnum
import cdm.base.datetime.CommodityBusinessCalendarEnum
import cdm.base.datetime.BusinessCenters
