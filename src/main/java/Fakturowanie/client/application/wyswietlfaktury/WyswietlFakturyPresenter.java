package Fakturowanie.client.application.wyswietlfaktury;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;

public class WyswietlFakturyPresenter
		extends Presenter<WyswietlFakturyPresenter.MyView, WyswietlFakturyPresenter.MyProxy>
		implements WyswietlFakturyUiHandlers {
	interface MyView extends View, HasUiHandlers<WyswietlFakturyUiHandlers> {
	}

	public static final NestedSlot SLOT_WyswietlFaktury = new NestedSlot();

	@NameToken(NameTokens.wyswietlFaktury)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<WyswietlFakturyPresenter> {
	}

	@Inject
	WyswietlFakturyPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}

}