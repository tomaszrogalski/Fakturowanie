package Fakturowanie.client.application.eventy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class WczytajPozycjeZBazyEvent extends GwtEvent<WczytajPozycjeZBazyEvent.WczytajPozycjeZBazyHandler> {
	private static Type<WczytajPozycjeZBazyHandler> TYPE = new Type<WczytajPozycjeZBazyHandler>();

	public interface WczytajPozycjeZBazyHandler extends EventHandler {
		void onWczytajPozycjeZBazy(WczytajPozycjeZBazyEvent event);
	}

	public WczytajPozycjeZBazyEvent() {

	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new WczytajPozycjeZBazyEvent());
	}

	public static Type<WczytajPozycjeZBazyHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WczytajPozycjeZBazyHandler handler) {
		handler.onWczytajPozycjeZBazy(this);
	}

	@Override
	public Type<WczytajPozycjeZBazyHandler> getAssociatedType() {
		return TYPE;
	}

}
