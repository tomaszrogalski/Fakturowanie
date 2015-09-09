package Fakturowanie.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	public interface MyView extends View {
	}

	public static final NestedSlot SLOT_SetMainContent = new NestedSlot();

	@ProxyStandard
	public interface MyProxy extends Proxy<ApplicationPresenter> {
	}

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
	}
}
