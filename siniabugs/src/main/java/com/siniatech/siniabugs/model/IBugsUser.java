package com.siniatech.siniabugs.model;

import java.sql.Date;

public interface IBugsUser {

    Long getId();

    void setId( Long id );

    Long getUid();

    void setUid( Long uid );

    String getFirstName();

    void setFirstName( String firstName );

    String getSurname();

    void setSurname( String surname );

    Date getStart();

    void setStart( Date start );

    Date getEnd();

    void setEnd( Date end );

    BugsUser getCreatedBy();

    void setCreatedBy( BugsUser createdBy );

    BugsUser getEditedBy();

    void setEditedBy( BugsUser editedBy );

}