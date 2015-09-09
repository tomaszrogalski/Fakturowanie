package Fakturowanie.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Fakturowanie.server.Pozycja;
import Fakturowanie.server.Produkt;
import Fakturowanie.server.Usluga;
import Fakturowanie.shared.dto.PozycjaDTO;

@Stateless
@Remote
public class PozycjaDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzProdukt(Produkt produkt) {
		entityManager.merge(produkt);

	}

	public void stworzUsluge(Usluga usluga) {
		entityManager.merge(usluga);

	}

	public List<PozycjaDTO> wczytaj() {

		List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();
		Query query = entityManager.createQuery("FROM Pozycja");
		List<Pozycja> listaPozycji = query.getResultList();

		for (Pozycja pozycja : listaPozycji) {
			if (pozycja.getClass() == Produkt.class) {
				listaPozycjiDTO.add(((Produkt) pozycja).stworzPozycjaDTO());
			} else if (pozycja.getClass() == Usluga.class) {
				listaPozycjiDTO.add(((Usluga) pozycja).stworzPozycjaDTO());
			}

		}

		return listaPozycjiDTO;
	}

}
