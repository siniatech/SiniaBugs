package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.Priority;

public interface IPriorityDao {

    List<Priority> getPriorities();

    Priority getPriority( Long id );
    
    // need an identifier field in addition to the guid field
}
