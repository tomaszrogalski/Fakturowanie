package Fakturowanie.shared.dto;

public class ProduktDTO {

	private String cena;

	private Jednostka jednostka;

	private String vat;

	/////////////////////////////////

	public ProduktDTO(String cena, Jednostka jednostka, String vat) {

		this.cena = cena;
		this.jednostka = jednostka;
		this.vat = vat;
	}

	public ProduktDTO() {

	}

	/////////////////////////////////

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public Jednostka getJednostka() {
		return jednostka;
	}

	public void setJednostka(Jednostka jednostka) {
		this.jednostka = jednostka;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public boolean czyJestemPusty() {

		if (getJednostka() == null && getVat() == null && getCena() == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cena: " + cena + ", Jednostka: " + jednostka + ", Vat: " + vat;
	}
}
