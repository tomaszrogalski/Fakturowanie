package Fakturowanie.client.application.dodajprodukt;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
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

	@Inject
	DodajProduktPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}

}