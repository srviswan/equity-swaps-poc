/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MarketDisruptionEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
   */
  
  const (
  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
   */
  MODIFIED_POSTPONEMENT MarketDisruptionEnum = iota + 1
  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
   */
  OMISSION MarketDisruptionEnum = iota + 1
  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
   */
  POSTPONEMENT MarketDisruptionEnum = iota + 1
  )    
