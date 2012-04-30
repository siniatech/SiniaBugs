package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IBugsUser;

public interface IBugsUserDao {

    List<IBugsUser> getBugsUsers();

    IBugsUser getBugsUser( Long id );

    List<IBugsUser> getHistoryForBugsUser( Long id );
}
