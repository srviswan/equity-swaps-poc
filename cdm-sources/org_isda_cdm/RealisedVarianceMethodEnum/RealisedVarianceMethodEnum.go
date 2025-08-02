/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package RealisedVarianceMethodEnum
  import . "org_isda_cdm"
  /**
   * The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors.
   */
  
  const (
  /**
   * For a return on day T, the observed prices on both T and T-1 must be in range
   */
  BOTH RealisedVarianceMethodEnum = iota + 1
  /**
   * For a return on day T, the observed price on T must be in range.
   */
  LAST RealisedVarianceMethodEnum = iota + 1
  /**
   * For a return on day T, the observed price on T-1 must be in range.
   */
  PREVIOUS RealisedVarianceMethodEnum = iota + 1
  )    
