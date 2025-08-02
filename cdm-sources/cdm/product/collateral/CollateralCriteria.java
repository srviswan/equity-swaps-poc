package cdm.product.collateral;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.AssetType.AssetTypeBuilder;
import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.CollateralIssuerType.CollateralIssuerTypeBuilder;
import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomy.CollateralTaxonomyBuilder;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.observable.asset.Index;
import cdm.observable.asset.Index.IndexBuilder;
import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AllCriteria.AllCriteriaBuilder;
import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.AnyCriteria.AnyCriteriaBuilder;
import cdm.product.collateral.AssetAgencyRating;
import cdm.product.collateral.AssetAgencyRating.AssetAgencyRatingBuilder;
import cdm.product.collateral.AssetCountryOfOrigin;
import cdm.product.collateral.AssetCountryOfOrigin.AssetCountryOfOriginBuilder;
import cdm.product.collateral.AssetMaturity;
import cdm.product.collateral.AssetMaturity.AssetMaturityBuilder;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilderImpl;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaImpl;
import cdm.product.collateral.CounterpartyOwnIssuePermitted;
import cdm.product.collateral.CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder;
import cdm.product.collateral.DomesticCurrencyIssued;
import cdm.product.collateral.DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder;
import cdm.product.collateral.IssuerAgencyRating;
import cdm.product.collateral.IssuerAgencyRating.IssuerAgencyRatingBuilder;
import cdm.product.collateral.IssuerCountryOfOrigin;
import cdm.product.collateral.IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder;
import cdm.product.collateral.IssuerName;
import cdm.product.collateral.IssuerName.IssuerNameBuilder;
import cdm.product.collateral.ListingExchange;
import cdm.product.collateral.ListingExchange.ListingExchangeBuilder;
import cdm.product.collateral.ListingSector;
import cdm.product.collateral.ListingSector.ListingSectorBuilder;
import cdm.product.collateral.NegativeCriteria;
import cdm.product.collateral.NegativeCriteria.NegativeCriteriaBuilder;
import cdm.product.collateral.SovereignAgencyRating;
import cdm.product.collateral.SovereignAgencyRating.SovereignAgencyRatingBuilder;
import cdm.product.collateral.SpecificAsset;
import cdm.product.collateral.SpecificAsset.SpecificAssetBuilder;
import cdm.product.collateral.meta.CollateralCriteriaMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The possible different terms that can be combined, using AND, OR and NOT logic, to define the issuers and/or assets that meet a given criteria for collateral.
 * @version 6.0.0
 */
@RosettaDataType(value="CollateralCriteria", builder=CollateralCriteria.CollateralCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CollateralCriteria", model="Just another Rosetta model", builder=CollateralCriteria.CollateralCriteriaBuilderImpl.class, version="6.0.0")
public interface CollateralCriteria extends RosettaModelObject {

	CollateralCriteriaMeta metaData = new CollateralCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Enables two or more Collateral Criteria to be combined using AND logic.
	 */
	AllCriteria getAllCriteria();
	/**
	 * Enables two or more Collateral Criteria to be combined using OR logic.
	 */
	AnyCriteria getAnyCriteria();
	/**
	 * Enables a single Collateral Criteria to be excluded using NOT logic.
	 */
	NegativeCriteria getNegativeCriteria();
	/**
	 * Criteria is the type of entity issuing the asset.
	 */
	CollateralIssuerType getCollateralIssuerType();
	/**
	 * Criteria is the asset type of the collateral.
	 */
	AssetType getAssetType();
	/**
	 * Criteria is the issuing entity country of origin.
	 */
	IssuerCountryOfOrigin getIssuerCountryOfOrigin();
	/**
	 * Criteria is the collateral asset country of origin.
	 */
	AssetCountryOfOrigin getAssetCountryOfOrigin();
	/**
	 * Criteria is the denominated currency of the collateral.
	 */
	CurrencyCodeEnum getCurrencyCodeEnum();
	/**
	 * Criteria is a specific named issuer entity.
	 */
	IssuerName getIssuerName();
	/**
	 * Criteria is the agency rating(s) of the issuer.
	 */
	IssuerAgencyRating getIssuerAgencyRating();
	/**
	 * Criteria is the agency rating(s) of the country of the issuer.
	 */
	SovereignAgencyRating getSovereignAgencyRating();
	/**
	 * Criteria is the agency rating(s) of the collateral asset.
	 */
	AssetAgencyRating getAssetAgencyRating();
	/**
	 * Criteria is the maturity characteristics of the collateral asset.
	 */
	AssetMaturity getAssetMaturity();
	/**
	 * Criteria is a specifically identified asset
	 */
	SpecificAsset getSpecificAsset();
	/**
	 * Criteria is the taxonomy characteristics of an collateral.
	 */
	CollateralTaxonomy getCollateralTaxonomy();
	/**
	 * Criteria is that the collateral is listed on a specific exchange.
	 */
	ListingExchange getListingExchange();
	/**
	 * Criteria is the industry sector of the collateral asset.
	 */
	ListingSector getListingSector();
	/**
	 * Criteria is that the collateral is a constituent of a specific index.
	 */
	Index getIndex();
	/**
	 * Criteria includes collateral issued by the counterparty.
	 */
	CounterpartyOwnIssuePermitted getCounterpartyOwnIssuePermitted();
	/**
	 * Criteria is that collateral must be denominated in the domestic currency of the issuer.
	 */
	DomesticCurrencyIssued getDomesticCurrencyIssued();

	/*********************** Build Methods  ***********************/
	CollateralCriteria build();
	
	CollateralCriteria.CollateralCriteriaBuilder toBuilder();
	
	static CollateralCriteria.CollateralCriteriaBuilder builder() {
		return new CollateralCriteria.CollateralCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralCriteria> getType() {
		return CollateralCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("AllCriteria"), processor, AllCriteria.class, getAllCriteria());
		processRosetta(path.newSubPath("AnyCriteria"), processor, AnyCriteria.class, getAnyCriteria());
		processRosetta(path.newSubPath("NegativeCriteria"), processor, NegativeCriteria.class, getNegativeCriteria());
		processRosetta(path.newSubPath("CollateralIssuerType"), processor, CollateralIssuerType.class, getCollateralIssuerType());
		processRosetta(path.newSubPath("AssetType"), processor, AssetType.class, getAssetType());
		processRosetta(path.newSubPath("IssuerCountryOfOrigin"), processor, IssuerCountryOfOrigin.class, getIssuerCountryOfOrigin());
		processRosetta(path.newSubPath("AssetCountryOfOrigin"), processor, AssetCountryOfOrigin.class, getAssetCountryOfOrigin());
		processor.processBasic(path.newSubPath("CurrencyCodeEnum"), CurrencyCodeEnum.class, getCurrencyCodeEnum(), this);
		processRosetta(path.newSubPath("IssuerName"), processor, IssuerName.class, getIssuerName());
		processRosetta(path.newSubPath("IssuerAgencyRating"), processor, IssuerAgencyRating.class, getIssuerAgencyRating());
		processRosetta(path.newSubPath("SovereignAgencyRating"), processor, SovereignAgencyRating.class, getSovereignAgencyRating());
		processRosetta(path.newSubPath("AssetAgencyRating"), processor, AssetAgencyRating.class, getAssetAgencyRating());
		processRosetta(path.newSubPath("AssetMaturity"), processor, AssetMaturity.class, getAssetMaturity());
		processRosetta(path.newSubPath("SpecificAsset"), processor, SpecificAsset.class, getSpecificAsset());
		processRosetta(path.newSubPath("CollateralTaxonomy"), processor, CollateralTaxonomy.class, getCollateralTaxonomy());
		processRosetta(path.newSubPath("ListingExchange"), processor, ListingExchange.class, getListingExchange());
		processRosetta(path.newSubPath("ListingSector"), processor, ListingSector.class, getListingSector());
		processRosetta(path.newSubPath("Index"), processor, Index.class, getIndex());
		processRosetta(path.newSubPath("CounterpartyOwnIssuePermitted"), processor, CounterpartyOwnIssuePermitted.class, getCounterpartyOwnIssuePermitted());
		processRosetta(path.newSubPath("DomesticCurrencyIssued"), processor, DomesticCurrencyIssued.class, getDomesticCurrencyIssued());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralCriteriaBuilder extends CollateralCriteria, RosettaModelObjectBuilder {
		AllCriteria.AllCriteriaBuilder getOrCreateAllCriteria();
		@Override
		AllCriteria.AllCriteriaBuilder getAllCriteria();
		AnyCriteria.AnyCriteriaBuilder getOrCreateAnyCriteria();
		@Override
		AnyCriteria.AnyCriteriaBuilder getAnyCriteria();
		NegativeCriteria.NegativeCriteriaBuilder getOrCreateNegativeCriteria();
		@Override
		NegativeCriteria.NegativeCriteriaBuilder getNegativeCriteria();
		CollateralIssuerType.CollateralIssuerTypeBuilder getOrCreateCollateralIssuerType();
		@Override
		CollateralIssuerType.CollateralIssuerTypeBuilder getCollateralIssuerType();
		AssetType.AssetTypeBuilder getOrCreateAssetType();
		@Override
		AssetType.AssetTypeBuilder getAssetType();
		IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder getOrCreateIssuerCountryOfOrigin();
		@Override
		IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder getIssuerCountryOfOrigin();
		AssetCountryOfOrigin.AssetCountryOfOriginBuilder getOrCreateAssetCountryOfOrigin();
		@Override
		AssetCountryOfOrigin.AssetCountryOfOriginBuilder getAssetCountryOfOrigin();
		IssuerName.IssuerNameBuilder getOrCreateIssuerName();
		@Override
		IssuerName.IssuerNameBuilder getIssuerName();
		IssuerAgencyRating.IssuerAgencyRatingBuilder getOrCreateIssuerAgencyRating();
		@Override
		IssuerAgencyRating.IssuerAgencyRatingBuilder getIssuerAgencyRating();
		SovereignAgencyRating.SovereignAgencyRatingBuilder getOrCreateSovereignAgencyRating();
		@Override
		SovereignAgencyRating.SovereignAgencyRatingBuilder getSovereignAgencyRating();
		AssetAgencyRating.AssetAgencyRatingBuilder getOrCreateAssetAgencyRating();
		@Override
		AssetAgencyRating.AssetAgencyRatingBuilder getAssetAgencyRating();
		AssetMaturity.AssetMaturityBuilder getOrCreateAssetMaturity();
		@Override
		AssetMaturity.AssetMaturityBuilder getAssetMaturity();
		SpecificAsset.SpecificAssetBuilder getOrCreateSpecificAsset();
		@Override
		SpecificAsset.SpecificAssetBuilder getSpecificAsset();
		CollateralTaxonomy.CollateralTaxonomyBuilder getOrCreateCollateralTaxonomy();
		@Override
		CollateralTaxonomy.CollateralTaxonomyBuilder getCollateralTaxonomy();
		ListingExchange.ListingExchangeBuilder getOrCreateListingExchange();
		@Override
		ListingExchange.ListingExchangeBuilder getListingExchange();
		ListingSector.ListingSectorBuilder getOrCreateListingSector();
		@Override
		ListingSector.ListingSectorBuilder getListingSector();
		Index.IndexBuilder getOrCreateIndex();
		@Override
		Index.IndexBuilder getIndex();
		CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder getOrCreateCounterpartyOwnIssuePermitted();
		@Override
		CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder getCounterpartyOwnIssuePermitted();
		DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder getOrCreateDomesticCurrencyIssued();
		@Override
		DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder getDomesticCurrencyIssued();
		CollateralCriteria.CollateralCriteriaBuilder setAllCriteria(AllCriteria _AllCriteria);
		CollateralCriteria.CollateralCriteriaBuilder setAnyCriteria(AnyCriteria _AnyCriteria);
		CollateralCriteria.CollateralCriteriaBuilder setNegativeCriteria(NegativeCriteria _NegativeCriteria);
		CollateralCriteria.CollateralCriteriaBuilder setCollateralIssuerType(CollateralIssuerType _CollateralIssuerType);
		CollateralCriteria.CollateralCriteriaBuilder setAssetType(AssetType _AssetType);
		CollateralCriteria.CollateralCriteriaBuilder setIssuerCountryOfOrigin(IssuerCountryOfOrigin _IssuerCountryOfOrigin);
		CollateralCriteria.CollateralCriteriaBuilder setAssetCountryOfOrigin(AssetCountryOfOrigin _AssetCountryOfOrigin);
		CollateralCriteria.CollateralCriteriaBuilder setCurrencyCodeEnum(CurrencyCodeEnum _CurrencyCodeEnum);
		CollateralCriteria.CollateralCriteriaBuilder setIssuerName(IssuerName _IssuerName);
		CollateralCriteria.CollateralCriteriaBuilder setIssuerAgencyRating(IssuerAgencyRating _IssuerAgencyRating);
		CollateralCriteria.CollateralCriteriaBuilder setSovereignAgencyRating(SovereignAgencyRating _SovereignAgencyRating);
		CollateralCriteria.CollateralCriteriaBuilder setAssetAgencyRating(AssetAgencyRating _AssetAgencyRating);
		CollateralCriteria.CollateralCriteriaBuilder setAssetMaturity(AssetMaturity _AssetMaturity);
		CollateralCriteria.CollateralCriteriaBuilder setSpecificAsset(SpecificAsset _SpecificAsset);
		CollateralCriteria.CollateralCriteriaBuilder setCollateralTaxonomy(CollateralTaxonomy _CollateralTaxonomy);
		CollateralCriteria.CollateralCriteriaBuilder setListingExchange(ListingExchange _ListingExchange);
		CollateralCriteria.CollateralCriteriaBuilder setListingSector(ListingSector _ListingSector);
		CollateralCriteria.CollateralCriteriaBuilder setIndex(Index _Index);
		CollateralCriteria.CollateralCriteriaBuilder setCounterpartyOwnIssuePermitted(CounterpartyOwnIssuePermitted _CounterpartyOwnIssuePermitted);
		CollateralCriteria.CollateralCriteriaBuilder setDomesticCurrencyIssued(DomesticCurrencyIssued _DomesticCurrencyIssued);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("AllCriteria"), processor, AllCriteria.AllCriteriaBuilder.class, getAllCriteria());
			processRosetta(path.newSubPath("AnyCriteria"), processor, AnyCriteria.AnyCriteriaBuilder.class, getAnyCriteria());
			processRosetta(path.newSubPath("NegativeCriteria"), processor, NegativeCriteria.NegativeCriteriaBuilder.class, getNegativeCriteria());
			processRosetta(path.newSubPath("CollateralIssuerType"), processor, CollateralIssuerType.CollateralIssuerTypeBuilder.class, getCollateralIssuerType());
			processRosetta(path.newSubPath("AssetType"), processor, AssetType.AssetTypeBuilder.class, getAssetType());
			processRosetta(path.newSubPath("IssuerCountryOfOrigin"), processor, IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder.class, getIssuerCountryOfOrigin());
			processRosetta(path.newSubPath("AssetCountryOfOrigin"), processor, AssetCountryOfOrigin.AssetCountryOfOriginBuilder.class, getAssetCountryOfOrigin());
			processor.processBasic(path.newSubPath("CurrencyCodeEnum"), CurrencyCodeEnum.class, getCurrencyCodeEnum(), this);
			processRosetta(path.newSubPath("IssuerName"), processor, IssuerName.IssuerNameBuilder.class, getIssuerName());
			processRosetta(path.newSubPath("IssuerAgencyRating"), processor, IssuerAgencyRating.IssuerAgencyRatingBuilder.class, getIssuerAgencyRating());
			processRosetta(path.newSubPath("SovereignAgencyRating"), processor, SovereignAgencyRating.SovereignAgencyRatingBuilder.class, getSovereignAgencyRating());
			processRosetta(path.newSubPath("AssetAgencyRating"), processor, AssetAgencyRating.AssetAgencyRatingBuilder.class, getAssetAgencyRating());
			processRosetta(path.newSubPath("AssetMaturity"), processor, AssetMaturity.AssetMaturityBuilder.class, getAssetMaturity());
			processRosetta(path.newSubPath("SpecificAsset"), processor, SpecificAsset.SpecificAssetBuilder.class, getSpecificAsset());
			processRosetta(path.newSubPath("CollateralTaxonomy"), processor, CollateralTaxonomy.CollateralTaxonomyBuilder.class, getCollateralTaxonomy());
			processRosetta(path.newSubPath("ListingExchange"), processor, ListingExchange.ListingExchangeBuilder.class, getListingExchange());
			processRosetta(path.newSubPath("ListingSector"), processor, ListingSector.ListingSectorBuilder.class, getListingSector());
			processRosetta(path.newSubPath("Index"), processor, Index.IndexBuilder.class, getIndex());
			processRosetta(path.newSubPath("CounterpartyOwnIssuePermitted"), processor, CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder.class, getCounterpartyOwnIssuePermitted());
			processRosetta(path.newSubPath("DomesticCurrencyIssued"), processor, DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder.class, getDomesticCurrencyIssued());
		}
		

		CollateralCriteria.CollateralCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralCriteria  ***********************/
	class CollateralCriteriaImpl implements CollateralCriteria {
		private final AllCriteria allCriteria;
		private final AnyCriteria anyCriteria;
		private final NegativeCriteria negativeCriteria;
		private final CollateralIssuerType collateralIssuerType;
		private final AssetType assetType;
		private final IssuerCountryOfOrigin issuerCountryOfOrigin;
		private final AssetCountryOfOrigin assetCountryOfOrigin;
		private final CurrencyCodeEnum currencyCodeEnum;
		private final IssuerName issuerName;
		private final IssuerAgencyRating issuerAgencyRating;
		private final SovereignAgencyRating sovereignAgencyRating;
		private final AssetAgencyRating assetAgencyRating;
		private final AssetMaturity assetMaturity;
		private final SpecificAsset specificAsset;
		private final CollateralTaxonomy collateralTaxonomy;
		private final ListingExchange listingExchange;
		private final ListingSector listingSector;
		private final Index index;
		private final CounterpartyOwnIssuePermitted counterpartyOwnIssuePermitted;
		private final DomesticCurrencyIssued domesticCurrencyIssued;
		
		protected CollateralCriteriaImpl(CollateralCriteria.CollateralCriteriaBuilder builder) {
			this.allCriteria = ofNullable(builder.getAllCriteria()).map(f->f.build()).orElse(null);
			this.anyCriteria = ofNullable(builder.getAnyCriteria()).map(f->f.build()).orElse(null);
			this.negativeCriteria = ofNullable(builder.getNegativeCriteria()).map(f->f.build()).orElse(null);
			this.collateralIssuerType = ofNullable(builder.getCollateralIssuerType()).map(f->f.build()).orElse(null);
			this.assetType = ofNullable(builder.getAssetType()).map(f->f.build()).orElse(null);
			this.issuerCountryOfOrigin = ofNullable(builder.getIssuerCountryOfOrigin()).map(f->f.build()).orElse(null);
			this.assetCountryOfOrigin = ofNullable(builder.getAssetCountryOfOrigin()).map(f->f.build()).orElse(null);
			this.currencyCodeEnum = builder.getCurrencyCodeEnum();
			this.issuerName = ofNullable(builder.getIssuerName()).map(f->f.build()).orElse(null);
			this.issuerAgencyRating = ofNullable(builder.getIssuerAgencyRating()).map(f->f.build()).orElse(null);
			this.sovereignAgencyRating = ofNullable(builder.getSovereignAgencyRating()).map(f->f.build()).orElse(null);
			this.assetAgencyRating = ofNullable(builder.getAssetAgencyRating()).map(f->f.build()).orElse(null);
			this.assetMaturity = ofNullable(builder.getAssetMaturity()).map(f->f.build()).orElse(null);
			this.specificAsset = ofNullable(builder.getSpecificAsset()).map(f->f.build()).orElse(null);
			this.collateralTaxonomy = ofNullable(builder.getCollateralTaxonomy()).map(f->f.build()).orElse(null);
			this.listingExchange = ofNullable(builder.getListingExchange()).map(f->f.build()).orElse(null);
			this.listingSector = ofNullable(builder.getListingSector()).map(f->f.build()).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
			this.counterpartyOwnIssuePermitted = ofNullable(builder.getCounterpartyOwnIssuePermitted()).map(f->f.build()).orElse(null);
			this.domesticCurrencyIssued = ofNullable(builder.getDomesticCurrencyIssued()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("AllCriteria")
		@RuneAttribute("AllCriteria")
		public AllCriteria getAllCriteria() {
			return allCriteria;
		}
		
		@Override
		@RosettaAttribute("AnyCriteria")
		@RuneAttribute("AnyCriteria")
		public AnyCriteria getAnyCriteria() {
			return anyCriteria;
		}
		
		@Override
		@RosettaAttribute("NegativeCriteria")
		@RuneAttribute("NegativeCriteria")
		public NegativeCriteria getNegativeCriteria() {
			return negativeCriteria;
		}
		
		@Override
		@RosettaAttribute("CollateralIssuerType")
		@RuneAttribute("CollateralIssuerType")
		public CollateralIssuerType getCollateralIssuerType() {
			return collateralIssuerType;
		}
		
		@Override
		@RosettaAttribute("AssetType")
		@RuneAttribute("AssetType")
		public AssetType getAssetType() {
			return assetType;
		}
		
		@Override
		@RosettaAttribute("IssuerCountryOfOrigin")
		@RuneAttribute("IssuerCountryOfOrigin")
		public IssuerCountryOfOrigin getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		@Override
		@RosettaAttribute("AssetCountryOfOrigin")
		@RuneAttribute("AssetCountryOfOrigin")
		public AssetCountryOfOrigin getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		@Override
		@RosettaAttribute("CurrencyCodeEnum")
		@RuneAttribute("CurrencyCodeEnum")
		public CurrencyCodeEnum getCurrencyCodeEnum() {
			return currencyCodeEnum;
		}
		
		@Override
		@RosettaAttribute("IssuerName")
		@RuneAttribute("IssuerName")
		public IssuerName getIssuerName() {
			return issuerName;
		}
		
		@Override
		@RosettaAttribute("IssuerAgencyRating")
		@RuneAttribute("IssuerAgencyRating")
		public IssuerAgencyRating getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		@Override
		@RosettaAttribute("SovereignAgencyRating")
		@RuneAttribute("SovereignAgencyRating")
		public SovereignAgencyRating getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		@Override
		@RosettaAttribute("AssetAgencyRating")
		@RuneAttribute("AssetAgencyRating")
		public AssetAgencyRating getAssetAgencyRating() {
			return assetAgencyRating;
		}
		
		@Override
		@RosettaAttribute("AssetMaturity")
		@RuneAttribute("AssetMaturity")
		public AssetMaturity getAssetMaturity() {
			return assetMaturity;
		}
		
		@Override
		@RosettaAttribute("SpecificAsset")
		@RuneAttribute("SpecificAsset")
		public SpecificAsset getSpecificAsset() {
			return specificAsset;
		}
		
		@Override
		@RosettaAttribute("CollateralTaxonomy")
		@RuneAttribute("CollateralTaxonomy")
		public CollateralTaxonomy getCollateralTaxonomy() {
			return collateralTaxonomy;
		}
		
		@Override
		@RosettaAttribute("ListingExchange")
		@RuneAttribute("ListingExchange")
		public ListingExchange getListingExchange() {
			return listingExchange;
		}
		
		@Override
		@RosettaAttribute("ListingSector")
		@RuneAttribute("ListingSector")
		public ListingSector getListingSector() {
			return listingSector;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public Index getIndex() {
			return index;
		}
		
		@Override
		@RosettaAttribute("CounterpartyOwnIssuePermitted")
		@RuneAttribute("CounterpartyOwnIssuePermitted")
		public CounterpartyOwnIssuePermitted getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		@RosettaAttribute("DomesticCurrencyIssued")
		@RuneAttribute("DomesticCurrencyIssued")
		public DomesticCurrencyIssued getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		public CollateralCriteria build() {
			return this;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder toBuilder() {
			CollateralCriteria.CollateralCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralCriteria.CollateralCriteriaBuilder builder) {
			ofNullable(getAllCriteria()).ifPresent(builder::setAllCriteria);
			ofNullable(getAnyCriteria()).ifPresent(builder::setAnyCriteria);
			ofNullable(getNegativeCriteria()).ifPresent(builder::setNegativeCriteria);
			ofNullable(getCollateralIssuerType()).ifPresent(builder::setCollateralIssuerType);
			ofNullable(getAssetType()).ifPresent(builder::setAssetType);
			ofNullable(getIssuerCountryOfOrigin()).ifPresent(builder::setIssuerCountryOfOrigin);
			ofNullable(getAssetCountryOfOrigin()).ifPresent(builder::setAssetCountryOfOrigin);
			ofNullable(getCurrencyCodeEnum()).ifPresent(builder::setCurrencyCodeEnum);
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
			ofNullable(getIssuerAgencyRating()).ifPresent(builder::setIssuerAgencyRating);
			ofNullable(getSovereignAgencyRating()).ifPresent(builder::setSovereignAgencyRating);
			ofNullable(getAssetAgencyRating()).ifPresent(builder::setAssetAgencyRating);
			ofNullable(getAssetMaturity()).ifPresent(builder::setAssetMaturity);
			ofNullable(getSpecificAsset()).ifPresent(builder::setSpecificAsset);
			ofNullable(getCollateralTaxonomy()).ifPresent(builder::setCollateralTaxonomy);
			ofNullable(getListingExchange()).ifPresent(builder::setListingExchange);
			ofNullable(getListingSector()).ifPresent(builder::setListingSector);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getCounterpartyOwnIssuePermitted()).ifPresent(builder::setCounterpartyOwnIssuePermitted);
			ofNullable(getDomesticCurrencyIssued()).ifPresent(builder::setDomesticCurrencyIssued);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(allCriteria, _that.getAllCriteria())) return false;
			if (!Objects.equals(anyCriteria, _that.getAnyCriteria())) return false;
			if (!Objects.equals(negativeCriteria, _that.getNegativeCriteria())) return false;
			if (!Objects.equals(collateralIssuerType, _that.getCollateralIssuerType())) return false;
			if (!Objects.equals(assetType, _that.getAssetType())) return false;
			if (!Objects.equals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			if (!Objects.equals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			if (!Objects.equals(currencyCodeEnum, _that.getCurrencyCodeEnum())) return false;
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			if (!Objects.equals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			if (!Objects.equals(assetAgencyRating, _that.getAssetAgencyRating())) return false;
			if (!Objects.equals(assetMaturity, _that.getAssetMaturity())) return false;
			if (!Objects.equals(specificAsset, _that.getSpecificAsset())) return false;
			if (!Objects.equals(collateralTaxonomy, _that.getCollateralTaxonomy())) return false;
			if (!Objects.equals(listingExchange, _that.getListingExchange())) return false;
			if (!Objects.equals(listingSector, _that.getListingSector())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allCriteria != null ? allCriteria.hashCode() : 0);
			_result = 31 * _result + (anyCriteria != null ? anyCriteria.hashCode() : 0);
			_result = 31 * _result + (negativeCriteria != null ? negativeCriteria.hashCode() : 0);
			_result = 31 * _result + (collateralIssuerType != null ? collateralIssuerType.hashCode() : 0);
			_result = 31 * _result + (assetType != null ? assetType.hashCode() : 0);
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (currencyCodeEnum != null ? currencyCodeEnum.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			_result = 31 * _result + (assetAgencyRating != null ? assetAgencyRating.hashCode() : 0);
			_result = 31 * _result + (assetMaturity != null ? assetMaturity.hashCode() : 0);
			_result = 31 * _result + (specificAsset != null ? specificAsset.hashCode() : 0);
			_result = 31 * _result + (collateralTaxonomy != null ? collateralTaxonomy.hashCode() : 0);
			_result = 31 * _result + (listingExchange != null ? listingExchange.hashCode() : 0);
			_result = 31 * _result + (listingSector != null ? listingSector.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteria {" +
				"AllCriteria=" + this.allCriteria + ", " +
				"AnyCriteria=" + this.anyCriteria + ", " +
				"NegativeCriteria=" + this.negativeCriteria + ", " +
				"CollateralIssuerType=" + this.collateralIssuerType + ", " +
				"AssetType=" + this.assetType + ", " +
				"IssuerCountryOfOrigin=" + this.issuerCountryOfOrigin + ", " +
				"AssetCountryOfOrigin=" + this.assetCountryOfOrigin + ", " +
				"CurrencyCodeEnum=" + this.currencyCodeEnum + ", " +
				"IssuerName=" + this.issuerName + ", " +
				"IssuerAgencyRating=" + this.issuerAgencyRating + ", " +
				"SovereignAgencyRating=" + this.sovereignAgencyRating + ", " +
				"AssetAgencyRating=" + this.assetAgencyRating + ", " +
				"AssetMaturity=" + this.assetMaturity + ", " +
				"SpecificAsset=" + this.specificAsset + ", " +
				"CollateralTaxonomy=" + this.collateralTaxonomy + ", " +
				"ListingExchange=" + this.listingExchange + ", " +
				"ListingSector=" + this.listingSector + ", " +
				"Index=" + this.index + ", " +
				"CounterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted + ", " +
				"DomesticCurrencyIssued=" + this.domesticCurrencyIssued +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralCriteria  ***********************/
	class CollateralCriteriaBuilderImpl implements CollateralCriteria.CollateralCriteriaBuilder {
	
		protected AllCriteria.AllCriteriaBuilder allCriteria;
		protected AnyCriteria.AnyCriteriaBuilder anyCriteria;
		protected NegativeCriteria.NegativeCriteriaBuilder negativeCriteria;
		protected CollateralIssuerType.CollateralIssuerTypeBuilder collateralIssuerType;
		protected AssetType.AssetTypeBuilder assetType;
		protected IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder issuerCountryOfOrigin;
		protected AssetCountryOfOrigin.AssetCountryOfOriginBuilder assetCountryOfOrigin;
		protected CurrencyCodeEnum currencyCodeEnum;
		protected IssuerName.IssuerNameBuilder issuerName;
		protected IssuerAgencyRating.IssuerAgencyRatingBuilder issuerAgencyRating;
		protected SovereignAgencyRating.SovereignAgencyRatingBuilder sovereignAgencyRating;
		protected AssetAgencyRating.AssetAgencyRatingBuilder assetAgencyRating;
		protected AssetMaturity.AssetMaturityBuilder assetMaturity;
		protected SpecificAsset.SpecificAssetBuilder specificAsset;
		protected CollateralTaxonomy.CollateralTaxonomyBuilder collateralTaxonomy;
		protected ListingExchange.ListingExchangeBuilder listingExchange;
		protected ListingSector.ListingSectorBuilder listingSector;
		protected Index.IndexBuilder index;
		protected CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder counterpartyOwnIssuePermitted;
		protected DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder domesticCurrencyIssued;
		
		@Override
		@RosettaAttribute("AllCriteria")
		@RuneAttribute("AllCriteria")
		public AllCriteria.AllCriteriaBuilder getAllCriteria() {
			return allCriteria;
		}
		
		@Override
		public AllCriteria.AllCriteriaBuilder getOrCreateAllCriteria() {
			AllCriteria.AllCriteriaBuilder result;
			if (allCriteria!=null) {
				result = allCriteria;
			}
			else {
				result = allCriteria = AllCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AnyCriteria")
		@RuneAttribute("AnyCriteria")
		public AnyCriteria.AnyCriteriaBuilder getAnyCriteria() {
			return anyCriteria;
		}
		
		@Override
		public AnyCriteria.AnyCriteriaBuilder getOrCreateAnyCriteria() {
			AnyCriteria.AnyCriteriaBuilder result;
			if (anyCriteria!=null) {
				result = anyCriteria;
			}
			else {
				result = anyCriteria = AnyCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NegativeCriteria")
		@RuneAttribute("NegativeCriteria")
		public NegativeCriteria.NegativeCriteriaBuilder getNegativeCriteria() {
			return negativeCriteria;
		}
		
		@Override
		public NegativeCriteria.NegativeCriteriaBuilder getOrCreateNegativeCriteria() {
			NegativeCriteria.NegativeCriteriaBuilder result;
			if (negativeCriteria!=null) {
				result = negativeCriteria;
			}
			else {
				result = negativeCriteria = NegativeCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CollateralIssuerType")
		@RuneAttribute("CollateralIssuerType")
		public CollateralIssuerType.CollateralIssuerTypeBuilder getCollateralIssuerType() {
			return collateralIssuerType;
		}
		
		@Override
		public CollateralIssuerType.CollateralIssuerTypeBuilder getOrCreateCollateralIssuerType() {
			CollateralIssuerType.CollateralIssuerTypeBuilder result;
			if (collateralIssuerType!=null) {
				result = collateralIssuerType;
			}
			else {
				result = collateralIssuerType = CollateralIssuerType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AssetType")
		@RuneAttribute("AssetType")
		public AssetType.AssetTypeBuilder getAssetType() {
			return assetType;
		}
		
		@Override
		public AssetType.AssetTypeBuilder getOrCreateAssetType() {
			AssetType.AssetTypeBuilder result;
			if (assetType!=null) {
				result = assetType;
			}
			else {
				result = assetType = AssetType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("IssuerCountryOfOrigin")
		@RuneAttribute("IssuerCountryOfOrigin")
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		@Override
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder getOrCreateIssuerCountryOfOrigin() {
			IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder result;
			if (issuerCountryOfOrigin!=null) {
				result = issuerCountryOfOrigin;
			}
			else {
				result = issuerCountryOfOrigin = IssuerCountryOfOrigin.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AssetCountryOfOrigin")
		@RuneAttribute("AssetCountryOfOrigin")
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder getAssetCountryOfOrigin() {
			return assetCountryOfOrigin;
		}
		
		@Override
		public AssetCountryOfOrigin.AssetCountryOfOriginBuilder getOrCreateAssetCountryOfOrigin() {
			AssetCountryOfOrigin.AssetCountryOfOriginBuilder result;
			if (assetCountryOfOrigin!=null) {
				result = assetCountryOfOrigin;
			}
			else {
				result = assetCountryOfOrigin = AssetCountryOfOrigin.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CurrencyCodeEnum")
		@RuneAttribute("CurrencyCodeEnum")
		public CurrencyCodeEnum getCurrencyCodeEnum() {
			return currencyCodeEnum;
		}
		
		@Override
		@RosettaAttribute("IssuerName")
		@RuneAttribute("IssuerName")
		public IssuerName.IssuerNameBuilder getIssuerName() {
			return issuerName;
		}
		
		@Override
		public IssuerName.IssuerNameBuilder getOrCreateIssuerName() {
			IssuerName.IssuerNameBuilder result;
			if (issuerName!=null) {
				result = issuerName;
			}
			else {
				result = issuerName = IssuerName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("IssuerAgencyRating")
		@RuneAttribute("IssuerAgencyRating")
		public IssuerAgencyRating.IssuerAgencyRatingBuilder getIssuerAgencyRating() {
			return issuerAgencyRating;
		}
		
		@Override
		public IssuerAgencyRating.IssuerAgencyRatingBuilder getOrCreateIssuerAgencyRating() {
			IssuerAgencyRating.IssuerAgencyRatingBuilder result;
			if (issuerAgencyRating!=null) {
				result = issuerAgencyRating;
			}
			else {
				result = issuerAgencyRating = IssuerAgencyRating.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SovereignAgencyRating")
		@RuneAttribute("SovereignAgencyRating")
		public SovereignAgencyRating.SovereignAgencyRatingBuilder getSovereignAgencyRating() {
			return sovereignAgencyRating;
		}
		
		@Override
		public SovereignAgencyRating.SovereignAgencyRatingBuilder getOrCreateSovereignAgencyRating() {
			SovereignAgencyRating.SovereignAgencyRatingBuilder result;
			if (sovereignAgencyRating!=null) {
				result = sovereignAgencyRating;
			}
			else {
				result = sovereignAgencyRating = SovereignAgencyRating.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AssetAgencyRating")
		@RuneAttribute("AssetAgencyRating")
		public AssetAgencyRating.AssetAgencyRatingBuilder getAssetAgencyRating() {
			return assetAgencyRating;
		}
		
		@Override
		public AssetAgencyRating.AssetAgencyRatingBuilder getOrCreateAssetAgencyRating() {
			AssetAgencyRating.AssetAgencyRatingBuilder result;
			if (assetAgencyRating!=null) {
				result = assetAgencyRating;
			}
			else {
				result = assetAgencyRating = AssetAgencyRating.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AssetMaturity")
		@RuneAttribute("AssetMaturity")
		public AssetMaturity.AssetMaturityBuilder getAssetMaturity() {
			return assetMaturity;
		}
		
		@Override
		public AssetMaturity.AssetMaturityBuilder getOrCreateAssetMaturity() {
			AssetMaturity.AssetMaturityBuilder result;
			if (assetMaturity!=null) {
				result = assetMaturity;
			}
			else {
				result = assetMaturity = AssetMaturity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SpecificAsset")
		@RuneAttribute("SpecificAsset")
		public SpecificAsset.SpecificAssetBuilder getSpecificAsset() {
			return specificAsset;
		}
		
		@Override
		public SpecificAsset.SpecificAssetBuilder getOrCreateSpecificAsset() {
			SpecificAsset.SpecificAssetBuilder result;
			if (specificAsset!=null) {
				result = specificAsset;
			}
			else {
				result = specificAsset = SpecificAsset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CollateralTaxonomy")
		@RuneAttribute("CollateralTaxonomy")
		public CollateralTaxonomy.CollateralTaxonomyBuilder getCollateralTaxonomy() {
			return collateralTaxonomy;
		}
		
		@Override
		public CollateralTaxonomy.CollateralTaxonomyBuilder getOrCreateCollateralTaxonomy() {
			CollateralTaxonomy.CollateralTaxonomyBuilder result;
			if (collateralTaxonomy!=null) {
				result = collateralTaxonomy;
			}
			else {
				result = collateralTaxonomy = CollateralTaxonomy.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ListingExchange")
		@RuneAttribute("ListingExchange")
		public ListingExchange.ListingExchangeBuilder getListingExchange() {
			return listingExchange;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder getOrCreateListingExchange() {
			ListingExchange.ListingExchangeBuilder result;
			if (listingExchange!=null) {
				result = listingExchange;
			}
			else {
				result = listingExchange = ListingExchange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ListingSector")
		@RuneAttribute("ListingSector")
		public ListingSector.ListingSectorBuilder getListingSector() {
			return listingSector;
		}
		
		@Override
		public ListingSector.ListingSectorBuilder getOrCreateListingSector() {
			ListingSector.ListingSectorBuilder result;
			if (listingSector!=null) {
				result = listingSector;
			}
			else {
				result = listingSector = ListingSector.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public Index.IndexBuilder getIndex() {
			return index;
		}
		
		@Override
		public Index.IndexBuilder getOrCreateIndex() {
			Index.IndexBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = Index.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CounterpartyOwnIssuePermitted")
		@RuneAttribute("CounterpartyOwnIssuePermitted")
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder getOrCreateCounterpartyOwnIssuePermitted() {
			CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder result;
			if (counterpartyOwnIssuePermitted!=null) {
				result = counterpartyOwnIssuePermitted;
			}
			else {
				result = counterpartyOwnIssuePermitted = CounterpartyOwnIssuePermitted.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DomesticCurrencyIssued")
		@RuneAttribute("DomesticCurrencyIssued")
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder getOrCreateDomesticCurrencyIssued() {
			DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder result;
			if (domesticCurrencyIssued!=null) {
				result = domesticCurrencyIssued;
			}
			else {
				result = domesticCurrencyIssued = DomesticCurrencyIssued.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("AllCriteria")
		@RuneAttribute("AllCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder setAllCriteria(AllCriteria _allCriteria) {
			this.allCriteria = _allCriteria == null ? null : _allCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("AnyCriteria")
		@RuneAttribute("AnyCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder setAnyCriteria(AnyCriteria _anyCriteria) {
			this.anyCriteria = _anyCriteria == null ? null : _anyCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("NegativeCriteria")
		@RuneAttribute("NegativeCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder setNegativeCriteria(NegativeCriteria _negativeCriteria) {
			this.negativeCriteria = _negativeCriteria == null ? null : _negativeCriteria.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CollateralIssuerType")
		@RuneAttribute("CollateralIssuerType")
		public CollateralCriteria.CollateralCriteriaBuilder setCollateralIssuerType(CollateralIssuerType _collateralIssuerType) {
			this.collateralIssuerType = _collateralIssuerType == null ? null : _collateralIssuerType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("AssetType")
		@RuneAttribute("AssetType")
		public CollateralCriteria.CollateralCriteriaBuilder setAssetType(AssetType _assetType) {
			this.assetType = _assetType == null ? null : _assetType.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("IssuerCountryOfOrigin")
		@RuneAttribute("IssuerCountryOfOrigin")
		public CollateralCriteria.CollateralCriteriaBuilder setIssuerCountryOfOrigin(IssuerCountryOfOrigin _issuerCountryOfOrigin) {
			this.issuerCountryOfOrigin = _issuerCountryOfOrigin == null ? null : _issuerCountryOfOrigin.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("AssetCountryOfOrigin")
		@RuneAttribute("AssetCountryOfOrigin")
		public CollateralCriteria.CollateralCriteriaBuilder setAssetCountryOfOrigin(AssetCountryOfOrigin _assetCountryOfOrigin) {
			this.assetCountryOfOrigin = _assetCountryOfOrigin == null ? null : _assetCountryOfOrigin.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CurrencyCodeEnum")
		@RuneAttribute("CurrencyCodeEnum")
		public CollateralCriteria.CollateralCriteriaBuilder setCurrencyCodeEnum(CurrencyCodeEnum _currencyCodeEnum) {
			this.currencyCodeEnum = _currencyCodeEnum == null ? null : _currencyCodeEnum;
			return this;
		}
		
		@Override
		@RosettaAttribute("IssuerName")
		@RuneAttribute("IssuerName")
		public CollateralCriteria.CollateralCriteriaBuilder setIssuerName(IssuerName _issuerName) {
			this.issuerName = _issuerName == null ? null : _issuerName.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("IssuerAgencyRating")
		@RuneAttribute("IssuerAgencyRating")
		public CollateralCriteria.CollateralCriteriaBuilder setIssuerAgencyRating(IssuerAgencyRating _issuerAgencyRating) {
			this.issuerAgencyRating = _issuerAgencyRating == null ? null : _issuerAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("SovereignAgencyRating")
		@RuneAttribute("SovereignAgencyRating")
		public CollateralCriteria.CollateralCriteriaBuilder setSovereignAgencyRating(SovereignAgencyRating _sovereignAgencyRating) {
			this.sovereignAgencyRating = _sovereignAgencyRating == null ? null : _sovereignAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("AssetAgencyRating")
		@RuneAttribute("AssetAgencyRating")
		public CollateralCriteria.CollateralCriteriaBuilder setAssetAgencyRating(AssetAgencyRating _assetAgencyRating) {
			this.assetAgencyRating = _assetAgencyRating == null ? null : _assetAgencyRating.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("AssetMaturity")
		@RuneAttribute("AssetMaturity")
		public CollateralCriteria.CollateralCriteriaBuilder setAssetMaturity(AssetMaturity _assetMaturity) {
			this.assetMaturity = _assetMaturity == null ? null : _assetMaturity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("SpecificAsset")
		@RuneAttribute("SpecificAsset")
		public CollateralCriteria.CollateralCriteriaBuilder setSpecificAsset(SpecificAsset _specificAsset) {
			this.specificAsset = _specificAsset == null ? null : _specificAsset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CollateralTaxonomy")
		@RuneAttribute("CollateralTaxonomy")
		public CollateralCriteria.CollateralCriteriaBuilder setCollateralTaxonomy(CollateralTaxonomy _collateralTaxonomy) {
			this.collateralTaxonomy = _collateralTaxonomy == null ? null : _collateralTaxonomy.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("ListingExchange")
		@RuneAttribute("ListingExchange")
		public CollateralCriteria.CollateralCriteriaBuilder setListingExchange(ListingExchange _listingExchange) {
			this.listingExchange = _listingExchange == null ? null : _listingExchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("ListingSector")
		@RuneAttribute("ListingSector")
		public CollateralCriteria.CollateralCriteriaBuilder setListingSector(ListingSector _listingSector) {
			this.listingSector = _listingSector == null ? null : _listingSector.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Index")
		@RuneAttribute("Index")
		public CollateralCriteria.CollateralCriteriaBuilder setIndex(Index _index) {
			this.index = _index == null ? null : _index.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("CounterpartyOwnIssuePermitted")
		@RuneAttribute("CounterpartyOwnIssuePermitted")
		public CollateralCriteria.CollateralCriteriaBuilder setCounterpartyOwnIssuePermitted(CounterpartyOwnIssuePermitted _counterpartyOwnIssuePermitted) {
			this.counterpartyOwnIssuePermitted = _counterpartyOwnIssuePermitted == null ? null : _counterpartyOwnIssuePermitted.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("DomesticCurrencyIssued")
		@RuneAttribute("DomesticCurrencyIssued")
		public CollateralCriteria.CollateralCriteriaBuilder setDomesticCurrencyIssued(DomesticCurrencyIssued _domesticCurrencyIssued) {
			this.domesticCurrencyIssued = _domesticCurrencyIssued == null ? null : _domesticCurrencyIssued.toBuilder();
			return this;
		}
		
		@Override
		public CollateralCriteria build() {
			return new CollateralCriteria.CollateralCriteriaImpl(this);
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder prune() {
			if (allCriteria!=null && !allCriteria.prune().hasData()) allCriteria = null;
			if (anyCriteria!=null && !anyCriteria.prune().hasData()) anyCriteria = null;
			if (negativeCriteria!=null && !negativeCriteria.prune().hasData()) negativeCriteria = null;
			if (collateralIssuerType!=null && !collateralIssuerType.prune().hasData()) collateralIssuerType = null;
			if (assetType!=null && !assetType.prune().hasData()) assetType = null;
			if (issuerCountryOfOrigin!=null && !issuerCountryOfOrigin.prune().hasData()) issuerCountryOfOrigin = null;
			if (assetCountryOfOrigin!=null && !assetCountryOfOrigin.prune().hasData()) assetCountryOfOrigin = null;
			if (issuerName!=null && !issuerName.prune().hasData()) issuerName = null;
			if (issuerAgencyRating!=null && !issuerAgencyRating.prune().hasData()) issuerAgencyRating = null;
			if (sovereignAgencyRating!=null && !sovereignAgencyRating.prune().hasData()) sovereignAgencyRating = null;
			if (assetAgencyRating!=null && !assetAgencyRating.prune().hasData()) assetAgencyRating = null;
			if (assetMaturity!=null && !assetMaturity.prune().hasData()) assetMaturity = null;
			if (specificAsset!=null && !specificAsset.prune().hasData()) specificAsset = null;
			if (collateralTaxonomy!=null && !collateralTaxonomy.prune().hasData()) collateralTaxonomy = null;
			if (listingExchange!=null && !listingExchange.prune().hasData()) listingExchange = null;
			if (listingSector!=null && !listingSector.prune().hasData()) listingSector = null;
			if (index!=null && !index.prune().hasData()) index = null;
			if (counterpartyOwnIssuePermitted!=null && !counterpartyOwnIssuePermitted.prune().hasData()) counterpartyOwnIssuePermitted = null;
			if (domesticCurrencyIssued!=null && !domesticCurrencyIssued.prune().hasData()) domesticCurrencyIssued = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllCriteria()!=null && getAllCriteria().hasData()) return true;
			if (getAnyCriteria()!=null && getAnyCriteria().hasData()) return true;
			if (getNegativeCriteria()!=null && getNegativeCriteria().hasData()) return true;
			if (getCollateralIssuerType()!=null && getCollateralIssuerType().hasData()) return true;
			if (getAssetType()!=null && getAssetType().hasData()) return true;
			if (getIssuerCountryOfOrigin()!=null && getIssuerCountryOfOrigin().hasData()) return true;
			if (getAssetCountryOfOrigin()!=null && getAssetCountryOfOrigin().hasData()) return true;
			if (getCurrencyCodeEnum()!=null) return true;
			if (getIssuerName()!=null && getIssuerName().hasData()) return true;
			if (getIssuerAgencyRating()!=null && getIssuerAgencyRating().hasData()) return true;
			if (getSovereignAgencyRating()!=null && getSovereignAgencyRating().hasData()) return true;
			if (getAssetAgencyRating()!=null && getAssetAgencyRating().hasData()) return true;
			if (getAssetMaturity()!=null && getAssetMaturity().hasData()) return true;
			if (getSpecificAsset()!=null && getSpecificAsset().hasData()) return true;
			if (getCollateralTaxonomy()!=null && getCollateralTaxonomy().hasData()) return true;
			if (getListingExchange()!=null && getListingExchange().hasData()) return true;
			if (getListingSector()!=null && getListingSector().hasData()) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			if (getCounterpartyOwnIssuePermitted()!=null && getCounterpartyOwnIssuePermitted().hasData()) return true;
			if (getDomesticCurrencyIssued()!=null && getDomesticCurrencyIssued().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralCriteria.CollateralCriteriaBuilder o = (CollateralCriteria.CollateralCriteriaBuilder) other;
			
			merger.mergeRosetta(getAllCriteria(), o.getAllCriteria(), this::setAllCriteria);
			merger.mergeRosetta(getAnyCriteria(), o.getAnyCriteria(), this::setAnyCriteria);
			merger.mergeRosetta(getNegativeCriteria(), o.getNegativeCriteria(), this::setNegativeCriteria);
			merger.mergeRosetta(getCollateralIssuerType(), o.getCollateralIssuerType(), this::setCollateralIssuerType);
			merger.mergeRosetta(getAssetType(), o.getAssetType(), this::setAssetType);
			merger.mergeRosetta(getIssuerCountryOfOrigin(), o.getIssuerCountryOfOrigin(), this::setIssuerCountryOfOrigin);
			merger.mergeRosetta(getAssetCountryOfOrigin(), o.getAssetCountryOfOrigin(), this::setAssetCountryOfOrigin);
			merger.mergeRosetta(getIssuerName(), o.getIssuerName(), this::setIssuerName);
			merger.mergeRosetta(getIssuerAgencyRating(), o.getIssuerAgencyRating(), this::setIssuerAgencyRating);
			merger.mergeRosetta(getSovereignAgencyRating(), o.getSovereignAgencyRating(), this::setSovereignAgencyRating);
			merger.mergeRosetta(getAssetAgencyRating(), o.getAssetAgencyRating(), this::setAssetAgencyRating);
			merger.mergeRosetta(getAssetMaturity(), o.getAssetMaturity(), this::setAssetMaturity);
			merger.mergeRosetta(getSpecificAsset(), o.getSpecificAsset(), this::setSpecificAsset);
			merger.mergeRosetta(getCollateralTaxonomy(), o.getCollateralTaxonomy(), this::setCollateralTaxonomy);
			merger.mergeRosetta(getListingExchange(), o.getListingExchange(), this::setListingExchange);
			merger.mergeRosetta(getListingSector(), o.getListingSector(), this::setListingSector);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			merger.mergeRosetta(getCounterpartyOwnIssuePermitted(), o.getCounterpartyOwnIssuePermitted(), this::setCounterpartyOwnIssuePermitted);
			merger.mergeRosetta(getDomesticCurrencyIssued(), o.getDomesticCurrencyIssued(), this::setDomesticCurrencyIssued);
			
			merger.mergeBasic(getCurrencyCodeEnum(), o.getCurrencyCodeEnum(), this::setCurrencyCodeEnum);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(allCriteria, _that.getAllCriteria())) return false;
			if (!Objects.equals(anyCriteria, _that.getAnyCriteria())) return false;
			if (!Objects.equals(negativeCriteria, _that.getNegativeCriteria())) return false;
			if (!Objects.equals(collateralIssuerType, _that.getCollateralIssuerType())) return false;
			if (!Objects.equals(assetType, _that.getAssetType())) return false;
			if (!Objects.equals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			if (!Objects.equals(assetCountryOfOrigin, _that.getAssetCountryOfOrigin())) return false;
			if (!Objects.equals(currencyCodeEnum, _that.getCurrencyCodeEnum())) return false;
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerAgencyRating, _that.getIssuerAgencyRating())) return false;
			if (!Objects.equals(sovereignAgencyRating, _that.getSovereignAgencyRating())) return false;
			if (!Objects.equals(assetAgencyRating, _that.getAssetAgencyRating())) return false;
			if (!Objects.equals(assetMaturity, _that.getAssetMaturity())) return false;
			if (!Objects.equals(specificAsset, _that.getSpecificAsset())) return false;
			if (!Objects.equals(collateralTaxonomy, _that.getCollateralTaxonomy())) return false;
			if (!Objects.equals(listingExchange, _that.getListingExchange())) return false;
			if (!Objects.equals(listingSector, _that.getListingSector())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allCriteria != null ? allCriteria.hashCode() : 0);
			_result = 31 * _result + (anyCriteria != null ? anyCriteria.hashCode() : 0);
			_result = 31 * _result + (negativeCriteria != null ? negativeCriteria.hashCode() : 0);
			_result = 31 * _result + (collateralIssuerType != null ? collateralIssuerType.hashCode() : 0);
			_result = 31 * _result + (assetType != null ? assetType.hashCode() : 0);
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (assetCountryOfOrigin != null ? assetCountryOfOrigin.hashCode() : 0);
			_result = 31 * _result + (currencyCodeEnum != null ? currencyCodeEnum.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerAgencyRating != null ? issuerAgencyRating.hashCode() : 0);
			_result = 31 * _result + (sovereignAgencyRating != null ? sovereignAgencyRating.hashCode() : 0);
			_result = 31 * _result + (assetAgencyRating != null ? assetAgencyRating.hashCode() : 0);
			_result = 31 * _result + (assetMaturity != null ? assetMaturity.hashCode() : 0);
			_result = 31 * _result + (specificAsset != null ? specificAsset.hashCode() : 0);
			_result = 31 * _result + (collateralTaxonomy != null ? collateralTaxonomy.hashCode() : 0);
			_result = 31 * _result + (listingExchange != null ? listingExchange.hashCode() : 0);
			_result = 31 * _result + (listingSector != null ? listingSector.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralCriteriaBuilder {" +
				"AllCriteria=" + this.allCriteria + ", " +
				"AnyCriteria=" + this.anyCriteria + ", " +
				"NegativeCriteria=" + this.negativeCriteria + ", " +
				"CollateralIssuerType=" + this.collateralIssuerType + ", " +
				"AssetType=" + this.assetType + ", " +
				"IssuerCountryOfOrigin=" + this.issuerCountryOfOrigin + ", " +
				"AssetCountryOfOrigin=" + this.assetCountryOfOrigin + ", " +
				"CurrencyCodeEnum=" + this.currencyCodeEnum + ", " +
				"IssuerName=" + this.issuerName + ", " +
				"IssuerAgencyRating=" + this.issuerAgencyRating + ", " +
				"SovereignAgencyRating=" + this.sovereignAgencyRating + ", " +
				"AssetAgencyRating=" + this.assetAgencyRating + ", " +
				"AssetMaturity=" + this.assetMaturity + ", " +
				"SpecificAsset=" + this.specificAsset + ", " +
				"CollateralTaxonomy=" + this.collateralTaxonomy + ", " +
				"ListingExchange=" + this.listingExchange + ", " +
				"ListingSector=" + this.listingSector + ", " +
				"Index=" + this.index + ", " +
				"CounterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted + ", " +
				"DomesticCurrencyIssued=" + this.domesticCurrencyIssued +
			'}';
		}
	}
}
