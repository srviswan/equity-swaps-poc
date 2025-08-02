/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package BankHolidayTreatmentEnum
  import . "org_isda_cdm"
  /**
   * Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles.
   */
  
  const (
  /**
   * Bank holidays treated as weekdays.
   */
  AS_WEEKDAY BankHolidayTreatmentEnum = iota + 1
  /**
   * Bank holidays treated as weekends.
   */
  AS_WEEKEND BankHolidayTreatmentEnum = iota + 1
  )    
