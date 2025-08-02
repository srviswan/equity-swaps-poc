package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilder;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.product.common.settlement.AssetFlowBase;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilder;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilderImpl;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseImpl;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.common.settlement.Cashflow.CashflowBuilderImpl;
import cdm.product.common.settlement.Cashflow.CashflowImpl;
import cdm.product.common.settlement.CashflowType;
import cdm.product.common.settlement.CashflowType.CashflowTypeBuilder;
import cdm.product.common.settlement.PaymentDiscounting;
import cdm.product.common.settlement.PaymentDiscounting.PaymentDiscountingBuilder;
import cdm.product.common.settlement.meta.CashflowMeta;
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
 * Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version 6.0.0
 */
@RosettaDataType(value="Cashflow", builder=Cashflow.CashflowBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Cashflow", model="Just another Rosetta model", builder=Cashflow.CashflowBuilderImpl.class, version="6.0.0")
public interface Cashflow extends AssetFlowBase {

	CashflowMeta metaData = new CashflowMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.
	 */
	PayerReceiver getPayerReceiver();
	/**
	 * The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
	 */
	CashflowType getCashflowType();
	/**
	 * FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
	 */
	PaymentDiscounting getPaymentDiscounting();

	/*********************** Build Methods  ***********************/
	Cashflow build();
	
	Cashflow.CashflowBuilder toBuilder();
	
	static Cashflow.CashflowBuilder builder() {
		return new Cashflow.CashflowBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Cashflow> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Cashflow> getType() {
		return Cashflow.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.class, getQuantity());
		processRosetta(path.newSubPath("asset"), processor, Asset.class, getAsset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.class, getCashflowType());
		processRosetta(path.newSubPath("paymentDiscounting"), processor, PaymentDiscounting.class, getPaymentDiscounting());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowBuilder extends Cashflow, AssetFlowBase.AssetFlowBaseBuilder {
		PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver();
		@Override
		PayerReceiver.PayerReceiverBuilder getPayerReceiver();
		CashflowType.CashflowTypeBuilder getOrCreateCashflowType();
		@Override
		CashflowType.CashflowTypeBuilder getCashflowType();
		PaymentDiscounting.PaymentDiscountingBuilder getOrCreatePaymentDiscounting();
		@Override
		PaymentDiscounting.PaymentDiscountingBuilder getPaymentDiscounting();
		@Override
		Cashflow.CashflowBuilder setQuantity(NonNegativeQuantity quantity);
		@Override
		Cashflow.CashflowBuilder setAsset(Asset asset);
		@Override
		Cashflow.CashflowBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate settlementDate);
		Cashflow.CashflowBuilder setPayerReceiver(PayerReceiver payerReceiver);
		Cashflow.CashflowBuilder setCashflowType(CashflowType cashflowType);
		Cashflow.CashflowBuilder setPaymentDiscounting(PaymentDiscounting paymentDiscounting);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.NonNegativeQuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("asset"), processor, Asset.AssetBuilder.class, getAsset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.CashflowTypeBuilder.class, getCashflowType());
			processRosetta(path.newSubPath("paymentDiscounting"), processor, PaymentDiscounting.PaymentDiscountingBuilder.class, getPaymentDiscounting());
		}
		

		Cashflow.CashflowBuilder prune();
	}

	/*********************** Immutable Implementation of Cashflow  ***********************/
	class CashflowImpl extends AssetFlowBase.AssetFlowBaseImpl implements Cashflow {
		private final PayerReceiver payerReceiver;
		private final CashflowType cashflowType;
		private final PaymentDiscounting paymentDiscounting;
		
		protected CashflowImpl(Cashflow.CashflowBuilder builder) {
			super(builder);
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.cashflowType = ofNullable(builder.getCashflowType()).map(f->f.build()).orElse(null);
			this.paymentDiscounting = ofNullable(builder.getPaymentDiscounting()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public PayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@RuneAttribute("cashflowType")
		public CashflowType getCashflowType() {
			return cashflowType;
		}
		
		@Override
		@RosettaAttribute("paymentDiscounting")
		@RuneAttribute("paymentDiscounting")
		public PaymentDiscounting getPaymentDiscounting() {
			return paymentDiscounting;
		}
		
		@Override
		public Cashflow build() {
			return this;
		}
		
		@Override
		public Cashflow.CashflowBuilder toBuilder() {
			Cashflow.CashflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cashflow.CashflowBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
			ofNullable(getPaymentDiscounting()).ifPresent(builder::setPaymentDiscounting);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cashflow _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(paymentDiscounting, _that.getPaymentDiscounting())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			_result = 31 * _result + (paymentDiscounting != null ? paymentDiscounting.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cashflow {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"paymentDiscounting=" + this.paymentDiscounting +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Cashflow  ***********************/
	class CashflowBuilderImpl extends AssetFlowBase.AssetFlowBaseBuilderImpl implements Cashflow.CashflowBuilder {
	
		protected PayerReceiver.PayerReceiverBuilder payerReceiver;
		protected CashflowType.CashflowTypeBuilder cashflowType;
		protected PaymentDiscounting.PaymentDiscountingBuilder paymentDiscounting;
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public PayerReceiver.PayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver() {
			PayerReceiver.PayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@RuneAttribute("cashflowType")
		public CashflowType.CashflowTypeBuilder getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder getOrCreateCashflowType() {
			CashflowType.CashflowTypeBuilder result;
			if (cashflowType!=null) {
				result = cashflowType;
			}
			else {
				result = cashflowType = CashflowType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDiscounting")
		@RuneAttribute("paymentDiscounting")
		public PaymentDiscounting.PaymentDiscountingBuilder getPaymentDiscounting() {
			return paymentDiscounting;
		}
		
		@Override
		public PaymentDiscounting.PaymentDiscountingBuilder getOrCreatePaymentDiscounting() {
			PaymentDiscounting.PaymentDiscountingBuilder result;
			if (paymentDiscounting!=null) {
				result = paymentDiscounting;
			}
			else {
				result = paymentDiscounting = PaymentDiscounting.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public Cashflow.CashflowBuilder setQuantity(NonNegativeQuantity _quantity) {
			this.quantity = _quantity == null ? null : _quantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("asset")
		@RuneAttribute("asset")
		public Cashflow.CashflowBuilder setAsset(Asset _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@RuneAttribute("settlementDate")
		public Cashflow.CashflowBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public Cashflow.CashflowBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@RuneAttribute("cashflowType")
		public Cashflow.CashflowBuilder setCashflowType(CashflowType _cashflowType) {
			this.cashflowType = _cashflowType == null ? null : _cashflowType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("paymentDiscounting")
		@RuneAttribute("paymentDiscounting")
		public Cashflow.CashflowBuilder setPaymentDiscounting(PaymentDiscounting _paymentDiscounting) {
			this.paymentDiscounting = _paymentDiscounting == null ? null : _paymentDiscounting.toBuilder();
			return this;
		}
		
		@Override
		public Cashflow build() {
			return new Cashflow.CashflowImpl(this);
		}
		
		@Override
		public Cashflow.CashflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflow.CashflowBuilder prune() {
			super.prune();
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (cashflowType!=null && !cashflowType.prune().hasData()) cashflowType = null;
			if (paymentDiscounting!=null && !paymentDiscounting.prune().hasData()) paymentDiscounting = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getCashflowType()!=null && getCashflowType().hasData()) return true;
			if (getPaymentDiscounting()!=null && getPaymentDiscounting().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflow.CashflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Cashflow.CashflowBuilder o = (Cashflow.CashflowBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			merger.mergeRosetta(getPaymentDiscounting(), o.getPaymentDiscounting(), this::setPaymentDiscounting);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cashflow _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(paymentDiscounting, _that.getPaymentDiscounting())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			_result = 31 * _result + (paymentDiscounting != null ? paymentDiscounting.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowBuilder {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"paymentDiscounting=" + this.paymentDiscounting +
			'}' + " " + super.toString();
		}
	}
}
