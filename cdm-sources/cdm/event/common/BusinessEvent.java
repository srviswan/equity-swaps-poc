package cdm.event.common;

import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.IdentifiedList.IdentifiedListBuilder;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.BusinessEvent.BusinessEventBuilderImpl;
import cdm.event.common.BusinessEvent.BusinessEventImpl;
import cdm.event.common.CorporateActionTypeEnum;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.Instruction.InstructionBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.event.common.meta.BusinessEventMeta;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.EventInstruction.EventInstructionBuilder;
import cdm.event.workflow.EventInstruction.EventInstructionBuilderImpl;
import cdm.event.workflow.EventInstruction.EventInstructionImpl;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A business event represents a life cycle event of a trade. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
 * @version 6.0.0
 */
@RosettaDataType(value="BusinessEvent", builder=BusinessEvent.BusinessEventBuilderImpl.class, version="6.0.0")
@RuneDataType(value="BusinessEvent", model="Just another Rosetta model", builder=BusinessEvent.BusinessEventBuilderImpl.class, version="6.0.0")
public interface BusinessEvent extends EventInstruction, GlobalKey {

	BusinessEventMeta metaData = new BusinessEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
	 */
	String getEventQualifier();
	/**
	 * Specifies the after trade state(s) created.
	 */
	List<? extends TradeState> getAfter();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	BusinessEvent build();
	
	BusinessEvent.BusinessEventBuilder toBuilder();
	
	static BusinessEvent.BusinessEventBuilder builder() {
		return new BusinessEvent.BusinessEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessEvent> getType() {
		return BusinessEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("intent"), EventIntentEnum.class, getIntent(), this);
		processor.processBasic(path.newSubPath("corporateActionIntent"), CorporateActionTypeEnum.class, getCorporateActionIntent(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("packageInformation"), processor, IdentifiedList.class, getPackageInformation());
		processRosetta(path.newSubPath("instruction"), processor, Instruction.class, getInstruction());
		processor.processBasic(path.newSubPath("eventQualifier"), String.class, getEventQualifier(), this);
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessEventBuilder extends BusinessEvent, EventInstruction.EventInstructionBuilder, GlobalKey.GlobalKeyBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter(int _index);
		@Override
		List<? extends TradeState.TradeStateBuilder> getAfter();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		@Override
		BusinessEvent.BusinessEventBuilder setIntent(EventIntentEnum intent);
		@Override
		BusinessEvent.BusinessEventBuilder setCorporateActionIntent(CorporateActionTypeEnum corporateActionIntent);
		@Override
		BusinessEvent.BusinessEventBuilder setEventDate(Date eventDate);
		@Override
		BusinessEvent.BusinessEventBuilder setEffectiveDate(Date effectiveDate);
		@Override
		BusinessEvent.BusinessEventBuilder setPackageInformation(IdentifiedList packageInformation);
		@Override
		BusinessEvent.BusinessEventBuilder addInstruction(Instruction instruction);
		@Override
		BusinessEvent.BusinessEventBuilder addInstruction(Instruction instruction, int _idx);
		@Override
		BusinessEvent.BusinessEventBuilder addInstruction(List<? extends Instruction> instruction);
		@Override
		BusinessEvent.BusinessEventBuilder setInstruction(List<? extends Instruction> instruction);
		BusinessEvent.BusinessEventBuilder setEventQualifier(String eventQualifier);
		BusinessEvent.BusinessEventBuilder addAfter(TradeState after);
		BusinessEvent.BusinessEventBuilder addAfter(TradeState after, int _idx);
		BusinessEvent.BusinessEventBuilder addAfter(List<? extends TradeState> after);
		BusinessEvent.BusinessEventBuilder setAfter(List<? extends TradeState> after);
		BusinessEvent.BusinessEventBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("intent"), EventIntentEnum.class, getIntent(), this);
			processor.processBasic(path.newSubPath("corporateActionIntent"), CorporateActionTypeEnum.class, getCorporateActionIntent(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("packageInformation"), processor, IdentifiedList.IdentifiedListBuilder.class, getPackageInformation());
			processRosetta(path.newSubPath("instruction"), processor, Instruction.InstructionBuilder.class, getInstruction());
			processor.processBasic(path.newSubPath("eventQualifier"), String.class, getEventQualifier(), this);
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		BusinessEvent.BusinessEventBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessEvent  ***********************/
	class BusinessEventImpl extends EventInstruction.EventInstructionImpl implements BusinessEvent {
		private final String eventQualifier;
		private final List<? extends TradeState> after;
		private final MetaFields meta;
		
		protected BusinessEventImpl(BusinessEvent.BusinessEventBuilder builder) {
			super(builder);
			this.eventQualifier = builder.getEventQualifier();
			this.after = ofNullable(builder.getAfter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("eventQualifier")
		@RuneAttribute("eventQualifier")
		public String getEventQualifier() {
			return eventQualifier;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public List<? extends TradeState> getAfter() {
			return after;
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BusinessEvent build() {
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder toBuilder() {
			BusinessEvent.BusinessEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessEvent.BusinessEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEventQualifier()).ifPresent(builder::setEventQualifier);
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(eventQualifier, _that.getEventQualifier())) return false;
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventQualifier != null ? eventQualifier.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEvent {" +
				"eventQualifier=" + this.eventQualifier + ", " +
				"after=" + this.after + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessEvent  ***********************/
	class BusinessEventBuilderImpl extends EventInstruction.EventInstructionBuilderImpl implements BusinessEvent.BusinessEventBuilder {
	
		protected String eventQualifier;
		protected List<TradeState.TradeStateBuilder> after = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("eventQualifier")
		@RuneAttribute("eventQualifier")
		public String getEventQualifier() {
			return eventQualifier;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public List<? extends TradeState.TradeStateBuilder> getAfter() {
			return after;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateAfter(int _index) {
		
			if (after==null) {
				this.after = new ArrayList<>();
			}
			TradeState.TradeStateBuilder result;
			return getIndex(after, _index, () -> {
						TradeState.TradeStateBuilder newAfter = TradeState.builder();
						return newAfter;
					});
		}
		
		@Override
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intent")
		@RuneAttribute("intent")
		public BusinessEvent.BusinessEventBuilder setIntent(EventIntentEnum _intent) {
			this.intent = _intent == null ? null : _intent;
			return this;
		}
		
		@Override
		@RosettaAttribute("corporateActionIntent")
		@RuneAttribute("corporateActionIntent")
		public BusinessEvent.BusinessEventBuilder setCorporateActionIntent(CorporateActionTypeEnum _corporateActionIntent) {
			this.corporateActionIntent = _corporateActionIntent == null ? null : _corporateActionIntent;
			return this;
		}
		
		@Override
		@RosettaAttribute("eventDate")
		@RuneAttribute("eventDate")
		public BusinessEvent.BusinessEventBuilder setEventDate(Date _eventDate) {
			this.eventDate = _eventDate == null ? null : _eventDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@RuneAttribute("effectiveDate")
		public BusinessEvent.BusinessEventBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@RuneAttribute("packageInformation")
		public BusinessEvent.BusinessEventBuilder setPackageInformation(IdentifiedList _packageInformation) {
			this.packageInformation = _packageInformation == null ? null : _packageInformation.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("instruction")
		@RuneAttribute("instruction")
		public BusinessEvent.BusinessEventBuilder addInstruction(Instruction _instruction) {
			if (_instruction != null) {
				this.instruction.add(_instruction.toBuilder());
			}
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder addInstruction(Instruction _instruction, int _idx) {
			getIndex(this.instruction, _idx, () -> _instruction.toBuilder());
			return this;
		}
		
		@Override 
		public BusinessEvent.BusinessEventBuilder addInstruction(List<? extends Instruction> instructions) {
			if (instructions != null) {
				for (final Instruction toAdd : instructions) {
					this.instruction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("instruction")
		public BusinessEvent.BusinessEventBuilder setInstruction(List<? extends Instruction> instructions) {
			if (instructions == null) {
				this.instruction = new ArrayList<>();
			} else {
				this.instruction = instructions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("eventQualifier")
		@RuneAttribute("eventQualifier")
		public BusinessEvent.BusinessEventBuilder setEventQualifier(String _eventQualifier) {
			this.eventQualifier = _eventQualifier == null ? null : _eventQualifier;
			return this;
		}
		
		@Override
		@RosettaAttribute("after")
		@RuneAttribute("after")
		public BusinessEvent.BusinessEventBuilder addAfter(TradeState _after) {
			if (_after != null) {
				this.after.add(_after.toBuilder());
			}
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder addAfter(TradeState _after, int _idx) {
			getIndex(this.after, _idx, () -> _after.toBuilder());
			return this;
		}
		
		@Override 
		public BusinessEvent.BusinessEventBuilder addAfter(List<? extends TradeState> afters) {
			if (afters != null) {
				for (final TradeState toAdd : afters) {
					this.after.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("after")
		public BusinessEvent.BusinessEventBuilder setAfter(List<? extends TradeState> afters) {
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
		@RosettaAttribute("meta")
		@RuneAttribute("meta")
		@RuneMetaType
		public BusinessEvent.BusinessEventBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public BusinessEvent build() {
			return new BusinessEvent.BusinessEventImpl(this);
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEvent.BusinessEventBuilder prune() {
			super.prune();
			after = after.stream().filter(b->b!=null).<TradeState.TradeStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEventQualifier()!=null) return true;
			if (getAfter()!=null && getAfter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEvent.BusinessEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BusinessEvent.BusinessEventBuilder o = (BusinessEvent.BusinessEventBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::getOrCreateAfter);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getEventQualifier(), o.getEventQualifier(), this::setEventQualifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(eventQualifier, _that.getEventQualifier())) return false;
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (eventQualifier != null ? eventQualifier.hashCode() : 0);
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventBuilder {" +
				"eventQualifier=" + this.eventQualifier + ", " +
				"after=" + this.after + ", " +
				"meta=" + this.meta +
			'}' + " " + super.toString();
		}
	}
}
