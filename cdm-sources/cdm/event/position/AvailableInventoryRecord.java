package cdm.event.position;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Security.SecurityBuilder;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.AssignedIdentifier.AssignedIdentifierBuilder;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.event.position.AvailableInventoryRecord;
import cdm.event.position.AvailableInventoryRecord.AvailableInventoryRecordBuilder;
import cdm.event.position.AvailableInventoryRecord.AvailableInventoryRecordBuilderImpl;
import cdm.event.position.AvailableInventoryRecord.AvailableInventoryRecordImpl;
import cdm.event.position.InventoryRecord;
import cdm.event.position.InventoryRecord.InventoryRecordBuilder;
import cdm.event.position.InventoryRecord.InventoryRecordBuilderImpl;
import cdm.event.position.InventoryRecord.InventoryRecordImpl;
import cdm.event.position.meta.AvailableInventoryRecordMeta;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.product.collateral.CollateralProvisions;
import cdm.product.collateral.CollateralProvisions.CollateralProvisionsBuilder;
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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An individual piece of available inventory. This represents a single security and its associated criteria. The criteria are used to describe any restrictions on the securities.
 * @version 6.0.0
 */
@RosettaDataType(value="AvailableInventoryRecord", builder=AvailableInventoryRecord.AvailableInventoryRecordBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AvailableInventoryRecord", model="Just another Rosetta model", builder=AvailableInventoryRecord.AvailableInventoryRecordBuilderImpl.class, version="6.0.0")
public interface AvailableInventoryRecord extends InventoryRecord {

	AvailableInventoryRecordMeta metaData = new AvailableInventoryRecordMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * There may be a set period/time restriction associated to the security.
	 */
	ZonedDateTime getExpirationDateTime();
	/**
	 * The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.
	 */
	List<? extends CollateralProvisions> getCollateral();
	/**
	 * An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.
	 */
	List<? extends PartyRole> getPartyRole();
	/**
	 * The quantity of the security
	 */
	Quantity getQuantity();
	/**
	 * An optional element which can be used to hold a rate associated to this piece of availability.
	 */
	Price getInterestRate();

	/*********************** Build Methods  ***********************/
	AvailableInventoryRecord build();
	
	AvailableInventoryRecord.AvailableInventoryRecordBuilder toBuilder();
	
	static AvailableInventoryRecord.AvailableInventoryRecordBuilder builder() {
		return new AvailableInventoryRecord.AvailableInventoryRecordBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AvailableInventoryRecord> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AvailableInventoryRecord> getType() {
		return AvailableInventoryRecord.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifer"), processor, AssignedIdentifier.class, getIdentifer());
		processRosetta(path.newSubPath("security"), processor, Security.class, getSecurity());
		processor.processBasic(path.newSubPath("expirationDateTime"), ZonedDateTime.class, getExpirationDateTime(), this);
		processRosetta(path.newSubPath("collateral"), processor, CollateralProvisions.class, getCollateral());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("interestRate"), processor, Price.class, getInterestRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AvailableInventoryRecordBuilder extends AvailableInventoryRecord, InventoryRecord.InventoryRecordBuilder {
		CollateralProvisions.CollateralProvisionsBuilder getOrCreateCollateral(int _index);
		@Override
		List<? extends CollateralProvisions.CollateralProvisionsBuilder> getCollateral();
		PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index);
		@Override
		List<? extends PartyRole.PartyRoleBuilder> getPartyRole();
		Quantity.QuantityBuilder getOrCreateQuantity();
		@Override
		Quantity.QuantityBuilder getQuantity();
		Price.PriceBuilder getOrCreateInterestRate();
		@Override
		Price.PriceBuilder getInterestRate();
		@Override
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setIdentifer(AssignedIdentifier identifer);
		@Override
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setSecurity(Security security);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setExpirationDateTime(ZonedDateTime expirationDateTime);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(CollateralProvisions collateral);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(CollateralProvisions collateral, int _idx);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(List<? extends CollateralProvisions> collateral);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setCollateral(List<? extends CollateralProvisions> collateral);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(PartyRole partyRole);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(PartyRole partyRole, int _idx);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(List<? extends PartyRole> partyRole);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setPartyRole(List<? extends PartyRole> partyRole);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setQuantity(Quantity quantity);
		AvailableInventoryRecord.AvailableInventoryRecordBuilder setInterestRate(Price interestRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifer"), processor, AssignedIdentifier.AssignedIdentifierBuilder.class, getIdentifer());
			processRosetta(path.newSubPath("security"), processor, Security.SecurityBuilder.class, getSecurity());
			processor.processBasic(path.newSubPath("expirationDateTime"), ZonedDateTime.class, getExpirationDateTime(), this);
			processRosetta(path.newSubPath("collateral"), processor, CollateralProvisions.CollateralProvisionsBuilder.class, getCollateral());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("interestRate"), processor, Price.PriceBuilder.class, getInterestRate());
		}
		

		AvailableInventoryRecord.AvailableInventoryRecordBuilder prune();
	}

	/*********************** Immutable Implementation of AvailableInventoryRecord  ***********************/
	class AvailableInventoryRecordImpl extends InventoryRecord.InventoryRecordImpl implements AvailableInventoryRecord {
		private final ZonedDateTime expirationDateTime;
		private final List<? extends CollateralProvisions> collateral;
		private final List<? extends PartyRole> partyRole;
		private final Quantity quantity;
		private final Price interestRate;
		
		protected AvailableInventoryRecordImpl(AvailableInventoryRecord.AvailableInventoryRecordBuilder builder) {
			super(builder);
			this.expirationDateTime = builder.getExpirationDateTime();
			this.collateral = ofNullable(builder.getCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRole = ofNullable(builder.getPartyRole()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.interestRate = ofNullable(builder.getInterestRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDateTime")
		@RuneAttribute("expirationDateTime")
		public ZonedDateTime getExpirationDateTime() {
			return expirationDateTime;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public List<? extends CollateralProvisions> getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public List<? extends PartyRole> getPartyRole() {
			return partyRole;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public Quantity getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("interestRate")
		@RuneAttribute("interestRate")
		public Price getInterestRate() {
			return interestRate;
		}
		
		@Override
		public AvailableInventoryRecord build() {
			return this;
		}
		
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder toBuilder() {
			AvailableInventoryRecord.AvailableInventoryRecordBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AvailableInventoryRecord.AvailableInventoryRecordBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDateTime()).ifPresent(builder::setExpirationDateTime);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getPartyRole()).ifPresent(builder::setPartyRole);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getInterestRate()).ifPresent(builder::setInterestRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AvailableInventoryRecord _that = getType().cast(o);
		
			if (!Objects.equals(expirationDateTime, _that.getExpirationDateTime())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(interestRate, _that.getInterestRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDateTime != null ? expirationDateTime.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AvailableInventoryRecord {" +
				"expirationDateTime=" + this.expirationDateTime + ", " +
				"collateral=" + this.collateral + ", " +
				"partyRole=" + this.partyRole + ", " +
				"quantity=" + this.quantity + ", " +
				"interestRate=" + this.interestRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AvailableInventoryRecord  ***********************/
	class AvailableInventoryRecordBuilderImpl extends InventoryRecord.InventoryRecordBuilderImpl implements AvailableInventoryRecord.AvailableInventoryRecordBuilder {
	
		protected ZonedDateTime expirationDateTime;
		protected List<CollateralProvisions.CollateralProvisionsBuilder> collateral = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRole = new ArrayList<>();
		protected Quantity.QuantityBuilder quantity;
		protected Price.PriceBuilder interestRate;
		
		@Override
		@RosettaAttribute("expirationDateTime")
		@RuneAttribute("expirationDateTime")
		public ZonedDateTime getExpirationDateTime() {
			return expirationDateTime;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public List<? extends CollateralProvisions.CollateralProvisionsBuilder> getCollateral() {
			return collateral;
		}
		
		@Override
		public CollateralProvisions.CollateralProvisionsBuilder getOrCreateCollateral(int _index) {
		
			if (collateral==null) {
				this.collateral = new ArrayList<>();
			}
			CollateralProvisions.CollateralProvisionsBuilder result;
			return getIndex(collateral, _index, () -> {
						CollateralProvisions.CollateralProvisionsBuilder newCollateral = CollateralProvisions.builder();
						return newCollateral;
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
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public Quantity.QuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateQuantity() {
			Quantity.QuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestRate")
		@RuneAttribute("interestRate")
		public Price.PriceBuilder getInterestRate() {
			return interestRate;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateInterestRate() {
			Price.PriceBuilder result;
			if (interestRate!=null) {
				result = interestRate;
			}
			else {
				result = interestRate = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifer")
		@RuneAttribute("identifer")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setIdentifer(AssignedIdentifier _identifer) {
			this.identifer = _identifer == null ? null : _identifer.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("security")
		@RuneAttribute("security")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setSecurity(Security _security) {
			this.security = _security == null ? null : _security.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("expirationDateTime")
		@RuneAttribute("expirationDateTime")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setExpirationDateTime(ZonedDateTime _expirationDateTime) {
			this.expirationDateTime = _expirationDateTime == null ? null : _expirationDateTime;
			return this;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(CollateralProvisions _collateral) {
			if (_collateral != null) {
				this.collateral.add(_collateral.toBuilder());
			}
			return this;
		}
		
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(CollateralProvisions _collateral, int _idx) {
			getIndex(this.collateral, _idx, () -> _collateral.toBuilder());
			return this;
		}
		
		@Override 
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addCollateral(List<? extends CollateralProvisions> collaterals) {
			if (collaterals != null) {
				for (final CollateralProvisions toAdd : collaterals) {
					this.collateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("collateral")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setCollateral(List<? extends CollateralProvisions> collaterals) {
			if (collaterals == null) {
				this.collateral = new ArrayList<>();
			} else {
				this.collateral = collaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(PartyRole _partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override 
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRole")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
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
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setQuantity(Quantity _quantity) {
			this.quantity = _quantity == null ? null : _quantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("interestRate")
		@RuneAttribute("interestRate")
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder setInterestRate(Price _interestRate) {
			this.interestRate = _interestRate == null ? null : _interestRate.toBuilder();
			return this;
		}
		
		@Override
		public AvailableInventoryRecord build() {
			return new AvailableInventoryRecord.AvailableInventoryRecordImpl(this);
		}
		
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder prune() {
			super.prune();
			collateral = collateral.stream().filter(b->b!=null).<CollateralProvisions.CollateralProvisionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRole = partyRole.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (interestRate!=null && !interestRate.prune().hasData()) interestRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDateTime()!=null) return true;
			if (getCollateral()!=null && getCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRole()!=null && getPartyRole().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getInterestRate()!=null && getInterestRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AvailableInventoryRecord.AvailableInventoryRecordBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AvailableInventoryRecord.AvailableInventoryRecordBuilder o = (AvailableInventoryRecord.AvailableInventoryRecordBuilder) other;
			
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::getOrCreateCollateral);
			merger.mergeRosetta(getPartyRole(), o.getPartyRole(), this::getOrCreatePartyRole);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getInterestRate(), o.getInterestRate(), this::setInterestRate);
			
			merger.mergeBasic(getExpirationDateTime(), o.getExpirationDateTime(), this::setExpirationDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AvailableInventoryRecord _that = getType().cast(o);
		
			if (!Objects.equals(expirationDateTime, _that.getExpirationDateTime())) return false;
			if (!ListEquals.listEquals(collateral, _that.getCollateral())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(interestRate, _that.getInterestRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDateTime != null ? expirationDateTime.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AvailableInventoryRecordBuilder {" +
				"expirationDateTime=" + this.expirationDateTime + ", " +
				"collateral=" + this.collateral + ", " +
				"partyRole=" + this.partyRole + ", " +
				"quantity=" + this.quantity + ", " +
				"interestRate=" + this.interestRate +
			'}' + " " + super.toString();
		}
	}
}
