package Fakturowanie.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers>implements MenuPresenter.MyView {
	interface Binder extends UiBinder<Widget, MenuView> {
	}

	@UiField
	Button buttonWyswietlKlientow;
	@UiField
	Button buttonWyswietlFaktury;

	@UiField
	Button buttonDodajNowaFakture;
	@UiField

	Button buttonWyswietlPozycje;

	@UiField
	VerticalPanel verticalPanel;

	@Inject
	MenuView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		// to chyba nie moze tu tak byc, zrobic w css tymczasowo
		verticalPanel.getElement().setAttribute("align", "center");

	}

	@UiHandler("buttonWyswietlPozycje")
	void wyswietlPozycje(ClickEvent e) {
		getUiHandlers().buttonAkcjaWyswietlPozycje();
	}

	@UiHandler("buttonWyswietlKlientow")
	void wyswietlKlientow(ClickEvent e) {
		getUiHandlers().buttonAkcjaWyswietlKlientow();
	}

	@UiHandler("buttonWyswietlFaktury")
	void wyswietlFaktury(ClickEvent e) {
		getUiHandlers().buttonAkcjaWyswietlFaktury();
	}

	@UiHandler("buttonDodajNowaFakture")
	void dodajNowaFakture(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajFakture();
	}

}