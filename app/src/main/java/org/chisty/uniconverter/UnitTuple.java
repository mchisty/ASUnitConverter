package org.chisty.uniconverter;

/**
 * Created by bawa on 17/08/2015.
 */

// unitArrayStr = { "LENGTH", "WEIGHT", "AREA", "ENERGY", "TEMPERATURE",
// "SPEED", "PRESSURE", "POWER",
// "VOLUME", "TIME" };

public class UnitTuple {
	private String label;
	private String value;

	public UnitTuple(String l, String v) {
		this.label = l;
		this.value = v;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
