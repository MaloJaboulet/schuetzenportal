package org.jaboumal.hoenggermeisterschaft.model;

public enum Verein {
    SSGN("SSGN", "Standschützengesellschaft Neumünster"),
    SSH("SSH", "Standschützen Höngg"),
    FSZB("FSZB", "Feldschützen Züriberg"),
    ZKB("ZKB", "Zürcher Kantonalbank");

    private final String kuerzel;
    private final String fullName;


    Verein(String kuerzel, String fullName) {
        this.kuerzel = kuerzel;
        this.fullName = fullName;
    }

    public String getKuerzel() {
        return kuerzel;
    }
    public String getFullName() {
        return fullName;
    }

    public static Verein fromKuerzel(String kuerzel) {
        for (Verein verein : values()) {
            if (verein.getKuerzel().equalsIgnoreCase(kuerzel)) {
                return verein;
            }
        }
        throw new IllegalArgumentException("Unknown kuerzel: " + kuerzel);
    }
}
