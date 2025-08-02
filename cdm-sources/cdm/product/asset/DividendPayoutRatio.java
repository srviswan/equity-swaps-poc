package cdm.product.asset;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.metafields.ReferenceWithMetaBasketConstituent;
import cdm.observable.asset.metafields.ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder;
import cdm.product.asset.DividendPayoutRatio;
import cdm.product.asset.DividendPayoutRatio.DividendPayoutRatioBuilder;
import cdm.product.asset.DividendPayoutRatio.DividendPayoutRatioBuilderImpl;
import cdm.product.asset.DividendPayoutRatio.DividendPayoutRatioImpl;
import cdm.product.asset.meta.DividendPayoutRatioMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class describing the dividend payout ratio associated with an equity underlier. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 * @version 6.0.0
 */
@RosettaDataType(value="DividendPayoutRatio", builder=DividendPayoutRatio.DividendPayoutRatioBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DividendPayoutRatio", model="Just another Rosetta model", builder=DividendPayoutRatio.DividendPayoutRatioBuilderImpl.class, version="6.0.0")
public interface DividendPayoutRatio extends RosettaModelObject {

	DividendPayoutRatioMeta metaData = new DividendPayoutRatioMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the total actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getTotalRatio();
	/**
	 * Specifies the cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getCashRatio();
	/**
	 * Specifies the non cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getNonCashRatio();
	/**
	 * In the case of a basket underlier, specifies to which component of the basket this particular set of dividend payout ratios correspond.
	 */
	ReferenceWithMetaBasketConstituent getBasketConstituent();

	/*********************** Build Methods  ***********************/
	DividendPayoutRatio build();
	
	DividendPayoutRatio.DividendPayoutRatioBuilder toBuilder();
	
	static DividendPayoutRatio.DividendPayoutRatioBuilder builder() {
		return new DividendPayoutRatio.DividendPayoutRatioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPayoutRatio> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPayoutRatio> getType() {
		return DividendPayoutRatio.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("totalRatio"), BigDecimal.class, getTotalRatio(), this);
		processor.processBasic(path.newSubPath("cashRatio"), BigDecimal.class, getCashRatio(), this);
		processor.processBasic(path.newSubPath("nonCashRatio"), BigDecimal.class, getNonCashRatio(), this);
		processRosetta(path.newSubPath("basketConstituent"), processor, ReferenceWithMetaBasketConstituent.class, getBasketConstituent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPayoutRatioBuilder extends DividendPayoutRatio, RosettaModelObjectBuilder {
		ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder getOrCreateBasketConstituent();
		@Override
		ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder getBasketConstituent();
		DividendPayoutRatio.DividendPayoutRatioBuilder setTotalRatio(BigDecimal totalRatio);
		DividendPayoutRatio.DividendPayoutRatioBuilder setCashRatio(BigDecimal cashRatio);
		DividendPayoutRatio.DividendPayoutRatioBuilder setNonCashRatio(BigDecimal nonCashRatio);
		DividendPayoutRatio.DividendPayoutRatioBuilder setBasketConstituent(ReferenceWithMetaBasketConstituent basketConstituent);
		DividendPayoutRatio.DividendPayoutRatioBuilder setBasketConstituentValue(BasketConstituent basketConstituent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("totalRatio"), BigDecimal.class, getTotalRatio(), this);
			processor.processBasic(path.newSubPath("cashRatio"), BigDecimal.class, getCashRatio(), this);
			processor.processBasic(path.newSubPath("nonCashRatio"), BigDecimal.class, getNonCashRatio(), this);
			processRosetta(path.newSubPath("basketConstituent"), processor, ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder.class, getBasketConstituent());
		}
		

		DividendPayoutRatio.DividendPayoutRatioBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPayoutRatio  ***********************/
	class DividendPayoutRatioImpl implements DividendPayoutRatio {
		private final BigDecimal totalRatio;
		private final BigDecimal cashRatio;
		private final BigDecimal nonCashRatio;
		private final ReferenceWithMetaBasketConstituent basketConstituent;
		
		protected DividendPayoutRatioImpl(DividendPayoutRatio.DividendPayoutRatioBuilder builder) {
			this.totalRatio = builder.getTotalRatio();
			this.cashRatio = builder.getCashRatio();
			this.nonCashRatio = builder.getNonCashRatio();
			this.basketConstituent = ofNullable(builder.getBasketConstituent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("totalRatio")
		@RuneAttribute("totalRatio")
		public BigDecimal getTotalRatio() {
			return totalRatio;
		}
		
		@Override
		@RosettaAttribute("cashRatio")
		@RuneAttribute("cashRatio")
		public BigDecimal getCashRatio() {
			return cashRatio;
		}
		
		@Override
		@RosettaAttribute("nonCashRatio")
		@RuneAttribute("nonCashRatio")
		public BigDecimal getNonCashRatio() {
			return nonCashRatio;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public ReferenceWithMetaBasketConstituent getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public DividendPayoutRatio build() {
			return this;
		}
		
		@Override
		public DividendPayoutRatio.DividendPayoutRatioBuilder toBuilder() {
			DividendPayoutRatio.DividendPayoutRatioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPayoutRatio.DividendPayoutRatioBuilder builder) {
			ofNullable(getTotalRatio()).ifPresent(builder::setTotalRatio);
			ofNullable(getCashRatio()).ifPresent(builder::setCashRatio);
			ofNullable(getNonCashRatio()).ifPresent(builder::setNonCashRatio);
			ofNullable(getBasketConstituent()).ifPresent(builder::setBasketConstituent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayoutRatio _that = getType().cast(o);
		
			if (!Objects.equals(totalRatio, _that.getTotalRatio())) return false;
			if (!Objects.equals(cashRatio, _that.getCashRatio())) return false;
			if (!Objects.equals(nonCashRatio, _that.getNonCashRatio())) return false;
			if (!Objects.equals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalRatio != null ? totalRatio.hashCode() : 0);
			_result = 31 * _result + (cashRatio != null ? cashRatio.hashCode() : 0);
			_result = 31 * _result + (nonCashRatio != null ? nonCashRatio.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutRatio {" +
				"totalRatio=" + this.totalRatio + ", " +
				"cashRatio=" + this.cashRatio + ", " +
				"nonCashRatio=" + this.nonCashRatio + ", " +
				"basketConstituent=" + this.basketConstituent +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPayoutRatio  ***********************/
	class DividendPayoutRatioBuilderImpl implements DividendPayoutRatio.DividendPayoutRatioBuilder {
	
		protected BigDecimal totalRatio;
		protected BigDecimal cashRatio;
		protected BigDecimal nonCashRatio;
		protected ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituent;
		
		@Override
		@RosettaAttribute("totalRatio")
		@RuneAttribute("totalRatio")
		public BigDecimal getTotalRatio() {
			return totalRatio;
		}
		
		@Override
		@RosettaAttribute("cashRatio")
		@RuneAttribute("cashRatio")
		public BigDecimal getCashRatio() {
			return cashRatio;
		}
		
		@Override
		@RosettaAttribute("nonCashRatio")
		@RuneAttribute("nonCashRatio")
		public BigDecimal getNonCashRatio() {
			return nonCashRatio;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder getBasketConstituent() {
			return basketConstituent;
		}
		
		@Override
		public ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder getOrCreateBasketConstituent() {
			ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder result;
			if (basketConstituent!=null) {
				result = basketConstituent;
			}
			else {
				result = basketConstituent = ReferenceWithMetaBasketConstituent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalRatio")
		@RuneAttribute("totalRatio")
		public DividendPayoutRatio.DividendPayoutRatioBuilder setTotalRatio(BigDecimal _totalRatio) {
			this.totalRatio = _totalRatio == null ? null : _totalRatio;
			return this;
		}
		
		@Override
		@RosettaAttribute("cashRatio")
		@RuneAttribute("cashRatio")
		public DividendPayoutRatio.DividendPayoutRatioBuilder setCashRatio(BigDecimal _cashRatio) {
			this.cashRatio = _cashRatio == null ? null : _cashRatio;
			return this;
		}
		
		@Override
		@RosettaAttribute("nonCashRatio")
		@RuneAttribute("nonCashRatio")
		public DividendPayoutRatio.DividendPayoutRatioBuilder setNonCashRatio(BigDecimal _nonCashRatio) {
			this.nonCashRatio = _nonCashRatio == null ? null : _nonCashRatio;
			return this;
		}
		
		@Override
		@RosettaAttribute("basketConstituent")
		@RuneAttribute("basketConstituent")
		public DividendPayoutRatio.DividendPayoutRatioBuilder setBasketConstituent(ReferenceWithMetaBasketConstituent _basketConstituent) {
			this.basketConstituent = _basketConstituent == null ? null : _basketConstituent.toBuilder();
			return this;
		}
		
		@Override
		public DividendPayoutRatio.DividendPayoutRatioBuilder setBasketConstituentValue(BasketConstituent _basketConstituent) {
			this.getOrCreateBasketConstituent().setValue(_basketConstituent);
			return this;
		}
		
		@Override
		public DividendPayoutRatio build() {
			return new DividendPayoutRatio.DividendPayoutRatioImpl(this);
		}
		
		@Override
		public DividendPayoutRatio.DividendPayoutRatioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayoutRatio.DividendPayoutRatioBuilder prune() {
			if (basketConstituent!=null && !basketConstituent.prune().hasData()) basketConstituent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTotalRatio()!=null) return true;
			if (getCashRatio()!=null) return true;
			if (getNonCashRatio()!=null) return true;
			if (getBasketConstituent()!=null && getBasketConstituent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayoutRatio.DividendPayoutRatioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPayoutRatio.DividendPayoutRatioBuilder o = (DividendPayoutRatio.DividendPayoutRatioBuilder) other;
			
			merger.mergeRosetta(getBasketConstituent(), o.getBasketConstituent(), this::setBasketConstituent);
			
			merger.mergeBasic(getTotalRatio(), o.getTotalRatio(), this::setTotalRatio);
			merger.mergeBasic(getCashRatio(), o.getCashRatio(), this::setCashRatio);
			merger.mergeBasic(getNonCashRatio(), o.getNonCashRatio(), this::setNonCashRatio);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayoutRatio _that = getType().cast(o);
		
			if (!Objects.equals(totalRatio, _that.getTotalRatio())) return false;
			if (!Objects.equals(cashRatio, _that.getCashRatio())) return false;
			if (!Objects.equals(nonCashRatio, _that.getNonCashRatio())) return false;
			if (!Objects.equals(basketConstituent, _that.getBasketConstituent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalRatio != null ? totalRatio.hashCode() : 0);
			_result = 31 * _result + (cashRatio != null ? cashRatio.hashCode() : 0);
			_result = 31 * _result + (nonCashRatio != null ? nonCashRatio.hashCode() : 0);
			_result = 31 * _result + (basketConstituent != null ? basketConstituent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutRatioBuilder {" +
				"totalRatio=" + this.totalRatio + ", " +
				"cashRatio=" + this.cashRatio + ", " +
				"nonCashRatio=" + this.nonCashRatio + ", " +
				"basketConstituent=" + this.basketConstituent +
			'}';
		}
	}
}
