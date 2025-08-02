package cdm.product.collateral;

import cdm.product.collateral.CounterpartyOwnIssuePermitted;
import cdm.product.collateral.CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder;
import cdm.product.collateral.CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilderImpl;
import cdm.product.collateral.CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedImpl;
import cdm.product.collateral.meta.CounterpartyOwnIssuePermittedMeta;
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
@RosettaDataType(value="CounterpartyOwnIssuePermitted", builder=CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CounterpartyOwnIssuePermitted", model="Just another Rosetta model", builder=CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilderImpl.class, version="6.0.0")
public interface CounterpartyOwnIssuePermitted extends RosettaModelObject {

	CounterpartyOwnIssuePermittedMeta metaData = new CounterpartyOwnIssuePermittedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter based on whether it is permitted for the underlying asset to be issued by the posting entity or part of their corporate family.
	 */
	Boolean getCounterpartyOwnIssuePermitted();

	/*********************** Build Methods  ***********************/
	CounterpartyOwnIssuePermitted build();
	
	CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder toBuilder();
	
	static CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder builder() {
		return new CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartyOwnIssuePermitted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartyOwnIssuePermitted> getType() {
		return CounterpartyOwnIssuePermitted.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("counterpartyOwnIssuePermitted"), Boolean.class, getCounterpartyOwnIssuePermitted(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartyOwnIssuePermittedBuilder extends CounterpartyOwnIssuePermitted, RosettaModelObjectBuilder {
		CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder setCounterpartyOwnIssuePermitted(Boolean counterpartyOwnIssuePermitted);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("counterpartyOwnIssuePermitted"), Boolean.class, getCounterpartyOwnIssuePermitted(), this);
		}
		

		CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder prune();
	}

	/*********************** Immutable Implementation of CounterpartyOwnIssuePermitted  ***********************/
	class CounterpartyOwnIssuePermittedImpl implements CounterpartyOwnIssuePermitted {
		private final Boolean counterpartyOwnIssuePermitted;
		
		protected CounterpartyOwnIssuePermittedImpl(CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder builder) {
			this.counterpartyOwnIssuePermitted = builder.getCounterpartyOwnIssuePermitted();
		}
		
		@Override
		@RosettaAttribute("counterpartyOwnIssuePermitted")
		@RuneAttribute("counterpartyOwnIssuePermitted")
		public Boolean getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		public CounterpartyOwnIssuePermitted build() {
			return this;
		}
		
		@Override
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder toBuilder() {
			CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder builder) {
			ofNullable(getCounterpartyOwnIssuePermitted()).ifPresent(builder::setCounterpartyOwnIssuePermitted);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyOwnIssuePermitted _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyOwnIssuePermitted {" +
				"counterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartyOwnIssuePermitted  ***********************/
	class CounterpartyOwnIssuePermittedBuilderImpl implements CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder {
	
		protected Boolean counterpartyOwnIssuePermitted;
		
		@Override
		@RosettaAttribute("counterpartyOwnIssuePermitted")
		@RuneAttribute("counterpartyOwnIssuePermitted")
		public Boolean getCounterpartyOwnIssuePermitted() {
			return counterpartyOwnIssuePermitted;
		}
		
		@Override
		@RosettaAttribute("counterpartyOwnIssuePermitted")
		@RuneAttribute("counterpartyOwnIssuePermitted")
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder setCounterpartyOwnIssuePermitted(Boolean _counterpartyOwnIssuePermitted) {
			this.counterpartyOwnIssuePermitted = _counterpartyOwnIssuePermitted == null ? null : _counterpartyOwnIssuePermitted;
			return this;
		}
		
		@Override
		public CounterpartyOwnIssuePermitted build() {
			return new CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedImpl(this);
		}
		
		@Override
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCounterpartyOwnIssuePermitted()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder o = (CounterpartyOwnIssuePermitted.CounterpartyOwnIssuePermittedBuilder) other;
			
			
			merger.mergeBasic(getCounterpartyOwnIssuePermitted(), o.getCounterpartyOwnIssuePermitted(), this::setCounterpartyOwnIssuePermitted);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyOwnIssuePermitted _that = getType().cast(o);
		
			if (!Objects.equals(counterpartyOwnIssuePermitted, _that.getCounterpartyOwnIssuePermitted())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (counterpartyOwnIssuePermitted != null ? counterpartyOwnIssuePermitted.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyOwnIssuePermittedBuilder {" +
				"counterpartyOwnIssuePermitted=" + this.counterpartyOwnIssuePermitted +
			'}';
		}
	}
}
