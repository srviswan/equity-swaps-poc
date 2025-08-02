package cdm.product.common.schedule;

import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl;
import cdm.product.common.schedule.meta.DateRelativeToCalculationPeriodDatesMeta;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder;
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
 * A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 * @version 6.0.0
 */
@RosettaDataType(value="DateRelativeToCalculationPeriodDates", builder=DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DateRelativeToCalculationPeriodDates", model="Just another Rosetta model", builder=DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl.class, version="6.0.0")
public interface DateRelativeToCalculationPeriodDates extends RosettaModelObject {

	DateRelativeToCalculationPeriodDatesMeta metaData = new DateRelativeToCalculationPeriodDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of href pointers to calculation period dates defined somewhere else in the document.
	 */
	List<? extends ReferenceWithMetaCalculationPeriodDates> getCalculationPeriodDatesReference();

	/*********************** Build Methods  ***********************/
	DateRelativeToCalculationPeriodDates build();
	
	DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder();
	
	static DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder() {
		return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRelativeToCalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateRelativeToCalculationPeriodDates> getType() {
		return DateRelativeToCalculationPeriodDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDates.class, getCalculationPeriodDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRelativeToCalculationPeriodDatesBuilder extends DateRelativeToCalculationPeriodDates, RosettaModelObjectBuilder {
		ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference(int _index);
		@Override
		List<? extends ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder> getCalculationPeriodDatesReference();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference, int _idx);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference, int _idx);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReference);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder.class, getCalculationPeriodDatesReference());
		}
		

		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of DateRelativeToCalculationPeriodDates  ***********************/
	class DateRelativeToCalculationPeriodDatesImpl implements DateRelativeToCalculationPeriodDates {
		private final List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReference;
		
		protected DateRelativeToCalculationPeriodDatesImpl(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@RuneAttribute("calculationPeriodDatesReference")
		public List<? extends ReferenceWithMetaCalculationPeriodDates> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDates {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRelativeToCalculationPeriodDates  ***********************/
	class DateRelativeToCalculationPeriodDatesBuilderImpl implements DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder {
	
		protected List<ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder> calculationPeriodDatesReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@RuneAttribute("calculationPeriodDatesReference")
		public List<? extends ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference(int _index) {
		
			if (calculationPeriodDatesReference==null) {
				this.calculationPeriodDatesReference = new ArrayList<>();
			}
			ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder result;
			return getIndex(calculationPeriodDatesReference, _index, () -> {
						ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder newCalculationPeriodDatesReference = ReferenceWithMetaCalculationPeriodDates.builder();
						return newCalculationPeriodDatesReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@RuneAttribute("calculationPeriodDatesReference")
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates _calculationPeriodDatesReference) {
			if (_calculationPeriodDatesReference != null) {
				this.calculationPeriodDatesReference.add(_calculationPeriodDatesReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates _calculationPeriodDatesReference, int _idx) {
			getIndex(this.calculationPeriodDatesReference, _idx, () -> _calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates _calculationPeriodDatesReference) {
			this.getOrCreateCalculationPeriodDatesReference(-1).setValue(_calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(CalculationPeriodDates _calculationPeriodDatesReference, int _idx) {
			this.getOrCreateCalculationPeriodDatesReference(_idx).setValue(_calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
		@Override 
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences != null) {
				for (final ReferenceWithMetaCalculationPeriodDates toAdd : calculationPeriodDatesReferences) {
					this.calculationPeriodDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("calculationPeriodDatesReference")
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends ReferenceWithMetaCalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences == null) {
				this.calculationPeriodDatesReference = new ArrayList<>();
			} else {
				this.calculationPeriodDatesReference = calculationPeriodDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences != null) {
				for (final CalculationPeriodDates toAdd : calculationPeriodDatesReferences) {
					this.addCalculationPeriodDatesReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReferenceValue(List<? extends CalculationPeriodDates> calculationPeriodDatesReferences) {
			this.calculationPeriodDatesReference.clear();
			if (calculationPeriodDatesReferences != null) {
				calculationPeriodDatesReferences.forEach(this::addCalculationPeriodDatesReferenceValue);
			}
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl(this);
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder prune() {
			calculationPeriodDatesReference = calculationPeriodDatesReference.stream().filter(b->b!=null).<ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder o = (DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::getOrCreateCalculationPeriodDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDatesBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}
}
