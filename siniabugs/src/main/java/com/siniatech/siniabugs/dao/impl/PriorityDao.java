package com.siniatech.siniabugs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IPriorityDao;
import com.siniatech.siniabugs.model.api.IPriority;
import com.siniatech.siniautils.collection.ListHelper;

public class PriorityDao implements IPriorityDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IPriority> getPriorities() {
        return hibernateTemplate.find( "from Priority" );
    }

    public IPriority getPriority( Long id ) {
        List<IPriority> priorities = hibernateTemplate.find( "from Priority where id = " + id );
        assert priorities.size() == 1;
        return ListHelper.head( priorities );
    }
}
