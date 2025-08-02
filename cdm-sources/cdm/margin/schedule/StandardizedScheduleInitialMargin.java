package cdm.margin.schedule;

import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.margin.schedule.StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder;
import cdm.margin.schedule.StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilderImpl;
import cdm.margin.schedule.StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginImpl;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.margin.schedule.StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder;
import cdm.margin.schedule.meta.StandardizedScheduleInitialMarginMeta;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 6.0.0
 */
@RosettaDataType(value="StandardizedScheduleInitialMargin", builder=StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilderImpl.class, version="6.0.0")
@RuneDataType(value="StandardizedScheduleInitialMargin", model="Just another Rosetta model", builder=StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilderImpl.class, version="6.0.0")
public interface StandardizedScheduleInitialMargin extends RosettaModelObject {

	StandardizedScheduleInitialMarginMeta metaData = new StandardizedScheduleInitialMarginMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends StandardizedScheduleTradeInfo> getTradeInfo();
	Money getNetInitialMargin();

	/*********************** Build Methods  ***********************/
	StandardizedScheduleInitialMargin build();
	
	StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder toBuilder();
	
	static StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder builder() {
		return new StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StandardizedScheduleInitialMargin> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StandardizedScheduleInitialMargin> getType() {
		return StandardizedScheduleInitialMargin.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeInfo"), processor, StandardizedScheduleTradeInfo.class, getTradeInfo());
		processRosetta(path.newSubPath("netInitialMargin"), processor, Money.class, getNetInitialMargin());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StandardizedScheduleInitialMarginBuilder extends StandardizedScheduleInitialMargin, RosettaModelObjectBuilder {
		StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder getOrCreateTradeInfo(int _index);
		@Override
		List<? extends StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder> getTradeInfo();
		Money.MoneyBuilder getOrCreateNetInitialMargin();
		@Override
		Money.MoneyBuilder getNetInitialMargin();
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(StandardizedScheduleTradeInfo tradeInfo);
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(StandardizedScheduleTradeInfo tradeInfo, int _idx);
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(List<? extends StandardizedScheduleTradeInfo> tradeInfo);
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder setTradeInfo(List<? extends StandardizedScheduleTradeInfo> tradeInfo);
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder setNetInitialMargin(Money netInitialMargin);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeInfo"), processor, StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder.class, getTradeInfo());
			processRosetta(path.newSubPath("netInitialMargin"), processor, Money.MoneyBuilder.class, getNetInitialMargin());
		}
		

		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder prune();
	}

	/*********************** Immutable Implementation of StandardizedScheduleInitialMargin  ***********************/
	class StandardizedScheduleInitialMarginImpl implements StandardizedScheduleInitialMargin {
		private final List<? extends StandardizedScheduleTradeInfo> tradeInfo;
		private final Money netInitialMargin;
		
		protected StandardizedScheduleInitialMarginImpl(StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder builder) {
			this.tradeInfo = ofNullable(builder.getTradeInfo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.netInitialMargin = ofNullable(builder.getNetInitialMargin()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeInfo")
		@RuneAttribute("tradeInfo")
		public List<? extends StandardizedScheduleTradeInfo> getTradeInfo() {
			return tradeInfo;
		}
		
		@Override
		@RosettaAttribute("netInitialMargin")
		@RuneAttribute("netInitialMargin")
		public Money getNetInitialMargin() {
			return netInitialMargin;
		}
		
		@Override
		public StandardizedScheduleInitialMargin build() {
			return this;
		}
		
		@Override
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder toBuilder() {
			StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder builder) {
			ofNullable(getTradeInfo()).ifPresent(builder::setTradeInfo);
			ofNullable(getNetInitialMargin()).ifPresent(builder::setNetInitialMargin);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedScheduleInitialMargin _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeInfo, _that.getTradeInfo())) return false;
			if (!Objects.equals(netInitialMargin, _that.getNetInitialMargin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeInfo != null ? tradeInfo.hashCode() : 0);
			_result = 31 * _result + (netInitialMargin != null ? netInitialMargin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedScheduleInitialMargin {" +
				"tradeInfo=" + this.tradeInfo + ", " +
				"netInitialMargin=" + this.netInitialMargin +
			'}';
		}
	}

	/*********************** Builder Implementation of StandardizedScheduleInitialMargin  ***********************/
	class StandardizedScheduleInitialMarginBuilderImpl implements StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder {
	
		protected List<StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder> tradeInfo = new ArrayList<>();
		protected Money.MoneyBuilder netInitialMargin;
		
		@Override
		@RosettaAttribute("tradeInfo")
		@RuneAttribute("tradeInfo")
		public List<? extends StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder> getTradeInfo() {
			return tradeInfo;
		}
		
		@Override
		public StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder getOrCreateTradeInfo(int _index) {
		
			if (tradeInfo==null) {
				this.tradeInfo = new ArrayList<>();
			}
			StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder result;
			return getIndex(tradeInfo, _index, () -> {
						StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder newTradeInfo = StandardizedScheduleTradeInfo.builder();
						return newTradeInfo;
					});
		}
		
		@Override
		@RosettaAttribute("netInitialMargin")
		@RuneAttribute("netInitialMargin")
		public Money.MoneyBuilder getNetInitialMargin() {
			return netInitialMargin;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNetInitialMargin() {
			Money.MoneyBuilder result;
			if (netInitialMargin!=null) {
				result = netInitialMargin;
			}
			else {
				result = netInitialMargin = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeInfo")
		@RuneAttribute("tradeInfo")
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(StandardizedScheduleTradeInfo _tradeInfo) {
			if (_tradeInfo != null) {
				this.tradeInfo.add(_tradeInfo.toBuilder());
			}
			return this;
		}
		
		@Override
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(StandardizedScheduleTradeInfo _tradeInfo, int _idx) {
			getIndex(this.tradeInfo, _idx, () -> _tradeInfo.toBuilder());
			return this;
		}
		
		@Override 
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder addTradeInfo(List<? extends StandardizedScheduleTradeInfo> tradeInfos) {
			if (tradeInfos != null) {
				for (final StandardizedScheduleTradeInfo toAdd : tradeInfos) {
					this.tradeInfo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("tradeInfo")
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder setTradeInfo(List<? extends StandardizedScheduleTradeInfo> tradeInfos) {
			if (tradeInfos == null) {
				this.tradeInfo = new ArrayList<>();
			} else {
				this.tradeInfo = tradeInfos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("netInitialMargin")
		@RuneAttribute("netInitialMargin")
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder setNetInitialMargin(Money _netInitialMargin) {
			this.netInitialMargin = _netInitialMargin == null ? null : _netInitialMargin.toBuilder();
			return this;
		}
		
		@Override
		public StandardizedScheduleInitialMargin build() {
			return new StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginImpl(this);
		}
		
		@Override
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder prune() {
			tradeInfo = tradeInfo.stream().filter(b->b!=null).<StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfoBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (netInitialMargin!=null && !netInitialMargin.prune().hasData()) netInitialMargin = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeInfo()!=null && getTradeInfo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNetInitialMargin()!=null && getNetInitialMargin().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder o = (StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder) other;
			
			merger.mergeRosetta(getTradeInfo(), o.getTradeInfo(), this::getOrCreateTradeInfo);
			merger.mergeRosetta(getNetInitialMargin(), o.getNetInitialMargin(), this::setNetInitialMargin);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StandardizedScheduleInitialMargin _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeInfo, _that.getTradeInfo())) return false;
			if (!Objects.equals(netInitialMargin, _that.getNetInitialMargin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeInfo != null ? tradeInfo.hashCode() : 0);
			_result = 31 * _result + (netInitialMargin != null ? netInitialMargin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StandardizedScheduleInitialMarginBuilder {" +
				"tradeInfo=" + this.tradeInfo + ", " +
				"netInitialMargin=" + this.netInitialMargin +
			'}';
		}
	}
}
