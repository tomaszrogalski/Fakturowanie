package Fakturowanie.client.application.dodajklienta;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.KlientResource;
import Fakturowanie.shared.dto.KlientDTO;

public class DodajKlientaPresenter extends Presenter<DodajKlientaPresenter.MyView, DodajKlientaPresenter.MyProxy>
		implements DodajKlientaUiHandlers {
	interface MyView extends View, HasUiHandlers<DodajKlientaUiHandlers> {
		public KlientDTO odbierzZawartoscTextBoxow();

	}

	@NameToken(NameTokens.dodajKlienta)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<DodajKlientaPresenter> {

	}

	RestDispatch dispatcher;

	KlientResource klientResource;

	@Inject
	DodajKlientaPresenter(EventBus eventBus, MyView view, MyProxy proxy, KlientResource klientResource,
			RestDispatch dispatcher) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.klientResource = klientResource;
		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajKlienta() {

		dispatcher.execute(klientResource.create(getView().odbierzZawartoscTextBoxow()), new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("COS NIE DZIAŁA");

			}

			@Override
			public void onSuccess(String result) {

			}

		});

	}

	
}
