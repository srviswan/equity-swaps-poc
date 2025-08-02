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

__all__ = ['CalculationAgent']


class CalculationAgent(BaseDataClass):
    """
    A class defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
    """
    calculationAgentParty: Optional[cdm.base.staticdata.party.AncillaryRoleEnum.AncillaryRoleEnum] = Field(None, description="Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.")
    """
    Specifies the party which is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
    """
    calculationAgentPartyEnum: Optional[cdm.observable.asset.PartyDeterminationEnum.PartyDeterminationEnum] = Field(None, description="Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.")
    """
    Specifies the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
    """
    calculationAgentBusinessCenter: Optional[AttributeWithMeta[cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] | cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] = Field(None, description="The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.")
    """
    The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
    """
    
    @rosetta_condition
    def condition_0_CalculationAgentChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('calculationAgentParty', 'calculationAgentPartyEnum', necessity=False)

import cdm 
import cdm.base.staticdata.party.AncillaryRoleEnum
import cdm.observable.asset.PartyDeterminationEnum
import cdm.base.datetime.BusinessCenterEnum
