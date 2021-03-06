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

import edu.uoa.estia.domain.Property;
import edu.uoa.estia.service.PropertyManagementService;

@Controller
@RequestMapping("/services/properties")
public class PropertyManagementController {

	private static Logger LOG = LoggerFactory.getLogger(PropertyManagementController.class);

    @Autowired
    private PropertyManagementService propertyService;

    @RequestMapping( method = RequestMethod.GET, value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Property> getAllProperties() {
        return propertyService.findAll();
    }
}
