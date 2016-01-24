package org.chisty.uniconverter;

import java.math.BigDecimal;

/**
 * The Class WeightManager.
 */
public class WeightManager {
	/** The Constant METRICTON_TO_KG. */
	private final static BigDecimal METRICTON_TO_KG = new BigDecimal(1000);
	/** The Constant KG_TO_METRICTON. */
	private final static BigDecimal KG_TO_METRICTON = BigDecimal.ONE.divide(METRICTON_TO_KG, Constant.MC);
	/** The Constant KG_TO_GRAM. */
	private final static BigDecimal KG_TO_GRAM = new BigDecimal(1000);
	/** The Constant METRICTON_TO_GRAM. */
	private final static BigDecimal METRICTON_TO_GRAM = METRICTON_TO_KG.multiply(KG_TO_GRAM);
	/** The Constant GRAM_TO_METRICTON. */
	private final static BigDecimal GRAM_TO_METRICTON = BigDecimal.ONE.divide(METRICTON_TO_GRAM, Constant.MC);
	/** The Constant GRAM_TO_KG. */
	private final static BigDecimal GRAM_TO_KG = BigDecimal.ONE.divide(KG_TO_GRAM, Constant.MC);
	/** The Constant GRAM_TO_MILLIGRAM. */
	private final static BigDecimal GRAM_TO_MILLIGRAM = new BigDecimal(1000);
	/** The Constant KG_TO_MILLIGRAM. */
	private final static BigDecimal KG_TO_MILLIGRAM = KG_TO_GRAM.multiply(GRAM_TO_MILLIGRAM);
	/** The Constant STONE_TO_POUND. */
	private final static BigDecimal STONE_TO_POUND = new BigDecimal(14);
	/** The Constant POUND_TO_OUNCH. */
	private final static BigDecimal POUND_TO_OUNCH = new BigDecimal(16);
	/** The Constant STONE_TO_OUNCH. */
	private final static BigDecimal STONE_TO_OUNCH = STONE_TO_POUND.multiply(POUND_TO_OUNCH);
	/** The Constant STONE_TO_KG. */
	private final static BigDecimal STONE_TO_KG = new BigDecimal(6.35029318);
	/** The Constant KG_TO_STONE. */
	private final static BigDecimal KG_TO_STONE = BigDecimal.ONE.divide(STONE_TO_KG, Constant.MC);
	/** The Constant STONE_TO_GRAM. */
	private final static BigDecimal STONE_TO_GRAM = new BigDecimal(6350.29318);
	/** The Constant STONE_TO_MILLIGRAM. */
	private final static BigDecimal STONE_TO_MILLIGRAM = STONE_TO_GRAM.multiply(GRAM_TO_MILLIGRAM);
	/** The Constant GRAM_TO_STONE. */
	private final static BigDecimal GRAM_TO_STONE = BigDecimal.ONE.divide(STONE_TO_GRAM, Constant.MC);
	/** The Constant METRICTON_TO_STONE. */
	private final static BigDecimal METRICTON_TO_STONE = new BigDecimal(157.47304442);
	/** The Constant METRICTON_TO_POUND. */
	private final static BigDecimal METRICTON_TO_POUND = METRICTON_TO_STONE.multiply(STONE_TO_POUND);
	/** The Constant METRICTON_TO_OUNCH. */
	private final static BigDecimal METRICTON_TO_OUNCH = METRICTON_TO_POUND.multiply(POUND_TO_OUNCH);
	/** The Constant KG_TO_POUND. */
	private final static BigDecimal KG_TO_POUND = new BigDecimal(2.20462262);
	/** The Constant KG_TO_OUNCH. */
	private final static BigDecimal KG_TO_OUNCH = KG_TO_POUND.multiply(POUND_TO_OUNCH);
	/** The Constant POUND_TO_GRAM. */
	private final static BigDecimal POUND_TO_GRAM = new BigDecimal(453.59237);
	/** The Constant POUND_TO_MILLIGRAM. */
	private final static BigDecimal POUND_TO_MILLIGRAM = POUND_TO_GRAM.multiply(GRAM_TO_MILLIGRAM);
	/** The Constant GRAM_TO_POUND. */
	private final static BigDecimal GRAM_TO_POUND = BigDecimal.ONE.divide(POUND_TO_GRAM, Constant.MC);
	/** The Constant METRICTON_TO_MILLIGRAM. */
	private final static BigDecimal METRICTON_TO_MILLIGRAM = METRICTON_TO_KG.multiply(KG_TO_MILLIGRAM);
	/** The Constant OUNCH_TO_MILLIGRAM. */
	private final static BigDecimal OUNCH_TO_MILLIGRAM = new BigDecimal(28349.5231);
	/** The Constant OUNCH_TO_GRAM. */
	private final static BigDecimal OUNCH_TO_GRAM = new BigDecimal(28.3495231); // TODO

	private final static BigDecimal OUNCH_TO_POUND = new BigDecimal(0.0625);

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
	public static BigDecimal getConvertedAmount(WeightTypeEnum sourceType, WeightTypeEnum targetType,
			BigDecimal amount) {
		BigDecimal updatedAmount = null;
		if (sourceType == targetType) {
			return amount;
		}
		if (sourceType == WeightTypeEnum.METRICTON) {
			if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_KG);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_GRAM);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_GRAM).multiply(GRAM_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_STONE);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_STONE).multiply(STONE_TO_POUND);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = amount.multiply(METRICTON_TO_STONE).multiply(STONE_TO_OUNCH);
			}
		} else if (sourceType == WeightTypeEnum.KILOGRAM) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = amount.multiply(KG_TO_METRICTON);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = amount.multiply(KG_TO_GRAM);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(KG_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = amount.multiply(KG_TO_STONE);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = amount.multiply(KG_TO_POUND);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = amount.multiply(KG_TO_POUND).multiply(POUND_TO_OUNCH);
			}
		} else if (sourceType == WeightTypeEnum.GRAM) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_METRICTON);
			} else if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_KG);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_STONE);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_POUND);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = amount.multiply(GRAM_TO_POUND).multiply(POUND_TO_OUNCH);
			}
		} else if (sourceType == WeightTypeEnum.MILLIGRAM) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = divide(amount, METRICTON_TO_MILLIGRAM);
			} else if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = divide(amount, KG_TO_MILLIGRAM);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = divide(amount, GRAM_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = divide(amount, STONE_TO_MILLIGRAM);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = divide(amount, POUND_TO_MILLIGRAM);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = divide(amount, OUNCH_TO_MILLIGRAM);
			}
		} else if (sourceType == WeightTypeEnum.STONE) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = divide(amount, METRICTON_TO_STONE);
			} else if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = amount.multiply(STONE_TO_KG);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = amount.multiply(STONE_TO_GRAM);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(STONE_TO_MILLIGRAM);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = amount.multiply(STONE_TO_POUND);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = amount.multiply(STONE_TO_OUNCH);
			}
		} else if (sourceType == WeightTypeEnum.POUND) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = divide(amount, METRICTON_TO_POUND);
			} else if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = divide(amount, KG_TO_POUND);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = amount.multiply(POUND_TO_GRAM);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(POUND_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = divide(amount, STONE_TO_POUND);
			} else if (WeightTypeEnum.OUNCH == targetType) {
				updatedAmount = amount.multiply(POUND_TO_OUNCH);
			}
		} else if (sourceType == WeightTypeEnum.OUNCH) {
			if (WeightTypeEnum.METRICTON == targetType) {
				updatedAmount = divide(amount, METRICTON_TO_OUNCH);
			} else if (WeightTypeEnum.KILOGRAM == targetType) {
				updatedAmount = divide(amount, KG_TO_OUNCH);
			} else if (WeightTypeEnum.GRAM == targetType) {
				updatedAmount = amount.multiply(OUNCH_TO_GRAM);
			} else if (WeightTypeEnum.MILLIGRAM == targetType) {
				updatedAmount = amount.multiply(OUNCH_TO_MILLIGRAM);
			} else if (WeightTypeEnum.STONE == targetType) {
				updatedAmount = divide(amount, STONE_TO_OUNCH);
			} else if (WeightTypeEnum.POUND == targetType) {
				updatedAmount = amount.multiply(OUNCH_TO_POUND);
			}
		}

		return updatedAmount;
	}

	/**
	 * Divide.
	 *
	 * @param amount
	 *            the amount
	 * @param conversion
	 *            the conversion
	 * @return the big decimal
	 */
	private final static BigDecimal divide(BigDecimal amount, BigDecimal conversion) {
		return amount.multiply(BigDecimal.ONE.divide(conversion, Constant.MC));
	}
}
