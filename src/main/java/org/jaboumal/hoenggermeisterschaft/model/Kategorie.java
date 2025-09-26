package org.jaboumal.hoenggermeisterschaft.model;

/**
 * Enum representing different competition categories
 */
public enum Kategorie {
    G300A("G300A", "Gewehr 300m Kategorie A"),
    G300B("G300B", "Gewehr 300m  Kategorie B"),
    P25("P25","Pistole 25m"),
    P50("P50","Pistole 50m");

    private final String shortName;
    private final String description;


    Kategorie(String shortName, String description) {
        this.shortName = shortName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getShortName() {
        return shortName;
    }
}
