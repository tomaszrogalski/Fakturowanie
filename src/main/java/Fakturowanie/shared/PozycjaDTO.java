package Fakturowanie.shared;

public class PozycjaDTO {

	private Long id;

	private String nazwa;

	private String typ;

	private ProduktDTO produktDTO;

	private UslugaDTO uslugaDTO;

	/////////////////////////////////

	public PozycjaDTO() {
		super();
	}

	public PozycjaDTO(String nazwa, UslugaDTO uslugaDTO) {
		super();
		this.nazwa = nazwa;
		this.uslugaDTO = uslugaDTO;
		produktDTO = new ProduktDTO(null, null, null);
		wyliczTyp();

	}

	public PozycjaDTO(String nazwa, ProduktDTO produktDTO) {
		super();
		this.nazwa = nazwa;
		this.produktDTO = produktDTO;
		uslugaDTO = new UslugaDTO(null, null);
		wyliczTyp();
	}

	/////////////////////////////////

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public ProduktDTO getProduktDTO() {
		return produktDTO;
	}

	public void setProduktDTO(ProduktDTO produktDTO) {
		this.produktDTO = produktDTO;
	}

	public UslugaDTO getUslugaDTO() {
		return uslugaDTO;
	}

	public void setUslugaDTO(UslugaDTO uslugaDTO) {
		this.uslugaDTO = uslugaDTO;
	}

	// zmienic na enum
	public void wyliczTyp() {
		if (uslugaDTO.czyJestemPusty()) {
			setTyp("USŁUGA");
		} else if (produktDTO.czyJestemPusty()) {
			setTyp("PRODUKT");
		}
		// tymczasowe
		else {
			setTyp("COS TU NIE DZIAŁA");
		}
	}

	public String toStringProdukt() {
		return "PozycjaDTO [nazwa=" + nazwa + "," + getProduktDTO().toString() + "]";
	}

	public String toStringUsluga() {
		return "PozycjaDTO [nazwa=" + nazwa + "," + getUslugaDTO().toString() + "]";
	}

	@Override
	public String toString() {
		if (uslugaDTO.czyJestemPusty()) {
			return toStringProdukt();
		} else if (produktDTO.czyJestemPusty()) {
			return toStringUsluga();
		}
		// tymczasowe
		else {
			return "cos nie dziala w metodzie to string";
		}

	}
}
