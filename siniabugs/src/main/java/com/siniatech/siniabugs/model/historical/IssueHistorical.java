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

import com.siniatech.siniabugs.model.abs.AbstractIssue;
import com.siniatech.siniabugs.model.api.IIssue;
import com.siniatech.siniabugs.model.current.BugsUser;
import com.siniatech.siniabugs.model.current.IssueStatus;
import com.siniatech.siniabugs.model.current.IssueType;
import com.siniatech.siniabugs.model.current.Priority;
import com.siniatech.siniabugs.model.current.Project;
import com.siniatech.siniabugs.model.current.Release;
import com.siniatech.siniabugs.model.current.Severity;

@Entity
@Table(name = "ISSUE_HISTORY")
public class IssueHistorical extends AbstractIssue implements IIssue {

    private Long id;
    private String name;
    private String description;
    private Long uid;
    private DateTime end;
    private DateTime start;
    private BugsUser createdBy;
    private BugsUser editedBy;
    private BugsUser assignedTo;
    private Project project;
    private Release release;
    private Double estimate;
    private Double done;
    private Severity severity;
    private Priority priority;
    private IssueType issueType;
    private IssueStatus issueStatus;

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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
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
    @JoinColumn(name = "assigned_to_id")
    public BugsUser getAssignedTo() {
        return assignedTo;
    }

    @Override
    public void setAssignedTo( BugsUser assignedTo ) {
        this.assignedTo = assignedTo;
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

    @Override
    @ManyToOne
    @JoinColumn(name = "project_id")
    public Project getProjectRaw() {
        return project;
    }

    @Override
    public void setProjectRaw( Project project ) {
        this.project = project;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "release_id")
    public Release getReleaseRaw() {
        return release;
    }

    @Override
    public void setReleaseRaw( Release release ) {
        this.release = release;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "priority_id")
    public Priority getPriorityRaw() {
        return priority;
    }

    @Override
    public void setPriorityRaw( Priority priority ) {
        this.priority = priority;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "issueType_id")
    public IssueType getIssueType() {
        return issueType;
    }

    @Override
    public void setIssueType( IssueType issueType ) {
        this.issueType = issueType;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "issueStatus_id")
    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    @Override
    public void setIssueStatus( IssueStatus issueStatus ) {
        this.issueStatus = issueStatus;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "severity_id")
    public Severity getSeverityRaw() {
        return severity;
    }

    @Override
    public void setSeverityRaw( Severity severity ) {
        this.severity = severity;
    }

    @Transient
    public boolean isHistorical() {
        return true;
    }

    @Column(name = "estimate")
    public Double getEstimate() {
        return estimate;
    }

    public void setEstimate( Double estimate ) {
        this.estimate = estimate;
    }

    @Column(name = "done")
    public Double getDone() {
        return done;
    }

    public void setDone( Double done ) {
        this.done = done;
    }

}
