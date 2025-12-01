package org.jaboumal.schuetzenportal.model.dto;

import java.util.List;

public class CompetitorDTO {
    private String vorname;
    private String name;
    private String jahrgang;
    private boolean guest;
    private Integer lizenzNummer;

    // New: store selected labels as strings
    private List<String> berchtoldSelections;

    public CompetitorDTO() {
    }

    public CompetitorDTO(String jahrgang, boolean guest, Integer lizenzNummer, String name, String vorname) {
        this.jahrgang = jahrgang;
        this.guest = guest;
        this.lizenzNummer = lizenzNummer;
        this.name = name;
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getBerchtoldSelections() {
        return berchtoldSelections;
    }

    public void setBerchtoldSelections(List<String> berchtoldSelections) {
        this.berchtoldSelections = berchtoldSelections;
    }

    @Override
    public String toString() {
        return "CompetitorDTO{" +
                "vorname='" + vorname + '\'' +
                ", name='" + name + '\'' +
                ", jahrgang='" + jahrgang + '\'' +
                ", guest=" + guest +
                ", lizenzNummer=" + lizenzNummer +
                ", berchtoldChoices=" + berchtoldSelections +
                '}';
    }
}
