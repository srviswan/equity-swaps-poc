package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.DebtEconomics;
import cdm.base.staticdata.asset.common.DebtEconomics.DebtEconomicsBuilder;
import cdm.base.staticdata.asset.common.DebtEconomics.DebtEconomicsBuilderImpl;
import cdm.base.staticdata.asset.common.DebtEconomics.DebtEconomicsImpl;
import cdm.base.staticdata.asset.common.DebtInterestEnum;
import cdm.base.staticdata.asset.common.DebtPrincipalEnum;
import cdm.base.staticdata.asset.common.DebtSeniorityEnum;
import cdm.base.staticdata.asset.common.meta.DebtEconomicsMeta;
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
 * Specifies selected economics of a debt instrument.
 * @version 6.0.0
 */
@RosettaDataType(value="DebtEconomics", builder=DebtEconomics.DebtEconomicsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DebtEconomics", model="Just another Rosetta model", builder=DebtEconomics.DebtEconomicsBuilderImpl.class, version="6.0.0")
public interface DebtEconomics extends RosettaModelObject {

	DebtEconomicsMeta metaData = new DebtEconomicsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
	 */
	DebtSeniorityEnum getDebtSeniority();
	/**
	 * Specifies the general rule for periodic interest rate payment.
	 */
	DebtInterestEnum getDebtInterest();
	/**
	 * Specifies the general rule for repayment of principal.
	 */
	DebtPrincipalEnum getDebtPrincipal();

	/*********************** Build Methods  ***********************/
	DebtEconomics build();
	
	DebtEconomics.DebtEconomicsBuilder toBuilder();
	
	static DebtEconomics.DebtEconomicsBuilder builder() {
		return new DebtEconomics.DebtEconomicsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DebtEconomics> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DebtEconomics> getType() {
		return DebtEconomics.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("debtSeniority"), DebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("debtInterest"), DebtInterestEnum.class, getDebtInterest(), this);
		processor.processBasic(path.newSubPath("debtPrincipal"), DebtPrincipalEnum.class, getDebtPrincipal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DebtEconomicsBuilder extends DebtEconomics, RosettaModelObjectBuilder {
		DebtEconomics.DebtEconomicsBuilder setDebtSeniority(DebtSeniorityEnum debtSeniority);
		DebtEconomics.DebtEconomicsBuilder setDebtInterest(DebtInterestEnum debtInterest);
		DebtEconomics.DebtEconomicsBuilder setDebtPrincipal(DebtPrincipalEnum debtPrincipal);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("debtSeniority"), DebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("debtInterest"), DebtInterestEnum.class, getDebtInterest(), this);
			processor.processBasic(path.newSubPath("debtPrincipal"), DebtPrincipalEnum.class, getDebtPrincipal(), this);
		}
		

		DebtEconomics.DebtEconomicsBuilder prune();
	}

	/*********************** Immutable Implementation of DebtEconomics  ***********************/
	class DebtEconomicsImpl implements DebtEconomics {
		private final DebtSeniorityEnum debtSeniority;
		private final DebtInterestEnum debtInterest;
		private final DebtPrincipalEnum debtPrincipal;
		
		protected DebtEconomicsImpl(DebtEconomics.DebtEconomicsBuilder builder) {
			this.debtSeniority = builder.getDebtSeniority();
			this.debtInterest = builder.getDebtInterest();
			this.debtPrincipal = builder.getDebtPrincipal();
		}
		
		@Override
		@RosettaAttribute("debtSeniority")
		@RuneAttribute("debtSeniority")
		public DebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("debtInterest")
		@RuneAttribute("debtInterest")
		public DebtInterestEnum getDebtInterest() {
			return debtInterest;
		}
		
		@Override
		@RosettaAttribute("debtPrincipal")
		@RuneAttribute("debtPrincipal")
		public DebtPrincipalEnum getDebtPrincipal() {
			return debtPrincipal;
		}
		
		@Override
		public DebtEconomics build() {
			return this;
		}
		
		@Override
		public DebtEconomics.DebtEconomicsBuilder toBuilder() {
			DebtEconomics.DebtEconomicsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DebtEconomics.DebtEconomicsBuilder builder) {
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getDebtInterest()).ifPresent(builder::setDebtInterest);
			ofNullable(getDebtPrincipal()).ifPresent(builder::setDebtPrincipal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DebtEconomics _that = getType().cast(o);
		
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(debtInterest, _that.getDebtInterest())) return false;
			if (!Objects.equals(debtPrincipal, _that.getDebtPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtInterest != null ? debtInterest.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtPrincipal != null ? debtPrincipal.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DebtEconomics {" +
				"debtSeniority=" + this.debtSeniority + ", " +
				"debtInterest=" + this.debtInterest + ", " +
				"debtPrincipal=" + this.debtPrincipal +
			'}';
		}
	}

	/*********************** Builder Implementation of DebtEconomics  ***********************/
	class DebtEconomicsBuilderImpl implements DebtEconomics.DebtEconomicsBuilder {
	
		protected DebtSeniorityEnum debtSeniority;
		protected DebtInterestEnum debtInterest;
		protected DebtPrincipalEnum debtPrincipal;
		
		@Override
		@RosettaAttribute("debtSeniority")
		@RuneAttribute("debtSeniority")
		public DebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("debtInterest")
		@RuneAttribute("debtInterest")
		public DebtInterestEnum getDebtInterest() {
			return debtInterest;
		}
		
		@Override
		@RosettaAttribute("debtPrincipal")
		@RuneAttribute("debtPrincipal")
		public DebtPrincipalEnum getDebtPrincipal() {
			return debtPrincipal;
		}
		
		@Override
		@RosettaAttribute("debtSeniority")
		@RuneAttribute("debtSeniority")
		public DebtEconomics.DebtEconomicsBuilder setDebtSeniority(DebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@Override
		@RosettaAttribute("debtInterest")
		@RuneAttribute("debtInterest")
		public DebtEconomics.DebtEconomicsBuilder setDebtInterest(DebtInterestEnum _debtInterest) {
			this.debtInterest = _debtInterest == null ? null : _debtInterest;
			return this;
		}
		
		@Override
		@RosettaAttribute("debtPrincipal")
		@RuneAttribute("debtPrincipal")
		public DebtEconomics.DebtEconomicsBuilder setDebtPrincipal(DebtPrincipalEnum _debtPrincipal) {
			this.debtPrincipal = _debtPrincipal == null ? null : _debtPrincipal;
			return this;
		}
		
		@Override
		public DebtEconomics build() {
			return new DebtEconomics.DebtEconomicsImpl(this);
		}
		
		@Override
		public DebtEconomics.DebtEconomicsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DebtEconomics.DebtEconomicsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDebtSeniority()!=null) return true;
			if (getDebtInterest()!=null) return true;
			if (getDebtPrincipal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DebtEconomics.DebtEconomicsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DebtEconomics.DebtEconomicsBuilder o = (DebtEconomics.DebtEconomicsBuilder) other;
			
			
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getDebtInterest(), o.getDebtInterest(), this::setDebtInterest);
			merger.mergeBasic(getDebtPrincipal(), o.getDebtPrincipal(), this::setDebtPrincipal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DebtEconomics _that = getType().cast(o);
		
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(debtInterest, _that.getDebtInterest())) return false;
			if (!Objects.equals(debtPrincipal, _that.getDebtPrincipal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtInterest != null ? debtInterest.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtPrincipal != null ? debtPrincipal.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DebtEconomicsBuilder {" +
				"debtSeniority=" + this.debtSeniority + ", " +
				"debtInterest=" + this.debtInterest + ", " +
				"debtPrincipal=" + this.debtPrincipal +
			'}';
		}
	}
}
