package Fakturowanie.serwer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "faktura", schema = "fakturowanie")
public class Faktura {

	@Id
	@SequenceGenerator(name = "nr_faktury_seq", sequenceName = "fakturowanie.nr_faktury_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nr_faktury_seq")
	@Column(name = "nr_faktury")
	private Long nrFaktury;

	@OneToMany(mappedBy = "faktura")
	private List<Pozycja> pozycja;

	@ManyToOne
	@JoinColumn(name = "klient_id")
	private Klient klient;

}
