package Fakturowanie.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers>implements MenuPresenter.MyView {
	interface Binder extends UiBinder<Widget, MenuView> {
	}

	/// ???????????????
//	@UiField
//	Button buttonWyswietlKlientow = new Button("WYSWIETL KLIENTOW", new ClickHandler() {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			getUiHandlers().buttonAkcjaWyswietlKlientow();
//
//		}
//	});
//	@UiField
//	Button buttonWyswietlFaktury = new Button("WYSWIETL FAKTURY", new ClickHandler() {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			getUiHandlers().buttonAkcjaWyswietlFaktury();
//
//		}
//	});
//
//	@UiField
//	Button buttonDodajNowaFakture = new Button("DODAJ FAKTURE", new ClickHandler() {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			getUiHandlers().buttonAkcjaDodajFakture();
//
//		}
//	});
//	@UiField
//
//	Button buttonWyswietlPozycje = new Button("WYSWIETL PRODUKTY I USLUGI", new ClickHandler() {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			getUiHandlers().buttonAkcjaWyswietlPozycje();
//
//		}
//	});

	@UiField
	VerticalPanel verticalPanel;

	@Inject
	MenuView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		// to chyba nie moze tu tak byc, zrobic w css tymczasowo
		verticalPanel.getElement().setAttribute("align", "center");

		// verticalPanel.add(buttonWyswietlKlientow);
		// verticalPanel.add(buttonWyswietlPozycje);
		// verticalPanel.add(buttonWyswietlFaktury);
		// verticalPanel.add(buttonDodajNowaFakture);
	}

	// @UiHandler("buttonWyswietlPozycje")
	// void wyswietlPozycje(ClickEvent e) {
	//
	// }
	//
	// @UiHandler("buttonWyswietlKlientow")
	// void wyswietlKlientow(ClickEvent e) {
	// // getUiHandlers().buttonAkcjaDodajFakture();
	// // Window.alert("sada");
	// }
	//
	// @UiHandler("buttonWyswietlFaktury")
	// void wyswietlFaktury(ClickEvent e) {
	//
	// }
	//
	// @UiHandler("buttonDodajNowaFakture")
	// void dodajNowaFakture(ClickEvent e) {
	//
	// }

}