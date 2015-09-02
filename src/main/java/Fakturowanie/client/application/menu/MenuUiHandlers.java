package Fakturowanie.client.application.menu;

import com.gwtplatform.mvp.client.UiHandlers;

interface MenuUiHandlers extends UiHandlers {
	void buttonAkcjaDodajFakture();

	void buttonAkcjaWyswietlFaktury();

	void buttonAkcjaWyswietlPozycje();

	void buttonAkcjaWyswietlKlientow();
}