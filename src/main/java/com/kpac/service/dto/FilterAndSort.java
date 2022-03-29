package com.kpac.service.dto;

/**
 * className FilterAndSort
 * @version 1.0
 * @author Supreeth
 *
 */
public class FilterAndSort {

	/** the filterByField*/
	private String filterByField;
	
	/** the filterByValue*/
	private String filterByValue;
	
	/** the sortByField*/
	private String sortByField;
	
	/** the orderByValue*/
	private String orderByValue; //ASC or DESC

	/**
	 * methodName getFilterByField
	 * @return string filterByField
	 */
	public String getFilterByField() {
		return filterByField;
	}

	/**
	 * methodName setFilterByField
	 * @param filterByField
	 * @return 
	 */
	public void setFilterByField(String filterByField) {
		this.filterByField = filterByField;
	}

	/**
	 * methodName getFilterByValue
	 * @return string filterByValue
	 */
	public String getFilterByValue() {
		return filterByValue;
	}

	/**
	 * methodName setFilterByValue
	 * @param filterByValue
	 * @return 
	 */
	public void setFilterByValue(String filterByValue) {
		this.filterByValue = filterByValue;
	}
	
	/**
	 * methodName getSortByField
	 * @return string sortByField
	 */
	public String getSortByField() {
		return sortByField;
	}

	/**
	 * methodName setSortByField
	 * @param sortByField
	 * @return 
	 */
	public void setSortByField(String sortByField) {
		this.sortByField = sortByField;
	}

	/**
	 * methodName getOrderByValue
	 * @return string orderByValue
	 */
	public String getOrderByValue() {
		return orderByValue;
	}

	/**
	 * methodName setOrderByValue
	 * @param orderByValue
	 * @return 
	 */
	public void setOrderByValue(String orderByValue) {
		this.orderByValue = orderByValue;
	}

	/**
	 * Constructor
	 */
	public FilterAndSort() {
		super();
	}
}
