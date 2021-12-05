package Modele;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.*;

/**
 * Un creneau temporel qui represente une periode avec une heure de debut et une heure de fin
 * a une date specifique.
 * @author Simon
 *
 */
public class Creneau {
	LocalDate date; 	//Date du crenea
	LocalTime debut; 	//Horaire de debut du creneau
	LocalTime fin; 	//Horaire de fin du creneau
	
	/**
	 * Construit un creneau temporel
	 * @param date : date du creneau
	 * @param debut : horaire de debut du creneau
	 * @param fin : horaire de fin du creneau
	 */
	public Creneau(LocalDate date, LocalTime debut, LocalTime fin) {
		super();
		this.date = date;
		this.debut = debut;
		this.fin = fin;
	}
	
	/**
	 * Construit un creneau temporel vide
	 */
	public Creneau() {
		super();
	}
	
	/**
	 * Getter pour la date
	 * @return la date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Setter pour la date
	 * @param date : nouvelle date
	 */
	@JsonDeserialize(using = LocalDateDeserializer.class)
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter pour l'horaire de debut
	 * @return l'horaire de debut
	 */
	public LocalTime getDebut() {
		return debut;
	}

	/**
	 * Setter pour l'horaire de debut
	 * @param debut : le nouvel horaire de debut
	 */
	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}

	/**
	 * Getter pour l'horaire de fin
	 * @return l'horaire de fin
	 */
	public LocalTime getFin() {
		return fin;
	}

	/**
	 * Setter pour l'horaire de fin
	 * @param fin : le nouvel horaire de fin
	 */
	public void setFin(LocalTime fin) {
		this.fin = fin;
	}
	
	public String toString() {
		return this.date.toString() +  " -- " + this.debut.toString() + " - " + this.fin.toString();
	}
	

}
