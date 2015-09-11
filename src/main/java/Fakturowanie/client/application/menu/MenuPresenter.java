package Fakturowanie.client.application.menu;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import Fakturowanie.client.application.dodajfakture.DodajFakturePresenter;
import Fakturowanie.client.application.home.HomePagePresenter;
import Fakturowanie.client.application.wyswietlfaktury.WyswietlFakturyPresenter;
import Fakturowanie.client.application.wyswietlklientow.WyswietlKlientowPresenter;
import Fakturowanie.client.application.wyswietlpozycje.WyswietlPozycjePresenter;
import Fakturowanie.client.place.NameTokens;

public class MenuPresenter extends Presenter<MenuPresenter.MyView, MenuPresenter.MyProxy>implements MenuUiHandlers {

	interface MyView extends View, HasUiHandlers<MenuUiHandlers> {
	}
	
	@NameToken(NameTokens.menu)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<MenuPresenter> {
	}

	@Inject
	MenuPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);
		getView().setUiHandlers(this);
	}

	@Inject
	WyswietlPozycjePresenter wyswietlPozycjePresenter;

	@Inject
	DodajFakturePresenter dodajFakturePresenter;

	@Inject
	WyswietlFakturyPresenter wyswietlFakturyPresenter;

	@Inject
	WyswietlKlientowPresenter wyswietlKlientowPresenter;

	@Override
	public void buttonAkcjaDodajFakture() {
		RevealContentEvent.fire(this, HomePagePresenter.SLOT_ROBOCZY, dodajFakturePresenter);
	}

	@Override
	public void buttonAkcjaWyswietlFaktury() {
		RevealContentEvent.fire(this, HomePagePresenter.SLOT_ROBOCZY, wyswietlFakturyPresenter);
	}

	@Override
	public void buttonAkcjaWyswietlPozycje() {
		RevealContentEvent.fire(this, HomePagePresenter.SLOT_ROBOCZY, wyswietlPozycjePresenter);
	}

	@Override
	public void buttonAkcjaWyswietlKlientow() {
		RevealContentEvent.fire(this, HomePagePresenter.SLOT_ROBOCZY, wyswietlKlientowPresenter);
	}

}