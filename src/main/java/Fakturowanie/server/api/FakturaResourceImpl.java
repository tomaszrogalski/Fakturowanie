package Fakturowanie.server.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Fakturowanie.server.dao.FakturaDAO;
import Fakturowanie.shared.dto.FakturaDTO;

@Path("/Faktura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FakturaResourceImpl {
	@EJB
	FakturaDAO fakturaDAO;
	
	@POST
	@Path("/dodaj")
	public void create(FakturaDTO fakturaDTO){
		fakturaDAO.stworzFakture(fakturaDTO.stworzFakture());
	}
	
	@POST
	@Path("/wczytajWszystkich")
	public List<FakturaDTO> wczytajWszystkieFaktury() {
		return fakturaDAO.wczytajWszystkieFaktury();

	}
	
	@POST
	@Path("/wczytajOstatnioDodana")
	public FakturaDTO wczytajOstatnioDodana() {

		return fakturaDAO.wczytajOstatnioDodana();

	}
}
