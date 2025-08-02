package cdm.product.collateral;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.product.collateral.IndependentAmount;
import cdm.product.collateral.IndependentAmount.IndependentAmountBuilder;
import cdm.product.collateral.IndependentAmount.IndependentAmountBuilderImpl;
import cdm.product.collateral.IndependentAmount.IndependentAmountImpl;
import cdm.product.collateral.meta.IndependentAmountMeta;
import cdm.product.common.settlement.PaymentDetail;
import cdm.product.common.settlement.PaymentDetail.PaymentDetailBuilder;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class specifying the Independent Amount as the combination of a payer/receiver, a payment amount, a payment date and an associated payment calculation rule.
 * @version 6.0.0
 */
@RosettaDataType(value="IndependentAmount", builder=IndependentAmount.IndependentAmountBuilderImpl.class, version="6.0.0")
@RuneDataType(value="IndependentAmount", model="Just another Rosetta model", builder=IndependentAmount.IndependentAmountBuilderImpl.class, version="6.0.0")
public interface IndependentAmount extends PartyReferencePayerReceiver {

	IndependentAmountMeta metaData = new IndependentAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An attribute that specifies a payment as the combination of a payment amount, a payment date and an associated payment calculation rule.
	 */
	List<? extends PaymentDetail> getPaymentDetail();

	/*********************** Build Methods  ***********************/
	IndependentAmount build();
	
	IndependentAmount.IndependentAmountBuilder toBuilder();
	
	static IndependentAmount.IndependentAmountBuilder builder() {
		return new IndependentAmount.IndependentAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndependentAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndependentAmount> getType() {
		return IndependentAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccount.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccount.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.class, getPaymentDetail());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndependentAmountBuilder extends IndependentAmount, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder {
		PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index);
		@Override
		List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail();
		@Override
		IndependentAmount.IndependentAmountBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setPayerAccountReferenceValue(Account payerAccountReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference);
		@Override
		IndependentAmount.IndependentAmountBuilder setReceiverAccountReferenceValue(Account receiverAccountReference);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail, int _idx);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetail);
		IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetail);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.PaymentDetailBuilder.class, getPaymentDetail());
		}
		

		IndependentAmount.IndependentAmountBuilder prune();
	}

	/*********************** Immutable Implementation of IndependentAmount  ***********************/
	class IndependentAmountImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl implements IndependentAmount {
		private final List<? extends PaymentDetail> paymentDetail;
		
		protected IndependentAmountImpl(IndependentAmount.IndependentAmountBuilder builder) {
			super(builder);
			this.paymentDetail = ofNullable(builder.getPaymentDetail()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDetail")
		@RuneAttribute("paymentDetail")
		public List<? extends PaymentDetail> getPaymentDetail() {
			return paymentDetail;
		}
		
		@Override
		public IndependentAmount build() {
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			IndependentAmount.IndependentAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndependentAmount.IndependentAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDetail()).ifPresent(builder::setPaymentDetail);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmount {" +
				"paymentDetail=" + this.paymentDetail +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IndependentAmount  ***********************/
	class IndependentAmountBuilderImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl implements IndependentAmount.IndependentAmountBuilder {
	
		protected List<PaymentDetail.PaymentDetailBuilder> paymentDetail = new ArrayList<>();
		
		@Override
		@RosettaAttribute("paymentDetail")
		@RuneAttribute("paymentDetail")
		public List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail() {
			return paymentDetail;
		}
		
		@Override
		public PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index) {
		
			if (paymentDetail==null) {
				this.paymentDetail = new ArrayList<>();
			}
			PaymentDetail.PaymentDetailBuilder result;
			return getIndex(paymentDetail, _index, () -> {
						PaymentDetail.PaymentDetailBuilder newPaymentDetail = PaymentDetail.builder();
						return newPaymentDetail;
					});
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@RuneAttribute("payerPartyReference")
		public IndependentAmount.IndependentAmountBuilder setPayerPartyReference(ReferenceWithMetaParty _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerPartyReferenceValue(Party _payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(_payerPartyReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@RuneAttribute("payerAccountReference")
		public IndependentAmount.IndependentAmountBuilder setPayerAccountReference(ReferenceWithMetaAccount _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerAccountReferenceValue(Account _payerAccountReference) {
			this.getOrCreatePayerAccountReference().setValue(_payerAccountReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@RuneAttribute("receiverPartyReference")
		public IndependentAmount.IndependentAmountBuilder setReceiverPartyReference(ReferenceWithMetaParty _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverPartyReferenceValue(Party _receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(_receiverPartyReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@RuneAttribute("receiverAccountReference")
		public IndependentAmount.IndependentAmountBuilder setReceiverAccountReference(ReferenceWithMetaAccount _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverAccountReferenceValue(Account _receiverAccountReference) {
			this.getOrCreateReceiverAccountReference().setValue(_receiverAccountReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("paymentDetail")
		@RuneAttribute("paymentDetail")
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail _paymentDetail) {
			if (_paymentDetail != null) {
				this.paymentDetail.add(_paymentDetail.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail _paymentDetail, int _idx) {
			getIndex(this.paymentDetail, _idx, () -> _paymentDetail.toBuilder());
			return this;
		}
		
		@Override 
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails != null) {
				for (final PaymentDetail toAdd : paymentDetails) {
					this.paymentDetail.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("paymentDetail")
		public IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails == null) {
				this.paymentDetail = new ArrayList<>();
			} else {
				this.paymentDetail = paymentDetails.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IndependentAmount build() {
			return new IndependentAmount.IndependentAmountImpl(this);
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder prune() {
			super.prune();
			paymentDetail = paymentDetail.stream().filter(b->b!=null).<PaymentDetail.PaymentDetailBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDetail()!=null && getPaymentDetail().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IndependentAmount.IndependentAmountBuilder o = (IndependentAmount.IndependentAmountBuilder) other;
			
			merger.mergeRosetta(getPaymentDetail(), o.getPaymentDetail(), this::getOrCreatePaymentDetail);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmountBuilder {" +
				"paymentDetail=" + this.paymentDetail +
			'}' + " " + super.toString();
		}
	}
}
