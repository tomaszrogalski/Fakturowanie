package Fakturowanie.client.application.wyswietlklientow;

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

import Fakturowanie.client.application.dodajklienta.DodajKlientaPresenter;
import Fakturowanie.client.application.eventy.WczytajKlientowZBazyEvent;
import Fakturowanie.client.application.eventy.WczytajKlientowZBazyEvent.WczytajKlientowZBazyHandler;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.KlientResource;
import Fakturowanie.shared.dto.KlientDTO;

public class WyswietlKlientowPresenter
		extends Presenter<WyswietlKlientowPresenter.MyView, WyswietlKlientowPresenter.MyProxy>
		implements WyswietlKlientowUiHandlers, WczytajKlientowZBazyHandler {
	interface MyView extends View, HasUiHandlers<WyswietlKlientowUiHandlers> {
		DataGrid<KlientDTO> getDataGridWyswietlKlientow();
	}

	static final NestedSlot SLOT_NA_DODAJ_KLIENTA = new NestedSlot();

	@NameToken(NameTokens.wyswietlKlientow)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlKlientowPresenter> {
	}

	@Inject
	DodajKlientaPresenter dodajKlientaPresenter;

	RestDispatch dispatcher;

	KlientResource klientResource;

	@Inject
	WyswietlKlientowPresenter(EventBus eventBus, MyView view, MyProxy proxy, KlientResource klientResource,
			RestDispatch dispatcher) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.klientResource = klientResource;
		getView().setUiHandlers(this);
		dodajDoGrida();
		addRegisteredHandler(WczytajKlientowZBazyEvent.getType(), this);

	}
	

	@Override
	public void buttonAkcjaDodajKlienta() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_KLIENTA, dodajKlientaPresenter);
	}

	private void dodajDoGrida() {
		dispatcher.execute(klientResource.wczytaj(), new AsyncCallback<List<KlientDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ KLIENTA");

			}

			@Override
			public void onSuccess(List<KlientDTO> result) {
				getView().getDataGridWyswietlKlientow().setRowData(result);
			}

		});
	}


	@Override
	public void onWczytajKlientowZBazy(WczytajKlientowZBazyEvent event) {
		dodajDoGrida();
		
	}

}