//package Fakturowanie.client.dispatch;
//
//import org.apache.http.protocol.HTTP;
//
//import com.gwtplatform.dispatch.rest.shared.HttpMethod;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.gwtplatform.dispatch.client.interceptor.ExecuteCommand;
//import com.gwtplatform.dispatch.rest.client.interceptor.AbstractRestInterceptor;
//import com.gwtplatform.dispatch.rest.client.interceptor.InterceptorContext;
//import com.gwtplatform.dispatch.rest.shared.RestAction;
//import com.gwtplatform.dispatch.shared.DispatchRequest;
//
//public class KlientInterceptor extends AbstractRestInterceptor {
//
//	protected KlientInterceptor(InterceptorContext context, InterceptorContext[] moreContexts) {
//		super(new InterceptorContext.Builder()
//                .path("/Klient")
//                .httpMethod(HttpMethod.POST)
//                .transcendent(true)
//                .build());
//	}
//
//	@Override
//	public DispatchRequest execute(RestAction action, AsyncCallback<Object> resultCallback,
//			ExecuteCommand<RestAction, Object> executeCommand) {
//		 return executeCommand.execute(action, resultCallback);
//	}
//}
