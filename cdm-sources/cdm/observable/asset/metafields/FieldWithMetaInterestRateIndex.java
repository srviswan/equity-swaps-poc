package cdm.observable.asset.metafields;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilder;
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
@RosettaDataType(value="FieldWithMetaInterestRateIndex", builder=FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaInterestRateIndex", model="Just another Rosetta model", builder=FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaInterestRateIndex extends RosettaModelObject, FieldWithMeta<InterestRateIndex>, GlobalKey {

	FieldWithMetaInterestRateIndexMeta metaData = new FieldWithMetaInterestRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	InterestRateIndex getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaInterestRateIndex build();
	
	FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder toBuilder();
	
	static FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder builder() {
		return new FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaInterestRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaInterestRateIndex> getType() {
		return FieldWithMetaInterestRateIndex.class;
	}
	
	@Override
	default Class<InterestRateIndex> getValueType() {
		return InterestRateIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("value"), processor, InterestRateIndex.class, getValue());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaInterestRateIndexBuilder extends FieldWithMetaInterestRateIndex, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<InterestRateIndex>, GlobalKey.GlobalKeyBuilder {
		InterestRateIndex.InterestRateIndexBuilder getOrCreateValue();
		@Override
		InterestRateIndex.InterestRateIndexBuilder getValue();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder setValue(InterestRateIndex value);
		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("value"), processor, InterestRateIndex.InterestRateIndexBuilder.class, getValue());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaInterestRateIndex  ***********************/
	class FieldWithMetaInterestRateIndexImpl implements FieldWithMetaInterestRateIndex {
		private final InterestRateIndex value;
		private final MetaFields meta;
		
		protected FieldWithMetaInterestRateIndexImpl(FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder builder) {
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("@data")
		@RuneMetaType
		public InterestRateIndex getValue() {
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
		public FieldWithMetaInterestRateIndex build() {
			return this;
		}
		
		@Override
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder toBuilder() {
			FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInterestRateIndex _that = getType().cast(o);
		
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
			return "FieldWithMetaInterestRateIndex {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaInterestRateIndex  ***********************/
	class FieldWithMetaInterestRateIndexBuilderImpl implements FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder {
	
		protected InterestRateIndex.InterestRateIndexBuilder value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@RuneAttribute("@data")
		@RuneMetaType
		public InterestRateIndex.InterestRateIndexBuilder getValue() {
			return value;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder getOrCreateValue() {
			InterestRateIndex.InterestRateIndexBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = InterestRateIndex.builder();
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
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder setValue(InterestRateIndex _value) {
			this.value = _value == null ? null : _value.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaInterestRateIndex build() {
			return new FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexImpl(this);
		}
		
		@Override
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder prune() {
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
		public FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder o = (FieldWithMetaInterestRateIndex.FieldWithMetaInterestRateIndexBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInterestRateIndex _that = getType().cast(o);
		
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
			return "FieldWithMetaInterestRateIndexBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaInterestRateIndexMeta extends BasicRosettaMetaData<FieldWithMetaInterestRateIndex>{

}
