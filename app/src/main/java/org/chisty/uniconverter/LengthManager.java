package org.chisty.uniconverter;

import java.math.BigDecimal;

/**
 * The Class LengthManager.
 */
public class LengthManager {
	/** The Constant UNIT_KM_TO_METER. */
	public final static BigDecimal UNIT_KM_TO_METER = new BigDecimal(1000);
	/** The Constant UNIT_METER_TO_CM. */
	public final static BigDecimal UNIT_METER_TO_CM = new BigDecimal(100);
	/** The Constant UNIT_CM_TO_MM. */
	public final static BigDecimal UNIT_CM_TO_MM = new BigDecimal(10);
	/** The Constant UNIT_METER_TO_MM. */
	public final static BigDecimal UNIT_METER_TO_MM = UNIT_METER_TO_CM.multiply(UNIT_CM_TO_MM);
	/** The Constant UNIT_MM_TO_CM. */
	public final static BigDecimal UNIT_MM_TO_CM = BigDecimal.ONE.divide(UNIT_CM_TO_MM, Constant.MC);
	/** The Constant UNIT_MM_TO_METER. */
	public final static BigDecimal UNIT_MM_TO_METER = BigDecimal.ONE.divide(UNIT_METER_TO_MM, Constant.MC);
	/** The Constant UNIT_CM_TO_METER. */
	public final static BigDecimal UNIT_CM_TO_METER = BigDecimal.ONE.divide(UNIT_METER_TO_CM, Constant.MC);
	/** The Constant UNIT_KM_TO_CM. */
	public final static BigDecimal UNIT_KM_TO_CM = UNIT_METER_TO_CM.multiply(UNIT_KM_TO_METER);
	/** The Constant UNIT_CM_TO_KM. */
	public final static BigDecimal UNIT_CM_TO_KM = BigDecimal.ONE.divide(UNIT_KM_TO_CM, Constant.MC);
	/** The Constant UNIT_MILE_TO_YARD. */
	public final static BigDecimal UNIT_MILE_TO_YARD = new BigDecimal(1760);
	/** The Constant UNIT_MILE_TO_FT. */
	public final static BigDecimal UNIT_MILE_TO_FT = new BigDecimal(5280);
	/** The Constant UNIT_YARD_TO_MILE. */
	public final static BigDecimal UNIT_YARD_TO_MILE = BigDecimal.ONE.divide(UNIT_MILE_TO_YARD, Constant.MC);
	/** The Constant UNIT_YARD_TO_FEET. */
	public final static BigDecimal UNIT_YARD_TO_FEET = new BigDecimal(3);
	/** The Constant UNIT_FOOT_TO_INCH. */
	public final static BigDecimal UNIT_FOOT_TO_INCH = new BigDecimal(12);
	/** The Constant UNIT_INCH_TO_FT. */
	public final static BigDecimal UNIT_INCH_TO_FT = BigDecimal.ONE.divide(UNIT_FOOT_TO_INCH, Constant.MC);
	/** The Constant UNIT_YARD_TO_INCH. */
	public final static BigDecimal UNIT_YARD_TO_INCH = new BigDecimal(36);
	/** The Constant UNIT_INCH_TO_CM. */
	public final static BigDecimal UNIT_INCH_TO_CM = new BigDecimal(2.54);
	/** The Constant UNIT_CM_TO_INCH. */
	public final static BigDecimal UNIT_CM_TO_INCH = BigDecimal.ONE.divide(UNIT_INCH_TO_CM, Constant.MC);
	/** The Constant UNIT_FOOT_TO_CM. */
	public final static BigDecimal UNIT_FOOT_TO_CM = new BigDecimal(30.48);
	/** The Constant UNIT_CM_TO_FT. */
	public final static BigDecimal UNIT_CM_TO_FT = BigDecimal.ONE.divide(UNIT_FOOT_TO_CM, Constant.MC);
	/** The Constant UNIT_YARD_TO_CM. */
	public final static BigDecimal UNIT_YARD_TO_CM = new BigDecimal(91.44);
	/** The Constant UNIT_CM_TO_YARD. */
	public final static BigDecimal UNIT_CM_TO_YARD = BigDecimal.ONE.divide(UNIT_YARD_TO_CM, Constant.MC);
	/** The Constant UNIT_MILE_TO_METER. */
	public final static BigDecimal UNIT_MILE_TO_METER = new BigDecimal(1609.344);
	/** The Constant UNIT_MILE_TO_CM. */
	public final static BigDecimal UNIT_MILE_TO_CM = new BigDecimal(160934.4);
	/** The Constant UNIT_MILE_TO_MM. */
	public final static BigDecimal UNIT_MILE_TO_MM = UNIT_MILE_TO_CM.multiply(UNIT_CM_TO_MM);
	/** The Constant UNIT_CM_TO_MILE. */
	public final static BigDecimal UNIT_CM_TO_MILE = BigDecimal.ONE.divide(UNIT_MILE_TO_CM, Constant.MC);
	/** The Constant UNIT_METER_TO_MILE. */
	public final static BigDecimal UNIT_METER_TO_MILE = BigDecimal.ONE.divide(UNIT_MILE_TO_METER, Constant.MC);
	/** The Constant UNIT_MILE_TO_KILOMETER. */
	public final static BigDecimal UNIT_MILE_TO_KILOMETER = new BigDecimal(1.609344);
	/** The Constant UNIT_KM_TO_MILE. */
	public final static BigDecimal UNIT_KM_TO_MILE = BigDecimal.ONE.divide(UNIT_MILE_TO_KILOMETER, Constant.MC);
	/** The Constant UNIT_METER_TO_YARD. */
	public final static BigDecimal UNIT_METER_TO_YARD = new BigDecimal(1.0936133);
	/** The Constant UNIT_METER_TO_FEET. */
	public final static BigDecimal UNIT_METER_TO_FEET = new BigDecimal(3.2808399);
	/** The Constant UNIT_METER_TO_INCH. */
	public final static BigDecimal UNIT_METER_TO_INCH = new BigDecimal(39.37007874);
	/** The Constant UNIT_YARD_TO_METER. */
	public final static BigDecimal UNIT_YARD_TO_METER = new BigDecimal(0.9144);
	/** The Constant UNIT_KM_TO_YARD. */
	public final static BigDecimal UNIT_KM_TO_YARD = new BigDecimal(1093.61329834);
	/** The Constant UNIT_KM_TO_FT. */
	public final static BigDecimal UNIT_KM_TO_FT = new BigDecimal(3280.83989501);
	/** The Constant UNIT_YARD_TO_KM. */
	public final static BigDecimal UNIT_YARD_TO_KM = BigDecimal.ONE.divide(UNIT_KM_TO_YARD, Constant.MC);
	/** The Constant UNIT_KM_TO_MM. */
	public final static BigDecimal UNIT_KM_TO_MM = UNIT_KM_TO_CM.multiply(UNIT_CM_TO_MM);

	/**
	 * From mile to feet.
	 *
	 * @param mile
	 *            the mile
	 * @return the big decimal
	 */
	public static BigDecimal fromMileToFeet(BigDecimal mile) {
		return mile.multiply(UNIT_MILE_TO_YARD).multiply(UNIT_YARD_TO_FEET).multiply(BigDecimal.ONE);
	}

	/**
	 * From mile to inches.
	 *
	 * @param mile
	 *            the mile
	 * @return the big decimal
	 */
	public static BigDecimal fromMileToInches(BigDecimal mile) {
		return fromMileToFeet(mile).multiply(UNIT_FOOT_TO_INCH).multiply(BigDecimal.ONE);
	}

	/**
	 * From mile to meter.
	 *
	 * @param mile
	 *            the mile
	 * @return the big decimal
	 */
	public static BigDecimal fromMileToMeter(BigDecimal mile) {
		return mile.multiply(UNIT_MILE_TO_METER).multiply(BigDecimal.ONE);
	}

	/**
	 * From mile to kilometer.
	 *
	 * @param mile
	 *            the mile
	 * @return the big decimal
	 */
	public static BigDecimal fromMileToKilometer(BigDecimal mile) {
		return mile.multiply(UNIT_MILE_TO_KILOMETER);
	}

	/**
	 * From kilometer to mile.
	 *
	 * @param kilometer
	 *            the kilometer
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToMile(BigDecimal kilometer) {
		return kilometer.multiply(UNIT_KM_TO_MILE);
	}

	/**
	 * From meter to centimeter.
	 *
	 * @param meter
	 *            the meter
	 * @return the big decimal
	 */
	public static BigDecimal fromMeterToCentimeter(BigDecimal meter) {
		return meter.multiply(UNIT_METER_TO_CM);
	}

	/**
	 * From kilometer to meter.
	 *
	 * @param kiloMeter
	 *            the kilo meter
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToMeter(BigDecimal kiloMeter) {
		return kiloMeter.multiply(UNIT_KM_TO_METER).multiply(BigDecimal.ONE);
	}

	/**
	 * From kilometer to centimeter.
	 *
	 * @param kiloMeter
	 *            the kilo meter
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToCentimeter(BigDecimal kiloMeter) {
		return kiloMeter.multiply(UNIT_KM_TO_METER).multiply(UNIT_METER_TO_CM).multiply(BigDecimal.ONE);
	}

	/**
	 * From kilometer to yard.
	 *
	 * @param kiloMeter
	 *            the kilo meter
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToYard(BigDecimal kiloMeter) {
		return fromKilometerToMile(kiloMeter).multiply(UNIT_MILE_TO_YARD);
	}

	/**
	 * From meter to yard.
	 *
	 * @param meter
	 *            the meter
	 * @return the big decimal
	 */
	public static BigDecimal fromMeterToYard(BigDecimal meter) {
		return meter.multiply(UNIT_METER_TO_YARD);
	}

	/**
	 * From meter to mile.
	 *
	 * @param meter
	 *            the meter
	 * @return the big decimal
	 */
	public static BigDecimal fromMeterToMile(BigDecimal meter) {
		return meter.multiply(UNIT_METER_TO_MILE);
	}

	/**
	 * From yard to meter.
	 *
	 * @param yard
	 *            the yard
	 * @return the big decimal
	 */
	public static BigDecimal fromYardToMeter(BigDecimal yard) {
		return yard.multiply(UNIT_YARD_TO_METER);
	}

	/**
	 * From yard to centimeter.
	 *
	 * @param yard
	 *            the yard
	 * @return the big decimal
	 */
	public static BigDecimal fromYardToCentimeter(BigDecimal yard) {
		return fromYardToMeter(yard).multiply(UNIT_METER_TO_CM);
	}

	/**
	 * From centimeter to inches.
	 *
	 * @param cm
	 *            the cm
	 * @return the big decimal
	 */
	public static BigDecimal fromCentimeterToInches(BigDecimal cm) {
		return cm.multiply(UNIT_CM_TO_INCH);
	}

	/**
	 * From centimeter to yard.
	 *
	 * @param cm
	 *            the cm
	 * @return the big decimal
	 */
	public static BigDecimal fromCentimeterToYard(BigDecimal cm) {
		return cm.multiply(UNIT_CM_TO_YARD);
	}

	/**
	 * From centimeter to mile.
	 *
	 * @param cm
	 *            the cm
	 * @return the big decimal
	 */
	public static BigDecimal fromCentimeterToMile(BigDecimal cm) {
		return fromCentimeterToYard(cm).multiply(UNIT_YARD_TO_MILE);
	}

	/**
	 * From centimeter to kilometer.
	 *
	 * @param cm
	 *            the cm
	 * @return the big decimal
	 */
	public static BigDecimal fromCentimeterToKilometer(BigDecimal cm) {
		return cm.multiply(UNIT_CM_TO_KM);
	}

	/**
	 * From kilometer to inches.
	 *
	 * @param km
	 *            the km
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToInches(BigDecimal km) {
		return km.multiply(UNIT_KM_TO_FT).multiply(UNIT_FOOT_TO_INCH).multiply(BigDecimal.ONE);
	}

	/**
	 * From meter to inches.
	 *
	 * @param meter
	 *            the meter
	 * @return the big decimal
	 */
	public static BigDecimal fromMeterToInches(BigDecimal meter) {
		return meter.multiply(UNIT_METER_TO_INCH);
	}

	/**
	 * From mile to milimeter.
	 *
	 * @param mile
	 *            the mile
	 * @return the big decimal
	 */
	public static BigDecimal fromMileToMilimeter(BigDecimal mile) {
		return mile.multiply(UNIT_MILE_TO_MM);
	}

	/**
	 * From kilometer to millimeter.
	 *
	 * @param km
	 *            the km
	 * @return the big decimal
	 */
	public static BigDecimal fromKilometerToMillimeter(BigDecimal km) {
		return km.multiply(UNIT_KM_TO_MM);
	}

	/**
	 * From meter to millimeter.
	 *
	 * @param meter
	 *            the meter
	 * @return the big decimal
	 */
	public static BigDecimal fromMeterToMillimeter(BigDecimal meter) {
		return meter.multiply(UNIT_METER_TO_CM).multiply(UNIT_CM_TO_MM);
	}

	/**
	 * From inch to millimeter.
	 *
	 * @param inch
	 *            the inch
	 * @return the big decimal
	 */
	public static BigDecimal fromInchToMillimeter(BigDecimal inch) {
		return inch.multiply(UNIT_INCH_TO_CM).multiply(UNIT_CM_TO_MM);
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
	public static BigDecimal getConvertedAmount(final LengthTypeEnum sourceType, final LengthTypeEnum targetType,
			final BigDecimal amount) {
		BigDecimal updatedAmount = BigDecimal.ONE;
		if (sourceType == targetType) {
			return amount;
		}
		if (sourceType == LengthTypeEnum.MILE) {
			if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = amount.multiply(new BigDecimal(1.609344), Constant.MC);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = amount.multiply(new BigDecimal(1609.344));
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_MILE_TO_METER).multiply(UNIT_METER_TO_CM);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = amount.multiply(UNIT_MILE_TO_YARD);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = fromMileToFeet(amount);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = fromMileToInches(amount);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = fromMileToMeter(amount).multiply(UNIT_METER_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.KILOMETER) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = fromKilometerToMile(amount);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = fromKilometerToMeter(amount);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = fromKilometerToCentimeter(amount);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = fromKilometerToYard(amount);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = fromKilometerToYard(amount).multiply(UNIT_YARD_TO_FEET);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = fromKilometerToYard(amount).multiply(UNIT_YARD_TO_INCH);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = fromKilometerToCentimeter(amount).multiply(UNIT_CM_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.METER) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = fromMeterToMile(amount);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_KM_TO_METER, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = fromMeterToCentimeter(amount);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = fromMeterToYard(amount);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = fromMeterToYard(amount).multiply(UNIT_YARD_TO_FEET);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = fromMeterToYard(amount).multiply(UNIT_YARD_TO_INCH);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_METER_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.CENTIMETER) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = fromCentimeterToMile(amount);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_KM);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_METER);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_YARD);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_FT);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_INCH);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_CM_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.YARD) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = amount.multiply(UNIT_YARD_TO_MILE);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_YARD_TO_KM);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = amount.multiply(UNIT_YARD_TO_METER);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = fromYardToCentimeter(amount);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = amount.multiply(UNIT_YARD_TO_FEET);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = amount.multiply(UNIT_YARD_TO_INCH);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = fromYardToCentimeter(amount).multiply(UNIT_CM_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.FOOT) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_MILE_TO_FT, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_KM_TO_FT, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_METER_TO_FEET, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_FOOT_TO_CM);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_YARD_TO_FEET, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = amount.multiply(UNIT_FOOT_TO_INCH);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_FOOT_TO_CM).multiply(UNIT_CM_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.INCHES) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromMileToInches(BigDecimal.ONE), Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromKilometerToInches(BigDecimal.ONE), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromMeterToInches(BigDecimal.ONE), Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_INCH_TO_CM);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_YARD_TO_INCH, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = amount.multiply(UNIT_INCH_TO_FT);
			} else if (LengthTypeEnum.MILLIMETER == targetType) {
				updatedAmount = amount.multiply(UNIT_INCH_TO_CM).multiply(UNIT_CM_TO_MM);
			}
		} else if (sourceType == LengthTypeEnum.MILLIMETER) {
			if (LengthTypeEnum.MILE == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromMileToMilimeter(BigDecimal.ONE), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.KILOMETER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromKilometerToMillimeter(BigDecimal.ONE), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.METER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromMeterToMillimeter(BigDecimal.ONE), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.CENTIMETER == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_CM_TO_MM, Constant.MC).multiply(amount);
			} else if (LengthTypeEnum.YARD == targetType) {
				updatedAmount = BigDecimal.ONE
						.divide(fromYardToCentimeter(BigDecimal.ONE).multiply(UNIT_CM_TO_MM), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.FOOT == targetType) {
				updatedAmount = BigDecimal.ONE.divide(UNIT_FOOT_TO_CM.multiply(UNIT_CM_TO_MM), Constant.MC)
						.multiply(amount);
			} else if (LengthTypeEnum.INCHES == targetType) {
				updatedAmount = BigDecimal.ONE.divide(fromInchToMillimeter(BigDecimal.ONE), Constant.MC)
						.multiply(amount);
			}
		}
		return updatedAmount; // .abs(Constant.MC);
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
