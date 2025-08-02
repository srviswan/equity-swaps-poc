package cdm.product.collateral;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.IssuerCountryOfOrigin;
import cdm.product.collateral.IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder;
import cdm.product.collateral.IssuerCountryOfOrigin.IssuerCountryOfOriginBuilderImpl;
import cdm.product.collateral.IssuerCountryOfOrigin.IssuerCountryOfOriginImpl;
import cdm.product.collateral.meta.IssuerCountryOfOriginMeta;
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
@RosettaDataType(value="IssuerCountryOfOrigin", builder=IssuerCountryOfOrigin.IssuerCountryOfOriginBuilderImpl.class, version="6.0.0")
@RuneDataType(value="IssuerCountryOfOrigin", model="Just another Rosetta model", builder=IssuerCountryOfOrigin.IssuerCountryOfOriginBuilderImpl.class, version="6.0.0")
public interface IssuerCountryOfOrigin extends RosettaModelObject {

	IssuerCountryOfOriginMeta metaData = new IssuerCountryOfOriginMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter on the issuing entity country of origin based on the ISO Standard 3166, which is the same as filtering by eligible Sovereigns.
	 */
	ISOCountryCodeEnum getIssuerCountryOfOrigin();

	/*********************** Build Methods  ***********************/
	IssuerCountryOfOrigin build();
	
	IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder toBuilder();
	
	static IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder builder() {
		return new IssuerCountryOfOrigin.IssuerCountryOfOriginBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerCountryOfOrigin> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IssuerCountryOfOrigin> getType() {
		return IssuerCountryOfOrigin.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("issuerCountryOfOrigin"), ISOCountryCodeEnum.class, getIssuerCountryOfOrigin(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerCountryOfOriginBuilder extends IssuerCountryOfOrigin, RosettaModelObjectBuilder {
		IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder setIssuerCountryOfOrigin(ISOCountryCodeEnum issuerCountryOfOrigin);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("issuerCountryOfOrigin"), ISOCountryCodeEnum.class, getIssuerCountryOfOrigin(), this);
		}
		

		IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerCountryOfOrigin  ***********************/
	class IssuerCountryOfOriginImpl implements IssuerCountryOfOrigin {
		private final ISOCountryCodeEnum issuerCountryOfOrigin;
		
		protected IssuerCountryOfOriginImpl(IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder builder) {
			this.issuerCountryOfOrigin = builder.getIssuerCountryOfOrigin();
		}
		
		@Override
		@RosettaAttribute("issuerCountryOfOrigin")
		@RuneAttribute("issuerCountryOfOrigin")
		public ISOCountryCodeEnum getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		@Override
		public IssuerCountryOfOrigin build() {
			return this;
		}
		
		@Override
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder toBuilder() {
			IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder builder) {
			ofNullable(getIssuerCountryOfOrigin()).ifPresent(builder::setIssuerCountryOfOrigin);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerCountryOfOrigin _that = getType().cast(o);
		
			if (!Objects.equals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerCountryOfOrigin {" +
				"issuerCountryOfOrigin=" + this.issuerCountryOfOrigin +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerCountryOfOrigin  ***********************/
	class IssuerCountryOfOriginBuilderImpl implements IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder {
	
		protected ISOCountryCodeEnum issuerCountryOfOrigin;
		
		@Override
		@RosettaAttribute("issuerCountryOfOrigin")
		@RuneAttribute("issuerCountryOfOrigin")
		public ISOCountryCodeEnum getIssuerCountryOfOrigin() {
			return issuerCountryOfOrigin;
		}
		
		@Override
		@RosettaAttribute("issuerCountryOfOrigin")
		@RuneAttribute("issuerCountryOfOrigin")
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder setIssuerCountryOfOrigin(ISOCountryCodeEnum _issuerCountryOfOrigin) {
			this.issuerCountryOfOrigin = _issuerCountryOfOrigin == null ? null : _issuerCountryOfOrigin;
			return this;
		}
		
		@Override
		public IssuerCountryOfOrigin build() {
			return new IssuerCountryOfOrigin.IssuerCountryOfOriginImpl(this);
		}
		
		@Override
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerCountryOfOrigin()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder o = (IssuerCountryOfOrigin.IssuerCountryOfOriginBuilder) other;
			
			
			merger.mergeBasic(getIssuerCountryOfOrigin(), o.getIssuerCountryOfOrigin(), this::setIssuerCountryOfOrigin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerCountryOfOrigin _that = getType().cast(o);
		
			if (!Objects.equals(issuerCountryOfOrigin, _that.getIssuerCountryOfOrigin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerCountryOfOrigin != null ? issuerCountryOfOrigin.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerCountryOfOriginBuilder {" +
				"issuerCountryOfOrigin=" + this.issuerCountryOfOrigin +
			'}';
		}
	}
}
