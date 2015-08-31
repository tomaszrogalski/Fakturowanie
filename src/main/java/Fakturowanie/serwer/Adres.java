package Fakturowanie.serwer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adres {

	@Column(name = "ulica")
	private String ulica;

	@Column(name = "nr_domu")
	private String nrDomu;

	@Column(name = "kod_pocztowy")
	private String kodPocztowy;

	@Column(name = "miejscowosc")
	private String miejscowosc;

	public String getUlica() {
		return ulica;
	}

	public String getNrDomu() {
		return nrDomu;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

}
