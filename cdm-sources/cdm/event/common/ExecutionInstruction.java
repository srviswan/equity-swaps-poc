package cdm.event.common;

import cdm.base.datetime.TimeZone;
import cdm.base.datetime.metafields.FieldWithMetaTimeZone;
import cdm.base.datetime.metafields.FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyBuilder;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Counterparty.CounterpartyBuilder;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionDetails.ExecutionDetailsBuilder;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.ExecutionInstruction.ExecutionInstructionBuilder;
import cdm.event.common.ExecutionInstruction.ExecutionInstructionBuilderImpl;
import cdm.event.common.ExecutionInstruction.ExecutionInstructionImpl;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeIdentifier.TradeIdentifierBuilder;
import cdm.event.common.meta.ExecutionInstructionMeta;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.Collateral.CollateralBuilder;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
 * @version 6.0.0
 */
@RosettaDataType(value="ExecutionInstruction", builder=ExecutionInstruction.ExecutionInstructionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ExecutionInstruction", model="Just another Rosetta model", builder=ExecutionInstruction.ExecutionInstructionBuilderImpl.class, version="6.0.0")
public interface ExecutionInstruction extends RosettaModelObject {

	ExecutionInstructionMeta metaData = new ExecutionInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the financial product to be executed and contract formed.
	 */
	NonTransferableProduct getProduct();
	/**
	 * Defines the prices (e.g. spread, equity price, FX rate), quantities (e.g. currency amount, no. shares) and settlement terms (e.g. initial fee, broker fee, up-front cds payment or option premium settlement) associated with the constituents of the transacted product.
	 */
	List<? extends PriceQuantity> getPriceQuantity();
	/**
	 * Maps two defined parties to counterparty enums for the transacted product.
	 */
	List<? extends Counterparty> getCounterparty();
	/**
	 * Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
	 */
	List<? extends AncillaryParty> getAncillaryParty();
	/**
	 * Defines all parties to that execution, including agents and brokers.
	 */
	List<? extends Party> getParties();
	/**
	 * Defines the role(s) that party(ies) may have in relation to the execution.
	 */
	List<? extends PartyRole> getPartyRoles();
	/**
	 * Specifies the type and venue of execution, e.g. via voice, or electronically.
	 */
	ExecutionDetails getExecutionDetails();
	/**
	 * Denotes the trade/execution date.
	 */
	FieldWithMetaDate getTradeDate();
	/**
	 * Denotes the trade time and timezone as agreed by the parties to the trade.
	 */
	FieldWithMetaTimeZone getTradeTime();
	/**
	 * Denotes one or more identifiers associated with the transaction.
	 */
	List<? extends TradeIdentifier> getTradeIdentifier();
	/**
	 * Detail the collateral requirement anticipated with the transaction.
	 */
	Collateral getCollateral();
	/**
	 * Lot Identifier associated with the transaction.
	 */
	Identifier getLotIdentifier();

	/*********************** Build Methods  ***********************/
	ExecutionInstruction build();
	
	ExecutionInstruction.ExecutionInstructionBuilder toBuilder();
	
	static ExecutionInstruction.ExecutionInstructionBuilder builder() {
		return new ExecutionInstruction.ExecutionInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionInstruction> getType() {
		return ExecutionInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("product"), processor, NonTransferableProduct.class, getProduct());
		processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
		processRosetta(path.newSubPath("ancillaryParty"), processor, AncillaryParty.class, getAncillaryParty());
		processRosetta(path.newSubPath("parties"), processor, Party.class, getParties());
		processRosetta(path.newSubPath("partyRoles"), processor, PartyRole.class, getPartyRoles());
		processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.class, getExecutionDetails());
		processRosetta(path.newSubPath("tradeDate"), processor, FieldWithMetaDate.class, getTradeDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("tradeTime"), processor, FieldWithMetaTimeZone.class, getTradeTime(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("lotIdentifier"), processor, Identifier.class, getLotIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionInstructionBuilder extends ExecutionInstruction, RosettaModelObjectBuilder {
		NonTransferableProduct.NonTransferableProductBuilder getOrCreateProduct();
		@Override
		NonTransferableProduct.NonTransferableProductBuilder getProduct();
		PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index);
		@Override
		List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index);
		@Override
		List<? extends Counterparty.CounterpartyBuilder> getCounterparty();
		AncillaryParty.AncillaryPartyBuilder getOrCreateAncillaryParty(int _index);
		@Override
		List<? extends AncillaryParty.AncillaryPartyBuilder> getAncillaryParty();
		Party.PartyBuilder getOrCreateParties(int _index);
		@Override
		List<? extends Party.PartyBuilder> getParties();
		PartyRole.PartyRoleBuilder getOrCreatePartyRoles(int _index);
		@Override
		List<? extends PartyRole.PartyRoleBuilder> getPartyRoles();
		ExecutionDetails.ExecutionDetailsBuilder getOrCreateExecutionDetails();
		@Override
		ExecutionDetails.ExecutionDetailsBuilder getExecutionDetails();
		FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateTradeDate();
		@Override
		FieldWithMetaDate.FieldWithMetaDateBuilder getTradeDate();
		FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder getOrCreateTradeTime();
		@Override
		FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder getTradeTime();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier();
		Collateral.CollateralBuilder getOrCreateCollateral();
		@Override
		Collateral.CollateralBuilder getCollateral();
		Identifier.IdentifierBuilder getOrCreateLotIdentifier();
		@Override
		Identifier.IdentifierBuilder getLotIdentifier();
		ExecutionInstruction.ExecutionInstructionBuilder setProduct(NonTransferableProduct product);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(List<? extends Counterparty> counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder setCounterparty(List<? extends Counterparty> counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(List<? extends AncillaryParty> ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder setAncillaryParty(List<? extends AncillaryParty> ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(List<? extends Party> parties);
		ExecutionInstruction.ExecutionInstructionBuilder setParties(List<? extends Party> parties);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(List<? extends PartyRole> partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder setPartyRoles(List<? extends PartyRole> partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder setExecutionDetails(ExecutionDetails executionDetails);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeDate(FieldWithMetaDate tradeDate);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeDateValue(Date tradeDate);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeTime(FieldWithMetaTimeZone tradeTime);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeTimeValue(TimeZone tradeTime);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		ExecutionInstruction.ExecutionInstructionBuilder setCollateral(Collateral collateral);
		ExecutionInstruction.ExecutionInstructionBuilder setLotIdentifier(Identifier lotIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("product"), processor, NonTransferableProduct.NonTransferableProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.PriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
			processRosetta(path.newSubPath("ancillaryParty"), processor, AncillaryParty.AncillaryPartyBuilder.class, getAncillaryParty());
			processRosetta(path.newSubPath("parties"), processor, Party.PartyBuilder.class, getParties());
			processRosetta(path.newSubPath("partyRoles"), processor, PartyRole.PartyRoleBuilder.class, getPartyRoles());
			processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.ExecutionDetailsBuilder.class, getExecutionDetails());
			processRosetta(path.newSubPath("tradeDate"), processor, FieldWithMetaDate.FieldWithMetaDateBuilder.class, getTradeDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("tradeTime"), processor, FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder.class, getTradeTime(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("lotIdentifier"), processor, Identifier.IdentifierBuilder.class, getLotIdentifier());
		}
		

		ExecutionInstruction.ExecutionInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionInstruction  ***********************/
	class ExecutionInstructionImpl implements ExecutionInstruction {
		private final NonTransferableProduct product;
		private final List<? extends PriceQuantity> priceQuantity;
		private final List<? extends Counterparty> counterparty;
		private final List<? extends AncillaryParty> ancillaryParty;
		private final List<? extends Party> parties;
		private final List<? extends PartyRole> partyRoles;
		private final ExecutionDetails executionDetails;
		private final FieldWithMetaDate tradeDate;
		private final FieldWithMetaTimeZone tradeTime;
		private final List<? extends TradeIdentifier> tradeIdentifier;
		private final Collateral collateral;
		private final Identifier lotIdentifier;
		
		protected ExecutionInstructionImpl(ExecutionInstruction.ExecutionInstructionBuilder builder) {
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
			this.priceQuantity = ofNullable(builder.getPriceQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.ancillaryParty = ofNullable(builder.getAncillaryParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parties = ofNullable(builder.getParties()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRoles = ofNullable(builder.getPartyRoles()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.executionDetails = ofNullable(builder.getExecutionDetails()).map(f->f.build()).orElse(null);
			this.tradeDate = ofNullable(builder.getTradeDate()).map(f->f.build()).orElse(null);
			this.tradeTime = ofNullable(builder.getTradeTime()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.lotIdentifier = ofNullable(builder.getLotIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public NonTransferableProduct getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public List<? extends PriceQuantity> getPriceQuantity() {
			return priceQuantity;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<? extends Counterparty> getCounterparty() {
			return counterparty;
		}
		
		@Override
		@RosettaAttribute("ancillaryParty")
		@RuneAttribute("ancillaryParty")
		public List<? extends AncillaryParty> getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		@RosettaAttribute("parties")
		@RuneAttribute("parties")
		public List<? extends Party> getParties() {
			return parties;
		}
		
		@Override
		@RosettaAttribute("partyRoles")
		@RuneAttribute("partyRoles")
		public List<? extends PartyRole> getPartyRoles() {
			return partyRoles;
		}
		
		@Override
		@RosettaAttribute("executionDetails")
		@RuneAttribute("executionDetails")
		public ExecutionDetails getExecutionDetails() {
			return executionDetails;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@RuneAttribute("tradeDate")
		public FieldWithMetaDate getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("tradeTime")
		@RuneAttribute("tradeTime")
		public FieldWithMetaTimeZone getTradeTime() {
			return tradeTime;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("lotIdentifier")
		@RuneAttribute("lotIdentifier")
		public Identifier getLotIdentifier() {
			return lotIdentifier;
		}
		
		@Override
		public ExecutionInstruction build() {
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder toBuilder() {
			ExecutionInstruction.ExecutionInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionInstruction.ExecutionInstructionBuilder builder) {
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getPriceQuantity()).ifPresent(builder::setPriceQuantity);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getAncillaryParty()).ifPresent(builder::setAncillaryParty);
			ofNullable(getParties()).ifPresent(builder::setParties);
			ofNullable(getPartyRoles()).ifPresent(builder::setPartyRoles);
			ofNullable(getExecutionDetails()).ifPresent(builder::setExecutionDetails);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getTradeTime()).ifPresent(builder::setTradeTime);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getLotIdentifier()).ifPresent(builder::setLotIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionInstruction _that = getType().cast(o);
		
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			if (!ListEquals.listEquals(partyRoles, _that.getPartyRoles())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(tradeTime, _that.getTradeTime())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(lotIdentifier, _that.getLotIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (partyRoles != null ? partyRoles.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeTime != null ? tradeTime.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (lotIdentifier != null ? lotIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionInstruction {" +
				"product=" + this.product + ", " +
				"priceQuantity=" + this.priceQuantity + ", " +
				"counterparty=" + this.counterparty + ", " +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"parties=" + this.parties + ", " +
				"partyRoles=" + this.partyRoles + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeTime=" + this.tradeTime + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"collateral=" + this.collateral + ", " +
				"lotIdentifier=" + this.lotIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionInstruction  ***********************/
	class ExecutionInstructionBuilderImpl implements ExecutionInstruction.ExecutionInstructionBuilder {
	
		protected NonTransferableProduct.NonTransferableProductBuilder product;
		protected List<PriceQuantity.PriceQuantityBuilder> priceQuantity = new ArrayList<>();
		protected List<Counterparty.CounterpartyBuilder> counterparty = new ArrayList<>();
		protected List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty = new ArrayList<>();
		protected List<Party.PartyBuilder> parties = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRoles = new ArrayList<>();
		protected ExecutionDetails.ExecutionDetailsBuilder executionDetails;
		protected FieldWithMetaDate.FieldWithMetaDateBuilder tradeDate;
		protected FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder tradeTime;
		protected List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Collateral.CollateralBuilder collateral;
		protected Identifier.IdentifierBuilder lotIdentifier;
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public NonTransferableProduct.NonTransferableProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder getOrCreateProduct() {
			NonTransferableProduct.NonTransferableProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = NonTransferableProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity() {
			return priceQuantity;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index) {
		
			if (priceQuantity==null) {
				this.priceQuantity = new ArrayList<>();
			}
			PriceQuantity.PriceQuantityBuilder result;
			return getIndex(priceQuantity, _index, () -> {
						PriceQuantity.PriceQuantityBuilder newPriceQuantity = PriceQuantity.builder();
						return newPriceQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<? extends Counterparty.CounterpartyBuilder> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index) {
		
			if (counterparty==null) {
				this.counterparty = new ArrayList<>();
			}
			Counterparty.CounterpartyBuilder result;
			return getIndex(counterparty, _index, () -> {
						Counterparty.CounterpartyBuilder newCounterparty = Counterparty.builder();
						return newCounterparty;
					});
		}
		
		@Override
		@RosettaAttribute("ancillaryParty")
		@RuneAttribute("ancillaryParty")
		public List<? extends AncillaryParty.AncillaryPartyBuilder> getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder getOrCreateAncillaryParty(int _index) {
		
			if (ancillaryParty==null) {
				this.ancillaryParty = new ArrayList<>();
			}
			AncillaryParty.AncillaryPartyBuilder result;
			return getIndex(ancillaryParty, _index, () -> {
						AncillaryParty.AncillaryPartyBuilder newAncillaryParty = AncillaryParty.builder();
						return newAncillaryParty;
					});
		}
		
		@Override
		@RosettaAttribute("parties")
		@RuneAttribute("parties")
		public List<? extends Party.PartyBuilder> getParties() {
			return parties;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParties(int _index) {
		
			if (parties==null) {
				this.parties = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(parties, _index, () -> {
						Party.PartyBuilder newParties = Party.builder();
						return newParties;
					});
		}
		
		@Override
		@RosettaAttribute("partyRoles")
		@RuneAttribute("partyRoles")
		public List<? extends PartyRole.PartyRoleBuilder> getPartyRoles() {
			return partyRoles;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreatePartyRoles(int _index) {
		
			if (partyRoles==null) {
				this.partyRoles = new ArrayList<>();
			}
			PartyRole.PartyRoleBuilder result;
			return getIndex(partyRoles, _index, () -> {
						PartyRole.PartyRoleBuilder newPartyRoles = PartyRole.builder();
						return newPartyRoles;
					});
		}
		
		@Override
		@RosettaAttribute("executionDetails")
		@RuneAttribute("executionDetails")
		public ExecutionDetails.ExecutionDetailsBuilder getExecutionDetails() {
			return executionDetails;
		}
		
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder getOrCreateExecutionDetails() {
			ExecutionDetails.ExecutionDetailsBuilder result;
			if (executionDetails!=null) {
				result = executionDetails;
			}
			else {
				result = executionDetails = ExecutionDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@RuneAttribute("tradeDate")
		public FieldWithMetaDate.FieldWithMetaDateBuilder getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateTradeDate() {
			FieldWithMetaDate.FieldWithMetaDateBuilder result;
			if (tradeDate!=null) {
				result = tradeDate;
			}
			else {
				result = tradeDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeTime")
		@RuneAttribute("tradeTime")
		public FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder getTradeTime() {
			return tradeTime;
		}
		
		@Override
		public FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder getOrCreateTradeTime() {
			FieldWithMetaTimeZone.FieldWithMetaTimeZoneBuilder result;
			if (tradeTime!=null) {
				result = tradeTime;
			}
			else {
				result = tradeTime = FieldWithMetaTimeZone.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newTradeIdentifier = TradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lotIdentifier")
		@RuneAttribute("lotIdentifier")
		public Identifier.IdentifierBuilder getLotIdentifier() {
			return lotIdentifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateLotIdentifier() {
			Identifier.IdentifierBuilder result;
			if (lotIdentifier!=null) {
				result = lotIdentifier;
			}
			else {
				result = lotIdentifier = Identifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public ExecutionInstruction.ExecutionInstructionBuilder setProduct(NonTransferableProduct _product) {
			this.product = _product == null ? null : _product.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity _priceQuantity) {
			if (_priceQuantity != null) {
				this.priceQuantity.add(_priceQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity _priceQuantity, int _idx) {
			getIndex(this.priceQuantity, _idx, () -> _priceQuantity.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys != null) {
				for (final PriceQuantity toAdd : priceQuantitys) {
					this.priceQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("priceQuantity")
		public ExecutionInstruction.ExecutionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys == null) {
				this.priceQuantity = new ArrayList<>();
			} else {
				this.priceQuantity = priceQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty _counterparty) {
			if (_counterparty != null) {
				this.counterparty.add(_counterparty.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty _counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> _counterparty.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys != null) {
				for (final Counterparty toAdd : counterpartys) {
					this.counterparty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("counterparty")
		public ExecutionInstruction.ExecutionInstructionBuilder setCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys == null) {
				this.counterparty = new ArrayList<>();
			} else {
				this.counterparty = counterpartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("ancillaryParty")
		@RuneAttribute("ancillaryParty")
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty _ancillaryParty) {
			if (_ancillaryParty != null) {
				this.ancillaryParty.add(_ancillaryParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty _ancillaryParty, int _idx) {
			getIndex(this.ancillaryParty, _idx, () -> _ancillaryParty.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(List<? extends AncillaryParty> ancillaryPartys) {
			if (ancillaryPartys != null) {
				for (final AncillaryParty toAdd : ancillaryPartys) {
					this.ancillaryParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("ancillaryParty")
		public ExecutionInstruction.ExecutionInstructionBuilder setAncillaryParty(List<? extends AncillaryParty> ancillaryPartys) {
			if (ancillaryPartys == null) {
				this.ancillaryParty = new ArrayList<>();
			} else {
				this.ancillaryParty = ancillaryPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parties")
		@RuneAttribute("parties")
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(Party _parties) {
			if (_parties != null) {
				this.parties.add(_parties.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(Party _parties, int _idx) {
			getIndex(this.parties, _idx, () -> _parties.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(List<? extends Party> partiess) {
			if (partiess != null) {
				for (final Party toAdd : partiess) {
					this.parties.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("parties")
		public ExecutionInstruction.ExecutionInstructionBuilder setParties(List<? extends Party> partiess) {
			if (partiess == null) {
				this.parties = new ArrayList<>();
			} else {
				this.parties = partiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyRoles")
		@RuneAttribute("partyRoles")
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole _partyRoles) {
			if (_partyRoles != null) {
				this.partyRoles.add(_partyRoles.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole _partyRoles, int _idx) {
			getIndex(this.partyRoles, _idx, () -> _partyRoles.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(List<? extends PartyRole> partyRoless) {
			if (partyRoless != null) {
				for (final PartyRole toAdd : partyRoless) {
					this.partyRoles.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRoles")
		public ExecutionInstruction.ExecutionInstructionBuilder setPartyRoles(List<? extends PartyRole> partyRoless) {
			if (partyRoless == null) {
				this.partyRoles = new ArrayList<>();
			} else {
				this.partyRoles = partyRoless.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("executionDetails")
		@RuneAttribute("executionDetails")
		public ExecutionInstruction.ExecutionInstructionBuilder setExecutionDetails(ExecutionDetails _executionDetails) {
			this.executionDetails = _executionDetails == null ? null : _executionDetails.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@RuneAttribute("tradeDate")
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeDate(FieldWithMetaDate _tradeDate) {
			this.tradeDate = _tradeDate == null ? null : _tradeDate.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeDateValue(Date _tradeDate) {
			this.getOrCreateTradeDate().setValue(_tradeDate);
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeTime")
		@RuneAttribute("tradeTime")
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeTime(FieldWithMetaTimeZone _tradeTime) {
			this.tradeTime = _tradeTime == null ? null : _tradeTime.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeTimeValue(TimeZone _tradeTime) {
			this.getOrCreateTradeTime().setValue(_tradeTime);
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@RuneAttribute("tradeIdentifier")
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final TradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("tradeIdentifier")
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@RuneAttribute("collateral")
		public ExecutionInstruction.ExecutionInstructionBuilder setCollateral(Collateral _collateral) {
			this.collateral = _collateral == null ? null : _collateral.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("lotIdentifier")
		@RuneAttribute("lotIdentifier")
		public ExecutionInstruction.ExecutionInstructionBuilder setLotIdentifier(Identifier _lotIdentifier) {
			this.lotIdentifier = _lotIdentifier == null ? null : _lotIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionInstruction build() {
			return new ExecutionInstruction.ExecutionInstructionImpl(this);
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder prune() {
			if (product!=null && !product.prune().hasData()) product = null;
			priceQuantity = priceQuantity.stream().filter(b->b!=null).<PriceQuantity.PriceQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			counterparty = counterparty.stream().filter(b->b!=null).<Counterparty.CounterpartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			ancillaryParty = ancillaryParty.stream().filter(b->b!=null).<AncillaryParty.AncillaryPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			parties = parties.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRoles = partyRoles.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionDetails!=null && !executionDetails.prune().hasData()) executionDetails = null;
			if (tradeDate!=null && !tradeDate.prune().hasData()) tradeDate = null;
			if (tradeTime!=null && !tradeTime.prune().hasData()) tradeTime = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (lotIdentifier!=null && !lotIdentifier.prune().hasData()) lotIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProduct()!=null && getProduct().hasData()) return true;
			if (getPriceQuantity()!=null && getPriceQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCounterparty()!=null && getCounterparty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAncillaryParty()!=null && getAncillaryParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParties()!=null && getParties().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRoles()!=null && getPartyRoles().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExecutionDetails()!=null && getExecutionDetails().hasData()) return true;
			if (getTradeDate()!=null) return true;
			if (getTradeTime()!=null && getTradeTime().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getLotIdentifier()!=null && getLotIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionInstruction.ExecutionInstructionBuilder o = (ExecutionInstruction.ExecutionInstructionBuilder) other;
			
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			merger.mergeRosetta(getPriceQuantity(), o.getPriceQuantity(), this::getOrCreatePriceQuantity);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::getOrCreateCounterparty);
			merger.mergeRosetta(getAncillaryParty(), o.getAncillaryParty(), this::getOrCreateAncillaryParty);
			merger.mergeRosetta(getParties(), o.getParties(), this::getOrCreateParties);
			merger.mergeRosetta(getPartyRoles(), o.getPartyRoles(), this::getOrCreatePartyRoles);
			merger.mergeRosetta(getExecutionDetails(), o.getExecutionDetails(), this::setExecutionDetails);
			merger.mergeRosetta(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeRosetta(getTradeTime(), o.getTradeTime(), this::setTradeTime);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getLotIdentifier(), o.getLotIdentifier(), this::setLotIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionInstruction _that = getType().cast(o);
		
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			if (!ListEquals.listEquals(partyRoles, _that.getPartyRoles())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(tradeTime, _that.getTradeTime())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(lotIdentifier, _that.getLotIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (partyRoles != null ? partyRoles.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeTime != null ? tradeTime.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (lotIdentifier != null ? lotIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionInstructionBuilder {" +
				"product=" + this.product + ", " +
				"priceQuantity=" + this.priceQuantity + ", " +
				"counterparty=" + this.counterparty + ", " +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"parties=" + this.parties + ", " +
				"partyRoles=" + this.partyRoles + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeTime=" + this.tradeTime + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"collateral=" + this.collateral + ", " +
				"lotIdentifier=" + this.lotIdentifier +
			'}';
		}
	}
}
