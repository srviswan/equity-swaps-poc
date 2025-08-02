package cdm.product.collateral;

import cdm.product.collateral.ListingSector;
import cdm.product.collateral.ListingSector.ListingSectorBuilder;
import cdm.product.collateral.ListingSector.ListingSectorBuilderImpl;
import cdm.product.collateral.ListingSector.ListingSectorImpl;
import cdm.product.collateral.meta.ListingSectorMeta;
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
 * Specifies a filter based on an industry sector.
 * @version 6.0.0
 */
@RosettaDataType(value="ListingSector", builder=ListingSector.ListingSectorBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ListingSector", model="Just another Rosetta model", builder=ListingSector.ListingSectorBuilderImpl.class, version="6.0.0")
public interface ListingSector extends RosettaModelObject {

	ListingSectorMeta metaData = new ListingSectorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter based on an industry sector defined under a system for classifying industry types such as Global Industry Classification Standard (GICS) and North American Industry Classification System (NAICS)
	 */
	List<? extends FieldWithMetaString> getSector();

	/*********************** Build Methods  ***********************/
	ListingSector build();
	
	ListingSector.ListingSectorBuilder toBuilder();
	
	static ListingSector.ListingSectorBuilder builder() {
		return new ListingSector.ListingSectorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ListingSector> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ListingSector> getType() {
		return ListingSector.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sector"), processor, FieldWithMetaString.class, getSector());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ListingSectorBuilder extends ListingSector, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSector(int _index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getSector();
		ListingSector.ListingSectorBuilder addSector(FieldWithMetaString sector);
		ListingSector.ListingSectorBuilder addSector(FieldWithMetaString sector, int _idx);
		ListingSector.ListingSectorBuilder addSectorValue(String sector);
		ListingSector.ListingSectorBuilder addSectorValue(String sector, int _idx);
		ListingSector.ListingSectorBuilder addSector(List<? extends FieldWithMetaString> sector);
		ListingSector.ListingSectorBuilder setSector(List<? extends FieldWithMetaString> sector);
		ListingSector.ListingSectorBuilder addSectorValue(List<? extends String> sector);
		ListingSector.ListingSectorBuilder setSectorValue(List<? extends String> sector);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sector"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getSector());
		}
		

		ListingSector.ListingSectorBuilder prune();
	}

	/*********************** Immutable Implementation of ListingSector  ***********************/
	class ListingSectorImpl implements ListingSector {
		private final List<? extends FieldWithMetaString> sector;
		
		protected ListingSectorImpl(ListingSector.ListingSectorBuilder builder) {
			this.sector = ofNullable(builder.getSector()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sector")
		@RuneAttribute("sector")
		public List<? extends FieldWithMetaString> getSector() {
			return sector;
		}
		
		@Override
		public ListingSector build() {
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder toBuilder() {
			ListingSector.ListingSectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ListingSector.ListingSectorBuilder builder) {
			ofNullable(getSector()).ifPresent(builder::setSector);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingSector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sector, _that.getSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingSector {" +
				"sector=" + this.sector +
			'}';
		}
	}

	/*********************** Builder Implementation of ListingSector  ***********************/
	class ListingSectorBuilderImpl implements ListingSector.ListingSectorBuilder {
	
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> sector = new ArrayList<>();
		
		@Override
		@RosettaAttribute("sector")
		@RuneAttribute("sector")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getSector() {
			return sector;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSector(int _index) {
		
			if (sector==null) {
				this.sector = new ArrayList<>();
			}
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			return getIndex(sector, _index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newSector = FieldWithMetaString.builder();
						return newSector;
					});
		}
		
		@Override
		@RosettaAttribute("sector")
		@RuneAttribute("sector")
		public ListingSector.ListingSectorBuilder addSector(FieldWithMetaString _sector) {
			if (_sector != null) {
				this.sector.add(_sector.toBuilder());
			}
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder addSector(FieldWithMetaString _sector, int _idx) {
			getIndex(this.sector, _idx, () -> _sector.toBuilder());
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder addSectorValue(String _sector) {
			this.getOrCreateSector(-1).setValue(_sector);
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder addSectorValue(String _sector, int _idx) {
			this.getOrCreateSector(_idx).setValue(_sector);
			return this;
		}
		
		@Override 
		public ListingSector.ListingSectorBuilder addSector(List<? extends FieldWithMetaString> sectors) {
			if (sectors != null) {
				for (final FieldWithMetaString toAdd : sectors) {
					this.sector.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("sector")
		public ListingSector.ListingSectorBuilder setSector(List<? extends FieldWithMetaString> sectors) {
			if (sectors == null) {
				this.sector = new ArrayList<>();
			} else {
				this.sector = sectors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder addSectorValue(List<? extends String> sectors) {
			if (sectors != null) {
				for (final String toAdd : sectors) {
					this.addSectorValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder setSectorValue(List<? extends String> sectors) {
			this.sector.clear();
			if (sectors != null) {
				sectors.forEach(this::addSectorValue);
			}
			return this;
		}
		
		@Override
		public ListingSector build() {
			return new ListingSector.ListingSectorImpl(this);
		}
		
		@Override
		public ListingSector.ListingSectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingSector.ListingSectorBuilder prune() {
			sector = sector.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSector()!=null && !getSector().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingSector.ListingSectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ListingSector.ListingSectorBuilder o = (ListingSector.ListingSectorBuilder) other;
			
			merger.mergeRosetta(getSector(), o.getSector(), this::getOrCreateSector);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingSector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(sector, _that.getSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingSectorBuilder {" +
				"sector=" + this.sector +
			'}';
		}
	}
}
