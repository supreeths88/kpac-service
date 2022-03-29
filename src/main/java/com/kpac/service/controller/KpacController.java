package com.kpac.service.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kpac.service.dto.FilterAndSort;
import com.kpac.service.entity.KnowledgePackage;
import com.kpac.service.entity.KnowledgePackageSet;
import com.kpac.service.service.KpacService;
import com.kpac.service.service.KpacSetService;

/**
 * className KpacController
 * @version 1.0
 * @author Supreeth
 *
 */

@Controller
public class KpacController {

	/** the kpacService*/
	@Autowired
	KpacService kpacService;
	
	/** the kpacSetService*/
	@Autowired
	KpacSetService kpacSetService;
	
	/**
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String kpacs(HttpServletResponse response) throws IOException {
		return "index";
	}
	
	/**
	 * Get Kpacs 
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value="/kpacs")
	public String getAllKpacs(Model model) throws IOException {
		List<KnowledgePackage> knowledgePackageList = kpacService.getAll();  
		model.addAttribute("knowledgePackageList",knowledgePackageList);
        return "kpacs"; 
	}
	
	/**
	 * 
	 * save Kpac 
	 * 
	 * @param knowledgePackage
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, value="/kpac")
	public String addKpac(@ModelAttribute("knowledgePackage") final KnowledgePackage knowledgePackage) throws IOException {
		kpacService.save(knowledgePackage);  
		return "redirect:/kpacs";
	}
	
    /**
     * Delete Kpac
     * 
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value="/kpac/delete/{id}")  
    public String deleteKpac(@PathVariable(value = "id") final int id) {  
    	kpacService.delete(id);  
        return "redirect:/kpacs";  
    }
    
    /**
     * Filter and sort kpacs
     * 
     * @param model
     * @param filterAndSort
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST, value="/kpacs")
	public String filterAndSortBy(Model model, @ModelAttribute("filterAndSort") final FilterAndSort filterAndSort) throws IOException {
		List<KnowledgePackage> knowledgePackageList = kpacService.filterAndSortBy(filterAndSort);  
		model.addAttribute("knowledgePackageList",knowledgePackageList);
        return "kpacs"; 
	}
    
    /**
     * Get all Kpac sets
     * 
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET, value="/sets")
	public String getAllKpacSets(Model model) throws IOException {
		List<KnowledgePackageSet> knowledgePackageSets = kpacSetService.getAll();  
		model.addAttribute("knowledgePackageSets",knowledgePackageSets);
		List<KnowledgePackage> knowledgePackageList = kpacService.getAll();  
		model.addAttribute("knowledgePackageList",knowledgePackageList);
        return "sets"; 
	}
    
    /**
     * Get Kpac set by Id
     * 
     * @param model
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET, value="/set/{id}")
   	public String getAllKpacSetsById(Model model, @PathVariable(value = "id") final int id) throws IOException {
   		List<KnowledgePackage> knowledgePackages = kpacSetService.getById(id);  
   		model.addAttribute("knowledgePackages",knowledgePackages);
        return "setById"; 
   	}
    
    /**
     * save kpac set 
     * 
     * @param knowledgePackageSet
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST, value="/set")
	public String addKpacSet(@ModelAttribute("knowledgePackage") final KnowledgePackageSet knowledgePackageSet) throws IOException {
    	kpacSetService.save(knowledgePackageSet);  
		return "redirect:/sets";
	}
    
    /**
     * delete kpac set
     * 
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value="/set/delete/{id}")  
    public String deleteKpacSet(@PathVariable(value = "id") final int id) {  
    	kpacSetService.delete(id);  
        return "redirect:/sets";  
    }
    
    /**
     * filter and sort kpac set
     * 
     * @param model
     * @param filterAndSort
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST, value="/sets")
	public String filterAndSortSets(Model model, @ModelAttribute("filterAndSort") final FilterAndSort filterAndSort) throws IOException {
		List<KnowledgePackageSet> knowledgePackageSets = kpacSetService.filterAndSortBy(filterAndSort);  
		model.addAttribute("knowledgePackageSets", knowledgePackageSets);
		List<KnowledgePackage> knowledgePackageList = kpacService.getAll();  
		model.addAttribute("knowledgePackageList",knowledgePackageList);
        return "sets"; 
	}
}
