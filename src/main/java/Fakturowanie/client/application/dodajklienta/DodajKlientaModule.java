package Fakturowanie.client.application.dodajklienta;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajKlientaModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DodajKlientaPresenter.class, DodajKlientaPresenter.MyView.class, DodajKlientaView.class, DodajKlientaPresenter.MyProxy.class);
    }
}