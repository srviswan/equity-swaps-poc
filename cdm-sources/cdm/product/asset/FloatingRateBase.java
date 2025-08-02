package cdm.product.asset;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder;
import cdm.product.asset.FloatingRateBase;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilder;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseBuilderImpl;
import cdm.product.asset.FloatingRateBase.FloatingRateBaseImpl;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.asset.meta.FloatingRateBaseMeta;
import cdm.product.template.StrikeSchedule;
import cdm.product.template.StrikeSchedule.StrikeScheduleBuilder;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
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
 * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
 * @version 6.0.0
 */
@RosettaDataType(value="FloatingRateBase", builder=FloatingRateBase.FloatingRateBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRateBase", model="Just another Rosetta model", builder=FloatingRateBase.FloatingRateBaseBuilderImpl.class, version="6.0.0")
public interface FloatingRateBase extends RosettaModelObject, GlobalKey {

	FloatingRateBaseMeta metaData = new FloatingRateBaseMeta();

	/*********************** Getter Methods  ***********************/
	ReferenceWithMetaInterestRateIndex getRateOption();
	/**
	 * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	SpreadSchedule getSpreadSchedule();
	/**
	 * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 */
	StrikeSchedule getCapRateSchedule();
	/**
	 * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 */
	StrikeSchedule getFloorRateSchedule();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FloatingRateBase build();
	
	FloatingRateBase.FloatingRateBaseBuilder toBuilder();
	
	static FloatingRateBase.FloatingRateBaseBuilder builder() {
		return new FloatingRateBase.FloatingRateBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateBase> getType() {
		return FloatingRateBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.class, getRateOption());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateBaseBuilder extends FloatingRateBase, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder getOrCreateRateOption();
		@Override
		ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder getRateOption();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule();
		@Override
		SpreadSchedule.SpreadScheduleBuilder getSpreadSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule();
		@Override
		StrikeSchedule.StrikeScheduleBuilder getCapRateSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule();
		@Override
		StrikeSchedule.StrikeScheduleBuilder getFloorRateSchedule();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FloatingRateBase.FloatingRateBaseBuilder setRateOption(ReferenceWithMetaInterestRateIndex rateOption);
		FloatingRateBase.FloatingRateBaseBuilder setRateOptionValue(InterestRateIndex rateOption);
		FloatingRateBase.FloatingRateBaseBuilder setSpreadSchedule(SpreadSchedule spreadSchedule);
		FloatingRateBase.FloatingRateBaseBuilder setCapRateSchedule(StrikeSchedule capRateSchedule);
		FloatingRateBase.FloatingRateBaseBuilder setFloorRateSchedule(StrikeSchedule floorRateSchedule);
		FloatingRateBase.FloatingRateBaseBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder.class, getRateOption());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FloatingRateBase.FloatingRateBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateBase  ***********************/
	class FloatingRateBaseImpl implements FloatingRateBase {
		private final ReferenceWithMetaInterestRateIndex rateOption;
		private final SpreadSchedule spreadSchedule;
		private final StrikeSchedule capRateSchedule;
		private final StrikeSchedule floorRateSchedule;
		private final MetaFields meta;
		
		protected FloatingRateBaseImpl(FloatingRateBase.FloatingRateBaseBuilder builder) {
			this.rateOption = ofNullable(builder.getRateOption()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).map(f->f.build()).orElse(null);
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).map(f->f.build()).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public ReferenceWithMetaInterestRateIndex getRateOption() {
			return rateOption;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public SpreadSchedule getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public StrikeSchedule getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public StrikeSchedule getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FloatingRateBase build() {
			return this;
		}
		
		@Override
		public FloatingRateBase.FloatingRateBaseBuilder toBuilder() {
			FloatingRateBase.FloatingRateBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateBase.FloatingRateBaseBuilder builder) {
			ofNullable(getRateOption()).ifPresent(builder::setRateOption);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateBase _that = getType().cast(o);
		
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			if (!Objects.equals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateBase {" +
				"rateOption=" + this.rateOption + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateBase  ***********************/
	class FloatingRateBaseBuilderImpl implements FloatingRateBase.FloatingRateBaseBuilder {
	
		protected ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder rateOption;
		protected SpreadSchedule.SpreadScheduleBuilder spreadSchedule;
		protected StrikeSchedule.StrikeScheduleBuilder capRateSchedule;
		protected StrikeSchedule.StrikeScheduleBuilder floorRateSchedule;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder getRateOption() {
			return rateOption;
		}
		
		@Override
		public ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder getOrCreateRateOption() {
			ReferenceWithMetaInterestRateIndex.ReferenceWithMetaInterestRateIndexBuilder result;
			if (rateOption!=null) {
				result = rateOption;
			}
			else {
				result = rateOption = ReferenceWithMetaInterestRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public SpreadSchedule.SpreadScheduleBuilder getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule() {
			SpreadSchedule.SpreadScheduleBuilder result;
			if (spreadSchedule!=null) {
				result = spreadSchedule;
			}
			else {
				result = spreadSchedule = SpreadSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public StrikeSchedule.StrikeScheduleBuilder getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule() {
			StrikeSchedule.StrikeScheduleBuilder result;
			if (capRateSchedule!=null) {
				result = capRateSchedule;
			}
			else {
				result = capRateSchedule = StrikeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public StrikeSchedule.StrikeScheduleBuilder getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule() {
			StrikeSchedule.StrikeScheduleBuilder result;
			if (floorRateSchedule!=null) {
				result = floorRateSchedule;
			}
			else {
				result = floorRateSchedule = StrikeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateOption")
		@RuneAttribute("rateOption")
		public FloatingRateBase.FloatingRateBaseBuilder setRateOption(ReferenceWithMetaInterestRateIndex _rateOption) {
			this.rateOption = _rateOption == null ? null : _rateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateBase.FloatingRateBaseBuilder setRateOptionValue(InterestRateIndex _rateOption) {
			this.getOrCreateRateOption().setValue(_rateOption);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@RuneAttribute("spreadSchedule")
		public FloatingRateBase.FloatingRateBaseBuilder setSpreadSchedule(SpreadSchedule _spreadSchedule) {
			this.spreadSchedule = _spreadSchedule == null ? null : _spreadSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@RuneAttribute("capRateSchedule")
		public FloatingRateBase.FloatingRateBaseBuilder setCapRateSchedule(StrikeSchedule _capRateSchedule) {
			this.capRateSchedule = _capRateSchedule == null ? null : _capRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@RuneAttribute("floorRateSchedule")
		public FloatingRateBase.FloatingRateBaseBuilder setFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			this.floorRateSchedule = _floorRateSchedule == null ? null : _floorRateSchedule.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public FloatingRateBase.FloatingRateBaseBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateBase build() {
			return new FloatingRateBase.FloatingRateBaseImpl(this);
		}
		
		@Override
		public FloatingRateBase.FloatingRateBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateBase.FloatingRateBaseBuilder prune() {
			if (rateOption!=null && !rateOption.prune().hasData()) rateOption = null;
			if (spreadSchedule!=null && !spreadSchedule.prune().hasData()) spreadSchedule = null;
			if (capRateSchedule!=null && !capRateSchedule.prune().hasData()) capRateSchedule = null;
			if (floorRateSchedule!=null && !floorRateSchedule.prune().hasData()) floorRateSchedule = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateOption()!=null && getRateOption().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().hasData()) return true;
			if (getCapRateSchedule()!=null && getCapRateSchedule().hasData()) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateBase.FloatingRateBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateBase.FloatingRateBaseBuilder o = (FloatingRateBase.FloatingRateBaseBuilder) other;
			
			merger.mergeRosetta(getRateOption(), o.getRateOption(), this::setRateOption);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::setSpreadSchedule);
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::setCapRateSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::setFloorRateSchedule);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateBase _that = getType().cast(o);
		
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			if (!Objects.equals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateBaseBuilder {" +
				"rateOption=" + this.rateOption + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
