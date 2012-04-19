package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.IssueStatus;

public interface IIssueStatusDao {

    List<IssueStatus> getIssueStatuses();

    IssueStatus getIssueStatus( Long id );
}
