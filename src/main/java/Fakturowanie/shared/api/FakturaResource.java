package Fakturowanie.shared.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import Fakturowanie.shared.dto.FakturaDTO;

@Path("/Faktura")
public interface FakturaResource {

	@POST
	@Path("/dodaj")
	public RestAction<Void> create(FakturaDTO fakturaDTO);

	@POST
	@Path("/wczytaj")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RestAction<List<FakturaDTO>> wczytaj();

}
