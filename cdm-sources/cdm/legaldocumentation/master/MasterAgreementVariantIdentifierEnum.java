package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.MasterAgreementVariantIdentifierEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.0.0
 */
@RosettaEnum("MasterAgreementVariantIdentifierEnum")
public enum MasterAgreementVariantIdentifierEnum {

	/**
	 * Agreement is Undated
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_001_01") 
	ISLA_GMSLA_001_01("ISLA_GMSLA_001_01", null),
	
	/**
	 * Agreement is Dated
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_001_02") 
	ISLA_GMSLA_001_02("ISLA_GMSLA_001_02", null),
	
	/**
	 * Name and Place of Incorporation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_002_01") 
	ISLA_GMSLA_002_01("ISLA_GMSLA_002_01", null),
	
	/**
	 * Names and Place of Incorporation plus Additional Information
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_002_02") 
	ISLA_GMSLA_002_02("ISLA_GMSLA_002_02", null),
	
	/**
	 * Defining the Party&#39;s Role as Lender or Borrower
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_002_03") 
	ISLA_GMSLA_002_03("ISLA_GMSLA_002_03", null),
	
	/**
	 * Non-specific Roles
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_003_01") 
	ISLA_GMSLA_003_01("ISLA_GMSLA_003_01", null),
	
	/**
	 * Specific Roles
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_003_02") 
	ISLA_GMSLA_003_02("ISLA_GMSLA_003_02", null),
	
	/**
	 * GMSLA Schedule
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_004_01") 
	ISLA_GMSLA_004_01("ISLA_GMSLA_004_01", null),
	
	/**
	 * Outside of GMSLA
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_004_02") 
	ISLA_GMSLA_004_02("ISLA_GMSLA_004_02", null),
	
	/**
	 * Additional Criteria
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_004_03") 
	ISLA_GMSLA_004_03("ISLA_GMSLA_004_03", null),
	
	/**
	 * GMSLA Schedule
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_005_01") 
	ISLA_GMSLA_005_01("ISLA_GMSLA_005_01", null),
	
	/**
	 * Outside of GMSLA
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_005_02") 
	ISLA_GMSLA_005_02("ISLA_GMSLA_005_02", null),
	
	/**
	 * Aggregation Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006_01") 
	ISLA_GMSLA_006_01("ISLA_GMSLA_006_01", null),
	
	/**
	 * Aggregation Does Not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006_02") 
	ISLA_GMSLA_006_02("ISLA_GMSLA_006_02", null),
	
	/**
	 * Aggregation Applies Separately to Loan Groups
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006_03") 
	ISLA_GMSLA_006_03("ISLA_GMSLA_006_03", null),
	
	/**
	 * Aggregation Applies to Some but Not All Loans
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006_04") 
	ISLA_GMSLA_006_04("ISLA_GMSLA_006_04", null),
	
	/**
	 * Neither Aggregation nor Loan by Loan Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006_05") 
	ISLA_GMSLA_006_05("ISLA_GMSLA_006_05", null),
	
	/**
	 * Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_007_01") 
	ISLA_GMSLA_007_01("ISLA_GMSLA_007_01", null),
	
	/**
	 * Collateral Disapplied
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_007_02") 
	ISLA_GMSLA_007_02("ISLA_GMSLA_007_02", null),
	
	/**
	 * Netting of Collateral Shall Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_008_01") 
	ISLA_GMSLA_008_01("ISLA_GMSLA_008_01", null),
	
	/**
	 * Netting of Collateral Shall Not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_008_02") 
	ISLA_GMSLA_008_02("ISLA_GMSLA_008_02", null),
	
	/**
	 * Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_008_03") 
	ISLA_GMSLA_008_03("ISLA_GMSLA_008_03", null),
	
	/**
	 * Netting of Collateral Shall Apply Separately per Group of Loans
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_008_04") 
	ISLA_GMSLA_008_04("ISLA_GMSLA_008_04", null),
	
	/**
	 * Specified Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_009_01") 
	ISLA_GMSLA_009_01("ISLA_GMSLA_009_01", null),
	
	/**
	 * Notification Time by Collateral Type
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_009_02") 
	ISLA_GMSLA_009_02("ISLA_GMSLA_009_02", null),
	
	/**
	 * Notification Time as Agreed
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_009_03") 
	ISLA_GMSLA_009_03("ISLA_GMSLA_009_03", null),
	
	/**
	 * No Notification Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_009_04") 
	ISLA_GMSLA_009_04("ISLA_GMSLA_009_04", null),
	
	/**
	 * Indemnity Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_010_01") 
	ISLA_GMSLA_010_01("ISLA_GMSLA_010_01", null),
	
	/**
	 * Indemnity does not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_010_02") 
	ISLA_GMSLA_010_02("ISLA_GMSLA_010_02", null),
	
	/**
	 * Single Base Currency
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_011_01") 
	ISLA_GMSLA_011_01("ISLA_GMSLA_011_01", null),
	
	/**
	 * Single Base Currency with Fallback
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_011_02") 
	ISLA_GMSLA_011_02("ISLA_GMSLA_011_02", null),
	
	/**
	 * Single Base Currency with Multiple Fallback Options
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_011_03") 
	ISLA_GMSLA_011_03("ISLA_GMSLA_011_03", null),
	
	/**
	 * Locations are Specified Without Reference to Party
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_012_01") 
	ISLA_GMSLA_012_01("ISLA_GMSLA_012_01", null),
	
	/**
	 * Locations are Specified Separately per Party
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_012_02") 
	ISLA_GMSLA_012_02("ISLA_GMSLA_012_02", null),
	
	/**
	 * Not all Places of Business Have to be Open
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_012_03") 
	ISLA_GMSLA_012_03("ISLA_GMSLA_012_03", null),
	
	/**
	 * Standard Bid Price
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_01") 
	ISLA_GMSLA_013_01("ISLA_GMSLA_013_01", null),
	
	/**
	 * Standard Mid Price
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_02") 
	ISLA_GMSLA_013_02("ISLA_GMSLA_013_02", null),
	
	/**
	 * 2018 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_03") 
	ISLA_GMSLA_013_03("ISLA_GMSLA_013_03", null),
	
	/**
	 * Borrowers Agreement to Pricing Source
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_04") 
	ISLA_GMSLA_013_04("ISLA_GMSLA_013_04", null),
	
	/**
	 * Pre-agreed Pricing Source
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_05") 
	ISLA_GMSLA_013_05("ISLA_GMSLA_013_05", null),
	
	/**
	 * Time Variation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013_06") 
	ISLA_GMSLA_013_06("ISLA_GMSLA_013_06", null),
	
	/**
	 * Automatic Early Termination does not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014_01") 
	ISLA_GMSLA_014_01("ISLA_GMSLA_014_01", null),
	
	/**
	 * Automatic Early Termination Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014_02") 
	ISLA_GMSLA_014_02("ISLA_GMSLA_014_02", null),
	
	/**
	 * Automatic Early Termination Applies in Modified Form)
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014_03") 
	ISLA_GMSLA_014_03("ISLA_GMSLA_014_03", null),
	
	/**
	 * Automatic Early Termination is specified separately for each Principal
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014_04") 
	ISLA_GMSLA_014_04("ISLA_GMSLA_014_04", null),
	
	/**
	 * Automatic Early Termination is not applicable unless required due to the systems of law
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014_05") 
	ISLA_GMSLA_014_05("ISLA_GMSLA_014_05", null),
	
	/**
	 * Party Specifies a Single Designated Office
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_015_01") 
	ISLA_GMSLA_015_01("ISLA_GMSLA_015_01", null),
	
	/**
	 * Party Specifies Multiple Designated Offices
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_015_02") 
	ISLA_GMSLA_015_02("ISLA_GMSLA_015_02", null),
	
	/**
	 * 2000 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_01") 
	ISLA_GMSLA_016_01("ISLA_GMSLA_016_01", null),
	
	/**
	 * 2010 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_02") 
	ISLA_GMSLA_016_02("ISLA_GMSLA_016_02", null),
	
	/**
	 * 2018 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_03") 
	ISLA_GMSLA_016_03("ISLA_GMSLA_016_03", null),
	
	/**
	 * Plus Email
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_04") 
	ISLA_GMSLA_016_04("ISLA_GMSLA_016_04", null),
	
	/**
	 * Separate Address for Legal and Operational Notices
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_05") 
	ISLA_GMSLA_016_05("ISLA_GMSLA_016_05", null),
	
	/**
	 * Special Instructions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016_06") 
	ISLA_GMSLA_016_06("ISLA_GMSLA_016_06", null),
	
	/**
	 * No Process Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_017_01") 
	ISLA_GMSLA_017_01("ISLA_GMSLA_017_01", null),
	
	/**
	 * Process Agent Specified
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_017_02") 
	ISLA_GMSLA_017_02("ISLA_GMSLA_017_02", null),
	
	/**
	 * Process Agent to be Appointed
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_017_03") 
	ISLA_GMSLA_017_03("ISLA_GMSLA_017_03", null),
	
	/**
	 * A Party will not act as Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_018_01") 
	ISLA_GMSLA_018_01("ISLA_GMSLA_018_01", null),
	
	/**
	 * A Party may act as Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_018_02") 
	ISLA_GMSLA_018_02("ISLA_GMSLA_018_02", null),
	
	/**
	 * A Party will always act as Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_018_03") 
	ISLA_GMSLA_018_03("ISLA_GMSLA_018_03", null),
	
	/**
	 * Pooled Principal Transactions Shall Not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_019_01") 
	ISLA_GMSLA_019_01("ISLA_GMSLA_019_01", null),
	
	/**
	 * Pooled Principal Transactions Shall  Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_019_02") 
	ISLA_GMSLA_019_02("ISLA_GMSLA_019_02", null),
	
	/**
	 * Pooled Principal Transactions May Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_019_03") 
	ISLA_GMSLA_019_03("ISLA_GMSLA_019_03", null),
	
	/**
	 * Simple Election
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_020_01") 
	ISLA_GMSLA_020_01("ISLA_GMSLA_020_01", null),
	
	/**
	 * Election with Modifications
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_020_02") 
	ISLA_GMSLA_020_02("ISLA_GMSLA_020_02", null),
	
	/**
	 * Term Rate
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021_01") 
	ISLA_GMSLA_021_01("ISLA_GMSLA_021_01", null),
	
	/**
	 * Overnight Rate
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021_02") 
	ISLA_GMSLA_021_02("ISLA_GMSLA_021_02", null),
	
	/**
	 * Risk Free Rate
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021_03") 
	ISLA_GMSLA_021_03("ISLA_GMSLA_021_03", null),
	
	/**
	 * Non-Defaulting Party Election
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021_04") 
	ISLA_GMSLA_021_04("ISLA_GMSLA_021_04", null),
	
	/**
	 * Spread
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021_05") 
	ISLA_GMSLA_021_05("ISLA_GMSLA_021_05", null),
	
	/**
	 * Agreement Covers Existing Loans
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_022_01") 
	ISLA_GMSLA_022_01("ISLA_GMSLA_022_01", null),
	
	/**
	 * Agreement Does Not Cover Existing Loans
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_022_02") 
	ISLA_GMSLA_022_02("ISLA_GMSLA_022_02", null),
	
	/**
	 * Automation Does Not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_023_01") 
	ISLA_GMSLA_023_01("ISLA_GMSLA_023_01", null),
	
	/**
	 * Automation May Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_023_02") 
	ISLA_GMSLA_023_02("ISLA_GMSLA_023_02", null),
	
	/**
	 * Standard Pre-Print
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_024_01") 
	ISLA_GMSLA_024_01("ISLA_GMSLA_024_01", null),
	
	/**
	 * Grace Period Amendment
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_024_02") 
	ISLA_GMSLA_024_02("ISLA_GMSLA_024_02", null),
	
	/**
	 * Jurisdictional Amendments
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_024_03") 
	ISLA_GMSLA_024_03("ISLA_GMSLA_024_03", null),
	
	/**
	 * Transferor Pays Costs and Expenses
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_025_01") 
	ISLA_GMSLA_025_01("ISLA_GMSLA_025_01", null),
	
	/**
	 * Transferor Pays Costs and Expenses other than those arising from Negligence
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_025_02") 
	ISLA_GMSLA_025_02("ISLA_GMSLA_025_02", null),
	
	/**
	 * Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_025_03") 
	ISLA_GMSLA_025_03("ISLA_GMSLA_025_03", null),
	
	/**
	 * Buy-in Expanded to Cover Buy-in Exercised by an Exchange
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_025_04") 
	ISLA_GMSLA_025_04("ISLA_GMSLA_025_04", null),
	
	/**
	 * Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_026_01") 
	ISLA_GMSLA_026_01("ISLA_GMSLA_026_01", null),
	
	/**
	 * Selecting Party other than Lender
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_026_02") 
	ISLA_GMSLA_026_02("ISLA_GMSLA_026_02", null),
	
	/**
	 * Variation of Exchange Rate Source
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_026_03") 
	ISLA_GMSLA_026_03("ISLA_GMSLA_026_03", null),
	
	/**
	 * Standard Scope
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_027_01") 
	ISLA_GMSLA_027_01("ISLA_GMSLA_027_01", null),
	
	/**
	 * Limited Scope
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_027_02") 
	ISLA_GMSLA_027_02("ISLA_GMSLA_027_02", null),
	
	/**
	 * Same Day
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028_01") 
	ISLA_GMSLA_028_01("ISLA_GMSLA_028_01", null),
	
	/**
	 * Alternative Delivery Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028_02") 
	ISLA_GMSLA_028_02("ISLA_GMSLA_028_02", null),
	
	/**
	 * Same Day with Notification Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028_03") 
	ISLA_GMSLA_028_03("ISLA_GMSLA_028_03", null),
	
	/**
	 * Alternative Delivery Time with Notification Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028_04") 
	ISLA_GMSLA_028_04("ISLA_GMSLA_028_04", null),
	
	/**
	 * Asset Dependent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028_05") 
	ISLA_GMSLA_028_05("ISLA_GMSLA_028_05", null),
	
	/**
	 * Simultaneous delivery of securities and collateral
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_029_01") 
	ISLA_GMSLA_029_01("ISLA_GMSLA_029_01", null),
	
	/**
	 * Collateral Delivery as specified in the Security Agreement
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_029_02") 
	ISLA_GMSLA_029_02("ISLA_GMSLA_029_02", null),
	
	/**
	 * Lender to Deliver Securities once Collateral is Delivered
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_029_03") 
	ISLA_GMSLA_029_03("ISLA_GMSLA_029_03", null),
	
	/**
	 * Borrower Request
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_030_01") 
	ISLA_GMSLA_030_01("ISLA_GMSLA_030_01", null),
	
	/**
	 * Borrower Request/Lender Consent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_030_02") 
	ISLA_GMSLA_030_02("ISLA_GMSLA_030_02", null),
	
	/**
	 * Lender or Borrower Request
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_030_03") 
	ISLA_GMSLA_030_03("ISLA_GMSLA_030_03", null),
	
	/**
	 * Pre-approval of Alternative Collateral
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_030_04") 
	ISLA_GMSLA_030_04("ISLA_GMSLA_030_04", null),
	
	/**
	 * Manufactured Payment of Amount Such Party Would Be Entitled to Receive
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031_01") 
	ISLA_GMSLA_031_01("ISLA_GMSLA_031_01", null),
	
	/**
	 * Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031_02") 
	ISLA_GMSLA_031_02("ISLA_GMSLA_031_02", null),
	
	/**
	 * Manufactured Payment Only in Relation to Loaned Securities
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031_03") 
	ISLA_GMSLA_031_03("ISLA_GMSLA_031_03", null),
	
	/**
	 * Additional Sum to Be Paid to Cover Tax Relief
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031_04") 
	ISLA_GMSLA_031_04("ISLA_GMSLA_031_04", null),
	
	/**
	 * Notice Requirement
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031_05") 
	ISLA_GMSLA_031_05("ISLA_GMSLA_031_05", null),
	
	/**
	 * Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_032_01") 
	ISLA_GMSLA_032_01("ISLA_GMSLA_032_01", null),
	
	/**
	 * Reasonable Notice Defined
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_032_02") 
	ISLA_GMSLA_032_02("ISLA_GMSLA_032_02", null),
	
	/**
	 * No Right to Instruct
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_032_03") 
	ISLA_GMSLA_032_03("ISLA_GMSLA_032_03", null),
	
	/**
	 * Payment Within a Week
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_033_01") 
	ISLA_GMSLA_033_01("ISLA_GMSLA_033_01", null),
	
	/**
	 * Payment Within 10 Days
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_033_02") 
	ISLA_GMSLA_033_02("ISLA_GMSLA_033_02", null),
	
	/**
	 * Payment Upon Maturity
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_033_03") 
	ISLA_GMSLA_033_03("ISLA_GMSLA_033_03", null),
	
	/**
	 * Such Rate as Agreed
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_034_01") 
	ISLA_GMSLA_034_01("ISLA_GMSLA_034_01", null),
	
	/**
	 * VAT Added
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_034_02") 
	ISLA_GMSLA_034_02("ISLA_GMSLA_034_02", null),
	
	/**
	 * No Deduction
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_034_03") 
	ISLA_GMSLA_034_03("ISLA_GMSLA_034_03", null),
	
	/**
	 * No Rate Payable
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_034_04") 
	ISLA_GMSLA_034_04("ISLA_GMSLA_034_04", null),
	
	/**
	 * Lender May Terminate a Loan at any Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_035_01") 
	ISLA_GMSLA_035_01("ISLA_GMSLA_035_01", null),
	
	/**
	 * Lender May Not Terminate a Loan
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_035_02") 
	ISLA_GMSLA_035_02("ISLA_GMSLA_035_02", null),
	
	/**
	 * Borrower May Terminate a Loan at Any Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_036_01") 
	ISLA_GMSLA_036_01("ISLA_GMSLA_036_01", null),
	
	/**
	 * Borrower May Terminate a Loan Subject to Notice
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_036_02") 
	ISLA_GMSLA_036_02("ISLA_GMSLA_036_02", null),
	
	/**
	 * Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_036_03") 
	ISLA_GMSLA_036_03("ISLA_GMSLA_036_03", null),
	
	/**
	 * Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_036_04") 
	ISLA_GMSLA_036_04("ISLA_GMSLA_036_04", null),
	
	/**
	 * Failure to Deliver Event of Default Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_037_01") 
	ISLA_GMSLA_037_01("ISLA_GMSLA_037_01", null),
	
	/**
	 * Failure to Deliver Event of Default does not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_037_02") 
	ISLA_GMSLA_037_02("ISLA_GMSLA_037_02", null),
	
	/**
	 * Failure to Deliver Event of Default does not Apply to Lender
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_037_03") 
	ISLA_GMSLA_037_03("ISLA_GMSLA_037_03", null),
	
	/**
	 * 2000 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_038_01") 
	ISLA_GMSLA_038_01("ISLA_GMSLA_038_01", null),
	
	/**
	 * 2010 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_038_02") 
	ISLA_GMSLA_038_02("ISLA_GMSLA_038_02", null),
	
	/**
	 * 2018 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_038_03") 
	ISLA_GMSLA_038_03("ISLA_GMSLA_038_03", null),
	
	/**
	 * 2000 Modified No Lender Close Out
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_038_04") 
	ISLA_GMSLA_038_04("ISLA_GMSLA_038_04", null),
	
	/**
	 * 2000 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_039_01") 
	ISLA_GMSLA_039_01("ISLA_GMSLA_039_01", null),
	
	/**
	 * 2010/2018 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_039_02") 
	ISLA_GMSLA_039_02("ISLA_GMSLA_039_02", null),
	
	/**
	 * Hybrid
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_039_03") 
	ISLA_GMSLA_039_03("ISLA_GMSLA_039_03", null),
	
	/**
	 * 2000 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_040_01") 
	ISLA_GMSLA_040_01("ISLA_GMSLA_040_01", null),
	
	/**
	 * 2010/2018 Standard
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_040_02") 
	ISLA_GMSLA_040_02("ISLA_GMSLA_040_02", null),
	
	/**
	 * Hybrid
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_040_03") 
	ISLA_GMSLA_040_03("ISLA_GMSLA_040_03", null),
	
	/**
	 * Standard Costs and Expenses
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_041_01") 
	ISLA_GMSLA_041_01("ISLA_GMSLA_041_01", null),
	
	/**
	 * Limitation of Costs and Expenses
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_041_02") 
	ISLA_GMSLA_041_02("ISLA_GMSLA_041_02", null),
	
	/**
	 * Expansion of Costs and Expenses
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_041_03") 
	ISLA_GMSLA_041_03("ISLA_GMSLA_041_03", null),
	
	/**
	 * No Contractual Set-Off
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_042_01") 
	ISLA_GMSLA_042_01("ISLA_GMSLA_042_01", null),
	
	/**
	 * Simple Contractual Set-Off
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_042_02") 
	ISLA_GMSLA_042_02("ISLA_GMSLA_042_02", null),
	
	/**
	 * Set-Off with Unascertained Obligations Amendment
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_042_03") 
	ISLA_GMSLA_042_03("ISLA_GMSLA_042_03", null),
	
	/**
	 * Standard Paragraph 11.2(a)
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_043_01") 
	ISLA_GMSLA_043_01("ISLA_GMSLA_043_01", null),
	
	/**
	 * Amended Paragraph 11.2,(a) applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_043_02") 
	ISLA_GMSLA_043_02("ISLA_GMSLA_043_02", null),
	
	/**
	 * Consent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_044_01") 
	ISLA_GMSLA_044_01("ISLA_GMSLA_044_01", null),
	
	/**
	 * Consent with Standard Exclusions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_044_02") 
	ISLA_GMSLA_044_02("ISLA_GMSLA_044_02", null),
	
	/**
	 * Consent with Additional Exclusions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_044_03") 
	ISLA_GMSLA_044_03("ISLA_GMSLA_044_03", null),
	
	/**
	 * Pre-approved Assignments
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_044_04") 
	ISLA_GMSLA_044_04("ISLA_GMSLA_044_04", null),
	
	/**
	 * Parties May Record All Conversations
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_045_01") 
	ISLA_GMSLA_045_01("ISLA_GMSLA_045_01", null),
	
	/**
	 * Parties Agree to Obtain Consent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_045_02") 
	ISLA_GMSLA_045_02("ISLA_GMSLA_045_02", null),
	
	/**
	 * Parties Limit the Conversations that May be Recorded
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_045_03") 
	ISLA_GMSLA_045_03("ISLA_GMSLA_045_03", null),
	
	/**
	 * Submission as Evidence
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_045_04") 
	ISLA_GMSLA_045_04("ISLA_GMSLA_045_04", null),
	
	/**
	 * Standard Waiver of Immunity Applies
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_046_01") 
	ISLA_GMSLA_046_01("ISLA_GMSLA_046_01", null),
	
	/**
	 * Waiver of Immunity may Not Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_046_02") 
	ISLA_GMSLA_046_02("ISLA_GMSLA_046_02", null),
	
	/**
	 * No Additional Documentation Required
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_047_01") 
	ISLA_GMSLA_047_01("ISLA_GMSLA_047_01", null),
	
	/**
	 * Additional Documentation Required
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_047_02") 
	ISLA_GMSLA_047_02("ISLA_GMSLA_047_02", null),
	
	/**
	 * Collateral Transfer Details not included
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_048_01") 
	ISLA_GMSLA_048_01("ISLA_GMSLA_048_01", null),
	
	/**
	 * Collateral Transfer Details included
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_048_02") 
	ISLA_GMSLA_048_02("ISLA_GMSLA_048_02", null),
	
	/**
	 * Confidentiality Clause
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_049_01") 
	ISLA_GMSLA_049_01("ISLA_GMSLA_049_01", null),
	
	/**
	 * Permitted Disclosure Clause
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_049_02") 
	ISLA_GMSLA_049_02("ISLA_GMSLA_049_02", null),
	
	/**
	 * Paragraph 20.1 Amended to Refer  Paragraph 6
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_050_01") 
	ISLA_GMSLA_050_01("ISLA_GMSLA_050_01", null),
	
	/**
	 * Paragraph 27.2 Amended to refer to the 2010 GMSLA
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_050_02") 
	ISLA_GMSLA_050_02("ISLA_GMSLA_050_02", null),
	
	/**
	 * MCTA  Delivery only
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_051_01") 
	ISLA_GMSLA_051_01("ISLA_GMSLA_051_01", null),
	
	/**
	 * MCTA  Delivery and Re-Delivery
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_051_02") 
	ISLA_GMSLA_051_02("ISLA_GMSLA_051_02", null),
	
	/**
	 * MCTA  Drops to Zero for a Defaulting Party
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_051_03") 
	ISLA_GMSLA_051_03("ISLA_GMSLA_051_03", null),
	
	/**
	 * No Non-Reliance Representation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_052_01") 
	ISLA_GMSLA_052_01("ISLA_GMSLA_052_01", null),
	
	/**
	 * Non-Reliance Representation Added
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_052_02") 
	ISLA_GMSLA_052_02("ISLA_GMSLA_052_02", null),
	
	/**
	 * No Records and Statements Clause
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_053_01") 
	ISLA_GMSLA_053_01("ISLA_GMSLA_053_01", null),
	
	/**
	 * Records and Statements Clause Added
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_053_02") 
	ISLA_GMSLA_053_02("ISLA_GMSLA_053_02", null),
	
	/**
	 * Recovery and Resolution not Included
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_054_01") 
	ISLA_GMSLA_054_01("ISLA_GMSLA_054_01", null),
	
	/**
	 * Recovery and Resolution Included in GMSLA
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_054_02") 
	ISLA_GMSLA_054_02("ISLA_GMSLA_054_02", null),
	
	/**
	 * Recovery and Resolution Included by Protocol
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_054_03") 
	ISLA_GMSLA_054_03("ISLA_GMSLA_054_03", null),
	
	/**
	 * Recovery and Resolution Incorporated by Reference
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_054_04") 
	ISLA_GMSLA_054_04("ISLA_GMSLA_054_04", null),
	
	/**
	 * Security Agreement Details Included
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_055_01") 
	ISLA_GMSLA_055_01("ISLA_GMSLA_055_01", null),
	
	/**
	 * Triparty Services Not Referenced
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_056_01") 
	ISLA_GMSLA_056_01("ISLA_GMSLA_056_01", null),
	
	/**
	 * Triparty Services May Apply
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_056_02") 
	ISLA_GMSLA_056_02("ISLA_GMSLA_056_02", null)
;
	private static Map<String, MasterAgreementVariantIdentifierEnum> values;
	static {
        Map<String, MasterAgreementVariantIdentifierEnum> map = new ConcurrentHashMap<>();
		for (MasterAgreementVariantIdentifierEnum instance : MasterAgreementVariantIdentifierEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MasterAgreementVariantIdentifierEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MasterAgreementVariantIdentifierEnum fromDisplayName(String name) {
		MasterAgreementVariantIdentifierEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
