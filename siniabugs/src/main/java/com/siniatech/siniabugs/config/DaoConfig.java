package com.siniatech.siniabugs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siniatech.siniabugs.dao.BugsUserDao;
import com.siniatech.siniabugs.dao.IBugsUserDao;
import com.siniatech.siniabugs.dao.IIssueDao;
import com.siniatech.siniabugs.dao.IIssueTypeDao;
import com.siniatech.siniabugs.dao.IssueDao;
import com.siniatech.siniabugs.dao.IssueTypeDao;

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
    IBugsUserDao bugsUserDao() {
        return new BugsUserDao();
    }

}
