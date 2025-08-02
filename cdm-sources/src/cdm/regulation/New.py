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

__all__ = ['New']


class New(BaseDataClass):
    txId: str = Field(..., description="")
    exctgPty: str = Field(..., description="")
    invstmtPtyInd: str = Field(..., description="")
    submitgPty: str = Field(..., description="")
    buyr: cdm.regulation.Buyr.Buyr = Field(..., description="")
    sellr: cdm.regulation.Sellr.Sellr = Field(..., description="")
    ordrTrnsmssn: cdm.regulation.OrdrTrnsmssn.OrdrTrnsmssn = Field(..., description="")
    tx: cdm.regulation.Tx.Tx = Field(..., description="")
    finInstrm: cdm.regulation.FinInstrm.FinInstrm = Field(..., description="")
    invstmtDcsnPrsn: cdm.regulation.InvstmtDcsnPrsn.InvstmtDcsnPrsn = Field(..., description="")
    exctgPrsn: cdm.regulation.ExctgPrsn.ExctgPrsn = Field(..., description="")
    addtlAttrbts: cdm.regulation.AddtlAttrbts.AddtlAttrbts = Field(..., description="")

import cdm 
import cdm.regulation.Buyr
import cdm.regulation.Sellr
import cdm.regulation.OrdrTrnsmssn
import cdm.regulation.Tx
import cdm.regulation.FinInstrm
import cdm.regulation.InvstmtDcsnPrsn
import cdm.regulation.ExctgPrsn
import cdm.regulation.AddtlAttrbts
