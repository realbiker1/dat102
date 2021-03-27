package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * Test for StabelADT.
 * 
 * @author Ole Olsen
 */
public abstract class KoeADTTest {

	// Referanse til stabel
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Tom k� for hver test.
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Test p� at en ny k� er tom.
	 */
	@Test
	public void nyStabelErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test p� push and pop.
	 */
	@Test
	public void InnUt() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� � sette elementer inn, fjerne, og se det f�rste elementet i k�en.
	 */
	@Test
	public void InnUtForste() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
	
		try {
			assertEquals(e0, koe.foerste());
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.foerste());
			
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� at en k� med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		assertFalse(koe.erTom());
	}

	/**
	 * Test p� at en k� med null elementer er tom.
	 */
	@Test
	public void pushPopErTom() {
		
		try {
			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.utKoe();
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� st�rrelsen
	 */
	@Test
	public void stor() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.utKoe();
		assertEquals(1, koe.antall());
	}

}
