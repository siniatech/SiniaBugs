package com.siniatech.siniabugs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.model.current.IssueType;
import com.siniatech.siniautils.collection.ListHelper;

public class IssueTypeDao implements IIssueTypeDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IssueType> getIssueTypes() {
        return hibernateTemplate.find( "from IssueType" );
    }

    public IssueType getIssueType( Long id ) {
        List<IssueType> issueTypes = hibernateTemplate.find( "from IssueType where id = " + id );
        assert issueTypes.size() == 1;
        return ListHelper.head( issueTypes );
    }
}
