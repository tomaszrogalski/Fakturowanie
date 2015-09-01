package Fakturowanie.client.application.dodajusluge;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajUslugeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DodajUslugePresenter.class, DodajUslugePresenter.MyView.class, DodajUslugeView.class, DodajUslugePresenter.MyProxy.class);
    }
}