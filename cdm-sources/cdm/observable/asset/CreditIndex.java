package cdm.observable.asset;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.CreditIndex.CreditIndexBuilder;
import cdm.observable.asset.CreditIndex.CreditIndexBuilderImpl;
import cdm.observable.asset.CreditIndex.CreditIndexImpl;
import cdm.observable.asset.IndexBase;
import cdm.observable.asset.IndexBase.IndexBaseBuilder;
import cdm.observable.asset.IndexBase.IndexBaseBuilderImpl;
import cdm.observable.asset.IndexBase.IndexBaseImpl;
import cdm.observable.asset.meta.CreditIndexMeta;
import cdm.product.asset.CreditSeniorityEnum;
import cdm.product.asset.IndexAnnexSourceEnum;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceInformation.ReferenceInformationBuilder;
import cdm.product.asset.SettledEntityMatrix;
import cdm.product.asset.SettledEntityMatrix.SettledEntityMatrixBuilder;
import cdm.product.asset.Tranche;
import cdm.product.asset.Tranche.TrancheBuilder;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of an index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
 * @version 6.0.0
 */
@RosettaDataType(value="CreditIndex", builder=CreditIndex.CreditIndexBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CreditIndex", model="Just another Rosetta model", builder=CreditIndex.CreditIndexBuilderImpl.class, version="6.0.0")
public interface CreditIndex extends IndexBase, GlobalKey {

	CreditIndexMeta metaData = new CreditIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A CDS index series identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexSeries();
	/**
	 * A CDS index series version identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexAnnexVersion();
	/**
	 * A CDS index series annex date.
	 */
	Date getIndexAnnexDate();
	/**
	 * A CDS index series annex source.
	 */
	FieldWithMetaIndexAnnexSourceEnum getIndexAnnexSource();
	/**
	 * Excluded reference entity.
	 */
	List<? extends ReferenceInformation> getExcludedReferenceEntity();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();
	/**
	 * Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
	 */
	SettledEntityMatrix getSettledEntityMatrix();
	/**
	 * Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
	 */
	BigDecimal getIndexFactor();
	/**
	 * Seniority of debt instruments comprising the index.
	 */
	CreditSeniorityEnum getSeniority();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	CreditIndex build();
	
	CreditIndex.CreditIndexBuilder toBuilder();
	
	static CreditIndex.CreditIndexBuilder builder() {
		return new CreditIndex.CreditIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditIndex> getType() {
		return CreditIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("provider"), processor, LegalEntity.class, getProvider());
		processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
		processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
		processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
		processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
		processRosetta(path.newSubPath("indexAnnexSource"), processor, FieldWithMetaIndexAnnexSourceEnum.class, getIndexAnnexSource());
		processRosetta(path.newSubPath("excludedReferenceEntity"), processor, ReferenceInformation.class, getExcludedReferenceEntity());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
		processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.class, getSettledEntityMatrix());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processor.processBasic(path.newSubPath("seniority"), CreditSeniorityEnum.class, getSeniority(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditIndexBuilder extends CreditIndex, IndexBase.IndexBaseBuilder, GlobalKey.GlobalKeyBuilder {
		FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder getOrCreateIndexAnnexSource();
		@Override
		FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder getIndexAnnexSource();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateExcludedReferenceEntity(int _index);
		@Override
		List<? extends ReferenceInformation.ReferenceInformationBuilder> getExcludedReferenceEntity();
		Tranche.TrancheBuilder getOrCreateTranche();
		@Override
		Tranche.TrancheBuilder getTranche();
		SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix();
		@Override
		SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		@Override
		CreditIndex.CreditIndexBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		CreditIndex.CreditIndexBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		CreditIndex.CreditIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		CreditIndex.CreditIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		CreditIndex.CreditIndexBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		CreditIndex.CreditIndexBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		CreditIndex.CreditIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		CreditIndex.CreditIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		CreditIndex.CreditIndexBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		CreditIndex.CreditIndexBuilder setExchange(LegalEntity exchange);
		@Override
		CreditIndex.CreditIndexBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		CreditIndex.CreditIndexBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		CreditIndex.CreditIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		CreditIndex.CreditIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		CreditIndex.CreditIndexBuilder setName(FieldWithMetaString name);
		@Override
		CreditIndex.CreditIndexBuilder setNameValue(String name);
		@Override
		CreditIndex.CreditIndexBuilder setProvider(LegalEntity provider);
		@Override
		CreditIndex.CreditIndexBuilder setAssetClass(AssetClassEnum assetClass);
		CreditIndex.CreditIndexBuilder setIndexSeries(Integer indexSeries);
		CreditIndex.CreditIndexBuilder setIndexAnnexVersion(Integer indexAnnexVersion);
		CreditIndex.CreditIndexBuilder setIndexAnnexDate(Date indexAnnexDate);
		CreditIndex.CreditIndexBuilder setIndexAnnexSource(FieldWithMetaIndexAnnexSourceEnum indexAnnexSource);
		CreditIndex.CreditIndexBuilder setIndexAnnexSourceValue(IndexAnnexSourceEnum indexAnnexSource);
		CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(ReferenceInformation excludedReferenceEntity);
		CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(ReferenceInformation excludedReferenceEntity, int _idx);
		CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(List<? extends ReferenceInformation> excludedReferenceEntity);
		CreditIndex.CreditIndexBuilder setExcludedReferenceEntity(List<? extends ReferenceInformation> excludedReferenceEntity);
		CreditIndex.CreditIndexBuilder setTranche(Tranche tranche);
		CreditIndex.CreditIndexBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix);
		CreditIndex.CreditIndexBuilder setIndexFactor(BigDecimal indexFactor);
		CreditIndex.CreditIndexBuilder setSeniority(CreditSeniorityEnum seniority);
		CreditIndex.CreditIndexBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("provider"), processor, LegalEntity.LegalEntityBuilder.class, getProvider());
			processor.processBasic(path.newSubPath("assetClass"), AssetClassEnum.class, getAssetClass(), this);
			processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
			processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
			processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
			processRosetta(path.newSubPath("indexAnnexSource"), processor, FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder.class, getIndexAnnexSource());
			processRosetta(path.newSubPath("excludedReferenceEntity"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getExcludedReferenceEntity());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
			processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.SettledEntityMatrixBuilder.class, getSettledEntityMatrix());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processor.processBasic(path.newSubPath("seniority"), CreditSeniorityEnum.class, getSeniority(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		CreditIndex.CreditIndexBuilder prune();
	}

	/*********************** Immutable Implementation of CreditIndex  ***********************/
	class CreditIndexImpl extends IndexBase.IndexBaseImpl implements CreditIndex {
		private final Integer indexSeries;
		private final Integer indexAnnexVersion;
		private final Date indexAnnexDate;
		private final FieldWithMetaIndexAnnexSourceEnum indexAnnexSource;
		private final List<? extends ReferenceInformation> excludedReferenceEntity;
		private final Tranche tranche;
		private final SettledEntityMatrix settledEntityMatrix;
		private final BigDecimal indexFactor;
		private final CreditSeniorityEnum seniority;
		private final MetaFields meta;
		
		protected CreditIndexImpl(CreditIndex.CreditIndexBuilder builder) {
			super(builder);
			this.indexSeries = builder.getIndexSeries();
			this.indexAnnexVersion = builder.getIndexAnnexVersion();
			this.indexAnnexDate = builder.getIndexAnnexDate();
			this.indexAnnexSource = ofNullable(builder.getIndexAnnexSource()).map(f->f.build()).orElse(null);
			this.excludedReferenceEntity = ofNullable(builder.getExcludedReferenceEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
			this.settledEntityMatrix = ofNullable(builder.getSettledEntityMatrix()).map(f->f.build()).orElse(null);
			this.indexFactor = builder.getIndexFactor();
			this.seniority = builder.getSeniority();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		@RuneAttribute("indexAnnexDate")
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		@RuneAttribute("indexAnnexSource")
		public FieldWithMetaIndexAnnexSourceEnum getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@RuneAttribute("excludedReferenceEntity")
		public List<? extends ReferenceInformation> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		@RuneAttribute("settledEntityMatrix")
		public SettledEntityMatrix getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@RuneAttribute("seniority")
		public CreditSeniorityEnum getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CreditIndex build() {
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder toBuilder() {
			CreditIndex.CreditIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditIndex.CreditIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIndexSeries()).ifPresent(builder::setIndexSeries);
			ofNullable(getIndexAnnexVersion()).ifPresent(builder::setIndexAnnexVersion);
			ofNullable(getIndexAnnexDate()).ifPresent(builder::setIndexAnnexDate);
			ofNullable(getIndexAnnexSource()).ifPresent(builder::setIndexAnnexSource);
			ofNullable(getExcludedReferenceEntity()).ifPresent(builder::setExcludedReferenceEntity);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getSettledEntityMatrix()).ifPresent(builder::setSettledEntityMatrix);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditIndex _that = getType().cast(o);
		
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditIndex {" +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditIndex  ***********************/
	class CreditIndexBuilderImpl extends IndexBase.IndexBaseBuilderImpl implements CreditIndex.CreditIndexBuilder {
	
		protected Integer indexSeries;
		protected Integer indexAnnexVersion;
		protected Date indexAnnexDate;
		protected FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder indexAnnexSource;
		protected List<ReferenceInformation.ReferenceInformationBuilder> excludedReferenceEntity = new ArrayList<>();
		protected Tranche.TrancheBuilder tranche;
		protected SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix;
		protected BigDecimal indexFactor;
		protected CreditSeniorityEnum seniority;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("indexSeries")
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		@RuneAttribute("indexAnnexDate")
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		@RuneAttribute("indexAnnexSource")
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder getOrCreateIndexAnnexSource() {
			FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder result;
			if (indexAnnexSource!=null) {
				result = indexAnnexSource;
			}
			else {
				result = indexAnnexSource = FieldWithMetaIndexAnnexSourceEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@RuneAttribute("excludedReferenceEntity")
		public List<? extends ReferenceInformation.ReferenceInformationBuilder> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateExcludedReferenceEntity(int _index) {
		
			if (excludedReferenceEntity==null) {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			ReferenceInformation.ReferenceInformationBuilder result;
			return getIndex(excludedReferenceEntity, _index, () -> {
						ReferenceInformation.ReferenceInformationBuilder newExcludedReferenceEntity = ReferenceInformation.builder();
						return newExcludedReferenceEntity;
					});
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		@RuneAttribute("settledEntityMatrix")
		public SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix() {
			SettledEntityMatrix.SettledEntityMatrixBuilder result;
			if (settledEntityMatrix!=null) {
				result = settledEntityMatrix;
			}
			else {
				result = settledEntityMatrix = SettledEntityMatrix.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@RuneAttribute("seniority")
		public CreditSeniorityEnum getSeniority() {
			return seniority;
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
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public CreditIndex.CreditIndexBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public CreditIndex.CreditIndexBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public CreditIndex.CreditIndexBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public CreditIndex.CreditIndexBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public CreditIndex.CreditIndexBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public CreditIndex.CreditIndexBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public CreditIndex.CreditIndexBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public CreditIndex.CreditIndexBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public CreditIndex.CreditIndexBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public CreditIndex.CreditIndexBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public CreditIndex.CreditIndexBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		@RosettaAttribute("name")
		@RuneAttribute("name")
		public CreditIndex.CreditIndexBuilder setName(FieldWithMetaString _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder setNameValue(String _name) {
			this.getOrCreateName().setValue(_name);
			return this;
		}
		
		@Override
		@RosettaAttribute("provider")
		@RuneAttribute("provider")
		public CreditIndex.CreditIndexBuilder setProvider(LegalEntity _provider) {
			this.provider = _provider == null ? null : _provider.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@RuneAttribute("assetClass")
		public CreditIndex.CreditIndexBuilder setAssetClass(AssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		@RuneAttribute("indexSeries")
		public CreditIndex.CreditIndexBuilder setIndexSeries(Integer _indexSeries) {
			this.indexSeries = _indexSeries == null ? null : _indexSeries;
			return this;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@RuneAttribute("indexAnnexVersion")
		public CreditIndex.CreditIndexBuilder setIndexAnnexVersion(Integer _indexAnnexVersion) {
			this.indexAnnexVersion = _indexAnnexVersion == null ? null : _indexAnnexVersion;
			return this;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		@RuneAttribute("indexAnnexDate")
		public CreditIndex.CreditIndexBuilder setIndexAnnexDate(Date _indexAnnexDate) {
			this.indexAnnexDate = _indexAnnexDate == null ? null : _indexAnnexDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		@RuneAttribute("indexAnnexSource")
		public CreditIndex.CreditIndexBuilder setIndexAnnexSource(FieldWithMetaIndexAnnexSourceEnum _indexAnnexSource) {
			this.indexAnnexSource = _indexAnnexSource == null ? null : _indexAnnexSource.toBuilder();
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder setIndexAnnexSourceValue(IndexAnnexSourceEnum _indexAnnexSource) {
			this.getOrCreateIndexAnnexSource().setValue(_indexAnnexSource);
			return this;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@RuneAttribute("excludedReferenceEntity")
		public CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(ReferenceInformation _excludedReferenceEntity) {
			if (_excludedReferenceEntity != null) {
				this.excludedReferenceEntity.add(_excludedReferenceEntity.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(ReferenceInformation _excludedReferenceEntity, int _idx) {
			getIndex(this.excludedReferenceEntity, _idx, () -> _excludedReferenceEntity.toBuilder());
			return this;
		}
		
		@Override 
		public CreditIndex.CreditIndexBuilder addExcludedReferenceEntity(List<? extends ReferenceInformation> excludedReferenceEntitys) {
			if (excludedReferenceEntitys != null) {
				for (final ReferenceInformation toAdd : excludedReferenceEntitys) {
					this.excludedReferenceEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("excludedReferenceEntity")
		public CreditIndex.CreditIndexBuilder setExcludedReferenceEntity(List<? extends ReferenceInformation> excludedReferenceEntitys) {
			if (excludedReferenceEntitys == null) {
				this.excludedReferenceEntity = new ArrayList<>();
			} else {
				this.excludedReferenceEntity = excludedReferenceEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public CreditIndex.CreditIndexBuilder setTranche(Tranche _tranche) {
			this.tranche = _tranche == null ? null : _tranche.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		@RuneAttribute("settledEntityMatrix")
		public CreditIndex.CreditIndexBuilder setSettledEntityMatrix(SettledEntityMatrix _settledEntityMatrix) {
			this.settledEntityMatrix = _settledEntityMatrix == null ? null : _settledEntityMatrix.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@RuneAttribute("indexFactor")
		public CreditIndex.CreditIndexBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@RuneAttribute("seniority")
		public CreditIndex.CreditIndexBuilder setSeniority(CreditSeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public CreditIndex.CreditIndexBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public CreditIndex build() {
			return new CreditIndex.CreditIndexImpl(this);
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditIndex.CreditIndexBuilder prune() {
			super.prune();
			if (indexAnnexSource!=null && !indexAnnexSource.prune().hasData()) indexAnnexSource = null;
			excludedReferenceEntity = excludedReferenceEntity.stream().filter(b->b!=null).<ReferenceInformation.ReferenceInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			if (settledEntityMatrix!=null && !settledEntityMatrix.prune().hasData()) settledEntityMatrix = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIndexSeries()!=null) return true;
			if (getIndexAnnexVersion()!=null) return true;
			if (getIndexAnnexDate()!=null) return true;
			if (getIndexAnnexSource()!=null) return true;
			if (getExcludedReferenceEntity()!=null && getExcludedReferenceEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			if (getSettledEntityMatrix()!=null && getSettledEntityMatrix().hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getSeniority()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditIndex.CreditIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditIndex.CreditIndexBuilder o = (CreditIndex.CreditIndexBuilder) other;
			
			merger.mergeRosetta(getIndexAnnexSource(), o.getIndexAnnexSource(), this::setIndexAnnexSource);
			merger.mergeRosetta(getExcludedReferenceEntity(), o.getExcludedReferenceEntity(), this::getOrCreateExcludedReferenceEntity);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeRosetta(getSettledEntityMatrix(), o.getSettledEntityMatrix(), this::setSettledEntityMatrix);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getIndexSeries(), o.getIndexSeries(), this::setIndexSeries);
			merger.mergeBasic(getIndexAnnexVersion(), o.getIndexAnnexVersion(), this::setIndexAnnexVersion);
			merger.mergeBasic(getIndexAnnexDate(), o.getIndexAnnexDate(), this::setIndexAnnexDate);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			merger.mergeBasic(getSeniority(), o.getSeniority(), this::setSeniority);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditIndex _that = getType().cast(o);
		
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditIndexBuilder {" +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}
