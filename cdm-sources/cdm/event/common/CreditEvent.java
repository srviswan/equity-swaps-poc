package cdm.event.common;

import cdm.event.common.CreditEvent;
import cdm.event.common.CreditEvent.CreditEventBuilder;
import cdm.event.common.CreditEvent.CreditEventBuilderImpl;
import cdm.event.common.CreditEvent.CreditEventImpl;
import cdm.event.common.CreditEventTypeEnum;
import cdm.event.common.meta.CreditEventMeta;
import cdm.legaldocumentation.common.Resource;
import cdm.legaldocumentation.common.Resource.ResourceBuilder;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceInformation.ReferenceInformationBuilder;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relevant data regarding a credit event.
 * @version 6.0.0
 */
@RosettaDataType(value="CreditEvent", builder=CreditEvent.CreditEventBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CreditEvent", model="Just another Rosetta model", builder=CreditEvent.CreditEventBuilderImpl.class, version="6.0.0")
public interface CreditEvent extends RosettaModelObject {

	CreditEventMeta metaData = new CreditEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of credit event taking place.
	 */
	CreditEventTypeEnum getCreditEventType();
	/**
	 * The date in which the credit event is determined by the Credit Derivatives Determinations Comitee.
	 */
	Date getEventDeterminationDate();
	/**
	 * The date on which the auction is scheduled to occur.
	 */
	Date getAuctionDate();
	/**
	 * The final price resulting from the auction.
	 */
	Price getFinalPrice();
	/**
	 * The percentage of the original value of the asset affected by the credit event that can be recovered.
	 */
	BigDecimal getRecoveryPercent();
	/**
	 * A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
	 */
	List<? extends Resource> getPubliclyAvailableInformation();
	/**
	 * The reference entity, part of a credit basket, impacted by the credit event.
	 */
	ReferenceInformation getReferenceInformation();

	/*********************** Build Methods  ***********************/
	CreditEvent build();
	
	CreditEvent.CreditEventBuilder toBuilder();
	
	static CreditEvent.CreditEventBuilder builder() {
		return new CreditEvent.CreditEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEvent> getType() {
		return CreditEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("creditEventType"), CreditEventTypeEnum.class, getCreditEventType(), this);
		processor.processBasic(path.newSubPath("eventDeterminationDate"), Date.class, getEventDeterminationDate(), this);
		processor.processBasic(path.newSubPath("auctionDate"), Date.class, getAuctionDate(), this);
		processRosetta(path.newSubPath("finalPrice"), processor, Price.class, getFinalPrice());
		processor.processBasic(path.newSubPath("recoveryPercent"), BigDecimal.class, getRecoveryPercent(), this);
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.class, getPubliclyAvailableInformation());
		processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.class, getReferenceInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventBuilder extends CreditEvent, RosettaModelObjectBuilder {
		Price.PriceBuilder getOrCreateFinalPrice();
		@Override
		Price.PriceBuilder getFinalPrice();
		Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int _index);
		@Override
		List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation();
		@Override
		ReferenceInformation.ReferenceInformationBuilder getReferenceInformation();
		CreditEvent.CreditEventBuilder setCreditEventType(CreditEventTypeEnum creditEventType);
		CreditEvent.CreditEventBuilder setEventDeterminationDate(Date eventDeterminationDate);
		CreditEvent.CreditEventBuilder setAuctionDate(Date auctionDate);
		CreditEvent.CreditEventBuilder setFinalPrice(Price finalPrice);
		CreditEvent.CreditEventBuilder setRecoveryPercent(BigDecimal recoveryPercent);
		CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation);
		CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int _idx);
		CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		CreditEvent.CreditEventBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		CreditEvent.CreditEventBuilder setReferenceInformation(ReferenceInformation referenceInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("creditEventType"), CreditEventTypeEnum.class, getCreditEventType(), this);
			processor.processBasic(path.newSubPath("eventDeterminationDate"), Date.class, getEventDeterminationDate(), this);
			processor.processBasic(path.newSubPath("auctionDate"), Date.class, getAuctionDate(), this);
			processRosetta(path.newSubPath("finalPrice"), processor, Price.PriceBuilder.class, getFinalPrice());
			processor.processBasic(path.newSubPath("recoveryPercent"), BigDecimal.class, getRecoveryPercent(), this);
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.ResourceBuilder.class, getPubliclyAvailableInformation());
			processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getReferenceInformation());
		}
		

		CreditEvent.CreditEventBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEvent  ***********************/
	class CreditEventImpl implements CreditEvent {
		private final CreditEventTypeEnum creditEventType;
		private final Date eventDeterminationDate;
		private final Date auctionDate;
		private final Price finalPrice;
		private final BigDecimal recoveryPercent;
		private final List<? extends Resource> publiclyAvailableInformation;
		private final ReferenceInformation referenceInformation;
		
		protected CreditEventImpl(CreditEvent.CreditEventBuilder builder) {
			this.creditEventType = builder.getCreditEventType();
			this.eventDeterminationDate = builder.getEventDeterminationDate();
			this.auctionDate = builder.getAuctionDate();
			this.finalPrice = ofNullable(builder.getFinalPrice()).map(f->f.build()).orElse(null);
			this.recoveryPercent = builder.getRecoveryPercent();
			this.publiclyAvailableInformation = ofNullable(builder.getPubliclyAvailableInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.referenceInformation = ofNullable(builder.getReferenceInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEventType")
		@RuneAttribute("creditEventType")
		public CreditEventTypeEnum getCreditEventType() {
			return creditEventType;
		}
		
		@Override
		@RosettaAttribute("eventDeterminationDate")
		@RuneAttribute("eventDeterminationDate")
		public Date getEventDeterminationDate() {
			return eventDeterminationDate;
		}
		
		@Override
		@RosettaAttribute("auctionDate")
		@RuneAttribute("auctionDate")
		public Date getAuctionDate() {
			return auctionDate;
		}
		
		@Override
		@RosettaAttribute("finalPrice")
		@RuneAttribute("finalPrice")
		public Price getFinalPrice() {
			return finalPrice;
		}
		
		@Override
		@RosettaAttribute("recoveryPercent")
		@RuneAttribute("recoveryPercent")
		public BigDecimal getRecoveryPercent() {
			return recoveryPercent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@RuneAttribute("publiclyAvailableInformation")
		public List<? extends Resource> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		@RuneAttribute("referenceInformation")
		public ReferenceInformation getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public CreditEvent build() {
			return this;
		}
		
		@Override
		public CreditEvent.CreditEventBuilder toBuilder() {
			CreditEvent.CreditEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEvent.CreditEventBuilder builder) {
			ofNullable(getCreditEventType()).ifPresent(builder::setCreditEventType);
			ofNullable(getEventDeterminationDate()).ifPresent(builder::setEventDeterminationDate);
			ofNullable(getAuctionDate()).ifPresent(builder::setAuctionDate);
			ofNullable(getFinalPrice()).ifPresent(builder::setFinalPrice);
			ofNullable(getRecoveryPercent()).ifPresent(builder::setRecoveryPercent);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
			ofNullable(getReferenceInformation()).ifPresent(builder::setReferenceInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvent _that = getType().cast(o);
		
			if (!Objects.equals(creditEventType, _that.getCreditEventType())) return false;
			if (!Objects.equals(eventDeterminationDate, _that.getEventDeterminationDate())) return false;
			if (!Objects.equals(auctionDate, _that.getAuctionDate())) return false;
			if (!Objects.equals(finalPrice, _that.getFinalPrice())) return false;
			if (!Objects.equals(recoveryPercent, _that.getRecoveryPercent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEventType != null ? creditEventType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDeterminationDate != null ? eventDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (auctionDate != null ? auctionDate.hashCode() : 0);
			_result = 31 * _result + (finalPrice != null ? finalPrice.hashCode() : 0);
			_result = 31 * _result + (recoveryPercent != null ? recoveryPercent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEvent {" +
				"creditEventType=" + this.creditEventType + ", " +
				"eventDeterminationDate=" + this.eventDeterminationDate + ", " +
				"auctionDate=" + this.auctionDate + ", " +
				"finalPrice=" + this.finalPrice + ", " +
				"recoveryPercent=" + this.recoveryPercent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"referenceInformation=" + this.referenceInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEvent  ***********************/
	class CreditEventBuilderImpl implements CreditEvent.CreditEventBuilder {
	
		protected CreditEventTypeEnum creditEventType;
		protected Date eventDeterminationDate;
		protected Date auctionDate;
		protected Price.PriceBuilder finalPrice;
		protected BigDecimal recoveryPercent;
		protected List<Resource.ResourceBuilder> publiclyAvailableInformation = new ArrayList<>();
		protected ReferenceInformation.ReferenceInformationBuilder referenceInformation;
		
		@Override
		@RosettaAttribute("creditEventType")
		@RuneAttribute("creditEventType")
		public CreditEventTypeEnum getCreditEventType() {
			return creditEventType;
		}
		
		@Override
		@RosettaAttribute("eventDeterminationDate")
		@RuneAttribute("eventDeterminationDate")
		public Date getEventDeterminationDate() {
			return eventDeterminationDate;
		}
		
		@Override
		@RosettaAttribute("auctionDate")
		@RuneAttribute("auctionDate")
		public Date getAuctionDate() {
			return auctionDate;
		}
		
		@Override
		@RosettaAttribute("finalPrice")
		@RuneAttribute("finalPrice")
		public Price.PriceBuilder getFinalPrice() {
			return finalPrice;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateFinalPrice() {
			Price.PriceBuilder result;
			if (finalPrice!=null) {
				result = finalPrice;
			}
			else {
				result = finalPrice = Price.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryPercent")
		@RuneAttribute("recoveryPercent")
		public BigDecimal getRecoveryPercent() {
			return recoveryPercent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@RuneAttribute("publiclyAvailableInformation")
		public List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int _index) {
		
			if (publiclyAvailableInformation==null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			}
			Resource.ResourceBuilder result;
			return getIndex(publiclyAvailableInformation, _index, () -> {
						Resource.ResourceBuilder newPubliclyAvailableInformation = Resource.builder();
						return newPubliclyAvailableInformation;
					});
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		@RuneAttribute("referenceInformation")
		public ReferenceInformation.ReferenceInformationBuilder getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation() {
			ReferenceInformation.ReferenceInformationBuilder result;
			if (referenceInformation!=null) {
				result = referenceInformation;
			}
			else {
				result = referenceInformation = ReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEventType")
		@RuneAttribute("creditEventType")
		public CreditEvent.CreditEventBuilder setCreditEventType(CreditEventTypeEnum _creditEventType) {
			this.creditEventType = _creditEventType == null ? null : _creditEventType;
			return this;
		}
		
		@Override
		@RosettaAttribute("eventDeterminationDate")
		@RuneAttribute("eventDeterminationDate")
		public CreditEvent.CreditEventBuilder setEventDeterminationDate(Date _eventDeterminationDate) {
			this.eventDeterminationDate = _eventDeterminationDate == null ? null : _eventDeterminationDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("auctionDate")
		@RuneAttribute("auctionDate")
		public CreditEvent.CreditEventBuilder setAuctionDate(Date _auctionDate) {
			this.auctionDate = _auctionDate == null ? null : _auctionDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("finalPrice")
		@RuneAttribute("finalPrice")
		public CreditEvent.CreditEventBuilder setFinalPrice(Price _finalPrice) {
			this.finalPrice = _finalPrice == null ? null : _finalPrice.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("recoveryPercent")
		@RuneAttribute("recoveryPercent")
		public CreditEvent.CreditEventBuilder setRecoveryPercent(BigDecimal _recoveryPercent) {
			this.recoveryPercent = _recoveryPercent == null ? null : _recoveryPercent;
			return this;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@RuneAttribute("publiclyAvailableInformation")
		public CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation) {
			if (_publiclyAvailableInformation != null) {
				this.publiclyAvailableInformation.add(_publiclyAvailableInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation, int _idx) {
			getIndex(this.publiclyAvailableInformation, _idx, () -> _publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override 
		public CreditEvent.CreditEventBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations != null) {
				for (final Resource toAdd : publiclyAvailableInformations) {
					this.publiclyAvailableInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("publiclyAvailableInformation")
		public CreditEvent.CreditEventBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations == null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			} else {
				this.publiclyAvailableInformation = publiclyAvailableInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		@RuneAttribute("referenceInformation")
		public CreditEvent.CreditEventBuilder setReferenceInformation(ReferenceInformation _referenceInformation) {
			this.referenceInformation = _referenceInformation == null ? null : _referenceInformation.toBuilder();
			return this;
		}
		
		@Override
		public CreditEvent build() {
			return new CreditEvent.CreditEventImpl(this);
		}
		
		@Override
		public CreditEvent.CreditEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvent.CreditEventBuilder prune() {
			if (finalPrice!=null && !finalPrice.prune().hasData()) finalPrice = null;
			publiclyAvailableInformation = publiclyAvailableInformation.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (referenceInformation!=null && !referenceInformation.prune().hasData()) referenceInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEventType()!=null) return true;
			if (getEventDeterminationDate()!=null) return true;
			if (getAuctionDate()!=null) return true;
			if (getFinalPrice()!=null && getFinalPrice().hasData()) return true;
			if (getRecoveryPercent()!=null) return true;
			if (getPubliclyAvailableInformation()!=null && getPubliclyAvailableInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReferenceInformation()!=null && getReferenceInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEvent.CreditEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEvent.CreditEventBuilder o = (CreditEvent.CreditEventBuilder) other;
			
			merger.mergeRosetta(getFinalPrice(), o.getFinalPrice(), this::setFinalPrice);
			merger.mergeRosetta(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::getOrCreatePubliclyAvailableInformation);
			merger.mergeRosetta(getReferenceInformation(), o.getReferenceInformation(), this::setReferenceInformation);
			
			merger.mergeBasic(getCreditEventType(), o.getCreditEventType(), this::setCreditEventType);
			merger.mergeBasic(getEventDeterminationDate(), o.getEventDeterminationDate(), this::setEventDeterminationDate);
			merger.mergeBasic(getAuctionDate(), o.getAuctionDate(), this::setAuctionDate);
			merger.mergeBasic(getRecoveryPercent(), o.getRecoveryPercent(), this::setRecoveryPercent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEvent _that = getType().cast(o);
		
			if (!Objects.equals(creditEventType, _that.getCreditEventType())) return false;
			if (!Objects.equals(eventDeterminationDate, _that.getEventDeterminationDate())) return false;
			if (!Objects.equals(auctionDate, _that.getAuctionDate())) return false;
			if (!Objects.equals(finalPrice, _that.getFinalPrice())) return false;
			if (!Objects.equals(recoveryPercent, _that.getRecoveryPercent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEventType != null ? creditEventType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDeterminationDate != null ? eventDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (auctionDate != null ? auctionDate.hashCode() : 0);
			_result = 31 * _result + (finalPrice != null ? finalPrice.hashCode() : 0);
			_result = 31 * _result + (recoveryPercent != null ? recoveryPercent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventBuilder {" +
				"creditEventType=" + this.creditEventType + ", " +
				"eventDeterminationDate=" + this.eventDeterminationDate + ", " +
				"auctionDate=" + this.auctionDate + ", " +
				"finalPrice=" + this.finalPrice + ", " +
				"recoveryPercent=" + this.recoveryPercent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"referenceInformation=" + this.referenceInformation +
			'}';
		}
	}
}
