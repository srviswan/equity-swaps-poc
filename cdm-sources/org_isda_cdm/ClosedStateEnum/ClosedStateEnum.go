/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ClosedStateEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify what led to the contract or execution closure.
   */
  
  const (
  /**
   * The execution or contract has been allocated.
   */
  ALLOCATED ClosedStateEnum = iota + 1
  /**
   * The execution or contract has been cancelled.
   */
  CANCELLED ClosedStateEnum = iota + 1
  /**
   * The (option) contract has been exercised.
   */
  EXERCISED ClosedStateEnum = iota + 1
  /**
   * The (option) contract has expired without being exercised.
   */
  EXPIRED ClosedStateEnum = iota + 1
  /**
   * The contract has reached its contractual termination date.
   */
  MATURED ClosedStateEnum = iota + 1
  /**
   * The contract has been novated. This state applies to the stepped-out contract component of the novation event.
   */
  NOVATED ClosedStateEnum = iota + 1
  /**
   * The contract has been subject of an early termination event.
   */
  TERMINATED ClosedStateEnum = iota + 1
  )    
