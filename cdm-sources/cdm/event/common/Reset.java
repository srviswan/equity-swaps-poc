package cdm.event.common;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.event.common.Reset.ResetBuilderImpl;
import cdm.event.common.Reset.ResetImpl;
import cdm.event.common.meta.ResetMeta;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.event.Observation;
import cdm.observable.event.metafields.ReferenceWithMetaObservation;
import cdm.observable.event.metafields.ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder;
import cdm.product.template.AveragingCalculation;
import cdm.product.template.AveragingCalculation.AveragingCalculationBuilder;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the reset value or fixing value produced in cashflow calculations, during the life-cycle of a financial instrument. The reset process defined in Create_Reset function joins product definition details with observations to compute the reset value.
 * @version 6.0.0
 */
@RosettaDataType(value="Reset", builder=Reset.ResetBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Reset", model="Just another Rosetta model", builder=Reset.ResetBuilderImpl.class, version="6.0.0")
public interface Reset extends RosettaModelObject, GlobalKey {

	ResetMeta metaData = new ResetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the reset or fixing value. The fixing value could be a cash price, interest rate, or other value.
	 */
	Price getResetValue();
	/**
	 * Specifies the date on which the reset occurred.
	 */
	Date getResetDate();
	/**
	 * Specifies the &#39;Rate Record Day&#39; for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset-&gt;resetDate occurs at the end of the interest period, and the Reset-&gt;rateRecordDate occurs near the start of the interest period.  The Reset-&gt;rateRecordDate and Reset-&gt;observations-&gt;observationIdentifier-&gt;observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
	 */
	Date getRateRecordDate();
	/**
	 * Represents an audit of the observations used to produce the reset value. If multiple observations were necessary to produce the reset value, the aggregation method should be defined on the payout.
	 */
	List<? extends ReferenceWithMetaObservation> getObservations();
	/**
	 * Identifies the aggregation method to use in the case where multiple observations are used to compute the reset value and the method is not defined in a payout.
	 */
	AveragingCalculation getAveragingMethodology();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	Reset build();
	
	Reset.ResetBuilder toBuilder();
	
	static Reset.ResetBuilder builder() {
		return new Reset.ResetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Reset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Reset> getType() {
		return Reset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("resetValue"), processor, Price.class, getResetValue());
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
		processRosetta(path.newSubPath("observations"), processor, ReferenceWithMetaObservation.class, getObservations());
		processRosetta(path.newSubPath("averagingMethodology"), processor, AveragingCalculation.class, getAveragingMethodology());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetBuilder extends Reset, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		Price.PriceBuilder getOrCreateResetValue();
		@Override
		Price.PriceBuilder getResetValue();
		ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder getOrCreateObservations(int _index);
		@Override
		List<? extends ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder> getObservations();
		AveragingCalculation.AveragingCalculationBuilder getOrCreateAveragingMethodology();
		@Override
		AveragingCalculation.AveragingCalculationBuilder getAveragingMethodology();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		Reset.ResetBuilder setResetValue(Price resetValue);
		Reset.ResetBuilder setResetDate(Date resetDate);
		Reset.ResetBuilder setRateRecordDate(Date rateRecordDate);
		Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations);
		Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations, int _idx);
		Reset.ResetBuilder addObservationsValue(Observation observations);
		Reset.ResetBuilder addObservationsValue(Observation observations, int _idx);
		Reset.ResetBuilder addObservations(List<? extends ReferenceWithMetaObservation> observations);
		Reset.ResetBuilder setObservations(List<? extends ReferenceWithMetaObservation> observations);
		Reset.ResetBuilder addObservationsValue(List<? extends Observation> observations);
		Reset.ResetBuilder setObservationsValue(List<? extends Observation> observations);
		Reset.ResetBuilder setAveragingMethodology(AveragingCalculation averagingMethodology);
		Reset.ResetBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("resetValue"), processor, Price.PriceBuilder.class, getResetValue());
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
			processRosetta(path.newSubPath("observations"), processor, ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder.class, getObservations());
			processRosetta(path.newSubPath("averagingMethodology"), processor, AveragingCalculation.AveragingCalculationBuilder.class, getAveragingMethodology());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		Reset.ResetBuilder prune();
	}

	/*********************** Immutable Implementation of Reset  ***********************/
	class ResetImpl implements Reset {
		private final Price resetValue;
		private final Date resetDate;
		private final Date rateRecordDate;
		private final List<? extends ReferenceWithMetaObservation> observations;
		private final AveragingCalculation averagingMethodology;
		private final MetaFields meta;
		
		protected ResetImpl(Reset.ResetBuilder builder) {
			this.resetValue = ofNullable(builder.getResetValue()).map(f->f.build()).orElse(null);
			this.resetDate = builder.getResetDate();
			this.rateRecordDate = builder.getRateRecordDate();
			this.observations = ofNullable(builder.getObservations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.averagingMethodology = ofNullable(builder.getAveragingMethodology()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("resetValue")
		@RuneAttribute("resetValue")
		public Price getResetValue() {
			return resetValue;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public List<? extends ReferenceWithMetaObservation> getObservations() {
			return observations;
		}
		
		@Override
		@RosettaAttribute("averagingMethodology")
		@RuneAttribute("averagingMethodology")
		public AveragingCalculation getAveragingMethodology() {
			return averagingMethodology;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Reset build() {
			return this;
		}
		
		@Override
		public Reset.ResetBuilder toBuilder() {
			Reset.ResetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reset.ResetBuilder builder) {
			ofNullable(getResetValue()).ifPresent(builder::setResetValue);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
			ofNullable(getRateRecordDate()).ifPresent(builder::setRateRecordDate);
			ofNullable(getObservations()).ifPresent(builder::setObservations);
			ofNullable(getAveragingMethodology()).ifPresent(builder::setAveragingMethodology);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reset _that = getType().cast(o);
		
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!ListEquals.listEquals(observations, _that.getObservations())) return false;
			if (!Objects.equals(averagingMethodology, _that.getAveragingMethodology())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (averagingMethodology != null ? averagingMethodology.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Reset {" +
				"resetValue=" + this.resetValue + ", " +
				"resetDate=" + this.resetDate + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"observations=" + this.observations + ", " +
				"averagingMethodology=" + this.averagingMethodology + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of Reset  ***********************/
	class ResetBuilderImpl implements Reset.ResetBuilder {
	
		protected Price.PriceBuilder resetValue;
		protected Date resetDate;
		protected Date rateRecordDate;
		protected List<ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder> observations = new ArrayList<>();
		protected AveragingCalculation.AveragingCalculationBuilder averagingMethodology;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("resetValue")
		@RuneAttribute("resetValue")
		public Price.PriceBuilder getResetValue() {
			return resetValue;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateResetValue() {
			Price.PriceBuilder result;
			if (resetValue!=null) {
				result = resetValue;
			}
			else {
				result = resetValue = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public List<? extends ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder> getObservations() {
			return observations;
		}
		
		@Override
		public ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder getOrCreateObservations(int _index) {
		
			if (observations==null) {
				this.observations = new ArrayList<>();
			}
			ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder result;
			return getIndex(observations, _index, () -> {
						ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder newObservations = ReferenceWithMetaObservation.builder();
						return newObservations;
					});
		}
		
		@Override
		@RosettaAttribute("averagingMethodology")
		@RuneAttribute("averagingMethodology")
		public AveragingCalculation.AveragingCalculationBuilder getAveragingMethodology() {
			return averagingMethodology;
		}
		
		@Override
		public AveragingCalculation.AveragingCalculationBuilder getOrCreateAveragingMethodology() {
			AveragingCalculation.AveragingCalculationBuilder result;
			if (averagingMethodology!=null) {
				result = averagingMethodology;
			}
			else {
				result = averagingMethodology = AveragingCalculation.builder();
			}
			
			return result;
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
		@RosettaAttribute("resetValue")
		@RuneAttribute("resetValue")
		public Reset.ResetBuilder setResetValue(Price _resetValue) {
			this.resetValue = _resetValue == null ? null : _resetValue.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Reset.ResetBuilder setResetDate(Date _resetDate) {
			this.resetDate = _resetDate == null ? null : _resetDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public Reset.ResetBuilder setRateRecordDate(Date _rateRecordDate) {
			this.rateRecordDate = _rateRecordDate == null ? null : _rateRecordDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("observations")
		@RuneAttribute("observations")
		public Reset.ResetBuilder addObservations(ReferenceWithMetaObservation _observations) {
			if (_observations != null) {
				this.observations.add(_observations.toBuilder());
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservations(ReferenceWithMetaObservation _observations, int _idx) {
			getIndex(this.observations, _idx, () -> _observations.toBuilder());
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservationsValue(Observation _observations) {
			this.getOrCreateObservations(-1).setValue(_observations.toBuilder());
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservationsValue(Observation _observations, int _idx) {
			this.getOrCreateObservations(_idx).setValue(_observations.toBuilder());
			return this;
		}
		
		@Override 
		public Reset.ResetBuilder addObservations(List<? extends ReferenceWithMetaObservation> observationss) {
			if (observationss != null) {
				for (final ReferenceWithMetaObservation toAdd : observationss) {
					this.observations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("observations")
		public Reset.ResetBuilder setObservations(List<? extends ReferenceWithMetaObservation> observationss) {
			if (observationss == null) {
				this.observations = new ArrayList<>();
			} else {
				this.observations = observationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservationsValue(List<? extends Observation> observationss) {
			if (observationss != null) {
				for (final Observation toAdd : observationss) {
					this.addObservationsValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder setObservationsValue(List<? extends Observation> observationss) {
			this.observations.clear();
			if (observationss != null) {
				observationss.forEach(this::addObservationsValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("averagingMethodology")
		@RuneAttribute("averagingMethodology")
		public Reset.ResetBuilder setAveragingMethodology(AveragingCalculation _averagingMethodology) {
			this.averagingMethodology = _averagingMethodology == null ? null : _averagingMethodology.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public Reset.ResetBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public Reset build() {
			return new Reset.ResetImpl(this);
		}
		
		@Override
		public Reset.ResetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reset.ResetBuilder prune() {
			if (resetValue!=null && !resetValue.prune().hasData()) resetValue = null;
			observations = observations.stream().filter(b->b!=null).<ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (averagingMethodology!=null && !averagingMethodology.prune().hasData()) averagingMethodology = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResetValue()!=null && getResetValue().hasData()) return true;
			if (getResetDate()!=null) return true;
			if (getRateRecordDate()!=null) return true;
			if (getObservations()!=null && getObservations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAveragingMethodology()!=null && getAveragingMethodology().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reset.ResetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Reset.ResetBuilder o = (Reset.ResetBuilder) other;
			
			merger.mergeRosetta(getResetValue(), o.getResetValue(), this::setResetValue);
			merger.mergeRosetta(getObservations(), o.getObservations(), this::getOrCreateObservations);
			merger.mergeRosetta(getAveragingMethodology(), o.getAveragingMethodology(), this::setAveragingMethodology);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			merger.mergeBasic(getRateRecordDate(), o.getRateRecordDate(), this::setRateRecordDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reset _that = getType().cast(o);
		
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!ListEquals.listEquals(observations, _that.getObservations())) return false;
			if (!Objects.equals(averagingMethodology, _that.getAveragingMethodology())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (averagingMethodology != null ? averagingMethodology.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetBuilder {" +
				"resetValue=" + this.resetValue + ", " +
				"resetDate=" + this.resetDate + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"observations=" + this.observations + ", " +
				"averagingMethodology=" + this.averagingMethodology + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
