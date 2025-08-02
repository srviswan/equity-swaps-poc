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

__all__ = ['Counterparty']


class Counterparty(BaseDataClass):
    """
    Defines a counterparty enumerated value, e.g. Party1 or Party2, with an associated party reference. The product is agnostic to the actual parties to the transaction, with the party references abstracted away from the product definition and replaced by the CounterpartyEnum (e.g. values Party1 or Party2). The CounterpartyEnum can then be positioned in the product (e.g. to specify which counterparty is the payer, receiver etc) and this Counterparty type, which is positioned outside of the product definition, allows the CounterpartyEnum to be associated with an actual party reference.
    """
    role: cdm.base.staticdata.party.CounterpartyRoleEnum.CounterpartyRoleEnum = Field(..., description="Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.")
    """
    Specifies the CounterpartyEnum, e.g. either Party1 or Party2, that is associated to the partyReference.
    """
    partyReference: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="Specifies the party that is associated to the counterparty.")
    """
    Specifies the party that is associated to the counterparty.
    """

import cdm 
import cdm.base.staticdata.party.CounterpartyRoleEnum
import cdm.base.staticdata.party.Party
