package cdm.base.staticdata.party;

import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.ContactInformation.ContactInformationBuilder;
import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.NaturalPerson.NaturalPersonBuilder;
import cdm.base.staticdata.party.NaturalPerson.NaturalPersonBuilderImpl;
import cdm.base.staticdata.party.NaturalPerson.NaturalPersonImpl;
import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.meta.NaturalPersonMeta;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to represent the attributes that are specific to a natural person.
 * @version 6.0.0
 */
@RosettaDataType(value="NaturalPerson", builder=NaturalPerson.NaturalPersonBuilderImpl.class, version="6.0.0")
@RuneDataType(value="NaturalPerson", model="Just another Rosetta model", builder=NaturalPerson.NaturalPersonBuilderImpl.class, version="6.0.0")
public interface NaturalPerson extends RosettaModelObject, GlobalKey {

	NaturalPersonMeta metaData = new NaturalPersonMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The identifier associated with a person, e.g. the internal identification code.
	 */
	List<? extends FieldWithMetaPersonIdentifier> getPersonId();
	/**
	 * An honorific title, such as Mr., Ms., Dr. etc.
	 */
	String getHonorific();
	/**
	 * The natural person&#39;s first name. It is optional in FpML.
	 */
	String getFirstName();
	/**
	 * The natural person&#39;s middle name(s). If a middle name is provided then an initial should be absent.
	 */
	List<String> getMiddleName();
	/**
	 * The natural person&#39;s middle initial(s). If a middle initial is provided then a name should be absent.
	 */
	List<String> getInitial();
	/**
	 * The natural person&#39;s surname.
	 */
	String getSurname();
	/**
	 * Name suffix, such as Jr., III, etc.
	 */
	String getSuffix();
	/**
	 * The natural person&#39;s date of birth.
	 */
	Date getDateOfBirth();
	/**
	 * The contact information for such person, when different from the contact information associated with the party.
	 */
	ContactInformation getContactInformation();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	NaturalPerson build();
	
	NaturalPerson.NaturalPersonBuilder toBuilder();
	
	static NaturalPerson.NaturalPersonBuilder builder() {
		return new NaturalPerson.NaturalPersonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPerson> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPerson> getType() {
		return NaturalPerson.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("personId"), processor, FieldWithMetaPersonIdentifier.class, getPersonId());
		processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
		processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
		processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
		processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
		processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
		processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
		processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
		processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.class, getContactInformation());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonBuilder extends NaturalPerson, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder getOrCreatePersonId(int _index);
		@Override
		List<? extends FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder> getPersonId();
		ContactInformation.ContactInformationBuilder getOrCreateContactInformation();
		@Override
		ContactInformation.ContactInformationBuilder getContactInformation();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		NaturalPerson.NaturalPersonBuilder addPersonId(FieldWithMetaPersonIdentifier personId);
		NaturalPerson.NaturalPersonBuilder addPersonId(FieldWithMetaPersonIdentifier personId, int _idx);
		NaturalPerson.NaturalPersonBuilder addPersonIdValue(PersonIdentifier personId);
		NaturalPerson.NaturalPersonBuilder addPersonIdValue(PersonIdentifier personId, int _idx);
		NaturalPerson.NaturalPersonBuilder addPersonId(List<? extends FieldWithMetaPersonIdentifier> personId);
		NaturalPerson.NaturalPersonBuilder setPersonId(List<? extends FieldWithMetaPersonIdentifier> personId);
		NaturalPerson.NaturalPersonBuilder addPersonIdValue(List<? extends PersonIdentifier> personId);
		NaturalPerson.NaturalPersonBuilder setPersonIdValue(List<? extends PersonIdentifier> personId);
		NaturalPerson.NaturalPersonBuilder setHonorific(String honorific);
		NaturalPerson.NaturalPersonBuilder setFirstName(String firstName);
		NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName);
		NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName, int _idx);
		NaturalPerson.NaturalPersonBuilder addMiddleName(List<String> middleName);
		NaturalPerson.NaturalPersonBuilder setMiddleName(List<String> middleName);
		NaturalPerson.NaturalPersonBuilder addInitial(String initial);
		NaturalPerson.NaturalPersonBuilder addInitial(String initial, int _idx);
		NaturalPerson.NaturalPersonBuilder addInitial(List<String> initial);
		NaturalPerson.NaturalPersonBuilder setInitial(List<String> initial);
		NaturalPerson.NaturalPersonBuilder setSurname(String surname);
		NaturalPerson.NaturalPersonBuilder setSuffix(String suffix);
		NaturalPerson.NaturalPersonBuilder setDateOfBirth(Date dateOfBirth);
		NaturalPerson.NaturalPersonBuilder setContactInformation(ContactInformation contactInformation);
		NaturalPerson.NaturalPersonBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("personId"), processor, FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder.class, getPersonId());
			processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
			processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
			processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
			processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
			processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
			processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
			processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
			processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.ContactInformationBuilder.class, getContactInformation());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		NaturalPerson.NaturalPersonBuilder prune();
	}

	/*********************** Immutable Implementation of NaturalPerson  ***********************/
	class NaturalPersonImpl implements NaturalPerson {
		private final List<? extends FieldWithMetaPersonIdentifier> personId;
		private final String honorific;
		private final String firstName;
		private final List<String> middleName;
		private final List<String> initial;
		private final String surname;
		private final String suffix;
		private final Date dateOfBirth;
		private final ContactInformation contactInformation;
		private final MetaFields meta;
		
		protected NaturalPersonImpl(NaturalPerson.NaturalPersonBuilder builder) {
			this.personId = ofNullable(builder.getPersonId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.honorific = builder.getHonorific();
			this.firstName = builder.getFirstName();
			this.middleName = ofNullable(builder.getMiddleName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.initial = ofNullable(builder.getInitial()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.surname = builder.getSurname();
			this.suffix = builder.getSuffix();
			this.dateOfBirth = builder.getDateOfBirth();
			this.contactInformation = ofNullable(builder.getContactInformation()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("personId")
		@RuneAttribute("personId")
		public List<? extends FieldWithMetaPersonIdentifier> getPersonId() {
			return personId;
		}
		
		@Override
		@RosettaAttribute("honorific")
		@RuneAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		@RuneAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		@RuneAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		@RuneAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		@RuneAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		@RuneAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		@RosettaAttribute("dateOfBirth")
		@RuneAttribute("dateOfBirth")
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		@Override
		@RosettaAttribute("contactInformation")
		@RuneAttribute("contactInformation")
		public ContactInformation getContactInformation() {
			return contactInformation;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public NaturalPerson build() {
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder toBuilder() {
			NaturalPerson.NaturalPersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPerson.NaturalPersonBuilder builder) {
			ofNullable(getPersonId()).ifPresent(builder::setPersonId);
			ofNullable(getHonorific()).ifPresent(builder::setHonorific);
			ofNullable(getFirstName()).ifPresent(builder::setFirstName);
			ofNullable(getMiddleName()).ifPresent(builder::setMiddleName);
			ofNullable(getInitial()).ifPresent(builder::setInitial);
			ofNullable(getSurname()).ifPresent(builder::setSurname);
			ofNullable(getSuffix()).ifPresent(builder::setSuffix);
			ofNullable(getDateOfBirth()).ifPresent(builder::setDateOfBirth);
			ofNullable(getContactInformation()).ifPresent(builder::setContactInformation);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPerson _that = getType().cast(o);
		
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPerson {" +
				"personId=" + this.personId + ", " +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"contactInformation=" + this.contactInformation + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPerson  ***********************/
	class NaturalPersonBuilderImpl implements NaturalPerson.NaturalPersonBuilder {
	
		protected List<FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder> personId = new ArrayList<>();
		protected String honorific;
		protected String firstName;
		protected List<String> middleName = new ArrayList<>();
		protected List<String> initial = new ArrayList<>();
		protected String surname;
		protected String suffix;
		protected Date dateOfBirth;
		protected ContactInformation.ContactInformationBuilder contactInformation;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("personId")
		@RuneAttribute("personId")
		public List<? extends FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder> getPersonId() {
			return personId;
		}
		
		@Override
		public FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder getOrCreatePersonId(int _index) {
		
			if (personId==null) {
				this.personId = new ArrayList<>();
			}
			FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder result;
			return getIndex(personId, _index, () -> {
						FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder newPersonId = FieldWithMetaPersonIdentifier.builder();
						return newPersonId;
					});
		}
		
		@Override
		@RosettaAttribute("honorific")
		@RuneAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		@RuneAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		@RuneAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		@RuneAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		@RuneAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		@RuneAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		@RosettaAttribute("dateOfBirth")
		@RuneAttribute("dateOfBirth")
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		@Override
		@RosettaAttribute("contactInformation")
		@RuneAttribute("contactInformation")
		public ContactInformation.ContactInformationBuilder getContactInformation() {
			return contactInformation;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder getOrCreateContactInformation() {
			ContactInformation.ContactInformationBuilder result;
			if (contactInformation!=null) {
				result = contactInformation;
			}
			else {
				result = contactInformation = ContactInformation.builder();
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
		@RosettaAttribute("personId")
		@RuneAttribute("personId")
		public NaturalPerson.NaturalPersonBuilder addPersonId(FieldWithMetaPersonIdentifier _personId) {
			if (_personId != null) {
				this.personId.add(_personId.toBuilder());
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addPersonId(FieldWithMetaPersonIdentifier _personId, int _idx) {
			getIndex(this.personId, _idx, () -> _personId.toBuilder());
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addPersonIdValue(PersonIdentifier _personId) {
			this.getOrCreatePersonId(-1).setValue(_personId.toBuilder());
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addPersonIdValue(PersonIdentifier _personId, int _idx) {
			this.getOrCreatePersonId(_idx).setValue(_personId.toBuilder());
			return this;
		}
		
		@Override 
		public NaturalPerson.NaturalPersonBuilder addPersonId(List<? extends FieldWithMetaPersonIdentifier> personIds) {
			if (personIds != null) {
				for (final FieldWithMetaPersonIdentifier toAdd : personIds) {
					this.personId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("personId")
		public NaturalPerson.NaturalPersonBuilder setPersonId(List<? extends FieldWithMetaPersonIdentifier> personIds) {
			if (personIds == null) {
				this.personId = new ArrayList<>();
			} else {
				this.personId = personIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addPersonIdValue(List<? extends PersonIdentifier> personIds) {
			if (personIds != null) {
				for (final PersonIdentifier toAdd : personIds) {
					this.addPersonIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder setPersonIdValue(List<? extends PersonIdentifier> personIds) {
			this.personId.clear();
			if (personIds != null) {
				personIds.forEach(this::addPersonIdValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("honorific")
		@RuneAttribute("honorific")
		public NaturalPerson.NaturalPersonBuilder setHonorific(String _honorific) {
			this.honorific = _honorific == null ? null : _honorific;
			return this;
		}
		
		@Override
		@RosettaAttribute("firstName")
		@RuneAttribute("firstName")
		public NaturalPerson.NaturalPersonBuilder setFirstName(String _firstName) {
			this.firstName = _firstName == null ? null : _firstName;
			return this;
		}
		
		@Override
		@RosettaAttribute("middleName")
		@RuneAttribute("middleName")
		public NaturalPerson.NaturalPersonBuilder addMiddleName(String _middleName) {
			if (_middleName != null) {
				this.middleName.add(_middleName);
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addMiddleName(String _middleName, int _idx) {
			getIndex(this.middleName, _idx, () -> _middleName);
			return this;
		}
		
		@Override 
		public NaturalPerson.NaturalPersonBuilder addMiddleName(List<String> middleNames) {
			if (middleNames != null) {
				for (final String toAdd : middleNames) {
					this.middleName.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("middleName")
		public NaturalPerson.NaturalPersonBuilder setMiddleName(List<String> middleNames) {
			if (middleNames == null) {
				this.middleName = new ArrayList<>();
			} else {
				this.middleName = middleNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initial")
		@RuneAttribute("initial")
		public NaturalPerson.NaturalPersonBuilder addInitial(String _initial) {
			if (_initial != null) {
				this.initial.add(_initial);
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addInitial(String _initial, int _idx) {
			getIndex(this.initial, _idx, () -> _initial);
			return this;
		}
		
		@Override 
		public NaturalPerson.NaturalPersonBuilder addInitial(List<String> initials) {
			if (initials != null) {
				for (final String toAdd : initials) {
					this.initial.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("initial")
		public NaturalPerson.NaturalPersonBuilder setInitial(List<String> initials) {
			if (initials == null) {
				this.initial = new ArrayList<>();
			} else {
				this.initial = initials.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("surname")
		@RuneAttribute("surname")
		public NaturalPerson.NaturalPersonBuilder setSurname(String _surname) {
			this.surname = _surname == null ? null : _surname;
			return this;
		}
		
		@Override
		@RosettaAttribute("suffix")
		@RuneAttribute("suffix")
		public NaturalPerson.NaturalPersonBuilder setSuffix(String _suffix) {
			this.suffix = _suffix == null ? null : _suffix;
			return this;
		}
		
		@Override
		@RosettaAttribute("dateOfBirth")
		@RuneAttribute("dateOfBirth")
		public NaturalPerson.NaturalPersonBuilder setDateOfBirth(Date _dateOfBirth) {
			this.dateOfBirth = _dateOfBirth == null ? null : _dateOfBirth;
			return this;
		}
		
		@Override
		@RosettaAttribute("contactInformation")
		@RuneAttribute("contactInformation")
		public NaturalPerson.NaturalPersonBuilder setContactInformation(ContactInformation _contactInformation) {
			this.contactInformation = _contactInformation == null ? null : _contactInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public NaturalPerson.NaturalPersonBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPerson build() {
			return new NaturalPerson.NaturalPersonImpl(this);
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPerson.NaturalPersonBuilder prune() {
			personId = personId.stream().filter(b->b!=null).<FieldWithMetaPersonIdentifier.FieldWithMetaPersonIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (contactInformation!=null && !contactInformation.prune().hasData()) contactInformation = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPersonId()!=null && getPersonId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getHonorific()!=null) return true;
			if (getFirstName()!=null) return true;
			if (getMiddleName()!=null && !getMiddleName().isEmpty()) return true;
			if (getInitial()!=null && !getInitial().isEmpty()) return true;
			if (getSurname()!=null) return true;
			if (getSuffix()!=null) return true;
			if (getDateOfBirth()!=null) return true;
			if (getContactInformation()!=null && getContactInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPerson.NaturalPersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPerson.NaturalPersonBuilder o = (NaturalPerson.NaturalPersonBuilder) other;
			
			merger.mergeRosetta(getPersonId(), o.getPersonId(), this::getOrCreatePersonId);
			merger.mergeRosetta(getContactInformation(), o.getContactInformation(), this::setContactInformation);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getHonorific(), o.getHonorific(), this::setHonorific);
			merger.mergeBasic(getFirstName(), o.getFirstName(), this::setFirstName);
			merger.mergeBasic(getMiddleName(), o.getMiddleName(), (Consumer<String>) this::addMiddleName);
			merger.mergeBasic(getInitial(), o.getInitial(), (Consumer<String>) this::addInitial);
			merger.mergeBasic(getSurname(), o.getSurname(), this::setSurname);
			merger.mergeBasic(getSuffix(), o.getSuffix(), this::setSuffix);
			merger.mergeBasic(getDateOfBirth(), o.getDateOfBirth(), this::setDateOfBirth);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPerson _that = getType().cast(o);
		
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonBuilder {" +
				"personId=" + this.personId + ", " +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"contactInformation=" + this.contactInformation + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
