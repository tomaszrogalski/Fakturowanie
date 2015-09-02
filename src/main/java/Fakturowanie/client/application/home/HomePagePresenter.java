package Fakturowanie.client.application.home;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import Fakturowanie.client.application.ApplicationPresenter;
import Fakturowanie.client.application.menu.MenuPresenter;
import Fakturowanie.client.place.NameTokens;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {
	}
//PermanentSlot tu zrobic dla menu
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Menu = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Roboczy = new Type<RevealContentHandler<?>>();

	@ProxyCodeSplit
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	MenuPresenter menuPresenter;

	@Override
	protected void onReveal() {
		addToSlot(SLOT_Menu, menuPresenter);
		super.onReveal();
	}
	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

		

	}
}
