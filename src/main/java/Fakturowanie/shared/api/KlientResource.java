package Fakturowanie.shared.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import Fakturowanie.shared.dto.KlientDTO;

@Path("/Klient")
public interface KlientResource {

	@POST
	@Path("/dodaj")
	public RestAction<String> create(KlientDTO klientDTO);

}
