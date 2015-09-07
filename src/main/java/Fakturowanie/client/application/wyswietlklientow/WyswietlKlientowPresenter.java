package Fakturowanie.client.application.wyswietlklientow;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import Fakturowanie.client.application.dodajklienta.DodajKlientaPresenter;
import Fakturowanie.client.application.home.HomePagePresenter;
import Fakturowanie.client.application.menu.MenuPresenter;
import Fakturowanie.client.place.NameTokens;

public class WyswietlKlientowPresenter
		extends Presenter<WyswietlKlientowPresenter.MyView, WyswietlKlientowPresenter.MyProxy>
		implements WyswietlKlientowUiHandlers {
	interface MyView extends View, HasUiHandlers<WyswietlKlientowUiHandlers> {

	}
	static final NestedSlot SLOT_NA_DODAJ_KLIENTA = new NestedSlot();
	
	@NameToken(NameTokens.wyswietlKlientow)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlKlientowPresenter> {
	}

	@Inject
	DodajKlientaPresenter dodajKlientaPresenter;

	@Inject
	WyswietlKlientowPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);

		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajKlienta() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_KLIENTA, dodajKlientaPresenter);
		
	}


}