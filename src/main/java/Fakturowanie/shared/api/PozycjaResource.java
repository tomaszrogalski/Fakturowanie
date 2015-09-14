package Fakturowanie.shared.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import Fakturowanie.shared.dto.PozycjaDTO;

@Path("/Pozycja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PozycjaResource {

	@POST
	@Path("/dodajProdukt")
	public RestAction<Void> createProdukt(PozycjaDTO pozycjaDTO);

	@POST
	@Path("/dodajUsluge")
	public RestAction<Void> createUsluge(PozycjaDTO pozycjaDTO);

	@POST
	@Path("/wczytaj")
	public RestAction<List<PozycjaDTO>> wczytaj();

}
