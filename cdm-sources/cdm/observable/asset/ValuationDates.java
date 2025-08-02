package cdm.observable.asset;

import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDatesBuilder;
import cdm.observable.asset.ValuationDates;
import cdm.observable.asset.ValuationDates.ValuationDatesBuilder;
import cdm.observable.asset.ValuationDates.ValuationDatesBuilderImpl;
import cdm.observable.asset.ValuationDates.ValuationDatesImpl;
import cdm.observable.asset.meta.ValuationDatesMeta;
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
 * Defines how and when a performance type option or performance type swap is to be valued, including initial, interim and final valuation dates.
 * @version 6.0.0
 */
@RosettaDataType(value="ValuationDates", builder=ValuationDates.ValuationDatesBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ValuationDates", model="Just another Rosetta model", builder=ValuationDates.ValuationDatesBuilderImpl.class, version="6.0.0")
public interface ValuationDates extends RosettaModelObject {

	ValuationDatesMeta metaData = new ValuationDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the initial valuation dates of the underlyer.
	 */
	PerformanceValuationDates getInitialValuationDate();
	/**
	 * Specifies the interim valuation dates of the underlyer.
	 */
	PerformanceValuationDates getInterimValuationDate();
	/**
	 * Specifies the final valuation dates of the underlyer.
	 */
	PerformanceValuationDates getFinalValuationDate();

	/*********************** Build Methods  ***********************/
	ValuationDates build();
	
	ValuationDates.ValuationDatesBuilder toBuilder();
	
	static ValuationDates.ValuationDatesBuilder builder() {
		return new ValuationDates.ValuationDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationDates> getType() {
		return ValuationDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialValuationDate"), processor, PerformanceValuationDates.class, getInitialValuationDate());
		processRosetta(path.newSubPath("interimValuationDate"), processor, PerformanceValuationDates.class, getInterimValuationDate());
		processRosetta(path.newSubPath("finalValuationDate"), processor, PerformanceValuationDates.class, getFinalValuationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDatesBuilder extends ValuationDates, RosettaModelObjectBuilder {
		PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateInitialValuationDate();
		@Override
		PerformanceValuationDates.PerformanceValuationDatesBuilder getInitialValuationDate();
		PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateInterimValuationDate();
		@Override
		PerformanceValuationDates.PerformanceValuationDatesBuilder getInterimValuationDate();
		PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateFinalValuationDate();
		@Override
		PerformanceValuationDates.PerformanceValuationDatesBuilder getFinalValuationDate();
		ValuationDates.ValuationDatesBuilder setInitialValuationDate(PerformanceValuationDates initialValuationDate);
		ValuationDates.ValuationDatesBuilder setInterimValuationDate(PerformanceValuationDates interimValuationDate);
		ValuationDates.ValuationDatesBuilder setFinalValuationDate(PerformanceValuationDates finalValuationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialValuationDate"), processor, PerformanceValuationDates.PerformanceValuationDatesBuilder.class, getInitialValuationDate());
			processRosetta(path.newSubPath("interimValuationDate"), processor, PerformanceValuationDates.PerformanceValuationDatesBuilder.class, getInterimValuationDate());
			processRosetta(path.newSubPath("finalValuationDate"), processor, PerformanceValuationDates.PerformanceValuationDatesBuilder.class, getFinalValuationDate());
		}
		

		ValuationDates.ValuationDatesBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDates  ***********************/
	class ValuationDatesImpl implements ValuationDates {
		private final PerformanceValuationDates initialValuationDate;
		private final PerformanceValuationDates interimValuationDate;
		private final PerformanceValuationDates finalValuationDate;
		
		protected ValuationDatesImpl(ValuationDates.ValuationDatesBuilder builder) {
			this.initialValuationDate = ofNullable(builder.getInitialValuationDate()).map(f->f.build()).orElse(null);
			this.interimValuationDate = ofNullable(builder.getInterimValuationDate()).map(f->f.build()).orElse(null);
			this.finalValuationDate = ofNullable(builder.getFinalValuationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialValuationDate")
		@RuneAttribute("initialValuationDate")
		public PerformanceValuationDates getInitialValuationDate() {
			return initialValuationDate;
		}
		
		@Override
		@RosettaAttribute("interimValuationDate")
		@RuneAttribute("interimValuationDate")
		public PerformanceValuationDates getInterimValuationDate() {
			return interimValuationDate;
		}
		
		@Override
		@RosettaAttribute("finalValuationDate")
		@RuneAttribute("finalValuationDate")
		public PerformanceValuationDates getFinalValuationDate() {
			return finalValuationDate;
		}
		
		@Override
		public ValuationDates build() {
			return this;
		}
		
		@Override
		public ValuationDates.ValuationDatesBuilder toBuilder() {
			ValuationDates.ValuationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDates.ValuationDatesBuilder builder) {
			ofNullable(getInitialValuationDate()).ifPresent(builder::setInitialValuationDate);
			ofNullable(getInterimValuationDate()).ifPresent(builder::setInterimValuationDate);
			ofNullable(getFinalValuationDate()).ifPresent(builder::setFinalValuationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(initialValuationDate, _that.getInitialValuationDate())) return false;
			if (!Objects.equals(interimValuationDate, _that.getInterimValuationDate())) return false;
			if (!Objects.equals(finalValuationDate, _that.getFinalValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValuationDate != null ? initialValuationDate.hashCode() : 0);
			_result = 31 * _result + (interimValuationDate != null ? interimValuationDate.hashCode() : 0);
			_result = 31 * _result + (finalValuationDate != null ? finalValuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDates {" +
				"initialValuationDate=" + this.initialValuationDate + ", " +
				"interimValuationDate=" + this.interimValuationDate + ", " +
				"finalValuationDate=" + this.finalValuationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationDates  ***********************/
	class ValuationDatesBuilderImpl implements ValuationDates.ValuationDatesBuilder {
	
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder initialValuationDate;
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder interimValuationDate;
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder finalValuationDate;
		
		@Override
		@RosettaAttribute("initialValuationDate")
		@RuneAttribute("initialValuationDate")
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getInitialValuationDate() {
			return initialValuationDate;
		}
		
		@Override
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateInitialValuationDate() {
			PerformanceValuationDates.PerformanceValuationDatesBuilder result;
			if (initialValuationDate!=null) {
				result = initialValuationDate;
			}
			else {
				result = initialValuationDate = PerformanceValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interimValuationDate")
		@RuneAttribute("interimValuationDate")
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getInterimValuationDate() {
			return interimValuationDate;
		}
		
		@Override
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateInterimValuationDate() {
			PerformanceValuationDates.PerformanceValuationDatesBuilder result;
			if (interimValuationDate!=null) {
				result = interimValuationDate;
			}
			else {
				result = interimValuationDate = PerformanceValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalValuationDate")
		@RuneAttribute("finalValuationDate")
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getFinalValuationDate() {
			return finalValuationDate;
		}
		
		@Override
		public PerformanceValuationDates.PerformanceValuationDatesBuilder getOrCreateFinalValuationDate() {
			PerformanceValuationDates.PerformanceValuationDatesBuilder result;
			if (finalValuationDate!=null) {
				result = finalValuationDate;
			}
			else {
				result = finalValuationDate = PerformanceValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValuationDate")
		@RuneAttribute("initialValuationDate")
		public ValuationDates.ValuationDatesBuilder setInitialValuationDate(PerformanceValuationDates _initialValuationDate) {
			this.initialValuationDate = _initialValuationDate == null ? null : _initialValuationDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("interimValuationDate")
		@RuneAttribute("interimValuationDate")
		public ValuationDates.ValuationDatesBuilder setInterimValuationDate(PerformanceValuationDates _interimValuationDate) {
			this.interimValuationDate = _interimValuationDate == null ? null : _interimValuationDate.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("finalValuationDate")
		@RuneAttribute("finalValuationDate")
		public ValuationDates.ValuationDatesBuilder setFinalValuationDate(PerformanceValuationDates _finalValuationDate) {
			this.finalValuationDate = _finalValuationDate == null ? null : _finalValuationDate.toBuilder();
			return this;
		}
		
		@Override
		public ValuationDates build() {
			return new ValuationDates.ValuationDatesImpl(this);
		}
		
		@Override
		public ValuationDates.ValuationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDates.ValuationDatesBuilder prune() {
			if (initialValuationDate!=null && !initialValuationDate.prune().hasData()) initialValuationDate = null;
			if (interimValuationDate!=null && !interimValuationDate.prune().hasData()) interimValuationDate = null;
			if (finalValuationDate!=null && !finalValuationDate.prune().hasData()) finalValuationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialValuationDate()!=null && getInitialValuationDate().hasData()) return true;
			if (getInterimValuationDate()!=null && getInterimValuationDate().hasData()) return true;
			if (getFinalValuationDate()!=null && getFinalValuationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDates.ValuationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationDates.ValuationDatesBuilder o = (ValuationDates.ValuationDatesBuilder) other;
			
			merger.mergeRosetta(getInitialValuationDate(), o.getInitialValuationDate(), this::setInitialValuationDate);
			merger.mergeRosetta(getInterimValuationDate(), o.getInterimValuationDate(), this::setInterimValuationDate);
			merger.mergeRosetta(getFinalValuationDate(), o.getFinalValuationDate(), this::setFinalValuationDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDates _that = getType().cast(o);
		
			if (!Objects.equals(initialValuationDate, _that.getInitialValuationDate())) return false;
			if (!Objects.equals(interimValuationDate, _that.getInterimValuationDate())) return false;
			if (!Objects.equals(finalValuationDate, _that.getFinalValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValuationDate != null ? initialValuationDate.hashCode() : 0);
			_result = 31 * _result + (interimValuationDate != null ? interimValuationDate.hashCode() : 0);
			_result = 31 * _result + (finalValuationDate != null ? finalValuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDatesBuilder {" +
				"initialValuationDate=" + this.initialValuationDate + ", " +
				"interimValuationDate=" + this.interimValuationDate + ", " +
				"finalValuationDate=" + this.finalValuationDate +
			'}';
		}
	}
}
