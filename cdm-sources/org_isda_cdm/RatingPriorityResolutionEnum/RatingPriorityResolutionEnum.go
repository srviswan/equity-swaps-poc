/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package RatingPriorityResolutionEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to 'Issuer', the rating in the 
   Issuer Criteria has priority or is used if there is no Asset criteria. If set to 'Asset', the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
   */
  
  const (
  /**
   * Denotes that the Asset Criteria has priority.
   */
  ASSET RatingPriorityResolutionEnum = iota + 1
  /**
   * Denotes that average rating should be used if several criteria apply.
   */
  AVERAGE RatingPriorityResolutionEnum = iota + 1
  /**
   * Denotes that highest rating should be used if several criteria apply.
   */
  HIGHEST RatingPriorityResolutionEnum = iota + 1
  /**
   * Denotes that the Issuer Criteria has priority.
   */
  ISSUER RatingPriorityResolutionEnum = iota + 1
  /**
   * Denotes that lowest rating should be used if several criteria apply.
   */
  LOWEST RatingPriorityResolutionEnum = iota + 1
  )    
