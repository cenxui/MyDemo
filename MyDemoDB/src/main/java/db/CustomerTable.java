package db;

import org.junit.runner.notification.RunListener.ThreadSafe;

import com.amazonaws.services.dynamodbv2.document.Table;

/**
 * This class use a lazy initializer 
 * which make this project run more efficiently.
 * 
 * @author cenxui
 *
 */

@ThreadSafe
public class CustomerTable {
	
	private static final String tableName = "customer"; 
	
	private static final String ID = "id";
	
	private Table table = CkmatesDynamoDB.getDynamoDB().getTable(tableName);
	
	public static CustomerTable getCustomerTable() {
		
		return Resource.customer;		
	}
	
	private CustomerTable() {
		
	}
	
	private static class Resource {
		private static CustomerTable customer = new CustomerTable(); 
		
	}
	
	/**
	 * This method is used to query the customer table in
	 * key value method.
	 * @param id this primary key in table.
	 * @return the item belong to this  primary key.
	 */
	
	public String queryItem(int id) {
		
		return table.query(ID, id).iterator().next().toJSON();
	}
	
	public String putItem(Customer customer) {
		
		return table.putItem(customer.getItem()).getPutItemResult().toString();
	}
	
	public String deleteItem(int id) {
		return table.deleteItem(ID, id).getDeleteItemResult().toString();
	}
	
}
