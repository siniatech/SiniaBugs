package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siniatech.siniabugs.dao.IIssueDao;
import com.siniatech.siniabugs.model.Issue;

@Controller
public class IssueController {

    @Autowired
    private IIssueDao issueDao;

    @RequestMapping(value = "/issue")
    public String list( Model model ) {
        model.addAttribute( "issueList", issueDao.listIssue() );
        model.addAttribute( "issue", new Issue() );
        return "issueForm";
    }
}
