package cdm.base.staticdata.party;

import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.PersonIdentifier.PersonIdentifierBuilder;
import cdm.base.staticdata.party.PersonIdentifier.PersonIdentifierBuilderImpl;
import cdm.base.staticdata.party.PersonIdentifier.PersonIdentifierImpl;
import cdm.base.staticdata.party.PersonIdentifierTypeEnum;
import cdm.base.staticdata.party.meta.PersonIdentifierMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the PersonIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version 6.0.0
 */
@RosettaDataType(value="PersonIdentifier", builder=PersonIdentifier.PersonIdentifierBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PersonIdentifier", model="Just another Rosetta model", builder=PersonIdentifier.PersonIdentifierBuilderImpl.class, version="6.0.0")
public interface PersonIdentifier extends RosettaModelObject, GlobalKey {

	PersonIdentifierMeta metaData = new PersonIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Provides an identifier associated with a person. The identifier is unique within the public source specified in the source attribute.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * Defines the source of the identifier.
	 */
	PersonIdentifierTypeEnum getIdentifierType();
	/**
	 * The ISO 3166 standard code for the country issuing the identifier.
	 */
	FieldWithMetaString getCountry();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	PersonIdentifier build();
	
	PersonIdentifier.PersonIdentifierBuilder toBuilder();
	
	static PersonIdentifier.PersonIdentifierBuilder builder() {
		return new PersonIdentifier.PersonIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PersonIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PersonIdentifier> getType() {
		return PersonIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processor.processBasic(path.newSubPath("identifierType"), PersonIdentifierTypeEnum.class, getIdentifierType(), this);
		processRosetta(path.newSubPath("country"), processor, FieldWithMetaString.class, getCountry());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonIdentifierBuilder extends PersonIdentifier, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCountry();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCountry();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		PersonIdentifier.PersonIdentifierBuilder setIdentifier(FieldWithMetaString identifier);
		PersonIdentifier.PersonIdentifierBuilder setIdentifierValue(String identifier);
		PersonIdentifier.PersonIdentifierBuilder setIdentifierType(PersonIdentifierTypeEnum identifierType);
		PersonIdentifier.PersonIdentifierBuilder setCountry(FieldWithMetaString country);
		PersonIdentifier.PersonIdentifierBuilder setCountryValue(String country);
		PersonIdentifier.PersonIdentifierBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getIdentifier());
			processor.processBasic(path.newSubPath("identifierType"), PersonIdentifierTypeEnum.class, getIdentifierType(), this);
			processRosetta(path.newSubPath("country"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCountry());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		PersonIdentifier.PersonIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PersonIdentifier  ***********************/
	class PersonIdentifierImpl implements PersonIdentifier {
		private final FieldWithMetaString identifier;
		private final PersonIdentifierTypeEnum identifierType;
		private final FieldWithMetaString country;
		private final MetaFields meta;
		
		protected PersonIdentifierImpl(PersonIdentifier.PersonIdentifierBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.identifierType = builder.getIdentifierType();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public PersonIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("country")
		@RuneAttribute("country")
		public FieldWithMetaString getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PersonIdentifier build() {
			return this;
		}
		
		@Override
		public PersonIdentifier.PersonIdentifierBuilder toBuilder() {
			PersonIdentifier.PersonIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PersonIdentifier.PersonIdentifierBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getIdentifierType()).ifPresent(builder::setIdentifierType);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonIdentifier {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType + ", " +
				"country=" + this.country + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of PersonIdentifier  ***********************/
	class PersonIdentifierBuilderImpl implements PersonIdentifier.PersonIdentifierBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder identifier;
		protected PersonIdentifierTypeEnum identifierType;
		protected FieldWithMetaString.FieldWithMetaStringBuilder country;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public FieldWithMetaString.FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public PersonIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("country")
		@RuneAttribute("country")
		public FieldWithMetaString.FieldWithMetaStringBuilder getCountry() {
			return country;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCountry() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = FieldWithMetaString.builder();
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
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public PersonIdentifier.PersonIdentifierBuilder setIdentifier(FieldWithMetaString _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public PersonIdentifier.PersonIdentifierBuilder setIdentifierValue(String _identifier) {
			this.getOrCreateIdentifier().setValue(_identifier);
			return this;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public PersonIdentifier.PersonIdentifierBuilder setIdentifierType(PersonIdentifierTypeEnum _identifierType) {
			this.identifierType = _identifierType == null ? null : _identifierType;
			return this;
		}
		
		@Override
		@RosettaAttribute("country")
		@RuneAttribute("country")
		public PersonIdentifier.PersonIdentifierBuilder setCountry(FieldWithMetaString _country) {
			this.country = _country == null ? null : _country.toBuilder();
			return this;
		}
		
		@Override
		public PersonIdentifier.PersonIdentifierBuilder setCountryValue(String _country) {
			this.getOrCreateCountry().setValue(_country);
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public PersonIdentifier.PersonIdentifierBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public PersonIdentifier build() {
			return new PersonIdentifier.PersonIdentifierImpl(this);
		}
		
		@Override
		public PersonIdentifier.PersonIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonIdentifier.PersonIdentifierBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (country!=null && !country.prune().hasData()) country = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getIdentifierType()!=null) return true;
			if (getCountry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PersonIdentifier.PersonIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PersonIdentifier.PersonIdentifierBuilder o = (PersonIdentifier.PersonIdentifierBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getIdentifierType(), o.getIdentifierType(), this::setIdentifierType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PersonIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonIdentifierBuilder {" +
				"identifier=" + this.identifier + ", " +
				"identifierType=" + this.identifierType + ", " +
				"country=" + this.country + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
