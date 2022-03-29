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
import com.kpac.service.entity.KnowledgePackageSet;
import com.kpac.service.repo.KpacSetRepo;

/**
 * className KpacSetService
 * 
 * @version 1.0
 * @author Supreeth
 *
 */
@Service
public class KpacSetService {

	/** the kpacService */
	@Autowired
	private KpacService kpacService;
	
	/** the kpacSetRepo */
	@Autowired
	private KpacSetRepo kpacSetRepo;
	
	/**
	 * get all kpac sets
	 * 
	 * @return
	 */
	public List<KnowledgePackageSet> getAll() {
		return kpacSetRepo.getAllKpacSets();
	}
	
	/**
	 * get kpac set by id
	 * 
	 * @param id
	 * @return
	 */
	public List<KnowledgePackage> getById(int id) {
		List<Integer> KpacIds = kpacSetRepo.getKpacSetById(id).stream().map(KnowledgePackageSet::getKpacId).collect(Collectors.toList());
		return kpacService.getByIds(KpacIds);
	}

	/**
	 * save kpac set to db
	 * 
	 * @param knowledgePackageSet
	 */
	public void save(KnowledgePackageSet knowledgePackageSet) {
		if (null != knowledgePackageSet) {
			kpacSetRepo.save(knowledgePackageSet);
		}
	}

	/**
	 * delete kpac set
	 * 
	 * @param id
	 */
	public void delete(int id) {
		kpacSetRepo.delete(id);
	}

	/**
	 * filter and sort kpac set
	 * 
	 * @param filterAndSort
	 * @return
	 */
	public List<KnowledgePackageSet> filterAndSortBy(FilterAndSort filterAndSort) {
		List<KnowledgePackageSet> list = kpacSetRepo.getAllKpacSets()
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
	private Comparator<? super KnowledgePackageSet> sort(FilterAndSort filterAndSort) {
		return (k1, k2) -> FilterAndSortUtil.byField(filterAndSort.getSortByField(), k1).compareTo(FilterAndSortUtil.byField(filterAndSort.getSortByField(), k2));
	}
}
