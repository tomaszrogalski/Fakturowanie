package Fakturowanie.server;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Fakturowanie.shared.dto.Jednostka;
import Fakturowanie.shared.dto.PozycjaDTO;
import Fakturowanie.shared.dto.ProduktDTO;

@Entity
@DiscriminatorValue(value = "produkt")
public class Produkt extends Pozycja {

	@Column(name = "cena")
	private String cena;

	@Column(name = "jednostka")
	private String jednostka;

	@Column(name = "vat")
	private String vat;

	public Produkt() {
		super();
	}

	public Produkt(String nazwa, Faktura faktura, String cena, String jednostka, String vat) {
		super(nazwa, faktura);
		this.cena = cena;
		this.jednostka = jednostka;
		this.vat = vat;
	}

	public Produkt(String nazwa, String cena, String jednostka, String vat) {
		super(nazwa);
		this.cena = cena;
		this.jednostka = jednostka;
		this.vat = vat;
	}

	public String getCena() {
		return cena;
	}

	public String getJednostka() {
		return jednostka;
	}

	public String getVat() {
		return vat;
	}

	public PozycjaDTO stworzPozycjaDTO() {
		return new PozycjaDTO(getNazwa(), new ProduktDTO(getCena(), Jednostka.valueOf(getJednostka()), getVat()));
	}
}
