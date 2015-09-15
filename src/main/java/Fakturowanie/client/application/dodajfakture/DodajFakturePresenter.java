package Fakturowanie.client.application.dodajfakture;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import Fakturowanie.client.application.dodajprodukt.DodajProduktPresenter;
import Fakturowanie.client.application.dodajusluge.DodajUslugePresenter;
import Fakturowanie.client.application.eventy.DodajDodanegoKlientaDoGridaEvent;
import Fakturowanie.client.application.eventy.DodajDodanegoKlientaDoGridaEvent.DodajDodanegoKlientaDoGridaHandler;
import Fakturowanie.client.application.eventy.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import Fakturowanie.client.application.eventy.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.DodajOstatnioDodanaPozycjeDoWyswietleniaHandler;
import Fakturowanie.client.application.eventy.WczytajOstatniaFaktureZBazyEvent;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.FakturaResource;
import Fakturowanie.shared.api.KlientResource;
import Fakturowanie.shared.api.PozycjaResource;
import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;

public class DodajFakturePresenter extends Presenter<DodajFakturePresenter.MyView, DodajFakturePresenter.MyProxy>
		implements DodajFaktureUiHandlers, DodajOstatnioDodanaPozycjeDoWyswietleniaHandler,DodajDodanegoKlientaDoGridaHandler {
	interface MyView extends View, HasUiHandlers<DodajFaktureUiHandlers> {
		FakturaDTO odbierzZawartoscZGridITextBoxa();

		DataGrid<KlientDTO> getDataGridListaKlientow();

		DataGrid<PozycjaDTO> getDataGridListaPozycji();
	}

	static final NestedSlot SLOT_NA_DODAJ_PRODUKT_USLUGE = new NestedSlot();

	@NameToken(NameTokens.dodajFakture)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajFakturePresenter> {
	}

	RestDispatch dispatcher;
	FakturaResource fakturaResource;
	PozycjaResource pozycjaResource;
	KlientResource klientResource;

	@Inject
	DodajFakturePresenter(EventBus eventBus, MyProxy proxy, MyView view, FakturaResource fakturaResource,
			RestDispatch dispatcher, PozycjaResource pozycjaResource, KlientResource klientResource) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.fakturaResource = fakturaResource;
		this.klientResource = klientResource;
		this.pozycjaResource = pozycjaResource;
		getView().setUiHandlers(this);
		addRegisteredHandler(DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.getType(), this);
		addRegisteredHandler(DodajDodanegoKlientaDoGridaEvent.getType(), this);
		dodajDoGrida();
	}

	private void funkcjaDoFireEvent() {

		WczytajOstatniaFaktureZBazyEvent.fire(this);
	}

	private void dodajDoGrida() {	
		dispatcher.execute(pozycjaResource.wczytaj(), new AsyncCallback<List<PozycjaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ POZYCJE");

			}

			@Override
			public void onSuccess(List<PozycjaDTO> result) {
				getView().getDataGridListaPozycji().setRowData(result);
			}

		});
		dispatcher.execute(klientResource.wczytajWszystkichKlientow(), new AsyncCallback<List<KlientDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ KLIENTOW");

			}

			@Override
			public void onSuccess(List<KlientDTO> result) {
				getView().getDataGridListaKlientow().setRowData(result);

			}

		});
	}

	@Inject
	DodajProduktPresenter dodajProduktPresenter;

	@Inject
	DodajUslugePresenter dodajUslugePresenter;

	@Override
	public void buttonAkcjaDodajProdukt() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_PRODUKT_USLUGE, dodajProduktPresenter);

	}

	@Override
	public void buttonAkcjaDodajUsluge() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_PRODUKT_USLUGE, dodajUslugePresenter);

	}

	@Override
	public void buttonAkcjaDodajFakture() {
		FakturaDTO fakturaDTO = getView().odbierzZawartoscZGridITextBoxa();
		dodajDoBazy(fakturaDTO);
	}
	
	private void dodajDoBazy(final FakturaDTO fakturaDTO){
		dispatcher.execute(fakturaResource.create(fakturaDTO),
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("COS NIE DZIAŁA - DODAJ FAKTURE");

					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("DODANO!");
						funkcjaDoFireEvent();
					}

				});
	}

	@Override
	public void onDodajOstatnioDodanaPozycjeDoWyswietlenia(DodajOstatnioDodanaPozycjeDoWyswietleniaEvent event) {
		List<PozycjaDTO> listaPozycji = new ArrayList<>();
		listaPozycji.addAll(getView().getDataGridListaPozycji().getVisibleItems());
		listaPozycji.add(event.getPozycjaDTO());
		getView().getDataGridListaPozycji().setRowData(listaPozycji);
	}

	@Override
	public void onDodajDodanegoKlientaDoGrida(DodajDodanegoKlientaDoGridaEvent event) {
		dispatcher.execute(klientResource.wczytajOstatnioDodanego(), new AsyncCallback<KlientDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ KLIENTA");
			}

			@Override
			public void onSuccess(KlientDTO result) {
				//tu chciałbym aby do datagrida dodawany byl 1 element nie nadpisywany jaka metoda???
				List<KlientDTO> listaKlientow = new ArrayList<>();
				listaKlientow.addAll(getView().getDataGridListaKlientow().getVisibleItems());
				listaKlientow.add(result);
				getView().getDataGridListaKlientow().setRowData(listaKlientow);
				
			}
		});
		
	}
}