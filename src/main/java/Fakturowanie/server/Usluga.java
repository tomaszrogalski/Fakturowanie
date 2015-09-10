package Fakturowanie.server;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Fakturowanie.shared.dto.PozycjaDTO;
import Fakturowanie.shared.dto.UslugaDTO;

@Entity
@DiscriminatorValue(value = "usluga")
public class Usluga extends Pozycja {

	@Column(name = "cena_za_godzine")
	private String cenaZaGodzine;

	@Column(name = "jednostka_podstawowa_vat")
	private String jednostkaPodstawowaVAT;

	public Usluga(String nazwa, String cenaZaGodzine, String jednostkaPodstawowaVAT) {
		super(nazwa);
		this.cenaZaGodzine = cenaZaGodzine;
		this.jednostkaPodstawowaVAT = jednostkaPodstawowaVAT;
	}
	
	

	public Usluga(String nazwa, Faktura faktura, String cenaZaGodzine, String jednostkaPodstawowaVAT) {
		super(nazwa, faktura);
		this.cenaZaGodzine = cenaZaGodzine;
		this.jednostkaPodstawowaVAT = jednostkaPodstawowaVAT;
	}



	public Usluga() {
		super();
	}

	public String getCenaZaGodzine() {
		return cenaZaGodzine;
	}

	public String getJednostkaPodstawowaVAT() {
		return jednostkaPodstawowaVAT;
	}

	public PozycjaDTO stworzPozycjaDTO() {

		return new PozycjaDTO(getNazwa(), new UslugaDTO(getCenaZaGodzine(), getJednostkaPodstawowaVAT()));

	}

	
}
