package cdm.observable.asset.metafields;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.BasketConstituent.BasketConstituentBuilder;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.FieldWithMeta;
import com.rosetta.model.lib.meta.FieldWithMeta.FieldWithMetaBuilder;
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
 * @version 1
 */
@RosettaDataType(value="FieldWithMetaBasketConstituent", builder=FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaBasketConstituent", model="Just another Rosetta model", builder=FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaBasketConstituent extends RosettaModelObject, FieldWithMeta<BasketConstituent>, GlobalKey {

	FieldWithMetaBasketConstituentMeta metaData = new FieldWithMetaBasketConstituentMeta();

	/*********************** Getter Methods  ***********************/
	BasketConstituent getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaBasketConstituent build();
	
	FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder toBuilder();
	
	static FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder builder() {
		return new FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaBasketConstituent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaBasketConstituent> getType() {
		return FieldWithMetaBasketConstituent.class;
	}
	
	@Override
	default Class<BasketConstituent> getValueType() {
		return BasketConstituent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("value"), processor, BasketConstituent.class, getValue());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaBasketConstituentBuilder extends FieldWithMetaBasketConstituent, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<BasketConstituent>, GlobalKey.GlobalKeyBuilder {
		BasketConstituent.BasketConstituentBuilder getOrCreateValue();
		@Override
		BasketConstituent.BasketConstituentBuilder getValue();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder setValue(BasketConstituent value);
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("value"), processor, BasketConstituent.BasketConstituentBuilder.class, getValue());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaBasketConstituent  ***********************/
	class FieldWithMetaBasketConstituentImpl implements FieldWithMetaBasketConstituent {
		private final BasketConstituent value;
		private final MetaFields meta;
		
		protected FieldWithMetaBasketConstituentImpl(FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder builder) {
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("@data")
		@RuneMetaType
		public BasketConstituent getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FieldWithMetaBasketConstituent build() {
			return this;
		}
		
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder toBuilder() {
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaBasketConstituent {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaBasketConstituent  ***********************/
	class FieldWithMetaBasketConstituentBuilderImpl implements FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder {
	
		protected BasketConstituent.BasketConstituentBuilder value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("@data")
		@RuneMetaType
		public BasketConstituent.BasketConstituentBuilder getValue() {
			return value;
		}
		
		@Override
		public BasketConstituent.BasketConstituentBuilder getOrCreateValue() {
			BasketConstituent.BasketConstituentBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = BasketConstituent.builder();
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
		@RosettaAttribute("value")
		@RuneAttribute("@data")
		@RuneMetaType
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder setValue(BasketConstituent _value) {
			this.value = _value == null ? null : _value.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaBasketConstituent build() {
			return new FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentImpl(this);
		}
		
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder prune() {
			if (value!=null && !value.prune().hasData()) value = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder o = (FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBasketConstituent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaBasketConstituentBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaBasketConstituentMeta extends BasicRosettaMetaData<FieldWithMetaBasketConstituent>{

}
