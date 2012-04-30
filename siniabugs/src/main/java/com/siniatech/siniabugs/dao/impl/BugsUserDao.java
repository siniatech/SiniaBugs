package com.siniatech.siniabugs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniautils.collection.ListHelper;

public class BugsUserDao implements IBugsUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IBugsUser> getBugsUsers() {
        return hibernateTemplate.find( "from BugsUser" );
    }

    public IBugsUser getBugsUser( Long id ) {
        List<IBugsUser> users = hibernateTemplate.find( "from BugsUser where id = " + id );
        assert users.size() == 1;
        return ListHelper.head( users );
    }

    public List<IBugsUser> getHistoryForBugsUser( Long id ) {
        List<IBugsUser> users = new ArrayList<IBugsUser>();
        users.addAll( hibernateTemplate.find( "from BugsUser where id = " + id ) );
        users.addAll( hibernateTemplate.find( "from BugsUserHistory where id = " + id + " order by end desc" ) );
        return users;
    }
}
