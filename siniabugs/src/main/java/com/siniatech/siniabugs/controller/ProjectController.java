package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IProjectDao;

@Controller
public class ProjectController {

    @Autowired
    private IProjectDao projectDao;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String getProject( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "project", projectDao.getProject( longId ) );
            return "project";
        } catch ( NumberFormatException e ) {
            return "project";
        }
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getIssuesTypes( Model model ) {
        model.addAttribute( "projects", projectDao.getProjects() );
        return "projects";
    }

}
