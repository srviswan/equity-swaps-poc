package cdm.product.collateral;

import cdm.product.collateral.ListingExchange;
import cdm.product.collateral.ListingExchange.ListingExchangeBuilder;
import cdm.product.collateral.ListingExchange.ListingExchangeBuilderImpl;
import cdm.product.collateral.ListingExchange.ListingExchangeImpl;
import cdm.product.collateral.meta.ListingExchangeMeta;
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
 * Specifies a filter based on a stock exchange.
 * @version 6.0.0
 */
@RosettaDataType(value="ListingExchange", builder=ListingExchange.ListingExchangeBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ListingExchange", model="Just another Rosetta model", builder=ListingExchange.ListingExchangeBuilderImpl.class, version="6.0.0")
public interface ListingExchange extends RosettaModelObject {

	ListingExchangeMeta metaData = new ListingExchangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents a filter based on the Primary Stock Exchange facilitating the listing of companies, exchange of Stocks, Exchange traded Derivatives, Bonds, and other Securities expressed in ISO standard 10383.
	 */
	List<? extends FieldWithMetaString> getExchange();

	/*********************** Build Methods  ***********************/
	ListingExchange build();
	
	ListingExchange.ListingExchangeBuilder toBuilder();
	
	static ListingExchange.ListingExchangeBuilder builder() {
		return new ListingExchange.ListingExchangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ListingExchange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ListingExchange> getType() {
		return ListingExchange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exchange"), processor, FieldWithMetaString.class, getExchange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ListingExchangeBuilder extends ListingExchange, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateExchange(int _index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getExchange();
		ListingExchange.ListingExchangeBuilder addExchange(FieldWithMetaString exchange);
		ListingExchange.ListingExchangeBuilder addExchange(FieldWithMetaString exchange, int _idx);
		ListingExchange.ListingExchangeBuilder addExchangeValue(String exchange);
		ListingExchange.ListingExchangeBuilder addExchangeValue(String exchange, int _idx);
		ListingExchange.ListingExchangeBuilder addExchange(List<? extends FieldWithMetaString> exchange);
		ListingExchange.ListingExchangeBuilder setExchange(List<? extends FieldWithMetaString> exchange);
		ListingExchange.ListingExchangeBuilder addExchangeValue(List<? extends String> exchange);
		ListingExchange.ListingExchangeBuilder setExchangeValue(List<? extends String> exchange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exchange"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getExchange());
		}
		

		ListingExchange.ListingExchangeBuilder prune();
	}

	/*********************** Immutable Implementation of ListingExchange  ***********************/
	class ListingExchangeImpl implements ListingExchange {
		private final List<? extends FieldWithMetaString> exchange;
		
		protected ListingExchangeImpl(ListingExchange.ListingExchangeBuilder builder) {
			this.exchange = ofNullable(builder.getExchange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public List<? extends FieldWithMetaString> getExchange() {
			return exchange;
		}
		
		@Override
		public ListingExchange build() {
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder toBuilder() {
			ListingExchange.ListingExchangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ListingExchange.ListingExchangeBuilder builder) {
			ofNullable(getExchange()).ifPresent(builder::setExchange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingExchange _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exchange, _that.getExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingExchange {" +
				"exchange=" + this.exchange +
			'}';
		}
	}

	/*********************** Builder Implementation of ListingExchange  ***********************/
	class ListingExchangeBuilderImpl implements ListingExchange.ListingExchangeBuilder {
	
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> exchange = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getExchange() {
			return exchange;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateExchange(int _index) {
		
			if (exchange==null) {
				this.exchange = new ArrayList<>();
			}
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			return getIndex(exchange, _index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newExchange = FieldWithMetaString.builder();
						return newExchange;
					});
		}
		
		@Override
		@RosettaAttribute("exchange")
		@RuneAttribute("exchange")
		public ListingExchange.ListingExchangeBuilder addExchange(FieldWithMetaString _exchange) {
			if (_exchange != null) {
				this.exchange.add(_exchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder addExchange(FieldWithMetaString _exchange, int _idx) {
			getIndex(this.exchange, _idx, () -> _exchange.toBuilder());
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder addExchangeValue(String _exchange) {
			this.getOrCreateExchange(-1).setValue(_exchange);
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder addExchangeValue(String _exchange, int _idx) {
			this.getOrCreateExchange(_idx).setValue(_exchange);
			return this;
		}
		
		@Override 
		public ListingExchange.ListingExchangeBuilder addExchange(List<? extends FieldWithMetaString> exchanges) {
			if (exchanges != null) {
				for (final FieldWithMetaString toAdd : exchanges) {
					this.exchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("exchange")
		public ListingExchange.ListingExchangeBuilder setExchange(List<? extends FieldWithMetaString> exchanges) {
			if (exchanges == null) {
				this.exchange = new ArrayList<>();
			} else {
				this.exchange = exchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder addExchangeValue(List<? extends String> exchanges) {
			if (exchanges != null) {
				for (final String toAdd : exchanges) {
					this.addExchangeValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder setExchangeValue(List<? extends String> exchanges) {
			this.exchange.clear();
			if (exchanges != null) {
				exchanges.forEach(this::addExchangeValue);
			}
			return this;
		}
		
		@Override
		public ListingExchange build() {
			return new ListingExchange.ListingExchangeImpl(this);
		}
		
		@Override
		public ListingExchange.ListingExchangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingExchange.ListingExchangeBuilder prune() {
			exchange = exchange.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchange()!=null && !getExchange().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ListingExchange.ListingExchangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ListingExchange.ListingExchangeBuilder o = (ListingExchange.ListingExchangeBuilder) other;
			
			merger.mergeRosetta(getExchange(), o.getExchange(), this::getOrCreateExchange);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ListingExchange _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exchange, _that.getExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchange != null ? exchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ListingExchangeBuilder {" +
				"exchange=" + this.exchange +
			'}';
		}
	}
}
