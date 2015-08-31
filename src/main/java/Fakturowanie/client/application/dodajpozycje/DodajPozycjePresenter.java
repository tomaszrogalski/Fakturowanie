package Fakturowanie.client.application.dodajpozycje;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;

public class DodajPozycjePresenter extends Presenter<DodajPozycjePresenter.MyView, DodajPozycjePresenter.MyProxy> {
	interface MyView extends View {
	}

	@NameToken(NameTokens.dodajPozycje)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajPozycjePresenter> {
	}

	@Inject
	DodajPozycjePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}

}