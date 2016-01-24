package org.chisty.uniconverter;

import java.math.BigDecimal;

/**
 * The Class SpeedManager.
 */
public class SpeedManager {

	/** The Constant HOUR_TO_MINUTE. */
	public final static BigDecimal HOUR_TO_MINUTE = new BigDecimal(60);

	/** The Constant HOUR_TO_SECOND. */
	public final static BigDecimal HOUR_TO_SECOND = new BigDecimal(3600);

	/** The Constant MILE_PH_KM_PH. */
	public final static BigDecimal MILE_PH_KM_PH = LengthManager.UNIT_MILE_TO_KILOMETER;

	/** The Constant KM_PH_MILE_PH. */
	public final static BigDecimal KM_PH_MILE_PH = BigDecimal.ONE.divide(MILE_PH_KM_PH, Constant.MC);

	/** The Constant METER_PS_KM_PH. */
	public final static BigDecimal METER_PS_KM_PH = new BigDecimal(3.6);

	/** The Constant KM_PH_METER_PS. */
	public final static BigDecimal KM_PH_METER_PS = BigDecimal.ONE.divide(METER_PS_KM_PH, Constant.MC);

	/** The Constant METER_PS_FT_PS. */
	public final static BigDecimal METER_PS_FT_PS = new BigDecimal(3.2808399);

	/** The Constant FT_PS_METER_PS. */
	public final static BigDecimal FT_PS_METER_PS = BigDecimal.ONE.divide(METER_PS_FT_PS, Constant.MC);

	/** The Constant MILE_PH_METER_PS. */
	public final static BigDecimal MILE_PH_METER_PS = new BigDecimal(0.44704);

	/** The Constant METER_PS_MILE_PH. */
	public final static BigDecimal METER_PS_MILE_PH = BigDecimal.ONE.divide(MILE_PH_METER_PS, Constant.MC);

	/** The Constant MILE_PH_FT_PS. */
	public final static BigDecimal MILE_PH_FT_PS = new BigDecimal(1.46666667);

	/** The Constant FT_PS_MILE_PH. */
	public final static BigDecimal FT_PS_MILE_PH = BigDecimal.ONE.divide(MILE_PH_FT_PS, Constant.MC);

	/** The Constant MILE_PH_INCH_PS. */
	public final static BigDecimal MILE_PH_INCH_PS = new BigDecimal(17.6);

	/** The Constant INCH_PS_MILE_PH. */
	public final static BigDecimal INCH_PS_MILE_PH = BigDecimal.ONE.divide(MILE_PH_INCH_PS, Constant.MC);

	/** The Constant FT_PS_INCH_PS. */
	public final static BigDecimal FT_PS_INCH_PS = new BigDecimal(12);

	/** The Constant METER_PS_INCH_PS. */
	public final static BigDecimal METER_PS_INCH_PS = METER_PS_FT_PS.multiply(FT_PS_INCH_PS);

	/** The Constant INCH_PS_METER_PS. */
	public final static BigDecimal INCH_PS_METER_PS = BigDecimal.ONE.divide(METER_PS_INCH_PS, Constant.MC);

	/** The Constant INCH_PS_FT_PS. */
	public final static BigDecimal INCH_PS_FT_PS = BigDecimal.ONE.divide(FT_PS_INCH_PS, Constant.MC);

	/** The Constant KM_PH_FT_HR. */
	// --------------------------------------------------------------------------------------------------------
	private final static BigDecimal KM_PH_FT_HR = LengthManager.UNIT_KM_TO_FT;

	/** The Constant KM_PH_FT_PS. */
	public final static BigDecimal KM_PH_FT_PS = KM_PH_FT_HR.divide(HOUR_TO_SECOND, Constant.MC);

	/** The Constant FT_PS_KM_PH. */
	public final static BigDecimal FT_PS_KM_PH = BigDecimal.ONE.divide(KM_PH_FT_PS, Constant.MC);

	/** The Constant KM_PH_INCH_HR. */
	private final static BigDecimal KM_PH_INCH_HR = KM_PH_FT_HR.multiply(LengthManager.UNIT_FOOT_TO_INCH);

	/** The Constant KM_PH_INCH_PS. */
	public final static BigDecimal KM_PH_INCH_PS = KM_PH_INCH_HR.divide(HOUR_TO_SECOND, Constant.MC);

	/** The Constant INCH_PS_KM_PH. */
	public final static BigDecimal INCH_PS_KM_PH = BigDecimal.ONE.divide(KM_PH_INCH_PS, Constant.MC);

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
	public static BigDecimal getConvertedAmount(SpeedTypeEnum sourceType, SpeedTypeEnum targetType, BigDecimal amount) {
		BigDecimal updatedAmount = null;
		if (sourceType == targetType) {
			return amount;
		}
		if (sourceType == SpeedTypeEnum.MILES_PER_HR) {
			if (SpeedTypeEnum.KM_PER_HR == targetType) {
				updatedAmount = amount.multiply(MILE_PH_KM_PH);
			} else if (SpeedTypeEnum.METER_PER_SEC == targetType) {
				updatedAmount = amount.multiply(MILE_PH_METER_PS);
			} else if (SpeedTypeEnum.FT_PER_SEC == targetType) {
				updatedAmount = amount.multiply(MILE_PH_FT_PS);
			} else if (SpeedTypeEnum.INCHES_PER_SEC == targetType) {
				updatedAmount = amount.multiply(MILE_PH_INCH_PS);
			}
		} else if (sourceType == SpeedTypeEnum.KM_PER_HR) {
			if (SpeedTypeEnum.MILES_PER_HR == targetType) {
				updatedAmount = amount.multiply(KM_PH_MILE_PH);
			} else if (SpeedTypeEnum.METER_PER_SEC == targetType) {
				updatedAmount = amount.multiply(KM_PH_METER_PS);
			} else if (SpeedTypeEnum.FT_PER_SEC == targetType) {
				updatedAmount = amount.multiply(KM_PH_FT_HR).divide(HOUR_TO_SECOND, Constant.MC);
			} else if (SpeedTypeEnum.INCHES_PER_SEC == targetType) {
				updatedAmount = amount.multiply(KM_PH_INCH_HR).divide(HOUR_TO_SECOND, Constant.MC);
			}
		} else if (sourceType == SpeedTypeEnum.METER_PER_SEC) {
			if (SpeedTypeEnum.MILES_PER_HR == targetType) {
				updatedAmount = amount.multiply(METER_PS_MILE_PH);
			} else if (SpeedTypeEnum.KM_PER_HR == targetType) {
				updatedAmount = amount.multiply(METER_PS_KM_PH);
			} else if (SpeedTypeEnum.FT_PER_SEC == targetType) {
				updatedAmount = amount.multiply(METER_PS_FT_PS);
			} else if (SpeedTypeEnum.INCHES_PER_SEC == targetType) {
				updatedAmount = amount.multiply(METER_PS_FT_PS).multiply(FT_PS_INCH_PS);
			}
		} else if (sourceType == SpeedTypeEnum.FT_PER_SEC) {
			if (SpeedTypeEnum.MILES_PER_HR == targetType) {
				updatedAmount = amount.multiply(FT_PS_MILE_PH);
			} else if (SpeedTypeEnum.KM_PER_HR == targetType) {
				updatedAmount = amount.multiply(FT_PS_KM_PH);
			} else if (SpeedTypeEnum.METER_PER_SEC == targetType) {
				updatedAmount = amount.multiply(FT_PS_METER_PS);
			} else if (SpeedTypeEnum.INCHES_PER_SEC == targetType) {
				updatedAmount = amount.multiply(FT_PS_INCH_PS);
			}
		} else if (sourceType == SpeedTypeEnum.INCHES_PER_SEC) {
			if (SpeedTypeEnum.MILES_PER_HR == targetType) {
				updatedAmount = amount.multiply(INCH_PS_MILE_PH);
			} else if (SpeedTypeEnum.KM_PER_HR == targetType) {
				updatedAmount = amount.multiply(INCH_PS_KM_PH);
			} else if (SpeedTypeEnum.METER_PER_SEC == targetType) {
				updatedAmount = amount.multiply(INCH_PS_METER_PS);
			} else if (SpeedTypeEnum.FT_PER_SEC == targetType) {
				updatedAmount = amount.multiply(INCH_PS_FT_PS);
			}
		}
		return updatedAmount.abs(Constant.MC);
	}
}
