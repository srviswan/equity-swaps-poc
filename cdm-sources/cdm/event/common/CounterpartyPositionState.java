package cdm.event.common;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.CounterpartyPositionState.CounterpartyPositionStateBuilder;
import cdm.event.common.CounterpartyPositionState.CounterpartyPositionStateBuilderImpl;
import cdm.event.common.CounterpartyPositionState.CounterpartyPositionStateImpl;
import cdm.event.common.ObservationEvent;
import cdm.event.common.ObservationEvent.ObservationEventBuilder;
import cdm.event.common.State;
import cdm.event.common.State.StateBuilder;
import cdm.event.common.Valuation;
import cdm.event.common.Valuation.ValuationBuilder;
import cdm.event.common.meta.CounterpartyPositionStateMeta;
import cdm.event.position.CounterpartyPosition;
import cdm.event.position.CounterpartyPosition.CounterpartyPositionBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each PositionState specifies where a Position is in its life-cycle. PositionState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 * @version 6.0.0
 */
@RosettaDataType(value="CounterpartyPositionState", builder=CounterpartyPositionState.CounterpartyPositionStateBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CounterpartyPositionState", model="Just another Rosetta model", builder=CounterpartyPositionState.CounterpartyPositionStateBuilderImpl.class, version="6.0.0")
public interface CounterpartyPositionState extends RosettaModelObject, GlobalKey {

	CounterpartyPositionStateMeta metaData = new CounterpartyPositionStateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents the Position that has been effected by a business or life-cycle event.
	 */
	CounterpartyPosition getCounterpartyPosition();
	/**
	 * Represents the State of the Position through its life-cycle.
	 */
	State getState();
	/**
	 * Represents the observed events related to a particular product or process, such as credit events or corporate actions.
	 */
	List<? extends ObservationEvent> getObservationHistory();
	List<? extends Valuation> getValuationHistory();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	CounterpartyPositionState build();
	
	CounterpartyPositionState.CounterpartyPositionStateBuilder toBuilder();
	
	static CounterpartyPositionState.CounterpartyPositionStateBuilder builder() {
		return new CounterpartyPositionState.CounterpartyPositionStateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartyPositionState> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartyPositionState> getType() {
		return CounterpartyPositionState.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("counterpartyPosition"), processor, CounterpartyPosition.class, getCounterpartyPosition());
		processRosetta(path.newSubPath("state"), processor, State.class, getState());
		processRosetta(path.newSubPath("observationHistory"), processor, ObservationEvent.class, getObservationHistory());
		processRosetta(path.newSubPath("valuationHistory"), processor, Valuation.class, getValuationHistory());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartyPositionStateBuilder extends CounterpartyPositionState, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		CounterpartyPosition.CounterpartyPositionBuilder getOrCreateCounterpartyPosition();
		@Override
		CounterpartyPosition.CounterpartyPositionBuilder getCounterpartyPosition();
		State.StateBuilder getOrCreateState();
		@Override
		State.StateBuilder getState();
		ObservationEvent.ObservationEventBuilder getOrCreateObservationHistory(int _index);
		@Override
		List<? extends ObservationEvent.ObservationEventBuilder> getObservationHistory();
		Valuation.ValuationBuilder getOrCreateValuationHistory(int _index);
		@Override
		List<? extends Valuation.ValuationBuilder> getValuationHistory();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		CounterpartyPositionState.CounterpartyPositionStateBuilder setCounterpartyPosition(CounterpartyPosition counterpartyPosition);
		CounterpartyPositionState.CounterpartyPositionStateBuilder setState(State state);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(ObservationEvent observationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(ObservationEvent observationHistory, int _idx);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(List<? extends ObservationEvent> observationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder setObservationHistory(List<? extends ObservationEvent> observationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(Valuation valuationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(Valuation valuationHistory, int _idx);
		CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(List<? extends Valuation> valuationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder setValuationHistory(List<? extends Valuation> valuationHistory);
		CounterpartyPositionState.CounterpartyPositionStateBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("counterpartyPosition"), processor, CounterpartyPosition.CounterpartyPositionBuilder.class, getCounterpartyPosition());
			processRosetta(path.newSubPath("state"), processor, State.StateBuilder.class, getState());
			processRosetta(path.newSubPath("observationHistory"), processor, ObservationEvent.ObservationEventBuilder.class, getObservationHistory());
			processRosetta(path.newSubPath("valuationHistory"), processor, Valuation.ValuationBuilder.class, getValuationHistory());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		CounterpartyPositionState.CounterpartyPositionStateBuilder prune();
	}

	/*********************** Immutable Implementation of CounterpartyPositionState  ***********************/
	class CounterpartyPositionStateImpl implements CounterpartyPositionState {
		private final CounterpartyPosition counterpartyPosition;
		private final State state;
		private final List<? extends ObservationEvent> observationHistory;
		private final List<? extends Valuation> valuationHistory;
		private final MetaFields meta;
		
		protected CounterpartyPositionStateImpl(CounterpartyPositionState.CounterpartyPositionStateBuilder builder) {
			this.counterpartyPosition = ofNullable(builder.getCounterpartyPosition()).map(f->f.build()).orElse(null);
			this.state = ofNullable(builder.getState()).map(f->f.build()).orElse(null);
			this.observationHistory = ofNullable(builder.getObservationHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationHistory = ofNullable(builder.getValuationHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("counterpartyPosition")
		@RuneAttribute("counterpartyPosition")
		public CounterpartyPosition getCounterpartyPosition() {
			return counterpartyPosition;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public State getState() {
			return state;
		}
		
		@Override
		@RosettaAttribute("observationHistory")
		@RuneAttribute("observationHistory")
		public List<? extends ObservationEvent> getObservationHistory() {
			return observationHistory;
		}
		
		@Override
		@RosettaAttribute("valuationHistory")
		@RuneAttribute("valuationHistory")
		public List<? extends Valuation> getValuationHistory() {
			return valuationHistory;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CounterpartyPositionState build() {
			return this;
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder toBuilder() {
			CounterpartyPositionState.CounterpartyPositionStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartyPositionState.CounterpartyPositionStateBuilder builder) {
			ofNullable(getCounterpartyPosition()).ifPresent(builder::setCounterpartyPosition);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getObservationHistory()).ifPresent(builder::setObservationHistory);
			ofNullable(getValuationHistory()).ifPresent(builder::setValuationHistory);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyPositionState _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyPosition, _that.getCounterpartyPosition())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(observationHistory, _that.getObservationHistory())) return false;
			if (!ListEquals.listEquals(valuationHistory, _that.getValuationHistory())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyPosition != null ? counterpartyPosition.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (observationHistory != null ? observationHistory.hashCode() : 0);
			_result = 31 * _result + (valuationHistory != null ? valuationHistory.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyPositionState {" +
				"counterpartyPosition=" + this.counterpartyPosition + ", " +
				"state=" + this.state + ", " +
				"observationHistory=" + this.observationHistory + ", " +
				"valuationHistory=" + this.valuationHistory + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartyPositionState  ***********************/
	class CounterpartyPositionStateBuilderImpl implements CounterpartyPositionState.CounterpartyPositionStateBuilder {
	
		protected CounterpartyPosition.CounterpartyPositionBuilder counterpartyPosition;
		protected State.StateBuilder state;
		protected List<ObservationEvent.ObservationEventBuilder> observationHistory = new ArrayList<>();
		protected List<Valuation.ValuationBuilder> valuationHistory = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("counterpartyPosition")
		@RuneAttribute("counterpartyPosition")
		public CounterpartyPosition.CounterpartyPositionBuilder getCounterpartyPosition() {
			return counterpartyPosition;
		}
		
		@Override
		public CounterpartyPosition.CounterpartyPositionBuilder getOrCreateCounterpartyPosition() {
			CounterpartyPosition.CounterpartyPositionBuilder result;
			if (counterpartyPosition!=null) {
				result = counterpartyPosition;
			}
			else {
				result = counterpartyPosition = CounterpartyPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public State.StateBuilder getState() {
			return state;
		}
		
		@Override
		public State.StateBuilder getOrCreateState() {
			State.StateBuilder result;
			if (state!=null) {
				result = state;
			}
			else {
				result = state = State.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationHistory")
		@RuneAttribute("observationHistory")
		public List<? extends ObservationEvent.ObservationEventBuilder> getObservationHistory() {
			return observationHistory;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder getOrCreateObservationHistory(int _index) {
		
			if (observationHistory==null) {
				this.observationHistory = new ArrayList<>();
			}
			ObservationEvent.ObservationEventBuilder result;
			return getIndex(observationHistory, _index, () -> {
						ObservationEvent.ObservationEventBuilder newObservationHistory = ObservationEvent.builder();
						return newObservationHistory;
					});
		}
		
		@Override
		@RosettaAttribute("valuationHistory")
		@RuneAttribute("valuationHistory")
		public List<? extends Valuation.ValuationBuilder> getValuationHistory() {
			return valuationHistory;
		}
		
		@Override
		public Valuation.ValuationBuilder getOrCreateValuationHistory(int _index) {
		
			if (valuationHistory==null) {
				this.valuationHistory = new ArrayList<>();
			}
			Valuation.ValuationBuilder result;
			return getIndex(valuationHistory, _index, () -> {
						Valuation.ValuationBuilder newValuationHistory = Valuation.builder();
						return newValuationHistory;
					});
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
		@RosettaAttribute("counterpartyPosition")
		@RuneAttribute("counterpartyPosition")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder setCounterpartyPosition(CounterpartyPosition _counterpartyPosition) {
			this.counterpartyPosition = _counterpartyPosition == null ? null : _counterpartyPosition.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("state")
		@RuneAttribute("state")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder setState(State _state) {
			this.state = _state == null ? null : _state.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationHistory")
		@RuneAttribute("observationHistory")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(ObservationEvent _observationHistory) {
			if (_observationHistory != null) {
				this.observationHistory.add(_observationHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(ObservationEvent _observationHistory, int _idx) {
			getIndex(this.observationHistory, _idx, () -> _observationHistory.toBuilder());
			return this;
		}
		
		@Override 
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addObservationHistory(List<? extends ObservationEvent> observationHistorys) {
			if (observationHistorys != null) {
				for (final ObservationEvent toAdd : observationHistorys) {
					this.observationHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("observationHistory")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder setObservationHistory(List<? extends ObservationEvent> observationHistorys) {
			if (observationHistorys == null) {
				this.observationHistory = new ArrayList<>();
			} else {
				this.observationHistory = observationHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("valuationHistory")
		@RuneAttribute("valuationHistory")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(Valuation _valuationHistory) {
			if (_valuationHistory != null) {
				this.valuationHistory.add(_valuationHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(Valuation _valuationHistory, int _idx) {
			getIndex(this.valuationHistory, _idx, () -> _valuationHistory.toBuilder());
			return this;
		}
		
		@Override 
		public CounterpartyPositionState.CounterpartyPositionStateBuilder addValuationHistory(List<? extends Valuation> valuationHistorys) {
			if (valuationHistorys != null) {
				for (final Valuation toAdd : valuationHistorys) {
					this.valuationHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("valuationHistory")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder setValuationHistory(List<? extends Valuation> valuationHistorys) {
			if (valuationHistorys == null) {
				this.valuationHistory = new ArrayList<>();
			} else {
				this.valuationHistory = valuationHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public CounterpartyPositionState.CounterpartyPositionStateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public CounterpartyPositionState build() {
			return new CounterpartyPositionState.CounterpartyPositionStateImpl(this);
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder prune() {
			if (counterpartyPosition!=null && !counterpartyPosition.prune().hasData()) counterpartyPosition = null;
			if (state!=null && !state.prune().hasData()) state = null;
			observationHistory = observationHistory.stream().filter(b->b!=null).<ObservationEvent.ObservationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationHistory = valuationHistory.stream().filter(b->b!=null).<Valuation.ValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCounterpartyPosition()!=null && getCounterpartyPosition().hasData()) return true;
			if (getState()!=null && getState().hasData()) return true;
			if (getObservationHistory()!=null && getObservationHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationHistory()!=null && getValuationHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartyPositionState.CounterpartyPositionStateBuilder o = (CounterpartyPositionState.CounterpartyPositionStateBuilder) other;
			
			merger.mergeRosetta(getCounterpartyPosition(), o.getCounterpartyPosition(), this::setCounterpartyPosition);
			merger.mergeRosetta(getState(), o.getState(), this::setState);
			merger.mergeRosetta(getObservationHistory(), o.getObservationHistory(), this::getOrCreateObservationHistory);
			merger.mergeRosetta(getValuationHistory(), o.getValuationHistory(), this::getOrCreateValuationHistory);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyPositionState _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyPosition, _that.getCounterpartyPosition())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(observationHistory, _that.getObservationHistory())) return false;
			if (!ListEquals.listEquals(valuationHistory, _that.getValuationHistory())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyPosition != null ? counterpartyPosition.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (observationHistory != null ? observationHistory.hashCode() : 0);
			_result = 31 * _result + (valuationHistory != null ? valuationHistory.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyPositionStateBuilder {" +
				"counterpartyPosition=" + this.counterpartyPosition + ", " +
				"state=" + this.state + ", " +
				"observationHistory=" + this.observationHistory + ", " +
				"valuationHistory=" + this.valuationHistory + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
