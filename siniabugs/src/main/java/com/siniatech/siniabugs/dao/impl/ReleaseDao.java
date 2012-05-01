package com.siniatech.siniabugs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IReleaseDao;
import com.siniatech.siniabugs.model.api.IRelease;
import com.siniatech.siniautils.collection.ListHelper;

public class ReleaseDao implements IReleaseDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IRelease> getReleases() {
        return hibernateTemplate.find( "from Release" );
    }

    public IRelease getRelease( Long id ) {
        List<IRelease> issueTypes = hibernateTemplate.find( "from Release where id = " + id );
        assert issueTypes.size() == 1;
        return ListHelper.head( issueTypes );
    }
}
