package cdm.base.staticdata.party;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl;
import cdm.base.staticdata.party.meta.PartyReferencePayerReceiverMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 * @version 6.0.0
 */
@RosettaDataType(value="PartyReferencePayerReceiver", builder=PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PartyReferencePayerReceiver", model="Just another Rosetta model", builder=PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl.class, version="6.0.0")
public interface PartyReferencePayerReceiver extends RosettaModelObject {

	PartyReferencePayerReceiverMeta metaData = new PartyReferencePayerReceiverMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaParty getPayerPartyReference();
	/**
	 * A reference to the account responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaAccount getPayerAccountReference();
	/**
	 * The party that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaParty getReceiverPartyReference();
	/**
	 * A reference to the account that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaAccount getReceiverAccountReference();

	/*********************** Build Methods  ***********************/
	PartyReferencePayerReceiver build();
	
	PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder();
	
	static PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder() {
		return new PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyReferencePayerReceiver> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyReferencePayerReceiver> getType() {
		return PartyReferencePayerReceiver.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccount.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccount.class, getReceiverAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyReferencePayerReceiverBuilder extends PartyReferencePayerReceiver, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePayerPartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPayerPartyReference();
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getOrCreatePayerAccountReference();
		@Override
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getPayerAccountReference();
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReceiverPartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReceiverPartyReference();
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getOrCreateReceiverAccountReference();
		@Override
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getReceiverAccountReference();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReferenceValue(Account payerAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReferenceValue(Account receiverAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder.class, getReceiverAccountReference());
		}
		

		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder prune();
	}

	/*********************** Immutable Implementation of PartyReferencePayerReceiver  ***********************/
	class PartyReferencePayerReceiverImpl implements PartyReferencePayerReceiver {
		private final ReferenceWithMetaParty payerPartyReference;
		private final ReferenceWithMetaAccount payerAccountReference;
		private final ReferenceWithMetaParty receiverPartyReference;
		private final ReferenceWithMetaAccount receiverAccountReference;
		
		protected PartyReferencePayerReceiverImpl(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@RuneAttribute("payerPartyReference")
		public ReferenceWithMetaParty getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@RuneAttribute("payerAccountReference")
		public ReferenceWithMetaAccount getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@RuneAttribute("receiverPartyReference")
		public ReferenceWithMetaParty getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@RuneAttribute("receiverAccountReference")
		public ReferenceWithMetaAccount getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public PartyReferencePayerReceiver build() {
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyReferencePayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyReferencePayerReceiver {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyReferencePayerReceiver  ***********************/
	class PartyReferencePayerReceiverBuilderImpl implements PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder payerPartyReference;
		protected ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder payerAccountReference;
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder receiverPartyReference;
		protected ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder receiverAccountReference;
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@RuneAttribute("payerPartyReference")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePayerPartyReference() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@RuneAttribute("payerAccountReference")
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getOrCreatePayerAccountReference() {
			ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@RuneAttribute("receiverPartyReference")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateReceiverPartyReference() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@RuneAttribute("receiverAccountReference")
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder getOrCreateReceiverAccountReference() {
			ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@RuneAttribute("payerPartyReference")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReferenceValue(Party _payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(_payerPartyReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@RuneAttribute("payerAccountReference")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReference(ReferenceWithMetaAccount _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReferenceValue(Account _payerAccountReference) {
			this.getOrCreatePayerAccountReference().setValue(_payerAccountReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@RuneAttribute("receiverPartyReference")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReferenceValue(Party _receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(_receiverPartyReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@RuneAttribute("receiverAccountReference")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReference(ReferenceWithMetaAccount _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReferenceValue(Account _receiverAccountReference) {
			this.getOrCreateReceiverAccountReference().setValue(_receiverAccountReference);
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver build() {
			return new PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl(this);
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder o = (PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyReferencePayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyReferencePayerReceiverBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference +
			'}';
		}
	}
}
