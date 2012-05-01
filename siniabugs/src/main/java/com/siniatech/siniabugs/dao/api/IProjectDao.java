package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IProject;

public interface IProjectDao {

    List<IProject> getProjects();

    IProject getProject( Long id );
}
