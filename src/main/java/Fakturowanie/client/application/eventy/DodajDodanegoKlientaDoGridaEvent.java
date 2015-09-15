package Fakturowanie.client.application.eventy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class DodajDodanegoKlientaDoGridaEvent extends GwtEvent<DodajDodanegoKlientaDoGridaEvent.DodajDodanegoKlientaDoGridaHandler> {
	private static Type<DodajDodanegoKlientaDoGridaHandler> TYPE = new Type<DodajDodanegoKlientaDoGridaHandler>();

	public interface DodajDodanegoKlientaDoGridaHandler extends EventHandler {
		void onDodajDodanegoKlientaDoGrida(DodajDodanegoKlientaDoGridaEvent event);
	}
	
	
	public DodajDodanegoKlientaDoGridaEvent() {
	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new DodajDodanegoKlientaDoGridaEvent());
	}

	public static Type<DodajDodanegoKlientaDoGridaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final DodajDodanegoKlientaDoGridaHandler handler) {
		handler.onDodajDodanegoKlientaDoGrida(this);
	}

	@Override
	public Type<DodajDodanegoKlientaDoGridaHandler> getAssociatedType() {
		return TYPE;
	}
}
