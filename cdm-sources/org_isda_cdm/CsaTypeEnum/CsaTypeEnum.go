/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CsaTypeEnum
  import . "org_isda_cdm"
  /**
   * How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1 
   */
  
  const (
  /**
   * Thre is an existing Credit Support Annex
   */
  EXISTING_CSA CsaTypeEnum = iota + 1
  /**
   * There is no CSA applicable
   */
  NO_CSA CsaTypeEnum = iota + 1
  /**
   * There is a bilateral Credit Support Annex specific to the transaction
   */
  REFERENCE_VMCSA CsaTypeEnum = iota + 1
  )    
