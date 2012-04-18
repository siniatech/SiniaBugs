package com.siniatech.siniabugs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.model.IssueType;

public class IssueTypeDao implements IIssueTypeDao {

    private HibernateTemplate hibernateTemplate;

    public IssueTypeDao( SessionFactory sessionFactory ) {
        this.hibernateTemplate = new HibernateTemplate( sessionFactory );
    }

    public List<IssueType> listIssueTypes() {
        return hibernateTemplate.find( "from IssueType" );
    }

}
