package Fakturowanie.client.application.wyswietlfaktury;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.application.eventy.WczytajOstatniaFaktureZBazyEvent;
import Fakturowanie.client.application.eventy.WczytajOstatniaFaktureZBazyEvent.WczytajOstatniaFaktureZBazyHandler;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.FakturaResource;
import Fakturowanie.shared.dto.FakturaDTO;

public class WyswietlFakturyPresenter
		extends Presenter<WyswietlFakturyPresenter.MyView, WyswietlFakturyPresenter.MyProxy>
		implements WczytajOstatniaFaktureZBazyHandler {

	interface MyView extends View {
		DataGrid<FakturaDTO> getDataGridWyswietlFaktury();
	}

	public static final NestedSlot SLOT_WyswietlFaktury = new NestedSlot();

	@NameToken(NameTokens.wyswietlFaktury)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlFakturyPresenter> {
	}

	RestDispatch dispatcher;
	FakturaResource fakturaResource;

	@Inject
	WyswietlFakturyPresenter(EventBus eventBus, MyView view, MyProxy proxy, FakturaResource fakturaResource,
			RestDispatch dispatcher) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.fakturaResource = fakturaResource;
		dodajDoGrida();
		addRegisteredHandler(WczytajOstatniaFaktureZBazyEvent.getType(), this);
	}

	private void dodajDoGrida() {
		dispatcher.execute(fakturaResource.wczytajWszystkieFaktury(), new AsyncCallback<List<FakturaDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ FAKTURY");
			}

			@Override
			public void onSuccess(List<FakturaDTO> result) {
				getView().getDataGridWyswietlFaktury().setRowData(result);
			}

		});
	}

	@Override
	public void onWczytajOstatniaFaktureZBazy(WczytajOstatniaFaktureZBazyEvent event) {
		
		dispatcher.execute(fakturaResource.wczytajOstatnioDodana(), new AsyncCallback<FakturaDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA - WCZYTAJ FAKTURE");
			}

			@Override
			public void onSuccess(FakturaDTO result) {
				List<FakturaDTO> listaFaktur = new ArrayList<>();
				listaFaktur.addAll(getView().getDataGridWyswietlFaktury().getVisibleItems());
				listaFaktur.add(result);
				getView().getDataGridWyswietlFaktury().setRowData(listaFaktur);

			}
		});

	}
}