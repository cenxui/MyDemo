package util;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 
 * @author cenxui
 * 2016/11/18
 */

public class Util {
	/**
	 * This method is used to check if the query string is a
	 * number.
	 * @param query the query string
	 * @return false if the query string is not a number.
	 * @return true if the query string is a number.
	 */
	public static boolean isQuery(String query){
		if (query == null || query.length() == 0) {
			return false;
		}
		
		if (NumberUtils.isCreatable(query) == false) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isCount(String count) {
		if (count == null || count.length() == 0) {
			return false;
		}
		
		if (NumberUtils.isCreatable(count) == false) {
			return false;
		}
		
		if (Integer.valueOf(count) > 1000 || Integer.valueOf(count) <0) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isCost(String cost) {
		if (cost == null || cost.length() == 0) {
			return false;
		}
		
		if (NumberUtils.isCreatable(cost) == false) {
			return false;
		}
		
		if (Integer.valueOf(cost) > 10000 || Integer.valueOf(cost) <0) {
			return false;
		}
		
		return true;
	}
}
