package com.siniatech.siniabugs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_TYPE")
public class IssueType {

    private Long id;
    private String shortCode;
    private String name;
    private Date start;
    private Date end;
    private BugsUser createdBy;
    private BugsUser editedBy;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
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
    public Date getStart() {
        return start;
    }

    public void setStart( Date start ) {
        this.start = start;
    }

    @Column(name = "end")
    public Date getEnd() {
        return end;
    }

    public void setEnd( Date end ) {
        this.end = end;
    }

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    public BugsUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( BugsUser createdBy ) {
        this.createdBy = createdBy;
    }

    @ManyToOne
    @JoinColumn(name = "edited_by_id")
    public BugsUser getEditedBy() {
        return editedBy;
    }

    public void setEditedBy( BugsUser editedBy ) {
        this.editedBy = editedBy;
    }

}
