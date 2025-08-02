/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DiscountingTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
   */
  
  const (
  /**
   * As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
   */
  AFMA DiscountingTypeEnum = iota + 1
  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
   */
  FRA DiscountingTypeEnum = iota + 1
  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
   */
  FRA_YIELD DiscountingTypeEnum = iota + 1
  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
   */
  STANDARD DiscountingTypeEnum = iota + 1
  )    
