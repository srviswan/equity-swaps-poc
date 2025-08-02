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

__all__ = ['MessageInformation']


class MessageInformation(BaseDataClass):
    """
    This class corresponds to the components of the FpML MessageHeader.model.
    """
    messageId: AttributeWithMeta[str] | str = Field(..., description="A unique identifier assigned to the message.")
    """
    A unique identifier assigned to the message.
    """
    sentBy: Optional[AttributeWithMeta[str] | str] = Field(None, description="The identifier for the originator of a message instance.")
    """
    The identifier for the originator of a message instance.
    """
    sentTo: List[AttributeWithMeta[str] | str] = Field([], description="The identifier(s) for the recipient(s) of a message instance.")
    """
    The identifier(s) for the recipient(s) of a message instance.
    """
    copyTo: List[AttributeWithMeta[str] | str] = Field([], description="A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.")
    """
    A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
    """

import cdm 
