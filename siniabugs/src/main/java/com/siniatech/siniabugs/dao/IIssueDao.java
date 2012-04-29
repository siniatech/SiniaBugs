package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.current.Issue;

public interface IIssueDao {

    void saveIssue( Issue issue );

    List<Issue> listIssues();
}
