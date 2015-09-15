package Fakturowanie.client.application.eventy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class WczytajOstatniaFaktureZBazyEvent extends GwtEvent<WczytajOstatniaFaktureZBazyEvent.WczytajOstatniaFaktureZBazyHandler> {
	private static Type<WczytajOstatniaFaktureZBazyHandler> TYPE = new Type<WczytajOstatniaFaktureZBazyHandler>();

	public interface WczytajOstatniaFaktureZBazyHandler extends EventHandler {
		void onWczytajOstatniaFaktureZBazy(WczytajOstatniaFaktureZBazyEvent event);
	}

	public WczytajOstatniaFaktureZBazyEvent() {
		
	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new WczytajOstatniaFaktureZBazyEvent());
	}

	public static Type<WczytajOstatniaFaktureZBazyHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WczytajOstatniaFaktureZBazyHandler handler) {
		handler.onWczytajOstatniaFaktureZBazy(this);
	}

	@Override
	public Type<WczytajOstatniaFaktureZBazyHandler> getAssociatedType() {
		return TYPE;
	}

	
}
