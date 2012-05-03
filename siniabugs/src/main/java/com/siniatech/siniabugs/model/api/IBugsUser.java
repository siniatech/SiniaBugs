package com.siniatech.siniabugs.model.api;


public interface IBugsUser extends IModelObject {

    String getFirstName();

    void setFirstName( String firstName );

    String getSurname();

    void setSurname( String surname );

}