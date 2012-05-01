package com.siniatech.siniabugs.model.abs;

import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.api.IIssue;
import com.siniatech.siniabugs.model.api.IIssueStatus;
import com.siniatech.siniabugs.model.api.IIssueType;
import com.siniatech.siniabugs.model.api.IPriority;
import com.siniatech.siniabugs.model.api.IProject;
import com.siniatech.siniabugs.model.api.IRelease;
import com.siniatech.siniabugs.model.api.ISeverity;
import com.siniatech.siniabugs.model.current.BugsUser;
import com.siniatech.siniabugs.model.current.IssueStatus;
import com.siniatech.siniabugs.model.current.IssueType;
import com.siniatech.siniabugs.model.current.Priority;
import com.siniatech.siniabugs.model.current.Project;
import com.siniatech.siniabugs.model.current.Release;
import com.siniatech.siniabugs.model.current.Severity;

abstract public class AbstractIssue extends ModelObject implements IIssue {

    abstract public BugsUser getAssignedTo();

    abstract public void setAssignedTo( BugsUser assignedTo );

    public IBugsUser getAssignee() {
        return getAssignedTo();
    }

    public void setAssignee( IBugsUser assignee ) {
        assert !assignee.isHistorical();
        setAssignedTo( (BugsUser) assignee );
    }

    abstract public Project getProjectRaw();

    abstract public void setProjectRaw( Project project );

    public IProject getProject() {
        return getProjectRaw();
    }

    public void setProject( IProject project ) {
        assert !project.isHistorical();
        setProjectRaw( (Project) project );
    }

    abstract public Release getReleaseRaw();

    abstract public void setReleaseRaw( Release release );

    public IRelease getRelease() {
        return getReleaseRaw();
    }

    public void setRelease( IRelease release ) {
        assert !release.isHistorical();
        setReleaseRaw( (Release) release );
    }

    abstract public IssueType getIssueType();

    abstract public void setIssueType( IssueType issueType );

    public IIssueType getType() {
        return getIssueType();
    }

    public void setType( IIssueType issueType ) {
        assert !issueType.isHistorical();
        setIssueType( (IssueType) issueType );
    }

    abstract public IssueStatus getIssueStatus();

    abstract public void setIssueStatus( IssueStatus issueStatus );

    public IIssueStatus getStatus() {
        return getIssueStatus();
    }

    public void setStatus( IIssueStatus issueStatus ) {
        assert !issueStatus.isHistorical();
        setIssueStatus( (IssueStatus) issueStatus );
    }

    abstract public Priority getPriorityRaw();

    abstract public void setPriorityRaw( Priority priority );

    public IPriority getPriority() {
        return getPriorityRaw();
    }

    public void setPriority( IPriority priority ) {
        assert !priority.isHistorical();
        setPriorityRaw( (Priority) priority );
    }

    abstract public Severity getSeverityRaw();

    abstract public void setSeverityRaw( Severity severity );

    public ISeverity getSeverity() {
        return getSeverityRaw();
    }

    public void setSeverity( ISeverity severity ) {
        assert !severity.isHistorical();
        setSeverityRaw( (Severity) severity );
    }
}
