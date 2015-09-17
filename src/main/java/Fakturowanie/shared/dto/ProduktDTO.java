package Fakturowanie.shared.dto;

public class ProduktDTO {

	private String cena;

	private Jednostka jednostka;

	/////////////////////////////////

	public ProduktDTO(String cena, Jednostka jednostka) {

		this.cena = cena;
		this.jednostka = jednostka;
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

	@Override
	public String toString() {
		return "Cena: " + cena + "zł, Jednostka: " + jednostka.getSkrotJednostki();
	}
}
