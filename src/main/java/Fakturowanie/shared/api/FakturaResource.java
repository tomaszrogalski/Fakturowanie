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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface FakturaResource {

	@POST
	@Path("/dodaj")
	public RestAction<Void> create(FakturaDTO fakturaDTO);

	@POST
	@Path("/wczytajWszystkich")
	public RestAction<List<FakturaDTO>> wczytajWszystkieFaktury();

	@POST
	@Path("/wczytajOstatnioDodana")
	public RestAction<FakturaDTO> wczytajOstatnioDodana();
}
