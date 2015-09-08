package Fakturowanie.client.application.dodajprodukt;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;

public class DodajProduktPresenter extends Presenter<DodajProduktPresenter.MyView, DodajProduktPresenter.MyProxy>
		implements DodajProduktUiHandlers {
	interface MyView extends View, HasUiHandlers<DodajProduktUiHandlers> {
	}

	@NameToken(NameTokens.dodajProdukt)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajProduktPresenter> {
	}

//	private final RestDispatch dispatcher;
//	//
//	private final ProduktResource produktResource;

	@Inject
	DodajProduktPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);
//		this.dispatcher = dispatcher;
//		this.produktResource = produktResource;
		getView().setUiHandlers(this);
	}

	// @Inject
	// ProduktResource produktResource;

	@Override
	public void buttonAkcjaDodajProdukt() {

//		dispatcher.execute(produktResource.create(), new RestCallback<Void>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert(caught.toString());
//			}
//
//			// @Override
//			// public void onSuccess(Produkt result) {
//			//
//			//
//			// }
//
//			@Override
//			public void setResponse(Response response) {
//				Window.alert(response.toString());
//
//			}
//
//			@Override
//			public void onSuccess(Void result) {
//				Window.alert(result.toString());
//
//			}

			// @Override
			// public void setResponse(Response response) {
			//
			//
			// }

//		});

	}
}