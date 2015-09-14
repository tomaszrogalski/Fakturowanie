package Fakturowanie.server.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Fakturowanie.server.dao.PozycjaDAO;
import Fakturowanie.shared.dto.PozycjaDTO;

@Path("/Pozycja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PozycjaResourceImpl {

	@EJB
	PozycjaDAO pozycjaDAO;

	@POST
	@Path("/dodajProdukt")
	public void createProdukt(PozycjaDTO pozycjaDTO) {
		pozycjaDAO.stworzProdukt(pozycjaDTO.stworzProdukt());
	}

	@POST
	@Path("/dodajUsluge")
	public void createUsluge(PozycjaDTO pozycjaDTO) {
		pozycjaDAO.stworzUsluge(pozycjaDTO.stworzUsluge());
	}

	@POST
	@Path("/wczytaj")
	public List<PozycjaDTO> wczytaj() {
		return pozycjaDAO.wczytaj();

	}
}
