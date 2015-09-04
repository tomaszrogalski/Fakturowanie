package Fakturowanie.client.application.wyswietlklientow;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

import Fakturowanie.client.application.home.HomePagePresenter;
import Fakturowanie.client.place.NameTokens;

public class WyswietlKlientowPresenter
		extends Presenter<WyswietlKlientowPresenter.MyView, WyswietlKlientowPresenter.MyProxy>
		implements WyswietlKlientowUiHandlers {
	interface MyView extends View, HasUiHandlers<WyswietlKlientowUiHandlers> {

	}

	@NameToken(NameTokens.wyswietlKlientow)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlKlientowPresenter> {
	}

	@Override
	protected void onBind() {
		setInSlot(HomePagePresenter.SLOT_ROBOCZY, this);
		super.onBind();
	}

	@Inject
	WyswietlKlientowPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);

		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HomePagePresenter.SLOT_ROBOCZY, this);
		super.revealInParent();
	}

}