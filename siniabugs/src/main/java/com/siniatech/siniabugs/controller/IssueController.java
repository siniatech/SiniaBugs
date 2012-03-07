package com.siniatech.siniabugs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.siniatech.siniabugs.dao.IIssueDao;
import com.siniatech.siniabugs.model.Issue;

public class IssueController extends MultiActionController {

    private IIssueDao issueDao;

    public IssueController( IIssueDao issueDao ) {
        this.issueDao = issueDao;
    }

    public ModelAndView add( HttpServletRequest request, HttpServletResponse response, Issue Issue ) throws Exception {
        issueDao.saveIssue( Issue );
        return new ModelAndView( "redirect:list.htm" );
    }

    public ModelAndView list( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute( "IssueList", issueDao.listIssue() );
        modelMap.addAttribute( "Issue", new Issue() );
        return new ModelAndView( "IssueForm", modelMap );
    }
}
