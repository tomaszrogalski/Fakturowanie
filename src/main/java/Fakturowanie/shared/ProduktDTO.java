package Fakturowanie.shared;

public class ProduktDTO extends PozycjaDTO {

	private String cena;

	private String jednostka;

	private String vat;

	/////////////////////////////////

	public ProduktDTO(Long id, String nazwa, String cena, String jednostka, String vat) {
		super(id, nazwa);
		this.cena = cena;
		this.jednostka = jednostka;
		this.vat = vat;
	}

	/////////////////////////////////

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getJednostka() {
		return jednostka;
	}

	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		return "ProduktDTO [cena=" + cena + ", jednostka=" + jednostka + ", vat=" + vat + ", toString()="
				+ super.toString() + "]";
	}
}
