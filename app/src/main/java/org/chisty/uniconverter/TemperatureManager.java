package org.chisty.uniconverter;

import java.math.BigDecimal;

/**
 * The Class TemperatureManager.
 */
public class TemperatureManager {

	/** The Constant NINE_BY_FIVE. */
	private final static BigDecimal NINE_BY_FIVE = new BigDecimal(1.8);

	/** The Constant FIVE_BY_NINE. */
	private final static BigDecimal FIVE_BY_NINE = new BigDecimal(0.5555555555);

	/**
	 * From celcius to farenheit.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// (C * 9/5) + 32
	public static BigDecimal fromCelciusToFarenheit(final BigDecimal amount) {

		// BigDecimal part1 = new BigDecimal(, Constant.MC);
		return (amount.multiply(NINE_BY_FIVE)).add(new BigDecimal(32));
	}

	/**
	 * From farenheit to celcius.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// (F - 32) * 5/9
	public static BigDecimal fromFarenheitToCelcius(final BigDecimal amount) {
		// BigDecimal part1 = new BigDecimal(5 / 9);
		return (amount.subtract(new BigDecimal(32))).multiply(FIVE_BY_NINE);
	}

	/**
	 * From celcius to kelvin.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// C + 273.15
	public static BigDecimal fromCelciusToKelvin(final BigDecimal amount) {
		return amount.add(new BigDecimal(273.15));
	}

	/**
	 * From kelvin to celcius.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// K - 273.15
	public static BigDecimal fromKelvinToCelcius(final BigDecimal amount) {
		return amount.subtract(new BigDecimal(273.15));
	}

	/**
	 * From farenheit to kelvin.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// (F - 32) * 5/9 + 273.15
	public static BigDecimal fromFarenheitToKelvin(final BigDecimal amount) {
		BigDecimal part1 = new BigDecimal(32);
		// BigDecimal part2 = new BigDecimal(5 / 9);
		BigDecimal part3 = new BigDecimal(273.15);
		return ((amount.subtract(part1)).multiply(FIVE_BY_NINE)).add(part3);
	}

	/**
	 * From kelvin to farenheit.
	 *
	 * @param amount
	 *            the amount
	 * @return the big decimal
	 */
	// (K - 273.15) * 9/5 + 32
	public static BigDecimal fromKelvinToFarenheit(final BigDecimal amount) {
		BigDecimal part1 = new BigDecimal(273.15);

		BigDecimal part3 = new BigDecimal(32);
		return ((amount.subtract(part1)).multiply(NINE_BY_FIVE)).add(part3);
	}

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
	public static BigDecimal getConvertedAmount(final TemperatureEnum sourceType, final TemperatureEnum targetType,
			final BigDecimal amount) {
		BigDecimal updatedAmount = BigDecimal.ONE;
		if (sourceType == targetType) {
			return amount;
		}
		if (sourceType == TemperatureEnum.CELSIUS) {
			if (targetType == TemperatureEnum.FAHRENHEIT) {
				updatedAmount = fromCelciusToFarenheit(amount);
			} else if (targetType == TemperatureEnum.KELVIN) {
				updatedAmount = fromCelciusToKelvin(amount);
			}
		} else if (sourceType == TemperatureEnum.FAHRENHEIT) {
			if (targetType == TemperatureEnum.CELSIUS) {
				updatedAmount = fromFarenheitToCelcius(amount);
			} else if (targetType == TemperatureEnum.KELVIN) {
				updatedAmount = fromFarenheitToKelvin(amount);
			}
		} else if (sourceType == TemperatureEnum.KELVIN) {
			if (targetType == TemperatureEnum.CELSIUS) {
				updatedAmount = fromKelvinToCelcius(amount);
			} else if (targetType == TemperatureEnum.FAHRENHEIT) {
				updatedAmount = fromKelvinToFarenheit(amount);
			}
		}

		return updatedAmount.round(Constant.MC);
	}

}
