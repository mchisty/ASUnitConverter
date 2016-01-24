package org.chisty.uniconverter;

/**
 * The Enum TimeEnum.
 */
public enum TimeEnum {

	/** The century. */
	CENTURY(1, 10),
	/** The decade. */
	DECADE(10, 10),
	/** The year. */
	YEAR(10, 12),
	/** The month. */
	MONTH(12, 2),
	/** The fortnight. */
	FORTNIGHT(2, 2),
	/** The week. */
	WEEK(2, 7),
	/** The day. */
	DAY(7, 24),
	/** The hour. */
	HOUR(24, 60),
	/** The minute. */
	MINUTE(60, 60),
	/** The second. */
	SECOND(60, 1000),
	/** The millisecond. */
	MILLISECOND(1000, 1000),
	/** The microsecond. */
	MICROSECOND(1000, 1000),
	/** The nanosecond. */
	NANOSECOND(1000, 1);

	/** The high value. */
	private int highValue;

	/** The low value. */
	private int lowValue;

	/**
	 * Instantiates a new time enum.
	 *
	 * @param highVal
	 *            the high val
	 * @param lowVal
	 *            the low val
	 */
	TimeEnum(int highVal, int lowVal) {
		this.highValue = highVal;
		this.lowValue = lowVal;
	}

	/**
	 * Gets the high value.
	 *
	 * @return the high value
	 */
	public int getHighValue() {
		return highValue;
	}

	/**
	 * Gets the low value.
	 *
	 * @return the low value
	 */
	public int getLowValue() {
		return lowValue;
	}

	/**
	 * Gets the name.
	 *
	 * @param name
	 *            the name
	 * @return the name
	 */
	public static TimeEnum getName(String name) {
		return valueOf(name);
	}
}
