package com.siniatech.siniabugs.model.historical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.siniatech.siniabugs.model.abs.ModelObject;
import com.siniatech.siniabugs.model.api.IRelease;
import com.siniatech.siniabugs.model.current.BugsUser;

@Entity
@Table(name = "PROJECT_RELEASE_HISTORY")
public class ReleaseHistorical extends ModelObject implements IRelease {

    private Long id;
    private String name;
    private DateTime start;
    private DateTime end;
    private DateTime release_start;
    private DateTime release_end;
    private BugsUser createdBy;
    private BugsUser editedBy;
    private Long uid;

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Id
    @Column(name = "uid")
    public Long getUid() {
        return uid;
    }

    public void setUid( Long uid ) {
        this.uid = uid;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Column(name = "start")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getVersionStart() {
        return start;
    }

    public void setVersionStart( DateTime start ) {
        this.start = start;
    }

    @Column(name = "end")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getVersionEnd() {
        return end;
    }

    public void setVersionEnd( DateTime end ) {
        this.end = end;
    }

    @Column(name = "release_start")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getReleaseStart() {
        return release_start;
    }

    public void setReleaseStart( DateTime start ) {
        this.release_start = start;
    }

    @Column(name = "release_end")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getReleaseEnd() {
        return release_end;
    }

    public void setReleaseEnd( DateTime end ) {
        this.release_end = end;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "created_by_id")
    public BugsUser getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy( BugsUser createdBy ) {
        this.createdBy = createdBy;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "edited_by_id")
    public BugsUser getEditedBy() {
        return editedBy;
    }

    @Override
    public void setEditedBy( BugsUser editedBy ) {
        this.editedBy = editedBy;
    }

    @Transient
    public boolean isHistorical() {
        return true;
    }

}
