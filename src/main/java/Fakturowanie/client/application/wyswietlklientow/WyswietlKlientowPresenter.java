package Fakturowanie.client.application.wyswietlklientow;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;
import Fakturowanie.serwer.Klient;

public class WyswietlKlientowPresenter
		extends Presenter<WyswietlKlientowPresenter.MyView, WyswietlKlientowPresenter.MyProxy>
		implements WyswietlKlientowUiHandlers {
	interface MyView extends View, HasUiHandlers<WyswietlKlientowUiHandlers> {
		
	}

	@NameToken(NameTokens.wyswietlKlientow)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlKlientowPresenter> {
	}

	@Inject
	WyswietlKlientowPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}

}