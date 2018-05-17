package org.osmand.didemo.config;

import org.osmand.didemo.examplebeans.FakeDataSource;
import org.osmand.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
// We can also use @PropertySources (plural) instead of comma separated collection of @PropertySource
@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class PropertyConfig {
    // Note that properties can be overridden with environment properties

    @Autowired
    Environment env;

    @Value("${db.username}")
    String user;

    @Value("${db.password}")
    String password;

    @Value("${db.url}")
    String dbUrl;

    @Value("${jms.username}")
    String jmsUser;

    @Value("${jms.password}")
    String jmsPassword;

    @Value("${jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);

        // Property Name should be same both in Properties file and the Environment
        // Note: db.url == DB_URL
        // Here if the property is not set at environment then we will get null.
        // If we want to control a property both by Properties file and Env, then don't go with
        // the approach given below. Follow what we have done for Username, it's set in both
        // Env (DB_USERNAME) and Properties file (db.username)
        fakeDataSource.setDbUrl(env.getProperty("DB_URL"));
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        //fakeJmsBroker.setJmsUrl(env.getProperty("JMS_URL"));
        fakeJmsBroker.setJmsUrl(jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
