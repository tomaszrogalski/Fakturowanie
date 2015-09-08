//package Fakturowanie.client.dispatch;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import com.google.gwt.http.client.Response;
//import com.gwtplatform.dispatch.rest.client.RestDispatchHooks;
//import com.gwtplatform.dispatch.rest.shared.RestAction;
//
//public class AppRestDispatchHooks implements RestDispatchHooks {
//    private static final Logger logger = Logger.getLogger(AppRestDispatchHooks.class.getName());
//
//    @Override
//    public void onExecute(RestAction<?> action) {
//        logger.log(Level.INFO, "Executing rest dispatch " + action.getPath() + " resource action");
//    }
//
//    @Override
//    public void onSuccess(RestAction<?> action, Response response, Object result) {
//        logger.log(Level.INFO, "Successfully executed " + action.getPath() + ", result: " + response.getText());
//    }
//
//    @Override
//    public void onFailure(RestAction<?> action, Response response, Throwable caught) {
//        logger.log(Level.INFO, "Failed to executed " + action.getPath() + ", result: "
//                + response.getStatusText() + " " + response.getText() + " " + caught.getMessage());
//    }
//}