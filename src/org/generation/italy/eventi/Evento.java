package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	/// proptrietà///

	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;

	/// costruttore///

	public Evento(String titolo, LocalDate data, int postiTotali) {

		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	/// sgetter///

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	/// metodi ///

	public boolean verificaData() throws IllegalArgumentException {

		boolean res = false;
		LocalDate controlloData = LocalDate.now();
		if (controlloData.isAfter(data)) {
			throw new IllegalArgumentException("Inserisci una data corretta");
		}
		return res;
	}

	public boolean verificaPosti() throws IllegalArgumentException {
		boolean res = false;
		if (postiTotali < postiPrenotati) {
			throw new IllegalArgumentException("Deve essere più di zero");
		}
		return res;
	}

	public boolean prenota() throws IllegalArgumentException {
		boolean res = false;

		if (LocalDate.now().isAfter(data)) {
			throw new IllegalArgumentException("Inserisci una data corretta");
		} else if (postiPrenotati > postiTotali) {
			throw new IllegalArgumentException("I posti non sono più disponibili");
		} else {
		}
		postiPrenotati++;
		return res;

	}

	public boolean disdici() throws IllegalArgumentException {
		boolean res = false;

		if (LocalDate.now().isAfter(data)) {
			throw new IllegalArgumentException("Inserisci una data corretta");
		} else if (postiPrenotati > postiTotali) {
			throw new IllegalArgumentException("I posti non sono più disponibili");
		} else {
		}
		postiPrenotati--;
		return res;
	}

	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(df);
		return dataFormattata + " - " + this.titolo;
	}

}
