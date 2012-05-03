package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IBugsUser;

public interface IBugsUserDao extends IModelObjectDao<IBugsUser> {

    List<IBugsUser> getBugsUsers();

    IBugsUser readById( Long id );

    List<IBugsUser> getHistoryForBugsUser( Long id );

}
