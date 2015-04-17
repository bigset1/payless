package com.letionik.payless.server.config;

import com.letionik.payless.server.ApplicationInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Configuration
@ComponentScan(basePackageClasses = ApplicationInitializer.class)
public class SpringApplicationConfiguration {

}
