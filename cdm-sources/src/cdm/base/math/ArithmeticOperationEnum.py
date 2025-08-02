# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ArithmeticOperationEnum']

class ArithmeticOperationEnum(Enum):
    """
    An arithmetic operator that can be passed to a function
    """
    ADD = "Add"
    """
    Addition of 2 values
    """
    DIVIDE = "Divide"
    """
    Division of 1st value by 2nd value
    """
    MAX = "Max"
    """
    Maximum of 2 values
    """
    MIN = "Min"
    """
    Minimum of 2 values
    """
    MULTIPLY = "Multiply"
    """
    Multiplication of 2 values
    """
    SUBTRACT = "Subtract"
    """
    Subtraction of 2nd value from 1st value
    """
