package cdm.product.common.schedule;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import cdm.product.common.schedule.ObservationDate;
import cdm.product.common.schedule.ObservationDate.ObservationDateBuilder;
import cdm.product.common.schedule.ObservationSchedule;
import cdm.product.common.schedule.ObservationSchedule.ObservationScheduleBuilder;
import cdm.product.common.schedule.ObservationSchedule.ObservationScheduleBuilderImpl;
import cdm.product.common.schedule.ObservationSchedule.ObservationScheduleImpl;
import cdm.product.common.schedule.meta.ObservationScheduleMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 * @version 6.0.0
 */
@RosettaDataType(value="ObservationSchedule", builder=ObservationSchedule.ObservationScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ObservationSchedule", model="Just another Rosetta model", builder=ObservationSchedule.ObservationScheduleBuilderImpl.class, version="6.0.0")
public interface ObservationSchedule extends RosettaModelObject {

	ObservationScheduleMeta metaData = new ObservationScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies an adjusted or unadjusted date for a market observation.
	 */
	List<? extends ObservationDate> getObservationDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();

	/*********************** Build Methods  ***********************/
	ObservationSchedule build();
	
	ObservationSchedule.ObservationScheduleBuilder toBuilder();
	
	static ObservationSchedule.ObservationScheduleBuilder builder() {
		return new ObservationSchedule.ObservationScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationSchedule> getType() {
		return ObservationSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observationDate"), processor, ObservationDate.class, getObservationDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationScheduleBuilder extends ObservationSchedule, RosettaModelObjectBuilder {
		ObservationDate.ObservationDateBuilder getOrCreateObservationDate(int _index);
		@Override
		List<? extends ObservationDate.ObservationDateBuilder> getObservationDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ObservationSchedule.ObservationScheduleBuilder addObservationDate(ObservationDate observationDate);
		ObservationSchedule.ObservationScheduleBuilder addObservationDate(ObservationDate observationDate, int _idx);
		ObservationSchedule.ObservationScheduleBuilder addObservationDate(List<? extends ObservationDate> observationDate);
		ObservationSchedule.ObservationScheduleBuilder setObservationDate(List<? extends ObservationDate> observationDate);
		ObservationSchedule.ObservationScheduleBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observationDate"), processor, ObservationDate.ObservationDateBuilder.class, getObservationDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
		}
		

		ObservationSchedule.ObservationScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationSchedule  ***********************/
	class ObservationScheduleImpl implements ObservationSchedule {
		private final List<? extends ObservationDate> observationDate;
		private final BusinessDayAdjustments dateAdjustments;
		
		protected ObservationScheduleImpl(ObservationSchedule.ObservationScheduleBuilder builder) {
			this.observationDate = ofNullable(builder.getObservationDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public List<? extends ObservationDate> getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public ObservationSchedule build() {
			return this;
		}
		
		@Override
		public ObservationSchedule.ObservationScheduleBuilder toBuilder() {
			ObservationSchedule.ObservationScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationSchedule.ObservationScheduleBuilder builder) {
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationSchedule {" +
				"observationDate=" + this.observationDate + ", " +
				"dateAdjustments=" + this.dateAdjustments +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationSchedule  ***********************/
	class ObservationScheduleBuilderImpl implements ObservationSchedule.ObservationScheduleBuilder {
	
		protected List<ObservationDate.ObservationDateBuilder> observationDate = new ArrayList<>();
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		
		@Override
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public List<? extends ObservationDate.ObservationDateBuilder> getObservationDate() {
			return observationDate;
		}
		
		@Override
		public ObservationDate.ObservationDateBuilder getOrCreateObservationDate(int _index) {
		
			if (observationDate==null) {
				this.observationDate = new ArrayList<>();
			}
			ObservationDate.ObservationDateBuilder result;
			return getIndex(observationDate, _index, () -> {
						ObservationDate.ObservationDateBuilder newObservationDate = ObservationDate.builder();
						return newObservationDate;
					});
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
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public ObservationSchedule.ObservationScheduleBuilder addObservationDate(ObservationDate _observationDate) {
			if (_observationDate != null) {
				this.observationDate.add(_observationDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public ObservationSchedule.ObservationScheduleBuilder addObservationDate(ObservationDate _observationDate, int _idx) {
			getIndex(this.observationDate, _idx, () -> _observationDate.toBuilder());
			return this;
		}
		
		@Override 
		public ObservationSchedule.ObservationScheduleBuilder addObservationDate(List<? extends ObservationDate> observationDates) {
			if (observationDates != null) {
				for (final ObservationDate toAdd : observationDates) {
					this.observationDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("observationDate")
		public ObservationSchedule.ObservationScheduleBuilder setObservationDate(List<? extends ObservationDate> observationDates) {
			if (observationDates == null) {
				this.observationDate = new ArrayList<>();
			} else {
				this.observationDate = observationDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@RuneAttribute("dateAdjustments")
		public ObservationSchedule.ObservationScheduleBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public ObservationSchedule build() {
			return new ObservationSchedule.ObservationScheduleImpl(this);
		}
		
		@Override
		public ObservationSchedule.ObservationScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSchedule.ObservationScheduleBuilder prune() {
			observationDate = observationDate.stream().filter(b->b!=null).<ObservationDate.ObservationDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationDate()!=null && getObservationDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSchedule.ObservationScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationSchedule.ObservationScheduleBuilder o = (ObservationSchedule.ObservationScheduleBuilder) other;
			
			merger.mergeRosetta(getObservationDate(), o.getObservationDate(), this::getOrCreateObservationDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationScheduleBuilder {" +
				"observationDate=" + this.observationDate + ", " +
				"dateAdjustments=" + this.dateAdjustments +
			'}';
		}
	}
}
