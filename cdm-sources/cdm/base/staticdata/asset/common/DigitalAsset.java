package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilder;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilderImpl;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetImpl;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.DigitalAssetMeta;
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
import java.util.stream.Collectors;


/**
 * An Asset that exists only in digital form, eg Bitcoin or Ethereum, that is not backed by other Assets; excludes the digital representation of other Assets, eg coins or Tokenised assets.
 * @version 6.0.0
 */
@RosettaDataType(value="DigitalAsset", builder=DigitalAsset.DigitalAssetBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DigitalAsset", model="Just another Rosetta model", builder=DigitalAsset.DigitalAssetBuilderImpl.class, version="6.0.0")
public interface DigitalAsset extends AssetBase {

	DigitalAssetMeta metaData = new DigitalAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DigitalAsset build();
	
	DigitalAsset.DigitalAssetBuilder toBuilder();
	
	static DigitalAsset.DigitalAssetBuilder builder() {
		return new DigitalAsset.DigitalAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigitalAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DigitalAsset> getType() {
		return DigitalAsset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigitalAssetBuilder extends DigitalAsset, AssetBase.AssetBaseBuilder {
		@Override
		DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		DigitalAsset.DigitalAssetBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		DigitalAsset.DigitalAssetBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		DigitalAsset.DigitalAssetBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		DigitalAsset.DigitalAssetBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		DigitalAsset.DigitalAssetBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		DigitalAsset.DigitalAssetBuilder setExchange(LegalEntity exchange);
		@Override
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		DigitalAsset.DigitalAssetBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		DigitalAsset.DigitalAssetBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
		}
		

		DigitalAsset.DigitalAssetBuilder prune();
	}

	/*********************** Immutable Implementation of DigitalAsset  ***********************/
	class DigitalAssetImpl extends AssetBase.AssetBaseImpl implements DigitalAsset {
		
		protected DigitalAssetImpl(DigitalAsset.DigitalAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public DigitalAsset build() {
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder toBuilder() {
			DigitalAsset.DigitalAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigitalAsset.DigitalAssetBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigitalAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DigitalAsset  ***********************/
	class DigitalAssetBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements DigitalAsset.DigitalAssetBuilder {
	
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public DigitalAsset.DigitalAssetBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public DigitalAsset.DigitalAssetBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public DigitalAsset.DigitalAssetBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public DigitalAsset.DigitalAssetBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public DigitalAsset.DigitalAssetBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public DigitalAsset.DigitalAssetBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public DigitalAsset build() {
			return new DigitalAsset.DigitalAssetImpl(this);
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigitalAsset.DigitalAssetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigitalAsset.DigitalAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DigitalAsset.DigitalAssetBuilder o = (DigitalAsset.DigitalAssetBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigitalAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
