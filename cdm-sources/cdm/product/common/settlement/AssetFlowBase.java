package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilder;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.product.common.settlement.AssetFlowBase;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilder;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseBuilderImpl;
import cdm.product.common.settlement.AssetFlowBase.AssetFlowBaseImpl;
import cdm.product.common.settlement.meta.AssetFlowBaseMeta;
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
 * Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
 * @version 6.0.0
 */
@RosettaDataType(value="AssetFlowBase", builder=AssetFlowBase.AssetFlowBaseBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetFlowBase", model="Just another Rosetta model", builder=AssetFlowBase.AssetFlowBaseBuilderImpl.class, version="6.0.0")
public interface AssetFlowBase extends RosettaModelObject {

	AssetFlowBaseMeta metaData = new AssetFlowBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
	 */
	NonNegativeQuantity getQuantity();
	/**
	 * Represents the object that is subject to the transfer, it could be an asset or a reference.
	 */
	Asset getAsset();
	/**
	 * Represents the date on which the transfer to due.
	 */
	AdjustableOrAdjustedOrRelativeDate getSettlementDate();

	/*********************** Build Methods  ***********************/
	AssetFlowBase build();
	
	AssetFlowBase.AssetFlowBaseBuilder toBuilder();
	
	static AssetFlowBase.AssetFlowBaseBuilder builder() {
		return new AssetFlowBase.AssetFlowBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetFlowBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetFlowBase> getType() {
		return AssetFlowBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.class, getQuantity());
		processRosetta(path.newSubPath("asset"), processor, Asset.class, getAsset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.class, getSettlementDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetFlowBaseBuilder extends AssetFlowBase, RosettaModelObjectBuilder {
		NonNegativeQuantity.NonNegativeQuantityBuilder getOrCreateQuantity();
		@Override
		NonNegativeQuantity.NonNegativeQuantityBuilder getQuantity();
		Asset.AssetBuilder getOrCreateAsset();
		@Override
		Asset.AssetBuilder getAsset();
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getSettlementDate();
		AssetFlowBase.AssetFlowBaseBuilder setQuantity(NonNegativeQuantity quantity);
		AssetFlowBase.AssetFlowBaseBuilder setAsset(Asset asset);
		AssetFlowBase.AssetFlowBaseBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantity"), processor, NonNegativeQuantity.NonNegativeQuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("asset"), processor, Asset.AssetBuilder.class, getAsset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder.class, getSettlementDate());
		}
		

		AssetFlowBase.AssetFlowBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AssetFlowBase  ***********************/
	class AssetFlowBaseImpl implements AssetFlowBase {
		private final NonNegativeQuantity quantity;
		private final Asset asset;
		private final AdjustableOrAdjustedOrRelativeDate settlementDate;
		
		protected AssetFlowBaseImpl(AssetFlowBase.AssetFlowBaseBuilder builder) {
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.asset = ofNullable(builder.getAsset()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public NonNegativeQuantity getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("asset")
		@RuneAttribute("asset")
		public Asset getAsset() {
			return asset;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AssetFlowBase build() {
			return this;
		}
		
		@Override
		public AssetFlowBase.AssetFlowBaseBuilder toBuilder() {
			AssetFlowBase.AssetFlowBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetFlowBase.AssetFlowBaseBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetFlowBase _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetFlowBase {" +
				"quantity=" + this.quantity + ", " +
				"asset=" + this.asset + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetFlowBase  ***********************/
	class AssetFlowBaseBuilderImpl implements AssetFlowBase.AssetFlowBaseBuilder {
	
		protected NonNegativeQuantity.NonNegativeQuantityBuilder quantity;
		protected Asset.AssetBuilder asset;
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder settlementDate;
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public NonNegativeQuantity.NonNegativeQuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public NonNegativeQuantity.NonNegativeQuantityBuilder getOrCreateQuantity() {
			NonNegativeQuantity.NonNegativeQuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = NonNegativeQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asset")
		@RuneAttribute("asset")
		public Asset.AssetBuilder getAsset() {
			return asset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateAsset() {
			Asset.AssetBuilder result;
			if (asset!=null) {
				result = asset;
			}
			else {
				result = asset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@RuneAttribute("quantity")
		public AssetFlowBase.AssetFlowBaseBuilder setQuantity(NonNegativeQuantity _quantity) {
			this.quantity = _quantity == null ? null : _quantity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("asset")
		@RuneAttribute("asset")
		public AssetFlowBase.AssetFlowBaseBuilder setAsset(Asset _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@RuneAttribute("settlementDate")
		public AssetFlowBase.AssetFlowBaseBuilder setSettlementDate(AdjustableOrAdjustedOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public AssetFlowBase build() {
			return new AssetFlowBase.AssetFlowBaseImpl(this);
		}
		
		@Override
		public AssetFlowBase.AssetFlowBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetFlowBase.AssetFlowBaseBuilder prune() {
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (asset!=null && !asset.prune().hasData()) asset = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getAsset()!=null && getAsset().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetFlowBase.AssetFlowBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetFlowBase.AssetFlowBaseBuilder o = (AssetFlowBase.AssetFlowBaseBuilder) other;
			
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getAsset(), o.getAsset(), this::setAsset);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetFlowBase _that = getType().cast(o);
		
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetFlowBaseBuilder {" +
				"quantity=" + this.quantity + ", " +
				"asset=" + this.asset + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}
}
