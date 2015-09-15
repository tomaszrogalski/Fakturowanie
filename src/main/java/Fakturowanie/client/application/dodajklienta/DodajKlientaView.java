package Fakturowanie.client.application.dodajklienta;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.AdresDTO;
import Fakturowanie.shared.dto.KlientDTO;

class DodajKlientaView extends ViewWithUiHandlers<DodajKlientaUiHandlers>
		implements Editor<KlientDTO>, DodajKlientaPresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajKlientaView> {
	}

	interface Driver extends SimpleBeanEditorDriver<KlientDTO, DodajKlientaView> {
	}

	Driver driver = GWT.create(Driver.class);
	// Zrodlo: https://searchcode.com/codesearch/view/7688836/
	// http://www.gwtproject.org/doc/latest/DevGuideValidation.html
	private ValidatorFactory factory = Validation.byDefaultProvider().configure().buildValidatorFactory();
	Validator validator = this.factory.getValidator();

	@UiField
	@Path("imie")
	TextBox textBoxImie;

	@UiField
	@Path("nazwisko")
	TextBox textBoxNazwisko;

	@UiField
	@Path("adresDTO.ulica")
	TextBox textBoxUlica;

	@UiField
	@Path("adresDTO.nrDomu")
	TextBox textBoxNrDomu;

	@UiField
	@Path("adresDTO.miejscowosc")
	TextBox textBoxMiejscowosc;

	@UiField
	@Path("adresDTO.kodPocztowy")
	TextBox textBoxKodPocztowy;

	@UiField
	@Ignore
	Label errorLabel;

	@UiField
	Button buttonDodaj;

	@Inject
	DodajKlientaView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new KlientDTO(null, null, new AdresDTO(null, null, null, null)));
	}

	public KlientDTO odbierzZawartoscTextBoxow() {
		KlientDTO klientDTO = driver.flush();
		return klientDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		if (waliduj()) {
			getUiHandlers().buttonAkcjaDodajKlienta();
			driver.edit(new KlientDTO(null, null, new AdresDTO(null, null, null, null)));
		}
	}

	private boolean waliduj() {
		KlientDTO klientDTO = driver.flush();
		Set<ConstraintViolation<KlientDTO>> violations = validator.validate(klientDTO);
		Set<ConstraintViolation<AdresDTO>> violations2 = validator.validate(klientDTO.getAdresDTO());
		StringBuilder builder = new StringBuilder();
		for (ConstraintViolation<KlientDTO> violation : violations) {
			builder.append(violation.getMessage() + "\n");
		}
		for (ConstraintViolation<AdresDTO> violation : violations2) {
			builder.append(violation.getMessage() + "\n");
		}
		errorLabel.setText(builder.toString());

		if (violations.isEmpty() && violations2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}