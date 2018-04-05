package dk.skat.rsu.b2b.sample.mvc;

import java.io.Serializable;

/**
 * OptionModel - Just for the dropdown buttons
 *
 * @author SKAT
 * @since 1.0
 */
public class OptionModel implements Serializable {

    private String value;

    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public OptionModel(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
