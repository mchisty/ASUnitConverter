package org.chisty.uniconverter;

import java.math.BigDecimal;


/**
 * The type Area manager.
 */
public class AreaManager {

    private final static BigDecimal SQ_MILE_TO_SQ_KM = new BigDecimal(2.589988110336);
    private final static BigDecimal SQ_CM_TO_SQ_INCH = new BigDecimal(0.1550003100006);
    private final static BigDecimal HECTRE_TO_SQ_INCH = new BigDecimal(15500031.00006);
    private final static BigDecimal SQ_KM_TO_SQ_INCH = new BigDecimal(1550003100.006);
    private final static BigDecimal SQ_YARD_TO_SQ_KM = BigDecimal.ONE.divide(new BigDecimal(1195990.046301), Constant.MC);
    private final static BigDecimal SQ_FT_TO_SQ_KM = BigDecimal.ONE.divide(new BigDecimal(10763910.41671), Constant.MC);
    private final static BigDecimal SQ_INCH_TO_SQ_KM = BigDecimal.ONE.divide(SQ_KM_TO_SQ_INCH, Constant.MC);


    private static boolean isCommonRuleApplicable(AreaEnum sourceType, AreaEnum targetType) {
        boolean s = (sourceType == AreaEnum.SQ_MILE || sourceType == AreaEnum.SQ_YARD || sourceType == AreaEnum.SQ_FOOT || sourceType == AreaEnum.SQ_INCH);
        boolean t = (targetType == AreaEnum.SQ_KM || targetType == AreaEnum.HECTARE || targetType == AreaEnum.SQ_METER || targetType == AreaEnum.SQ_CM);
        if (s && t) {
            return false;
        }
        return true;
    }


    /**
     * Gets common converted amount from high to low.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount     the amount
     * @return common converted amount from high to low
     */
    public static BigDecimal getCommonConvertedAmountFromHighToLow(AreaEnum sourceType, AreaEnum targetType, BigDecimal amount) {
        if (sourceType == targetType) {
            return amount;
        }
        BigDecimal result = amount;
        boolean startFlag = false;
        for (AreaEnum t : AreaEnum.values()) {
            if (sourceType == t && startFlag == false) {
                startFlag = true;
                continue;
            }
            if (startFlag) {
                BigDecimal srcAmountVal = t.getUpperToLowerVal();
                result = result.multiply(srcAmountVal);
                if (t == targetType) {
                    break;
                }
            }
        }
        return result;
    }


    /**
     * Gets common converted amount from low to high.
     *
     * @param sourceType       the source type
     * @param targetType       the target type
     * @param originalAmount   the original amount
     * @param calculatedAmount the calculated amount
     * @return the common converted amount from low to high
     */
    public static BigDecimal getCommonConvertedAmountFromLowToHigh(AreaEnum sourceType, AreaEnum targetType,
                                                                   BigDecimal originalAmount, BigDecimal calculatedAmount) {
        if (sourceType == targetType) {
            return calculatedAmount;
        }
        BigDecimal result = BigDecimal.ONE;
        boolean startFlag = false;
        AreaEnum[] vv = AreaEnum.values();
        int len = vv.length - 1;
        for (int i = len; i >= 0; --i) {
            AreaEnum t = vv[i];
            if (sourceType == t && startFlag == false) {
                startFlag = true;
                continue;
            }
            if (startFlag) {
                BigDecimal srcAmountVal = t.getLowerToUpperVal();
                result = result.multiply(srcAmountVal, Constant.MC);
                if (t == targetType) {
                    break;
                }
            }
        }
        return calculatedAmount.multiply(result);

    }


    private static BigDecimal getConvertedAmountFromHighToLow(AreaEnum sourceType, AreaEnum targetType, BigDecimal amount) {
        BigDecimal updatedAmount = null;
        BigDecimal tmp = SQ_MILE_TO_SQ_KM.multiply(AreaEnum.SQ_YARD.getUpperToLowerVal());

        if (sourceType == targetType) {
            return amount;
        }
        if (isCommonRuleApplicable(sourceType, targetType)) {
            updatedAmount = getCommonConvertedAmountFromHighToLow(sourceType, targetType, amount);
            return updatedAmount.abs(Constant.MC);
        }
        if (sourceType == AreaEnum.SQ_MILE) {
            updatedAmount = amount.multiply(SQ_MILE_TO_SQ_KM);
        } else if (sourceType == AreaEnum.SQ_YARD) {
            updatedAmount = amount.multiply(SQ_YARD_TO_SQ_KM);
        } else if (sourceType == AreaEnum.SQ_FOOT) {
            updatedAmount = amount.multiply(SQ_FT_TO_SQ_KM);
        } else if (sourceType == AreaEnum.SQ_INCH) {
            updatedAmount = amount.multiply(SQ_INCH_TO_SQ_KM);
        }
        updatedAmount = getCommonConvertedAmountFromHighToLow(AreaEnum.SQ_KM, targetType, updatedAmount);
        return updatedAmount.abs(Constant.MC);
    }


    /**
     * Gets converted amount.
     *
     * @param sourceType the source type
     * @param targetType the target type
     * @param amount     the amount
     * @return the converted amount
     */
    public static BigDecimal getConvertedAmount(AreaEnum sourceType, AreaEnum targetType, BigDecimal amount) {
        if (sourceType == targetType) {
            return amount;
        }
        if (isSourceToTargetOrderDescending(sourceType, targetType, amount)) {
            return getConvertedAmountFromHighToLow(sourceType, targetType, amount);
        }
        return getConvertedAmountFromLowToHigh(sourceType, targetType, amount);
    }


    private static boolean isSourceToTargetOrderDescending(AreaEnum sourceType, AreaEnum targetType, BigDecimal amount) {
        boolean flag = false;
        for (AreaEnum t : AreaEnum.values()) {
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


    private static BigDecimal getConvertedAmountFromLowToHigh(AreaEnum sourceType, AreaEnum targetType,
                                                              BigDecimal amount) {
        BigDecimal updatedAmount = null;
        if (sourceType == targetType) {
            return amount;
        }
        if (isCommonRuleApplicable(targetType, sourceType)) {
            updatedAmount = getCommonConvertedAmountFromLowToHigh(sourceType, targetType, amount, amount);
            return updatedAmount.abs(Constant.MC);
        }
        // First convert everything to inch, the middle point
        if (sourceType == AreaEnum.SQ_CM) {
            updatedAmount = SQ_CM_TO_SQ_INCH;
        } else if (sourceType == AreaEnum.SQ_METER) {
            updatedAmount = Constant.TEN_THOUSAND.multiply(SQ_CM_TO_SQ_INCH);
        } else if (sourceType == AreaEnum.HECTARE) {
            updatedAmount = HECTRE_TO_SQ_INCH;
        } else if (sourceType == AreaEnum.SQ_KM) {
            updatedAmount = SQ_KM_TO_SQ_INCH;
        }

        updatedAmount = updatedAmount.multiply(amount);
        updatedAmount = getCommonConvertedAmountFromLowToHigh(AreaEnum.SQ_INCH, targetType, amount, updatedAmount);
        return updatedAmount;
    }

}
