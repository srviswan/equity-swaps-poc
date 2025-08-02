package cdm.product.collateral;

import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import cdm.product.collateral.NegativeCriteria;
import cdm.product.collateral.NegativeCriteria.NegativeCriteriaBuilder;
import cdm.product.collateral.NegativeCriteria.NegativeCriteriaBuilderImpl;
import cdm.product.collateral.NegativeCriteria.NegativeCriteriaImpl;
import cdm.product.collateral.meta.NegativeCriteriaMeta;
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
 * Used to apply a NOT logic condition to a single Collateral Criteria.
 * @version 6.0.0
 */
@RosettaDataType(value="NegativeCriteria", builder=NegativeCriteria.NegativeCriteriaBuilderImpl.class, version="6.0.0")
@RuneDataType(value="NegativeCriteria", model="Just another Rosetta model", builder=NegativeCriteria.NegativeCriteriaBuilderImpl.class, version="6.0.0")
public interface NegativeCriteria extends RosettaModelObject {

	NegativeCriteriaMeta metaData = new NegativeCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	CollateralCriteria getNegativeCriteria();

	/*********************** Build Methods  ***********************/
	NegativeCriteria build();
	
	NegativeCriteria.NegativeCriteriaBuilder toBuilder();
	
	static NegativeCriteria.NegativeCriteriaBuilder builder() {
		return new NegativeCriteria.NegativeCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NegativeCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NegativeCriteria> getType() {
		return NegativeCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("negativeCriteria"), processor, CollateralCriteria.class, getNegativeCriteria());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NegativeCriteriaBuilder extends NegativeCriteria, RosettaModelObjectBuilder {
		CollateralCriteria.CollateralCriteriaBuilder getOrCreateNegativeCriteria();
		@Override
		CollateralCriteria.CollateralCriteriaBuilder getNegativeCriteria();
		NegativeCriteria.NegativeCriteriaBuilder setNegativeCriteria(CollateralCriteria negativeCriteria);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("negativeCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getNegativeCriteria());
		}
		

		NegativeCriteria.NegativeCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of NegativeCriteria  ***********************/
	class NegativeCriteriaImpl implements NegativeCriteria {
		private final CollateralCriteria negativeCriteria;
		
		protected NegativeCriteriaImpl(NegativeCriteria.NegativeCriteriaBuilder builder) {
			this.negativeCriteria = ofNullable(builder.getNegativeCriteria()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("negativeCriteria")
		@RuneAttribute("negativeCriteria")
		public CollateralCriteria getNegativeCriteria() {
			return negativeCriteria;
		}
		
		@Override
		public NegativeCriteria build() {
			return this;
		}
		
		@Override
		public NegativeCriteria.NegativeCriteriaBuilder toBuilder() {
			NegativeCriteria.NegativeCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NegativeCriteria.NegativeCriteriaBuilder builder) {
			ofNullable(getNegativeCriteria()).ifPresent(builder::setNegativeCriteria);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NegativeCriteria _that = getType().cast(o);
		
			if (!Objects.equals(negativeCriteria, _that.getNegativeCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (negativeCriteria != null ? negativeCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NegativeCriteria {" +
				"negativeCriteria=" + this.negativeCriteria +
			'}';
		}
	}

	/*********************** Builder Implementation of NegativeCriteria  ***********************/
	class NegativeCriteriaBuilderImpl implements NegativeCriteria.NegativeCriteriaBuilder {
	
		protected CollateralCriteria.CollateralCriteriaBuilder negativeCriteria;
		
		@Override
		@RosettaAttribute("negativeCriteria")
		@RuneAttribute("negativeCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder getNegativeCriteria() {
			return negativeCriteria;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder getOrCreateNegativeCriteria() {
			CollateralCriteria.CollateralCriteriaBuilder result;
			if (negativeCriteria!=null) {
				result = negativeCriteria;
			}
			else {
				result = negativeCriteria = CollateralCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("negativeCriteria")
		@RuneAttribute("negativeCriteria")
		public NegativeCriteria.NegativeCriteriaBuilder setNegativeCriteria(CollateralCriteria _negativeCriteria) {
			this.negativeCriteria = _negativeCriteria == null ? null : _negativeCriteria.toBuilder();
			return this;
		}
		
		@Override
		public NegativeCriteria build() {
			return new NegativeCriteria.NegativeCriteriaImpl(this);
		}
		
		@Override
		public NegativeCriteria.NegativeCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NegativeCriteria.NegativeCriteriaBuilder prune() {
			if (negativeCriteria!=null && !negativeCriteria.prune().hasData()) negativeCriteria = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNegativeCriteria()!=null && getNegativeCriteria().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NegativeCriteria.NegativeCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NegativeCriteria.NegativeCriteriaBuilder o = (NegativeCriteria.NegativeCriteriaBuilder) other;
			
			merger.mergeRosetta(getNegativeCriteria(), o.getNegativeCriteria(), this::setNegativeCriteria);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NegativeCriteria _that = getType().cast(o);
		
			if (!Objects.equals(negativeCriteria, _that.getNegativeCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (negativeCriteria != null ? negativeCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NegativeCriteriaBuilder {" +
				"negativeCriteria=" + this.negativeCriteria +
			'}';
		}
	}
}
