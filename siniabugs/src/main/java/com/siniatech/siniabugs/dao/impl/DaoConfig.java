package com.siniatech.siniabugs.dao.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.dao.api.IIssueDao;
import com.siniatech.siniabugs.dao.api.IIssueStatusDao;
import com.siniatech.siniabugs.dao.api.IIssueTypeDao;
import com.siniatech.siniabugs.dao.api.IPriorityDao;

@Configuration
public class DaoConfig {

    @Bean
    IIssueDao issueDao() {
        return new IssueDao();
    }

    @Bean
    IIssueTypeDao issueTypeDao() {
        return new IssueTypeDao();
    }

    @Bean
    IIssueStatusDao issueStatusDao() {
        return new IssueStatusDao();
    }

    @Bean
    IBugsUserDao bugsUserDao() {
        return new BugsUserDao();
    }

    @Bean
    IPriorityDao priorityDao() {
        return new PriorityDao();
    }

}
