package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.IssueType;

public interface IIssueTypeDao {

    List<IssueType> getIssueTypes();

    IssueType getIssueType( Long id );
}
