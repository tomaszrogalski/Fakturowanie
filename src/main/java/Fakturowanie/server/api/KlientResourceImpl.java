package Fakturowanie.server.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import Fakturowanie.server.dao.KlientDAO;
import Fakturowanie.shared.api.KlientResource;
import Fakturowanie.shared.dto.KlientDTO;

@Path("/Klient")
public class KlientResourceImpl implements KlientResource{
	
	@EJB
	KlientDAO klientDAO;

	@POST
	@Path("/dodaj")
	public RestAction<String> create(KlientDTO klientDTO) {
		klientDAO.stworzKlienta(klientDTO.stworzKlienta());
		return null;
	}

}