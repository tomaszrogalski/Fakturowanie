package Fakturowanie.client.application.wyswietlpozycje;

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
import Fakturowanie.client.application.eventy.WczytajPozycjeZBazyEvent;
import Fakturowanie.client.application.eventy.WczytajPozycjeZBazyEvent.WczytajPozycjeZBazyHandler;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.PozycjaResource;
import Fakturowanie.shared.dto.PozycjaDTO;

public class WyswietlPozycjePresenter
		extends Presenter<WyswietlPozycjePresenter.MyView, WyswietlPozycjePresenter.MyProxy>
		implements WyswietlPozycjeUiHandlers, WczytajPozycjeZBazyHandler {
	
	interface MyView extends View, HasUiHandlers<WyswietlPozycjeUiHandlers> {
		DataGrid<PozycjaDTO> getDataGridWyswietlPozycje();
	}

	static final NestedSlot SLOT_NA_DODAJ_PRODUKT_USLUGE = new NestedSlot();
	@NameToken(NameTokens.wyswietlPozycje)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlPozycjePresenter> {
	}

	RestDispatch dispatcher;
	PozycjaResource pozycjaResource;

	@Inject
	WyswietlPozycjePresenter(EventBus eventBus, MyView view, MyProxy proxy, RestDispatch dispatcher,

	PozycjaResource pozycjaResource) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.pozycjaResource = pozycjaResource;
		dodajDoGrida();
		getView().setUiHandlers(this);
		addRegisteredHandler(WczytajPozycjeZBazyEvent.getType(), this);
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
	public void onWczytajPozycjeZBazy(WczytajPozycjeZBazyEvent event) {
		dodajDoGrida();

	}

	private void dodajDoGrida() {
		dispatcher.execute(pozycjaResource.wczytaj(), new AsyncCallback<List<PozycjaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ POZYCJE");
			}

			@Override
			public void onSuccess(List<PozycjaDTO> result) {
				getView().getDataGridWyswietlPozycje().setRowData(result);
			}
		});
	}
}