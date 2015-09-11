package Fakturowanie.client.application.wyswietlfaktury;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import Fakturowanie.shared.dto.FakturaDTO;

class WyswietlFakturyView extends ViewImpl implements WyswietlFakturyPresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlFakturyView> {
	}

	@UiField
	DataGrid<FakturaDTO> dataGridWyswietlFaktury;

	@Inject
	WyswietlFakturyView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		stworzDataGrid();

	}

	private void stworzDataGrid() {
		TextColumn<FakturaDTO> textColumnNrFaktury = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getNrFaktury().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnKlientImie = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getKlientDTO().getImie().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnKlientNazwisko = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getKlientDTO().getNazwisko().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnListaPozycji = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getListaPozycjiDTO().toString();
			}

		};

		dataGridWyswietlFaktury.setWidth("100%");
		dataGridWyswietlFaktury.setHeight("300px");
		dataGridWyswietlFaktury.addColumn(textColumnNrFaktury, "NR FAKTURY");
		dataGridWyswietlFaktury.addColumn(textColumnKlientImie, "IMIE");
		dataGridWyswietlFaktury.addColumn(textColumnKlientNazwisko, "NAZWISKO");
		dataGridWyswietlFaktury.addColumn(textColumnListaPozycji, "LISTA POZYCJI");
		dataGridWyswietlFaktury.setColumnWidth(0, "10%");
		dataGridWyswietlFaktury.setColumnWidth(1, "20%");
		dataGridWyswietlFaktury.setColumnWidth(2, "20%");
		dataGridWyswietlFaktury.setColumnWidth(3, "50%");
	}

	public DataGrid<FakturaDTO> getDataGridWyswietlFaktury() {
		return dataGridWyswietlFaktury;
	}

}