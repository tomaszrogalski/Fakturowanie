package Fakturowanie.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import Fakturowanie.client.application.dodajfakture.DodajFaktureModule;
import Fakturowanie.client.application.dodajklienta.DodajKlientaModule;
import Fakturowanie.client.application.dodajprodukt.DodajProduktModule;
import Fakturowanie.client.application.dodajusluge.DodajUslugeModule;
import Fakturowanie.client.application.home.HomeModule;
import Fakturowanie.client.application.menu.MenuModule;
import Fakturowanie.client.application.wyswietlfaktury.WyswietlFakturyModule;
import Fakturowanie.client.application.wyswietlklientow.WyswietlKlientowModule;
import Fakturowanie.client.application.wyswietlpozycje.WyswietlPozycjeModule;
import Fakturowanie.client.application.error.ErrorModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new ErrorModule());
		install(new MenuModule());
		install(new DodajFaktureModule());
		install(new WyswietlFakturyModule());
		install(new WyswietlPozycjeModule());
		install(new DodajUslugeModule());
		install(new DodajProduktModule());
		install(new DodajKlientaModule());
		install(new WyswietlKlientowModule());
		install(new HomeModule());

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);
	}
}
