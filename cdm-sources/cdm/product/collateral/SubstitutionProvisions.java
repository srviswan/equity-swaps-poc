package cdm.product.collateral;

import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import cdm.product.collateral.SubstitutionProvisions;
import cdm.product.collateral.SubstitutionProvisions.SubstitutionProvisionsBuilder;
import cdm.product.collateral.SubstitutionProvisions.SubstitutionProvisionsBuilderImpl;
import cdm.product.collateral.SubstitutionProvisions.SubstitutionProvisionsImpl;
import cdm.product.collateral.meta.SubstitutionProvisionsMeta;
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
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines collateral substitution provisions such as how many and with how much notice are substitutions allowed.
 * @version 6.0.0
 */
@RosettaDataType(value="SubstitutionProvisions", builder=SubstitutionProvisions.SubstitutionProvisionsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SubstitutionProvisions", model="Just another Rosetta model", builder=SubstitutionProvisions.SubstitutionProvisionsBuilderImpl.class, version="6.0.0")
public interface SubstitutionProvisions extends RosettaModelObject {

	SubstitutionProvisionsMeta metaData = new SubstitutionProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies if 1 or more substitutions are allowed.
	 */
	Integer getNumberOfSubstitutionsAllowed();
	/**
	 * Defines the min period for notify of a substitution.
	 */
	Period getNoticeDeadlinePeriod();
	/**
	 * A specific date and time for the notice deadline
	 */
	ZonedDateTime getNoticeDeadlineDateTime();

	/*********************** Build Methods  ***********************/
	SubstitutionProvisions build();
	
	SubstitutionProvisions.SubstitutionProvisionsBuilder toBuilder();
	
	static SubstitutionProvisions.SubstitutionProvisionsBuilder builder() {
		return new SubstitutionProvisions.SubstitutionProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SubstitutionProvisions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SubstitutionProvisions> getType() {
		return SubstitutionProvisions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("numberOfSubstitutionsAllowed"), Integer.class, getNumberOfSubstitutionsAllowed(), this);
		processRosetta(path.newSubPath("noticeDeadlinePeriod"), processor, Period.class, getNoticeDeadlinePeriod());
		processor.processBasic(path.newSubPath("noticeDeadlineDateTime"), ZonedDateTime.class, getNoticeDeadlineDateTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubstitutionProvisionsBuilder extends SubstitutionProvisions, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateNoticeDeadlinePeriod();
		@Override
		Period.PeriodBuilder getNoticeDeadlinePeriod();
		SubstitutionProvisions.SubstitutionProvisionsBuilder setNumberOfSubstitutionsAllowed(Integer numberOfSubstitutionsAllowed);
		SubstitutionProvisions.SubstitutionProvisionsBuilder setNoticeDeadlinePeriod(Period noticeDeadlinePeriod);
		SubstitutionProvisions.SubstitutionProvisionsBuilder setNoticeDeadlineDateTime(ZonedDateTime noticeDeadlineDateTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("numberOfSubstitutionsAllowed"), Integer.class, getNumberOfSubstitutionsAllowed(), this);
			processRosetta(path.newSubPath("noticeDeadlinePeriod"), processor, Period.PeriodBuilder.class, getNoticeDeadlinePeriod());
			processor.processBasic(path.newSubPath("noticeDeadlineDateTime"), ZonedDateTime.class, getNoticeDeadlineDateTime(), this);
		}
		

		SubstitutionProvisions.SubstitutionProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of SubstitutionProvisions  ***********************/
	class SubstitutionProvisionsImpl implements SubstitutionProvisions {
		private final Integer numberOfSubstitutionsAllowed;
		private final Period noticeDeadlinePeriod;
		private final ZonedDateTime noticeDeadlineDateTime;
		
		protected SubstitutionProvisionsImpl(SubstitutionProvisions.SubstitutionProvisionsBuilder builder) {
			this.numberOfSubstitutionsAllowed = builder.getNumberOfSubstitutionsAllowed();
			this.noticeDeadlinePeriod = ofNullable(builder.getNoticeDeadlinePeriod()).map(f->f.build()).orElse(null);
			this.noticeDeadlineDateTime = builder.getNoticeDeadlineDateTime();
		}
		
		@Override
		@RosettaAttribute("numberOfSubstitutionsAllowed")
		@RuneAttribute("numberOfSubstitutionsAllowed")
		public Integer getNumberOfSubstitutionsAllowed() {
			return numberOfSubstitutionsAllowed;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public Period getNoticeDeadlinePeriod() {
			return noticeDeadlinePeriod;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public ZonedDateTime getNoticeDeadlineDateTime() {
			return noticeDeadlineDateTime;
		}
		
		@Override
		public SubstitutionProvisions build() {
			return this;
		}
		
		@Override
		public SubstitutionProvisions.SubstitutionProvisionsBuilder toBuilder() {
			SubstitutionProvisions.SubstitutionProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutionProvisions.SubstitutionProvisionsBuilder builder) {
			ofNullable(getNumberOfSubstitutionsAllowed()).ifPresent(builder::setNumberOfSubstitutionsAllowed);
			ofNullable(getNoticeDeadlinePeriod()).ifPresent(builder::setNoticeDeadlinePeriod);
			ofNullable(getNoticeDeadlineDateTime()).ifPresent(builder::setNoticeDeadlineDateTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutionProvisions _that = getType().cast(o);
		
			if (!Objects.equals(numberOfSubstitutionsAllowed, _that.getNumberOfSubstitutionsAllowed())) return false;
			if (!Objects.equals(noticeDeadlinePeriod, _that.getNoticeDeadlinePeriod())) return false;
			if (!Objects.equals(noticeDeadlineDateTime, _that.getNoticeDeadlineDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfSubstitutionsAllowed != null ? numberOfSubstitutionsAllowed.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlinePeriod != null ? noticeDeadlinePeriod.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlineDateTime != null ? noticeDeadlineDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionProvisions {" +
				"numberOfSubstitutionsAllowed=" + this.numberOfSubstitutionsAllowed + ", " +
				"noticeDeadlinePeriod=" + this.noticeDeadlinePeriod + ", " +
				"noticeDeadlineDateTime=" + this.noticeDeadlineDateTime +
			'}';
		}
	}

	/*********************** Builder Implementation of SubstitutionProvisions  ***********************/
	class SubstitutionProvisionsBuilderImpl implements SubstitutionProvisions.SubstitutionProvisionsBuilder {
	
		protected Integer numberOfSubstitutionsAllowed;
		protected Period.PeriodBuilder noticeDeadlinePeriod;
		protected ZonedDateTime noticeDeadlineDateTime;
		
		@Override
		@RosettaAttribute("numberOfSubstitutionsAllowed")
		@RuneAttribute("numberOfSubstitutionsAllowed")
		public Integer getNumberOfSubstitutionsAllowed() {
			return numberOfSubstitutionsAllowed;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public Period.PeriodBuilder getNoticeDeadlinePeriod() {
			return noticeDeadlinePeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateNoticeDeadlinePeriod() {
			Period.PeriodBuilder result;
			if (noticeDeadlinePeriod!=null) {
				result = noticeDeadlinePeriod;
			}
			else {
				result = noticeDeadlinePeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public ZonedDateTime getNoticeDeadlineDateTime() {
			return noticeDeadlineDateTime;
		}
		
		@Override
		@RosettaAttribute("numberOfSubstitutionsAllowed")
		@RuneAttribute("numberOfSubstitutionsAllowed")
		public SubstitutionProvisions.SubstitutionProvisionsBuilder setNumberOfSubstitutionsAllowed(Integer _numberOfSubstitutionsAllowed) {
			this.numberOfSubstitutionsAllowed = _numberOfSubstitutionsAllowed == null ? null : _numberOfSubstitutionsAllowed;
			return this;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlinePeriod")
		@RuneAttribute("noticeDeadlinePeriod")
		public SubstitutionProvisions.SubstitutionProvisionsBuilder setNoticeDeadlinePeriod(Period _noticeDeadlinePeriod) {
			this.noticeDeadlinePeriod = _noticeDeadlinePeriod == null ? null : _noticeDeadlinePeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("noticeDeadlineDateTime")
		@RuneAttribute("noticeDeadlineDateTime")
		public SubstitutionProvisions.SubstitutionProvisionsBuilder setNoticeDeadlineDateTime(ZonedDateTime _noticeDeadlineDateTime) {
			this.noticeDeadlineDateTime = _noticeDeadlineDateTime == null ? null : _noticeDeadlineDateTime;
			return this;
		}
		
		@Override
		public SubstitutionProvisions build() {
			return new SubstitutionProvisions.SubstitutionProvisionsImpl(this);
		}
		
		@Override
		public SubstitutionProvisions.SubstitutionProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutionProvisions.SubstitutionProvisionsBuilder prune() {
			if (noticeDeadlinePeriod!=null && !noticeDeadlinePeriod.prune().hasData()) noticeDeadlinePeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfSubstitutionsAllowed()!=null) return true;
			if (getNoticeDeadlinePeriod()!=null && getNoticeDeadlinePeriod().hasData()) return true;
			if (getNoticeDeadlineDateTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutionProvisions.SubstitutionProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutionProvisions.SubstitutionProvisionsBuilder o = (SubstitutionProvisions.SubstitutionProvisionsBuilder) other;
			
			merger.mergeRosetta(getNoticeDeadlinePeriod(), o.getNoticeDeadlinePeriod(), this::setNoticeDeadlinePeriod);
			
			merger.mergeBasic(getNumberOfSubstitutionsAllowed(), o.getNumberOfSubstitutionsAllowed(), this::setNumberOfSubstitutionsAllowed);
			merger.mergeBasic(getNoticeDeadlineDateTime(), o.getNoticeDeadlineDateTime(), this::setNoticeDeadlineDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutionProvisions _that = getType().cast(o);
		
			if (!Objects.equals(numberOfSubstitutionsAllowed, _that.getNumberOfSubstitutionsAllowed())) return false;
			if (!Objects.equals(noticeDeadlinePeriod, _that.getNoticeDeadlinePeriod())) return false;
			if (!Objects.equals(noticeDeadlineDateTime, _that.getNoticeDeadlineDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfSubstitutionsAllowed != null ? numberOfSubstitutionsAllowed.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlinePeriod != null ? noticeDeadlinePeriod.hashCode() : 0);
			_result = 31 * _result + (noticeDeadlineDateTime != null ? noticeDeadlineDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionProvisionsBuilder {" +
				"numberOfSubstitutionsAllowed=" + this.numberOfSubstitutionsAllowed + ", " +
				"noticeDeadlinePeriod=" + this.noticeDeadlinePeriod + ", " +
				"noticeDeadlineDateTime=" + this.noticeDeadlineDateTime +
			'}';
		}
	}
}
