package Fakturowanie.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Fakturowanie.server.Faktura;
import Fakturowanie.server.Klient;
import Fakturowanie.server.Pozycja;
import Fakturowanie.server.Produkt;
import Fakturowanie.server.Usluga;
import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;

@Stateless
@Remote
public class FakturaDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzFakture(Faktura faktura) {
		entityManager.merge(faktura);
		System.out.println("DAO");
	}

	public List<FakturaDTO> wczytaj() {
		List<FakturaDTO> listaFakturDTO = new ArrayList<>();
		Query query = entityManager.createQuery("FROM Faktura");
		List<Faktura> listaFaktur = query.getResultList();

		for (Faktura faktura : listaFaktur) {
			List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();

			for (Pozycja pozycja : faktura.getPozycja()) {

				if (pozycja.getClass() == Produkt.class) {
					listaPozycjiDTO.add(((Produkt) pozycja).stworzPozycjaDTO());
				} else if (pozycja.getClass() == Usluga.class) {
					listaPozycjiDTO.add(((Usluga) pozycja).stworzPozycjaDTO());
				}

			}
			listaFakturDTO.add(faktura.stworzFaktureDTO(listaPozycjiDTO));

		}
		return listaFakturDTO;
	}

}