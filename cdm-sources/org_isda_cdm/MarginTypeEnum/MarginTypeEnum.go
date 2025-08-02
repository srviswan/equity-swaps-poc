/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MarginTypeEnum
  import . "org_isda_cdm"
  /**
   * This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
   */
  
  const (
  /**
   * When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
   */
  CASH MarginTypeEnum = iota + 1
  /**
   * When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the 'instrument' case, the haircut would be applied to the securities.
   */
  INSTRUMENT MarginTypeEnum = iota + 1
  )    
