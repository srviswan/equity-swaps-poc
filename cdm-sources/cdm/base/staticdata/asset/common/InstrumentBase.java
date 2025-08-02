package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilder;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseBuilderImpl;
import cdm.base.staticdata.asset.common.AssetBase.AssetBaseImpl;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.InstrumentBaseMeta;
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
 * Defines the common attributes for all Instrument data types.
 * @version 6.0.0
 */
@RosettaDataType(value="InstrumentBase", builder=InstrumentBase.InstrumentBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="InstrumentBase", model="Just another Rosetta model", builder=InstrumentBase.InstrumentBaseBuilderImpl.class, version="6.0.0")
public interface InstrumentBase extends AssetBase {

	InstrumentBaseMeta metaData = new InstrumentBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the type of an instrument using an enumerated list.
	 */
	InstrumentTypeEnum getInstrumentType();

	/*********************** Build Methods  ***********************/
	InstrumentBase build();
	
	InstrumentBase.InstrumentBaseBuilder toBuilder();
	
	static InstrumentBase.InstrumentBaseBuilder builder() {
		return new InstrumentBase.InstrumentBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentBase> getType() {
		return InstrumentBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentBaseBuilder extends InstrumentBase, AssetBase.AssetBaseBuilder {
		@Override
		InstrumentBase.InstrumentBaseBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		InstrumentBase.InstrumentBaseBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		InstrumentBase.InstrumentBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		InstrumentBase.InstrumentBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		InstrumentBase.InstrumentBaseBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		InstrumentBase.InstrumentBaseBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		InstrumentBase.InstrumentBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		InstrumentBase.InstrumentBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		InstrumentBase.InstrumentBaseBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		InstrumentBase.InstrumentBaseBuilder setExchange(LegalEntity exchange);
		@Override
		InstrumentBase.InstrumentBaseBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		InstrumentBase.InstrumentBaseBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		InstrumentBase.InstrumentBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		InstrumentBase.InstrumentBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		InstrumentBase.InstrumentBaseBuilder setInstrumentType(InstrumentTypeEnum instrumentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
		}
		

		InstrumentBase.InstrumentBaseBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentBase  ***********************/
	class InstrumentBaseImpl extends AssetBase.AssetBaseImpl implements InstrumentBase {
		private final InstrumentTypeEnum instrumentType;
		
		protected InstrumentBaseImpl(InstrumentBase.InstrumentBaseBuilder builder) {
			super(builder);
			this.instrumentType = builder.getInstrumentType();
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@RuneAttribute("instrumentType")
		public InstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		public InstrumentBase build() {
			return this;
		}
		
		@Override
		public InstrumentBase.InstrumentBaseBuilder toBuilder() {
			InstrumentBase.InstrumentBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentBase.InstrumentBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInstrumentType()).ifPresent(builder::setInstrumentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentBase _that = getType().cast(o);
		
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentBase {" +
				"instrumentType=" + this.instrumentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InstrumentBase  ***********************/
	class InstrumentBaseBuilderImpl extends AssetBase.AssetBaseBuilderImpl implements InstrumentBase.InstrumentBaseBuilder {
	
		protected InstrumentTypeEnum instrumentType;
		
		@Override
		@RosettaAttribute("instrumentType")
		@RuneAttribute("instrumentType")
		public InstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public InstrumentBase.InstrumentBaseBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentBase.InstrumentBaseBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public InstrumentBase.InstrumentBaseBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public InstrumentBase.InstrumentBaseBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public InstrumentBase.InstrumentBaseBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentBase.InstrumentBaseBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public InstrumentBase.InstrumentBaseBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public InstrumentBase.InstrumentBaseBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public InstrumentBase.InstrumentBaseBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public InstrumentBase.InstrumentBaseBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public InstrumentBase.InstrumentBaseBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentBase.InstrumentBaseBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public InstrumentBase.InstrumentBaseBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public InstrumentBase.InstrumentBaseBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public InstrumentBase.InstrumentBaseBuilder setInstrumentType(InstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@Override
		public InstrumentBase build() {
			return new InstrumentBase.InstrumentBaseImpl(this);
		}
		
		@Override
		public InstrumentBase.InstrumentBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentBase.InstrumentBaseBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInstrumentType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentBase.InstrumentBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InstrumentBase.InstrumentBaseBuilder o = (InstrumentBase.InstrumentBaseBuilder) other;
			
			
			merger.mergeBasic(getInstrumentType(), o.getInstrumentType(), this::setInstrumentType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InstrumentBase _that = getType().cast(o);
		
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentBaseBuilder {" +
				"instrumentType=" + this.instrumentType +
			'}' + " " + super.toString();
		}
	}
}
