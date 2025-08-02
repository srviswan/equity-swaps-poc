package cdm.product.collateral;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder;
import cdm.product.asset.FloatingRateBase;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilder;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilderImpl;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseImpl;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.collateral.CollateralAgreementFloatingRate;
import cdm.product.collateral.CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder;
import cdm.product.collateral.CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilderImpl;
import cdm.product.collateral.CollateralAgreementFloatingRate.CollateralAgreementFloatingRateImpl;
import cdm.product.collateral.meta.CollateralAgreementFloatingRateMeta;
import cdm.product.template.StrikeSchedule;
import cdm.product.template.StrikeSchedule.StrikeScheduleBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Represents the parameters needed to calculate the floating rate paid on collateral holdings.
 * @version 6.0.0
 */
@RosettaDataType(value="CollateralAgreementFloatingRate", builder=CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CollateralAgreementFloatingRate", model="Just another Rosetta model", builder=CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilderImpl.class, version="6.0.0")
public interface CollateralAgreementFloatingRate extends FloatingRateBase {

	CollateralAgreementFloatingRateMeta metaData = new CollateralAgreementFloatingRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies how negative rates should be applied.  If rates go negative, should the payment be reversed (true) or zeroed out (false)?
	 */
	Boolean getNegativeInterest();
	/**
	 * Specifies how spreads should be applied in a low/negative rate environment.  If true, spread is applied only if rate is positive.
	 */
	Boolean getCompressibleSpread();

	/*********************** Build Methods  ***********************/
	CollateralAgreementFloatingRate build();
	
	CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder toBuilder();
	
	static CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder builder() {
		return new CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAgreementFloatingRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralAgreementFloatingRate> getType() {
		return CollateralAgreementFloatingRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.class, getRateOption());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processor.processBasic(path.newSubPath("negativeInterest"), Boolean.class, getNegativeInterest(), this);
		processor.processBasic(path.newSubPath("compressibleSpread"), Boolean.class, getCompressibleSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralAgreementFloatingRateBuilder extends CollateralAgreementFloatingRate, FloatingRateBase.FloatingRateBaseBuilder {
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setRateOption(ReferenceWithMetaInterestRateIndex rateOption);
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setRateOptionValue(InterestRateIndex rateOption);
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setMeta(MetaFields meta);
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setNegativeInterest(Boolean negativeInterest);
		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setCompressibleSpread(Boolean compressibleSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder.class, getRateOption());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processor.processBasic(path.newSubPath("negativeInterest"), Boolean.class, getNegativeInterest(), this);
			processor.processBasic(path.newSubPath("compressibleSpread"), Boolean.class, getCompressibleSpread(), this);
		}
		

		CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAgreementFloatingRate  ***********************/
	class CollateralAgreementFloatingRateImpl extends FloatingRateBase.FloatingRateBaseImpl implements CollateralAgreementFloatingRate {
		private final Boolean negativeInterest;
		private final Boolean compressibleSpread;
		
		protected CollateralAgreementFloatingRateImpl(CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder builder) {
			super(builder);
			this.negativeInterest = builder.getNegativeInterest();
			this.compressibleSpread = builder.getCompressibleSpread();
		}
		
		@Override
		@RosettaAttribute("negativeInterest")
		@RuneAttribute("negativeInterest")
		public Boolean getNegativeInterest() {
			return negativeInterest;
		}
		
		@Override
		@RosettaAttribute("compressibleSpread")
		@RuneAttribute("compressibleSpread")
		public Boolean getCompressibleSpread() {
			return compressibleSpread;
		}
		
		@Override
		public CollateralAgreementFloatingRate build() {
			return this;
		}
		
		@Override
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder toBuilder() {
			CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNegativeInterest()).ifPresent(builder::setNegativeInterest);
			ofNullable(getCompressibleSpread()).ifPresent(builder::setCompressibleSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralAgreementFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(negativeInterest, _that.getNegativeInterest())) return false;
			if (!Objects.equals(compressibleSpread, _that.getCompressibleSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (negativeInterest != null ? negativeInterest.hashCode() : 0);
			_result = 31 * _result + (compressibleSpread != null ? compressibleSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAgreementFloatingRate {" +
				"negativeInterest=" + this.negativeInterest + ", " +
				"compressibleSpread=" + this.compressibleSpread +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAgreementFloatingRate  ***********************/
	class CollateralAgreementFloatingRateBuilderImpl extends FloatingRateBase.FloatingRateBaseBuilderImpl implements CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder {
	
		protected Boolean negativeInterest;
		protected Boolean compressibleSpread;
		
		@Override
		@RosettaAttribute("negativeInterest")
		@RuneAttribute("negativeInterest")
		public Boolean getNegativeInterest() {
			return negativeInterest;
		}
		
		@Override
		@RosettaAttribute("compressibleSpread")
		@RuneAttribute("compressibleSpread")
		public Boolean getCompressibleSpread() {
			return compressibleSpread;
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setRateOption(ReferenceWithMetaInterestRateIndex _rateOption) {
			this.rateOption = _rateOption == null ? null : _rateOption.toBuilder();
			return this;
		}
		
		@Override
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setRateOptionValue(InterestRateIndex _rateOption) {
			this.getOrCreateRateOption().setValue(_rateOption);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setSpreadSchedule(SpreadSchedule _spreadSchedule) {
			this.spreadSchedule = _spreadSchedule == null ? null : _spreadSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setCapRateSchedule(StrikeSchedule _capRateSchedule) {
			this.capRateSchedule = _capRateSchedule == null ? null : _capRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			this.floorRateSchedule = _floorRateSchedule == null ? null : _floorRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("negativeInterest")
		@RuneAttribute("negativeInterest")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setNegativeInterest(Boolean _negativeInterest) {
			this.negativeInterest = _negativeInterest == null ? null : _negativeInterest;
			return this;
		}
		
		@Override
		@RosettaAttribute("compressibleSpread")
		@RuneAttribute("compressibleSpread")
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder setCompressibleSpread(Boolean _compressibleSpread) {
			this.compressibleSpread = _compressibleSpread == null ? null : _compressibleSpread;
			return this;
		}
		
		@Override
		public CollateralAgreementFloatingRate build() {
			return new CollateralAgreementFloatingRate.CollateralAgreementFloatingRateImpl(this);
		}
		
		@Override
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNegativeInterest()!=null) return true;
			if (getCompressibleSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder o = (CollateralAgreementFloatingRate.CollateralAgreementFloatingRateBuilder) other;
			
			
			merger.mergeBasic(getNegativeInterest(), o.getNegativeInterest(), this::setNegativeInterest);
			merger.mergeBasic(getCompressibleSpread(), o.getCompressibleSpread(), this::setCompressibleSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralAgreementFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(negativeInterest, _that.getNegativeInterest())) return false;
			if (!Objects.equals(compressibleSpread, _that.getCompressibleSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (negativeInterest != null ? negativeInterest.hashCode() : 0);
			_result = 31 * _result + (compressibleSpread != null ? compressibleSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAgreementFloatingRateBuilder {" +
				"negativeInterest=" + this.negativeInterest + ", " +
				"compressibleSpread=" + this.compressibleSpread +
			'}' + " " + super.toString();
		}
	}
}
