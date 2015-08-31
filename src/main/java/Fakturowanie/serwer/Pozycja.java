package Fakturowanie.serwer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ_poyzcji")
@Table(name = "pozycja", schema = "fakturowanie")
public class Pozycja {

	@Id
	@SequenceGenerator(name = "pozycja_id_seq", sequenceName = "fakturowanie.pozycja_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pozycja_id_seq")
	@Column(name = "pozycja_id")
	private long id;

	@Column(name = "nazwa")
	private String nazwa;

	@ManyToOne
	@JoinColumn(name = "nr_faktury")
	private Faktura faktura;

}
