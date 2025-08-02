/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package InstrumentTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to indentify the type of an instrument.
   */
  
  const (
  /**
   * Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
   */
  CERTIFICATE InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
   */
  DEBT InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as an Equity value of holding of shares in listed company.
   */
  EQUITY InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as representing holding in an investment fund.
   */
  FUND InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
   */
  LETTER_OF_CREDIT InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as a listed derivative on an exchange.
   */
  LISTED_DERIVATIVE InstrumentTypeEnum = iota + 1
  /**
   * Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
   */
  WARRANT InstrumentTypeEnum = iota + 1
  )    
