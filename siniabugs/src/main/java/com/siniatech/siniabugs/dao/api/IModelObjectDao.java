package com.siniatech.siniabugs.dao.api;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IModelObject;

public interface IModelObjectDao<T extends IModelObject> {

    void save( T t, IBugsUser user );

    T newInstance();

}
