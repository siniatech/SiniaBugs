package com.siniatech.siniabugs.model;

import org.joda.time.DateTime;

public interface IModelObject {

    Long getId();

    void setId( Long id );

    Long getUid();

    void setUid( Long uid );

    boolean isHistorical();

    DateTime getVersionStart();

    void setVersionStart( DateTime start );

    DateTime getVersionEnd();

    void setVersionEnd( DateTime end );

    IBugsUser getCreator();

    void setCreator( IBugsUser creator );

    IBugsUser getLastEditor();

    void setLastEditor( IBugsUser lastEditor );

}
