package cdm.product.collateral;

import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.AnyCriteria.AnyCriteriaBuilder;
import cdm.product.collateral.AnyCriteria.AnyCriteriaBuilderImpl;
import cdm.product.collateral.AnyCriteria.AnyCriteriaImpl;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.meta.AnyCriteriaMeta;
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
 * Used to combine two or more Collateral Criteria using OR logic.
 * @version 6.0.0
 */
@RosettaDataType(value="AnyCriteria", builder=AnyCriteria.AnyCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AnyCriteria", model="Just another Rosetta model", builder=AnyCriteria.AnyCriteriaBuilderImpl.class, version="6.0.0")
public interface AnyCriteria extends RosettaModelObject {

	AnyCriteriaMeta metaData = new AnyCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends CollateralCriteria> getAnyCriteria();

	/*********************** Build Methods  ***********************/
	AnyCriteria build();
	
	AnyCriteria.AnyCriteriaBuilder toBuilder();
	
	static AnyCriteria.AnyCriteriaBuilder builder() {
		return new AnyCriteria.AnyCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnyCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnyCriteria> getType() {
		return AnyCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("anyCriteria"), processor, CollateralCriteria.class, getAnyCriteria());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnyCriteriaBuilder extends AnyCriteria, RosettaModelObjectBuilder {
		CollateralCriteria.CollateralCriteriaBuilder getOrCreateAnyCriteria(int _index);
		@Override
		List<? extends CollateralCriteria.CollateralCriteriaBuilder> getAnyCriteria();
		AnyCriteria.AnyCriteriaBuilder addAnyCriteria(CollateralCriteria anyCriteria);
		AnyCriteria.AnyCriteriaBuilder addAnyCriteria(CollateralCriteria anyCriteria, int _idx);
		AnyCriteria.AnyCriteriaBuilder addAnyCriteria(List<? extends CollateralCriteria> anyCriteria);
		AnyCriteria.AnyCriteriaBuilder setAnyCriteria(List<? extends CollateralCriteria> anyCriteria);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("anyCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getAnyCriteria());
		}
		

		AnyCriteria.AnyCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of AnyCriteria  ***********************/
	class AnyCriteriaImpl implements AnyCriteria {
		private final List<? extends CollateralCriteria> anyCriteria;
		
		protected AnyCriteriaImpl(AnyCriteria.AnyCriteriaBuilder builder) {
			this.anyCriteria = ofNullable(builder.getAnyCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("anyCriteria")
		@RuneAttribute("anyCriteria")
		public List<? extends CollateralCriteria> getAnyCriteria() {
			return anyCriteria;
		}
		
		@Override
		public AnyCriteria build() {
			return this;
		}
		
		@Override
		public AnyCriteria.AnyCriteriaBuilder toBuilder() {
			AnyCriteria.AnyCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnyCriteria.AnyCriteriaBuilder builder) {
			ofNullable(getAnyCriteria()).ifPresent(builder::setAnyCriteria);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnyCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(anyCriteria, _that.getAnyCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyCriteria != null ? anyCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnyCriteria {" +
				"anyCriteria=" + this.anyCriteria +
			'}';
		}
	}

	/*********************** Builder Implementation of AnyCriteria  ***********************/
	class AnyCriteriaBuilderImpl implements AnyCriteria.AnyCriteriaBuilder {
	
		protected List<CollateralCriteria.CollateralCriteriaBuilder> anyCriteria = new ArrayList<>();
		
		@Override
		@RosettaAttribute("anyCriteria")
		@RuneAttribute("anyCriteria")
		public List<? extends CollateralCriteria.CollateralCriteriaBuilder> getAnyCriteria() {
			return anyCriteria;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder getOrCreateAnyCriteria(int _index) {
		
			if (anyCriteria==null) {
				this.anyCriteria = new ArrayList<>();
			}
			CollateralCriteria.CollateralCriteriaBuilder result;
			return getIndex(anyCriteria, _index, () -> {
						CollateralCriteria.CollateralCriteriaBuilder newAnyCriteria = CollateralCriteria.builder();
						return newAnyCriteria;
					});
		}
		
		@Override
		@RosettaAttribute("anyCriteria")
		@RuneAttribute("anyCriteria")
		public AnyCriteria.AnyCriteriaBuilder addAnyCriteria(CollateralCriteria _anyCriteria) {
			if (_anyCriteria != null) {
				this.anyCriteria.add(_anyCriteria.toBuilder());
			}
			return this;
		}
		
		@Override
		public AnyCriteria.AnyCriteriaBuilder addAnyCriteria(CollateralCriteria _anyCriteria, int _idx) {
			getIndex(this.anyCriteria, _idx, () -> _anyCriteria.toBuilder());
			return this;
		}
		
		@Override 
		public AnyCriteria.AnyCriteriaBuilder addAnyCriteria(List<? extends CollateralCriteria> anyCriterias) {
			if (anyCriterias != null) {
				for (final CollateralCriteria toAdd : anyCriterias) {
					this.anyCriteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("anyCriteria")
		public AnyCriteria.AnyCriteriaBuilder setAnyCriteria(List<? extends CollateralCriteria> anyCriterias) {
			if (anyCriterias == null) {
				this.anyCriteria = new ArrayList<>();
			} else {
				this.anyCriteria = anyCriterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AnyCriteria build() {
			return new AnyCriteria.AnyCriteriaImpl(this);
		}
		
		@Override
		public AnyCriteria.AnyCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnyCriteria.AnyCriteriaBuilder prune() {
			anyCriteria = anyCriteria.stream().filter(b->b!=null).<CollateralCriteria.CollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyCriteria()!=null && getAnyCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnyCriteria.AnyCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnyCriteria.AnyCriteriaBuilder o = (AnyCriteria.AnyCriteriaBuilder) other;
			
			merger.mergeRosetta(getAnyCriteria(), o.getAnyCriteria(), this::getOrCreateAnyCriteria);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnyCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(anyCriteria, _that.getAnyCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyCriteria != null ? anyCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnyCriteriaBuilder {" +
				"anyCriteria=" + this.anyCriteria +
			'}';
		}
	}
}
