package org.generation.italy.eventi;
import java.time.LocalDate;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Che evento vuoi partecipare: ");
		String titolo = scan.nextLine();
		
		System.out.println("Inserisci la data yyyy-MM-gg");
		String data = scan.nextLine(); 		
		LocalDate dateTime = LocalDate.parse(data);
		
		int postiDisponibli = 100;
		
		Evento evento = new Evento(titolo, dateTime, postiDisponibli);
		
		System.out.println(evento.toString());
		
		System.out.println("Vuoi prenotare?(s/n)");
		String confermaPrenotazione = scan.nextLine();
		
		if(confermaPrenotazione.equalsIgnoreCase("s")) {
			
			System.out.println("Vuoi aggiungere una prenotazione? (s/n)");
			String aggiungiPrenotazione = scan.nextLine();	
			postiDisponibli--;
			evento.prenota();			
		}
		
		if(confermaPrenotazione.equalsIgnoreCase("n")) {
			
		}
		
		
		
		
		
		
		
		
		scan.close();
	}

}
