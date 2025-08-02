package cdm.base.datetime;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder;
import cdm.base.datetime.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl;
import cdm.base.datetime.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessCenters.BusinessCentersBuilder;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetImpl;
import cdm.base.datetime.meta.AdjustedRelativeDateOffsetMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.model.metafields.ReferenceWithMetaDate;
import com.rosetta.model.metafields.ReferenceWithMetaDate.ReferenceWithMetaDateBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 * @version 6.0.0
 */
@RosettaDataType(value="AdjustedRelativeDateOffset", builder=AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AdjustedRelativeDateOffset", model="Just another Rosetta model", builder=AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl.class, version="6.0.0")
public interface AdjustedRelativeDateOffset extends RelativeDateOffset {

	AdjustedRelativeDateOffsetMeta metaData = new AdjustedRelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getRelativeDateAdjustments();

	/*********************** Build Methods  ***********************/
	AdjustedRelativeDateOffset build();
	
	AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder();
	
	static AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder() {
		return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustedRelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustedRelativeDateOffset> getType() {
		return AdjustedRelativeDateOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, ReferenceWithMetaDate.class, getDateRelativeTo());
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.class, getRelativeDateAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustedRelativeDateOffsetBuilder extends AdjustedRelativeDateOffset, RelativeDateOffset.RelativeDateOffsetBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields meta);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate dateRelativeTo);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo);
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, ReferenceWithMetaDate.ReferenceWithMetaDateBuilder.class, getDateRelativeTo());
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
			processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getRelativeDateAdjustments());
		}
		

		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements AdjustedRelativeDateOffset {
		private final BusinessDayAdjustments relativeDateAdjustments;
		
		protected AdjustedRelativeDateOffsetImpl(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super(builder);
			this.relativeDateAdjustments = ofNullable(builder.getRelativeDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		@RuneAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelativeDateAdjustments()).ifPresent(builder::setRelativeDateAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffset {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl implements AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder relativeDateAdjustments;
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		@RuneAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (relativeDateAdjustments!=null) {
				result = relativeDateAdjustments;
			}
			else {
				result = relativeDateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@RuneAttribute("periodMultiplier")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@Override
		@RosettaAttribute("period")
		@RuneAttribute("period")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@RuneAttribute("dayType")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@RuneAttribute("businessDayConvention")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@RuneAttribute("businessCenters")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@RuneAttribute("businessCentersReference")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters _businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(_businessCentersReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@RuneAttribute("dateRelativeTo")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate _dateRelativeTo) {
			this.dateRelativeTo = _dateRelativeTo == null ? null : _dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeToValue(Date _dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(_dateRelativeTo);
			return this;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(Date _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		@RuneAttribute("relativeDateAdjustments")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments _relativeDateAdjustments) {
			this.relativeDateAdjustments = _relativeDateAdjustments == null ? null : _relativeDateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl(this);
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune() {
			super.prune();
			if (relativeDateAdjustments!=null && !relativeDateAdjustments.prune().hasData()) relativeDateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelativeDateAdjustments()!=null && getRelativeDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder o = (AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getRelativeDateAdjustments(), o.getRelativeDateAdjustments(), this::setRelativeDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffsetBuilder {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}
}
