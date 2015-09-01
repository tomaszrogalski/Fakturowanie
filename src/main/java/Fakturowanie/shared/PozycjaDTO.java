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
		this.produktDTO = null;
		
	}

	public PozycjaDTO(String nazwa, ProduktDTO produktDTO) {
		super();
		this.nazwa = nazwa;
		this.produktDTO = produktDTO;
		this.uslugaDTO = null;
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

	public String toStringProdukt() {
		return "PozycjaDTO [nazwa=" + nazwa + "," + getProduktDTO().toString() + "]";
	}

	public String toStringUsluga() {
		return "PozycjaDTO [nazwa=" + nazwa + "," + getUslugaDTO().toString() + "]";
	}

	@Override
	public String toString() {
		if (uslugaDTO == null) {
			return toStringProdukt();
		} else {
			return toStringUsluga();
		}

	}
}
