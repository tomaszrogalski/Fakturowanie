package Fakturowanie.shared.dto;

import Fakturowanie.server.Produkt;
import Fakturowanie.server.Usluga;

public class PozycjaDTO {

	private Long id;

	private String nazwa;

	private String vat;

	private TypPozycji typ;

	private ProduktDTO produktDTO;

	private UslugaDTO uslugaDTO;

	/////////////////////////////////

	public PozycjaDTO() {
		super();
	}

	public PozycjaDTO(String nazwa, String vat, UslugaDTO uslugaDTO) {
		super();
		this.nazwa = nazwa;
		this.vat = vat;
		this.uslugaDTO = uslugaDTO;
		this.produktDTO = new ProduktDTO("-", Jednostka.BRAK);
		this.typ = TypPozycji.USLUGA;
	}

	public PozycjaDTO(String nazwa, String vat, ProduktDTO produktDTO) {
		super();
		this.nazwa = nazwa;
		this.vat = vat;
		this.produktDTO = produktDTO;
		this.uslugaDTO = new UslugaDTO("-");
		this.typ = TypPozycji.PRODUKT;
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

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
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

	public String toStringProdukt() {
		return "Typ: " + typ + ", " + "Nazwa: " + nazwa + ", " + "VAT: " + vat + "%, " + getProduktDTO().toString();
	}

	public String toStringUsluga() {
		return "Typ: " + typ + ", " + "Nazwa: " + nazwa + ", " + "VAT: " + vat + "%, " + getUslugaDTO().toString();
	}

	@Override
	public String toString() {
		if (typ == TypPozycji.PRODUKT) {
			return toStringProdukt();
		} else if (typ == TypPozycji.USLUGA) {
			return toStringUsluga();
		} else {
			return "BLEDY, WSZEDZIE BLEDY";
		}
	}

	public Produkt stworzProdukt() {
		Produkt produkt = new Produkt(getNazwa(), getVat(), getProduktDTO().getCena(),
				getProduktDTO().getJednostka().toString());
		return produkt;
	}

	public Usluga stworzUsluge() {
		Usluga usluga = new Usluga(getNazwa(), getVat(), getUslugaDTO().getCenaZaGodzine());
		return usluga;
	}
}
