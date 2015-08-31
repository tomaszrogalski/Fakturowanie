package Fakturowanie.client.application;

import Fakturowanie.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import Fakturowanie.client.application.wyswietlklientow.WyswietlKlientowModule;
import Fakturowanie.client.application.dodajklienta.DodajKlientaModule;
import Fakturowanie.client.application.dodajprodukt.DodajProduktModule;
import Fakturowanie.client.application.dodajpozycje.DodajPozycjeModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DodajPozycjeModule());
		install(new DodajProduktModule());
		install(new DodajKlientaModule());
		install(new WyswietlKlientowModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
