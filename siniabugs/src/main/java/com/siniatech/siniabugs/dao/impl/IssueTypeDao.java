package com.siniatech.siniabugs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IIssueTypeDao;
import com.siniatech.siniabugs.model.api.IIssueType;
import com.siniatech.siniautils.collection.ListHelper;

public class IssueTypeDao implements IIssueTypeDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IIssueType> getIssueTypes() {
        return hibernateTemplate.find( "from IssueType" );
    }

    public IIssueType getIssueType( Long id ) {
        List<IIssueType> issueTypes = hibernateTemplate.find( "from IssueType where id = " + id );
        assert issueTypes.size() == 1;
        return ListHelper.head( issueTypes );
    }
}
