package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyClassification.TaxonomyClassificationBuilder;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomyValue.TaxonomyValueBuilder;
import cdm.base.staticdata.asset.common.TaxonomyValue.TaxonomyValueBuilderImpl;
import cdm.base.staticdata.asset.common.TaxonomyValue.TaxonomyValueImpl;
import cdm.base.staticdata.asset.common.meta.TaxonomyValueMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a taxonomy value as either a simple string or a more granular expression with class names and values for each class.
 * @version 6.0.0
 */
@RosettaDataType(value="TaxonomyValue", builder=TaxonomyValue.TaxonomyValueBuilderImpl.class, version="6.0.0")
@RuneDataType(value="TaxonomyValue", model="Just another Rosetta model", builder=TaxonomyValue.TaxonomyValueBuilderImpl.class, version="6.0.0")
public interface TaxonomyValue extends RosettaModelObject {

	TaxonomyValueMeta metaData = new TaxonomyValueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the taxonomy value as a simple string, which may be associated to an external scheme.
	 */
	FieldWithMetaString getName();
	/**
	 * Specifies the taxonomy value as a set of class names and values for each class.
	 */
	List<? extends TaxonomyClassification> getClassification();

	/*********************** Build Methods  ***********************/
	TaxonomyValue build();
	
	TaxonomyValue.TaxonomyValueBuilder toBuilder();
	
	static TaxonomyValue.TaxonomyValueBuilder builder() {
		return new TaxonomyValue.TaxonomyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaxonomyValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaxonomyValue> getType() {
		return TaxonomyValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("classification"), processor, TaxonomyClassification.class, getClassification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaxonomyValueBuilder extends TaxonomyValue, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getName();
		TaxonomyClassification.TaxonomyClassificationBuilder getOrCreateClassification(int _index);
		@Override
		List<? extends TaxonomyClassification.TaxonomyClassificationBuilder> getClassification();
		TaxonomyValue.TaxonomyValueBuilder setName(FieldWithMetaString name);
		TaxonomyValue.TaxonomyValueBuilder setNameValue(String name);
		TaxonomyValue.TaxonomyValueBuilder addClassification(TaxonomyClassification classification);
		TaxonomyValue.TaxonomyValueBuilder addClassification(TaxonomyClassification classification, int _idx);
		TaxonomyValue.TaxonomyValueBuilder addClassification(List<? extends TaxonomyClassification> classification);
		TaxonomyValue.TaxonomyValueBuilder setClassification(List<? extends TaxonomyClassification> classification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("classification"), processor, TaxonomyClassification.TaxonomyClassificationBuilder.class, getClassification());
		}
		

		TaxonomyValue.TaxonomyValueBuilder prune();
	}

	/*********************** Immutable Implementation of TaxonomyValue  ***********************/
	class TaxonomyValueImpl implements TaxonomyValue {
		private final FieldWithMetaString name;
		private final List<? extends TaxonomyClassification> classification;
		
		protected TaxonomyValueImpl(TaxonomyValue.TaxonomyValueBuilder builder) {
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.classification = ofNullable(builder.getClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("classification")
		@RuneAttribute("classification")
		public List<? extends TaxonomyClassification> getClassification() {
			return classification;
		}
		
		@Override
		public TaxonomyValue build() {
			return this;
		}
		
		@Override
		public TaxonomyValue.TaxonomyValueBuilder toBuilder() {
			TaxonomyValue.TaxonomyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaxonomyValue.TaxonomyValueBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getClassification()).ifPresent(builder::setClassification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxonomyValue _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxonomyValue {" +
				"name=" + this.name + ", " +
				"classification=" + this.classification +
			'}';
		}
	}

	/*********************** Builder Implementation of TaxonomyValue  ***********************/
	class TaxonomyValueBuilderImpl implements TaxonomyValue.TaxonomyValueBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder name;
		protected List<TaxonomyClassification.TaxonomyClassificationBuilder> classification = new ArrayList<>();
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public FieldWithMetaString.FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("classification")
		@RuneAttribute("classification")
		public List<? extends TaxonomyClassification.TaxonomyClassificationBuilder> getClassification() {
			return classification;
		}
		
		@Override
		public TaxonomyClassification.TaxonomyClassificationBuilder getOrCreateClassification(int _index) {
		
			if (classification==null) {
				this.classification = new ArrayList<>();
			}
			TaxonomyClassification.TaxonomyClassificationBuilder result;
			return getIndex(classification, _index, () -> {
						TaxonomyClassification.TaxonomyClassificationBuilder newClassification = TaxonomyClassification.builder();
						return newClassification;
					});
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public TaxonomyValue.TaxonomyValueBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public TaxonomyValue.TaxonomyValueBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("classification")
		@RuneAttribute("classification")
		public TaxonomyValue.TaxonomyValueBuilder addClassification(TaxonomyClassification _classification) {
			if (_classification != null) {
				this.classification.add(_classification.toBuilder());
			}
			return this;
		}
		
		@Override
		public TaxonomyValue.TaxonomyValueBuilder addClassification(TaxonomyClassification _classification, int _idx) {
			getIndex(this.classification, _idx, () -> _classification.toBuilder());
			return this;
		}
		
		@Override 
		public TaxonomyValue.TaxonomyValueBuilder addClassification(List<? extends TaxonomyClassification> classifications) {
			if (classifications != null) {
				for (final TaxonomyClassification toAdd : classifications) {
					this.classification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("classification")
		public TaxonomyValue.TaxonomyValueBuilder setClassification(List<? extends TaxonomyClassification> classifications) {
			if (classifications == null) {
				this.classification = new ArrayList<>();
			} else {
				this.classification = classifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TaxonomyValue build() {
			return new TaxonomyValue.TaxonomyValueImpl(this);
		}
		
		@Override
		public TaxonomyValue.TaxonomyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxonomyValue.TaxonomyValueBuilder prune() {
			if (name!=null && !name.prune().hasData()) name = null;
			classification = classification.stream().filter(b->b!=null).<TaxonomyClassification.TaxonomyClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getClassification()!=null && getClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxonomyValue.TaxonomyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaxonomyValue.TaxonomyValueBuilder o = (TaxonomyValue.TaxonomyValueBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getClassification(), o.getClassification(), this::getOrCreateClassification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxonomyValue _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxonomyValueBuilder {" +
				"name=" + this.name + ", " +
				"classification=" + this.classification +
			'}';
		}
	}
}
