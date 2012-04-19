package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.BugsUser;

public interface IBugsUserDao {

    List<BugsUser> getBugsUsers();

    BugsUser getBugsUser( Long id );
}
