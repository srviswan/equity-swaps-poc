/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package AveragingInOutEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type of averaging used in an Asian option.
   */
  
  const (
  /**
   * The average price is used to derive both the strike and the expiration price.
   */
  BOTH AveragingInOutEnum = iota + 1
  /**
   * The average price is used to derive the strike price. Also known as 'Asian strike' style option.
   */
  IN AveragingInOutEnum = iota + 1
  /**
   * The average price is used to derive the expiration price. Also known as 'Asian price' style option.
   */
  OUT AveragingInOutEnum = iota + 1
  )    
