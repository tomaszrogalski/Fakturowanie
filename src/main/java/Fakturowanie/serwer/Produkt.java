package Fakturowanie.serwer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "produkt")
public class Produkt extends Pozycja {

	@Column(name = "cena")
	private String cena;

	@Column(name = "jednostka")
	private String jednostka;

	@Column(name = "vat")
	private String vat;

}
