package com.siniatech.siniabugs.model.current;

import com.siniatech.siniabugs.model.api.IBugsUser;

abstract public class ModelObject {

    abstract public BugsUser getCreatedBy();

    abstract public void setCreatedBy( BugsUser createdBy );

    abstract public BugsUser getEditedBy();

    abstract public void setEditedBy( BugsUser editedBy );

    public IBugsUser getCreator() {
        return getCreatedBy();
    }

    public void setCreator( IBugsUser creator ) {
        assert !creator.isHistorical();
        setCreatedBy( (BugsUser) creator );
    }

    public IBugsUser getLastEditor() {
        return getEditedBy();
    }

    public void setLastEditor( IBugsUser lastEditor ) {
        assert !lastEditor.isHistorical();
        setCreatedBy( (BugsUser) lastEditor );
    }
}
