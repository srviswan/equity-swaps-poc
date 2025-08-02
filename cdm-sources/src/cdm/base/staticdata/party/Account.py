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

__all__ = ['Account']


class Account(BaseDataClass):
    """
    A class to specify an account as an account number alongside, optionally. an account name, an account type, an account beneficiary and a servicing party.
    """
    partyReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="A reference to the party to which the account refers to.")
    """
    A reference to the party to which the account refers to.
    """
    accountNumber: AttributeWithMeta[str] | str = Field(..., description="The account number.")
    """
    The account number.
    """
    accountName: Optional[AttributeWithMeta[str] | str] = Field(None, description="The name by which the account is known.")
    """
    The name by which the account is known.
    """
    accountType: Optional[AttributeWithMeta[cdm.base.staticdata.party.AccountTypeEnum.AccountTypeEnum] | cdm.base.staticdata.party.AccountTypeEnum.AccountTypeEnum] = Field(None, description="The type of account, e.g. client, house.")
    """
    The type of account, e.g. client, house.
    """
    accountBeneficiary: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="A reference to the party beneficiary of the account.")
    """
    A reference to the party beneficiary of the account.
    """
    servicingParty: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="The reference to the legal entity that services the account, i.e. in the books of which the account is held.")
    """
    The reference to the legal entity that services the account, i.e. in the books of which the account is held.
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.AccountTypeEnum
