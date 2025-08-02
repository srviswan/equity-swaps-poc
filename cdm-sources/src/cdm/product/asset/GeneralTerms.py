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

__all__ = ['GeneralTerms']


class GeneralTerms(BaseDataClass):
    """
     A class specifying a set of non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms. The CDM GeneralTerms class corresponds to the FpML GeneralTerms complex type, except that the effectiveDate and scheduledTerminationDate have been positioned as part of the InterestRatePayout class in the CDM instead of in GeneralTerms.
    """
    referenceInformation: Optional[cdm.product.asset.ReferenceInformation.ReferenceInformation] = Field(None, description="This attribute contains all the terms relevant to defining the reference entity and reference obligation(s).")
    """
    This attribute contains all the terms relevant to defining the reference entity and reference obligation(s).
    """
    indexReferenceInformation: Optional[cdm.observable.asset.CreditIndex.CreditIndex] = Field(None, description="This attribute contains all the terms relevant to the underlying Index.")
    """
    This attribute contains all the terms relevant to the underlying Index.
    """
    basketReferenceInformation: Optional[cdm.product.asset.BasketReferenceInformation.BasketReferenceInformation] = Field(None, description="This attribute contains all the terms relevant to defining the Credit Default Swap Basket.")
    """
    This attribute contains all the terms relevant to defining the Credit Default Swap Basket.
    """
    additionalTerm: List[AttributeWithMeta[str] | str] = Field([], description="This attribute is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.")
    """
    This attribute is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
    """
    substitution: Optional[bool] = Field(None, description="Value of this attribute set to 'true' indicates that substitution is applicable.")
    """
    Value of this attribute set to 'true' indicates that substitution is applicable.
    """
    modifiedEquityDelivery: Optional[bool] = Field(None, description="Value of this attribute set to 'true' indicates that modified equity delivery is applicable.")
    """
    Value of this attribute set to 'true' indicates that modified equity delivery is applicable.
    """
    
    @rosetta_condition
    def condition_0_GeneralTermsChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('referenceInformation', 'indexReferenceInformation', 'basketReferenceInformation', necessity=True)
    
    @rosetta_condition
    def condition_1_FpML_cd_41(self):
        """
        FpML validation rule cd-41 - If indexReferenceInformation/tranche does not exist, then modifiedEquityDelivery must not exist.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "modifiedEquityDelivery")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "indexReferenceInformation"), "tranche"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_FpML_cd_42(self):
        """
        FpML validation rule cd-42 - If basketReferenceInformation does not exist, then substitution must not exist.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "substitution")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "basketReferenceInformation"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_BasketReferenceInformationNameOrId(self):
        """
        The BasketReferenceInformation requires either a basket name or a basket identifier.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "basketReferenceInformation"), "basketName")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "basketReferenceInformation"), "basketId")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "basketReferenceInformation")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.ReferenceInformation
import cdm.observable.asset.CreditIndex
import cdm.product.asset.BasketReferenceInformation
