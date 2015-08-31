package Fakturowanie.shared;

public class UslugaDTO extends PozycjaDTO {

	private String cenaZaGodzine;

	private String jednostkaPodstawowaVAT;

	/////////////////////////////////

	public UslugaDTO(Long id, String nazwa, String cenaZaGodzine, String jednostkaPodstawowaVAT) {
		super(id, nazwa);
		this.cenaZaGodzine = cenaZaGodzine;
		this.jednostkaPodstawowaVAT = jednostkaPodstawowaVAT;
	}

	/////////////////////////////////

	public String getCenaZaGodzine() {
		return cenaZaGodzine;
	}

	public void setCenaZaGodzine(String cenaZaGodzine) {
		this.cenaZaGodzine = cenaZaGodzine;
	}

	public String getJednostkaPodstawowaVAT() {
		return jednostkaPodstawowaVAT;
	}

	public void setJednostkaPodstawowaVAT(String jednostkaPodstawowaVAT) {
		this.jednostkaPodstawowaVAT = jednostkaPodstawowaVAT;
	}

	@Override
	public String toString() {
		return "UslugaDTO [cenaZaGodzine=" + cenaZaGodzine + ", jednostkaPodstawowaVAT=" + jednostkaPodstawowaVAT
				+ ", toString()=" + super.toString() + "]";
	}

}
