package com.siniatech.siniabugs.model;

import java.sql.Date;

abstract public class ModelObject {

    abstract public Date getStart();

    abstract public void setStart( Date start );

    abstract public Date getEnd();

    abstract public void setEnd( Date end );

    abstract public BugsUser getCreatedBy();

    abstract public void setCreatedBy( BugsUser createdBy );

    abstract public BugsUser getEditedBy();

    abstract public void setEditedBy( BugsUser editedBy );

}
