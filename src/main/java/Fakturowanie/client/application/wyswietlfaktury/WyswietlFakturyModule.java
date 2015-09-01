package Fakturowanie.client.application.wyswietlfaktury;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WyswietlFakturyModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(WyswietlFakturyPresenter.class, WyswietlFakturyPresenter.MyView.class, WyswietlFakturyView.class, WyswietlFakturyPresenter.MyProxy.class);
    }
}