package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import db.Customer;
import db.CustomerTable;
import request.Request;

public class DemoPostHandler implements RequestHandler<Request, Object> {
	
	private CustomerTable table = CustomerTable.getCustomerTable();

    @Override
    public Object handleRequest(Request input, Context context) {
        context.getLogger().log("Input: " + input);
        
        if (input.getId() <= 0) {
			return "error";
		}
        
        Customer customer = new Customer();
        customer.setId(input.getId());
        customer.setName(input.getName());
        customer.setCost(input.getCost());
        customer.setCount(input.getCount());
        customer.setBirthday(input.getBirthday());
        customer.setHeight(input.getHeight());
        customer.setWeight(input.getWeight());
        
        table.putItem(customer);
              
        return customer.toString();
    }

}
