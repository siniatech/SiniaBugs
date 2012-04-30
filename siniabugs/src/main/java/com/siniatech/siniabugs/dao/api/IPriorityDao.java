package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IPriority;

public interface IPriorityDao {

    List<IPriority> getPriorities();

    IPriority getPriority( Long id );

}
