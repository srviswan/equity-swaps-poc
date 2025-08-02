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

__all__ = ['DeliverableObligations']


class DeliverableObligations(BaseDataClass):
    """
    A class to specify all the ISDA terms relevant to defining the deliverable obligations.
    """
    accruedInterest: Optional[bool] = Field(None, description="Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.")
    """
    Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
    """
    category: Optional[cdm.base.staticdata.asset.credit.ObligationCategoryEnum.ObligationCategoryEnum] = Field(None, description="Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.")
    """
    Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
    """
    notSubordinated: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.")
    """
    An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
    """
    specifiedCurrency: Optional[cdm.base.staticdata.asset.credit.SpecifiedCurrency.SpecifiedCurrency] = Field(None, description="An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.")
    """
    An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
    """
    notSovereignLender: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.")
    """
    An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
    """
    notDomesticCurrency: Optional[cdm.base.staticdata.asset.credit.NotDomesticCurrency.NotDomesticCurrency] = Field(None, description="An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.")
    """
    An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
    """
    notDomesticLaw: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.")
    """
    An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
    """
    listed: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.")
    """
    An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
    """
    notContingent: Optional[bool] = Field(None, description="A deliverable obligation characteristic. In essence Not Contingent means the repayment of principal cannot be dependant on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.")
    """
    A deliverable obligation characteristic. In essence Not Contingent means the repayment of principal cannot be dependant on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
    """
    notDomesticIssuance: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.")
    """
    An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
    """
    assignableLoan: Optional[cdm.product.common.settlement.PCDeliverableObligationCharac.PCDeliverableObligationCharac] = Field(None, description="A deliverable obligation characteristic. A loan that is freely assignable to a bank or financial institution without the consent of the Reference Entity or the guarantor, if any, of the loan (or the consent of the applicable borrower if a Reference Entity is guaranteeing the loan) or any agent. ISDA 2003 Term: Assignable Loan.")
    """
    A deliverable obligation characteristic. A loan that is freely assignable to a bank or financial institution without the consent of the Reference Entity or the guarantor, if any, of the loan (or the consent of the applicable borrower if a Reference Entity is guaranteeing the loan) or any agent. ISDA 2003 Term: Assignable Loan.
    """
    consentRequiredLoan: Optional[cdm.product.common.settlement.PCDeliverableObligationCharac.PCDeliverableObligationCharac] = Field(None, description="A deliverable obligation characteristic. A loan that is capable of being assigned with the consent of the Reference Entity or the guarantor, if any, of the loan or any agent. ISDA 2003 Term: Consent Required Loan.")
    """
    A deliverable obligation characteristic. A loan that is capable of being assigned with the consent of the Reference Entity or the guarantor, if any, of the loan or any agent. ISDA 2003 Term: Consent Required Loan.
    """
    directLoanParticipation: Optional[cdm.product.common.settlement.LoanParticipation.LoanParticipation] = Field(None, description="A deliverable obligation characteristic. A loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.")
    """
    A deliverable obligation characteristic. A loan with a participation agreement whereby the buyer is capable of creating, or procuring the creation of, a contractual right in favour of the seller that provides the seller with recourse to the participation seller for a specified share in any payments due under the relevant loan which are received by the participation seller. ISDA 2003 Term: Direct Loan Participation.
    """
    transferable: Optional[bool] = Field(None, description="A deliverable obligation characteristic. An obligation that is transferable to institutional investors without any contractual, statutory or regulatory restrictions. ISDA 2003 Term: Transferable.")
    """
    A deliverable obligation characteristic. An obligation that is transferable to institutional investors without any contractual, statutory or regulatory restrictions. ISDA 2003 Term: Transferable.
    """
    maximumMaturity: Optional[cdm.base.datetime.Period.Period] = Field(None, description="A deliverable obligation characteristic. An obligation that has a remaining maturity from the Physical Settlement Date of not greater than the period specified. ISDA 2003 Term: Maximum Maturity.")
    """
    A deliverable obligation characteristic. An obligation that has a remaining maturity from the Physical Settlement Date of not greater than the period specified. ISDA 2003 Term: Maximum Maturity.
    """
    acceleratedOrMatured: Optional[bool] = Field(None, description="A deliverable obligation characteristic. An obligation at time of default is due to mature and due to be repaid, or as a result of downgrade/bankruptcy is due to be repaid as a result of an acceleration clause. ISDA 2003 Term: Accelerated or Matured.")
    """
    A deliverable obligation characteristic. An obligation at time of default is due to mature and due to be repaid, or as a result of downgrade/bankruptcy is due to be repaid as a result of an acceleration clause. ISDA 2003 Term: Accelerated or Matured.
    """
    notBearer: Optional[bool] = Field(None, description="A deliverable obligation characteristic. Any obligation that is not a bearer instrument. This applies to Bonds only and is meant to avoid tax, fraud and security/delivery provisions that can potentially be associated with Bearer Bonds. ISDA 2003 Term: Not Bearer.")
    """
    A deliverable obligation characteristic. Any obligation that is not a bearer instrument. This applies to Bonds only and is meant to avoid tax, fraud and security/delivery provisions that can potentially be associated with Bearer Bonds. ISDA 2003 Term: Not Bearer.
    """
    fullFaithAndCreditObLiability: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.")
    """
    An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
    """
    generalFundObligationLiability: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.")
    """
    An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
    """
    revenueObligationLiability: Optional[bool] = Field(None, description="An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.")
    """
    An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
    """
    indirectLoanParticipation: Optional[cdm.product.common.settlement.LoanParticipation.LoanParticipation] = Field(None, description="ISDA 1999 Term: Indirect Loan Participation. NOTE: Only applicable as a deliverable obligation under ISDA Credit 1999.")
    """
    ISDA 1999 Term: Indirect Loan Participation. NOTE: Only applicable as a deliverable obligation under ISDA Credit 1999.
    """
    excluded: Optional[str] = Field(None, description="A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.")
    """
    A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
    """
    othReferenceEntityObligations: Optional[str] = Field(None, description="This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.")
    """
    This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
    """
    
    @rosetta_condition
    def condition_0_DeliverableObligationsChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('fullFaithAndCreditObLiability', 'generalFundObligationLiability', 'revenueObligationLiability', necessity=False)
    
    @rosetta_condition
    def condition_1_FpML_cd_34(self):
        """
        FpML validation rule cd-34 - Context: DeliverableObligations. If category is equal to 'ReferenceObligationsOnly', then no other elements may be contained in the deliverable obligations element.
        """
        item = self
        def _then_fn0():
            return ((((((((((((((((((((((not rosetta_attr_exists(rosetta_resolve_attr(self, "acceleratedOrMatured"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "accruedInterest")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "assignableLoan")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "consentRequiredLoan")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "directLoanParticipation")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "excluded")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "fullFaithAndCreditObLiability")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "generalFundObligationLiability")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "indirectLoanParticipation")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "listed")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "maximumMaturity")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notBearer")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notContingent")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notDomesticCurrency")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notDomesticIssuance")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notDomesticLaw")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notSovereignLender")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "notSubordinated")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "othReferenceEntityObligations")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "revenueObligationLiability")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "specifiedCurrency")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "transferable"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "category")) and all_elements(rosetta_resolve_attr(self, "category"), "=", rosetta_resolve_attr(ObligationCategoryEnum, "REFERENCE_OBLIGATIONS_ONLY"))), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.credit.ObligationCategoryEnum
import cdm.base.staticdata.asset.credit.SpecifiedCurrency
import cdm.base.staticdata.asset.credit.NotDomesticCurrency
import cdm.product.common.settlement.PCDeliverableObligationCharac
import cdm.product.common.settlement.LoanParticipation
import cdm.base.datetime.Period
from cdm.base.staticdata.asset.credit.ObligationCategoryEnum import ObligationCategoryEnum
