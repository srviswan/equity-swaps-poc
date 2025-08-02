package cdm.product.collateral;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Counterparty.CounterpartyBuilder;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder;
import cdm.product.collateral.EligibleCollateralSpecification;
import cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder;
import cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecificationBuilderImpl;
import cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecificationImpl;
import cdm.product.collateral.meta.EligibleCollateralSpecificationMeta;
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
 * Represents a set of criteria used to specify eligible collateral.
 * @version 6.0.0
 */
@RosettaDataType(value="EligibleCollateralSpecification", builder=EligibleCollateralSpecification.EligibleCollateralSpecificationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="EligibleCollateralSpecification", model="Just another Rosetta model", builder=EligibleCollateralSpecification.EligibleCollateralSpecificationBuilderImpl.class, version="6.0.0")
public interface EligibleCollateralSpecification extends RosettaModelObject, GlobalKey {

	EligibleCollateralSpecificationMeta metaData = new EligibleCollateralSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the identifier(s) to uniquely identify eligible collateral or a set of eligible collateral, such as a schedule or equivalant for an identity issuer.
	 */
	List<? extends Identifier> getIdentifier();
	/**
	 * The parties associated with the specification.
	 */
	List<? extends Party> getParty();
	/**
	 * Specification of the roles of the counterparties to the specification.
	 */
	List<? extends Counterparty> getCounterparty();
	/**
	 * Represents a set of criteria used to specify eligible collateral.
	 */
	List<? extends EligibleCollateralCriteria> getCriteria();
	/**
	 * Specifies the role(s) that each of the party(s) is playing in the context of the specification, eg Payor or Receiver.
	 */
	List<? extends PartyRole> getPartyRole();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	EligibleCollateralSpecification build();
	
	EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder toBuilder();
	
	static EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder builder() {
		return new EligibleCollateralSpecification.EligibleCollateralSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EligibleCollateralSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EligibleCollateralSpecification> getType() {
		return EligibleCollateralSpecification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, Identifier.class, getIdentifier());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
		processRosetta(path.newSubPath("criteria"), processor, EligibleCollateralCriteria.class, getCriteria());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EligibleCollateralSpecificationBuilder extends EligibleCollateralSpecification, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		Identifier.IdentifierBuilder getOrCreateIdentifier(int _index);
		@Override
		List<? extends Identifier.IdentifierBuilder> getIdentifier();
		Party.PartyBuilder getOrCreateParty(int _index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index);
		@Override
		List<? extends Counterparty.CounterpartyBuilder> getCounterparty();
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateCriteria(int _index);
		@Override
		List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getCriteria();
		PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index);
		@Override
		List<? extends PartyRole.PartyRoleBuilder> getPartyRole();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(Identifier identifier);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(Identifier identifier, int _idx);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(List<? extends Identifier> identifier);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setIdentifier(List<? extends Identifier> identifier);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(Party party);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(Party party, int _idx);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(List<? extends Party> party);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setParty(List<? extends Party> party);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(Counterparty counterparty);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(Counterparty counterparty, int _idx);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(List<? extends Counterparty> counterparty);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setCounterparty(List<? extends Counterparty> counterparty);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(EligibleCollateralCriteria criteria);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(EligibleCollateralCriteria criteria, int _idx);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(List<? extends EligibleCollateralCriteria> criteria);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setCriteria(List<? extends EligibleCollateralCriteria> criteria);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(PartyRole partyRole);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(PartyRole partyRole, int _idx);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(List<? extends PartyRole> partyRole);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setPartyRole(List<? extends PartyRole> partyRole);
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, Identifier.IdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
			processRosetta(path.newSubPath("criteria"), processor, EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder.class, getCriteria());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of EligibleCollateralSpecification  ***********************/
	class EligibleCollateralSpecificationImpl implements EligibleCollateralSpecification {
		private final List<? extends Identifier> identifier;
		private final List<? extends Party> party;
		private final List<? extends Counterparty> counterparty;
		private final List<? extends EligibleCollateralCriteria> criteria;
		private final List<? extends PartyRole> partyRole;
		private final MetaFields meta;
		
		protected EligibleCollateralSpecificationImpl(EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.criteria = ofNullable(builder.getCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRole = ofNullable(builder.getPartyRole()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends Identifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<? extends Counterparty> getCounterparty() {
			return counterparty;
		}
		
		@Override
		@RosettaAttribute("criteria")
		@RuneAttribute("criteria")
		public List<? extends EligibleCollateralCriteria> getCriteria() {
			return criteria;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public List<? extends PartyRole> getPartyRole() {
			return partyRole;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public EligibleCollateralSpecification build() {
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder toBuilder() {
			EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getCriteria()).ifPresent(builder::setCriteria);
			ofNullable(getPartyRole()).ifPresent(builder::setPartyRole);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralSpecification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(criteria, _that.getCriteria())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (criteria != null ? criteria.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralSpecification {" +
				"identifier=" + this.identifier + ", " +
				"party=" + this.party + ", " +
				"counterparty=" + this.counterparty + ", " +
				"criteria=" + this.criteria + ", " +
				"partyRole=" + this.partyRole + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of EligibleCollateralSpecification  ***********************/
	class EligibleCollateralSpecificationBuilderImpl implements EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder {
	
		protected List<Identifier.IdentifierBuilder> identifier = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Counterparty.CounterpartyBuilder> counterparty = new ArrayList<>();
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> criteria = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRole = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends Identifier.IdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						Identifier.IdentifierBuilder newIdentifier = Identifier.builder();
						return newIdentifier;
					});
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
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<? extends Counterparty.CounterpartyBuilder> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index) {
		
			if (counterparty==null) {
				this.counterparty = new ArrayList<>();
			}
			Counterparty.CounterpartyBuilder result;
			return getIndex(counterparty, _index, () -> {
						Counterparty.CounterpartyBuilder newCounterparty = Counterparty.builder();
						return newCounterparty;
					});
		}
		
		@Override
		@RosettaAttribute("criteria")
		@RuneAttribute("criteria")
		public List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getCriteria() {
			return criteria;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateCriteria(int _index) {
		
			if (criteria==null) {
				this.criteria = new ArrayList<>();
			}
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder result;
			return getIndex(criteria, _index, () -> {
						EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder newCriteria = EligibleCollateralCriteria.builder();
						return newCriteria;
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
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(Identifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(Identifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addIdentifier(List<? extends Identifier> identifiers) {
			if (identifiers != null) {
				for (final Identifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setIdentifier(List<? extends Identifier> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(Party _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override 
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setParty(List<? extends Party> partys) {
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
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(Counterparty _counterparty) {
			if (_counterparty != null) {
				this.counterparty.add(_counterparty.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(Counterparty _counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> _counterparty.toBuilder());
			return this;
		}
		
		@Override 
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys != null) {
				for (final Counterparty toAdd : counterpartys) {
					this.counterparty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("counterparty")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys == null) {
				this.counterparty = new ArrayList<>();
			} else {
				this.counterparty = counterpartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("criteria")
		@RuneAttribute("criteria")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(EligibleCollateralCriteria _criteria) {
			if (_criteria != null) {
				this.criteria.add(_criteria.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(EligibleCollateralCriteria _criteria, int _idx) {
			getIndex(this.criteria, _idx, () -> _criteria.toBuilder());
			return this;
		}
		
		@Override 
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addCriteria(List<? extends EligibleCollateralCriteria> criterias) {
			if (criterias != null) {
				for (final EligibleCollateralCriteria toAdd : criterias) {
					this.criteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("criteria")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setCriteria(List<? extends EligibleCollateralCriteria> criterias) {
			if (criterias == null) {
				this.criteria = new ArrayList<>();
			} else {
				this.criteria = criterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(PartyRole _partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override 
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRole")
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
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
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCollateralSpecification build() {
			return new EligibleCollateralSpecification.EligibleCollateralSpecificationImpl(this);
		}
		
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			counterparty = counterparty.stream().filter(b->b!=null).<Counterparty.CounterpartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			criteria = criteria.stream().filter(b->b!=null).<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRole = partyRole.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCounterparty()!=null && getCounterparty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCriteria()!=null && getCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRole()!=null && getPartyRole().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder o = (EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::getOrCreateCounterparty);
			merger.mergeRosetta(getCriteria(), o.getCriteria(), this::getOrCreateCriteria);
			merger.mergeRosetta(getPartyRole(), o.getPartyRole(), this::getOrCreatePartyRole);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralSpecification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(criteria, _that.getCriteria())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (criteria != null ? criteria.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralSpecificationBuilder {" +
				"identifier=" + this.identifier + ", " +
				"party=" + this.party + ", " +
				"counterparty=" + this.counterparty + ", " +
				"criteria=" + this.criteria + ", " +
				"partyRole=" + this.partyRole + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
