package Fakturowanie.client.application.dodajfakture;

import javax.inject.Inject;

import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.KlientDTO;
import Fakturowanie.shared.PozycjaDTO;

class DodajFaktureView extends ViewWithUiHandlers<DodajFaktureUiHandlers>implements DodajFakturePresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajFaktureView> {
	}

	@UiField
	TextBox textBoxNrFaktury;

	@UiField
	DataGrid<PozycjaDTO> dataGridListaPozycji;

	@UiField
	DataGrid<KlientDTO> dataGridListaKlientow;

	@UiField
	Button buttonDodajNowaPozycje;

	@UiField
	Button buttonDodajNowaFakture;

	@Inject
	DodajFaktureView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		stworzDataGridListaPozycji();
		stworzDataGridListaKlientow();

	}

	@UiHandler("buttonDodajNowaPozycje")
	void dodajPozycje(ClickEvent e) {
//		dataGridListaPozycji.addCellPreviewHandler(new CellPreviewEvent.Handler<PozycjaDTO>() {
//
//			@Override
//			public void onCellPreview(CellPreviewEvent<PozycjaDTO> event) {
//				// TODO Auto-generated method stub
//
//			}
//		});

		Window.alert("Nie działam");
	}
	//
	//
	// @Override
	// public void onCellPreview(CellPreviewEvent<PozycjaDTO> event) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// };};
	//

	// Thanks Jens for the tip.
	//
	// For anybody interested on the solution I've implemented it in the
	// following
	// manner :
	//
	// addCellPreviewHandler(new CellPreviewEvent.Handler<T>() {
	//
	// @Override
	// public void onCellPreview(final CellPreviewEvent<T> event) {
	// // userChoiceHandler is used to notify an item choice
	// within the datagrid.
	// if (userChoiceHandler != null) {
	// NativeEvent nativeEvent = event.getNativeEvent();
	// String eventType = nativeEvent.getType();
	// if ((BrowserEvents.KEYDOWN.equals(eventType) &&
	// nativeEvent.getKeyCode() == KeyCodes.KEY_ENTER)
	// (BrowserEvents.DBLCLICK.equals(nativeEvent.getType()))) {
	// T selectedValue = event.getValue();
	// userChoiceHandler.onUserChoice(selectedValue);
	// }
	// }
	// }
	// });
	//

	// .addDomHandler(new DoubleClickHandler() {
	//
	// @Override
	// public void onDoubleClick(final DoubleClickEvent event) {
	// T selected = selectionModel
	// .getSelectedObject();
	// if (selected != null) {
	// //DO YOUR STUFF
	//
	// }
	//
	// }
	// },

	@UiHandler("buttonDodajNowaFakture")
	void dodajFakture(ClickEvent e) {
		Window.alert("Nie działam");
	}

	private void stworzDataGridListaKlientow() {
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

		dataGridListaKlientow.setWidth("100%");
		dataGridListaKlientow.setHeight("300px");

		dataGridListaKlientow.addColumn(textColumnId, "ID");
		dataGridListaKlientow.addColumn(textColumnImie, "IMIE");
		dataGridListaKlientow.addColumn(textColumnNazwisko, "NAZWISKO");
		dataGridListaKlientow.addColumn(textColumnUlica, "ULICA");
		dataGridListaKlientow.addColumn(textColumnNrDomu, "NR DOMU");
		dataGridListaKlientow.addColumn(textColumnMiejscowosc, "MIEJSCOWOŚĆ");
		dataGridListaKlientow.addColumn(textColumnKodPocztowy, "KOD POCZTOWY");

	}

	private void stworzDataGridListaPozycji() {
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
		dataGridListaPozycji.setWidth("100%");
		dataGridListaPozycji.setHeight("300px");

		dataGridListaPozycji.addColumn(textColumnNazwa, "NAZWA");
		dataGridListaPozycji.addColumn(textColumnTyp, "TYP");
		dataGridListaPozycji.addColumn(textColumnCena, "CENA");
		dataGridListaPozycji.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE");
		dataGridListaPozycji.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridListaPozycji.addColumn(textColumnVat, "VAT");
		dataGridListaPozycji.addColumn(textColumnJednostkaPodstawowa, "JEDNOSTKA PODSTAWOWA VAT");
	}

}