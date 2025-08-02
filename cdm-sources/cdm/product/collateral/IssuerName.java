package cdm.product.collateral;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import cdm.product.collateral.IssuerName;
import cdm.product.collateral.IssuerName.IssuerNameBuilder;
import cdm.product.collateral.IssuerName.IssuerNameBuilderImpl;
import cdm.product.collateral.IssuerName.IssuerNameImpl;
import cdm.product.collateral.meta.IssuerNameMeta;
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
@RosettaDataType(value="IssuerName", builder=IssuerName.IssuerNameBuilderImpl.class, version="6.0.0")
@RuneDataType(value="IssuerName", model="Just another Rosetta model", builder=IssuerName.IssuerNameBuilderImpl.class, version="6.0.0")
public interface IssuerName extends RosettaModelObject {

	IssuerNameMeta metaData = new IssuerNameMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the issuing entity name or LEI.
	 */
	LegalEntity getIssuerName();

	/*********************** Build Methods  ***********************/
	IssuerName build();
	
	IssuerName.IssuerNameBuilder toBuilder();
	
	static IssuerName.IssuerNameBuilder builder() {
		return new IssuerName.IssuerNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IssuerName> getType() {
		return IssuerName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuerName"), processor, LegalEntity.class, getIssuerName());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerNameBuilder extends IssuerName, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateIssuerName();
		@Override
		LegalEntity.LegalEntityBuilder getIssuerName();
		IssuerName.IssuerNameBuilder setIssuerName(LegalEntity issuerName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuerName"), processor, LegalEntity.LegalEntityBuilder.class, getIssuerName());
		}
		

		IssuerName.IssuerNameBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerName  ***********************/
	class IssuerNameImpl implements IssuerName {
		private final LegalEntity issuerName;
		
		protected IssuerNameImpl(IssuerName.IssuerNameBuilder builder) {
			this.issuerName = ofNullable(builder.getIssuerName()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuerName")
		@RuneAttribute("issuerName")
		public LegalEntity getIssuerName() {
			return issuerName;
		}
		
		@Override
		public IssuerName build() {
			return this;
		}
		
		@Override
		public IssuerName.IssuerNameBuilder toBuilder() {
			IssuerName.IssuerNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerName.IssuerNameBuilder builder) {
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerName _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerName {" +
				"issuerName=" + this.issuerName +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerName  ***********************/
	class IssuerNameBuilderImpl implements IssuerName.IssuerNameBuilder {
	
		protected LegalEntity.LegalEntityBuilder issuerName;
		
		@Override
		@RosettaAttribute("issuerName")
		@RuneAttribute("issuerName")
		public LegalEntity.LegalEntityBuilder getIssuerName() {
			return issuerName;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateIssuerName() {
			LegalEntity.LegalEntityBuilder result;
			if (issuerName!=null) {
				result = issuerName;
			}
			else {
				result = issuerName = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerName")
		@RuneAttribute("issuerName")
		public IssuerName.IssuerNameBuilder setIssuerName(LegalEntity _issuerName) {
			this.issuerName = _issuerName == null ? null : _issuerName.toBuilder();
			return this;
		}
		
		@Override
		public IssuerName build() {
			return new IssuerName.IssuerNameImpl(this);
		}
		
		@Override
		public IssuerName.IssuerNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerName.IssuerNameBuilder prune() {
			if (issuerName!=null && !issuerName.prune().hasData()) issuerName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerName()!=null && getIssuerName().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerName.IssuerNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerName.IssuerNameBuilder o = (IssuerName.IssuerNameBuilder) other;
			
			merger.mergeRosetta(getIssuerName(), o.getIssuerName(), this::setIssuerName);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerName _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerNameBuilder {" +
				"issuerName=" + this.issuerName +
			'}';
		}
	}
}
