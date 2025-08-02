/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DebtClassEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list that identifies the type of debt.
   */
  
  const (
  /**
   * Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations.
   */
  ASSET_BACKED DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that can be converted into common shares.
   */
  CONVERTIBLE DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer.
   */
  HOLDER_CONVERTIBLE DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer.
   */
  HOLDER_EXCHANGEABLE DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
   */
  ISSUER_CONVERTIBLE DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable.
   */
  ISSUER_EXCHANGEABLE DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
   */
  REG_CAP DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
   */
  STRUCTURED DebtClassEnum = iota + 1
  /**
   * Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
   */
  VANILLA DebtClassEnum = iota + 1
  )    
