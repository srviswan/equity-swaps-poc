package cdm.product.template;

import cdm.product.template.CancelableProvisionAdjustedDates;
import cdm.product.template.CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder;
import cdm.product.template.CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilderImpl;
import cdm.product.template.CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesImpl;
import cdm.product.template.CancellationEvent;
import cdm.product.template.CancellationEvent.CancellationEventBuilder;
import cdm.product.template.meta.CancelableProvisionAdjustedDatesMeta;
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
 * A data to:  define the adjusted dates for a cancelable provision on a swap transaction.
 * @version 6.0.0
 */
@RosettaDataType(value="CancelableProvisionAdjustedDates", builder=CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CancelableProvisionAdjustedDates", model="Just another Rosetta model", builder=CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilderImpl.class, version="6.0.0")
public interface CancelableProvisionAdjustedDates extends RosettaModelObject {

	CancelableProvisionAdjustedDatesMeta metaData = new CancelableProvisionAdjustedDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The adjusted dates for an individual cancellation date.
	 */
	List<? extends CancellationEvent> getCancellationEvent();

	/*********************** Build Methods  ***********************/
	CancelableProvisionAdjustedDates build();
	
	CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder toBuilder();
	
	static CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder builder() {
		return new CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancelableProvisionAdjustedDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CancelableProvisionAdjustedDates> getType() {
		return CancelableProvisionAdjustedDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cancellationEvent"), processor, CancellationEvent.class, getCancellationEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancelableProvisionAdjustedDatesBuilder extends CancelableProvisionAdjustedDates, RosettaModelObjectBuilder {
		CancellationEvent.CancellationEventBuilder getOrCreateCancellationEvent(int _index);
		@Override
		List<? extends CancellationEvent.CancellationEventBuilder> getCancellationEvent();
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(CancellationEvent cancellationEvent);
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(CancellationEvent cancellationEvent, int _idx);
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(List<? extends CancellationEvent> cancellationEvent);
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder setCancellationEvent(List<? extends CancellationEvent> cancellationEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cancellationEvent"), processor, CancellationEvent.CancellationEventBuilder.class, getCancellationEvent());
		}
		

		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CancelableProvisionAdjustedDates  ***********************/
	class CancelableProvisionAdjustedDatesImpl implements CancelableProvisionAdjustedDates {
		private final List<? extends CancellationEvent> cancellationEvent;
		
		protected CancelableProvisionAdjustedDatesImpl(CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder builder) {
			this.cancellationEvent = ofNullable(builder.getCancellationEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cancellationEvent")
		@RuneAttribute("cancellationEvent")
		public List<? extends CancellationEvent> getCancellationEvent() {
			return cancellationEvent;
		}
		
		@Override
		public CancelableProvisionAdjustedDates build() {
			return this;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder toBuilder() {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder builder) {
			ofNullable(getCancellationEvent()).ifPresent(builder::setCancellationEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvisionAdjustedDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cancellationEvent, _that.getCancellationEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cancellationEvent != null ? cancellationEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionAdjustedDates {" +
				"cancellationEvent=" + this.cancellationEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of CancelableProvisionAdjustedDates  ***********************/
	class CancelableProvisionAdjustedDatesBuilderImpl implements CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder {
	
		protected List<CancellationEvent.CancellationEventBuilder> cancellationEvent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("cancellationEvent")
		@RuneAttribute("cancellationEvent")
		public List<? extends CancellationEvent.CancellationEventBuilder> getCancellationEvent() {
			return cancellationEvent;
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder getOrCreateCancellationEvent(int _index) {
		
			if (cancellationEvent==null) {
				this.cancellationEvent = new ArrayList<>();
			}
			CancellationEvent.CancellationEventBuilder result;
			return getIndex(cancellationEvent, _index, () -> {
						CancellationEvent.CancellationEventBuilder newCancellationEvent = CancellationEvent.builder();
						return newCancellationEvent;
					});
		}
		
		@Override
		@RosettaAttribute("cancellationEvent")
		@RuneAttribute("cancellationEvent")
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(CancellationEvent _cancellationEvent) {
			if (_cancellationEvent != null) {
				this.cancellationEvent.add(_cancellationEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(CancellationEvent _cancellationEvent, int _idx) {
			getIndex(this.cancellationEvent, _idx, () -> _cancellationEvent.toBuilder());
			return this;
		}
		
		@Override 
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder addCancellationEvent(List<? extends CancellationEvent> cancellationEvents) {
			if (cancellationEvents != null) {
				for (final CancellationEvent toAdd : cancellationEvents) {
					this.cancellationEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("cancellationEvent")
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder setCancellationEvent(List<? extends CancellationEvent> cancellationEvents) {
			if (cancellationEvents == null) {
				this.cancellationEvent = new ArrayList<>();
			} else {
				this.cancellationEvent = cancellationEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CancelableProvisionAdjustedDates build() {
			return new CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesImpl(this);
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder prune() {
			cancellationEvent = cancellationEvent.stream().filter(b->b!=null).<CancellationEvent.CancellationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCancellationEvent()!=null && getCancellationEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder o = (CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder) other;
			
			merger.mergeRosetta(getCancellationEvent(), o.getCancellationEvent(), this::getOrCreateCancellationEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvisionAdjustedDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cancellationEvent, _that.getCancellationEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cancellationEvent != null ? cancellationEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionAdjustedDatesBuilder {" +
				"cancellationEvent=" + this.cancellationEvent +
			'}';
		}
	}
}
