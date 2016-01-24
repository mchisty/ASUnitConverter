package org.chisty.uniconverter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Constant {
	public final static BigDecimal MILLION = new BigDecimal(1000000);
	public final static BigDecimal THOUSAND = new BigDecimal(1000);
	public final static BigDecimal HUNDRED = new BigDecimal(100);
	public final static int PRECISION = 5;
	public final static MathContext MC = new MathContext(6, RoundingMode.HALF_UP);

}
