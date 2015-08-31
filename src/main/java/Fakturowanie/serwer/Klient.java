package Fakturowanie.serwer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "klient", schema = "fakturowanie")
public class Klient {

	@Id
	@SequenceGenerator(name = "klient_id_seq", sequenceName = "fakturowanie.klient_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klient_id_seq")
	@Column(name = "klient_id")
	private Long id;

	
	@Column(name = "imie")
	private String imie;

	@Column(name = "nazwisko")
	private String nazwisko;

	@Embedded
	private Adres adres;

	@OneToMany(mappedBy = "klient")
	private List<Faktura> listaFaktur;

	public Long getId() {
		return id;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public Adres getAdres() {
		return adres;
	}

	public List<Faktura> getListaFaktur() {
		return listaFaktur;
	}
}
