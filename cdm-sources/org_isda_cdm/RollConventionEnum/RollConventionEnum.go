/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package RollConventionEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month.
   */
  
  const (
  /**
   * Rolls on month end dates irrespective of the length of the month and the previous roll day.
   */
  EOM RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Friday
   */
  FRI RollConventionEnum = iota + 1
  /**
   * Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions.
   */
  FRN RollConventionEnum = iota + 1
  /**
   * IMM Settlement Dates. The third Wednesday of the (delivery) month.
   */
  IMM RollConventionEnum = iota + 1
  /**
   * The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement.
   */
  IMMAUD RollConventionEnum = iota + 1
  /**
   * The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers' Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification.
   */
  IMMCAD RollConventionEnum = iota + 1
  /**
   * The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month.
   */
  IMMNZD RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Monday.
   */
  MON RollConventionEnum = iota + 1
  /**
   * The roll convention is not required. For example, in the case of a daily calculation frequency.
   */
  NONE RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Saturday
   */
  SAT RollConventionEnum = iota + 1
  /**
   * Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month
   */
  SFE RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Sunday
   */
  SUN RollConventionEnum = iota + 1
  /**
   * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday.
   */
  TBILL RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Thursday
   */
  THU RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Tuesday
   */
  TUE RollConventionEnum = iota + 1
  /**
   * Rolling weekly on a Wednesday
   */
  WED RollConventionEnum = iota + 1
  /**
   * Rolls on the 1st day of the month.
   */
  _1 RollConventionEnum = iota + 1
  /**
   * Rolls on the 10th day of the month.
   */
  _10 RollConventionEnum = iota + 1
  /**
   * Rolls on the 11th day of the month.
   */
  _11 RollConventionEnum = iota + 1
  /**
   * Rolls on the 12th day of the month.
   */
  _12 RollConventionEnum = iota + 1
  /**
   * Rolls on the 13th day of the month.
   */
  _13 RollConventionEnum = iota + 1
  /**
   * Rolls on the 14th day of the month.
   */
  _14 RollConventionEnum = iota + 1
  /**
   * Rolls on the 15th day of the month.
   */
  _15 RollConventionEnum = iota + 1
  /**
   * Rolls on the 16th day of the month.
   */
  _16 RollConventionEnum = iota + 1
  /**
   * Rolls on the 17th day of the month.
   */
  _17 RollConventionEnum = iota + 1
  /**
   * Rolls on the 18th day of the month.
   */
  _18 RollConventionEnum = iota + 1
  /**
   * Rolls on the 19th day of the month.
   */
  _19 RollConventionEnum = iota + 1
  /**
   * Rolls on the 2nd day of the month.
   */
  _2 RollConventionEnum = iota + 1
  /**
   * Rolls on the 20th day of the month.
   */
  _20 RollConventionEnum = iota + 1
  /**
   * Rolls on the 21st day of the month.
   */
  _21 RollConventionEnum = iota + 1
  /**
   * Rolls on the 22nd day of the month.
   */
  _22 RollConventionEnum = iota + 1
  /**
   * Rolls on the 23rd day of the month.
   */
  _23 RollConventionEnum = iota + 1
  /**
   * Rolls on the 24th day of the month.
   */
  _24 RollConventionEnum = iota + 1
  /**
   * Rolls on the 25th day of the month.
   */
  _25 RollConventionEnum = iota + 1
  /**
   * Rolls on the 26th day of the month.
   */
  _26 RollConventionEnum = iota + 1
  /**
   * Rolls on the 27th day of the month.
   */
  _27 RollConventionEnum = iota + 1
  /**
   * Rolls on the 28th day of the month.
   */
  _28 RollConventionEnum = iota + 1
  /**
   * Rolls on the 29th day of the month.
   */
  _29 RollConventionEnum = iota + 1
  /**
   * Rolls on the 3rd day of the month.
   */
  _3 RollConventionEnum = iota + 1
  /**
   * Rolls on the 30th day of the month.
   */
  _30 RollConventionEnum = iota + 1
  /**
   * Rolls on the 4th day of the month.
   */
  _4 RollConventionEnum = iota + 1
  /**
   * Rolls on the 5th day of the month.
   */
  _5 RollConventionEnum = iota + 1
  /**
   * Rolls on the 6th day of the month.
   */
  _6 RollConventionEnum = iota + 1
  /**
   * Rolls on the 7th day of the month.
   */
  _7 RollConventionEnum = iota + 1
  /**
   * Rolls on the 8th day of the month.
   */
  _8 RollConventionEnum = iota + 1
  /**
   * Rolls on the 9th day of the month.
   */
  _9 RollConventionEnum = iota + 1
  )    
