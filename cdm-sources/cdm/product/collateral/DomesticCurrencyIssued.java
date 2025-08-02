package cdm.product.collateral;

import cdm.product.collateral.DomesticCurrencyIssued;
import cdm.product.collateral.DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder;
import cdm.product.collateral.DomesticCurrencyIssued.DomesticCurrencyIssuedBuilderImpl;
import cdm.product.collateral.DomesticCurrencyIssued.DomesticCurrencyIssuedImpl;
import cdm.product.collateral.meta.DomesticCurrencyIssuedMeta;
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
@RosettaDataType(value="DomesticCurrencyIssued", builder=DomesticCurrencyIssued.DomesticCurrencyIssuedBuilderImpl.class, version="6.0.0")
@RuneDataType(value="DomesticCurrencyIssued", model="Just another Rosetta model", builder=DomesticCurrencyIssued.DomesticCurrencyIssuedBuilderImpl.class, version="6.0.0")
public interface DomesticCurrencyIssued extends RosettaModelObject {

	DomesticCurrencyIssuedMeta metaData = new DomesticCurrencyIssuedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies that the Security must be denominated in the domestic currency of the issuer.
	 */
	Boolean getDomesticCurrencyIssued();

	/*********************** Build Methods  ***********************/
	DomesticCurrencyIssued build();
	
	DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder toBuilder();
	
	static DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder builder() {
		return new DomesticCurrencyIssued.DomesticCurrencyIssuedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DomesticCurrencyIssued> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DomesticCurrencyIssued> getType() {
		return DomesticCurrencyIssued.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("domesticCurrencyIssued"), Boolean.class, getDomesticCurrencyIssued(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DomesticCurrencyIssuedBuilder extends DomesticCurrencyIssued, RosettaModelObjectBuilder {
		DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder setDomesticCurrencyIssued(Boolean domesticCurrencyIssued);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("domesticCurrencyIssued"), Boolean.class, getDomesticCurrencyIssued(), this);
		}
		

		DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder prune();
	}

	/*********************** Immutable Implementation of DomesticCurrencyIssued  ***********************/
	class DomesticCurrencyIssuedImpl implements DomesticCurrencyIssued {
		private final Boolean domesticCurrencyIssued;
		
		protected DomesticCurrencyIssuedImpl(DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder builder) {
			this.domesticCurrencyIssued = builder.getDomesticCurrencyIssued();
		}
		
		@Override
		@RosettaAttribute("domesticCurrencyIssued")
		@RuneAttribute("domesticCurrencyIssued")
		public Boolean getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		public DomesticCurrencyIssued build() {
			return this;
		}
		
		@Override
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder toBuilder() {
			DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder builder) {
			ofNullable(getDomesticCurrencyIssued()).ifPresent(builder::setDomesticCurrencyIssued);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DomesticCurrencyIssued _that = getType().cast(o);
		
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DomesticCurrencyIssued {" +
				"domesticCurrencyIssued=" + this.domesticCurrencyIssued +
			'}';
		}
	}

	/*********************** Builder Implementation of DomesticCurrencyIssued  ***********************/
	class DomesticCurrencyIssuedBuilderImpl implements DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder {
	
		protected Boolean domesticCurrencyIssued;
		
		@Override
		@RosettaAttribute("domesticCurrencyIssued")
		@RuneAttribute("domesticCurrencyIssued")
		public Boolean getDomesticCurrencyIssued() {
			return domesticCurrencyIssued;
		}
		
		@Override
		@RosettaAttribute("domesticCurrencyIssued")
		@RuneAttribute("domesticCurrencyIssued")
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder setDomesticCurrencyIssued(Boolean _domesticCurrencyIssued) {
			this.domesticCurrencyIssued = _domesticCurrencyIssued == null ? null : _domesticCurrencyIssued;
			return this;
		}
		
		@Override
		public DomesticCurrencyIssued build() {
			return new DomesticCurrencyIssued.DomesticCurrencyIssuedImpl(this);
		}
		
		@Override
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDomesticCurrencyIssued()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder o = (DomesticCurrencyIssued.DomesticCurrencyIssuedBuilder) other;
			
			
			merger.mergeBasic(getDomesticCurrencyIssued(), o.getDomesticCurrencyIssued(), this::setDomesticCurrencyIssued);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DomesticCurrencyIssued _that = getType().cast(o);
		
			if (!Objects.equals(domesticCurrencyIssued, _that.getDomesticCurrencyIssued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (domesticCurrencyIssued != null ? domesticCurrencyIssued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DomesticCurrencyIssuedBuilder {" +
				"domesticCurrencyIssued=" + this.domesticCurrencyIssued +
			'}';
		}
	}
}
