package Fakturowanie.client.application.wyswietlklientow;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.KlientDTO;

class WyswietlKlientowView extends ViewWithUiHandlers<WyswietlKlientowUiHandlers>
		implements WyswietlKlientowPresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlKlientowView> {
	}

	@UiField
	DataGrid<KlientDTO> dataGridWyswietlKlientow;

	@UiField
	Button buttonDodajNowegoKlienta;

	@UiField
	HTMLPanel htmlPanelNaDodajKlienta;

	@Inject
	WyswietlKlientowView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		bindSlot(WyswietlKlientowPresenter.SLOT_NA_DODAJ_KLIENTA, htmlPanelNaDodajKlienta);
		stworzDataGrid();

	}

	private void stworzDataGrid() {
		TextColumn<KlientDTO> textColumnId = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getId().toString();
			}
		};
		TextColumn<KlientDTO> textColumnImie = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getImie();
			}
		};
		TextColumn<KlientDTO> textColumnNazwisko = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getNazwisko();
			}
		};
		TextColumn<KlientDTO> textColumnUlica = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getUlica();
			}
		};
		TextColumn<KlientDTO> textColumnNrDomu = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getNrDomu();
			}
		};
		TextColumn<KlientDTO> textColumnMiejscowosc = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getMiejscowosc();
			}
		};
		TextColumn<KlientDTO> textColumnKodPocztowy = new TextColumn<KlientDTO>() {

			@Override
			public String getValue(KlientDTO klient) {
				return klient.getAdresDTO().getKodPocztowy();
			}
		};

		dataGridWyswietlKlientow.setWidth("100%");
		dataGridWyswietlKlientow.setHeight("300px");

		dataGridWyswietlKlientow.addColumn(textColumnId, "ID");
		dataGridWyswietlKlientow.addColumn(textColumnImie, "IMIE");
		dataGridWyswietlKlientow.addColumn(textColumnNazwisko, "NAZWISKO");
		dataGridWyswietlKlientow.addColumn(textColumnUlica, "ULICA");
		dataGridWyswietlKlientow.addColumn(textColumnNrDomu, "NR DOMU");
		dataGridWyswietlKlientow.addColumn(textColumnMiejscowosc, "MIEJSCOWOŚĆ");
		dataGridWyswietlKlientow.addColumn(textColumnKodPocztowy, "KOD POCZTOWY");
	}

	@UiHandler("buttonDodajNowegoKlienta")
	void dodajClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajKlienta();
	}

	public DataGrid<KlientDTO> getDataGridWyswietlKlientow() {
		return dataGridWyswietlKlientow;
	}

}