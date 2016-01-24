package org.chisty.uniconverter;

public class LengthTuple<LengthTypeEnum, BigDecimal> {
	private LengthTypeEnum lt;
	private BigDecimal amount;

	public LengthTuple(LengthTypeEnum lt, BigDecimal amount) {
		this.lt = lt;
		this.amount = amount;
	}

	public LengthTypeEnum getLt() {
		return lt;
	}

	public void setLt(LengthTypeEnum lt) {
		this.lt = lt;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
