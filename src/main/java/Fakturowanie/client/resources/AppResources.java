package Fakturowanie.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
	// zrodlo:
	// http://blog.arcbees.com/2015/04/14/getting-started-with-css-gss-gwt/
	interface Normalize extends CssResource {
	}

	interface Style extends CssResource {

		String menu_html_Panel();

		String menu_button_rozmiary();

		String menu_vertical_panel();

		String wyswietl_html_panel();

		String label();

		String error_i_dodaj_html_panel();

		String horizontal_panel_buttony();

		String home_html_panel_glowny();

		String home_html_panel_menu();

		String home_html_panel_roboczy();

		String dodaj_horizontal_panel();
		
		String buttony_wyswietl_dodaj();
	}

	@Source("css/style.css")
	Style style();
}
