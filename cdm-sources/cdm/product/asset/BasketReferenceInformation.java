package cdm.product.asset;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.BasketReferenceInformation.BasketReferenceInformationBuilder;
import cdm.product.asset.BasketReferenceInformation.BasketReferenceInformationBuilderImpl;
import cdm.product.asset.BasketReferenceInformation.BasketReferenceInformationImpl;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePool.ReferencePoolBuilder;
import cdm.product.asset.Tranche;
import cdm.product.asset.Tranche.TrancheBuilder;
import cdm.product.asset.meta.BasketReferenceInformationMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * CDS Basket Reference Information.
 * @version 6.0.0
 */
@RosettaDataType(value="BasketReferenceInformation", builder=BasketReferenceInformation.BasketReferenceInformationBuilderImpl.class, version="6.0.0")
@RuneDataType(value="BasketReferenceInformation", model="Just another Rosetta model", builder=BasketReferenceInformation.BasketReferenceInformationBuilderImpl.class, version="6.0.0")
public interface BasketReferenceInformation extends RosettaModelObject {

	BasketReferenceInformationMeta metaData = new BasketReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 */
	FieldWithMetaString getBasketName();
	/**
	 * A CDS basket identifier.
	 */
	List<? extends FieldWithMetaString> getBasketId();
	/**
	 * This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
	 */
	ReferencePool getReferencePool();
	/**
	 * N th reference obligation to default triggers payout.
	 */
	Integer getNthToDefault();
	/**
	 * M th reference obligation to default to allow representation of N th to M th defaults.
	 */
	Integer getMthToDefault();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();

	/*********************** Build Methods  ***********************/
	BasketReferenceInformation build();
	
	BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder();
	
	static BasketReferenceInformation.BasketReferenceInformationBuilder builder() {
		return new BasketReferenceInformation.BasketReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketReferenceInformation> getType() {
		return BasketReferenceInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketName"), processor, FieldWithMetaString.class, getBasketName());
		processRosetta(path.newSubPath("basketId"), processor, FieldWithMetaString.class, getBasketId());
		processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.class, getReferencePool());
		processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
		processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketReferenceInformationBuilder extends BasketReferenceInformation, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBasketName();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getBasketName();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBasketId(int _index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getBasketId();
		ReferencePool.ReferencePoolBuilder getOrCreateReferencePool();
		@Override
		ReferencePool.ReferencePoolBuilder getReferencePool();
		Tranche.TrancheBuilder getOrCreateTranche();
		@Override
		Tranche.TrancheBuilder getTranche();
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(FieldWithMetaString basketName);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketNameValue(String basketName);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString basketId, int _idx);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String basketId, int _idx);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends FieldWithMetaString> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends FieldWithMetaString> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(List<? extends String> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdValue(List<? extends String> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool);
		BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer nthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer mthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketName"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getBasketName());
			processRosetta(path.newSubPath("basketId"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getBasketId());
			processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.ReferencePoolBuilder.class, getReferencePool());
			processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
			processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
		}
		

		BasketReferenceInformation.BasketReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationImpl implements BasketReferenceInformation {
		private final FieldWithMetaString basketName;
		private final List<? extends FieldWithMetaString> basketId;
		private final ReferencePool referencePool;
		private final Integer nthToDefault;
		private final Integer mthToDefault;
		private final Tranche tranche;
		
		protected BasketReferenceInformationImpl(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.referencePool = ofNullable(builder.getReferencePool()).map(f->f.build()).orElse(null);
			this.nthToDefault = builder.getNthToDefault();
			this.mthToDefault = builder.getMthToDefault();
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketName")
		@RuneAttribute("basketName")
		public FieldWithMetaString getBasketName() {
			return basketName;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@RuneAttribute("basketId")
		public List<? extends FieldWithMetaString> getBasketId() {
			return basketId;
		}
		
		@Override
		@RosettaAttribute("referencePool")
		@RuneAttribute("referencePool")
		public ReferencePool getReferencePool() {
			return referencePool;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		@RuneAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		@RuneAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			BasketReferenceInformation.BasketReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
			ofNullable(getReferencePool()).ifPresent(builder::setReferencePool);
			ofNullable(getNthToDefault()).ifPresent(builder::setNthToDefault);
			ofNullable(getMthToDefault()).ifPresent(builder::setMthToDefault);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformation {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"referencePool=" + this.referencePool + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationBuilderImpl implements BasketReferenceInformation.BasketReferenceInformationBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder basketName;
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> basketId = new ArrayList<>();
		protected ReferencePool.ReferencePoolBuilder referencePool;
		protected Integer nthToDefault;
		protected Integer mthToDefault;
		protected Tranche.TrancheBuilder tranche;
		
		@Override
		@RosettaAttribute("basketName")
		@RuneAttribute("basketName")
		public FieldWithMetaString.FieldWithMetaStringBuilder getBasketName() {
			return basketName;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBasketName() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (basketName!=null) {
				result = basketName;
			}
			else {
				result = basketName = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@RuneAttribute("basketId")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getBasketId() {
			return basketId;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBasketId(int _index) {
		
			if (basketId==null) {
				this.basketId = new ArrayList<>();
			}
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			return getIndex(basketId, _index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newBasketId = FieldWithMetaString.builder();
						return newBasketId;
					});
		}
		
		@Override
		@RosettaAttribute("referencePool")
		@RuneAttribute("referencePool")
		public ReferencePool.ReferencePoolBuilder getReferencePool() {
			return referencePool;
		}
		
		@Override
		public ReferencePool.ReferencePoolBuilder getOrCreateReferencePool() {
			ReferencePool.ReferencePoolBuilder result;
			if (referencePool!=null) {
				result = referencePool;
			}
			else {
				result = referencePool = ReferencePool.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		@RuneAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		@RuneAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketName")
		@RuneAttribute("basketName")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(FieldWithMetaString _basketName) {
			this.basketName = _basketName == null ? null : _basketName.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketNameValue(String _basketName) {
			this.getOrCreateBasketName().setValue(_basketName);
			return this;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@RuneAttribute("basketId")
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString _basketId) {
			if (_basketId != null) {
				this.basketId.add(_basketId.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(FieldWithMetaString _basketId, int _idx) {
			getIndex(this.basketId, _idx, () -> _basketId.toBuilder());
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String _basketId) {
			this.getOrCreateBasketId(-1).setValue(_basketId);
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(String _basketId, int _idx) {
			this.getOrCreateBasketId(_idx).setValue(_basketId);
			return this;
		}
		
		@Override 
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends FieldWithMetaString> basketIds) {
			if (basketIds != null) {
				for (final FieldWithMetaString toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("basketId")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends FieldWithMetaString> basketIds) {
			if (basketIds == null) {
				this.basketId = new ArrayList<>();
			} else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketIdValue(List<? extends String> basketIds) {
			if (basketIds != null) {
				for (final String toAdd : basketIds) {
					this.addBasketIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketIdValue(List<? extends String> basketIds) {
			this.basketId.clear();
			if (basketIds != null) {
				basketIds.forEach(this::addBasketIdValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("referencePool")
		@RuneAttribute("referencePool")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool _referencePool) {
			this.referencePool = _referencePool == null ? null : _referencePool.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		@RuneAttribute("nthToDefault")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer _nthToDefault) {
			this.nthToDefault = _nthToDefault == null ? null : _nthToDefault;
			return this;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		@RuneAttribute("mthToDefault")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer _mthToDefault) {
			this.mthToDefault = _mthToDefault == null ? null : _mthToDefault;
			return this;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@RuneAttribute("tranche")
		public BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche _tranche) {
			this.tranche = _tranche == null ? null : _tranche.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return new BasketReferenceInformation.BasketReferenceInformationImpl(this);
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder prune() {
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			basketId = basketId.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (referencePool!=null && !referencePool.prune().hasData()) referencePool = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketName()!=null) return true;
			if (getBasketId()!=null && !getBasketId().isEmpty()) return true;
			if (getReferencePool()!=null && getReferencePool().hasData()) return true;
			if (getNthToDefault()!=null) return true;
			if (getMthToDefault()!=null) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketReferenceInformation.BasketReferenceInformationBuilder o = (BasketReferenceInformation.BasketReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			merger.mergeRosetta(getReferencePool(), o.getReferencePool(), this::setReferencePool);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getNthToDefault(), o.getNthToDefault(), this::setNthToDefault);
			merger.mergeBasic(getMthToDefault(), o.getMthToDefault(), this::setMthToDefault);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationBuilder {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"referencePool=" + this.referencePool + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
}
