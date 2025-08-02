package cdm.event.common;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilder;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.event.common.Transfer.TransferBuilderImpl;
import cdm.event.common.Transfer.TransferImpl;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferExpression.TransferExpressionBuilder;
import cdm.event.common.meta.TransferMeta;
import cdm.product.common.settlement.AssetFlowBase;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilder;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilderImpl;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseImpl;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder;
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
 * Defines the movement of an Asset (eg cash, securities or commodities) between two parties on a date.
 * @version 6.0.0
 */
@RosettaDataType(value="Transfer", builder=Transfer.TransferBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Transfer", model="Just another Rosetta model", builder=Transfer.TransferBuilderImpl.class, version="6.0.0")
public interface Transfer extends AssetFlowBase {

	TransferMeta metaData = new TransferMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a unique reference to the transfer.
	 */
	List<? extends FieldWithMetaIdentifier> getIdentifier();
	/**
	 * Represents the parties to the transfer and their role.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	/**
	 * Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.
	 */
	ReferenceWithMetaPayout getSettlementOrigin();
	/**
	 * Represents the reset and observation values that were used to determine the transfer amount.
	 */
	Reset getResetOrigin();
	/**
	 * Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
	 */
	TransferExpression getTransferExpression();

	/*********************** Build Methods  ***********************/
	Transfer build();
	
	Transfer.TransferBuilder toBuilder();
	
	static Transfer.TransferBuilder builder() {
		return new Transfer.TransferBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Transfer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Transfer> getType() {
		return Transfer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.class, getQuantity());
		processRosetta(path.newSubPath("asset"), processor, Asset.class, getAsset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("settlementOrigin"), processor, ReferenceWithMetaPayout.class, getSettlementOrigin());
		processRosetta(path.newSubPath("resetOrigin"), processor, Reset.class, getResetOrigin());
		processRosetta(path.newSubPath("transferExpression"), processor, TransferExpression.class, getTransferExpression());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferBuilder extends Transfer, AssetFlowBase.AssetFlowBaseBuilder {
		FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder getOrCreateIdentifier(int _index);
		@Override
		List<? extends FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> getIdentifier();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		@Override
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateSettlementOrigin();
		@Override
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getSettlementOrigin();
		Reset.ResetBuilder getOrCreateResetOrigin();
		@Override
		Reset.ResetBuilder getResetOrigin();
		TransferExpression.TransferExpressionBuilder getOrCreateTransferExpression();
		@Override
		TransferExpression.TransferExpressionBuilder getTransferExpression();
		@Override
		Transfer.TransferBuilder setQuantity(NonNegativeQuantity quantity);
		@Override
		Transfer.TransferBuilder setAsset(Asset asset);
		@Override
		Transfer.TransferBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate settlementDate);
		Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier);
		Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier identifier, int _idx);
		Transfer.TransferBuilder addIdentifierValue(Identifier identifier);
		Transfer.TransferBuilder addIdentifierValue(Identifier identifier, int _idx);
		Transfer.TransferBuilder addIdentifier(List<? extends FieldWithMetaIdentifier> identifier);
		Transfer.TransferBuilder setIdentifier(List<? extends FieldWithMetaIdentifier> identifier);
		Transfer.TransferBuilder addIdentifierValue(List<? extends Identifier> identifier);
		Transfer.TransferBuilder setIdentifierValue(List<? extends Identifier> identifier);
		Transfer.TransferBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		Transfer.TransferBuilder setSettlementOrigin(ReferenceWithMetaPayout settlementOrigin);
		Transfer.TransferBuilder setSettlementOriginValue(Payout settlementOrigin);
		Transfer.TransferBuilder setResetOrigin(Reset resetOrigin);
		Transfer.TransferBuilder setTransferExpression(TransferExpression transferExpression);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.NonNegativeQuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("asset"), processor, Asset.AssetBuilder.class, getAsset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("settlementOrigin"), processor, ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder.class, getSettlementOrigin());
			processRosetta(path.newSubPath("resetOrigin"), processor, Reset.ResetBuilder.class, getResetOrigin());
			processRosetta(path.newSubPath("transferExpression"), processor, TransferExpression.TransferExpressionBuilder.class, getTransferExpression());
		}
		

		Transfer.TransferBuilder prune();
	}

	/*********************** Immutable Implementation of Transfer  ***********************/
	class TransferImpl extends AssetFlowBase.AssetFlowBaseImpl implements Transfer {
		private final List<? extends FieldWithMetaIdentifier> identifier;
		private final PartyReferencePayerReceiver payerReceiver;
		private final ReferenceWithMetaPayout settlementOrigin;
		private final Reset resetOrigin;
		private final TransferExpression transferExpression;
		
		protected TransferImpl(Transfer.TransferBuilder builder) {
			super(builder);
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.settlementOrigin = ofNullable(builder.getSettlementOrigin()).map(f->f.build()).orElse(null);
			this.resetOrigin = ofNullable(builder.getResetOrigin()).map(f->f.build()).orElse(null);
			this.transferExpression = ofNullable(builder.getTransferExpression()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends FieldWithMetaIdentifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		@RosettaAttribute("settlementOrigin")
		@RuneAttribute("settlementOrigin")
		public ReferenceWithMetaPayout getSettlementOrigin() {
			return settlementOrigin;
		}
		
		@Override
		@RosettaAttribute("resetOrigin")
		@RuneAttribute("resetOrigin")
		public Reset getResetOrigin() {
			return resetOrigin;
		}
		
		@Override
		@RosettaAttribute("transferExpression")
		@RuneAttribute("transferExpression")
		public TransferExpression getTransferExpression() {
			return transferExpression;
		}
		
		@Override
		public Transfer build() {
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder toBuilder() {
			Transfer.TransferBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transfer.TransferBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getSettlementOrigin()).ifPresent(builder::setSettlementOrigin);
			ofNullable(getResetOrigin()).ifPresent(builder::setResetOrigin);
			ofNullable(getTransferExpression()).ifPresent(builder::setTransferExpression);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Transfer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(settlementOrigin, _that.getSettlementOrigin())) return false;
			if (!Objects.equals(resetOrigin, _that.getResetOrigin())) return false;
			if (!Objects.equals(transferExpression, _that.getTransferExpression())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (settlementOrigin != null ? settlementOrigin.hashCode() : 0);
			_result = 31 * _result + (resetOrigin != null ? resetOrigin.hashCode() : 0);
			_result = 31 * _result + (transferExpression != null ? transferExpression.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Transfer {" +
				"identifier=" + this.identifier + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"settlementOrigin=" + this.settlementOrigin + ", " +
				"resetOrigin=" + this.resetOrigin + ", " +
				"transferExpression=" + this.transferExpression +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Transfer  ***********************/
	class TransferBuilderImpl extends AssetFlowBase.AssetFlowBaseBuilderImpl implements Transfer.TransferBuilder {
	
		protected List<FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> identifier = new ArrayList<>();
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
		protected ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder settlementOrigin;
		protected Reset.ResetBuilder resetOrigin;
		protected TransferExpression.TransferExpressionBuilder transferExpression;
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public List<? extends FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder newIdentifier = FieldWithMetaIdentifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PartyReferencePayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementOrigin")
		@RuneAttribute("settlementOrigin")
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getSettlementOrigin() {
			return settlementOrigin;
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateSettlementOrigin() {
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder result;
			if (settlementOrigin!=null) {
				result = settlementOrigin;
			}
			else {
				result = settlementOrigin = ReferenceWithMetaPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetOrigin")
		@RuneAttribute("resetOrigin")
		public Reset.ResetBuilder getResetOrigin() {
			return resetOrigin;
		}
		
		@Override
		public Reset.ResetBuilder getOrCreateResetOrigin() {
			Reset.ResetBuilder result;
			if (resetOrigin!=null) {
				result = resetOrigin;
			}
			else {
				result = resetOrigin = Reset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferExpression")
		@RuneAttribute("transferExpression")
		public TransferExpression.TransferExpressionBuilder getTransferExpression() {
			return transferExpression;
		}
		
		@Override
		public TransferExpression.TransferExpressionBuilder getOrCreateTransferExpression() {
			TransferExpression.TransferExpressionBuilder result;
			if (transferExpression!=null) {
				result = transferExpression;
			}
			else {
				result = transferExpression = TransferExpression.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public Transfer.TransferBuilder setQuantity(NonNegativeQuantity _quantity) {
			this.quantity = _quantity == null ? null : _quantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("asset")
		@RuneAttribute("asset")
		public Transfer.TransferBuilder setAsset(Asset _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@RuneAttribute("settlementDate")
		public Transfer.TransferBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifier(FieldWithMetaIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifierValue(Identifier _identifier) {
			this.getOrCreateIdentifier(-1).setValue(_identifier.toBuilder());
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifierValue(Identifier _identifier, int _idx) {
			this.getOrCreateIdentifier(_idx).setValue(_identifier.toBuilder());
			return this;
		}
		
		@Override 
		public Transfer.TransferBuilder addIdentifier(List<? extends FieldWithMetaIdentifier> identifiers) {
			if (identifiers != null) {
				for (final FieldWithMetaIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public Transfer.TransferBuilder setIdentifier(List<? extends FieldWithMetaIdentifier> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder addIdentifierValue(List<? extends Identifier> identifiers) {
			if (identifiers != null) {
				for (final Identifier toAdd : identifiers) {
					this.addIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder setIdentifierValue(List<? extends Identifier> identifiers) {
			this.identifier.clear();
			if (identifiers != null) {
				identifiers.forEach(this::addIdentifierValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiver")
		@RuneAttribute("payerReceiver")
		public Transfer.TransferBuilder setPayerReceiver(PartyReferencePayerReceiver _payerReceiver) {
			this.payerReceiver = _payerReceiver == null ? null : _payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementOrigin")
		@RuneAttribute("settlementOrigin")
		public Transfer.TransferBuilder setSettlementOrigin(ReferenceWithMetaPayout _settlementOrigin) {
			this.settlementOrigin = _settlementOrigin == null ? null : _settlementOrigin.toBuilder();
			return this;
		}
		
		@Override
		public Transfer.TransferBuilder setSettlementOriginValue(Payout _settlementOrigin) {
			this.getOrCreateSettlementOrigin().setValue(_settlementOrigin);
			return this;
		}
		
		@Override
		@RosettaAttribute("resetOrigin")
		@RuneAttribute("resetOrigin")
		public Transfer.TransferBuilder setResetOrigin(Reset _resetOrigin) {
			this.resetOrigin = _resetOrigin == null ? null : _resetOrigin.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("transferExpression")
		@RuneAttribute("transferExpression")
		public Transfer.TransferBuilder setTransferExpression(TransferExpression _transferExpression) {
			this.transferExpression = _transferExpression == null ? null : _transferExpression.toBuilder();
			return this;
		}
		
		@Override
		public Transfer build() {
			return new Transfer.TransferImpl(this);
		}
		
		@Override
		public Transfer.TransferBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfer.TransferBuilder prune() {
			super.prune();
			identifier = identifier.stream().filter(b->b!=null).<FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (settlementOrigin!=null && !settlementOrigin.prune().hasData()) settlementOrigin = null;
			if (resetOrigin!=null && !resetOrigin.prune().hasData()) resetOrigin = null;
			if (transferExpression!=null && !transferExpression.prune().hasData()) transferExpression = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getSettlementOrigin()!=null && getSettlementOrigin().hasData()) return true;
			if (getResetOrigin()!=null && getResetOrigin().hasData()) return true;
			if (getTransferExpression()!=null && getTransferExpression().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfer.TransferBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Transfer.TransferBuilder o = (Transfer.TransferBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getSettlementOrigin(), o.getSettlementOrigin(), this::setSettlementOrigin);
			merger.mergeRosetta(getResetOrigin(), o.getResetOrigin(), this::setResetOrigin);
			merger.mergeRosetta(getTransferExpression(), o.getTransferExpression(), this::setTransferExpression);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Transfer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(settlementOrigin, _that.getSettlementOrigin())) return false;
			if (!Objects.equals(resetOrigin, _that.getResetOrigin())) return false;
			if (!Objects.equals(transferExpression, _that.getTransferExpression())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (settlementOrigin != null ? settlementOrigin.hashCode() : 0);
			_result = 31 * _result + (resetOrigin != null ? resetOrigin.hashCode() : 0);
			_result = 31 * _result + (transferExpression != null ? transferExpression.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBuilder {" +
				"identifier=" + this.identifier + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"settlementOrigin=" + this.settlementOrigin + ", " +
				"resetOrigin=" + this.resetOrigin + ", " +
				"transferExpression=" + this.transferExpression +
			'}' + " " + super.toString();
		}
	}
}
