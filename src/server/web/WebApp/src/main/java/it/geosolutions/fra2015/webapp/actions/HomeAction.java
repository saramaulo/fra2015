package it.geosolutions.fra2015.webapp.actions;

import com.lidlesslabs.enterprise.RequestObject;
import com.lidlesslabs.enterprise.ResponseObject;

/**
 *
 * @author francesco
 */
public class HomeAction extends AbstractAction {
    
    @Override
    public ResponseObject call(RequestObject request) {
        ResponseObject responseObject = getResponseObject("home");
        return responseObject;
    }
    
}
