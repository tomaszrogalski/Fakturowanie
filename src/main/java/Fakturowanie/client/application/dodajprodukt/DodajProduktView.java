package Fakturowanie.client.application.dodajprodukt;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class DodajProduktView extends ViewWithUiHandlers<DodajProduktUiHandlers> implements DodajProduktPresenter.MyView {
    interface Binder extends UiBinder<Widget, DodajProduktView> {
    }

   

    @Inject
    DodajProduktView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
   
}