package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siniatech.siniabugs.dao.IIssueTypeDao;
import com.siniatech.siniabugs.model.IssueType;

@Controller
public class IssueTypeController {

    @Autowired
    private IIssueTypeDao issueTypeDao;

    @RequestMapping(value = "/issueType", method = RequestMethod.GET)
    public String listIssues( Model model ) {
        model.addAttribute( "issueTypeList", issueTypeDao.listIssueTypes() );
        model.addAttribute( "issueType", new IssueType() );
        return "issueTypeList";
    }

}
