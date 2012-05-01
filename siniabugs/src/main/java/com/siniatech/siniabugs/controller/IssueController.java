package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siniatech.siniabugs.dao.api.IIssueDao;
import com.siniatech.siniabugs.model.current.Issue;

@Controller
public class IssueController {

    @Autowired
    private IIssueDao issueDao;

    @RequestMapping(value = "/issue/add", method = RequestMethod.GET)
    public String listIssues( Model model ) {
        model.addAttribute( "issue", new Issue() );
        return "createIssue";
    }

    @RequestMapping(value = "/issue/add", method = RequestMethod.POST)
    public String createIssue( @ModelAttribute Issue issue, Model model ) {
        issueDao.saveIssue( issue );
        model.addAttribute( "issue", issue );
        return "viewIssue";
    }
    
    @RequestMapping(value = "/issue", method = RequestMethod.GET)
    public String listIssuesold( Model model ) {
        model.addAttribute( "issueList", issueDao.listIssues() );
        model.addAttribute( "issue", new Issue() );
        return "issueForm";
    }
    
    @RequestMapping(value = "/issue", method = RequestMethod.POST)
    public String addIssueold( @ModelAttribute Issue issue, Model model ) {
        issueDao.saveIssue( issue );
        model.addAttribute( "issueList", issueDao.listIssues() );
        model.addAttribute( "issue", new Issue() );
        return "issueForm";
    }
}
