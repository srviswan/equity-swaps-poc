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

__all__ = ['ReferenceObligation']


class ReferenceObligation(BaseDataClass):
    """
    A class to specify the reference obligation that is associated with a credit derivative instrument.
    """
    security: Optional[cdm.base.staticdata.asset.common.Security.Security] = Field(None, description="Identifies the underlying asset when it is a security, such as a bond or convertible bond. The security data type requires one or more productIdentifiers, specificaiton of the security type (e.g. debt), and includes optional attributes to specify a debt class, such as asset-backed, as well as seniority.")
    """
    Identifies the underlying asset when it is a security, such as a bond or convertible bond. The security data type requires one or more productIdentifiers, specificaiton of the security type (e.g. debt), and includes optional attributes to specify a debt class, such as asset-backed, as well as seniority.
    """
    loan: Optional[cdm.base.staticdata.asset.common.Loan.Loan] = Field(None, description="Identifies the underlying asset when it is a loan.")
    """
    Identifies the underlying asset when it is a loan.
    """
    primaryObligor: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor.")
    """
    The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor.
    """
    primaryObligorReference: Optional[AttributeWithReference | cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.")
    """
    A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.
    """
    guarantor: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor.")
    """
    The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor.
    """
    guarantorReference: Optional[str] = Field(None, description="A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.")
    """
    A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.
    """
    standardReferenceObligation: Optional[bool] = Field(None, description="Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.")
    """
    Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.
    """
    
    @rosetta_condition
    def condition_0_AssetChoice(self):
        """
        Represents the choice in a CDS contract.
        """
        item = self
        return self.check_one_of_constraint('security', 'loan', necessity=True)
    
    @rosetta_condition
    def condition_1_MustBeDebtSecurity(self):
        """
        Only debt securities can be used as the reference obligation for a credit derivative.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "security")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_LegalEntityChoice(self):
        """
        Represents the choice in a CDS contract..
        """
        item = self
        return self.check_one_of_constraint('primaryObligor', 'primaryObligorReference', necessity=False)

import cdm 
import cdm.base.staticdata.asset.common.Security
import cdm.base.staticdata.asset.common.Loan
import cdm.base.staticdata.party.LegalEntity
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum
