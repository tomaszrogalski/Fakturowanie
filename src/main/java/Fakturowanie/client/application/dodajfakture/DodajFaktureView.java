package Fakturowanie.client.application.dodajfakture;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;

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
	Button buttonDodajNowaUsluge;

	@UiField
	Button buttonDodajNowyProdukt;

	@UiField
	Button buttonDodajNowaFakture;

	@UiField
	HTMLPanel htmlPanelDodajPozycje;

	final SingleSelectionModel<KlientDTO> simpleSelectionModel = new SingleSelectionModel<KlientDTO>();

	final MultiSelectionModel<PozycjaDTO> multiSelectionModel = new MultiSelectionModel<PozycjaDTO>();

	@Inject
	DodajFaktureView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		bindSlot(DodajFakturePresenter.SLOT_NA_DODAJ_PRODUKT_USLUGE, htmlPanelDodajPozycje);
		stworzDataGridListaPozycji();
		stworzDataGridListaKlientow();
	}

	@UiHandler("buttonDodajNowyProdukt")
	void dodajProdukt(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajProdukt();
		// List<KlientDTO> listK = new ArrayList<>();
		// KlientDTO kli = new KlientDTO("asd", "asdas", new AdresDTO("asd",
		// "asdads", "asd", "sd"));
		// kli.setId(2L);
		// listK.add(kli);
		// dataGridListaKlientow.setRowData(listK);
		//
		// List<PozycjaDTO> list = new ArrayList<>();
		// list.add(new PozycjaDTO("asdwewq", new ProduktDTO("asd", "asd",
		// "asdasd")));
		// list.add(new PozycjaDTO("asdwewq", new UslugaDTO("asd", "asd")));
		//
		// Window.alert(multiSelectionModel.getSelectedSet().toString());
		// Window.alert(simpleSelectionModel.getSelectedObject().toString());
		//
		// dataGridListaPozycji.setRowData(list);

		// Window.alert("Nie działam");
	}

	@UiHandler("buttonDodajNowaUsluge")
	void dodajUsluge(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajUsluge();
		// Window.alert("Nie działam");
	}

	@UiHandler("buttonDodajNowaFakture")
	void dodajFakture(ClickEvent e) {
		// C
		Window.alert("Nie działam");
	}

	public FakturaDTO OdbierzZawartoscZGridITextBoxa() {
		FakturaDTO fakturaDTO = new FakturaDTO();
		fakturaDTO.setKlientDTO(simpleSelectionModel.getSelectedObject());
		// CZY MOGE TAK ZROBIC? SPRAWDZIC
		fakturaDTO.setListaPozycjiDTO((List<PozycjaDTO>) multiSelectionModel.getSelectedSet());

		// TYMCZASOWE
		fakturaDTO.setNrFaktury(2L);
		return fakturaDTO;
	}

	//////// Z Internetu, brak zrodła, z projektu robionego wczesniej
	// @Override
	// public void addToSlot(Object slot, IsWidget content) {
	// if (slot == DodajFakturePresenter.SLOT_DodajFakture) {
	// if (content != null) {
	// htmlPanelDodajPozycje.add(content);
	// }
	// } else {
	// super.addToSlot(slot, content);
	// }
	// }

	////////

	private void stworzDataGridListaKlientow() {

		///////// Zrobione na podstawie:
		///////// http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwDataGrid
		dataGridListaKlientow.setSelectionModel(simpleSelectionModel);

		Column<KlientDTO, Boolean> checkColumn = new Column<KlientDTO, Boolean>(new CheckboxCell(true, false)) {

			@Override
			public Boolean getValue(KlientDTO object) {
				return simpleSelectionModel.isSelected(object);
			}
			/////////

		};

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
		dataGridListaKlientow.addColumn(checkColumn, "checkcolumn");
		dataGridListaKlientow.addColumn(textColumnId, "ID");
		dataGridListaKlientow.addColumn(textColumnImie, "IMIE");
		dataGridListaKlientow.addColumn(textColumnNazwisko, "NAZWISKO");
		dataGridListaKlientow.addColumn(textColumnUlica, "ULICA");
		dataGridListaKlientow.addColumn(textColumnNrDomu, "NR DOMU");
		dataGridListaKlientow.addColumn(textColumnMiejscowosc, "MIEJSCOWOŚĆ");
		dataGridListaKlientow.addColumn(textColumnKodPocztowy, "KOD POCZTOWY");

	}

	private void stworzDataGridListaPozycji() {

		///////// Zrobione analogicznie do simpleSelectionModel
		// Dlaczego działa to jak naciskam ctrl? POPRAWIC!
		dataGridListaPozycji.setSelectionModel(multiSelectionModel);

		Column<PozycjaDTO, Boolean> checkColumn = new Column<PozycjaDTO, Boolean>(new CheckboxCell(true, false)) {

			@Override
			public Boolean getValue(PozycjaDTO object) {
				return multiSelectionModel.isSelected(object);
			}

		};
		/////////

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
		dataGridListaPozycji.addColumn(checkColumn, "CheckBox");
		dataGridListaPozycji.addColumn(textColumnNazwa, "NAZWA");
		dataGridListaPozycji.addColumn(textColumnTyp, "TYP");
		dataGridListaPozycji.addColumn(textColumnCena, "CENA");
		dataGridListaPozycji.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE");
		dataGridListaPozycji.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridListaPozycji.addColumn(textColumnVat, "VAT");
		dataGridListaPozycji.addColumn(textColumnJednostkaPodstawowa, "JEDNOSTKA PODSTAWOWA VAT");

	}

}