# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.NonTransferableProduct import NonTransferableProduct
from cdm.event.common.TermsChangeInstruction import TermsChangeInstruction
from cdm.event.common.CollateralPortfolio import CollateralPortfolio
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_SubstitutionInstruction']


@replaceable
def Create_SubstitutionInstruction(product: NonTransferableProduct, effectiveDate: AdjustableOrRelativeDate, newCollateralPortfolio: CollateralPortfolio) -> TermsChangeInstruction:
    """
    Creates the terms change instruction that updates the payout with the new substitution payout.
    
    Parameters 
    ----------
    product : NonTransferableProduct
    The original contractual product to be used as the basis of the new trade.
    
    effectiveDate : AdjustableOrRelativeDate
    The effective date of the substitution.
    
    newCollateralPortfolio : CollateralPortfolio
    New collateral portfolio to substitute for the original collateral.
    
    Returns
    -------
    termsChangeInstruction : TermsChangeInstruction
    
    """
    self = inspect.currentframe()
    
    
    termsChangeInstruction =  Create_EffectiveOrTerminationDateTermChangeInstruction(rosetta_resolve_attr(self, "product"), rosetta_resolve_attr(self, "effectiveDate"), [])
    termsChangeInstruction = _get_rosetta_object('TermsChangeInstruction', 'product', _get_rosetta_object('NonTransferableProduct', 'economicTerms', _get_rosetta_object('EconomicTerms', 'collateral', _get_rosetta_object('Collateral', 'collateralPortfolio', rosetta_resolve_attr(self, "newCollateralPortfolio")))))
    
    
    return termsChangeInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
