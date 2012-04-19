package com.siniatech.siniabugs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.model.BugsUser;
import com.siniatech.siniautils.collection.ListHelper;

public class BugsUserDao implements IBugsUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<BugsUser> getBugsUsers() {
        return hibernateTemplate.find( "from BugsUser" );
    }

    public BugsUser getBugsUser( Long id ) {
        List<BugsUser> users = hibernateTemplate.find( "from BugsUser where id = " + id );
        assert users.size() == 1;
        return ListHelper.head( users );
    }
}
