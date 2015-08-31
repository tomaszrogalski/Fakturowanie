package Fakturowanie.shared;

public class PozycjaDTO {

	private Long id;

	private String nazwa;

	/////////////////////////////////

	public PozycjaDTO(Long id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
	}

	/////////////////////////////////

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

	@Override
	public String toString() {
		return "PozycjaDTO [id=" + id + ", nazwa=" + nazwa + "]";
	}
}
