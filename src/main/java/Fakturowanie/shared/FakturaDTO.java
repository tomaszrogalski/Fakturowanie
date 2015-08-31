package Fakturowanie.shared;

import java.util.List;

public class FakturaDTO {

	private Long nrFaktury;

	private KlientDTO klientDTO;

	private List<PozycjaDTO> listaPozycjiDTO;

	/////////////////////////////////

	public FakturaDTO(Long nrFaktury, KlientDTO klientDTO, List<PozycjaDTO> listaPozycjiDTO) {
		super();
		this.nrFaktury = nrFaktury;
		this.klientDTO = klientDTO;
		this.listaPozycjiDTO = listaPozycjiDTO;
	}

	/////////////////////////////////

	public Long getNrFaktury() {
		return nrFaktury;
	}

	public void setNrFaktury(Long nrFaktury) {
		this.nrFaktury = nrFaktury;
	}

	public KlientDTO getKlientDTO() {
		return klientDTO;
	}

	public void setKlientDTO(KlientDTO klientDTO) {
		this.klientDTO = klientDTO;
	}

	public List<PozycjaDTO> getListaPozycjiDTO() {
		return listaPozycjiDTO;
	}

	public void setListaPozycjiDTO(List<PozycjaDTO> listaPozycjiDTO) {
		this.listaPozycjiDTO = listaPozycjiDTO;
	}

	@Override
	public String toString() {
		return "FakturaDTO [nrFaktury=" + nrFaktury + ", klientDTO=" + klientDTO + ", listaPozycji=" + listaPozycjiDTO
				+ "]";
	}

}
