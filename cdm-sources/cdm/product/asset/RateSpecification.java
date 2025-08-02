package cdm.product.asset;

import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FixedRateSpecification.FixedRateSpecificationBuilder;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilder;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InflationRateSpecification.InflationRateSpecificationBuilder;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.RateSpecification.RateSpecificationBuilder;
import cdm.product.asset.RateSpecification.RateSpecificationBuilderImpl;
import cdm.product.asset.RateSpecification.RateSpecificationImpl;
import cdm.product.asset.meta.RateSpecificationMeta;
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
 *  A data type to specify the fixed interest rate, floating interest rate or inflation rate.
 * @version 6.0.0
 */
@RosettaDataType(value="RateSpecification", builder=RateSpecification.RateSpecificationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="RateSpecification", model="Just another Rosetta model", builder=RateSpecification.RateSpecificationBuilderImpl.class, version="6.0.0")
public interface RateSpecification extends RosettaModelObject {

	RateSpecificationMeta metaData = new RateSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.
	 */
	FixedRateSpecification getFixedRateSpecification();
	/**
	 * The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.
	 */
	FloatingRateSpecification getFloatingRateSpecification();
	/**
	 * An inflation rate calculation definition.
	 */
	InflationRateSpecification getInflationRateSpecification();

	/*********************** Build Methods  ***********************/
	RateSpecification build();
	
	RateSpecification.RateSpecificationBuilder toBuilder();
	
	static RateSpecification.RateSpecificationBuilder builder() {
		return new RateSpecification.RateSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateSpecification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RateSpecification> getType() {
		return RateSpecification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("FixedRateSpecification"), processor, FixedRateSpecification.class, getFixedRateSpecification());
		processRosetta(path.newSubPath("FloatingRateSpecification"), processor, FloatingRateSpecification.class, getFloatingRateSpecification());
		processRosetta(path.newSubPath("InflationRateSpecification"), processor, InflationRateSpecification.class, getInflationRateSpecification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateSpecificationBuilder extends RateSpecification, RosettaModelObjectBuilder {
		FixedRateSpecification.FixedRateSpecificationBuilder getOrCreateFixedRateSpecification();
		@Override
		FixedRateSpecification.FixedRateSpecificationBuilder getFixedRateSpecification();
		FloatingRateSpecification.FloatingRateSpecificationBuilder getOrCreateFloatingRateSpecification();
		@Override
		FloatingRateSpecification.FloatingRateSpecificationBuilder getFloatingRateSpecification();
		InflationRateSpecification.InflationRateSpecificationBuilder getOrCreateInflationRateSpecification();
		@Override
		InflationRateSpecification.InflationRateSpecificationBuilder getInflationRateSpecification();
		RateSpecification.RateSpecificationBuilder setFixedRateSpecification(FixedRateSpecification _FixedRateSpecification);
		RateSpecification.RateSpecificationBuilder setFloatingRateSpecification(FloatingRateSpecification _FloatingRateSpecification);
		RateSpecification.RateSpecificationBuilder setInflationRateSpecification(InflationRateSpecification _InflationRateSpecification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("FixedRateSpecification"), processor, FixedRateSpecification.FixedRateSpecificationBuilder.class, getFixedRateSpecification());
			processRosetta(path.newSubPath("FloatingRateSpecification"), processor, FloatingRateSpecification.FloatingRateSpecificationBuilder.class, getFloatingRateSpecification());
			processRosetta(path.newSubPath("InflationRateSpecification"), processor, InflationRateSpecification.InflationRateSpecificationBuilder.class, getInflationRateSpecification());
		}
		

		RateSpecification.RateSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of RateSpecification  ***********************/
	class RateSpecificationImpl implements RateSpecification {
		private final FixedRateSpecification fixedRateSpecification;
		private final FloatingRateSpecification floatingRateSpecification;
		private final InflationRateSpecification inflationRateSpecification;
		
		protected RateSpecificationImpl(RateSpecification.RateSpecificationBuilder builder) {
			this.fixedRateSpecification = ofNullable(builder.getFixedRateSpecification()).map(f->f.build()).orElse(null);
			this.floatingRateSpecification = ofNullable(builder.getFloatingRateSpecification()).map(f->f.build()).orElse(null);
			this.inflationRateSpecification = ofNullable(builder.getInflationRateSpecification()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("FixedRateSpecification")
		@RuneAttribute("FixedRateSpecification")
		public FixedRateSpecification getFixedRateSpecification() {
			return fixedRateSpecification;
		}
		
		@Override
		@RosettaAttribute("FloatingRateSpecification")
		@RuneAttribute("FloatingRateSpecification")
		public FloatingRateSpecification getFloatingRateSpecification() {
			return floatingRateSpecification;
		}
		
		@Override
		@RosettaAttribute("InflationRateSpecification")
		@RuneAttribute("InflationRateSpecification")
		public InflationRateSpecification getInflationRateSpecification() {
			return inflationRateSpecification;
		}
		
		@Override
		public RateSpecification build() {
			return this;
		}
		
		@Override
		public RateSpecification.RateSpecificationBuilder toBuilder() {
			RateSpecification.RateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateSpecification.RateSpecificationBuilder builder) {
			ofNullable(getFixedRateSpecification()).ifPresent(builder::setFixedRateSpecification);
			ofNullable(getFloatingRateSpecification()).ifPresent(builder::setFloatingRateSpecification);
			ofNullable(getInflationRateSpecification()).ifPresent(builder::setInflationRateSpecification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSpecification, _that.getFixedRateSpecification())) return false;
			if (!Objects.equals(floatingRateSpecification, _that.getFloatingRateSpecification())) return false;
			if (!Objects.equals(inflationRateSpecification, _that.getInflationRateSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSpecification != null ? fixedRateSpecification.hashCode() : 0);
			_result = 31 * _result + (floatingRateSpecification != null ? floatingRateSpecification.hashCode() : 0);
			_result = 31 * _result + (inflationRateSpecification != null ? inflationRateSpecification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateSpecification {" +
				"FixedRateSpecification=" + this.fixedRateSpecification + ", " +
				"FloatingRateSpecification=" + this.floatingRateSpecification + ", " +
				"InflationRateSpecification=" + this.inflationRateSpecification +
			'}';
		}
	}

	/*********************** Builder Implementation of RateSpecification  ***********************/
	class RateSpecificationBuilderImpl implements RateSpecification.RateSpecificationBuilder {
	
		protected FixedRateSpecification.FixedRateSpecificationBuilder fixedRateSpecification;
		protected FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecification;
		protected InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecification;
		
		@Override
		@RosettaAttribute("FixedRateSpecification")
		@RuneAttribute("FixedRateSpecification")
		public FixedRateSpecification.FixedRateSpecificationBuilder getFixedRateSpecification() {
			return fixedRateSpecification;
		}
		
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder getOrCreateFixedRateSpecification() {
			FixedRateSpecification.FixedRateSpecificationBuilder result;
			if (fixedRateSpecification!=null) {
				result = fixedRateSpecification;
			}
			else {
				result = fixedRateSpecification = FixedRateSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FloatingRateSpecification")
		@RuneAttribute("FloatingRateSpecification")
		public FloatingRateSpecification.FloatingRateSpecificationBuilder getFloatingRateSpecification() {
			return floatingRateSpecification;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder getOrCreateFloatingRateSpecification() {
			FloatingRateSpecification.FloatingRateSpecificationBuilder result;
			if (floatingRateSpecification!=null) {
				result = floatingRateSpecification;
			}
			else {
				result = floatingRateSpecification = FloatingRateSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("InflationRateSpecification")
		@RuneAttribute("InflationRateSpecification")
		public InflationRateSpecification.InflationRateSpecificationBuilder getInflationRateSpecification() {
			return inflationRateSpecification;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder getOrCreateInflationRateSpecification() {
			InflationRateSpecification.InflationRateSpecificationBuilder result;
			if (inflationRateSpecification!=null) {
				result = inflationRateSpecification;
			}
			else {
				result = inflationRateSpecification = InflationRateSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FixedRateSpecification")
		@RuneAttribute("FixedRateSpecification")
		public RateSpecification.RateSpecificationBuilder setFixedRateSpecification(FixedRateSpecification _fixedRateSpecification) {
			this.fixedRateSpecification = _fixedRateSpecification == null ? null : _fixedRateSpecification.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("FloatingRateSpecification")
		@RuneAttribute("FloatingRateSpecification")
		public RateSpecification.RateSpecificationBuilder setFloatingRateSpecification(FloatingRateSpecification _floatingRateSpecification) {
			this.floatingRateSpecification = _floatingRateSpecification == null ? null : _floatingRateSpecification.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("InflationRateSpecification")
		@RuneAttribute("InflationRateSpecification")
		public RateSpecification.RateSpecificationBuilder setInflationRateSpecification(InflationRateSpecification _inflationRateSpecification) {
			this.inflationRateSpecification = _inflationRateSpecification == null ? null : _inflationRateSpecification.toBuilder();
			return this;
		}
		
		@Override
		public RateSpecification build() {
			return new RateSpecification.RateSpecificationImpl(this);
		}
		
		@Override
		public RateSpecification.RateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSpecification.RateSpecificationBuilder prune() {
			if (fixedRateSpecification!=null && !fixedRateSpecification.prune().hasData()) fixedRateSpecification = null;
			if (floatingRateSpecification!=null && !floatingRateSpecification.prune().hasData()) floatingRateSpecification = null;
			if (inflationRateSpecification!=null && !inflationRateSpecification.prune().hasData()) inflationRateSpecification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateSpecification()!=null && getFixedRateSpecification().hasData()) return true;
			if (getFloatingRateSpecification()!=null && getFloatingRateSpecification().hasData()) return true;
			if (getInflationRateSpecification()!=null && getInflationRateSpecification().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSpecification.RateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateSpecification.RateSpecificationBuilder o = (RateSpecification.RateSpecificationBuilder) other;
			
			merger.mergeRosetta(getFixedRateSpecification(), o.getFixedRateSpecification(), this::setFixedRateSpecification);
			merger.mergeRosetta(getFloatingRateSpecification(), o.getFloatingRateSpecification(), this::setFloatingRateSpecification);
			merger.mergeRosetta(getInflationRateSpecification(), o.getInflationRateSpecification(), this::setInflationRateSpecification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSpecification, _that.getFixedRateSpecification())) return false;
			if (!Objects.equals(floatingRateSpecification, _that.getFloatingRateSpecification())) return false;
			if (!Objects.equals(inflationRateSpecification, _that.getInflationRateSpecification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateSpecification != null ? fixedRateSpecification.hashCode() : 0);
			_result = 31 * _result + (floatingRateSpecification != null ? floatingRateSpecification.hashCode() : 0);
			_result = 31 * _result + (inflationRateSpecification != null ? inflationRateSpecification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateSpecificationBuilder {" +
				"FixedRateSpecification=" + this.fixedRateSpecification + ", " +
				"FloatingRateSpecification=" + this.floatingRateSpecification + ", " +
				"InflationRateSpecification=" + this.inflationRateSpecification +
			'}';
		}
	}
}
