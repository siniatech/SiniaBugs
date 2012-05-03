package com.siniatech.siniabugs.dao.api;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IModelObject;

public interface IModelObjectDao<T extends IModelObject> {

    T newInstance();

    void save( T t, IBugsUser user );
    
    void delete( T t, IBugsUser deletedBy );


}
