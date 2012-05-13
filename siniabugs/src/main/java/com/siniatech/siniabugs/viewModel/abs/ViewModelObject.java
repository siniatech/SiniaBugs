package com.siniatech.siniabugs.viewModel.abs;

import org.joda.time.DateTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IModelObject;
import com.siniatech.siniabugs.viewModel.api.IViewModelObject;

public class ViewModelObject<MO extends IModelObject> implements IViewModelObject<MO> {

    private final MO modelObject;

    protected ViewModelObject( MO modelObject ) {
        this.modelObject = modelObject;
    }

    protected MO getModelObject() {
        return modelObject;
    }

    public String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println( auth.getPrincipal() );
        System.out.println( auth.getAuthorities() );
        System.out.println( auth.getCredentials() );
        System.out.println( auth.getDetails() );
        System.out.println( auth.getName() );
        return auth.getName();
    }

    public Long getId() {
        return getModelObject().getId();
    }

    public void setId( Long id ) {
        getModelObject().setId( id );
    }

    public Long getUid() {
        return getModelObject().getUid();
    }

    public void setUid( Long uid ) {
        getModelObject().setUid( uid );
    }

    public boolean isHistorical() {
        return getModelObject().isHistorical();
    }

    public DateTime getVersionStart() {
        return getModelObject().getVersionStart();
    }

    public void setVersionStart( DateTime start ) {
        getModelObject().setVersionStart( start );
    }

    public DateTime getVersionEnd() {
        return getModelObject().getVersionEnd();
    }

    public void setVersionEnd( DateTime end ) {
        getModelObject().setVersionEnd( end );
    }

    public IBugsUser getCreator() {
        return getModelObject().getCreator();
    }

    public void setCreator( IBugsUser creator ) {
        getModelObject().setCreator( creator );
    }

    public IBugsUser getLastEditor() {
        return getModelObject().getLastEditor();
    }

    public void setLastEditor( IBugsUser lastEditor ) {
        getModelObject().setLastEditor( lastEditor );
    }

    public String getName() {
        return getModelObject().getName();
    }

}
