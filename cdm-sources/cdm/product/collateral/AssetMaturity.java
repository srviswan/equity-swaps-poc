package cdm.product.collateral;

import cdm.base.datetime.PeriodRange;
import cdm.base.datetime.PeriodRange.PeriodRangeBuilder;
import cdm.base.staticdata.asset.common.MaturityTypeEnum;
import cdm.product.collateral.AssetMaturity;
import cdm.product.collateral.AssetMaturity.AssetMaturityBuilder;
import cdm.product.collateral.AssetMaturity.AssetMaturityBuilderImpl;
import cdm.product.collateral.AssetMaturity.AssetMaturityImpl;
import cdm.product.collateral.meta.AssetMaturityMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="AssetMaturity", builder=AssetMaturity.AssetMaturityBuilderImpl.class, version="6.0.0")
@RuneDataType(value="AssetMaturity", model="Just another Rosetta model", builder=AssetMaturity.AssetMaturityBuilderImpl.class, version="6.0.0")
public interface AssetMaturity extends RosettaModelObject {

	AssetMaturityMeta metaData = new AssetMaturityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the maturity range is the remaining or original maturity.
	 */
	MaturityTypeEnum getMaturityType();
	/**
	 * Represents a filter based on the underlying asset maturity.
	 */
	PeriodRange getMaturityRange();

	/*********************** Build Methods  ***********************/
	AssetMaturity build();
	
	AssetMaturity.AssetMaturityBuilder toBuilder();
	
	static AssetMaturity.AssetMaturityBuilder builder() {
		return new AssetMaturity.AssetMaturityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetMaturity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetMaturity> getType() {
		return AssetMaturity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maturityType"), MaturityTypeEnum.class, getMaturityType(), this);
		processRosetta(path.newSubPath("maturityRange"), processor, PeriodRange.class, getMaturityRange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetMaturityBuilder extends AssetMaturity, RosettaModelObjectBuilder {
		PeriodRange.PeriodRangeBuilder getOrCreateMaturityRange();
		@Override
		PeriodRange.PeriodRangeBuilder getMaturityRange();
		AssetMaturity.AssetMaturityBuilder setMaturityType(MaturityTypeEnum maturityType);
		AssetMaturity.AssetMaturityBuilder setMaturityRange(PeriodRange maturityRange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maturityType"), MaturityTypeEnum.class, getMaturityType(), this);
			processRosetta(path.newSubPath("maturityRange"), processor, PeriodRange.PeriodRangeBuilder.class, getMaturityRange());
		}
		

		AssetMaturity.AssetMaturityBuilder prune();
	}

	/*********************** Immutable Implementation of AssetMaturity  ***********************/
	class AssetMaturityImpl implements AssetMaturity {
		private final MaturityTypeEnum maturityType;
		private final PeriodRange maturityRange;
		
		protected AssetMaturityImpl(AssetMaturity.AssetMaturityBuilder builder) {
			this.maturityType = builder.getMaturityType();
			this.maturityRange = ofNullable(builder.getMaturityRange()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("maturityType")
		@RuneAttribute("maturityType")
		public MaturityTypeEnum getMaturityType() {
			return maturityType;
		}
		
		@Override
		@RosettaAttribute("maturityRange")
		@RuneAttribute("maturityRange")
		public PeriodRange getMaturityRange() {
			return maturityRange;
		}
		
		@Override
		public AssetMaturity build() {
			return this;
		}
		
		@Override
		public AssetMaturity.AssetMaturityBuilder toBuilder() {
			AssetMaturity.AssetMaturityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetMaturity.AssetMaturityBuilder builder) {
			ofNullable(getMaturityType()).ifPresent(builder::setMaturityType);
			ofNullable(getMaturityRange()).ifPresent(builder::setMaturityRange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetMaturity _that = getType().cast(o);
		
			if (!Objects.equals(maturityType, _that.getMaturityType())) return false;
			if (!Objects.equals(maturityRange, _that.getMaturityRange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maturityType != null ? maturityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maturityRange != null ? maturityRange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetMaturity {" +
				"maturityType=" + this.maturityType + ", " +
				"maturityRange=" + this.maturityRange +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetMaturity  ***********************/
	class AssetMaturityBuilderImpl implements AssetMaturity.AssetMaturityBuilder {
	
		protected MaturityTypeEnum maturityType;
		protected PeriodRange.PeriodRangeBuilder maturityRange;
		
		@Override
		@RosettaAttribute("maturityType")
		@RuneAttribute("maturityType")
		public MaturityTypeEnum getMaturityType() {
			return maturityType;
		}
		
		@Override
		@RosettaAttribute("maturityRange")
		@RuneAttribute("maturityRange")
		public PeriodRange.PeriodRangeBuilder getMaturityRange() {
			return maturityRange;
		}
		
		@Override
		public PeriodRange.PeriodRangeBuilder getOrCreateMaturityRange() {
			PeriodRange.PeriodRangeBuilder result;
			if (maturityRange!=null) {
				result = maturityRange;
			}
			else {
				result = maturityRange = PeriodRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maturityType")
		@RuneAttribute("maturityType")
		public AssetMaturity.AssetMaturityBuilder setMaturityType(MaturityTypeEnum _maturityType) {
			this.maturityType = _maturityType == null ? null : _maturityType;
			return this;
		}
		
		@Override
		@RosettaAttribute("maturityRange")
		@RuneAttribute("maturityRange")
		public AssetMaturity.AssetMaturityBuilder setMaturityRange(PeriodRange _maturityRange) {
			this.maturityRange = _maturityRange == null ? null : _maturityRange.toBuilder();
			return this;
		}
		
		@Override
		public AssetMaturity build() {
			return new AssetMaturity.AssetMaturityImpl(this);
		}
		
		@Override
		public AssetMaturity.AssetMaturityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetMaturity.AssetMaturityBuilder prune() {
			if (maturityRange!=null && !maturityRange.prune().hasData()) maturityRange = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaturityType()!=null) return true;
			if (getMaturityRange()!=null && getMaturityRange().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetMaturity.AssetMaturityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetMaturity.AssetMaturityBuilder o = (AssetMaturity.AssetMaturityBuilder) other;
			
			merger.mergeRosetta(getMaturityRange(), o.getMaturityRange(), this::setMaturityRange);
			
			merger.mergeBasic(getMaturityType(), o.getMaturityType(), this::setMaturityType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetMaturity _that = getType().cast(o);
		
			if (!Objects.equals(maturityType, _that.getMaturityType())) return false;
			if (!Objects.equals(maturityRange, _that.getMaturityRange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maturityType != null ? maturityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maturityRange != null ? maturityRange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetMaturityBuilder {" +
				"maturityType=" + this.maturityType + ", " +
				"maturityRange=" + this.maturityRange +
			'}';
		}
	}
}
