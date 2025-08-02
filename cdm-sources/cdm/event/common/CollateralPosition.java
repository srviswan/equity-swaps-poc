package cdm.event.common;

import cdm.event.common.CollateralPosition;
import cdm.event.common.CollateralPosition.CollateralPositionBuilder;
import cdm.event.common.CollateralPosition.CollateralPositionBuilderImpl;
import cdm.event.common.CollateralPosition.CollateralPositionImpl;
import cdm.event.common.CollateralStatusEnum;
import cdm.event.common.TradeState;
import cdm.event.common.meta.CollateralPositionMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.event.position.Position;
import cdm.event.position.Position.PositionBuilder;
import cdm.event.position.Position.PositionBuilderImpl;
import cdm.event.position.Position.PositionImpl;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralTreatment.CollateralTreatmentBuilder;
import cdm.product.template.Product;
import cdm.product.template.Product.ProductBuilder;
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
 * Specifies the individual components of collateral positions.
 * @version 6.0.0
 */
@RosettaDataType(value="CollateralPosition", builder=CollateralPosition.CollateralPositionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CollateralPosition", model="Just another Rosetta model", builder=CollateralPosition.CollateralPositionBuilderImpl.class, version="6.0.0")
public interface CollateralPosition extends Position {

	CollateralPositionMeta metaData = new CollateralPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.
	 */
	CollateralTreatment getTreatment();
	/**
	 * Indicates the collateral positions settlement status.
	 */
	CollateralStatusEnum getCollateralPositionStatus();

	/*********************** Build Methods  ***********************/
	CollateralPosition build();
	
	CollateralPosition.CollateralPositionBuilder toBuilder();
	
	static CollateralPosition.CollateralPositionBuilder builder() {
		return new CollateralPosition.CollateralPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPosition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPosition> getType() {
		return CollateralPosition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("cashBalance"), processor, Money.class, getCashBalance());
		processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTradeState.class, getTradeReference());
		processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.class, getTreatment());
		processor.processBasic(path.newSubPath("collateralPositionStatus"), CollateralStatusEnum.class, getCollateralPositionStatus(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPositionBuilder extends CollateralPosition, Position.PositionBuilder {
		CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment();
		@Override
		CollateralTreatment.CollateralTreatmentBuilder getTreatment();
		@Override
		CollateralPosition.CollateralPositionBuilder addPriceQuantity(PriceQuantity priceQuantity);
		@Override
		CollateralPosition.CollateralPositionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx);
		@Override
		CollateralPosition.CollateralPositionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		@Override
		CollateralPosition.CollateralPositionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		@Override
		CollateralPosition.CollateralPositionBuilder setProduct(Product product);
		@Override
		CollateralPosition.CollateralPositionBuilder setCashBalance(Money cashBalance);
		@Override
		CollateralPosition.CollateralPositionBuilder setTradeReference(ReferenceWithMetaTradeState tradeReference);
		@Override
		CollateralPosition.CollateralPositionBuilder setTradeReferenceValue(TradeState tradeReference);
		CollateralPosition.CollateralPositionBuilder setTreatment(CollateralTreatment treatment);
		CollateralPosition.CollateralPositionBuilder setCollateralPositionStatus(CollateralStatusEnum collateralPositionStatus);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.PriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("cashBalance"), processor, Money.MoneyBuilder.class, getCashBalance());
			processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder.class, getTradeReference());
			processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.CollateralTreatmentBuilder.class, getTreatment());
			processor.processBasic(path.newSubPath("collateralPositionStatus"), CollateralStatusEnum.class, getCollateralPositionStatus(), this);
		}
		

		CollateralPosition.CollateralPositionBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPosition  ***********************/
	class CollateralPositionImpl extends Position.PositionImpl implements CollateralPosition {
		private final CollateralTreatment treatment;
		private final CollateralStatusEnum collateralPositionStatus;
		
		protected CollateralPositionImpl(CollateralPosition.CollateralPositionBuilder builder) {
			super(builder);
			this.treatment = ofNullable(builder.getTreatment()).map(f->f.build()).orElse(null);
			this.collateralPositionStatus = builder.getCollateralPositionStatus();
		}
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public CollateralTreatment getTreatment() {
			return treatment;
		}
		
		@Override
		@RosettaAttribute("collateralPositionStatus")
		@RuneAttribute("collateralPositionStatus")
		public CollateralStatusEnum getCollateralPositionStatus() {
			return collateralPositionStatus;
		}
		
		@Override
		public CollateralPosition build() {
			return this;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder toBuilder() {
			CollateralPosition.CollateralPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPosition.CollateralPositionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTreatment()).ifPresent(builder::setTreatment);
			ofNullable(getCollateralPositionStatus()).ifPresent(builder::setCollateralPositionStatus);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralPosition _that = getType().cast(o);
		
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			if (!Objects.equals(collateralPositionStatus, _that.getCollateralPositionStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			_result = 31 * _result + (collateralPositionStatus != null ? collateralPositionStatus.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPosition {" +
				"treatment=" + this.treatment + ", " +
				"collateralPositionStatus=" + this.collateralPositionStatus +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralPosition  ***********************/
	class CollateralPositionBuilderImpl extends Position.PositionBuilderImpl implements CollateralPosition.CollateralPositionBuilder {
	
		protected CollateralTreatment.CollateralTreatmentBuilder treatment;
		protected CollateralStatusEnum collateralPositionStatus;
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public CollateralTreatment.CollateralTreatmentBuilder getTreatment() {
			return treatment;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment() {
			CollateralTreatment.CollateralTreatmentBuilder result;
			if (treatment!=null) {
				result = treatment;
			}
			else {
				result = treatment = CollateralTreatment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralPositionStatus")
		@RuneAttribute("collateralPositionStatus")
		public CollateralStatusEnum getCollateralPositionStatus() {
			return collateralPositionStatus;
		}
		
		@Override
		@RosettaAttribute("priceQuantity")
		@RuneAttribute("priceQuantity")
		public CollateralPosition.CollateralPositionBuilder addPriceQuantity(PriceQuantity _priceQuantity) {
			if (_priceQuantity != null) {
				this.priceQuantity.add(_priceQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder addPriceQuantity(PriceQuantity _priceQuantity, int _idx) {
			getIndex(this.priceQuantity, _idx, () -> _priceQuantity.toBuilder());
			return this;
		}
		
		@Override 
		public CollateralPosition.CollateralPositionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys != null) {
				for (final PriceQuantity toAdd : priceQuantitys) {
					this.priceQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("priceQuantity")
		public CollateralPosition.CollateralPositionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys == null) {
				this.priceQuantity = new ArrayList<>();
			} else {
				this.priceQuantity = priceQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("product")
		@RuneAttribute("product")
		public CollateralPosition.CollateralPositionBuilder setProduct(Product _product) {
			this.product = _product == null ? null : _product.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("cashBalance")
		@RuneAttribute("cashBalance")
		public CollateralPosition.CollateralPositionBuilder setCashBalance(Money _cashBalance) {
			this.cashBalance = _cashBalance == null ? null : _cashBalance.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@RuneAttribute("tradeReference")
		public CollateralPosition.CollateralPositionBuilder setTradeReference(ReferenceWithMetaTradeState _tradeReference) {
			this.tradeReference = _tradeReference == null ? null : _tradeReference.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder setTradeReferenceValue(TradeState _tradeReference) {
			this.getOrCreateTradeReference().setValue(_tradeReference);
			return this;
		}
		
		@Override
		@RosettaAttribute("treatment")
		@RuneAttribute("treatment")
		public CollateralPosition.CollateralPositionBuilder setTreatment(CollateralTreatment _treatment) {
			this.treatment = _treatment == null ? null : _treatment.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("collateralPositionStatus")
		@RuneAttribute("collateralPositionStatus")
		public CollateralPosition.CollateralPositionBuilder setCollateralPositionStatus(CollateralStatusEnum _collateralPositionStatus) {
			this.collateralPositionStatus = _collateralPositionStatus == null ? null : _collateralPositionStatus;
			return this;
		}
		
		@Override
		public CollateralPosition build() {
			return new CollateralPosition.CollateralPositionImpl(this);
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPosition.CollateralPositionBuilder prune() {
			super.prune();
			if (treatment!=null && !treatment.prune().hasData()) treatment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTreatment()!=null && getTreatment().hasData()) return true;
			if (getCollateralPositionStatus()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPosition.CollateralPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CollateralPosition.CollateralPositionBuilder o = (CollateralPosition.CollateralPositionBuilder) other;
			
			merger.mergeRosetta(getTreatment(), o.getTreatment(), this::setTreatment);
			
			merger.mergeBasic(getCollateralPositionStatus(), o.getCollateralPositionStatus(), this::setCollateralPositionStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralPosition _that = getType().cast(o);
		
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			if (!Objects.equals(collateralPositionStatus, _that.getCollateralPositionStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			_result = 31 * _result + (collateralPositionStatus != null ? collateralPositionStatus.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPositionBuilder {" +
				"treatment=" + this.treatment + ", " +
				"collateralPositionStatus=" + this.collateralPositionStatus +
			'}' + " " + super.toString();
		}
	}
}
