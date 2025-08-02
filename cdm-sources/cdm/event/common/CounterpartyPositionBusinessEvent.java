package cdm.event.common;

import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.IdentifiedList.IdentifiedListBuilder;
import cdm.event.common.CorporateActionTypeEnum;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder;
import cdm.event.common.CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilderImpl;
import cdm.event.common.CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventImpl;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.CounterpartyPositionState.CounterpartyPositionStateBuilder;
import cdm.event.common.PositionEventIntentEnum;
import cdm.event.common.meta.CounterpartyPositionBusinessEventMeta;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A business event represents a life cycle event of a position. The combination of the state changes results in a qualifiable life cycle event.
 * @version 6.0.0
 */
@RosettaDataType(value="CounterpartyPositionBusinessEvent", builder=CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilderImpl.class, version="6.0.0")
@RuneDataType(value="CounterpartyPositionBusinessEvent", model="Just another Rosetta model", builder=CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilderImpl.class, version="6.0.0")
public interface CounterpartyPositionBusinessEvent extends RosettaModelObject {

	CounterpartyPositionBusinessEventMeta metaData = new CounterpartyPositionBusinessEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those.
	 */
	PositionEventIntentEnum getIntent();
	/**
	 * The intent of a corporate action on the position.
	 */
	CorporateActionTypeEnum getCorporateActionIntent();
	/**
	 * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
	 */
	Date getEventDate();
	/**
	 * The date on which the event contractually takes effect, when different from the event date.
	 */
	Date getEffectiveDate();
	/**
	 * Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
	 */
	IdentifiedList getPackageInformation();
	/**
	 * Specifies the after position state(s) created.
	 */
	List<? extends CounterpartyPositionState> getAfter();

	/*********************** Build Methods  ***********************/
	CounterpartyPositionBusinessEvent build();
	
	CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder toBuilder();
	
	static CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder builder() {
		return new CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartyPositionBusinessEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartyPositionBusinessEvent> getType() {
		return CounterpartyPositionBusinessEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("intent"), PositionEventIntentEnum.class, getIntent(), this);
		processor.processBasic(path.newSubPath("corporateActionIntent"), CorporateActionTypeEnum.class, getCorporateActionIntent(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("packageInformation"), processor, IdentifiedList.class, getPackageInformation());
		processRosetta(path.newSubPath("after"), processor, CounterpartyPositionState.class, getAfter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartyPositionBusinessEventBuilder extends CounterpartyPositionBusinessEvent, RosettaModelObjectBuilder {
		IdentifiedList.IdentifiedListBuilder getOrCreatePackageInformation();
		@Override
		IdentifiedList.IdentifiedListBuilder getPackageInformation();
		CounterpartyPositionState.CounterpartyPositionStateBuilder getOrCreateAfter(int _index);
		@Override
		List<? extends CounterpartyPositionState.CounterpartyPositionStateBuilder> getAfter();
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setIntent(PositionEventIntentEnum intent);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setCorporateActionIntent(CorporateActionTypeEnum corporateActionIntent);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setEventDate(Date eventDate);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setEffectiveDate(Date effectiveDate);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setPackageInformation(IdentifiedList packageInformation);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(CounterpartyPositionState after);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(CounterpartyPositionState after, int _idx);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(List<? extends CounterpartyPositionState> after);
		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setAfter(List<? extends CounterpartyPositionState> after);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("intent"), PositionEventIntentEnum.class, getIntent(), this);
			processor.processBasic(path.newSubPath("corporateActionIntent"), CorporateActionTypeEnum.class, getCorporateActionIntent(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("packageInformation"), processor, IdentifiedList.IdentifiedListBuilder.class, getPackageInformation());
			processRosetta(path.newSubPath("after"), processor, CounterpartyPositionState.CounterpartyPositionStateBuilder.class, getAfter());
		}
		

		CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder prune();
	}

	/*********************** Immutable Implementation of CounterpartyPositionBusinessEvent  ***********************/
	class CounterpartyPositionBusinessEventImpl implements CounterpartyPositionBusinessEvent {
		private final PositionEventIntentEnum intent;
		private final CorporateActionTypeEnum corporateActionIntent;
		private final Date eventDate;
		private final Date effectiveDate;
		private final IdentifiedList packageInformation;
		private final List<? extends CounterpartyPositionState> after;
		
		protected CounterpartyPositionBusinessEventImpl(CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder builder) {
			this.intent = builder.getIntent();
			this.corporateActionIntent = builder.getCorporateActionIntent();
			this.eventDate = builder.getEventDate();
			this.effectiveDate = builder.getEffectiveDate();
			this.packageInformation = ofNullable(builder.getPackageInformation()).map(f->f.build()).orElse(null);
			this.after = ofNullable(builder.getAfter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("intent")
		@RuneAttribute("intent")
		public PositionEventIntentEnum getIntent() {
			return intent;
		}
		
		@Override
		@RosettaAttribute("corporateActionIntent")
		@RuneAttribute("corporateActionIntent")
		public CorporateActionTypeEnum getCorporateActionIntent() {
			return corporateActionIntent;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@RuneAttribute("packageInformation")
		public IdentifiedList getPackageInformation() {
			return packageInformation;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public List<? extends CounterpartyPositionState> getAfter() {
			return after;
		}
		
		@Override
		public CounterpartyPositionBusinessEvent build() {
			return this;
		}
		
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder toBuilder() {
			CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder builder) {
			ofNullable(getIntent()).ifPresent(builder::setIntent);
			ofNullable(getCorporateActionIntent()).ifPresent(builder::setCorporateActionIntent);
			ofNullable(getEventDate()).ifPresent(builder::setEventDate);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPackageInformation()).ifPresent(builder::setPackageInformation);
			ofNullable(getAfter()).ifPresent(builder::setAfter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyPositionBusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(intent, _that.getIntent())) return false;
			if (!Objects.equals(corporateActionIntent, _that.getCorporateActionIntent())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(packageInformation, _that.getPackageInformation())) return false;
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (intent != null ? intent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (corporateActionIntent != null ? corporateActionIntent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (packageInformation != null ? packageInformation.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyPositionBusinessEvent {" +
				"intent=" + this.intent + ", " +
				"corporateActionIntent=" + this.corporateActionIntent + ", " +
				"eventDate=" + this.eventDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"packageInformation=" + this.packageInformation + ", " +
				"after=" + this.after +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartyPositionBusinessEvent  ***********************/
	class CounterpartyPositionBusinessEventBuilderImpl implements CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder {
	
		protected PositionEventIntentEnum intent;
		protected CorporateActionTypeEnum corporateActionIntent;
		protected Date eventDate;
		protected Date effectiveDate;
		protected IdentifiedList.IdentifiedListBuilder packageInformation;
		protected List<CounterpartyPositionState.CounterpartyPositionStateBuilder> after = new ArrayList<>();
		
		@Override
		@RosettaAttribute("intent")
		@RuneAttribute("intent")
		public PositionEventIntentEnum getIntent() {
			return intent;
		}
		
		@Override
		@RosettaAttribute("corporateActionIntent")
		@RuneAttribute("corporateActionIntent")
		public CorporateActionTypeEnum getCorporateActionIntent() {
			return corporateActionIntent;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@RuneAttribute("eventDate")
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@RuneAttribute("packageInformation")
		public IdentifiedList.IdentifiedListBuilder getPackageInformation() {
			return packageInformation;
		}
		
		@Override
		public IdentifiedList.IdentifiedListBuilder getOrCreatePackageInformation() {
			IdentifiedList.IdentifiedListBuilder result;
			if (packageInformation!=null) {
				result = packageInformation;
			}
			else {
				result = packageInformation = IdentifiedList.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public List<? extends CounterpartyPositionState.CounterpartyPositionStateBuilder> getAfter() {
			return after;
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder getOrCreateAfter(int _index) {
		
			if (after==null) {
				this.after = new ArrayList<>();
			}
			CounterpartyPositionState.CounterpartyPositionStateBuilder result;
			return getIndex(after, _index, () -> {
						CounterpartyPositionState.CounterpartyPositionStateBuilder newAfter = CounterpartyPositionState.builder();
						return newAfter;
					});
		}
		
		@Override
		@RosettaAttribute("intent")
		@RuneAttribute("intent")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setIntent(PositionEventIntentEnum _intent) {
			this.intent = _intent == null ? null : _intent;
			return this;
		}
		
		@Override
		@RosettaAttribute("corporateActionIntent")
		@RuneAttribute("corporateActionIntent")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setCorporateActionIntent(CorporateActionTypeEnum _corporateActionIntent) {
			this.corporateActionIntent = _corporateActionIntent == null ? null : _corporateActionIntent;
			return this;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@RuneAttribute("eventDate")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@RuneAttribute("packageInformation")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setPackageInformation(IdentifiedList _packageInformation) {
			this.packageInformation = _packageInformation == null ? null : _packageInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(CounterpartyPositionState _after) {
			if (_after != null) {
				this.after.add(_after.toBuilder());
			}
			return this;
		}
		
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(CounterpartyPositionState _after, int _idx) {
			getIndex(this.after, _idx, () -> _after.toBuilder());
			return this;
		}
		
		@Override 
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder addAfter(List<? extends CounterpartyPositionState> afters) {
			if (afters != null) {
				for (final CounterpartyPositionState toAdd : afters) {
					this.after.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("after")
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder setAfter(List<? extends CounterpartyPositionState> afters) {
			if (afters == null) {
				this.after = new ArrayList<>();
			} else {
				this.after = afters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CounterpartyPositionBusinessEvent build() {
			return new CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventImpl(this);
		}
		
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder prune() {
			if (packageInformation!=null && !packageInformation.prune().hasData()) packageInformation = null;
			after = after.stream().filter(b->b!=null).<CounterpartyPositionState.CounterpartyPositionStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIntent()!=null) return true;
			if (getCorporateActionIntent()!=null) return true;
			if (getEventDate()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getPackageInformation()!=null && getPackageInformation().hasData()) return true;
			if (getAfter()!=null && getAfter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder o = (CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEventBuilder) other;
			
			merger.mergeRosetta(getPackageInformation(), o.getPackageInformation(), this::setPackageInformation);
			merger.mergeRosetta(getAfter(), o.getAfter(), this::getOrCreateAfter);
			
			merger.mergeBasic(getIntent(), o.getIntent(), this::setIntent);
			merger.mergeBasic(getCorporateActionIntent(), o.getCorporateActionIntent(), this::setCorporateActionIntent);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyPositionBusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(intent, _that.getIntent())) return false;
			if (!Objects.equals(corporateActionIntent, _that.getCorporateActionIntent())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(packageInformation, _that.getPackageInformation())) return false;
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (intent != null ? intent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (corporateActionIntent != null ? corporateActionIntent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (packageInformation != null ? packageInformation.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyPositionBusinessEventBuilder {" +
				"intent=" + this.intent + ", " +
				"corporateActionIntent=" + this.corporateActionIntent + ", " +
				"eventDate=" + this.eventDate + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"packageInformation=" + this.packageInformation + ", " +
				"after=" + this.after +
			'}';
		}
	}
}
