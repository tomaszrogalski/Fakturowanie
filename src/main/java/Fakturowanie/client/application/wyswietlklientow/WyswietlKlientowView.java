package Fakturowanie.client.application.wyswietlklientow;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.serwer.Klient;

class WyswietlKlientowView extends ViewWithUiHandlers<WyswietlKlientowUiHandlers>
		implements WyswietlKlientowPresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlKlientowView> {
	}

	@UiField
	DataGrid<Klient> dataGridWyswietlKlientow;

	@UiField
	Button buttonDodajNowegoKlienta;

	@Inject
	WyswietlKlientowView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		TextColumn<Klient> textColumnId = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getId().toString();
			}
		};
		TextColumn<Klient> textColumnImie = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getImie();
			}
		};
		TextColumn<Klient> textColumnNazwisko = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getNazwisko();
			}
		};
		TextColumn<Klient> textColumnUlica = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getAdres().getUlica();
			}
		};
		TextColumn<Klient> textColumnNrDomu = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getAdres().getNrDomu();
			}
		};
		TextColumn<Klient> textColumnMiejscowosc = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getAdres().getMiejscowosc();
			}
		};
		TextColumn<Klient> textColumnKodPocztowy = new TextColumn<Klient>() {

			@Override
			public String getValue(Klient klient) {
				return klient.getAdres().getKodPocztowy();
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
		Window.alert("Nie działam");
	}

	public DataGrid<Klient> getDataGridWyswietlKlientow() {
		return dataGridWyswietlKlientow;
	}
}