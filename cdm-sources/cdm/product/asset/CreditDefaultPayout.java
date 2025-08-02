package cdm.product.asset;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import cdm.observable.asset.TransactedPrice;
import cdm.observable.asset.TransactedPrice.TransactedPriceBuilder;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.CreditDefaultPayout.CreditDefaultPayoutBuilder;
import cdm.product.asset.CreditDefaultPayout.CreditDefaultPayoutBuilderImpl;
import cdm.product.asset.CreditDefaultPayout.CreditDefaultPayoutImpl;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.GeneralTerms.GeneralTermsBuilder;
import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ProtectionTerms.ProtectionTermsBuilder;
import cdm.product.asset.meta.CreditDefaultPayoutMeta;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.PrincipalPayments.PrincipalPaymentsBuilder;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity.ResolvablePriceQuantityBuilder;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTerms.SettlementTermsBuilder;
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
 *  The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version 6.0.0
 */
@RosettaDataType(value="CreditDefaultPayout", builder=CreditDefaultPayout.CreditDefaultPayoutBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CreditDefaultPayout", model="Just another Rosetta model", builder=CreditDefaultPayout.CreditDefaultPayoutBuilderImpl.class, version="6.0.0")
public interface CreditDefaultPayout extends PayoutBase {

	CreditDefaultPayoutMeta metaData = new CreditDefaultPayoutMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
	 */
	GeneralTerms getGeneralTerms();
	/**
	 * Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
	 */
	List<? extends ProtectionTerms> getProtectionTerms();
	/**
	 * The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
	 */
	TransactedPrice getTransactedPrice();

	/*********************** Build Methods  ***********************/
	CreditDefaultPayout build();
	
	CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder();
	
	static CreditDefaultPayout.CreditDefaultPayoutBuilder builder() {
		return new CreditDefaultPayout.CreditDefaultPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultPayout> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDefaultPayout> getType() {
		return CreditDefaultPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.class, getPrincipalPayment());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.class, getGeneralTerms());
		processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.class, getProtectionTerms());
		processRosetta(path.newSubPath("transactedPrice"), processor, TransactedPrice.class, getTransactedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultPayoutBuilder extends CreditDefaultPayout, PayoutBase.PayoutBaseBuilder {
		GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms();
		@Override
		GeneralTerms.GeneralTermsBuilder getGeneralTerms();
		ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index);
		@Override
		List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms();
		TransactedPrice.TransactedPriceBuilder getOrCreateTransactedPrice();
		@Override
		TransactedPrice.TransactedPriceBuilder getTransactedPrice();
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder setPriceQuantity(ResolvablePriceQuantity priceQuantity);
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder setPrincipalPayment(PrincipalPayments principalPayment);
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setGeneralTerms(GeneralTerms generalTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms, int _idx);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setTransactedPrice(TransactedPrice transactedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("priceQuantity"), processor, ResolvablePriceQuantity.ResolvablePriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("principalPayment"), processor, PrincipalPayments.PrincipalPaymentsBuilder.class, getPrincipalPayment());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.GeneralTermsBuilder.class, getGeneralTerms());
			processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.ProtectionTermsBuilder.class, getProtectionTerms());
			processRosetta(path.newSubPath("transactedPrice"), processor, TransactedPrice.TransactedPriceBuilder.class, getTransactedPrice());
		}
		

		CreditDefaultPayout.CreditDefaultPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultPayout  ***********************/
	class CreditDefaultPayoutImpl extends PayoutBase.PayoutBaseImpl implements CreditDefaultPayout {
		private final GeneralTerms generalTerms;
		private final List<? extends ProtectionTerms> protectionTerms;
		private final TransactedPrice transactedPrice;
		
		protected CreditDefaultPayoutImpl(CreditDefaultPayout.CreditDefaultPayoutBuilder builder) {
			super(builder);
			this.generalTerms = ofNullable(builder.getGeneralTerms()).map(f->f.build()).orElse(null);
			this.protectionTerms = ofNullable(builder.getProtectionTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transactedPrice = ofNullable(builder.getTransactedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("generalTerms")
		@RuneAttribute("generalTerms")
		public GeneralTerms getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		@RuneAttribute("protectionTerms")
		public List<? extends ProtectionTerms> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		@RosettaAttribute("transactedPrice")
		@RuneAttribute("transactedPrice")
		public TransactedPrice getTransactedPrice() {
			return transactedPrice;
		}
		
		@Override
		public CreditDefaultPayout build() {
			return this;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultPayout.CreditDefaultPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGeneralTerms()).ifPresent(builder::setGeneralTerms);
			ofNullable(getProtectionTerms()).ifPresent(builder::setProtectionTerms);
			ofNullable(getTransactedPrice()).ifPresent(builder::setTransactedPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultPayout _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!Objects.equals(transactedPrice, _that.getTransactedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (transactedPrice != null ? transactedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultPayout {" +
				"generalTerms=" + this.generalTerms + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"transactedPrice=" + this.transactedPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditDefaultPayout  ***********************/
	class CreditDefaultPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl implements CreditDefaultPayout.CreditDefaultPayoutBuilder {
	
		protected GeneralTerms.GeneralTermsBuilder generalTerms;
		protected List<ProtectionTerms.ProtectionTermsBuilder> protectionTerms = new ArrayList<>();
		protected TransactedPrice.TransactedPriceBuilder transactedPrice;
		
		@Override
		@RosettaAttribute("generalTerms")
		@RuneAttribute("generalTerms")
		public GeneralTerms.GeneralTermsBuilder getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms() {
			GeneralTerms.GeneralTermsBuilder result;
			if (generalTerms!=null) {
				result = generalTerms;
			}
			else {
				result = generalTerms = GeneralTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		@RuneAttribute("protectionTerms")
		public List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index) {
		
			if (protectionTerms==null) {
				this.protectionTerms = new ArrayList<>();
			}
			ProtectionTerms.ProtectionTermsBuilder result;
			return getIndex(protectionTerms, _index, () -> {
						ProtectionTerms.ProtectionTermsBuilder newProtectionTerms = ProtectionTerms.builder();
						return newProtectionTerms;
					});
		}
		
		@Override
		@RosettaAttribute("transactedPrice")
		@RuneAttribute("transactedPrice")
		public TransactedPrice.TransactedPriceBuilder getTransactedPrice() {
			return transactedPrice;
		}
		
		@Override
		public TransactedPrice.TransactedPriceBuilder getOrCreateTransactedPrice() {
			TransactedPrice.TransactedPriceBuilder result;
			if (transactedPrice!=null) {
				result = transactedPrice;
			}
			else {
				result = transactedPrice = TransactedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setPayerReceiver(PayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setPriceQuantity(ResolvablePriceQuantity _priceQuantity) {
			this.priceQuantity = _priceQuantity == null ? null : _priceQuantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("principalPayment")
		@RuneAttribute("principalPayment")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setPrincipalPayment(PrincipalPayments _principalPayment) {
			this.principalPayment = _principalPayment == null ? null : _principalPayment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@RuneAttribute("settlementTerms")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("generalTerms")
		@RuneAttribute("generalTerms")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setGeneralTerms(GeneralTerms _generalTerms) {
			this.generalTerms = _generalTerms == null ? null : _generalTerms.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("protectionTerms")
		@RuneAttribute("protectionTerms")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms _protectionTerms) {
			if (_protectionTerms != null) {
				this.protectionTerms.add(_protectionTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms _protectionTerms, int _idx) {
			getIndex(this.protectionTerms, _idx, () -> _protectionTerms.toBuilder());
			return this;
		}
		
		@Override 
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss != null) {
				for (final ProtectionTerms toAdd : protectionTermss) {
					this.protectionTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("protectionTerms")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss == null) {
				this.protectionTerms = new ArrayList<>();
			} else {
				this.protectionTerms = protectionTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("transactedPrice")
		@RuneAttribute("transactedPrice")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setTransactedPrice(TransactedPrice _transactedPrice) {
			this.transactedPrice = _transactedPrice == null ? null : _transactedPrice.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultPayout build() {
			return new CreditDefaultPayout.CreditDefaultPayoutImpl(this);
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder prune() {
			super.prune();
			if (generalTerms!=null && !generalTerms.prune().hasData()) generalTerms = null;
			protectionTerms = protectionTerms.stream().filter(b->b!=null).<ProtectionTerms.ProtectionTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (transactedPrice!=null && !transactedPrice.prune().hasData()) transactedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGeneralTerms()!=null && getGeneralTerms().hasData()) return true;
			if (getProtectionTerms()!=null && getProtectionTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransactedPrice()!=null && getTransactedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditDefaultPayout.CreditDefaultPayoutBuilder o = (CreditDefaultPayout.CreditDefaultPayoutBuilder) other;
			
			merger.mergeRosetta(getGeneralTerms(), o.getGeneralTerms(), this::setGeneralTerms);
			merger.mergeRosetta(getProtectionTerms(), o.getProtectionTerms(), this::getOrCreateProtectionTerms);
			merger.mergeRosetta(getTransactedPrice(), o.getTransactedPrice(), this::setTransactedPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultPayout _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!Objects.equals(transactedPrice, _that.getTransactedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (transactedPrice != null ? transactedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultPayoutBuilder {" +
				"generalTerms=" + this.generalTerms + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"transactedPrice=" + this.transactedPrice +
			'}' + " " + super.toString();
		}
	}
}
