package cdm.regulation;

import cdm.regulation.FinInstrmGnlAttrbts;
import cdm.regulation.FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder;
import cdm.regulation.FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilderImpl;
import cdm.regulation.FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsImpl;
import cdm.regulation.meta.FinInstrmGnlAttrbtsMeta;
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
@RosettaDataType(value="FinInstrmGnlAttrbts", builder=FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="FinInstrmGnlAttrbts", model="Just another Rosetta model", builder=FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilderImpl.class, version="6.0.0")
public interface FinInstrmGnlAttrbts extends RosettaModelObject {

	FinInstrmGnlAttrbtsMeta metaData = new FinInstrmGnlAttrbtsMeta();

	/*********************** Getter Methods  ***********************/
	String getFullNm();
	String getClssfctnTp();
	String getNtnlCcy();

	/*********************** Build Methods  ***********************/
	FinInstrmGnlAttrbts build();
	
	FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder toBuilder();
	
	static FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder builder() {
		return new FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinInstrmGnlAttrbts> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinInstrmGnlAttrbts> getType() {
		return FinInstrmGnlAttrbts.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fullNm"), String.class, getFullNm(), this);
		processor.processBasic(path.newSubPath("clssfctnTp"), String.class, getClssfctnTp(), this);
		processor.processBasic(path.newSubPath("ntnlCcy"), String.class, getNtnlCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinInstrmGnlAttrbtsBuilder extends FinInstrmGnlAttrbts, RosettaModelObjectBuilder {
		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setFullNm(String fullNm);
		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setClssfctnTp(String clssfctnTp);
		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setNtnlCcy(String ntnlCcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fullNm"), String.class, getFullNm(), this);
			processor.processBasic(path.newSubPath("clssfctnTp"), String.class, getClssfctnTp(), this);
			processor.processBasic(path.newSubPath("ntnlCcy"), String.class, getNtnlCcy(), this);
		}
		

		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder prune();
	}

	/*********************** Immutable Implementation of FinInstrmGnlAttrbts  ***********************/
	class FinInstrmGnlAttrbtsImpl implements FinInstrmGnlAttrbts {
		private final String fullNm;
		private final String clssfctnTp;
		private final String ntnlCcy;
		
		protected FinInstrmGnlAttrbtsImpl(FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder builder) {
			this.fullNm = builder.getFullNm();
			this.clssfctnTp = builder.getClssfctnTp();
			this.ntnlCcy = builder.getNtnlCcy();
		}
		
		@Override
		@RosettaAttribute("fullNm")
		@RuneAttribute("fullNm")
		public String getFullNm() {
			return fullNm;
		}
		
		@Override
		@RosettaAttribute("clssfctnTp")
		@RuneAttribute("clssfctnTp")
		public String getClssfctnTp() {
			return clssfctnTp;
		}
		
		@Override
		@RosettaAttribute("ntnlCcy")
		@RuneAttribute("ntnlCcy")
		public String getNtnlCcy() {
			return ntnlCcy;
		}
		
		@Override
		public FinInstrmGnlAttrbts build() {
			return this;
		}
		
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder toBuilder() {
			FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder builder) {
			ofNullable(getFullNm()).ifPresent(builder::setFullNm);
			ofNullable(getClssfctnTp()).ifPresent(builder::setClssfctnTp);
			ofNullable(getNtnlCcy()).ifPresent(builder::setNtnlCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinInstrmGnlAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(fullNm, _that.getFullNm())) return false;
			if (!Objects.equals(clssfctnTp, _that.getClssfctnTp())) return false;
			if (!Objects.equals(ntnlCcy, _that.getNtnlCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fullNm != null ? fullNm.hashCode() : 0);
			_result = 31 * _result + (clssfctnTp != null ? clssfctnTp.hashCode() : 0);
			_result = 31 * _result + (ntnlCcy != null ? ntnlCcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinInstrmGnlAttrbts {" +
				"fullNm=" + this.fullNm + ", " +
				"clssfctnTp=" + this.clssfctnTp + ", " +
				"ntnlCcy=" + this.ntnlCcy +
			'}';
		}
	}

	/*********************** Builder Implementation of FinInstrmGnlAttrbts  ***********************/
	class FinInstrmGnlAttrbtsBuilderImpl implements FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder {
	
		protected String fullNm;
		protected String clssfctnTp;
		protected String ntnlCcy;
		
		@Override
		@RosettaAttribute("fullNm")
		@RuneAttribute("fullNm")
		public String getFullNm() {
			return fullNm;
		}
		
		@Override
		@RosettaAttribute("clssfctnTp")
		@RuneAttribute("clssfctnTp")
		public String getClssfctnTp() {
			return clssfctnTp;
		}
		
		@Override
		@RosettaAttribute("ntnlCcy")
		@RuneAttribute("ntnlCcy")
		public String getNtnlCcy() {
			return ntnlCcy;
		}
		
		@Override
		@RosettaAttribute("fullNm")
		@RuneAttribute("fullNm")
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setFullNm(String _fullNm) {
			this.fullNm = _fullNm == null ? null : _fullNm;
			return this;
		}
		
		@Override
		@RosettaAttribute("clssfctnTp")
		@RuneAttribute("clssfctnTp")
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setClssfctnTp(String _clssfctnTp) {
			this.clssfctnTp = _clssfctnTp == null ? null : _clssfctnTp;
			return this;
		}
		
		@Override
		@RosettaAttribute("ntnlCcy")
		@RuneAttribute("ntnlCcy")
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder setNtnlCcy(String _ntnlCcy) {
			this.ntnlCcy = _ntnlCcy == null ? null : _ntnlCcy;
			return this;
		}
		
		@Override
		public FinInstrmGnlAttrbts build() {
			return new FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsImpl(this);
		}
		
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFullNm()!=null) return true;
			if (getClssfctnTp()!=null) return true;
			if (getNtnlCcy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder o = (FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder) other;
			
			
			merger.mergeBasic(getFullNm(), o.getFullNm(), this::setFullNm);
			merger.mergeBasic(getClssfctnTp(), o.getClssfctnTp(), this::setClssfctnTp);
			merger.mergeBasic(getNtnlCcy(), o.getNtnlCcy(), this::setNtnlCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinInstrmGnlAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(fullNm, _that.getFullNm())) return false;
			if (!Objects.equals(clssfctnTp, _that.getClssfctnTp())) return false;
			if (!Objects.equals(ntnlCcy, _that.getNtnlCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fullNm != null ? fullNm.hashCode() : 0);
			_result = 31 * _result + (clssfctnTp != null ? clssfctnTp.hashCode() : 0);
			_result = 31 * _result + (ntnlCcy != null ? ntnlCcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinInstrmGnlAttrbtsBuilder {" +
				"fullNm=" + this.fullNm + ", " +
				"clssfctnTp=" + this.clssfctnTp + ", " +
				"ntnlCcy=" + this.ntnlCcy +
			'}';
		}
	}
}
