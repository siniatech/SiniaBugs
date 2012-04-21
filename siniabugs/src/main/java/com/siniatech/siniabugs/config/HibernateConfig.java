package com.siniatech.siniabugs.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.siniatech.siniabugs.model.BugsUser;
import com.siniatech.siniabugs.model.Issue;
import com.siniatech.siniabugs.model.IssueStatus;
import com.siniatech.siniabugs.model.IssueType;
import com.siniatech.siniabugs.model.Priority;
import com.siniatech.siniabugs.model.Release;
import com.siniatech.siniabugs.model.Severity;

@Configuration
public class HibernateConfig {

    @Autowired
    private Properties siniaBugsProperties;

    // FORneed to start hsqldb: java -cp hsqldb-2.2.8.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb
    @Bean
    DataSource dataSource() throws Exception {
        Properties properties = siniaBugsProperties;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( (String) properties.get( "db.driver" ) );
        dataSource.setUrl( (String) properties.get( "db.url" ) );
        dataSource.setUsername( (String) properties.get( "db.username" ) );
        dataSource.setPassword( (String) properties.get( "db.password" ) );
        return dataSource;
    }

    @Bean
    SessionFactory sessionFactory() throws Exception {
        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
        sessionFactoryBean.setAnnotatedPackages( new String[] { "com.siniatech.siniabugs.model" } );
        sessionFactoryBean.setAnnotatedClasses( new Class[] { Issue.class, IssueType.class, BugsUser.class, IssueStatus.class, Release.class, Severity.class, Priority.class } );
        sessionFactoryBean.setDataSource( dataSource() );
        sessionFactoryBean.setHibernateProperties( hibernateProperties() );
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    private Properties hibernateProperties() throws Exception {
        return siniaBugsProperties;
    }

    @Bean
    HibernateTemplate hibernateTemplate() throws Exception {
        return new HibernateTemplate( sessionFactory() );
    }

}
