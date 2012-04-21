package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.BugsUser;
import com.siniatech.siniabugs.model.IBugsUser;

public interface IBugsUserDao {

    List<BugsUser> getBugsUsers();

    IBugsUser getBugsUser( Long id );
    
    List<IBugsUser> getHistoryForBugsUser( Long id );
}
