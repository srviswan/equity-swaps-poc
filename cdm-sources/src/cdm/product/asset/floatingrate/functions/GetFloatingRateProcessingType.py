# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.fro.FloatingRateIndexCalculationMethodEnum import FloatingRateIndexCalculationMethodEnum
from cdm.observable.asset.fro.FloatingRateIndexCategoryEnum import FloatingRateIndexCategoryEnum
from cdm.product.asset.FloatingRateSpecification import FloatingRateSpecification
from cdm.observable.asset.fro.functions.FloatingRateIndexMetadata import FloatingRateIndexMetadata
from cdm.product.asset.floatingrate.FloatingRateIndexProcessingTypeEnum import FloatingRateIndexProcessingTypeEnum
from cdm.observable.asset.fro.FloatingRateIndexStyleEnum import FloatingRateIndexStyleEnum

__all__ = ['GetFloatingRateProcessingType']


@replaceable
def GetFloatingRateProcessingType(rateDef: FloatingRateSpecification) -> FloatingRateIndexProcessingTypeEnum:
    """
    Get a classification of  the floating rate is processed. This is based on FRO category, style, and calculation method, as described in the 2021 ISDA Definitions Section 6.6.  The categorization information is obtained from the FRO metadata. .
    
    Parameters 
    ----------
    rateDef : FloatingRateSpecification
    Specification details of the floating rate.
    
    Returns
    -------
    processingType : FloatingRateIndexProcessingTypeEnum
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return rosetta_resolve_attr(FloatingRateIndexProcessingTypeEnum, "OVERNIGHT_AVG")
    
    def _else_fn1():
        return True
    
    def _then_fn0():
        return rosetta_resolve_attr(FloatingRateIndexProcessingTypeEnum, "OIS")
    
    def _else_fn0():
        return if_cond_fn((all_elements(rosetta_resolve_attr(self, "idxStyle"), "=", rosetta_resolve_attr(FloatingRateIndexStyleEnum, "AVERAGE_FRO")) and all_elements(rosetta_resolve_attr(self, "method"), "=", rosetta_resolve_attr(FloatingRateIndexCalculationMethodEnum, "AVERAGE"))), _then_fn1, _else_fn1)
    
    def _then_fn1():
        return rosetta_resolve_attr(FloatingRateIndexProcessingTypeEnum, "SCREEN")
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "calcProcessingType")
    
    def _then_fn3():
        return rosetta_resolve_attr(self, "definitionProcessingType")
    
    def _else_fn3():
        return rosetta_resolve_attr(FloatingRateIndexProcessingTypeEnum, "SCREEN")
    
    def _then_fn2():
        return rosetta_resolve_attr(FloatingRateIndexProcessingTypeEnum, "MODULAR")
    
    def _else_fn2():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "floatingRateDefinition"), "fro")), _then_fn3, _else_fn3)
    
    isCalculatedRate = rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateDef"), "calculationParameters"))
    floatingRateDefinition = FloatingRateIndexMetadata(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateDef"), "rateOption"), "FloatingRateIndex"), "floatingRateIndex"))
    calcDefaults = rosetta_resolve_attr(rosetta_resolve_attr(self, "floatingRateDefinition"), "calculationDefaults")
    category = rosetta_resolve_attr(rosetta_resolve_attr(self, "calcDefaults"), "category")
    idxStyle = rosetta_resolve_attr(rosetta_resolve_attr(self, "calcDefaults"), "indexStyle")
    method = rosetta_resolve_attr(rosetta_resolve_attr(self, "calcDefaults"), "method")
    calcProcessingType = if_cond_fn((all_elements(rosetta_resolve_attr(self, "idxStyle"), "=", rosetta_resolve_attr(FloatingRateIndexStyleEnum, "COMPOUNDED_FRO")) and all_elements(rosetta_resolve_attr(self, "method"), "=", rosetta_resolve_attr(FloatingRateIndexCalculationMethodEnum, "OIS_COMPOUND"))), _then_fn0, _else_fn0)
    definitionProcessingType = if_cond_fn(all_elements(rosetta_resolve_attr(self, "category"), "=", rosetta_resolve_attr(FloatingRateIndexCategoryEnum, "SCREEN_RATE")), _then_fn1, _else_fn1)
    processingCategory = if_cond_fn(all_elements(rosetta_resolve_attr(self, "isCalculatedRate"), "=", True), _then_fn2, _else_fn2)
    processingType =  rosetta_resolve_attr(self, "processingCategory")
    
    
    return processingType

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
