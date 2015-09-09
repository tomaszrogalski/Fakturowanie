package Fakturowanie.client.application.wyswietlpozycje;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.PozycjaDTO;

class WyswietlPozycjeView extends ViewWithUiHandlers<WyswietlPozycjeUiHandlers>
		implements WyswietlPozycjePresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlPozycjeView> {
	}

	@UiField
	DataGrid<PozycjaDTO> dataGridWyswietlPozycje;

	@UiField
	Button buttonDodajNowyProdukt;
	@UiField
	Button buttonDodajNowaUsluge;

	@UiField
	HTMLPanel htmlPanelNaDodajProduktLubUsluge;

	@Inject
	WyswietlPozycjeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		bindSlot(WyswietlPozycjePresenter.SLOT_NA_DODAJ_PRODUKT_USLUGE, htmlPanelNaDodajProduktLubUsluge);
		TextColumn<PozycjaDTO> textColumnTyp = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getTyp();
			}
			// enum?

		};

		TextColumn<PozycjaDTO> textColumnNazwa = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {

				return pozycjaDTO.getNazwa();
			}
		};
		TextColumn<PozycjaDTO> textColumnCena = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {

				return pozycjaDTO.getProduktDTO().getCena();
			}
		};
		TextColumn<PozycjaDTO> textColumnCenaZaGodzine = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getUslugaDTO().getCenaZaGodzine();
			}
		};
		TextColumn<PozycjaDTO> textColumnJednostka = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getProduktDTO().getJednostka();
			}
		};

		TextColumn<PozycjaDTO> textColumnJednostkaPodstawowa = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getUslugaDTO().getJednostkaPodstawowaVAT();
			}
		};
		TextColumn<PozycjaDTO> textColumnVat = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getProduktDTO().getVat();
			}
		};
		dataGridWyswietlPozycje.setWidth("100%");
		dataGridWyswietlPozycje.setHeight("300px");

		dataGridWyswietlPozycje.addColumn(textColumnNazwa, "NAZWA");
		dataGridWyswietlPozycje.addColumn(textColumnTyp, "TYP");
		dataGridWyswietlPozycje.addColumn(textColumnCena, "CENA");
		dataGridWyswietlPozycje.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE");
		dataGridWyswietlPozycje.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridWyswietlPozycje.addColumn(textColumnVat, "VAT");
		dataGridWyswietlPozycje.addColumn(textColumnJednostkaPodstawowa, "JEDNOSTKA PODSTAWOWA VAT");

	}

	@UiHandler("buttonDodajNowyProdukt")
	void dodajProdukt(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajProdukt();
		// final List<PozycjaDTO> list = new ArrayList<>();
		//
		// list.add(new PozycjaDTO("asdwewq", new ProduktDTO("asd", "asd",
		// "asdasd")));
		// list.add(new PozycjaDTO("asdwewq", new UslugaDTO("asd", "asd")));
		// dataGridWyswietlPozycje.setRowData(list);
		// Window.alert("Nie działam");
	}

	@UiHandler("buttonDodajNowaUsluge")
	void dodajUsluge(ClickEvent e) {
		// Window.alert("Nie działam");
		getUiHandlers().buttonAkcjaDodajUsluge();
	}

	public DataGrid<PozycjaDTO> getDataGridWyswietlPozycje() {
		return dataGridWyswietlPozycje;
	}

}