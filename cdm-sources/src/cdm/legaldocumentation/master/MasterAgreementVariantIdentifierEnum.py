# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MasterAgreementVariantIdentifierEnum']

class MasterAgreementVariantIdentifierEnum(Enum):
    ISLA_GMSLA_001_01 = "ISLA_GMSLA_001_01"
    """
    Agreement is Undated
    """
    ISLA_GMSLA_001_02 = "ISLA_GMSLA_001_02"
    """
    Agreement is Dated
    """
    ISLA_GMSLA_002_01 = "ISLA_GMSLA_002_01"
    """
    Name and Place of Incorporation
    """
    ISLA_GMSLA_002_02 = "ISLA_GMSLA_002_02"
    """
    Names and Place of Incorporation plus Additional Information
    """
    ISLA_GMSLA_002_03 = "ISLA_GMSLA_002_03"
    """
    Defining the Party's Role as Lender or Borrower
    """
    ISLA_GMSLA_003_01 = "ISLA_GMSLA_003_01"
    """
    Non-specific Roles
    """
    ISLA_GMSLA_003_02 = "ISLA_GMSLA_003_02"
    """
    Specific Roles
    """
    ISLA_GMSLA_004_01 = "ISLA_GMSLA_004_01"
    """
    GMSLA Schedule
    """
    ISLA_GMSLA_004_02 = "ISLA_GMSLA_004_02"
    """
    Outside of GMSLA
    """
    ISLA_GMSLA_004_03 = "ISLA_GMSLA_004_03"
    """
    Additional Criteria
    """
    ISLA_GMSLA_005_01 = "ISLA_GMSLA_005_01"
    """
    GMSLA Schedule
    """
    ISLA_GMSLA_005_02 = "ISLA_GMSLA_005_02"
    """
    Outside of GMSLA
    """
    ISLA_GMSLA_006_01 = "ISLA_GMSLA_006_01"
    """
    Aggregation Applies
    """
    ISLA_GMSLA_006_02 = "ISLA_GMSLA_006_02"
    """
    Aggregation Does Not Apply
    """
    ISLA_GMSLA_006_03 = "ISLA_GMSLA_006_03"
    """
    Aggregation Applies Separately to Loan Groups
    """
    ISLA_GMSLA_006_04 = "ISLA_GMSLA_006_04"
    """
    Aggregation Applies to Some but Not All Loans
    """
    ISLA_GMSLA_006_05 = "ISLA_GMSLA_006_05"
    """
    Neither Aggregation nor Loan by Loan Applies
    """
    ISLA_GMSLA_007_01 = "ISLA_GMSLA_007_01"
    """
    Standard
    """
    ISLA_GMSLA_007_02 = "ISLA_GMSLA_007_02"
    """
    Collateral Disapplied
    """
    ISLA_GMSLA_008_01 = "ISLA_GMSLA_008_01"
    """
    Netting of Collateral Shall Apply
    """
    ISLA_GMSLA_008_02 = "ISLA_GMSLA_008_02"
    """
    Netting of Collateral Shall Not Apply
    """
    ISLA_GMSLA_008_03 = "ISLA_GMSLA_008_03"
    """
    Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
    """
    ISLA_GMSLA_008_04 = "ISLA_GMSLA_008_04"
    """
    Netting of Collateral Shall Apply Separately per Group of Loans
    """
    ISLA_GMSLA_009_01 = "ISLA_GMSLA_009_01"
    """
    Specified Time
    """
    ISLA_GMSLA_009_02 = "ISLA_GMSLA_009_02"
    """
    Notification Time by Collateral Type
    """
    ISLA_GMSLA_009_03 = "ISLA_GMSLA_009_03"
    """
    Notification Time as Agreed
    """
    ISLA_GMSLA_009_04 = "ISLA_GMSLA_009_04"
    """
    No Notification Time
    """
    ISLA_GMSLA_010_01 = "ISLA_GMSLA_010_01"
    """
    Indemnity Applies
    """
    ISLA_GMSLA_010_02 = "ISLA_GMSLA_010_02"
    """
    Indemnity does not Apply
    """
    ISLA_GMSLA_011_01 = "ISLA_GMSLA_011_01"
    """
    Single Base Currency
    """
    ISLA_GMSLA_011_02 = "ISLA_GMSLA_011_02"
    """
    Single Base Currency with Fallback
    """
    ISLA_GMSLA_011_03 = "ISLA_GMSLA_011_03"
    """
    Single Base Currency with Multiple Fallback Options
    """
    ISLA_GMSLA_012_01 = "ISLA_GMSLA_012_01"
    """
    Locations are Specified Without Reference to Party
    """
    ISLA_GMSLA_012_02 = "ISLA_GMSLA_012_02"
    """
    Locations are Specified Separately per Party
    """
    ISLA_GMSLA_012_03 = "ISLA_GMSLA_012_03"
    """
    Not all Places of Business Have to be Open
    """
    ISLA_GMSLA_013_01 = "ISLA_GMSLA_013_01"
    """
    Standard Bid Price
    """
    ISLA_GMSLA_013_02 = "ISLA_GMSLA_013_02"
    """
    Standard Mid Price
    """
    ISLA_GMSLA_013_03 = "ISLA_GMSLA_013_03"
    """
    2018 Standard
    """
    ISLA_GMSLA_013_04 = "ISLA_GMSLA_013_04"
    """
    Borrowers Agreement to Pricing Source
    """
    ISLA_GMSLA_013_05 = "ISLA_GMSLA_013_05"
    """
    Pre-agreed Pricing Source
    """
    ISLA_GMSLA_013_06 = "ISLA_GMSLA_013_06"
    """
    Time Variation
    """
    ISLA_GMSLA_014_01 = "ISLA_GMSLA_014_01"
    """
    Automatic Early Termination does not Apply
    """
    ISLA_GMSLA_014_02 = "ISLA_GMSLA_014_02"
    """
    Automatic Early Termination Applies
    """
    ISLA_GMSLA_014_03 = "ISLA_GMSLA_014_03"
    """
    Automatic Early Termination Applies in Modified Form)
    """
    ISLA_GMSLA_014_04 = "ISLA_GMSLA_014_04"
    """
    Automatic Early Termination is specified separately for each Principal
    """
    ISLA_GMSLA_014_05 = "ISLA_GMSLA_014_05"
    """
    Automatic Early Termination is not applicable unless required due to the systems of law
    """
    ISLA_GMSLA_015_01 = "ISLA_GMSLA_015_01"
    """
    Party Specifies a Single Designated Office
    """
    ISLA_GMSLA_015_02 = "ISLA_GMSLA_015_02"
    """
    Party Specifies Multiple Designated Offices
    """
    ISLA_GMSLA_016_01 = "ISLA_GMSLA_016_01"
    """
    2000 Standard
    """
    ISLA_GMSLA_016_02 = "ISLA_GMSLA_016_02"
    """
    2010 Standard
    """
    ISLA_GMSLA_016_03 = "ISLA_GMSLA_016_03"
    """
    2018 Standard
    """
    ISLA_GMSLA_016_04 = "ISLA_GMSLA_016_04"
    """
    Plus Email
    """
    ISLA_GMSLA_016_05 = "ISLA_GMSLA_016_05"
    """
    Separate Address for Legal and Operational Notices
    """
    ISLA_GMSLA_016_06 = "ISLA_GMSLA_016_06"
    """
    Special Instructions
    """
    ISLA_GMSLA_017_01 = "ISLA_GMSLA_017_01"
    """
    No Process Agent
    """
    ISLA_GMSLA_017_02 = "ISLA_GMSLA_017_02"
    """
    Process Agent Specified
    """
    ISLA_GMSLA_017_03 = "ISLA_GMSLA_017_03"
    """
    Process Agent to be Appointed
    """
    ISLA_GMSLA_018_01 = "ISLA_GMSLA_018_01"
    """
    A Party will not act as Agent
    """
    ISLA_GMSLA_018_02 = "ISLA_GMSLA_018_02"
    """
    A Party may act as Agent
    """
    ISLA_GMSLA_018_03 = "ISLA_GMSLA_018_03"
    """
    A Party will always act as Agent
    """
    ISLA_GMSLA_019_01 = "ISLA_GMSLA_019_01"
    """
    Pooled Principal Transactions Shall Not Apply
    """
    ISLA_GMSLA_019_02 = "ISLA_GMSLA_019_02"
    """
    Pooled Principal Transactions Shall  Apply
    """
    ISLA_GMSLA_019_03 = "ISLA_GMSLA_019_03"
    """
    Pooled Principal Transactions May Apply
    """
    ISLA_GMSLA_020_01 = "ISLA_GMSLA_020_01"
    """
    Simple Election
    """
    ISLA_GMSLA_020_02 = "ISLA_GMSLA_020_02"
    """
    Election with Modifications
    """
    ISLA_GMSLA_021_01 = "ISLA_GMSLA_021_01"
    """
    Term Rate
    """
    ISLA_GMSLA_021_02 = "ISLA_GMSLA_021_02"
    """
    Overnight Rate
    """
    ISLA_GMSLA_021_03 = "ISLA_GMSLA_021_03"
    """
    Risk Free Rate
    """
    ISLA_GMSLA_021_04 = "ISLA_GMSLA_021_04"
    """
    Non-Defaulting Party Election
    """
    ISLA_GMSLA_021_05 = "ISLA_GMSLA_021_05"
    """
    Spread
    """
    ISLA_GMSLA_022_01 = "ISLA_GMSLA_022_01"
    """
    Agreement Covers Existing Loans
    """
    ISLA_GMSLA_022_02 = "ISLA_GMSLA_022_02"
    """
    Agreement Does Not Cover Existing Loans
    """
    ISLA_GMSLA_023_01 = "ISLA_GMSLA_023_01"
    """
    Automation Does Not Apply
    """
    ISLA_GMSLA_023_02 = "ISLA_GMSLA_023_02"
    """
    Automation May Apply
    """
    ISLA_GMSLA_024_01 = "ISLA_GMSLA_024_01"
    """
    Standard Pre-Print
    """
    ISLA_GMSLA_024_02 = "ISLA_GMSLA_024_02"
    """
    Grace Period Amendment
    """
    ISLA_GMSLA_024_03 = "ISLA_GMSLA_024_03"
    """
    Jurisdictional Amendments
    """
    ISLA_GMSLA_025_01 = "ISLA_GMSLA_025_01"
    """
    Transferor Pays Costs and Expenses
    """
    ISLA_GMSLA_025_02 = "ISLA_GMSLA_025_02"
    """
    Transferor Pays Costs and Expenses other than those arising from Negligence
    """
    ISLA_GMSLA_025_03 = "ISLA_GMSLA_025_03"
    """
    Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
    """
    ISLA_GMSLA_025_04 = "ISLA_GMSLA_025_04"
    """
    Buy-in Expanded to Cover Buy-in Exercised by an Exchange
    """
    ISLA_GMSLA_026_01 = "ISLA_GMSLA_026_01"
    """
    Standard
    """
    ISLA_GMSLA_026_02 = "ISLA_GMSLA_026_02"
    """
    Selecting Party other than Lender
    """
    ISLA_GMSLA_026_03 = "ISLA_GMSLA_026_03"
    """
    Variation of Exchange Rate Source
    """
    ISLA_GMSLA_027_01 = "ISLA_GMSLA_027_01"
    """
    Standard Scope
    """
    ISLA_GMSLA_027_02 = "ISLA_GMSLA_027_02"
    """
    Limited Scope
    """
    ISLA_GMSLA_028_01 = "ISLA_GMSLA_028_01"
    """
    Same Day
    """
    ISLA_GMSLA_028_02 = "ISLA_GMSLA_028_02"
    """
    Alternative Delivery Time
    """
    ISLA_GMSLA_028_03 = "ISLA_GMSLA_028_03"
    """
    Same Day with Notification Time
    """
    ISLA_GMSLA_028_04 = "ISLA_GMSLA_028_04"
    """
    Alternative Delivery Time with Notification Time
    """
    ISLA_GMSLA_028_05 = "ISLA_GMSLA_028_05"
    """
    Asset Dependent
    """
    ISLA_GMSLA_029_01 = "ISLA_GMSLA_029_01"
    """
    Simultaneous delivery of securities and collateral
    """
    ISLA_GMSLA_029_02 = "ISLA_GMSLA_029_02"
    """
    Collateral Delivery as specified in the Security Agreement
    """
    ISLA_GMSLA_029_03 = "ISLA_GMSLA_029_03"
    """
    Lender to Deliver Securities once Collateral is Delivered
    """
    ISLA_GMSLA_030_01 = "ISLA_GMSLA_030_01"
    """
    Borrower Request
    """
    ISLA_GMSLA_030_02 = "ISLA_GMSLA_030_02"
    """
    Borrower Request/Lender Consent
    """
    ISLA_GMSLA_030_03 = "ISLA_GMSLA_030_03"
    """
    Lender or Borrower Request
    """
    ISLA_GMSLA_030_04 = "ISLA_GMSLA_030_04"
    """
    Pre-approval of Alternative Collateral
    """
    ISLA_GMSLA_031_01 = "ISLA_GMSLA_031_01"
    """
    Manufactured Payment of Amount Such Party Would Be Entitled to Receive
    """
    ISLA_GMSLA_031_02 = "ISLA_GMSLA_031_02"
    """
    Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
    """
    ISLA_GMSLA_031_03 = "ISLA_GMSLA_031_03"
    """
    Manufactured Payment Only in Relation to Loaned Securities
    """
    ISLA_GMSLA_031_04 = "ISLA_GMSLA_031_04"
    """
    Additional Sum to Be Paid to Cover Tax Relief
    """
    ISLA_GMSLA_031_05 = "ISLA_GMSLA_031_05"
    """
    Notice Requirement
    """
    ISLA_GMSLA_032_01 = "ISLA_GMSLA_032_01"
    """
    Standard
    """
    ISLA_GMSLA_032_02 = "ISLA_GMSLA_032_02"
    """
    Reasonable Notice Defined
    """
    ISLA_GMSLA_032_03 = "ISLA_GMSLA_032_03"
    """
    No Right to Instruct
    """
    ISLA_GMSLA_033_01 = "ISLA_GMSLA_033_01"
    """
    Payment Within a Week
    """
    ISLA_GMSLA_033_02 = "ISLA_GMSLA_033_02"
    """
    Payment Within 10 Days
    """
    ISLA_GMSLA_033_03 = "ISLA_GMSLA_033_03"
    """
    Payment Upon Maturity
    """
    ISLA_GMSLA_034_01 = "ISLA_GMSLA_034_01"
    """
    Such Rate as Agreed
    """
    ISLA_GMSLA_034_02 = "ISLA_GMSLA_034_02"
    """
    VAT Added
    """
    ISLA_GMSLA_034_03 = "ISLA_GMSLA_034_03"
    """
    No Deduction
    """
    ISLA_GMSLA_034_04 = "ISLA_GMSLA_034_04"
    """
    No Rate Payable
    """
    ISLA_GMSLA_035_01 = "ISLA_GMSLA_035_01"
    """
    Lender May Terminate a Loan at any Time
    """
    ISLA_GMSLA_035_02 = "ISLA_GMSLA_035_02"
    """
    Lender May Not Terminate a Loan
    """
    ISLA_GMSLA_036_01 = "ISLA_GMSLA_036_01"
    """
    Borrower May Terminate a Loan at Any Time
    """
    ISLA_GMSLA_036_02 = "ISLA_GMSLA_036_02"
    """
    Borrower May Terminate a Loan Subject to Notice
    """
    ISLA_GMSLA_036_03 = "ISLA_GMSLA_036_03"
    """
    Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
    """
    ISLA_GMSLA_036_04 = "ISLA_GMSLA_036_04"
    """
    Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
    """
    ISLA_GMSLA_037_01 = "ISLA_GMSLA_037_01"
    """
    Failure to Deliver Event of Default Applies
    """
    ISLA_GMSLA_037_02 = "ISLA_GMSLA_037_02"
    """
    Failure to Deliver Event of Default does not Apply
    """
    ISLA_GMSLA_037_03 = "ISLA_GMSLA_037_03"
    """
    Failure to Deliver Event of Default does not Apply to Lender
    """
    ISLA_GMSLA_038_01 = "ISLA_GMSLA_038_01"
    """
    2000 Standard
    """
    ISLA_GMSLA_038_02 = "ISLA_GMSLA_038_02"
    """
    2010 Standard
    """
    ISLA_GMSLA_038_03 = "ISLA_GMSLA_038_03"
    """
    2018 Standard
    """
    ISLA_GMSLA_038_04 = "ISLA_GMSLA_038_04"
    """
    2000 Modified No Lender Close Out
    """
    ISLA_GMSLA_039_01 = "ISLA_GMSLA_039_01"
    """
    2000 Standard
    """
    ISLA_GMSLA_039_02 = "ISLA_GMSLA_039_02"
    """
    2010/2018 Standard
    """
    ISLA_GMSLA_039_03 = "ISLA_GMSLA_039_03"
    """
    Hybrid
    """
    ISLA_GMSLA_040_01 = "ISLA_GMSLA_040_01"
    """
    2000 Standard
    """
    ISLA_GMSLA_040_02 = "ISLA_GMSLA_040_02"
    """
    2010/2018 Standard
    """
    ISLA_GMSLA_040_03 = "ISLA_GMSLA_040_03"
    """
    Hybrid
    """
    ISLA_GMSLA_041_01 = "ISLA_GMSLA_041_01"
    """
    Standard Costs and Expenses
    """
    ISLA_GMSLA_041_02 = "ISLA_GMSLA_041_02"
    """
    Limitation of Costs and Expenses
    """
    ISLA_GMSLA_041_03 = "ISLA_GMSLA_041_03"
    """
    Expansion of Costs and Expenses
    """
    ISLA_GMSLA_042_01 = "ISLA_GMSLA_042_01"
    """
    No Contractual Set-Off
    """
    ISLA_GMSLA_042_02 = "ISLA_GMSLA_042_02"
    """
    Simple Contractual Set-Off
    """
    ISLA_GMSLA_042_03 = "ISLA_GMSLA_042_03"
    """
    Set-Off with Unascertained Obligations Amendment
    """
    ISLA_GMSLA_043_01 = "ISLA_GMSLA_043_01"
    """
    Standard Paragraph 11.2(a)
    """
    ISLA_GMSLA_043_02 = "ISLA_GMSLA_043_02"
    """
    Amended Paragraph 11.2,(a) applies
    """
    ISLA_GMSLA_044_01 = "ISLA_GMSLA_044_01"
    """
    Consent
    """
    ISLA_GMSLA_044_02 = "ISLA_GMSLA_044_02"
    """
    Consent with Standard Exclusions
    """
    ISLA_GMSLA_044_03 = "ISLA_GMSLA_044_03"
    """
    Consent with Additional Exclusions
    """
    ISLA_GMSLA_044_04 = "ISLA_GMSLA_044_04"
    """
    Pre-approved Assignments
    """
    ISLA_GMSLA_045_01 = "ISLA_GMSLA_045_01"
    """
    Parties May Record All Conversations
    """
    ISLA_GMSLA_045_02 = "ISLA_GMSLA_045_02"
    """
    Parties Agree to Obtain Consent
    """
    ISLA_GMSLA_045_03 = "ISLA_GMSLA_045_03"
    """
    Parties Limit the Conversations that May be Recorded
    """
    ISLA_GMSLA_045_04 = "ISLA_GMSLA_045_04"
    """
    Submission as Evidence
    """
    ISLA_GMSLA_046_01 = "ISLA_GMSLA_046_01"
    """
    Standard Waiver of Immunity Applies
    """
    ISLA_GMSLA_046_02 = "ISLA_GMSLA_046_02"
    """
    Waiver of Immunity may Not Apply
    """
    ISLA_GMSLA_047_01 = "ISLA_GMSLA_047_01"
    """
    No Additional Documentation Required
    """
    ISLA_GMSLA_047_02 = "ISLA_GMSLA_047_02"
    """
    Additional Documentation Required
    """
    ISLA_GMSLA_048_01 = "ISLA_GMSLA_048_01"
    """
    Collateral Transfer Details not included
    """
    ISLA_GMSLA_048_02 = "ISLA_GMSLA_048_02"
    """
    Collateral Transfer Details included
    """
    ISLA_GMSLA_049_01 = "ISLA_GMSLA_049_01"
    """
    Confidentiality Clause
    """
    ISLA_GMSLA_049_02 = "ISLA_GMSLA_049_02"
    """
    Permitted Disclosure Clause
    """
    ISLA_GMSLA_050_01 = "ISLA_GMSLA_050_01"
    """
    Paragraph 20.1 Amended to Refer  Paragraph 6
    """
    ISLA_GMSLA_050_02 = "ISLA_GMSLA_050_02"
    """
    Paragraph 27.2 Amended to refer to the 2010 GMSLA
    """
    ISLA_GMSLA_051_01 = "ISLA_GMSLA_051_01"
    """
    MCTA  Delivery only
    """
    ISLA_GMSLA_051_02 = "ISLA_GMSLA_051_02"
    """
    MCTA  Delivery and Re-Delivery
    """
    ISLA_GMSLA_051_03 = "ISLA_GMSLA_051_03"
    """
    MCTA  Drops to Zero for a Defaulting Party
    """
    ISLA_GMSLA_052_01 = "ISLA_GMSLA_052_01"
    """
    No Non-Reliance Representation
    """
    ISLA_GMSLA_052_02 = "ISLA_GMSLA_052_02"
    """
    Non-Reliance Representation Added
    """
    ISLA_GMSLA_053_01 = "ISLA_GMSLA_053_01"
    """
    No Records and Statements Clause
    """
    ISLA_GMSLA_053_02 = "ISLA_GMSLA_053_02"
    """
    Records and Statements Clause Added
    """
    ISLA_GMSLA_054_01 = "ISLA_GMSLA_054_01"
    """
    Recovery and Resolution not Included
    """
    ISLA_GMSLA_054_02 = "ISLA_GMSLA_054_02"
    """
    Recovery and Resolution Included in GMSLA
    """
    ISLA_GMSLA_054_03 = "ISLA_GMSLA_054_03"
    """
    Recovery and Resolution Included by Protocol
    """
    ISLA_GMSLA_054_04 = "ISLA_GMSLA_054_04"
    """
    Recovery and Resolution Incorporated by Reference
    """
    ISLA_GMSLA_055_01 = "ISLA_GMSLA_055_01"
    """
    Security Agreement Details Included
    """
    ISLA_GMSLA_056_01 = "ISLA_GMSLA_056_01"
    """
    Triparty Services Not Referenced
    """
    ISLA_GMSLA_056_02 = "ISLA_GMSLA_056_02"
    """
    Triparty Services May Apply
    """
