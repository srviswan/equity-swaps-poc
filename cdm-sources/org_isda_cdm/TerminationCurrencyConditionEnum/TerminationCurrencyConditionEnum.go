/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package TerminationCurrencyConditionEnum
  import . "org_isda_cdm"
  
  const (
  /**
   * A currency that is freely available.
   */
  FREELY_AVAILABLE TerminationCurrencyConditionEnum = iota + 1
  /**
   * A currency in which payments would be due under one or more Transactions.
   */
  PAYMENTS_DUE TerminationCurrencyConditionEnum = iota + 1
  /**
   * A currency in which payments would be due under one or more Transactions and that is freely available.
   */
  PAYMENTS_DUE_AND_FREELY_AVAILABLE TerminationCurrencyConditionEnum = iota + 1
  /**
   * Termination Currency Conditions are specified.
   */
  SPECIFIED TerminationCurrencyConditionEnum = iota + 1
  )    
