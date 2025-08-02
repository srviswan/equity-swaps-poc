package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilder;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseBuilderImpl;
import cdm.base.staticdata.asset.common.InstrumentBase.InstrumentBaseImpl;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilder;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeBuilderImpl;
import cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivativeImpl;
import cdm.base.staticdata.asset.common.PutCallEnum;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
import cdm.base.staticdata.asset.common.meta.ListedDerivativeMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A securitized derivative on another asset.
 * @version 6.0.0
 */
@RosettaDataType(value="ListedDerivative", builder=ListedDerivative.ListedDerivativeBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ListedDerivative", model="Just another Rosetta model", builder=ListedDerivative.ListedDerivativeBuilderImpl.class, version="6.0.0")
public interface ListedDerivative extends InstrumentBase {

	ListedDerivativeMeta metaData = new ListedDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Also called contract month or delivery month. However, it&#39;s not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
	 */
	String getDeliveryTerm();
	/**
	 * The type of option, ie Put or Call. Left empty if it is a Future.
	 */
	PutCallEnum getOptionType();
	/**
	 * Specifies the strike of the option.
	 */
	BigDecimal getStrike();

	/*********************** Build Methods  ***********************/
	ListedDerivative build();
	
	ListedDerivative.ListedDerivativeBuilder toBuilder();
	
	static ListedDerivative.ListedDerivativeBuilder builder() {
		return new ListedDerivative.ListedDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ListedDerivative> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ListedDerivative> getType() {
		return ListedDerivative.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.class, getTaxonomy());
		processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
		processRosetta(path.newSubPath("exchange"), processor, LegalEntity.class, getExchange());
		processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.class, getRelatedExchange());
		processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
		processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ListedDerivativeBuilder extends ListedDerivative, InstrumentBase.InstrumentBaseBuilder {
		@Override
		ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier);
		@Override
		ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier identifier, int _idx);
		@Override
		ListedDerivative.ListedDerivativeBuilder addIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		ListedDerivative.ListedDerivativeBuilder setIdentifier(List<? extends AssetIdentifier> identifier);
		@Override
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy);
		@Override
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy taxonomy, int _idx);
		@Override
		ListedDerivative.ListedDerivativeBuilder addTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		ListedDerivative.ListedDerivativeBuilder setTaxonomy(List<? extends Taxonomy> taxonomy);
		@Override
		ListedDerivative.ListedDerivativeBuilder setIsExchangeListed(Boolean isExchangeListed);
		@Override
		ListedDerivative.ListedDerivativeBuilder setExchange(LegalEntity exchange);
		@Override
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange);
		@Override
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity relatedExchange, int _idx);
		@Override
		ListedDerivative.ListedDerivativeBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		ListedDerivative.ListedDerivativeBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchange);
		@Override
		ListedDerivative.ListedDerivativeBuilder setInstrumentType(InstrumentTypeEnum instrumentType);
		ListedDerivative.ListedDerivativeBuilder setDeliveryTerm(String deliveryTerm);
		ListedDerivative.ListedDerivativeBuilder setOptionType(PutCallEnum optionType);
		ListedDerivative.ListedDerivativeBuilder setStrike(BigDecimal strike);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("taxonomy"), processor, Taxonomy.TaxonomyBuilder.class, getTaxonomy());
			processor.processBasic(path.newSubPath("isExchangeListed"), Boolean.class, getIsExchangeListed(), this);
			processRosetta(path.newSubPath("exchange"), processor, LegalEntity.LegalEntityBuilder.class, getExchange());
			processRosetta(path.newSubPath("relatedExchange"), processor, LegalEntity.LegalEntityBuilder.class, getRelatedExchange());
			processor.processBasic(path.newSubPath("instrumentType"), InstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("deliveryTerm"), String.class, getDeliveryTerm(), this);
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		}
		

		ListedDerivative.ListedDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of ListedDerivative  ***********************/
	class ListedDerivativeImpl extends InstrumentBase.InstrumentBaseImpl implements ListedDerivative {
		private final String deliveryTerm;
		private final PutCallEnum optionType;
		private final BigDecimal strike;
		
		protected ListedDerivativeImpl(ListedDerivative.ListedDerivativeBuilder builder) {
			super(builder);
			this.deliveryTerm = builder.getDeliveryTerm();
			this.optionType = builder.getOptionType();
			this.strike = builder.getStrike();
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		@RuneAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		public ListedDerivative build() {
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder toBuilder() {
			ListedDerivative.ListedDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ListedDerivative.ListedDerivativeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryTerm()).ifPresent(builder::setDeliveryTerm);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ListedDerivative _that = getType().cast(o);
		
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListedDerivative {" +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ListedDerivative  ***********************/
	class ListedDerivativeBuilderImpl extends InstrumentBase.InstrumentBaseBuilderImpl implements ListedDerivative.ListedDerivativeBuilder {
	
		protected String deliveryTerm;
		protected PutCallEnum optionType;
		protected BigDecimal strike;
		
		@Override
		@RosettaAttribute("deliveryTerm")
		@RuneAttribute("deliveryTerm")
		public String getDeliveryTerm() {
			return deliveryTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@RuneAttribute("identifier")
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(AssetIdentifier _identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addIdentifier(List<? extends AssetIdentifier> identifiers) {
			if (identifiers != null) {
				for (final AssetIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("identifier")
		public ListedDerivative.ListedDerivativeBuilder setIdentifier(List<? extends AssetIdentifier> identifiers) {
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
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy _taxonomy) {
			if (_taxonomy != null) {
				this.taxonomy.add(_taxonomy.toBuilder());
			}
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(Taxonomy _taxonomy, int _idx) {
			getIndex(this.taxonomy, _idx, () -> _taxonomy.toBuilder());
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addTaxonomy(List<? extends Taxonomy> taxonomys) {
			if (taxonomys != null) {
				for (final Taxonomy toAdd : taxonomys) {
					this.taxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("taxonomy")
		public ListedDerivative.ListedDerivativeBuilder setTaxonomy(List<? extends Taxonomy> taxonomys) {
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
		public ListedDerivative.ListedDerivativeBuilder setIsExchangeListed(Boolean _isExchangeListed) {
			this.isExchangeListed = _isExchangeListed == null ? null : _isExchangeListed;
			return this;
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public ListedDerivative.ListedDerivativeBuilder setExchange(LegalEntity _exchange) {
			this.exchange = _exchange == null ? null : _exchange.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("relatedExchange")
		@RuneAttribute("relatedExchange")
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity _relatedExchange) {
			if (_relatedExchange != null) {
				this.relatedExchange.add(_relatedExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(LegalEntity _relatedExchange, int _idx) {
			getIndex(this.relatedExchange, _idx, () -> _relatedExchange.toBuilder());
			return this;
		}
		
		@Override 
		public ListedDerivative.ListedDerivativeBuilder addRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
			if (relatedExchanges != null) {
				for (final LegalEntity toAdd : relatedExchanges) {
					this.relatedExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("relatedExchange")
		public ListedDerivative.ListedDerivativeBuilder setRelatedExchange(List<? extends LegalEntity> relatedExchanges) {
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
		public ListedDerivative.ListedDerivativeBuilder setInstrumentType(InstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@Override
		@RosettaAttribute("deliveryTerm")
		@RuneAttribute("deliveryTerm")
		public ListedDerivative.ListedDerivativeBuilder setDeliveryTerm(String _deliveryTerm) {
			this.deliveryTerm = _deliveryTerm == null ? null : _deliveryTerm;
			return this;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@RuneAttribute("optionType")
		public ListedDerivative.ListedDerivativeBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@Override
		@RosettaAttribute("strike")
		@RuneAttribute("strike")
		public ListedDerivative.ListedDerivativeBuilder setStrike(BigDecimal _strike) {
			this.strike = _strike == null ? null : _strike;
			return this;
		}
		
		@Override
		public ListedDerivative build() {
			return new ListedDerivative.ListedDerivativeImpl(this);
		}
		
		@Override
		public ListedDerivative.ListedDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListedDerivative.ListedDerivativeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryTerm()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getStrike()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListedDerivative.ListedDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ListedDerivative.ListedDerivativeBuilder o = (ListedDerivative.ListedDerivativeBuilder) other;
			
			
			merger.mergeBasic(getDeliveryTerm(), o.getDeliveryTerm(), this::setDeliveryTerm);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ListedDerivative _that = getType().cast(o);
		
			if (!Objects.equals(deliveryTerm, _that.getDeliveryTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryTerm != null ? deliveryTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListedDerivativeBuilder {" +
				"deliveryTerm=" + this.deliveryTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strike=" + this.strike +
			'}' + " " + super.toString();
		}
	}
}
