package cdm.product.asset;

import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.PriceReturnTerms.PriceReturnTermsBuilder;
import cdm.product.asset.PriceReturnTerms.PriceReturnTermsBuilderImpl;
import cdm.product.asset.PriceReturnTerms.PriceReturnTermsImpl;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.asset.meta.PriceReturnTermsMeta;
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
 * @version 6.0.0
 */
@RosettaDataType(value="PriceReturnTerms", builder=PriceReturnTerms.PriceReturnTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="PriceReturnTerms", model="Just another Rosetta model", builder=PriceReturnTerms.PriceReturnTermsBuilderImpl.class, version="6.0.0")
public interface PriceReturnTerms extends RosettaModelObject {

	PriceReturnTermsMeta metaData = new PriceReturnTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of return associated with the equity swap.
	 */
	ReturnTypeEnum getReturnType();
	/**
	 * Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
	 */
	BigDecimal getConversionFactor();
	/**
	 * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. &#39;Equity Performance&#39;. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
	 */
	String getPerformance();

	/*********************** Build Methods  ***********************/
	PriceReturnTerms build();
	
	PriceReturnTerms.PriceReturnTermsBuilder toBuilder();
	
	static PriceReturnTerms.PriceReturnTermsBuilder builder() {
		return new PriceReturnTerms.PriceReturnTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceReturnTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceReturnTerms> getType() {
		return PriceReturnTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceReturnTermsBuilder extends PriceReturnTerms, RosettaModelObjectBuilder {
		PriceReturnTerms.PriceReturnTermsBuilder setReturnType(ReturnTypeEnum returnType);
		PriceReturnTerms.PriceReturnTermsBuilder setConversionFactor(BigDecimal conversionFactor);
		PriceReturnTerms.PriceReturnTermsBuilder setPerformance(String performance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processor.processBasic(path.newSubPath("performance"), String.class, getPerformance(), this);
		}
		

		PriceReturnTerms.PriceReturnTermsBuilder prune();
	}

	/*********************** Immutable Implementation of PriceReturnTerms  ***********************/
	class PriceReturnTermsImpl implements PriceReturnTerms {
		private final ReturnTypeEnum returnType;
		private final BigDecimal conversionFactor;
		private final String performance;
		
		protected PriceReturnTermsImpl(PriceReturnTerms.PriceReturnTermsBuilder builder) {
			this.returnType = builder.getReturnType();
			this.conversionFactor = builder.getConversionFactor();
			this.performance = builder.getPerformance();
		}
		
		@Override
		@RosettaAttribute("returnType")
		@RuneAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("performance")
		@RuneAttribute("performance")
		public String getPerformance() {
			return performance;
		}
		
		@Override
		public PriceReturnTerms build() {
			return this;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder toBuilder() {
			PriceReturnTerms.PriceReturnTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceReturnTerms.PriceReturnTermsBuilder builder) {
			ofNullable(getReturnType()).ifPresent(builder::setReturnType);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getPerformance()).ifPresent(builder::setPerformance);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceReturnTerms {" +
				"returnType=" + this.returnType + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"performance=" + this.performance +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceReturnTerms  ***********************/
	class PriceReturnTermsBuilderImpl implements PriceReturnTerms.PriceReturnTermsBuilder {
	
		protected ReturnTypeEnum returnType;
		protected BigDecimal conversionFactor;
		protected String performance;
		
		@Override
		@RosettaAttribute("returnType")
		@RuneAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("performance")
		@RuneAttribute("performance")
		public String getPerformance() {
			return performance;
		}
		
		@Override
		@RosettaAttribute("returnType")
		@RuneAttribute("returnType")
		public PriceReturnTerms.PriceReturnTermsBuilder setReturnType(ReturnTypeEnum _returnType) {
			this.returnType = _returnType == null ? null : _returnType;
			return this;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@RuneAttribute("conversionFactor")
		public PriceReturnTerms.PriceReturnTermsBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@Override
		@RosettaAttribute("performance")
		@RuneAttribute("performance")
		public PriceReturnTerms.PriceReturnTermsBuilder setPerformance(String _performance) {
			this.performance = _performance == null ? null : _performance;
			return this;
		}
		
		@Override
		public PriceReturnTerms build() {
			return new PriceReturnTerms.PriceReturnTermsImpl(this);
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnType()!=null) return true;
			if (getConversionFactor()!=null) return true;
			if (getPerformance()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceReturnTerms.PriceReturnTermsBuilder o = (PriceReturnTerms.PriceReturnTermsBuilder) other;
			
			
			merger.mergeBasic(getReturnType(), o.getReturnType(), this::setReturnType);
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			merger.mergeBasic(getPerformance(), o.getPerformance(), this::setPerformance);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceReturnTerms _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceReturnTermsBuilder {" +
				"returnType=" + this.returnType + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"performance=" + this.performance +
			'}';
		}
	}
}
