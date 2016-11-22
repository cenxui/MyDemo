package handler;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import db.CustomerTable;
import util.Util;
import request.Request;

/**
 * 
 * @author cenxui
 * 2016/11/17
 */
public class DemoGetHandler implements RequestHandler<Request, String> {
	
	private CustomerTable table = CustomerTable.getCustomerTable(); 

    @Override
    public String handleRequest(Request input, Context context) {
        context.getLogger().log("Input: " + input);
        
        String id = input.getParams().get("querystring").get("id");
        
        if (Util.isQuery(id) == false) 
        	return "not a currect query";
        
        return table.queryItem(Integer.valueOf(id));

    }
    
}

