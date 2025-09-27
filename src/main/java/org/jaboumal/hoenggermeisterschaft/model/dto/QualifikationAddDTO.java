package org.jaboumal.hoenggermeisterschaft.model.dto;

import org.jaboumal.hoenggermeisterschaft.model.enums.Kategorie;
import org.jaboumal.hoenggermeisterschaft.model.enums.Verein;

import java.util.List;

/**
 * Data Transfer Object for qualification data used when adding a new qualification.
 * Contains all information needed to create a new qualification record.
 */
public class QualifikationAddDTO {

    /** Last name of the participant */
    private String name;
    /** First name of the participant */
    private String vorname;
    /** Club of the participant */
    private Verein verein;
    /** Year of birth of the participant */
    private int jahrgang;
    /** Category of the competition */
    private Kategorie kategorie;
    /** List of scores for each shot */
    private List<Integer> schussListe;

    /**
     * Default constructor.
     */
    public QualifikationAddDTO() {
    }

    /**
     * Constructor with all fields.
     * 
     * @param jahrgang year of birth of the participant
     * @param kategorie category of the competition
     * @param name last name of the participant
     * @param schussListe list of scores for each shot
     * @param verein club of the participant
     * @param vorname first name of the participant
     */
    public QualifikationAddDTO(int jahrgang, Kategorie kategorie, String name, List<Integer> schussListe, Verein verein, String vorname) {
        this.jahrgang = jahrgang;
        this.kategorie = kategorie;
        this.name = name;
        this.schussListe = schussListe;
        this.verein = verein;
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
    public Kategorie getKategorie() {
        return kategorie;
    }

    /**
     * Sets the category of the competition.
     * 
     * @param kategorie the category to set
     */
    public void setKategorie(Kategorie kategorie) {
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
     * Gets the club of the participant.
     * 
     * @return the club
     */
    public Verein getVerein() {
        return verein;
    }

    /**
     * Sets the club of the participant.
     * 
     * @param verein the club to set
     */
    public void setVerein(Verein verein) {
        this.verein = verein;
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
