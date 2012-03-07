package com.siniatech.siniabugs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.siniatech.siniabugs.model.Issue;

public class IssueDao implements IIssueDao {

    private HibernateTemplate hibernateTemplate;

    public IssueDao( SessionFactory sessionFactory ) {
        this.hibernateTemplate = new HibernateTemplate( sessionFactory );
    }

    public void saveIssue( Issue issue ) {
        hibernateTemplate.saveOrUpdate( issue );
    }

    public List<Issue> listIssue() {
        return hibernateTemplate.find( "from User" );
    }

}
