package com.java89.springbootwebappcrud.sorting;

public class SortParam {
	private String property;
	private boolean accending;

	public SortParam(String property, boolean accending) {
		this.property = property;
		this.accending = accending;
	}

	public String getProperty() {
		return property;
	}

	public boolean isAccending() {
		return accending;
	}
}
