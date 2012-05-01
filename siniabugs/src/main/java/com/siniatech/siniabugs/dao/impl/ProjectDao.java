package com.siniatech.siniabugs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.siniatech.siniabugs.dao.api.IProjectDao;
import com.siniatech.siniabugs.model.api.IProject;
import com.siniatech.siniautils.collection.ListHelper;

public class ProjectDao implements IProjectDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<IProject> getProjects() {
        return hibernateTemplate.find( "from Project" );
    }

    public IProject getProject( Long id ) {
        List<IProject> projects = hibernateTemplate.find( "from Project where id = " + id );
        assert projects.size() == 1;
        return ListHelper.head( projects );
    }
}
