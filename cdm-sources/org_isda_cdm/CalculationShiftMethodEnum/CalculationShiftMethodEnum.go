/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CalculationShiftMethodEnum
  import . "org_isda_cdm"
  /**
   *  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
   */
  
  const (
  /**
   * Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days.
   */
  LOOKBACK CalculationShiftMethodEnum = iota + 1
  /**
   * calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style.
   */
  NO_SHIFT CalculationShiftMethodEnum = iota + 1
  /**
   * the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period.
   */
  OBSERVATION_PERIOD_SHIFT CalculationShiftMethodEnum = iota + 1
  /**
   * Calculations cut the rate off several business days prior to rate setting (Lockout).
   */
  RATE_CUT_OFF CalculationShiftMethodEnum = iota + 1
  )    
