package Fakturowanie.client.application.dodajprodukt;

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

import Fakturowanie.shared.dto.PozycjaDTO;
import Fakturowanie.shared.dto.ProduktDTO;

class DodajProduktView extends ViewWithUiHandlers<DodajProduktUiHandlers>
		implements Editor<PozycjaDTO>, DodajProduktPresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajProduktView> {
	}

	interface Driver extends SimpleBeanEditorDriver<PozycjaDTO, DodajProduktView> {
	}

	Driver driver = GWT.create(Driver.class);
	@UiField
	@Path("nazwa")
	TextBox textBoxNazwa;

	@UiField
	@Path("produktDTO.cena")
	TextBox textBoxCena;

	@UiField
	@Path("produktDTO.jednostka")
	TextBox textBoxJednostka;

	@UiField
	@Path("produktDTO.vat")
	TextBox textBoxVAT;

	@UiField
	Button buttonDodaj;

	@Inject
	DodajProduktView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new PozycjaDTO(null, new ProduktDTO(null, null, null)));
	}

	public PozycjaDTO odbierzZawartoscTextBoxow() {
		PozycjaDTO pozycjaDTO = driver.flush();
		return pozycjaDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		
		
		getUiHandlers().buttonAkcjaDodajProdukt();
		driver.edit(new PozycjaDTO(null, new ProduktDTO(null, null, null)));
	}

}