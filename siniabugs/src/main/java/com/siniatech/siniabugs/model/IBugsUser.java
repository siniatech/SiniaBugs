package com.siniatech.siniabugs.model;

public interface IBugsUser extends IModelObject {

    Long getId();

    void setId( Long id );

    Long getUid();

    void setUid( Long uid );

    String getFirstName();

    void setFirstName( String firstName );

    String getSurname();

    void setSurname( String surname );

}