package com.java89.springbootwebappcrud.sorting;

import com.java89.springbootwebappcrud.entity.Customer;

import java.util.HashMap;
import java.util.Map;

public class SortUtils {
	private SortUtils() {
	}
	
	/**
	 * Key:   URL Sort Parameter
	 * Value: Table Column
	 */
	public static Map<String, String> CUSTOMER_ORDER_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 4293312786696007788L;

		{
			put("firstName", Customer.FIRST_NAME);
			put("lastName", Customer.LAST_NAME);
			put("email", Customer.EMAIL);
		}
	};
}
