package org.jaboumal.hoenggermeisterschaft.model.dto;

public class CompetitorDTO {
    private Integer lizenzNummer;
    private String vorname;
    private String name;
    private String jahrgang;
    private boolean guest;

    /**
     * Default constructor.
     */
    public CompetitorDTO() {
    }

    public CompetitorDTO(String jahrgang, boolean guest, Integer lizenzNummer, String name, String vorname) {
        this.jahrgang = jahrgang;
        this.guest = guest;
        this.lizenzNummer = lizenzNummer;
        this.name = name;
        this.vorname = vorname;
    }

    public String getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(String jahrgang) {
        this.jahrgang = "01.01."+jahrgang;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    public Integer getLizenzNummer() {
        return lizenzNummer;
    }

    public void setLizenzNummer(Integer lizenzNummer) {
        this.lizenzNummer = lizenzNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
