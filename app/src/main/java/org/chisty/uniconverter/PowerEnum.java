package org.chisty.uniconverter;

/**
 * The Enum PowerEnum.
 */
public enum PowerEnum {

	/** The btu per sec. */
	BTU_PER_SEC("BTU/Second", 1.0, 0.7067870061706),

	/** The hp. */
	HP("Horsepower(hp)", 1.414853, 0.001818181818182),

	/** The fps. */
	FPS("Foot-Pound/Second", 550, 0),

	/** The megawatt. */
	MEGAWATT("Megawatt(MW)", 0, 0.001),

	/** The kilowatt. */
	KILOWATT("Kilowatt(KW)", 1000, 0.001),

	/** The watt. */
	WATT("Watt(joules/s)", 1000, 1.0);

	/** The label. */
	private String label;

	/** The upper to lower val. */
	private double upperToLowerVal;

	/** The lower to upper val. */
	private double lowerToUpperVal;

	/**
	 * Instantiates a new power enum.
	 *
	 * @param label
	 *            the label
	 * @param u
	 *            the u
	 * @param l
	 *            the l
	 */
	private PowerEnum(String label, double u, double l) {
		this.label = label;
		this.upperToLowerVal = u;
		this.lowerToUpperVal = l;
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
	 * Gets the name.
	 *
	 * @param name
	 *            the name
	 * @return the name
	 */
	public static PowerEnum getName(String name) {
		return valueOf(name);
	}

	/**
	 * Gets the upper to lower val.
	 *
	 * @return the upper to lower val
	 */
	public double getUpperToLowerVal() {
		return upperToLowerVal;
	}

	/**
	 * Gets the lower to upper val.
	 *
	 * @return the lower to upper val
	 */
	public double getLowerToUpperVal() {
		return lowerToUpperVal;
	}
}
