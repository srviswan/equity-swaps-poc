package cdm.legaldocumentation.master;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.legaldocumentation.master.MasterAgreementClause;
import cdm.legaldocumentation.master.MasterAgreementClause.MasterAgreementClauseBuilder;
import cdm.legaldocumentation.master.MasterAgreementClause.MasterAgreementClauseBuilderImpl;
import cdm.legaldocumentation.master.MasterAgreementClause.MasterAgreementClauseImpl;
import cdm.legaldocumentation.master.MasterAgreementClauseIdentifierEnum;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder;
import cdm.legaldocumentation.master.meta.MasterAgreementClauseMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines clauses that make up a Master Agreement
 * @version 6.0.0
 */
@RosettaDataType(value="MasterAgreementClause", builder=MasterAgreementClause.MasterAgreementClauseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MasterAgreementClause", model="Just another Rosetta model", builder=MasterAgreementClause.MasterAgreementClauseBuilderImpl.class, version="6.0.0")
public interface MasterAgreementClause extends RosettaModelObject {

	MasterAgreementClauseMeta metaData = new MasterAgreementClauseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identifier for the clause
	 */
	MasterAgreementClauseIdentifierEnum getIdentifer();
	/**
	 * Optional textual description of the clause.
	 */
	String getName();
	/**
	 * Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.
	 */
	List<CounterpartyRoleEnum> getCounterparty();
	/**
	 * Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.
	 */
	List<PartyRoleEnum> getOtherParty();
	/**
	 * Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.
	 */
	List<? extends MasterAgreementClauseVariant> getVariant();

	/*********************** Build Methods  ***********************/
	MasterAgreementClause build();
	
	MasterAgreementClause.MasterAgreementClauseBuilder toBuilder();
	
	static MasterAgreementClause.MasterAgreementClauseBuilder builder() {
		return new MasterAgreementClause.MasterAgreementClauseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementClause> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementClause> getType() {
		return MasterAgreementClause.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("identifer"), MasterAgreementClauseIdentifierEnum.class, getIdentifer(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("counterparty"), CounterpartyRoleEnum.class, getCounterparty(), this);
		processor.processBasic(path.newSubPath("otherParty"), PartyRoleEnum.class, getOtherParty(), this);
		processRosetta(path.newSubPath("variant"), processor, MasterAgreementClauseVariant.class, getVariant());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementClauseBuilder extends MasterAgreementClause, RosettaModelObjectBuilder {
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder getOrCreateVariant(int _index);
		@Override
		List<? extends MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> getVariant();
		MasterAgreementClause.MasterAgreementClauseBuilder setIdentifer(MasterAgreementClauseIdentifierEnum identifer);
		MasterAgreementClause.MasterAgreementClauseBuilder setName(String name);
		MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(CounterpartyRoleEnum counterparty);
		MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(CounterpartyRoleEnum counterparty, int _idx);
		MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(List<CounterpartyRoleEnum> counterparty);
		MasterAgreementClause.MasterAgreementClauseBuilder setCounterparty(List<CounterpartyRoleEnum> counterparty);
		MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(PartyRoleEnum otherParty);
		MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(PartyRoleEnum otherParty, int _idx);
		MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(List<PartyRoleEnum> otherParty);
		MasterAgreementClause.MasterAgreementClauseBuilder setOtherParty(List<PartyRoleEnum> otherParty);
		MasterAgreementClause.MasterAgreementClauseBuilder addVariant(MasterAgreementClauseVariant variant);
		MasterAgreementClause.MasterAgreementClauseBuilder addVariant(MasterAgreementClauseVariant variant, int _idx);
		MasterAgreementClause.MasterAgreementClauseBuilder addVariant(List<? extends MasterAgreementClauseVariant> variant);
		MasterAgreementClause.MasterAgreementClauseBuilder setVariant(List<? extends MasterAgreementClauseVariant> variant);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("identifer"), MasterAgreementClauseIdentifierEnum.class, getIdentifer(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("counterparty"), CounterpartyRoleEnum.class, getCounterparty(), this);
			processor.processBasic(path.newSubPath("otherParty"), PartyRoleEnum.class, getOtherParty(), this);
			processRosetta(path.newSubPath("variant"), processor, MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder.class, getVariant());
		}
		

		MasterAgreementClause.MasterAgreementClauseBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementClause  ***********************/
	class MasterAgreementClauseImpl implements MasterAgreementClause {
		private final MasterAgreementClauseIdentifierEnum identifer;
		private final String name;
		private final List<CounterpartyRoleEnum> counterparty;
		private final List<PartyRoleEnum> otherParty;
		private final List<? extends MasterAgreementClauseVariant> variant;
		
		protected MasterAgreementClauseImpl(MasterAgreementClause.MasterAgreementClauseBuilder builder) {
			this.identifer = builder.getIdentifer();
			this.name = builder.getName();
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.otherParty = ofNullable(builder.getOtherParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.variant = ofNullable(builder.getVariant()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifer")
		@RuneAttribute("identifer")
		public MasterAgreementClauseIdentifierEnum getIdentifer() {
			return identifer;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<CounterpartyRoleEnum> getCounterparty() {
			return counterparty;
		}
		
		@Override
		@RosettaAttribute("otherParty")
		@RuneAttribute("otherParty")
		public List<PartyRoleEnum> getOtherParty() {
			return otherParty;
		}
		
		@Override
		@RosettaAttribute("variant")
		@RuneAttribute("variant")
		public List<? extends MasterAgreementClauseVariant> getVariant() {
			return variant;
		}
		
		@Override
		public MasterAgreementClause build() {
			return this;
		}
		
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder toBuilder() {
			MasterAgreementClause.MasterAgreementClauseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementClause.MasterAgreementClauseBuilder builder) {
			ofNullable(getIdentifer()).ifPresent(builder::setIdentifer);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getOtherParty()).ifPresent(builder::setOtherParty);
			ofNullable(getVariant()).ifPresent(builder::setVariant);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementClause _that = getType().cast(o);
		
			if (!Objects.equals(identifer, _that.getIdentifer())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			if (!ListEquals.listEquals(variant, _that.getVariant())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifer != null ? identifer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (variant != null ? variant.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementClause {" +
				"identifer=" + this.identifer + ", " +
				"name=" + this.name + ", " +
				"counterparty=" + this.counterparty + ", " +
				"otherParty=" + this.otherParty + ", " +
				"variant=" + this.variant +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementClause  ***********************/
	class MasterAgreementClauseBuilderImpl implements MasterAgreementClause.MasterAgreementClauseBuilder {
	
		protected MasterAgreementClauseIdentifierEnum identifer;
		protected String name;
		protected List<CounterpartyRoleEnum> counterparty = new ArrayList<>();
		protected List<PartyRoleEnum> otherParty = new ArrayList<>();
		protected List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> variant = new ArrayList<>();
		
		@Override
		@RosettaAttribute("identifer")
		@RuneAttribute("identifer")
		public MasterAgreementClauseIdentifierEnum getIdentifer() {
			return identifer;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public List<CounterpartyRoleEnum> getCounterparty() {
			return counterparty;
		}
		
		@Override
		@RosettaAttribute("otherParty")
		@RuneAttribute("otherParty")
		public List<PartyRoleEnum> getOtherParty() {
			return otherParty;
		}
		
		@Override
		@RosettaAttribute("variant")
		@RuneAttribute("variant")
		public List<? extends MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> getVariant() {
			return variant;
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder getOrCreateVariant(int _index) {
		
			if (variant==null) {
				this.variant = new ArrayList<>();
			}
			MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder result;
			return getIndex(variant, _index, () -> {
						MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder newVariant = MasterAgreementClauseVariant.builder();
						return newVariant;
					});
		}
		
		@Override
		@RosettaAttribute("identifer")
		@RuneAttribute("identifer")
		public MasterAgreementClause.MasterAgreementClauseBuilder setIdentifer(MasterAgreementClauseIdentifierEnum _identifer) {
			this.identifer = _identifer == null ? null : _identifer;
			return this;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public MasterAgreementClause.MasterAgreementClauseBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(CounterpartyRoleEnum _counterparty) {
			if (_counterparty != null) {
				this.counterparty.add(_counterparty);
			}
			return this;
		}
		
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(CounterpartyRoleEnum _counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> _counterparty);
			return this;
		}
		
		@Override 
		public MasterAgreementClause.MasterAgreementClauseBuilder addCounterparty(List<CounterpartyRoleEnum> counterpartys) {
			if (counterpartys != null) {
				for (final CounterpartyRoleEnum toAdd : counterpartys) {
					this.counterparty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("counterparty")
		public MasterAgreementClause.MasterAgreementClauseBuilder setCounterparty(List<CounterpartyRoleEnum> counterpartys) {
			if (counterpartys == null) {
				this.counterparty = new ArrayList<>();
			} else {
				this.counterparty = counterpartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("otherParty")
		@RuneAttribute("otherParty")
		public MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(PartyRoleEnum _otherParty) {
			if (_otherParty != null) {
				this.otherParty.add(_otherParty);
			}
			return this;
		}
		
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(PartyRoleEnum _otherParty, int _idx) {
			getIndex(this.otherParty, _idx, () -> _otherParty);
			return this;
		}
		
		@Override 
		public MasterAgreementClause.MasterAgreementClauseBuilder addOtherParty(List<PartyRoleEnum> otherPartys) {
			if (otherPartys != null) {
				for (final PartyRoleEnum toAdd : otherPartys) {
					this.otherParty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("otherParty")
		public MasterAgreementClause.MasterAgreementClauseBuilder setOtherParty(List<PartyRoleEnum> otherPartys) {
			if (otherPartys == null) {
				this.otherParty = new ArrayList<>();
			} else {
				this.otherParty = otherPartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("variant")
		@RuneAttribute("variant")
		public MasterAgreementClause.MasterAgreementClauseBuilder addVariant(MasterAgreementClauseVariant _variant) {
			if (_variant != null) {
				this.variant.add(_variant.toBuilder());
			}
			return this;
		}
		
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder addVariant(MasterAgreementClauseVariant _variant, int _idx) {
			getIndex(this.variant, _idx, () -> _variant.toBuilder());
			return this;
		}
		
		@Override 
		public MasterAgreementClause.MasterAgreementClauseBuilder addVariant(List<? extends MasterAgreementClauseVariant> variants) {
			if (variants != null) {
				for (final MasterAgreementClauseVariant toAdd : variants) {
					this.variant.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("variant")
		public MasterAgreementClause.MasterAgreementClauseBuilder setVariant(List<? extends MasterAgreementClauseVariant> variants) {
			if (variants == null) {
				this.variant = new ArrayList<>();
			} else {
				this.variant = variants.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MasterAgreementClause build() {
			return new MasterAgreementClause.MasterAgreementClauseImpl(this);
		}
		
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder prune() {
			variant = variant.stream().filter(b->b!=null).<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifer()!=null) return true;
			if (getName()!=null) return true;
			if (getCounterparty()!=null && !getCounterparty().isEmpty()) return true;
			if (getOtherParty()!=null && !getOtherParty().isEmpty()) return true;
			if (getVariant()!=null && getVariant().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementClause.MasterAgreementClauseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementClause.MasterAgreementClauseBuilder o = (MasterAgreementClause.MasterAgreementClauseBuilder) other;
			
			merger.mergeRosetta(getVariant(), o.getVariant(), this::getOrCreateVariant);
			
			merger.mergeBasic(getIdentifer(), o.getIdentifer(), this::setIdentifer);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getCounterparty(), o.getCounterparty(), (Consumer<CounterpartyRoleEnum>) this::addCounterparty);
			merger.mergeBasic(getOtherParty(), o.getOtherParty(), (Consumer<PartyRoleEnum>) this::addOtherParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementClause _that = getType().cast(o);
		
			if (!Objects.equals(identifer, _that.getIdentifer())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			if (!ListEquals.listEquals(variant, _that.getVariant())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifer != null ? identifer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (variant != null ? variant.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementClauseBuilder {" +
				"identifer=" + this.identifer + ", " +
				"name=" + this.name + ", " +
				"counterparty=" + this.counterparty + ", " +
				"otherParty=" + this.otherParty + ", " +
				"variant=" + this.variant +
			'}';
		}
	}
}
