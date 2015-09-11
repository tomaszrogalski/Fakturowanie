package Fakturowanie.client.application.eventy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class WczytajFakturyZBazyEvent extends GwtEvent<WczytajFakturyZBazyEvent.WczytajFakturyZBazyHandler> {
	private static Type<WczytajFakturyZBazyHandler> TYPE = new Type<WczytajFakturyZBazyHandler>();

	public interface WczytajFakturyZBazyHandler extends EventHandler {
		void onWczytajFakturyZBazy(WczytajFakturyZBazyEvent event);
	}

	public WczytajFakturyZBazyEvent() {

	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new WczytajFakturyZBazyEvent());
	}

	public static Type<WczytajFakturyZBazyHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WczytajFakturyZBazyHandler handler) {
		handler.onWczytajFakturyZBazy(this);
	}

	@Override
	public Type<WczytajFakturyZBazyHandler> getAssociatedType() {
		return TYPE;
	}
}
