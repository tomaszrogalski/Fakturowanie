package Fakturowanie.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import Fakturowanie.client.application.ApplicationPresenter;
import Fakturowanie.client.application.menu.MenuPresenter;
import Fakturowanie.client.place.NameTokens;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {
	}

	static final PermanentSlot<MenuPresenter> SLOT_MENU = new PermanentSlot<>();

	public static final NestedSlot SLOT_ROBOCZY = new NestedSlot();

	@ProxyCodeSplit
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	MenuPresenter menuPresenter;

	@Override
	protected void onBind() {
		setInSlot(SLOT_MENU, menuPresenter);
	}

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

	}
}
