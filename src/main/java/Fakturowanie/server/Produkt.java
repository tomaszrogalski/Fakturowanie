package Fakturowanie.server;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

	

	
	
	

}
