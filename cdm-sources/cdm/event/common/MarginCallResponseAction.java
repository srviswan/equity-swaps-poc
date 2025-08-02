package cdm.event.common;

import cdm.event.common.CollateralPosition;
import cdm.event.common.CollateralPosition.CollateralPositionBuilder;
import cdm.event.common.MarginCallActionEnum;
import cdm.event.common.MarginCallResponseAction;
import cdm.event.common.MarginCallResponseAction.MarginCallResponseActionBuilder;
import cdm.event.common.MarginCallResponseAction.MarginCallResponseActionBuilderImpl;
import cdm.event.common.MarginCallResponseAction.MarginCallResponseActionImpl;
import cdm.event.common.meta.MarginCallResponseActionMeta;
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
 * Specifies the margin call action details, including collateral to be moved and its direction.
 * @version 6.0.0
 */
@RosettaDataType(value="MarginCallResponseAction", builder=MarginCallResponseAction.MarginCallResponseActionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MarginCallResponseAction", model="Just another Rosetta model", builder=MarginCallResponseAction.MarginCallResponseActionBuilderImpl.class, version="6.0.0")
public interface MarginCallResponseAction extends RosettaModelObject {

	MarginCallResponseActionMeta metaData = new MarginCallResponseActionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the collateral to be moved and its direction.
	 */
	List<? extends CollateralPosition> getCollateralPositionComponent();
	/**
	 * Specifies the margin call action details, specified as either Delivery or Return.
	 */
	MarginCallActionEnum getMarginCallAction();

	/*********************** Build Methods  ***********************/
	MarginCallResponseAction build();
	
	MarginCallResponseAction.MarginCallResponseActionBuilder toBuilder();
	
	static MarginCallResponseAction.MarginCallResponseActionBuilder builder() {
		return new MarginCallResponseAction.MarginCallResponseActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginCallResponseAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginCallResponseAction> getType() {
		return MarginCallResponseAction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralPositionComponent"), processor, CollateralPosition.class, getCollateralPositionComponent());
		processor.processBasic(path.newSubPath("marginCallAction"), MarginCallActionEnum.class, getMarginCallAction(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginCallResponseActionBuilder extends MarginCallResponseAction, RosettaModelObjectBuilder {
		CollateralPosition.CollateralPositionBuilder getOrCreateCollateralPositionComponent(int _index);
		@Override
		List<? extends CollateralPosition.CollateralPositionBuilder> getCollateralPositionComponent();
		MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(CollateralPosition collateralPositionComponent);
		MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(CollateralPosition collateralPositionComponent, int _idx);
		MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(List<? extends CollateralPosition> collateralPositionComponent);
		MarginCallResponseAction.MarginCallResponseActionBuilder setCollateralPositionComponent(List<? extends CollateralPosition> collateralPositionComponent);
		MarginCallResponseAction.MarginCallResponseActionBuilder setMarginCallAction(MarginCallActionEnum marginCallAction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralPositionComponent"), processor, CollateralPosition.CollateralPositionBuilder.class, getCollateralPositionComponent());
			processor.processBasic(path.newSubPath("marginCallAction"), MarginCallActionEnum.class, getMarginCallAction(), this);
		}
		

		MarginCallResponseAction.MarginCallResponseActionBuilder prune();
	}

	/*********************** Immutable Implementation of MarginCallResponseAction  ***********************/
	class MarginCallResponseActionImpl implements MarginCallResponseAction {
		private final List<? extends CollateralPosition> collateralPositionComponent;
		private final MarginCallActionEnum marginCallAction;
		
		protected MarginCallResponseActionImpl(MarginCallResponseAction.MarginCallResponseActionBuilder builder) {
			this.collateralPositionComponent = ofNullable(builder.getCollateralPositionComponent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.marginCallAction = builder.getMarginCallAction();
		}
		
		@Override
		@RosettaAttribute("collateralPositionComponent")
		@RuneAttribute("collateralPositionComponent")
		public List<? extends CollateralPosition> getCollateralPositionComponent() {
			return collateralPositionComponent;
		}
		
		@Override
		@RosettaAttribute("marginCallAction")
		@RuneAttribute("marginCallAction")
		public MarginCallActionEnum getMarginCallAction() {
			return marginCallAction;
		}
		
		@Override
		public MarginCallResponseAction build() {
			return this;
		}
		
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder toBuilder() {
			MarginCallResponseAction.MarginCallResponseActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginCallResponseAction.MarginCallResponseActionBuilder builder) {
			ofNullable(getCollateralPositionComponent()).ifPresent(builder::setCollateralPositionComponent);
			ofNullable(getMarginCallAction()).ifPresent(builder::setMarginCallAction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCallResponseAction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(collateralPositionComponent, _that.getCollateralPositionComponent())) return false;
			if (!Objects.equals(marginCallAction, _that.getMarginCallAction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralPositionComponent != null ? collateralPositionComponent.hashCode() : 0);
			_result = 31 * _result + (marginCallAction != null ? marginCallAction.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallResponseAction {" +
				"collateralPositionComponent=" + this.collateralPositionComponent + ", " +
				"marginCallAction=" + this.marginCallAction +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginCallResponseAction  ***********************/
	class MarginCallResponseActionBuilderImpl implements MarginCallResponseAction.MarginCallResponseActionBuilder {
	
		protected List<CollateralPosition.CollateralPositionBuilder> collateralPositionComponent = new ArrayList<>();
		protected MarginCallActionEnum marginCallAction;
		
		@Override
		@RosettaAttribute("collateralPositionComponent")
		@RuneAttribute("collateralPositionComponent")
		public List<? extends CollateralPosition.CollateralPositionBuilder> getCollateralPositionComponent() {
			return collateralPositionComponent;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder getOrCreateCollateralPositionComponent(int _index) {
		
			if (collateralPositionComponent==null) {
				this.collateralPositionComponent = new ArrayList<>();
			}
			CollateralPosition.CollateralPositionBuilder result;
			return getIndex(collateralPositionComponent, _index, () -> {
						CollateralPosition.CollateralPositionBuilder newCollateralPositionComponent = CollateralPosition.builder();
						return newCollateralPositionComponent;
					});
		}
		
		@Override
		@RosettaAttribute("marginCallAction")
		@RuneAttribute("marginCallAction")
		public MarginCallActionEnum getMarginCallAction() {
			return marginCallAction;
		}
		
		@Override
		@RosettaAttribute("collateralPositionComponent")
		@RuneAttribute("collateralPositionComponent")
		public MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(CollateralPosition _collateralPositionComponent) {
			if (_collateralPositionComponent != null) {
				this.collateralPositionComponent.add(_collateralPositionComponent.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(CollateralPosition _collateralPositionComponent, int _idx) {
			getIndex(this.collateralPositionComponent, _idx, () -> _collateralPositionComponent.toBuilder());
			return this;
		}
		
		@Override 
		public MarginCallResponseAction.MarginCallResponseActionBuilder addCollateralPositionComponent(List<? extends CollateralPosition> collateralPositionComponents) {
			if (collateralPositionComponents != null) {
				for (final CollateralPosition toAdd : collateralPositionComponents) {
					this.collateralPositionComponent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("collateralPositionComponent")
		public MarginCallResponseAction.MarginCallResponseActionBuilder setCollateralPositionComponent(List<? extends CollateralPosition> collateralPositionComponents) {
			if (collateralPositionComponents == null) {
				this.collateralPositionComponent = new ArrayList<>();
			} else {
				this.collateralPositionComponent = collateralPositionComponents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("marginCallAction")
		@RuneAttribute("marginCallAction")
		public MarginCallResponseAction.MarginCallResponseActionBuilder setMarginCallAction(MarginCallActionEnum _marginCallAction) {
			this.marginCallAction = _marginCallAction == null ? null : _marginCallAction;
			return this;
		}
		
		@Override
		public MarginCallResponseAction build() {
			return new MarginCallResponseAction.MarginCallResponseActionImpl(this);
		}
		
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder prune() {
			collateralPositionComponent = collateralPositionComponent.stream().filter(b->b!=null).<CollateralPosition.CollateralPositionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralPositionComponent()!=null && getCollateralPositionComponent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarginCallAction()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginCallResponseAction.MarginCallResponseActionBuilder o = (MarginCallResponseAction.MarginCallResponseActionBuilder) other;
			
			merger.mergeRosetta(getCollateralPositionComponent(), o.getCollateralPositionComponent(), this::getOrCreateCollateralPositionComponent);
			
			merger.mergeBasic(getMarginCallAction(), o.getMarginCallAction(), this::setMarginCallAction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCallResponseAction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(collateralPositionComponent, _that.getCollateralPositionComponent())) return false;
			if (!Objects.equals(marginCallAction, _that.getMarginCallAction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralPositionComponent != null ? collateralPositionComponent.hashCode() : 0);
			_result = 31 * _result + (marginCallAction != null ? marginCallAction.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallResponseActionBuilder {" +
				"collateralPositionComponent=" + this.collateralPositionComponent + ", " +
				"marginCallAction=" + this.marginCallAction +
			'}';
		}
	}
}
