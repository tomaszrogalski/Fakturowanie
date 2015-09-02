package Fakturowanie.client.application.menu;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import Fakturowanie.client.place.NameTokens;
public class MenuPresenter extends Presenter<MenuPresenter.MyView, MenuPresenter.MyProxy> implements MenuUiHandlers {
    interface MyView extends View , HasUiHandlers<MenuUiHandlers> {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Menu = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.menu)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<MenuPresenter> {
    }

    @Inject
    MenuPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
        getView().setUiHandlers(this);
    }

	@Override
	public void buttonAkcjaDodajFakture() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonAkcjaWyswietlFaktury() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonAkcjaWyswietlPozycje() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonAkcjaWyswietlKlientow() {
		// TODO Auto-generated method stub
		
	}
    
    
}