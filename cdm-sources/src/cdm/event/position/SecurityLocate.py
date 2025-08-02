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

__all__ = ['SecurityLocate']

from cdm.event.position.AvailableInventory import AvailableInventory

class SecurityLocate(AvailableInventory):
    """
    A locate is an approval from a broker that needs to be obtained prior to effecting a short sale in an equity security. Similar to security availability, a borrower can request a single or multiple securities, but at least one must be requested.
    """
    
    @rosetta_condition
    def condition_0_RequestOneSecurityMinimum(self):
        """
        A locate must request the availability of at least one security.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "availableInventoryRecord"))

import cdm 
