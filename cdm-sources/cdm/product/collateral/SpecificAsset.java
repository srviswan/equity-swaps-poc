package cdm.product.collateral;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.asset.common.Asset.AssetBuilderImpl;
import cdm.base.staticdata.asset.common.Asset.AssetImpl;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Cash.CashBuilder;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Commodity.CommodityBuilder;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilder;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Instrument.InstrumentBuilder;
import cdm.product.collateral.SpecificAsset;
import cdm.product.collateral.SpecificAsset.SpecificAssetBuilder;
import cdm.product.collateral.SpecificAsset.SpecificAssetBuilderImpl;
import cdm.product.collateral.SpecificAsset.SpecificAssetImpl;
import cdm.product.collateral.meta.SpecificAssetMeta;
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


/**
 * A single, specifically identified Asset chosen from the Asset data type
 * @version 6.0.0
 */
@RosettaDataType(value="SpecificAsset", builder=SpecificAsset.SpecificAssetBuilderImpl.class, version="6.0.0")
@RuneDataType(value="SpecificAsset", model="Just another Rosetta model", builder=SpecificAsset.SpecificAssetBuilderImpl.class, version="6.0.0")
public interface SpecificAsset extends Asset {

	SpecificAssetMeta metaData = new SpecificAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SpecificAsset build();
	
	SpecificAsset.SpecificAssetBuilder toBuilder();
	
	static SpecificAsset.SpecificAssetBuilder builder() {
		return new SpecificAsset.SpecificAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecificAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecificAsset> getType() {
		return SpecificAsset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Cash"), processor, Cash.class, getCash());
		processRosetta(path.newSubPath("Commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.class, getDigitalAsset());
		processRosetta(path.newSubPath("Instrument"), processor, Instrument.class, getInstrument());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecificAssetBuilder extends SpecificAsset, Asset.AssetBuilder {
		@Override
		SpecificAsset.SpecificAssetBuilder setCash(Cash _Cash);
		@Override
		SpecificAsset.SpecificAssetBuilder setCommodity(Commodity _Commodity);
		@Override
		SpecificAsset.SpecificAssetBuilder setDigitalAsset(DigitalAsset _DigitalAsset);
		@Override
		SpecificAsset.SpecificAssetBuilder setInstrument(Instrument _Instrument);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Cash"), processor, Cash.CashBuilder.class, getCash());
			processRosetta(path.newSubPath("Commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.DigitalAssetBuilder.class, getDigitalAsset());
			processRosetta(path.newSubPath("Instrument"), processor, Instrument.InstrumentBuilder.class, getInstrument());
		}
		

		SpecificAsset.SpecificAssetBuilder prune();
	}

	/*********************** Immutable Implementation of SpecificAsset  ***********************/
	class SpecificAssetImpl extends Asset.AssetImpl implements SpecificAsset {
		
		protected SpecificAssetImpl(SpecificAsset.SpecificAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public SpecificAsset build() {
			return this;
		}
		
		@Override
		public SpecificAsset.SpecificAssetBuilder toBuilder() {
			SpecificAsset.SpecificAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecificAsset.SpecificAssetBuilder builder) {
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
			return "SpecificAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SpecificAsset  ***********************/
	class SpecificAssetBuilderImpl extends Asset.AssetBuilderImpl implements SpecificAsset.SpecificAssetBuilder {
	
		
		@Override
		@RosettaAttribute("Cash")
		@RuneAttribute("Cash")
		public SpecificAsset.SpecificAssetBuilder setCash(Cash _cash) {
			this.cash = _cash == null ? null : _cash.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Commodity")
		@RuneAttribute("Commodity")
		public SpecificAsset.SpecificAssetBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("DigitalAsset")
		@RuneAttribute("DigitalAsset")
		public SpecificAsset.SpecificAssetBuilder setDigitalAsset(DigitalAsset _digitalAsset) {
			this.digitalAsset = _digitalAsset == null ? null : _digitalAsset.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("Instrument")
		@RuneAttribute("Instrument")
		public SpecificAsset.SpecificAssetBuilder setInstrument(Instrument _instrument) {
			this.instrument = _instrument == null ? null : _instrument.toBuilder();
			return this;
		}
		
		@Override
		public SpecificAsset build() {
			return new SpecificAsset.SpecificAssetImpl(this);
		}
		
		@Override
		public SpecificAsset.SpecificAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecificAsset.SpecificAssetBuilder prune() {
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
		public SpecificAsset.SpecificAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpecificAsset.SpecificAssetBuilder o = (SpecificAsset.SpecificAssetBuilder) other;
			
			
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
			return "SpecificAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
