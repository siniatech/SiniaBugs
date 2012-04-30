package com.siniatech.siniabugs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IIssueStatusDao;
import com.siniatech.siniabugs.model.api.IIssueStatus;
import com.siniatech.siniautils.collection.ListHelper;

public class IssueStatusDao implements IIssueStatusDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IIssueStatus> getIssueStatuses() {
        return hibernateTemplate.find( "from IssueStatus" );
    }

    public IIssueStatus getIssueStatus( Long id ) {
        List<IIssueStatus> issueStatuses = hibernateTemplate.find( "from IssueStatus where id = " + id );
        assert issueStatuses.size() == 1;
        return ListHelper.head( issueStatuses );
    }
    
    public List<IIssueStatus> getHistoryForIssueStatus( Long id ) {
        List<IIssueStatus> users = new ArrayList<IIssueStatus>();
        users.addAll( hibernateTemplate.find( "from IssueStatus where id = " + id ) );
        users.addAll( hibernateTemplate.find( "from IssueStatusHistory where id = " + id + " order by end desc" ) );
        return users;
    }
}
