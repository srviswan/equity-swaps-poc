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

__all__ = ['EligibilityQuery']


class EligibilityQuery(BaseDataClass):
    """
    Query to check against an EligibleCollateralSpecification
    """
    maturity: Decimal = Field(..., description="Maturity in years")
    """
    Maturity in years
    """
    collateralAssetType: cdm.base.staticdata.asset.common.AssetType.AssetType = Field(..., description="The asset product type.")
    """
    The asset product type.
    """
    assetCountryOfOrigin: cdm.base.staticdata.asset.common.ISOCountryCodeEnum.ISOCountryCodeEnum = Field(..., description="The asset country of origin.")
    """
    The asset country of origin.
    """
    denominatedCurrency: cdm.base.staticdata.asset.common.CurrencyCodeEnum.CurrencyCodeEnum = Field(..., description="The underlying asset denominated currency.")
    """
    The underlying asset denominated currency.
    """
    agencyRating: cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteria = Field(..., description="The agency rating based on default risk and creditors claim in event of default associated with specific instrument.")
    """
    The agency rating based on default risk and creditors claim in event of default associated with specific instrument.
    """
    issuerType: cdm.base.staticdata.asset.common.CollateralIssuerType.CollateralIssuerType = Field(..., description="Represents a filter based on the type of entity issuing the asset.")
    """
    Represents a filter based on the type of entity issuing the asset.
    """
    issuerName: cdm.base.staticdata.party.LegalEntity.LegalEntity = Field(..., description="Specifies the issuing entity name or LEI.")
    """
    Specifies the issuing entity name or LEI.
    """

import cdm 
import cdm.base.staticdata.asset.common.AssetType
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum
import cdm.base.staticdata.asset.common.CurrencyCodeEnum
import cdm.product.collateral.AgencyRatingCriteria
import cdm.base.staticdata.asset.common.CollateralIssuerType
import cdm.base.staticdata.party.LegalEntity
