package Fakturowanie.client.application.dodajfakture;

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
import Fakturowanie.client.application.eventy.WczytajFakturyZBazyEvent;
import Fakturowanie.client.application.eventy.WczytajPozycjeZBazyEvent;
import Fakturowanie.client.application.eventy.WczytajPozycjeZBazyEvent.WczytajPozycjeZBazyHandler;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.FakturaResource;
import Fakturowanie.shared.api.KlientResource;
import Fakturowanie.shared.api.PozycjaResource;
import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.KlientDTO;
import Fakturowanie.shared.dto.PozycjaDTO;

public class DodajFakturePresenter extends Presenter<DodajFakturePresenter.MyView, DodajFakturePresenter.MyProxy>
		implements DodajFaktureUiHandlers, WczytajPozycjeZBazyHandler {
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
		addRegisteredHandler(WczytajPozycjeZBazyEvent.getType(), this);
	}

	private void funkcjaDoFireEvent() {

		WczytajFakturyZBazyEvent.fire(this);
	}

	@Override
	protected void onReveal() {
		dodajDoGrida();
		super.onReveal();
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
		dispatcher.execute(klientResource.wczytaj(), new AsyncCallback<List<KlientDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ KLIENTOW");

			}

			@Override
			public void onSuccess(List<KlientDTO> result) {
				funkcjaDoFireEvent();
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
		dispatcher.execute(fakturaResource.create(getView().odbierzZawartoscZGridITextBoxa()),
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("COS NIE DZIAŁA - DODAJ FAKTURE");

					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("DODANO!");
					}

				});
	}

	@Override
	public void onWczytajPozycjeZBazy(WczytajPozycjeZBazyEvent event) {
		dodajDoGrida();
	}
}