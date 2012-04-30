package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IIssueStatusDao;

@Controller
public class IssueStatusController {

    @Autowired
    private IIssueStatusDao issueStatusDao;

    @RequestMapping(value = "/issueStatus", method = RequestMethod.GET)
    public String getIssueStatus( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "issueStatus", issueStatusDao.getIssueStatus( longId ) );
            return "issueStatus";
        } catch ( NumberFormatException e ) {
            return "issueStatus";
        }
    }

    @RequestMapping(value = "/issueStatuses", method = RequestMethod.GET)
    public String getIssuesStatuss( Model model ) {
        model.addAttribute( "issueStatuses", issueStatusDao.getIssueStatuses() );
        return "issueStatuses";
    }

}
