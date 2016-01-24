package org.chisty.uniconverter;

import java.math.BigDecimal;

/**
 * The Class TimeManager.
 */
public class TimeManager {

	/** The Constant DECADE_TO_YEAR. */
	private final static BigDecimal DECADE_TO_YEAR = new BigDecimal(10);

	/** The Constant YEAR_TO_MONTH. */
	private final static BigDecimal YEAR_TO_MONTH = new BigDecimal(12);

	/** The Constant MONTH_TO_FORTNIGHT. */
	private final static BigDecimal MONTH_TO_FORTNIGHT = new BigDecimal(2.174126129167);

	/** The Constant YEAR_TO_FORTNIGHT. */
	private final static BigDecimal YEAR_TO_FORTNIGHT = YEAR_TO_MONTH.multiply(MONTH_TO_FORTNIGHT);

	/** The Constant DAY_TO_HOUR. */
	private final static BigDecimal DAY_TO_HOUR = new BigDecimal(24);

	/** The Constant DAY_TO_MINUTE. */
	private static final BigDecimal DAY_TO_MINUTE = new BigDecimal(1440);

	/** The Constant SECOND_TO_MILLISECOND. */
	private final static BigDecimal SECOND_TO_MILLISECOND = new BigDecimal(1000);

	/** The Constant SECOND_TO_MICROSECOND. */
	private final static BigDecimal SECOND_TO_MICROSECOND = new BigDecimal(1000000);

	/** The Constant SECOND_TO_NANOSECOND. */
	private final static BigDecimal SECOND_TO_NANOSECOND = new BigDecimal(1000000000);

	/** The Constant MONTH_TO_WEEK. */
	private static final BigDecimal MONTH_TO_WEEK = new BigDecimal(4.348252258333);

	/** The Constant MONTH_TO_DAY. */
	private static final BigDecimal MONTH_TO_DAY = new BigDecimal(30.43776580833);

	/** The Constant MONTH_TO_SECOND. */
	private static final BigDecimal MONTH_TO_SECOND = new BigDecimal(2629822.96584);

	/** The Constant CENTURY_TO_MONTH. */
	private static final BigDecimal CENTURY_TO_MONTH = new BigDecimal(1199.168172521);

	/**
	 * Gets the converted amount.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param amount
	 *            the amount
	 * @return the converted amount
	 */
	public static BigDecimal getConvertedAmount(TimeEnum sourceType, TimeEnum targetType, BigDecimal amount) {
		if (sourceType == targetType) {
			return amount;
		}
		if (isSourceToTargetOrderAscending(sourceType, targetType, amount)) {
			return getConvertedAmountFromHighToLow(sourceType, targetType, amount);
		}
		return getConvertedAmountFromLowToHigh(sourceType, targetType, amount);
	}

	/**
	 * Checks if is source to target order ascending.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param amount
	 *            the amount
	 * @return true, if is source to target order ascending
	 */
	private static boolean isSourceToTargetOrderAscending(TimeEnum sourceType, TimeEnum targetType, BigDecimal amount) {
		boolean flag = false;
		for (TimeEnum t : TimeEnum.values()) {
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

	/**
	 * Gets the converted amount from high to low.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param amount
	 *            the amount
	 * @return the converted amount from high to low
	 */
	private static BigDecimal getConvertedAmountFromHighToLow(TimeEnum sourceType, TimeEnum targetType,
			BigDecimal amount) {
		BigDecimal updatedAmount = null;
		if (sourceType == targetType) {
			return amount;
		}
		if (isCommonRuleApplicable(sourceType, targetType)) {
			updatedAmount = getCommonConvertedAmountFromHighToLow(sourceType, targetType, amount);
			return updatedAmount.abs(Constant.MC);
		}
		if (sourceType == TimeEnum.CENTURY) {
			updatedAmount = amount.multiply(CENTURY_TO_MONTH).multiply(MONTH_TO_FORTNIGHT);
		} else if (sourceType == TimeEnum.DECADE) {
			updatedAmount = amount.multiply(DECADE_TO_YEAR).multiply(YEAR_TO_FORTNIGHT);
		} else if (sourceType == TimeEnum.YEAR) {
			updatedAmount = amount.multiply(YEAR_TO_FORTNIGHT);
		} else if (sourceType == TimeEnum.MONTH) {
			updatedAmount = amount.multiply(MONTH_TO_FORTNIGHT);
		}
		updatedAmount = getCommonConvertedAmountFromHighToLow(TimeEnum.FORTNIGHT, targetType, updatedAmount);
		return updatedAmount.abs(Constant.MC);
	}

	/**
	 * Gets the converted amount from low to high.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param amount
	 *            the amount
	 * @return the converted amount from low to high
	 */
	private static BigDecimal getConvertedAmountFromLowToHigh(TimeEnum sourceType, TimeEnum targetType,
			BigDecimal amount) {
		BigDecimal updatedAmount = null;
		if (sourceType == targetType) {
			return amount;
		}
		if (isCommonRuleApplicable(targetType, sourceType)) {
			updatedAmount = getCommonConvertedAmountFromLowToHigh(sourceType, targetType, amount, amount);
			return updatedAmount.abs(Constant.MC);
		}
		if (sourceType == TimeEnum.NANOSECOND) {
			updatedAmount = MONTH_TO_SECOND.multiply(SECOND_TO_NANOSECOND);
		} else if (sourceType == TimeEnum.MICROSECOND) {
			updatedAmount = MONTH_TO_SECOND.multiply(SECOND_TO_MICROSECOND);
		} else if (sourceType == TimeEnum.MILLISECOND) {
			updatedAmount = MONTH_TO_SECOND.multiply(SECOND_TO_MILLISECOND);
		} else if (sourceType == TimeEnum.SECOND) {
			updatedAmount = MONTH_TO_SECOND;
		} else if (sourceType == TimeEnum.MINUTE) {
			updatedAmount = MONTH_TO_DAY.multiply(DAY_TO_MINUTE);
		} else if (sourceType == TimeEnum.HOUR) {
			updatedAmount = MONTH_TO_DAY.multiply(DAY_TO_HOUR);
		} else if (sourceType == TimeEnum.DAY) {
			updatedAmount = MONTH_TO_DAY;
		} else if (sourceType == TimeEnum.WEEK) {
			updatedAmount = MONTH_TO_WEEK;
		} else if (sourceType == TimeEnum.FORTNIGHT) {
			updatedAmount = MONTH_TO_FORTNIGHT;
		}
		updatedAmount = getCommonConvertedAmountFromLowToHigh(TimeEnum.MONTH, targetType, amount, updatedAmount);
		return updatedAmount;
	}

	/**
	 * Checks if is common rule applicable.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @return true, if is common rule applicable
	 */
	private static boolean isCommonRuleApplicable(TimeEnum sourceType, TimeEnum targetType) {
		boolean s = (sourceType == TimeEnum.CENTURY || sourceType == TimeEnum.DECADE || sourceType == TimeEnum.YEAR
				|| sourceType == TimeEnum.MONTH);
		boolean t = (targetType == TimeEnum.FORTNIGHT || targetType == TimeEnum.WEEK || targetType == TimeEnum.DAY
				|| targetType == TimeEnum.HOUR || targetType == TimeEnum.MINUTE || targetType == TimeEnum.SECOND
				|| targetType == TimeEnum.MILLISECOND || targetType == TimeEnum.MICROSECOND
				|| targetType == TimeEnum.NANOSECOND);
		if (s && t) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the common converted amount from high to low.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param amount
	 *            the amount
	 * @return the common converted amount from high to low
	 */
	public static BigDecimal getCommonConvertedAmountFromHighToLow(TimeEnum sourceType, TimeEnum targetType,
			BigDecimal amount) {
		if (sourceType == targetType) {
			return amount;
		}
		BigDecimal result = amount;
		boolean startFlag = false;
		for (TimeEnum t : TimeEnum.values()) {
			if (sourceType == t && startFlag == false) {
				startFlag = true;
				continue;
			}
			if (startFlag) {
				BigDecimal srcAmountVal = new BigDecimal(t.getHighValue());
				result = result.multiply(srcAmountVal);
				if (t == targetType) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Gets the common converted amount from low to high.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @param originalAmount
	 *            the original amount
	 * @param calculatedAmount
	 *            the calculated amount
	 * @return the common converted amount from low to high
	 */
	public static BigDecimal getCommonConvertedAmountFromLowToHigh(TimeEnum sourceType, TimeEnum targetType,
			BigDecimal originalAmount, BigDecimal calculatedAmount) {
		if (sourceType == targetType) {
			return originalAmount.divide(calculatedAmount, Constant.MC);
		}
		BigDecimal result = BigDecimal.ONE;
		boolean startFlag = false;
		TimeEnum[] vv = TimeEnum.values();
		int len = vv.length - 1;
		for (int i = len; i >= 0; --i) {
			TimeEnum t = vv[i];
			if (sourceType == t && startFlag == false) {
				startFlag = true;
				continue;
			}
			if (startFlag) {
				BigDecimal srcAmountVal = new BigDecimal(t.getLowValue());
				result = result.multiply(srcAmountVal);
				if (t == targetType) {
					break;
				}
			}
		}
		return calculatedAmount.divide(result, Constant.MC);
	}
}