package no.hvl.dat102.klient;

import java.util.Random;
import java.util.Scanner;

import no.hvl.dat102.KjedetBSTre;

public class KlientBSTre {
	
	private static void genererBTrer(int antTre, int antNoder) {
		
		Random random = new Random();
		KjedetBSTre<Integer> minTre = null;
		KjedetBSTre<Integer> maxTre = null;
		int minTreNr = 0;
		int maxTreNr = 0;
		int totNoder = 0;
		int totHoyde = 0;
		
		//Nøstet-forløkke som legger inn nodene på plass i hvert tre.
		for (int i = 0; i < antTre; i++) {
			
			KjedetBSTre<Integer> tre = new KjedetBSTre<Integer>();
						
			for (int j = 0; j < antNoder; j++) {
				tre.leggTil(random.nextInt(100));
				totNoder++;
			}			
			//If-setninger som tester om det nye genererte treet har størst/minst høyde.
			if (minTre == null || tre.hoyde(tre.getRot()) < minTre.hoyde(minTre.getRot())) {
				minTre = tre;	
				minTreNr = i + 1;				
			}			
			if (maxTre == null || tre.hoyde(tre.getRot()) > maxTre.hoyde(maxTre.getRot())) {
				maxTre = tre;	
				maxTreNr = i + 1;				
			}
			//Øker totale høyde med det nye treets høyde til bruk for å finne gjennomsnitt senere.
			totHoyde += tre.hoyde(tre.getRot());
		}				
		System.out.println("\nTotalt antall noder: " + totNoder + 
						   "\nMinimale teoretiske høyde: " + minimalHoyde(antNoder) +
						   "\nMaksimale teoretiske høyde: " + (antNoder - 1) +
						   "\nHøyde på minste tre: " + minTre.hoyde(minTre.getRot()) + " (nr " + minTreNr + ")" + 
						   "\nHøyde på største tre: " + maxTre.hoyde(maxTre.getRot()) + " (nr " + maxTreNr + ")" +
						   "\nGjennomsnittlig hoyde: " + Math.round((float)totHoyde/antTre*100)/100.0);
	}
	
	private static int minimalHoyde(int noder) {
		return (int)(Math.log(noder)/Math.log(2));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Scanner scan = new Scanner(System.in);
//		int antTre = 0;
//		int antNoder = 0;
//		
//		System.out.println("Oppgi antall binære trær som skal genereres");
//		
//		while (antTre <= 0) {
//			antTre = scan.nextInt();
//		}
//		System.out.println("Oppgi antall noder trærne skal ha:");
//		while (antNoder <= 0) {
//			antNoder = scan.nextInt();
//		}
//		scan.close();
//
//		System.out.println("Genererer " + antTre + " binære trær med " + antNoder + " noder ...");
//		genererBTrer(antTre, antNoder);
		
		KjedetBSTre<Integer> bstre = new KjedetBSTre<Integer>();		
		bstre.leggTil(7);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(4);
		bstre.leggTil(9);
		bstre.leggTil(10);
		bstre.leggTil(8);
		bstre.leggTil(3);
		


		// Tester på sortert utskrift
		System.out.println("Skriver ut elementene sortert i bs-treet");
		bstre.visInorden();
		System.out.println("\n"+bstre.finnMaks());
		System.out.println("\n"+bstre.finn2(11));
		bstre.visInorden();

		// Tester på om et bestemt element fins
		int element = 8;
		System.out.println("\nTester om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}

		element = 1;
		System.out.println("\nTester om elementet " + element + " fins");

		if (bstre.finn(element) != null) {
			System.out.println("Elementet " + element + " fins i bs-treet");
		} else {
			System.out.println("Elementet " + element + " fins ikke i bs-treet");
		}
	}

}
