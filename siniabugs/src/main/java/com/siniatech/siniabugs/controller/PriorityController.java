package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IPriorityDao;

@Controller
public class PriorityController {

    @Autowired
    private IPriorityDao priorityDao;

    @RequestMapping(value = "/priority", method = RequestMethod.GET)
    public String getPriority( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "priority", priorityDao.getPriority( longId ) );
            return "priority";
        } catch ( NumberFormatException e ) {
            return "priority";
        }
    }

    @RequestMapping(value = "/priorities", method = RequestMethod.GET)
    public String getPriorities( Model model ) {
        model.addAttribute( "priorities", priorityDao.getPriorities() );
        return "priorities";
    }

}
