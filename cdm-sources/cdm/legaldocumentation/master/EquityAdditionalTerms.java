package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.DeterminationRolesAndTerms;
import cdm.legaldocumentation.master.DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder;
import cdm.legaldocumentation.master.EquityAdditionalTerms;
import cdm.legaldocumentation.master.EquityAdditionalTerms.EquityAdditionalTermsBuilder;
import cdm.legaldocumentation.master.EquityAdditionalTerms.EquityAdditionalTermsBuilderImpl;
import cdm.legaldocumentation.master.EquityAdditionalTerms.EquityAdditionalTermsImpl;
import cdm.legaldocumentation.master.ExtraordinaryEvents;
import cdm.legaldocumentation.master.ExtraordinaryEvents.ExtraordinaryEventsBuilder;
import cdm.legaldocumentation.master.UnderlierSubstitutionProvision;
import cdm.legaldocumentation.master.UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder;
import cdm.legaldocumentation.master.meta.EquityAdditionalTermsMeta;
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
 * Transaction AdditionalTerms that apply to Equity asset class.
 * @version 6.0.0
 */
@RosettaDataType(value="EquityAdditionalTerms", builder=EquityAdditionalTerms.EquityAdditionalTermsBuilderImpl.class, version="6.0.0")
@RuneDataType(value="EquityAdditionalTerms", model="Just another Rosetta model", builder=EquityAdditionalTerms.EquityAdditionalTermsBuilderImpl.class, version="6.0.0")
public interface EquityAdditionalTerms extends RosettaModelObject {

	EquityAdditionalTermsMeta metaData = new EquityAdditionalTermsMeta();

	/*********************** Getter Methods  ***********************/
	ExtraordinaryEvents getExtraordinaryEvents();
	List<? extends DeterminationRolesAndTerms> getDeterminationTerms();
	UnderlierSubstitutionProvision getSubstitutionProvision();

	/*********************** Build Methods  ***********************/
	EquityAdditionalTerms build();
	
	EquityAdditionalTerms.EquityAdditionalTermsBuilder toBuilder();
	
	static EquityAdditionalTerms.EquityAdditionalTermsBuilder builder() {
		return new EquityAdditionalTerms.EquityAdditionalTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityAdditionalTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityAdditionalTerms> getType() {
		return EquityAdditionalTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("determinationTerms"), processor, DeterminationRolesAndTerms.class, getDeterminationTerms());
		processRosetta(path.newSubPath("substitutionProvision"), processor, UnderlierSubstitutionProvision.class, getSubstitutionProvision());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityAdditionalTermsBuilder extends EquityAdditionalTerms, RosettaModelObjectBuilder {
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getOrCreateDeterminationTerms(int _index);
		@Override
		List<? extends DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> getDeterminationTerms();
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder getOrCreateSubstitutionProvision();
		@Override
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder getSubstitutionProvision();
		EquityAdditionalTerms.EquityAdditionalTermsBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(DeterminationRolesAndTerms determinationTerms);
		EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(DeterminationRolesAndTerms determinationTerms, int _idx);
		EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(List<? extends DeterminationRolesAndTerms> determinationTerms);
		EquityAdditionalTerms.EquityAdditionalTermsBuilder setDeterminationTerms(List<? extends DeterminationRolesAndTerms> determinationTerms);
		EquityAdditionalTerms.EquityAdditionalTermsBuilder setSubstitutionProvision(UnderlierSubstitutionProvision substitutionProvision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("determinationTerms"), processor, DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder.class, getDeterminationTerms());
			processRosetta(path.newSubPath("substitutionProvision"), processor, UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder.class, getSubstitutionProvision());
		}
		

		EquityAdditionalTerms.EquityAdditionalTermsBuilder prune();
	}

	/*********************** Immutable Implementation of EquityAdditionalTerms  ***********************/
	class EquityAdditionalTermsImpl implements EquityAdditionalTerms {
		private final ExtraordinaryEvents extraordinaryEvents;
		private final List<? extends DeterminationRolesAndTerms> determinationTerms;
		private final UnderlierSubstitutionProvision substitutionProvision;
		
		protected EquityAdditionalTermsImpl(EquityAdditionalTerms.EquityAdditionalTermsBuilder builder) {
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
			this.determinationTerms = ofNullable(builder.getDeterminationTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.substitutionProvision = ofNullable(builder.getSubstitutionProvision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		@RosettaAttribute("determinationTerms")
		@RuneAttribute("determinationTerms")
		public List<? extends DeterminationRolesAndTerms> getDeterminationTerms() {
			return determinationTerms;
		}
		
		@Override
		@RosettaAttribute("substitutionProvision")
		@RuneAttribute("substitutionProvision")
		public UnderlierSubstitutionProvision getSubstitutionProvision() {
			return substitutionProvision;
		}
		
		@Override
		public EquityAdditionalTerms build() {
			return this;
		}
		
		@Override
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder toBuilder() {
			EquityAdditionalTerms.EquityAdditionalTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityAdditionalTerms.EquityAdditionalTermsBuilder builder) {
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
			ofNullable(getDeterminationTerms()).ifPresent(builder::setDeterminationTerms);
			ofNullable(getSubstitutionProvision()).ifPresent(builder::setSubstitutionProvision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			if (!ListEquals.listEquals(determinationTerms, _that.getDeterminationTerms())) return false;
			if (!Objects.equals(substitutionProvision, _that.getSubstitutionProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			_result = 31 * _result + (determinationTerms != null ? determinationTerms.hashCode() : 0);
			_result = 31 * _result + (substitutionProvision != null ? substitutionProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAdditionalTerms {" +
				"extraordinaryEvents=" + this.extraordinaryEvents + ", " +
				"determinationTerms=" + this.determinationTerms + ", " +
				"substitutionProvision=" + this.substitutionProvision +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityAdditionalTerms  ***********************/
	class EquityAdditionalTermsBuilderImpl implements EquityAdditionalTerms.EquityAdditionalTermsBuilder {
	
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		protected List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> determinationTerms = new ArrayList<>();
		protected UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder substitutionProvision;
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationTerms")
		@RuneAttribute("determinationTerms")
		public List<? extends DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> getDeterminationTerms() {
			return determinationTerms;
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getOrCreateDeterminationTerms(int _index) {
		
			if (determinationTerms==null) {
				this.determinationTerms = new ArrayList<>();
			}
			DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder result;
			return getIndex(determinationTerms, _index, () -> {
						DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder newDeterminationTerms = DeterminationRolesAndTerms.builder();
						return newDeterminationTerms;
					});
		}
		
		@Override
		@RosettaAttribute("substitutionProvision")
		@RuneAttribute("substitutionProvision")
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder getSubstitutionProvision() {
			return substitutionProvision;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder getOrCreateSubstitutionProvision() {
			UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder result;
			if (substitutionProvision!=null) {
				result = substitutionProvision;
			}
			else {
				result = substitutionProvision = UnderlierSubstitutionProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@RuneAttribute("extraordinaryEvents")
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		@RosettaAttribute("determinationTerms")
		@RuneAttribute("determinationTerms")
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(DeterminationRolesAndTerms _determinationTerms) {
			if (_determinationTerms != null) {
				this.determinationTerms.add(_determinationTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(DeterminationRolesAndTerms _determinationTerms, int _idx) {
			getIndex(this.determinationTerms, _idx, () -> _determinationTerms.toBuilder());
			return this;
		}
		
		@Override 
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder addDeterminationTerms(List<? extends DeterminationRolesAndTerms> determinationTermss) {
			if (determinationTermss != null) {
				for (final DeterminationRolesAndTerms toAdd : determinationTermss) {
					this.determinationTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("determinationTerms")
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder setDeterminationTerms(List<? extends DeterminationRolesAndTerms> determinationTermss) {
			if (determinationTermss == null) {
				this.determinationTerms = new ArrayList<>();
			} else {
				this.determinationTerms = determinationTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("substitutionProvision")
		@RuneAttribute("substitutionProvision")
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder setSubstitutionProvision(UnderlierSubstitutionProvision _substitutionProvision) {
			this.substitutionProvision = _substitutionProvision == null ? null : _substitutionProvision.toBuilder();
			return this;
		}
		
		@Override
		public EquityAdditionalTerms build() {
			return new EquityAdditionalTerms.EquityAdditionalTermsImpl(this);
		}
		
		@Override
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder prune() {
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			determinationTerms = determinationTerms.stream().filter(b->b!=null).<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (substitutionProvision!=null && !substitutionProvision.prune().hasData()) substitutionProvision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			if (getDeterminationTerms()!=null && getDeterminationTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubstitutionProvision()!=null && getSubstitutionProvision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAdditionalTerms.EquityAdditionalTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityAdditionalTerms.EquityAdditionalTermsBuilder o = (EquityAdditionalTerms.EquityAdditionalTermsBuilder) other;
			
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			merger.mergeRosetta(getDeterminationTerms(), o.getDeterminationTerms(), this::getOrCreateDeterminationTerms);
			merger.mergeRosetta(getSubstitutionProvision(), o.getSubstitutionProvision(), this::setSubstitutionProvision);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			if (!ListEquals.listEquals(determinationTerms, _that.getDeterminationTerms())) return false;
			if (!Objects.equals(substitutionProvision, _that.getSubstitutionProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			_result = 31 * _result + (determinationTerms != null ? determinationTerms.hashCode() : 0);
			_result = 31 * _result + (substitutionProvision != null ? substitutionProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAdditionalTermsBuilder {" +
				"extraordinaryEvents=" + this.extraordinaryEvents + ", " +
				"determinationTerms=" + this.determinationTerms + ", " +
				"substitutionProvision=" + this.substitutionProvision +
			'}';
		}
	}
}
