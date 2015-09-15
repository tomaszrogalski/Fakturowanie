package Fakturowanie.client.application.dodajprodukt;

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
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.application.eventy.DodajOstatnioDodanaPozycjeDoWyswietleniaEvent;
import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.api.PozycjaResource;
import Fakturowanie.shared.dto.PozycjaDTO;

public class DodajProduktPresenter extends Presenter<DodajProduktPresenter.MyView, DodajProduktPresenter.MyProxy>
		implements DodajProduktUiHandlers {
	
	interface MyView extends View, HasUiHandlers<DodajProduktUiHandlers> {
		PozycjaDTO odbierzZawartoscTextBoxow();
	}
	@NameToken(NameTokens.dodajProdukt)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajProduktPresenter> {
	}

	RestDispatch dispatcher;
	PozycjaResource pozycjaResource;

	@Inject
	DodajProduktPresenter(EventBus eventBus, MyView view, MyProxy proxy, RestDispatch dispatcher,

	PozycjaResource pozycjaResource) {
		super(eventBus, view, proxy);
		this.dispatcher = dispatcher;
		this.pozycjaResource = pozycjaResource;
		getView().setUiHandlers(this);
	}

	private void funkcjaDoFireEvent(PozycjaDTO pozycjaDTO) {

		DodajOstatnioDodanaPozycjeDoWyswietleniaEvent.fire(this,pozycjaDTO);
	}

	private void dodajDoBazy(final PozycjaDTO pozycjaDTO) {
		dispatcher.execute(pozycjaResource.createProdukt(pozycjaDTO),
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("COS NIE DZIAŁA - DODAJ PRODUKT");

					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("DODANO!");
						funkcjaDoFireEvent(pozycjaDTO);
					}

				});
	}

	@Override
	public void buttonAkcjaDodajProdukt() {
		PozycjaDTO pozycjaDTO=getView().odbierzZawartoscTextBoxow();
		dodajDoBazy(pozycjaDTO);
		removeFromParentSlot();
	}
}