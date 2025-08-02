package cdm.event.common;

import cdm.event.common.ResetInstruction;
import cdm.event.common.ResetInstruction.ResetInstructionBuilder;
import cdm.event.common.ResetInstruction.ResetInstructionBuilderImpl;
import cdm.event.common.ResetInstruction.ResetInstructionImpl;
import cdm.event.common.meta.ResetInstructionMeta;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder;
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
 * Defines the information needed to create a Reset Business Event. 
 * @version 6.0.0
 */
@RosettaDataType(value="ResetInstruction", builder=ResetInstruction.ResetInstructionBuilderImpl.class, version="6.0.0")
@RuneDataType(value="ResetInstruction", model="Just another Rosetta model", builder=ResetInstruction.ResetInstructionBuilderImpl.class, version="6.0.0")
public interface ResetInstruction extends RosettaModelObject {

	ResetInstructionMeta metaData = new ResetInstructionMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends ReferenceWithMetaPayout> getPayout();
	/**
	 * Specifies the &#39;Rate Record Day&#39; for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset-&gt;resetDate occurs at the end of the interest period, and the Reset-&gt;rateRecordDate occurs near the start of the interest period.  The Reset-&gt;rateRecordDate and Reset-&gt;observations-&gt;observationIdentifier-&gt;observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
	 */
	Date getRateRecordDate();
	/**
	 * Specifies the date on which the reset is occuring.
	 */
	Date getResetDate();

	/*********************** Build Methods  ***********************/
	ResetInstruction build();
	
	ResetInstruction.ResetInstructionBuilder toBuilder();
	
	static ResetInstruction.ResetInstructionBuilder builder() {
		return new ResetInstruction.ResetInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetInstruction> getType() {
		return ResetInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayout.class, getPayout());
		processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetInstructionBuilder extends ResetInstruction, RosettaModelObjectBuilder {
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreatePayout(int _index);
		@Override
		List<? extends ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder> getPayout();
		ResetInstruction.ResetInstructionBuilder addPayout(ReferenceWithMetaPayout payout);
		ResetInstruction.ResetInstructionBuilder addPayout(ReferenceWithMetaPayout payout, int _idx);
		ResetInstruction.ResetInstructionBuilder addPayoutValue(Payout payout);
		ResetInstruction.ResetInstructionBuilder addPayoutValue(Payout payout, int _idx);
		ResetInstruction.ResetInstructionBuilder addPayout(List<? extends ReferenceWithMetaPayout> payout);
		ResetInstruction.ResetInstructionBuilder setPayout(List<? extends ReferenceWithMetaPayout> payout);
		ResetInstruction.ResetInstructionBuilder addPayoutValue(List<? extends Payout> payout);
		ResetInstruction.ResetInstructionBuilder setPayoutValue(List<? extends Payout> payout);
		ResetInstruction.ResetInstructionBuilder setRateRecordDate(Date rateRecordDate);
		ResetInstruction.ResetInstructionBuilder setResetDate(Date resetDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder.class, getPayout());
			processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		}
		

		ResetInstruction.ResetInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ResetInstruction  ***********************/
	class ResetInstructionImpl implements ResetInstruction {
		private final List<? extends ReferenceWithMetaPayout> payout;
		private final Date rateRecordDate;
		private final Date resetDate;
		
		protected ResetInstructionImpl(ResetInstruction.ResetInstructionBuilder builder) {
			this.payout = ofNullable(builder.getPayout()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateRecordDate = builder.getRateRecordDate();
			this.resetDate = builder.getResetDate();
		}
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public List<? extends ReferenceWithMetaPayout> getPayout() {
			return payout;
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public ResetInstruction build() {
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder toBuilder() {
			ResetInstruction.ResetInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetInstruction.ResetInstructionBuilder builder) {
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getRateRecordDate()).ifPresent(builder::setRateRecordDate);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payout, _that.getPayout())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetInstruction {" +
				"payout=" + this.payout + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"resetDate=" + this.resetDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetInstruction  ***********************/
	class ResetInstructionBuilderImpl implements ResetInstruction.ResetInstructionBuilder {
	
		protected List<ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder> payout = new ArrayList<>();
		protected Date rateRecordDate;
		protected Date resetDate;
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public List<? extends ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder> getPayout() {
			return payout;
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreatePayout(int _index) {
		
			if (payout==null) {
				this.payout = new ArrayList<>();
			}
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder result;
			return getIndex(payout, _index, () -> {
						ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder newPayout = ReferenceWithMetaPayout.builder();
						return newPayout;
					});
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("payout")
		@RuneAttribute("payout")
		public ResetInstruction.ResetInstructionBuilder addPayout(ReferenceWithMetaPayout _payout) {
			if (_payout != null) {
				this.payout.add(_payout.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder addPayout(ReferenceWithMetaPayout _payout, int _idx) {
			getIndex(this.payout, _idx, () -> _payout.toBuilder());
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder addPayoutValue(Payout _payout) {
			this.getOrCreatePayout(-1).setValue(_payout.toBuilder());
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder addPayoutValue(Payout _payout, int _idx) {
			this.getOrCreatePayout(_idx).setValue(_payout.toBuilder());
			return this;
		}
		
		@Override 
		public ResetInstruction.ResetInstructionBuilder addPayout(List<? extends ReferenceWithMetaPayout> payouts) {
			if (payouts != null) {
				for (final ReferenceWithMetaPayout toAdd : payouts) {
					this.payout.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RuneAttribute("payout")
		public ResetInstruction.ResetInstructionBuilder setPayout(List<? extends ReferenceWithMetaPayout> payouts) {
			if (payouts == null) {
				this.payout = new ArrayList<>();
			} else {
				this.payout = payouts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder addPayoutValue(List<? extends Payout> payouts) {
			if (payouts != null) {
				for (final Payout toAdd : payouts) {
					this.addPayoutValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder setPayoutValue(List<? extends Payout> payouts) {
			this.payout.clear();
			if (payouts != null) {
				payouts.forEach(this::addPayoutValue);
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rateRecordDate")
		@RuneAttribute("rateRecordDate")
		public ResetInstruction.ResetInstructionBuilder setRateRecordDate(Date _rateRecordDate) {
			this.rateRecordDate = _rateRecordDate == null ? null : _rateRecordDate;
			return this;
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@RuneAttribute("resetDate")
		public ResetInstruction.ResetInstructionBuilder setResetDate(Date _resetDate) {
			this.resetDate = _resetDate == null ? null : _resetDate;
			return this;
		}
		
		@Override
		public ResetInstruction build() {
			return new ResetInstruction.ResetInstructionImpl(this);
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetInstruction.ResetInstructionBuilder prune() {
			payout = payout.stream().filter(b->b!=null).<ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayout()!=null && getPayout().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateRecordDate()!=null) return true;
			if (getResetDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetInstruction.ResetInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetInstruction.ResetInstructionBuilder o = (ResetInstruction.ResetInstructionBuilder) other;
			
			merger.mergeRosetta(getPayout(), o.getPayout(), this::getOrCreatePayout);
			
			merger.mergeBasic(getRateRecordDate(), o.getRateRecordDate(), this::setRateRecordDate);
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payout, _that.getPayout())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetInstructionBuilder {" +
				"payout=" + this.payout + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"resetDate=" + this.resetDate +
			'}';
		}
	}
}
