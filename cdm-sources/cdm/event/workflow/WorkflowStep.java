package cdm.event.workflow;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account.AccountBuilder;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder;
import cdm.event.common.Lineage;
import cdm.event.common.Lineage.LineageBuilder;
import cdm.event.workflow.CreditLimitInformation;
import cdm.event.workflow.CreditLimitInformation.CreditLimitInformationBuilder;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.EventInstruction.EventInstructionBuilder;
import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestamp.EventTimestampBuilder;
import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.MessageInformation.MessageInformationBuilder;
import cdm.event.workflow.WorkflowState;
import cdm.event.workflow.WorkflowState.WorkflowStateBuilder;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.WorkflowStep.WorkflowStepBuilder;
import cdm.event.workflow.WorkflowStep.WorkflowStepBuilderImpl;
import cdm.event.workflow.WorkflowStep.WorkflowStepImpl;
import cdm.event.workflow.WorkflowStepApproval;
import cdm.event.workflow.WorkflowStepApproval.WorkflowStepApprovalBuilder;
import cdm.event.workflow.meta.WorkflowStepMeta;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A workflow step represents the state of a business event. The workflow step contains a reference to a previous WorkflowStep in order to preserve lineage. A workflow step is accepted if it contains a business event, proposed if proposedEvent is present and is rejected if the rejected flag is set.
 * @version 6.0.0
 */
@RosettaDataType(value="WorkflowStep", builder=WorkflowStep.WorkflowStepBuilderImpl.class, version="6.0.0")
@RuneDataType(value="WorkflowStep", model="Just another Rosetta model", builder=WorkflowStep.WorkflowStepBuilderImpl.class, version="6.0.0")
public interface WorkflowStep extends RosettaModelObject, GlobalKey {

	WorkflowStepMeta metaData = new WorkflowStepMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Life cycle event for the step. The businessEvent is optional when a proposedEvent or rejection are present.
	 */
	BusinessEvent getBusinessEvent();
	/**
	 * Documents the life cycle event for a position.
	 */
	CounterpartyPositionBusinessEvent getCounterpartyPositionBusinessEvent();
	/**
	 * The proposed event for a workflow step. The proposedEvent is optional when the businessEvent or rejection are present
	 */
	EventInstruction getProposedEvent();
	/**
	 * Flags this step as rejected.
	 */
	Boolean getRejected();
	/**
	 * Optional party approvals for the current workflow step. A workflow step can have any number of parties associated to it, thus this object is represented as a list. All parties that are expected to provide approval should have an item in this list that references them.
	 */
	List<? extends WorkflowStepApproval> getApproval();
	/**
	 * Optional previous workflow step that provides lineage to workflow steps that precedes it.
	 */
	ReferenceWithMetaWorkflowStep getPreviousWorkflowStep();
	/**
	 * The intended next event can be specified, even if the instructions are not known yet.
	 */
	EventInstruction getNextEvent();
	/**
	 * Contains all information pertaining the FpML messaging header 
	 */
	MessageInformation getMessageInformation();
	/**
	 * The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].
	 */
	List<? extends EventTimestamp> getTimestamp();
	/**
	 * The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.
	 */
	List<? extends Identifier> getEventIdentifier();
	/**
	 * Specifies whether the event is a new, a correction or a cancellation.
	 */
	ActionEnum getAction();
	/**
	 * The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).
	 */
	List<? extends Party> getParty();
	/**
	 * Optional account information that could be associated to the event.
	 */
	List<? extends Account> getAccount();
	/**
	 * The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).
	 */
	Lineage getLineage();
	CreditLimitInformation getCreditLimitInformation();
	/**
	 * The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.
	 */
	WorkflowState getWorkflowState();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	WorkflowStep build();
	
	WorkflowStep.WorkflowStepBuilder toBuilder();
	
	static WorkflowStep.WorkflowStepBuilder builder() {
		return new WorkflowStep.WorkflowStepBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WorkflowStep> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WorkflowStep> getType() {
		return WorkflowStep.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("businessEvent"), processor, BusinessEvent.class, getBusinessEvent());
		processRosetta(path.newSubPath("counterpartyPositionBusinessEvent"), processor, CounterpartyPositionBusinessEvent.class, getCounterpartyPositionBusinessEvent());
		processRosetta(path.newSubPath("proposedEvent"), processor, EventInstruction.class, getProposedEvent());
		processor.processBasic(path.newSubPath("rejected"), Boolean.class, getRejected(), this);
		processRosetta(path.newSubPath("approval"), processor, WorkflowStepApproval.class, getApproval());
		processRosetta(path.newSubPath("previousWorkflowStep"), processor, ReferenceWithMetaWorkflowStep.class, getPreviousWorkflowStep());
		processRosetta(path.newSubPath("nextEvent"), processor, EventInstruction.class, getNextEvent());
		processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.class, getMessageInformation());
		processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.class, getTimestamp());
		processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("action"), ActionEnum.class, getAction(), this);
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("lineage"), processor, Lineage.class, getLineage());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("workflowState"), processor, WorkflowState.class, getWorkflowState());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WorkflowStepBuilder extends WorkflowStep, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		BusinessEvent.BusinessEventBuilder getOrCreateBusinessEvent();
		@Override
		BusinessEvent.BusinessEventBuilder getBusinessEvent();
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder getOrCreateCounterpartyPositionBusinessEvent();
		@Override
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder getCounterpartyPositionBusinessEvent();
		EventInstruction.EventInstructionBuilder getOrCreateProposedEvent();
		@Override
		EventInstruction.EventInstructionBuilder getProposedEvent();
		WorkflowStepApproval.WorkflowStepApprovalBuilder getOrCreateApproval(int _index);
		@Override
		List<? extends WorkflowStepApproval.WorkflowStepApprovalBuilder> getApproval();
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder getOrCreatePreviousWorkflowStep();
		@Override
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder getPreviousWorkflowStep();
		EventInstruction.EventInstructionBuilder getOrCreateNextEvent();
		@Override
		EventInstruction.EventInstructionBuilder getNextEvent();
		MessageInformation.MessageInformationBuilder getOrCreateMessageInformation();
		@Override
		MessageInformation.MessageInformationBuilder getMessageInformation();
		EventTimestamp.EventTimestampBuilder getOrCreateTimestamp(int _index);
		@Override
		List<? extends EventTimestamp.EventTimestampBuilder> getTimestamp();
		Identifier.IdentifierBuilder getOrCreateEventIdentifier(int _index);
		@Override
		List<? extends Identifier.IdentifierBuilder> getEventIdentifier();
		Party.PartyBuilder getOrCreateParty(int _index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int _index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		Lineage.LineageBuilder getOrCreateLineage();
		@Override
		Lineage.LineageBuilder getLineage();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation();
		@Override
		CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation();
		WorkflowState.WorkflowStateBuilder getOrCreateWorkflowState();
		@Override
		WorkflowState.WorkflowStateBuilder getWorkflowState();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		WorkflowStep.WorkflowStepBuilder setBusinessEvent(BusinessEvent businessEvent);
		WorkflowStep.WorkflowStepBuilder setCounterpartyPositionBusinessEvent(CounterpartyPositionBusinessEvent counterpartyPositionBusinessEvent);
		WorkflowStep.WorkflowStepBuilder setProposedEvent(EventInstruction proposedEvent);
		WorkflowStep.WorkflowStepBuilder setRejected(Boolean rejected);
		WorkflowStep.WorkflowStepBuilder addApproval(WorkflowStepApproval approval);
		WorkflowStep.WorkflowStepBuilder addApproval(WorkflowStepApproval approval, int _idx);
		WorkflowStep.WorkflowStepBuilder addApproval(List<? extends WorkflowStepApproval> approval);
		WorkflowStep.WorkflowStepBuilder setApproval(List<? extends WorkflowStepApproval> approval);
		WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep previousWorkflowStep);
		WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStepValue(WorkflowStep previousWorkflowStep);
		WorkflowStep.WorkflowStepBuilder setNextEvent(EventInstruction nextEvent);
		WorkflowStep.WorkflowStepBuilder setMessageInformation(MessageInformation messageInformation);
		WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp);
		WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp, int _idx);
		WorkflowStep.WorkflowStepBuilder addTimestamp(List<? extends EventTimestamp> timestamp);
		WorkflowStep.WorkflowStepBuilder setTimestamp(List<? extends EventTimestamp> timestamp);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier, int _idx);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(List<? extends Identifier> eventIdentifier);
		WorkflowStep.WorkflowStepBuilder setEventIdentifier(List<? extends Identifier> eventIdentifier);
		WorkflowStep.WorkflowStepBuilder setAction(ActionEnum action);
		WorkflowStep.WorkflowStepBuilder addParty(Party party);
		WorkflowStep.WorkflowStepBuilder addParty(Party party, int _idx);
		WorkflowStep.WorkflowStepBuilder addParty(List<? extends Party> party);
		WorkflowStep.WorkflowStepBuilder setParty(List<? extends Party> party);
		WorkflowStep.WorkflowStepBuilder addAccount(Account account);
		WorkflowStep.WorkflowStepBuilder addAccount(Account account, int _idx);
		WorkflowStep.WorkflowStepBuilder addAccount(List<? extends Account> account);
		WorkflowStep.WorkflowStepBuilder setAccount(List<? extends Account> account);
		WorkflowStep.WorkflowStepBuilder setLineage(Lineage lineage);
		WorkflowStep.WorkflowStepBuilder setCreditLimitInformation(CreditLimitInformation creditLimitInformation);
		WorkflowStep.WorkflowStepBuilder setWorkflowState(WorkflowState workflowState);
		WorkflowStep.WorkflowStepBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("businessEvent"), processor, BusinessEvent.BusinessEventBuilder.class, getBusinessEvent());
			processRosetta(path.newSubPath("counterpartyPositionBusinessEvent"), processor, CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder.class, getCounterpartyPositionBusinessEvent());
			processRosetta(path.newSubPath("proposedEvent"), processor, EventInstruction.EventInstructionBuilder.class, getProposedEvent());
			processor.processBasic(path.newSubPath("rejected"), Boolean.class, getRejected(), this);
			processRosetta(path.newSubPath("approval"), processor, WorkflowStepApproval.WorkflowStepApprovalBuilder.class, getApproval());
			processRosetta(path.newSubPath("previousWorkflowStep"), processor, ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder.class, getPreviousWorkflowStep());
			processRosetta(path.newSubPath("nextEvent"), processor, EventInstruction.EventInstructionBuilder.class, getNextEvent());
			processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.MessageInformationBuilder.class, getMessageInformation());
			processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.EventTimestampBuilder.class, getTimestamp());
			processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.IdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("action"), ActionEnum.class, getAction(), this);
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("lineage"), processor, Lineage.LineageBuilder.class, getLineage());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("workflowState"), processor, WorkflowState.WorkflowStateBuilder.class, getWorkflowState());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		WorkflowStep.WorkflowStepBuilder prune();
	}

	/*********************** Immutable Implementation of WorkflowStep  ***********************/
	class WorkflowStepImpl implements WorkflowStep {
		private final BusinessEvent businessEvent;
		private final CounterpartyPositionBusinessEvent counterpartyPositionBusinessEvent;
		private final EventInstruction proposedEvent;
		private final Boolean rejected;
		private final List<? extends WorkflowStepApproval> approval;
		private final ReferenceWithMetaWorkflowStep previousWorkflowStep;
		private final EventInstruction nextEvent;
		private final MessageInformation messageInformation;
		private final List<? extends EventTimestamp> timestamp;
		private final List<? extends Identifier> eventIdentifier;
		private final ActionEnum action;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		private final Lineage lineage;
		private final CreditLimitInformation creditLimitInformation;
		private final WorkflowState workflowState;
		private final MetaFields meta;
		
		protected WorkflowStepImpl(WorkflowStep.WorkflowStepBuilder builder) {
			this.businessEvent = ofNullable(builder.getBusinessEvent()).map(f->f.build()).orElse(null);
			this.counterpartyPositionBusinessEvent = ofNullable(builder.getCounterpartyPositionBusinessEvent()).map(f->f.build()).orElse(null);
			this.proposedEvent = ofNullable(builder.getProposedEvent()).map(f->f.build()).orElse(null);
			this.rejected = builder.getRejected();
			this.approval = ofNullable(builder.getApproval()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.previousWorkflowStep = ofNullable(builder.getPreviousWorkflowStep()).map(f->f.build()).orElse(null);
			this.nextEvent = ofNullable(builder.getNextEvent()).map(f->f.build()).orElse(null);
			this.messageInformation = ofNullable(builder.getMessageInformation()).map(f->f.build()).orElse(null);
			this.timestamp = ofNullable(builder.getTimestamp()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.action = builder.getAction();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lineage = ofNullable(builder.getLineage()).map(f->f.build()).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).map(f->f.build()).orElse(null);
			this.workflowState = ofNullable(builder.getWorkflowState()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessEvent")
		@RuneAttribute("businessEvent")
		public BusinessEvent getBusinessEvent() {
			return businessEvent;
		}
		
		@Override
		@RosettaAttribute("counterpartyPositionBusinessEvent")
		@RuneAttribute("counterpartyPositionBusinessEvent")
		public CounterpartyPositionBusinessEvent getCounterpartyPositionBusinessEvent() {
			return counterpartyPositionBusinessEvent;
		}
		
		@Override
		@RosettaAttribute("proposedEvent")
		@RuneAttribute("proposedEvent")
		public EventInstruction getProposedEvent() {
			return proposedEvent;
		}
		
		@Override
		@RosettaAttribute("rejected")
		@RuneAttribute("rejected")
		public Boolean getRejected() {
			return rejected;
		}
		
		@Override
		@RosettaAttribute("approval")
		@RuneAttribute("approval")
		public List<? extends WorkflowStepApproval> getApproval() {
			return approval;
		}
		
		@Override
		@RosettaAttribute("previousWorkflowStep")
		@RuneAttribute("previousWorkflowStep")
		public ReferenceWithMetaWorkflowStep getPreviousWorkflowStep() {
			return previousWorkflowStep;
		}
		
		@Override
		@RosettaAttribute("nextEvent")
		@RuneAttribute("nextEvent")
		public EventInstruction getNextEvent() {
			return nextEvent;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public MessageInformation getMessageInformation() {
			return messageInformation;
		}
		
		@Override
		@RosettaAttribute("timestamp")
		@RuneAttribute("timestamp")
		public List<? extends EventTimestamp> getTimestamp() {
			return timestamp;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@RuneAttribute("eventIdentifier")
		public List<? extends Identifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("action")
		@RuneAttribute("action")
		public ActionEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("account")
		@RuneAttribute("account")
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		@RosettaAttribute("lineage")
		@RuneAttribute("lineage")
		public Lineage getLineage() {
			return lineage;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		@RuneAttribute("creditLimitInformation")
		public CreditLimitInformation getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		@RosettaAttribute("workflowState")
		@RuneAttribute("workflowState")
		public WorkflowState getWorkflowState() {
			return workflowState;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public WorkflowStep build() {
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder toBuilder() {
			WorkflowStep.WorkflowStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WorkflowStep.WorkflowStepBuilder builder) {
			ofNullable(getBusinessEvent()).ifPresent(builder::setBusinessEvent);
			ofNullable(getCounterpartyPositionBusinessEvent()).ifPresent(builder::setCounterpartyPositionBusinessEvent);
			ofNullable(getProposedEvent()).ifPresent(builder::setProposedEvent);
			ofNullable(getRejected()).ifPresent(builder::setRejected);
			ofNullable(getApproval()).ifPresent(builder::setApproval);
			ofNullable(getPreviousWorkflowStep()).ifPresent(builder::setPreviousWorkflowStep);
			ofNullable(getNextEvent()).ifPresent(builder::setNextEvent);
			ofNullable(getMessageInformation()).ifPresent(builder::setMessageInformation);
			ofNullable(getTimestamp()).ifPresent(builder::setTimestamp);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getAction()).ifPresent(builder::setAction);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getLineage()).ifPresent(builder::setLineage);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getWorkflowState()).ifPresent(builder::setWorkflowState);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStep _that = getType().cast(o);
		
			if (!Objects.equals(businessEvent, _that.getBusinessEvent())) return false;
			if (!Objects.equals(counterpartyPositionBusinessEvent, _that.getCounterpartyPositionBusinessEvent())) return false;
			if (!Objects.equals(proposedEvent, _that.getProposedEvent())) return false;
			if (!Objects.equals(rejected, _that.getRejected())) return false;
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			if (!Objects.equals(previousWorkflowStep, _that.getPreviousWorkflowStep())) return false;
			if (!Objects.equals(nextEvent, _that.getNextEvent())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!ListEquals.listEquals(timestamp, _that.getTimestamp())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(workflowState, _that.getWorkflowState())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessEvent != null ? businessEvent.hashCode() : 0);
			_result = 31 * _result + (counterpartyPositionBusinessEvent != null ? counterpartyPositionBusinessEvent.hashCode() : 0);
			_result = 31 * _result + (proposedEvent != null ? proposedEvent.hashCode() : 0);
			_result = 31 * _result + (rejected != null ? rejected.hashCode() : 0);
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			_result = 31 * _result + (previousWorkflowStep != null ? previousWorkflowStep.hashCode() : 0);
			_result = 31 * _result + (nextEvent != null ? nextEvent.hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (workflowState != null ? workflowState.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStep {" +
				"businessEvent=" + this.businessEvent + ", " +
				"counterpartyPositionBusinessEvent=" + this.counterpartyPositionBusinessEvent + ", " +
				"proposedEvent=" + this.proposedEvent + ", " +
				"rejected=" + this.rejected + ", " +
				"approval=" + this.approval + ", " +
				"previousWorkflowStep=" + this.previousWorkflowStep + ", " +
				"nextEvent=" + this.nextEvent + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"timestamp=" + this.timestamp + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"action=" + this.action + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"lineage=" + this.lineage + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"workflowState=" + this.workflowState + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of WorkflowStep  ***********************/
	class WorkflowStepBuilderImpl implements WorkflowStep.WorkflowStepBuilder {
	
		protected BusinessEvent.BusinessEventBuilder businessEvent;
		protected CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder counterpartyPositionBusinessEvent;
		protected EventInstruction.EventInstructionBuilder proposedEvent;
		protected Boolean rejected;
		protected List<WorkflowStepApproval.WorkflowStepApprovalBuilder> approval = new ArrayList<>();
		protected ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder previousWorkflowStep;
		protected EventInstruction.EventInstructionBuilder nextEvent;
		protected MessageInformation.MessageInformationBuilder messageInformation;
		protected List<EventTimestamp.EventTimestampBuilder> timestamp = new ArrayList<>();
		protected List<Identifier.IdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected ActionEnum action;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected Lineage.LineageBuilder lineage;
		protected CreditLimitInformation.CreditLimitInformationBuilder creditLimitInformation;
		protected WorkflowState.WorkflowStateBuilder workflowState;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("businessEvent")
		@RuneAttribute("businessEvent")
		public BusinessEvent.BusinessEventBuilder getBusinessEvent() {
			return businessEvent;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder getOrCreateBusinessEvent() {
			BusinessEvent.BusinessEventBuilder result;
			if (businessEvent!=null) {
				result = businessEvent;
			}
			else {
				result = businessEvent = BusinessEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterpartyPositionBusinessEvent")
		@RuneAttribute("counterpartyPositionBusinessEvent")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder getCounterpartyPositionBusinessEvent() {
			return counterpartyPositionBusinessEvent;
		}
		
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder getOrCreateCounterpartyPositionBusinessEvent() {
			CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder result;
			if (counterpartyPositionBusinessEvent!=null) {
				result = counterpartyPositionBusinessEvent;
			}
			else {
				result = counterpartyPositionBusinessEvent = CounterpartyPositionBusinessEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proposedEvent")
		@RuneAttribute("proposedEvent")
		public EventInstruction.EventInstructionBuilder getProposedEvent() {
			return proposedEvent;
		}
		
		@Override
		public EventInstruction.EventInstructionBuilder getOrCreateProposedEvent() {
			EventInstruction.EventInstructionBuilder result;
			if (proposedEvent!=null) {
				result = proposedEvent;
			}
			else {
				result = proposedEvent = EventInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rejected")
		@RuneAttribute("rejected")
		public Boolean getRejected() {
			return rejected;
		}
		
		@Override
		@RosettaAttribute("approval")
		@RuneAttribute("approval")
		public List<? extends WorkflowStepApproval.WorkflowStepApprovalBuilder> getApproval() {
			return approval;
		}
		
		@Override
		public WorkflowStepApproval.WorkflowStepApprovalBuilder getOrCreateApproval(int _index) {
		
			if (approval==null) {
				this.approval = new ArrayList<>();
			}
			WorkflowStepApproval.WorkflowStepApprovalBuilder result;
			return getIndex(approval, _index, () -> {
						WorkflowStepApproval.WorkflowStepApprovalBuilder newApproval = WorkflowStepApproval.builder();
						return newApproval;
					});
		}
		
		@Override
		@RosettaAttribute("previousWorkflowStep")
		@RuneAttribute("previousWorkflowStep")
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder getPreviousWorkflowStep() {
			return previousWorkflowStep;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder getOrCreatePreviousWorkflowStep() {
			ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder result;
			if (previousWorkflowStep!=null) {
				result = previousWorkflowStep;
			}
			else {
				result = previousWorkflowStep = ReferenceWithMetaWorkflowStep.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nextEvent")
		@RuneAttribute("nextEvent")
		public EventInstruction.EventInstructionBuilder getNextEvent() {
			return nextEvent;
		}
		
		@Override
		public EventInstruction.EventInstructionBuilder getOrCreateNextEvent() {
			EventInstruction.EventInstructionBuilder result;
			if (nextEvent!=null) {
				result = nextEvent;
			}
			else {
				result = nextEvent = EventInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public MessageInformation.MessageInformationBuilder getMessageInformation() {
			return messageInformation;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder getOrCreateMessageInformation() {
			MessageInformation.MessageInformationBuilder result;
			if (messageInformation!=null) {
				result = messageInformation;
			}
			else {
				result = messageInformation = MessageInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timestamp")
		@RuneAttribute("timestamp")
		public List<? extends EventTimestamp.EventTimestampBuilder> getTimestamp() {
			return timestamp;
		}
		
		@Override
		public EventTimestamp.EventTimestampBuilder getOrCreateTimestamp(int _index) {
		
			if (timestamp==null) {
				this.timestamp = new ArrayList<>();
			}
			EventTimestamp.EventTimestampBuilder result;
			return getIndex(timestamp, _index, () -> {
						EventTimestamp.EventTimestampBuilder newTimestamp = EventTimestamp.builder();
						return newTimestamp;
					});
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@RuneAttribute("eventIdentifier")
		public List<? extends Identifier.IdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateEventIdentifier(int _index) {
		
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(eventIdentifier, _index, () -> {
						Identifier.IdentifierBuilder newEventIdentifier = Identifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("action")
		@RuneAttribute("action")
		public ActionEnum getAction() {
			return action;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("account")
		@RuneAttribute("account")
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount(int _index) {
		
			if (account==null) {
				this.account = new ArrayList<>();
			}
			Account.AccountBuilder result;
			return getIndex(account, _index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@Override
		@RosettaAttribute("lineage")
		@RuneAttribute("lineage")
		public Lineage.LineageBuilder getLineage() {
			return lineage;
		}
		
		@Override
		public Lineage.LineageBuilder getOrCreateLineage() {
			Lineage.LineageBuilder result;
			if (lineage!=null) {
				result = lineage;
			}
			else {
				result = lineage = Lineage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		@RuneAttribute("creditLimitInformation")
		public CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation() {
			CreditLimitInformation.CreditLimitInformationBuilder result;
			if (creditLimitInformation!=null) {
				result = creditLimitInformation;
			}
			else {
				result = creditLimitInformation = CreditLimitInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("workflowState")
		@RuneAttribute("workflowState")
		public WorkflowState.WorkflowStateBuilder getWorkflowState() {
			return workflowState;
		}
		
		@Override
		public WorkflowState.WorkflowStateBuilder getOrCreateWorkflowState() {
			WorkflowState.WorkflowStateBuilder result;
			if (workflowState!=null) {
				result = workflowState;
			}
			else {
				result = workflowState = WorkflowState.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessEvent")
		@RuneAttribute("businessEvent")
		public WorkflowStep.WorkflowStepBuilder setBusinessEvent(BusinessEvent _businessEvent) {
			this.businessEvent = _businessEvent == null ? null : _businessEvent.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("counterpartyPositionBusinessEvent")
		@RuneAttribute("counterpartyPositionBusinessEvent")
		public WorkflowStep.WorkflowStepBuilder setCounterpartyPositionBusinessEvent(CounterpartyPositionBusinessEvent _counterpartyPositionBusinessEvent) {
			this.counterpartyPositionBusinessEvent = _counterpartyPositionBusinessEvent == null ? null : _counterpartyPositionBusinessEvent.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("proposedEvent")
		@RuneAttribute("proposedEvent")
		public WorkflowStep.WorkflowStepBuilder setProposedEvent(EventInstruction _proposedEvent) {
			this.proposedEvent = _proposedEvent == null ? null : _proposedEvent.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("rejected")
		@RuneAttribute("rejected")
		public WorkflowStep.WorkflowStepBuilder setRejected(Boolean _rejected) {
			this.rejected = _rejected == null ? null : _rejected;
			return this;
		}
		
		@Override
		@RosettaAttribute("approval")
		@RuneAttribute("approval")
		public WorkflowStep.WorkflowStepBuilder addApproval(WorkflowStepApproval _approval) {
			if (_approval != null) {
				this.approval.add(_approval.toBuilder());
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addApproval(WorkflowStepApproval _approval, int _idx) {
			getIndex(this.approval, _idx, () -> _approval.toBuilder());
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder addApproval(List<? extends WorkflowStepApproval> approvals) {
			if (approvals != null) {
				for (final WorkflowStepApproval toAdd : approvals) {
					this.approval.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("approval")
		public WorkflowStep.WorkflowStepBuilder setApproval(List<? extends WorkflowStepApproval> approvals) {
			if (approvals == null) {
				this.approval = new ArrayList<>();
			} else {
				this.approval = approvals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("previousWorkflowStep")
		@RuneAttribute("previousWorkflowStep")
		public WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep _previousWorkflowStep) {
			this.previousWorkflowStep = _previousWorkflowStep == null ? null : _previousWorkflowStep.toBuilder();
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStepValue(WorkflowStep _previousWorkflowStep) {
			this.getOrCreatePreviousWorkflowStep().setValue(_previousWorkflowStep);
			return this;
		}
		
		@Override
		@RosettaAttribute("nextEvent")
		@RuneAttribute("nextEvent")
		public WorkflowStep.WorkflowStepBuilder setNextEvent(EventInstruction _nextEvent) {
			this.nextEvent = _nextEvent == null ? null : _nextEvent.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public WorkflowStep.WorkflowStepBuilder setMessageInformation(MessageInformation _messageInformation) {
			this.messageInformation = _messageInformation == null ? null : _messageInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("timestamp")
		@RuneAttribute("timestamp")
		public WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp _timestamp) {
			if (_timestamp != null) {
				this.timestamp.add(_timestamp.toBuilder());
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp _timestamp, int _idx) {
			getIndex(this.timestamp, _idx, () -> _timestamp.toBuilder());
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder addTimestamp(List<? extends EventTimestamp> timestamps) {
			if (timestamps != null) {
				for (final EventTimestamp toAdd : timestamps) {
					this.timestamp.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("timestamp")
		public WorkflowStep.WorkflowStepBuilder setTimestamp(List<? extends EventTimestamp> timestamps) {
			if (timestamps == null) {
				this.timestamp = new ArrayList<>();
			} else {
				this.timestamp = timestamps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@RuneAttribute("eventIdentifier")
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier _eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final Identifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("eventIdentifier")
		public WorkflowStep.WorkflowStepBuilder setEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("action")
		@RuneAttribute("action")
		public WorkflowStep.WorkflowStepBuilder setAction(ActionEnum _action) {
			this.action = _action == null ? null : _action;
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public WorkflowStep.WorkflowStepBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addParty(Party _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public WorkflowStep.WorkflowStepBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("account")
		@RuneAttribute("account")
		public WorkflowStep.WorkflowStepBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addAccount(Account _account, int _idx) {
			getIndex(this.account, _idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (final Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("account")
		public WorkflowStep.WorkflowStepBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("lineage")
		@RuneAttribute("lineage")
		public WorkflowStep.WorkflowStepBuilder setLineage(Lineage _lineage) {
			this.lineage = _lineage == null ? null : _lineage.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("creditLimitInformation")
		@RuneAttribute("creditLimitInformation")
		public WorkflowStep.WorkflowStepBuilder setCreditLimitInformation(CreditLimitInformation _creditLimitInformation) {
			this.creditLimitInformation = _creditLimitInformation == null ? null : _creditLimitInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("workflowState")
		@RuneAttribute("workflowState")
		public WorkflowStep.WorkflowStepBuilder setWorkflowState(WorkflowState _workflowState) {
			this.workflowState = _workflowState == null ? null : _workflowState.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public WorkflowStep.WorkflowStepBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public WorkflowStep build() {
			return new WorkflowStep.WorkflowStepImpl(this);
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStep.WorkflowStepBuilder prune() {
			if (businessEvent!=null && !businessEvent.prune().hasData()) businessEvent = null;
			if (counterpartyPositionBusinessEvent!=null && !counterpartyPositionBusinessEvent.prune().hasData()) counterpartyPositionBusinessEvent = null;
			if (proposedEvent!=null && !proposedEvent.prune().hasData()) proposedEvent = null;
			approval = approval.stream().filter(b->b!=null).<WorkflowStepApproval.WorkflowStepApprovalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (previousWorkflowStep!=null && !previousWorkflowStep.prune().hasData()) previousWorkflowStep = null;
			if (nextEvent!=null && !nextEvent.prune().hasData()) nextEvent = null;
			if (messageInformation!=null && !messageInformation.prune().hasData()) messageInformation = null;
			timestamp = timestamp.stream().filter(b->b!=null).<EventTimestamp.EventTimestampBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lineage!=null && !lineage.prune().hasData()) lineage = null;
			if (creditLimitInformation!=null && !creditLimitInformation.prune().hasData()) creditLimitInformation = null;
			if (workflowState!=null && !workflowState.prune().hasData()) workflowState = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessEvent()!=null && getBusinessEvent().hasData()) return true;
			if (getCounterpartyPositionBusinessEvent()!=null && getCounterpartyPositionBusinessEvent().hasData()) return true;
			if (getProposedEvent()!=null && getProposedEvent().hasData()) return true;
			if (getRejected()!=null) return true;
			if (getApproval()!=null && getApproval().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPreviousWorkflowStep()!=null && getPreviousWorkflowStep().hasData()) return true;
			if (getNextEvent()!=null && getNextEvent().hasData()) return true;
			if (getMessageInformation()!=null && getMessageInformation().hasData()) return true;
			if (getTimestamp()!=null && getTimestamp().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAction()!=null) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLineage()!=null && getLineage().hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().hasData()) return true;
			if (getWorkflowState()!=null && getWorkflowState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStep.WorkflowStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WorkflowStep.WorkflowStepBuilder o = (WorkflowStep.WorkflowStepBuilder) other;
			
			merger.mergeRosetta(getBusinessEvent(), o.getBusinessEvent(), this::setBusinessEvent);
			merger.mergeRosetta(getCounterpartyPositionBusinessEvent(), o.getCounterpartyPositionBusinessEvent(), this::setCounterpartyPositionBusinessEvent);
			merger.mergeRosetta(getProposedEvent(), o.getProposedEvent(), this::setProposedEvent);
			merger.mergeRosetta(getApproval(), o.getApproval(), this::getOrCreateApproval);
			merger.mergeRosetta(getPreviousWorkflowStep(), o.getPreviousWorkflowStep(), this::setPreviousWorkflowStep);
			merger.mergeRosetta(getNextEvent(), o.getNextEvent(), this::setNextEvent);
			merger.mergeRosetta(getMessageInformation(), o.getMessageInformation(), this::setMessageInformation);
			merger.mergeRosetta(getTimestamp(), o.getTimestamp(), this::getOrCreateTimestamp);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getLineage(), o.getLineage(), this::setLineage);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::setCreditLimitInformation);
			merger.mergeRosetta(getWorkflowState(), o.getWorkflowState(), this::setWorkflowState);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getRejected(), o.getRejected(), this::setRejected);
			merger.mergeBasic(getAction(), o.getAction(), this::setAction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStep _that = getType().cast(o);
		
			if (!Objects.equals(businessEvent, _that.getBusinessEvent())) return false;
			if (!Objects.equals(counterpartyPositionBusinessEvent, _that.getCounterpartyPositionBusinessEvent())) return false;
			if (!Objects.equals(proposedEvent, _that.getProposedEvent())) return false;
			if (!Objects.equals(rejected, _that.getRejected())) return false;
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			if (!Objects.equals(previousWorkflowStep, _that.getPreviousWorkflowStep())) return false;
			if (!Objects.equals(nextEvent, _that.getNextEvent())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!ListEquals.listEquals(timestamp, _that.getTimestamp())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!Objects.equals(workflowState, _that.getWorkflowState())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessEvent != null ? businessEvent.hashCode() : 0);
			_result = 31 * _result + (counterpartyPositionBusinessEvent != null ? counterpartyPositionBusinessEvent.hashCode() : 0);
			_result = 31 * _result + (proposedEvent != null ? proposedEvent.hashCode() : 0);
			_result = 31 * _result + (rejected != null ? rejected.hashCode() : 0);
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			_result = 31 * _result + (previousWorkflowStep != null ? previousWorkflowStep.hashCode() : 0);
			_result = 31 * _result + (nextEvent != null ? nextEvent.hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (workflowState != null ? workflowState.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepBuilder {" +
				"businessEvent=" + this.businessEvent + ", " +
				"counterpartyPositionBusinessEvent=" + this.counterpartyPositionBusinessEvent + ", " +
				"proposedEvent=" + this.proposedEvent + ", " +
				"rejected=" + this.rejected + ", " +
				"approval=" + this.approval + ", " +
				"previousWorkflowStep=" + this.previousWorkflowStep + ", " +
				"nextEvent=" + this.nextEvent + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"timestamp=" + this.timestamp + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"action=" + this.action + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"lineage=" + this.lineage + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"workflowState=" + this.workflowState + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
