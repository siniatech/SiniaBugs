package com.siniatech.siniabugs.model.api;

public interface IIssue extends IModelObject {

    IBugsUser getAssignee();

    void setAssignee( IBugsUser assignee );

    IProject getProject();

    void setProject( IProject project );

    IRelease getRelease();

    void setRelease( IRelease release );

    String getDescription();

    void setDescription( String description );

    Double getEstimate();

    void setEstimate( Double estimate );

    Double getDone();

    void setDone( Double done );

    IPriority getPriority();

    void setPriority( IPriority priority );

    ISeverity getSeverity();

    void setSeverity( ISeverity severity );

    IIssueType getType();

    void setType( IIssueType issueType );

    IIssueStatus getStatus();

    void setStatus( IIssueStatus issueStatus );

}
