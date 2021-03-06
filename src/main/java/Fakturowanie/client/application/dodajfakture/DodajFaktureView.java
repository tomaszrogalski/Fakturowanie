package Fakturowanie.client.application.dodajfakture;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
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

	@UiField
	@Ignore
	Label errorLabel;

	CheckboxCell checkBoxCell = new CheckboxCell();

	SingleSelectionModel<KlientDTO> simpleSelectionModel = new SingleSelectionModel<KlientDTO>();

	MultiSelectionModel<PozycjaDTO> multiSelectionModel = new MultiSelectionModel<PozycjaDTO>();

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

	}

	@UiHandler("buttonDodajNowaUsluge")
	void dodajUsluge(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajUsluge();
	}

	@UiHandler("buttonDodajNowaFakture")
	void dodajFakture(ClickEvent e) {
		if (waliduj()) {
			getUiHandlers().buttonAkcjaDodajFakture();
			errorLabel.setText("");
		} else {
			errorLabel.setText("Zaznacz minimum 1 pozycje i mininum 1 klienta");
		}
	}

	public FakturaDTO odbierzZawartoscZGridITextBoxa() {
		FakturaDTO fakturaDTO = new FakturaDTO();
		fakturaDTO.setKlientDTO(simpleSelectionModel.getSelectedObject());

		List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();

		for (PozycjaDTO pozycjaDTO : multiSelectionModel.getSelectedSet()) {
			listaPozycjiDTO.add(pozycjaDTO);
		}
		fakturaDTO.setListaPozycjiDTO(listaPozycjiDTO);
		return fakturaDTO;
	}

	private void stworzDataGridListaKlientow() {

		///////// Zrobione na podstawie:
		///////// http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwDataGrid
		dataGridListaKlientow.setSelectionModel(simpleSelectionModel,
				DefaultSelectionEventManager.<KlientDTO> createCheckboxManager());

		Column<KlientDTO, Boolean> checkColumn = new Column<KlientDTO, Boolean>(checkBoxCell) {

			@Override
			public Boolean getValue(KlientDTO object) {
				return simpleSelectionModel.isSelected(object);

			}
			/////////
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
		dataGridListaKlientow.addColumn(checkColumn, "*");
		dataGridListaKlientow.addColumn(textColumnImie, "IMIE");
		dataGridListaKlientow.addColumn(textColumnNazwisko, "NAZWISKO");
		dataGridListaKlientow.addColumn(textColumnUlica, "ULICA");
		dataGridListaKlientow.addColumn(textColumnNrDomu, "NR DOMU");
		dataGridListaKlientow.addColumn(textColumnMiejscowosc, "MIEJSCOWOŚĆ");
		dataGridListaKlientow.addColumn(textColumnKodPocztowy, "KOD POCZTOWY");
	}

	private void stworzDataGridListaPozycji() {

		///////// Zrobione analogicznie do simpleSelectionModel
		// Teraz działa lepiej
		dataGridListaPozycji.setSelectionModel(multiSelectionModel,
				DefaultSelectionEventManager.<PozycjaDTO> createCheckboxManager());

		Column<PozycjaDTO, Boolean> checkColumn = new Column<PozycjaDTO, Boolean>(new CheckboxCell(true, false)) {

			@Override
			public Boolean getValue(PozycjaDTO object) {
				return dataGridListaPozycji.getSelectionModel().isSelected(object);
			}

		};

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
		dataGridListaPozycji.setWidth("100%");
		dataGridListaPozycji.setHeight("300px");
		dataGridListaPozycji.addColumn(checkColumn, "*");
		dataGridListaPozycji.addColumn(textColumnTyp, "TYP");
		dataGridListaPozycji.addColumn(textColumnNazwa, "NAZWA");
		dataGridListaPozycji.addColumn(textColumnCena, "CENA(zł)");
		dataGridListaPozycji.addColumn(textColumnCenaZaGodzine, "CENA ZA GODZINE(zł/h)");
		dataGridListaPozycji.addColumn(textColumnJednostka, "JEDNOSTKA");
		dataGridListaPozycji.addColumn(textColumnVat, "VAT(%)");
	}

	public DataGrid<PozycjaDTO> getDataGridListaPozycji() {
		return dataGridListaPozycji;
	}

	public DataGrid<KlientDTO> getDataGridListaKlientow() {
		return dataGridListaKlientow;
	}

	private boolean waliduj() {
		if (simpleSelectionModel.getSelectedObject() != null && !multiSelectionModel.getSelectedSet().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}