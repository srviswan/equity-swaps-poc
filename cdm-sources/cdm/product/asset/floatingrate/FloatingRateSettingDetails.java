package cdm.product.asset.floatingrate;

import cdm.observable.asset.calculatedrate.CalculatedRateDetails;
import cdm.observable.asset.calculatedrate.CalculatedRateDetails.CalculatedRateDetailsBuilder;
import cdm.product.asset.floatingrate.FloatingRateSettingDetails;
import cdm.product.asset.floatingrate.FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder;
import cdm.product.asset.floatingrate.FloatingRateSettingDetails.FloatingRateSettingDetailsBuilderImpl;
import cdm.product.asset.floatingrate.FloatingRateSettingDetails.FloatingRateSettingDetailsImpl;
import cdm.product.asset.floatingrate.meta.FloatingRateSettingDetailsMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Type for reporting the raw (untreated) observed or calculated rate for a calculation period.  If this is a calculated rate, it allows details of the observations and the resulting rate to be returned.
 * @version 6.0.0
 */
@RosettaDataType(value="FloatingRateSettingDetails", builder=FloatingRateSettingDetails.FloatingRateSettingDetailsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FloatingRateSettingDetails", model="Just another Rosetta model", builder=FloatingRateSettingDetails.FloatingRateSettingDetailsBuilderImpl.class, version="6.0.0")
public interface FloatingRateSettingDetails extends RosettaModelObject {

	FloatingRateSettingDetailsMeta metaData = new FloatingRateSettingDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Calculated rate details (observation dates, values, and weights).
	 */
	CalculatedRateDetails getCalculationDetails();
	/**
	 * The day upon which the rate was observed (for term rates).
	 */
	Date getObservationDate();
	/**
	 * The day for which the rate is needed (e.g. period beginning or end date).
	 */
	Date getResetDate();
	/**
	 * The resulting rate that was observed or calculated.
	 */
	BigDecimal getFloatingRate();

	/*********************** Build Methods  ***********************/
	FloatingRateSettingDetails build();
	
	FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder toBuilder();
	
	static FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder builder() {
		return new FloatingRateSettingDetails.FloatingRateSettingDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateSettingDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateSettingDetails> getType() {
		return FloatingRateSettingDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDetails"), processor, CalculatedRateDetails.class, getCalculationDetails());
		processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		processor.processBasic(path.newSubPath("floatingRate"), BigDecimal.class, getFloatingRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateSettingDetailsBuilder extends FloatingRateSettingDetails, RosettaModelObjectBuilder {
		CalculatedRateDetails.CalculatedRateDetailsBuilder getOrCreateCalculationDetails();
		@Override
		CalculatedRateDetails.CalculatedRateDetailsBuilder getCalculationDetails();
		FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setCalculationDetails(CalculatedRateDetails calculationDetails);
		FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setObservationDate(Date observationDate);
		FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setResetDate(Date resetDate);
		FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setFloatingRate(BigDecimal floatingRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDetails"), processor, CalculatedRateDetails.CalculatedRateDetailsBuilder.class, getCalculationDetails());
			processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			processor.processBasic(path.newSubPath("floatingRate"), BigDecimal.class, getFloatingRate(), this);
		}
		

		FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateSettingDetails  ***********************/
	class FloatingRateSettingDetailsImpl implements FloatingRateSettingDetails {
		private final CalculatedRateDetails calculationDetails;
		private final Date observationDate;
		private final Date resetDate;
		private final BigDecimal floatingRate;
		
		protected FloatingRateSettingDetailsImpl(FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder builder) {
			this.calculationDetails = ofNullable(builder.getCalculationDetails()).map(f->f.build()).orElse(null);
			this.observationDate = builder.getObservationDate();
			this.resetDate = builder.getResetDate();
			this.floatingRate = builder.getFloatingRate();
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@RuneAttribute("calculationDetails")
		public CalculatedRateDetails getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@RuneAttribute("floatingRate")
		public BigDecimal getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		public FloatingRateSettingDetails build() {
			return this;
		}
		
		@Override
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder toBuilder() {
			FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder builder) {
			ofNullable(getCalculationDetails()).ifPresent(builder::setCalculationDetails);
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
			ofNullable(getFloatingRate()).ifPresent(builder::setFloatingRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateSettingDetails _that = getType().cast(o);
		
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSettingDetails {" +
				"calculationDetails=" + this.calculationDetails + ", " +
				"observationDate=" + this.observationDate + ", " +
				"resetDate=" + this.resetDate + ", " +
				"floatingRate=" + this.floatingRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateSettingDetails  ***********************/
	class FloatingRateSettingDetailsBuilderImpl implements FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder {
	
		protected CalculatedRateDetails.CalculatedRateDetailsBuilder calculationDetails;
		protected Date observationDate;
		protected Date resetDate;
		protected BigDecimal floatingRate;
		
		@Override
		@RosettaAttribute("calculationDetails")
		@RuneAttribute("calculationDetails")
		public CalculatedRateDetails.CalculatedRateDetailsBuilder getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		public CalculatedRateDetails.CalculatedRateDetailsBuilder getOrCreateCalculationDetails() {
			CalculatedRateDetails.CalculatedRateDetailsBuilder result;
			if (calculationDetails!=null) {
				result = calculationDetails;
			}
			else {
				result = calculationDetails = CalculatedRateDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@RuneAttribute("floatingRate")
		public BigDecimal getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@RuneAttribute("calculationDetails")
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setCalculationDetails(CalculatedRateDetails _calculationDetails) {
			this.calculationDetails = _calculationDetails == null ? null : _calculationDetails.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@RuneAttribute("observationDate")
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setObservationDate(Date _observationDate) {
			this.observationDate = _observationDate == null ? null : _observationDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setResetDate(Date _resetDate) {
			this.resetDate = _resetDate == null ? null : _resetDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@RuneAttribute("floatingRate")
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder setFloatingRate(BigDecimal _floatingRate) {
			this.floatingRate = _floatingRate == null ? null : _floatingRate;
			return this;
		}
		
		@Override
		public FloatingRateSettingDetails build() {
			return new FloatingRateSettingDetails.FloatingRateSettingDetailsImpl(this);
		}
		
		@Override
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder prune() {
			if (calculationDetails!=null && !calculationDetails.prune().hasData()) calculationDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationDetails()!=null && getCalculationDetails().hasData()) return true;
			if (getObservationDate()!=null) return true;
			if (getResetDate()!=null) return true;
			if (getFloatingRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder o = (FloatingRateSettingDetails.FloatingRateSettingDetailsBuilder) other;
			
			merger.mergeRosetta(getCalculationDetails(), o.getCalculationDetails(), this::setCalculationDetails);
			
			merger.mergeBasic(getObservationDate(), o.getObservationDate(), this::setObservationDate);
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			merger.mergeBasic(getFloatingRate(), o.getFloatingRate(), this::setFloatingRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateSettingDetails _that = getType().cast(o);
		
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSettingDetailsBuilder {" +
				"calculationDetails=" + this.calculationDetails + ", " +
				"observationDate=" + this.observationDate + ", " +
				"resetDate=" + this.resetDate + ", " +
				"floatingRate=" + this.floatingRate +
			'}';
		}
	}
}
