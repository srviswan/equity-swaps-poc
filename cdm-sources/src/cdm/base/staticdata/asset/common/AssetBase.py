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

__all__ = ['AssetBase']


class AssetBase(BaseDataClass):
    """
    The base data type to specify common attributes for all Assets.
    """
    identifier: List[cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifier] = Field([], description="Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.")
    """
    Asset Identifiers are used to uniquely identify an Asset, using a specified Asset Identifier Type.
    """
    @rosetta_condition
    def cardinality_identifier(self):
        return check_cardinality(self.identifier, 1, None)
    
    taxonomy: List[cdm.base.staticdata.asset.common.Taxonomy.Taxonomy] = Field([], description="Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.")
    """
    Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object.
    """
    isExchangeListed: Optional[bool] = Field(None, description="Defines whether the Asset is listed on a public exchange.")
    """
    Defines whether the Asset is listed on a public exchange.
    """
    exchange: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="If the Asset is listed, defines the public exchange of the listing.")
    """
    If the Asset is listed, defines the public exchange of the listing.
    """
    relatedExchange: List[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field([], description="Provides the related Exchanges, if applicable.")
    """
    Provides the related Exchanges, if applicable.
    """
    
    @rosetta_condition
    def condition_0_ExchangeListed(self):
        """
        If Exchange is specified, it must be an exchange-listed Instrument.
        """
        item = self
        def _then_fn0():
            return rosetta_resolve_attr(self, "isExchangeListed")
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "exchange")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_RelatedExchange(self):
        """
        Related Exchange should only be specified if an Exchange is also specified.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "relatedExchange")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "exchange"))), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.AssetIdentifier
import cdm.base.staticdata.asset.common.Taxonomy
import cdm.base.staticdata.party.LegalEntity
