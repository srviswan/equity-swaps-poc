package cdm.base.datetime;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessCenters.BusinessCentersBuilder;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.Offset;
import cdm.base.datetime.Offset.OffsetBuilder;
import cdm.base.datetime.Offset.OffsetBuilderImpl;
import cdm.base.datetime.Offset.OffsetImpl;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetImpl;
import cdm.base.datetime.meta.RelativeDateOffsetMeta;
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
 * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 * @version 6.0.0
 */
@RosettaDataType(value="RelativeDateOffset", builder=RelativeDateOffset.RelativeDateOffsetBuilderImpl.class, version="6.0.0")
@RuneDataType(value="RelativeDateOffset", model="Just another Rosetta model", builder=RelativeDateOffset.RelativeDateOffsetBuilderImpl.class, version="6.0.0")
public interface RelativeDateOffset extends Offset {

	RelativeDateOffsetMeta metaData = new RelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	BusinessCenters getBusinessCenters();
	/**
	 * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 */
	ReferenceWithMetaBusinessCenters getBusinessCentersReference();
	/**
	 * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 */
	ReferenceWithMetaDate getDateRelativeTo();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	Date getAdjustedDate();

	/*********************** Build Methods  ***********************/
	RelativeDateOffset build();
	
	RelativeDateOffset.RelativeDateOffsetBuilder toBuilder();
	
	static RelativeDateOffset.RelativeDateOffsetBuilder builder() {
		return new RelativeDateOffset.RelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelativeDateOffset> getType() {
		return RelativeDateOffset.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDateOffsetBuilder extends RelativeDateOffset, Offset.OffsetBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference();
		@Override
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference();
		ReferenceWithMetaDate.ReferenceWithMetaDateBuilder getOrCreateDateRelativeTo();
		@Override
		ReferenceWithMetaDate.ReferenceWithMetaDateBuilder getDateRelativeTo();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setMeta(MetaFields meta);
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate);

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
		}
		

		RelativeDateOffset.RelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetImpl extends Offset.OffsetImpl implements RelativeDateOffset {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCenters businessCenters;
		private final ReferenceWithMetaBusinessCenters businessCentersReference;
		private final ReferenceWithMetaDate dateRelativeTo;
		private final Date adjustedDate;
		
		protected RelativeDateOffsetImpl(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super(builder);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.adjustedDate = builder.getAdjustedDate();
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@RuneAttribute("businessCentersReference")
		public ReferenceWithMetaBusinessCenters getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@RuneAttribute("dateRelativeTo")
		public ReferenceWithMetaDate getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public Date getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public RelativeDateOffset build() {
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			RelativeDateOffset.RelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffset {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RelativeDateOffset  ***********************/
	class RelativeDateOffsetBuilderImpl extends Offset.OffsetBuilderImpl implements RelativeDateOffset.RelativeDateOffsetBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder businessCentersReference;
		protected ReferenceWithMetaDate.ReferenceWithMetaDateBuilder dateRelativeTo;
		protected Date adjustedDate;
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@RuneAttribute("businessCentersReference")
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference() {
			ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = ReferenceWithMetaBusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@RuneAttribute("dateRelativeTo")
		public ReferenceWithMetaDate.ReferenceWithMetaDateBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public ReferenceWithMetaDate.ReferenceWithMetaDateBuilder getOrCreateDateRelativeTo() {
			ReferenceWithMetaDate.ReferenceWithMetaDateBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = ReferenceWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public Date getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		@RuneAttribute("periodMultiplier")
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@Override
		@RosettaAttribute("period")
		@RuneAttribute("period")
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public RelativeDateOffset.RelativeDateOffsetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@RuneAttribute("dayType")
		public RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@RuneAttribute("businessDayConvention")
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@RuneAttribute("businessCenters")
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@RuneAttribute("businessCentersReference")
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters _businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(_businessCentersReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@RuneAttribute("dateRelativeTo")
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(ReferenceWithMetaDate _dateRelativeTo) {
			this.dateRelativeTo = _dateRelativeTo == null ? null : _dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeToValue(Date _dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(_dateRelativeTo);
			return this;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(Date _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@Override
		public RelativeDateOffset build() {
			return new RelativeDateOffset.RelativeDateOffsetImpl(this);
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder prune() {
			super.prune();
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getDateRelativeTo()!=null) return true;
			if (getAdjustedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RelativeDateOffset.RelativeDateOffsetBuilder o = (RelativeDateOffset.RelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffsetBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}' + " " + super.toString();
		}
	}
}
