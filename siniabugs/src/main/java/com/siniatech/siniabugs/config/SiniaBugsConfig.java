package com.siniatech.siniabugs.config;

import java.util.Comparator;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.siniatech.siniabugs.dao.IIssueDao;
import com.siniatech.siniabugs.dao.IssueDao;
import com.siniatech.siniabugs.model.Issue;

@Configuration
public class SiniaBugsConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "WEB-INF/views/" );
        resolver.setSuffix( ".jsp" );
        return resolver;
    }

    @Bean
    Comparator<String> comparator() {
        return new CaseInsensitiveComparator();
    }

    public class CaseInsensitiveComparator implements Comparator<String> {
        public int compare( String s1, String s2 ) {
            assert s1 != null && s2 != null;
            return String.CASE_INSENSITIVE_ORDER.compare( s1, s2 );
        }
    }

    // need to start hsqldb: java -cp hsqldb-2.2.8.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb
    @Bean
    DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( "org.hsqldb.jdbcDriver" );
        dataSource.setUrl( "jdbc:hsqldb:hsql://localhost:9001/xdb" );
        dataSource.setUsername( "sa" );
        dataSource.setPassword( "" );
        return dataSource;
    }

    @Bean
    SessionFactory sessionFactory() throws Exception {
        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
        sessionFactoryBean.setAnnotatedPackages( new String[] { "com.siniatech.siniabugs.model.issue" } );
        sessionFactoryBean.setAnnotatedClasses( new Class[] { Issue.class } );
        sessionFactoryBean.setDataSource( dataSource() );
        sessionFactoryBean.setHibernateProperties( hibernateProperties() );
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put( "hibernate.dialect", "org.hibernate.dialect.HSQLDialect" );
        properties.put( "hibernate.show_sql", true );
        properties.put( "hibernate.hbm2ddl.auto", "create" );
        return properties;
    }

    @Bean
    IIssueDao issueDao() throws Exception {
        return new IssueDao( sessionFactory() );
    }

}
