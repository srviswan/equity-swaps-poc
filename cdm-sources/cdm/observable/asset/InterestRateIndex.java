package cdm.observable.asset;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilder;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InflationIndex.InflationIndexBuilder;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilder;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilderImpl;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexImpl;
import cdm.observable.asset.meta.InterestRateIndexMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An index based in interest rates or inflation rates in a certain market.
 * @version 6.0.0
 */
@RosettaDataType(value="InterestRateIndex", builder=InterestRateIndex.InterestRateIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="InterestRateIndex", model="Just another Rosetta model", builder=InterestRateIndex.InterestRateIndexBuilderImpl.class, version="6.0.0")
public interface InterestRateIndex extends RosettaModelObject {

	InterestRateIndexMeta metaData = new InterestRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
	 */
	InflationIndex getInflationIndex();

	/*********************** Build Methods  ***********************/
	InterestRateIndex build();
	
	InterestRateIndex.InterestRateIndexBuilder toBuilder();
	
	static InterestRateIndex.InterestRateIndexBuilder builder() {
		return new InterestRateIndex.InterestRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateIndex> getType() {
		return InterestRateIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("FloatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("InflationIndex"), processor, InflationIndex.class, getInflationIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateIndexBuilder extends InterestRateIndex, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		InflationIndex.InflationIndexBuilder getOrCreateInflationIndex();
		@Override
		InflationIndex.InflationIndexBuilder getInflationIndex();
		InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndex(FloatingRateIndex _FloatingRateIndex);
		InterestRateIndex.InterestRateIndexBuilder setInflationIndex(InflationIndex _InflationIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("FloatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("InflationIndex"), processor, InflationIndex.InflationIndexBuilder.class, getInflationIndex());
		}
		

		InterestRateIndex.InterestRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of InterestRateIndex  ***********************/
	class InterestRateIndexImpl implements InterestRateIndex {
		private final FloatingRateIndex floatingRateIndex;
		private final InflationIndex inflationIndex;
		
		protected InterestRateIndexImpl(InterestRateIndex.InterestRateIndexBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.inflationIndex = ofNullable(builder.getInflationIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("FloatingRateIndex")
		@RuneAttribute("FloatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("InflationIndex")
		@RuneAttribute("InflationIndex")
		public InflationIndex getInflationIndex() {
			return inflationIndex;
		}
		
		@Override
		public InterestRateIndex build() {
			return this;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder toBuilder() {
			InterestRateIndex.InterestRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateIndex.InterestRateIndexBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getInflationIndex()).ifPresent(builder::setInflationIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(inflationIndex, _that.getInflationIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (inflationIndex != null ? inflationIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateIndex {" +
				"FloatingRateIndex=" + this.floatingRateIndex + ", " +
				"InflationIndex=" + this.inflationIndex +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateIndex  ***********************/
	class InterestRateIndexBuilderImpl implements InterestRateIndex.InterestRateIndexBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected InflationIndex.InflationIndexBuilder inflationIndex;
		
		@Override
		@RosettaAttribute("FloatingRateIndex")
		@RuneAttribute("FloatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("InflationIndex")
		@RuneAttribute("InflationIndex")
		public InflationIndex.InflationIndexBuilder getInflationIndex() {
			return inflationIndex;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder getOrCreateInflationIndex() {
			InflationIndex.InflationIndexBuilder result;
			if (inflationIndex!=null) {
				result = inflationIndex;
			}
			else {
				result = inflationIndex = InflationIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FloatingRateIndex")
		@RuneAttribute("FloatingRateIndex")
		public InterestRateIndex.InterestRateIndexBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("InflationIndex")
		@RuneAttribute("InflationIndex")
		public InterestRateIndex.InterestRateIndexBuilder setInflationIndex(InflationIndex _inflationIndex) {
			this.inflationIndex = _inflationIndex == null ? null : _inflationIndex.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateIndex build() {
			return new InterestRateIndex.InterestRateIndexImpl(this);
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateIndex.InterestRateIndexBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (inflationIndex!=null && !inflationIndex.prune().hasData()) inflationIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getInflationIndex()!=null && getInflationIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateIndex.InterestRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateIndex.InterestRateIndexBuilder o = (InterestRateIndex.InterestRateIndexBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getInflationIndex(), o.getInflationIndex(), this::setInflationIndex);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(inflationIndex, _that.getInflationIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (inflationIndex != null ? inflationIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateIndexBuilder {" +
				"FloatingRateIndex=" + this.floatingRateIndex + ", " +
				"InflationIndex=" + this.inflationIndex +
			'}';
		}
	}
}
