# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.collateral.CollateralCriteria import CollateralCriteria
from cdm.product.collateral.EligibleCollateralSpecification import EligibleCollateralSpecification
from cdm.product.collateral.CollateralTreatment import CollateralTreatment

__all__ = ['CloneEligibleCollateralWithChangedTreatment']


@replaceable
def CloneEligibleCollateralWithChangedTreatment(inputSpecification: EligibleCollateralSpecification, changedCriteria: CollateralCriteria, changedTreatment: CollateralTreatment) -> EligibleCollateralSpecification:
    """
    Creates a new Eligible Collateral Specification based on an input specification but with one changed criteria with a changed treatment.
    
    Parameters 
    ----------
    inputSpecification : EligibleCollateralSpecification
    
    changedCriteria : CollateralCriteria
    
    changedTreatment : CollateralTreatment
    
    Returns
    -------
    outputSpecification : EligibleCollateralSpecification
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_NoLogicApplied(self):
        return (((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "changedCriteria"), "AllCriteria"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "changedCriteria"), "AnyCriteria")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "changedCriteria"), "NegativeCriteria"))))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    outputSpecification =  rosetta_resolve_attr(self, "inputSpecification")
    outputSpecification = _get_rosetta_object('EligibleCollateralSpecification', 'criteria', _get_rosetta_object('EligibleCollateralCriteria', 'treatment', rosetta_resolve_attr(self, "changedTreatment")))
    
    
    return outputSpecification

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
