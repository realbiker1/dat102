package no.hvl.dat102;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KjedetBSTreADTTest {

	private KjedetBSTre<Integer> bs;
	InordenIterator<Integer> tre;
	BinaerTreNode<Integer> rot;
	
	// Testdata som legges inn i treet
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

	// Data som ikke legges inn i treet
	private Integer e7 = 8;

	/**
	 * Opprett en tomt tre for hver test.
	 * 
	 * @throws Exception exception
	 */
	@BeforeEach
	public final void setup() throws Exception {
		bs = new KjedetBSTre<Integer>();
	}

	/**
	 * Tester finn
	 * 
	 */
	@Test
	public final void erElementIBSTre() {
		
		bs.leggTil(e0);
		bs.leggTil(e5);
		bs.leggTil(e2);
		bs.leggTil(e4);
		bs.leggTil(e6);
		bs.leggTil(e1);
		bs.leggTil(e3);
		
		assertEquals(bs.finn(e2), 3);
		assertEquals(bs.finn2(e6), 7);
		assertEquals(bs.finn(e7), null);
	}

	/**
	 * 1. Tester ordning ved å legge til elementer og fjerne minste
	 * 
	 */
	@Test
	public final void erBSTreOrdnet() {
		bs.leggTil(e6);
		bs.leggTil(e5);
		bs.leggTil(e2);
		bs.leggTil(e4);
		bs.leggTil(e0);
		bs.leggTil(e1);
		bs.leggTil(e3);
		
		assertFalse(bs.erTom());
		
		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		for (int i = 0; i < el.length-1; i++) {
			
			assertEquals(bs.finn(el[i]), i+1);
			bs.fjernMin();
			assertEquals(bs.finn(el[i]), null);
		}	

	}

	/**
	 * 2 Tester ordning ved å bruke en inordeniterator Her studerer du alt om bruk
	 * av inordeniterator.
	 */
	@Test
	public final void erBSTreOrdnet2() {
		
	
		

	}

}// class
