package com.siniatech.siniabugs.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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

}
