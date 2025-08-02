package cdm.event.position;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.event.position.AvailableInventory;
import cdm.event.position.AvailableInventory.AvailableInventoryBuilder;
import cdm.event.position.AvailableInventory.AvailableInventoryBuilderImpl;
import cdm.event.position.AvailableInventory.AvailableInventoryImpl;
import cdm.event.position.AvailableInventoryRecord;
import cdm.event.position.AvailableInventoryRecord.AvailableInventoryRecordBuilder;
import cdm.event.position.AvailableInventoryTypeEnum;
import cdm.event.position.meta.AvailableInventoryMeta;
import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.MessageInformation.MessageInformationBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
 * @version 6.0.0
 */
@RosettaDataType(value="AvailableInventory", builder=AvailableInventory.AvailableInventoryBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AvailableInventory", model="Just another Rosetta model", builder=AvailableInventory.AvailableInventoryBuilderImpl.class, version="6.0.0")
public interface AvailableInventory extends RosettaModelObject {

	AvailableInventoryMeta metaData = new AvailableInventoryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the purpose of this inventory.
	 */
	AvailableInventoryTypeEnum getAvailableInventoryType();
	/**
	 * Allows details related to the availability messaging use case to be defined
	 */
	MessageInformation getMessageInformation();
	/**
	 * Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
	 */
	List<? extends Party> getParty();
	/**
	 * Defines the role(s) that party(ies) may have in relation to the inventory.
	 */
	List<? extends PartyRole> getPartyRole();
	/**
	 * An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
	 */
	List<? extends AvailableInventoryRecord> getAvailableInventoryRecord();

	/*********************** Build Methods  ***********************/
	AvailableInventory build();
	
	AvailableInventory.AvailableInventoryBuilder toBuilder();
	
	static AvailableInventory.AvailableInventoryBuilder builder() {
		return new AvailableInventory.AvailableInventoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AvailableInventory> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AvailableInventory> getType() {
		return AvailableInventory.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("availableInventoryType"), AvailableInventoryTypeEnum.class, getAvailableInventoryType(), this);
		processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.class, getMessageInformation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("availableInventoryRecord"), processor, AvailableInventoryRecord.class, getAvailableInventoryRecord());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AvailableInventoryBuilder extends AvailableInventory, RosettaModelObjectBuilder {
		MessageInformation.MessageInformationBuilder getOrCreateMessageInformation();
		@Override
		MessageInformation.MessageInformationBuilder getMessageInformation();
		Party.PartyBuilder getOrCreateParty(int _index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index);
		@Override
		List<? extends PartyRole.PartyRoleBuilder> getPartyRole();
		AvailableInventoryRecord.AvailableInventoryRecordBuilder getOrCreateAvailableInventoryRecord(int _index);
		@Override
		List<? extends AvailableInventoryRecord.AvailableInventoryRecordBuilder> getAvailableInventoryRecord();
		AvailableInventory.AvailableInventoryBuilder setAvailableInventoryType(AvailableInventoryTypeEnum availableInventoryType);
		AvailableInventory.AvailableInventoryBuilder setMessageInformation(MessageInformation messageInformation);
		AvailableInventory.AvailableInventoryBuilder addParty(Party party);
		AvailableInventory.AvailableInventoryBuilder addParty(Party party, int _idx);
		AvailableInventory.AvailableInventoryBuilder addParty(List<? extends Party> party);
		AvailableInventory.AvailableInventoryBuilder setParty(List<? extends Party> party);
		AvailableInventory.AvailableInventoryBuilder addPartyRole(PartyRole partyRole);
		AvailableInventory.AvailableInventoryBuilder addPartyRole(PartyRole partyRole, int _idx);
		AvailableInventory.AvailableInventoryBuilder addPartyRole(List<? extends PartyRole> partyRole);
		AvailableInventory.AvailableInventoryBuilder setPartyRole(List<? extends PartyRole> partyRole);
		AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(AvailableInventoryRecord availableInventoryRecord);
		AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(AvailableInventoryRecord availableInventoryRecord, int _idx);
		AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecord);
		AvailableInventory.AvailableInventoryBuilder setAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecord);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("availableInventoryType"), AvailableInventoryTypeEnum.class, getAvailableInventoryType(), this);
			processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.MessageInformationBuilder.class, getMessageInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("availableInventoryRecord"), processor, AvailableInventoryRecord.AvailableInventoryRecordBuilder.class, getAvailableInventoryRecord());
		}
		

		AvailableInventory.AvailableInventoryBuilder prune();
	}

	/*********************** Immutable Implementation of AvailableInventory  ***********************/
	class AvailableInventoryImpl implements AvailableInventory {
		private final AvailableInventoryTypeEnum availableInventoryType;
		private final MessageInformation messageInformation;
		private final List<? extends Party> party;
		private final List<? extends PartyRole> partyRole;
		private final List<? extends AvailableInventoryRecord> availableInventoryRecord;
		
		protected AvailableInventoryImpl(AvailableInventory.AvailableInventoryBuilder builder) {
			this.availableInventoryType = builder.getAvailableInventoryType();
			this.messageInformation = ofNullable(builder.getMessageInformation()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRole = ofNullable(builder.getPartyRole()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.availableInventoryRecord = ofNullable(builder.getAvailableInventoryRecord()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("availableInventoryType")
		@RuneAttribute("availableInventoryType")
		public AvailableInventoryTypeEnum getAvailableInventoryType() {
			return availableInventoryType;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public MessageInformation getMessageInformation() {
			return messageInformation;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public List<? extends PartyRole> getPartyRole() {
			return partyRole;
		}
		
		@Override
		@RosettaAttribute("availableInventoryRecord")
		@RuneAttribute("availableInventoryRecord")
		public List<? extends AvailableInventoryRecord> getAvailableInventoryRecord() {
			return availableInventoryRecord;
		}
		
		@Override
		public AvailableInventory build() {
			return this;
		}
		
		@Override
		public AvailableInventory.AvailableInventoryBuilder toBuilder() {
			AvailableInventory.AvailableInventoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AvailableInventory.AvailableInventoryBuilder builder) {
			ofNullable(getAvailableInventoryType()).ifPresent(builder::setAvailableInventoryType);
			ofNullable(getMessageInformation()).ifPresent(builder::setMessageInformation);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getPartyRole()).ifPresent(builder::setPartyRole);
			ofNullable(getAvailableInventoryRecord()).ifPresent(builder::setAvailableInventoryRecord);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AvailableInventory _that = getType().cast(o);
		
			if (!Objects.equals(availableInventoryType, _that.getAvailableInventoryType())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!ListEquals.listEquals(availableInventoryRecord, _that.getAvailableInventoryRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (availableInventoryType != null ? availableInventoryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (availableInventoryRecord != null ? availableInventoryRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AvailableInventory {" +
				"availableInventoryType=" + this.availableInventoryType + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"party=" + this.party + ", " +
				"partyRole=" + this.partyRole + ", " +
				"availableInventoryRecord=" + this.availableInventoryRecord +
			'}';
		}
	}

	/*********************** Builder Implementation of AvailableInventory  ***********************/
	class AvailableInventoryBuilderImpl implements AvailableInventory.AvailableInventoryBuilder {
	
		protected AvailableInventoryTypeEnum availableInventoryType;
		protected MessageInformation.MessageInformationBuilder messageInformation;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRole = new ArrayList<>();
		protected List<AvailableInventoryRecord.AvailableInventoryRecordBuilder> availableInventoryRecord = new ArrayList<>();
		
		@Override
		@RosettaAttribute("availableInventoryType")
		@RuneAttribute("availableInventoryType")
		public AvailableInventoryTypeEnum getAvailableInventoryType() {
			return availableInventoryType;
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
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public List<? extends PartyRole.PartyRoleBuilder> getPartyRole() {
			return partyRole;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index) {
		
			if (partyRole==null) {
				this.partyRole = new ArrayList<>();
			}
			PartyRole.PartyRoleBuilder result;
			return getIndex(partyRole, _index, () -> {
						PartyRole.PartyRoleBuilder newPartyRole = PartyRole.builder();
						return newPartyRole;
					});
		}
		
		@Override
		@RosettaAttribute("availableInventoryRecord")
		@RuneAttribute("availableInventoryRecord")
		public List<? extends AvailableInventoryRecord.AvailableInventoryRecordBuilder> getAvailableInventoryRecord() {
			return availableInventoryRecord;
		}
		
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder getOrCreateAvailableInventoryRecord(int _index) {
		
			if (availableInventoryRecord==null) {
				this.availableInventoryRecord = new ArrayList<>();
			}
			AvailableInventoryRecord.AvailableInventoryRecordBuilder result;
			return getIndex(availableInventoryRecord, _index, () -> {
						AvailableInventoryRecord.AvailableInventoryRecordBuilder newAvailableInventoryRecord = AvailableInventoryRecord.builder();
						return newAvailableInventoryRecord;
					});
		}
		
		@Override
		@RosettaAttribute("availableInventoryType")
		@RuneAttribute("availableInventoryType")
		public AvailableInventory.AvailableInventoryBuilder setAvailableInventoryType(AvailableInventoryTypeEnum _availableInventoryType) {
			this.availableInventoryType = _availableInventoryType == null ? null : _availableInventoryType;
			return this;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public AvailableInventory.AvailableInventoryBuilder setMessageInformation(MessageInformation _messageInformation) {
			this.messageInformation = _messageInformation == null ? null : _messageInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public AvailableInventory.AvailableInventoryBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public AvailableInventory.AvailableInventoryBuilder addParty(Party _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override 
		public AvailableInventory.AvailableInventoryBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public AvailableInventory.AvailableInventoryBuilder setParty(List<? extends Party> partys) {
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
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public AvailableInventory.AvailableInventoryBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public AvailableInventory.AvailableInventoryBuilder addPartyRole(PartyRole _partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override 
		public AvailableInventory.AvailableInventoryBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRole")
		public AvailableInventory.AvailableInventoryBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles == null) {
				this.partyRole = new ArrayList<>();
			} else {
				this.partyRole = partyRoles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("availableInventoryRecord")
		@RuneAttribute("availableInventoryRecord")
		public AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(AvailableInventoryRecord _availableInventoryRecord) {
			if (_availableInventoryRecord != null) {
				this.availableInventoryRecord.add(_availableInventoryRecord.toBuilder());
			}
			return this;
		}
		
		@Override
		public AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(AvailableInventoryRecord _availableInventoryRecord, int _idx) {
			getIndex(this.availableInventoryRecord, _idx, () -> _availableInventoryRecord.toBuilder());
			return this;
		}
		
		@Override 
		public AvailableInventory.AvailableInventoryBuilder addAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecords) {
			if (availableInventoryRecords != null) {
				for (final AvailableInventoryRecord toAdd : availableInventoryRecords) {
					this.availableInventoryRecord.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("availableInventoryRecord")
		public AvailableInventory.AvailableInventoryBuilder setAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecords) {
			if (availableInventoryRecords == null) {
				this.availableInventoryRecord = new ArrayList<>();
			} else {
				this.availableInventoryRecord = availableInventoryRecords.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AvailableInventory build() {
			return new AvailableInventory.AvailableInventoryImpl(this);
		}
		
		@Override
		public AvailableInventory.AvailableInventoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AvailableInventory.AvailableInventoryBuilder prune() {
			if (messageInformation!=null && !messageInformation.prune().hasData()) messageInformation = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRole = partyRole.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			availableInventoryRecord = availableInventoryRecord.stream().filter(b->b!=null).<AvailableInventoryRecord.AvailableInventoryRecordBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAvailableInventoryType()!=null) return true;
			if (getMessageInformation()!=null && getMessageInformation().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRole()!=null && getPartyRole().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAvailableInventoryRecord()!=null && getAvailableInventoryRecord().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AvailableInventory.AvailableInventoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AvailableInventory.AvailableInventoryBuilder o = (AvailableInventory.AvailableInventoryBuilder) other;
			
			merger.mergeRosetta(getMessageInformation(), o.getMessageInformation(), this::setMessageInformation);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getPartyRole(), o.getPartyRole(), this::getOrCreatePartyRole);
			merger.mergeRosetta(getAvailableInventoryRecord(), o.getAvailableInventoryRecord(), this::getOrCreateAvailableInventoryRecord);
			
			merger.mergeBasic(getAvailableInventoryType(), o.getAvailableInventoryType(), this::setAvailableInventoryType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AvailableInventory _that = getType().cast(o);
		
			if (!Objects.equals(availableInventoryType, _that.getAvailableInventoryType())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!ListEquals.listEquals(availableInventoryRecord, _that.getAvailableInventoryRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (availableInventoryType != null ? availableInventoryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (availableInventoryRecord != null ? availableInventoryRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AvailableInventoryBuilder {" +
				"availableInventoryType=" + this.availableInventoryType + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"party=" + this.party + ", " +
				"partyRole=" + this.partyRole + ", " +
				"availableInventoryRecord=" + this.availableInventoryRecord +
			'}';
		}
	}
}
