package cdm.base.staticdata.party;

import cdm.base.staticdata.party.TelephoneNumber;
import cdm.base.staticdata.party.TelephoneNumber.TelephoneNumberBuilder;
import cdm.base.staticdata.party.TelephoneNumber.TelephoneNumberBuilderImpl;
import cdm.base.staticdata.party.TelephoneNumber.TelephoneNumberImpl;
import cdm.base.staticdata.party.TelephoneTypeEnum;
import cdm.base.staticdata.party.meta.TelephoneNumberMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
 * @version 6.0.0
 */
@RosettaDataType(value="TelephoneNumber", builder=TelephoneNumber.TelephoneNumberBuilderImpl.class, version="6.0.0")
@RuneDataType(value="TelephoneNumber", model="Just another Rosetta model", builder=TelephoneNumber.TelephoneNumberBuilderImpl.class, version="6.0.0")
public interface TelephoneNumber extends RosettaModelObject {

	TelephoneNumberMeta metaData = new TelephoneNumberMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of telephone number, e.g. work, mobile.
	 */
	TelephoneTypeEnum getTelephoneNumberType();
	/**
	 * The actual telephone number.
	 */
	String getNumber();

	/*********************** Build Methods  ***********************/
	TelephoneNumber build();
	
	TelephoneNumber.TelephoneNumberBuilder toBuilder();
	
	static TelephoneNumber.TelephoneNumberBuilder builder() {
		return new TelephoneNumber.TelephoneNumberBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TelephoneNumber> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TelephoneNumber> getType() {
		return TelephoneNumber.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("telephoneNumberType"), TelephoneTypeEnum.class, getTelephoneNumberType(), this);
		processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TelephoneNumberBuilder extends TelephoneNumber, RosettaModelObjectBuilder {
		TelephoneNumber.TelephoneNumberBuilder setTelephoneNumberType(TelephoneTypeEnum telephoneNumberType);
		TelephoneNumber.TelephoneNumberBuilder setNumber(String number);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("telephoneNumberType"), TelephoneTypeEnum.class, getTelephoneNumberType(), this);
			processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
		}
		

		TelephoneNumber.TelephoneNumberBuilder prune();
	}

	/*********************** Immutable Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberImpl implements TelephoneNumber {
		private final TelephoneTypeEnum telephoneNumberType;
		private final String number;
		
		protected TelephoneNumberImpl(TelephoneNumber.TelephoneNumberBuilder builder) {
			this.telephoneNumberType = builder.getTelephoneNumberType();
			this.number = builder.getNumber();
		}
		
		@Override
		@RosettaAttribute("telephoneNumberType")
		@RuneAttribute("telephoneNumberType")
		public TelephoneTypeEnum getTelephoneNumberType() {
			return telephoneNumberType;
		}
		
		@Override
		@RosettaAttribute("number")
		@RuneAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@Override
		public TelephoneNumber build() {
			return this;
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			TelephoneNumber.TelephoneNumberBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TelephoneNumber.TelephoneNumberBuilder builder) {
			ofNullable(getTelephoneNumberType()).ifPresent(builder::setTelephoneNumberType);
			ofNullable(getNumber()).ifPresent(builder::setNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(telephoneNumberType, _that.getTelephoneNumberType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (telephoneNumberType != null ? telephoneNumberType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumber {" +
				"telephoneNumberType=" + this.telephoneNumberType + ", " +
				"number=" + this.number +
			'}';
		}
	}

	/*********************** Builder Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberBuilderImpl implements TelephoneNumber.TelephoneNumberBuilder {
	
		protected TelephoneTypeEnum telephoneNumberType;
		protected String number;
		
		@Override
		@RosettaAttribute("telephoneNumberType")
		@RuneAttribute("telephoneNumberType")
		public TelephoneTypeEnum getTelephoneNumberType() {
			return telephoneNumberType;
		}
		
		@Override
		@RosettaAttribute("number")
		@RuneAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@Override
		@RosettaAttribute("telephoneNumberType")
		@RuneAttribute("telephoneNumberType")
		public TelephoneNumber.TelephoneNumberBuilder setTelephoneNumberType(TelephoneTypeEnum _telephoneNumberType) {
			this.telephoneNumberType = _telephoneNumberType == null ? null : _telephoneNumberType;
			return this;
		}
		
		@Override
		@RosettaAttribute("number")
		@RuneAttribute("number")
		public TelephoneNumber.TelephoneNumberBuilder setNumber(String _number) {
			this.number = _number == null ? null : _number;
			return this;
		}
		
		@Override
		public TelephoneNumber build() {
			return new TelephoneNumber.TelephoneNumberImpl(this);
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTelephoneNumberType()!=null) return true;
			if (getNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TelephoneNumber.TelephoneNumberBuilder o = (TelephoneNumber.TelephoneNumberBuilder) other;
			
			
			merger.mergeBasic(getTelephoneNumberType(), o.getTelephoneNumberType(), this::setTelephoneNumberType);
			merger.mergeBasic(getNumber(), o.getNumber(), this::setNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(telephoneNumberType, _that.getTelephoneNumberType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (telephoneNumberType != null ? telephoneNumberType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumberBuilder {" +
				"telephoneNumberType=" + this.telephoneNumberType + ", " +
				"number=" + this.number +
			'}';
		}
	}
}
