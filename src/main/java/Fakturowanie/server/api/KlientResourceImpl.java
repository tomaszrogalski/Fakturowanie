package Fakturowanie.server.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Fakturowanie.server.dao.KlientDAO;
import Fakturowanie.shared.dto.KlientDTO;

@Path("/Klient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KlientResourceImpl {

	@EJB
	KlientDAO klientDAO;

	@POST
	@Path("/dodaj")
	public void create(KlientDTO klientDTO) {
		klientDAO.stworzKlienta(klientDTO.stworzKlienta());
	}

	@POST
	@Path("/wczytajWszystkich")
	public List<KlientDTO> wczytajWszystkichKlientow() {

		return klientDAO.wczytajWszystkichKlientow();

	}
	
	@POST
	@Path("/wczytajOstatnioDodanego")
	public KlientDTO wczytajOstatnioDodanego() {

		return klientDAO.wczytajOstatnioDodanego();

	}
}