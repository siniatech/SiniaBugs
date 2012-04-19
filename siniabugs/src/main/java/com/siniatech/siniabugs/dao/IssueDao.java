package com.siniatech.siniabugs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.model.Issue;

public class IssueDao implements IIssueDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveIssue( Issue issue ) {
        hibernateTemplate.saveOrUpdate( issue );
    }

    public List<Issue> listIssues() {
        return hibernateTemplate.find( "from Issue" );
    }

}
