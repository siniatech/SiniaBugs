package com.siniatech.siniabugs.dao.api;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IModelObject;

public interface IModelObjectDao<T extends IModelObject> {

    // should these be exposed or internalised?
    T newInstance();

    T newInstanceHistorical();

    T copy( T t );

    //

    void create( T t, IBugsUser createdBy );

    void delete( T t, IBugsUser deletedBy );

    void update( T t, IBugsUser updatedBy );

    T readByUid( Long uid );
    
    T readById( Long id );

}
