package no.hvl.dat102.adt;

import java.util.*;

import no.hvl.dat102.BinaerTreNode;

public interface BSTreADT<T extends Comparable<T>> {
	// Burde hatt javadoc her
	// Anbefaler at du fyller ut med javadoc her som kan vaere en del av 
	// �vingen. Flere metoder m� fylles ut i implementasjonsfilen.
	//Legg merke til at i denne imlementasjonen er det ikke brukt exceptions som
	// vi kunne hatt og som vi har brukt for i flere av de andre samlingene.

	/**
	 * Returnerer antall noder i det bin�re treet.
	 * @return
	 */
	public int antall();
	
	/**
	 * returnerer sann hvis det bin�re treet er tom og usann ellers.
	 * @return
	 */
	public boolean erTom();

	/**
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 * @param element
	 */
	public void leggTil(T element);

	 /**
	  * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	  * bin�re treet ellers returneres null.
	  * @param element
	  * @return
	  */
	public T finn(T element);
	
	/**
	 * Returnerer en referanse til minste elementet, null viss tre er tomt.
	 * @return
	 */
	public T finnMin();
	
	/**
	 * Returnerer en referanse til st�rste elementet, null viss tre er tomt.
	 * @return
	 */
	public T finnMaks();

	/**
	 * Fjerner et element fra dette treet hvis det fins, ellers returneres null.
	 * @param element
	 * @return
	 */
	public T fjern(T element);

	
	/**
	 * Fjerner minste elementet fra dette treet hvis det fins, ellers returneres null.
	 * @return
	 */
	public T fjernMin();
	
	/**
	 * Fjerner st�rste elementet fra dette treet hvis det fins, ellers returneres null.
	 * @return
	 */
	public T fjernMaks();
	
	/**
	 * Returnerer h�yden av et tre.
	 * @param binaerTreNode
	 * @return
	 */
	int hoyde();
}
