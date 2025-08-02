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

__all__ = ['Trade']

from cdm.product.template.TradableProduct import TradableProduct

class Trade(TradableProduct):
    """
    Defines the output of a financial transaction between parties - a Business Event. A Trade impacts the financial position (i.e. the balance sheet) of involved parties.
    """
    tradeIdentifier: List[cdm.event.common.TradeIdentifier.TradeIdentifier] = Field([], description="Represents the identifier(s) that uniquely identify a trade for an identity issuer. A trade can include multiple identifiers, for example a trade that is reportable to both the CFTC and ESMA, and then has an associated USI (Unique Swap Identifier) UTI (Unique Trade Identifier).")
    """
    Represents the identifier(s) that uniquely identify a trade for an identity issuer. A trade can include multiple identifiers, for example a trade that is reportable to both the CFTC and ESMA, and then has an associated USI (Unique Swap Identifier) UTI (Unique Trade Identifier).
    """
    @rosetta_condition
    def cardinality_tradeIdentifier(self):
        return check_cardinality(self.tradeIdentifier, 1, None)
    
    tradeDate: AttributeWithMeta[datetime.date] | datetime.date = Field(..., description="Specifies the date which the trade was agreed.")
    """
    Specifies the date which the trade was agreed.
    """
    tradeTime: Optional[AttributeWithMeta[cdm.base.datetime.TimeZone.TimeZone] | cdm.base.datetime.TimeZone.TimeZone] = Field(None, description="Denotes the trade time and timezone as agreed by the parties to the trade.")
    """
    Denotes the trade time and timezone as agreed by the parties to the trade.
    """
    party: List[cdm.base.staticdata.party.Party.Party] = Field([], description="Represents the parties to the trade. The cardinality is optional to address the case where the trade is defined within a BusinessEvent data type, in which case the party is specified in BusinessEvent.")
    """
    Represents the parties to the trade. The cardinality is optional to address the case where the trade is defined within a BusinessEvent data type, in which case the party is specified in BusinessEvent.
    """
    partyRole: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="Represents the role each specified party takes in the trade. further to the principal roles, payer and receiver.")
    """
    Represents the role each specified party takes in the trade. further to the principal roles, payer and receiver.
    """
    executionDetails: Optional[cdm.event.common.ExecutionDetails.ExecutionDetails] = Field(None, description="Represents information specific to trades that arose from executions.")
    """
    Represents information specific to trades that arose from executions.
    """
    contractDetails: Optional[cdm.event.common.ContractDetails.ContractDetails] = Field(None, description="Represents information specific to trades involving contractual products.")
    """
    Represents information specific to trades involving contractual products.
    """
    clearedDate: Optional[datetime.date] = Field(None, description="Specifies the date on which a trade is cleared (novated) through a central counterparty clearing service.")
    """
    Specifies the date on which a trade is cleared (novated) through a central counterparty clearing service.
    """
    collateral: Optional[cdm.product.collateral.Collateral.Collateral] = Field(None, description="Represents the collateral obligations of a party.")
    """
    Represents the collateral obligations of a party.
    """
    account: List[cdm.base.staticdata.party.Account.Account] = Field([], description="Represents a party's granular account information, which may be used in subsequent internal processing.")
    """
    Represents a party's granular account information, which may be used in subsequent internal processing.
    """
    
    @rosetta_condition
    def condition_0_SettlementPayout(self):
        """
        When the product uses a settlement payout, both buyer and seller party roles, and a price, must exist.
        """
        item = self
        def _then_fn0():
            return ((contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "BUYER")) and contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "SELLER"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot"), "priceQuantity"), "price")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(SettlementPayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_PackageTrade(self):
        """
        When the trade is part of a package as specified in the execution details, the trade identifier must be found as one of the package components.
        """
        item = self
        def _then_fn0():
            return contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "executionDetails"), "packageReference"), "componentId"), "assignedIdentifier"), rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeIdentifier"), "assignedIdentifier"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "executionDetails"), "packageReference")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_DeliverableObligationsPhysicalSettlementMatrix(self):
        """
        The below set of credit deliverable obligation provisions are specified as optional boolean in FpML and the CDM because they would be specified as part of the Physical Settlement Matrix when such document governs the contract terms. As a result, this data rule specifies that those provisions cannot be omitted if the Credit Derivatives Physical Settlement Matrix doesn't governs the terms of the contract.
        """
        item = self
        def _then_fn0():
            return ((((((((((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notSubordinated")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "specifiedCurrency"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notSovereignLender"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notDomesticCurrency"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notDomesticLaw"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notContingent"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notDomesticIssuance"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "assignableLoan"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "consentRequiredLoan"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "transferable"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "maximumMaturity"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "notBearer"))) and ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "fullFaithAndCreditObLiability")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "generalFundObligationLiability"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "revenueObligationLiability"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType"), "<>", rosetta_resolve_attr(MatrixTypeEnum, "CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")) or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_ObligationsPhysicalSettlementMatrix(self):
        """
        The below set of obligation of the reference entity are specified as optional boolean in FpML and the CDM because they would be specified as part of the Physical Settlement Matrix when such document governs the contract terms. As a result, this data rule specifies that those provisions cannot be omitted if the Physical Settlement Matrix governs the terms of the contract. This data rule also applies to cash settled contracts because those could still end-up being physically settled, in case the case where an auction could not take place because of, say, liquidity considerations.
        """
        item = self
        def _then_fn0():
            return ((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "notSubordinated")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "notSovereignLender"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "notDomesticLaw"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "notDomesticIssuance"))) and ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "fullFaithAndCreditObLiability")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "generalFundObligationLiability"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "revenueObligationLiability"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType"), "<>", rosetta_resolve_attr(MatrixTypeEnum, "CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")) or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_CreditEventsPhysicalSettlementMatrix(self):
        """
        The below set of credit events are specified as optional boolean in FpML and the CDM because they would be specified as part of the Physical Settlement Matrix when such document governs the contract terms. As a result, this data rule specifies that those provisions can only be omitted if the Physical Settlement Matrix governs the terms of the contract. This data rule also applies to cash settled contracts because those could still end-up being physically settled, in the case where an auction could not take place because of, say, liquidity considerations.
        """
        item = self
        def _then_fn0():
            return ((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "bankruptcy")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "obligationDefault"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "obligationAcceleration"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "repudiationMoratorium"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "governmentalIntervention")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType"), "<>", rosetta_resolve_attr(MatrixTypeEnum, "CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")) or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_5_RestructuringPhysicalSettlementMatrix(self):
        """
        The below multiple holder obligation restructuring provisions is specified as optional boolean in FpML and the CDM because they would be specified as part of the Physical Settlement Matrix when such document governs the contract terms. As a result, this data rule specifies that this provision can only be omitted if the Physical Settlement Matrix governs the terms of the contract. This data rule also applies to cash settled contracts because those could still end-up being physically settled, in the case where an auction could not take place because of, say, liquidity considerations.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "restructuring"), "multipleHolderObligation"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType"), "<>", rosetta_resolve_attr(MatrixTypeEnum, "CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")) or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix"), "matrixType")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "restructuring"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_6_AdditionalFixedPaymentsMortgages(self):
        """
        The below set of additional fixed payment provisions are specified as optional boolean in FpML and the CDM because they only apply to mortgage credit default swaps. As a result, this data rule specifies that those provisions are required if the contract corresponds to a mortgage credit default swap. The provision related to the existence of the Contractual Term Supplement is meant to address the case where the underlier is a mortgage index.
        """
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "additionalFixedPayments"), "interestShortfallReimbursement")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "additionalFixedPayments"), "principalShortfallReimbursement"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "additionalFixedPayments"), "writedownReimbursement")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "debtType"), "debtClass"), "=", rosetta_resolve_attr(DebtClassEnum, "ASSET_BACKED"))) or contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualTermsSupplement"), "contractualTermsSupplementType"), rosetta_resolve_attr(ContractualSupplementTypeEnum, "CD_SON_MBS"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_7_FloatingAmountEventsMortgages(self):
        """
        The below set of floating amount events provisions are specified as optional boolean in FpML and the CDM because they only apply to mortgage credit default swaps. As a result, this data rule specifies that those provisions are required if the contract corresponds to a mortgage credit default swap. The provision related to the existence of the Contractual Term Supplement is meant to address the case where the underlier is a mortgage index.
        """
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "failureToPayPrincipal")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "writedown"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"), "impliedWritedown")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "debtType"), "debtClass"), "=", rosetta_resolve_attr(DebtClassEnum, "ASSET_BACKED"))) or contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualTermsSupplement"), "contractualTermsSupplementType"), rosetta_resolve_attr(ContractualSupplementTypeEnum, "CD_SON_MBS"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "floatingAmountEvents"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_8_CreditEventsMortgages(self):
        """
        The below set of credit events provisions are specified as optional boolean in FpML and the CDM because they only apply to mortgage credit default swaps. As a result, this data rule specifies that those provisions are required if the contract corresponds to a mortgage credit default swap. The provision related to the existence of the Contractual Term Supplement is meant to address the case where the underlier is a mortgage index.
        """
        item = self
        def _then_fn0():
            return (((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "failureToPayPrincipal")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "failureToPayInterest"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "distressedRatingsDowngrade"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "maturityExtension"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "writedown"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "impliedWritedown")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "security"), "debtType"), "debtClass"), "=", rosetta_resolve_attr(DebtClassEnum, "ASSET_BACKED"))) or contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualTermsSupplement"), "contractualTermsSupplementType"), rosetta_resolve_attr(ContractualSupplementTypeEnum, "CD_SON_MBS"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_9_HedgingParty(self):
        """
        FpML specifies that there cannot be more than 2 hedging parties.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_count(FilterPartyRole(rosetta_resolve_attr(self, "partyRole"), rosetta_resolve_attr(PartyRoleEnum, "HEDGING_PARTY"))), "<=", 2)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "HEDGING_PARTY")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_10_DeterminingParty(self):
        """
        FpML specifies that there cannot be more than 2 determining parties.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_count(FilterPartyRole(rosetta_resolve_attr(self, "partyRole"), rosetta_resolve_attr(PartyRoleEnum, "DETERMINING_PARTY"))), "<=", 2)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "DETERMINING_PARTY")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_11_BarrierDerterminationAgent(self):
        """
        FpML specifies that there cannot be more than 1 barrier determination agent.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_count(FilterPartyRole(rosetta_resolve_attr(self, "partyRole"), rosetta_resolve_attr(PartyRoleEnum, "BARRIER_DETERMINATION_AGENT"))), "<=", 1)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "BARRIER_DETERMINATION_AGENT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_12_ClearedDate(self):
        """
        If the cleared date exists, it needs to be on or after the trade date.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "clearedDate"), ">=", rosetta_resolve_attr(self, "tradeDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "clearedDate")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_13_FpML_cd_1(self):
        """
        FpML validation rule cd-1 - If referenceInformation exists, tradeDate must be before effectiveDate/unadjustedDate.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "tradeDate"), "<", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "effectiveDate"), "adjustableDate"), "unadjustedDate")) or all_elements(rosetta_resolve_attr(self, "tradeDate"), "<", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "effectiveDate"), "adjustableDate"), "adjustedDate")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_14_FpML_cd_7(self):
        """
        FpML validation rule cd-7 - If condition LongForm is true, then effectiveDate/dateAdjustments exists.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "InterestRatePayout"), "calculationPeriodDates"), "effectiveDate"), "adjustableDate"), "dateAdjustments")) or all_elements(rosetta_resolve_attr(self, "tradeDate"), "<", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "effectiveDate"), "adjustableDate"), "adjustedDate")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_15_FpML_cd_8(self):
        """
        FpML validation rule cd-8 - If condition LongForm is true, and if scheduledTerminationDate exists then scheduledTerminationDate/dateAdjustments exists.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "terminationDate"), "adjustableDate"), "dateAdjustments"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_16_FpML_cd_11(self):
        """
        FpML validation rule cd-11 - If condition LongForm is true, and if condition ISDA2003 is true, then allGuarantees must exist.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "allGuarantees"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualDefinitionsType"), "=", rosetta_resolve_attr(ContractualDefinitionsEnum, "ISDA_2003_CREDIT_DERIVATIVES"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_17_FpML_cd_19(self):
        """
        FpML validation rule cd-19 - If the condition ISDA1999Credit is true, then the following elements must not exist: protectionTerms/creditEvents/creditEventNotice/businessCenter, protectionTerms/creditEvents/restructuring/multipleHolderObligation, protectionTerms/creditEvents/restructuring/multipleCreditEventNotices, generalTerms/referenceInformation/allGuarantees, generalTerms/indexReferenceInformation, generalTerms/substitution, generalTerms/modifiedEquityDelivery.
        """
        item = self
        def _then_fn0():
            return (((((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "creditEventNotice"), "businessCenter"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "restructuring"), "multipleHolderObligation")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "restructuring"), "multipleCreditEventNotices")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "allGuarantees")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "indexReferenceInformation")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "substitution")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "modifiedEquityDelivery"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualDefinitionsType"), "=", rosetta_resolve_attr(ContractualDefinitionsEnum, "ISDA_1999_CREDIT_DERIVATIVES")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_18_FpML_cd_20(self):
        """
        FpML validation rule cd-20 - If the condition ISDA2003 is true, then protectionTerms/obligations/notContingent must not exist.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"), "notContingent")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualDefinitionsType"), "=", rosetta_resolve_attr(ContractualDefinitionsEnum, "ISDA_2003_CREDIT_DERIVATIVES")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_19_FpML_cd_23(self):
        """
        FpML validation rule cd-23 - If the condition LongForm is true, then cashSettlementTerms or physicalSettlementTerms must exist.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "cashSettlementTerms")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_20_FpML_cd_24(self):
        """
        FpML validation rule cd-24 - If the condition LongForm is true, then the following elements must exist: protectionTerms/creditEvents/creditEventNotice, protectionTerms/obligations, generalTerms/referenceInformation/referencePrice.
        """
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "creditEvents"), "creditEventNotice")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "protectionTerms"), "obligations"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referencePrice")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_21_FpML_cd_25(self):
        """
        FpML validation rule cd-25 - If the condition LongForm is true, and if physicalSettlementTerms exists, then physicalSettlementTerms must contain settlementCurrency, physicalSettlementPeriod, escrow and deliverableObligations/accruedInterest.
        """
        item = self
        def _then_fn0():
            return (((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "settlementCurrency")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "physicalSettlementPeriod"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "escrow"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"), "deliverableObligations"), "accruedInterest")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "settlementTerms"), "physicalSettlementTerms"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_22_FpML_cd_32(self):
        """
        FpML validation rule cd-32 - If condition LongForm is true, and if fixedAmountCalculation/calculationAmount exists, then fixedAmountCalculation/dayCountFraction must exist.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "InterestRatePayout"), "dayCountFraction"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "masterConfirmationType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "legalAgreementIdentification"), "agreementName"), "contractualMatrix")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "InterestRatePayout"), "priceQuantity"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot"), "priceQuantity"), "quantity"), "value"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_23_FpML_ird_8(self):
        """
        FpML validation rule ird-8 - If the same party is specified as the payer and receiver, then different accounts must be specified.
        """
        item = self
        def _then_fn0():
            return all_elements(FpmlIrd8(item, rosetta_resolve_attr(self, "account")), "=", True)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "InterestRatePayout")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_24_ExtraordinaryEvents(self):
        """
        Extraordinary events provisions must be associated with an equity payout or an equity option payout.
        """
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "priceReturnTerms")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "OptionPayout"))) and Qualify_AssetClass_Equity(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "agreementTerms"), "agreement"), "transactionAdditionalTerms"), "equityAdditionalTerms"), "extraordinaryEvents")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_25_DisruptionEventsDeterminingParty(self):
        item = self
        def _then_fn1():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "agreementTerms"), "agreement"), "transactionAdditionalTerms"), "equityAdditionalTerms"), "extraordinaryEvents"), "additionalDisruptionEvents"), "determiningParty"))
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "ancillaryParty"), "role"), rosetta_resolve_attr(AncillaryRoleEnum, "DISRUPTION_EVENTS_DETERMINING_PARTY")) and if_cond_fn(contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "ancillaryParty"), "role"), rosetta_resolve_attr(AncillaryRoleEnum, "DISRUPTION_EVENTS_DETERMINING_PARTY")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractDetails"), "documentation"), "agreementTerms"), "agreement"), "transactionAdditionalTerms"), "equityAdditionalTerms"), "extraordinaryEvents"), "additionalDisruptionEvents"), "determiningParty")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.TradeIdentifier
import cdm.base.datetime.TimeZone
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRole
import cdm.event.common.ExecutionDetails
import cdm.event.common.ContractDetails
import cdm.product.collateral.Collateral
import cdm.base.staticdata.party.Account
from cdm.product.qualification.functions.SettlementPayoutOnlyExists import SettlementPayoutOnlyExists
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum
from cdm.legaldocumentation.common.MatrixTypeEnum import MatrixTypeEnum
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum
from cdm.base.staticdata.asset.common.DebtClassEnum import DebtClassEnum
from cdm.legaldocumentation.common.ContractualSupplementTypeEnum import ContractualSupplementTypeEnum
from cdm.base.staticdata.party.functions.FilterPartyRole import FilterPartyRole
from cdm.legaldocumentation.common.ContractualDefinitionsEnum import ContractualDefinitionsEnum
from cdm.product.template.functions.FpmlIrd8 import FpmlIrd8
from cdm.product.qualification.functions.Qualify_AssetClass_Equity import Qualify_AssetClass_Equity
from cdm.base.staticdata.party.AncillaryRoleEnum import AncillaryRoleEnum
