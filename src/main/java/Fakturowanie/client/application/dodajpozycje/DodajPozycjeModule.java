package Fakturowanie.client.application.dodajpozycje;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajPozycjeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DodajPozycjePresenter.class, DodajPozycjePresenter.MyView.class, DodajPozycjeView.class, DodajPozycjePresenter.MyProxy.class);
    }
}