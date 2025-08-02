/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MasterAgreementVariantIdentifierEnum
  import . "org_isda_cdm"
  
  const (
  /**
   * Agreement is Undated
   */
  ISLA_GMSLA_001_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Agreement is Dated
   */
  ISLA_GMSLA_001_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Name and Place of Incorporation
   */
  ISLA_GMSLA_002_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Names and Place of Incorporation plus Additional Information
   */
  ISLA_GMSLA_002_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Defining the Party's Role as Lender or Borrower
   */
  ISLA_GMSLA_002_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Non-specific Roles
   */
  ISLA_GMSLA_003_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Specific Roles
   */
  ISLA_GMSLA_003_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * GMSLA Schedule
   */
  ISLA_GMSLA_004_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Outside of GMSLA
   */
  ISLA_GMSLA_004_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Additional Criteria
   */
  ISLA_GMSLA_004_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * GMSLA Schedule
   */
  ISLA_GMSLA_005_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Outside of GMSLA
   */
  ISLA_GMSLA_005_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Aggregation Applies
   */
  ISLA_GMSLA_006_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Aggregation Does Not Apply
   */
  ISLA_GMSLA_006_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Aggregation Applies Separately to Loan Groups
   */
  ISLA_GMSLA_006_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Aggregation Applies to Some but Not All Loans
   */
  ISLA_GMSLA_006_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Neither Aggregation nor Loan by Loan Applies
   */
  ISLA_GMSLA_006_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard
   */
  ISLA_GMSLA_007_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Collateral Disapplied
   */
  ISLA_GMSLA_007_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Netting of Collateral Shall Apply
   */
  ISLA_GMSLA_008_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Netting of Collateral Shall Not Apply
   */
  ISLA_GMSLA_008_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
   */
  ISLA_GMSLA_008_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Netting of Collateral Shall Apply Separately per Group of Loans
   */
  ISLA_GMSLA_008_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Specified Time
   */
  ISLA_GMSLA_009_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Notification Time by Collateral Type
   */
  ISLA_GMSLA_009_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Notification Time as Agreed
   */
  ISLA_GMSLA_009_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Notification Time
   */
  ISLA_GMSLA_009_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Indemnity Applies
   */
  ISLA_GMSLA_010_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Indemnity does not Apply
   */
  ISLA_GMSLA_010_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Single Base Currency
   */
  ISLA_GMSLA_011_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Single Base Currency with Fallback
   */
  ISLA_GMSLA_011_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Single Base Currency with Multiple Fallback Options
   */
  ISLA_GMSLA_011_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Locations are Specified Without Reference to Party
   */
  ISLA_GMSLA_012_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Locations are Specified Separately per Party
   */
  ISLA_GMSLA_012_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Not all Places of Business Have to be Open
   */
  ISLA_GMSLA_012_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Bid Price
   */
  ISLA_GMSLA_013_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Mid Price
   */
  ISLA_GMSLA_013_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2018 Standard
   */
  ISLA_GMSLA_013_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrowers Agreement to Pricing Source
   */
  ISLA_GMSLA_013_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pre-agreed Pricing Source
   */
  ISLA_GMSLA_013_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Time Variation
   */
  ISLA_GMSLA_013_06 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automatic Early Termination does not Apply
   */
  ISLA_GMSLA_014_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automatic Early Termination Applies
   */
  ISLA_GMSLA_014_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automatic Early Termination Applies in Modified Form)
   */
  ISLA_GMSLA_014_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automatic Early Termination is specified separately for each Principal
   */
  ISLA_GMSLA_014_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automatic Early Termination is not applicable unless required due to the systems of law
   */
  ISLA_GMSLA_014_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Party Specifies a Single Designated Office
   */
  ISLA_GMSLA_015_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Party Specifies Multiple Designated Offices
   */
  ISLA_GMSLA_015_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2000 Standard
   */
  ISLA_GMSLA_016_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2010 Standard
   */
  ISLA_GMSLA_016_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2018 Standard
   */
  ISLA_GMSLA_016_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Plus Email
   */
  ISLA_GMSLA_016_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Separate Address for Legal and Operational Notices
   */
  ISLA_GMSLA_016_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Special Instructions
   */
  ISLA_GMSLA_016_06 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Process Agent
   */
  ISLA_GMSLA_017_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Process Agent Specified
   */
  ISLA_GMSLA_017_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Process Agent to be Appointed
   */
  ISLA_GMSLA_017_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * A Party will not act as Agent
   */
  ISLA_GMSLA_018_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * A Party may act as Agent
   */
  ISLA_GMSLA_018_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * A Party will always act as Agent
   */
  ISLA_GMSLA_018_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pooled Principal Transactions Shall Not Apply
   */
  ISLA_GMSLA_019_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pooled Principal Transactions Shall  Apply
   */
  ISLA_GMSLA_019_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pooled Principal Transactions May Apply
   */
  ISLA_GMSLA_019_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Simple Election
   */
  ISLA_GMSLA_020_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Election with Modifications
   */
  ISLA_GMSLA_020_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Term Rate
   */
  ISLA_GMSLA_021_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Overnight Rate
   */
  ISLA_GMSLA_021_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Risk Free Rate
   */
  ISLA_GMSLA_021_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Non-Defaulting Party Election
   */
  ISLA_GMSLA_021_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Spread
   */
  ISLA_GMSLA_021_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Agreement Covers Existing Loans
   */
  ISLA_GMSLA_022_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Agreement Does Not Cover Existing Loans
   */
  ISLA_GMSLA_022_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automation Does Not Apply
   */
  ISLA_GMSLA_023_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Automation May Apply
   */
  ISLA_GMSLA_023_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Pre-Print
   */
  ISLA_GMSLA_024_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Grace Period Amendment
   */
  ISLA_GMSLA_024_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Jurisdictional Amendments
   */
  ISLA_GMSLA_024_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Transferor Pays Costs and Expenses
   */
  ISLA_GMSLA_025_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Transferor Pays Costs and Expenses other than those arising from Negligence
   */
  ISLA_GMSLA_025_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
   */
  ISLA_GMSLA_025_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Buy-in Expanded to Cover Buy-in Exercised by an Exchange
   */
  ISLA_GMSLA_025_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard
   */
  ISLA_GMSLA_026_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Selecting Party other than Lender
   */
  ISLA_GMSLA_026_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Variation of Exchange Rate Source
   */
  ISLA_GMSLA_026_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Scope
   */
  ISLA_GMSLA_027_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Limited Scope
   */
  ISLA_GMSLA_027_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Same Day
   */
  ISLA_GMSLA_028_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Alternative Delivery Time
   */
  ISLA_GMSLA_028_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Same Day with Notification Time
   */
  ISLA_GMSLA_028_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Alternative Delivery Time with Notification Time
   */
  ISLA_GMSLA_028_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Asset Dependent
   */
  ISLA_GMSLA_028_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Simultaneous delivery of securities and collateral
   */
  ISLA_GMSLA_029_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Collateral Delivery as specified in the Security Agreement
   */
  ISLA_GMSLA_029_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Lender to Deliver Securities once Collateral is Delivered
   */
  ISLA_GMSLA_029_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower Request
   */
  ISLA_GMSLA_030_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower Request/Lender Consent
   */
  ISLA_GMSLA_030_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Lender or Borrower Request
   */
  ISLA_GMSLA_030_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pre-approval of Alternative Collateral
   */
  ISLA_GMSLA_030_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Manufactured Payment of Amount Such Party Would Be Entitled to Receive
   */
  ISLA_GMSLA_031_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
   */
  ISLA_GMSLA_031_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Manufactured Payment Only in Relation to Loaned Securities
   */
  ISLA_GMSLA_031_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Additional Sum to Be Paid to Cover Tax Relief
   */
  ISLA_GMSLA_031_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Notice Requirement
   */
  ISLA_GMSLA_031_05 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard
   */
  ISLA_GMSLA_032_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Reasonable Notice Defined
   */
  ISLA_GMSLA_032_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Right to Instruct
   */
  ISLA_GMSLA_032_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Payment Within a Week
   */
  ISLA_GMSLA_033_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Payment Within 10 Days
   */
  ISLA_GMSLA_033_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Payment Upon Maturity
   */
  ISLA_GMSLA_033_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Such Rate as Agreed
   */
  ISLA_GMSLA_034_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * VAT Added
   */
  ISLA_GMSLA_034_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Deduction
   */
  ISLA_GMSLA_034_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Rate Payable
   */
  ISLA_GMSLA_034_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Lender May Terminate a Loan at any Time
   */
  ISLA_GMSLA_035_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Lender May Not Terminate a Loan
   */
  ISLA_GMSLA_035_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower May Terminate a Loan at Any Time
   */
  ISLA_GMSLA_036_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower May Terminate a Loan Subject to Notice
   */
  ISLA_GMSLA_036_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
   */
  ISLA_GMSLA_036_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
   */
  ISLA_GMSLA_036_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Failure to Deliver Event of Default Applies
   */
  ISLA_GMSLA_037_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Failure to Deliver Event of Default does not Apply
   */
  ISLA_GMSLA_037_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Failure to Deliver Event of Default does not Apply to Lender
   */
  ISLA_GMSLA_037_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2000 Standard
   */
  ISLA_GMSLA_038_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2010 Standard
   */
  ISLA_GMSLA_038_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2018 Standard
   */
  ISLA_GMSLA_038_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2000 Modified No Lender Close Out
   */
  ISLA_GMSLA_038_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2000 Standard
   */
  ISLA_GMSLA_039_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2010/2018 Standard
   */
  ISLA_GMSLA_039_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Hybrid
   */
  ISLA_GMSLA_039_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2000 Standard
   */
  ISLA_GMSLA_040_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * 2010/2018 Standard
   */
  ISLA_GMSLA_040_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Hybrid
   */
  ISLA_GMSLA_040_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Costs and Expenses
   */
  ISLA_GMSLA_041_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Limitation of Costs and Expenses
   */
  ISLA_GMSLA_041_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Expansion of Costs and Expenses
   */
  ISLA_GMSLA_041_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Contractual Set-Off
   */
  ISLA_GMSLA_042_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Simple Contractual Set-Off
   */
  ISLA_GMSLA_042_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Set-Off with Unascertained Obligations Amendment
   */
  ISLA_GMSLA_042_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Paragraph 11.2(a)
   */
  ISLA_GMSLA_043_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Amended Paragraph 11.2,(a) applies
   */
  ISLA_GMSLA_043_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Consent
   */
  ISLA_GMSLA_044_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Consent with Standard Exclusions
   */
  ISLA_GMSLA_044_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Consent with Additional Exclusions
   */
  ISLA_GMSLA_044_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Pre-approved Assignments
   */
  ISLA_GMSLA_044_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Parties May Record All Conversations
   */
  ISLA_GMSLA_045_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Parties Agree to Obtain Consent
   */
  ISLA_GMSLA_045_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Parties Limit the Conversations that May be Recorded
   */
  ISLA_GMSLA_045_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Submission as Evidence
   */
  ISLA_GMSLA_045_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Standard Waiver of Immunity Applies
   */
  ISLA_GMSLA_046_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Waiver of Immunity may Not Apply
   */
  ISLA_GMSLA_046_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Additional Documentation Required
   */
  ISLA_GMSLA_047_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Additional Documentation Required
   */
  ISLA_GMSLA_047_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Collateral Transfer Details not included
   */
  ISLA_GMSLA_048_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Collateral Transfer Details included
   */
  ISLA_GMSLA_048_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Confidentiality Clause
   */
  ISLA_GMSLA_049_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Permitted Disclosure Clause
   */
  ISLA_GMSLA_049_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Paragraph 20.1 Amended to Refer  Paragraph 6
   */
  ISLA_GMSLA_050_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Paragraph 27.2 Amended to refer to the 2010 GMSLA
   */
  ISLA_GMSLA_050_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * MCTA  Delivery only
   */
  ISLA_GMSLA_051_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * MCTA  Delivery and Re-Delivery
   */
  ISLA_GMSLA_051_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * MCTA  Drops to Zero for a Defaulting Party
   */
  ISLA_GMSLA_051_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Non-Reliance Representation
   */
  ISLA_GMSLA_052_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Non-Reliance Representation Added
   */
  ISLA_GMSLA_052_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * No Records and Statements Clause
   */
  ISLA_GMSLA_053_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Records and Statements Clause Added
   */
  ISLA_GMSLA_053_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Recovery and Resolution not Included
   */
  ISLA_GMSLA_054_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Recovery and Resolution Included in GMSLA
   */
  ISLA_GMSLA_054_02 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Recovery and Resolution Included by Protocol
   */
  ISLA_GMSLA_054_03 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Recovery and Resolution Incorporated by Reference
   */
  ISLA_GMSLA_054_04 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Security Agreement Details Included
   */
  ISLA_GMSLA_055_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Triparty Services Not Referenced
   */
  ISLA_GMSLA_056_01 MasterAgreementVariantIdentifierEnum = iota + 1
  /**
   * Triparty Services May Apply
   */
  ISLA_GMSLA_056_02 MasterAgreementVariantIdentifierEnum = iota + 1
  )    
