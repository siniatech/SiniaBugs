package com.siniatech.siniabugs.dao;

import java.util.List;

import com.siniatech.siniabugs.model.api.IIssueType;

public interface IIssueTypeDao {

    List<IIssueType> getIssueTypes();

    IIssueType getIssueType( Long id );
}
