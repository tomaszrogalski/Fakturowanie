package Fakturowanie.client.application.wyswietlklientow;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WyswietlKlientowModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(WyswietlKlientowPresenter.class, WyswietlKlientowPresenter.MyView.class, WyswietlKlientowView.class, WyswietlKlientowPresenter.MyProxy.class);
    }
}