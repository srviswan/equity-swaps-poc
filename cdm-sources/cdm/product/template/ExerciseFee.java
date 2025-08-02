package cdm.product.template;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverImpl;
import cdm.observable.asset.Money;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder;
import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseFee.ExerciseFeeBuilder;
import cdm.product.template.ExerciseFee.ExerciseFeeBuilderImpl;
import cdm.product.template.ExerciseFee.ExerciseFeeImpl;
import cdm.product.template.meta.ExerciseFeeMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining the fee payable on exercise of an option. This fee may be defined as an amount or a percentage of the notional exercised. As a difference with FpML, it extends the BuyerSeller class.
 * @version 6.0.0
 */
@RosettaDataType(value="ExerciseFee", builder=ExerciseFee.ExerciseFeeBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ExerciseFee", model="Just another Rosetta model", builder=ExerciseFee.ExerciseFeeBuilderImpl.class, version="6.0.0")
public interface ExerciseFee extends PayerReceiver {

	ExerciseFeeMeta metaData = new ExerciseFeeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 */
	ReferenceWithMetaMoney getNotionalReference();
	/**
	 * The amount of fee to be paid on exercise. The fee currency is that of the referenced notional.
	 */
	BigDecimal getFeeAmount();
	/**
	 * A fee represented as a percentage of some referenced notional. A percentage of 5% would be represented as 0.05.
	 */
	BigDecimal getFeeRate();
	/**
	 * The date on which exercise fee(s) will be paid. It is specified as a relative date.
	 */
	RelativeDateOffset getFeePaymentDate();

	/*********************** Build Methods  ***********************/
	ExerciseFee build();
	
	ExerciseFee.ExerciseFeeBuilder toBuilder();
	
	static ExerciseFee.ExerciseFeeBuilder builder() {
		return new ExerciseFee.ExerciseFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseFee> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseFee> getType() {
		return ExerciseFee.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("payer"), CounterpartyRoleEnum.class, getPayer(), this);
		processor.processBasic(path.newSubPath("receiver"), CounterpartyRoleEnum.class, getReceiver(), this);
		processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoney.class, getNotionalReference());
		processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
		processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
		processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.class, getFeePaymentDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseFeeBuilder extends ExerciseFee, PayerReceiver.PayerReceiverBuilder {
		ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder getOrCreateNotionalReference();
		@Override
		ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder getNotionalReference();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate();
		@Override
		ExerciseFee.ExerciseFeeBuilder setPayer(CounterpartyRoleEnum payer);
		@Override
		ExerciseFee.ExerciseFeeBuilder setReceiver(CounterpartyRoleEnum receiver);
		ExerciseFee.ExerciseFeeBuilder setNotionalReference(ReferenceWithMetaMoney notionalReference);
		ExerciseFee.ExerciseFeeBuilder setNotionalReferenceValue(Money notionalReference);
		ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal feeAmount);
		ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal feeRate);
		ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset feePaymentDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("payer"), CounterpartyRoleEnum.class, getPayer(), this);
			processor.processBasic(path.newSubPath("receiver"), CounterpartyRoleEnum.class, getReceiver(), this);
			processRosetta(path.newSubPath("notionalReference"), processor, ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("feeAmount"), BigDecimal.class, getFeeAmount(), this);
			processor.processBasic(path.newSubPath("feeRate"), BigDecimal.class, getFeeRate(), this);
			processRosetta(path.newSubPath("feePaymentDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getFeePaymentDate());
		}
		

		ExerciseFee.ExerciseFeeBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseFee  ***********************/
	class ExerciseFeeImpl extends PayerReceiver.PayerReceiverImpl implements ExerciseFee {
		private final ReferenceWithMetaMoney notionalReference;
		private final BigDecimal feeAmount;
		private final BigDecimal feeRate;
		private final RelativeDateOffset feePaymentDate;
		
		protected ExerciseFeeImpl(ExerciseFee.ExerciseFeeBuilder builder) {
			super(builder);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.feeAmount = builder.getFeeAmount();
			this.feeRate = builder.getFeeRate();
			this.feePaymentDate = ofNullable(builder.getFeePaymentDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@RuneAttribute("notionalReference")
		public ReferenceWithMetaMoney getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		@RuneAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		@RuneAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@RuneAttribute("feePaymentDate")
		public RelativeDateOffset getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public ExerciseFee build() {
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			ExerciseFee.ExerciseFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseFee.ExerciseFeeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getFeeAmount()).ifPresent(builder::setFeeAmount);
			ofNullable(getFeeRate()).ifPresent(builder::setFeeRate);
			ofNullable(getFeePaymentDate()).ifPresent(builder::setFeePaymentDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFee {" +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExerciseFee  ***********************/
	class ExerciseFeeBuilderImpl extends PayerReceiver.PayerReceiverBuilderImpl implements ExerciseFee.ExerciseFeeBuilder {
	
		protected ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder notionalReference;
		protected BigDecimal feeAmount;
		protected BigDecimal feeRate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder feePaymentDate;
		
		@Override
		@RosettaAttribute("notionalReference")
		@RuneAttribute("notionalReference")
		public ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder getOrCreateNotionalReference() {
			ReferenceWithMetaMoney.ReferenceWithMetaMoneyBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = ReferenceWithMetaMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		@RuneAttribute("feeAmount")
		public BigDecimal getFeeAmount() {
			return feeAmount;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		@RuneAttribute("feeRate")
		public BigDecimal getFeeRate() {
			return feeRate;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@RuneAttribute("feePaymentDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getFeePaymentDate() {
			return feePaymentDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateFeePaymentDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (feePaymentDate!=null) {
				result = feePaymentDate;
			}
			else {
				result = feePaymentDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payer")
		@RuneAttribute("payer")
		public ExerciseFee.ExerciseFeeBuilder setPayer(CounterpartyRoleEnum _payer) {
			this.payer = _payer == null ? null : _payer;
			return this;
		}
		
		@Override
		@RosettaAttribute("receiver")
		@RuneAttribute("receiver")
		public ExerciseFee.ExerciseFeeBuilder setReceiver(CounterpartyRoleEnum _receiver) {
			this.receiver = _receiver == null ? null : _receiver;
			return this;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@RuneAttribute("notionalReference")
		public ExerciseFee.ExerciseFeeBuilder setNotionalReference(ReferenceWithMetaMoney _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder setNotionalReferenceValue(Money _notionalReference) {
			this.getOrCreateNotionalReference().setValue(_notionalReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("feeAmount")
		@RuneAttribute("feeAmount")
		public ExerciseFee.ExerciseFeeBuilder setFeeAmount(BigDecimal _feeAmount) {
			this.feeAmount = _feeAmount == null ? null : _feeAmount;
			return this;
		}
		
		@Override
		@RosettaAttribute("feeRate")
		@RuneAttribute("feeRate")
		public ExerciseFee.ExerciseFeeBuilder setFeeRate(BigDecimal _feeRate) {
			this.feeRate = _feeRate == null ? null : _feeRate;
			return this;
		}
		
		@Override
		@RosettaAttribute("feePaymentDate")
		@RuneAttribute("feePaymentDate")
		public ExerciseFee.ExerciseFeeBuilder setFeePaymentDate(RelativeDateOffset _feePaymentDate) {
			this.feePaymentDate = _feePaymentDate == null ? null : _feePaymentDate.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseFee build() {
			return new ExerciseFee.ExerciseFeeImpl(this);
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder prune() {
			super.prune();
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (feePaymentDate!=null && !feePaymentDate.prune().hasData()) feePaymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getFeeAmount()!=null) return true;
			if (getFeeRate()!=null) return true;
			if (getFeePaymentDate()!=null && getFeePaymentDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseFee.ExerciseFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExerciseFee.ExerciseFeeBuilder o = (ExerciseFee.ExerciseFeeBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getFeePaymentDate(), o.getFeePaymentDate(), this::setFeePaymentDate);
			
			merger.mergeBasic(getFeeAmount(), o.getFeeAmount(), this::setFeeAmount);
			merger.mergeBasic(getFeeRate(), o.getFeeRate(), this::setFeeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExerciseFee _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(feeAmount, _that.getFeeAmount())) return false;
			if (!Objects.equals(feeRate, _that.getFeeRate())) return false;
			if (!Objects.equals(feePaymentDate, _that.getFeePaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (feeAmount != null ? feeAmount.hashCode() : 0);
			_result = 31 * _result + (feeRate != null ? feeRate.hashCode() : 0);
			_result = 31 * _result + (feePaymentDate != null ? feePaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseFeeBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"feeAmount=" + this.feeAmount + ", " +
				"feeRate=" + this.feeRate + ", " +
				"feePaymentDate=" + this.feePaymentDate +
			'}' + " " + super.toString();
		}
	}
}
