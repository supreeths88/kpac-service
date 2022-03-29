package com.kpac.service.entity;

/**
 * className KnowledgePackageSet
 * @version 1.0
 * @author Supreeth
 *
 */
public class KnowledgePackageSet {

	/** the id*/
	private Integer id;
	
	/** the title*/
	private String title;
	
	/** the kpacId*/
	private Integer kpacId;
	
	
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
	 * methodName getKpacId
	 * @return Integer kpacId
	 */
	public Integer getKpacId() {
		return kpacId;
	}
	
	/**
	 * methodName setKpacId
	 * @param kpacId
	 * @return 
	 */
	public void setKpacId(Integer kpacId) {
		this.kpacId = kpacId;
	}

	/**
	 * Constructor
	 */
	public KnowledgePackageSet() {
		super();
	}
}
