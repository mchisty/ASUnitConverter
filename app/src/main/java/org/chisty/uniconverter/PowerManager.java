package org.chisty.uniconverter;

import java.math.BigDecimal;

//BTU_PER_SEC("BTU/Second", 1.0, 0.7067870061706),
//HP("Horsepower(hp)", 1.414853, 0.001818181818182),
//FPS("Foot-Pound/Second", 550, 0),
//// -----------------------------------------------------
//MEGAWATT("Megawatt(MW)", 0, 0.001),
//KILOWATT("Kilowatt(KW)", 1000, 0.001),
/**
 * The Class PowerManager.
 */
//WATT("Watt(joules/s))", 1000, 1.0);
public class PowerManager {
    
    /** The Constant BTU_PS_TO_WATT. */
    private static final BigDecimal BTU_PS_TO_WATT = new BigDecimal(1055.056);
    
    /** The Constant WATT_TO_BTU_PS. */
    private static final BigDecimal WATT_TO_BTU_PS = BigDecimal.ONE.divide(BTU_PS_TO_WATT, Constant.MC);
    
    /** The Constant HP_TO_WATT. */
    private static final BigDecimal HP_TO_WATT = new BigDecimal(745.6998715823);
    
    /** The Constant WATT_TO_HP. */
    private static final BigDecimal WATT_TO_HP = BigDecimal.ONE.divide(HP_TO_WATT, Constant.MC);
    
    /** The Constant FPS_TO_WATT. */
    private static final BigDecimal FPS_TO_WATT = new BigDecimal(1.355817948331);
    
    /** The Constant BTU_PS_TO_MW. */
    // ------------------------------------------
    private static final BigDecimal BTU_PS_TO_MW = new BigDecimal(0.001055056);
    // private static final BigDecimal HP_TO_MW = new BigDecimal(0.0007456998715823);
    // private static final BigDecimal MW = new BigDecimal(0.000001355817948331);
    /** The Constant HP_TO_FPS. */
    // ----------------------------------------------
    private static final BigDecimal HP_TO_FPS = new BigDecimal(13750);
    
    /** The Constant MW_TO_WATT. */
    private static final BigDecimal MW_TO_WATT = new BigDecimal(1000000);
    
    /** The Constant WATT_TO_FPS. */
    private static final BigDecimal WATT_TO_FPS = new BigDecimal(0.7375621492773);
    // private static final BigDecimal WATT_TO_HP = new BigDecimal(0.001341022089595);

    /**
     * Gets the converted amount.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount the amount
     * @return the converted amount
     */
    public static BigDecimal getConvertedAmount(PowerEnum sourceType, PowerEnum targetType, BigDecimal amount) {
	if (sourceType == targetType) {
	    return amount;
	}
	if (isSourceToTargetOrderDescending(sourceType, targetType, amount)) {
	    return getConvertedAmountFromHighToLow(sourceType, targetType, amount);
	}
	return getConvertedAmountFromLowToHigh(sourceType, targetType, amount);
    }

    /**
     * Checks if is source to target order descending.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount the amount
     * @return true, if is source to target order descending
     */
    private static boolean isSourceToTargetOrderDescending(PowerEnum sourceType, PowerEnum targetType,
	    BigDecimal amount) {
	boolean flag = false;
	for (PowerEnum t : PowerEnum.values()) {
	    if (sourceType == t) {
		flag = true;
		break;
	    }
	    if (targetType == t) {
		flag = false;
		break;
	    }
	}
	return flag;
    }

    // --------------------------
    // BTU_PER_SEC
    // HP
    // FP_PER_SECOND
    // -----------------
    // MEGAWATT
    // KILOWATT
    // WATT
    /**
     * Gets the converted amount from high to low.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount the amount
     * @return the converted amount from high to low
     */
    // ---------------------------
    private static BigDecimal getConvertedAmountFromHighToLow(PowerEnum sourceType, PowerEnum targetType,
	    BigDecimal amount) {
	BigDecimal updatedAmount = null;
	if (sourceType == targetType) {
	    return amount;
	}
	if (isCommonRuleApplicable(sourceType, targetType)) {
	    updatedAmount = getCommonConvertedAmountFromHighToLow(sourceType, targetType, amount);
	    return updatedAmount.abs(Constant.MC);
	}
	if (sourceType == PowerEnum.BTU_PER_SEC) {
	    updatedAmount = amount.multiply(BTU_PS_TO_MW);
	} else if (sourceType == PowerEnum.HP) {
	    updatedAmount = amount.multiply(HP_TO_WATT).divide(MW_TO_WATT, Constant.MC);
	} else if (sourceType == PowerEnum.FPS) {
	    updatedAmount = amount.multiply(FPS_TO_WATT).divide(MW_TO_WATT, Constant.MC);
	}
	updatedAmount = getCommonConvertedAmountFromHighToLow(PowerEnum.MEGAWATT, targetType, updatedAmount);
	return updatedAmount.abs(Constant.MC);
    }

    // --------------------------------------------------------------------------
    // Range 1: FPS, HP, BTU_PER_SEC
    // Range 2: WATT, KILOWATT, MEGAWATT
    /**
     * Gets the converted amount from low to high.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount the amount
     * @return the converted amount from low to high
     */
    // --------------------------------------------------------------------------
    private static BigDecimal getConvertedAmountFromLowToHigh(PowerEnum sourceType, PowerEnum targetType,
	    BigDecimal amount) {
	BigDecimal updatedAmount = null;
	if (sourceType == targetType) {
	    return amount;
	}
	if (isCommonRuleApplicable(targetType, sourceType)) {
	    updatedAmount = getCommonConvertedAmountFromLowToHigh(sourceType, targetType, amount, amount);
	    return updatedAmount.abs(Constant.MC);
	}
	if (sourceType == PowerEnum.WATT) {
	    if (targetType == PowerEnum.FPS) {
		updatedAmount = amount.multiply(WATT_TO_FPS);
	    } else if (targetType == PowerEnum.HP) {
		updatedAmount = amount.multiply(WATT_TO_HP);
	    } else if (targetType == PowerEnum.BTU_PER_SEC) {
		updatedAmount = amount.multiply(WATT_TO_BTU_PS);
	    }
	} else if (sourceType == PowerEnum.KILOWATT) {
	    if (targetType == PowerEnum.FPS) {
		updatedAmount = amount.multiply(Constant.THOUSAND).multiply(WATT_TO_FPS);
	    } else if (targetType == PowerEnum.HP) {
		updatedAmount = amount.multiply(Constant.THOUSAND).multiply(WATT_TO_HP);
	    } else if (targetType == PowerEnum.BTU_PER_SEC) {
		updatedAmount = amount.multiply(Constant.THOUSAND).multiply(WATT_TO_BTU_PS);
	    }
	} else if (sourceType == PowerEnum.MEGAWATT) {
	    if (targetType == PowerEnum.FPS) {
		updatedAmount = amount.multiply(Constant.MILLION).multiply(WATT_TO_FPS);
	    } else if (targetType == PowerEnum.HP) {
		updatedAmount = amount.multiply(Constant.MILLION).multiply(WATT_TO_HP);
	    } else if (targetType == PowerEnum.BTU_PER_SEC) {
		updatedAmount = amount.multiply(Constant.MILLION).multiply(WATT_TO_BTU_PS);
	    }
	}
	return updatedAmount;
    }
    // --------------------------
    // BTU_PER_SEC
    // HP
    // FP_PER_SECOND
    // -----------------
    // MEGAWATT
    // KILOWATT
    // WATT
    // ---------------------------

    // --------------------------------------------------------------------------
    // Range 1: FP_PER_SECOND, HP, BTU_PER_SEC
    // Range 2: WATT, KILOWATT, MEGAWATT
    /**
     * Checks if is common rule applicable.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @return true, if is common rule applicable
     */
    // --------------------------------------------------------------------------
    private static boolean isCommonRuleApplicable(PowerEnum sourceType, PowerEnum targetType) {
	boolean s = (sourceType == PowerEnum.BTU_PER_SEC || sourceType == PowerEnum.HP || sourceType == PowerEnum.FPS);
	boolean t = (targetType == PowerEnum.MEGAWATT || targetType == PowerEnum.KILOWATT
		|| targetType == PowerEnum.WATT);
	if (s && t) {
	    return false;
	}
	return true;
    }

    /**
     * Gets the common converted amount from high to low.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount the amount
     * @return the common converted amount from high to low
     */
    public static BigDecimal getCommonConvertedAmountFromHighToLow(PowerEnum sourceType, PowerEnum targetType,
	    BigDecimal amount) {
	if (sourceType == targetType) {
	    return amount;
	}
	BigDecimal result = amount;
	boolean startFlag = false;
	for (PowerEnum t : PowerEnum.values()) {
	    if (sourceType == t && startFlag == false) {
		startFlag = true;
		continue;
	    }
	    if (startFlag) {
		BigDecimal srcAmountVal = new BigDecimal(t.getUpperToLowerVal());
		result = result.multiply(srcAmountVal);
		if (t == targetType) {
		    break;
		}
	    }
	}
	return result;
    }

    // --------------------------
    // BTU_PER_SEC
    // HP
    // FP_PER_SECOND
    // -----------------
    // MEGAWATT
    // KILOWATT
    // WATT
    /**
     * Gets the common converted amount from low to high.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param originalAmount the original amount
     * @param calculatedAmount the calculated amount
     * @return the common converted amount from low to high
     */
    // ---------------------------
    public static BigDecimal getCommonConvertedAmountFromLowToHigh(PowerEnum sourceType, PowerEnum targetType,
	    BigDecimal originalAmount, BigDecimal calculatedAmount) {
	System.out.println("originalAmount: " + originalAmount + " calculatedAmount: " + calculatedAmount);
	if (sourceType == targetType) {
	    return originalAmount.multiply(calculatedAmount, Constant.MC);
	}
	BigDecimal result = BigDecimal.ONE;
	boolean startFlag = false;
	PowerEnum[] vv = PowerEnum.values();
	int len = vv.length - 1;
	for (int i = len; i >= 0; --i) {
	    PowerEnum t = vv[i];
	    if (sourceType == t && startFlag == false) {
		startFlag = true;
		continue;
	    }
	    // System.out.println("sourceType: " + t.name());
	    if (startFlag) {
		BigDecimal srcAmountVal = new BigDecimal(t.getLowerToUpperVal());
		result = result.multiply(srcAmountVal);
		if (t == targetType) {
		    break;
		}
	    }
	}
	// System.out.println("calculatedAmount: " + calculatedAmount + ", result amount: " + result);
	return calculatedAmount.multiply(result, Constant.MC);
    }
}
