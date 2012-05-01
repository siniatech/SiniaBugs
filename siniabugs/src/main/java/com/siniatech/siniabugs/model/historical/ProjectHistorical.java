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
import com.siniatech.siniabugs.model.api.IProject;
import com.siniatech.siniabugs.model.current.BugsUser;

@Entity
@Table(name = "PROJECT_HISTORY")
public class ProjectHistorical extends ModelObject implements IProject {

    private Long id;
    private String shortCode;
    private String name;
    private DateTime start;
    private DateTime end;
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

    @Column(name = "short_code")
    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode( String shortCode ) {
        this.shortCode = shortCode;
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
