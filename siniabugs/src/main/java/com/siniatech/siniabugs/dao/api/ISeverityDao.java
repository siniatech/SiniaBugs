package com.siniatech.siniabugs.dao.api;

import java.util.List;

import com.siniatech.siniabugs.model.api.ISeverity;

public interface ISeverityDao {

    List<ISeverity> getSeverities();

    ISeverity getSeverity( Long id );

}
