package cdm.event.workflow;

import cdm.event.workflow.CreditLimitUtilisationPosition;
import cdm.event.workflow.CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder;
import cdm.event.workflow.CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl;
import cdm.event.workflow.CreditLimitUtilisationPosition.CreditLimitUtilisationPositionImpl;
import cdm.event.workflow.meta.CreditLimitUtilisationPositionMeta;
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
@RosettaDataType(value="CreditLimitUtilisationPosition", builder=CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CreditLimitUtilisationPosition", model="Just another Rosetta model", builder=CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl.class, version="6.0.0")
public interface CreditLimitUtilisationPosition extends RosettaModelObject {

	CreditLimitUtilisationPositionMeta metaData = new CreditLimitUtilisationPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Credit limit utilisation attributable to short positions.
	 */
	BigDecimal getShortPosition();
	/**
	 * Credit limit utilisation attributable to long positions.
	 */
	BigDecimal getLongPosition();
	/**
	 * Global credit limit utilisation amount, agnostic of long/short position direction.
	 */
	BigDecimal getGlobal();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilisationPosition build();
	
	CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder();
	
	static CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder() {
		return new CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilisationPosition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimitUtilisationPosition> getType() {
		return CreditLimitUtilisationPosition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("shortPosition"), BigDecimal.class, getShortPosition(), this);
		processor.processBasic(path.newSubPath("longPosition"), BigDecimal.class, getLongPosition(), this);
		processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilisationPositionBuilder extends CreditLimitUtilisationPosition, RosettaModelObjectBuilder {
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setShortPosition(BigDecimal shortPosition);
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setLongPosition(BigDecimal longPosition);
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setGlobal(BigDecimal global);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("shortPosition"), BigDecimal.class, getShortPosition(), this);
			processor.processBasic(path.newSubPath("longPosition"), BigDecimal.class, getLongPosition(), this);
			processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
		}
		

		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilisationPosition  ***********************/
	class CreditLimitUtilisationPositionImpl implements CreditLimitUtilisationPosition {
		private final BigDecimal shortPosition;
		private final BigDecimal longPosition;
		private final BigDecimal global;
		
		protected CreditLimitUtilisationPositionImpl(CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder) {
			this.shortPosition = builder.getShortPosition();
			this.longPosition = builder.getLongPosition();
			this.global = builder.getGlobal();
		}
		
		@Override
		@RosettaAttribute("shortPosition")
		@RuneAttribute("shortPosition")
		public BigDecimal getShortPosition() {
			return shortPosition;
		}
		
		@Override
		@RosettaAttribute("longPosition")
		@RuneAttribute("longPosition")
		public BigDecimal getLongPosition() {
			return longPosition;
		}
		
		@Override
		@RosettaAttribute("global")
		@RuneAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public CreditLimitUtilisationPosition build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder() {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder) {
			ofNullable(getShortPosition()).ifPresent(builder::setShortPosition);
			ofNullable(getLongPosition()).ifPresent(builder::setLongPosition);
			ofNullable(getGlobal()).ifPresent(builder::setGlobal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisationPosition _that = getType().cast(o);
		
			if (!Objects.equals(shortPosition, _that.getShortPosition())) return false;
			if (!Objects.equals(longPosition, _that.getLongPosition())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shortPosition != null ? shortPosition.hashCode() : 0);
			_result = 31 * _result + (longPosition != null ? longPosition.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisationPosition {" +
				"shortPosition=" + this.shortPosition + ", " +
				"longPosition=" + this.longPosition + ", " +
				"global=" + this.global +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilisationPosition  ***********************/
	class CreditLimitUtilisationPositionBuilderImpl implements CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder {
	
		protected BigDecimal shortPosition;
		protected BigDecimal longPosition;
		protected BigDecimal global;
		
		@Override
		@RosettaAttribute("shortPosition")
		@RuneAttribute("shortPosition")
		public BigDecimal getShortPosition() {
			return shortPosition;
		}
		
		@Override
		@RosettaAttribute("longPosition")
		@RuneAttribute("longPosition")
		public BigDecimal getLongPosition() {
			return longPosition;
		}
		
		@Override
		@RosettaAttribute("global")
		@RuneAttribute("global")
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		@RosettaAttribute("shortPosition")
		@RuneAttribute("shortPosition")
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setShortPosition(BigDecimal _shortPosition) {
			this.shortPosition = _shortPosition == null ? null : _shortPosition;
			return this;
		}
		
		@Override
		@RosettaAttribute("longPosition")
		@RuneAttribute("longPosition")
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setLongPosition(BigDecimal _longPosition) {
			this.longPosition = _longPosition == null ? null : _longPosition;
			return this;
		}
		
		@Override
		@RosettaAttribute("global")
		@RuneAttribute("global")
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setGlobal(BigDecimal _global) {
			this.global = _global == null ? null : _global;
			return this;
		}
		
		@Override
		public CreditLimitUtilisationPosition build() {
			return new CreditLimitUtilisationPosition.CreditLimitUtilisationPositionImpl(this);
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShortPosition()!=null) return true;
			if (getLongPosition()!=null) return true;
			if (getGlobal()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder o = (CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder) other;
			
			
			merger.mergeBasic(getShortPosition(), o.getShortPosition(), this::setShortPosition);
			merger.mergeBasic(getLongPosition(), o.getLongPosition(), this::setLongPosition);
			merger.mergeBasic(getGlobal(), o.getGlobal(), this::setGlobal);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisationPosition _that = getType().cast(o);
		
			if (!Objects.equals(shortPosition, _that.getShortPosition())) return false;
			if (!Objects.equals(longPosition, _that.getLongPosition())) return false;
			if (!Objects.equals(global, _that.getGlobal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shortPosition != null ? shortPosition.hashCode() : 0);
			_result = 31 * _result + (longPosition != null ? longPosition.hashCode() : 0);
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisationPositionBuilder {" +
				"shortPosition=" + this.shortPosition + ", " +
				"longPosition=" + this.longPosition + ", " +
				"global=" + this.global +
			'}';
		}
	}
}
