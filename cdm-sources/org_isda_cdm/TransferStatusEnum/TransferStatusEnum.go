/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package TransferStatusEnum
  import . "org_isda_cdm"
  /**
   * The enumeration values to specify the transfer status.
   */
  
  const (
  /**
   * The transfer is disputed.
   */
  DISPUTED TransferStatusEnum = iota + 1
  /**
   * The transfer has been instructed.
   */
  INSTRUCTED TransferStatusEnum = iota + 1
  /**
   * The transfer has been netted into a separate Transfer.
   */
  NETTED TransferStatusEnum = iota + 1
  /**
   * The transfer is pending instruction.
   */
  PENDING TransferStatusEnum = iota + 1
  /**
   * The transfer has been settled.
   */
  SETTLED TransferStatusEnum = iota + 1
  )    
