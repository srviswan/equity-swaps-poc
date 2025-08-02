package cdm.legaldocumentation.master;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilderImpl;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariantImpl;
import cdm.legaldocumentation.master.MasterAgreementVariableSet;
import cdm.legaldocumentation.master.MasterAgreementVariableSet.MasterAgreementVariableSetBuilder;
import cdm.legaldocumentation.master.MasterAgreementVariantIdentifierEnum;
import cdm.legaldocumentation.master.meta.MasterAgreementClauseVariantMeta;
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
 * Sets the details for a specific variant associated to a clause in a Master Agreement
 * @version 6.0.0
 */
@RosettaDataType(value="MasterAgreementClauseVariant", builder=MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilderImpl.class, version="6.0.0")
@RuneDataType(value="MasterAgreementClauseVariant", model="Just another Rosetta model", builder=MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilderImpl.class, version="6.0.0")
public interface MasterAgreementClauseVariant extends RosettaModelObject {

	MasterAgreementClauseVariantMeta metaData = new MasterAgreementClauseVariantMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identifier for this variant
	 */
	MasterAgreementVariantIdentifierEnum getIdentifier();
	/**
	 * Optional textual description of the variant.
	 */
	String getName();
	/**
	 * Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.
	 */
	List<CounterpartyRoleEnum> getCounterparty();
	/**
	 * Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.
	 */
	List<PartyRoleEnum> getOtherParty();
	/**
	 * For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.
	 */
	List<? extends MasterAgreementVariableSet> getVariableSet();

	/*********************** Build Methods  ***********************/
	MasterAgreementClauseVariant build();
	
	MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder toBuilder();
	
	static MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder builder() {
		return new MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementClauseVariant> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementClauseVariant> getType() {
		return MasterAgreementClauseVariant.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("identifier"), MasterAgreementVariantIdentifierEnum.class, getIdentifier(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("counterparty"), CounterpartyRoleEnum.class, getCounterparty(), this);
		processor.processBasic(path.newSubPath("otherParty"), PartyRoleEnum.class, getOtherParty(), this);
		processRosetta(path.newSubPath("variableSet"), processor, MasterAgreementVariableSet.class, getVariableSet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementClauseVariantBuilder extends MasterAgreementClauseVariant, RosettaModelObjectBuilder {
		MasterAgreementVariableSet.MasterAgreementVariableSetBuilder getOrCreateVariableSet(int _index);
		@Override
		List<? extends MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> getVariableSet();
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setIdentifier(MasterAgreementVariantIdentifierEnum identifier);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setName(String name);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(CounterpartyRoleEnum counterparty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(CounterpartyRoleEnum counterparty, int _idx);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(List<CounterpartyRoleEnum> counterparty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setCounterparty(List<CounterpartyRoleEnum> counterparty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(PartyRoleEnum otherParty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(PartyRoleEnum otherParty, int _idx);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(List<PartyRoleEnum> otherParty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setOtherParty(List<PartyRoleEnum> otherParty);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(MasterAgreementVariableSet variableSet);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(MasterAgreementVariableSet variableSet, int _idx);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(List<? extends MasterAgreementVariableSet> variableSet);
		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setVariableSet(List<? extends MasterAgreementVariableSet> variableSet);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("identifier"), MasterAgreementVariantIdentifierEnum.class, getIdentifier(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("counterparty"), CounterpartyRoleEnum.class, getCounterparty(), this);
			processor.processBasic(path.newSubPath("otherParty"), PartyRoleEnum.class, getOtherParty(), this);
			processRosetta(path.newSubPath("variableSet"), processor, MasterAgreementVariableSet.MasterAgreementVariableSetBuilder.class, getVariableSet());
		}
		

		MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementClauseVariant  ***********************/
	class MasterAgreementClauseVariantImpl implements MasterAgreementClauseVariant {
		private final MasterAgreementVariantIdentifierEnum identifier;
		private final String name;
		private final List<CounterpartyRoleEnum> counterparty;
		private final List<PartyRoleEnum> otherParty;
		private final List<? extends MasterAgreementVariableSet> variableSet;
		
		protected MasterAgreementClauseVariantImpl(MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder builder) {
			this.identifier = builder.getIdentifier();
			this.name = builder.getName();
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.otherParty = ofNullable(builder.getOtherParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.variableSet = ofNullable(builder.getVariableSet()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public MasterAgreementVariantIdentifierEnum getIdentifier() {
			return identifier;
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
		@RosettaAttribute("variableSet")
		@RuneAttribute("variableSet")
		public List<? extends MasterAgreementVariableSet> getVariableSet() {
			return variableSet;
		}
		
		@Override
		public MasterAgreementClauseVariant build() {
			return this;
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder toBuilder() {
			MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getOtherParty()).ifPresent(builder::setOtherParty);
			ofNullable(getVariableSet()).ifPresent(builder::setVariableSet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementClauseVariant _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			if (!ListEquals.listEquals(variableSet, _that.getVariableSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (variableSet != null ? variableSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementClauseVariant {" +
				"identifier=" + this.identifier + ", " +
				"name=" + this.name + ", " +
				"counterparty=" + this.counterparty + ", " +
				"otherParty=" + this.otherParty + ", " +
				"variableSet=" + this.variableSet +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementClauseVariant  ***********************/
	class MasterAgreementClauseVariantBuilderImpl implements MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder {
	
		protected MasterAgreementVariantIdentifierEnum identifier;
		protected String name;
		protected List<CounterpartyRoleEnum> counterparty = new ArrayList<>();
		protected List<PartyRoleEnum> otherParty = new ArrayList<>();
		protected List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> variableSet = new ArrayList<>();
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public MasterAgreementVariantIdentifierEnum getIdentifier() {
			return identifier;
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
		@RosettaAttribute("variableSet")
		@RuneAttribute("variableSet")
		public List<? extends MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> getVariableSet() {
			return variableSet;
		}
		
		@Override
		public MasterAgreementVariableSet.MasterAgreementVariableSetBuilder getOrCreateVariableSet(int _index) {
		
			if (variableSet==null) {
				this.variableSet = new ArrayList<>();
			}
			MasterAgreementVariableSet.MasterAgreementVariableSetBuilder result;
			return getIndex(variableSet, _index, () -> {
						MasterAgreementVariableSet.MasterAgreementVariableSetBuilder newVariableSet = MasterAgreementVariableSet.builder();
						return newVariableSet;
					});
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setIdentifier(MasterAgreementVariantIdentifierEnum _identifier) {
			this.identifier = _identifier == null ? null : _identifier;
			return this;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@RuneAttribute("counterparty")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(CounterpartyRoleEnum _counterparty) {
			if (_counterparty != null) {
				this.counterparty.add(_counterparty);
			}
			return this;
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(CounterpartyRoleEnum _counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> _counterparty);
			return this;
		}
		
		@Override 
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addCounterparty(List<CounterpartyRoleEnum> counterpartys) {
			if (counterpartys != null) {
				for (final CounterpartyRoleEnum toAdd : counterpartys) {
					this.counterparty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("counterparty")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setCounterparty(List<CounterpartyRoleEnum> counterpartys) {
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
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(PartyRoleEnum _otherParty) {
			if (_otherParty != null) {
				this.otherParty.add(_otherParty);
			}
			return this;
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(PartyRoleEnum _otherParty, int _idx) {
			getIndex(this.otherParty, _idx, () -> _otherParty);
			return this;
		}
		
		@Override 
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addOtherParty(List<PartyRoleEnum> otherPartys) {
			if (otherPartys != null) {
				for (final PartyRoleEnum toAdd : otherPartys) {
					this.otherParty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("otherParty")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setOtherParty(List<PartyRoleEnum> otherPartys) {
			if (otherPartys == null) {
				this.otherParty = new ArrayList<>();
			} else {
				this.otherParty = otherPartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("variableSet")
		@RuneAttribute("variableSet")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(MasterAgreementVariableSet _variableSet) {
			if (_variableSet != null) {
				this.variableSet.add(_variableSet.toBuilder());
			}
			return this;
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(MasterAgreementVariableSet _variableSet, int _idx) {
			getIndex(this.variableSet, _idx, () -> _variableSet.toBuilder());
			return this;
		}
		
		@Override 
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder addVariableSet(List<? extends MasterAgreementVariableSet> variableSets) {
			if (variableSets != null) {
				for (final MasterAgreementVariableSet toAdd : variableSets) {
					this.variableSet.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("variableSet")
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder setVariableSet(List<? extends MasterAgreementVariableSet> variableSets) {
			if (variableSets == null) {
				this.variableSet = new ArrayList<>();
			} else {
				this.variableSet = variableSets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MasterAgreementClauseVariant build() {
			return new MasterAgreementClauseVariant.MasterAgreementClauseVariantImpl(this);
		}
		
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder prune() {
			variableSet = variableSet.stream().filter(b->b!=null).<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getName()!=null) return true;
			if (getCounterparty()!=null && !getCounterparty().isEmpty()) return true;
			if (getOtherParty()!=null && !getOtherParty().isEmpty()) return true;
			if (getVariableSet()!=null && getVariableSet().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder o = (MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder) other;
			
			merger.mergeRosetta(getVariableSet(), o.getVariableSet(), this::getOrCreateVariableSet);
			
			merger.mergeBasic(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getCounterparty(), o.getCounterparty(), (Consumer<CounterpartyRoleEnum>) this::addCounterparty);
			merger.mergeBasic(getOtherParty(), o.getOtherParty(), (Consumer<PartyRoleEnum>) this::addOtherParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementClauseVariant _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			if (!ListEquals.listEquals(variableSet, _that.getVariableSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (variableSet != null ? variableSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementClauseVariantBuilder {" +
				"identifier=" + this.identifier + ", " +
				"name=" + this.name + ", " +
				"counterparty=" + this.counterparty + ", " +
				"otherParty=" + this.otherParty + ", " +
				"variableSet=" + this.variableSet +
			'}';
		}
	}
}
