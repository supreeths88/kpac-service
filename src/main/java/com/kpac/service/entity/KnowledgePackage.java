package com.kpac.service.entity;

import org.springframework.data.annotation.Id;

/**
 * className KnowledgePackage
 * @version 1.0
 * @author Supreeth
 *
 */
public class KnowledgePackage {

	/** the id*/
	@Id
	private Integer id;
	
	/** the title*/
	private String title;
	
	/** the description*/
	private String description;
	
	/** the date*/
	private String date;
	
	
	/**
	 * methodName getId
	 * @return integer id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * methodName setId
	 * @param id
	 * @return 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * methodName getTitle
	 * @return String title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * methodName setTitle
	 * @param title
	 * @return 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * methodName getDescription
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * methodName setDescription
	 * @param description
	 * @return 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * methodName getDate
	 * @return String date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * methodName setDate
	 * @param date
	 * @return 
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Constructor
	 */
	public KnowledgePackage() {
		super();
	}
}
