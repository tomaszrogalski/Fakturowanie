package Fakturowanie.client.application.wyswietlpozycje;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import Fakturowanie.client.application.dodajprodukt.DodajProduktPresenter;
import Fakturowanie.client.application.dodajusluge.DodajUslugePresenter;
import Fakturowanie.client.place.NameTokens;

public class WyswietlPozycjePresenter
		extends Presenter<WyswietlPozycjePresenter.MyView, WyswietlPozycjePresenter.MyProxy>
		implements WyswietlPozycjeUiHandlers {
	interface MyView extends View, HasUiHandlers<WyswietlPozycjeUiHandlers> {
	}

	static final NestedSlot SLOT_NA_DODAJ_PRODUKT_USLUGE = new NestedSlot();

	@NameToken(NameTokens.wyswietlPozycje)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlPozycjePresenter> {
	}

	@Inject
	WyswietlPozycjePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}

	@Inject
	DodajProduktPresenter dodajProduktPresenter;

	@Inject
	DodajUslugePresenter dodajUslugePresenter;

	@Override
	public void buttonAkcjaDodajProdukt() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_PRODUKT_USLUGE, dodajProduktPresenter);

	}

	@Override
	public void buttonAkcjaDodajUsluge() {
		RevealContentEvent.fire(this, SLOT_NA_DODAJ_PRODUKT_USLUGE, dodajUslugePresenter);

	}

}