package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.DebtType.DebtTypeBuilder;
import cdm.base.staticdata.asset.common.EquityTypeEnum;
import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Security.SecurityBuilder;
import cdm.base.staticdata.asset.common.Security.SecurityBuilderImpl;
import cdm.base.staticdata.asset.common.Security.SecurityImpl;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.SecurityMeta;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a security by referencing an identifier and by specifying the sector.
 * @version 6.0.0
 *
 * Body ICMA
 * Corpus MasterAgreement GMRA Global Master Repurchase Agreement GMRA 2011 "The Global Master Repurchase Agreement (GMRA) is a model legal agreement designed for parties transacting repos and is published by the International Capital Market Association (ICMA)." 
 * namingConvention "Purchased Security"
 *
 * Provision As defined in GMRA paragraph 2(oo) The Purchased Securities are the Securities sold or to be sold and any New Purchased Securities transferred by Seller to Buyer under paragraph 8 (Substitution).
 *
 */
@RosettaDataType(value="Security", builder=Security.SecurityBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Security", model="Just another Rosetta model", builder=Security.SecurityBuilderImpl.class, version="6.0.0")
public interface Security extends InstrumentBase {

	SecurityMeta metaData = new SecurityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the type of debt and selected debt economics.
	 */
	DebtType getDebtType();
	/**
	 * Identifies the type of equity.
	 */
	EquityTypeEnum getEquityType();
	/**
	 * Identifies the type of fund.
	 */
	FundProductTypeEnum getFundType();

	/*********************** Build Methods  ***********************/
	Security build();
	
	Security.SecurityBuilder toBuilder();
	
	static Security.SecurityBuilder builder() {
		return new Security.SecurityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Security> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Security> getType() {
		return Security.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
		processRosetta(path.newSubPath("debtType"), processor, DebtType.class, getDebtType());
		processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
		processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityBuilder extends Security, InstrumentBase.InstrumentBaseBuilder {
		DebtType.DebtTypeBuilder getOrCreateDebtType();
		@Override
		DebtType.DebtTypeBuilder getDebtType();
		@Override
		Security.SecurityBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		Security.SecurityBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		Security.SecurityBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Security.SecurityBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		Security.SecurityBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		Security.SecurityBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Security.SecurityBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Security.SecurityBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		Security.SecurityBuilder setExchange(LegalEntity exchange);
		@Override
		Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		Security.SecurityBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		Security.SecurityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		Security.SecurityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		Security.SecurityBuilder setInstrumentType(InstrumentTypeEnum instrumentType);
		Security.SecurityBuilder setDebtType(DebtType debtType);
		Security.SecurityBuilder setEquityType(EquityTypeEnum equityType);
		Security.SecurityBuilder setFundType(FundProductTypeEnum fundType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
			processRosetta(path.newSubPath("debtType"), processor, DebtType.DebtTypeBuilder.class, getDebtType());
			processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
			processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
		}
		

		Security.SecurityBuilder prune();
	}

	/*********************** Immutable Implementation of Security  ***********************/
	class SecurityImpl extends InstrumentBase.InstrumentBaseImpl implements Security {
		private final DebtType debtType;
		private final EquityTypeEnum equityType;
		private final FundProductTypeEnum fundType;
		
		protected SecurityImpl(Security.SecurityBuilder builder) {
			super(builder);
			this.debtType = ofNullable(builder.getDebtType()).map(f->f.build()).orElse(null);
			this.equityType = builder.getEquityType();
			this.fundType = builder.getFundType();
		}
		
		@Override
		@RosettaAttribute("debtType")
		@RuneAttribute("debtType")
		public DebtType getDebtType() {
			return debtType;
		}
		
		@Override
		@RosettaAttribute("equityType")
		@RuneAttribute("equityType")
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		@RosettaAttribute("fundType")
		@RuneAttribute("fundType")
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		public Security build() {
			return this;
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			Security.SecurityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Security.SecurityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDebtType()).ifPresent(builder::setDebtType);
			ofNullable(getEquityType()).ifPresent(builder::setEquityType);
			ofNullable(getFundType()).ifPresent(builder::setFundType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Security {" +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Security  ***********************/
	class SecurityBuilderImpl extends InstrumentBase.InstrumentBaseBuilderImpl implements Security.SecurityBuilder {
	
		protected DebtType.DebtTypeBuilder debtType;
		protected EquityTypeEnum equityType;
		protected FundProductTypeEnum fundType;
		
		@Override
		@RosettaAttribute("debtType")
		@RuneAttribute("debtType")
		public DebtType.DebtTypeBuilder getDebtType() {
			return debtType;
		}
		
		@Override
		public DebtType.DebtTypeBuilder getOrCreateDebtType() {
			DebtType.DebtTypeBuilder result;
			if (debtType!=null) {
				result = debtType;
			}
			else {
				result = debtType = DebtType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityType")
		@RuneAttribute("equityType")
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		@RosettaAttribute("fundType")
		@RuneAttribute("fundType")
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public Security.SecurityBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public Security.SecurityBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("taxonomy")
		@RuneAttribute("taxonomy")
		public Security.SecurityBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public Security.SecurityBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys == null) {
				this.taxonomy = new ArrayList<>();
			} else {
				this.taxonomy = taxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("isExchangeListed")
		@RuneAttribute("isExchangeListed")
		public Security.SecurityBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public Security.SecurityBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public Security.SecurityBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public Security.SecurityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges == null) {
				this.relatedExchange = new ArrayList<>();
			} else {
				this.relatedExchange = relatedExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@RuneAttribute("instrumentType")
		public Security.SecurityBuilder setInstrumentType(InstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@Override
		@RosettaAttribute("debtType")
		@RuneAttribute("debtType")
		public Security.SecurityBuilder setDebtType(DebtType _debtType) {
			this.debtType = _debtType == null ? null : _debtType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("equityType")
		@RuneAttribute("equityType")
		public Security.SecurityBuilder setEquityType(EquityTypeEnum _equityType) {
			this.equityType = _equityType == null ? null : _equityType;
			return this;
		}
		
		@Override
		@RosettaAttribute("fundType")
		@RuneAttribute("fundType")
		public Security.SecurityBuilder setFundType(FundProductTypeEnum _fundType) {
			this.fundType = _fundType == null ? null : _fundType;
			return this;
		}
		
		@Override
		public Security build() {
			return new Security.SecurityImpl(this);
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder prune() {
			super.prune();
			if (debtType!=null && !debtType.prune().hasData()) debtType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDebtType()!=null && getDebtType().hasData()) return true;
			if (getEquityType()!=null) return true;
			if (getFundType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Security.SecurityBuilder o = (Security.SecurityBuilder) other;
			
			merger.mergeRosetta(getDebtType(), o.getDebtType(), this::setDebtType);
			
			merger.mergeBasic(getEquityType(), o.getEquityType(), this::setEquityType);
			merger.mergeBasic(getFundType(), o.getFundType(), this::setFundType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityBuilder {" +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType +
			'}' + " " + super.toString();
		}
	}
}
