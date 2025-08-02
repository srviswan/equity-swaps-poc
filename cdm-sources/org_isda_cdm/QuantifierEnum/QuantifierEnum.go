/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package QuantifierEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumerated values to specify a logical quantification, i.e. either All or Any.
   */
  
  const (
  /**
   * Specifies that the condition in the scope of the quantifier is true of every member of the domain i.e. every one of the elements in scope.
   */
  ALL QuantifierEnum = iota + 1
  /**
   * Specifies that the condition in the scope of the quantifier is true of at least one member of the domain i.e. one or more of the elements in scope.
   */
  ANY QuantifierEnum = iota + 1
  )    
