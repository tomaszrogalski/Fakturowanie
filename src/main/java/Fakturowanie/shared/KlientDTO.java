package Fakturowanie.shared;

import java.util.List;

public class KlientDTO {

	private Long id;

	private String imie;

	private String nazwisko;

	private AdresDTO adresDTO;

	private List<FakturaDTO> listaFakturDTO;

	/////////////////////////////////

	public KlientDTO(String imie, String nazwisko, AdresDTO adresDTO) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adresDTO = adresDTO;
	}

	public KlientDTO() {
		super();
	}
	/////////////////////////////////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public AdresDTO getAdresDTO() {
		return adresDTO;
	}

	public void setAdresDTO(AdresDTO adresDTO) {
		this.adresDTO = adresDTO;
	}

	public List<FakturaDTO> getListaFakturDTO() {
		return listaFakturDTO;
	}

	public void setListaFakturDTO(List<FakturaDTO> listaFakturDTO) {
		this.listaFakturDTO = listaFakturDTO;
	}

	@Override
	public String toString() {
		return "KlientDTO [imie=" + imie + ", nazwisko=" + nazwisko + getAdresDTO().toString() + "]";
	}
}
