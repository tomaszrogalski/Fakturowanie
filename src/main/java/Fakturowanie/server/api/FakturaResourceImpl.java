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
import Fakturowanie.shared.dto.KlientDTO;

@Path("/Faktura")
public class FakturaResourceImpl {
	@EJB
	FakturaDAO fakturaDAO;
	
	@POST
	@Path("/dodaj")
	public void create(FakturaDTO fakturaDTO){
		fakturaDAO.stworzFakture(fakturaDTO.stworzFakture());
		System.out.println("IMPL");
	}
	@POST
	@Path("/wczytaj")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<FakturaDTO> wczytaj() {

		return fakturaDAO.wczytaj();

	}
}
