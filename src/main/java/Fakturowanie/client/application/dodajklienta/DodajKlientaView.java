package Fakturowanie.client.application.dodajklienta;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
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
		getUiHandlers().buttonAkcjaDodajKlienta();
		driver.edit(new KlientDTO(null, null, new AdresDTO(null, null, null, null)));
	}

}