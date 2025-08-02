package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.CreditSupportAgreementElections;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections.CreditSupportAgreementElectionsImpl;
import cdm.legaldocumentation.csa.meta.CreditSupportAgreementElectionsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;


/**
 * The set of elections which specify a Credit Support Annex or Deed.
 * @version 6.0.0
 */
@RosettaDataType(value="CreditSupportAgreementElections", builder=CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CreditSupportAgreementElections", model="Just another Rosetta model", builder=CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl.class, version="6.0.0")
public interface CreditSupportAgreementElections extends RosettaModelObject {

	CreditSupportAgreementElectionsMeta metaData = new CreditSupportAgreementElectionsMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditSupportAgreementElections build();
	
	CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder();
	
	static CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder() {
		return new CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportAgreementElections> getType() {
		return CreditSupportAgreementElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementElectionsBuilder extends CreditSupportAgreementElections, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreementElections  ***********************/
	class CreditSupportAgreementElectionsImpl implements CreditSupportAgreementElections {
		
		protected CreditSupportAgreementElectionsImpl(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
		}
		
		@Override
		public CreditSupportAgreementElections build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElections {" +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreementElections  ***********************/
	class CreditSupportAgreementElectionsBuilderImpl implements CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder {
	
		
		@Override
		public CreditSupportAgreementElections build() {
			return new CreditSupportAgreementElections.CreditSupportAgreementElectionsImpl(this);
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder o = (CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElectionsBuilder {" +
			'}';
		}
	}
}
