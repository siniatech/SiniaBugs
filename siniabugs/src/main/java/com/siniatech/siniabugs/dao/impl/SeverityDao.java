package com.siniatech.siniabugs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.ISeverityDao;
import com.siniatech.siniabugs.model.api.ISeverity;
import com.siniatech.siniautils.collection.ListHelper;

public class SeverityDao implements ISeverityDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ISeverity> getSeverities() {
        return hibernateTemplate.find( "from Severity" );
    }

    public ISeverity getSeverity( Long id ) {
        List<ISeverity> priorities = hibernateTemplate.find( "from Severity where id = " + id );
        assert priorities.size() == 1;
        return ListHelper.head( priorities );
    }
}
