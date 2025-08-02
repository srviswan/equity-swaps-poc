package cdm.event.position;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.event.common.Trade;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder;
import cdm.event.position.AggregationParameters;
import cdm.event.position.AggregationParameters.AggregationParametersBuilder;
import cdm.event.position.AggregationParameters.AggregationParametersBuilderImpl;
import cdm.event.position.AggregationParameters.AggregationParametersImpl;
import cdm.event.position.PositionStatusEnum;
import cdm.event.position.meta.AggregationParametersMeta;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  Parameters to be used to filter events that are relevant to a given portfolio in order to calculate the state of this portfolio. The attributes correspond to all the possible aggregation criteria that can be used and these criteria can be combined. All the attributes are optional.
 * @version 6.0.0
 */
@RosettaDataType(value="AggregationParameters", builder=AggregationParameters.AggregationParametersBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AggregationParameters", model="Just another Rosetta model", builder=AggregationParameters.AggregationParametersBuilderImpl.class, version="6.0.0")
public interface AggregationParameters extends RosettaModelObject {

	AggregationParametersMeta metaData = new AggregationParametersMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * To aggregate as of a particular date
	 */
	ZonedDateTime getDateTime();
	/**
	 * Specifies whether to calculate total position to given date, or only daily position for the given date.
	 */
	Boolean getTotalPosition();
	/**
	 * To aggregate based on position status (EXECUTED, SETTLED etc)
	 */
	PositionStatusEnum getPositionStatus();
	/**
	 * To aggregate based on a selection of party(ies) / legal entity(ies).
	 */
	List<? extends ReferenceWithMetaParty> getParty();
	/**
	 * To aggregate based on a selection of products.
	 */
	List<? extends NonTransferableProduct> getProduct();
	/**
	 * To aggregate based on a selection of product type(s).
	 */
	List<String> getProductQualifier();
	List<? extends ReferenceWithMetaTrade> getTradeReference();

	/*********************** Build Methods  ***********************/
	AggregationParameters build();
	
	AggregationParameters.AggregationParametersBuilder toBuilder();
	
	static AggregationParameters.AggregationParametersBuilder builder() {
		return new AggregationParameters.AggregationParametersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AggregationParameters> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AggregationParameters> getType() {
		return AggregationParameters.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
		processor.processBasic(path.newSubPath("totalPosition"), Boolean.class, getTotalPosition(), this);
		processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
		processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaParty.class, getParty());
		processRosetta(path.newSubPath("product"), processor, NonTransferableProduct.class, getProduct());
		processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
		processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTrade.class, getTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AggregationParametersBuilder extends AggregationParameters, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateParty(int _index);
		@Override
		List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getParty();
		NonTransferableProduct.NonTransferableProductBuilder getOrCreateProduct(int _index);
		@Override
		List<? extends NonTransferableProduct.NonTransferableProductBuilder> getProduct();
		ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index);
		@Override
		List<? extends ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder> getTradeReference();
		AggregationParameters.AggregationParametersBuilder setDateTime(ZonedDateTime dateTime);
		AggregationParameters.AggregationParametersBuilder setTotalPosition(Boolean totalPosition);
		AggregationParameters.AggregationParametersBuilder setPositionStatus(PositionStatusEnum positionStatus);
		AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party);
		AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party, int _idx);
		AggregationParameters.AggregationParametersBuilder addPartyValue(Party party);
		AggregationParameters.AggregationParametersBuilder addPartyValue(Party party, int _idx);
		AggregationParameters.AggregationParametersBuilder addParty(List<? extends ReferenceWithMetaParty> party);
		AggregationParameters.AggregationParametersBuilder setParty(List<? extends ReferenceWithMetaParty> party);
		AggregationParameters.AggregationParametersBuilder addPartyValue(List<? extends Party> party);
		AggregationParameters.AggregationParametersBuilder setPartyValue(List<? extends Party> party);
		AggregationParameters.AggregationParametersBuilder addProduct(NonTransferableProduct product);
		AggregationParameters.AggregationParametersBuilder addProduct(NonTransferableProduct product, int _idx);
		AggregationParameters.AggregationParametersBuilder addProduct(List<? extends NonTransferableProduct> product);
		AggregationParameters.AggregationParametersBuilder setProduct(List<? extends NonTransferableProduct> product);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier, int _idx);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(List<String> productQualifier);
		AggregationParameters.AggregationParametersBuilder setProductQualifier(List<String> productQualifier);
		AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference, int _idx);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference, int _idx);
		AggregationParameters.AggregationParametersBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		AggregationParameters.AggregationParametersBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(List<? extends Trade> tradeReference);
		AggregationParameters.AggregationParametersBuilder setTradeReferenceValue(List<? extends Trade> tradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
			processor.processBasic(path.newSubPath("totalPosition"), Boolean.class, getTotalPosition(), this);
			processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
			processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getParty());
			processRosetta(path.newSubPath("product"), processor, NonTransferableProduct.NonTransferableProductBuilder.class, getProduct());
			processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
			processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder.class, getTradeReference());
		}
		

		AggregationParameters.AggregationParametersBuilder prune();
	}

	/*********************** Immutable Implementation of AggregationParameters  ***********************/
	class AggregationParametersImpl implements AggregationParameters {
		private final ZonedDateTime dateTime;
		private final Boolean totalPosition;
		private final PositionStatusEnum positionStatus;
		private final List<? extends ReferenceWithMetaParty> party;
		private final List<? extends NonTransferableProduct> product;
		private final List<String> productQualifier;
		private final List<? extends ReferenceWithMetaTrade> tradeReference;
		
		protected AggregationParametersImpl(AggregationParameters.AggregationParametersBuilder builder) {
			this.dateTime = builder.getDateTime();
			this.totalPosition = builder.getTotalPosition();
			this.positionStatus = builder.getPositionStatus();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.product = ofNullable(builder.getProduct()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productQualifier = ofNullable(builder.getProductQualifier()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeReference = ofNullable(builder.getTradeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateTime")
		@RuneAttribute("dateTime")
		public ZonedDateTime getDateTime() {
			return dateTime;
		}
		
		@Override
		@RosettaAttribute("totalPosition")
		@RuneAttribute("totalPosition")
		public Boolean getTotalPosition() {
			return totalPosition;
		}
		
		@Override
		@RosettaAttribute("positionStatus")
		@RuneAttribute("positionStatus")
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends ReferenceWithMetaParty> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public List<? extends NonTransferableProduct> getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("productQualifier")
		@RuneAttribute("productQualifier")
		public List<String> getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@RuneAttribute("tradeReference")
		public List<? extends ReferenceWithMetaTrade> getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public AggregationParameters build() {
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder toBuilder() {
			AggregationParameters.AggregationParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AggregationParameters.AggregationParametersBuilder builder) {
			ofNullable(getDateTime()).ifPresent(builder::setDateTime);
			ofNullable(getTotalPosition()).ifPresent(builder::setTotalPosition);
			ofNullable(getPositionStatus()).ifPresent(builder::setPositionStatus);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getProductQualifier()).ifPresent(builder::setProductQualifier);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationParameters _that = getType().cast(o);
		
			if (!Objects.equals(dateTime, _that.getDateTime())) return false;
			if (!Objects.equals(totalPosition, _that.getTotalPosition())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(productQualifier, _that.getProductQualifier())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			_result = 31 * _result + (totalPosition != null ? totalPosition.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationParameters {" +
				"dateTime=" + this.dateTime + ", " +
				"totalPosition=" + this.totalPosition + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"party=" + this.party + ", " +
				"product=" + this.product + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of AggregationParameters  ***********************/
	class AggregationParametersBuilderImpl implements AggregationParameters.AggregationParametersBuilder {
	
		protected ZonedDateTime dateTime;
		protected Boolean totalPosition;
		protected PositionStatusEnum positionStatus;
		protected List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> party = new ArrayList<>();
		protected List<NonTransferableProduct.NonTransferableProductBuilder> product = new ArrayList<>();
		protected List<String> productQualifier = new ArrayList<>();
		protected List<ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder> tradeReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dateTime")
		@RuneAttribute("dateTime")
		public ZonedDateTime getDateTime() {
			return dateTime;
		}
		
		@Override
		@RosettaAttribute("totalPosition")
		@RuneAttribute("totalPosition")
		public Boolean getTotalPosition() {
			return totalPosition;
		}
		
		@Override
		@RosettaAttribute("positionStatus")
		@RuneAttribute("positionStatus")
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			return getIndex(party, _index, () -> {
						ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder newParty = ReferenceWithMetaParty.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public List<? extends NonTransferableProduct.NonTransferableProductBuilder> getProduct() {
			return product;
		}
		
		@Override
		public NonTransferableProduct.NonTransferableProductBuilder getOrCreateProduct(int _index) {
		
			if (product==null) {
				this.product = new ArrayList<>();
			}
			NonTransferableProduct.NonTransferableProductBuilder result;
			return getIndex(product, _index, () -> {
						NonTransferableProduct.NonTransferableProductBuilder newProduct = NonTransferableProduct.builder();
						return newProduct;
					});
		}
		
		@Override
		@RosettaAttribute("productQualifier")
		@RuneAttribute("productQualifier")
		public List<String> getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@RuneAttribute("tradeReference")
		public List<? extends ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder> getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index) {
		
			if (tradeReference==null) {
				this.tradeReference = new ArrayList<>();
			}
			ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder result;
			return getIndex(tradeReference, _index, () -> {
						ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder newTradeReference = ReferenceWithMetaTrade.builder();
						return newTradeReference;
					});
		}
		
		@Override
		@RosettaAttribute("dateTime")
		@RuneAttribute("dateTime")
		public AggregationParameters.AggregationParametersBuilder setDateTime(ZonedDateTime _dateTime) {
			this.dateTime = _dateTime == null ? null : _dateTime;
			return this;
		}
		
		@Override
		@RosettaAttribute("totalPosition")
		@RuneAttribute("totalPosition")
		public AggregationParameters.AggregationParametersBuilder setTotalPosition(Boolean _totalPosition) {
			this.totalPosition = _totalPosition == null ? null : _totalPosition;
			return this;
		}
		
		@Override
		@RosettaAttribute("positionStatus")
		@RuneAttribute("positionStatus")
		public AggregationParameters.AggregationParametersBuilder setPositionStatus(PositionStatusEnum _positionStatus) {
			this.positionStatus = _positionStatus == null ? null : _positionStatus;
			return this;
		}
		
		@Override
		@RosettaAttribute("party")
		@RuneAttribute("party")
		public AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty _party, int _idx) {
			getIndex(this.party, _idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addPartyValue(Party _party) {
			this.getOrCreateParty(-1).setValue(_party.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addPartyValue(Party _party, int _idx) {
			this.getOrCreateParty(_idx).setValue(_party.toBuilder());
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder addParty(List<? extends ReferenceWithMetaParty> partys) {
			if (partys != null) {
				for (final ReferenceWithMetaParty toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("party")
		public AggregationParameters.AggregationParametersBuilder setParty(List<? extends ReferenceWithMetaParty> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addPartyValue(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.addPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setPartyValue(List<? extends Party> partys) {
			this.party.clear();
			if (partys != null) {
				partys.forEach(this::addPartyValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public AggregationParameters.AggregationParametersBuilder addProduct(NonTransferableProduct _product) {
			if (_product != null) {
				this.product.add(_product.toBuilder());
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addProduct(NonTransferableProduct _product, int _idx) {
			getIndex(this.product, _idx, () -> _product.toBuilder());
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder addProduct(List<? extends NonTransferableProduct> products) {
			if (products != null) {
				for (final NonTransferableProduct toAdd : products) {
					this.product.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("product")
		public AggregationParameters.AggregationParametersBuilder setProduct(List<? extends NonTransferableProduct> products) {
			if (products == null) {
				this.product = new ArrayList<>();
			} else {
				this.product = products.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("productQualifier")
		@RuneAttribute("productQualifier")
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(String _productQualifier) {
			if (_productQualifier != null) {
				this.productQualifier.add(_productQualifier);
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(String _productQualifier, int _idx) {
			getIndex(this.productQualifier, _idx, () -> _productQualifier);
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(List<String> productQualifiers) {
			if (productQualifiers != null) {
				for (final String toAdd : productQualifiers) {
					this.productQualifier.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("productQualifier")
		public AggregationParameters.AggregationParametersBuilder setProductQualifier(List<String> productQualifiers) {
			if (productQualifiers == null) {
				this.productQualifier = new ArrayList<>();
			} else {
				this.productQualifier = productQualifiers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@RuneAttribute("tradeReference")
		public AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade _tradeReference) {
			if (_tradeReference != null) {
				this.tradeReference.add(_tradeReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade _tradeReference, int _idx) {
			getIndex(this.tradeReference, _idx, () -> _tradeReference.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade _tradeReference) {
			this.getOrCreateTradeReference(-1).setValue(_tradeReference.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade _tradeReference, int _idx) {
			this.getOrCreateTradeReference(_idx).setValue(_tradeReference.toBuilder());
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences != null) {
				for (final ReferenceWithMetaTrade toAdd : tradeReferences) {
					this.tradeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("tradeReference")
		public AggregationParameters.AggregationParametersBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences == null) {
				this.tradeReference = new ArrayList<>();
			} else {
				this.tradeReference = tradeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(List<? extends Trade> tradeReferences) {
			if (tradeReferences != null) {
				for (final Trade toAdd : tradeReferences) {
					this.addTradeReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setTradeReferenceValue(List<? extends Trade> tradeReferences) {
			this.tradeReference.clear();
			if (tradeReferences != null) {
				tradeReferences.forEach(this::addTradeReferenceValue);
			}
			return this;
		}
		
		@Override
		public AggregationParameters build() {
			return new AggregationParameters.AggregationParametersImpl(this);
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationParameters.AggregationParametersBuilder prune() {
			party = party.stream().filter(b->b!=null).<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			product = product.stream().filter(b->b!=null).<NonTransferableProduct.NonTransferableProductBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeReference = tradeReference.stream().filter(b->b!=null).<ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateTime()!=null) return true;
			if (getTotalPosition()!=null) return true;
			if (getPositionStatus()!=null) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProduct()!=null && getProduct().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductQualifier()!=null && !getProductQualifier().isEmpty()) return true;
			if (getTradeReference()!=null && getTradeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationParameters.AggregationParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AggregationParameters.AggregationParametersBuilder o = (AggregationParameters.AggregationParametersBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::getOrCreateProduct);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::getOrCreateTradeReference);
			
			merger.mergeBasic(getDateTime(), o.getDateTime(), this::setDateTime);
			merger.mergeBasic(getTotalPosition(), o.getTotalPosition(), this::setTotalPosition);
			merger.mergeBasic(getPositionStatus(), o.getPositionStatus(), this::setPositionStatus);
			merger.mergeBasic(getProductQualifier(), o.getProductQualifier(), (Consumer<String>) this::addProductQualifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationParameters _that = getType().cast(o);
		
			if (!Objects.equals(dateTime, _that.getDateTime())) return false;
			if (!Objects.equals(totalPosition, _that.getTotalPosition())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(productQualifier, _that.getProductQualifier())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			_result = 31 * _result + (totalPosition != null ? totalPosition.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationParametersBuilder {" +
				"dateTime=" + this.dateTime + ", " +
				"totalPosition=" + this.totalPosition + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"party=" + this.party + ", " +
				"product=" + this.product + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
}
