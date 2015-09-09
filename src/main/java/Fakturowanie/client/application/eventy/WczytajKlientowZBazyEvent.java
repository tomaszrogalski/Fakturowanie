package Fakturowanie.client.application.eventy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class WczytajKlientowZBazyEvent extends GwtEvent<WczytajKlientowZBazyEvent.WczytajKlientowZBazyHandler> {
	private static Type<WczytajKlientowZBazyHandler> TYPE = new Type<WczytajKlientowZBazyHandler>();

	public interface WczytajKlientowZBazyHandler extends EventHandler {
		void onWczytajKlientowZBazy(WczytajKlientowZBazyEvent event);
	}

	// albo zrobic tu zeby zassac tylko 1 ten dodany aktualnie
	public WczytajKlientowZBazyEvent() {

	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new WczytajKlientowZBazyEvent());
	}

	public static Type<WczytajKlientowZBazyHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WczytajKlientowZBazyHandler handler) {
		handler.onWczytajKlientowZBazy(this);
	}

	@Override
	public Type<WczytajKlientowZBazyHandler> getAssociatedType() {
		return TYPE;
	}

}
