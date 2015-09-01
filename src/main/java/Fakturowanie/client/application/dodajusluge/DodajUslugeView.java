package Fakturowanie.client.application.dodajusluge;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.PozycjaDTO;
import Fakturowanie.shared.ProduktDTO;
import Fakturowanie.shared.UslugaDTO;

class DodajUslugeView extends ViewWithUiHandlers<DodajUslugeUiHandlers>
		implements Editor<PozycjaDTO>, DodajUslugePresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajUslugeView> {
	}

	interface Driver extends SimpleBeanEditorDriver<PozycjaDTO, DodajUslugeView> {
	}

	Driver driver = GWT.create(Driver.class);
	@UiField
	@Path("nazwa")
	TextBox textBoxNazwa;

	@UiField
	@Path("uslugaDTO.cenaZaGodzine")
	TextBox textBoxCenaZaGodzine;

	@UiField
	@Path("uslugaDTO.jednostkaPodstawowaVAT")
	TextBox textBoxJednostkaPodstawowaVAT;

	@UiField
	Button buttonDodaj;

	@Inject
	DodajUslugeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		textBoxJednostkaPodstawowaVAT.setEnabled(false);
		driver.edit(new PozycjaDTO(null, new UslugaDTO(null, "23%")));
	}

	public PozycjaDTO OdbierzZawartoscTextBoxow() {

		PozycjaDTO pozycjaDTO = driver.flush();

		return pozycjaDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		
		Window.alert("NIE DZIALAM JESZCZE");
	}

}