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

__all__ = ['EquityUnderlierProvisions']


class EquityUnderlierProvisions(BaseDataClass):
    multipleExchangeIndexAnnexFallback: Optional[bool] = Field(None, description="For an index option or swap transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.")
    """
    For an index option or swap transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
    """
    componentSecurityIndexAnnexFallback: Optional[bool] = Field(None, description="For an index option or swap transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.")
    """
    For an index option or swap transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
    """
    localJurisdiction: Optional[AttributeWithMeta[str] | str] = Field(None, description="The ISO 3166 standard code for the country within which the postal address is located.")
    """
    The ISO 3166 standard code for the country within which the postal address is located.
    """
    relevantJurisdiction: Optional[AttributeWithMeta[str] | str] = Field(None, description="The ISO 3166 standard code for the country within which the postal address is located.")
    """
    The ISO 3166 standard code for the country within which the postal address is located.
    """
    
    @rosetta_condition
    def condition_0_ComponentSecurityOrMultipleExchange(self):
        """
        If multipleExchangeIndexAnnexFallback is present then componentSecurityIndexAnnexFallback must be absent and vice versa.
        """
        item = self
        return self.check_one_of_constraint('multipleExchangeIndexAnnexFallback', 'componentSecurityIndexAnnexFallback', necessity=False)

import cdm 
