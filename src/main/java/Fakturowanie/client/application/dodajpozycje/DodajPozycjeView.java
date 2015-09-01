package Fakturowanie.client.application.dodajpozycje;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class DodajPozycjeView extends ViewImpl implements DodajPozycjePresenter.MyView {
    interface Binder extends UiBinder<Widget, DodajPozycjeView> {
    }

    @Inject
    DodajPozycjeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    
}