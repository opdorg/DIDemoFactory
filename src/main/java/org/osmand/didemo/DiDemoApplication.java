package org.osmand.didemo;

import org.osmand.didemo.controllers.ConstructorInjectedController;
import org.osmand.didemo.controllers.MyController;
import org.osmand.didemo.controllers.PropertyInjectedController;
import org.osmand.didemo.controllers.SetterInjectedController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// by default @SpringBootApplication scans all the packages under its container package
// if there are classes in packages outside the main package then those need to be added in base packages.
//@ComponentScan(basePackages = {"org.osmand.didemo"})
public class DiDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DiDemoApplication.class);

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");
        //controller.hello();

        logger.info(ctx.getBean(PropertyInjectedController.class).sayHello());
        logger.info(ctx.getBean(SetterInjectedController.class).sayHello());
        logger.info(ctx.getBean(ConstructorInjectedController.class).sayHello());

        logger.info(controller.hello());

    }
}
