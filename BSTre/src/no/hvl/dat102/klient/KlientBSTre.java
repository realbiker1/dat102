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
				tre.leggTil(random.nextInt());
				totNoder++;
			}			
			//If-setninger som tester om det nye genererte treet har størst/minst høyde.
			if (minTre == null || tre.hoyde() < minTre.hoyde()) {
				minTre = tre;	
				minTreNr = i + 1;				
			}			
			if (maxTre == null || tre.hoyde() > maxTre.hoyde()) {
				maxTre = tre;	
				maxTreNr = i + 1;				
			}
			//Øker totale høyde med det nye treets høyde til bruk for å finne gjennomsnitt senere.
			totHoyde += tre.hoyde();
		}
		int log2n = (int)(Math.log(antNoder)/Math.log(2));
		
		System.out.println("\nTotalt antall noder: " + totNoder + 
						   "\nMinimale teoretiske høyde: " + log2n +
						   "\nMaksimale teoretiske høyde: " + (antNoder - 1) +
						   "\nHøyde på minste tre: " + minTre.hoyde() + " (nr " + minTreNr + ")" + 
						   "\nHøyde på største tre: " + maxTre.hoyde() + " (nr " + maxTreNr + ")" +
						   "\nGjennomsnittlig hoyde: " + Math.round((float)totHoyde/antTre*100)/100.0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Scanner scan = new Scanner(System.in);
//		int antTre = 1000;
//		int antNoder = 8192;
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
		bstre.leggTil(1);
		bstre.leggTil(2);
		bstre.leggTil(3);
		bstre.leggTil(4);
		bstre.leggTil(5);
		bstre.leggTil(6);
		bstre.leggTil(7);
		bstre.leggTil(8);

		// Tester på sortert utskrift
		System.out.println("Skriver ut elementene sortert i bs-treet");
		bstre.skrivVerdier(2,7);


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
