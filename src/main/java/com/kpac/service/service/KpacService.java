package com.kpac.service.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpac.service.config.utils.FilterAndSortUtil;
import com.kpac.service.dto.FilterAndSort;
import com.kpac.service.entity.KnowledgePackage;
import com.kpac.service.repo.KpacRepo;

/**
 * className KpacService
 * 
 * @version 1.0
 * @author Supreeth
 *
 */
@Service
public class KpacService {

	/** the kpacRepo */
	@Autowired
	private KpacRepo kpacRepo;

	/**
	 * get all kpacs
	 * 
	 * @return List<KnowledgePackage>
	 */
	public List<KnowledgePackage> getAll() {
		return kpacRepo.getAllKpacs();
	}
	
	/** 
	 * get kpacs by id
	 * 
	 * @param ids
	 * @return
	 */
	public List<KnowledgePackage> getByIds(List<Integer> ids) {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		ids.forEach(id -> builder.append(id).append(","));
		builder.deleteCharAt(builder.length() - 1);
		builder.append(")");
		return kpacRepo.getKpacsByIds(builder.toString());
	}

	/**
	 * save kpac to db
	 * 
	 * @param knowledgePackage
	 */
	public void save(KnowledgePackage knowledgePackage) {
		if (null != knowledgePackage) {
			kpacRepo.save(knowledgePackage);
		}
	}

	/**
	 * delete kpac
	 * 
	 * @param id
	 */
	public void delete(int id) {
		kpacRepo.delete(id);
	}

	/**
	 * filter and sort 
	 * @param filterAndSort
	 * @return
	 */
	public List<KnowledgePackage> filterAndSortBy(FilterAndSort filterAndSort) {
		List<KnowledgePackage> list = kpacRepo.getAllKpacs()
				.stream()
				.filter(kpac -> FilterAndSortUtil.byField(filterAndSort.getFilterByField(),kpac).equalsIgnoreCase(filterAndSort.getFilterByValue()))
				.sorted(sort(filterAndSort))
				.collect(Collectors.toList());
		
		if ("DESC".equalsIgnoreCase(filterAndSort.getOrderByValue())) {
			Collections.reverse(list);
		}
		
		return list;
	}

	/**
	 * @param filterAndSort
	 * @return
	 */
	private Comparator<? super KnowledgePackage> sort(FilterAndSort filterAndSort) {
		return (k1, k2) -> FilterAndSortUtil.byField(filterAndSort.getSortByField(), k1).compareTo(FilterAndSortUtil.byField(filterAndSort.getSortByField(), k2));
	}
}
