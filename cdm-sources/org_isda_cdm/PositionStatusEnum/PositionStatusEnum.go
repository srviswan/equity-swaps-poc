/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package PositionStatusEnum
  import . "org_isda_cdm"
  /**
   * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
   */
  
  const (
  /**
   * The position has been cancelled, in case of a cancellation event following an execution.
   */
  CANCELLED PositionStatusEnum = iota + 1
  /**
   * The position has been closed, in case of a termination event.
   */
  CLOSED PositionStatusEnum = iota + 1
  /**
   * The position has been executed, which is the point at which risk has been transferred.
   */
  EXECUTED PositionStatusEnum = iota + 1
  /**
   * Contract has been formed, in case position is on a contractual product.
   */
  FORMED PositionStatusEnum = iota + 1
  /**
   * The position has settled, in case product is subject to settlement after execution, such as securities.
   */
  SETTLED PositionStatusEnum = iota + 1
  )    
