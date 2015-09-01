package Fakturowanie.client.application.dodajfakture;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajFaktureModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DodajFakturePresenter.class, DodajFakturePresenter.MyView.class, DodajFaktureView.class, DodajFakturePresenter.MyProxy.class);
    }
}