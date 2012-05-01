package com.siniatech.siniabugs.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.dao.api.IIssueDao;
import com.siniatech.siniabugs.dao.api.IIssueStatusDao;
import com.siniatech.siniabugs.dao.api.IIssueTypeDao;
import com.siniatech.siniabugs.dao.api.IPriorityDao;
import com.siniatech.siniabugs.dao.api.IProjectDao;
import com.siniatech.siniabugs.dao.api.IReleaseDao;
import com.siniatech.siniabugs.dao.api.ISeverityDao;
import com.siniatech.siniabugs.dao.impl.BugsUserDao;
import com.siniatech.siniabugs.dao.impl.IssueDao;
import com.siniatech.siniabugs.dao.impl.IssueStatusDao;
import com.siniatech.siniabugs.dao.impl.IssueTypeDao;
import com.siniatech.siniabugs.dao.impl.PriorityDao;
import com.siniatech.siniabugs.dao.impl.ProjectDao;
import com.siniatech.siniabugs.dao.impl.ReleaseDao;
import com.siniatech.siniabugs.dao.impl.SeverityDao;

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

    @Bean
    IReleaseDao releaseDao() {
        return new ReleaseDao();
    }

    @Bean
    ISeverityDao severityDao() {
        return new SeverityDao();
    }

    @Bean
    IProjectDao projectDao() {
        return new ProjectDao();
    }
}
