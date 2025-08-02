package cdm.event.common;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.AssignedIdentifier.AssignedIdentifierBuilder;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilderImpl;
import cdm.base.staticdata.identifier.Identifier.IdentifierImpl;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.event.common.PositionIdentifier;
import cdm.event.common.PositionIdentifier.PositionIdentifierBuilder;
import cdm.event.common.PositionIdentifier.PositionIdentifierBuilderImpl;
import cdm.event.common.PositionIdentifier.PositionIdentifierImpl;
import cdm.event.common.meta.PositionIdentifierMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines a position identifier as a special case of the generic identifier type, that also includes the position identifier class.
 * @version 6.0.0
 */
@RosettaDataType(value="PositionIdentifier", builder=PositionIdentifier.PositionIdentifierBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PositionIdentifier", model="Just another Rosetta model", builder=PositionIdentifier.PositionIdentifierBuilderImpl.class, version="6.0.0")
public interface PositionIdentifier extends Identifier {

	PositionIdentifierMeta metaData = new PositionIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The enumerated classification of the identifier. Optional as a position identifier may be party-specific, in which case it may not correspond to any established classification.
	 */
	TradeIdentifierTypeEnum getIdentifierType();

	/*********************** Build Methods  ***********************/
	PositionIdentifier build();
	
	PositionIdentifier.PositionIdentifierBuilder toBuilder();
	
	static PositionIdentifier.PositionIdentifierBuilder builder() {
		return new PositionIdentifier.PositionIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PositionIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PositionIdentifier> getType() {
		return PositionIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerReference"), processor, ReferenceWithMetaParty.class, getIssuerReference());
		processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaString.class, getIssuer());
		processRosetta(path.newSubPath("assignedIdentifier"), processor, AssignedIdentifier.class, getAssignedIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processor.processBasic(path.newSubPath("identifierType"), TradeIdentifierTypeEnum.class, getIdentifierType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PositionIdentifierBuilder extends PositionIdentifier, Identifier.IdentifierBuilder {
		@Override
		PositionIdentifier.PositionIdentifierBuilder setIssuerReference(ReferenceWithMetaParty issuerReference);
		@Override
		PositionIdentifier.PositionIdentifierBuilder setIssuerReferenceValue(Party issuerReference);
		@Override
		PositionIdentifier.PositionIdentifierBuilder setIssuer(FieldWithMetaString issuer);
		@Override
		PositionIdentifier.PositionIdentifierBuilder setIssuerValue(String issuer);
		@Override
		PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier);
		@Override
		PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(AssignedIdentifier assignedIdentifier, int _idx);
		@Override
		PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifier);
		@Override
		PositionIdentifier.PositionIdentifierBuilder setAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifier);
		@Override
		PositionIdentifier.PositionIdentifierBuilder setMeta(MetaFields meta);
		PositionIdentifier.PositionIdentifierBuilder setIdentifierType(TradeIdentifierTypeEnum identifierType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getIssuerReference());
			processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getIssuer());
			processRosetta(path.newSubPath("assignedIdentifier"), processor, AssignedIdentifier.AssignedIdentifierBuilder.class, getAssignedIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processor.processBasic(path.newSubPath("identifierType"), TradeIdentifierTypeEnum.class, getIdentifierType(), this);
		}
		

		PositionIdentifier.PositionIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PositionIdentifier  ***********************/
	class PositionIdentifierImpl extends Identifier.IdentifierImpl implements PositionIdentifier {
		private final TradeIdentifierTypeEnum identifierType;
		
		protected PositionIdentifierImpl(PositionIdentifier.PositionIdentifierBuilder builder) {
			super(builder);
			this.identifierType = builder.getIdentifierType();
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public TradeIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		public PositionIdentifier build() {
			return this;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder toBuilder() {
			PositionIdentifier.PositionIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PositionIdentifier.PositionIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIdentifierType()).ifPresent(builder::setIdentifierType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PositionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PositionIdentifier {" +
				"identifierType=" + this.identifierType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PositionIdentifier  ***********************/
	class PositionIdentifierBuilderImpl extends Identifier.IdentifierBuilderImpl implements PositionIdentifier.PositionIdentifierBuilder {
	
		protected TradeIdentifierTypeEnum identifierType;
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public TradeIdentifierTypeEnum getIdentifierType() {
			return identifierType;
		}
		
		@Override
		@RosettaAttribute("issuerReference")
		@RuneAttribute("issuerReference")
		public PositionIdentifier.PositionIdentifierBuilder setIssuerReference(ReferenceWithMetaParty _issuerReference) {
			this.issuerReference = _issuerReference == null ? null : _issuerReference.toBuilder();
			return this;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder setIssuerReferenceValue(Party _issuerReference) {
			this.getOrCreateIssuerReference().setValue(_issuerReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("issuer")
		@RuneAttribute("issuer")
		public PositionIdentifier.PositionIdentifierBuilder setIssuer(FieldWithMetaString _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder setIssuerValue(String _issuer) {
			this.getOrCreateIssuer().setValue(_issuer);
			return this;
		}
		
		@Override
		@RosettaAttribute("assignedIdentifier")
		@RuneAttribute("assignedIdentifier")
		public PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(AssignedIdentifier _assignedIdentifier) {
			if (_assignedIdentifier != null) {
				this.assignedIdentifier.add(_assignedIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(AssignedIdentifier _assignedIdentifier, int _idx) {
			getIndex(this.assignedIdentifier, _idx, () -> _assignedIdentifier.toBuilder());
			return this;
		}
		
		@Override 
		public PositionIdentifier.PositionIdentifierBuilder addAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifiers) {
			if (assignedIdentifiers != null) {
				for (final AssignedIdentifier toAdd : assignedIdentifiers) {
					this.assignedIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("assignedIdentifier")
		public PositionIdentifier.PositionIdentifierBuilder setAssignedIdentifier(List<? extends AssignedIdentifier> assignedIdentifiers) {
			if (assignedIdentifiers == null) {
				this.assignedIdentifier = new ArrayList<>();
			} else {
				this.assignedIdentifier = assignedIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public PositionIdentifier.PositionIdentifierBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("identifierType")
		@RuneAttribute("identifierType")
		public PositionIdentifier.PositionIdentifierBuilder setIdentifierType(TradeIdentifierTypeEnum _identifierType) {
			this.identifierType = _identifierType == null ? null : _identifierType;
			return this;
		}
		
		@Override
		public PositionIdentifier build() {
			return new PositionIdentifier.PositionIdentifierImpl(this);
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PositionIdentifier.PositionIdentifierBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIdentifierType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PositionIdentifier.PositionIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PositionIdentifier.PositionIdentifierBuilder o = (PositionIdentifier.PositionIdentifierBuilder) other;
			
			
			merger.mergeBasic(getIdentifierType(), o.getIdentifierType(), this::setIdentifierType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PositionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifierType, _that.getIdentifierType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (identifierType != null ? identifierType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PositionIdentifierBuilder {" +
				"identifierType=" + this.identifierType +
			'}' + " " + super.toString();
		}
	}
}
