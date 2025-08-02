package cdm.base.staticdata.party;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyBuilder;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyBuilderImpl;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyImpl;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.meta.AncillaryPartyMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * Defines an ancillary role enumerated value with an associated party reference. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and this AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 * @version 6.0.0
 */
@RosettaDataType(value="AncillaryParty", builder=AncillaryParty.AncillaryPartyBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AncillaryParty", model="Just another Rosetta model", builder=AncillaryParty.AncillaryPartyBuilderImpl.class, version="6.0.0")
public interface AncillaryParty extends RosettaModelObject {

	AncillaryPartyMeta metaData = new AncillaryPartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the AncillaryRoleEnum that is associated to the party reference. An ancillary party is any involved party that is not one of the two principal parties to the transaction.
	 */
	AncillaryRoleEnum getRole();
	/**
	 * Specifies the party, or parties, associated to the ancillary role.
	 */
	List<? extends ReferenceWithMetaParty> getPartyReference();
	/**
	 * Optionally specifies the counterparty that the ancillary party is acting on behalf of.
	 */
	CounterpartyRoleEnum getOnBehalfOf();

	/*********************** Build Methods  ***********************/
	AncillaryParty build();
	
	AncillaryParty.AncillaryPartyBuilder toBuilder();
	
	static AncillaryParty.AncillaryPartyBuilder builder() {
		return new AncillaryParty.AncillaryPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AncillaryParty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AncillaryParty> getType() {
		return AncillaryParty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("role"), AncillaryRoleEnum.class, getRole(), this);
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processor.processBasic(path.newSubPath("onBehalfOf"), CounterpartyRoleEnum.class, getOnBehalfOf(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AncillaryPartyBuilder extends AncillaryParty, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference(int _index);
		@Override
		List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getPartyReference();
		AncillaryParty.AncillaryPartyBuilder setRole(AncillaryRoleEnum role);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty partyReference, int _idx);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party partyReference, int _idx);
		AncillaryParty.AncillaryPartyBuilder addPartyReference(List<? extends ReferenceWithMetaParty> partyReference);
		AncillaryParty.AncillaryPartyBuilder setPartyReference(List<? extends ReferenceWithMetaParty> partyReference);
		AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(List<? extends Party> partyReference);
		AncillaryParty.AncillaryPartyBuilder setPartyReferenceValue(List<? extends Party> partyReference);
		AncillaryParty.AncillaryPartyBuilder setOnBehalfOf(CounterpartyRoleEnum onBehalfOf);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("role"), AncillaryRoleEnum.class, getRole(), this);
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processor.processBasic(path.newSubPath("onBehalfOf"), CounterpartyRoleEnum.class, getOnBehalfOf(), this);
		}
		

		AncillaryParty.AncillaryPartyBuilder prune();
	}

	/*********************** Immutable Implementation of AncillaryParty  ***********************/
	class AncillaryPartyImpl implements AncillaryParty {
		private final AncillaryRoleEnum role;
		private final List<? extends ReferenceWithMetaParty> partyReference;
		private final CounterpartyRoleEnum onBehalfOf;
		
		protected AncillaryPartyImpl(AncillaryParty.AncillaryPartyBuilder builder) {
			this.role = builder.getRole();
			this.partyReference = ofNullable(builder.getPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.onBehalfOf = builder.getOnBehalfOf();
		}
		
		@Override
		@RosettaAttribute("role")
		@RuneAttribute("role")
		public AncillaryRoleEnum getRole() {
			return role;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@RuneAttribute("partyReference")
		public List<? extends ReferenceWithMetaParty> getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@RuneAttribute("onBehalfOf")
		public CounterpartyRoleEnum getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public AncillaryParty build() {
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder toBuilder() {
			AncillaryParty.AncillaryPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AncillaryParty.AncillaryPartyBuilder builder) {
			ofNullable(getRole()).ifPresent(builder::setRole);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryParty _that = getType().cast(o);
		
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryParty {" +
				"role=" + this.role + ", " +
				"partyReference=" + this.partyReference + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}';
		}
	}

	/*********************** Builder Implementation of AncillaryParty  ***********************/
	class AncillaryPartyBuilderImpl implements AncillaryParty.AncillaryPartyBuilder {
	
		protected AncillaryRoleEnum role;
		protected List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> partyReference = new ArrayList<>();
		protected CounterpartyRoleEnum onBehalfOf;
		
		@Override
		@RosettaAttribute("role")
		@RuneAttribute("role")
		public AncillaryRoleEnum getRole() {
			return role;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@RuneAttribute("partyReference")
		public List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference(int _index) {
		
			if (partyReference==null) {
				this.partyReference = new ArrayList<>();
			}
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			return getIndex(partyReference, _index, () -> {
						ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder newPartyReference = ReferenceWithMetaParty.builder();
						return newPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@RuneAttribute("onBehalfOf")
		public CounterpartyRoleEnum getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		@RosettaAttribute("role")
		@RuneAttribute("role")
		public AncillaryParty.AncillaryPartyBuilder setRole(AncillaryRoleEnum _role) {
			this.role = _role == null ? null : _role;
			return this;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@RuneAttribute("partyReference")
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty _partyReference) {
			if (_partyReference != null) {
				this.partyReference.add(_partyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(ReferenceWithMetaParty _partyReference, int _idx) {
			getIndex(this.partyReference, _idx, () -> _partyReference.toBuilder());
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party _partyReference) {
			this.getOrCreatePartyReference(-1).setValue(_partyReference.toBuilder());
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(Party _partyReference, int _idx) {
			this.getOrCreatePartyReference(_idx).setValue(_partyReference.toBuilder());
			return this;
		}
		
		@Override 
		public AncillaryParty.AncillaryPartyBuilder addPartyReference(List<? extends ReferenceWithMetaParty> partyReferences) {
			if (partyReferences != null) {
				for (final ReferenceWithMetaParty toAdd : partyReferences) {
					this.partyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("partyReference")
		public AncillaryParty.AncillaryPartyBuilder setPartyReference(List<? extends ReferenceWithMetaParty> partyReferences) {
			if (partyReferences == null) {
				this.partyReference = new ArrayList<>();
			} else {
				this.partyReference = partyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder addPartyReferenceValue(List<? extends Party> partyReferences) {
			if (partyReferences != null) {
				for (final Party toAdd : partyReferences) {
					this.addPartyReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder setPartyReferenceValue(List<? extends Party> partyReferences) {
			this.partyReference.clear();
			if (partyReferences != null) {
				partyReferences.forEach(this::addPartyReferenceValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@RuneAttribute("onBehalfOf")
		public AncillaryParty.AncillaryPartyBuilder setOnBehalfOf(CounterpartyRoleEnum _onBehalfOf) {
			this.onBehalfOf = _onBehalfOf == null ? null : _onBehalfOf;
			return this;
		}
		
		@Override
		public AncillaryParty build() {
			return new AncillaryParty.AncillaryPartyImpl(this);
		}
		
		@Override
		public AncillaryParty.AncillaryPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryParty.AncillaryPartyBuilder prune() {
			partyReference = partyReference.stream().filter(b->b!=null).<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRole()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOnBehalfOf()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AncillaryParty.AncillaryPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AncillaryParty.AncillaryPartyBuilder o = (AncillaryParty.AncillaryPartyBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::getOrCreatePartyReference);
			
			merger.mergeBasic(getRole(), o.getRole(), this::setRole);
			merger.mergeBasic(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AncillaryParty _that = getType().cast(o);
		
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AncillaryPartyBuilder {" +
				"role=" + this.role + ", " +
				"partyReference=" + this.partyReference + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}';
		}
	}
}
