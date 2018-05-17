package org.osmand.didemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(LifeCycleDemoBean.class);

    public LifeCycleDemoBean(){
        logger.info(">>>>>>>>>>>>>>> Constructor...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info(">>>>>>>>>>>>>>> setBeanFactory...");
    }

    @Override
    public void setBeanName(String s) {
        logger.info(">>>>>>>>>>>>>>> setBeanName...");
    }

    @Override
    public void destroy() throws Exception {
        logger.info(">>>>>>>>>>>>>>> destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info(">>>>>>>>>>>>>>> setApplicationContext...");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info(">>>>>>>>>>>>>>> postConstruct...");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info(">>>>>>>>>>>>>>> preDestroy...");
    }

    public void beforeInit(){
        logger.info(">>>>>>>>>>>>>>> beforeInit...");
    }

    public void afterInit(){
        logger.info(">>>>>>>>>>>>>>> afterInit...");
    }
}
