package com.siniatech.siniabugs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.model.IssueStatus;
import com.siniatech.siniautils.collection.ListHelper;

public class IssueStatusDao implements IIssueStatusDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IssueStatus> getIssueStatuses() {
        return hibernateTemplate.find( "from IssueStatus" );
    }

    public IssueStatus getIssueStatus( Long id ) {
        List<IssueStatus> issueStatuses = hibernateTemplate.find( "from IssueStatus where id = " + id );
        assert issueStatuses.size() == 1;
        return ListHelper.head( issueStatuses );
    }
}
