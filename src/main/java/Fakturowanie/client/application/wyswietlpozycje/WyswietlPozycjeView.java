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
		stworzDataGrid();
	}

	private void stworzDataGrid() {
		TextColumn<PozycjaDTO> textColumnTyp = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getTyp().toString();
			}
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
				if (pozycjaDTO.getProduktDTO().getCena() == 0.0) {
					return "-";
				} else {
					return pozycjaDTO.getProduktDTO().getCena().toString();
				}
			}
		};
		TextColumn<PozycjaDTO> textColumnCenaZaGodzine = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				if (pozycjaDTO.getUslugaDTO().getCenaZaGodzine() == 0.0) {
					return "-";
				} else {
					return pozycjaDTO.getUslugaDTO().getCenaZaGodzine().toString();
				}

			}
		};
		TextColumn<PozycjaDTO> textColumnJednostka = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getProduktDTO().getJednostka().getSkrotJednostki();
			}
		};

		TextColumn<PozycjaDTO> textColumnVat = new TextColumn<PozycjaDTO>() {

			@Override
			public String getValue(PozycjaDTO pozycjaDTO) {
				return pozycjaDTO.getVat().toString();
			}
		};

		dataGridWyswietlPozycje.setWidth("100%");
		dataGridWyswietlPozycje.setHeight("300px");
		dataGridWyswietlPozycje.addColumn(textColumnTyp, "TYP");
		dataGridWyswietlPozycje.addColumn(textColumnNazwa, "NAZWA");
		dataGridWyswietlPozycje.addColumn(textColumnCena, "CENA(zł)");
		dataGridWyswietlPozycje.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE(zł/h)");
		dataGridWyswietlPozycje.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridWyswietlPozycje.addColumn(textColumnVat, "VAT(%)");

	}

	@UiHandler("buttonDodajNowyProdukt")
	void dodajProdukt(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajProdukt();
	}

	@UiHandler("buttonDodajNowaUsluge")
	void dodajUsluge(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajUsluge();
	}

	public DataGrid<PozycjaDTO> getDataGridWyswietlPozycje() {
		return dataGridWyswietlPozycje;
	}

}