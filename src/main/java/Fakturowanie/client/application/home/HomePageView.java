package Fakturowanie.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import Fakturowanie.client.application.dodajfakture.DodajFakturePresenter;
import Fakturowanie.client.application.menu.MenuPresenter;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	public interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	HTMLPanel htmlPanelMenu;

	@UiField
	HTMLPanel htmlPanelRoboczy;

	@Inject
	HomePageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		
	}

	//////// Z Internetu, brak zrodła, z projektu robionego wczesniej
	@Override
	public void addToSlot(Object slot, IsWidget content) {
//		if (slot == DodajFakturePresenter.SLOT_DodajFakture) {
//			if (content != null) {
//				htmlPanelRoboczy.add(content);
//			}
//		} else {
//			super.addToSlot(slot, content);
//		}
		
		if (slot == HomePagePresenter.SLOT_Menu) {
			if (content != null) {
				htmlPanelMenu.add(content);
			}
		} else {
			super.addToSlot(slot, content);
		}
	}

	////////
}
