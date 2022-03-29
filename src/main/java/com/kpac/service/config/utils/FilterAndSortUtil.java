package com.kpac.service.config.utils;

import com.kpac.service.entity.KnowledgePackage;
import com.kpac.service.entity.KnowledgePackageSet;

/**
 * className FilterAndSortUtil
 * @version 1.0
 * @author Supreeth
 *
 */
public class FilterAndSortUtil {

	/**
	 * @param filterByField
	 * @param kpac
	 * @return string
	 */ 
	public static String byField(String filterByField, KnowledgePackage kpac) {
		
		switch (filterByField) {
		case "Id":
			return kpac.getId().toString();
		case "Title":
			return kpac.getTitle();
		case "Description":
			return kpac.getDescription();
		case "Date":
			return kpac.getDate();
		default:
			break;
		}
		return null;
	}
	
	/**
	 * @param filterByField
	 * @param kpacSet
	 * @return string
	 */ 
	public static String byField(String filterByField, KnowledgePackageSet kpacSet) {
		
		switch (filterByField) {
		case "Id":
			return kpacSet.getId().toString();
		case "Title":
			return kpacSet.getTitle();
		default:
			break;
		}
		return null;
	}
}
