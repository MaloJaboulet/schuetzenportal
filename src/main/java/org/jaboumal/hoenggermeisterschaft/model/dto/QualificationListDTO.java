package org.jaboumal.hoenggermeisterschaft.model.dto;

import java.util.List;

/**
 * Data Transfer Object for qualification data used in list views.
 * Contains all information about a qualification record for display purposes.
 */
public class QualificationListDTO {
    /** Last name of the participant */
    private String name;
    /** First name of the participant */
    private String vorname;
    /** Club code of the participant */
    private String verein;
    /** Full name of the club */
    private String vereinName;
    /** Year of birth of the participant */
    private int jahrgang;
    /** Category of the competition */
    private String kategorie;
    /** List of scores for each shot */
    private List<Integer> schussListe;
    /** Total score (sum of all shots) */
    private int totalScore;

    /**
     * Default constructor.
     */
    public QualificationListDTO() {
    }

    /**
     * Constructor with all fields.
     * 
     * @param jahrgang year of birth of the participant
     * @param kategorie category of the competition
     * @param name last name of the participant
     * @param schussListe list of scores for each shot
     * @param totalScore total score (sum of all shots)
     * @param verein club code of the participant
     * @param vereinName full name of the club
     * @param vorname first name of the participant
     */
    public QualificationListDTO(int jahrgang, String kategorie, String name, List<Integer> schussListe, int totalScore, String verein, String vereinName, String vorname) {
        this.jahrgang = jahrgang;
        this.kategorie = kategorie;
        this.name = name;
        this.schussListe = schussListe;
        this.totalScore = totalScore;
        this.verein = verein;
        this.vereinName = vereinName;
        this.vorname = vorname;
    }

    /**
     * Gets the year of birth of the participant.
     * 
     * @return the year of birth
     */
    public int getJahrgang() {
        return jahrgang;
    }

    /**
     * Sets the year of birth of the participant.
     * 
     * @param jahrgang the year of birth to set
     */
    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    /**
     * Gets the category of the competition.
     * 
     * @return the category
     */
    public String getKategorie() {
        return kategorie;
    }

    /**
     * Sets the category of the competition.
     * 
     * @param kategorie the category to set
     */
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    /**
     * Gets the last name of the participant.
     * 
     * @return the last name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the last name of the participant.
     * 
     * @param name the last name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of scores for each shot.
     * 
     * @return the list of scores
     */
    public List<Integer> getSchussListe() {
        return schussListe;
    }

    /**
     * Sets the list of scores for each shot.
     * 
     * @param schussListe the list of scores to set
     */
    public void setSchussListe(List<Integer> schussListe) {
        this.schussListe = schussListe;
    }

    /**
     * Gets the total score (sum of all shots).
     * 
     * @return the total score
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Sets the total score (sum of all shots).
     * 
     * @param totalScore the total score to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Gets the club code of the participant.
     * 
     * @return the club code
     */
    public String getVerein() {
        return verein;
    }

    /**
     * Sets the club code of the participant.
     * 
     * @param verein the club code to set
     */
    public void setVerein(String verein) {
        this.verein = verein;
    }

    /**
     * Gets the full name of the club.
     * 
     * @return the full name of the club
     */
    public String getVereinName() {
        return vereinName;
    }

    /**
     * Sets the full name of the club.
     * 
     * @param vereinName the full name of the club to set
     */
    public void setVereinName(String vereinName) {
        this.vereinName = vereinName;
    }

    /**
     * Gets the first name of the participant.
     * 
     * @return the first name
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Sets the first name of the participant.
     * 
     * @param vorname the first name to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
