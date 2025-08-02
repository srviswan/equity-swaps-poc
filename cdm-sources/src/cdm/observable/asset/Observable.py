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

__all__ = ['Observable']


class Observable(BaseDataClass):
    """
    Specifies the object to be observed for a price, it could be an asset or a reference.
    """
    Asset: Optional[cdm.base.staticdata.asset.common.Asset.Asset] = Field(None, description="The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.")
    """
    The object to be observed is an Asset, ie something that can be owned and transferred in the financial markets.
    """
    Basket: Optional[cdm.observable.asset.Basket.Basket] = Field(None, description="The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.")
    """
    The object to be observed is a Basket, ie a collection of Observables with an identifier and optional weightings.
    """
    Index: Optional[cdm.observable.asset.Index.Index] = Field(None, description="The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.")
    """
    The object to be observed is an Index, ie an observable computed on the prices, rates or valuations of a number of assets.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('Asset', 'Basket', 'Index', necessity=True)

import cdm 
import cdm.base.staticdata.asset.common.Asset
import cdm.observable.asset.Basket
import cdm.observable.asset.Index
