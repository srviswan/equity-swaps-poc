/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ExerciseNoticeGiverEnum
  import . "org_isda_cdm"
  /**
   * Defines the principal party to the trade that has the right to exercise.
   */
  
  const (
  /**
   * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
   */
  AS_SPECIFIED_IN_MASTER_AGREEMENT ExerciseNoticeGiverEnum = iota + 1
  /**
   * Specifies that both the option buyer and option seller has the right to exercise.
   */
  BOTH ExerciseNoticeGiverEnum = iota + 1
  /**
   * Specifies that only the option buyer has the right to exercise.
   */
  BUYER ExerciseNoticeGiverEnum = iota + 1
  /**
   * Specifies that only the option seller has the right to exercise.
   */
  SELLER ExerciseNoticeGiverEnum = iota + 1
  )    
