package cdm.event.workflow;

import cdm.event.workflow.CreditLimitTypeEnum;
import cdm.event.workflow.CreditLimitUtilisation;
import cdm.event.workflow.CreditLimitUtilisation.CreditLimitUtilisationBuilder;
import cdm.event.workflow.LimitApplicable;
import cdm.event.workflow.LimitApplicable.LimitApplicableBuilder;
import cdm.event.workflow.LimitApplicable.LimitApplicableBuilderImpl;
import cdm.event.workflow.LimitApplicable.LimitApplicableImpl;
import cdm.event.workflow.LimitApplicableExtended;
import cdm.event.workflow.LimitApplicableExtended.LimitApplicableExtendedBuilder;
import cdm.event.workflow.LimitApplicableExtended.LimitApplicableExtendedBuilderImpl;
import cdm.event.workflow.LimitApplicableExtended.LimitApplicableExtendedImpl;
import cdm.event.workflow.LimitLevelEnum;
import cdm.event.workflow.Velocity;
import cdm.event.workflow.Velocity.VelocityBuilder;
import cdm.event.workflow.meta.LimitApplicableExtendedMeta;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder;
import cdm.event.workflow.metafields.FieldWithMetaLimitLevelEnum;
import cdm.event.workflow.metafields.FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to represent the CDM attributes that are not part of the FpML standard. Once broader usage is confirmed, it is expected that those two classes can be collapsed.
 * @version 6.0.0
 */
@RosettaDataType(value="LimitApplicableExtended", builder=LimitApplicableExtended.LimitApplicableExtendedBuilderImpl.class, version="6.0.0")
@RuneDataType(value="LimitApplicableExtended", model="Just another Rosetta model", builder=LimitApplicableExtended.LimitApplicableExtendedBuilderImpl.class, version="6.0.0")
public interface LimitApplicableExtended extends LimitApplicable {

	LimitApplicableExtendedMeta metaData = new LimitApplicableExtendedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The level at which the limit is set: customer business, proprietary business or account level. This attribute is specified as a string as part of the CME clearing confirmation specification.
	 */
	FieldWithMetaLimitLevelEnum getLimitLevel();
	/**
	 * The total limit available for the limit level and limit type. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getLimitAmount();
	/**
	 * The limit utilized by this specific trade. While the attribute is of type integer in the CME schema, it has been specified to be of type number in the CDM to take into consideration java size limits as well as for consistency purposes with the way most monetary amounts are expressed.
	 */
	BigDecimal getLimitImpactDueToTrade();

	/*********************** Build Methods  ***********************/
	LimitApplicableExtended build();
	
	LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder();
	
	static LimitApplicableExtended.LimitApplicableExtendedBuilder builder() {
		return new LimitApplicableExtended.LimitApplicableExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LimitApplicableExtended> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LimitApplicableExtended> getType() {
		return LimitApplicableExtended.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("limitType"), processor, FieldWithMetaCreditLimitTypeEnum.class, getLimitType());
		processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
		processor.processBasic(path.newSubPath("amountUtilized"), BigDecimal.class, getAmountUtilized(), this);
		processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilisation.class, getUtilization());
		processor.processBasic(path.newSubPath("amountRemaining"), BigDecimal.class, getAmountRemaining(), this);
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("velocity"), processor, Velocity.class, getVelocity());
		processRosetta(path.newSubPath("limitLevel"), processor, FieldWithMetaLimitLevelEnum.class, getLimitLevel());
		processor.processBasic(path.newSubPath("limitAmount"), BigDecimal.class, getLimitAmount(), this);
		processor.processBasic(path.newSubPath("limitImpactDueToTrade"), BigDecimal.class, getLimitImpactDueToTrade(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LimitApplicableExtendedBuilder extends LimitApplicableExtended, LimitApplicable.LimitApplicableBuilder {
		FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder getOrCreateLimitLevel();
		@Override
		FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder getLimitLevel();
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum limitType);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitTypeValue(CreditLimitTypeEnum limitType);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setClipSize(Integer clipSize);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountUtilized(BigDecimal amountUtilized);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setUtilization(CreditLimitUtilisation utilization);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountRemaining(BigDecimal amountRemaining);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrency(FieldWithMetaString currency);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrencyValue(String currency);
		@Override
		LimitApplicableExtended.LimitApplicableExtendedBuilder setVelocity(Velocity velocity);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevel(FieldWithMetaLimitLevelEnum limitLevel);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevelValue(LimitLevelEnum limitLevel);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitAmount(BigDecimal limitAmount);
		LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitImpactDueToTrade(BigDecimal limitImpactDueToTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("limitType"), processor, FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder.class, getLimitType());
			processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
			processor.processBasic(path.newSubPath("amountUtilized"), BigDecimal.class, getAmountUtilized(), this);
			processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilisation.CreditLimitUtilisationBuilder.class, getUtilization());
			processor.processBasic(path.newSubPath("amountRemaining"), BigDecimal.class, getAmountRemaining(), this);
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("velocity"), processor, Velocity.VelocityBuilder.class, getVelocity());
			processRosetta(path.newSubPath("limitLevel"), processor, FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder.class, getLimitLevel());
			processor.processBasic(path.newSubPath("limitAmount"), BigDecimal.class, getLimitAmount(), this);
			processor.processBasic(path.newSubPath("limitImpactDueToTrade"), BigDecimal.class, getLimitImpactDueToTrade(), this);
		}
		

		LimitApplicableExtended.LimitApplicableExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of LimitApplicableExtended  ***********************/
	class LimitApplicableExtendedImpl extends LimitApplicable.LimitApplicableImpl implements LimitApplicableExtended {
		private final FieldWithMetaLimitLevelEnum limitLevel;
		private final BigDecimal limitAmount;
		private final BigDecimal limitImpactDueToTrade;
		
		protected LimitApplicableExtendedImpl(LimitApplicableExtended.LimitApplicableExtendedBuilder builder) {
			super(builder);
			this.limitLevel = ofNullable(builder.getLimitLevel()).map(f->f.build()).orElse(null);
			this.limitAmount = builder.getLimitAmount();
			this.limitImpactDueToTrade = builder.getLimitImpactDueToTrade();
		}
		
		@Override
		@RosettaAttribute("limitLevel")
		@RuneAttribute("limitLevel")
		public FieldWithMetaLimitLevelEnum getLimitLevel() {
			return limitLevel;
		}
		
		@Override
		@RosettaAttribute("limitAmount")
		@RuneAttribute("limitAmount")
		public BigDecimal getLimitAmount() {
			return limitAmount;
		}
		
		@Override
		@RosettaAttribute("limitImpactDueToTrade")
		@RuneAttribute("limitImpactDueToTrade")
		public BigDecimal getLimitImpactDueToTrade() {
			return limitImpactDueToTrade;
		}
		
		@Override
		public LimitApplicableExtended build() {
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder() {
			LimitApplicableExtended.LimitApplicableExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitApplicableExtended.LimitApplicableExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLimitLevel()).ifPresent(builder::setLimitLevel);
			ofNullable(getLimitAmount()).ifPresent(builder::setLimitAmount);
			ofNullable(getLimitImpactDueToTrade()).ifPresent(builder::setLimitImpactDueToTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LimitApplicableExtended _that = getType().cast(o);
		
			if (!Objects.equals(limitLevel, _that.getLimitLevel())) return false;
			if (!Objects.equals(limitAmount, _that.getLimitAmount())) return false;
			if (!Objects.equals(limitImpactDueToTrade, _that.getLimitImpactDueToTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitLevel != null ? limitLevel.hashCode() : 0);
			_result = 31 * _result + (limitAmount != null ? limitAmount.hashCode() : 0);
			_result = 31 * _result + (limitImpactDueToTrade != null ? limitImpactDueToTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableExtended {" +
				"limitLevel=" + this.limitLevel + ", " +
				"limitAmount=" + this.limitAmount + ", " +
				"limitImpactDueToTrade=" + this.limitImpactDueToTrade +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LimitApplicableExtended  ***********************/
	class LimitApplicableExtendedBuilderImpl extends LimitApplicable.LimitApplicableBuilderImpl implements LimitApplicableExtended.LimitApplicableExtendedBuilder {
	
		protected FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder limitLevel;
		protected BigDecimal limitAmount;
		protected BigDecimal limitImpactDueToTrade;
		
		@Override
		@RosettaAttribute("limitLevel")
		@RuneAttribute("limitLevel")
		public FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder getLimitLevel() {
			return limitLevel;
		}
		
		@Override
		public FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder getOrCreateLimitLevel() {
			FieldWithMetaLimitLevelEnum.FieldWithMetaLimitLevelEnumBuilder result;
			if (limitLevel!=null) {
				result = limitLevel;
			}
			else {
				result = limitLevel = FieldWithMetaLimitLevelEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("limitAmount")
		@RuneAttribute("limitAmount")
		public BigDecimal getLimitAmount() {
			return limitAmount;
		}
		
		@Override
		@RosettaAttribute("limitImpactDueToTrade")
		@RuneAttribute("limitImpactDueToTrade")
		public BigDecimal getLimitImpactDueToTrade() {
			return limitImpactDueToTrade;
		}
		
		@Override
		@RosettaAttribute("limitType")
		@RuneAttribute("limitType")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitType(FieldWithMetaCreditLimitTypeEnum _limitType) {
			this.limitType = _limitType == null ? null : _limitType.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitTypeValue(CreditLimitTypeEnum _limitType) {
			this.getOrCreateLimitType().setValue(_limitType);
			return this;
		}
		
		@Override
		@RosettaAttribute("clipSize")
		@RuneAttribute("clipSize")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setClipSize(Integer _clipSize) {
			this.clipSize = _clipSize == null ? null : _clipSize;
			return this;
		}
		
		@Override
		@RosettaAttribute("amountUtilized")
		@RuneAttribute("amountUtilized")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountUtilized(BigDecimal _amountUtilized) {
			this.amountUtilized = _amountUtilized == null ? null : _amountUtilized;
			return this;
		}
		
		@Override
		@RosettaAttribute("utilization")
		@RuneAttribute("utilization")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setUtilization(CreditLimitUtilisation _utilization) {
			this.utilization = _utilization == null ? null : _utilization.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("amountRemaining")
		@RuneAttribute("amountRemaining")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setAmountRemaining(BigDecimal _amountRemaining) {
			this.amountRemaining = _amountRemaining == null ? null : _amountRemaining;
			return this;
		}
		
		@Override
		@RosettaAttribute("currency")
		@RuneAttribute("currency")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrency(FieldWithMetaString _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setCurrencyValue(String _currency) {
			this.getOrCreateCurrency().setValue(_currency);
			return this;
		}
		
		@Override
		@RosettaAttribute("velocity")
		@RuneAttribute("velocity")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setVelocity(Velocity _velocity) {
			this.velocity = _velocity == null ? null : _velocity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("limitLevel")
		@RuneAttribute("limitLevel")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevel(FieldWithMetaLimitLevelEnum _limitLevel) {
			this.limitLevel = _limitLevel == null ? null : _limitLevel.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitLevelValue(LimitLevelEnum _limitLevel) {
			this.getOrCreateLimitLevel().setValue(_limitLevel);
			return this;
		}
		
		@Override
		@RosettaAttribute("limitAmount")
		@RuneAttribute("limitAmount")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitAmount(BigDecimal _limitAmount) {
			this.limitAmount = _limitAmount == null ? null : _limitAmount;
			return this;
		}
		
		@Override
		@RosettaAttribute("limitImpactDueToTrade")
		@RuneAttribute("limitImpactDueToTrade")
		public LimitApplicableExtended.LimitApplicableExtendedBuilder setLimitImpactDueToTrade(BigDecimal _limitImpactDueToTrade) {
			this.limitImpactDueToTrade = _limitImpactDueToTrade == null ? null : _limitImpactDueToTrade;
			return this;
		}
		
		@Override
		public LimitApplicableExtended build() {
			return new LimitApplicableExtended.LimitApplicableExtendedImpl(this);
		}
		
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder prune() {
			super.prune();
			if (limitLevel!=null && !limitLevel.prune().hasData()) limitLevel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLimitLevel()!=null) return true;
			if (getLimitAmount()!=null) return true;
			if (getLimitImpactDueToTrade()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicableExtended.LimitApplicableExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LimitApplicableExtended.LimitApplicableExtendedBuilder o = (LimitApplicableExtended.LimitApplicableExtendedBuilder) other;
			
			merger.mergeRosetta(getLimitLevel(), o.getLimitLevel(), this::setLimitLevel);
			
			merger.mergeBasic(getLimitAmount(), o.getLimitAmount(), this::setLimitAmount);
			merger.mergeBasic(getLimitImpactDueToTrade(), o.getLimitImpactDueToTrade(), this::setLimitImpactDueToTrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LimitApplicableExtended _that = getType().cast(o);
		
			if (!Objects.equals(limitLevel, _that.getLimitLevel())) return false;
			if (!Objects.equals(limitAmount, _that.getLimitAmount())) return false;
			if (!Objects.equals(limitImpactDueToTrade, _that.getLimitImpactDueToTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (limitLevel != null ? limitLevel.hashCode() : 0);
			_result = 31 * _result + (limitAmount != null ? limitAmount.hashCode() : 0);
			_result = 31 * _result + (limitImpactDueToTrade != null ? limitImpactDueToTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableExtendedBuilder {" +
				"limitLevel=" + this.limitLevel + ", " +
				"limitAmount=" + this.limitAmount + ", " +
				"limitImpactDueToTrade=" + this.limitImpactDueToTrade +
			'}' + " " + super.toString();
		}
	}
}
