package org.chisty.uniconverter;

import java.util.ArrayList;
import java.util.List;

/**
 * The Enum SpeedTypeEnum.
 */
public enum SpeedTypeEnum {

	/** The miles per hr. */
	MILES_PER_HR("Mile/Hour"),
	/** The km per hr. */
	KM_PER_HR("Kilometer/Hour"),
	/** The meter per sec. */
	METER_PER_SEC("Meter/Second"),
	/** The ft per sec. */
	FT_PER_SEC("Foot/Second"),
	/** The inches per sec. */
	INCHES_PER_SEC("Inch/Second");

	/** The label. */
	private String label;

	/** The labels list. */
	private final List<String> labelsList = new ArrayList<String>();

	/**
	 * Instantiates a new speed type enum.
	 *
	 * @param l
	 *            the l
	 */
	private SpeedTypeEnum(String l) {
		this.label = l;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return name();
	}

	/**
	 * Gets the all labels.
	 *
	 * @return the all labels
	 */
	public String[] getAllLabels() {
		for (SpeedTypeEnum se : values()) {
			labelsList.add(se.getLabel());
		}
		return (String[]) labelsList.toArray();
	}

	/**
	 * Gets the name.
	 *
	 * @param name
	 *            the name
	 * @return the name
	 */
	public static SpeedTypeEnum getName(String name) {
		return valueOf(name);
	}
}
