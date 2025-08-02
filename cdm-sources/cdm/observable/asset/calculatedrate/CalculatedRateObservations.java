package cdm.observable.asset.calculatedrate;

import cdm.observable.asset.calculatedrate.CalculatedRateObservations;
import cdm.observable.asset.calculatedrate.CalculatedRateObservations.CalculatedRateObservationsBuilder;
import cdm.observable.asset.calculatedrate.CalculatedRateObservations.CalculatedRateObservationsBuilderImpl;
import cdm.observable.asset.calculatedrate.CalculatedRateObservations.CalculatedRateObservationsImpl;
import cdm.observable.asset.calculatedrate.meta.CalculatedRateObservationsMeta;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Type for reporting observations that went into the final reported rate.
 * @version 6.0.0
 */
@RosettaDataType(value="CalculatedRateObservations", builder=CalculatedRateObservations.CalculatedRateObservationsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CalculatedRateObservations", model="Just another Rosetta model", builder=CalculatedRateObservations.CalculatedRateObservationsBuilderImpl.class, version="6.0.0")
public interface CalculatedRateObservations extends RosettaModelObject {

	CalculatedRateObservationsMeta metaData = new CalculatedRateObservationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The observation date upon which the rate is observed.
	 */
	List<Date> getObservationDates();
	/**
	 * The corresponding weight for each date.
	 */
	List<BigDecimal> getWeights();
	/**
	 * The value observed for that date
	 */
	List<BigDecimal> getObservedRates();
	/**
	 * The value after any processing, such as application of caps or floors.
	 */
	List<BigDecimal> getProcessedRates();

	/*********************** Build Methods  ***********************/
	CalculatedRateObservations build();
	
	CalculatedRateObservations.CalculatedRateObservationsBuilder toBuilder();
	
	static CalculatedRateObservations.CalculatedRateObservationsBuilder builder() {
		return new CalculatedRateObservations.CalculatedRateObservationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculatedRateObservations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculatedRateObservations> getType() {
		return CalculatedRateObservations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDates"), Date.class, getObservationDates(), this);
		processor.processBasic(path.newSubPath("weights"), BigDecimal.class, getWeights(), this);
		processor.processBasic(path.newSubPath("observedRates"), BigDecimal.class, getObservedRates(), this);
		processor.processBasic(path.newSubPath("processedRates"), BigDecimal.class, getProcessedRates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculatedRateObservationsBuilder extends CalculatedRateObservations, RosettaModelObjectBuilder {
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(Date observationDates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(Date observationDates, int _idx);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(List<Date> observationDates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder setObservationDates(List<Date> observationDates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(BigDecimal weights);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(BigDecimal weights, int _idx);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(List<BigDecimal> weights);
		CalculatedRateObservations.CalculatedRateObservationsBuilder setWeights(List<BigDecimal> weights);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(BigDecimal observedRates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(BigDecimal observedRates, int _idx);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(List<BigDecimal> observedRates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder setObservedRates(List<BigDecimal> observedRates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(BigDecimal processedRates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(BigDecimal processedRates, int _idx);
		CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(List<BigDecimal> processedRates);
		CalculatedRateObservations.CalculatedRateObservationsBuilder setProcessedRates(List<BigDecimal> processedRates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDates"), Date.class, getObservationDates(), this);
			processor.processBasic(path.newSubPath("weights"), BigDecimal.class, getWeights(), this);
			processor.processBasic(path.newSubPath("observedRates"), BigDecimal.class, getObservedRates(), this);
			processor.processBasic(path.newSubPath("processedRates"), BigDecimal.class, getProcessedRates(), this);
		}
		

		CalculatedRateObservations.CalculatedRateObservationsBuilder prune();
	}

	/*********************** Immutable Implementation of CalculatedRateObservations  ***********************/
	class CalculatedRateObservationsImpl implements CalculatedRateObservations {
		private final List<Date> observationDates;
		private final List<BigDecimal> weights;
		private final List<BigDecimal> observedRates;
		private final List<BigDecimal> processedRates;
		
		protected CalculatedRateObservationsImpl(CalculatedRateObservations.CalculatedRateObservationsBuilder builder) {
			this.observationDates = ofNullable(builder.getObservationDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.weights = ofNullable(builder.getWeights()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.observedRates = ofNullable(builder.getObservedRates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.processedRates = ofNullable(builder.getProcessedRates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public List<Date> getObservationDates() {
			return observationDates;
		}
		
		@Override
		@RosettaAttribute("weights")
		@RuneAttribute("weights")
		public List<BigDecimal> getWeights() {
			return weights;
		}
		
		@Override
		@RosettaAttribute("observedRates")
		@RuneAttribute("observedRates")
		public List<BigDecimal> getObservedRates() {
			return observedRates;
		}
		
		@Override
		@RosettaAttribute("processedRates")
		@RuneAttribute("processedRates")
		public List<BigDecimal> getProcessedRates() {
			return processedRates;
		}
		
		@Override
		public CalculatedRateObservations build() {
			return this;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder toBuilder() {
			CalculatedRateObservations.CalculatedRateObservationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculatedRateObservations.CalculatedRateObservationsBuilder builder) {
			ofNullable(getObservationDates()).ifPresent(builder::setObservationDates);
			ofNullable(getWeights()).ifPresent(builder::setWeights);
			ofNullable(getObservedRates()).ifPresent(builder::setObservedRates);
			ofNullable(getProcessedRates()).ifPresent(builder::setProcessedRates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedRateObservations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationDates, _that.getObservationDates())) return false;
			if (!ListEquals.listEquals(weights, _that.getWeights())) return false;
			if (!ListEquals.listEquals(observedRates, _that.getObservedRates())) return false;
			if (!ListEquals.listEquals(processedRates, _that.getProcessedRates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (weights != null ? weights.hashCode() : 0);
			_result = 31 * _result + (observedRates != null ? observedRates.hashCode() : 0);
			_result = 31 * _result + (processedRates != null ? processedRates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedRateObservations {" +
				"observationDates=" + this.observationDates + ", " +
				"weights=" + this.weights + ", " +
				"observedRates=" + this.observedRates + ", " +
				"processedRates=" + this.processedRates +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculatedRateObservations  ***********************/
	class CalculatedRateObservationsBuilderImpl implements CalculatedRateObservations.CalculatedRateObservationsBuilder {
	
		protected List<Date> observationDates = new ArrayList<>();
		protected List<BigDecimal> weights = new ArrayList<>();
		protected List<BigDecimal> observedRates = new ArrayList<>();
		protected List<BigDecimal> processedRates = new ArrayList<>();
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public List<Date> getObservationDates() {
			return observationDates;
		}
		
		@Override
		@RosettaAttribute("weights")
		@RuneAttribute("weights")
		public List<BigDecimal> getWeights() {
			return weights;
		}
		
		@Override
		@RosettaAttribute("observedRates")
		@RuneAttribute("observedRates")
		public List<BigDecimal> getObservedRates() {
			return observedRates;
		}
		
		@Override
		@RosettaAttribute("processedRates")
		@RuneAttribute("processedRates")
		public List<BigDecimal> getProcessedRates() {
			return processedRates;
		}
		
		@Override
		@RosettaAttribute("observationDates")
		@RuneAttribute("observationDates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(Date _observationDates) {
			if (_observationDates != null) {
				this.observationDates.add(_observationDates);
			}
			return this;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(Date _observationDates, int _idx) {
			getIndex(this.observationDates, _idx, () -> _observationDates);
			return this;
		}
		
		@Override 
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservationDates(List<Date> observationDatess) {
			if (observationDatess != null) {
				for (final Date toAdd : observationDatess) {
					this.observationDates.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("observationDates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder setObservationDates(List<Date> observationDatess) {
			if (observationDatess == null) {
				this.observationDates = new ArrayList<>();
			} else {
				this.observationDates = observationDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("weights")
		@RuneAttribute("weights")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(BigDecimal _weights) {
			if (_weights != null) {
				this.weights.add(_weights);
			}
			return this;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(BigDecimal _weights, int _idx) {
			getIndex(this.weights, _idx, () -> _weights);
			return this;
		}
		
		@Override 
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addWeights(List<BigDecimal> weightss) {
			if (weightss != null) {
				for (final BigDecimal toAdd : weightss) {
					this.weights.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("weights")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder setWeights(List<BigDecimal> weightss) {
			if (weightss == null) {
				this.weights = new ArrayList<>();
			} else {
				this.weights = weightss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("observedRates")
		@RuneAttribute("observedRates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(BigDecimal _observedRates) {
			if (_observedRates != null) {
				this.observedRates.add(_observedRates);
			}
			return this;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(BigDecimal _observedRates, int _idx) {
			getIndex(this.observedRates, _idx, () -> _observedRates);
			return this;
		}
		
		@Override 
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addObservedRates(List<BigDecimal> observedRatess) {
			if (observedRatess != null) {
				for (final BigDecimal toAdd : observedRatess) {
					this.observedRates.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("observedRates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder setObservedRates(List<BigDecimal> observedRatess) {
			if (observedRatess == null) {
				this.observedRates = new ArrayList<>();
			} else {
				this.observedRates = observedRatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("processedRates")
		@RuneAttribute("processedRates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(BigDecimal _processedRates) {
			if (_processedRates != null) {
				this.processedRates.add(_processedRates);
			}
			return this;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(BigDecimal _processedRates, int _idx) {
			getIndex(this.processedRates, _idx, () -> _processedRates);
			return this;
		}
		
		@Override 
		public CalculatedRateObservations.CalculatedRateObservationsBuilder addProcessedRates(List<BigDecimal> processedRatess) {
			if (processedRatess != null) {
				for (final BigDecimal toAdd : processedRatess) {
					this.processedRates.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("processedRates")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder setProcessedRates(List<BigDecimal> processedRatess) {
			if (processedRatess == null) {
				this.processedRates = new ArrayList<>();
			} else {
				this.processedRates = processedRatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CalculatedRateObservations build() {
			return new CalculatedRateObservations.CalculatedRateObservationsImpl(this);
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationDates()!=null && !getObservationDates().isEmpty()) return true;
			if (getWeights()!=null && !getWeights().isEmpty()) return true;
			if (getObservedRates()!=null && !getObservedRates().isEmpty()) return true;
			if (getProcessedRates()!=null && !getProcessedRates().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculatedRateObservations.CalculatedRateObservationsBuilder o = (CalculatedRateObservations.CalculatedRateObservationsBuilder) other;
			
			
			merger.mergeBasic(getObservationDates(), o.getObservationDates(), (Consumer<Date>) this::addObservationDates);
			merger.mergeBasic(getWeights(), o.getWeights(), (Consumer<BigDecimal>) this::addWeights);
			merger.mergeBasic(getObservedRates(), o.getObservedRates(), (Consumer<BigDecimal>) this::addObservedRates);
			merger.mergeBasic(getProcessedRates(), o.getProcessedRates(), (Consumer<BigDecimal>) this::addProcessedRates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedRateObservations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationDates, _that.getObservationDates())) return false;
			if (!ListEquals.listEquals(weights, _that.getWeights())) return false;
			if (!ListEquals.listEquals(observedRates, _that.getObservedRates())) return false;
			if (!ListEquals.listEquals(processedRates, _that.getProcessedRates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (weights != null ? weights.hashCode() : 0);
			_result = 31 * _result + (observedRates != null ? observedRates.hashCode() : 0);
			_result = 31 * _result + (processedRates != null ? processedRates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedRateObservationsBuilder {" +
				"observationDates=" + this.observationDates + ", " +
				"weights=" + this.weights + ", " +
				"observedRates=" + this.observedRates + ", " +
				"processedRates=" + this.processedRates +
			'}';
		}
	}
}
