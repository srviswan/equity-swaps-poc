/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package RegMarginTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation.
   */
  
  const (
  /**
   * Indicates Non Regulatory Initial margin or independent amount
   */
  NON_REG_IM RegMarginTypeEnum = iota + 1
  /**
   * Indicates Regulatory Initial Margin
   */
  REG_IM RegMarginTypeEnum = iota + 1
  /**
   * Indicates Variation Margin
   */
  VM RegMarginTypeEnum = iota + 1
  )    
