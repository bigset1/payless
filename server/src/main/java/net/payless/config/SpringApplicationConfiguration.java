package net.payless.config;

import net.payless.ApplicationInitializer;
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
