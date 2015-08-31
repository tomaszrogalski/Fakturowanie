package Fakturowanie.client.application.dodajprodukt;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajProduktModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DodajProduktPresenter.class, DodajProduktPresenter.MyView.class, DodajProduktView.class, DodajProduktPresenter.MyProxy.class);
    }
}