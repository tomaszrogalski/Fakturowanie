package Fakturowanie.shared.dto;

import Fakturowanie.server.Produkt;
import Fakturowanie.server.Usluga;

public class PozycjaDTO {

	private Long id;

	private String nazwa;

	private TypPozycji typ;

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

	

	public Long getId() {
		return id;
	}

	public TypPozycji getTyp() {
		return typ;
	}

	public void setTyp(TypPozycji typ) {
		this.typ = typ;
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

	public void wyliczTyp() {
		if (uslugaDTO.czyJestemPusty()) {
			setTyp(TypPozycji.PRODUKT);
		} else if (produktDTO.czyJestemPusty()) {
			setTyp(TypPozycji.USLUGA);
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
		} else {
			return toStringUsluga();
		}
	}

	public Produkt stworzProdukt() {
		Produkt produkt = new Produkt(getNazwa(), getProduktDTO().getCena(), getProduktDTO().getJednostka(),
				getProduktDTO().getVat());

		return produkt;
	}

	public Usluga stworzUsluge() {
		Usluga usluga = new Usluga(getNazwa(), getUslugaDTO().getCenaZaGodzine(),
				getUslugaDTO().getJednostkaPodstawowaVAT());

		return usluga;
	}

}


