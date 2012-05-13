package com.siniatech.siniabugs.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.siniatech.siniabugs.model.current.BugsUser;
import com.siniatech.siniabugs.model.historical.BugsUserHistorical;
import com.siniatech.siniabugs.model.util.ViewModelHelper;
import com.siniatech.siniabugs.viewModel.impl.BugsUserViewModel;

@Configuration
public class SiniaBugsConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "/WEB-INF/views/" );
        resolver.setSuffix( ".jsp" );
        return resolver;
    }

    @Bean
    ViewModelHelper viewModelHelper() {
        Map<Class<?>, Class<?>> modelToViewModelClassMap = new HashMap<Class<?>, Class<?>>();
        modelToViewModelClassMap.put( BugsUser.class, BugsUserViewModel.class );
        modelToViewModelClassMap.put( BugsUserHistorical.class, BugsUserViewModel.class );
        return new ViewModelHelper( modelToViewModelClassMap );
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

}
