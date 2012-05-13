package com.siniatech.siniabugs.viewModel.impl;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.viewModel.abs.ViewModelObject;
import com.siniatech.siniabugs.viewModel.api.IBugsUserViewModel;

public class BugsUserViewModel extends ViewModelObject<IBugsUser> implements IBugsUserViewModel {

    public BugsUserViewModel( IBugsUser modelObject ) {
        super( modelObject );
    }

    public String getFirstName() {
        return getModelObject().getFirstName();
    }

    public void setFirstName( String firstName ) {
        getModelObject().setFirstName( firstName );
    }

    public String getSurname() {
        return getModelObject().getSurname();
    }

    public void setSurname( String surname ) {
        getModelObject().setSurname( surname );
    }

}
