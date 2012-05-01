package com.siniatech.siniabugs.model.api;

import org.joda.time.DateTime;

public interface IRelease extends IModelObject {

    DateTime getReleaseStart();

    void setReleaseStart( DateTime start );

    DateTime getReleaseEnd();

    void setReleaseEnd( DateTime end );
}
