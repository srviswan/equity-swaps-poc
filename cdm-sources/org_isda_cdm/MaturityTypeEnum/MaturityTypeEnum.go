/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MaturityTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to identify the Maturity.
   */
  
  const (
  /**
   * Denotes a period from issuance date until now.
   */
  FROM_ISSUANCE MaturityTypeEnum = iota + 1
  /**
   * Denotes a period from issuance until maturity date.
   */
  ORIGINAL_MATURITY MaturityTypeEnum = iota + 1
  /**
   * Denotes a period from now until maturity date.
   */
  REMAINING_MATURITY MaturityTypeEnum = iota + 1
  )    
