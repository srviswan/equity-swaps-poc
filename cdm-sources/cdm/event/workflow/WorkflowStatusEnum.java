package cdm.event.workflow;

import cdm.event.workflow.WorkflowStatusEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.0.0
 */
@RosettaEnum("WorkflowStatusEnum")
public enum WorkflowStatusEnum {

	@RosettaEnumValue(value = "Accepted") 
	ACCEPTED("Accepted", null),
	
	@RosettaEnumValue(value = "Alleged") 
	ALLEGED("Alleged", null),
	
	@RosettaEnumValue(value = "Amended") 
	AMENDED("Amended", null),
	
	@RosettaEnumValue(value = "Cancelled") 
	CANCELLED("Cancelled", null),
	
	@RosettaEnumValue(value = "Certain") 
	CERTAIN("Certain", null),
	
	@RosettaEnumValue(value = "Cleared") 
	CLEARED("Cleared", null),
	
	@RosettaEnumValue(value = "Pending") 
	PENDING("Pending", null),
	
	@RosettaEnumValue(value = "Rejected") 
	REJECTED("Rejected", null),
	
	@RosettaEnumValue(value = "Submitted") 
	SUBMITTED("Submitted", null),
	
	@RosettaEnumValue(value = "Terminated") 
	TERMINATED("Terminated", null),
	
	@RosettaEnumValue(value = "Uncertain") 
	UNCERTAIN("Uncertain", null),
	
	@RosettaEnumValue(value = "Unconfirmed") 
	UNCONFIRMED("Unconfirmed", null),
	
	@RosettaEnumValue(value = "Affirmed") 
	AFFIRMED("Affirmed", null),
	
	@RosettaEnumValue(value = "Confirmed") 
	CONFIRMED("Confirmed", null)
;
	private static Map<String, WorkflowStatusEnum> values;
	static {
        Map<String, WorkflowStatusEnum> map = new ConcurrentHashMap<>();
		for (WorkflowStatusEnum instance : WorkflowStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	WorkflowStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static WorkflowStatusEnum fromDisplayName(String name) {
		WorkflowStatusEnum value = values.get(name);
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
