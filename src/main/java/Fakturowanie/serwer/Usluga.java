package Fakturowanie.serwer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "usluga")
public class Usluga extends Pozycja {

	@Column(name = "cena_za_godzine")
	private String cenaZaGodzine;

	@Column(name = "jednostka_podstawowa_vat")
	private String jednostkaPodstawowaVAT;

}
