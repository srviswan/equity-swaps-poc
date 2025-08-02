package cdm.product.asset;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilderImpl;
import cdm.product.asset.SpreadSchedule.SpreadScheduleImpl;
import cdm.product.asset.SpreadScheduleTypeEnum;
import cdm.product.asset.meta.SpreadScheduleMeta;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.schedule.RateSchedule.RateScheduleBuilder;
import cdm.product.common.schedule.RateSchedule.RateScheduleBuilderImpl;
import cdm.product.common.schedule.RateSchedule.RateScheduleImpl;
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
 * Adds an optional spread type element to the Schedule to identify a long or short spread value.
 * @version 6.0.0
 */
@RosettaDataType(value="SpreadSchedule", builder=SpreadSchedule.SpreadScheduleBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SpreadSchedule", model="Just another Rosetta model", builder=SpreadSchedule.SpreadScheduleBuilderImpl.class, version="6.0.0")
public interface SpreadSchedule extends RateSchedule {

	SpreadScheduleMeta metaData = new SpreadScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element which purpose is to identify a long or short spread value.
	 */
	FieldWithMetaSpreadScheduleTypeEnum getSpreadScheduleType();

	/*********************** Build Methods  ***********************/
	SpreadSchedule build();
	
	SpreadSchedule.SpreadScheduleBuilder toBuilder();
	
	static SpreadSchedule.SpreadScheduleBuilder builder() {
		return new SpreadSchedule.SpreadScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpreadSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpreadSchedule> getType() {
		return SpreadSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("price"), processor, ReferenceWithMetaPriceSchedule.class, getPrice());
		processRosetta(path.newSubPath("spreadScheduleType"), processor, FieldWithMetaSpreadScheduleTypeEnum.class, getSpreadScheduleType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleBuilder extends SpreadSchedule, RateSchedule.RateScheduleBuilder {
		FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder getOrCreateSpreadScheduleType();
		@Override
		FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder getSpreadScheduleType();
		@Override
		SpreadSchedule.SpreadScheduleBuilder setPrice(ReferenceWithMetaPriceSchedule price);
		@Override
		SpreadSchedule.SpreadScheduleBuilder setPriceValue(PriceSchedule price);
		SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleType(FieldWithMetaSpreadScheduleTypeEnum spreadScheduleType);
		SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleTypeValue(SpreadScheduleTypeEnum spreadScheduleType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("price"), processor, ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder.class, getPrice());
			processRosetta(path.newSubPath("spreadScheduleType"), processor, FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder.class, getSpreadScheduleType());
		}
		

		SpreadSchedule.SpreadScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleImpl extends RateSchedule.RateScheduleImpl implements SpreadSchedule {
		private final FieldWithMetaSpreadScheduleTypeEnum spreadScheduleType;
		
		protected SpreadScheduleImpl(SpreadSchedule.SpreadScheduleBuilder builder) {
			super(builder);
			this.spreadScheduleType = ofNullable(builder.getSpreadScheduleType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spreadScheduleType")
		@RuneAttribute("spreadScheduleType")
		public FieldWithMetaSpreadScheduleTypeEnum getSpreadScheduleType() {
			return spreadScheduleType;
		}
		
		@Override
		public SpreadSchedule build() {
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			SpreadSchedule.SpreadScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadSchedule.SpreadScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSpreadScheduleType()).ifPresent(builder::setSpreadScheduleType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(spreadScheduleType, _that.getSpreadScheduleType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadScheduleType != null ? spreadScheduleType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadSchedule {" +
				"spreadScheduleType=" + this.spreadScheduleType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SpreadSchedule  ***********************/
	class SpreadScheduleBuilderImpl extends RateSchedule.RateScheduleBuilderImpl implements SpreadSchedule.SpreadScheduleBuilder {
	
		protected FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder spreadScheduleType;
		
		@Override
		@RosettaAttribute("spreadScheduleType")
		@RuneAttribute("spreadScheduleType")
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder getSpreadScheduleType() {
			return spreadScheduleType;
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder getOrCreateSpreadScheduleType() {
			FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder result;
			if (spreadScheduleType!=null) {
				result = spreadScheduleType;
			}
			else {
				result = spreadScheduleType = FieldWithMetaSpreadScheduleTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("price")
		@RuneAttribute("price")
		public SpreadSchedule.SpreadScheduleBuilder setPrice(ReferenceWithMetaPriceSchedule _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setPriceValue(PriceSchedule _price) {
			this.getOrCreatePrice().setValue(_price);
			return this;
		}
		
		@Override
		@RosettaAttribute("spreadScheduleType")
		@RuneAttribute("spreadScheduleType")
		public SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleType(FieldWithMetaSpreadScheduleTypeEnum _spreadScheduleType) {
			this.spreadScheduleType = _spreadScheduleType == null ? null : _spreadScheduleType.toBuilder();
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleTypeValue(SpreadScheduleTypeEnum _spreadScheduleType) {
			this.getOrCreateSpreadScheduleType().setValue(_spreadScheduleType);
			return this;
		}
		
		@Override
		public SpreadSchedule build() {
			return new SpreadSchedule.SpreadScheduleImpl(this);
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder prune() {
			super.prune();
			if (spreadScheduleType!=null && !spreadScheduleType.prune().hasData()) spreadScheduleType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSpreadScheduleType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpreadSchedule.SpreadScheduleBuilder o = (SpreadSchedule.SpreadScheduleBuilder) other;
			
			merger.mergeRosetta(getSpreadScheduleType(), o.getSpreadScheduleType(), this::setSpreadScheduleType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(spreadScheduleType, _that.getSpreadScheduleType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadScheduleType != null ? spreadScheduleType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleBuilder {" +
				"spreadScheduleType=" + this.spreadScheduleType +
			'}' + " " + super.toString();
		}
	}
}
