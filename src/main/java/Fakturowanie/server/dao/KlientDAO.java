package Fakturowanie.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Fakturowanie.server.Klient;
import Fakturowanie.shared.dto.KlientDTO;

@Stateless
@Remote
public class KlientDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzKlienta(Klient klient) {
		entityManager.merge(klient);

	}

	public List<KlientDTO> wczytaj() {

		List<KlientDTO> listaKlientowDTO = new ArrayList<>();
		Query query = entityManager.createQuery("FROM Klient");
		List<Klient> listaKlientow = query.getResultList();

		for (Klient klient : listaKlientow) {
			listaKlientowDTO.add(klient.stworzKlientaDTO());
		}

		return listaKlientowDTO;
	}
}