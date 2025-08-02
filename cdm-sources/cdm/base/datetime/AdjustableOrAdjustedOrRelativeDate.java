package cdm.base.datetime;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateImpl;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.datetime.meta.AdjustableOrAdjustedOrRelativeDateMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
 * @version 6.0.0
 */
@RosettaDataType(value="AdjustableOrAdjustedOrRelativeDate", builder=AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AdjustableOrAdjustedOrRelativeDate", model="Just another Rosetta model", builder=AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl.class, version="6.0.0")
public interface AdjustableOrAdjustedOrRelativeDate extends RosettaModelObject {

	AdjustableOrAdjustedOrRelativeDateMeta metaData = new AdjustableOrAdjustedOrRelativeDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment.
	 */
	Date getUnadjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	FieldWithMetaDate getAdjustedDate();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();

	/*********************** Build Methods  ***********************/
	AdjustableOrAdjustedOrRelativeDate build();
	
	AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder();
	
	static AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder() {
		return new AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrAdjustedOrRelativeDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableOrAdjustedOrRelativeDate> getType() {
		return AdjustableOrAdjustedOrRelativeDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrAdjustedOrRelativeDateBuilder extends AdjustableOrAdjustedOrRelativeDate, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateAdjustedDate();
		@Override
		FieldWithMetaDate.FieldWithMetaDateBuilder getAdjustedDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setUnadjustedDate(Date unadjustedDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDate(FieldWithMetaDate adjustedDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDateValue(Date adjustedDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.FieldWithMetaDateBuilder.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
		}
		

		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrAdjustedOrRelativeDate  ***********************/
	class AdjustableOrAdjustedOrRelativeDateImpl implements AdjustableOrAdjustedOrRelativeDate {
		private final Date unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final FieldWithMetaDate adjustedDate;
		private final RelativeDateOffset relativeDate;
		
		protected AdjustableOrAdjustedOrRelativeDateImpl(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder) {
			this.unadjustedDate = builder.getUnadjustedDate();
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@RuneAttribute("unadjustedDate")
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public FieldWithMetaDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		@RuneAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder() {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedOrRelativeDate {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrAdjustedOrRelativeDate  ***********************/
	class AdjustableOrAdjustedOrRelativeDateBuilderImpl implements AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder {
	
		protected Date unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected FieldWithMetaDate.FieldWithMetaDateBuilder adjustedDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@RuneAttribute("unadjustedDate")
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public FieldWithMetaDate.FieldWithMetaDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateAdjustedDate() {
			FieldWithMetaDate.FieldWithMetaDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		@RuneAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@RuneAttribute("unadjustedDate")
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setUnadjustedDate(Date _unadjustedDate) {
			this.unadjustedDate = _unadjustedDate == null ? null : _unadjustedDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDate(FieldWithMetaDate _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setAdjustedDateValue(Date _adjustedDate) {
			this.getOrCreateAdjustedDate().setValue(_adjustedDate);
			return this;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		@RuneAttribute("relativeDate")
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder setRelativeDate(RelativeDateOffset _relativeDate) {
			this.relativeDate = _relativeDate == null ? null : _relativeDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate build() {
			return new AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateImpl(this);
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder o = (AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedOrRelativeDateBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
}
