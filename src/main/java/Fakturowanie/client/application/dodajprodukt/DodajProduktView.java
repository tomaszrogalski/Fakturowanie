package Fakturowanie.client.application.dodajprodukt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.Jednostka;
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

	@UiField(provided = true)
	@Path("produktDTO.jednostka")
	ValueListBox<Jednostka> valueListBoxJednostka = new ValueListBox<Jednostka>(new Renderer<Jednostka>() {

		@Override
		public String render(Jednostka object) {
			return object == null ? "" : object.toString();
		}

		@Override
		public void render(Jednostka object, Appendable appendable) throws IOException {
		}

	});

	@UiField
	@Path("vat")
	TextBox textBoxVAT;

	@UiField
	Button buttonDodaj;

	@Inject
	DodajProduktView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new PozycjaDTO(null, null, new ProduktDTO(null, null)));
		valueListBoxJednostka.setValue(Jednostka.KILOGRAM);

		List<Jednostka> listaJednostek = new ArrayList<Jednostka>();
		listaJednostek.addAll(java.util.Arrays.asList(Jednostka.values()));
		listaJednostek.remove(Jednostka.BRAK);

		valueListBoxJednostka.setAcceptableValues(listaJednostek);
	}

	public PozycjaDTO odbierzZawartoscTextBoxow() {
		PozycjaDTO pozycjaDTO = driver.flush();
		return pozycjaDTO;
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {

		getUiHandlers().buttonAkcjaDodajProdukt();
		driver.edit(new PozycjaDTO(null, null, new ProduktDTO(null, null)));
	}

}