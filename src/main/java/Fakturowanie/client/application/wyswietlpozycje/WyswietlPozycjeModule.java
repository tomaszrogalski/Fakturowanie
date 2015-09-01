package Fakturowanie.client.application.wyswietlpozycje;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WyswietlPozycjeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(WyswietlPozycjePresenter.class, WyswietlPozycjePresenter.MyView.class, WyswietlPozycjeView.class, WyswietlPozycjePresenter.MyProxy.class);
    }
}