package com.siniatech.siniabugs.dao.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IModelObjectDao;
import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IModelObject;

abstract public class ModelObjectDao<T extends IModelObject> implements IModelObjectDao<T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    public void save( T t, IBugsUser savedBy ) {
        t.setUid( 1L);
        t.setCreator( savedBy );
        t.setLastEditor( savedBy );
        t.setVersionStart( new DateTime() );
        hibernateTemplate.saveOrUpdate( t );
    }
}
