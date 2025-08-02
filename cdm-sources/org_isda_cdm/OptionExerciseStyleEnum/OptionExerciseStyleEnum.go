/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package OptionExerciseStyleEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
   */
  
  const (
  /**
   * Continuous exercise over a range of dates
   */
  AMERICAN OptionExerciseStyleEnum = iota + 1
  /**
   * Multiple specified exercise dates
   */
  BERMUDA OptionExerciseStyleEnum = iota + 1
  /**
   * Single Exercise
   */
  EUROPEAN OptionExerciseStyleEnum = iota + 1
  )    
