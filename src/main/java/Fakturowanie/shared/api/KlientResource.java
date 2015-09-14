package Fakturowanie.shared.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import Fakturowanie.shared.dto.KlientDTO;

@Path("/Klient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface KlientResource {

	@POST
	@Path("/dodaj")
	public RestAction<Void> create(KlientDTO klientDTO);

	@POST
	@Path("/wczytaj")
	public RestAction<List<KlientDTO>> wczytaj();
}
