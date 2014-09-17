package edu.uoa.estia.controllers;

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
import edu.uoa.estia.service.SearchService;

@Controller
@RequestMapping("/services/search")
public class SearchController {

    private static Logger LOG = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

    @RequestMapping( method = RequestMethod.GET, value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Akinita> getAll() {
        return searchService.findAll();
    }
    
}
