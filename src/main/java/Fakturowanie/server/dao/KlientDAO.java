package Fakturowanie.server.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Fakturowanie.server.Klient;

@Stateless
@Remote
public class KlientDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzKlienta(Klient klient) {
		entityManager.merge(klient);
		wczytaj();
	}

	// List<Klient>
	public void wczytaj() {

		List<Klient> listaKlientow = new ArrayList<>();

		Query query = entityManager.createQuery("FROM Klient ");
		List<Klient> listaZTablicaObiektow = query.getResultList();

		for (Klient klient : listaZTablicaObiektow) {
			System.out.println(klient.toString());
			System.out.println();
		}

		// return listaKlientow;
	}

}
