package Fakturowanie.server;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import Fakturowanie.shared.dto.AdresDTO;

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

	public Adres(String ulica, String nrDomu, String kodPocztowy, String miejscowosc) {
		super();
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.kodPocztowy = kodPocztowy;
		this.miejscowosc = miejscowosc;
	}

	public Adres() {
		super();
	}

	@Override
	public String toString() {
		return "Adres [ulica=" + ulica + ", nrDomu=" + nrDomu + ", kodPocztowy=" + kodPocztowy + ", miejscowosc="
				+ miejscowosc + "]";
	}

	public AdresDTO stworzAdresDTO() {
		return new AdresDTO(getKodPocztowy(), getUlica(), getNrDomu(), getMiejscowosc());

	}

}
