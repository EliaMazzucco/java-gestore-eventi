package org.generation.italy.eventi;

import java.time.LocalDate;

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

	/// metodi private///

	private int verificaPosti() throws IllegalArgumentException {
		if (postiTotali < 1) {
			throw new IllegalArgumentException("Deve essere positivo");
		}
		return postiTotali;
	}

	private boolean verificaData() {
		boolean res = false;
		LocalDate controlloData = LocalDate.now();
		if (controlloData.isBefore(data)) {
			throw new IllegalArgumentException("Non è la data di oggi");
		}
		return res;
	}

	/// metodi public///
	public boolean prenota() {
		boolean res = false;

		if (LocalDate.now().isAfter(data)) {
			throw new IllegalArgumentException("Non è la data di oggi");
		} else if (postiPrenotati > postiTotali) {
			throw new IllegalArgumentException("I posti non sono più disponibili");
		} else {
		}
		postiPrenotati++;
		return res;

	}

	public boolean disdici() {
		boolean res = false;

		if (LocalDate.now().isAfter(data)) {
			throw new IllegalArgumentException("Non è la data di oggi");
		} else if (postiPrenotati > postiTotali) {
			throw new IllegalArgumentException("I posti non sono più disponibili");
		} else {
		}
		postiPrenotati++;
		return res;
	}

	@Override
	public String toString() {
		return data + "-" + titolo;
	}

}