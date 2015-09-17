package Fakturowanie.client.walidacja;

import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import Fakturowanie.shared.dto.AdresDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;
import Fakturowanie.shared.dto.ProduktDTO;
import Fakturowanie.shared.dto.UslugaDTO;

public final class SampleValidatorFactory extends AbstractGwtValidatorFactory {

	@GwtValidation(value = { KlientDTO.class, AdresDTO.class,PozycjaDTO.class,UslugaDTO.class,ProduktDTO.class })
	public interface GwtValidator extends Validator {
		
	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}

}