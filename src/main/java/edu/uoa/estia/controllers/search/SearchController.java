package edu.uoa.estia.controllers.search;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.uoa.estia.domain.Akinita;
import edu.uoa.estia.domain.Property;
import edu.uoa.estia.service.SearchService;

@Controller
public class SearchController {

    private static Logger LOG = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

	/**
	 * Renders the home page as HTML in thw web browser.
	 * The home page is different based on whether the user is signed in or not.
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String home(Principal user) {
		return user != null ? "search" : "/";
	}
	
    @RequestMapping( method = RequestMethod.GET, value = "/search/services/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Property> getAll() {
        return searchService.findAll();
    }
    
    
    
}
