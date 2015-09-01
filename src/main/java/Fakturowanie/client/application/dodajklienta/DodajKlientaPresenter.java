package Fakturowanie.client.application.dodajklienta;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.place.NameTokens;
import Fakturowanie.shared.KlientDTO;

public class DodajKlientaPresenter extends Presenter<DodajKlientaPresenter.MyView, DodajKlientaPresenter.MyProxy>
		implements DodajKlientaUiHandlers {
	interface MyView extends View, HasUiHandlers<DodajKlientaUiHandlers> {
		public KlientDTO OdbierzZawartoscTextBoxow();
	}

	@NameToken(NameTokens.dodajKlienta)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajKlientaPresenter> {
	}

	@Inject
	DodajKlientaPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajKlienta() {
		KlientDTO klientDTO = getView().OdbierzZawartoscTextBoxow();
		Window.alert(klientDTO.toString());
	}
}