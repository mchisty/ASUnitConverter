package org.chisty.uniconverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The enum Area enum.
 */
public enum AreaEnum {

    /**
     * Sq mile area enum.
     */
    SQ_MILE("Sqr. Mile", 1, 0.0000003228305785124),
    /**
     * Sq yard area enum.
     */
    SQ_YARD("Sqr. Yard", 3097600, 0.11111),
    /**
     * Sq foot area enum.
     */
    SQ_FOOT("Sqr. Foot", 9, 0.0069445),
    /**
     * Sq inch area enum.
     */
    SQ_INCH("Sqr. Inch", 144, 1.0),
    /**
     * Sq km area enum.
     */
// --------------------------------------------
    SQ_KM("Sqr. KM", 1, 0.01),
    /**
     * Hectare area enum.
     */
    HECTARE("Hectare", 100, 0.0001),
    /**
     * Sq meter area enum.
     */
    SQ_METER("Sqr. Meter", 10000, 0.0001),
    /**
     * Sq cm area enum.
     */
    SQ_CM("Sqr. CM", 10000, 0.0);

    /**
     * The labels list.
     */
    private final List<String> labelsList = new ArrayList<String>();
    /**
     * The label.
     */
    private String label;
    /**
     * The upper to lower val.
     */
    private double upperToLowerVal;
    /**
     * The lower to upper val.
     */
    private double lowerToUpperVal;

    /**
     * Instantiates a new speed type enum.
     *
     * @param l the l
     */
    private AreaEnum(String l, Integer hv, Double lv) {
        this.label = l;
        this.upperToLowerVal = hv;
        this.lowerToUpperVal = lv;
    }

    /**
     * Gets the name.
     *
     * @param name the name
     * @return the name
     */
    public static AreaEnum getName(String name) {
        return valueOf(name);
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
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(String label) {
        this.label = label;
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
     * Gets upper to lower val.
     *
     * @return the upper to lower val
     */
    public BigDecimal getUpperToLowerVal() {
        return new BigDecimal(upperToLowerVal);
    }

    /**
     * Gets lower to upper val.
     *
     * @return the lower to upper val
     */
    public BigDecimal getLowerToUpperVal() {
        return new BigDecimal(lowerToUpperVal);

    }
}
