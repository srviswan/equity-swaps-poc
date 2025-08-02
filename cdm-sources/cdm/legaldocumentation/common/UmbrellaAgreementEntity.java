package cdm.legaldocumentation.common;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilderImpl;
import cdm.base.staticdata.party.LegalEntity.LegalEntityImpl;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity.UmbrellaAgreementEntityImpl;
import cdm.legaldocumentation.common.meta.UmbrellaAgreementEntityMeta;
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
 * A class to specify the legal entities that are part of the umbrella agreement.
 * @version 6.0.0
 */
@RosettaDataType(value="UmbrellaAgreementEntity", builder=UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl.class, version="6.0.0")
@RuneDataType(value="UmbrellaAgreementEntity", model="Just another Rosetta model", builder=UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl.class, version="6.0.0")
public interface UmbrellaAgreementEntity extends LegalEntity {

	UmbrellaAgreementEntityMeta metaData = new UmbrellaAgreementEntityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The terms that might be associated with each party to the umbrella agreement.
	 */
	String getTerms();

	/*********************** Build Methods  ***********************/
	UmbrellaAgreementEntity build();
	
	UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder();
	
	static UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder() {
		return new UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UmbrellaAgreementEntity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UmbrellaAgreementEntity> getType() {
		return UmbrellaAgreementEntity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaString.class, getEntityId());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processor.processBasic(path.newSubPath("terms"), String.class, getTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UmbrellaAgreementEntityBuilder extends UmbrellaAgreementEntity, LegalEntity.LegalEntityBuilder {
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString entityId, int _idx);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String entityId, int _idx);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(List<? extends String> entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityIdValue(List<? extends String> entityId);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setName(FieldWithMetaString name);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setNameValue(String name);
		@Override
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setMeta(MetaFields meta);
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setTerms(String terms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getEntityId());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processor.processBasic(path.newSubPath("terms"), String.class, getTerms(), this);
		}
		

		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder prune();
	}

	/*********************** Immutable Implementation of UmbrellaAgreementEntity  ***********************/
	class UmbrellaAgreementEntityImpl extends LegalEntity.LegalEntityImpl implements UmbrellaAgreementEntity {
		private final String terms;
		
		protected UmbrellaAgreementEntityImpl(UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder) {
			super(builder);
			this.terms = builder.getTerms();
		}
		
		@Override
		@RosettaAttribute("terms")
		@RuneAttribute("terms")
		public String getTerms() {
			return terms;
		}
		
		@Override
		public UmbrellaAgreementEntity build() {
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder() {
			UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTerms()).ifPresent(builder::setTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UmbrellaAgreementEntity _that = getType().cast(o);
		
			if (!Objects.equals(terms, _that.getTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (terms != null ? terms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreementEntity {" +
				"terms=" + this.terms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UmbrellaAgreementEntity  ***********************/
	class UmbrellaAgreementEntityBuilderImpl extends LegalEntity.LegalEntityBuilderImpl implements UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder {
	
		protected String terms;
		
		@Override
		@RosettaAttribute("terms")
		@RuneAttribute("terms")
		public String getTerms() {
			return terms;
		}
		
		@Override
		@RosettaAttribute("entityId")
		@RuneAttribute("entityId")
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString _entityId) {
			if (_entityId != null) {
				this.entityId.add(_entityId.toBuilder());
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(FieldWithMetaString _entityId, int _idx) {
			getIndex(this.entityId, _idx, () -> _entityId.toBuilder());
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String _entityId) {
			this.getOrCreateEntityId(-1).setValue(_entityId);
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(String _entityId, int _idx) {
			this.getOrCreateEntityId(_idx).setValue(_entityId);
			return this;
		}
		
		@Override 
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds != null) {
				for (final FieldWithMetaString toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("entityId")
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds == null) {
				this.entityId = new ArrayList<>();
			} else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder addEntityIdValue(List<? extends String> entityIds) {
			if (entityIds != null) {
				for (final String toAdd : entityIds) {
					this.addEntityIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setEntityIdValue(List<? extends String> entityIds) {
			this.entityId.clear();
			if (entityIds != null) {
				entityIds.forEach(this::addEntityIdValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("terms")
		@RuneAttribute("terms")
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder setTerms(String _terms) {
			this.terms = _terms == null ? null : _terms;
			return this;
		}
		
		@Override
		public UmbrellaAgreementEntity build() {
			return new UmbrellaAgreementEntity.UmbrellaAgreementEntityImpl(this);
		}
		
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder o = (UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder) other;
			
			
			merger.mergeBasic(getTerms(), o.getTerms(), this::setTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UmbrellaAgreementEntity _that = getType().cast(o);
		
			if (!Objects.equals(terms, _that.getTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (terms != null ? terms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreementEntityBuilder {" +
				"terms=" + this.terms +
			'}' + " " + super.toString();
		}
	}
}
