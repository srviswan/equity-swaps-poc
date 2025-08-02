package cdm.observable.asset.calculatedrate;

import cdm.observable.asset.calculatedrate.CalculatedRateDetails;
import cdm.observable.asset.calculatedrate.CalculatedRateDetails.CalculatedRateDetailsBuilder;
import cdm.observable.asset.calculatedrate.CalculatedRateDetails.CalculatedRateDetailsBuilderImpl;
import cdm.observable.asset.calculatedrate.CalculatedRateDetails.CalculatedRateDetailsImpl;
import cdm.observable.asset.calculatedrate.CalculatedRateObservations;
import cdm.observable.asset.calculatedrate.CalculatedRateObservations.CalculatedRateObservationsBuilder;
import cdm.observable.asset.calculatedrate.meta.CalculatedRateDetailsMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Type for reporting details of calculated rates, including the observations that went into the final reported rate.
 * @version 6.0.0
 */
@RosettaDataType(value="CalculatedRateDetails", builder=CalculatedRateDetails.CalculatedRateDetailsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CalculatedRateDetails", model="Just another Rosetta model", builder=CalculatedRateDetails.CalculatedRateDetailsBuilderImpl.class, version="6.0.0")
public interface CalculatedRateDetails extends RosettaModelObject {

	CalculatedRateDetailsMeta metaData = new CalculatedRateDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The observation dates and weights for each observation date.
	 */
	CalculatedRateObservations getObservations();
	/**
	 * The weighted value of each observation.
	 */
	List<BigDecimal> getWeightedRates();
	/**
	 * The daily growth factors, showing the weighted rates divided by the day count basis plus one, giving how much the value grows for each step in the calculation.
	 */
	List<BigDecimal> getGrowthFactor();
	/**
	 * The compounding curve, showing how the initial value grew during the calculation period.
	 */
	List<BigDecimal> getCompoundedGrowth();
	/**
	 * The total sum or product of all the individual terms that went into the calculated rate.
	 */
	BigDecimal getAggregateValue();
	/**
	 * The total weight of all the terms that went into the calculated rate.
	 */
	BigDecimal getAggregateWeight();
	/**
	 * The resulting calculated weight.
	 */
	BigDecimal getCalculatedRate();

	/*********************** Build Methods  ***********************/
	CalculatedRateDetails build();
	
	CalculatedRateDetails.CalculatedRateDetailsBuilder toBuilder();
	
	static CalculatedRateDetails.CalculatedRateDetailsBuilder builder() {
		return new CalculatedRateDetails.CalculatedRateDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculatedRateDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculatedRateDetails> getType() {
		return CalculatedRateDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observations"), processor, CalculatedRateObservations.class, getObservations());
		processor.processBasic(path.newSubPath("weightedRates"), BigDecimal.class, getWeightedRates(), this);
		processor.processBasic(path.newSubPath("growthFactor"), BigDecimal.class, getGrowthFactor(), this);
		processor.processBasic(path.newSubPath("compoundedGrowth"), BigDecimal.class, getCompoundedGrowth(), this);
		processor.processBasic(path.newSubPath("aggregateValue"), BigDecimal.class, getAggregateValue(), this);
		processor.processBasic(path.newSubPath("aggregateWeight"), BigDecimal.class, getAggregateWeight(), this);
		processor.processBasic(path.newSubPath("calculatedRate"), BigDecimal.class, getCalculatedRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculatedRateDetailsBuilder extends CalculatedRateDetails, RosettaModelObjectBuilder {
		CalculatedRateObservations.CalculatedRateObservationsBuilder getOrCreateObservations();
		@Override
		CalculatedRateObservations.CalculatedRateObservationsBuilder getObservations();
		CalculatedRateDetails.CalculatedRateDetailsBuilder setObservations(CalculatedRateObservations observations);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(BigDecimal weightedRates);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(BigDecimal weightedRates, int _idx);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(List<BigDecimal> weightedRates);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setWeightedRates(List<BigDecimal> weightedRates);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(BigDecimal growthFactor);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(BigDecimal growthFactor, int _idx);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(List<BigDecimal> growthFactor);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setGrowthFactor(List<BigDecimal> growthFactor);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(BigDecimal compoundedGrowth);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(BigDecimal compoundedGrowth, int _idx);
		CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(List<BigDecimal> compoundedGrowth);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setCompoundedGrowth(List<BigDecimal> compoundedGrowth);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setAggregateValue(BigDecimal aggregateValue);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setAggregateWeight(BigDecimal aggregateWeight);
		CalculatedRateDetails.CalculatedRateDetailsBuilder setCalculatedRate(BigDecimal calculatedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observations"), processor, CalculatedRateObservations.CalculatedRateObservationsBuilder.class, getObservations());
			processor.processBasic(path.newSubPath("weightedRates"), BigDecimal.class, getWeightedRates(), this);
			processor.processBasic(path.newSubPath("growthFactor"), BigDecimal.class, getGrowthFactor(), this);
			processor.processBasic(path.newSubPath("compoundedGrowth"), BigDecimal.class, getCompoundedGrowth(), this);
			processor.processBasic(path.newSubPath("aggregateValue"), BigDecimal.class, getAggregateValue(), this);
			processor.processBasic(path.newSubPath("aggregateWeight"), BigDecimal.class, getAggregateWeight(), this);
			processor.processBasic(path.newSubPath("calculatedRate"), BigDecimal.class, getCalculatedRate(), this);
		}
		

		CalculatedRateDetails.CalculatedRateDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of CalculatedRateDetails  ***********************/
	class CalculatedRateDetailsImpl implements CalculatedRateDetails {
		private final CalculatedRateObservations observations;
		private final List<BigDecimal> weightedRates;
		private final List<BigDecimal> growthFactor;
		private final List<BigDecimal> compoundedGrowth;
		private final BigDecimal aggregateValue;
		private final BigDecimal aggregateWeight;
		private final BigDecimal calculatedRate;
		
		protected CalculatedRateDetailsImpl(CalculatedRateDetails.CalculatedRateDetailsBuilder builder) {
			this.observations = ofNullable(builder.getObservations()).map(f->f.build()).orElse(null);
			this.weightedRates = ofNullable(builder.getWeightedRates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.growthFactor = ofNullable(builder.getGrowthFactor()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.compoundedGrowth = ofNullable(builder.getCompoundedGrowth()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.aggregateValue = builder.getAggregateValue();
			this.aggregateWeight = builder.getAggregateWeight();
			this.calculatedRate = builder.getCalculatedRate();
		}
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public CalculatedRateObservations getObservations() {
			return observations;
		}
		
		@Override
		@RosettaAttribute("weightedRates")
		@RuneAttribute("weightedRates")
		public List<BigDecimal> getWeightedRates() {
			return weightedRates;
		}
		
		@Override
		@RosettaAttribute("growthFactor")
		@RuneAttribute("growthFactor")
		public List<BigDecimal> getGrowthFactor() {
			return growthFactor;
		}
		
		@Override
		@RosettaAttribute("compoundedGrowth")
		@RuneAttribute("compoundedGrowth")
		public List<BigDecimal> getCompoundedGrowth() {
			return compoundedGrowth;
		}
		
		@Override
		@RosettaAttribute("aggregateValue")
		@RuneAttribute("aggregateValue")
		public BigDecimal getAggregateValue() {
			return aggregateValue;
		}
		
		@Override
		@RosettaAttribute("aggregateWeight")
		@RuneAttribute("aggregateWeight")
		public BigDecimal getAggregateWeight() {
			return aggregateWeight;
		}
		
		@Override
		@RosettaAttribute("calculatedRate")
		@RuneAttribute("calculatedRate")
		public BigDecimal getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		public CalculatedRateDetails build() {
			return this;
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder toBuilder() {
			CalculatedRateDetails.CalculatedRateDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculatedRateDetails.CalculatedRateDetailsBuilder builder) {
			ofNullable(getObservations()).ifPresent(builder::setObservations);
			ofNullable(getWeightedRates()).ifPresent(builder::setWeightedRates);
			ofNullable(getGrowthFactor()).ifPresent(builder::setGrowthFactor);
			ofNullable(getCompoundedGrowth()).ifPresent(builder::setCompoundedGrowth);
			ofNullable(getAggregateValue()).ifPresent(builder::setAggregateValue);
			ofNullable(getAggregateWeight()).ifPresent(builder::setAggregateWeight);
			ofNullable(getCalculatedRate()).ifPresent(builder::setCalculatedRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedRateDetails _that = getType().cast(o);
		
			if (!Objects.equals(observations, _that.getObservations())) return false;
			if (!ListEquals.listEquals(weightedRates, _that.getWeightedRates())) return false;
			if (!ListEquals.listEquals(growthFactor, _that.getGrowthFactor())) return false;
			if (!ListEquals.listEquals(compoundedGrowth, _that.getCompoundedGrowth())) return false;
			if (!Objects.equals(aggregateValue, _that.getAggregateValue())) return false;
			if (!Objects.equals(aggregateWeight, _that.getAggregateWeight())) return false;
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (weightedRates != null ? weightedRates.hashCode() : 0);
			_result = 31 * _result + (growthFactor != null ? growthFactor.hashCode() : 0);
			_result = 31 * _result + (compoundedGrowth != null ? compoundedGrowth.hashCode() : 0);
			_result = 31 * _result + (aggregateValue != null ? aggregateValue.hashCode() : 0);
			_result = 31 * _result + (aggregateWeight != null ? aggregateWeight.hashCode() : 0);
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedRateDetails {" +
				"observations=" + this.observations + ", " +
				"weightedRates=" + this.weightedRates + ", " +
				"growthFactor=" + this.growthFactor + ", " +
				"compoundedGrowth=" + this.compoundedGrowth + ", " +
				"aggregateValue=" + this.aggregateValue + ", " +
				"aggregateWeight=" + this.aggregateWeight + ", " +
				"calculatedRate=" + this.calculatedRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculatedRateDetails  ***********************/
	class CalculatedRateDetailsBuilderImpl implements CalculatedRateDetails.CalculatedRateDetailsBuilder {
	
		protected CalculatedRateObservations.CalculatedRateObservationsBuilder observations;
		protected List<BigDecimal> weightedRates = new ArrayList<>();
		protected List<BigDecimal> growthFactor = new ArrayList<>();
		protected List<BigDecimal> compoundedGrowth = new ArrayList<>();
		protected BigDecimal aggregateValue;
		protected BigDecimal aggregateWeight;
		protected BigDecimal calculatedRate;
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public CalculatedRateObservations.CalculatedRateObservationsBuilder getObservations() {
			return observations;
		}
		
		@Override
		public CalculatedRateObservations.CalculatedRateObservationsBuilder getOrCreateObservations() {
			CalculatedRateObservations.CalculatedRateObservationsBuilder result;
			if (observations!=null) {
				result = observations;
			}
			else {
				result = observations = CalculatedRateObservations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weightedRates")
		@RuneAttribute("weightedRates")
		public List<BigDecimal> getWeightedRates() {
			return weightedRates;
		}
		
		@Override
		@RosettaAttribute("growthFactor")
		@RuneAttribute("growthFactor")
		public List<BigDecimal> getGrowthFactor() {
			return growthFactor;
		}
		
		@Override
		@RosettaAttribute("compoundedGrowth")
		@RuneAttribute("compoundedGrowth")
		public List<BigDecimal> getCompoundedGrowth() {
			return compoundedGrowth;
		}
		
		@Override
		@RosettaAttribute("aggregateValue")
		@RuneAttribute("aggregateValue")
		public BigDecimal getAggregateValue() {
			return aggregateValue;
		}
		
		@Override
		@RosettaAttribute("aggregateWeight")
		@RuneAttribute("aggregateWeight")
		public BigDecimal getAggregateWeight() {
			return aggregateWeight;
		}
		
		@Override
		@RosettaAttribute("calculatedRate")
		@RuneAttribute("calculatedRate")
		public BigDecimal getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setObservations(CalculatedRateObservations _observations) {
			this.observations = _observations == null ? null : _observations.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("weightedRates")
		@RuneAttribute("weightedRates")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(BigDecimal _weightedRates) {
			if (_weightedRates != null) {
				this.weightedRates.add(_weightedRates);
			}
			return this;
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(BigDecimal _weightedRates, int _idx) {
			getIndex(this.weightedRates, _idx, () -> _weightedRates);
			return this;
		}
		
		@Override 
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addWeightedRates(List<BigDecimal> weightedRatess) {
			if (weightedRatess != null) {
				for (final BigDecimal toAdd : weightedRatess) {
					this.weightedRates.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("weightedRates")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setWeightedRates(List<BigDecimal> weightedRatess) {
			if (weightedRatess == null) {
				this.weightedRates = new ArrayList<>();
			} else {
				this.weightedRates = weightedRatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("growthFactor")
		@RuneAttribute("growthFactor")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(BigDecimal _growthFactor) {
			if (_growthFactor != null) {
				this.growthFactor.add(_growthFactor);
			}
			return this;
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(BigDecimal _growthFactor, int _idx) {
			getIndex(this.growthFactor, _idx, () -> _growthFactor);
			return this;
		}
		
		@Override 
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addGrowthFactor(List<BigDecimal> growthFactors) {
			if (growthFactors != null) {
				for (final BigDecimal toAdd : growthFactors) {
					this.growthFactor.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("growthFactor")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setGrowthFactor(List<BigDecimal> growthFactors) {
			if (growthFactors == null) {
				this.growthFactor = new ArrayList<>();
			} else {
				this.growthFactor = growthFactors.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("compoundedGrowth")
		@RuneAttribute("compoundedGrowth")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(BigDecimal _compoundedGrowth) {
			if (_compoundedGrowth != null) {
				this.compoundedGrowth.add(_compoundedGrowth);
			}
			return this;
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(BigDecimal _compoundedGrowth, int _idx) {
			getIndex(this.compoundedGrowth, _idx, () -> _compoundedGrowth);
			return this;
		}
		
		@Override 
		public CalculatedRateDetails.CalculatedRateDetailsBuilder addCompoundedGrowth(List<BigDecimal> compoundedGrowths) {
			if (compoundedGrowths != null) {
				for (final BigDecimal toAdd : compoundedGrowths) {
					this.compoundedGrowth.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("compoundedGrowth")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setCompoundedGrowth(List<BigDecimal> compoundedGrowths) {
			if (compoundedGrowths == null) {
				this.compoundedGrowth = new ArrayList<>();
			} else {
				this.compoundedGrowth = compoundedGrowths.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("aggregateValue")
		@RuneAttribute("aggregateValue")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setAggregateValue(BigDecimal _aggregateValue) {
			this.aggregateValue = _aggregateValue == null ? null : _aggregateValue;
			return this;
		}
		
		@Override
		@RosettaAttribute("aggregateWeight")
		@RuneAttribute("aggregateWeight")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setAggregateWeight(BigDecimal _aggregateWeight) {
			this.aggregateWeight = _aggregateWeight == null ? null : _aggregateWeight;
			return this;
		}
		
		@Override
		@RosettaAttribute("calculatedRate")
		@RuneAttribute("calculatedRate")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder setCalculatedRate(BigDecimal _calculatedRate) {
			this.calculatedRate = _calculatedRate == null ? null : _calculatedRate;
			return this;
		}
		
		@Override
		public CalculatedRateDetails build() {
			return new CalculatedRateDetails.CalculatedRateDetailsImpl(this);
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder prune() {
			if (observations!=null && !observations.prune().hasData()) observations = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservations()!=null && getObservations().hasData()) return true;
			if (getWeightedRates()!=null && !getWeightedRates().isEmpty()) return true;
			if (getGrowthFactor()!=null && !getGrowthFactor().isEmpty()) return true;
			if (getCompoundedGrowth()!=null && !getCompoundedGrowth().isEmpty()) return true;
			if (getAggregateValue()!=null) return true;
			if (getAggregateWeight()!=null) return true;
			if (getCalculatedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculatedRateDetails.CalculatedRateDetailsBuilder o = (CalculatedRateDetails.CalculatedRateDetailsBuilder) other;
			
			merger.mergeRosetta(getObservations(), o.getObservations(), this::setObservations);
			
			merger.mergeBasic(getWeightedRates(), o.getWeightedRates(), (Consumer<BigDecimal>) this::addWeightedRates);
			merger.mergeBasic(getGrowthFactor(), o.getGrowthFactor(), (Consumer<BigDecimal>) this::addGrowthFactor);
			merger.mergeBasic(getCompoundedGrowth(), o.getCompoundedGrowth(), (Consumer<BigDecimal>) this::addCompoundedGrowth);
			merger.mergeBasic(getAggregateValue(), o.getAggregateValue(), this::setAggregateValue);
			merger.mergeBasic(getAggregateWeight(), o.getAggregateWeight(), this::setAggregateWeight);
			merger.mergeBasic(getCalculatedRate(), o.getCalculatedRate(), this::setCalculatedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedRateDetails _that = getType().cast(o);
		
			if (!Objects.equals(observations, _that.getObservations())) return false;
			if (!ListEquals.listEquals(weightedRates, _that.getWeightedRates())) return false;
			if (!ListEquals.listEquals(growthFactor, _that.getGrowthFactor())) return false;
			if (!ListEquals.listEquals(compoundedGrowth, _that.getCompoundedGrowth())) return false;
			if (!Objects.equals(aggregateValue, _that.getAggregateValue())) return false;
			if (!Objects.equals(aggregateWeight, _that.getAggregateWeight())) return false;
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (weightedRates != null ? weightedRates.hashCode() : 0);
			_result = 31 * _result + (growthFactor != null ? growthFactor.hashCode() : 0);
			_result = 31 * _result + (compoundedGrowth != null ? compoundedGrowth.hashCode() : 0);
			_result = 31 * _result + (aggregateValue != null ? aggregateValue.hashCode() : 0);
			_result = 31 * _result + (aggregateWeight != null ? aggregateWeight.hashCode() : 0);
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedRateDetailsBuilder {" +
				"observations=" + this.observations + ", " +
				"weightedRates=" + this.weightedRates + ", " +
				"growthFactor=" + this.growthFactor + ", " +
				"compoundedGrowth=" + this.compoundedGrowth + ", " +
				"aggregateValue=" + this.aggregateValue + ", " +
				"aggregateWeight=" + this.aggregateWeight + ", " +
				"calculatedRate=" + this.calculatedRate +
			'}';
		}
	}
}
