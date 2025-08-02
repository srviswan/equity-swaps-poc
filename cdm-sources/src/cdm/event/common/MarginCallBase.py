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

__all__ = ['MarginCallBase']


class MarginCallBase(BaseDataClass):
    """
    Represents common attributes required for Issuance and Response to a Margin Call action as a result of a demand for delivery or return of collateral determined under a legal agreement such as a credit support document or equivalent.
    """
    instructionType: cdm.event.common.MarginCallInstructionType.MarginCallInstructionType = Field(..., description="Identifies the enumeration values to specify the call notification type, direction, specific action type.")
    """
    Identifies the enumeration values to specify the call notification type, direction, specific action type.
    """
    party: List[cdm.base.staticdata.party.Party.Party] = Field([], description="Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.")
    """
    Represents the parties to the margin call. The cardinality is optional to address the case where both parties of the event are specified and a third party if applicable.
    """
    partyRole: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.")
    """
    Represents the role each specified party takes in the margin call. further to the principal roles, payer and receiver.
    """
    clearingBroker: Optional[cdm.base.staticdata.party.Party.Party] = Field(None, description="Indicates the name of the Clearing Broker FCM/DCM.")
    """
    Indicates the name of the Clearing Broker FCM/DCM.
    """
    callIdentifier: Optional[cdm.base.staticdata.identifier.Identifier.Identifier] = Field(None, description="Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.")
    """
    Represents a unique Identifier for a margin call message, that can be referenced throughout all points of the process.
    """
    callAgreementType: cdm.legaldocumentation.common.AgreementName.AgreementName = Field(..., description="Specifies the legal agreement type the margin call is generated from and governed by.")
    """
    Specifies the legal agreement type the margin call is generated from and governed by.
    """
    agreementMinimumTransferAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="Specifies the collateral legal agreement minimum transfer amount in base currency.")
    """
    Specifies the collateral legal agreement minimum transfer amount in base currency.
    """
    agreementThreshold: Optional[cdm.observable.asset.Money.Money] = Field(None, description="Specifies the collateral legal agreement threshold amount in base currency.")
    """
    Specifies the collateral legal agreement threshold amount in base currency.
    """
    agreementRounding: Optional[cdm.observable.asset.Money.Money] = Field(None, description="Specifies the collateral legal agreement rounding in base currency.")
    """
    Specifies the collateral legal agreement rounding in base currency.
    """
    regMarginType: cdm.event.common.RegMarginTypeEnum.RegMarginTypeEnum = Field(..., description="Identifies margin type and if related regulatory mandate")
    """
    Identifies margin type and if related regulatory mandate
    """
    regIMRole: Optional[cdm.event.common.RegIMRoleEnum.RegIMRoleEnum] = Field(None, description="Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).")
    """
    Indicates the role of the party in an regulatory initial margin call instruction (i.e Pledgor party or Secured party).
    """
    baseCurrencyExposure: Optional[cdm.event.common.MarginCallExposure.MarginCallExposure] = Field(None, description="Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.")
    """
    Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency), to be referenced in a margin call.
    """
    collateralPortfolio: Optional[AttributeWithReference | cdm.event.common.CollateralPortfolio.CollateralPortfolio] = Field(None, description="Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.")
    """
    Represents attributes to define the details of collateral assets within a collateral portfolio to be used in margin call messaging and contribute to collateral balances e.g securities in a collateral account recorded by the principal as held or posted.
    """
    independentAmountBalance: Optional[cdm.event.common.CollateralBalance.CollateralBalance] = Field(None, description="Represents additional credit support amount over and above mark to market value.")
    """
    Represents additional credit support amount over and above mark to market value.
    """
    
    @rosetta_condition
    def condition_0_RegIMRoleIMOnly(self):
        """
        Specifies a condition to ensure that RegIMRole (Pledgor or Secured Party)is only applicable if the Reg margin type is defined as RegIM (Regulatory Initial Margin).
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "regMarginType"), "=", rosetta_resolve_attr(RegMarginTypeEnum, "REG_IM"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "regIMRole")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.MarginCallInstructionType
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRole
import cdm.base.staticdata.identifier.Identifier
import cdm.legaldocumentation.common.AgreementName
import cdm.observable.asset.Money
import cdm.event.common.RegMarginTypeEnum
import cdm.event.common.RegIMRoleEnum
import cdm.event.common.MarginCallExposure
import cdm.event.common.CollateralPortfolio
import cdm.event.common.CollateralBalance
from cdm.event.common.RegMarginTypeEnum import RegMarginTypeEnum
