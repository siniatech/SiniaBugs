package com.siniatech.siniabugs.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.siniatech.siniabugs.model.BugsUser;
import com.siniatech.siniabugs.model.Issue;
import com.siniatech.siniabugs.model.IssueType;

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

    @Bean
    Properties siniaBugsProperties() throws Exception {
        Properties prop = new Properties();
        loadProperties( new File( System.getProperty( "user.home" ) + File.separator + "siniabugs.properties" ), prop );
        loadProperties( getClass().getResourceAsStream( "/siniabugs-system.properties" ), prop );
        return prop;
    }

    private void loadProperties( File propertiesFile, Properties prop ) throws Exception {
        if ( propertiesFile.exists() ) {
            InputStream in = new FileInputStream( propertiesFile );
            loadProperties( in, prop );
        }
    }

    private void loadProperties( InputStream in, Properties prop ) throws Exception {
        prop.load( in );
        in.close();
    }

    // FORneed to start hsqldb: java -cp hsqldb-2.2.8.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb
    @Bean
    DataSource dataSource() throws Exception {
        Properties properties = siniaBugsProperties();
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
        sessionFactoryBean.setAnnotatedClasses( new Class[] { Issue.class, IssueType.class, BugsUser.class } );
        sessionFactoryBean.setDataSource( dataSource() );
        sessionFactoryBean.setHibernateProperties( hibernateProperties() );
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    private Properties hibernateProperties() throws Exception {
        return siniaBugsProperties();
    }

    @Bean
    HibernateTemplate hibernateTemplate() throws Exception {
        return new HibernateTemplate( sessionFactory() );
    }

}
