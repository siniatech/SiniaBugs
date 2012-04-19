package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.IIssueTypeDao;

@Controller
public class IssueTypeController {

    @Autowired
    private IIssueTypeDao issueTypeDao;

    @RequestMapping(value = "/issueType", method = RequestMethod.GET)
    public String getIssueType( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "issueType", issueTypeDao.getIssueType( longId ) );
            return "issueType";
        } catch ( NumberFormatException e ) {
            return "issueType";
        }
    }

    @RequestMapping(value = "/issueTypes", method = RequestMethod.GET)
    public String getIssuesTypes( Model model ) {
        model.addAttribute( "issueTypes", issueTypeDao.getIssueTypes() );
        return "issueTypes";
    }

}
