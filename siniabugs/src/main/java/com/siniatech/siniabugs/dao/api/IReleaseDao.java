package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IRelease;

public interface IReleaseDao {

    List<IRelease> getReleases();

    IRelease getRelease( Long id );

}
