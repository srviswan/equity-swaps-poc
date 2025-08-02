package cdm.observable.event;

import cdm.observable.event.Restructuring;
import cdm.observable.event.Restructuring.RestructuringBuilder;
import cdm.observable.event.Restructuring.RestructuringBuilderImpl;
import cdm.observable.event.Restructuring.RestructuringImpl;
import cdm.observable.event.RestructuringEnum;
import cdm.observable.event.meta.RestructuringMeta;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder;
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
 * @version 6.0.0
 */
@RosettaDataType(value="Restructuring", builder=Restructuring.RestructuringBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Restructuring", model="Just another Rosetta model", builder=Restructuring.RestructuringBuilderImpl.class, version="6.0.0")
public interface Restructuring extends RosettaModelObject {

	RestructuringMeta metaData = new RestructuringMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether the restructuring provision is applicable.
	 */
	Boolean getApplicable();
	/**
	 * Specifies the type of restructuring that is applicable.
	 */
	FieldWithMetaRestructuringEnum getRestructuringType();
	/**
	 * In relation to a restructuring credit event, unless multiple holder obligation is not specified restructurings are limited to multiple holder obligations. A multiple holder obligation means an obligation that is held by more than three holders that are not affiliates of each other and where at least two thirds of the holders must agree to the event that constitutes the restructuring credit event. ISDA 2003 Term: Multiple Holder Obligation.
	 */
	Boolean getMultipleHolderObligation();
	/**
	 * Presence of this element and value set to &#39;true&#39; indicates that Section 3.9 of the 2003 Credit Derivatives Definitions shall apply. Absence of this element indicates that Section 3.9 shall not apply. NOTE: Not allowed under ISDA Credit 1999.
	 */
	Boolean getMultipleCreditEventNotices();

	/*********************** Build Methods  ***********************/
	Restructuring build();
	
	Restructuring.RestructuringBuilder toBuilder();
	
	static Restructuring.RestructuringBuilder builder() {
		return new Restructuring.RestructuringBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Restructuring> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Restructuring> getType() {
		return Restructuring.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("restructuringType"), processor, FieldWithMetaRestructuringEnum.class, getRestructuringType());
		processor.processBasic(path.newSubPath("multipleHolderObligation"), Boolean.class, getMultipleHolderObligation(), this);
		processor.processBasic(path.newSubPath("multipleCreditEventNotices"), Boolean.class, getMultipleCreditEventNotices(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringBuilder extends Restructuring, RosettaModelObjectBuilder {
		FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder getOrCreateRestructuringType();
		@Override
		FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder getRestructuringType();
		Restructuring.RestructuringBuilder setApplicable(Boolean applicable);
		Restructuring.RestructuringBuilder setRestructuringType(FieldWithMetaRestructuringEnum restructuringType);
		Restructuring.RestructuringBuilder setRestructuringTypeValue(RestructuringEnum restructuringType);
		Restructuring.RestructuringBuilder setMultipleHolderObligation(Boolean multipleHolderObligation);
		Restructuring.RestructuringBuilder setMultipleCreditEventNotices(Boolean multipleCreditEventNotices);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("restructuringType"), processor, FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder.class, getRestructuringType());
			processor.processBasic(path.newSubPath("multipleHolderObligation"), Boolean.class, getMultipleHolderObligation(), this);
			processor.processBasic(path.newSubPath("multipleCreditEventNotices"), Boolean.class, getMultipleCreditEventNotices(), this);
		}
		

		Restructuring.RestructuringBuilder prune();
	}

	/*********************** Immutable Implementation of Restructuring  ***********************/
	class RestructuringImpl implements Restructuring {
		private final Boolean applicable;
		private final FieldWithMetaRestructuringEnum restructuringType;
		private final Boolean multipleHolderObligation;
		private final Boolean multipleCreditEventNotices;
		
		protected RestructuringImpl(Restructuring.RestructuringBuilder builder) {
			this.applicable = builder.getApplicable();
			this.restructuringType = ofNullable(builder.getRestructuringType()).map(f->f.build()).orElse(null);
			this.multipleHolderObligation = builder.getMultipleHolderObligation();
			this.multipleCreditEventNotices = builder.getMultipleCreditEventNotices();
		}
		
		@Override
		@RosettaAttribute("applicable")
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("restructuringType")
		@RuneAttribute("restructuringType")
		public FieldWithMetaRestructuringEnum getRestructuringType() {
			return restructuringType;
		}
		
		@Override
		@RosettaAttribute("multipleHolderObligation")
		@RuneAttribute("multipleHolderObligation")
		public Boolean getMultipleHolderObligation() {
			return multipleHolderObligation;
		}
		
		@Override
		@RosettaAttribute("multipleCreditEventNotices")
		@RuneAttribute("multipleCreditEventNotices")
		public Boolean getMultipleCreditEventNotices() {
			return multipleCreditEventNotices;
		}
		
		@Override
		public Restructuring build() {
			return this;
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			Restructuring.RestructuringBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Restructuring.RestructuringBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getRestructuringType()).ifPresent(builder::setRestructuringType);
			ofNullable(getMultipleHolderObligation()).ifPresent(builder::setMultipleHolderObligation);
			ofNullable(getMultipleCreditEventNotices()).ifPresent(builder::setMultipleCreditEventNotices);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Restructuring _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(restructuringType, _that.getRestructuringType())) return false;
			if (!Objects.equals(multipleHolderObligation, _that.getMultipleHolderObligation())) return false;
			if (!Objects.equals(multipleCreditEventNotices, _that.getMultipleCreditEventNotices())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (restructuringType != null ? restructuringType.hashCode() : 0);
			_result = 31 * _result + (multipleHolderObligation != null ? multipleHolderObligation.hashCode() : 0);
			_result = 31 * _result + (multipleCreditEventNotices != null ? multipleCreditEventNotices.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Restructuring {" +
				"applicable=" + this.applicable + ", " +
				"restructuringType=" + this.restructuringType + ", " +
				"multipleHolderObligation=" + this.multipleHolderObligation + ", " +
				"multipleCreditEventNotices=" + this.multipleCreditEventNotices +
			'}';
		}
	}

	/*********************** Builder Implementation of Restructuring  ***********************/
	class RestructuringBuilderImpl implements Restructuring.RestructuringBuilder {
	
		protected Boolean applicable;
		protected FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder restructuringType;
		protected Boolean multipleHolderObligation;
		protected Boolean multipleCreditEventNotices;
		
		@Override
		@RosettaAttribute("applicable")
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("restructuringType")
		@RuneAttribute("restructuringType")
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder getRestructuringType() {
			return restructuringType;
		}
		
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder getOrCreateRestructuringType() {
			FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder result;
			if (restructuringType!=null) {
				result = restructuringType;
			}
			else {
				result = restructuringType = FieldWithMetaRestructuringEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multipleHolderObligation")
		@RuneAttribute("multipleHolderObligation")
		public Boolean getMultipleHolderObligation() {
			return multipleHolderObligation;
		}
		
		@Override
		@RosettaAttribute("multipleCreditEventNotices")
		@RuneAttribute("multipleCreditEventNotices")
		public Boolean getMultipleCreditEventNotices() {
			return multipleCreditEventNotices;
		}
		
		@Override
		@RosettaAttribute("applicable")
		@RuneAttribute("applicable")
		public Restructuring.RestructuringBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@Override
		@RosettaAttribute("restructuringType")
		@RuneAttribute("restructuringType")
		public Restructuring.RestructuringBuilder setRestructuringType(FieldWithMetaRestructuringEnum _restructuringType) {
			this.restructuringType = _restructuringType == null ? null : _restructuringType.toBuilder();
			return this;
		}
		
		@Override
		public Restructuring.RestructuringBuilder setRestructuringTypeValue(RestructuringEnum _restructuringType) {
			this.getOrCreateRestructuringType().setValue(_restructuringType);
			return this;
		}
		
		@Override
		@RosettaAttribute("multipleHolderObligation")
		@RuneAttribute("multipleHolderObligation")
		public Restructuring.RestructuringBuilder setMultipleHolderObligation(Boolean _multipleHolderObligation) {
			this.multipleHolderObligation = _multipleHolderObligation == null ? null : _multipleHolderObligation;
			return this;
		}
		
		@Override
		@RosettaAttribute("multipleCreditEventNotices")
		@RuneAttribute("multipleCreditEventNotices")
		public Restructuring.RestructuringBuilder setMultipleCreditEventNotices(Boolean _multipleCreditEventNotices) {
			this.multipleCreditEventNotices = _multipleCreditEventNotices == null ? null : _multipleCreditEventNotices;
			return this;
		}
		
		@Override
		public Restructuring build() {
			return new Restructuring.RestructuringImpl(this);
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder prune() {
			if (restructuringType!=null && !restructuringType.prune().hasData()) restructuringType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getRestructuringType()!=null) return true;
			if (getMultipleHolderObligation()!=null) return true;
			if (getMultipleCreditEventNotices()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Restructuring.RestructuringBuilder o = (Restructuring.RestructuringBuilder) other;
			
			merger.mergeRosetta(getRestructuringType(), o.getRestructuringType(), this::setRestructuringType);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			merger.mergeBasic(getMultipleHolderObligation(), o.getMultipleHolderObligation(), this::setMultipleHolderObligation);
			merger.mergeBasic(getMultipleCreditEventNotices(), o.getMultipleCreditEventNotices(), this::setMultipleCreditEventNotices);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Restructuring _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(restructuringType, _that.getRestructuringType())) return false;
			if (!Objects.equals(multipleHolderObligation, _that.getMultipleHolderObligation())) return false;
			if (!Objects.equals(multipleCreditEventNotices, _that.getMultipleCreditEventNotices())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (restructuringType != null ? restructuringType.hashCode() : 0);
			_result = 31 * _result + (multipleHolderObligation != null ? multipleHolderObligation.hashCode() : 0);
			_result = 31 * _result + (multipleCreditEventNotices != null ? multipleCreditEventNotices.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringBuilder {" +
				"applicable=" + this.applicable + ", " +
				"restructuringType=" + this.restructuringType + ", " +
				"multipleHolderObligation=" + this.multipleHolderObligation + ", " +
				"multipleCreditEventNotices=" + this.multipleCreditEventNotices +
			'}';
		}
	}
}
