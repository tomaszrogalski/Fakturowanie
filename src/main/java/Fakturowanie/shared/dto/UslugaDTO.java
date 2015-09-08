package Fakturowanie.shared.dto;

public class UslugaDTO {

	private String cenaZaGodzine;

	private String jednostkaPodstawowaVAT;

	/////////////////////////////////

	public UslugaDTO(String cenaZaGodzine, String jednostkaPodstawowaVAT) {

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

	public boolean czyJestemPusty() {

		if (getJednostkaPodstawowaVAT() == null && getCenaZaGodzine() == null) {
			return true;
		} else {
			return false;

		}

	}

	@Override
	public String toString() {
		return "UslugaDTO [cenaZaGodzine=" + cenaZaGodzine + ", jednostkaPodstawowaVAT=" + jednostkaPodstawowaVAT + "]";
	}

}
