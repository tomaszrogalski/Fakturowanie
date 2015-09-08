package Fakturowanie.client.application.wyswietlfaktury;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;
import Fakturowanie.shared.dto.ProduktDTO;

class WyswietlFakturyView extends ViewWithUiHandlers<WyswietlFakturyUiHandlers>
		implements WyswietlFakturyPresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlFakturyView> {
	}

	@UiField
	DataGrid<FakturaDTO> dataGridWyswietlFaktury;


	@UiField
	Button buttonDodajNowaFakture;

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

	@UiHandler("buttonDodajNowaFakture")
	void dodajFakture(ClickEvent e) {

		List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();
		KlientDTO klientDTO = new KlientDTO();
		klientDTO.setId(2L);

		listaPozycjiDTO.add(new PozycjaDTO("nazwa", new ProduktDTO("scena", "jednostka", "vat")));
		FakturaDTO fakturaDTO = new FakturaDTO(1L, klientDTO, listaPozycjiDTO);

		List<FakturaDTO> listFaktur = new ArrayList<>();
		listFaktur.add(fakturaDTO);
		dataGridWyswietlFaktury.setRowData(listFaktur);
		Window.alert("Nie działam");
	}

}