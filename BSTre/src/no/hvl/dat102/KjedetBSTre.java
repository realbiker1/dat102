package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	
	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		
		if(p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if(element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTilRek(p.getVenstre(), element));
			} else {
				p.setHoyre(leggTilRek(p.getHoyre(), element));
			}
		return p;
		}
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		
		BinaerTreNode<T> nyNode = new BinaerTreNode<T>(element);
		
		if (rot == null) {
			rot = nyNode;
			antall = 1;
			return;
		} 	
		BinaerTreNode<T> p = rot;
				
		for (int i = 0; i < antall; i++) {
			
			if (element.compareTo(p.getElement()) < 0) {
				
				if (p.getVenstre() == null) {
					p.setVenstre(nyNode);
					antall++;
					return;
				}
				p = p.getVenstre();				
			} else {
				
				if (p.getHoyre() == null) {
					p.setHoyre(nyNode);
					antall++;
					return;
				}
				p = p.getHoyre();				
			}
		}
	}
	
	/******************************************************************
	 * Fjerner et element i det binære søketreet.
	 ******************************************************************/
	public T fjern(T element) {
		fjernRek(rot, element);
		antall--;
		return element;
	}
	
	private BinaerTreNode<T> fjernRek(BinaerTreNode<T> p, T element) {
		
		if (p == null) {
			return p;
		}
		
		if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(fjernRek(p.getVenstre(), element));
			
		} else if (element.compareTo(p.getElement()) > 0){
			p.setHoyre(fjernRek(p.getHoyre(), element));
		//Hvis element er det samme som p er det denne noden som skal slettes.	
		} else if (element.compareTo(p.getElement()) == 0){
			//If setningene her behandler tilfeller der noden som skal slettes har 0, 1 eller 2 barn.
			//Hvis 1 eller 0 barn.
			if (p.getVenstre() == null) {
				return p.getHoyre();
				
			} else if (p.getHoyre() == null) {
				return p.getVenstre();	
			//Hvis 2 barn	
			} else {				
				p.setElement(minsteVerdi(p.getHoyre()));
			}	
			p.setHoyre(fjernRek(p.getHoyre(), p.getElement()));			
		}
		return p;	
	}
	// Hjelpemetode for å finne minste verdi 
	private T minsteVerdi(BinaerTreNode<T> p) {
		
		T minv = p.getElement();
		
		while (p.getVenstre() != null) {
			minv = p.getVenstre().getElement();
			p = p.getVenstre();
		}
		return minv;		
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		return fjern(finnMin());
	}

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {		
		return fjern(finnMaks());
	}

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		return finnMinRek(rot).getElement();		
	}
	
	private BinaerTreNode<T> finnMinRek(BinaerTreNode<T> p) {
		
		if (p.getVenstre() == null) {
			return p;
		}
		return finnMinRek(p.getVenstre());
	}

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		return finnMaksRek(rot).getElement();
	}
	
	private BinaerTreNode<T> finnMaksRek(BinaerTreNode<T> p) {
		
		if (p.getHoyre() == null) {
			return p;
		}
		return finnMaksRek(p.getHoyre());
	}

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode
		if (finnRek(element, rot)) {
			return element;
		}
		return null;
	}

	private boolean finnRek(T element, BinaerTreNode<T> n) {
		
		if (n == null) {
			return false;
		}	
		if (element.compareTo(n.getElement()) == 0) {
			return true;
		}		
		if (finnRek(element, n.getVenstre())) {
			return true;
		}		
		return finnRek(element, n.getHoyre());
	}
	
	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
				
		InordenIterator<T> tre = new InordenIterator<T>(rot);
		
		while (tre.hasNext()) {
			if (tre.getAktuell().getElement().compareTo(element) == 0) {
				return element;				
			}
			tre.next();	
		}
		return null;		
	}

	public void visInorden() {
		visInorden(rot);
	}

	private void visInorden(BinaerTreNode<T> n) {
	
		if (n == null) {		
			return;
		}
		visInorden(n.getVenstre());	
		System.out.print(n.getElement() + " ");
		visInorden(n.getHoyre());	
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);		
	}
	
	@Override
	public int hoyde() {
		return hoydeRek(rot);
	}
	
	private int hoydeRek(BinaerTreNode<T> n) {
		
		if (n == null) {
			return -1;
		}
		
		int hVenstre = hoydeRek(n.getVenstre());
		int hHoyre = hoydeRek(n.getHoyre());
		
		if (hVenstre > hHoyre) {
			return hVenstre + 1;
		} else {
			return hHoyre + 1;
		}
	}
	
	public void skrivVerdier(T nedre, T ovre){
		 skrivVerdierRek(rot, nedre, ovre);
	}
	
	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks){
		System.out.println("good");
		if (t == null) {
			return;
		}
		if (t.getElement().compareTo(min) < 0) {
			skrivVerdierRek(t.getHoyre(), min, maks);
			return;
		}
		if (t.getElement().compareTo(maks) > 0) {
			skrivVerdierRek(t.getVenstre(), min, maks);
			return;
		}
		skrivVerdierRek(t.getHoyre(), min, maks);
		System.out.println(t.getElement() + " ");
		skrivVerdierRek(t.getVenstre(), min, maks);
		
	}
}// class
