package cdm.product.template;

import cdm.base.datetime.DateRange;
import cdm.base.datetime.DateRange.DateRangeBuilder;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder;
import cdm.product.template.SchedulePeriod;
import cdm.product.template.SchedulePeriod.SchedulePeriodBuilder;
import cdm.product.template.SchedulePeriod.SchedulePeriodBuilderImpl;
import cdm.product.template.SchedulePeriod.SchedulePeriodImpl;
import cdm.product.template.meta.SchedulePeriodMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class that defines the period of a schedule. The period contains a set of start and end dates, quantities, fixing, and pricing data.
 * @version 6.0.0
 */
@RosettaDataType(value="SchedulePeriod", builder=SchedulePeriod.SchedulePeriodBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SchedulePeriod", model="Just another Rosetta model", builder=SchedulePeriod.SchedulePeriodBuilderImpl.class, version="6.0.0")
public interface SchedulePeriod extends RosettaModelObject {

	SchedulePeriodMeta metaData = new SchedulePeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Period for which the payment is generated.
	 */
	DateRange getCalculationPeriod();
	/**
	 * Adjusted payment date.
	 */
	Date getPaymentDate();
	/**
	 * Period over which the underlying price is observed.
	 */
	DateRange getFixingPeriod();
	/**
	 * Period and time profile over which the delivery takes place.
	 */
	CalculationScheduleDeliveryPeriods getDeliveryPeriod();

	/*********************** Build Methods  ***********************/
	SchedulePeriod build();
	
	SchedulePeriod.SchedulePeriodBuilder toBuilder();
	
	static SchedulePeriod.SchedulePeriodBuilder builder() {
		return new SchedulePeriod.SchedulePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SchedulePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SchedulePeriod> getType() {
		return SchedulePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriod"), processor, DateRange.class, getCalculationPeriod());
		processor.processBasic(path.newSubPath("paymentDate"), Date.class, getPaymentDate(), this);
		processRosetta(path.newSubPath("fixingPeriod"), processor, DateRange.class, getFixingPeriod());
		processRosetta(path.newSubPath("deliveryPeriod"), processor, CalculationScheduleDeliveryPeriods.class, getDeliveryPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SchedulePeriodBuilder extends SchedulePeriod, RosettaModelObjectBuilder {
		DateRange.DateRangeBuilder getOrCreateCalculationPeriod();
		@Override
		DateRange.DateRangeBuilder getCalculationPeriod();
		DateRange.DateRangeBuilder getOrCreateFixingPeriod();
		@Override
		DateRange.DateRangeBuilder getFixingPeriod();
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder getOrCreateDeliveryPeriod();
		@Override
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder getDeliveryPeriod();
		SchedulePeriod.SchedulePeriodBuilder setCalculationPeriod(DateRange calculationPeriod);
		SchedulePeriod.SchedulePeriodBuilder setPaymentDate(Date paymentDate);
		SchedulePeriod.SchedulePeriodBuilder setFixingPeriod(DateRange fixingPeriod);
		SchedulePeriod.SchedulePeriodBuilder setDeliveryPeriod(CalculationScheduleDeliveryPeriods deliveryPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriod"), processor, DateRange.DateRangeBuilder.class, getCalculationPeriod());
			processor.processBasic(path.newSubPath("paymentDate"), Date.class, getPaymentDate(), this);
			processRosetta(path.newSubPath("fixingPeriod"), processor, DateRange.DateRangeBuilder.class, getFixingPeriod());
			processRosetta(path.newSubPath("deliveryPeriod"), processor, CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder.class, getDeliveryPeriod());
		}
		

		SchedulePeriod.SchedulePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of SchedulePeriod  ***********************/
	class SchedulePeriodImpl implements SchedulePeriod {
		private final DateRange calculationPeriod;
		private final Date paymentDate;
		private final DateRange fixingPeriod;
		private final CalculationScheduleDeliveryPeriods deliveryPeriod;
		
		protected SchedulePeriodImpl(SchedulePeriod.SchedulePeriodBuilder builder) {
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).map(f->f.build()).orElse(null);
			this.paymentDate = builder.getPaymentDate();
			this.fixingPeriod = ofNullable(builder.getFixingPeriod()).map(f->f.build()).orElse(null);
			this.deliveryPeriod = ofNullable(builder.getDeliveryPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@RuneAttribute("calculationPeriod")
		public DateRange getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@RuneAttribute("paymentDate")
		public Date getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("fixingPeriod")
		@RuneAttribute("fixingPeriod")
		public DateRange getFixingPeriod() {
			return fixingPeriod;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriod")
		@RuneAttribute("deliveryPeriod")
		public CalculationScheduleDeliveryPeriods getDeliveryPeriod() {
			return deliveryPeriod;
		}
		
		@Override
		public SchedulePeriod build() {
			return this;
		}
		
		@Override
		public SchedulePeriod.SchedulePeriodBuilder toBuilder() {
			SchedulePeriod.SchedulePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SchedulePeriod.SchedulePeriodBuilder builder) {
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getFixingPeriod()).ifPresent(builder::setFixingPeriod);
			ofNullable(getDeliveryPeriod()).ifPresent(builder::setDeliveryPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SchedulePeriod _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingPeriod, _that.getFixingPeriod())) return false;
			if (!Objects.equals(deliveryPeriod, _that.getDeliveryPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingPeriod != null ? fixingPeriod.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriod != null ? deliveryPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SchedulePeriod {" +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingPeriod=" + this.fixingPeriod + ", " +
				"deliveryPeriod=" + this.deliveryPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of SchedulePeriod  ***********************/
	class SchedulePeriodBuilderImpl implements SchedulePeriod.SchedulePeriodBuilder {
	
		protected DateRange.DateRangeBuilder calculationPeriod;
		protected Date paymentDate;
		protected DateRange.DateRangeBuilder fixingPeriod;
		protected CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder deliveryPeriod;
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@RuneAttribute("calculationPeriod")
		public DateRange.DateRangeBuilder getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public DateRange.DateRangeBuilder getOrCreateCalculationPeriod() {
			DateRange.DateRangeBuilder result;
			if (calculationPeriod!=null) {
				result = calculationPeriod;
			}
			else {
				result = calculationPeriod = DateRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@RuneAttribute("paymentDate")
		public Date getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("fixingPeriod")
		@RuneAttribute("fixingPeriod")
		public DateRange.DateRangeBuilder getFixingPeriod() {
			return fixingPeriod;
		}
		
		@Override
		public DateRange.DateRangeBuilder getOrCreateFixingPeriod() {
			DateRange.DateRangeBuilder result;
			if (fixingPeriod!=null) {
				result = fixingPeriod;
			}
			else {
				result = fixingPeriod = DateRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriod")
		@RuneAttribute("deliveryPeriod")
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder getDeliveryPeriod() {
			return deliveryPeriod;
		}
		
		@Override
		public CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder getOrCreateDeliveryPeriod() {
			CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder result;
			if (deliveryPeriod!=null) {
				result = deliveryPeriod;
			}
			else {
				result = deliveryPeriod = CalculationScheduleDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@RuneAttribute("calculationPeriod")
		public SchedulePeriod.SchedulePeriodBuilder setCalculationPeriod(DateRange _calculationPeriod) {
			this.calculationPeriod = _calculationPeriod == null ? null : _calculationPeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@RuneAttribute("paymentDate")
		public SchedulePeriod.SchedulePeriodBuilder setPaymentDate(Date _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("fixingPeriod")
		@RuneAttribute("fixingPeriod")
		public SchedulePeriod.SchedulePeriodBuilder setFixingPeriod(DateRange _fixingPeriod) {
			this.fixingPeriod = _fixingPeriod == null ? null : _fixingPeriod.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriod")
		@RuneAttribute("deliveryPeriod")
		public SchedulePeriod.SchedulePeriodBuilder setDeliveryPeriod(CalculationScheduleDeliveryPeriods _deliveryPeriod) {
			this.deliveryPeriod = _deliveryPeriod == null ? null : _deliveryPeriod.toBuilder();
			return this;
		}
		
		@Override
		public SchedulePeriod build() {
			return new SchedulePeriod.SchedulePeriodImpl(this);
		}
		
		@Override
		public SchedulePeriod.SchedulePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SchedulePeriod.SchedulePeriodBuilder prune() {
			if (calculationPeriod!=null && !calculationPeriod.prune().hasData()) calculationPeriod = null;
			if (fixingPeriod!=null && !fixingPeriod.prune().hasData()) fixingPeriod = null;
			if (deliveryPeriod!=null && !deliveryPeriod.prune().hasData()) deliveryPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriod()!=null && getCalculationPeriod().hasData()) return true;
			if (getPaymentDate()!=null) return true;
			if (getFixingPeriod()!=null && getFixingPeriod().hasData()) return true;
			if (getDeliveryPeriod()!=null && getDeliveryPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SchedulePeriod.SchedulePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SchedulePeriod.SchedulePeriodBuilder o = (SchedulePeriod.SchedulePeriodBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::setCalculationPeriod);
			merger.mergeRosetta(getFixingPeriod(), o.getFixingPeriod(), this::setFixingPeriod);
			merger.mergeRosetta(getDeliveryPeriod(), o.getDeliveryPeriod(), this::setDeliveryPeriod);
			
			merger.mergeBasic(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SchedulePeriod _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(fixingPeriod, _that.getFixingPeriod())) return false;
			if (!Objects.equals(deliveryPeriod, _that.getDeliveryPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (fixingPeriod != null ? fixingPeriod.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriod != null ? deliveryPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SchedulePeriodBuilder {" +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"fixingPeriod=" + this.fixingPeriod + ", " +
				"deliveryPeriod=" + this.deliveryPeriod +
			'}';
		}
	}
}
