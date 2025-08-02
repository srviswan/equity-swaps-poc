package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Commodity.CommodityBuilder;
import cdm.base.staticdata.asset.common.Commodity.CommodityBuilderImpl;
import cdm.base.staticdata.asset.common.Commodity.CommodityImpl;
import cdm.base.staticdata.asset.common.CommodityProductDefinition;
import cdm.base.staticdata.asset.common.CommodityProductDefinition.CommodityProductDefinitionBuilder;
import cdm.base.staticdata.asset.common.DeliveryDateParameters;
import cdm.base.staticdata.asset.common.DeliveryDateParameters.DeliveryDateParametersBuilder;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.CommodityMeta;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.observable.asset.QuotationSideEnum;
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
 * Identifies a specific commodity by referencing a product identifier or by a product definition.
 * @version 6.0.0
 */
@RosettaDataType(value="Commodity", builder=Commodity.CommodityBuilderImpl.class, version="6.0.0")
@RuneDataType(value="Commodity", model="Just another Rosetta model", builder=Commodity.CommodityBuilderImpl.class, version="6.0.0")
public interface Commodity extends AssetBase {

	CommodityMeta metaData = new CommodityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
	 */
	CommodityProductDefinition getCommodityProductDefinition();
	/**
	 * Describes the required quote type of the underlying price that will be observed. Example values include &#39;Bid, &#39;Ask&#39;, &#39;Settlement&#39; (for a futures contract) and &#39;WeightedAverage&#39; (for some published prices and indices).
	 */
	QuotationSideEnum getPriceQuoteType();
	/**
	 * Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
	 */
	DeliveryDateParameters getDeliveryDateReference();
	/**
	 * Provides additional information about the commodity underlier.
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	Commodity build();
	
	Commodity.CommodityBuilder toBuilder();
	
	static Commodity.CommodityBuilder builder() {
		return new Commodity.CommodityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Commodity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Commodity> getType() {
		return Commodity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processRosetta(path.newSubPath("commodityProductDefinition"), processor, CommodityProductDefinition.class, getCommodityProductDefinition());
		processor.processBasic(path.newSubPath("priceQuoteType"), QuotationSideEnum.class, getPriceQuoteType(), this);
		processRosetta(path.newSubPath("deliveryDateReference"), processor, DeliveryDateParameters.class, getDeliveryDateReference());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBuilder extends Commodity, AssetBase.AssetBaseBuilder {
		CommodityProductDefinition.CommodityProductDefinitionBuilder getOrCreateCommodityProductDefinition();
		@Override
		CommodityProductDefinition.CommodityProductDefinitionBuilder getCommodityProductDefinition();
		DeliveryDateParameters.DeliveryDateParametersBuilder getOrCreateDeliveryDateReference();
		@Override
		DeliveryDateParameters.DeliveryDateParametersBuilder getDeliveryDateReference();
		@Override
		Commodity.CommodityBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		Commodity.CommodityBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		Commodity.CommodityBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Commodity.CommodityBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		Commodity.CommodityBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		Commodity.CommodityBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		Commodity.CommodityBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Commodity.CommodityBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		Commodity.CommodityBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		Commodity.CommodityBuilder setExchange(LegalEntity exchange);
		@Override
		Commodity.CommodityBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		Commodity.CommodityBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		Commodity.CommodityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		Commodity.CommodityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		Commodity.CommodityBuilder setCommodityProductDefinition(CommodityProductDefinition commodityProductDefinition);
		Commodity.CommodityBuilder setPriceQuoteType(QuotationSideEnum priceQuoteType);
		Commodity.CommodityBuilder setDeliveryDateReference(DeliveryDateParameters deliveryDateReference);
		Commodity.CommodityBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processRosetta(path.newSubPath("commodityProductDefinition"), processor, CommodityProductDefinition.CommodityProductDefinitionBuilder.class, getCommodityProductDefinition());
			processor.processBasic(path.newSubPath("priceQuoteType"), QuotationSideEnum.class, getPriceQuoteType(), this);
			processRosetta(path.newSubPath("deliveryDateReference"), processor, DeliveryDateParameters.DeliveryDateParametersBuilder.class, getDeliveryDateReference());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		Commodity.CommodityBuilder prune();
	}

	/*********************** Immutable Implementation of Commodity  ***********************/
	class CommodityImpl extends AssetBase.AssetBaseImpl implements Commodity {
		private final CommodityProductDefinition commodityProductDefinition;
		private final QuotationSideEnum priceQuoteType;
		private final DeliveryDateParameters deliveryDateReference;
		private final String description;
		
		protected CommodityImpl(Commodity.CommodityBuilder builder) {
			super(builder);
			this.commodityProductDefinition = ofNullable(builder.getCommodityProductDefinition()).map(f->f.build()).orElse(null);
			this.priceQuoteType = builder.getPriceQuoteType();
			this.deliveryDateReference = ofNullable(builder.getDeliveryDateReference()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("commodityProductDefinition")
		@RuneAttribute("commodityProductDefinition")
		public CommodityProductDefinition getCommodityProductDefinition() {
			return commodityProductDefinition;
		}
		
		@Override
		@RosettaAttribute("priceQuoteType")
		@RuneAttribute("priceQuoteType")
		public QuotationSideEnum getPriceQuoteType() {
			return priceQuoteType;
		}
		
		@Override
		@RosettaAttribute("deliveryDateReference")
		@RuneAttribute("deliveryDateReference")
		public DeliveryDateParameters getDeliveryDateReference() {
			return deliveryDateReference;
		}
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public Commodity build() {
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			Commodity.CommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commodity.CommodityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityProductDefinition()).ifPresent(builder::setCommodityProductDefinition);
			ofNullable(getPriceQuoteType()).ifPresent(builder::setPriceQuoteType);
			ofNullable(getDeliveryDateReference()).ifPresent(builder::setDeliveryDateReference);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductDefinition, _that.getCommodityProductDefinition())) return false;
			if (!Objects.equals(priceQuoteType, _that.getPriceQuoteType())) return false;
			if (!Objects.equals(deliveryDateReference, _that.getDeliveryDateReference())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductDefinition != null ? commodityProductDefinition.hashCode() : 0);
			_result = 31 * _result + (priceQuoteType != null ? priceQuoteType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDateReference != null ? deliveryDateReference.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commodity {" +
				"commodityProductDefinition=" + this.commodityProductDefinition + ", " +
				"priceQuoteType=" + this.priceQuoteType + ", " +
				"deliveryDateReference=" + this.deliveryDateReference + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Commodity  ***********************/
	class CommodityBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements Commodity.CommodityBuilder {
	
		protected CommodityProductDefinition.CommodityProductDefinitionBuilder commodityProductDefinition;
		protected QuotationSideEnum priceQuoteType;
		protected DeliveryDateParameters.DeliveryDateParametersBuilder deliveryDateReference;
		protected String description;
		
		@Override
		@RosettaAttribute("commodityProductDefinition")
		@RuneAttribute("commodityProductDefinition")
		public CommodityProductDefinition.CommodityProductDefinitionBuilder getCommodityProductDefinition() {
			return commodityProductDefinition;
		}
		
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder getOrCreateCommodityProductDefinition() {
			CommodityProductDefinition.CommodityProductDefinitionBuilder result;
			if (commodityProductDefinition!=null) {
				result = commodityProductDefinition;
			}
			else {
				result = commodityProductDefinition = CommodityProductDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceQuoteType")
		@RuneAttribute("priceQuoteType")
		public QuotationSideEnum getPriceQuoteType() {
			return priceQuoteType;
		}
		
		@Override
		@RosettaAttribute("deliveryDateReference")
		@RuneAttribute("deliveryDateReference")
		public DeliveryDateParameters.DeliveryDateParametersBuilder getDeliveryDateReference() {
			return deliveryDateReference;
		}
		
		@Override
		public DeliveryDateParameters.DeliveryDateParametersBuilder getOrCreateDeliveryDateReference() {
			DeliveryDateParameters.DeliveryDateParametersBuilder result;
			if (deliveryDateReference!=null) {
				result = deliveryDateReference;
			}
			else {
				result = deliveryDateReference = DeliveryDateParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public Commodity.CommodityBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public Commodity.CommodityBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public Commodity.CommodityBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public Commodity.CommodityBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public Commodity.CommodityBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public Commodity.CommodityBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public Commodity.CommodityBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public Commodity.CommodityBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public Commodity.CommodityBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public Commodity.CommodityBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public Commodity.CommodityBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		@RosettaAttribute("commodityProductDefinition")
		@RuneAttribute("commodityProductDefinition")
		public Commodity.CommodityBuilder setCommodityProductDefinition(CommodityProductDefinition _commodityProductDefinition) {
			this.commodityProductDefinition = _commodityProductDefinition == null ? null : _commodityProductDefinition.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("priceQuoteType")
		@RuneAttribute("priceQuoteType")
		public Commodity.CommodityBuilder setPriceQuoteType(QuotationSideEnum _priceQuoteType) {
			this.priceQuoteType = _priceQuoteType == null ? null : _priceQuoteType;
			return this;
		}
		
		@Override
		@RosettaAttribute("deliveryDateReference")
		@RuneAttribute("deliveryDateReference")
		public Commodity.CommodityBuilder setDeliveryDateReference(DeliveryDateParameters _deliveryDateReference) {
			this.deliveryDateReference = _deliveryDateReference == null ? null : _deliveryDateReference.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		@RuneAttribute("description")
		public Commodity.CommodityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public Commodity build() {
			return new Commodity.CommodityImpl(this);
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder prune() {
			super.prune();
			if (commodityProductDefinition!=null && !commodityProductDefinition.prune().hasData()) commodityProductDefinition = null;
			if (deliveryDateReference!=null && !deliveryDateReference.prune().hasData()) deliveryDateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityProductDefinition()!=null && getCommodityProductDefinition().hasData()) return true;
			if (getPriceQuoteType()!=null) return true;
			if (getDeliveryDateReference()!=null && getDeliveryDateReference().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Commodity.CommodityBuilder o = (Commodity.CommodityBuilder) other;
			
			merger.mergeRosetta(getCommodityProductDefinition(), o.getCommodityProductDefinition(), this::setCommodityProductDefinition);
			merger.mergeRosetta(getDeliveryDateReference(), o.getDeliveryDateReference(), this::setDeliveryDateReference);
			
			merger.mergeBasic(getPriceQuoteType(), o.getPriceQuoteType(), this::setPriceQuoteType);
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductDefinition, _that.getCommodityProductDefinition())) return false;
			if (!Objects.equals(priceQuoteType, _that.getPriceQuoteType())) return false;
			if (!Objects.equals(deliveryDateReference, _that.getDeliveryDateReference())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductDefinition != null ? commodityProductDefinition.hashCode() : 0);
			_result = 31 * _result + (priceQuoteType != null ? priceQuoteType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDateReference != null ? deliveryDateReference.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBuilder {" +
				"commodityProductDefinition=" + this.commodityProductDefinition + ", " +
				"priceQuoteType=" + this.priceQuoteType + ", " +
				"deliveryDateReference=" + this.deliveryDateReference + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
