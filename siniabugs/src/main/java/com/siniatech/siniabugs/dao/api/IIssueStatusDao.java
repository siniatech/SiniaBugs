package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.IIssueStatus;

public interface IIssueStatusDao {

    List<IIssueStatus> getIssueStatuses();

    IIssueStatus getIssueStatus( Long id );
}
