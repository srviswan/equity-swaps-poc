/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package AveragingCalculationMethodEnum
  import . "org_isda_cdm"
  /**
   * Specifies enumerations for the type of averaging calculation.
   */
  
  const (
  /**
   * Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
   */
  ARITHMETIC AveragingCalculationMethodEnum = iota + 1
  /**
   * Refers to the calculation of an average by taking the nth root of the product of n observations.
   */
  GEOMETRIC AveragingCalculationMethodEnum = iota + 1
  /**
   * Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
   */
  HARMONIC AveragingCalculationMethodEnum = iota + 1
  )    
