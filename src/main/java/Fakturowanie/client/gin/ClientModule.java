package Fakturowanie.client.gin;

import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

import Fakturowanie.client.application.ApplicationModule;
import Fakturowanie.client.place.NameTokens;

public class ClientModule extends AbstractPresenterModule {
	@Override
	protected void configure() {

		install(new DefaultModule());
		install(new ApplicationModule());
		RestDispatchAsyncModule.Builder dispatchBuilder = new RestDispatchAsyncModule.Builder();
		install(dispatchBuilder.build());

		bindConstant().annotatedWith(RestApplicationPath.class).to("http://localhost:8080/Fakturowanie-1.5/Fakturowanie");
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.error);
		bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.error);

	}
}
