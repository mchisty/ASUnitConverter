package org.chisty.uniconverter;

import java.util.ArrayList;
import java.util.List;

public enum AreaEnum {

	SQ_MILE("Square Mile", 0, 0.0),
	SQ_YARD("Square Yard", 3097600, 0.11111),
	SQ_FOOT("Square Foot", 9, 0.0069445),
	SQ_INCH("Square Inch", 144, 0.0),
	// --------------------------------------------
	SQ_KM("Square Kilometer", 1, 0.01),
	HECTARE("Hectare", 100, 0.0001),
	SQ_METER("Square Meter", 10000, 0.0001),
	SQ_CM("Square Centimeter", 10000, 0.0);

	/** The label. */
	private String label;
	private Integer highVal;
	private Double lowVal;

	/** The labels list. */
	private final List<String> labelsList = new ArrayList<String>();

	/**
	 * Instantiates a new speed type enum.
	 *
	 * @param l
	 *            the l
	 */
	private AreaEnum(String l, Integer hv, Double lv) {
		this.label = l;
		this.highVal = hv;
		this.lowVal = lv;
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
		for (AreaEnum se : values()) {
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
	public static AreaEnum getName(String name) {
		return valueOf(name);
	}
}
