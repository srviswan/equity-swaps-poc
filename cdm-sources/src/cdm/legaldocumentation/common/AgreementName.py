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

__all__ = ['AgreementName']


class AgreementName(BaseDataClass):
    """
    Specifies the agreement name through an agreement type and optional detailed sub agreement type.
    """
    agreementType: cdm.legaldocumentation.common.LegalAgreementTypeEnum.LegalAgreementTypeEnum = Field(..., description="Specification of the legal agreement type.")
    """
    Specification of the legal agreement type.
    """
    creditSupportAgreementType: Optional[AttributeWithMeta[cdm.product.collateral.CreditSupportAgreementTypeEnum.CreditSupportAgreementTypeEnum] | cdm.product.collateral.CreditSupportAgreementTypeEnum.CreditSupportAgreementTypeEnum] = Field(None, description="Specification of the credit support agreement type.")
    """
    Specification of the credit support agreement type.
    """
    creditSupportAgreementMarginType: Optional[cdm.product.collateral.CollateralMarginTypeEnum.CollateralMarginTypeEnum] = Field(None, description="specifies the type of margin for which a legal agreement is named.")
    """
    specifies the type of margin for which a legal agreement is named.
    """
    contractualDefinitionsType: List[AttributeWithMeta[cdm.legaldocumentation.common.ContractualDefinitionsEnum.ContractualDefinitionsEnum] | cdm.legaldocumentation.common.ContractualDefinitionsEnum.ContractualDefinitionsEnum] = Field([], description="The definitions such as those published by ISDA that will define the terms of the trade.")
    """
    The definitions such as those published by ISDA that will define the terms of the trade.
    """
    contractualTermsSupplement: List[cdm.legaldocumentation.common.ContractualTermsSupplement.ContractualTermsSupplement] = Field([], description="A contractual supplement (such as those published by ISDA) that will apply to the trade.")
    """
    A contractual supplement (such as those published by ISDA) that will apply to the trade.
    """
    contractualMatrix: List[cdm.legaldocumentation.common.ContractualMatrix.ContractualMatrix] = Field([], description="A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.")
    """
    A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
    """
    masterAgreementType: Optional[AttributeWithMeta[cdm.legaldocumentation.master.MasterAgreementTypeEnum.MasterAgreementTypeEnum] | cdm.legaldocumentation.master.MasterAgreementTypeEnum.MasterAgreementTypeEnum] = Field(None, description="Specification of the master agreement type.")
    """
    Specification of the master agreement type.
    """
    masterConfirmationType: Optional[AttributeWithMeta[cdm.legaldocumentation.master.MasterConfirmationTypeEnum.MasterConfirmationTypeEnum] | cdm.legaldocumentation.master.MasterConfirmationTypeEnum.MasterConfirmationTypeEnum] = Field(None, description="The type of master confirmation executed between the parties.")
    """
    The type of master confirmation executed between the parties.
    """
    masterConfirmationAnnexType: Optional[AttributeWithMeta[cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum.MasterConfirmationAnnexTypeEnum] | cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum.MasterConfirmationAnnexTypeEnum] = Field(None, description="The type of master confirmation annex executed between the parties.")
    """
    The type of master confirmation annex executed between the parties.
    """
    otherAgreement: Optional[str] = Field(None, description="Definition of an agreement that is not enumerated in the CDM.")
    """
    Definition of an agreement that is not enumerated in the CDM.
    """
    
    @rosetta_condition
    def condition_0_AgreementType(self):
        """
        A condition to ensure that the agreement type specified is consistent with the detailed documentation identified.
        """
        item = self
        def _then_fn3():
            return (((not rosetta_attr_exists(rosetta_resolve_attr(self, "contractualDefinitionsType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "contractualTermsSupplement")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "contractualMatrix"))))
        
        def _else_fn3():
            return True
        
        def _then_fn2():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmationAnnexType"))))
        
        def _else_fn2():
            return if_cond_fn(any_elements(rosetta_resolve_attr(self, "agreementType"), "<>", rosetta_resolve_attr(LegalAgreementTypeEnum, "CONFIRMATION")), _then_fn3, _else_fn3)
        
        def _then_fn1():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "masterAgreementType")))
        
        def _else_fn1():
            return if_cond_fn(any_elements(rosetta_resolve_attr(self, "agreementType"), "<>", rosetta_resolve_attr(LegalAgreementTypeEnum, "MASTER_CONFIRMATION")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "otherAgreement")))
        
        def _else_fn0():
            return if_cond_fn(any_elements(rosetta_resolve_attr(self, "agreementType"), "<>", rosetta_resolve_attr(LegalAgreementTypeEnum, "MASTER_AGREEMENT")), _then_fn1, _else_fn1)
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "agreementType"), "<>", rosetta_resolve_attr(LegalAgreementTypeEnum, "OTHER")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_CreditSupportAgreement(self):
        """
        A condition to ensure that the credit supoort agreement type is specified when required.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "creditSupportAgreementType"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "agreementType"), "=", rosetta_resolve_attr(LegalAgreementTypeEnum, "CREDIT_SUPPORT_AGREEMENT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_MasterConfirmation(self):
        """
        If a master confirmation annex type is specified a master confirmation type must exist.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmationType"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmationAnnexType")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_CSAMarginType(self):
        """
        A condition to ensure that CSA margin type is only specified if a credit support agreemnt type is specified.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "creditSupportAgreementType"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "creditSupportAgreementMarginType")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.LegalAgreementTypeEnum
import cdm.product.collateral.CreditSupportAgreementTypeEnum
import cdm.product.collateral.CollateralMarginTypeEnum
import cdm.legaldocumentation.common.ContractualDefinitionsEnum
import cdm.legaldocumentation.common.ContractualTermsSupplement
import cdm.legaldocumentation.common.ContractualMatrix
import cdm.legaldocumentation.master.MasterAgreementTypeEnum
import cdm.legaldocumentation.master.MasterConfirmationTypeEnum
import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum
from cdm.legaldocumentation.common.LegalAgreementTypeEnum import LegalAgreementTypeEnum
