package cdm.event.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.event.common.CollateralBalance;
import cdm.event.common.CollateralBalance.CollateralBalanceBuilder;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.Exposure;
import cdm.event.common.Exposure.ExposureBuilder;
import cdm.event.common.MarginCallBase;
import cdm.event.common.MarginCallBase.MarginCallBaseBuilder;
import cdm.event.common.MarginCallBase.MarginCallBaseBuilderImpl;
import cdm.event.common.MarginCallBase.MarginCallBaseImpl;
import cdm.event.common.MarginCallExposure;
import cdm.event.common.MarginCallExposure.MarginCallExposureBuilder;
import cdm.event.common.MarginCallExposure.MarginCallExposureBuilderImpl;
import cdm.event.common.MarginCallExposure.MarginCallExposureImpl;
import cdm.event.common.MarginCallInstructionType;
import cdm.event.common.MarginCallInstructionType.MarginCallInstructionTypeBuilder;
import cdm.event.common.RegIMRoleEnum;
import cdm.event.common.RegMarginTypeEnum;
import cdm.event.common.meta.MarginCallExposureMeta;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio.ReferenceWithMetaCollateralPortfolioBuilder;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.AgreementName.AgreementNameBuilder;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Represents attributes required for mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
 * @version 6.0.0
 */
@RosettaDataType(value="MarginCallExposure", builder=MarginCallExposure.MarginCallExposureBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MarginCallExposure", model="Just another Rosetta model", builder=MarginCallExposure.MarginCallExposureBuilderImpl.class, version="6.0.0")
public interface MarginCallExposure extends MarginCallBase {

	MarginCallExposureMeta metaData = new MarginCallExposureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
	 */
	Exposure getOverallExposure();
	/**
	 * Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.
	 */
	Exposure getSimmIMExposure();
	/**
	 * Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.
	 */
	Exposure getScheduleGridIMExposure();

	/*********************** Build Methods  ***********************/
	MarginCallExposure build();
	
	MarginCallExposure.MarginCallExposureBuilder toBuilder();
	
	static MarginCallExposure.MarginCallExposureBuilder builder() {
		return new MarginCallExposure.MarginCallExposureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginCallExposure> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginCallExposure> getType() {
		return MarginCallExposure.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instructionType"), processor, MarginCallInstructionType.class, getInstructionType());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("clearingBroker"), processor, Party.class, getClearingBroker());
		processRosetta(path.newSubPath("callIdentifier"), processor, Identifier.class, getCallIdentifier());
		processRosetta(path.newSubPath("callAgreementType"), processor, AgreementName.class, getCallAgreementType());
		processRosetta(path.newSubPath("agreementMinimumTransferAmount"), processor, Money.class, getAgreementMinimumTransferAmount());
		processRosetta(path.newSubPath("agreementThreshold"), processor, Money.class, getAgreementThreshold());
		processRosetta(path.newSubPath("agreementRounding"), processor, Money.class, getAgreementRounding());
		processor.processBasic(path.newSubPath("regMarginType"), RegMarginTypeEnum.class, getRegMarginType(), this);
		processor.processBasic(path.newSubPath("regIMRole"), RegIMRoleEnum.class, getRegIMRole(), this);
		processRosetta(path.newSubPath("baseCurrencyExposure"), processor, MarginCallExposure.class, getBaseCurrencyExposure());
		processRosetta(path.newSubPath("collateralPortfolio"), processor, ReferenceWithMetaCollateralPortfolio.class, getCollateralPortfolio());
		processRosetta(path.newSubPath("independentAmountBalance"), processor, CollateralBalance.class, getIndependentAmountBalance());
		processRosetta(path.newSubPath("overallExposure"), processor, Exposure.class, getOverallExposure());
		processRosetta(path.newSubPath("simmIMExposure"), processor, Exposure.class, getSimmIMExposure());
		processRosetta(path.newSubPath("scheduleGridIMExposure"), processor, Exposure.class, getScheduleGridIMExposure());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginCallExposureBuilder extends MarginCallExposure, MarginCallBase.MarginCallBaseBuilder {
		Exposure.ExposureBuilder getOrCreateOverallExposure();
		@Override
		Exposure.ExposureBuilder getOverallExposure();
		Exposure.ExposureBuilder getOrCreateSimmIMExposure();
		@Override
		Exposure.ExposureBuilder getSimmIMExposure();
		Exposure.ExposureBuilder getOrCreateScheduleGridIMExposure();
		@Override
		Exposure.ExposureBuilder getScheduleGridIMExposure();
		@Override
		MarginCallExposure.MarginCallExposureBuilder setInstructionType(MarginCallInstructionType instructionType);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addParty(Party party);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addParty(Party party, int _idx);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addParty(List<? extends Party> party);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setParty(List<? extends Party> party);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addPartyRole(PartyRole partyRole);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addPartyRole(PartyRole partyRole, int _idx);
		@Override
		MarginCallExposure.MarginCallExposureBuilder addPartyRole(List<? extends PartyRole> partyRole);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setPartyRole(List<? extends PartyRole> partyRole);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setClearingBroker(Party clearingBroker);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setCallIdentifier(Identifier callIdentifier);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setCallAgreementType(AgreementName callAgreementType);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setAgreementMinimumTransferAmount(Money agreementMinimumTransferAmount);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setAgreementThreshold(Money agreementThreshold);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setAgreementRounding(Money agreementRounding);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setRegMarginType(RegMarginTypeEnum regMarginType);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setRegIMRole(RegIMRoleEnum regIMRole);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setBaseCurrencyExposure(MarginCallExposure baseCurrencyExposure);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setCollateralPortfolio(ReferenceWithMetaCollateralPortfolio collateralPortfolio);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setCollateralPortfolioValue(CollateralPortfolio collateralPortfolio);
		@Override
		MarginCallExposure.MarginCallExposureBuilder setIndependentAmountBalance(CollateralBalance independentAmountBalance);
		MarginCallExposure.MarginCallExposureBuilder setOverallExposure(Exposure overallExposure);
		MarginCallExposure.MarginCallExposureBuilder setSimmIMExposure(Exposure simmIMExposure);
		MarginCallExposure.MarginCallExposureBuilder setScheduleGridIMExposure(Exposure scheduleGridIMExposure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instructionType"), processor, MarginCallInstructionType.MarginCallInstructionTypeBuilder.class, getInstructionType());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("clearingBroker"), processor, Party.PartyBuilder.class, getClearingBroker());
			processRosetta(path.newSubPath("callIdentifier"), processor, Identifier.IdentifierBuilder.class, getCallIdentifier());
			processRosetta(path.newSubPath("callAgreementType"), processor, AgreementName.AgreementNameBuilder.class, getCallAgreementType());
			processRosetta(path.newSubPath("agreementMinimumTransferAmount"), processor, Money.MoneyBuilder.class, getAgreementMinimumTransferAmount());
			processRosetta(path.newSubPath("agreementThreshold"), processor, Money.MoneyBuilder.class, getAgreementThreshold());
			processRosetta(path.newSubPath("agreementRounding"), processor, Money.MoneyBuilder.class, getAgreementRounding());
			processor.processBasic(path.newSubPath("regMarginType"), RegMarginTypeEnum.class, getRegMarginType(), this);
			processor.processBasic(path.newSubPath("regIMRole"), RegIMRoleEnum.class, getRegIMRole(), this);
			processRosetta(path.newSubPath("baseCurrencyExposure"), processor, MarginCallExposure.MarginCallExposureBuilder.class, getBaseCurrencyExposure());
			processRosetta(path.newSubPath("collateralPortfolio"), processor, ReferenceWithMetaCollateralPortfolio.ReferenceWithMetaCollateralPortfolioBuilder.class, getCollateralPortfolio());
			processRosetta(path.newSubPath("independentAmountBalance"), processor, CollateralBalance.CollateralBalanceBuilder.class, getIndependentAmountBalance());
			processRosetta(path.newSubPath("overallExposure"), processor, Exposure.ExposureBuilder.class, getOverallExposure());
			processRosetta(path.newSubPath("simmIMExposure"), processor, Exposure.ExposureBuilder.class, getSimmIMExposure());
			processRosetta(path.newSubPath("scheduleGridIMExposure"), processor, Exposure.ExposureBuilder.class, getScheduleGridIMExposure());
		}
		

		MarginCallExposure.MarginCallExposureBuilder prune();
	}

	/*********************** Immutable Implementation of MarginCallExposure  ***********************/
	class MarginCallExposureImpl extends MarginCallBase.MarginCallBaseImpl implements MarginCallExposure {
		private final Exposure overallExposure;
		private final Exposure simmIMExposure;
		private final Exposure scheduleGridIMExposure;
		
		protected MarginCallExposureImpl(MarginCallExposure.MarginCallExposureBuilder builder) {
			super(builder);
			this.overallExposure = ofNullable(builder.getOverallExposure()).map(f->f.build()).orElse(null);
			this.simmIMExposure = ofNullable(builder.getSimmIMExposure()).map(f->f.build()).orElse(null);
			this.scheduleGridIMExposure = ofNullable(builder.getScheduleGridIMExposure()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("overallExposure")
		@RuneAttribute("overallExposure")
		public Exposure getOverallExposure() {
			return overallExposure;
		}
		
		@Override
		@RosettaAttribute("simmIMExposure")
		@RuneAttribute("simmIMExposure")
		public Exposure getSimmIMExposure() {
			return simmIMExposure;
		}
		
		@Override
		@RosettaAttribute("scheduleGridIMExposure")
		@RuneAttribute("scheduleGridIMExposure")
		public Exposure getScheduleGridIMExposure() {
			return scheduleGridIMExposure;
		}
		
		@Override
		public MarginCallExposure build() {
			return this;
		}
		
		@Override
		public MarginCallExposure.MarginCallExposureBuilder toBuilder() {
			MarginCallExposure.MarginCallExposureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginCallExposure.MarginCallExposureBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOverallExposure()).ifPresent(builder::setOverallExposure);
			ofNullable(getSimmIMExposure()).ifPresent(builder::setSimmIMExposure);
			ofNullable(getScheduleGridIMExposure()).ifPresent(builder::setScheduleGridIMExposure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarginCallExposure _that = getType().cast(o);
		
			if (!Objects.equals(overallExposure, _that.getOverallExposure())) return false;
			if (!Objects.equals(simmIMExposure, _that.getSimmIMExposure())) return false;
			if (!Objects.equals(scheduleGridIMExposure, _that.getScheduleGridIMExposure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (overallExposure != null ? overallExposure.hashCode() : 0);
			_result = 31 * _result + (simmIMExposure != null ? simmIMExposure.hashCode() : 0);
			_result = 31 * _result + (scheduleGridIMExposure != null ? scheduleGridIMExposure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallExposure {" +
				"overallExposure=" + this.overallExposure + ", " +
				"simmIMExposure=" + this.simmIMExposure + ", " +
				"scheduleGridIMExposure=" + this.scheduleGridIMExposure +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MarginCallExposure  ***********************/
	class MarginCallExposureBuilderImpl extends MarginCallBase.MarginCallBaseBuilderImpl implements MarginCallExposure.MarginCallExposureBuilder {
	
		protected Exposure.ExposureBuilder overallExposure;
		protected Exposure.ExposureBuilder simmIMExposure;
		protected Exposure.ExposureBuilder scheduleGridIMExposure;
		
		@Override
		@RosettaAttribute("overallExposure")
		@RuneAttribute("overallExposure")
		public Exposure.ExposureBuilder getOverallExposure() {
			return overallExposure;
		}
		
		@Override
		public Exposure.ExposureBuilder getOrCreateOverallExposure() {
			Exposure.ExposureBuilder result;
			if (overallExposure!=null) {
				result = overallExposure;
			}
			else {
				result = overallExposure = Exposure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("simmIMExposure")
		@RuneAttribute("simmIMExposure")
		public Exposure.ExposureBuilder getSimmIMExposure() {
			return simmIMExposure;
		}
		
		@Override
		public Exposure.ExposureBuilder getOrCreateSimmIMExposure() {
			Exposure.ExposureBuilder result;
			if (simmIMExposure!=null) {
				result = simmIMExposure;
			}
			else {
				result = simmIMExposure = Exposure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scheduleGridIMExposure")
		@RuneAttribute("scheduleGridIMExposure")
		public Exposure.ExposureBuilder getScheduleGridIMExposure() {
			return scheduleGridIMExposure;
		}
		
		@Override
		public Exposure.ExposureBuilder getOrCreateScheduleGridIMExposure() {
			Exposure.ExposureBuilder result;
			if (scheduleGridIMExposure!=null) {
				result = scheduleGridIMExposure;
			}
			else {
				result = scheduleGridIMExposure = Exposure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("instructionType")
		@RuneAttribute("instructionType")
		public MarginCallExposure.MarginCallExposureBuilder setInstructionType(MarginCallInstructionType _instructionType) {
			this.instructionType = _instructionType == null ? null : _instructionType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public MarginCallExposure.MarginCallExposureBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallExposure.MarginCallExposureBuilder addParty(Party _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override 
		public MarginCallExposure.MarginCallExposureBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public MarginCallExposure.MarginCallExposureBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyRole")
		@RuneAttribute("partyRole")
		public MarginCallExposure.MarginCallExposureBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallExposure.MarginCallExposureBuilder addPartyRole(PartyRole _partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override 
		public MarginCallExposure.MarginCallExposureBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyRole")
		public MarginCallExposure.MarginCallExposureBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles == null) {
				this.partyRole = new ArrayList<>();
			} else {
				this.partyRole = partyRoles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("clearingBroker")
		@RuneAttribute("clearingBroker")
		public MarginCallExposure.MarginCallExposureBuilder setClearingBroker(Party _clearingBroker) {
			this.clearingBroker = _clearingBroker == null ? null : _clearingBroker.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("callIdentifier")
		@RuneAttribute("callIdentifier")
		public MarginCallExposure.MarginCallExposureBuilder setCallIdentifier(Identifier _callIdentifier) {
			this.callIdentifier = _callIdentifier == null ? null : _callIdentifier.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("callAgreementType")
		@RuneAttribute("callAgreementType")
		public MarginCallExposure.MarginCallExposureBuilder setCallAgreementType(AgreementName _callAgreementType) {
			this.callAgreementType = _callAgreementType == null ? null : _callAgreementType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("agreementMinimumTransferAmount")
		@RuneAttribute("agreementMinimumTransferAmount")
		public MarginCallExposure.MarginCallExposureBuilder setAgreementMinimumTransferAmount(Money _agreementMinimumTransferAmount) {
			this.agreementMinimumTransferAmount = _agreementMinimumTransferAmount == null ? null : _agreementMinimumTransferAmount.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("agreementThreshold")
		@RuneAttribute("agreementThreshold")
		public MarginCallExposure.MarginCallExposureBuilder setAgreementThreshold(Money _agreementThreshold) {
			this.agreementThreshold = _agreementThreshold == null ? null : _agreementThreshold.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("agreementRounding")
		@RuneAttribute("agreementRounding")
		public MarginCallExposure.MarginCallExposureBuilder setAgreementRounding(Money _agreementRounding) {
			this.agreementRounding = _agreementRounding == null ? null : _agreementRounding.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("regMarginType")
		@RuneAttribute("regMarginType")
		public MarginCallExposure.MarginCallExposureBuilder setRegMarginType(RegMarginTypeEnum _regMarginType) {
			this.regMarginType = _regMarginType == null ? null : _regMarginType;
			return this;
		}
		
		@Override
		@RosettaAttribute("regIMRole")
		@RuneAttribute("regIMRole")
		public MarginCallExposure.MarginCallExposureBuilder setRegIMRole(RegIMRoleEnum _regIMRole) {
			this.regIMRole = _regIMRole == null ? null : _regIMRole;
			return this;
		}
		
		@Override
		@RosettaAttribute("baseCurrencyExposure")
		@RuneAttribute("baseCurrencyExposure")
		public MarginCallExposure.MarginCallExposureBuilder setBaseCurrencyExposure(MarginCallExposure _baseCurrencyExposure) {
			this.baseCurrencyExposure = _baseCurrencyExposure == null ? null : _baseCurrencyExposure.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolio")
		@RuneAttribute("collateralPortfolio")
		public MarginCallExposure.MarginCallExposureBuilder setCollateralPortfolio(ReferenceWithMetaCollateralPortfolio _collateralPortfolio) {
			this.collateralPortfolio = _collateralPortfolio == null ? null : _collateralPortfolio.toBuilder();
			return this;
		}
		
		@Override
		public MarginCallExposure.MarginCallExposureBuilder setCollateralPortfolioValue(CollateralPortfolio _collateralPortfolio) {
			this.getOrCreateCollateralPortfolio().setValue(_collateralPortfolio);
			return this;
		}
		
		@Override
		@RosettaAttribute("independentAmountBalance")
		@RuneAttribute("independentAmountBalance")
		public MarginCallExposure.MarginCallExposureBuilder setIndependentAmountBalance(CollateralBalance _independentAmountBalance) {
			this.independentAmountBalance = _independentAmountBalance == null ? null : _independentAmountBalance.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("overallExposure")
		@RuneAttribute("overallExposure")
		public MarginCallExposure.MarginCallExposureBuilder setOverallExposure(Exposure _overallExposure) {
			this.overallExposure = _overallExposure == null ? null : _overallExposure.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("simmIMExposure")
		@RuneAttribute("simmIMExposure")
		public MarginCallExposure.MarginCallExposureBuilder setSimmIMExposure(Exposure _simmIMExposure) {
			this.simmIMExposure = _simmIMExposure == null ? null : _simmIMExposure.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("scheduleGridIMExposure")
		@RuneAttribute("scheduleGridIMExposure")
		public MarginCallExposure.MarginCallExposureBuilder setScheduleGridIMExposure(Exposure _scheduleGridIMExposure) {
			this.scheduleGridIMExposure = _scheduleGridIMExposure == null ? null : _scheduleGridIMExposure.toBuilder();
			return this;
		}
		
		@Override
		public MarginCallExposure build() {
			return new MarginCallExposure.MarginCallExposureImpl(this);
		}
		
		@Override
		public MarginCallExposure.MarginCallExposureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallExposure.MarginCallExposureBuilder prune() {
			super.prune();
			if (overallExposure!=null && !overallExposure.prune().hasData()) overallExposure = null;
			if (simmIMExposure!=null && !simmIMExposure.prune().hasData()) simmIMExposure = null;
			if (scheduleGridIMExposure!=null && !scheduleGridIMExposure.prune().hasData()) scheduleGridIMExposure = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOverallExposure()!=null && getOverallExposure().hasData()) return true;
			if (getSimmIMExposure()!=null && getSimmIMExposure().hasData()) return true;
			if (getScheduleGridIMExposure()!=null && getScheduleGridIMExposure().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallExposure.MarginCallExposureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MarginCallExposure.MarginCallExposureBuilder o = (MarginCallExposure.MarginCallExposureBuilder) other;
			
			merger.mergeRosetta(getOverallExposure(), o.getOverallExposure(), this::setOverallExposure);
			merger.mergeRosetta(getSimmIMExposure(), o.getSimmIMExposure(), this::setSimmIMExposure);
			merger.mergeRosetta(getScheduleGridIMExposure(), o.getScheduleGridIMExposure(), this::setScheduleGridIMExposure);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarginCallExposure _that = getType().cast(o);
		
			if (!Objects.equals(overallExposure, _that.getOverallExposure())) return false;
			if (!Objects.equals(simmIMExposure, _that.getSimmIMExposure())) return false;
			if (!Objects.equals(scheduleGridIMExposure, _that.getScheduleGridIMExposure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (overallExposure != null ? overallExposure.hashCode() : 0);
			_result = 31 * _result + (simmIMExposure != null ? simmIMExposure.hashCode() : 0);
			_result = 31 * _result + (scheduleGridIMExposure != null ? scheduleGridIMExposure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallExposureBuilder {" +
				"overallExposure=" + this.overallExposure + ", " +
				"simmIMExposure=" + this.simmIMExposure + ", " +
				"scheduleGridIMExposure=" + this.scheduleGridIMExposure +
			'}' + " " + super.toString();
		}
	}
}
