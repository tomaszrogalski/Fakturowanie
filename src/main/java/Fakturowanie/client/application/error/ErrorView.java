package Fakturowanie.client.application.error;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ErrorView extends ViewImpl implements ErrorPresenter.MyView {
    interface Binder extends UiBinder<Widget, ErrorView> {
    }

    @Inject
    ErrorView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}