package cdm.event.common;

import cdm.event.common.Valuation;
import cdm.event.common.Valuation.ValuationBuilder;
import cdm.event.common.ValuationInstruction;
import cdm.event.common.ValuationInstruction.ValuationInstructionBuilder;
import cdm.event.common.ValuationInstruction.ValuationInstructionBuilderImpl;
import cdm.event.common.ValuationInstruction.ValuationInstructionImpl;
import cdm.event.common.meta.ValuationInstructionMeta;
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
 * Specifies inputs needed to process a valuation.
 * @version 6.0.0
 */
@RosettaDataType(value="ValuationInstruction", builder=ValuationInstruction.ValuationInstructionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ValuationInstruction", model="Just another Rosetta model", builder=ValuationInstruction.ValuationInstructionBuilderImpl.class, version="6.0.0")
public interface ValuationInstruction extends RosettaModelObject {

	ValuationInstructionMeta metaData = new ValuationInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Contains all information related to a valuation.
	 */
	List<? extends Valuation> getValuation();
	/**
	 * Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).
	 */
	Boolean getReplace();

	/*********************** Build Methods  ***********************/
	ValuationInstruction build();
	
	ValuationInstruction.ValuationInstructionBuilder toBuilder();
	
	static ValuationInstruction.ValuationInstructionBuilder builder() {
		return new ValuationInstruction.ValuationInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationInstruction> getType() {
		return ValuationInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuation"), processor, Valuation.class, getValuation());
		processor.processBasic(path.newSubPath("replace"), Boolean.class, getReplace(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationInstructionBuilder extends ValuationInstruction, RosettaModelObjectBuilder {
		Valuation.ValuationBuilder getOrCreateValuation(int _index);
		@Override
		List<? extends Valuation.ValuationBuilder> getValuation();
		ValuationInstruction.ValuationInstructionBuilder addValuation(Valuation valuation);
		ValuationInstruction.ValuationInstructionBuilder addValuation(Valuation valuation, int _idx);
		ValuationInstruction.ValuationInstructionBuilder addValuation(List<? extends Valuation> valuation);
		ValuationInstruction.ValuationInstructionBuilder setValuation(List<? extends Valuation> valuation);
		ValuationInstruction.ValuationInstructionBuilder setReplace(Boolean replace);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuation"), processor, Valuation.ValuationBuilder.class, getValuation());
			processor.processBasic(path.newSubPath("replace"), Boolean.class, getReplace(), this);
		}
		

		ValuationInstruction.ValuationInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationInstruction  ***********************/
	class ValuationInstructionImpl implements ValuationInstruction {
		private final List<? extends Valuation> valuation;
		private final Boolean replace;
		
		protected ValuationInstructionImpl(ValuationInstruction.ValuationInstructionBuilder builder) {
			this.valuation = ofNullable(builder.getValuation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.replace = builder.getReplace();
		}
		
		@Override
		@RosettaAttribute("valuation")
		@RuneAttribute("valuation")
		public List<? extends Valuation> getValuation() {
			return valuation;
		}
		
		@Override
		@RosettaAttribute("replace")
		@RuneAttribute("replace")
		public Boolean getReplace() {
			return replace;
		}
		
		@Override
		public ValuationInstruction build() {
			return this;
		}
		
		@Override
		public ValuationInstruction.ValuationInstructionBuilder toBuilder() {
			ValuationInstruction.ValuationInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationInstruction.ValuationInstructionBuilder builder) {
			ofNullable(getValuation()).ifPresent(builder::setValuation);
			ofNullable(getReplace()).ifPresent(builder::setReplace);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(valuation, _that.getValuation())) return false;
			if (!Objects.equals(replace, _that.getReplace())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			_result = 31 * _result + (replace != null ? replace.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationInstruction {" +
				"valuation=" + this.valuation + ", " +
				"replace=" + this.replace +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationInstruction  ***********************/
	class ValuationInstructionBuilderImpl implements ValuationInstruction.ValuationInstructionBuilder {
	
		protected List<Valuation.ValuationBuilder> valuation = new ArrayList<>();
		protected Boolean replace;
		
		@Override
		@RosettaAttribute("valuation")
		@RuneAttribute("valuation")
		public List<? extends Valuation.ValuationBuilder> getValuation() {
			return valuation;
		}
		
		@Override
		public Valuation.ValuationBuilder getOrCreateValuation(int _index) {
		
			if (valuation==null) {
				this.valuation = new ArrayList<>();
			}
			Valuation.ValuationBuilder result;
			return getIndex(valuation, _index, () -> {
						Valuation.ValuationBuilder newValuation = Valuation.builder();
						return newValuation;
					});
		}
		
		@Override
		@RosettaAttribute("replace")
		@RuneAttribute("replace")
		public Boolean getReplace() {
			return replace;
		}
		
		@Override
		@RosettaAttribute("valuation")
		@RuneAttribute("valuation")
		public ValuationInstruction.ValuationInstructionBuilder addValuation(Valuation _valuation) {
			if (_valuation != null) {
				this.valuation.add(_valuation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationInstruction.ValuationInstructionBuilder addValuation(Valuation _valuation, int _idx) {
			getIndex(this.valuation, _idx, () -> _valuation.toBuilder());
			return this;
		}
		
		@Override 
		public ValuationInstruction.ValuationInstructionBuilder addValuation(List<? extends Valuation> valuations) {
			if (valuations != null) {
				for (final Valuation toAdd : valuations) {
					this.valuation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("valuation")
		public ValuationInstruction.ValuationInstructionBuilder setValuation(List<? extends Valuation> valuations) {
			if (valuations == null) {
				this.valuation = new ArrayList<>();
			} else {
				this.valuation = valuations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("replace")
		@RuneAttribute("replace")
		public ValuationInstruction.ValuationInstructionBuilder setReplace(Boolean _replace) {
			this.replace = _replace == null ? null : _replace;
			return this;
		}
		
		@Override
		public ValuationInstruction build() {
			return new ValuationInstruction.ValuationInstructionImpl(this);
		}
		
		@Override
		public ValuationInstruction.ValuationInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationInstruction.ValuationInstructionBuilder prune() {
			valuation = valuation.stream().filter(b->b!=null).<Valuation.ValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuation()!=null && getValuation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReplace()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationInstruction.ValuationInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationInstruction.ValuationInstructionBuilder o = (ValuationInstruction.ValuationInstructionBuilder) other;
			
			merger.mergeRosetta(getValuation(), o.getValuation(), this::getOrCreateValuation);
			
			merger.mergeBasic(getReplace(), o.getReplace(), this::setReplace);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(valuation, _that.getValuation())) return false;
			if (!Objects.equals(replace, _that.getReplace())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			_result = 31 * _result + (replace != null ? replace.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationInstructionBuilder {" +
				"valuation=" + this.valuation + ", " +
				"replace=" + this.replace +
			'}';
		}
	}
}
