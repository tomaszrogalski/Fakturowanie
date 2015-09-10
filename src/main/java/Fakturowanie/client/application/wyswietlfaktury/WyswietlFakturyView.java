package Fakturowanie.client.application.wyswietlfaktury;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.FakturaDTO;

class WyswietlFakturyView extends ViewWithUiHandlers<WyswietlFakturyUiHandlers>
		implements WyswietlFakturyPresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlFakturyView> {
	}

	@UiField
	DataGrid<FakturaDTO> dataGridWyswietlFaktury;

	@Inject
	WyswietlFakturyView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		

		TextColumn<FakturaDTO> textColumnNrFaktury = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getNrFaktury().toString();
			}

		};
		TextColumn<FakturaDTO> textColumnKlient = new TextColumn<FakturaDTO>() {

			@Override
			public String getValue(FakturaDTO fakturaDTO) {
				return fakturaDTO.getKlientDTO().getId().toString();
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
		dataGridWyswietlFaktury.addColumn(textColumnKlient, "KLIENT");
		dataGridWyswietlFaktury.addColumn(textColumnListaPozycji, "LISTA POZYCJI");
	}


	public DataGrid<FakturaDTO> getDataGridWyswietlFaktury() {
		return dataGridWyswietlFaktury;
	}

	
}