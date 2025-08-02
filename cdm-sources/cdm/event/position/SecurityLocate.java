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
import cdm.event.position.SecurityLocate;
import cdm.event.position.SecurityLocate.SecurityLocateBuilder;
import cdm.event.position.SecurityLocate.SecurityLocateBuilderImpl;
import cdm.event.position.SecurityLocate.SecurityLocateImpl;
import cdm.event.position.meta.SecurityLocateMeta;
import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.MessageInformation.MessageInformationBuilder;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A locate is an approval from a broker that needs to be obtained prior to effecting a short sale in an equity security. Similar to security availability, a borrower can request a single or multiple securities, but at least one must be requested.
 * @version 6.0.0
 */
@RosettaDataType(value="SecurityLocate", builder=SecurityLocate.SecurityLocateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SecurityLocate", model="Just another Rosetta model", builder=SecurityLocate.SecurityLocateBuilderImpl.class, version="6.0.0")
public interface SecurityLocate extends AvailableInventory {

	SecurityLocateMeta metaData = new SecurityLocateMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SecurityLocate build();
	
	SecurityLocate.SecurityLocateBuilder toBuilder();
	
	static SecurityLocate.SecurityLocateBuilder builder() {
		return new SecurityLocate.SecurityLocateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityLocate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityLocate> getType() {
		return SecurityLocate.class;
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
	interface SecurityLocateBuilder extends SecurityLocate, AvailableInventory.AvailableInventoryBuilder {
		@Override
		SecurityLocate.SecurityLocateBuilder setAvailableInventoryType(AvailableInventoryTypeEnum availableInventoryType);
		@Override
		SecurityLocate.SecurityLocateBuilder setMessageInformation(MessageInformation messageInformation);
		@Override
		SecurityLocate.SecurityLocateBuilder addParty(Party party);
		@Override
		SecurityLocate.SecurityLocateBuilder addParty(Party party, int _idx);
		@Override
		SecurityLocate.SecurityLocateBuilder addParty(List<? extends Party> party);
		@Override
		SecurityLocate.SecurityLocateBuilder setParty(List<? extends Party> party);
		@Override
		SecurityLocate.SecurityLocateBuilder addPartyRole(PartyRole partyRole);
		@Override
		SecurityLocate.SecurityLocateBuilder addPartyRole(PartyRole partyRole, int _idx);
		@Override
		SecurityLocate.SecurityLocateBuilder addPartyRole(List<? extends PartyRole> partyRole);
		@Override
		SecurityLocate.SecurityLocateBuilder setPartyRole(List<? extends PartyRole> partyRole);
		@Override
		SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(AvailableInventoryRecord availableInventoryRecord);
		@Override
		SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(AvailableInventoryRecord availableInventoryRecord, int _idx);
		@Override
		SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecord);
		@Override
		SecurityLocate.SecurityLocateBuilder setAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecord);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("availableInventoryType"), AvailableInventoryTypeEnum.class, getAvailableInventoryType(), this);
			processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.MessageInformationBuilder.class, getMessageInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("availableInventoryRecord"), processor, AvailableInventoryRecord.AvailableInventoryRecordBuilder.class, getAvailableInventoryRecord());
		}
		

		SecurityLocate.SecurityLocateBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityLocate  ***********************/
	class SecurityLocateImpl extends AvailableInventory.AvailableInventoryImpl implements SecurityLocate {
		
		protected SecurityLocateImpl(SecurityLocate.SecurityLocateBuilder builder) {
			super(builder);
		}
		
		@Override
		public SecurityLocate build() {
			return this;
		}
		
		@Override
		public SecurityLocate.SecurityLocateBuilder toBuilder() {
			SecurityLocate.SecurityLocateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityLocate.SecurityLocateBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLocate {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SecurityLocate  ***********************/
	class SecurityLocateBuilderImpl extends AvailableInventory.AvailableInventoryBuilderImpl implements SecurityLocate.SecurityLocateBuilder {
	
		
		@Override
		@RosettaAttribute("availableInventoryType")
		@RuneAttribute("availableInventoryType")
		public SecurityLocate.SecurityLocateBuilder setAvailableInventoryType(AvailableInventoryTypeEnum _availableInventoryType) {
			this.availableInventoryType = _availableInventoryType == null ? null : _availableInventoryType;
			return this;
		}
		
		@Override
		@RosettaAttribute("messageInformation")
		@RuneAttribute("messageInformation")
		public SecurityLocate.SecurityLocateBuilder setMessageInformation(MessageInformation _messageInformation) {
			this.messageInformation = _messageInformation == null ? null : _messageInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public SecurityLocate.SecurityLocateBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLocate.SecurityLocateBuilder addParty(Party _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override 
		public SecurityLocate.SecurityLocateBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public SecurityLocate.SecurityLocateBuilder setParty(List<? extends Party> partys) {
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
		public SecurityLocate.SecurityLocateBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLocate.SecurityLocateBuilder addPartyRole(PartyRole _partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override 
		public SecurityLocate.SecurityLocateBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRole")
		public SecurityLocate.SecurityLocateBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
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
		public SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(AvailableInventoryRecord _availableInventoryRecord) {
			if (_availableInventoryRecord != null) {
				this.availableInventoryRecord.add(_availableInventoryRecord.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(AvailableInventoryRecord _availableInventoryRecord, int _idx) {
			getIndex(this.availableInventoryRecord, _idx, () -> _availableInventoryRecord.toBuilder());
			return this;
		}
		
		@Override 
		public SecurityLocate.SecurityLocateBuilder addAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecords) {
			if (availableInventoryRecords != null) {
				for (final AvailableInventoryRecord toAdd : availableInventoryRecords) {
					this.availableInventoryRecord.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("availableInventoryRecord")
		public SecurityLocate.SecurityLocateBuilder setAvailableInventoryRecord(List<? extends AvailableInventoryRecord> availableInventoryRecords) {
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
		public SecurityLocate build() {
			return new SecurityLocate.SecurityLocateImpl(this);
		}
		
		@Override
		public SecurityLocate.SecurityLocateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLocate.SecurityLocateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLocate.SecurityLocateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SecurityLocate.SecurityLocateBuilder o = (SecurityLocate.SecurityLocateBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLocateBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
