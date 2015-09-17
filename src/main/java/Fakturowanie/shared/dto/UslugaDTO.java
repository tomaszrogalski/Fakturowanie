package Fakturowanie.shared.dto;

public class UslugaDTO {

	private String cenaZaGodzine;


	/////////////////////////////////

	public UslugaDTO(String cenaZaGodzine) {

		this.cenaZaGodzine = cenaZaGodzine;
	}

	public UslugaDTO() {
		super();
	}

	/////////////////////////////////

	public String getCenaZaGodzine() {
		return cenaZaGodzine;
	}

	
	public void setCenaZaGodzine(String cenaZaGodzine) {
		this.cenaZaGodzine = cenaZaGodzine;
	}

	@Override
	public String toString() {
		return "CenaZaGodzine: " + cenaZaGodzine+"zł/h";
	}

}
