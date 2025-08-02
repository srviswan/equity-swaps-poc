package cdm.base.staticdata.party;

import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.Address.AddressBuilder;
import cdm.base.staticdata.party.Address.AddressBuilderImpl;
import cdm.base.staticdata.party.Address.AddressImpl;
import cdm.base.staticdata.party.meta.AddressMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a post or street address.
 * @version 6.0.0
 */
@RosettaDataType(value="Address", builder=Address.AddressBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Address", model="Just another Rosetta model", builder=Address.AddressBuilderImpl.class, version="6.0.0")
public interface Address extends RosettaModelObject {

	AddressMeta metaData = new AddressMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The set of street and building number information that identifies a postal address within a city.
	 */
	List<String> getStreet();
	/**
	 * The city component of the postal address.
	 */
	String getCity();
	/**
	 * A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons, ...
	 */
	String getState();
	/**
	 * The ISO 3166 standard code for the country within which the postal address is located.
	 */
	FieldWithMetaString getCountry();
	/**
	 * The code, required for computerized mail sorting systems, that is allocated to a physical address by a national postal authority.
	 */
	String getPostalCode();

	/*********************** Build Methods  ***********************/
	Address build();
	
	Address.AddressBuilder toBuilder();
	
	static Address.AddressBuilder builder() {
		return new Address.AddressBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Address> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Address> getType() {
		return Address.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("street"), String.class, getStreet(), this);
		processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
		processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
		processRosetta(path.newSubPath("country"), processor, FieldWithMetaString.class, getCountry());
		processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AddressBuilder extends Address, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCountry();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCountry();
		Address.AddressBuilder addStreet(String street);
		Address.AddressBuilder addStreet(String street, int _idx);
		Address.AddressBuilder addStreet(List<String> street);
		Address.AddressBuilder setStreet(List<String> street);
		Address.AddressBuilder setCity(String city);
		Address.AddressBuilder setState(String state);
		Address.AddressBuilder setCountry(FieldWithMetaString country);
		Address.AddressBuilder setCountryValue(String country);
		Address.AddressBuilder setPostalCode(String postalCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("street"), String.class, getStreet(), this);
			processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
			processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
			processRosetta(path.newSubPath("country"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCountry());
			processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
		}
		

		Address.AddressBuilder prune();
	}

	/*********************** Immutable Implementation of Address  ***********************/
	class AddressImpl implements Address {
		private final List<String> street;
		private final String city;
		private final String state;
		private final FieldWithMetaString country;
		private final String postalCode;
		
		protected AddressImpl(Address.AddressBuilder builder) {
			this.street = ofNullable(builder.getStreet()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.city = builder.getCity();
			this.state = builder.getState();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.postalCode = builder.getPostalCode();
		}
		
		@Override
		@RosettaAttribute("street")
		@RuneAttribute("street")
		public List<String> getStreet() {
			return street;
		}
		
		@Override
		@RosettaAttribute("city")
		@RuneAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public String getState() {
			return state;
		}
		
		@Override
		@RosettaAttribute("country")
		@RuneAttribute("country")
		public FieldWithMetaString getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("postalCode")
		@RuneAttribute("postalCode")
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		public Address build() {
			return this;
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			Address.AddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Address.AddressBuilder builder) {
			ofNullable(getStreet()).ifPresent(builder::setStreet);
			ofNullable(getCity()).ifPresent(builder::setCity);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getPostalCode()).ifPresent(builder::setPostalCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!ListEquals.listEquals(street, _that.getStreet())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (street != null ? street.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Address {" +
				"street=" + this.street + ", " +
				"city=" + this.city + ", " +
				"state=" + this.state + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode +
			'}';
		}
	}

	/*********************** Builder Implementation of Address  ***********************/
	class AddressBuilderImpl implements Address.AddressBuilder {
	
		protected List<String> street = new ArrayList<>();
		protected String city;
		protected String state;
		protected FieldWithMetaString.FieldWithMetaStringBuilder country;
		protected String postalCode;
		
		@Override
		@RosettaAttribute("street")
		@RuneAttribute("street")
		public List<String> getStreet() {
			return street;
		}
		
		@Override
		@RosettaAttribute("city")
		@RuneAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public String getState() {
			return state;
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
		@RosettaAttribute("postalCode")
		@RuneAttribute("postalCode")
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		@RosettaAttribute("street")
		@RuneAttribute("street")
		public Address.AddressBuilder addStreet(String _street) {
			if (_street != null) {
				this.street.add(_street);
			}
			return this;
		}
		
		@Override
		public Address.AddressBuilder addStreet(String _street, int _idx) {
			getIndex(this.street, _idx, () -> _street);
			return this;
		}
		
		@Override 
		public Address.AddressBuilder addStreet(List<String> streets) {
			if (streets != null) {
				for (final String toAdd : streets) {
					this.street.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("street")
		public Address.AddressBuilder setStreet(List<String> streets) {
			if (streets == null) {
				this.street = new ArrayList<>();
			} else {
				this.street = streets.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("city")
		@RuneAttribute("city")
		public Address.AddressBuilder setCity(String _city) {
			this.city = _city == null ? null : _city;
			return this;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public Address.AddressBuilder setState(String _state) {
			this.state = _state == null ? null : _state;
			return this;
		}
		
		@Override
		@RosettaAttribute("country")
		@RuneAttribute("country")
		public Address.AddressBuilder setCountry(FieldWithMetaString _country) {
			this.country = _country == null ? null : _country.toBuilder();
			return this;
		}
		
		@Override
		public Address.AddressBuilder setCountryValue(String _country) {
			this.getOrCreateCountry().setValue(_country);
			return this;
		}
		
		@Override
		@RosettaAttribute("postalCode")
		@RuneAttribute("postalCode")
		public Address.AddressBuilder setPostalCode(String _postalCode) {
			this.postalCode = _postalCode == null ? null : _postalCode;
			return this;
		}
		
		@Override
		public Address build() {
			return new Address.AddressImpl(this);
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder prune() {
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStreet()!=null && !getStreet().isEmpty()) return true;
			if (getCity()!=null) return true;
			if (getState()!=null) return true;
			if (getCountry()!=null) return true;
			if (getPostalCode()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Address.AddressBuilder o = (Address.AddressBuilder) other;
			
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getStreet(), o.getStreet(), (Consumer<String>) this::addStreet);
			merger.mergeBasic(getCity(), o.getCity(), this::setCity);
			merger.mergeBasic(getState(), o.getState(), this::setState);
			merger.mergeBasic(getPostalCode(), o.getPostalCode(), this::setPostalCode);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!ListEquals.listEquals(street, _that.getStreet())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (street != null ? street.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddressBuilder {" +
				"street=" + this.street + ", " +
				"city=" + this.city + ", " +
				"state=" + this.state + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode +
			'}';
		}
	}
}
