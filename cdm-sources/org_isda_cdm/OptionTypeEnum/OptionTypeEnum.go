/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package OptionTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type or strategy of the option.
   */
  
  const (
  /**
   * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
   */
  CALL OptionTypeEnum = iota + 1
  /**
   * A 'payer' option: If you buy a 'payer' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price payer and receive float.
   */
  PAYER OptionTypeEnum = iota + 1
  /**
   * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
   */
  PUT OptionTypeEnum = iota + 1
  /**
   * A 'receiver' option: If you buy a 'receiver' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price receiver and pay float.
   */
  RECEIVER OptionTypeEnum = iota + 1
  /**
   * A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
   */
  STRADDLE OptionTypeEnum = iota + 1
  )    
