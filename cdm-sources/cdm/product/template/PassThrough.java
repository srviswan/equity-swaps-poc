package cdm.product.template;

import cdm.product.template.PassThrough;
import cdm.product.template.PassThrough.PassThroughBuilder;
import cdm.product.template.PassThrough.PassThroughBuilderImpl;
import cdm.product.template.PassThrough.PassThroughImpl;
import cdm.product.template.PassThroughItem;
import cdm.product.template.PassThroughItem.PassThroughItemBuilder;
import cdm.product.template.meta.PassThroughMeta;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Type which contains pass through payments.
 * @version 6.0.0
 */
@RosettaDataType(value="PassThrough", builder=PassThrough.PassThroughBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PassThrough", model="Just another Rosetta model", builder=PassThrough.PassThroughBuilderImpl.class, version="6.0.0")
public interface PassThrough extends RosettaModelObject {

	PassThroughMeta metaData = new PassThroughMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * One to many pass through payment items.
	 */
	List<? extends PassThroughItem> getPassThroughItem();

	/*********************** Build Methods  ***********************/
	PassThrough build();
	
	PassThrough.PassThroughBuilder toBuilder();
	
	static PassThrough.PassThroughBuilder builder() {
		return new PassThrough.PassThroughBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PassThrough> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PassThrough> getType() {
		return PassThrough.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("passThroughItem"), processor, PassThroughItem.class, getPassThroughItem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PassThroughBuilder extends PassThrough, RosettaModelObjectBuilder {
		PassThroughItem.PassThroughItemBuilder getOrCreatePassThroughItem(int _index);
		@Override
		List<? extends PassThroughItem.PassThroughItemBuilder> getPassThroughItem();
		PassThrough.PassThroughBuilder addPassThroughItem(PassThroughItem passThroughItem);
		PassThrough.PassThroughBuilder addPassThroughItem(PassThroughItem passThroughItem, int _idx);
		PassThrough.PassThroughBuilder addPassThroughItem(List<? extends PassThroughItem> passThroughItem);
		PassThrough.PassThroughBuilder setPassThroughItem(List<? extends PassThroughItem> passThroughItem);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("passThroughItem"), processor, PassThroughItem.PassThroughItemBuilder.class, getPassThroughItem());
		}
		

		PassThrough.PassThroughBuilder prune();
	}

	/*********************** Immutable Implementation of PassThrough  ***********************/
	class PassThroughImpl implements PassThrough {
		private final List<? extends PassThroughItem> passThroughItem;
		
		protected PassThroughImpl(PassThrough.PassThroughBuilder builder) {
			this.passThroughItem = ofNullable(builder.getPassThroughItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("passThroughItem")
		@RuneAttribute("passThroughItem")
		public List<? extends PassThroughItem> getPassThroughItem() {
			return passThroughItem;
		}
		
		@Override
		public PassThrough build() {
			return this;
		}
		
		@Override
		public PassThrough.PassThroughBuilder toBuilder() {
			PassThrough.PassThroughBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PassThrough.PassThroughBuilder builder) {
			ofNullable(getPassThroughItem()).ifPresent(builder::setPassThroughItem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThrough _that = getType().cast(o);
		
			if (!ListEquals.listEquals(passThroughItem, _that.getPassThroughItem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (passThroughItem != null ? passThroughItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThrough {" +
				"passThroughItem=" + this.passThroughItem +
			'}';
		}
	}

	/*********************** Builder Implementation of PassThrough  ***********************/
	class PassThroughBuilderImpl implements PassThrough.PassThroughBuilder {
	
		protected List<PassThroughItem.PassThroughItemBuilder> passThroughItem = new ArrayList<>();
		
		@Override
		@RosettaAttribute("passThroughItem")
		@RuneAttribute("passThroughItem")
		public List<? extends PassThroughItem.PassThroughItemBuilder> getPassThroughItem() {
			return passThroughItem;
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder getOrCreatePassThroughItem(int _index) {
		
			if (passThroughItem==null) {
				this.passThroughItem = new ArrayList<>();
			}
			PassThroughItem.PassThroughItemBuilder result;
			return getIndex(passThroughItem, _index, () -> {
						PassThroughItem.PassThroughItemBuilder newPassThroughItem = PassThroughItem.builder();
						return newPassThroughItem;
					});
		}
		
		@Override
		@RosettaAttribute("passThroughItem")
		@RuneAttribute("passThroughItem")
		public PassThrough.PassThroughBuilder addPassThroughItem(PassThroughItem _passThroughItem) {
			if (_passThroughItem != null) {
				this.passThroughItem.add(_passThroughItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public PassThrough.PassThroughBuilder addPassThroughItem(PassThroughItem _passThroughItem, int _idx) {
			getIndex(this.passThroughItem, _idx, () -> _passThroughItem.toBuilder());
			return this;
		}
		
		@Override 
		public PassThrough.PassThroughBuilder addPassThroughItem(List<? extends PassThroughItem> passThroughItems) {
			if (passThroughItems != null) {
				for (final PassThroughItem toAdd : passThroughItems) {
					this.passThroughItem.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("passThroughItem")
		public PassThrough.PassThroughBuilder setPassThroughItem(List<? extends PassThroughItem> passThroughItems) {
			if (passThroughItems == null) {
				this.passThroughItem = new ArrayList<>();
			} else {
				this.passThroughItem = passThroughItems.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PassThrough build() {
			return new PassThrough.PassThroughImpl(this);
		}
		
		@Override
		public PassThrough.PassThroughBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThrough.PassThroughBuilder prune() {
			passThroughItem = passThroughItem.stream().filter(b->b!=null).<PassThroughItem.PassThroughItemBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPassThroughItem()!=null && getPassThroughItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThrough.PassThroughBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PassThrough.PassThroughBuilder o = (PassThrough.PassThroughBuilder) other;
			
			merger.mergeRosetta(getPassThroughItem(), o.getPassThroughItem(), this::getOrCreatePassThroughItem);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThrough _that = getType().cast(o);
		
			if (!ListEquals.listEquals(passThroughItem, _that.getPassThroughItem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (passThroughItem != null ? passThroughItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughBuilder {" +
				"passThroughItem=" + this.passThroughItem +
			'}';
		}
	}
}
