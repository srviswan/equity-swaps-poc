package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Instrument.InstrumentBuilder;
import cdm.base.staticdata.asset.common.Instrument.InstrumentBuilderImpl;
import cdm.base.staticdata.asset.common.Instrument.InstrumentImpl;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilder;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Loan.LoanBuilder;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Security.SecurityBuilder;
import cdm.base.staticdata.asset.common.meta.InstrumentMeta;
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
 * A type of Asset that is issued by one party to one or more others.
 * @version 6.0.0
 */
@RosettaDataType(value="Instrument", builder=Instrument.InstrumentBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Instrument", model="Just another Rosetta model", builder=Instrument.InstrumentBuilderImpl.class, version="6.0.0")
public interface Instrument extends RosettaModelObject {

	InstrumentMeta metaData = new InstrumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A securitized derivative on another asset that is created by an exchange.
	 */
	ListedDerivative getListedDerivative();
	/**
	 * An Asset that represents a loan or borrow obligation.
	 */
	Loan getLoan();
	/**
	 * An Asset that is issued by a party to be held by or transferred to others.
	 */
	Security getSecurity();

	/*********************** Build Methods  ***********************/
	Instrument build();
	
	Instrument.InstrumentBuilder toBuilder();
	
	static Instrument.InstrumentBuilder builder() {
		return new Instrument.InstrumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Instrument> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Instrument> getType() {
		return Instrument.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ListedDerivative"), processor, ListedDerivative.class, getListedDerivative());
		processRosetta(path.newSubPath("Loan"), processor, Loan.class, getLoan());
		processRosetta(path.newSubPath("Security"), processor, Security.class, getSecurity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentBuilder extends Instrument, RosettaModelObjectBuilder {
		ListedDerivative.ListedDerivativeBuilder getOrCreateListedDerivative();
		@Override
		ListedDerivative.ListedDerivativeBuilder getListedDerivative();
		Loan.LoanBuilder getOrCreateLoan();
		@Override
		Loan.LoanBuilder getLoan();
		Security.SecurityBuilder getOrCreateSecurity();
		@Override
		Security.SecurityBuilder getSecurity();
		Instrument.InstrumentBuilder setListedDerivative(ListedDerivative _ListedDerivative);
		Instrument.InstrumentBuilder setLoan(Loan _Loan);
		Instrument.InstrumentBuilder setSecurity(Security _Security);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ListedDerivative"), processor, ListedDerivative.ListedDerivativeBuilder.class, getListedDerivative());
			processRosetta(path.newSubPath("Loan"), processor, Loan.LoanBuilder.class, getLoan());
			processRosetta(path.newSubPath("Security"), processor, Security.SecurityBuilder.class, getSecurity());
		}
		

		Instrument.InstrumentBuilder prune();
	}

	/*********************** Immutable Implementation of Instrument  ***********************/
	class InstrumentImpl implements Instrument {
		private final ListedDerivative listedDerivative;
		private final Loan loan;
		private final Security security;
		
		protected InstrumentImpl(Instrument.InstrumentBuilder builder) {
			this.listedDerivative = ofNullable(builder.getListedDerivative()).map(f->f.build()).orElse(null);
			this.loan = ofNullable(builder.getLoan()).map(f->f.build()).orElse(null);
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ListedDerivative")
		@RuneAttribute("ListedDerivative")
		public ListedDerivative getListedDerivative() {
			return listedDerivative;
		}
		
		@Override
		@RosettaAttribute("Loan")
		@RuneAttribute("Loan")
		public Loan getLoan() {
			return loan;
		}
		
		@Override
		@RosettaAttribute("Security")
		@RuneAttribute("Security")
		public Security getSecurity() {
			return security;
		}
		
		@Override
		public Instrument build() {
			return this;
		}
		
		@Override
		public Instrument.InstrumentBuilder toBuilder() {
			Instrument.InstrumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Instrument.InstrumentBuilder builder) {
			ofNullable(getListedDerivative()).ifPresent(builder::setListedDerivative);
			ofNullable(getLoan()).ifPresent(builder::setLoan);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Instrument _that = getType().cast(o);
		
			if (!Objects.equals(listedDerivative, _that.getListedDerivative())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (listedDerivative != null ? listedDerivative.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Instrument {" +
				"ListedDerivative=" + this.listedDerivative + ", " +
				"Loan=" + this.loan + ", " +
				"Security=" + this.security +
			'}';
		}
	}

	/*********************** Builder Implementation of Instrument  ***********************/
	class InstrumentBuilderImpl implements Instrument.InstrumentBuilder {
	
		protected ListedDerivative.ListedDerivativeBuilder listedDerivative;
		protected Loan.LoanBuilder loan;
		protected Security.SecurityBuilder security;
		
		@Override
		@RosettaAttribute("ListedDerivative")
		@RuneAttribute("ListedDerivative")
		public ListedDerivative.ListedDerivativeBuilder getListedDerivative() {
			return listedDerivative;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder getOrCreateListedDerivative() {
			ListedDerivative.ListedDerivativeBuilder result;
			if (listedDerivative!=null) {
				result = listedDerivative;
			}
			else {
				result = listedDerivative = ListedDerivative.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Loan")
		@RuneAttribute("Loan")
		public Loan.LoanBuilder getLoan() {
			return loan;
		}
		
		@Override
		public Loan.LoanBuilder getOrCreateLoan() {
			Loan.LoanBuilder result;
			if (loan!=null) {
				result = loan;
			}
			else {
				result = loan = Loan.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Security")
		@RuneAttribute("Security")
		public Security.SecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public Security.SecurityBuilder getOrCreateSecurity() {
			Security.SecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = Security.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ListedDerivative")
		@RuneAttribute("ListedDerivative")
		public Instrument.InstrumentBuilder setListedDerivative(ListedDerivative _listedDerivative) {
			this.listedDerivative = _listedDerivative == null ? null : _listedDerivative.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Loan")
		@RuneAttribute("Loan")
		public Instrument.InstrumentBuilder setLoan(Loan _loan) {
			this.loan = _loan == null ? null : _loan.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Security")
		@RuneAttribute("Security")
		public Instrument.InstrumentBuilder setSecurity(Security _security) {
			this.security = _security == null ? null : _security.toBuilder();
			return this;
		}
		
		@Override
		public Instrument build() {
			return new Instrument.InstrumentImpl(this);
		}
		
		@Override
		public Instrument.InstrumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Instrument.InstrumentBuilder prune() {
			if (listedDerivative!=null && !listedDerivative.prune().hasData()) listedDerivative = null;
			if (loan!=null && !loan.prune().hasData()) loan = null;
			if (security!=null && !security.prune().hasData()) security = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getListedDerivative()!=null && getListedDerivative().hasData()) return true;
			if (getLoan()!=null && getLoan().hasData()) return true;
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Instrument.InstrumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Instrument.InstrumentBuilder o = (Instrument.InstrumentBuilder) other;
			
			merger.mergeRosetta(getListedDerivative(), o.getListedDerivative(), this::setListedDerivative);
			merger.mergeRosetta(getLoan(), o.getLoan(), this::setLoan);
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Instrument _that = getType().cast(o);
		
			if (!Objects.equals(listedDerivative, _that.getListedDerivative())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (listedDerivative != null ? listedDerivative.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentBuilder {" +
				"ListedDerivative=" + this.listedDerivative + ", " +
				"Loan=" + this.loan + ", " +
				"Security=" + this.security +
			'}';
		}
	}
}
