package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.MasterAgreementClauseIdentifierEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.0.0
 */
@RosettaEnum("MasterAgreementClauseIdentifierEnum")
public enum MasterAgreementClauseIdentifierEnum {

	/**
	 * Date of Agreement
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_001") 
	ISLA_GMSLA_001("ISLA_GMSLA_001", null),
	
	/**
	 * Parties
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_002") 
	ISLA_GMSLA_002("ISLA_GMSLA_002", null),
	
	/**
	 * Specific Roles
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_003") 
	ISLA_GMSLA_003("ISLA_GMSLA_003", null),
	
	/**
	 * Eligible Collateral
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_004") 
	ISLA_GMSLA_004("ISLA_GMSLA_004", null),
	
	/**
	 * Margin
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_005") 
	ISLA_GMSLA_005("ISLA_GMSLA_005", null),
	
	/**
	 * Aggregation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_006") 
	ISLA_GMSLA_006("ISLA_GMSLA_006", null),
	
	/**
	 * Collateral Disapplication
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_007") 
	ISLA_GMSLA_007("ISLA_GMSLA_007", null),
	
	/**
	 * Settlement Netting
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_008") 
	ISLA_GMSLA_008("ISLA_GMSLA_008", null),
	
	/**
	 * Notification Time
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_009") 
	ISLA_GMSLA_009("ISLA_GMSLA_009", null),
	
	/**
	 * Indemnity
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_010") 
	ISLA_GMSLA_010("ISLA_GMSLA_010", null),
	
	/**
	 * Base Currency
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_011") 
	ISLA_GMSLA_011("ISLA_GMSLA_011", null),
	
	/**
	 * Places of Business
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_012") 
	ISLA_GMSLA_012("ISLA_GMSLA_012", null),
	
	/**
	 * Value
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_013") 
	ISLA_GMSLA_013("ISLA_GMSLA_013", null),
	
	/**
	 * Automatic Early Termination
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_014") 
	ISLA_GMSLA_014("ISLA_GMSLA_014", null),
	
	/**
	 * Designated Offices
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_015") 
	ISLA_GMSLA_015("ISLA_GMSLA_015", null),
	
	/**
	 * Address for Notices
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_016") 
	ISLA_GMSLA_016("ISLA_GMSLA_016", null),
	
	/**
	 * Process Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_017") 
	ISLA_GMSLA_017("ISLA_GMSLA_017", null),
	
	/**
	 * Party Acting as Agent
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_018") 
	ISLA_GMSLA_018("ISLA_GMSLA_018", null),
	
	/**
	 * Pooled Principal Transactions 
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_019") 
	ISLA_GMSLA_019("ISLA_GMSLA_019", null),
	
	/**
	 * Party Preparing the Agreement 
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_020") 
	ISLA_GMSLA_020("ISLA_GMSLA_020", null),
	
	/**
	 * Default Interest Rate
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_021") 
	ISLA_GMSLA_021("ISLA_GMSLA_021", null),
	
	/**
	 * Existing Transactions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_022") 
	ISLA_GMSLA_022("ISLA_GMSLA_022", null),
	
	/**
	 * Automation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_023") 
	ISLA_GMSLA_023("ISLA_GMSLA_023", null),
	
	/**
	 * Act of Insolvency
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_024") 
	ISLA_GMSLA_024("ISLA_GMSLA_024", null),
	
	/**
	 * Buy-In
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_025") 
	ISLA_GMSLA_025("ISLA_GMSLA_025", null),
	
	/**
	 * Currency Conversions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_026") 
	ISLA_GMSLA_026("ISLA_GMSLA_026", null),
	
	/**
	 * Scope
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_027") 
	ISLA_GMSLA_027("ISLA_GMSLA_027", null),
	
	/**
	 * Collateral Delivery Timings
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_028") 
	ISLA_GMSLA_028("ISLA_GMSLA_028", null),
	
	/**
	 * Delivery
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_029") 
	ISLA_GMSLA_029("ISLA_GMSLA_029", null),
	
	/**
	 * Substitution of Collateral
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_030") 
	ISLA_GMSLA_030("ISLA_GMSLA_030", null),
	
	/**
	 * Manufactured Payments
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_031") 
	ISLA_GMSLA_031("ISLA_GMSLA_031", null),
	
	/**
	 * Corporate Actions
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_032") 
	ISLA_GMSLA_032("ISLA_GMSLA_032", null),
	
	/**
	 * Payment of Rates
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_033") 
	ISLA_GMSLA_033("ISLA_GMSLA_033", null),
	
	/**
	 * Rate Applicable to Loaned Securities
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_034") 
	ISLA_GMSLA_034("ISLA_GMSLA_034", null),
	
	/**
	 * Lender&#39;s Right to Terminate a Loan
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_035") 
	ISLA_GMSLA_035("ISLA_GMSLA_035", null),
	
	/**
	 * Borrower&#39;s Right to Terminate a Loan
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_036") 
	ISLA_GMSLA_036("ISLA_GMSLA_036", null),
	
	/**
	 * Failure to Deliver Event of Default
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_037") 
	ISLA_GMSLA_037("ISLA_GMSLA_037", null),
	
	/**
	 * Failure to Redeliver
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_038") 
	ISLA_GMSLA_038("ISLA_GMSLA_038", null),
	
	/**
	 * Assets Transferred to a Trustee
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_039") 
	ISLA_GMSLA_039("ISLA_GMSLA_039", null),
	
	/**
	 * Suspension Event of Default
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_040") 
	ISLA_GMSLA_040("ISLA_GMSLA_040", null),
	
	/**
	 * Costs and Expenses
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_041") 
	ISLA_GMSLA_041("ISLA_GMSLA_041", null),
	
	/**
	 * Set-Off
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_042") 
	ISLA_GMSLA_042("ISLA_GMSLA_042", null),
	
	/**
	 * Default Market Value Fallbacks
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_043") 
	ISLA_GMSLA_043("ISLA_GMSLA_043", null),
	
	/**
	 * Assignment
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_044") 
	ISLA_GMSLA_044("ISLA_GMSLA_044", null),
	
	/**
	 * Telephone Recordings
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_045") 
	ISLA_GMSLA_045("ISLA_GMSLA_045", null),
	
	/**
	 * Waiver of Immunity
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_046") 
	ISLA_GMSLA_046("ISLA_GMSLA_046", null),
	
	/**
	 * Agreement to Deliver Documents
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_047") 
	ISLA_GMSLA_047("ISLA_GMSLA_047", null),
	
	/**
	 * Collateral Transfer Details
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_048") 
	ISLA_GMSLA_048("ISLA_GMSLA_048", null),
	
	/**
	 * Confidentiality
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_049") 
	ISLA_GMSLA_049("ISLA_GMSLA_049", null),
	
	/**
	 * Correction
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_050") 
	ISLA_GMSLA_050("ISLA_GMSLA_050", null),
	
	/**
	 * Minimum Collateral Transfer Amount
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_051") 
	ISLA_GMSLA_051("ISLA_GMSLA_051", null),
	
	/**
	 * Non-Reliance Representation
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_052") 
	ISLA_GMSLA_052("ISLA_GMSLA_052", null),
	
	/**
	 * Records and Statements
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_053") 
	ISLA_GMSLA_053("ISLA_GMSLA_053", null),
	
	/**
	 * Recovery and Resolution
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_054") 
	ISLA_GMSLA_054("ISLA_GMSLA_054", null),
	
	/**
	 * Security Agreement Details
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_055") 
	ISLA_GMSLA_055("ISLA_GMSLA_055", null),
	
	/**
	 * Triparty Services
	 */
	@RosettaEnumValue(value = "ISLA_GMSLA_056") 
	ISLA_GMSLA_056("ISLA_GMSLA_056", null)
;
	private static Map<String, MasterAgreementClauseIdentifierEnum> values;
	static {
        Map<String, MasterAgreementClauseIdentifierEnum> map = new ConcurrentHashMap<>();
		for (MasterAgreementClauseIdentifierEnum instance : MasterAgreementClauseIdentifierEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MasterAgreementClauseIdentifierEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MasterAgreementClauseIdentifierEnum fromDisplayName(String name) {
		MasterAgreementClauseIdentifierEnum value = values.get(name);
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
