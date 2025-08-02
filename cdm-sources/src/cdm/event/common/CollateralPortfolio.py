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

__all__ = ['CollateralPortfolio']


class CollateralPortfolio(BaseDataClass):
    """
    Represents common attributes to define the details of collateral assets, to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account.
    """
    portfolioIdentifier: Optional[cdm.base.staticdata.identifier.Identifier.Identifier] = Field(None, description="Specifies a unique identifier for a set of collateral positions in a portfolio.")
    """
    Specifies a unique identifier for a set of collateral positions in a portfolio.
    """
    collateralPosition: List[cdm.event.common.CollateralPosition.CollateralPosition] = Field([], description="Specifies the individual components of the collateral positions in the collateral portfolio.")
    """
    Specifies the individual components of the collateral positions in the collateral portfolio.
    """
    collateralBalance: List[cdm.event.common.CollateralBalance.CollateralBalance] = Field([], description="Represents the populated or calculated collateral aggregate balance amount for the collateral portfolio.")
    """
    Represents the populated or calculated collateral aggregate balance amount for the collateral portfolio.
    """
    legalAgreement: Optional[AttributeWithReference | cdm.legaldocumentation.common.LegalAgreement.LegalAgreement] = Field(None, description=" The specification of a legal agreement between two parties governing the collateral relationship such as Credit Support Agreement or Collateral Transfer Agreement etc. (NB: this can be provided by reference to a global key for each LegalAgreement object).")
    """
     The specification of a legal agreement between two parties governing the collateral relationship such as Credit Support Agreement or Collateral Transfer Agreement etc. (NB: this can be provided by reference to a global key for each LegalAgreement object).
    """

import cdm 
import cdm.base.staticdata.identifier.Identifier
import cdm.event.common.CollateralPosition
import cdm.event.common.CollateralBalance
import cdm.legaldocumentation.common.LegalAgreement
