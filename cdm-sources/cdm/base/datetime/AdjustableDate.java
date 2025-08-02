package cdm.base.datetime;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableDate.AdjustableDateBuilder;
import cdm.base.datetime.AdjustableDate.AdjustableDateBuilderImpl;
import cdm.base.datetime.AdjustableDate.AdjustableDateImpl;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import cdm.base.datetime.meta.AdjustableDateMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder;
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
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @version 6.0.0
 */
@RosettaDataType(value="AdjustableDate", builder=AdjustableDate.AdjustableDateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AdjustableDate", model="Just another Rosetta model", builder=AdjustableDate.AdjustableDateBuilderImpl.class, version="6.0.0")
public interface AdjustableDate extends RosettaModelObject, GlobalKey {

	AdjustableDateMeta metaData = new AdjustableDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.
	 */
	Date getUnadjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * A pointer style reference to date adjustments defined elsewhere in the document.
	 */
	ReferenceWithMetaBusinessDayAdjustments getDateAdjustmentsReference();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	FieldWithMetaDate getAdjustedDate();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	AdjustableDate build();
	
	AdjustableDate.AdjustableDateBuilder toBuilder();
	
	static AdjustableDate.AdjustableDateBuilder builder() {
		return new AdjustableDate.AdjustableDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableDate> getType() {
		return AdjustableDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("dateAdjustmentsReference"), processor, ReferenceWithMetaBusinessDayAdjustments.class, getDateAdjustmentsReference());
		processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDateBuilder extends AdjustableDate, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder getOrCreateDateAdjustmentsReference();
		@Override
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder getDateAdjustmentsReference();
		FieldWithMetaDate.FieldWithMetaDateBuilder getOrCreateAdjustedDate();
		@Override
		FieldWithMetaDate.FieldWithMetaDateBuilder getAdjustedDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableDate.AdjustableDateBuilder setUnadjustedDate(Date unadjustedDate);
		AdjustableDate.AdjustableDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDate.AdjustableDateBuilder setDateAdjustmentsReference(ReferenceWithMetaBusinessDayAdjustments dateAdjustmentsReference);
		AdjustableDate.AdjustableDateBuilder setDateAdjustmentsReferenceValue(BusinessDayAdjustments dateAdjustmentsReference);
		AdjustableDate.AdjustableDateBuilder setAdjustedDate(FieldWithMetaDate adjustedDate);
		AdjustableDate.AdjustableDateBuilder setAdjustedDateValue(Date adjustedDate);
		AdjustableDate.AdjustableDateBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("dateAdjustmentsReference"), processor, ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder.class, getDateAdjustmentsReference());
			processRosetta(path.newSubPath("adjustedDate"), processor, FieldWithMetaDate.FieldWithMetaDateBuilder.class, getAdjustedDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		AdjustableDate.AdjustableDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDate  ***********************/
	class AdjustableDateImpl implements AdjustableDate {
		private final Date unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final ReferenceWithMetaBusinessDayAdjustments dateAdjustmentsReference;
		private final FieldWithMetaDate adjustedDate;
		private final MetaFields meta;
		
		protected AdjustableDateImpl(AdjustableDate.AdjustableDateBuilder builder) {
			this.unadjustedDate = builder.getUnadjustedDate();
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.dateAdjustmentsReference = ofNullable(builder.getDateAdjustmentsReference()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("dateAdjustmentsReference")
		@RuneAttribute("dateAdjustmentsReference")
		public ReferenceWithMetaBusinessDayAdjustments getDateAdjustmentsReference() {
			return dateAdjustmentsReference;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public FieldWithMetaDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AdjustableDate build() {
			return this;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder toBuilder() {
			AdjustableDate.AdjustableDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDate.AdjustableDateBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getDateAdjustmentsReference()).ifPresent(builder::setDateAdjustmentsReference);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(dateAdjustmentsReference, _that.getDateAdjustmentsReference())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentsReference != null ? dateAdjustmentsReference.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDate {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"dateAdjustmentsReference=" + this.dateAdjustmentsReference + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDate  ***********************/
	class AdjustableDateBuilderImpl implements AdjustableDate.AdjustableDateBuilder {
	
		protected Date unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder dateAdjustmentsReference;
		protected FieldWithMetaDate.FieldWithMetaDateBuilder adjustedDate;
		protected MetaFields.MetaFieldsBuilder meta;
		
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
		@RosettaAttribute("dateAdjustmentsReference")
		@RuneAttribute("dateAdjustmentsReference")
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder getDateAdjustmentsReference() {
			return dateAdjustmentsReference;
		}
		
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder getOrCreateDateAdjustmentsReference() {
			ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder result;
			if (dateAdjustmentsReference!=null) {
				result = dateAdjustmentsReference;
			}
			else {
				result = dateAdjustmentsReference = ReferenceWithMetaBusinessDayAdjustments.builder();
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
		@RosettaAttribute("unadjustedDate")
		@RuneAttribute("unadjustedDate")
		public AdjustableDate.AdjustableDateBuilder setUnadjustedDate(Date _unadjustedDate) {
			this.unadjustedDate = _unadjustedDate == null ? null : _unadjustedDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public AdjustableDate.AdjustableDateBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustmentsReference")
		@RuneAttribute("dateAdjustmentsReference")
		public AdjustableDate.AdjustableDateBuilder setDateAdjustmentsReference(ReferenceWithMetaBusinessDayAdjustments _dateAdjustmentsReference) {
			this.dateAdjustmentsReference = _dateAdjustmentsReference == null ? null : _dateAdjustmentsReference.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder setDateAdjustmentsReferenceValue(BusinessDayAdjustments _dateAdjustmentsReference) {
			this.getOrCreateDateAdjustmentsReference().setValue(_dateAdjustmentsReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@RuneAttribute("adjustedDate")
		public AdjustableDate.AdjustableDateBuilder setAdjustedDate(FieldWithMetaDate _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder setAdjustedDateValue(Date _adjustedDate) {
			this.getOrCreateAdjustedDate().setValue(_adjustedDate);
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public AdjustableDate.AdjustableDateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDate build() {
			return new AdjustableDate.AdjustableDateImpl(this);
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate.AdjustableDateBuilder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (dateAdjustmentsReference!=null && !dateAdjustmentsReference.prune().hasData()) dateAdjustmentsReference = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getDateAdjustmentsReference()!=null && getDateAdjustmentsReference().hasData()) return true;
			if (getAdjustedDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate.AdjustableDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDate.AdjustableDateBuilder o = (AdjustableDate.AdjustableDateBuilder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getDateAdjustmentsReference(), o.getDateAdjustmentsReference(), this::setDateAdjustmentsReference);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(dateAdjustmentsReference, _that.getDateAdjustmentsReference())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentsReference != null ? dateAdjustmentsReference.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"dateAdjustmentsReference=" + this.dateAdjustmentsReference + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
