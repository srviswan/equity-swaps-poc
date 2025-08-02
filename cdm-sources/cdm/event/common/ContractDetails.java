package cdm.event.common;

import cdm.event.common.ContractDetails;
import cdm.event.common.ContractDetails.ContractDetailsBuilder;
import cdm.event.common.ContractDetails.ContractDetailsBuilderImpl;
import cdm.event.common.ContractDetails.ContractDetailsImpl;
import cdm.event.common.meta.ContractDetailsMeta;
import cdm.legaldocumentation.common.GoverningLawEnum;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreement.LegalAgreementBuilder;
import cdm.legaldocumentation.common.metafields.FieldWithMetaGoverningLawEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
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
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines specific attributes that relate to contractual details of trades.
 * @version 6.0.0
 */
@RosettaDataType(value="ContractDetails", builder=ContractDetails.ContractDetailsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ContractDetails", model="Just another Rosetta model", builder=ContractDetails.ContractDetailsBuilderImpl.class, version="6.0.0")
public interface ContractDetails extends RosettaModelObject, GlobalKey {

	ContractDetailsMeta metaData = new ContractDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents the legal document(s) that governs a trade and associated contractual product terms, either as a reference to such documents when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
	 */
	List<? extends LegalAgreement> getDocumentation();
	/**
	 * Represents the law governing the trade and associated contractual product terms.
	 */
	FieldWithMetaGoverningLawEnum getGoverningLaw();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	ContractDetails build();
	
	ContractDetails.ContractDetailsBuilder toBuilder();
	
	static ContractDetails.ContractDetailsBuilder builder() {
		return new ContractDetails.ContractDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractDetails> getType() {
		return ContractDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("documentation"), processor, LegalAgreement.class, getDocumentation());
		processRosetta(path.newSubPath("governingLaw"), processor, FieldWithMetaGoverningLawEnum.class, getGoverningLaw());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractDetailsBuilder extends ContractDetails, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		LegalAgreement.LegalAgreementBuilder getOrCreateDocumentation(int _index);
		@Override
		List<? extends LegalAgreement.LegalAgreementBuilder> getDocumentation();
		FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder getOrCreateGoverningLaw();
		@Override
		FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder getGoverningLaw();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		ContractDetails.ContractDetailsBuilder addDocumentation(LegalAgreement documentation);
		ContractDetails.ContractDetailsBuilder addDocumentation(LegalAgreement documentation, int _idx);
		ContractDetails.ContractDetailsBuilder addDocumentation(List<? extends LegalAgreement> documentation);
		ContractDetails.ContractDetailsBuilder setDocumentation(List<? extends LegalAgreement> documentation);
		ContractDetails.ContractDetailsBuilder setGoverningLaw(FieldWithMetaGoverningLawEnum governingLaw);
		ContractDetails.ContractDetailsBuilder setGoverningLawValue(GoverningLawEnum governingLaw);
		ContractDetails.ContractDetailsBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("documentation"), processor, LegalAgreement.LegalAgreementBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("governingLaw"), processor, FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		ContractDetails.ContractDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ContractDetails  ***********************/
	class ContractDetailsImpl implements ContractDetails {
		private final List<? extends LegalAgreement> documentation;
		private final FieldWithMetaGoverningLawEnum governingLaw;
		private final MetaFields meta;
		
		protected ContractDetailsImpl(ContractDetails.ContractDetailsBuilder builder) {
			this.documentation = ofNullable(builder.getDocumentation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("documentation")
		@RuneAttribute("documentation")
		public List<? extends LegalAgreement> getDocumentation() {
			return documentation;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@RuneAttribute("governingLaw")
		public FieldWithMetaGoverningLawEnum getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ContractDetails build() {
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder toBuilder() {
			ContractDetails.ContractDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractDetails.ContractDetailsBuilder builder) {
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractDetails {" +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractDetails  ***********************/
	class ContractDetailsBuilderImpl implements ContractDetails.ContractDetailsBuilder {
	
		protected List<LegalAgreement.LegalAgreementBuilder> documentation = new ArrayList<>();
		protected FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder governingLaw;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("documentation")
		@RuneAttribute("documentation")
		public List<? extends LegalAgreement.LegalAgreementBuilder> getDocumentation() {
			return documentation;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder getOrCreateDocumentation(int _index) {
		
			if (documentation==null) {
				this.documentation = new ArrayList<>();
			}
			LegalAgreement.LegalAgreementBuilder result;
			return getIndex(documentation, _index, () -> {
						LegalAgreement.LegalAgreementBuilder newDocumentation = LegalAgreement.builder();
						return newDocumentation;
					});
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@RuneAttribute("governingLaw")
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder getOrCreateGoverningLaw() {
			FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = FieldWithMetaGoverningLawEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("documentation")
		@RuneAttribute("documentation")
		public ContractDetails.ContractDetailsBuilder addDocumentation(LegalAgreement _documentation) {
			if (_documentation != null) {
				this.documentation.add(_documentation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder addDocumentation(LegalAgreement _documentation, int _idx) {
			getIndex(this.documentation, _idx, () -> _documentation.toBuilder());
			return this;
		}
		
		@Override 
		public ContractDetails.ContractDetailsBuilder addDocumentation(List<? extends LegalAgreement> documentations) {
			if (documentations != null) {
				for (final LegalAgreement toAdd : documentations) {
					this.documentation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("documentation")
		public ContractDetails.ContractDetailsBuilder setDocumentation(List<? extends LegalAgreement> documentations) {
			if (documentations == null) {
				this.documentation = new ArrayList<>();
			} else {
				this.documentation = documentations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@RuneAttribute("governingLaw")
		public ContractDetails.ContractDetailsBuilder setGoverningLaw(FieldWithMetaGoverningLawEnum _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder setGoverningLawValue(GoverningLawEnum _governingLaw) {
			this.getOrCreateGoverningLaw().setValue(_governingLaw);
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public ContractDetails.ContractDetailsBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public ContractDetails build() {
			return new ContractDetails.ContractDetailsImpl(this);
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractDetails.ContractDetailsBuilder prune() {
			documentation = documentation.stream().filter(b->b!=null).<LegalAgreement.LegalAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDocumentation()!=null && getDocumentation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGoverningLaw()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractDetails.ContractDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractDetails.ContractDetailsBuilder o = (ContractDetails.ContractDetailsBuilder) other;
			
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::getOrCreateDocumentation);
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractDetailsBuilder {" +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
