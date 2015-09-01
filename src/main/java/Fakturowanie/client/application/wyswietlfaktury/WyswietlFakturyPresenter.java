package Fakturowanie.client.application.wyswietlfaktury;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import Fakturowanie.client.place.NameTokens;
public class WyswietlFakturyPresenter extends Presenter<WyswietlFakturyPresenter.MyView, WyswietlFakturyPresenter.MyProxy> implements WyswietlFakturyUiHandlers {
    interface MyView extends View , HasUiHandlers<WyswietlFakturyUiHandlers> {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_WyswietlFaktury = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.wyswietlFaktury)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<WyswietlFakturyPresenter> {
    }

    @Inject
    WyswietlFakturyPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
        getView().setUiHandlers(this);
    }
    
    
}