package cdm.base.datetime;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableDates.AdjustableDatesBuilder;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl;
import cdm.base.datetime.PeriodicDates;
import cdm.base.datetime.PeriodicDates.PeriodicDatesBuilder;
import cdm.base.datetime.RelativeDates;
import cdm.base.datetime.RelativeDates.RelativeDatesBuilder;
import cdm.base.datetime.meta.AdjustableRelativeOrPeriodicDatesMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates, or as a calculation period schedule.
 * @version 6.0.0
 */
@RosettaDataType(value="AdjustableRelativeOrPeriodicDates", builder=AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AdjustableRelativeOrPeriodicDates", model="Just another Rosetta model", builder=AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl.class, version="6.0.0")
public interface AdjustableRelativeOrPeriodicDates extends RosettaModelObject, GlobalKey {

	AdjustableRelativeOrPeriodicDatesMeta metaData = new AdjustableRelativeOrPeriodicDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDates getAdjustableDates();
	/**
	 * A series of dates specified as some offset to another series of dates (the anchor dates).
	 */
	RelativeDates getRelativeDates();
	/**
	 * A calculation period schedule.
	 */
	PeriodicDates getPeriodicDates();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	AdjustableRelativeOrPeriodicDates build();
	
	AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder();
	
	static AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder() {
		return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableRelativeOrPeriodicDates> getType() {
		return AdjustableRelativeOrPeriodicDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.class, getRelativeDates());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableRelativeOrPeriodicDatesBuilder extends AdjustableRelativeOrPeriodicDates, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates();
		@Override
		RelativeDates.RelativeDatesBuilder getRelativeDates();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		@Override
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDates(RelativeDates relativeDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.RelativeDatesBuilder.class, getRelativeDates());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesImpl implements AdjustableRelativeOrPeriodicDates {
		private final AdjustableDates adjustableDates;
		private final RelativeDates relativeDates;
		private final PeriodicDates periodicDates;
		private final MetaFields meta;
		
		protected AdjustableRelativeOrPeriodicDatesImpl(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDates = ofNullable(builder.getRelativeDates()).map(f->f.build()).orElse(null);
			this.periodicDates = ofNullable(builder.getPeriodicDates()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		@RuneAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDates")
		@RuneAttribute("relativeDates")
		public RelativeDates getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@RuneAttribute("periodicDates")
		public PeriodicDates getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDates()).ifPresent(builder::setRelativeDates);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesBuilderImpl implements AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDates.RelativeDatesBuilder relativeDates;
		protected PeriodicDates.PeriodicDatesBuilder periodicDates;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("adjustableDates")
		@RuneAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDates")
		@RuneAttribute("relativeDates")
		public RelativeDates.RelativeDatesBuilder getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates() {
			RelativeDates.RelativeDatesBuilder result;
			if (relativeDates!=null) {
				result = relativeDates;
			}
			else {
				result = relativeDates = RelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@RuneAttribute("periodicDates")
		public PeriodicDates.PeriodicDatesBuilder getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates() {
			PeriodicDates.PeriodicDatesBuilder result;
			if (periodicDates!=null) {
				result = periodicDates;
			}
			else {
				result = periodicDates = PeriodicDates.builder();
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
		@RosettaAttribute("adjustableDates")
		@RuneAttribute("adjustableDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates _adjustableDates) {
			this.adjustableDates = _adjustableDates == null ? null : _adjustableDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relativeDates")
		@RuneAttribute("relativeDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDates(RelativeDates _relativeDates) {
			this.relativeDates = _relativeDates == null ? null : _relativeDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		@RuneAttribute("periodicDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates _periodicDates) {
			this.periodicDates = _periodicDates == null ? null : _periodicDates.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDates!=null && !relativeDates.prune().hasData()) relativeDates = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDates()!=null && getRelativeDates().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder o = (AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDates(), o.getRelativeDates(), this::setRelativeDates);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDatesBuilder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
