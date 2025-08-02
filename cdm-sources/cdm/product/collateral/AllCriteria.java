package cdm.product.collateral;

import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AllCriteria.AllCriteriaBuilder;
import cdm.product.collateral.AllCriteria.AllCriteriaBuilderImpl;
import cdm.product.collateral.AllCriteria.AllCriteriaImpl;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.meta.AllCriteriaMeta;
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
 * Used to combine two or more Collateral Criteria using AND logic.
 * @version 6.0.0
 */
@RosettaDataType(value="AllCriteria", builder=AllCriteria.AllCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AllCriteria", model="Just another Rosetta model", builder=AllCriteria.AllCriteriaBuilderImpl.class, version="6.0.0")
public interface AllCriteria extends RosettaModelObject {

	AllCriteriaMeta metaData = new AllCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends CollateralCriteria> getAllCriteria();

	/*********************** Build Methods  ***********************/
	AllCriteria build();
	
	AllCriteria.AllCriteriaBuilder toBuilder();
	
	static AllCriteria.AllCriteriaBuilder builder() {
		return new AllCriteria.AllCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AllCriteria> getType() {
		return AllCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allCriteria"), processor, CollateralCriteria.class, getAllCriteria());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllCriteriaBuilder extends AllCriteria, RosettaModelObjectBuilder {
		CollateralCriteria.CollateralCriteriaBuilder getOrCreateAllCriteria(int _index);
		@Override
		List<? extends CollateralCriteria.CollateralCriteriaBuilder> getAllCriteria();
		AllCriteria.AllCriteriaBuilder addAllCriteria(CollateralCriteria allCriteria);
		AllCriteria.AllCriteriaBuilder addAllCriteria(CollateralCriteria allCriteria, int _idx);
		AllCriteria.AllCriteriaBuilder addAllCriteria(List<? extends CollateralCriteria> allCriteria);
		AllCriteria.AllCriteriaBuilder setAllCriteria(List<? extends CollateralCriteria> allCriteria);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getAllCriteria());
		}
		

		AllCriteria.AllCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of AllCriteria  ***********************/
	class AllCriteriaImpl implements AllCriteria {
		private final List<? extends CollateralCriteria> allCriteria;
		
		protected AllCriteriaImpl(AllCriteria.AllCriteriaBuilder builder) {
			this.allCriteria = ofNullable(builder.getAllCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allCriteria")
		@RuneAttribute("allCriteria")
		public List<? extends CollateralCriteria> getAllCriteria() {
			return allCriteria;
		}
		
		@Override
		public AllCriteria build() {
			return this;
		}
		
		@Override
		public AllCriteria.AllCriteriaBuilder toBuilder() {
			AllCriteria.AllCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllCriteria.AllCriteriaBuilder builder) {
			ofNullable(getAllCriteria()).ifPresent(builder::setAllCriteria);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allCriteria, _that.getAllCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allCriteria != null ? allCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllCriteria {" +
				"allCriteria=" + this.allCriteria +
			'}';
		}
	}

	/*********************** Builder Implementation of AllCriteria  ***********************/
	class AllCriteriaBuilderImpl implements AllCriteria.AllCriteriaBuilder {
	
		protected List<CollateralCriteria.CollateralCriteriaBuilder> allCriteria = new ArrayList<>();
		
		@Override
		@RosettaAttribute("allCriteria")
		@RuneAttribute("allCriteria")
		public List<? extends CollateralCriteria.CollateralCriteriaBuilder> getAllCriteria() {
			return allCriteria;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder getOrCreateAllCriteria(int _index) {
		
			if (allCriteria==null) {
				this.allCriteria = new ArrayList<>();
			}
			CollateralCriteria.CollateralCriteriaBuilder result;
			return getIndex(allCriteria, _index, () -> {
						CollateralCriteria.CollateralCriteriaBuilder newAllCriteria = CollateralCriteria.builder();
						return newAllCriteria;
					});
		}
		
		@Override
		@RosettaAttribute("allCriteria")
		@RuneAttribute("allCriteria")
		public AllCriteria.AllCriteriaBuilder addAllCriteria(CollateralCriteria _allCriteria) {
			if (_allCriteria != null) {
				this.allCriteria.add(_allCriteria.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllCriteria.AllCriteriaBuilder addAllCriteria(CollateralCriteria _allCriteria, int _idx) {
			getIndex(this.allCriteria, _idx, () -> _allCriteria.toBuilder());
			return this;
		}
		
		@Override 
		public AllCriteria.AllCriteriaBuilder addAllCriteria(List<? extends CollateralCriteria> allCriterias) {
			if (allCriterias != null) {
				for (final CollateralCriteria toAdd : allCriterias) {
					this.allCriteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("allCriteria")
		public AllCriteria.AllCriteriaBuilder setAllCriteria(List<? extends CollateralCriteria> allCriterias) {
			if (allCriterias == null) {
				this.allCriteria = new ArrayList<>();
			} else {
				this.allCriteria = allCriterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AllCriteria build() {
			return new AllCriteria.AllCriteriaImpl(this);
		}
		
		@Override
		public AllCriteria.AllCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllCriteria.AllCriteriaBuilder prune() {
			allCriteria = allCriteria.stream().filter(b->b!=null).<CollateralCriteria.CollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllCriteria()!=null && getAllCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllCriteria.AllCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllCriteria.AllCriteriaBuilder o = (AllCriteria.AllCriteriaBuilder) other;
			
			merger.mergeRosetta(getAllCriteria(), o.getAllCriteria(), this::getOrCreateAllCriteria);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllCriteria _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allCriteria, _that.getAllCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allCriteria != null ? allCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllCriteriaBuilder {" +
				"allCriteria=" + this.allCriteria +
			'}';
		}
	}
}
