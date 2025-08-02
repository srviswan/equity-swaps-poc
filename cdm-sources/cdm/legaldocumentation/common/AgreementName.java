package cdm.legaldocumentation.common;

import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.AgreementName.AgreementNameBuilder;
import cdm.legaldocumentation.common.AgreementName.AgreementNameBuilderImpl;
import cdm.legaldocumentation.common.AgreementName.AgreementNameImpl;
import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.legaldocumentation.common.ContractualMatrix;
import cdm.legaldocumentation.common.ContractualMatrix.ContractualMatrixBuilder;
import cdm.legaldocumentation.common.ContractualTermsSupplement;
import cdm.legaldocumentation.common.ContractualTermsSupplement.ContractualTermsSupplementBuilder;
import cdm.legaldocumentation.common.LegalAgreementTypeEnum;
import cdm.legaldocumentation.common.meta.AgreementNameMeta;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder;
import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterAgreementTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import cdm.legaldocumentation.master.metafields.FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import cdm.product.collateral.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
import cdm.product.collateral.metafields.FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder;
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
 * Specifies the agreement name through an agreement type and optional detailed sub agreement type.
 * @version 6.0.0
 */
@RosettaDataType(value="AgreementName", builder=AgreementName.AgreementNameBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AgreementName", model="Just another Rosetta model", builder=AgreementName.AgreementNameBuilderImpl.class, version="6.0.0")
public interface AgreementName extends RosettaModelObject {

	AgreementNameMeta metaData = new AgreementNameMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specification of the legal agreement type.
	 */
	LegalAgreementTypeEnum getAgreementType();
	/**
	 * Specification of the credit support agreement type.
	 */
	FieldWithMetaCreditSupportAgreementTypeEnum getCreditSupportAgreementType();
	/**
	 * specifies the type of margin for which a legal agreement is named.
	 */
	CollateralMarginTypeEnum getCreditSupportAgreementMarginType();
	/**
	 * The definitions such as those published by ISDA that will define the terms of the trade.
	 */
	List<? extends FieldWithMetaContractualDefinitionsEnum> getContractualDefinitionsType();
	/**
	 * A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();
	/**
	 * A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
	 */
	List<? extends ContractualMatrix> getContractualMatrix();
	/**
	 * Specification of the master agreement type.
	 */
	FieldWithMetaMasterAgreementTypeEnum getMasterAgreementType();
	/**
	 * The type of master confirmation executed between the parties.
	 */
	FieldWithMetaMasterConfirmationTypeEnum getMasterConfirmationType();
	/**
	 * The type of master confirmation annex executed between the parties.
	 */
	FieldWithMetaMasterConfirmationAnnexTypeEnum getMasterConfirmationAnnexType();
	/**
	 * Definition of an agreement that is not enumerated in the CDM.
	 */
	String getOtherAgreement();

	/*********************** Build Methods  ***********************/
	AgreementName build();
	
	AgreementName.AgreementNameBuilder toBuilder();
	
	static AgreementName.AgreementNameBuilder builder() {
		return new AgreementName.AgreementNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgreementName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgreementName> getType() {
		return AgreementName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("agreementType"), LegalAgreementTypeEnum.class, getAgreementType(), this);
		processRosetta(path.newSubPath("creditSupportAgreementType"), processor, FieldWithMetaCreditSupportAgreementTypeEnum.class, getCreditSupportAgreementType());
		processor.processBasic(path.newSubPath("creditSupportAgreementMarginType"), CollateralMarginTypeEnum.class, getCreditSupportAgreementMarginType(), this);
		processRosetta(path.newSubPath("contractualDefinitionsType"), processor, FieldWithMetaContractualDefinitionsEnum.class, getContractualDefinitionsType());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
		processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.class, getContractualMatrix());
		processRosetta(path.newSubPath("masterAgreementType"), processor, FieldWithMetaMasterAgreementTypeEnum.class, getMasterAgreementType());
		processRosetta(path.newSubPath("masterConfirmationType"), processor, FieldWithMetaMasterConfirmationTypeEnum.class, getMasterConfirmationType());
		processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, FieldWithMetaMasterConfirmationAnnexTypeEnum.class, getMasterConfirmationAnnexType());
		processor.processBasic(path.newSubPath("otherAgreement"), String.class, getOtherAgreement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgreementNameBuilder extends AgreementName, RosettaModelObjectBuilder {
		FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder getOrCreateCreditSupportAgreementType();
		@Override
		FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder getCreditSupportAgreementType();
		FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder getOrCreateContractualDefinitionsType(int _index);
		@Override
		List<? extends FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder> getContractualDefinitionsType();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index);
		@Override
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index);
		@Override
		List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix();
		FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder getOrCreateMasterAgreementType();
		@Override
		FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder getMasterAgreementType();
		FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder getOrCreateMasterConfirmationType();
		@Override
		FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder getMasterConfirmationType();
		FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getOrCreateMasterConfirmationAnnexType();
		@Override
		FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getMasterConfirmationAnnexType();
		AgreementName.AgreementNameBuilder setAgreementType(LegalAgreementTypeEnum agreementType);
		AgreementName.AgreementNameBuilder setCreditSupportAgreementType(FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementType);
		AgreementName.AgreementNameBuilder setCreditSupportAgreementTypeValue(CreditSupportAgreementTypeEnum creditSupportAgreementType);
		AgreementName.AgreementNameBuilder setCreditSupportAgreementMarginType(CollateralMarginTypeEnum creditSupportAgreementMarginType);
		AgreementName.AgreementNameBuilder addContractualDefinitionsType(FieldWithMetaContractualDefinitionsEnum contractualDefinitionsType);
		AgreementName.AgreementNameBuilder addContractualDefinitionsType(FieldWithMetaContractualDefinitionsEnum contractualDefinitionsType, int _idx);
		AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(ContractualDefinitionsEnum contractualDefinitionsType);
		AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(ContractualDefinitionsEnum contractualDefinitionsType, int _idx);
		AgreementName.AgreementNameBuilder addContractualDefinitionsType(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionsType);
		AgreementName.AgreementNameBuilder setContractualDefinitionsType(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionsType);
		AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionsType);
		AgreementName.AgreementNameBuilder setContractualDefinitionsTypeValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionsType);
		AgreementName.AgreementNameBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement);
		AgreementName.AgreementNameBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int _idx);
		AgreementName.AgreementNameBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		AgreementName.AgreementNameBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		AgreementName.AgreementNameBuilder addContractualMatrix(ContractualMatrix contractualMatrix);
		AgreementName.AgreementNameBuilder addContractualMatrix(ContractualMatrix contractualMatrix, int _idx);
		AgreementName.AgreementNameBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		AgreementName.AgreementNameBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		AgreementName.AgreementNameBuilder setMasterAgreementType(FieldWithMetaMasterAgreementTypeEnum masterAgreementType);
		AgreementName.AgreementNameBuilder setMasterAgreementTypeValue(MasterAgreementTypeEnum masterAgreementType);
		AgreementName.AgreementNameBuilder setMasterConfirmationType(FieldWithMetaMasterConfirmationTypeEnum masterConfirmationType);
		AgreementName.AgreementNameBuilder setMasterConfirmationTypeValue(MasterConfirmationTypeEnum masterConfirmationType);
		AgreementName.AgreementNameBuilder setMasterConfirmationAnnexType(FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType);
		AgreementName.AgreementNameBuilder setMasterConfirmationAnnexTypeValue(MasterConfirmationAnnexTypeEnum masterConfirmationAnnexType);
		AgreementName.AgreementNameBuilder setOtherAgreement(String otherAgreement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("agreementType"), LegalAgreementTypeEnum.class, getAgreementType(), this);
			processRosetta(path.newSubPath("creditSupportAgreementType"), processor, FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder.class, getCreditSupportAgreementType());
			processor.processBasic(path.newSubPath("creditSupportAgreementMarginType"), CollateralMarginTypeEnum.class, getCreditSupportAgreementMarginType(), this);
			processRosetta(path.newSubPath("contractualDefinitionsType"), processor, FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder.class, getContractualDefinitionsType());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
			processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.ContractualMatrixBuilder.class, getContractualMatrix());
			processRosetta(path.newSubPath("masterAgreementType"), processor, FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder.class, getMasterAgreementType());
			processRosetta(path.newSubPath("masterConfirmationType"), processor, FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder.class, getMasterConfirmationType());
			processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder.class, getMasterConfirmationAnnexType());
			processor.processBasic(path.newSubPath("otherAgreement"), String.class, getOtherAgreement(), this);
		}
		

		AgreementName.AgreementNameBuilder prune();
	}

	/*********************** Immutable Implementation of AgreementName  ***********************/
	class AgreementNameImpl implements AgreementName {
		private final LegalAgreementTypeEnum agreementType;
		private final FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementType;
		private final CollateralMarginTypeEnum creditSupportAgreementMarginType;
		private final List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionsType;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		private final List<? extends ContractualMatrix> contractualMatrix;
		private final FieldWithMetaMasterAgreementTypeEnum masterAgreementType;
		private final FieldWithMetaMasterConfirmationTypeEnum masterConfirmationType;
		private final FieldWithMetaMasterConfirmationAnnexTypeEnum masterConfirmationAnnexType;
		private final String otherAgreement;
		
		protected AgreementNameImpl(AgreementName.AgreementNameBuilder builder) {
			this.agreementType = builder.getAgreementType();
			this.creditSupportAgreementType = ofNullable(builder.getCreditSupportAgreementType()).map(f->f.build()).orElse(null);
			this.creditSupportAgreementMarginType = builder.getCreditSupportAgreementMarginType();
			this.contractualDefinitionsType = ofNullable(builder.getContractualDefinitionsType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualMatrix = ofNullable(builder.getContractualMatrix()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.masterAgreementType = ofNullable(builder.getMasterAgreementType()).map(f->f.build()).orElse(null);
			this.masterConfirmationType = ofNullable(builder.getMasterConfirmationType()).map(f->f.build()).orElse(null);
			this.masterConfirmationAnnexType = ofNullable(builder.getMasterConfirmationAnnexType()).map(f->f.build()).orElse(null);
			this.otherAgreement = builder.getOtherAgreement();
		}
		
		@Override
		@RosettaAttribute("agreementType")
		@RuneAttribute("agreementType")
		public LegalAgreementTypeEnum getAgreementType() {
			return agreementType;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementType")
		@RuneAttribute("creditSupportAgreementType")
		public FieldWithMetaCreditSupportAgreementTypeEnum getCreditSupportAgreementType() {
			return creditSupportAgreementType;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementMarginType")
		@RuneAttribute("creditSupportAgreementMarginType")
		public CollateralMarginTypeEnum getCreditSupportAgreementMarginType() {
			return creditSupportAgreementMarginType;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionsType")
		@RuneAttribute("contractualDefinitionsType")
		public List<? extends FieldWithMetaContractualDefinitionsEnum> getContractualDefinitionsType() {
			return contractualDefinitionsType;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		@RuneAttribute("contractualMatrix")
		public List<? extends ContractualMatrix> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@RuneAttribute("masterAgreementType")
		public FieldWithMetaMasterAgreementTypeEnum getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		@RuneAttribute("masterConfirmationType")
		public FieldWithMetaMasterConfirmationTypeEnum getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		@RuneAttribute("masterConfirmationAnnexType")
		public FieldWithMetaMasterConfirmationAnnexTypeEnum getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		@RuneAttribute("otherAgreement")
		public String getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		public AgreementName build() {
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder toBuilder() {
			AgreementName.AgreementNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgreementName.AgreementNameBuilder builder) {
			ofNullable(getAgreementType()).ifPresent(builder::setAgreementType);
			ofNullable(getCreditSupportAgreementType()).ifPresent(builder::setCreditSupportAgreementType);
			ofNullable(getCreditSupportAgreementMarginType()).ifPresent(builder::setCreditSupportAgreementMarginType);
			ofNullable(getContractualDefinitionsType()).ifPresent(builder::setContractualDefinitionsType);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
			ofNullable(getContractualMatrix()).ifPresent(builder::setContractualMatrix);
			ofNullable(getMasterAgreementType()).ifPresent(builder::setMasterAgreementType);
			ofNullable(getMasterConfirmationType()).ifPresent(builder::setMasterConfirmationType);
			ofNullable(getMasterConfirmationAnnexType()).ifPresent(builder::setMasterConfirmationAnnexType);
			ofNullable(getOtherAgreement()).ifPresent(builder::setOtherAgreement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementName _that = getType().cast(o);
		
			if (!Objects.equals(agreementType, _that.getAgreementType())) return false;
			if (!Objects.equals(creditSupportAgreementType, _that.getCreditSupportAgreementType())) return false;
			if (!Objects.equals(creditSupportAgreementMarginType, _that.getCreditSupportAgreementMarginType())) return false;
			if (!ListEquals.listEquals(contractualDefinitionsType, _that.getContractualDefinitionsType())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			if (!Objects.equals(otherAgreement, _that.getOtherAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementType != null ? agreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementType != null ? creditSupportAgreementType.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementMarginType != null ? creditSupportAgreementMarginType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionsType != null ? contractualDefinitionsType.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementName {" +
				"agreementType=" + this.agreementType + ", " +
				"creditSupportAgreementType=" + this.creditSupportAgreementType + ", " +
				"creditSupportAgreementMarginType=" + this.creditSupportAgreementMarginType + ", " +
				"contractualDefinitionsType=" + this.contractualDefinitionsType + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType + ", " +
				"otherAgreement=" + this.otherAgreement +
			'}';
		}
	}

	/*********************** Builder Implementation of AgreementName  ***********************/
	class AgreementNameBuilderImpl implements AgreementName.AgreementNameBuilder {
	
		protected LegalAgreementTypeEnum agreementType;
		protected FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder creditSupportAgreementType;
		protected CollateralMarginTypeEnum creditSupportAgreementMarginType;
		protected List<FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder> contractualDefinitionsType = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
		protected List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrix = new ArrayList<>();
		protected FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder masterAgreementType;
		protected FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder masterConfirmationType;
		protected FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder masterConfirmationAnnexType;
		protected String otherAgreement;
		
		@Override
		@RosettaAttribute("agreementType")
		@RuneAttribute("agreementType")
		public LegalAgreementTypeEnum getAgreementType() {
			return agreementType;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementType")
		@RuneAttribute("creditSupportAgreementType")
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder getCreditSupportAgreementType() {
			return creditSupportAgreementType;
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder getOrCreateCreditSupportAgreementType() {
			FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder result;
			if (creditSupportAgreementType!=null) {
				result = creditSupportAgreementType;
			}
			else {
				result = creditSupportAgreementType = FieldWithMetaCreditSupportAgreementTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementMarginType")
		@RuneAttribute("creditSupportAgreementMarginType")
		public CollateralMarginTypeEnum getCreditSupportAgreementMarginType() {
			return creditSupportAgreementMarginType;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionsType")
		@RuneAttribute("contractualDefinitionsType")
		public List<? extends FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder> getContractualDefinitionsType() {
			return contractualDefinitionsType;
		}
		
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder getOrCreateContractualDefinitionsType(int _index) {
		
			if (contractualDefinitionsType==null) {
				this.contractualDefinitionsType = new ArrayList<>();
			}
			FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder result;
			return getIndex(contractualDefinitionsType, _index, () -> {
						FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder newContractualDefinitionsType = FieldWithMetaContractualDefinitionsEnum.builder();
						return newContractualDefinitionsType;
					});
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index) {
		
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			ContractualTermsSupplement.ContractualTermsSupplementBuilder result;
			return getIndex(contractualTermsSupplement, _index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		@RuneAttribute("contractualMatrix")
		public List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index) {
		
			if (contractualMatrix==null) {
				this.contractualMatrix = new ArrayList<>();
			}
			ContractualMatrix.ContractualMatrixBuilder result;
			return getIndex(contractualMatrix, _index, () -> {
						ContractualMatrix.ContractualMatrixBuilder newContractualMatrix = ContractualMatrix.builder();
						return newContractualMatrix;
					});
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@RuneAttribute("masterAgreementType")
		public FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		public FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder getOrCreateMasterAgreementType() {
			FieldWithMetaMasterAgreementTypeEnum.FieldWithMetaMasterAgreementTypeEnumBuilder result;
			if (masterAgreementType!=null) {
				result = masterAgreementType;
			}
			else {
				result = masterAgreementType = FieldWithMetaMasterAgreementTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		@RuneAttribute("masterConfirmationType")
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder getOrCreateMasterConfirmationType() {
			FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder result;
			if (masterConfirmationType!=null) {
				result = masterConfirmationType;
			}
			else {
				result = masterConfirmationType = FieldWithMetaMasterConfirmationTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		@RuneAttribute("masterConfirmationAnnexType")
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder getOrCreateMasterConfirmationAnnexType() {
			FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder result;
			if (masterConfirmationAnnexType!=null) {
				result = masterConfirmationAnnexType;
			}
			else {
				result = masterConfirmationAnnexType = FieldWithMetaMasterConfirmationAnnexTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		@RuneAttribute("otherAgreement")
		public String getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		@RosettaAttribute("agreementType")
		@RuneAttribute("agreementType")
		public AgreementName.AgreementNameBuilder setAgreementType(LegalAgreementTypeEnum _agreementType) {
			this.agreementType = _agreementType == null ? null : _agreementType;
			return this;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementType")
		@RuneAttribute("creditSupportAgreementType")
		public AgreementName.AgreementNameBuilder setCreditSupportAgreementType(FieldWithMetaCreditSupportAgreementTypeEnum _creditSupportAgreementType) {
			this.creditSupportAgreementType = _creditSupportAgreementType == null ? null : _creditSupportAgreementType.toBuilder();
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder setCreditSupportAgreementTypeValue(CreditSupportAgreementTypeEnum _creditSupportAgreementType) {
			this.getOrCreateCreditSupportAgreementType().setValue(_creditSupportAgreementType);
			return this;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreementMarginType")
		@RuneAttribute("creditSupportAgreementMarginType")
		public AgreementName.AgreementNameBuilder setCreditSupportAgreementMarginType(CollateralMarginTypeEnum _creditSupportAgreementMarginType) {
			this.creditSupportAgreementMarginType = _creditSupportAgreementMarginType == null ? null : _creditSupportAgreementMarginType;
			return this;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionsType")
		@RuneAttribute("contractualDefinitionsType")
		public AgreementName.AgreementNameBuilder addContractualDefinitionsType(FieldWithMetaContractualDefinitionsEnum _contractualDefinitionsType) {
			if (_contractualDefinitionsType != null) {
				this.contractualDefinitionsType.add(_contractualDefinitionsType.toBuilder());
			}
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualDefinitionsType(FieldWithMetaContractualDefinitionsEnum _contractualDefinitionsType, int _idx) {
			getIndex(this.contractualDefinitionsType, _idx, () -> _contractualDefinitionsType.toBuilder());
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(ContractualDefinitionsEnum _contractualDefinitionsType) {
			this.getOrCreateContractualDefinitionsType(-1).setValue(_contractualDefinitionsType);
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(ContractualDefinitionsEnum _contractualDefinitionsType, int _idx) {
			this.getOrCreateContractualDefinitionsType(_idx).setValue(_contractualDefinitionsType);
			return this;
		}
		
		@Override 
		public AgreementName.AgreementNameBuilder addContractualDefinitionsType(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionsTypes) {
			if (contractualDefinitionsTypes != null) {
				for (final FieldWithMetaContractualDefinitionsEnum toAdd : contractualDefinitionsTypes) {
					this.contractualDefinitionsType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("contractualDefinitionsType")
		public AgreementName.AgreementNameBuilder setContractualDefinitionsType(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionsTypes) {
			if (contractualDefinitionsTypes == null) {
				this.contractualDefinitionsType = new ArrayList<>();
			} else {
				this.contractualDefinitionsType = contractualDefinitionsTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualDefinitionsTypeValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionsTypes) {
			if (contractualDefinitionsTypes != null) {
				for (final ContractualDefinitionsEnum toAdd : contractualDefinitionsTypes) {
					this.addContractualDefinitionsTypeValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder setContractualDefinitionsTypeValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionsTypes) {
			this.contractualDefinitionsType.clear();
			if (contractualDefinitionsTypes != null) {
				contractualDefinitionsTypes.forEach(this::addContractualDefinitionsTypeValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@RuneAttribute("contractualTermsSupplement")
		public AgreementName.AgreementNameBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement) {
			if (_contractualTermsSupplement != null) {
				this.contractualTermsSupplement.add(_contractualTermsSupplement.toBuilder());
			}
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement, int _idx) {
			getIndex(this.contractualTermsSupplement, _idx, () -> _contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override 
		public AgreementName.AgreementNameBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (final ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("contractualTermsSupplement")
		public AgreementName.AgreementNameBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null) {
				this.contractualTermsSupplement = new ArrayList<>();
			} else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		@RuneAttribute("contractualMatrix")
		public AgreementName.AgreementNameBuilder addContractualMatrix(ContractualMatrix _contractualMatrix) {
			if (_contractualMatrix != null) {
				this.contractualMatrix.add(_contractualMatrix.toBuilder());
			}
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder addContractualMatrix(ContractualMatrix _contractualMatrix, int _idx) {
			getIndex(this.contractualMatrix, _idx, () -> _contractualMatrix.toBuilder());
			return this;
		}
		
		@Override 
		public AgreementName.AgreementNameBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs != null) {
				for (final ContractualMatrix toAdd : contractualMatrixs) {
					this.contractualMatrix.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("contractualMatrix")
		public AgreementName.AgreementNameBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs == null) {
				this.contractualMatrix = new ArrayList<>();
			} else {
				this.contractualMatrix = contractualMatrixs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@RuneAttribute("masterAgreementType")
		public AgreementName.AgreementNameBuilder setMasterAgreementType(FieldWithMetaMasterAgreementTypeEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType.toBuilder();
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder setMasterAgreementTypeValue(MasterAgreementTypeEnum _masterAgreementType) {
			this.getOrCreateMasterAgreementType().setValue(_masterAgreementType);
			return this;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		@RuneAttribute("masterConfirmationType")
		public AgreementName.AgreementNameBuilder setMasterConfirmationType(FieldWithMetaMasterConfirmationTypeEnum _masterConfirmationType) {
			this.masterConfirmationType = _masterConfirmationType == null ? null : _masterConfirmationType.toBuilder();
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder setMasterConfirmationTypeValue(MasterConfirmationTypeEnum _masterConfirmationType) {
			this.getOrCreateMasterConfirmationType().setValue(_masterConfirmationType);
			return this;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		@RuneAttribute("masterConfirmationAnnexType")
		public AgreementName.AgreementNameBuilder setMasterConfirmationAnnexType(FieldWithMetaMasterConfirmationAnnexTypeEnum _masterConfirmationAnnexType) {
			this.masterConfirmationAnnexType = _masterConfirmationAnnexType == null ? null : _masterConfirmationAnnexType.toBuilder();
			return this;
		}
		
		@Override
		public AgreementName.AgreementNameBuilder setMasterConfirmationAnnexTypeValue(MasterConfirmationAnnexTypeEnum _masterConfirmationAnnexType) {
			this.getOrCreateMasterConfirmationAnnexType().setValue(_masterConfirmationAnnexType);
			return this;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		@RuneAttribute("otherAgreement")
		public AgreementName.AgreementNameBuilder setOtherAgreement(String _otherAgreement) {
			this.otherAgreement = _otherAgreement == null ? null : _otherAgreement;
			return this;
		}
		
		@Override
		public AgreementName build() {
			return new AgreementName.AgreementNameImpl(this);
		}
		
		@Override
		public AgreementName.AgreementNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementName.AgreementNameBuilder prune() {
			if (creditSupportAgreementType!=null && !creditSupportAgreementType.prune().hasData()) creditSupportAgreementType = null;
			contractualDefinitionsType = contractualDefinitionsType.stream().filter(b->b!=null).<FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualMatrix = contractualMatrix.stream().filter(b->b!=null).<ContractualMatrix.ContractualMatrixBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (masterAgreementType!=null && !masterAgreementType.prune().hasData()) masterAgreementType = null;
			if (masterConfirmationType!=null && !masterConfirmationType.prune().hasData()) masterConfirmationType = null;
			if (masterConfirmationAnnexType!=null && !masterConfirmationAnnexType.prune().hasData()) masterConfirmationAnnexType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreementType()!=null) return true;
			if (getCreditSupportAgreementType()!=null) return true;
			if (getCreditSupportAgreementMarginType()!=null) return true;
			if (getContractualDefinitionsType()!=null && !getContractualDefinitionsType().isEmpty()) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualMatrix()!=null && getContractualMatrix().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMasterAgreementType()!=null) return true;
			if (getMasterConfirmationType()!=null) return true;
			if (getMasterConfirmationAnnexType()!=null) return true;
			if (getOtherAgreement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementName.AgreementNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgreementName.AgreementNameBuilder o = (AgreementName.AgreementNameBuilder) other;
			
			merger.mergeRosetta(getCreditSupportAgreementType(), o.getCreditSupportAgreementType(), this::setCreditSupportAgreementType);
			merger.mergeRosetta(getContractualDefinitionsType(), o.getContractualDefinitionsType(), this::getOrCreateContractualDefinitionsType);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			merger.mergeRosetta(getContractualMatrix(), o.getContractualMatrix(), this::getOrCreateContractualMatrix);
			merger.mergeRosetta(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementType);
			merger.mergeRosetta(getMasterConfirmationType(), o.getMasterConfirmationType(), this::setMasterConfirmationType);
			merger.mergeRosetta(getMasterConfirmationAnnexType(), o.getMasterConfirmationAnnexType(), this::setMasterConfirmationAnnexType);
			
			merger.mergeBasic(getAgreementType(), o.getAgreementType(), this::setAgreementType);
			merger.mergeBasic(getCreditSupportAgreementMarginType(), o.getCreditSupportAgreementMarginType(), this::setCreditSupportAgreementMarginType);
			merger.mergeBasic(getOtherAgreement(), o.getOtherAgreement(), this::setOtherAgreement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementName _that = getType().cast(o);
		
			if (!Objects.equals(agreementType, _that.getAgreementType())) return false;
			if (!Objects.equals(creditSupportAgreementType, _that.getCreditSupportAgreementType())) return false;
			if (!Objects.equals(creditSupportAgreementMarginType, _that.getCreditSupportAgreementMarginType())) return false;
			if (!ListEquals.listEquals(contractualDefinitionsType, _that.getContractualDefinitionsType())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			if (!Objects.equals(otherAgreement, _that.getOtherAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementType != null ? agreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementType != null ? creditSupportAgreementType.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementMarginType != null ? creditSupportAgreementMarginType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionsType != null ? contractualDefinitionsType.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementNameBuilder {" +
				"agreementType=" + this.agreementType + ", " +
				"creditSupportAgreementType=" + this.creditSupportAgreementType + ", " +
				"creditSupportAgreementMarginType=" + this.creditSupportAgreementMarginType + ", " +
				"contractualDefinitionsType=" + this.contractualDefinitionsType + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType + ", " +
				"otherAgreement=" + this.otherAgreement +
			'}';
		}
	}
}
