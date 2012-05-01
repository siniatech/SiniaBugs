package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.ISeverityDao;

@Controller
public class SeverityController {

    @Autowired
    private ISeverityDao severityDao;

    @RequestMapping(value = "/severity", method = RequestMethod.GET)
    public String getSeverity( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "severity", severityDao.getSeverity( longId ) );
            return "severity";
        } catch ( NumberFormatException e ) {
            return "severity";
        }
    }

    @RequestMapping(value = "/severities", method = RequestMethod.GET)
    public String getSeverities( Model model ) {
        model.addAttribute( "severities", severityDao.getSeverities() );
        return "severities";
    }

}
