package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Che evento vuoi partecipare: ");
		String titolo = scan.nextLine();

		try {

			System.out.print("Inserisci il giorno dell'evento: ");
			int giorno = Integer.parseInt(scan.nextLine());
			System.out.print("Inserisci il mese: ");
			int mese = Integer.parseInt(scan.nextLine());

			System.out.print("Inserisci l'anno: ");
			int anno = Integer.parseInt(scan.nextLine());

			LocalDate dataEvento = LocalDate.of(anno, mese, giorno);

			int postiDisponibli = 100;

			Evento evento = new Evento(titolo, dataEvento, postiDisponibli);
			evento.verificaData();
			;
			System.out.print("Vuoi prenotare? (s/n)");
			String rispUtente = scan.nextLine();
			boolean risp = false;

			if (rispUtente.equals("s")) {
				risp = true;
				String rispPrenotazione = "";
				String rispDisdici = "";

				do {
					System.out.println("Vuoi aggiungere una prenotazione?(s/n)");
					rispPrenotazione = scan.nextLine();
					evento.prenota();
					postiDisponibli --;
				} while (rispPrenotazione.equals("s"));

				do {
					System.out.println("Vuoi disdire una prenotazione?(s/n)");
					rispDisdici = scan.nextLine();
					evento.disdici();
					postiDisponibli ++;
				} while (rispDisdici.equals("s"));

				System.out.println("I posti prenotati sono: " + evento.getPostiPrenotati()
						+ ", i posti disponibili sono: " + postiDisponibli);

			}evento.verificaPosti();
			if (rispUtente.equals("n")) {
				risp = false;
				System.out.println("Grazie e arrivederci");

			}

		} catch (IllegalArgumentException Iae) {
			System.out.println(Iae);
		}

		boolean res = false;

		scan.close();

	}

}